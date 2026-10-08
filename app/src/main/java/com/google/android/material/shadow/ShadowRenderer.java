package com.google.android.material.shadow;

import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ShadowRenderer {
    public final Paint cornerShadowPaint;
    public final Paint edgeShadowPaint;
    public final Path scratch = new Path();
    public final int shadowEndColor;
    public final int shadowMiddleColor;
    public final Paint shadowPaint;
    public final int shadowStartColor;
    public final Paint transparentPaint;
    public static final int[] edgeColors = new int[3];
    public static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    public static final int[] cornerColors = new int[4];
    public static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};

    public ShadowRenderer() {
        Paint paint = new Paint();
        this.transparentPaint = paint;
        Paint paint2 = new Paint();
        this.shadowPaint = paint2;
        this.shadowStartColor = ColorUtils.setAlphaComponent(-16777216, 68);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(-16777216, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(-16777216, 0);
        paint2.setColor(this.shadowStartColor);
        paint.setColor(0);
        Paint paint3 = new Paint(4);
        this.cornerShadowPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.edgeShadowPaint = new Paint(paint3);
    }
}
