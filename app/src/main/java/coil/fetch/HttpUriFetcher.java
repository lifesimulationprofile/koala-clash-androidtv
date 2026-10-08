package coil.fetch;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import androidx.compose.ui.unit.Density;
import coil.decode.FileImageSource;
import coil.decode.SourceImageSource;
import coil.disk.DiskLruCache;
import coil.disk.RealDiskCache;
import coil.memory.MemoryCacheService;
import coil.network.CacheResponse;
import coil.network.CacheStrategy;
import coil.network.HttpException;
import coil.request.Options;
import coil.util.ContinuationCallback;
import coil.util.Utils;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.CacheControl;
import okhttp3.Call$Factory;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealCall.AsyncCall;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.internal.ZipFilesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HttpUriFetcher implements Fetcher {
    public static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl(true, true, -1, -1, false, false, false, -1, -1, false, false, false, null);
    public static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl(true, false, -1, -1, false, false, false, -1, -1, true, false, false, null);
    public final SynchronizedLazyImpl callFactory;
    public final SynchronizedLazyImpl diskCache;
    public final Options options;
    public final String url;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Factory implements Fetcher.Factory {
        public final SynchronizedLazyImpl callFactory;
        public final SynchronizedLazyImpl diskCache;

        public Factory(SynchronizedLazyImpl synchronizedLazyImpl, SynchronizedLazyImpl synchronizedLazyImpl2) {
            this.callFactory = synchronizedLazyImpl;
            this.diskCache = synchronizedLazyImpl2;
        }

        @Override // coil.fetch.Fetcher.Factory
        public final Fetcher create(Object obj, Options options) {
            Uri uri = (Uri) obj;
            if (Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), "https")) {
                return new HttpUriFetcher(uri.toString(), options, this.callFactory, this.diskCache);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$executeNetworkRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.executeNetworkRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$fetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00161 extends ContinuationImpl {
        public HttpUriFetcher L$0;
        public RealDiskCache.RealSnapshot L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00161(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.fetch(this);
        }
    }

    public HttpUriFetcher(String str, Options options, SynchronizedLazyImpl synchronizedLazyImpl, SynchronizedLazyImpl synchronizedLazyImpl2) {
        this.url = str;
        this.options = options;
        this.callFactory = synchronizedLazyImpl;
        this.diskCache = synchronizedLazyImpl2;
    }

    public static String getMimeType$coil_base_release(String str, MediaType mediaType) {
        String mimeTypeFromUrl;
        String str2 = mediaType != null ? mediaType.mediaType : null;
        if ((str2 == null || StringsKt__StringsJVMKt.startsWith(str2, "text/plain", false)) && (mimeTypeFromUrl = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), str)) != null) {
            return mimeTypeFromUrl;
        }
        if (str2 != null) {
            return StringsKt.substringBefore$default(str2, ';');
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x012f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object executeNetworkRequest(Request request, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        RealCall.AsyncCall asyncCall;
        Response responseExecute;
        int i;
        ResponseBody responseBody;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object result = anonymousClass1.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(result);
            Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                OkHttpClient okHttpClient = (OkHttpClient) ((Call$Factory) this.callFactory.getValue());
                okHttpClient.getClass();
                RealCall realCall = new RealCall(okHttpClient, request);
                anonymousClass1.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(anonymousClass1));
                cancellableContinuationImpl.initCancellability();
                ContinuationCallback continuationCallback = new ContinuationCallback(0, realCall, cancellableContinuationImpl);
                if (!realCall.executed.compareAndSet(false, true)) {
                    throw new IllegalStateException("Already Executed");
                }
                Platform platform = Platform.platform;
                realCall.callStackTrace = Platform.platform.getStackTraceForCloseable();
                Dispatcher dispatcher = okHttpClient.dispatcher;
                RealCall.AsyncCall asyncCall2 = realCall.new AsyncCall(continuationCallback);
                synchronized (dispatcher) {
                    ((ArrayDeque) dispatcher.readyAsyncCalls).add(asyncCall2);
                    String str = ((HttpUrl) request.url).host;
                    Iterator it = ((ArrayDeque) dispatcher.runningAsyncCalls).iterator();
                    do {
                        if (!it.hasNext()) {
                            Iterator it2 = ((ArrayDeque) dispatcher.readyAsyncCalls).iterator();
                            do {
                                if (!it2.hasNext()) {
                                    asyncCall = null;
                                    break;
                                }
                                asyncCall = (RealCall.AsyncCall) it2.next();
                            } while (!Intrinsics.areEqual(((HttpUrl) RealCall.this.originalRequest.url).host, str));
                        } else {
                            asyncCall = (RealCall.AsyncCall) it.next();
                        }
                    } while (!Intrinsics.areEqual(((HttpUrl) RealCall.this.originalRequest.url).host, str));
                    if (asyncCall != null) {
                        asyncCall2.callsPerHost = asyncCall.callsPerHost;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                dispatcher.promoteAndExecute();
                cancellableContinuationImpl.invokeOnCancellation(continuationCallback);
                result = cancellableContinuationImpl.getResult();
                if (result == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (Density.CC.getReadEnabled(this.options.networkCachePolicy)) {
                    throw new NetworkOnMainThreadException();
                }
                OkHttpClient okHttpClient2 = (OkHttpClient) ((Call$Factory) this.callFactory.getValue());
                okHttpClient2.getClass();
                responseExecute = new RealCall(okHttpClient2, request).execute();
            }
            i = responseExecute.code;
            if ((200 > i && i < 300) || i == 304) {
                return responseExecute;
            }
            responseBody = responseExecute.body;
            if (responseBody != null) {
                Utils.closeQuietly(responseBody);
            }
            throw new HttpException("HTTP " + responseExecute.code + ": " + responseExecute.message);
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(result);
        responseExecute = (Response) result;
        i = responseExecute.code;
        if (200 > i) {
        }
        responseBody = responseExecute.body;
        if (responseBody != null) {
            Utils.closeQuietly(responseBody);
        }
        throw new HttpException("HTTP " + responseExecute.code + ": " + responseExecute.message);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0225  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e3 A[Catch: Exception -> 0x0209, TryCatch #3 {Exception -> 0x0209, blocks: (B:89:0x01dd, B:91:0x01e3, B:95:0x0205, B:99:0x020c, B:100:0x0211), top: B:117:0x01dd }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0203  */
    /* JADX WARN: Code duplicated, block: B:94:0x0204  */
    /* JADX WARN: Code duplicated, block: B:99:0x020c A[Catch: Exception -> 0x0209, TryCatch #3 {Exception -> 0x0209, blocks: (B:89:0x01dd, B:91:0x01e3, B:95:0x0205, B:99:0x020c, B:100:0x0211), top: B:117:0x01dd }] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, kotlin.Lazy] */
    @Override // coil.fetch.Fetcher
    public final Object fetch(Continuation continuation) throws Exception {
        C00161 c00161;
        RealDiskCache.RealSnapshot realSnapshot;
        RealDiskCache.RealSnapshot realSnapshot2;
        CacheStrategy cacheStrategyCompute;
        CacheStrategy cacheStrategy;
        HttpUriFetcher httpUriFetcher;
        RealDiskCache realDiskCache;
        RealDiskCache.RealSnapshot realSnapshot3;
        Response response;
        HttpUriFetcher httpUriFetcher2;
        Response response2;
        ResponseBody responseBody;
        if (continuation instanceof C00161) {
            c00161 = (C00161) continuation;
            int i = c00161.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00161.label = i - Integer.MIN_VALUE;
            } else {
                c00161 = new C00161((ContinuationImpl) continuation);
            }
        } else {
            c00161 = new C00161((ContinuationImpl) continuation);
        }
        Object objExecuteNetworkRequest = c00161.result;
        int i2 = c00161.label;
        int i3 = 4;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecuteNetworkRequest);
            Options options = this.options;
            boolean readEnabled = Density.CC.getReadEnabled(options.diskCachePolicy);
            String str = this.url;
            if (!readEnabled || (realDiskCache = (RealDiskCache) this.diskCache.getValue()) == null) {
                realSnapshot = null;
            } else {
                String str2 = options.diskCacheKey;
                if (str2 == null) {
                    str2 = str;
                }
                DiskLruCache diskLruCache = realDiskCache.cache;
                byte[] bytes = str2.getBytes(Charsets.UTF_8);
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(bytes, 0, bytes.length);
                byte[] bArrDigest = messageDigest.digest();
                char[] cArr = new char[bArrDigest.length * 2];
                int i4 = 0;
                for (byte b : bArrDigest) {
                    int i5 = i4 + 1;
                    char[] cArr2 = ZipFilesKt.HEX_DIGIT_CHARS;
                    cArr[i4] = cArr2[(b >> 4) & 15];
                    i4 += 2;
                    cArr[i5] = cArr2[b & 15];
                }
                DiskLruCache.Snapshot snapshot = diskLruCache.get(new String(cArr));
                if (snapshot != null) {
                    realSnapshot = new RealDiskCache.RealSnapshot(snapshot);
                } else {
                    realSnapshot = null;
                }
            }
            try {
                if (realSnapshot != null) {
                    FileSystem fileSystem = getFileSystem();
                    DiskLruCache.Snapshot snapshot2 = realSnapshot.snapshot;
                    if (snapshot2.closed) {
                        throw new IllegalStateException("snapshot is closed");
                    }
                    Long l = (Long) fileSystem.metadata((Path) snapshot2.entry.cleanFiles.get(0)).size;
                    if (l != null && l.longValue() == 0) {
                        return new SourceResult(toImageSource(realSnapshot), getMimeType$coil_base_release(str, null), 3);
                    }
                    cacheStrategyCompute = new CacheStrategy.Factory(newRequest(), toCacheResponse(realSnapshot)).compute();
                    CacheResponse cacheResponse = cacheStrategyCompute.cacheResponse;
                    if (cacheStrategyCompute.networkRequest == null && cacheResponse != null) {
                        return new SourceResult(toImageSource(realSnapshot), getMimeType$coil_base_release(str, (MediaType) cacheResponse.contentType$delegate.getValue()), 3);
                    }
                } else {
                    cacheStrategyCompute = new CacheStrategy.Factory(newRequest(), null).compute();
                }
                Request request = cacheStrategyCompute.networkRequest;
                c00161.L$0 = this;
                c00161.L$1 = realSnapshot;
                c00161.L$2 = cacheStrategyCompute;
                c00161.label = 1;
                Object objExecuteNetworkRequest2 = executeNetworkRequest(request, c00161);
                if (objExecuteNetworkRequest2 != coroutineSingletons) {
                    RealDiskCache.RealSnapshot realSnapshot4 = realSnapshot;
                    cacheStrategy = cacheStrategyCompute;
                    objExecuteNetworkRequest = objExecuteNetworkRequest2;
                    realSnapshot2 = realSnapshot4;
                    httpUriFetcher = this;
                }
                return coroutineSingletons;
            } catch (Exception e) {
                e = e;
                realSnapshot2 = realSnapshot;
                if (realSnapshot2 != null) {
                    Utils.closeQuietly(realSnapshot2);
                }
                throw e;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            response = (Response) c00161.L$2;
            realSnapshot3 = c00161.L$1;
            httpUriFetcher2 = c00161.L$0;
            try {
                ResultKt.throwOnFailure(objExecuteNetworkRequest);
                response2 = (Response) objExecuteNetworkRequest;
                try {
                    Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
                    responseBody = response2.body;
                    if (responseBody != null) {
                        throw new IllegalStateException("response body == null");
                    }
                    httpUriFetcher2.getClass();
                    BufferedSource bufferedSourceSource = responseBody.source();
                    Context context = httpUriFetcher2.options.context;
                    SourceImageSource sourceImageSource = new SourceImageSource(bufferedSourceSource, null);
                    String mimeType$coil_base_release = getMimeType$coil_base_release(httpUriFetcher2.url, responseBody.contentType());
                    if (response2.networkResponse != null) {
                        i3 = 3;
                    }
                    return new SourceResult(sourceImageSource, mimeType$coil_base_release, i3);
                } catch (Exception e2) {
                    e = e2;
                    response = response2;
                    try {
                        Utils.closeQuietly(response);
                        throw e;
                    } catch (Exception e3) {
                        e = e3;
                        realSnapshot2 = realSnapshot3;
                        if (realSnapshot2 != null) {
                            Utils.closeQuietly(realSnapshot2);
                        }
                        throw e;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                Utils.closeQuietly(response);
                throw e;
            }
        }
        cacheStrategy = (CacheStrategy) c00161.L$2;
        realSnapshot2 = c00161.L$1;
        httpUriFetcher = c00161.L$0;
        try {
            ResultKt.throwOnFailure(objExecuteNetworkRequest);
        } catch (Exception e5) {
            e = e5;
            if (realSnapshot2 != null) {
                Utils.closeQuietly(realSnapshot2);
            }
            throw e;
        }
        Response response3 = (Response) objExecuteNetworkRequest;
        Bitmap.Config[] configArr2 = Utils.VALID_TRANSFORMATION_CONFIGS;
        ResponseBody responseBody2 = response3.body;
        if (responseBody2 == null) {
            throw new IllegalStateException("response body == null");
        }
        try {
            RealDiskCache.RealSnapshot realSnapshotWriteToDiskCache = httpUriFetcher.writeToDiskCache(realSnapshot2, cacheStrategy.networkRequest, response3, cacheStrategy.cacheResponse);
            String str3 = httpUriFetcher.url;
            try {
                if (realSnapshotWriteToDiskCache != null) {
                    FileImageSource imageSource = httpUriFetcher.toImageSource(realSnapshotWriteToDiskCache);
                    CacheResponse cacheResponse2 = httpUriFetcher.toCacheResponse(realSnapshotWriteToDiskCache);
                    return new SourceResult(imageSource, getMimeType$coil_base_release(str3, cacheResponse2 != null ? (MediaType) cacheResponse2.contentType$delegate.getValue() : null), 4);
                }
                if (responseBody2.source().request(1L)) {
                    BufferedSource bufferedSourceSource2 = responseBody2.source();
                    Context context2 = httpUriFetcher.options.context;
                    SourceImageSource sourceImageSource2 = new SourceImageSource(bufferedSourceSource2, null);
                    String mimeType$coil_base_release2 = getMimeType$coil_base_release(str3, responseBody2.contentType());
                    if (response3.networkResponse == null) {
                        i3 = 3;
                    }
                    return new SourceResult(sourceImageSource2, mimeType$coil_base_release2, i3);
                }
                Utils.closeQuietly(response3);
                Request requestNewRequest = httpUriFetcher.newRequest();
                c00161.L$0 = httpUriFetcher;
                c00161.L$1 = realSnapshotWriteToDiskCache;
                c00161.L$2 = response3;
                c00161.label = 2;
                objExecuteNetworkRequest = httpUriFetcher.executeNetworkRequest(requestNewRequest, c00161);
                if (objExecuteNetworkRequest != coroutineSingletons) {
                    realSnapshot3 = realSnapshotWriteToDiskCache;
                    httpUriFetcher2 = httpUriFetcher;
                    response = response3;
                    response2 = (Response) objExecuteNetworkRequest;
                    Bitmap.Config[] configArr3 = Utils.VALID_TRANSFORMATION_CONFIGS;
                    responseBody = response2.body;
                    if (responseBody != null) {
                        throw new IllegalStateException("response body == null");
                    }
                    httpUriFetcher2.getClass();
                    BufferedSource bufferedSourceSource3 = responseBody.source();
                    Context context3 = httpUriFetcher2.options.context;
                    SourceImageSource sourceImageSource3 = new SourceImageSource(bufferedSourceSource3, null);
                    String mimeType$coil_base_release3 = getMimeType$coil_base_release(httpUriFetcher2.url, responseBody.contentType());
                    if (response2.networkResponse != null) {
                        i3 = 3;
                    }
                    return new SourceResult(sourceImageSource3, mimeType$coil_base_release3, i3);
                }
                return coroutineSingletons;
            } catch (Exception e6) {
                e = e6;
                realSnapshot3 = realSnapshotWriteToDiskCache;
                response = response3;
                Utils.closeQuietly(response);
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            realSnapshot3 = realSnapshot2;
        }
    }

    public final FileSystem getFileSystem() {
        return ((RealDiskCache) this.diskCache.getValue()).fileSystem;
    }

    public final Request newRequest() {
        Dispatcher dispatcher = new Dispatcher(22);
        String strConcat = this.url;
        if (StringsKt__StringsJVMKt.startsWith(strConcat, "ws:", true)) {
            strConcat = "http:".concat(strConcat.substring(3));
        } else if (StringsKt__StringsJVMKt.startsWith(strConcat, "wss:", true)) {
            strConcat = "https:".concat(strConcat.substring(4));
        }
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.parse$okhttp(null, strConcat);
        dispatcher.executorServiceOrNull = builder.build();
        Options options = this.options;
        dispatcher.runningAsyncCalls = options.headers.newBuilder();
        for (Map.Entry entry : options.tags.tags.entrySet()) {
            Class cls = (Class) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                ((LinkedHashMap) dispatcher.runningSyncCalls).remove(cls);
            } else {
                if (((LinkedHashMap) dispatcher.runningSyncCalls).isEmpty()) {
                    dispatcher.runningSyncCalls = new LinkedHashMap();
                }
                ((LinkedHashMap) dispatcher.runningSyncCalls).put(cls, cls.cast(value));
            }
        }
        int i = options.diskCachePolicy;
        boolean readEnabled = Density.CC.getReadEnabled(i);
        boolean readEnabled2 = Density.CC.getReadEnabled(options.networkCachePolicy);
        if (!readEnabled2 && readEnabled) {
            dispatcher.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!readEnabled2 || readEnabled) {
            if (!readEnabled2 && !readEnabled) {
                dispatcher.cacheControl(CACHE_CONTROL_NO_NETWORK_NO_CACHE);
            }
        } else if (Density.CC.getWriteEnabled(i)) {
            dispatcher.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            dispatcher.cacheControl(CACHE_CONTROL_FORCE_NETWORK_NO_CACHE);
        }
        return dispatcher.build();
    }

    public final CacheResponse toCacheResponse(RealDiskCache.RealSnapshot realSnapshot) throws Throwable {
        Throwable th;
        CacheResponse cacheResponse;
        try {
            FileSystem fileSystem = getFileSystem();
            DiskLruCache.Snapshot snapshot = realSnapshot.snapshot;
            if (snapshot.closed) {
                throw new IllegalStateException("snapshot is closed");
            }
            RealBufferedSource realBufferedSource = new RealBufferedSource(fileSystem.source((Path) snapshot.entry.cleanFiles.get(0)));
            try {
                cacheResponse = new CacheResponse(realBufferedSource);
                try {
                    realBufferedSource.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    realBufferedSource.close();
                } catch (Throwable th4) {
                    ScanQRCode.addSuppressed(th3, th4);
                }
                th = th3;
                cacheResponse = null;
            }
            if (th == null) {
                return cacheResponse;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    public final FileImageSource toImageSource(RealDiskCache.RealSnapshot realSnapshot) {
        DiskLruCache.Snapshot snapshot = realSnapshot.snapshot;
        if (snapshot.closed) {
            throw new IllegalStateException("snapshot is closed");
        }
        Path path = (Path) snapshot.entry.cleanFiles.get(1);
        FileSystem fileSystem = getFileSystem();
        String str = this.options.diskCacheKey;
        if (str == null) {
            str = this.url;
        }
        return new FileImageSource(path, fileSystem, str, realSnapshot);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:95:0x0189 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x018b  */
    public final RealDiskCache.RealSnapshot writeToDiskCache(RealDiskCache.RealSnapshot realSnapshot, Request request, Response response, CacheResponse cacheResponse) throws NoSuchAlgorithmException {
        MemoryCacheService memoryCacheService;
        DiskLruCache.Editor editorEdit;
        Throwable th = null;
        if (Density.CC.getWriteEnabled(this.options.diskCachePolicy) && !request.cacheControl().noStore) {
            CacheControl cacheControl = response.lazyCacheControl;
            if (cacheControl == null) {
                CacheControl cacheControl2 = CacheControl.FORCE_NETWORK;
                cacheControl = CacheControl.Companion.parse(response.headers);
                response.lazyCacheControl = cacheControl;
            }
            if (!cacheControl.noStore && !Intrinsics.areEqual(response.headers.get("Vary"), "*")) {
                int i = 20;
                if (realSnapshot != null) {
                    DiskLruCache.Snapshot snapshot = realSnapshot.snapshot;
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    synchronized (diskLruCache) {
                        snapshot.close();
                        editorEdit = diskLruCache.edit(snapshot.entry.key);
                    }
                    if (editorEdit != null) {
                        memoryCacheService = new MemoryCacheService(i, editorEdit);
                    } else {
                        memoryCacheService = null;
                    }
                } else {
                    RealDiskCache realDiskCache = (RealDiskCache) this.diskCache.getValue();
                    if (realDiskCache == null) {
                        memoryCacheService = null;
                    } else {
                        String str = this.options.diskCacheKey;
                        if (str == null) {
                            str = this.url;
                        }
                        DiskLruCache diskLruCache2 = realDiskCache.cache;
                        byte[] bytes = str.getBytes(Charsets.UTF_8);
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                        messageDigest.update(bytes, 0, bytes.length);
                        byte[] bArrDigest = messageDigest.digest();
                        char[] cArr = new char[bArrDigest.length * 2];
                        int i2 = 0;
                        for (byte b : bArrDigest) {
                            int i3 = i2 + 1;
                            char[] cArr2 = ZipFilesKt.HEX_DIGIT_CHARS;
                            cArr[i2] = cArr2[(b >> 4) & 15];
                            i2 += 2;
                            cArr[i3] = cArr2[b & 15];
                        }
                        DiskLruCache.Editor editorEdit2 = diskLruCache2.edit(new String(cArr));
                        if (editorEdit2 != null) {
                            memoryCacheService = new MemoryCacheService(i, editorEdit2);
                        } else {
                            memoryCacheService = null;
                        }
                    }
                }
                try {
                    if (memoryCacheService != null) {
                        try {
                            if (response.code != 304 || cacheResponse == null) {
                                RealBufferedSink realBufferedSink = new RealBufferedSink(getFileSystem().sink(((DiskLruCache.Editor) memoryCacheService.imageLoader).file(0)));
                                try {
                                    new CacheResponse(response).writeTo(realBufferedSink);
                                    Unit unit = Unit.INSTANCE;
                                    try {
                                        realBufferedSink.close();
                                        th = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    try {
                                        realBufferedSink.close();
                                    } catch (Throwable th4) {
                                        ScanQRCode.addSuppressed(th, th4);
                                    }
                                }
                                if (th != null) {
                                    throw th;
                                }
                                RealBufferedSink realBufferedSink2 = new RealBufferedSink(getFileSystem().sink(((DiskLruCache.Editor) memoryCacheService.imageLoader).file(1)));
                                try {
                                    response.body.source().readAll(realBufferedSink2);
                                    try {
                                        realBufferedSink2.close();
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    try {
                                        realBufferedSink2.close();
                                    } catch (Throwable th7) {
                                        ScanQRCode.addSuppressed(th, th7);
                                    }
                                }
                                if (th != null) {
                                    throw th;
                                }
                            } else {
                                Response.Builder builderNewBuilder = response.newBuilder();
                                builderNewBuilder.headers = CacheStrategy.Companion.combineHeaders(cacheResponse.responseHeaders, response.headers).newBuilder();
                                Response responseBuild = builderNewBuilder.build();
                                RealBufferedSink realBufferedSink3 = new RealBufferedSink(getFileSystem().sink(((DiskLruCache.Editor) memoryCacheService.imageLoader).file(0)));
                                try {
                                    new CacheResponse(responseBuild).writeTo(realBufferedSink3);
                                    Unit unit2 = Unit.INSTANCE;
                                    try {
                                        realBufferedSink3.close();
                                    } catch (Throwable th8) {
                                        th = th8;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    try {
                                        realBufferedSink3.close();
                                    } catch (Throwable th10) {
                                        ScanQRCode.addSuppressed(th, th10);
                                    }
                                }
                                if (th != null) {
                                    throw th;
                                }
                            }
                            RealDiskCache.RealSnapshot realSnapshotCommitAndOpenSnapshot$1 = memoryCacheService.commitAndOpenSnapshot$1();
                            Utils.closeQuietly(response);
                            return realSnapshotCommitAndOpenSnapshot$1;
                        } catch (Exception e) {
                            Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
                            try {
                                ((DiskLruCache.Editor) memoryCacheService.imageLoader).complete(false);
                            } catch (Exception unused) {
                            }
                            throw e;
                        }
                    }
                } catch (Throwable th11) {
                    Utils.closeQuietly(response);
                    throw th11;
                }
            } else if (realSnapshot != null) {
                Utils.closeQuietly(realSnapshot);
            }
        } else if (realSnapshot != null) {
            Utils.closeQuietly(realSnapshot);
        }
        return null;
    }
}
