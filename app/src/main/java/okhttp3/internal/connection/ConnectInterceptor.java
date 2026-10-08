package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectInterceptor implements Interceptor {
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        RealCall realCall = realInterceptorChain.call;
        synchronized (realCall) {
            if (!realCall.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
            if (realCall.responseBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            if (realCall.requestBodyOpen) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.INSTANCE;
        }
        ExchangeFinder exchangeFinder = realCall.exchangeFinder;
        OkHttpClient okHttpClient = realCall.client;
        try {
            ExchangeCodec exchangeCodecNewCodec$okhttp = exchangeFinder.findHealthyConnection(realInterceptorChain.connectTimeoutMillis, realInterceptorChain.readTimeoutMillis, realInterceptorChain.writeTimeoutMillis, okHttpClient.retryOnConnectionFailure, !Intrinsics.areEqual((String) realInterceptorChain.request.method, "GET")).newCodec$okhttp(okHttpClient, realInterceptorChain);
            Exchange exchange = new Exchange();
            exchange.call = realCall;
            exchange.finder = exchangeFinder;
            exchange.codec = exchangeCodecNewCodec$okhttp;
            exchange.connection = exchangeCodecNewCodec$okhttp.getConnection();
            realCall.interceptorScopedExchange = exchange;
            realCall.exchange = exchange;
            synchronized (realCall) {
                realCall.requestBodyOpen = true;
                realCall.responseBodyOpen = true;
            }
            if (realCall.canceled) {
                throw new IOException("Canceled");
            }
            return RealInterceptorChain.copy$okhttp$default(realInterceptorChain, 0, exchange, null, 61).proceed(realInterceptorChain.request);
        } catch (IOException e) {
            exchangeFinder.trackFailure(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            exchangeFinder.trackFailure(e2.lastConnectException);
            throw e2;
        }
    }
}
