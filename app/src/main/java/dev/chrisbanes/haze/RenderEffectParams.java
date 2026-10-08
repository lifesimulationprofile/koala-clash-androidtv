package dev.chrisbanes.haze;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RenderEffectParams {
    public final float blurRadius;
    public final int blurTileMode;
    public final long contentOffset;
    public final long contentSize;
    public final Brush mask;
    public final float noiseFactor;
    public final float scale;
    public final float tintAlphaModulate;
    public final List tints;

    public RenderEffectParams(float f, float f2, float f3, long j, long j2, List list, float f4, Brush brush, int i) {
        this.blurRadius = f;
        this.noiseFactor = f2;
        this.scale = f3;
        this.contentSize = j;
        this.contentOffset = j2;
        this.tints = list;
        this.tintAlphaModulate = f4;
        this.mask = brush;
        this.blurTileMode = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RenderEffectParams)) {
            return false;
        }
        RenderEffectParams renderEffectParams = (RenderEffectParams) obj;
        return Dp.m704equalsimpl0(this.blurRadius, renderEffectParams.blurRadius) && Float.compare(this.noiseFactor, renderEffectParams.noiseFactor) == 0 && Float.compare(this.scale, renderEffectParams.scale) == 0 && Size.m384equalsimpl0(this.contentSize, renderEffectParams.contentSize) && Offset.m369equalsimpl0(this.contentOffset, renderEffectParams.contentOffset) && Intrinsics.areEqual(this.tints, renderEffectParams.tints) && Float.compare(this.tintAlphaModulate, renderEffectParams.tintAlphaModulate) == 0 && Intrinsics.areEqual(this.mask, renderEffectParams.mask) && this.blurTileMode == renderEffectParams.blurTileMode;
    }

    public final int hashCode() {
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.scale, ImageAnalysis$$ExternalSyntheticLambda1.m(this.noiseFactor, Float.floatToIntBits(this.blurRadius) * 31, 31), 31);
        long j = this.contentSize;
        int iM2 = ImageAnalysis$$ExternalSyntheticLambda1.m(this.tintAlphaModulate, (this.tints.hashCode() + ((Offset.m371hashCodeimpl(this.contentOffset) + ((((int) (j ^ (j >>> 32))) + iM) * 31)) * 31)) * 31, 31);
        Brush brush = this.mask;
        return ((iM2 + (brush == null ? 0 : brush.hashCode())) * 961) + this.blurTileMode;
    }

    public final String toString() {
        String strM705toStringimpl = Dp.m705toStringimpl(this.blurRadius);
        String strM390toStringimpl = Size.m390toStringimpl(this.contentSize);
        String strM375toStringimpl = Offset.m375toStringimpl(this.contentOffset);
        String strM430toStringimpl$1 = BrushKt.m430toStringimpl$1(this.blurTileMode);
        StringBuilder sb = new StringBuilder("RenderEffectParams(blurRadius=");
        sb.append(strM705toStringimpl);
        sb.append(", noiseFactor=");
        sb.append(this.noiseFactor);
        sb.append(", scale=");
        sb.append(this.scale);
        sb.append(", contentSize=");
        sb.append(strM390toStringimpl);
        sb.append(", contentOffset=");
        sb.append(strM375toStringimpl);
        sb.append(", tints=");
        sb.append(this.tints);
        sb.append(", tintAlphaModulate=");
        sb.append(this.tintAlphaModulate);
        sb.append(", mask=");
        sb.append(this.mask);
        sb.append(", progressive=null, blurTileMode=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, strM430toStringimpl$1, ")");
    }
}
