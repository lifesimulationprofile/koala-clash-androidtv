package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import androidx.core.graphics.ColorUtils;
import com.google.android.gms.internal.mlkit_vision_common.zzln;
import com.google.android.material.color.MaterialColors;
import com.koala.clash.R;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ElevationOverlayProvider {
    public static final int OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    public final int colorSurface;
    public final float displayDensity;
    public final int elevationOverlayAccentColor;
    public final int elevationOverlayColor;
    public final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        TypedValue typedValueResolve = zzln.resolve(context, R.attr.elevationOverlayEnabled);
        boolean z = (typedValueResolve == null || typedValueResolve.type != 18 || typedValueResolve.data == 0) ? false : true;
        int color = MaterialColors.getColor(context, R.attr.elevationOverlayColor, 0);
        int color2 = MaterialColors.getColor(context, R.attr.elevationOverlayAccentColor, 0);
        int color3 = MaterialColors.getColor(context, R.attr.colorSurface, 0);
        float f = context.getResources().getDisplayMetrics().density;
        this.elevationOverlayEnabled = z;
        this.elevationOverlayColor = color;
        this.elevationOverlayAccentColor = color2;
        this.colorSurface = color3;
        this.displayDensity = f;
    }

    public final int compositeOverlayIfNeeded(int i, float f) {
        int i2;
        if (!this.elevationOverlayEnabled || ColorUtils.setAlphaComponent(i, 255) != this.colorSurface) {
            return i;
        }
        float f2 = this.displayDensity;
        float fMin = (f2 <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / f2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iLayer = MaterialColors.layer(fMin, ColorUtils.setAlphaComponent(i, 255), this.elevationOverlayColor);
        if (fMin > 0.0f && (i2 = this.elevationOverlayAccentColor) != 0) {
            iLayer = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, OVERLAY_ACCENT_COLOR_ALPHA), iLayer);
        }
        return ColorUtils.setAlphaComponent(iLayer, iAlpha);
    }
}
