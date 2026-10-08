package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import coil.request.Parameters;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Painter {
    public BlendModeColorFilter colorFilter;
    public AndroidPaint layerPaint;
    public float alpha = 1.0f;
    public LayoutDirection layoutDirection = LayoutDirection.Ltr;

    public abstract void applyAlpha(float f);

    public abstract void applyColorFilter(BlendModeColorFilter blendModeColorFilter);

    /* JADX INFO: renamed from: draw-x_KDEd0, reason: not valid java name */
    public final void m495drawx_KDEd0(LayoutNodeDrawScope layoutNodeDrawScope, long j, float f, BlendModeColorFilter blendModeColorFilter) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        if (this.alpha != f) {
            applyAlpha(f);
            this.alpha = f;
        }
        if (!Intrinsics.areEqual(this.colorFilter, blendModeColorFilter)) {
            applyColorFilter(blendModeColorFilter);
            this.colorFilter = blendModeColorFilter;
        }
        LayoutDirection layoutDirection = layoutNodeDrawScope.getLayoutDirection();
        if (this.layoutDirection != layoutDirection) {
            applyLayoutDirection(layoutDirection);
            this.layoutDirection = layoutDirection;
        }
        int i = (int) (j >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (layoutNodeDrawScope.mo474getSizeNHjbRc() >> 32)) - Float.intBitsToFloat(i);
        int i2 = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (layoutNodeDrawScope.mo474getSizeNHjbRc() & 4294967295L)) - Float.intBitsToFloat(i2);
        ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).inset(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2);
        if (f > 0.0f) {
            try {
                if (Float.intBitsToFloat(i) > 0.0f && Float.intBitsToFloat(i2) > 0.0f) {
                    onDraw(layoutNodeDrawScope);
                }
            } finally {
                ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).inset(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
            }
        }
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public abstract long mo492getIntrinsicSizeNHjbRc();

    public abstract void onDraw(LayoutNodeDrawScope layoutNodeDrawScope);

    public void applyLayoutDirection(LayoutDirection layoutDirection) {
    }
}
