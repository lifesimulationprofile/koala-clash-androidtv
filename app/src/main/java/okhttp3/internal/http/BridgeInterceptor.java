package okhttp3.internal.http;

import androidx.compose.ui.node.RulerTrackingMap;
import coil.memory.RealWeakMemoryCache;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.GzipSource;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BridgeInterceptor implements Interceptor {
    public final /* synthetic */ int $r8$classId;
    public final Object cookieJar;

    public /* synthetic */ BridgeInterceptor(int i, Object obj) {
        this.$r8$classId = i;
        this.cookieJar = obj;
    }

    public static int retryAfter(Response response, int i) {
        String str = response.headers.get("Retry-After");
        if (str == null) {
            str = null;
        }
        if (str == null) {
            return i;
        }
        if (Pattern.compile("\\d+").matcher(str).matches()) {
            return Integer.valueOf(str).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0131  */
    /* JADX WARN: Code duplicated, block: B:103:0x0137  */
    /* JADX WARN: Code duplicated, block: B:106:0x0150  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:91:0x0114  */
    /* JADX WARN: Code duplicated, block: B:95:0x0120  */
    public Request followUpRequest(Response response, Exchange exchange) throws ProtocolException {
        OkHttpClient okHttpClient;
        String str;
        Request request;
        HttpUrl.Builder builder;
        HttpUrl httpUrlBuild;
        Dispatcher dispatcherNewBuilder;
        boolean z;
        Response response2;
        RealConnection realConnection;
        Route route = (exchange == null || (realConnection = (RealConnection) exchange.connection) == null) ? null : realConnection.route;
        int i = response.code;
        String str2 = (String) response.request.method;
        if (i == 307 || i == 308) {
            okHttpClient = (OkHttpClient) this.cookieJar;
            if (okHttpClient.followRedirects) {
                str = response.headers.get("Location");
                if (str == null) {
                    str = null;
                }
                request = response.request;
                if (str != null) {
                    HttpUrl httpUrl = (HttpUrl) request.url;
                    httpUrl.getClass();
                    try {
                        builder = new HttpUrl.Builder();
                        builder.parse$okhttp(httpUrl, str);
                    } catch (IllegalArgumentException unused) {
                        builder = null;
                    }
                    if (builder != null) {
                        httpUrlBuild = builder.build();
                    } else {
                        httpUrlBuild = null;
                    }
                    if (httpUrlBuild != null && (Intrinsics.areEqual(httpUrlBuild.scheme, ((HttpUrl) request.url).scheme) || okHttpClient.followSslRedirects)) {
                        dispatcherNewBuilder = request.newBuilder();
                        if (HttpMethod.permitsRequestBody(str2)) {
                            int i2 = response.code;
                            z = !str2.equals("PROPFIND") || i2 == 308 || i2 == 307;
                            if (!str2.equals("PROPFIND") || i2 == 308 || i2 == 307) {
                                dispatcherNewBuilder.method(str2, null);
                            } else {
                                dispatcherNewBuilder.method("GET", null);
                            }
                            if (!z) {
                                dispatcherNewBuilder.removeHeader("Transfer-Encoding");
                                dispatcherNewBuilder.removeHeader("Content-Length");
                                dispatcherNewBuilder.removeHeader("Content-Type");
                            }
                        }
                        if (!Util.canReuseConnectionFor((HttpUrl) request.url, httpUrlBuild)) {
                            dispatcherNewBuilder.removeHeader("Authorization");
                        }
                        dispatcherNewBuilder.executorServiceOrNull = httpUrlBuild;
                        return dispatcherNewBuilder.build();
                    }
                }
            }
        } else {
            if (i == 401) {
                ((OkHttpClient) this.cookieJar).authenticator.getClass();
                return null;
            }
            if (i != 421) {
                if (i == 503) {
                    Response response3 = response.priorResponse;
                    if ((response3 == null || response3.code != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                        return response.request;
                    }
                } else {
                    if (i == 407) {
                        if (route.proxy.type() != Proxy.Type.HTTP) {
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                        ((OkHttpClient) this.cookieJar).proxyAuthenticator.getClass();
                        return null;
                    }
                    if (i != 408) {
                        switch (i) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                okHttpClient = (OkHttpClient) this.cookieJar;
                                if (okHttpClient.followRedirects) {
                                    str = response.headers.get("Location");
                                    if (str == null) {
                                        str = null;
                                    }
                                    request = response.request;
                                    if (str != null) {
                                        HttpUrl httpUrl2 = (HttpUrl) request.url;
                                        httpUrl2.getClass();
                                        builder = new HttpUrl.Builder();
                                        builder.parse$okhttp(httpUrl2, str);
                                        if (builder != null) {
                                            httpUrlBuild = builder.build();
                                        } else {
                                            httpUrlBuild = null;
                                        }
                                        if (httpUrlBuild != null) {
                                            dispatcherNewBuilder = request.newBuilder();
                                            if (HttpMethod.permitsRequestBody(str2)) {
                                                int i3 = response.code;
                                                if (str2.equals("PROPFIND")) {
                                                }
                                                if (str2.equals("PROPFIND")) {
                                                    dispatcherNewBuilder.method(str2, null);
                                                } else {
                                                    dispatcherNewBuilder.method(str2, null);
                                                }
                                                if (!z) {
                                                    dispatcherNewBuilder.removeHeader("Transfer-Encoding");
                                                    dispatcherNewBuilder.removeHeader("Content-Length");
                                                    dispatcherNewBuilder.removeHeader("Content-Type");
                                                }
                                            }
                                            if (!Util.canReuseConnectionFor((HttpUrl) request.url, httpUrlBuild)) {
                                                dispatcherNewBuilder.removeHeader("Authorization");
                                            }
                                            dispatcherNewBuilder.executorServiceOrNull = httpUrlBuild;
                                            return dispatcherNewBuilder.build();
                                        }
                                    }
                                }
                            default:
                                return null;
                        }
                    } else if (((OkHttpClient) this.cookieJar).retryOnConnectionFailure && (((response2 = response.priorResponse) == null || response2.code != 408) && retryAfter(response, 0) <= 0)) {
                        return response.request;
                    }
                }
            } else if (exchange != null && !Intrinsics.areEqual(((ExchangeFinder) exchange.finder).address.url.host, ((RealConnection) exchange.connection).route.address.url.host)) {
                RealConnection realConnection2 = (RealConnection) exchange.connection;
                synchronized (realConnection2) {
                    realConnection2.noCoalescedConnections = true;
                }
                return response.request;
            }
        }
        return null;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) {
        boolean z;
        ResponseBody responseBody;
        Response responseProceed;
        SSLSocketFactory sSLSocketFactory;
        OkHostnameVerifier okHostnameVerifier;
        CertificatePinner certificatePinner;
        switch (this.$r8$classId) {
            case 0:
                HttpUrl.Companion companion = (HttpUrl.Companion) this.cookieJar;
                Request request = realInterceptorChain.request;
                Dispatcher dispatcherNewBuilder = request.newBuilder();
                HttpUrl httpUrl = (HttpUrl) request.url;
                Headers headers = (Headers) request.headers;
                if (headers.get("Host") == null) {
                    dispatcherNewBuilder.header("Host", Util.toHostHeader(httpUrl, false));
                }
                if (headers.get("Connection") == null) {
                    dispatcherNewBuilder.header("Connection", "Keep-Alive");
                }
                if (headers.get("Accept-Encoding") == null && headers.get("Range") == null) {
                    dispatcherNewBuilder.header("Accept-Encoding", "gzip");
                    z = true;
                } else {
                    z = false;
                }
                companion.getClass();
                if (headers.get("User-Agent") == null) {
                    dispatcherNewBuilder.header("User-Agent", "okhttp/4.12.0");
                }
                Response responseProceed2 = realInterceptorChain.proceed(dispatcherNewBuilder.build());
                Headers headers2 = responseProceed2.headers;
                HttpHeaders.receiveHeaders(companion, httpUrl, headers2);
                Response.Builder builderNewBuilder = responseProceed2.newBuilder();
                builderNewBuilder.request = request;
                if (z) {
                    String str = headers2.get("Content-Encoding");
                    if (str == null) {
                        str = null;
                    }
                    if ("gzip".equalsIgnoreCase(str) && HttpHeaders.promisesBody(responseProceed2) && (responseBody = responseProceed2.body) != null) {
                        GzipSource gzipSource = new GzipSource(responseBody.source());
                        Headers.Builder builderNewBuilder2 = headers2.newBuilder();
                        builderNewBuilder2.removeAll("Content-Encoding");
                        builderNewBuilder2.removeAll("Content-Length");
                        builderNewBuilder.headers = builderNewBuilder2.build().newBuilder();
                        String str2 = headers2.get("Content-Type");
                        if (str2 == null) {
                            str2 = null;
                        }
                        builderNewBuilder.body = new RealResponseBody(str2, -1L, new RealBufferedSource(gzipSource));
                    }
                }
                return builderNewBuilder.build();
            default:
                Request request2 = realInterceptorChain.request;
                RealCall realCall = realInterceptorChain.call;
                List listPlus = EmptyList.INSTANCE;
                Response response = null;
                int i = 0;
                Request requestFollowUpRequest = request2;
                while (true) {
                    boolean z2 = true;
                    while (true) {
                        if (realCall.interceptorScopedExchange != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                        synchronized (realCall) {
                            if (realCall.responseBodyOpen) {
                                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                            }
                            if (realCall.requestBodyOpen) {
                                throw new IllegalStateException("Check failed.");
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                        if (z2) {
                            RealConnectionPool realConnectionPool = realCall.connectionPool;
                            HttpUrl httpUrl2 = (HttpUrl) requestFollowUpRequest.url;
                            OkHttpClient okHttpClient = realCall.client;
                            if (httpUrl2.isHttps) {
                                SSLSocketFactory sSLSocketFactory2 = okHttpClient.sslSocketFactoryOrNull;
                                if (sSLSocketFactory2 == null) {
                                    throw new IllegalStateException("CLEARTEXT-only client");
                                }
                                OkHostnameVerifier okHostnameVerifier2 = okHttpClient.hostnameVerifier;
                                certificatePinner = okHttpClient.certificatePinner;
                                sSLSocketFactory = sSLSocketFactory2;
                                okHostnameVerifier = okHostnameVerifier2;
                            } else {
                                sSLSocketFactory = null;
                                okHostnameVerifier = null;
                                certificatePinner = null;
                            }
                            realCall.exchangeFinder = new ExchangeFinder(realConnectionPool, new Address(httpUrl2.host, httpUrl2.port, okHttpClient.dns, okHttpClient.socketFactory, sSLSocketFactory, okHostnameVerifier, certificatePinner, okHttpClient.proxyAuthenticator, okHttpClient.protocols, okHttpClient.connectionSpecs, okHttpClient.proxySelector), realCall);
                        }
                        try {
                            if (realCall.canceled) {
                                throw new IOException("Canceled");
                            }
                            try {
                                responseProceed = realInterceptorChain.proceed(requestFollowUpRequest);
                            } catch (IOException e) {
                                if (!recover(e, realCall, requestFollowUpRequest, !(e instanceof ConnectionShutdownException))) {
                                    Iterator it = listPlus.iterator();
                                    while (it.hasNext()) {
                                        ScanQRCode.addSuppressed(e, (Exception) it.next());
                                    }
                                    throw e;
                                }
                                listPlus = CollectionsKt.plus(listPlus, e);
                                realCall.exitNetworkInterceptorExchange$okhttp(true);
                                z2 = false;
                            } catch (RouteException e2) {
                                if (!recover(e2.lastConnectException, realCall, requestFollowUpRequest, false)) {
                                    IOException iOException = e2.firstConnectException;
                                    Iterator it2 = listPlus.iterator();
                                    while (it2.hasNext()) {
                                        ScanQRCode.addSuppressed(iOException, (Exception) it2.next());
                                    }
                                    throw iOException;
                                }
                                listPlus = CollectionsKt.plus(listPlus, e2.firstConnectException);
                                realCall.exitNetworkInterceptorExchange$okhttp(true);
                                z2 = false;
                            }
                        } catch (Throwable th) {
                            realCall.exitNetworkInterceptorExchange$okhttp(true);
                            throw th;
                        }
                        break;
                        z2 = false;
                    }
                    if (response != null) {
                        Response.Builder builderNewBuilder3 = responseProceed.newBuilder();
                        Response.Builder builderNewBuilder4 = response.newBuilder();
                        builderNewBuilder4.body = null;
                        Response responseBuild = builderNewBuilder4.build();
                        if (responseBuild.body != null) {
                            throw new IllegalArgumentException("priorResponse.body != null");
                        }
                        builderNewBuilder3.priorResponse = responseBuild;
                        responseProceed = builderNewBuilder3.build();
                    }
                    response = responseProceed;
                    requestFollowUpRequest = followUpRequest(response, realCall.interceptorScopedExchange);
                    if (requestFollowUpRequest == null) {
                        realCall.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    ResponseBody responseBody2 = response.body;
                    if (responseBody2 != null) {
                        Util.closeQuietly(responseBody2);
                    }
                    i++;
                    if (i > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + i);
                    }
                    realCall.exitNetworkInterceptorExchange$okhttp(true);
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0046  */
    /* JADX WARN: Code duplicated, block: B:36:0x004b  */
    /* JADX WARN: Code duplicated, block: B:38:0x004e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0063 A[ADDED_TO_REGION, DONT_GENERATE, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:51:0x0065 A[Catch: all -> 0x007b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:47:0x005f, B:51:0x0065, B:55:0x0077), top: B:76:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0080  */
    /* JADX WARN: Code duplicated, block: B:63:0x0082  */
    /* JADX WARN: Code duplicated, block: B:64:0x0084  */
    /* JADX WARN: Code duplicated, block: B:66:0x0088  */
    /* JADX WARN: Code duplicated, block: B:69:0x008f  */
    /* JADX WARN: Code duplicated, block: B:75:0x009b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean recover(IOException iOException, RealCall realCall, Request request, boolean z) {
        ExchangeFinder exchangeFinder;
        int i;
        boolean zHasNext;
        Route route;
        RealWeakMemoryCache realWeakMemoryCache;
        RulerTrackingMap rulerTrackingMap;
        RealConnection realConnection;
        if (!((OkHttpClient) this.cookieJar).retryOnConnectionFailure || ((z && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException))) {
            return false;
        }
        if (!(iOException instanceof InterruptedIOException)) {
            if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
                return false;
            }
            exchangeFinder = realCall.exchangeFinder;
            i = exchangeFinder.refusedStreamCount;
            if (i != 0) {
                if (exchangeFinder.nextRouteToTry != null) {
                    zHasNext = true;
                } else {
                    route = null;
                    if (i <= 1) {
                        synchronized (realConnection) {
                            if (realConnection.routeFailureCount != 0) {
                                route = realConnection.route;
                            }
                        }
                    }
                    if (route != null) {
                        exchangeFinder.nextRouteToTry = route;
                    } else {
                        realWeakMemoryCache = exchangeFinder.routeSelection;
                        zHasNext = realWeakMemoryCache != null ? rulerTrackingMap.hasNext() : rulerTrackingMap.hasNext();
                    }
                    zHasNext = true;
                }
            } else if (exchangeFinder.nextRouteToTry != null) {
                zHasNext = true;
            } else {
                route = null;
                if (i <= 1) {
                    synchronized (realConnection) {
                        if (realConnection.routeFailureCount != 0) {
                            route = realConnection.route;
                        }
                    }
                }
                if (route != null) {
                    exchangeFinder.nextRouteToTry = route;
                } else {
                    realWeakMemoryCache = exchangeFinder.routeSelection;
                    if (realWeakMemoryCache != null) {
                    }
                }
                zHasNext = true;
            }
            if (!zHasNext) {
                return true;
            }
        } else if ((iOException instanceof SocketTimeoutException) && !z) {
            exchangeFinder = realCall.exchangeFinder;
            i = exchangeFinder.refusedStreamCount;
            if (i != 0 && exchangeFinder.connectionShutdownCount == 0 && exchangeFinder.otherFailureCount == 0) {
                zHasNext = false;
            } else if (exchangeFinder.nextRouteToTry != null) {
                zHasNext = true;
            } else {
                route = null;
                if (i <= 1 && exchangeFinder.connectionShutdownCount <= 1 && exchangeFinder.otherFailureCount <= 0 && (realConnection = exchangeFinder.call.connection) != null) {
                    synchronized (realConnection) {
                        if (realConnection.routeFailureCount != 0 && Util.canReuseConnectionFor(realConnection.route.address.url, exchangeFinder.address.url)) {
                            route = realConnection.route;
                        }
                    }
                }
                if (route != null) {
                    exchangeFinder.nextRouteToTry = route;
                } else {
                    realWeakMemoryCache = exchangeFinder.routeSelection;
                    if ((realWeakMemoryCache != null || !realWeakMemoryCache.hasNext()) && (rulerTrackingMap = exchangeFinder.routeSelector) != null) {
                    }
                }
                zHasNext = true;
            }
            if (!zHasNext) {
                return true;
            }
        }
        return false;
    }
}
