package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {
    public static final int[][] ENABLED_CHECKED_STATES = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public final ElevationOverlayProvider elevationOverlayProvider;
    public ColorStateList materialThemeColorsThumbTintList;
    public ColorStateList materialThemeColorsTrackTintList;
    public boolean useMaterialThemeColors;

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, com.koala.clash.R.attr.switchStyle, com.koala.clash.R.style.Widget_MaterialComponents_CompoundButton_Switch), attributeSet);
        Context context2 = getContext();
        this.elevationOverlayProvider = new ElevationOverlayProvider(context2);
        ViewUtils.checkCompatibleTheme(context2, attributeSet, com.koala.clash.R.attr.switchStyle, com.koala.clash.R.style.Widget_MaterialComponents_CompoundButton_Switch);
        int[] iArr = R$styleable.SwitchMaterial;
        ViewUtils.checkTextAppearance(context2, attributeSet, iArr, com.koala.clash.R.attr.switchStyle, com.koala.clash.R.style.Widget_MaterialComponents_CompoundButton_Switch, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.koala.clash.R.attr.switchStyle, com.koala.clash.R.style.Widget_MaterialComponents_CompoundButton_Switch);
        this.useMaterialThemeColors = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.materialThemeColorsThumbTintList == null) {
            int color = MaterialColors.getColor(this, com.koala.clash.R.attr.colorSurface);
            int color2 = MaterialColors.getColor(this, com.koala.clash.R.attr.colorControlActivated);
            float dimension = getResources().getDimension(com.koala.clash.R.dimen.mtrl_switch_thumb_elevation);
            ElevationOverlayProvider elevationOverlayProvider = this.elevationOverlayProvider;
            if (elevationOverlayProvider.elevationOverlayEnabled) {
                float elevation = 0.0f;
                for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    elevation += ViewCompat.Api21Impl.getElevation((View) parent);
                }
                dimension += elevation;
            }
            int iCompositeOverlayIfNeeded = elevationOverlayProvider.compositeOverlayIfNeeded(color, dimension);
            this.materialThemeColorsThumbTintList = new ColorStateList(ENABLED_CHECKED_STATES, new int[]{MaterialColors.layer(1.0f, color, color2), iCompositeOverlayIfNeeded, MaterialColors.layer(0.38f, color, color2), iCompositeOverlayIfNeeded});
        }
        return this.materialThemeColorsThumbTintList;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.materialThemeColorsTrackTintList == null) {
            int color = MaterialColors.getColor(this, com.koala.clash.R.attr.colorSurface);
            int color2 = MaterialColors.getColor(this, com.koala.clash.R.attr.colorControlActivated);
            int color3 = MaterialColors.getColor(this, com.koala.clash.R.attr.colorOnSurface);
            this.materialThemeColorsTrackTintList = new ColorStateList(ENABLED_CHECKED_STATES, new int[]{MaterialColors.layer(0.54f, color, color2), MaterialColors.layer(0.32f, color, color3), MaterialColors.layer(0.12f, color, color2), MaterialColors.layer(0.12f, color, color3)});
        }
        return this.materialThemeColorsTrackTintList;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.useMaterialThemeColors && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }
}
