package androidx.compose.foundation.layout;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Arrangement {
    public static final Arrangement$Center$1 SpaceBetween;
    public static final FlowRowOverflow Start = new FlowRowOverflow(6);
    public static final FlowRowOverflow End = new FlowRowOverflow(5);
    public static final FlowRowOverflow Top = new FlowRowOverflow(7);
    public static final FlowRowOverflow Bottom = new FlowRowOverflow(4);
    public static final Arrangement$Center$1 Center = new Arrangement$Center$1(0);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface Horizontal {
        void arrange(MeasureScope measureScope, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo112getSpacingD9Ej5fM();
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface Vertical {
        void arrange(int i, MeasureScope measureScope, int[] iArr, int[] iArr2);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo112getSpacingD9Ej5fM();
    }

    static {
        new Arrangement$Center$1(3);
        SpaceBetween = new Arrangement$Center$1(2);
        new Arrangement$Center$1(1);
    }

    public static void placeCenter$foundation_layout(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float f = (i - i3) / 2;
        if (!z) {
            int length = iArr.length;
            int i5 = 0;
            while (i2 < length) {
                int i6 = iArr[i2];
                iArr2[i5] = Math.round(f);
                f += i6;
                i2++;
                i5++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i7 = iArr[length2];
            iArr2[length2] = Math.round(f);
            f += i7;
        }
    }

    public static void placeLeftOrTop$foundation_layout(int[] iArr, int[] iArr2, boolean z) {
        int i = 0;
        if (!z) {
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                int i4 = iArr[i];
                iArr2[i2] = i3;
                i3 += i4;
                i++;
                i2++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i5 = iArr[length2];
            iArr2[length2] = i;
            i += i5;
        }
    }

    public static void placeRightOrBottom$foundation_layout(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        int i5 = i - i3;
        if (!z) {
            int length = iArr.length;
            int i6 = 0;
            while (i2 < length) {
                int i7 = iArr[i2];
                iArr2[i6] = i5;
                i5 += i7;
                i2++;
                i6++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i8 = iArr[length2];
            iArr2[length2] = i5;
            i5 += i8;
        }
    }

    public static void placeSpaceAround$foundation_layout(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float length = iArr.length == 0 ? 0.0f : (i - i3) / iArr.length;
        float f = length / 2;
        if (!z) {
            int length2 = iArr.length;
            int i5 = 0;
            while (i2 < length2) {
                int i6 = iArr[i2];
                iArr2[i5] = Math.round(f);
                f += i6 + length;
                i2++;
                i5++;
            }
            return;
        }
        int length3 = iArr.length;
        while (true) {
            length3--;
            if (-1 >= length3) {
                return;
            }
            int i7 = iArr[length3];
            iArr2[length3] = Math.round(f);
            f += i7 + length;
        }
    }

    public static void placeSpaceBetween$foundation_layout(int i, int[] iArr, int[] iArr2, boolean z) {
        if (iArr.length == 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float fMax = (i - i3) / Math.max(iArr.length - 1, 1);
        float f = (z && iArr.length == 1) ? fMax : 0.0f;
        if (z) {
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i5 = iArr[length];
                iArr2[length] = Math.round(f);
                f += i5 + fMax;
            }
            return;
        }
        int length2 = iArr.length;
        int i6 = 0;
        while (i2 < length2) {
            int i7 = iArr[i2];
            iArr2[i6] = Math.round(f);
            f += i7 + fMax;
            i2++;
            i6++;
        }
    }

    public static void placeSpaceEvenly$foundation_layout(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float length = (i - i3) / (iArr.length + 1);
        if (z) {
            float f = length;
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i5 = iArr[length2];
                iArr2[length2] = Math.round(f);
                f += i5 + length;
            }
            return;
        }
        int length3 = iArr.length;
        float f2 = length;
        int i6 = 0;
        while (i2 < length3) {
            int i7 = iArr[i2];
            iArr2[i6] = Math.round(f2);
            f2 += i7 + length;
            i2++;
            i6++;
        }
    }

    /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
    public static SpacedAligned m111spacedBy0680j_4(float f) {
        return new SpacedAligned(f, new ZslControlImpl$$ExternalSyntheticLambda0(7));
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SpacedAligned implements Horizontal, Vertical {
        public final ZslControlImpl$$ExternalSyntheticLambda0 alignment;
        public final float space;
        public final float spacing;

        public SpacedAligned(float f, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0) {
            this.space = f;
            this.alignment = zslControlImpl$$ExternalSyntheticLambda0;
            this.spacing = f;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public final void arrange(MeasureScope measureScope, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            int i2;
            if (iArr.length == 0) {
                return;
            }
            int iMo86roundToPx0680j_4 = measureScope.mo86roundToPx0680j_4(this.space);
            boolean z = layoutDirection == LayoutDirection.Rtl;
            if (z) {
                int length = iArr.length;
                int i3 = 0;
                int iMin = 0;
                int i4 = 0;
                while (i3 < length) {
                    int iMax = Math.max(0, i - iArr[i3]);
                    iArr2[i4] = iMax;
                    iMin = Math.min(iMo86roundToPx0680j_4, iMax);
                    i = iArr2[i4] - iMin;
                    i3++;
                    i4++;
                }
                i2 = i + iMin;
            } else {
                int length2 = iArr.length;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (i5 < length2) {
                    int i9 = iArr[i5];
                    int iMin2 = Math.min(i6, i - i9);
                    iArr2[i8] = iMin2;
                    int iMin3 = Math.min(iMo86roundToPx0680j_4, (i - iMin2) - i9);
                    int i10 = iArr2[i8] + i9 + iMin3;
                    i5++;
                    i7 = iMin3;
                    i6 = i10;
                    i8++;
                }
                i2 = i - (i6 - i7);
            }
            if (i2 > 0) {
                int iRound = Math.round((1 + (layoutDirection != LayoutDirection.Ltr ? (-1.0f) * (-1) : -1.0f)) * (i2 / 2.0f));
                if (z) {
                    iRound -= i2;
                }
                if (iRound != 0) {
                    int length3 = iArr2.length;
                    for (int i11 = 0; i11 < length3; i11++) {
                        iArr2[i11] = iArr2[i11] + iRound;
                    }
                }
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) obj;
            return Dp.m704equalsimpl0(this.space, spacedAligned.space) && this.alignment.equals(spacedAligned.alignment);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public final float mo112getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public final int hashCode() {
            int iFloatToIntBits = ((Float.floatToIntBits(this.space) * 31) + 1231) * 31;
            ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0 = this.alignment;
            return iFloatToIntBits + (zslControlImpl$$ExternalSyntheticLambda0 == null ? 0 : zslControlImpl$$ExternalSyntheticLambda0.hashCode());
        }

        public final String toString() {
            return "Arrangement#spacedAligned(" + ((Object) Dp.m705toStringimpl(this.space)) + ", " + this.alignment + ')';
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public final void arrange(int i, MeasureScope measureScope, int[] iArr, int[] iArr2) {
            arrange(measureScope, i, iArr, LayoutDirection.Ltr, iArr2);
        }
    }
}
