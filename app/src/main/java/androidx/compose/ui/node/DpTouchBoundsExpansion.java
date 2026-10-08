package androidx.compose.ui.node;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DpTouchBoundsExpansion {
    public final float bottom;
    public final float end;
    public final float start;
    public final float top;

    public DpTouchBoundsExpansion(float f, float f2, float f3, float f4) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        if (f < 0.0f) {
            InlineClassHelperKt.throwIllegalArgumentException("Left must be non-negative");
        }
        if (f2 < 0.0f) {
            InlineClassHelperKt.throwIllegalArgumentException("Top must be non-negative");
        }
        if (f3 < 0.0f) {
            InlineClassHelperKt.throwIllegalArgumentException("Right must be non-negative");
        }
        if (f4 >= 0.0f) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Bottom must be non-negative");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DpTouchBoundsExpansion)) {
            return false;
        }
        DpTouchBoundsExpansion dpTouchBoundsExpansion = (DpTouchBoundsExpansion) obj;
        return Dp.m704equalsimpl0(this.start, dpTouchBoundsExpansion.start) && Dp.m704equalsimpl0(this.top, dpTouchBoundsExpansion.top) && Dp.m704equalsimpl0(this.end, dpTouchBoundsExpansion.end) && Dp.m704equalsimpl0(this.bottom, dpTouchBoundsExpansion.bottom);
    }

    public final int hashCode() {
        return ((Float.floatToIntBits(this.bottom) + ImageAnalysis$$ExternalSyntheticLambda1.m(this.end, ImageAnalysis$$ExternalSyntheticLambda1.m(this.top, Float.floatToIntBits(this.start) * 31, 31), 31)) * 31) + 1231;
    }

    public final String toString() {
        return "DpTouchBoundsExpansion(start=" + ((Object) Dp.m705toStringimpl(this.start)) + ", top=" + ((Object) Dp.m705toStringimpl(this.top)) + ", end=" + ((Object) Dp.m705toStringimpl(this.end)) + ", bottom=" + ((Object) Dp.m705toStringimpl(this.bottom)) + ", isLayoutDirectionAware=true)";
    }
}
