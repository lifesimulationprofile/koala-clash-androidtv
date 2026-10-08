package com.google.android.material.shape;

import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.google.android.material.elevation.ElevationOverlayProvider;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class MaterialShapeUtils {
    public static CornerTreatment createCornerTreatment(int i) {
        if (i != 0) {
            return i != 1 ? new RoundedCornerTreatment() : new CutCornerTreatment();
        }
        return new RoundedCornerTreatment();
    }

    public static void setParentAbsoluteElevation(View view, MaterialShapeDrawable materialShapeDrawable) {
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawable.drawableState.elevationOverlayProvider;
        if (elevationOverlayProvider == null || !elevationOverlayProvider.elevationOverlayEnabled) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            elevation += ViewCompat.Api21Impl.getElevation((View) parent);
        }
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
        if (materialShapeDrawableState.parentAbsoluteElevation != elevation) {
            materialShapeDrawableState.parentAbsoluteElevation = elevation;
            materialShapeDrawable.updateZ();
        }
    }
}
