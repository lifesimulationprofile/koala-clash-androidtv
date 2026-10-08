package okhttp3.internal.connection;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.RulerTrackingMap;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionSpec;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec$FixedLengthSource;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.InputStreamSource;
import okio.Okio__JvmOkioKt;
import okio.OutputStreamSink;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.SocketAsyncTimeout;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealConnection extends Http2Connection.Listener {
    public Handshake handshake;
    public Http2Connection http2Connection;
    public boolean noCoalescedConnections;
    public boolean noNewExchanges;
    public Protocol protocol;
    public Socket rawSocket;
    public int refusedStreamCount;
    public final Route route;
    public int routeFailureCount;
    public RealBufferedSink sink;
    public Socket socket;
    public RealBufferedSource source;
    public int successCount;
    public int allocationLimit = 1;
    public final ArrayList calls = new ArrayList();
    public long idleAtNs = Long.MAX_VALUE;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RealConnection(Route route) {
        this.route = route;
    }

    public static void connectFailed$okhttp(OkHttpClient okHttpClient, Route route, IOException iOException) {
        if (route.proxy.type() != Proxy.Type.DIRECT) {
            Address address = route.address;
            address.proxySelector.connectFailed(address.url.uri(), route.proxy.address(), iOException);
        }
        Headers.Builder builder = okHttpClient.routeDatabase;
        synchronized (builder) {
            ((LinkedHashSet) builder.namesAndValues).add(route);
        }
    }

    public final void connect(int i, int i2, int i3, boolean z, RealCall realCall) throws Throwable {
        if (this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        Address address = this.route.address;
        List list = address.connectionSpecs;
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        if (address.sslSocketFactory == null) {
            if (!list.contains(ConnectionSpec.CLEARTEXT)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.route.address.url.host;
            Platform platform = Platform.platform;
            if (!Platform.platform.isCleartextTrafficPermitted(str)) {
                throw new RouteException(new UnknownServiceException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (address.protocols.contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        while (true) {
            try {
                Route route = this.route;
                if (route.address.sslSocketFactory != null && route.proxy.type() == Proxy.Type.HTTP) {
                    connectTunnel(i, i2, i3);
                    if (this.rawSocket != null) {
                        break;
                    } else {
                        break;
                    }
                }
                connectSocket(i, i2);
                establishProtocol(connectionSpecSelector);
                InetSocketAddress inetSocketAddress = this.route.socketAddress;
                break;
            } catch (IOException e) {
                Socket socket = this.socket;
                if (socket != null) {
                    Util.closeQuietly(socket);
                }
                Socket socket2 = this.rawSocket;
                if (socket2 != null) {
                    Util.closeQuietly(socket2);
                }
                this.socket = null;
                this.rawSocket = null;
                this.source = null;
                this.sink = null;
                this.handshake = null;
                this.protocol = null;
                this.http2Connection = null;
                this.allocationLimit = 1;
                InetSocketAddress inetSocketAddress2 = this.route.socketAddress;
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    ScanQRCode.addSuppressed(routeException.firstConnectException, e);
                    routeException.lastConnectException = e;
                }
                if (!z) {
                    throw routeException;
                }
                connectionSpecSelector.isFallback = true;
                if (!connectionSpecSelector.isFallbackPossible) {
                    throw routeException;
                }
                if (e instanceof ProtocolException) {
                    throw routeException;
                }
                if (e instanceof InterruptedIOException) {
                    throw routeException;
                }
                if ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) {
                    throw routeException;
                }
                if (e instanceof SSLPeerUnverifiedException) {
                    throw routeException;
                }
                if (!(e instanceof SSLException)) {
                    throw routeException;
                }
            }
        }
        Route route2 = this.route;
        if (route2.address.sslSocketFactory != null && route2.proxy.type() == Proxy.Type.HTTP && this.rawSocket == null) {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.idleAtNs = System.nanoTime();
    }

    public final void connectSocket(int i, int i2) throws IOException {
        Route route = this.route;
        Proxy proxy = route.proxy;
        Address address = route.address;
        Proxy.Type type = proxy.type();
        int i3 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        int i4 = 1;
        Socket socketCreateSocket = (i3 == 1 || i3 == 2) ? address.socketFactory.createSocket() : new Socket(proxy);
        this.rawSocket = socketCreateSocket;
        InetSocketAddress inetSocketAddress = this.route.socketAddress;
        socketCreateSocket.setSoTimeout(i2);
        try {
            Platform platform = Platform.platform;
            Platform.platform.connectSocket(socketCreateSocket, this.route.socketAddress, i);
            try {
                Logger logger = Okio__JvmOkioKt.logger;
                SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socketCreateSocket);
                int i5 = 0;
                this.source = new RealBufferedSource(new InputStreamSource(i4, socketAsyncTimeout, new InputStreamSource(i5, socketCreateSocket.getInputStream(), socketAsyncTimeout)));
                SocketAsyncTimeout socketAsyncTimeout2 = new SocketAsyncTimeout(socketCreateSocket);
                this.sink = new RealBufferedSink(new OutputStreamSink(i4, socketAsyncTimeout2, new OutputStreamSink(i5, socketCreateSocket.getOutputStream(), socketAsyncTimeout2)));
            } catch (NullPointerException e) {
                if (Intrinsics.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress);
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void connectTunnel(int i, int i2, int i3) throws IOException {
        Dispatcher dispatcher = new Dispatcher(22);
        Route route = this.route;
        dispatcher.executorServiceOrNull = route.address.url;
        dispatcher.method("CONNECT", null);
        Address address = route.address;
        ((Headers.Builder) dispatcher.runningAsyncCalls).set("Host", Util.toHostHeader(address.url, true));
        ((Headers.Builder) dispatcher.runningAsyncCalls).set("Proxy-Connection", "Keep-Alive");
        ((Headers.Builder) dispatcher.runningAsyncCalls).set("User-Agent", "okhttp/4.12.0");
        Request requestBuild = dispatcher.build();
        Headers.Builder builder = new Headers.Builder(0);
        builder.set("Proxy-Authenticate", "OkHttp-Preemptive");
        builder.build();
        address.proxyAuthenticator.getClass();
        HttpUrl httpUrl = (HttpUrl) requestBuild.url;
        connectSocket(i, i2);
        String str = "CONNECT " + Util.toHostHeader(httpUrl, true) + " HTTP/1.1";
        RealBufferedSource realBufferedSource = this.source;
        RealBufferedSink realBufferedSink = this.sink;
        RulerTrackingMap rulerTrackingMap = new RulerTrackingMap(null, this, realBufferedSource, realBufferedSink);
        Timeout timeout = realBufferedSource.source.timeout();
        long j = i2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(j);
        realBufferedSink.sink.timeout().timeout(i3);
        rulerTrackingMap.writeRequest((Headers) requestBuild.headers, str);
        rulerTrackingMap.finishRequest();
        Response.Builder responseHeaders = rulerTrackingMap.readResponseHeaders(false);
        responseHeaders.request = requestBuild;
        Response responseBuild = responseHeaders.build();
        int i4 = responseBuild.code;
        long jHeadersContentLength = Util.headersContentLength(responseBuild);
        if (jHeadersContentLength != -1) {
            Http1ExchangeCodec$FixedLengthSource http1ExchangeCodec$FixedLengthSourceNewFixedLengthSource = rulerTrackingMap.newFixedLengthSource(jHeadersContentLength);
            Util.skipAll(http1ExchangeCodec$FixedLengthSourceNewFixedLengthSource, Integer.MAX_VALUE);
            http1ExchangeCodec$FixedLengthSourceNewFixedLengthSource.close();
        }
        if (i4 != 200) {
            if (i4 != 407) {
                throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unexpected response code for CONNECT: ", i4));
            }
            address.proxyAuthenticator.getClass();
            throw new IOException("Failed to authenticate with proxy");
        }
        if (!realBufferedSource.bufferField.exhausted() || !realBufferedSink.bufferField.exhausted()) {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
    }

    public final void establishProtocol(ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        SSLSocket sSLSocket;
        String selectedProtocol;
        Protocol protocol = Protocol.HTTP_2;
        Protocol protocol2 = Protocol.HTTP_1_1;
        Protocol protocol3 = Protocol.H2_PRIOR_KNOWLEDGE;
        Address address = this.route.address;
        SSLSocketFactory sSLSocketFactory = address.sslSocketFactory;
        if (sSLSocketFactory == null) {
            if (!address.protocols.contains(protocol3)) {
                this.socket = this.rawSocket;
                this.protocol = protocol2;
                return;
            } else {
                this.socket = this.rawSocket;
                this.protocol = protocol3;
                startHttp2();
                return;
            }
        }
        try {
            Socket socket = this.rawSocket;
            HttpUrl httpUrl = address.url;
            int i = 1;
            SSLSocket sSLSocket2 = (SSLSocket) sSLSocketFactory.createSocket(socket, httpUrl.host, httpUrl.port, true);
            try {
                ConnectionSpec connectionSpecConfigureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                if (connectionSpecConfigureSecureSocket.supportsTlsExtensions) {
                    Platform platform = Platform.platform;
                    Platform.platform.configureTlsExtensions(sSLSocket2, address.url.host, address.protocols);
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                Handshake handshake = Handshake.Companion.get(session);
                int i2 = 0;
                if (!address.hostnameVerifier.verify(address.url.host, session)) {
                    List listPeerCertificates = handshake.peerCertificates();
                    if (listPeerCertificates.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + address.url.host + " not verified (no certificates)");
                    }
                    X509Certificate x509Certificate = (X509Certificate) listPeerCertificates.get(0);
                    StringBuilder sb = new StringBuilder("\n              |Hostname ");
                    sb.append(address.url.host);
                    sb.append(" not verified:\n              |    certificate: ");
                    CertificatePinner certificatePinner = CertificatePinner.DEFAULT;
                    sb.append(CertificatePinner.Companion.pin(x509Certificate));
                    sb.append("\n              |    DN: ");
                    sb.append(x509Certificate.getSubjectDN().getName());
                    sb.append("\n              |    subjectAltNames: ");
                    sb.append(CollectionsKt.plus((Collection) OkHostnameVerifier.getSubjectAltNames(x509Certificate, 7), OkHostnameVerifier.getSubjectAltNames(x509Certificate, 2)));
                    sb.append("\n              ");
                    throw new SSLPeerUnverifiedException(StringsKt__IndentKt.trimMargin$default(sb.toString()));
                }
                CertificatePinner certificatePinner2 = address.certificatePinner;
                this.handshake = new Handshake(handshake.tlsVersion, handshake.cipherSuite, handshake.localCertificates, new RealConnection$connectTls$1(certificatePinner2, handshake, address, i2));
                String str = address.url.host;
                Iterator it = certificatePinner2.pins.iterator();
                if (it.hasNext()) {
                    Modifier.CC.m(it.next());
                    throw null;
                }
                if (connectionSpecConfigureSecureSocket.supportsTlsExtensions) {
                    Platform platform2 = Platform.platform;
                    selectedProtocol = Platform.platform.getSelectedProtocol(sSLSocket2);
                } else {
                    selectedProtocol = null;
                }
                this.socket = sSLSocket2;
                Logger logger = Okio__JvmOkioKt.logger;
                SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(sSLSocket2);
                this.source = new RealBufferedSource(new InputStreamSource(i, socketAsyncTimeout, new InputStreamSource(i2, sSLSocket2.getInputStream(), socketAsyncTimeout)));
                SocketAsyncTimeout socketAsyncTimeout2 = new SocketAsyncTimeout(sSLSocket2);
                this.sink = new RealBufferedSink(new OutputStreamSink(i, socketAsyncTimeout2, new OutputStreamSink(i2, sSLSocket2.getOutputStream(), socketAsyncTimeout2)));
                if (selectedProtocol != null) {
                    Protocol protocol4 = Protocol.HTTP_1_0;
                    if (selectedProtocol.equals("http/1.0")) {
                        protocol2 = protocol4;
                    } else if (!selectedProtocol.equals("http/1.1")) {
                        if (selectedProtocol.equals("h2_prior_knowledge")) {
                            protocol2 = protocol3;
                        } else if (selectedProtocol.equals("h2")) {
                            protocol2 = protocol;
                        } else {
                            protocol2 = Protocol.SPDY_3;
                            if (!selectedProtocol.equals("spdy/3.1")) {
                                protocol2 = Protocol.QUIC;
                                if (!selectedProtocol.equals("quic")) {
                                    throw new IOException("Unexpected protocol: ".concat(selectedProtocol));
                                }
                            }
                        }
                    }
                }
                this.protocol = protocol2;
                Platform platform3 = Platform.platform;
                Platform.platform.afterHandshake(sSLSocket2);
                if (this.protocol == protocol) {
                    startHttp2();
                }
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform platform4 = Platform.platform;
                    Platform.platform.afterHandshake(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.closeQuietly((Socket) sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            sSLSocket = null;
        }
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        this.successCount++;
    }

    public final boolean isEligible$okhttp(Address address, List list) {
        Handshake handshake;
        HttpUrl httpUrl = address.url;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        if (this.calls.size() < this.allocationLimit && !this.noNewExchanges) {
            Route route = this.route;
            Address address2 = route.address;
            Address address3 = route.address;
            if (address2.equalsNonHost$okhttp(address)) {
                if (!Intrinsics.areEqual(httpUrl.host, address3.url.host)) {
                    if (this.http2Connection != null && list != null && !list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            Route route2 = (Route) it.next();
                            Proxy.Type type = route2.proxy.type();
                            Proxy.Type type2 = Proxy.Type.DIRECT;
                            if (type == type2 && route.proxy.type() == type2 && Intrinsics.areEqual(route.socketAddress, route2.socketAddress)) {
                                if (address.hostnameVerifier != OkHostnameVerifier.INSTANCE) {
                                    break;
                                }
                                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                                HttpUrl httpUrl2 = address3.url;
                                int i = httpUrl.port;
                                String str = httpUrl.host;
                                if (i != httpUrl2.port) {
                                    break;
                                }
                                if (!Intrinsics.areEqual(str, httpUrl2.host)) {
                                    if (!this.noCoalescedConnections && (handshake = this.handshake) != null) {
                                        List listPeerCertificates = handshake.peerCertificates();
                                        if (listPeerCertificates.isEmpty() || !OkHostnameVerifier.verify(str, (X509Certificate) listPeerCertificates.get(0))) {
                                            break;
                                            break;
                                        }
                                    } else {
                                        break;
                                        break;
                                    }
                                }
                                try {
                                    CertificatePinner certificatePinner = address.certificatePinner;
                                    this.handshake.peerCertificates();
                                    Iterator it2 = certificatePinner.pins.iterator();
                                    if (!it2.hasNext()) {
                                        return true;
                                    }
                                    Modifier.CC.m(it2.next());
                                    throw null;
                                } catch (SSLPeerUnverifiedException unused) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isHealthy(boolean z) {
        long j;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        long jNanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        Socket socket2 = this.socket;
        RealBufferedSource realBufferedSource = this.source;
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.idleAtNs;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !realBufferedSource.exhausted();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) throws SocketException {
        int i = realInterceptorChain.readTimeoutMillis;
        Socket socket = this.socket;
        RealBufferedSource realBufferedSource = this.source;
        RealBufferedSink realBufferedSink = this.sink;
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain, http2Connection);
        }
        socket.setSoTimeout(i);
        Timeout timeout = realBufferedSource.source.timeout();
        long j = i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(j);
        realBufferedSink.sink.timeout().timeout(realInterceptorChain.writeTimeoutMillis);
        return new RulerTrackingMap(okHttpClient, this, realBufferedSource, realBufferedSink);
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final synchronized void onSettings(Settings settings) {
        this.allocationLimit = (settings.set & 16) != 0 ? settings.values[4] : Integer.MAX_VALUE;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final void onStream(Http2Stream http2Stream) {
        http2Stream.close(8, null);
    }

    public final void startHttp2() throws SocketException {
        Socket socket = this.socket;
        RealBufferedSource realBufferedSource = this.source;
        RealBufferedSink realBufferedSink = this.sink;
        socket.setSoTimeout(0);
        TaskRunner taskRunner = TaskRunner.INSTANCE;
        Http2Connection.Builder builder = new Http2Connection.Builder();
        builder.taskRunner = taskRunner;
        builder.listener = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
        String str = this.route.address.url.host;
        builder.socket = socket;
        builder.connectionName = Util.okHttpName + ' ' + str;
        builder.source = realBufferedSource;
        builder.sink = realBufferedSink;
        builder.listener = this;
        Http2Connection http2Connection = new Http2Connection(builder);
        this.http2Connection = http2Connection;
        Settings settings = Http2Connection.DEFAULT_SETTINGS;
        this.allocationLimit = (settings.set & 16) != 0 ? settings.values[4] : Integer.MAX_VALUE;
        Http2Writer http2Writer = http2Connection.writer;
        synchronized (http2Writer) {
            try {
                if (http2Writer.closed) {
                    throw new IOException("closed");
                }
                Logger logger = Http2Writer.logger;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                http2Writer.sink.write(Http2.CONNECTION_PREFACE);
                http2Writer.sink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
        http2Connection.writer.settings(http2Connection.okHttpSettings);
        int initialWindowSize = http2Connection.okHttpSettings.getInitialWindowSize();
        if (initialWindowSize != 65535) {
            http2Connection.writer.windowUpdate(0, initialWindowSize - 65535);
        }
        taskRunner.newQueue().schedule(new TaskQueue$execute$1(http2Connection.connectionName, http2Connection.readerRunnable, 0), 0L);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        Route route = this.route;
        sb.append(route.address.url.host);
        sb.append(':');
        sb.append(route.address.url.port);
        sb.append(", proxy=");
        sb.append(route.proxy);
        sb.append(" hostAddress=");
        sb.append(route.socketAddress);
        sb.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        if (handshake == null || (obj = handshake.cipherSuite) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
