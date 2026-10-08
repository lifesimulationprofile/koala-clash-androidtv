package kotlin.time;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Duration implements Comparable {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long INFINITE;
    public static final long NEG_INFINITE;
    public final long rawValue;

    static {
        int i = DurationJvmKt.$r8$clinit;
        INFINITE = DurationKt.durationOfMillis(4611686018427387903L);
        NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    public static final long m833addValuesMixedRangesUwyO8pc(long j, long j2) {
        long j3 = 1000000;
        long j4 = j2 / j3;
        long j5 = j + j4;
        if (-4611686018426L > j5 || j5 >= 4611686018427L) {
            return DurationKt.durationOfMillis(RangesKt.coerceIn(j5, -4611686018427387903L, 4611686018427387903L));
        }
        long j6 = ((j5 * j3) + (j2 - (j4 * j3))) << 1;
        int i = DurationJvmKt.$r8$clinit;
        return j6;
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    public static final void m834appendFractionalimpl(StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String strPadStart = StringsKt.padStart(String.valueOf(i2), i3);
            int i4 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                sb.append((CharSequence) strPadStart, 0, ((i4 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) strPadStart, 0, i6);
            }
        }
        sb.append(str);
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m835getNanosecondsComponentimpl(long j) {
        if (m836isInfiniteimpl(j)) {
            return 0;
        }
        return (int) ((((int) j) & 1) == 1 ? ((j >> 1) % ((long) 1000)) * ((long) 1000000) : (j >> 1) % ((long) 1000000000));
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m836isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m837plusLRDsOJo(long j, long j2) {
        if (m836isInfiniteimpl(j)) {
            if (!m836isInfiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m836isInfiniteimpl(j2)) {
            return j2;
        }
        int i = ((int) j) & 1;
        if (i != (((int) j2) & 1)) {
            return i == 1 ? m833addValuesMixedRangesUwyO8pc(j >> 1, j2 >> 1) : m833addValuesMixedRangesUwyO8pc(j2 >> 1, j >> 1);
        }
        long j3 = (j >> 1) + (j2 >> 1);
        if (i != 0) {
            return DurationKt.durationOfMillisNormalized(j3);
        }
        if (-4611686018426999999L > j3 || j3 >= 4611686018427000000L) {
            return DurationKt.durationOfMillis(j3 / ((long) 1000000));
        }
        long j4 = j3 << 1;
        int i2 = DurationJvmKt.$r8$clinit;
        return j4;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m838toLongimpl(long j, DurationUnit durationUnit) {
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return durationUnit.timeUnit.convert(j >> 1, ((((int) j) & 1) == 0 ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS).timeUnit);
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m839unaryMinusUwyO8pc(long j) {
        long j2 = ((-(j >> 1)) << 1) + ((long) (((int) j) & 1));
        int i = DurationJvmKt.$r8$clinit;
        return j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = ((Duration) obj).rawValue;
        long j2 = this.rawValue;
        long j3 = j2 ^ j;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j2, j);
        }
        int i = (((int) j2) & 1) - (((int) j) & 1);
        return j2 < 0 ? -i : i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Duration) {
            return this.rawValue == ((Duration) obj).rawValue;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.rawValue;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        long jM839unaryMinusUwyO8pc = this.rawValue;
        if (jM839unaryMinusUwyO8pc == 0) {
            return "0s";
        }
        if (jM839unaryMinusUwyO8pc == INFINITE) {
            return "Infinity";
        }
        if (jM839unaryMinusUwyO8pc == NEG_INFINITE) {
            return "-Infinity";
        }
        int i = 0;
        boolean z = jM839unaryMinusUwyO8pc < 0;
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('-');
        }
        if (jM839unaryMinusUwyO8pc < 0) {
            jM839unaryMinusUwyO8pc = m839unaryMinusUwyO8pc(jM839unaryMinusUwyO8pc);
        }
        long jM838toLongimpl = m838toLongimpl(jM839unaryMinusUwyO8pc, DurationUnit.DAYS);
        int iM838toLongimpl = m836isInfiniteimpl(jM839unaryMinusUwyO8pc) ? 0 : (int) (m838toLongimpl(jM839unaryMinusUwyO8pc, DurationUnit.HOURS) % ((long) 24));
        int iM838toLongimpl2 = m836isInfiniteimpl(jM839unaryMinusUwyO8pc) ? 0 : (int) (m838toLongimpl(jM839unaryMinusUwyO8pc, DurationUnit.MINUTES) % ((long) 60));
        int iM838toLongimpl3 = m836isInfiniteimpl(jM839unaryMinusUwyO8pc) ? 0 : (int) (m838toLongimpl(jM839unaryMinusUwyO8pc, DurationUnit.SECONDS) % ((long) 60));
        int iM835getNanosecondsComponentimpl = m835getNanosecondsComponentimpl(jM839unaryMinusUwyO8pc);
        boolean z2 = jM838toLongimpl != 0;
        boolean z3 = iM838toLongimpl != 0;
        boolean z4 = iM838toLongimpl2 != 0;
        boolean z5 = (iM838toLongimpl3 == 0 && iM835getNanosecondsComponentimpl == 0) ? false : true;
        if (z2) {
            sb.append(jM838toLongimpl);
            sb.append('d');
            i = 1;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM838toLongimpl);
            sb.append('h');
            i = i2;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM838toLongimpl2);
            sb.append('m');
            i = i3;
        }
        if (z5) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iM838toLongimpl3 != 0 || z2 || z3 || z4) {
                m834appendFractionalimpl(sb, iM838toLongimpl3, iM835getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM835getNanosecondsComponentimpl >= 1000000) {
                m834appendFractionalimpl(sb, iM835getNanosecondsComponentimpl / 1000000, iM835getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (iM835getNanosecondsComponentimpl >= 1000) {
                m834appendFractionalimpl(sb, iM835getNanosecondsComponentimpl / 1000, iM835getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(iM835getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (z && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }
}
