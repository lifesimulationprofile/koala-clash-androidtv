package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPaint {
    public int _blendMode = 3;
    public BlendModeColorFilter internalColorFilter;
    public final Paint internalPaint;
    public Shader internalShader;

    public AndroidPaint(Paint paint) {
        this.internalPaint = paint;
    }

    /* JADX INFO: renamed from: getStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m401getStrokeCapKaPHkGw() {
        Paint.Cap strokeCap = this.internalPaint.getStrokeCap();
        int i = strokeCap == null ? -1 : AndroidPaint_androidKt$WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    /* JADX INFO: renamed from: getStrokeJoin-LxFBmk8, reason: not valid java name */
    public final int m402getStrokeJoinLxFBmk8() {
        Paint.Join strokeJoin = this.internalPaint.getStrokeJoin();
        int i = strokeJoin == null ? -1 : AndroidPaint_androidKt$WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 2;
    }

    public final void setAlpha(float f) {
        this.internalPaint.setAlpha((int) Math.rint(f * 255.0f));
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m403setBlendModes9anfk8(int i) {
        if (this._blendMode == i) {
            return;
        }
        this._blendMode = i;
        int i2 = Build.VERSION.SDK_INT;
        Paint paint = this.internalPaint;
        if (i2 >= 29) {
            paint.setBlendMode(BrushKt.m424toAndroidBlendModes9anfk8(i));
        } else {
            paint.setXfermode(new PorterDuffXfermode(BrushKt.m428toPorterDuffModes9anfk8(i)));
        }
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m404setColor8_81llA(long j) {
        this.internalPaint.setColor(BrushKt.m426toArgb8_81llA(j));
    }

    public final void setColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.internalColorFilter = blendModeColorFilter;
        this.internalPaint.setColorFilter(blendModeColorFilter != null ? blendModeColorFilter.nativeColorFilter : null);
    }

    /* JADX INFO: renamed from: setFilterQuality-vDHp3xo, reason: not valid java name */
    public final void m405setFilterQualityvDHp3xo(int i) {
        this.internalPaint.setFilterBitmap(!(i == 0));
    }

    public final void setShader(Shader shader) {
        this.internalShader = shader;
        this.internalPaint.setShader(shader);
    }

    /* JADX INFO: renamed from: setStrokeCap-BeK7IIE, reason: not valid java name */
    public final void m406setStrokeCapBeK7IIE(int i) {
        Paint.Cap cap;
        if (i == 2) {
            cap = Paint.Cap.SQUARE;
        } else if (i == 1) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = i == 0 ? Paint.Cap.BUTT : Paint.Cap.BUTT;
        }
        this.internalPaint.setStrokeCap(cap);
    }

    /* JADX INFO: renamed from: setStrokeJoin-Ww9F2mQ, reason: not valid java name */
    public final void m407setStrokeJoinWw9F2mQ(int i) {
        Paint.Join join;
        if (i == 0) {
            join = Paint.Join.MITER;
        } else if (i == 2) {
            join = Paint.Join.BEVEL;
        } else {
            join = i == 1 ? Paint.Join.ROUND : Paint.Join.MITER;
        }
        this.internalPaint.setStrokeJoin(join);
    }

    public final void setStrokeWidth(float f) {
        this.internalPaint.setStrokeWidth(f);
    }

    /* JADX INFO: renamed from: setStyle-k9PVt8s, reason: not valid java name */
    public final void m408setStylek9PVt8s(int i) {
        this.internalPaint.setStyle(i == 1 ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
