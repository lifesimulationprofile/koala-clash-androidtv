package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.gms.internal.mlkit_vision_common.zzln;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.textViewStyle, 0), attributeSet, R.attr.textViewStyle);
        Context context2 = getContext();
        TypedValue typedValueResolve = zzln.resolve(context2, com.koala.clash.R.attr.textAppearanceLineHeightEnabled);
        if (typedValueResolve != null && typedValueResolve.type == 18 && typedValueResolve.data == 0) {
            return;
        }
        Resources.Theme theme = context2.getTheme();
        int[] iArr = R$styleable.MaterialTextView;
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
        int[] iArr2 = {1, 2};
        int dimensionPixelSize = -1;
        for (int i = 0; i < 2 && dimensionPixelSize < 0; i++) {
            dimensionPixelSize = MaterialResources.getDimensionPixelSize(context2, typedArrayObtainStyledAttributes, iArr2[i], -1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (dimensionPixelSize != -1) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId != -1) {
            TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, R$styleable.MaterialTextAppearance);
            Context context3 = getContext();
            int[] iArr3 = {1, 2};
            int dimensionPixelSize2 = -1;
            for (int i2 = 0; i2 < 2 && dimensionPixelSize2 < 0; i2++) {
                dimensionPixelSize2 = MaterialResources.getDimensionPixelSize(context3, typedArrayObtainStyledAttributes3, iArr3[i2], -1);
            }
            typedArrayObtainStyledAttributes3.recycle();
            if (dimensionPixelSize2 >= 0) {
                setLineHeight(dimensionPixelSize2);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedValue typedValueResolve = zzln.resolve(context, com.koala.clash.R.attr.textAppearanceLineHeightEnabled);
        if (typedValueResolve != null && typedValueResolve.type == 18 && typedValueResolve.data == 0) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, R$styleable.MaterialTextAppearance);
        Context context2 = getContext();
        int[] iArr = {1, 2};
        int dimensionPixelSize = -1;
        for (int i2 = 0; i2 < 2 && dimensionPixelSize < 0; i2++) {
            dimensionPixelSize = MaterialResources.getDimensionPixelSize(context2, typedArrayObtainStyledAttributes, iArr[i2], -1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (dimensionPixelSize >= 0) {
            setLineHeight(dimensionPixelSize);
        }
    }
}
