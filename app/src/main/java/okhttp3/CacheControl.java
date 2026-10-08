package okhttp3;

import androidx.compose.ui.graphics.vector.ImageVector;
import java.util.concurrent.TimeUnit;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CacheControl {
    public static final CacheControl FORCE_CACHE;
    public static final CacheControl FORCE_NETWORK = new CacheControl(true, false, -1, -1, false, false, false, -1, -1, false, false, false, null);
    public String headerValue;
    public final boolean immutable;
    public final boolean isPrivate;
    public final boolean isPublic;
    public final int maxAgeSeconds;
    public final int maxStaleSeconds;
    public final int minFreshSeconds;
    public final boolean mustRevalidate;
    public final boolean noCache;
    public final boolean noStore;
    public final boolean noTransform;
    public final boolean onlyIfCached;
    public final int sMaxAgeSeconds;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static ImageVector _adb;

        /* JADX WARN: Code duplicated, block: B:108:0x0062 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:109:0x0068 A[EDGE_INSN: B:109:0x0068->B:22:0x0068 BREAK  A[LOOP:2: B:16:0x004a->B:20:0x005b], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:15:0x0043  */
        /* JADX WARN: Code duplicated, block: B:17:0x004c  */
        /* JADX WARN: Code duplicated, block: B:20:0x005b A[LOOP:2: B:16:0x004a->B:20:0x005b, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:51:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:54:0x0103  */
        /* JADX WARN: Code duplicated, block: B:56:0x010d  */
        /* JADX WARN: Code duplicated, block: B:58:0x0115  */
        /* JADX WARN: Code duplicated, block: B:59:0x011c  */
        /* JADX WARN: Code duplicated, block: B:61:0x0124  */
        /* JADX WARN: Code duplicated, block: B:63:0x012f  */
        /* JADX WARN: Code duplicated, block: B:65:0x0138  */
        /* JADX WARN: Code duplicated, block: B:66:0x013d  */
        /* JADX WARN: Code duplicated, block: B:68:0x0145  */
        /* JADX WARN: Code duplicated, block: B:69:0x014c  */
        /* JADX WARN: Code duplicated, block: B:71:0x0154  */
        /* JADX WARN: Code duplicated, block: B:72:0x015b  */
        /* JADX WARN: Code duplicated, block: B:74:0x0163  */
        /* JADX WARN: Code duplicated, block: B:75:0x016a  */
        /* JADX WARN: Code duplicated, block: B:77:0x0172  */
        /* JADX WARN: Code duplicated, block: B:78:0x017a  */
        /* JADX WARN: Code duplicated, block: B:80:0x0182  */
        /* JADX WARN: Code duplicated, block: B:81:0x0188  */
        /* JADX WARN: Code duplicated, block: B:83:0x0191  */
        /* JADX WARN: Code duplicated, block: B:84:0x019a  */
        /* JADX WARN: Code duplicated, block: B:86:0x01a2  */
        /* JADX WARN: Code duplicated, block: B:87:0x01ab  */
        /* JADX WARN: Code duplicated, block: B:89:0x01b3  */
        public static CacheControl parse(Headers headers) {
            int i;
            int length;
            boolean z;
            int length2;
            int i2;
            String string;
            String string2;
            Headers headers2 = headers;
            int size = headers2.size();
            boolean z2 = true;
            boolean z3 = true;
            int i3 = 0;
            String str = null;
            boolean z4 = false;
            boolean z5 = false;
            int nonNegativeInt = -1;
            int nonNegativeInt2 = -1;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int nonNegativeInt3 = -1;
            int nonNegativeInt4 = -1;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            while (i3 < size) {
                String strName = headers2.name(i3);
                String strValue = headers2.value(i3);
                if (StringsKt__StringsJVMKt.equals(strName, "Cache-Control", z2)) {
                    if (str == null) {
                        str = strValue;
                    }
                    i = 0;
                    while (i < strValue.length()) {
                        length = strValue.length();
                        z = z2;
                        length2 = i;
                        while (true) {
                            if (length2 < length) {
                                i2 = size;
                                length2 = strValue.length();
                                break;
                            }
                            i2 = size;
                            if (StringsKt.contains$default("=,;", strValue.charAt(length2))) {
                                break;
                            }
                            length2++;
                            size = i2;
                        }
                        string = StringsKt.trim(strValue.substring(i, length2)).toString();
                        if (length2 != strValue.length() || strValue.charAt(length2) == ',' || strValue.charAt(length2) == ';') {
                            i = length2 + 1;
                            string2 = null;
                        } else {
                            int length3 = length2 + 1;
                            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                            int length4 = strValue.length();
                            while (true) {
                                if (length3 < length4) {
                                    char cCharAt = strValue.charAt(length3);
                                    if (cCharAt != ' ' && cCharAt != '\t') {
                                        break;
                                    }
                                    length3++;
                                } else {
                                    length3 = strValue.length();
                                    break;
                                }
                            }
                            if (length3 >= strValue.length() || strValue.charAt(length3) != '\"') {
                                int length5 = strValue.length();
                                int length6 = length3;
                                while (true) {
                                    if (length6 >= length5) {
                                        length6 = strValue.length();
                                        break;
                                    }
                                    int i4 = length5;
                                    if (StringsKt.contains$default(",;", strValue.charAt(length6))) {
                                        break;
                                    }
                                    length6++;
                                    length5 = i4;
                                }
                                int i5 = length6;
                                string2 = StringsKt.trim(strValue.substring(length3, length6)).toString();
                                i = i5;
                            } else {
                                int i6 = length3 + 1;
                                int iIndexOf$default = StringsKt.indexOf$default(strValue, '\"', i6, 4);
                                string2 = strValue.substring(i6, iIndexOf$default);
                                i = iIndexOf$default + 1;
                            }
                        }
                        if ("no-cache".equalsIgnoreCase(string)) {
                            z2 = z;
                            z4 = z2;
                        } else if ("no-store".equalsIgnoreCase(string)) {
                            z2 = z;
                            z5 = z2;
                        } else {
                            if ("max-age".equalsIgnoreCase(string)) {
                                nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                            } else if ("s-maxage".equalsIgnoreCase(string)) {
                                nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                            } else if ("private".equalsIgnoreCase(string)) {
                                z2 = z;
                                z6 = z2;
                            } else if ("public".equalsIgnoreCase(string)) {
                                z2 = z;
                                z7 = z2;
                            } else if ("must-revalidate".equalsIgnoreCase(string)) {
                                z2 = z;
                                z8 = z2;
                            } else if ("max-stale".equalsIgnoreCase(string)) {
                                nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                            } else if ("min-fresh".equalsIgnoreCase(string)) {
                                nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                            } else if ("only-if-cached".equalsIgnoreCase(string)) {
                                z2 = z;
                                z9 = z2;
                            } else if ("no-transform".equalsIgnoreCase(string)) {
                                z2 = z;
                                z10 = z2;
                            } else if ("immutable".equalsIgnoreCase(string)) {
                                z2 = z;
                                z11 = z2;
                            }
                            z2 = z;
                        }
                        size = i2;
                    }
                    i3++;
                    headers2 = headers;
                    z2 = z2;
                    size = size;
                } else {
                    if (StringsKt__StringsJVMKt.equals(strName, "Pragma", z2)) {
                    }
                    i3++;
                    headers2 = headers;
                    z2 = z2;
                    size = size;
                }
                z3 = false;
                i = 0;
                while (i < strValue.length()) {
                    length = strValue.length();
                    z = z2;
                    length2 = i;
                    while (true) {
                        if (length2 < length) {
                            i2 = size;
                            length2 = strValue.length();
                            break;
                        }
                        i2 = size;
                        if (StringsKt.contains$default("=,;", strValue.charAt(length2))) {
                            break;
                            break;
                        }
                        length2++;
                        size = i2;
                    }
                    string = StringsKt.trim(strValue.substring(i, length2)).toString();
                    if (length2 != strValue.length()) {
                        i = length2 + 1;
                        string2 = null;
                    } else {
                        i = length2 + 1;
                        string2 = null;
                    }
                    if ("no-cache".equalsIgnoreCase(string)) {
                        z2 = z;
                        z4 = z2;
                    } else if ("no-store".equalsIgnoreCase(string)) {
                        z2 = z;
                        z5 = z2;
                    } else {
                        if ("max-age".equalsIgnoreCase(string)) {
                            nonNegativeInt = Util.toNonNegativeInt(string2, -1);
                        } else if ("s-maxage".equalsIgnoreCase(string)) {
                            nonNegativeInt2 = Util.toNonNegativeInt(string2, -1);
                        } else if ("private".equalsIgnoreCase(string)) {
                            z2 = z;
                            z6 = z2;
                        } else if ("public".equalsIgnoreCase(string)) {
                            z2 = z;
                            z7 = z2;
                        } else if ("must-revalidate".equalsIgnoreCase(string)) {
                            z2 = z;
                            z8 = z2;
                        } else if ("max-stale".equalsIgnoreCase(string)) {
                            nonNegativeInt3 = Util.toNonNegativeInt(string2, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(string)) {
                            nonNegativeInt4 = Util.toNonNegativeInt(string2, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(string)) {
                            z2 = z;
                            z9 = z2;
                        } else if ("no-transform".equalsIgnoreCase(string)) {
                            z2 = z;
                            z10 = z2;
                        } else if ("immutable".equalsIgnoreCase(string)) {
                            z2 = z;
                            z11 = z2;
                        }
                        z2 = z;
                    }
                    size = i2;
                }
                i3++;
                headers2 = headers;
                z2 = z2;
                size = size;
            }
            return new CacheControl(z4, z5, nonNegativeInt, nonNegativeInt2, z6, z7, z8, nonNegativeInt3, nonNegativeInt4, z9, z10, z11, !z3 ? null : str);
        }
    }

    static {
        long seconds = TimeUnit.SECONDS.toSeconds(Integer.MAX_VALUE);
        FORCE_CACHE = new CacheControl(false, false, -1, -1, false, false, false, seconds <= 2147483647L ? (int) seconds : Integer.MAX_VALUE, -1, true, false, false, null);
    }

    public CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    public final String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        int i = this.maxAgeSeconds;
        if (i != -1) {
            sb.append("max-age=");
            sb.append(i);
            sb.append(", ");
        }
        int i2 = this.sMaxAgeSeconds;
        if (i2 != -1) {
            sb.append("s-maxage=");
            sb.append(i2);
            sb.append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        int i3 = this.maxStaleSeconds;
        if (i3 != -1) {
            sb.append("max-stale=");
            sb.append(i3);
            sb.append(", ");
        }
        int i4 = this.minFreshSeconds;
        if (i4 != -1) {
            sb.append("min-fresh=");
            sb.append(i4);
            sb.append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (this.immutable) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        this.headerValue = string;
        return string;
    }
}
