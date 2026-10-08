package okhttp3.internal.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HttpHeaders {
    static {
        new ByteString("\"\\".getBytes(Charsets.UTF_8)).utf8 = "\"\\";
        new ByteString("\t ,=".getBytes(Charsets.UTF_8)).utf8 = "\t ,=";
    }

    public static final boolean promisesBody(Response response) {
        if (Intrinsics.areEqual((String) response.request.method, "HEAD")) {
            return false;
        }
        int i = response.code;
        if (((i < 100 || i >= 200) && i != 204 && i != 304) || Util.headersContentLength(response) != -1) {
            return true;
        }
        String str = response.headers.get("Transfer-Encoding");
        if (str == null) {
            str = null;
        }
        return "chunked".equalsIgnoreCase(str);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:30:0x0094  */
    public static final void receiveHeaders(HttpUrl.Companion companion, HttpUrl httpUrl, Headers headers) {
        Cookie cookie;
        Cookie cookie2;
        String strSubstring;
        if (companion == HttpUrl.Companion.NO_COOKIES) {
            return;
        }
        Pattern pattern = Cookie.YEAR_PATTERN;
        int size = headers.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if ("Set-Cookie".equalsIgnoreCase(headers.name(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.value(i));
            }
        }
        List listUnmodifiableList = EmptyList.INSTANCE;
        List listUnmodifiableList2 = arrayList != null ? Collections.unmodifiableList(arrayList) : listUnmodifiableList;
        int size2 = listUnmodifiableList2.size();
        ArrayList arrayList2 = null;
        for (int i2 = 0; i2 < size2; i2++) {
            String str = (String) listUnmodifiableList2.get(i2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            char c = ';';
            int iDelimiterOffset = Util.delimiterOffset(str, ';', 0, str.length());
            char c2 = '=';
            int iDelimiterOffset2 = Util.delimiterOffset(str, '=', 0, iDelimiterOffset);
            if (iDelimiterOffset2 == iDelimiterOffset) {
                cookie = null;
            } else {
                int iIndexOfFirstNonAsciiWhitespace = Util.indexOfFirstNonAsciiWhitespace(0, iDelimiterOffset2, str);
                String strSubstring2 = str.substring(iIndexOfFirstNonAsciiWhitespace, Util.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset2, str));
                if (strSubstring2.length() != 0 && Util.indexOfControlOrNonAscii(strSubstring2) == -1) {
                    int iIndexOfFirstNonAsciiWhitespace2 = Util.indexOfFirstNonAsciiWhitespace(iDelimiterOffset2 + 1, iDelimiterOffset, str);
                    String strSubstring3 = str.substring(iIndexOfFirstNonAsciiWhitespace2, Util.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace2, iDelimiterOffset, str));
                    if (Util.indexOfControlOrNonAscii(strSubstring3) == -1) {
                        int i3 = iDelimiterOffset + 1;
                        int length = str.length();
                        long j = 253402300799999L;
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        long expires = 253402300799999L;
                        String str2 = null;
                        String strSubstring4 = null;
                        long j2 = -1;
                        boolean z4 = true;
                        while (true) {
                            if (i3 >= length) {
                                if (j2 == Long.MIN_VALUE) {
                                    j = Long.MIN_VALUE;
                                } else if (j2 != -1) {
                                    long j3 = jCurrentTimeMillis + (j2 <= 9223372036854775L ? j2 * ((long) 1000) : Long.MAX_VALUE);
                                    if (j3 >= jCurrentTimeMillis && j3 <= 253402300799999L) {
                                        j = j3;
                                    }
                                } else {
                                    j = expires;
                                }
                                String str3 = httpUrl.host;
                                if (str2 != null) {
                                    if (!Intrinsics.areEqual(str3, str2) && (!str3.endsWith(str2) || str3.charAt((str3.length() - str2.length()) - 1) != '.' || Util.VERIFY_AS_IP_ADDRESS.matches(str3))) {
                                        cookie2 = null;
                                    }
                                    cookie = cookie2;
                                    break;
                                }
                                str2 = str3;
                                if (str3.length() == str2.length() || PublicSuffixDatabase.instance.getEffectiveTldPlusOne(str2) != null) {
                                    if (strSubstring4 == null || !StringsKt__StringsJVMKt.startsWith(strSubstring4, "/", false)) {
                                        String strEncodedPath = httpUrl.encodedPath();
                                        int iLastIndexOf$default = StringsKt.lastIndexOf$default(strEncodedPath, '/', 0, 6);
                                        strSubstring4 = iLastIndexOf$default != 0 ? strEncodedPath.substring(0, iLastIndexOf$default) : "/";
                                    }
                                    cookie2 = new Cookie(strSubstring2, strSubstring3, j, str2, strSubstring4, z, z2, z3, z4);
                                } else {
                                    cookie2 = null;
                                }
                                cookie = cookie2;
                                break;
                            }
                            int iDelimiterOffset3 = Util.delimiterOffset(str, c, i3, length);
                            int iDelimiterOffset4 = Util.delimiterOffset(str, c2, i3, iDelimiterOffset3);
                            int iIndexOfFirstNonAsciiWhitespace3 = Util.indexOfFirstNonAsciiWhitespace(i3, iDelimiterOffset4, str);
                            String strSubstring5 = str.substring(iIndexOfFirstNonAsciiWhitespace3, Util.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace3, iDelimiterOffset4, str));
                            if (iDelimiterOffset4 < iDelimiterOffset3) {
                                int iIndexOfFirstNonAsciiWhitespace4 = Util.indexOfFirstNonAsciiWhitespace(iDelimiterOffset4 + 1, iDelimiterOffset3, str);
                                strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace4, Util.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace4, iDelimiterOffset3, str));
                            } else {
                                strSubstring = "";
                            }
                            if (strSubstring5.equalsIgnoreCase("expires")) {
                                try {
                                    expires = Cookie.Companion.parseExpires(strSubstring, strSubstring.length());
                                    z3 = true;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (strSubstring5.equalsIgnoreCase("max-age")) {
                                try {
                                    long j4 = Long.parseLong(strSubstring);
                                    j2 = j4 <= 0 ? Long.MIN_VALUE : j4;
                                } catch (NumberFormatException e) {
                                    if (!Pattern.compile("-?\\d+").matcher(strSubstring).matches()) {
                                        throw e;
                                    }
                                    j2 = StringsKt__StringsJVMKt.startsWith(strSubstring, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                                }
                                z3 = true;
                            } else if (strSubstring5.equalsIgnoreCase("domain")) {
                                if (strSubstring.endsWith(".")) {
                                    throw new IllegalArgumentException("Failed requirement.");
                                }
                                String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt.removePrefix(strSubstring, "."));
                                if (canonicalHost == null) {
                                    throw new IllegalArgumentException();
                                }
                                str2 = canonicalHost;
                                z4 = false;
                            } else if (strSubstring5.equalsIgnoreCase("path")) {
                                strSubstring4 = strSubstring;
                            } else if (strSubstring5.equalsIgnoreCase("secure")) {
                                z = true;
                            } else if (strSubstring5.equalsIgnoreCase("httponly")) {
                                z2 = true;
                            }
                            i3 = iDelimiterOffset3 + 1;
                            c = ';';
                            c2 = '=';
                        }
                    } else {
                        cookie = null;
                    }
                } else {
                    cookie = null;
                }
            }
            if (cookie != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(cookie);
            }
        }
        if (arrayList2 != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList2);
        }
        listUnmodifiableList.isEmpty();
    }
}
