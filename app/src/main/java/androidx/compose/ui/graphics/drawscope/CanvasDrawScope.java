package androidx.compose.ui.graphics.drawscope;

import android.graphics.Paint;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import androidx.navigation.NavController$handleDeepLink$2;
import coil.network.HttpException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {
    public final MenuHostHelper drawContext;
    public final DrawParams drawParams;
    public AndroidPaint fillPaint;
    public AndroidPaint strokePaint;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DrawParams {
        public Canvas canvas;
        public Density density;
        public LayoutDirection layoutDirection;
        public long size;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m384equalsimpl0(this.size, drawParams.size);
        }

        public final int hashCode() {
            int iHashCode = (this.canvas.hashCode() + ((this.layoutDirection.hashCode() + (this.density.hashCode() * 31)) * 31)) * 31;
            long j = this.size;
            return ((int) (j ^ (j >>> 32))) + iHashCode;
        }

        public final String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m390toStringimpl(this.size)) + ')';
        }
    }

    public CanvasDrawScope() {
        DrawParams drawParams = new DrawParams();
        drawParams.density = DrawContextKt.DefaultDensity;
        drawParams.layoutDirection = LayoutDirection.Ltr;
        drawParams.canvas = EmptyCanvas.INSTANCE;
        drawParams.size = 0L;
        this.drawParams = drawParams;
        this.drawContext = new MenuHostHelper(this);
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    public static AndroidPaint m460configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, int i) {
        AndroidPaint androidPaintSelectPaint = canvasDrawScope.selectPaint(drawStyle);
        if (f != 1.0f) {
            j = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), Color.m436getAlphaimpl(j) * f, Color.m438getColorSpaceimpl(j));
        }
        Paint paint = androidPaintSelectPaint.internalPaint;
        if (!Color.m435equalsimpl0(BrushKt.Color(paint.getColor()), j)) {
            androidPaintSelectPaint.m404setColor8_81llA(j);
        }
        if (androidPaintSelectPaint.internalShader != null) {
            androidPaintSelectPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(androidPaintSelectPaint.internalColorFilter, null)) {
            androidPaintSelectPaint.setColorFilter(null);
        }
        if (androidPaintSelectPaint._blendMode != i) {
            androidPaintSelectPaint.m403setBlendModes9anfk8(i);
        }
        if (paint.isFilterBitmap()) {
            return androidPaintSelectPaint;
        }
        androidPaintSelectPaint.m405setFilterQualityvDHp3xo(1);
        return androidPaintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    public final AndroidPaint m461configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f, BlendModeColorFilter blendModeColorFilter, int i, int i2) {
        AndroidPaint androidPaintSelectPaint = selectPaint(drawStyle);
        if (brush != null) {
            brush.mo411applyToPq9zytI(f, this.drawContext.m756getSizeNHjbRc(), androidPaintSelectPaint);
        } else {
            Paint paint = androidPaintSelectPaint.internalPaint;
            if (androidPaintSelectPaint.internalShader != null) {
                androidPaintSelectPaint.setShader(null);
            }
            long jColor = BrushKt.Color(paint.getColor());
            long j = Color.Black;
            if (!Color.m435equalsimpl0(jColor, j)) {
                androidPaintSelectPaint.m404setColor8_81llA(j);
            }
            if (paint.getAlpha() / 255.0f != f) {
                androidPaintSelectPaint.setAlpha(f);
            }
        }
        if (!Intrinsics.areEqual(androidPaintSelectPaint.internalColorFilter, blendModeColorFilter)) {
            androidPaintSelectPaint.setColorFilter(blendModeColorFilter);
        }
        if (androidPaintSelectPaint._blendMode != i) {
            androidPaintSelectPaint.m403setBlendModes9anfk8(i);
        }
        if (androidPaintSelectPaint.internalPaint.isFilterBitmap() == i2) {
            return androidPaintSelectPaint;
        }
        androidPaintSelectPaint.m405setFilterQualityvDHp3xo(i2);
        return androidPaintSelectPaint;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public final void mo462drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, DrawStyle drawStyle) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        this.drawParams.canvas.drawArc(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat(i2), f, f2, m460configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public final void mo463drawCircleVaOC9Bg(long j, float f, long j2, DrawStyle drawStyle) {
        this.drawParams.canvas.mo396drawCircle9KIMszo(f, j2, m460configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public final void mo464drawImageAZ2fEMs(AndroidImageBitmap androidImageBitmap, long j, long j2, long j3, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.drawParams.canvas.mo398drawImageRectHPBpro0(androidImageBitmap, j, j2, j3, m461configurePaintswdJneE(null, Fill.INSTANCE, f, blendModeColorFilter, 3, i));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public final void mo465drawImagegbVJVH8(AndroidImageBitmap androidImageBitmap, long j, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.drawParams.canvas.mo397drawImaged4ec7I(androidImageBitmap, j, m461configurePaintswdJneE(null, Fill.INSTANCE, f, blendModeColorFilter, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public final void mo466drawLineNGM6Ib0(long j, long j2, long j3, float f, int i) {
        Canvas canvas = this.drawParams.canvas;
        AndroidPaint androidPaintPaint = this.strokePaint;
        if (androidPaintPaint == null) {
            androidPaintPaint = BrushKt.Paint();
            androidPaintPaint.m408setStylek9PVt8s(1);
            this.strokePaint = androidPaintPaint;
        }
        Paint paint = androidPaintPaint.internalPaint;
        if (!Color.m435equalsimpl0(BrushKt.Color(paint.getColor()), j)) {
            androidPaintPaint.m404setColor8_81llA(j);
        }
        if (androidPaintPaint.internalShader != null) {
            androidPaintPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(androidPaintPaint.internalColorFilter, null)) {
            androidPaintPaint.setColorFilter(null);
        }
        if (androidPaintPaint._blendMode != 3) {
            androidPaintPaint.m403setBlendModes9anfk8(3);
        }
        if (paint.getStrokeWidth() != f) {
            androidPaintPaint.setStrokeWidth(f);
        }
        if (paint.getStrokeMiter() != 4.0f) {
            paint.setStrokeMiter(4.0f);
        }
        if (androidPaintPaint.m401getStrokeCapKaPHkGw() != i) {
            androidPaintPaint.m406setStrokeCapBeK7IIE(i);
        }
        if (androidPaintPaint.m402getStrokeJoinLxFBmk8() != 0) {
            androidPaintPaint.m407setStrokeJoinWw9F2mQ(0);
        }
        if (!paint.isFilterBitmap()) {
            androidPaintPaint.m405setFilterQualityvDHp3xo(1);
        }
        canvas.mo399drawLineWko1d7g(j2, j3, androidPaintPaint);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public final void mo467drawPathGBMwjPU(AndroidPath androidPath, Brush brush, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        this.drawParams.canvas.drawPath(androidPath, m461configurePaintswdJneE(brush, drawStyle, f, blendModeColorFilter, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public final void mo468drawPathLG529CI(AndroidPath androidPath, long j, DrawStyle drawStyle) {
        this.drawParams.canvas.drawPath(androidPath, m460configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public final void mo469drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        this.drawParams.canvas.drawRect(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (4294967295L & j2)) + Float.intBitsToFloat(i3), m461configurePaintswdJneE(brush, drawStyle, f, blendModeColorFilter, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public final void mo470drawRectnJ9OG0(long j, long j2, long j3, float f, int i) {
        int i2 = (int) (j2 >> 32);
        int i3 = (int) (j2 & 4294967295L);
        this.drawParams.canvas.drawRect(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (4294967295L & j3)) + Float.intBitsToFloat(i3), m460configurePaint2qPWKa0$default(this, j, Fill.INSTANCE, f, i));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public final void mo471drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        this.drawParams.canvas.drawRoundRect(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j2 & 4294967295L)) + Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), m461configurePaintswdJneE(brush, drawStyle, f, blendModeColorFilter, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public final void mo472drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        this.drawParams.canvas.drawRoundRect(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), m460configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final long mo473getCenterF1C5BW0() {
        return SizeKt.m391getCenteruvyYCjk(this.drawContext.m756getSizeNHjbRc());
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.drawParams.density.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final MenuHostHelper getDrawContext() {
        return this.drawContext;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.drawParams.density.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final LayoutDirection getLayoutDirection() {
        return this.drawParams.layoutDirection;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long mo474getSizeNHjbRc() {
        return this.drawContext.m756getSizeNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
    public final void mo475recordJVtK1S4(GraphicsLayer graphicsLayer, long j, Function1 function1) {
        graphicsLayer.m476recordmLhObY(this, this.drawParams.layoutDirection, j, new NavController$handleDeepLink$2(4, this, function1));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo86roundToPx0680j_4(float f) {
        return Density.CC.m695$default$roundToPx0680j_4(this, f);
    }

    public final AndroidPaint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            AndroidPaint androidPaint = this.fillPaint;
            if (androidPaint != null) {
                return androidPaint;
            }
            AndroidPaint androidPaintPaint = BrushKt.Paint();
            androidPaintPaint.m408setStylek9PVt8s(0);
            this.fillPaint = androidPaintPaint;
            return androidPaintPaint;
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new HttpException();
        }
        AndroidPaint androidPaintPaint2 = this.strokePaint;
        if (androidPaintPaint2 == null) {
            androidPaintPaint2 = BrushKt.Paint();
            androidPaintPaint2.m408setStylek9PVt8s(1);
            this.strokePaint = androidPaintPaint2;
        }
        Paint paint = androidPaintPaint2.internalPaint;
        float strokeWidth = paint.getStrokeWidth();
        Stroke stroke = (Stroke) drawStyle;
        float f = stroke.width;
        if (strokeWidth != f) {
            androidPaintPaint2.setStrokeWidth(f);
        }
        int iM401getStrokeCapKaPHkGw = androidPaintPaint2.m401getStrokeCapKaPHkGw();
        int i = stroke.cap;
        if (iM401getStrokeCapKaPHkGw != i) {
            androidPaintPaint2.m406setStrokeCapBeK7IIE(i);
        }
        float strokeMiter = paint.getStrokeMiter();
        float f2 = stroke.miter;
        if (strokeMiter != f2) {
            paint.setStrokeMiter(f2);
        }
        int iM402getStrokeJoinLxFBmk8 = androidPaintPaint2.m402getStrokeJoinLxFBmk8();
        int i2 = stroke.join;
        if (iM402getStrokeJoinLxFBmk8 == i2) {
            return androidPaintPaint2;
        }
        androidPaintPaint2.m407setStrokeJoinWw9F2mQ(i2);
        return androidPaintPaint2;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo87toDpGaN1DYA(long j) {
        return Density.CC.m696$default$toDpGaN1DYA(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo89toDpu2uoSUM(int i) {
        return i / getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo90toDpSizekrfVVM(long j) {
        return Density.CC.m697$default$toDpSizekrfVVM(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo91toPxR2X_6o(long j) {
        return Density.CC.m698$default$toPxR2X_6o(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo92toPx0680j_4(float f) {
        return getDensity() * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo93toSizeXkaWNTQ(long j) {
        return Density.CC.m699$default$toSizeXkaWNTQ(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo94toSpkPz2Gy4(float f) {
        return Density.CC.m700$default$toSp0xMU5do(this, mo88toDpu2uoSUM(f));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo88toDpu2uoSUM(float f) {
        return f / getDensity();
    }
}
