package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LineHeightStyle {
    public static final LineHeightStyle Default = new LineHeightStyle(Alignment.Proportional, 17, 0);
    public final float alignment;
    public final int mode;
    public final int trim;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Alignment {
        public static final float Bottom;
        public static final float Center;
        public static final float Proportional;
        public final float topRatio;

        static {
            m671constructorimpl(0.0f);
            m671constructorimpl(0.5f);
            Center = 0.5f;
            m671constructorimpl(-1.0f);
            Proportional = -1.0f;
            m671constructorimpl(1.0f);
            Bottom = 1.0f;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static void m671constructorimpl(float f) {
            if ((0.0f > f || f > 1.0f) && f != -1.0f) {
                InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
            }
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m672toStringimpl(float f) {
            if (f == 0.0f) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f == Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f + ')';
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Alignment) {
                return Float.compare(this.topRatio, ((Alignment) obj).topRatio) == 0;
            }
            return false;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.topRatio);
        }

        public final String toString() {
            return m672toStringimpl(this.topRatio);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Mode {
        public final int value;

        public final boolean equals(Object obj) {
            if (obj instanceof Mode) {
                return this.value == ((Mode) obj).value;
            }
            return false;
        }

        public final int hashCode() {
            return this.value;
        }

        public final String toString() {
            int i = this.value;
            if (i == 0) {
                return "LineHeightStyle.Mode.Fixed";
            }
            if (i == 1) {
                return "LineHeightStyle.Mode.Minimum";
            }
            return i == 2 ? "LineHeightStyle.Mode.Tight" : "Invalid";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Trim {
        public final int value;

        public final boolean equals(Object obj) {
            if (obj instanceof Trim) {
                return this.value == ((Trim) obj).value;
            }
            return false;
        }

        public final int hashCode() {
            return this.value;
        }

        public final String toString() {
            int i = this.value;
            if (i == 1) {
                return "LineHeightStyle.Trim.FirstLineTop";
            }
            if (i == 16) {
                return "LineHeightStyle.Trim.LastLineBottom";
            }
            if (i == 17) {
                return "LineHeightStyle.Trim.Both";
            }
            return i == 0 ? "LineHeightStyle.Trim.None" : "Invalid";
        }
    }

    public LineHeightStyle(float f, int i, int i2) {
        this.alignment = f;
        this.trim = i;
        this.mode = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        float f = lineHeightStyle.alignment;
        float f2 = Alignment.Center;
        return Float.compare(this.alignment, f) == 0 && this.trim == lineHeightStyle.trim && this.mode == lineHeightStyle.mode;
    }

    public final int hashCode() {
        float f = Alignment.Center;
        return (((Float.floatToIntBits(this.alignment) * 31) + this.trim) * 31) + this.mode;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("LineHeightStyle(alignment=");
        sb.append((Object) Alignment.m672toStringimpl(this.alignment));
        sb.append(", trim=");
        String str2 = "Invalid";
        int i = this.trim;
        if (i == 1) {
            str = "LineHeightStyle.Trim.FirstLineTop";
        } else if (i == 16) {
            str = "LineHeightStyle.Trim.LastLineBottom";
        } else if (i == 17) {
            str = "LineHeightStyle.Trim.Both";
        } else {
            str = i == 0 ? "LineHeightStyle.Trim.None" : "Invalid";
        }
        sb.append((Object) str);
        sb.append(",mode=");
        int i2 = this.mode;
        if (i2 == 0) {
            str2 = "LineHeightStyle.Mode.Fixed";
        } else if (i2 == 1) {
            str2 = "LineHeightStyle.Mode.Minimum";
        } else if (i2 == 2) {
            str2 = "LineHeightStyle.Mode.Tight";
        }
        sb.append((Object) str2);
        sb.append(')');
        return sb.toString();
    }
}
