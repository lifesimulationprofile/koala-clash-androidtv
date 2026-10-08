package androidx.compose.ui.graphics.shadow;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Shadow {
    public final float alpha;
    public final int blendMode;
    public final Brush brush;
    public final long color;
    public final long offset;
    public final float radius;
    public final float spread;

    public Shadow(float f, float f2, long j, long j2, Brush brush, float f3, int i) {
        this.radius = f;
        this.spread = f2;
        this.offset = j;
        this.blendMode = i;
        if (brush instanceof SolidColor) {
            this.color = ((SolidColor) brush).value;
            this.brush = null;
        } else {
            this.color = j2;
            this.brush = brush;
        }
        this.alpha = RangesKt.coerceIn(f3, 0.0f, 1.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Shadow) {
            Shadow shadow = (Shadow) obj;
            if (Dp.m704equalsimpl0(this.radius, shadow.radius) && Dp.m704equalsimpl0(this.spread, shadow.spread) && this.offset == shadow.offset && this.alpha == shadow.alpha && this.blendMode == shadow.blendMode && Color.m435equalsimpl0(this.color, shadow.color) && Intrinsics.areEqual(this.brush, shadow.brush)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.spread, Float.floatToIntBits(this.radius) * 31, 31);
        long j = this.offset;
        int iM2 = (ImageAnalysis$$ExternalSyntheticLambda1.m(this.alpha, (((int) (j ^ (j >>> 32))) + iM) * 31, 31) + this.blendMode) * 31;
        int i = Color.$r8$clinit;
        int iM3 = ImageAnalysis$$ExternalSyntheticLambda1.m(iM2, 31, this.color);
        Brush brush = this.brush;
        return iM3 + (brush != null ? brush.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Shadow(radius=");
        sb.append((Object) Dp.m705toStringimpl(this.radius));
        sb.append(", spread=");
        sb.append((Object) Dp.m705toStringimpl(this.spread));
        sb.append(", offset=");
        sb.append((Object) DpOffset.m709toStringimpl(this.offset));
        sb.append(", alpha=");
        sb.append(this.alpha);
        sb.append(", blendMode=");
        sb.append((Object) BrushKt.m429toStringimpl(this.blendMode));
        sb.append(", color=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.color, sb, ", brush=");
        sb.append(this.brush);
        sb.append(')');
        return sb.toString();
    }

    public final Shadow transparentCopy$ui_graphics() {
        long j = Color.Transparent;
        if (j == 16) {
            j = Color.Black;
        }
        return new Shadow(this.radius, this.spread, this.offset, j, null, this.alpha, this.blendMode);
    }
}
