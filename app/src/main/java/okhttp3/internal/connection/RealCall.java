package okhttp3.internal.connection;

import coil.util.ContinuationCallback;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealCall implements Cloneable {
    public Object callStackTrace;
    public volatile boolean canceled;
    public final OkHttpClient client;
    public RealConnection connection;
    public final RealConnectionPool connectionPool;
    public volatile RealConnection connectionToCancel;
    public volatile Exchange exchange;
    public ExchangeFinder exchangeFinder;
    public final AtomicBoolean executed;
    public boolean expectMoreExchanges;
    public Exchange interceptorScopedExchange;
    public final Request originalRequest;
    public boolean requestBodyOpen;
    public boolean responseBodyOpen;
    public final RealCall$timeout$1 timeout;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AsyncCall implements Runnable {
        public volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        public final ContinuationCallback responseCallback;

        public AsyncCall(ContinuationCallback continuationCallback) {
            this.responseCallback = continuationCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OkHttpClient okHttpClient;
            String strConcat = "OkHttp ".concat(((HttpUrl) RealCall.this.originalRequest.url).redact());
            RealCall realCall = RealCall.this;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(strConcat);
            try {
                realCall.timeout.enter();
                boolean z = false;
                try {
                    try {
                        try {
                            ((CancellableContinuationImpl) this.responseCallback.continuation).resumeWith(realCall.getResponseWithInterceptorChain$okhttp());
                            okHttpClient = realCall.client;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (z) {
                                Platform platform = Platform.platform;
                                Platform platform2 = Platform.platform;
                                String str = "Callback failure for " + RealCall.access$toLoggableString(realCall);
                                platform2.getClass();
                                Platform.log(str, 4, e);
                            } else {
                                ContinuationCallback continuationCallback = this.responseCallback;
                                if (!realCall.canceled) {
                                    ((CancellableContinuationImpl) continuationCallback.continuation).resumeWith(new Result.Failure(e));
                                }
                            }
                            okHttpClient = realCall.client;
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            realCall.cancel();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                ScanQRCode.addSuppressed(iOException, th);
                                ContinuationCallback continuationCallback2 = this.responseCallback;
                                if (!realCall.canceled) {
                                    ((CancellableContinuationImpl) continuationCallback2.continuation).resumeWith(new Result.Failure(iOException));
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        realCall.client.dispatcher.finished$okhttp(this);
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
                okHttpClient.dispatcher.finished$okhttp(this);
                threadCurrentThread.setName(name);
            } catch (Throwable th4) {
                threadCurrentThread.setName(name);
                throw th4;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CallReference extends WeakReference {
        public final Object callStackTrace;

        public CallReference(RealCall realCall, Object obj) {
            super(realCall);
            this.callStackTrace = obj;
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [okhttp3.internal.connection.RealCall$timeout$1, okio.Timeout] */
    public RealCall(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.connectionPool = (RealConnectionPool) okHttpClient.connectionPool.delegate;
        okHttpClient.eventListenerFactory.getClass();
        ?? r3 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            public final void timedOut() {
                this.this$0.cancel();
            }
        };
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        r3.timeout(0);
        this.timeout = r3;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    public static final String access$toLoggableString(RealCall realCall) {
        StringBuilder sb = new StringBuilder();
        sb.append(realCall.canceled ? "canceled " : "");
        sb.append("call");
        sb.append(" to ");
        sb.append(((HttpUrl) realCall.originalRequest.url).redact());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        if (this.connection != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.connection = realConnection;
        realConnection.calls.add(new CallReference(this, this.callStackTrace));
    }

    public final IOException callDone(IOException iOException) {
        Socket socketReleaseConnectionNoEvents$okhttp;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            synchronized (realConnection) {
                socketReleaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (socketReleaseConnectionNoEvents$okhttp != null) {
                    Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                }
            } else if (socketReleaseConnectionNoEvents$okhttp != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (!exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void cancel() {
        Socket socket;
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            ((ExchangeCodec) exchange.codec).cancel();
        }
        RealConnection realConnection = this.connectionToCancel;
        if (realConnection == null || (socket = realConnection.rawSocket) == null) {
            return;
        }
        Util.closeQuietly(socket);
    }

    public final Object clone() {
        return new RealCall(this.client, this.originalRequest);
    }

    public final Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        enter();
        Platform platform = Platform.platform;
        this.callStackTrace = Platform.platform.getStackTraceForCloseable();
        try {
            Dispatcher dispatcher = this.client.dispatcher;
            synchronized (dispatcher) {
                ((ArrayDeque) dispatcher.runningSyncCalls).add(this);
            }
            Response responseWithInterceptorChain$okhttp = getResponseWithInterceptorChain$okhttp();
            Dispatcher dispatcher2 = this.client.dispatcher;
            dispatcher2.finished((ArrayDeque) dispatcher2.runningSyncCalls, this);
            return responseWithInterceptorChain$okhttp;
        } catch (Throwable th) {
            Dispatcher dispatcher3 = this.client.dispatcher;
            dispatcher3.finished((ArrayDeque) dispatcher3.runningSyncCalls, this);
            throw th;
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Exchange exchange;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z && (exchange = this.exchange) != null) {
            ((ExchangeCodec) exchange.codec).cancel();
            ((RealCall) exchange.call).messageDone$okhttp(exchange, true, true, null);
        }
        this.interceptorScopedExchange = null;
    }

    public final Response getResponseWithInterceptorChain$okhttp() {
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(this.client.interceptors, arrayList);
        arrayList.add(new BridgeInterceptor(1, this.client));
        arrayList.add(new BridgeInterceptor(0, this.client.cookieJar));
        arrayList.add(new CacheInterceptor());
        arrayList.add(ConnectInterceptor.INSTANCE);
        CollectionsKt__MutableCollectionsKt.addAll(this.client.networkInterceptors, arrayList);
        arrayList.add(new CallServerInterceptor());
        Request request = this.originalRequest;
        OkHttpClient okHttpClient = this.client;
        try {
            try {
                Response responseProceed = new RealInterceptorChain(this, arrayList, 0, null, request, okHttpClient.connectTimeoutMillis, okHttpClient.readTimeoutMillis, okHttpClient.writeTimeoutMillis).proceed(request);
                if (this.canceled) {
                    Util.closeQuietly(responseProceed);
                    throw new IOException("Canceled");
                }
                noMoreExchanges$okhttp(null);
                return responseProceed;
            } catch (IOException e) {
                throw noMoreExchanges$okhttp(e);
            }
        } catch (Throwable th) {
            if (0 == 0) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x001c A[Catch: all -> 0x0012, TryCatch #0 {all -> 0x0012, blocks: (B:8:0x000d, B:17:0x001c, B:19:0x0020, B:20:0x0022, B:22:0x0027, B:27:0x0030, B:29:0x0034, B:34:0x003d, B:14:0x0016), top: B:46:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0020 A[Catch: all -> 0x0012, TryCatch #0 {all -> 0x0012, blocks: (B:8:0x000d, B:17:0x001c, B:19:0x0020, B:20:0x0022, B:22:0x0027, B:27:0x0030, B:29:0x0034, B:34:0x003d, B:14:0x0016), top: B:46:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:25:0x002d  */
    public final IOException messageDone$okhttp(Exchange exchange, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (exchange.equals(this.exchange)) {
            synchronized (this) {
                z3 = false;
                if (z) {
                    try {
                        if (this.requestBodyOpen) {
                            if (z) {
                                this.requestBodyOpen = false;
                            }
                            if (z2) {
                                this.responseBodyOpen = false;
                            }
                            z5 = this.requestBodyOpen;
                            if (z5) {
                                z6 = false;
                            } else {
                                z6 = false;
                            }
                            if (!z5) {
                                z3 = true;
                            }
                            z4 = z3;
                            z3 = z6;
                        } else if (z2 || !this.responseBodyOpen) {
                            z4 = false;
                        } else {
                            if (z) {
                                this.requestBodyOpen = false;
                            }
                            if (z2) {
                                this.responseBodyOpen = false;
                            }
                            z5 = this.requestBodyOpen;
                            if (z5 || this.responseBodyOpen) {
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            if (!z5 && !this.responseBodyOpen && !this.expectMoreExchanges) {
                                z3 = true;
                            }
                            z4 = z3;
                            z3 = z6;
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z2) {
                    }
                    z4 = false;
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            if (z3) {
                this.exchange = null;
                RealConnection realConnection = this.connection;
                if (realConnection != null) {
                    realConnection.incrementSuccessCount$okhttp();
                }
            }
            if (z4) {
                return callDone(iOException);
            }
        }
        return iOException;
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z;
        synchronized (this) {
            try {
                z = false;
                if (this.expectMoreExchanges) {
                    this.expectMoreExchanges = false;
                    if (!this.requestBodyOpen && !this.responseBodyOpen) {
                        z = true;
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z ? callDone(iOException) : iOException;
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = realConnection.calls;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = -1;
                break;
            }
            Object obj = arrayList.get(i2);
            i2++;
            if (Intrinsics.areEqual(((Reference) obj).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i);
        this.connection = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        realConnection.idleAtNs = System.nanoTime();
        RealConnectionPool realConnectionPool = this.connectionPool;
        ConcurrentLinkedQueue concurrentLinkedQueue = realConnectionPool.connections;
        TaskQueue taskQueue = realConnectionPool.cleanupQueue;
        byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
        if (!realConnection.noNewExchanges) {
            taskQueue.schedule(realConnectionPool.cleanupTask, 0L);
            return null;
        }
        realConnection.noNewExchanges = true;
        concurrentLinkedQueue.remove(realConnection);
        if (concurrentLinkedQueue.isEmpty()) {
            taskQueue.cancelAll();
        }
        return realConnection.socket;
    }
}
