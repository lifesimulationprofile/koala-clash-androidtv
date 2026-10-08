package dev.chrisbanes.haze;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidRenderEffect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.koala.clash.R;
import java.util.List;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RenderEffect_androidKt {
    public static Bitmap noiseTexture;

    /* JADX INFO: renamed from: blendWith-moWRBKg, reason: not valid java name */
    public static final RenderEffect m829blendWithmoWRBKg(RenderEffect renderEffect, RenderEffect renderEffect2, BlendMode blendMode, long j) {
        if ((9223372034707292159L & j) != 9205357640488583168L && !Offset.m369equalsimpl0(j, 0L)) {
            renderEffect2 = RenderEffect.createOffsetEffect(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), renderEffect2);
        }
        return RenderEffect.createBlendModeEffect(renderEffect, renderEffect2, blendMode);
    }

    public static final AndroidRenderEffect createRenderEffect(HazeEffectNode hazeEffectNode, RenderEffectParams renderEffectParams) {
        RenderEffect renderEffectCreateBlurEffect;
        RenderEffect renderEffectCreateColorFilterEffect;
        float f = renderEffectParams.scale;
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        float f2 = renderEffectParams.blurRadius * f;
        float f3 = 0;
        if (Dp.m703compareTo0680j_4(f2, f3) < 0) {
            throw new IllegalArgumentException("blurRadius needs to be equal or greater than 0.dp");
        }
        long jM389times7Ah8Wj8 = Size.m389times7Ah8Wj8(f, renderEffectParams.contentSize);
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((float) Math.ceil(Float.intBitsToFloat((int) (jM389times7Ah8Wj8 & 4294967295L))))) & 4294967295L) | (((long) Float.floatToRawIntBits((float) Math.ceil(Float.intBitsToFloat((int) (jM389times7Ah8Wj8 >> 32))))) << 32);
        long jM374timestuRUvjQ = Offset.m374timestuRUvjQ(f, renderEffectParams.contentOffset);
        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(MathKt.roundToInt(Float.intBitsToFloat((int) (jM374timestuRUvjQ & 4294967295L))))) & 4294967295L) | (((long) Float.floatToRawIntBits(MathKt.roundToInt(Float.intBitsToFloat((int) (jM374timestuRUvjQ >> 32))))) << 32);
        if (Dp.m703compareTo0680j_4(f2, f3) <= 0) {
            renderEffectCreateBlurEffect = RenderEffect.createOffsetEffect(0.0f, 0.0f);
        } else {
            try {
                float fMo92toPx0680j_4 = ((Density) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(f2);
                renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(fMo92toPx0680j_4, fMo92toPx0680j_4, BrushKt.m425toAndroidTileMode0vamqd0(renderEffectParams.blurTileMode));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Error whilst calling RenderEffect.createBlurEffect. This is likely because this device does not support a blur radius of ", Dp.m705toStringimpl(f2), "dp"), e);
            }
        }
        Context context = (Context) HitTestResultKt.currentValueOf(hazeEffectNode, AndroidCompositionLocals_androidKt.LocalContext);
        float f4 = renderEffectParams.noiseFactor;
        if (f4 >= 0.005f) {
            if (f <= 0.0f) {
                f = 1.0f;
            }
            Bitmap noiseTexture2 = getNoiseTexture(context);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            BitmapShader bitmapShader = new BitmapShader(noiseTexture2, tileMode, tileMode);
            if (Math.abs(f - 1.0f) >= 0.001f) {
                Matrix matrix = new Matrix();
                float f5 = 1.0f / f;
                matrix.setScale(f5, f5);
                bitmapShader.setLocalMatrix(matrix);
            }
            float fCoerceIn = RangesKt.coerceIn(f4, 0.0f, 1.0f);
            RenderEffect renderEffectCreateShaderEffect = RenderEffect.createShaderEffect(bitmapShader);
            if (fCoerceIn < 1.0f) {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setScale(1.0f, 1.0f, 1.0f, fCoerceIn);
                renderEffectCreateShaderEffect = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix), renderEffectCreateShaderEffect);
            }
            BlendMode blendMode = BlendMode.DST_ATOP;
            renderEffectCreateBlurEffect = RenderEffect.createBlendModeEffect(renderEffectCreateShaderEffect, renderEffectCreateBlurEffect, BlendMode.DST_ATOP);
        }
        List<HazeTint> list = renderEffectParams.tints;
        float f6 = renderEffectParams.tintAlphaModulate;
        for (HazeTint hazeTint : list) {
            boolean zIsSpecified = hazeTint.isSpecified();
            long jColor = hazeTint.color;
            int i = hazeTint.blendMode;
            if (zIsSpecified) {
                Brush brush = hazeTint.brush;
                Shader shaderMo431createShaderuvyYCjk = (brush == null || !(brush instanceof ShaderBrush)) ? null : ((ShaderBrush) brush).mo431createShaderuvyYCjk(jFloatToRawIntBits);
                if (shaderMo431createShaderuvyYCjk != null) {
                    if (f6 >= 1.0f) {
                        renderEffectCreateColorFilterEffect = RenderEffect.createShaderEffect(shaderMo431createShaderuvyYCjk);
                    } else {
                        long j = Color.Blue;
                        renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(BrushKt.m426toArgb8_81llA(BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), f6, Color.m438getColorSpaceimpl(j))), BlendMode.SRC_IN), RenderEffect.createShaderEffect(shaderMo431createShaderuvyYCjk));
                    }
                    renderEffectCreateBlurEffect = m829blendWithmoWRBKg(renderEffectCreateBlurEffect, renderEffectCreateColorFilterEffect, HazeKt.m828toAndroidBlendModes9anfk8(i), jFloatToRawIntBits2);
                } else {
                    if (f6 < 1.0f) {
                        jColor = BrushKt.Color(Color.m440getRedimpl(jColor), Color.m439getGreenimpl(jColor), Color.m437getBlueimpl(jColor), Color.m436getAlphaimpl(jColor) * f6, Color.m438getColorSpaceimpl(jColor));
                    }
                    if (Color.m436getAlphaimpl(jColor) >= 0.005f) {
                        renderEffectCreateBlurEffect = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(BrushKt.m426toArgb8_81llA(jColor), HazeKt.m828toAndroidBlendModes9anfk8(i)), renderEffectCreateBlurEffect);
                    }
                }
            }
        }
        Brush brush2 = renderEffectParams.mask;
        BlendMode blendMode2 = BlendMode.DST_IN;
        if (brush2 != null) {
            Shader shaderMo431createShaderuvyYCjk2 = brush2 instanceof ShaderBrush ? ((ShaderBrush) brush2).mo431createShaderuvyYCjk(jFloatToRawIntBits) : null;
            if (shaderMo431createShaderuvyYCjk2 != null) {
                renderEffectCreateBlurEffect = m829blendWithmoWRBKg(renderEffectCreateBlurEffect, RenderEffect.createShaderEffect(shaderMo431createShaderuvyYCjk2), blendMode2, jFloatToRawIntBits2);
            }
        }
        return new AndroidRenderEffect(renderEffectCreateBlurEffect);
    }

    public static final Bitmap getNoiseTexture(Context context) {
        Bitmap bitmap = noiseTexture;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.haze_noise);
        noiseTexture = bitmapDecodeResource;
        return bitmapDecodeResource;
    }
}
