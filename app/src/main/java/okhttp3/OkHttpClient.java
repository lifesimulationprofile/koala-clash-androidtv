package okhttp3;

import androidx.compose.material.icons.filled.LanKt;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.Util$$ExternalSyntheticLambda0;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.OkHostnameVerifier;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OkHttpClient implements Cloneable, Call$Factory {
    public final HttpUrl.Companion authenticator;
    public final LanKt certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeoutMillis;
    public final ConnectionPool connectionPool;
    public final List connectionSpecs;
    public final HttpUrl.Companion cookieJar;
    public final Dispatcher dispatcher;
    public final HttpUrl.Companion dns;
    public final Util$$ExternalSyntheticLambda0 eventListenerFactory;
    public final boolean followRedirects;
    public final boolean followSslRedirects;
    public final OkHostnameVerifier hostnameVerifier;
    public final List interceptors;
    public final List networkInterceptors;
    public final List protocols;
    public final HttpUrl.Companion proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeoutMillis;
    public final boolean retryOnConnectionFailure;
    public final Headers.Builder routeDatabase;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactoryOrNull;
    public final int writeTimeoutMillis;
    public final X509TrustManager x509TrustManager;
    public static final List DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder {
        public final HttpUrl.Companion authenticator;
        public final CertificatePinner certificatePinner;
        public int connectTimeout;
        public final List connectionSpecs;
        public final HttpUrl.Companion cookieJar;
        public final HttpUrl.Companion dns;
        public final boolean followRedirects;
        public final boolean followSslRedirects;
        public final OkHostnameVerifier hostnameVerifier;
        public final List protocols;
        public final HttpUrl.Companion proxyAuthenticator;
        public int readTimeout;
        public final SocketFactory socketFactory;
        public final int writeTimeout;
        public final Dispatcher dispatcher = new Dispatcher(0);
        public final ConnectionPool connectionPool = new ConnectionPool(0);
        public final ArrayList interceptors = new ArrayList();
        public final ArrayList networkInterceptors = new ArrayList();
        public final Util$$ExternalSyntheticLambda0 eventListenerFactory = new Util$$ExternalSyntheticLambda0();
        public final boolean retryOnConnectionFailure = true;

        public Builder() {
            HttpUrl.Companion companion = HttpUrl.Companion.NONE;
            this.authenticator = companion;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = HttpUrl.Companion.NO_COOKIES;
            this.dns = HttpUrl.Companion.SYSTEM;
            this.proxyAuthenticator = companion;
            this.socketFactory = SocketFactory.getDefault();
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = ModuleDescriptor.MODULE_VERSION;
            this.readTimeout = ModuleDescriptor.MODULE_VERSION;
            this.writeTimeout = ModuleDescriptor.MODULE_VERSION;
        }
    }

    public OkHttpClient(Builder builder) throws NoSuchAlgorithmException, KeyStoreException {
        this.dispatcher = builder.dispatcher;
        this.connectionPool = builder.connectionPool;
        this.interceptors = Collections.unmodifiableList(new ArrayList(builder.interceptors));
        this.networkInterceptors = Collections.unmodifiableList(new ArrayList(builder.networkInterceptors));
        this.eventListenerFactory = builder.eventListenerFactory;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.authenticator = builder.authenticator;
        this.followRedirects = builder.followRedirects;
        this.followSslRedirects = builder.followSslRedirects;
        this.cookieJar = builder.cookieJar;
        this.dns = builder.dns;
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.proxySelector = proxySelector == null ? NullProxySelector.INSTANCE : proxySelector;
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.socketFactory = builder.socketFactory;
        List list = builder.connectionSpecs;
        this.connectionSpecs = list;
        this.protocols = builder.protocols;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.connectTimeoutMillis = builder.connectTimeout;
        this.readTimeoutMillis = builder.readTimeout;
        this.writeTimeoutMillis = builder.writeTimeout;
        this.routeDatabase = new Headers.Builder(16);
        if (list != null && list.isEmpty()) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
            break;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.sslSocketFactoryOrNull = null;
                this.certificateChainCleaner = null;
                this.x509TrustManager = null;
                this.certificatePinner = CertificatePinner.DEFAULT;
                break;
            }
            if (((ConnectionSpec) it.next()).isTls) {
                Platform platform = Platform.platform;
                X509TrustManager x509TrustManagerPlatformTrustManager = Platform.platform.platformTrustManager();
                this.x509TrustManager = x509TrustManagerPlatformTrustManager;
                this.sslSocketFactoryOrNull = Platform.platform.newSslSocketFactory(x509TrustManagerPlatformTrustManager);
                LanKt lanKtBuildCertificateChainCleaner = Platform.platform.buildCertificateChainCleaner(x509TrustManagerPlatformTrustManager);
                this.certificateChainCleaner = lanKtBuildCertificateChainCleaner;
                CertificatePinner certificatePinner = builder.certificatePinner;
                this.certificatePinner = Intrinsics.areEqual(certificatePinner.certificateChainCleaner, lanKtBuildCertificateChainCleaner) ? certificatePinner : new CertificatePinner(certificatePinner.pins, lanKtBuildCertificateChainCleaner);
                break;
            }
        }
        X509TrustManager x509TrustManager = this.x509TrustManager;
        LanKt lanKt = this.certificateChainCleaner;
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        List list2 = this.networkInterceptors;
        List list3 = this.interceptors;
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list3).toString());
        }
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list2).toString());
        }
        List list4 = this.connectionSpecs;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((ConnectionSpec) it2.next()).isTls) {
                    if (sSLSocketFactory == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (lanKt == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (sSLSocketFactory != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (lanKt != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (x509TrustManager != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!Intrinsics.areEqual(this.certificatePinner, CertificatePinner.DEFAULT)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final Object clone() {
        return super.clone();
    }
}
