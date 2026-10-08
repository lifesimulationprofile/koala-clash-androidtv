package okhttp3.internal.tls;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    public static List getSubjectAltNames(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
        } catch (CertificateParsingException unused) {
        }
        return EmptyList.INSTANCE;
    }

    public static boolean isAscii(String str) {
        int i;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(length2, "endIndex < beginIndex: ", " < 0").toString());
        }
        if (length2 > str.length()) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(length2, "endIndex > string.length: ", " > ");
            sbM.append(str.length());
            throw new IllegalArgumentException(sbM.toString().toString());
        }
        long j = 0;
        int i2 = 0;
        while (i2 < length2) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                j++;
            } else {
                if (cCharAt < 2048) {
                    i = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i = 3;
                } else {
                    int i3 = i2 + 1;
                    char cCharAt2 = i3 < length2 ? str.charAt(i3) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j++;
                        i2 = i3;
                    } else {
                        j += (long) 4;
                        i2 += 2;
                    }
                }
                j += (long) i;
            }
            i2++;
        }
        return length == ((int) j);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        if (isAscii(str)) {
            try {
                return verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            } catch (SSLException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00db  */
    public static boolean verify(String str, X509Certificate x509Certificate) {
        boolean zAreEqual;
        int length;
        if (Util.VERIFY_AS_IP_ADDRESS.matches(str)) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            List subjectAltNames = getSubjectAltNames(x509Certificate, 7);
            if (!subjectAltNames.isEmpty()) {
                Iterator it = subjectAltNames.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(canonicalHost, HostnamesKt.toCanonicalHost((String) it.next()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (isAscii(str)) {
            str = str.toLowerCase(Locale.US);
        }
        List<String> subjectAltNames2 = getSubjectAltNames(x509Certificate, 2);
        if (!subjectAltNames2.isEmpty()) {
            for (String lowerCase : subjectAltNames2) {
                if (str.length() == 0 || StringsKt__StringsJVMKt.startsWith(str, ".", false) || str.endsWith("..") || lowerCase == null || lowerCase.length() == 0 || StringsKt__StringsJVMKt.startsWith(lowerCase, ".", false) || lowerCase.endsWith("..")) {
                    zAreEqual = false;
                } else {
                    String strConcat = !str.endsWith(".") ? str.concat(".") : str;
                    if (!lowerCase.endsWith(".")) {
                        lowerCase = lowerCase.concat(".");
                    }
                    if (isAscii(lowerCase)) {
                        lowerCase = lowerCase.toLowerCase(Locale.US);
                    }
                    if (!StringsKt.contains(lowerCase, "*", false)) {
                        zAreEqual = Intrinsics.areEqual(strConcat, lowerCase);
                    } else if (!StringsKt__StringsJVMKt.startsWith(lowerCase, "*.", false) || StringsKt.indexOf$default(lowerCase, '*', 1, 4) != -1 || strConcat.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                        zAreEqual = false;
                    } else {
                        String strSubstring = lowerCase.substring(1);
                        if (strConcat.endsWith(strSubstring) && ((length = strConcat.length() - strSubstring.length()) <= 0 || StringsKt.lastIndexOf$default(strConcat, '.', length - 1, 4) == -1)) {
                            zAreEqual = true;
                        } else {
                            zAreEqual = false;
                        }
                    }
                }
                if (zAreEqual) {
                    return true;
                }
            }
        }
        return false;
    }
}
