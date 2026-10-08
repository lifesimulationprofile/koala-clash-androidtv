package okhttp3;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HttpUrl {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String fragment;
    public final String host;
    public final boolean isHttps;
    public final String password;
    public final int port;
    public final List queryNamesAndValues;
    public final String scheme;
    public final String url;
    public final String username;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder {
        public String encodedFragment;
        public final ArrayList encodedPathSegments;
        public ArrayList encodedQueryNamesAndValues;
        public String host;
        public String scheme;
        public String encodedUsername = "";
        public String encodedPassword = "";
        public int port = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String strPercentDecode$okhttp$default = Companion.percentDecode$okhttp$default(0, 0, 7, this.encodedUsername);
            String strPercentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(0, 0, 7, this.encodedPassword);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            ArrayList arrayList2 = this.encodedPathSegments;
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                arrayList3.add(Companion.percentDecode$okhttp$default(0, 0, 7, (String) obj));
            }
            ArrayList arrayList4 = this.encodedQueryNamesAndValues;
            if (arrayList4 != null) {
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10));
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    String str3 = (String) obj2;
                    arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(0, 0, 3, str3) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$okhttp$default, strPercentDecode$okhttp$default2, str2, iEffectivePort, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(0, 0, 7, str4) : null, toString());
        }

        public final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            String str = this.scheme;
            if (str.equals("http")) {
                return 80;
            }
            return str.equals("https") ? 443 : -1;
        }

        /* JADX WARN: Code duplicated, block: B:39:0x0079  */
        public final void parse$okhttp(HttpUrl httpUrl, String str) {
            int i;
            String str2;
            int i2;
            int iDelimiterOffset;
            int i3;
            int i4;
            char cCharAt;
            String str3 = str;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            int iIndexOfFirstNonAsciiWhitespace = Util.indexOfFirstNonAsciiWhitespace(0, str3.length(), str3);
            int iIndexOfLastNonAsciiWhitespace = Util.indexOfLastNonAsciiWhitespace(iIndexOfFirstNonAsciiWhitespace, str3.length(), str3);
            byte b = -1;
            if (iIndexOfLastNonAsciiWhitespace - iIndexOfFirstNonAsciiWhitespace >= 2) {
                char cCharAt2 = str3.charAt(iIndexOfFirstNonAsciiWhitespace);
                if ((Intrinsics.compare((int) cCharAt2, 97) >= 0 && Intrinsics.compare((int) cCharAt2, 122) <= 0) || (Intrinsics.compare((int) cCharAt2, 65) >= 0 && Intrinsics.compare((int) cCharAt2, 90) <= 0)) {
                    int i5 = iIndexOfFirstNonAsciiWhitespace + 1;
                    while (true) {
                        if (i5 < iIndexOfLastNonAsciiWhitespace) {
                            char cCharAt3 = str3.charAt(i5);
                            if (('a' <= cCharAt3 && cCharAt3 < '{') || (('A' <= cCharAt3 && cCharAt3 < '[') || (('0' <= cCharAt3 && cCharAt3 < ':') || cCharAt3 == '+' || cCharAt3 == '-' || cCharAt3 == '.'))) {
                                i5++;
                            } else if (cCharAt3 == ':') {
                                i = i5;
                                break;
                            }
                        }
                        i = -1;
                        break;
                    }
                } else {
                    i = -1;
                    break;
                }
            } else {
                i = -1;
                break;
            }
            int i6 = 1;
            if (i != -1) {
                str2 = "https";
                if (str3.regionMatches(true, iIndexOfFirstNonAsciiWhitespace, "https:", 0, 6)) {
                    this.scheme = str2;
                    iIndexOfFirstNonAsciiWhitespace += 6;
                    str3 = str;
                } else {
                    str3 = str;
                    if (!str3.regionMatches(true, iIndexOfFirstNonAsciiWhitespace, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str3.substring(0, i) + '\'');
                    }
                    this.scheme = "http";
                    iIndexOfFirstNonAsciiWhitespace += 5;
                }
            } else {
                str2 = "https";
                if (httpUrl == null) {
                    throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m("Expected URL scheme 'http' or 'https' but no scheme was found for ", str3.length() > 6 ? StringsKt.take(str3, 6).concat("...") : str3));
                }
                this.scheme = httpUrl.scheme;
            }
            int i7 = iIndexOfFirstNonAsciiWhitespace;
            int i8 = 0;
            while (true) {
                i2 = i6;
                if (i7 >= iIndexOfLastNonAsciiWhitespace || !((cCharAt = str3.charAt(i7)) == '\\' || cCharAt == '/')) {
                    break;
                }
                i8++;
                i7++;
                i6 = i2;
            }
            ArrayList arrayList = this.encodedPathSegments;
            byte b2 = 35;
            if (i8 >= 2 || httpUrl == null || !Intrinsics.areEqual(httpUrl.scheme, this.scheme)) {
                int i9 = iIndexOfFirstNonAsciiWhitespace + i8;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(i9, iIndexOfLastNonAsciiWhitespace, str3, "@/\\?#");
                    byte bCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace ? str3.charAt(iDelimiterOffset) : b;
                    if (bCharAt == b || bCharAt == b2 || bCharAt == 47 || bCharAt == 92 || bCharAt == 63) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (i10 == 0) {
                            int iDelimiterOffset2 = Util.delimiterOffset(str3, ':', i9, iDelimiterOffset);
                            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(str3, i9, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", 240);
                            if (i11 != 0) {
                                strCanonicalize$okhttp$default = this.encodedUsername + "%40" + strCanonicalize$okhttp$default;
                            }
                            this.encodedUsername = strCanonicalize$okhttp$default;
                            if (iDelimiterOffset2 != iDelimiterOffset) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(str3, iDelimiterOffset2 + 1, iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", 240);
                                i10 = i2;
                            }
                            i11 = i2;
                        } else {
                            this.encodedPassword += "%40" + Companion.canonicalize$okhttp$default(str3, i9, iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", 240);
                        }
                        i9 = iDelimiterOffset + 1;
                        b = -1;
                        b2 = 35;
                    }
                }
                int i12 = i9;
                while (true) {
                    if (i12 >= iDelimiterOffset) {
                        i12 = iDelimiterOffset;
                        break;
                    }
                    char cCharAt4 = str3.charAt(i12);
                    if (cCharAt4 == '[') {
                        do {
                            i12++;
                            if (i12 >= iDelimiterOffset) {
                                break;
                            }
                        } while (str3.charAt(i12) != ']');
                    } else if (cCharAt4 == ':') {
                        break;
                    }
                    i12++;
                }
                int i13 = i12 + 1;
                if (i13 < iDelimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(i9, i12, 4, str3));
                    try {
                        i4 = Integer.parseInt(Companion.canonicalize$okhttp$default(str3, i13, iDelimiterOffset, "", 248));
                        if (i2 > i4 || i4 >= 65536) {
                            i4 = -1;
                        }
                    } catch (NumberFormatException unused) {
                    }
                    this.port = i4;
                    if (i4 == -1) {
                        throw new IllegalArgumentException(("Invalid URL port: \"" + str3.substring(i13, iDelimiterOffset) + '\"').toString());
                    }
                } else {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(i9, i12, 4, str3));
                    String str4 = this.scheme;
                    if (str4.equals("http")) {
                        i3 = 80;
                    } else {
                        i3 = str4.equals(str2) ? 443 : -1;
                    }
                    this.port = i3;
                }
                if (this.host == null) {
                    throw new IllegalArgumentException(("Invalid URL host: \"" + str3.substring(i9, i12) + '\"').toString());
                }
                iIndexOfFirstNonAsciiWhitespace = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                arrayList.clear();
                arrayList.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace == iIndexOfLastNonAsciiWhitespace || str3.charAt(iIndexOfFirstNonAsciiWhitespace) == '#') {
                    String strEncodedQuery = httpUrl.encodedQuery();
                    this.encodedQueryNamesAndValues = strEncodedQuery != null ? Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(strEncodedQuery, 0, 0, " \"'<>#", 211)) : null;
                }
            }
            int iDelimiterOffset3 = Util.delimiterOffset(iIndexOfFirstNonAsciiWhitespace, iIndexOfLastNonAsciiWhitespace, str3, "?#");
            if (iIndexOfFirstNonAsciiWhitespace != iDelimiterOffset3) {
                char cCharAt5 = str3.charAt(iIndexOfFirstNonAsciiWhitespace);
                if (cCharAt5 == '/' || cCharAt5 == '\\') {
                    arrayList.clear();
                    arrayList.add("");
                    iIndexOfFirstNonAsciiWhitespace++;
                } else {
                    arrayList.set(arrayList.size() - 1, "");
                }
                while (iIndexOfFirstNonAsciiWhitespace < iDelimiterOffset3) {
                    int iDelimiterOffset4 = Util.delimiterOffset(iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset3, str3, "/\\");
                    boolean z = iDelimiterOffset4 < iDelimiterOffset3;
                    String strCanonicalize$okhttp$default2 = Companion.canonicalize$okhttp$default(str3, iIndexOfFirstNonAsciiWhitespace, iDelimiterOffset4, " \"<>^`{}|/\\?#", 240);
                    if (!strCanonicalize$okhttp$default2.equals(".") && !strCanonicalize$okhttp$default2.equalsIgnoreCase("%2e")) {
                        if (!strCanonicalize$okhttp$default2.equals("..") && !strCanonicalize$okhttp$default2.equalsIgnoreCase("%2e.") && !strCanonicalize$okhttp$default2.equalsIgnoreCase(".%2e") && !strCanonicalize$okhttp$default2.equalsIgnoreCase("%2e%2e")) {
                            if (((CharSequence) arrayList.get(arrayList.size() - 1)).length() == 0) {
                                arrayList.set(arrayList.size() - 1, strCanonicalize$okhttp$default2);
                            } else {
                                arrayList.add(strCanonicalize$okhttp$default2);
                            }
                            if (z) {
                                arrayList.add("");
                            }
                        } else if (((String) arrayList.remove(arrayList.size() - 1)).length() != 0 || arrayList.isEmpty()) {
                            arrayList.add("");
                        } else {
                            arrayList.set(arrayList.size() - 1, "");
                        }
                    }
                    iIndexOfFirstNonAsciiWhitespace = z ? iDelimiterOffset4 + 1 : iDelimiterOffset4;
                }
            }
            if (iDelimiterOffset3 < iIndexOfLastNonAsciiWhitespace && str3.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset5 = Util.delimiterOffset(str3, '#', iDelimiterOffset3, iIndexOfLastNonAsciiWhitespace);
                this.encodedQueryNamesAndValues = Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(str3, iDelimiterOffset3 + 1, iDelimiterOffset5, " \"'<>#", 208));
                iDelimiterOffset3 = iDelimiterOffset5;
            }
            if (iDelimiterOffset3 >= iIndexOfLastNonAsciiWhitespace || str3.charAt(iDelimiterOffset3) != '#') {
                return;
            }
            this.encodedFragment = Companion.canonicalize$okhttp$default(str3, iDelimiterOffset3 + 1, iIndexOfLastNonAsciiWhitespace, "", 176);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x008b  */
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (StringsKt.contains$default(str2, ':')) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            int i = -1;
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null) {
                    sb.append(':');
                    sb.append(iEffectivePort);
                } else {
                    if (str3.equals("http")) {
                        i = 80;
                    } else if (str3.equals("https")) {
                        i = 443;
                    }
                    if (iEffectivePort != i) {
                        sb.append(':');
                        sb.append(iEffectivePort);
                    }
                }
            }
            ArrayList arrayList = this.encodedPathSegments;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append((String) arrayList.get(i2));
            }
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                Companion.toQueryString$okhttp(this.encodedQueryNamesAndValues, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public static final Companion NONE = new Companion();
        public static final Companion NO_COOKIES = new Companion();
        public static final Companion SYSTEM = new Companion();

        public static final CipherSuite access$init(Companion companion, String str) {
            CipherSuite cipherSuite = new CipherSuite(str);
            CipherSuite.INSTANCES.put(str, cipherSuite);
            return cipherSuite;
        }

        public static String canonicalize$okhttp$default(String str, int i, int i2, String str2, int i3) {
            int i4 = 0;
            int i5 = (i3 & 1) != 0 ? 0 : i;
            int length = (i3 & 2) != 0 ? str.length() : i2;
            boolean z = (i3 & 8) == 0;
            boolean z2 = (i3 & 16) == 0;
            boolean z3 = (i3 & 32) == 0;
            boolean z4 = (i3 & 64) == 0;
            int iCharCount = i5;
            while (iCharCount < length) {
                int iCodePointAt = str.codePointAt(iCharCount);
                int i6 = 32;
                int i7 = 43;
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z4) || StringsKt.contains$default(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z || (z2 && !isPercentEncoded(iCharCount, length, str)))) || (iCodePointAt == 43 && z3)))) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(i5, iCharCount, str);
                    Buffer buffer2 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = str.codePointAt(iCharCount);
                        if (!z || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                            if (iCodePointAt2 == i7 && z3) {
                                String str3 = z ? "+" : "%2B";
                                buffer.writeUtf8(i4, str3.length(), str3);
                            } else {
                                if (iCodePointAt2 >= i6 && iCodePointAt2 != 127) {
                                    if ((iCodePointAt2 < 128 || z4) && !StringsKt.contains$default(str2, (char) iCodePointAt2) && (iCodePointAt2 != 37 || (z && (!z2 || isPercentEncoded(iCharCount, length, str))))) {
                                        buffer.writeUtf8CodePoint(iCodePointAt2);
                                    }
                                }
                                if (buffer2 == null) {
                                    buffer2 = new Buffer();
                                }
                                buffer2.writeUtf8CodePoint(iCodePointAt2);
                                while (!buffer2.exhausted()) {
                                    byte b = buffer2.readByte();
                                    buffer.m857writeByte(37);
                                    char[] cArr = HttpUrl.HEX_DIGITS;
                                    buffer.m857writeByte((int) cArr[((b & 255) >> 4) & 15]);
                                    buffer.m857writeByte((int) cArr[b & 15]);
                                }
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i4 = 0;
                        i6 = 32;
                        i7 = 43;
                    }
                    return buffer.readString(buffer.size, Charsets.UTF_8);
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            return str.substring(i5, length);
        }

        public static boolean isPercentEncoded(int i, int i2, String str) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && Util.parseHexDigit(str.charAt(i + 1)) != -1 && Util.parseHexDigit(str.charAt(i3)) != -1;
        }

        public static String percentDecode$okhttp$default(int i, int i2, int i3, String str) {
            int i4;
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            boolean z = (i3 & 4) == 0;
            int iCharCount = i;
            while (iCharCount < i2) {
                char cCharAt = str.charAt(iCharCount);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(i, iCharCount, str);
                    while (iCharCount < i2) {
                        int iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 37 && (i4 = iCharCount + 2) < i2) {
                            int hexDigit = Util.parseHexDigit(str.charAt(iCharCount + 1));
                            int hexDigit2 = Util.parseHexDigit(str.charAt(i4));
                            if (hexDigit == -1 || hexDigit2 == -1) {
                                buffer.writeUtf8CodePoint(iCodePointAt);
                                iCharCount += Character.charCount(iCodePointAt);
                            } else {
                                buffer.m857writeByte((hexDigit << 4) + hexDigit2);
                                iCharCount = Character.charCount(iCodePointAt) + i4;
                            }
                        } else if (iCodePointAt == 43 && z) {
                            buffer.m857writeByte(32);
                            iCharCount++;
                        } else {
                            buffer.writeUtf8CodePoint(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                    return buffer.readString(buffer.size, Charsets.UTF_8);
                }
                iCharCount++;
            }
            return str.substring(i, i2);
        }

        public static ArrayList toQueryNamesAndValues$okhttp(String str) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iIndexOf$default = StringsKt.indexOf$default(str, '&', i, 4);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str.length();
                }
                int iIndexOf$default2 = StringsKt.indexOf$default(str, '=', i, 4);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > iIndexOf$default) {
                    arrayList.add(str.substring(i, iIndexOf$default));
                    arrayList.add(null);
                } else {
                    arrayList.add(str.substring(i, iIndexOf$default2));
                    arrayList.add(str.substring(iIndexOf$default2 + 1, iIndexOf$default));
                }
                i = iIndexOf$default + 1;
            }
            return arrayList;
        }

        public static void toQueryString$okhttp(List list, StringBuilder sb) {
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, list.size()), 2);
            int i = intProgressionStep.first;
            int i2 = intProgressionStep.last;
            int i3 = intProgressionStep.step;
            if ((i3 <= 0 || i > i2) && (i3 >= 0 || i2 > i)) {
                return;
            }
            while (true) {
                String str = (String) list.get(i);
                String str2 = (String) list.get(i + 1);
                if (i > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (i == i2) {
                    return;
                } else {
                    i += i3;
                }
            }
        }

        public synchronized CipherSuite forJavaName(String str) {
            CipherSuite cipherSuite;
            String strConcat;
            try {
                LinkedHashMap linkedHashMap = CipherSuite.INSTANCES;
                cipherSuite = (CipherSuite) linkedHashMap.get(str);
                if (cipherSuite == null) {
                    if (StringsKt__StringsJVMKt.startsWith(str, "TLS_", false)) {
                        strConcat = "SSL_".concat(str.substring(4));
                    } else {
                        strConcat = StringsKt__StringsJVMKt.startsWith(str, "SSL_", false) ? "TLS_".concat(str.substring(4)) : str;
                    }
                    cipherSuite = (CipherSuite) linkedHashMap.get(strConcat);
                    if (cipherSuite == null) {
                        cipherSuite = new CipherSuite(str);
                    }
                    linkedHashMap.put(str, cipherSuite);
                }
            } catch (Throwable th) {
                throw th;
            }
            return cipherSuite;
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i, ArrayList arrayList, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i;
        this.queryNamesAndValues = arrayList;
        this.fragment = str5;
        this.url = str6;
        this.isHttps = Intrinsics.areEqual(str, "https");
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return str.substring(StringsKt.indexOf$default(str, ':', length, 4) + 1, StringsKt.indexOf$default(str, '@', 0, 6));
    }

    public final String encodedPath() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iIndexOf$default = StringsKt.indexOf$default(str, '/', length, 4);
        return str.substring(iIndexOf$default, Util.delimiterOffset(iIndexOf$default, str.length(), str, "?#"));
    }

    public final ArrayList encodedPathSegments() {
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iIndexOf$default = StringsKt.indexOf$default(str, '/', length, 4);
        int iDelimiterOffset = Util.delimiterOffset(iIndexOf$default, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iDelimiterOffset) {
            int i = iIndexOf$default + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(str, '/', i, iDelimiterOffset);
            arrayList.add(str.substring(i, iDelimiterOffset2));
            iIndexOf$default = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        String str = this.url;
        int iIndexOf$default = StringsKt.indexOf$default(str, '?', 0, 6) + 1;
        return str.substring(iIndexOf$default, Util.delimiterOffset(str, '#', iIndexOf$default, str.length()));
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return str.substring(length, Util.delimiterOffset(length, str.length(), str, ":@"));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) obj).url, this.url);
    }

    public final int hashCode() {
        return this.url.hashCode();
    }

    public final String redact() {
        Builder builder;
        try {
            builder = new Builder();
            builder.parse$okhttp(this, "/...");
        } catch (IllegalArgumentException unused) {
            builder = null;
        }
        builder.encodedUsername = Companion.canonicalize$okhttp$default("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        builder.encodedPassword = Companion.canonicalize$okhttp$default("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", 251);
        return builder.build().url;
    }

    public final String toString() {
        return this.url;
    }

    public final URI uri() {
        String strSubstring;
        Builder builder = new Builder();
        String str = this.scheme;
        builder.scheme = str;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        int i = str.equals("http") ? 80 : str.equals("https") ? 443 : -1;
        int i2 = this.port;
        builder.port = i2 != i ? i2 : -1;
        ArrayList arrayList = builder.encodedPathSegments;
        arrayList.clear();
        arrayList.addAll(encodedPathSegments());
        String strEncodedQuery = encodedQuery();
        builder.encodedQueryNamesAndValues = strEncodedQuery != null ? Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(strEncodedQuery, 0, 0, " \"'<>#", 211)) : null;
        if (this.fragment == null) {
            strSubstring = null;
        } else {
            String str2 = this.url;
            strSubstring = str2.substring(StringsKt.indexOf$default(str2, '#', 0, 6) + 1);
        }
        builder.encodedFragment = strSubstring;
        String str3 = builder.host;
        builder.host = str3 != null ? Pattern.compile("[\"<>^`{|}]").matcher(str3).replaceAll("") : null;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.set(i3, Companion.canonicalize$okhttp$default((String) arrayList.get(i3), 0, 0, "[]", 227));
        }
        ArrayList arrayList2 = builder.encodedQueryNamesAndValues;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                String str4 = (String) arrayList2.get(i4);
                arrayList2.set(i4, str4 != null ? Companion.canonicalize$okhttp$default(str4, 0, 0, "\\^`{|}", 195) : null);
            }
        }
        String str5 = builder.encodedFragment;
        builder.encodedFragment = str5 != null ? Companion.canonicalize$okhttp$default(str5, 0, 0, " \"#<>\\^`{|}", 163) : null;
        String string = builder.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").matcher(string).replaceAll(""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }
}
