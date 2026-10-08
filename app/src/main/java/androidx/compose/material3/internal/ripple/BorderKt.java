package androidx.compose.material3.internal.ripple;

import androidx.compose.ui.geometry.RoundRect;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BorderKt {
    public static final RoundRect createInsetRoundedRect(float f, RoundRect roundRect) {
        return new RoundRect(f, f, roundRect.getWidth() - f, roundRect.getHeight() - f, m284shrinkKibmq7A(f, roundRect.topLeftCornerRadius), m284shrinkKibmq7A(f, roundRect.topRightCornerRadius), m284shrinkKibmq7A(f, roundRect.bottomRightCornerRadius), m284shrinkKibmq7A(f, roundRect.bottomLeftCornerRadius));
    }

    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m284shrinkKibmq7A(float f, long j) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f);
        return (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L);
    }
}
