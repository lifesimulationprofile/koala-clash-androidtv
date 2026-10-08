package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import coil.network.HttpException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    public int backingBlendMode;
    public AndroidPaint backingComposePaint;
    public Brush brush;
    public Size brushSize;
    public DrawStyle drawStyle;
    public Color lastColor;
    public DerivedSnapshotState shaderState;
    public Shadow shadow;
    public TextDecoration textDecoration;

    public final AndroidPaint getComposePaint() {
        AndroidPaint androidPaint = this.backingComposePaint;
        if (androidPaint != null) {
            return androidPaint;
        }
        AndroidPaint androidPaint2 = new AndroidPaint(this);
        this.backingComposePaint = androidPaint2;
        return androidPaint2;
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m664setBlendModes9anfk8(int i) {
        if (i == this.backingBlendMode) {
            return;
        }
        getComposePaint().m403setBlendModes9anfk8(i);
        this.backingBlendMode = i;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0038  */
    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX INFO: renamed from: setBrush-12SF9DM, reason: not valid java name */
    public final void m665setBrush12SF9DM(final Brush brush, final long j, float f) {
        if (brush == null) {
            this.shaderState = null;
            this.brush = null;
            this.brushSize = null;
            setShader(null);
            return;
        }
        if (brush instanceof SolidColor) {
            m666setColor8_81llA(TextDrawStyleKt.m675modulateDxMtmZc(f, ((SolidColor) brush).value));
            return;
        }
        if (!(brush instanceof ShaderBrush)) {
            throw new HttpException();
        }
        if (Intrinsics.areEqual(this.brush, brush)) {
            Size size = this.brushSize;
            if (!(size == null ? false : Size.m384equalsimpl0(size.packedValue, j))) {
                if (j != 9205357640488583168L) {
                    this.brush = brush;
                    this.brushSize = new Size(j);
                    this.shaderState = Stack.derivedStateOf(new Function0() { // from class: androidx.compose.ui.text.platform.AndroidTextPaint$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ((ShaderBrush) brush).mo431createShaderuvyYCjk(j);
                        }
                    });
                }
            }
        } else {
            if (j != 9205357640488583168L) {
                this.brush = brush;
                this.brushSize = new Size(j);
                this.shaderState = Stack.derivedStateOf(new Function0() { // from class: androidx.compose.ui.text.platform.AndroidTextPaint$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ((ShaderBrush) brush).mo431createShaderuvyYCjk(j);
                    }
                });
            }
        }
        AndroidPaint composePaint = getComposePaint();
        DerivedSnapshotState derivedSnapshotState = this.shaderState;
        composePaint.setShader(derivedSnapshotState != null ? (Shader) derivedSnapshotState.getValue() : null);
        this.lastColor = null;
        AndroidTextPaint_androidKt.setAlpha(this, f);
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m666setColor8_81llA(long j) {
        Color color = this.lastColor;
        if (color == null ? false : Color.m435equalsimpl0(color.value, j)) {
            return;
        }
        if (j != 16) {
            this.lastColor = new Color(j);
            setColor(BrushKt.m426toArgb8_81llA(j));
            this.shaderState = null;
            this.brush = null;
            this.brushSize = null;
            setShader(null);
        }
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle == null || Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            return;
        }
        this.drawStyle = drawStyle;
        if (drawStyle.equals(Fill.INSTANCE)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new HttpException();
        }
        getComposePaint().m408setStylek9PVt8s(1);
        Stroke stroke = (Stroke) drawStyle;
        getComposePaint().setStrokeWidth(stroke.width);
        AndroidPaint composePaint = getComposePaint();
        composePaint.internalPaint.setStrokeMiter(stroke.miter);
        getComposePaint().m407setStrokeJoinWw9F2mQ(stroke.join);
        getComposePaint().m406setStrokeCapBeK7IIE(stroke.cap);
        getComposePaint().internalPaint.setPathEffect(null);
    }

    public final void setShadow(Shadow shadow) {
        if (shadow == null || Intrinsics.areEqual(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (shadow.equals(Shadow.None)) {
            clearShadowLayer();
            return;
        }
        Shadow shadow2 = this.shadow;
        float f = shadow2.blurRadius;
        if (f == 0.0f) {
            f = Float.MIN_VALUE;
        }
        setShadowLayer(f, Float.intBitsToFloat((int) (shadow2.offset >> 32)), Float.intBitsToFloat((int) (this.shadow.offset & 4294967295L)), BrushKt.m426toArgb8_81llA(this.shadow.color));
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration == null || Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        int i = textDecoration.mask;
        setUnderlineText((i | 1) == i);
        int i2 = this.textDecoration.mask;
        setStrikeThruText((i2 | 2) == i2);
    }
}
