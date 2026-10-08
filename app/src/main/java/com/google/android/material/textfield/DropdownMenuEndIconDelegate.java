package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.FragmentStateManager;
import androidx.transition.Transition;
import coil.network.EmptyNetworkObserver;
import com.google.android.gms.internal.mlkit_vision_common.zzln;
import com.google.android.gms.tasks.zzi;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.koala.clash.R;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DropdownMenuEndIconDelegate extends EndIconDelegate {
    public final AnonymousClass3 accessibilityDelegate;
    public AccessibilityManager accessibilityManager;
    public final ClearTextEndIconDelegate.AnonymousClass3 dropdownMenuOnEditTextAttachedListener;
    public long dropdownPopupActivatedAt;
    public boolean dropdownPopupDirty;
    public final ClearTextEndIconDelegate.AnonymousClass4 endIconChangedListener;
    public final AnonymousClass1 exposedDropdownEndIconTextWatcher;
    public ValueAnimator fadeInAnim;
    public ValueAnimator fadeOutAnim;
    public StateListDrawable filledPopupBackground;
    public boolean isEndIconChecked;
    public final FragmentStateManager.AnonymousClass1 onAttachStateChangeListener;
    public final ClearTextEndIconDelegate.AnonymousClass2 onFocusChangeListener;
    public MaterialShapeDrawable outlinedPopupBackground;
    public final Headers.Builder touchExplorationStateChangeListener;

    /* JADX INFO: renamed from: com.google.android.material.textfield.DropdownMenuEndIconDelegate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends TextWatcherAdapter {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ EndIconDelegate this$0;

        public /* synthetic */ AnonymousClass1(EndIconDelegate endIconDelegate, int i) {
            this.$r8$classId = i;
            this.this$0 = endIconDelegate;
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            switch (this.$r8$classId) {
                case 0:
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.this$0;
                    EditText editText = dropdownMenuEndIconDelegate.textInputLayout.getEditText();
                    if (!(editText instanceof AutoCompleteTextView)) {
                        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                    }
                    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                    if (dropdownMenuEndIconDelegate.accessibilityManager.isTouchExplorationEnabled() && autoCompleteTextView.getKeyListener() != null && !dropdownMenuEndIconDelegate.endIconView.hasFocus()) {
                        autoCompleteTextView.dismissDropDown();
                    }
                    autoCompleteTextView.post(new zzi(19, this, autoCompleteTextView, false));
                    return;
                default:
                    return;
            }
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            switch (this.$r8$classId) {
                case 1:
                    PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = (PasswordToggleEndIconDelegate) this.this$0;
                    passwordToggleEndIconDelegate.endIconView.setChecked(!PasswordToggleEndIconDelegate.access$000(passwordToggleEndIconDelegate));
                    break;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.android.material.textfield.DropdownMenuEndIconDelegate$3] */
    public DropdownMenuEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.exposedDropdownEndIconTextWatcher = new AnonymousClass1(this, 0);
        this.onFocusChangeListener = new ClearTextEndIconDelegate.AnonymousClass2(this, 1);
        this.accessibilityDelegate = new TextInputLayout.AccessibilityDelegate(textInputLayout) { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (!DropdownMenuEndIconDelegate.isEditable(DropdownMenuEndIconDelegate.this.textInputLayout.getEditText())) {
                    accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
                }
                if (Build.VERSION.SDK_INT >= 26 ? accessibilityNodeInfoCompat.mInfo.isShowingHintText() : accessibilityNodeInfoCompat.getBooleanProperty(4)) {
                    accessibilityNodeInfoCompat.setHintText(null);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                TextInputLayout textInputLayout2 = dropdownMenuEndIconDelegate.textInputLayout;
                EditText editText = textInputLayout2.getEditText();
                if (!(editText instanceof AutoCompleteTextView)) {
                    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                }
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                if (accessibilityEvent.getEventType() == 1 && dropdownMenuEndIconDelegate.accessibilityManager.isEnabled() && !DropdownMenuEndIconDelegate.isEditable(textInputLayout2.getEditText())) {
                    DropdownMenuEndIconDelegate.access$500(dropdownMenuEndIconDelegate, autoCompleteTextView);
                    dropdownMenuEndIconDelegate.dropdownPopupDirty = true;
                    dropdownMenuEndIconDelegate.dropdownPopupActivatedAt = System.currentTimeMillis();
                }
            }
        };
        int i2 = 1;
        this.dropdownMenuOnEditTextAttachedListener = new ClearTextEndIconDelegate.AnonymousClass3(this, i2);
        this.endIconChangedListener = new ClearTextEndIconDelegate.AnonymousClass4(this, i2);
        this.onAttachStateChangeListener = new FragmentStateManager.AnonymousClass1(6, this);
        this.touchExplorationStateChangeListener = new Headers.Builder(13, this);
        this.dropdownPopupDirty = false;
        this.isEndIconChecked = false;
        this.dropdownPopupActivatedAt = Long.MAX_VALUE;
    }

    public static void access$500(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - dropdownMenuEndIconDelegate.dropdownPopupActivatedAt;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
        }
        if (dropdownMenuEndIconDelegate.dropdownPopupDirty) {
            dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
            return;
        }
        dropdownMenuEndIconDelegate.setEndIconChecked(!dropdownMenuEndIconDelegate.isEndIconChecked);
        if (!dropdownMenuEndIconDelegate.isEndIconChecked) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    public static boolean isEditable(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public final void addRippleEffect(AutoCompleteTextView autoCompleteTextView) {
        if (isEditable(autoCompleteTextView)) {
            return;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        int boxBackgroundMode = textInputLayout.getBoxBackgroundMode();
        MaterialShapeDrawable boxBackground = textInputLayout.getBoxBackground();
        int color = MaterialColors.getColor(autoCompleteTextView, R.attr.colorControlHighlight);
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode != 2) {
            if (boxBackgroundMode == 1) {
                int boxBackgroundColor = textInputLayout.getBoxBackgroundColor();
                RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(0.1f, color, boxBackgroundColor), boxBackgroundColor}), boxBackground, boxBackground);
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                autoCompleteTextView.setBackground(rippleDrawable);
                return;
            }
            return;
        }
        int color2 = MaterialColors.getColor(autoCompleteTextView, R.attr.colorSurface);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.drawableState.shapeAppearanceModel);
        int iLayer = MaterialColors.layer(0.1f, color, color2);
        materialShapeDrawable.setFillColor(new ColorStateList(iArr, new int[]{iLayer, 0}));
        materialShapeDrawable.setTint(color2);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iLayer, color2});
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.drawableState.shapeAppearanceModel);
        materialShapeDrawable2.setTint(-1);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground});
        WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
        autoCompleteTextView.setBackground(layerDrawable);
    }

    public final void addTouchExplorationStateChangeListenerIfNeeded() {
        TextInputLayout textInputLayout;
        if (this.accessibilityManager == null || (textInputLayout = this.textInputLayout) == null) {
            return;
        }
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (textInputLayout.isAttachedToWindow()) {
            this.accessibilityManager.addTouchExplorationStateChangeListener(new AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(this.touchExplorationStateChangeListener));
        }
    }

    public final MaterialShapeDrawable getPopUpMaterialShapeDrawable(float f, float f2, float f3, int i) {
        RoundedCornerTreatment roundedCornerTreatment = new RoundedCornerTreatment();
        RoundedCornerTreatment roundedCornerTreatment2 = new RoundedCornerTreatment();
        RoundedCornerTreatment roundedCornerTreatment3 = new RoundedCornerTreatment();
        RoundedCornerTreatment roundedCornerTreatment4 = new RoundedCornerTreatment();
        EmptyNetworkObserver emptyNetworkObserver = new EmptyNetworkObserver();
        EmptyNetworkObserver emptyNetworkObserver2 = new EmptyNetworkObserver();
        EmptyNetworkObserver emptyNetworkObserver3 = new EmptyNetworkObserver();
        EmptyNetworkObserver emptyNetworkObserver4 = new EmptyNetworkObserver();
        AbsoluteCornerSize absoluteCornerSize = new AbsoluteCornerSize(f);
        AbsoluteCornerSize absoluteCornerSize2 = new AbsoluteCornerSize(f);
        AbsoluteCornerSize absoluteCornerSize3 = new AbsoluteCornerSize(f2);
        AbsoluteCornerSize absoluteCornerSize4 = new AbsoluteCornerSize(f2);
        ShapeAppearanceModel shapeAppearanceModel = new ShapeAppearanceModel();
        shapeAppearanceModel.topLeftCorner = roundedCornerTreatment;
        shapeAppearanceModel.topRightCorner = roundedCornerTreatment2;
        shapeAppearanceModel.bottomRightCorner = roundedCornerTreatment3;
        shapeAppearanceModel.bottomLeftCorner = roundedCornerTreatment4;
        shapeAppearanceModel.topLeftCornerSize = absoluteCornerSize;
        shapeAppearanceModel.topRightCornerSize = absoluteCornerSize2;
        shapeAppearanceModel.bottomRightCornerSize = absoluteCornerSize4;
        shapeAppearanceModel.bottomLeftCornerSize = absoluteCornerSize3;
        shapeAppearanceModel.topEdge = emptyNetworkObserver;
        shapeAppearanceModel.rightEdge = emptyNetworkObserver2;
        shapeAppearanceModel.bottomEdge = emptyNetworkObserver3;
        shapeAppearanceModel.leftEdge = emptyNetworkObserver4;
        Paint paint = MaterialShapeDrawable.clearPaint;
        Context context = this.context;
        int iResolveOrThrow = zzln.resolveOrThrow(R.attr.colorSurface, context, "MaterialShapeDrawable");
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(iResolveOrThrow));
        materialShapeDrawable.setElevation(f3);
        materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
        if (materialShapeDrawableState.padding == null) {
            materialShapeDrawableState.padding = new Rect();
        }
        materialShapeDrawable.drawableState.padding.set(0, i, 0, i);
        materialShapeDrawable.invalidateSelf();
        return materialShapeDrawable;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        Context context = this.context;
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable popUpMaterialShapeDrawable = getPopUpMaterialShapeDrawable(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable popUpMaterialShapeDrawable2 = getPopUpMaterialShapeDrawable(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.outlinedPopupBackground = popUpMaterialShapeDrawable;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.filledPopupBackground = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, popUpMaterialShapeDrawable);
        this.filledPopupBackground.addState(new int[0], popUpMaterialShapeDrawable2);
        int i = this.customEndIcon;
        if (i == 0) {
            i = R.drawable.mtrl_dropdown_arrow;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(i);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        textInputLayout.setEndIconOnClickListener(new Toolbar.AnonymousClass4(6, this));
        LinkedHashSet linkedHashSet = textInputLayout.editTextAttachedListeners;
        ClearTextEndIconDelegate.AnonymousClass3 anonymousClass3 = this.dropdownMenuOnEditTextAttachedListener;
        linkedHashSet.add(anonymousClass3);
        if (textInputLayout.editText != null) {
            anonymousClass3.onEditTextAttached(textInputLayout);
        }
        textInputLayout.endIconChangedListeners.add(this.endIconChangedListener);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        int i2 = 3;
        valueAnimatorOfFloat.addUpdateListener(new TextInputLayout.AnonymousClass4(i2, this));
        this.fadeInAnim = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new TextInputLayout.AnonymousClass4(i2, this));
        this.fadeOutAnim = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new Transition.AnonymousClass3(5, this));
        this.accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        textInputLayout.addOnAttachStateChangeListener(this.onAttachStateChangeListener);
        addTouchExplorationStateChangeListenerIfNeeded();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean isBoxBackgroundModeSupported(int i) {
        return i != 0;
    }

    public final void setEndIconChecked(boolean z) {
        if (this.isEndIconChecked != z) {
            this.isEndIconChecked = z;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }
}
