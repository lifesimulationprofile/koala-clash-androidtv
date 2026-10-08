package androidx.compose.ui.graphics.colorspace;

import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda0 implements DoubleFunction {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Rgb f$0;

    public /* synthetic */ Rgb$$ExternalSyntheticLambda0(Rgb rgb, int i) {
        this.$r8$classId = i;
        this.f$0 = rgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        switch (this.$r8$classId) {
            case 0:
                Rgb rgb = this.f$0;
                return RangesKt.coerceIn(rgb.oetfOrig.invoke(d), rgb.min, rgb.max);
            default:
                Rgb rgb2 = this.f$0;
                return rgb2.eotfOrig.invoke(RangesKt.coerceIn(d, rgb2.min, rgb2.max));
        }
    }
}
