package okhttp3.internal.platform;

import android.util.Log;
import androidx.compose.material.icons.filled.LanKt;
import coil.network.EmptyNetworkObserver;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.platform.android.AndroidLogHandler;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.TrustRootIndex;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class Platform {
    public static final Logger logger;
    public static volatile Platform platform;

    /* JADX WARN: Code duplicated, block: B:25:0x006e A[PHI: r2
      0x006e: PHI (r2v3 okhttp3.internal.platform.Platform) = 
      (r2v1 okhttp3.internal.platform.Platform)
      (r2v0 okhttp3.internal.platform.Platform)
      (r2v4 okhttp3.internal.platform.Platform)
     binds: [B:64:0x0134, B:23:0x0067, B:24:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x0092  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:66:0x0138  */
    static {
        Platform platform2;
        Platform jdk8WithJettyBootPlatform = null;
        if (EmptyNetworkObserver.isAndroid()) {
            for (Map.Entry entry : AndroidLog.knownLoggers.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                Logger logger2 = Logger.getLogger(str);
                if (AndroidLog.configuredLoggers.add(logger2)) {
                    logger2.setUseParentHandlers(false);
                    logger2.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
                    logger2.addHandler(AndroidLogHandler.INSTANCE);
                }
            }
            platform2 = Android10Platform.isSupported ? new Android10Platform() : null;
            if (platform2 == null) {
                if (AndroidPlatform.isSupported) {
                    jdk8WithJettyBootPlatform = new AndroidPlatform();
                }
                platform2 = jdk8WithJettyBootPlatform;
            }
        } else if ("Conscrypt".equals(Security.getProviders()[0].getName())) {
            platform2 = ConscryptPlatform.isSupported ? new ConscryptPlatform() : null;
            if (platform2 == null) {
                if (!"BC".equals(Security.getProviders()[0].getName())) {
                    if (BouncyCastlePlatform.isSupported) {
                        platform2 = new BouncyCastlePlatform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 == null) {
                        if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                            if (OpenJSSEPlatform.isSupported) {
                                platform2 = new OpenJSSEPlatform();
                            } else {
                                platform2 = null;
                            }
                            if (platform2 == null) {
                                if (Jdk9Platform.isAvailable) {
                                    platform2 = new Jdk9Platform();
                                } else {
                                    platform2 = null;
                                }
                                if (platform2 == null) {
                                    if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) < 9) {
                                        Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null)), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
                                    }
                                    if (jdk8WithJettyBootPlatform != null) {
                                        platform2 = jdk8WithJettyBootPlatform;
                                    } else {
                                        platform2 = new Platform();
                                    }
                                }
                            }
                        } else {
                            if (Jdk9Platform.isAvailable) {
                                platform2 = new Jdk9Platform();
                            } else {
                                platform2 = null;
                            }
                            if (platform2 == null) {
                                if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) < 9) {
                                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null)), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
                                }
                                if (jdk8WithJettyBootPlatform != null) {
                                    platform2 = jdk8WithJettyBootPlatform;
                                } else {
                                    platform2 = new Platform();
                                }
                            }
                        }
                    }
                } else if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                    if (Jdk9Platform.isAvailable) {
                        platform2 = new Jdk9Platform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 == null) {
                        if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) < 9) {
                            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls3.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null)), cls3.getMethod("get", SSLSocket.class), cls3.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
                        }
                        if (jdk8WithJettyBootPlatform != null) {
                            platform2 = jdk8WithJettyBootPlatform;
                        } else {
                            platform2 = new Platform();
                        }
                    }
                } else {
                    if (OpenJSSEPlatform.isSupported) {
                        platform2 = new OpenJSSEPlatform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 == null) {
                        if (Jdk9Platform.isAvailable) {
                            platform2 = new Jdk9Platform();
                        } else {
                            platform2 = null;
                        }
                        if (platform2 == null) {
                            if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) < 9) {
                                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls4.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null)), cls4.getMethod("get", SSLSocket.class), cls4.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
                            }
                            if (jdk8WithJettyBootPlatform != null) {
                                platform2 = jdk8WithJettyBootPlatform;
                            } else {
                                platform2 = new Platform();
                            }
                        }
                    }
                }
            }
        } else if (!"BC".equals(Security.getProviders()[0].getName())) {
            if (BouncyCastlePlatform.isSupported) {
                platform2 = new BouncyCastlePlatform();
            } else {
                platform2 = null;
            }
            if (platform2 == null) {
                if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
                    if (Jdk9Platform.isAvailable) {
                        platform2 = new Jdk9Platform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 == null) {
                        if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) < 9) {
                            Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls5.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null)), cls5.getMethod("get", SSLSocket.class), cls5.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
                        }
                        if (jdk8WithJettyBootPlatform != null) {
                            platform2 = jdk8WithJettyBootPlatform;
                        } else {
                            platform2 = new Platform();
                        }
                    }
                } else {
                    if (OpenJSSEPlatform.isSupported) {
                        platform2 = new OpenJSSEPlatform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 == null) {
                        if (Jdk9Platform.isAvailable) {
                            platform2 = new Jdk9Platform();
                        } else {
                            platform2 = null;
                        }
                        if (platform2 == null) {
                            if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) < 9) {
                                Class<?> cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls6.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null)), cls6.getMethod("get", SSLSocket.class), cls6.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
                            }
                            if (jdk8WithJettyBootPlatform != null) {
                                platform2 = jdk8WithJettyBootPlatform;
                            } else {
                                platform2 = new Platform();
                            }
                        }
                    }
                }
            }
        } else if ("OpenJSSE".equals(Security.getProviders()[0].getName())) {
            if (Jdk9Platform.isAvailable) {
                platform2 = new Jdk9Platform();
            } else {
                platform2 = null;
            }
            if (platform2 == null) {
                try {
                    if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) < 9) {
                        try {
                            Class<?> cls7 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                            jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls7.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null)), cls7.getMethod("get", SSLSocket.class), cls7.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
                        } catch (ClassNotFoundException | NoSuchMethodException unused) {
                        }
                    }
                } catch (NumberFormatException unused2) {
                }
                if (jdk8WithJettyBootPlatform != null) {
                    platform2 = jdk8WithJettyBootPlatform;
                } else {
                    platform2 = new Platform();
                }
            }
        } else {
            if (OpenJSSEPlatform.isSupported) {
                platform2 = new OpenJSSEPlatform();
            } else {
                platform2 = null;
            }
            if (platform2 == null) {
                if (Jdk9Platform.isAvailable) {
                    platform2 = new Jdk9Platform();
                } else {
                    platform2 = null;
                }
                if (platform2 == null) {
                    if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) < 9) {
                        Class<?> cls8 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(cls8.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null)), cls8.getMethod("get", SSLSocket.class), cls8.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
                    }
                    if (jdk8WithJettyBootPlatform != null) {
                        platform2 = jdk8WithJettyBootPlatform;
                    } else {
                        platform2 = new Platform();
                    }
                }
            }
        }
        platform = platform2;
        logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static void log(String str, int i, Throwable th) {
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public LanKt buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public Object getStackTraceForCloseable() {
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        return true;
    }

    public void logCloseableLeak(Object obj, String str) {
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        log(str, 5, (Throwable) obj);
    }

    public SSLContext newSSLContext() {
        return SSLContext.getInstance("TLS");
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContextNewSSLContext = newSSLContext();
            sSLContextNewSSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextNewSSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException("Unexpected default trust managers: ".concat(Arrays.toString(trustManagers)).toString());
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
    }
}
