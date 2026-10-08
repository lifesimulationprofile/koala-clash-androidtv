package okhttp3.internal.connection;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.comparisons.NaturalOrderComparator;
import okhttp3.CipherSuite;
import okhttp3.CipherSuite$Companion$ORDER_BY_NAME$1;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionSpecSelector {
    public final List connectionSpecs;
    public boolean isFallback;
    public boolean isFallbackPossible;
    public int nextModeIndex;

    public ConnectionSpecSelector(List list) {
        this.connectionSpecs = list;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Serializable, java.lang.String[]] */
    public final ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws UnknownServiceException {
        ConnectionSpec connectionSpec;
        int i;
        boolean z;
        int i2 = this.nextModeIndex;
        List list = this.connectionSpecs;
        int size = list.size();
        while (true) {
            if (i2 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = (ConnectionSpec) list.get(i2);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i2 + 1;
                break;
            }
            i2++;
        }
        if (connectionSpec == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + list + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        int i3 = this.nextModeIndex;
        int size2 = list.size();
        while (true) {
            i = 0;
            if (i3 >= size2) {
                z = false;
                break;
            }
            if (((ConnectionSpec) list.get(i3)).isCompatible(sSLSocket)) {
                z = true;
                break;
            }
            i3++;
        }
        this.isFallbackPossible = z;
        boolean z2 = this.isFallback;
        ?? r1 = connectionSpec.tlsVersionsAsString;
        String[] strArr = connectionSpec.cipherSuitesAsString;
        String[] strArrIntersect = strArr != null ? Util.intersect(sSLSocket.getEnabledCipherSuites(), strArr, CipherSuite.ORDER_BY_NAME) : sSLSocket.getEnabledCipherSuites();
        String[] strArrIntersect2 = r1 != 0 ? Util.intersect(sSLSocket.getEnabledProtocols(), r1, NaturalOrderComparator.INSTANCE) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        CipherSuite$Companion$ORDER_BY_NAME$1 cipherSuite$Companion$ORDER_BY_NAME$1 = CipherSuite.ORDER_BY_NAME;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        int length = supportedCipherSuites.length;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (cipherSuite$Companion$ORDER_BY_NAME$1.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i++;
        }
        if (z2 && i != -1) {
            String str = supportedCipherSuites[i];
            strArrIntersect = (String[]) Arrays.copyOf(strArrIntersect, strArrIntersect.length + 1);
            strArrIntersect[strArrIntersect.length - 1] = str;
        }
        ConnectionSpec.Builder builder = new ConnectionSpec.Builder();
        builder.tls = connectionSpec.isTls;
        builder.cipherSuites = strArr;
        builder.tlsVersions = r1;
        builder.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        builder.cipherSuites((String[]) Arrays.copyOf(strArrIntersect, strArrIntersect.length));
        builder.tlsVersions((String[]) Arrays.copyOf(strArrIntersect2, strArrIntersect2.length));
        ConnectionSpec connectionSpecBuild = builder.build();
        if (connectionSpecBuild.tlsVersions() != null) {
            sSLSocket.setEnabledProtocols(connectionSpecBuild.tlsVersionsAsString);
        }
        if (connectionSpecBuild.cipherSuites() != null) {
            sSLSocket.setEnabledCipherSuites(connectionSpecBuild.cipherSuitesAsString);
        }
        return connectionSpec;
    }
}
