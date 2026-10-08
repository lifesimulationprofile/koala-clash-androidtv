package okhttp3.internal.http;

import io.github.g00fy2.quickie.ScanQRCode;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.Exchange.ResponseBodySource;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CallServerInterceptor implements Interceptor {
    /* JADX WARN: Code duplicated, block: B:41:0x00d6 A[Catch: IOException -> 0x0088, TryCatch #0 {IOException -> 0x0088, blocks: (B:19:0x004a, B:26:0x006f, B:29:0x008b, B:34:0x00b1, B:36:0x00c7, B:39:0x00d0, B:46:0x00e5, B:48:0x00e9, B:52:0x00f6, B:54:0x0109, B:55:0x0111, B:56:0x011b, B:41:0x00d6, B:59:0x011e, B:60:0x0121, B:30:0x008f, B:33:0x009a), top: B:67:0x004a, inners: #2 }] */
    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        Exchange exchange = realInterceptorChain.exchange;
        ExchangeCodec exchangeCodec = (ExchangeCodec) exchange.codec;
        RealCall realCall = (RealCall) exchange.call;
        ExchangeCodec exchangeCodec2 = (ExchangeCodec) exchange.codec;
        RealConnection realConnection = (RealConnection) exchange.connection;
        Request request = realInterceptorChain.request;
        request.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                exchangeCodec.writeRequestHeaders(request);
                HttpMethod.permitsRequestBody((String) request.method);
                realCall.messageDone$okhttp(exchange, true, false, null);
                try {
                    exchangeCodec.finishRequest();
                    e = null;
                } catch (IOException e) {
                    exchange.trackFailure(e);
                    throw e;
                }
            } catch (IOException e2) {
                exchange.trackFailure(e2);
                throw e2;
            }
        } catch (IOException e3) {
            e = e3;
            if ((e instanceof ConnectionShutdownException) || !exchange.hasFailure) {
                throw e;
            }
        }
        try {
            Response.Builder responseHeaders = exchange.readResponseHeaders(false);
            responseHeaders.request = request;
            responseHeaders.handshake = realConnection.handshake;
            responseHeaders.sentRequestAtMillis = jCurrentTimeMillis;
            responseHeaders.receivedResponseAtMillis = System.currentTimeMillis();
            Response responseBuild = responseHeaders.build();
            int i = responseBuild.code;
            if (i == 100 || (102 <= i && i < 200)) {
                Response.Builder responseHeaders2 = exchange.readResponseHeaders(false);
                responseHeaders2.request = request;
                responseHeaders2.handshake = realConnection.handshake;
                responseHeaders2.sentRequestAtMillis = jCurrentTimeMillis;
                responseHeaders2.receivedResponseAtMillis = System.currentTimeMillis();
                responseBuild = responseHeaders2.build();
                i = responseBuild.code;
            }
            Response.Builder builderNewBuilder = responseBuild.newBuilder();
            try {
                String str = responseBuild.headers.get("Content-Type");
                if (str == null) {
                    str = null;
                }
                long jReportedContentLength = exchangeCodec2.reportedContentLength(responseBuild);
                builderNewBuilder.body = new RealResponseBody(str, jReportedContentLength, new RealBufferedSource(exchange.new ResponseBodySource(exchangeCodec2.openResponseBodySource(responseBuild), jReportedContentLength)));
                Response responseBuild2 = builderNewBuilder.build();
                if ("close".equalsIgnoreCase(((Headers) responseBuild2.request.headers).get("Connection"))) {
                    exchangeCodec2.getConnection().noNewExchanges$okhttp();
                } else {
                    String str2 = responseBuild2.headers.get("Connection");
                    if (str2 == null) {
                        str2 = null;
                    }
                    if ("close".equalsIgnoreCase(str2)) {
                        exchangeCodec2.getConnection().noNewExchanges$okhttp();
                    }
                }
                if (i == 204 || i == 205) {
                    ResponseBody responseBody = responseBuild2.body;
                    if ((responseBody != null ? responseBody.contentLength() : -1L) > 0) {
                        StringBuilder sb = new StringBuilder("HTTP ");
                        sb.append(i);
                        sb.append(" had non-zero Content-Length: ");
                        ResponseBody responseBody2 = responseBuild2.body;
                        sb.append(responseBody2 != null ? Long.valueOf(responseBody2.contentLength()) : null);
                        throw new ProtocolException(sb.toString());
                    }
                }
                return responseBuild2;
            } catch (IOException e4) {
                exchange.trackFailure(e4);
                throw e4;
            }
        } catch (IOException e5) {
            if (e == null) {
                throw e5;
            }
            ScanQRCode.addSuppressed(e, e5);
            throw e;
        }
    }
}
