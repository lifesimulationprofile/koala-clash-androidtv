package okhttp3.internal.http2;

import androidx.room.RoomOpenHelper;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.StatusLine$Companion;
import okio.ByteString;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    public static final List HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    public volatile boolean canceled;
    public final RealInterceptorChain chain;
    public final RealConnection connection;
    public final Http2Connection http2Connection;
    public final Protocol protocol;
    public volatile Http2Stream stream;

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection) {
        this.connection = realConnection;
        this.chain = realInterceptorChain;
        this.http2Connection = http2Connection;
        List list = okHttpClient.protocols;
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = list.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(9);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void finishRequest() throws SocketTimeoutException {
        Http2Stream http2Stream = this.stream;
        synchronized (http2Stream) {
            try {
                if (!http2Stream.hasResponseHeaders && !http2Stream.isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        http2Stream.sink.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Source openResponseBodySource(Response response) {
        return this.stream.source;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        Headers headers;
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            throw new IOException("stream wasn't created");
        }
        synchronized (http2Stream) {
            http2Stream.readTimeout.enter();
            while (http2Stream.headersQueue.isEmpty() && http2Stream.errorCode == 0) {
                try {
                    try {
                        http2Stream.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    http2Stream.readTimeout.exitAndThrowIfTimedOut();
                    throw th;
                }
            }
            http2Stream.readTimeout.exitAndThrowIfTimedOut();
            if (http2Stream.headersQueue.isEmpty()) {
                IOException iOException = http2Stream.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                throw new StreamResetException(http2Stream.errorCode);
            }
            headers = (Headers) http2Stream.headersQueue.removeFirst();
        }
        Protocol protocol = this.protocol;
        ArrayList arrayList = new ArrayList(20);
        int size = headers.size();
        RoomOpenHelper roomOpenHelper = null;
        for (int i = 0; i < size; i++) {
            String strName = headers.name(i);
            String strValue = headers.value(i);
            if (Intrinsics.areEqual(strName, ":status")) {
                roomOpenHelper = StatusLine$Companion.parse("HTTP/1.1 " + strValue);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(strName)) {
                arrayList.add(strName);
                arrayList.add(StringsKt.trim(strValue).toString());
            }
        }
        if (roomOpenHelper == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Response.Builder builder = new Response.Builder();
        builder.protocol = protocol;
        builder.code = roomOpenHelper.version;
        builder.message = (String) roomOpenHelper.mDelegate;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        Headers.Builder builder2 = new Headers.Builder(0);
        ((ArrayList) builder2.namesAndValues).addAll(Arrays.asList(strArr));
        builder.headers = builder2;
        if (z && builder.code == 100) {
            return null;
        }
        return builder;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final long reportedContentLength(Response response) {
        if (HttpHeaders.promisesBody(response)) {
            return Util.headersContentLength(response);
        }
        return 0L;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void writeRequestHeaders(Request request) throws IOException {
        int i;
        Http2Stream http2Stream;
        if (this.stream != null) {
            return;
        }
        request.getClass();
        Headers headers = (Headers) request.headers;
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, (String) request.method));
        ByteString byteString = Header.TARGET_PATH;
        HttpUrl httpUrl = (HttpUrl) request.url;
        String strEncodedPath = httpUrl.encodedPath();
        String strEncodedQuery = httpUrl.encodedQuery();
        if (strEncodedQuery != null) {
            strEncodedPath = strEncodedPath + '?' + strEncodedQuery;
        }
        arrayList.add(new Header(byteString, strEncodedPath));
        String str = headers.get("Host");
        if (str != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, str));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, httpUrl.scheme));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String lowerCase = headers.name(i2).toLowerCase(Locale.US);
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (lowerCase.equals("te") && Intrinsics.areEqual(headers.value(i2), "trailers"))) {
                arrayList.add(new Header(lowerCase, headers.value(i2)));
            }
        }
        Http2Connection http2Connection = this.http2Connection;
        boolean z = !false;
        synchronized (http2Connection.writer) {
            synchronized (http2Connection) {
                try {
                    if (http2Connection.nextStreamId > 1073741823) {
                        http2Connection.shutdown(8);
                    }
                    if (http2Connection.isShutdown) {
                        throw new ConnectionShutdownException();
                    }
                    i = http2Connection.nextStreamId;
                    http2Connection.nextStreamId = i + 2;
                    http2Stream = new Http2Stream(i, http2Connection, z, false, null);
                    if (http2Stream.isOpen()) {
                        http2Connection.streams.put(Integer.valueOf(i), http2Stream);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            http2Connection.writer.headers(z, i, arrayList);
        }
        http2Connection.writer.flush();
        this.stream = http2Stream;
        if (this.canceled) {
            this.stream.closeLater(9);
            throw new IOException("Canceled");
        }
        Http2Stream.StreamTimeout streamTimeout = this.stream.readTimeout;
        long j = this.chain.readTimeoutMillis;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        streamTimeout.timeout(j);
        this.stream.writeTimeout.timeout(this.chain.writeTimeoutMillis);
    }
}
