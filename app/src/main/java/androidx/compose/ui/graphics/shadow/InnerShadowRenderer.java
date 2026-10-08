package androidx.compose.ui.graphics.shadow;

import android.graphics.Bitmap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.CompositeShaderBrush;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InnerShadowRenderer extends ShadowRenderer {
    public CompositeShaderBrush compositeShader;
    public final AndroidPaint paint;
    public final Shadow shadow;
    public BrushKt$ShaderBrush$1 shadowMask;

    public InnerShadowRenderer(Shadow shadow, BrushKt brushKt) {
        super(brushKt);
        this.shadow = shadow;
        this.paint = BrushKt.Paint();
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: buildShadow-_SMYjrA */
    public final void mo498buildShadow_SMYjrA(LayoutNodeDrawScope layoutNodeDrawScope, long j, long j2, AndroidPath androidPath) {
        BrushKt$ShaderBrush$1 brushKt$ShaderBrush$1;
        AndroidImageBitmap androidImageBitmapM412ImageBitmapx__hDU$default;
        Shadow shadow = this.shadow;
        float fMo92toPx0680j_4 = layoutNodeDrawScope.mo92toPx0680j_4(shadow.radius);
        float fMo92toPx0680j_5 = layoutNodeDrawScope.mo92toPx0680j_4(shadow.spread);
        long j3 = shadow.offset;
        float fMo92toPx0680j_6 = layoutNodeDrawScope.mo92toPx0680j_4(DpOffset.m707getXD9Ej5fM(j3));
        float fMo92toPx0680j_7 = layoutNodeDrawScope.mo92toPx0680j_4(DpOffset.m708getYD9Ej5fM(j3));
        AndroidPaint androidPaint = this.paint;
        if (androidPath != null) {
            int iCeil = (int) Math.ceil(Float.intBitsToFloat((int) (j >> 32)));
            int iCeil2 = (int) Math.ceil(Float.intBitsToFloat((int) (j & 4294967295L)));
            if (fMo92toPx0680j_5 > 0.0f) {
                Rect bounds = androidPath.getBounds();
                float f = bounds.right - bounds.left;
                float f2 = bounds.bottom - bounds.top;
                androidImageBitmapM412ImageBitmapx__hDU$default = BrushKt.m412ImageBitmapx__hDU$default((int) Math.ceil(f), (int) Math.ceil(f2), 1);
                AndroidCanvas androidCanvasCanvas = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default);
                androidCanvasCanvas.drawPath(androidPath, androidPaint);
                androidCanvasCanvas.mo393clipRectN_I0leg(0.0f, 0.0f, f, f2, 1);
                AndroidPaint androidPaintM497configureShadowFoewPVk$default = BlurKt.m497configureShadowFoewPVk$default(androidPaint, 0, null, 5);
                androidPaintM497configureShadowFoewPVk$default.setStrokeWidth(fMo92toPx0680j_5 * 2.0f);
                Unit unit = Unit.INSTANCE;
                androidCanvasCanvas.drawPath(androidPath, androidPaintM497configureShadowFoewPVk$default);
            } else {
                androidImageBitmapM412ImageBitmapx__hDU$default = null;
            }
            int iCeil3 = ((int) Math.ceil(fMo92toPx0680j_4)) * 2;
            AndroidImageBitmap androidImageBitmapM412ImageBitmapx__hDU$default2 = BrushKt.m412ImageBitmapx__hDU$default(iCeil + iCeil3, iCeil2 + iCeil3, 1);
            Bitmap bitmap = androidImageBitmapM412ImageBitmapx__hDU$default2.bitmap;
            AndroidCanvas androidCanvasCanvas2 = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default2);
            if (androidImageBitmapM412ImageBitmapx__hDU$default != null) {
                androidCanvasCanvas2.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), BlurKt.m497configureShadowFoewPVk$default(androidPaint, 0, null, 15));
                androidCanvasCanvas2.mo397drawImaged4ec7I(androidImageBitmapM412ImageBitmapx__hDU$default, (((long) Float.floatToRawIntBits(fMo92toPx0680j_6)) << 32) | (((long) Float.floatToRawIntBits(fMo92toPx0680j_7)) & 4294967295L), BlurKt.m497configureShadowFoewPVk$default(androidPaint, 11, fMo92toPx0680j_4 > 0.0f ? Blur_androidKt.BlurFilter(fMo92toPx0680j_4) : null, 9));
                brushKt$ShaderBrush$1 = new BrushKt$ShaderBrush$1(BrushKt.m413ImageShaderF49vj9s$default(androidImageBitmapM412ImageBitmapx__hDU$default2));
            } else {
                androidCanvasCanvas2.save();
                androidCanvasCanvas2.translate(fMo92toPx0680j_6, fMo92toPx0680j_7);
                androidCanvasCanvas2.drawPath(androidPath, BlurKt.m497configureShadowFoewPVk$default(androidPaint, 0, fMo92toPx0680j_4 > 0.0f ? Blur_androidKt.BlurFilter(fMo92toPx0680j_4) : null, 11));
                androidCanvasCanvas2.restore();
                androidCanvasCanvas2.drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), BlurKt.m497configureShadowFoewPVk$default(androidPaint, 11, null, 13));
                brushKt$ShaderBrush$1 = new BrushKt$ShaderBrush$1(BrushKt.m413ImageShaderF49vj9s$default(androidImageBitmapM412ImageBitmapx__hDU$default2));
            }
        } else {
            int i = (int) (j >> 32);
            int i2 = (int) (j & 4294967295L);
            AndroidImageBitmap androidImageBitmapM412ImageBitmapx__hDU$default3 = BrushKt.m412ImageBitmapx__hDU$default((int) Math.ceil(Float.intBitsToFloat(i)), (int) Math.ceil(Float.intBitsToFloat(i2)), 1);
            AndroidCanvas androidCanvasCanvas3 = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default3);
            float f3 = fMo92toPx0680j_6 + fMo92toPx0680j_5;
            float f4 = fMo92toPx0680j_7 + fMo92toPx0680j_5;
            androidCanvasCanvas3.drawRoundRect(f3, f4, Math.max(f3, (Float.intBitsToFloat(i) + fMo92toPx0680j_6) - fMo92toPx0680j_5), Math.max(f4, (Float.intBitsToFloat(i2) + fMo92toPx0680j_7) - fMo92toPx0680j_5), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), BlurKt.m497configureShadowFoewPVk$default(androidPaint, 0, fMo92toPx0680j_4 > 0.0f ? Blur_androidKt.BlurFilter(fMo92toPx0680j_4) : null, 11));
            Bitmap bitmap2 = androidImageBitmapM412ImageBitmapx__hDU$default3.bitmap;
            androidCanvasCanvas3.drawRect(0.0f, 0.0f, bitmap2.getWidth(), bitmap2.getHeight(), BlurKt.m497configureShadowFoewPVk$default(androidPaint, 11, null, 13));
            brushKt$ShaderBrush$1 = new BrushKt$ShaderBrush$1(BrushKt.m413ImageShaderF49vj9s$default(androidImageBitmapM412ImageBitmapx__hDU$default3));
        }
        this.shadowMask = brushKt$ShaderBrush$1;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: onDrawShadow-MLmccfk */
    public final void mo499onDrawShadowMLmccfk(LayoutNodeDrawScope layoutNodeDrawScope, long j, AndroidPath androidPath, float f, BlendModeColorFilter blendModeColorFilter, Brush brush, int i) {
        Brush brush2 = this.shadowMask;
        if (brush2 != null) {
            Shadow shadow = this.shadow;
            Brush brush3 = shadow.brush;
            if (brush3 instanceof ShaderBrush) {
                CompositeShaderBrush compositeShaderBrush = this.compositeShader;
                if (compositeShaderBrush == null || !compositeShaderBrush.srcBrush.equals(brush3)) {
                    compositeShaderBrush = new CompositeShaderBrush(BrushKt.toShaderBrush(brush2), BrushKt.toShaderBrush(brush3));
                    this.compositeShader = compositeShaderBrush;
                }
                brush2 = compositeShaderBrush;
            }
            Brush brush4 = brush2;
            if (androidPath != null) {
                Modifier.CC.m312drawPathGBMwjPU$default(layoutNodeDrawScope, androidPath, brush4, f, null, blendModeColorFilter, i, 8);
            } else if (CornerRadius.m365equalsimpl0(j, 0L)) {
                Modifier.CC.m314drawRectAsUm42w$default(layoutNodeDrawScope, brush4, 0L, 0L, f, null, blendModeColorFilter, i, 22);
            } else {
                Modifier.CC.m316drawRoundRectZuiqVtQ$default(layoutNodeDrawScope, brush4, 0L, 0L, j, f, null, blendModeColorFilter, shadow.blendMode, 38);
            }
        }
    }
}
