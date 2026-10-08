package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectionMagnifierKt {
    public static final SpringSpec MagnifierSpringSpec;
    public static final long OffsetDisplacementThreshold;
    public static final AnimationVector2D UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);
    public static final TwoWayConverterImpl UnspecifiedSafeOffsetVectorConverter = new TwoWayConverterImpl(new SaversKt$$ExternalSyntheticLambda10(3), new SaversKt$$ExternalSyntheticLambda10(4));

    static {
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.01f)) << 32) | (((long) Float.floatToRawIntBits(0.01f)) & 4294967295L);
        OffsetDisplacementThreshold = jFloatToRawIntBits;
        MagnifierSpringSpec = new SpringSpec(new Offset(jFloatToRawIntBits));
    }
}
