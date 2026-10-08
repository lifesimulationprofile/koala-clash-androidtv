package androidx.compose.runtime;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.ViewCompat;
import coil.network.HttpException;
import kotlin.collections.AbstractList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProvidedValue {
    public boolean canOverride;
    public final Object compositionLocal;
    public boolean explicitNull;
    public boolean isDynamic;
    public Object mutationPolicy;
    public Object providedValue;

    public /* synthetic */ ProvidedValue(TextView textView) {
        this.mutationPolicy = null;
        this.providedValue = null;
        this.explicitNull = false;
        this.isDynamic = false;
        this.compositionLocal = textView;
    }

    public void applyButtonTint() {
        CompoundButton compoundButton = (CompoundButton) this.compositionLocal;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.explicitNull || this.isDynamic) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.explicitNull) {
                    drawableMutate.setTintList((ColorStateList) this.mutationPolicy);
                }
                if (this.isDynamic) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.providedValue);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void applyCheckMarkTint() {
        AppCompatCheckedTextView appCompatCheckedTextView = (AppCompatCheckedTextView) this.compositionLocal;
        Drawable checkMarkDrawable = appCompatCheckedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.explicitNull || this.isDynamic) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.explicitNull) {
                    drawableMutate.setTintList((ColorStateList) this.mutationPolicy);
                }
                if (this.isDynamic) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.providedValue);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(appCompatCheckedTextView.getDrawableState());
                }
                appCompatCheckedTextView.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public Object getEffectiveValue$runtime() {
        if (this.explicitNull) {
            return null;
        }
        Object obj = this.providedValue;
        if (obj != null) {
            return obj;
        }
        ComposerKt.composeRuntimeError("Unexpected form of a provided value");
        throw new HttpException();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.compositionLocal;
        Context context = compoundButton.getContext();
        int[] iArr = R$styleable.CompoundButton;
        MenuHostHelper menuHostHelperObtainStyledAttributes = MenuHostHelper.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) menuHostHelperObtainStyledAttributes.mMenuProviders;
        ViewCompat.saveAttributeDataForStyleable(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) menuHostHelperObtainStyledAttributes.mMenuProviders, i, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(AbstractList.Companion.getDrawable(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(AbstractList.Companion.getDrawable(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(AbstractList.Companion.getDrawable(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                compoundButton.setButtonTintList(menuHostHelperObtainStyledAttributes.getColorStateList(2));
            }
            if (typedArray.hasValue(3)) {
                compoundButton.setButtonTintMode(DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null));
            }
        } finally {
            menuHostHelperObtainStyledAttributes.recycle();
        }
    }

    public ProvidedValue(ProvidableCompositionLocal providableCompositionLocal, Object obj, boolean z, SnapshotMutationPolicy snapshotMutationPolicy, boolean z2) {
        this.compositionLocal = providableCompositionLocal;
        this.explicitNull = z;
        this.mutationPolicy = snapshotMutationPolicy;
        this.isDynamic = z2;
        this.providedValue = obj;
        this.canOverride = true;
    }
}
