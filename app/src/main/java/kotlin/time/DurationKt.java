package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DurationKt {
    public static final long access$parseDuration(String str) {
        DurationUnit durationUnit;
        long jDurationOfMillisNormalized;
        char cCharAt;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        int i = Duration.$r8$clinit;
        int i2 = 0;
        char cCharAt2 = str.charAt(0);
        char c = 1;
        int i3 = (cCharAt2 == '+' || cCharAt2 == '-') ? 1 : 0;
        boolean z = i3 > 0 && str.length() > 0 && CharsKt.equals(str.charAt(0), '-', false);
        if (length <= i3) {
            throw new IllegalArgumentException("No components");
        }
        if (str.charAt(i3) != 'P') {
            throw new IllegalArgumentException();
        }
        int i4 = i3 + 1;
        if (i4 == length) {
            throw new IllegalArgumentException();
        }
        DurationUnit durationUnit2 = null;
        char c2 = 0;
        long jM837plusLRDsOJo = 0;
        while (i4 < length) {
            if (str.charAt(i4) != 'T') {
                int i5 = i4;
                while (i5 < str.length() && (('0' <= (cCharAt = str.charAt(i5)) && cCharAt < ':') || StringsKt.contains$default("+-.", cCharAt))) {
                    i5++;
                }
                String strSubstring = str.substring(i4, i5);
                if (strSubstring.length() == 0) {
                    throw new IllegalArgumentException();
                }
                int length2 = strSubstring.length() + i4;
                if (length2 < 0 || length2 >= str.length()) {
                    throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring));
                }
                char cCharAt3 = str.charAt(length2);
                i4 = length2 + 1;
                if (c2 == 0) {
                    if (cCharAt3 != 'D') {
                        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + cCharAt3);
                    }
                    durationUnit = DurationUnit.DAYS;
                } else if (cCharAt3 == 'H') {
                    durationUnit = DurationUnit.HOURS;
                } else if (cCharAt3 == 'M') {
                    durationUnit = DurationUnit.MINUTES;
                } else {
                    if (cCharAt3 != 'S') {
                        throw new IllegalArgumentException("Invalid duration ISO time unit: " + cCharAt3);
                    }
                    durationUnit = DurationUnit.SECONDS;
                }
                if (durationUnit2 != null && durationUnit2.compareTo(durationUnit) <= 0) {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
                int iIndexOf$default = StringsKt.indexOf$default(strSubstring, '.', i2, 6);
                if (durationUnit != DurationUnit.SECONDS || iIndexOf$default <= 0) {
                    DurationUnit durationUnit3 = durationUnit;
                    jM837plusLRDsOJo = Duration.m837plusLRDsOJo(jM837plusLRDsOJo, toDuration(parseOverLongIsoComponent(strSubstring), durationUnit3));
                    durationUnit2 = durationUnit3;
                    c2 = c2;
                    c = c;
                } else {
                    long jM837plusLRDsOJo2 = Duration.m837plusLRDsOJo(jM837plusLRDsOJo, toDuration(parseOverLongIsoComponent(strSubstring.substring(i2, iIndexOf$default)), durationUnit));
                    double d = Double.parseDouble(strSubstring.substring(iIndexOf$default));
                    TimeUnit timeUnit = DurationUnit.NANOSECONDS.timeUnit;
                    TimeUnit timeUnit2 = durationUnit.timeUnit;
                    char c3 = c;
                    DurationUnit durationUnit4 = durationUnit;
                    long jConvert = timeUnit.convert(1L, timeUnit2);
                    double dConvert = jConvert > 0 ? jConvert * d : d / timeUnit2.convert(1L, timeUnit);
                    if (Double.isNaN(dConvert)) {
                        throw new IllegalArgumentException("Duration value cannot be NaN.");
                    }
                    long jRoundToLong = MathKt.roundToLong(dConvert);
                    if (-4611686018426999999L > jRoundToLong || jRoundToLong >= 4611686018427000000L) {
                        TimeUnit timeUnit3 = DurationUnit.MILLISECONDS.timeUnit;
                        long jConvert2 = timeUnit3.convert(1L, timeUnit2);
                        jDurationOfMillisNormalized = durationOfMillisNormalized(MathKt.roundToLong(jConvert2 > 0 ? d * jConvert2 : d / timeUnit2.convert(1L, timeUnit3)));
                    } else {
                        int i6 = Duration.$r8$clinit;
                        int i7 = DurationJvmKt.$r8$clinit;
                        jDurationOfMillisNormalized = jRoundToLong << c3;
                    }
                    jM837plusLRDsOJo = Duration.m837plusLRDsOJo(jM837plusLRDsOJo2, jDurationOfMillisNormalized);
                    c2 = c2;
                    c = c3;
                    durationUnit2 = durationUnit4;
                }
                i2 = 0;
            } else {
                if (c2 != 0 || (i4 = i4 + 1) == length) {
                    throw new IllegalArgumentException();
                }
                c2 = c;
            }
        }
        return z ? Duration.m839unaryMinusUwyO8pc(jM837plusLRDsOJo) : jM837plusLRDsOJo;
    }

    public static final long durationOfMillis(long j) {
        long j2 = (j << 1) + 1;
        int i = Duration.$r8$clinit;
        int i2 = DurationJvmKt.$r8$clinit;
        return j2;
    }

    public static final long durationOfMillisNormalized(long j) {
        if (-4611686018426L > j || j >= 4611686018427L) {
            return durationOfMillis(RangesKt.coerceIn(j, -4611686018427387903L, 4611686018427387903L));
        }
        long j2 = (j * ((long) 1000000)) << 1;
        int i = Duration.$r8$clinit;
        int i2 = DurationJvmKt.$r8$clinit;
        return j2;
    }

    public static final long parseOverLongIsoComponent(String str) {
        char cCharAt;
        int length = str.length();
        int i = (length <= 0 || !StringsKt.contains$default("+-", str.charAt(0))) ? 0 : 1;
        if (length - i > 16) {
            int i2 = i;
            while (true) {
                if (i >= length) {
                    if (length - i2 <= 16) {
                        break;
                    }
                    return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 == '0') {
                    if (i2 == i) {
                        i2++;
                    }
                } else if ('1' > cCharAt2 || cCharAt2 >= ':') {
                    break;
                }
                i++;
            }
        }
        return (!StringsKt__StringsJVMKt.startsWith(str, "+", false) || length <= 1 || '0' > (cCharAt = str.charAt(1)) || cCharAt >= ':') ? Long.parseLong(str) : Long.parseLong(StringsKt.drop(str, 1));
    }

    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m840shrinkKibmq7A(float f, long j) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f);
        return (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L);
    }

    public static final long toDuration(long j, DurationUnit durationUnit) {
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        TimeUnit timeUnit = durationUnit.timeUnit;
        TimeUnit timeUnit2 = durationUnit.timeUnit;
        long jConvert = timeUnit.convert(4611686018426999999L, durationUnit2.timeUnit);
        if ((-jConvert) > j || j > jConvert) {
            return durationOfMillis(RangesKt.coerceIn(DurationUnit.MILLISECONDS.timeUnit.convert(j, timeUnit2), -4611686018427387903L, 4611686018427387903L));
        }
        long jConvert2 = durationUnit2.timeUnit.convert(j, timeUnit2) << 1;
        int i = Duration.$r8$clinit;
        int i2 = DurationJvmKt.$r8$clinit;
        return jConvert2;
    }
}
