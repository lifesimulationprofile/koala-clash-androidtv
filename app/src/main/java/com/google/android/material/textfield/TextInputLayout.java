package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.graphics.ColorUtils;
import androidx.core.text.BidiFormatter;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.FastScroller;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.gms.tasks.zzi;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.koala.clash.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import kotlin.collections.AbstractList;
import kotlinx.serialization.json.internal.Composer;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public ValueAnimator animator;
    public boolean areCornerRadiiRtl;
    public MaterialShapeDrawable boxBackground;
    public int boxBackgroundColor;
    public int boxBackgroundMode;
    public int boxCollapsedPaddingTopPx;
    public final int boxLabelCutoutPaddingPx;
    public int boxStrokeColor;
    public int boxStrokeWidthDefaultPx;
    public int boxStrokeWidthFocusedPx;
    public int boxStrokeWidthPx;
    public MaterialShapeDrawable boxUnderlineDefault;
    public MaterialShapeDrawable boxUnderlineFocused;
    public final CollapsingTextHelper collapsingTextHelper;
    public boolean counterEnabled;
    public int counterMaxLength;
    public int counterOverflowTextAppearance;
    public ColorStateList counterOverflowTextColor;
    public boolean counterOverflowed;
    public int counterTextAppearance;
    public ColorStateList counterTextColor;
    public AppCompatTextView counterView;
    public int defaultFilledBackgroundColor;
    public ColorStateList defaultHintTextColor;
    public int defaultStrokeColor;
    public int disabledColor;
    public int disabledFilledBackgroundColor;
    public EditText editText;
    public final LinkedHashSet editTextAttachedListeners;
    public ColorDrawable endDummyDrawable;
    public int endDummyDrawableWidth;
    public final LinkedHashSet endIconChangedListeners;
    public final SparseArray endIconDelegates;
    public final FrameLayout endIconFrame;
    public int endIconMode;
    public View.OnLongClickListener endIconOnLongClickListener;
    public ColorStateList endIconTintList;
    public PorterDuff.Mode endIconTintMode;
    public final CheckableImageButton endIconView;
    public final LinearLayout endLayout;
    public View.OnLongClickListener errorIconOnLongClickListener;
    public ColorStateList errorIconTintList;
    public PorterDuff.Mode errorIconTintMode;
    public final CheckableImageButton errorIconView;
    public boolean expandedHintEnabled;
    public int focusedFilledBackgroundColor;
    public int focusedStrokeColor;
    public ColorStateList focusedTextColor;
    public CharSequence hint;
    public boolean hintAnimationEnabled;
    public boolean hintEnabled;
    public boolean hintExpanded;
    public int hoveredFilledBackgroundColor;
    public int hoveredStrokeColor;
    public boolean inDrawableStateChanged;
    public final IndicatorViewController indicatorViewController;
    public final FrameLayout inputFrame;
    public boolean isProvidingHint;
    public int maxEms;
    public int maxWidth;
    public int minEms;
    public int minWidth;
    public Drawable originalEditTextEndDrawable;
    public CharSequence originalHint;
    public boolean placeholderEnabled;
    public Fade placeholderFadeIn;
    public Fade placeholderFadeOut;
    public CharSequence placeholderText;
    public int placeholderTextAppearance;
    public ColorStateList placeholderTextColor;
    public AppCompatTextView placeholderTextView;
    public boolean restoringSavedState;
    public ShapeAppearanceModel shapeAppearanceModel;
    public ColorDrawable startDummyDrawable;
    public int startDummyDrawableWidth;
    public final StartCompoundLayout startLayout;
    public ColorStateList strokeErrorColor;
    public CharSequence suffixText;
    public final AppCompatTextView suffixTextView;
    public final Rect tmpBoundsRect;
    public final Rect tmpRect;
    public final RectF tmpRectF;
    public Typeface typeface;

    /* JADX INFO: renamed from: com.google.android.material.textfield.TextInputLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ TextInputLayout this$0;

        public /* synthetic */ AnonymousClass2(TextInputLayout textInputLayout, int i) {
            this.$r8$classId = i;
            this.this$0 = textInputLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    TextInputLayout textInputLayout = this.this$0;
                    textInputLayout.endIconView.performClick();
                    textInputLayout.endIconView.jumpDrawablesToCurrentState();
                    break;
                default:
                    this.this$0.editText.requestLayout();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.TextInputLayout$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass4(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            switch (this.$r8$classId) {
                case 0:
                    ((TextInputLayout) this.this$0).collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    break;
                case 1:
                    int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                    FastScroller fastScroller = (FastScroller) this.this$0;
                    fastScroller.mVerticalThumbDrawable.setAlpha(iFloatValue);
                    fastScroller.mVerticalTrackDrawable.setAlpha(iFloatValue);
                    fastScroller.mRecyclerView.invalidate();
                    break;
                case 2:
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MaterialShapeDrawable materialShapeDrawable = ((BottomSheetBehavior) this.this$0).materialShapeDrawable;
                    if (materialShapeDrawable != null) {
                        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
                        if (materialShapeDrawableState.interpolation != fFloatValue) {
                            materialShapeDrawableState.interpolation = fFloatValue;
                            materialShapeDrawable.pathDirty = true;
                            materialShapeDrawable.invalidateSelf();
                        }
                    }
                    break;
                default:
                    ((DropdownMenuEndIconDelegate) this.this$0).endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            TextInputLayout textInputLayout = this.layout;
            EditText editText = textInputLayout.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = textInputLayout.getHint();
            CharSequence error = textInputLayout.getError();
            CharSequence placeholderText = textInputLayout.getPlaceholderText();
            int counterMaxLength = textInputLayout.getCounterMaxLength();
            CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean z = textInputLayout.hintExpanded;
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z2 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : "";
            StartCompoundLayout startCompoundLayout = textInputLayout.startLayout;
            AppCompatTextView appCompatTextView = startCompoundLayout.prefixTextView;
            if (appCompatTextView.getVisibility() == 0) {
                accessibilityNodeInfo.setLabelFor(appCompatTextView);
                accessibilityNodeInfo.setTraversalAfter(appCompatTextView);
            } else {
                accessibilityNodeInfo.setTraversalAfter(startCompoundLayout.startIconView);
            }
            if (!zIsEmpty) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfoCompat.setText(string);
                if (!z && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 26) {
                    accessibilityNodeInfoCompat.setHintText(string);
                } else {
                    if (!zIsEmpty) {
                        string = ((Object) text) + ", " + string;
                    }
                    accessibilityNodeInfoCompat.setText(string);
                }
                if (i >= 26) {
                    accessibilityNodeInfo.setShowingHintText(zIsEmpty);
                } else {
                    accessibilityNodeInfoCompat.setBooleanProperty(4, zIsEmpty);
                }
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
            if (z2) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfo.setError(error);
            }
            AppCompatTextView appCompatTextView2 = textInputLayout.indicatorViewController.helperTextView;
            if (appCompatTextView2 != null) {
                accessibilityNodeInfo.setLabelFor(appCompatTextView2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(9);
        public CharSequence error;
        public CharSequence helperText;
        public CharSequence hintText;
        public boolean isEndIconChecked;
        public CharSequence placeholderText;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.error = (CharSequence) creator.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() == 1;
            this.hintText = (CharSequence) creator.createFromParcel(parcel);
            this.helperText = (CharSequence) creator.createFromParcel(parcel);
            this.placeholderText = (CharSequence) creator.createFromParcel(parcel);
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + " hint=" + ((Object) this.hintText) + " helperText=" + ((Object) this.helperText) + " placeholderText=" + ((Object) this.placeholderText) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, parcel, i);
            TextUtils.writeToParcel(this.helperText, parcel, i);
            TextUtils.writeToParcel(this.placeholderText, parcel, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v33 */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        int i;
        int i2;
        ?? r4;
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.textInputStyle, R.style.Widget_Design_TextInputLayout), attributeSet, R.attr.textInputStyle);
        this.minEms = -1;
        this.maxEms = -1;
        this.minWidth = -1;
        this.maxWidth = -1;
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet();
        this.endIconMode = 0;
        SparseArray sparseArray = new SparseArray();
        this.endIconDelegates = sparseArray;
        this.endIconChangedListeners = new LinkedHashSet();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.inputFrame = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.endIconFrame = frameLayout2;
        LinearLayout linearLayout = new LinearLayout(context2);
        this.endLayout = linearLayout;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2, null);
        this.suffixTextView = appCompatTextView;
        linearLayout.setVisibility(8);
        frameLayout2.setVisibility(8);
        appCompatTextView.setVisibility(8);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context2);
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(R.layout.design_text_input_end_icon, (ViewGroup) linearLayout, false);
        this.errorIconView = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) layoutInflaterFrom.inflate(R.layout.design_text_input_end_icon, (ViewGroup) frameLayout2, false);
        this.endIconView = checkableImageButton2;
        frameLayout.setAddStatesFromChildren(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        collapsingTextHelper.textSizeInterpolator = linearInterpolator;
        collapsingTextHelper.recalculate(false);
        collapsingTextHelper.positionInterpolator = linearInterpolator;
        collapsingTextHelper.recalculate(false);
        if (collapsingTextHelper.collapsedTextGravity != 8388659) {
            collapsingTextHelper.collapsedTextGravity = 8388659;
            collapsingTextHelper.recalculate(false);
        }
        ViewUtils.checkCompatibleTheme(context2, attributeSet, R.attr.textInputStyle, R.style.Widget_Design_TextInputLayout);
        int[] iArr = R$styleable.TextInputLayout;
        ViewUtils.checkTextAppearance(context2, attributeSet, iArr, R.attr.textInputStyle, R.style.Widget_Design_TextInputLayout, 22, 20, 35, 40, 44);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.textInputStyle, R.style.Widget_Design_TextInputLayout);
        MenuHostHelper menuHostHelper = new MenuHostHelper(context2, typedArrayObtainStyledAttributes);
        StartCompoundLayout startCompoundLayout = new StartCompoundLayout(this, menuHostHelper);
        this.startLayout = startCompoundLayout;
        this.hintEnabled = typedArrayObtainStyledAttributes.getBoolean(43, true);
        setHint(typedArrayObtainStyledAttributes.getText(4));
        this.hintAnimationEnabled = typedArrayObtainStyledAttributes.getBoolean(42, true);
        this.expandedHintEnabled = typedArrayObtainStyledAttributes.getBoolean(37, true);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            i = -1;
            setMinEms(typedArrayObtainStyledAttributes.getInt(6, -1));
        } else {
            i = -1;
            if (typedArrayObtainStyledAttributes.hasValue(3)) {
                setMinWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1));
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            setMaxEms(typedArrayObtainStyledAttributes.getInt(5, i));
        } else if (typedArrayObtainStyledAttributes.hasValue(2)) {
            setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(2, i));
        }
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, R.attr.textInputStyle, R.style.Widget_Design_TextInputLayout).build();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = typedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.boxStrokeWidthDefaultPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float dimension = typedArrayObtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = typedArrayObtainStyledAttributes.getDimension(11, -1.0f);
        ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
        if (dimension >= 0.0f) {
            builder.topLeftCornerSize = new AbsoluteCornerSize(dimension);
        }
        if (dimension2 >= 0.0f) {
            builder.topRightCornerSize = new AbsoluteCornerSize(dimension2);
        }
        if (dimension3 >= 0.0f) {
            builder.bottomRightCornerSize = new AbsoluteCornerSize(dimension3);
        }
        if (dimension4 >= 0.0f) {
            builder.bottomLeftCornerSize = new AbsoluteCornerSize(dimension4);
        }
        this.shapeAppearanceModel = builder.build();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, menuHostHelper, 7);
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.defaultFilledBackgroundColor = defaultColor;
            this.boxBackgroundColor = defaultColor;
            if (colorStateList.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
                ColorStateList colorStateList2 = AbstractList.Companion.getColorStateList(context2, R.color.mtrl_filled_background_color);
                this.disabledFilledBackgroundColor = colorStateList2.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList2.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateList3 = menuHostHelper.getColorStateList(1);
            this.focusedTextColor = colorStateList3;
            this.defaultHintTextColor = colorStateList3;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context2, menuHostHelper, 14);
        this.focusedStrokeColor = typedArrayObtainStyledAttributes.getColor(14, i2);
        this.defaultStrokeColor = context2.getColor(R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = context2.getColor(R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = context2.getColor(R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateList4 != null) {
            setBoxStrokeColorStateList(colorStateList4);
        }
        if (typedArrayObtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(MaterialResources.getColorStateList(context2, menuHostHelper, 15));
        }
        if (typedArrayObtainStyledAttributes.getResourceId(44, -1) != -1) {
            r4 = 0;
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(44, 0));
        } else {
            r4 = 0;
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(35, r4);
        CharSequence text = typedArrayObtainStyledAttributes.getText(30);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(31, r4);
        checkableImageButton.setId(R.id.text_input_error_icon);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(r4);
        }
        if (typedArrayObtainStyledAttributes.hasValue(33)) {
            this.errorIconTintList = MaterialResources.getColorStateList(context2, menuHostHelper, 33);
        }
        if (typedArrayObtainStyledAttributes.hasValue(34)) {
            this.errorIconTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(34, -1), null);
        }
        if (typedArrayObtainStyledAttributes.hasValue(32)) {
            setErrorIconDrawable(menuHostHelper.getDrawable(32));
        }
        checkableImageButton.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        checkableImageButton.setImportantForAccessibility(2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(40, 0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(39, false);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(38);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(52, 0);
        CharSequence text3 = typedArrayObtainStyledAttributes.getText(51);
        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(65, 0);
        CharSequence text4 = typedArrayObtainStyledAttributes.getText(64);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(typedArrayObtainStyledAttributes.getInt(19, -1));
        this.counterTextAppearance = typedArrayObtainStyledAttributes.getResourceId(22, 0);
        this.counterOverflowTextAppearance = typedArrayObtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(typedArrayObtainStyledAttributes.getInt(8, 0));
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams()).setMarginStart(0);
        }
        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(26, 0);
        sparseArray.append(-1, new NoEndIconDelegate(this, resourceId5, 1));
        int i3 = 0;
        sparseArray.append(0, new NoEndIconDelegate(this, i3, i3));
        sparseArray.append(1, new PasswordToggleEndIconDelegate(this, resourceId5 == 0 ? typedArrayObtainStyledAttributes.getResourceId(47, 0) : resourceId5));
        sparseArray.append(2, new ClearTextEndIconDelegate(this, resourceId5));
        sparseArray.append(3, new DropdownMenuEndIconDelegate(this, resourceId5));
        if (!typedArrayObtainStyledAttributes.hasValue(48)) {
            if (typedArrayObtainStyledAttributes.hasValue(28)) {
                this.endIconTintList = MaterialResources.getColorStateList(context2, menuHostHelper, 28);
            }
            if (typedArrayObtainStyledAttributes.hasValue(29)) {
                this.endIconTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(29, -1), null);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(27)) {
            setEndIconMode(typedArrayObtainStyledAttributes.getInt(27, 0));
            if (typedArrayObtainStyledAttributes.hasValue(25)) {
                setEndIconContentDescription(typedArrayObtainStyledAttributes.getText(25));
            }
            setEndIconCheckable(typedArrayObtainStyledAttributes.getBoolean(24, true));
        } else if (typedArrayObtainStyledAttributes.hasValue(48)) {
            if (typedArrayObtainStyledAttributes.hasValue(49)) {
                this.endIconTintList = MaterialResources.getColorStateList(context2, menuHostHelper, 49);
            }
            if (typedArrayObtainStyledAttributes.hasValue(50)) {
                this.endIconTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(50, -1), null);
            }
            setEndIconMode(typedArrayObtainStyledAttributes.getBoolean(48, false) ? 1 : 0);
            setEndIconContentDescription(typedArrayObtainStyledAttributes.getText(46));
        }
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        appCompatTextView.setAccessibilityLiveRegion(1);
        setErrorContentDescription(text);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.counterTextAppearance);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setSuffixTextAppearance(resourceId4);
        if (typedArrayObtainStyledAttributes.hasValue(36)) {
            setErrorTextColor(menuHostHelper.getColorStateList(36));
        }
        if (typedArrayObtainStyledAttributes.hasValue(41)) {
            setHelperTextColor(menuHostHelper.getColorStateList(41));
        }
        if (typedArrayObtainStyledAttributes.hasValue(45)) {
            setHintTextColor(menuHostHelper.getColorStateList(45));
        }
        if (typedArrayObtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(menuHostHelper.getColorStateList(23));
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(menuHostHelper.getColorStateList(21));
        }
        if (typedArrayObtainStyledAttributes.hasValue(53)) {
            setPlaceholderTextColor(menuHostHelper.getColorStateList(53));
        }
        if (typedArrayObtainStyledAttributes.hasValue(66)) {
            setSuffixTextColor(menuHostHelper.getColorStateList(66));
        }
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        menuHostHelper.recycle();
        setImportantForAccessibility(2);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26 && i4 >= 26) {
            ViewCompat.Api26Impl.setImportantForAutofill(this, 1);
        }
        frameLayout2.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        linearLayout.addView(checkableImageButton);
        linearLayout.addView(frameLayout2);
        frameLayout.addView(startCompoundLayout);
        frameLayout.addView(linearLayout);
        addView(frameLayout);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
        setSuffixText(text4);
    }

    private EndIconDelegate getEndIconDelegate() {
        int i = this.endIconMode;
        SparseArray sparseArray = this.endIconDelegates;
        EndIconDelegate endIconDelegate = (EndIconDelegate) sparseArray.get(i);
        return endIconDelegate != null ? endIconDelegate : (EndIconDelegate) sparseArray.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        CheckableImageButton checkableImageButton = this.errorIconView;
        if (checkableImageButton.getVisibility() == 0) {
            return checkableImageButton;
        }
        if (this.endIconMode == 0 || !isEndIconVisible()) {
            return null;
        }
        return this.endIconView;
    }

    public static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.editText != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.endIconMode != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.editText = editText;
        int i = this.minEms;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.minWidth);
        }
        int i2 = this.maxEms;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.maxWidth);
        }
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        Typeface typeface = this.editText.getTypeface();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        collapsingTextHelper.setTypefaces(typeface);
        float textSize = this.editText.getTextSize();
        if (collapsingTextHelper.expandedTextSize != textSize) {
            collapsingTextHelper.expandedTextSize = textSize;
            collapsingTextHelper.recalculate(false);
        }
        float letterSpacing = this.editText.getLetterSpacing();
        if (collapsingTextHelper.expandedLetterSpacing != letterSpacing) {
            collapsingTextHelper.expandedLetterSpacing = letterSpacing;
            collapsingTextHelper.recalculate(false);
        }
        int gravity = this.editText.getGravity();
        int i3 = (gravity & (-113)) | 48;
        if (collapsingTextHelper.collapsedTextGravity != i3) {
            collapsingTextHelper.collapsedTextGravity = i3;
            collapsingTextHelper.recalculate(false);
        }
        if (collapsingTextHelper.expandedTextGravity != gravity) {
            collapsingTextHelper.expandedTextGravity = gravity;
            collapsingTextHelper.recalculate(false);
        }
        this.editText.addTextChangedListener(new AnonymousClass1(0, this));
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (TextUtils.isEmpty(this.hint)) {
                CharSequence hint = this.editText.getHint();
                this.originalHint = hint;
                setHint(hint);
                this.editText.setHint((CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            updateCounter(this.editText.getText().length());
        }
        updateEditTextBackground();
        this.indicatorViewController.adjustIndicatorPadding();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        Iterator it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            ((ClearTextEndIconDelegate.AnonymousClass3) it.next()).onEditTextAttached(this);
        }
        updateSuffixTextViewPadding();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        updateLabelState(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.hint)) {
            return;
        }
        this.hint = charSequence;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (charSequence == null || !TextUtils.equals(collapsingTextHelper.text, charSequence)) {
            collapsingTextHelper.text = charSequence;
            collapsingTextHelper.textToDraw = null;
            Bitmap bitmap = collapsingTextHelper.expandedTitleTexture;
            if (bitmap != null) {
                bitmap.recycle();
                collapsingTextHelper.expandedTitleTexture = null;
            }
            collapsingTextHelper.recalculate(false);
        }
        if (this.hintExpanded) {
            return;
        }
        openCutout();
    }

    public static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.placeholderEnabled == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = this.placeholderTextView;
            if (appCompatTextView != null) {
                this.inputFrame.addView(appCompatTextView);
                this.placeholderTextView.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.placeholderTextView;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.placeholderTextView = null;
        }
        this.placeholderEnabled = z;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.inputFrame;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        updateInputLayoutMargins();
        setEditText((EditText) view);
    }

    public final void animateToExpansionFraction(float f) {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper.expandedFraction == f) {
            return;
        }
        int i = 0;
        if (this.animator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.animator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new AnonymousClass4(i, this));
        }
        this.animator.setFloatValues(collapsingTextHelper.expandedFraction, f);
        this.animator.start();
    }

    public final void applyBoxAttributes() {
        int i;
        int i2;
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable == null) {
            return;
        }
        ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawable.drawableState.shapeAppearanceModel;
        ShapeAppearanceModel shapeAppearanceModel2 = this.shapeAppearanceModel;
        if (shapeAppearanceModel != shapeAppearanceModel2) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel2);
            if (this.endIconMode == 3 && this.boxBackgroundMode == 2) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.endIconDelegates.get(3);
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.editText;
                dropdownMenuEndIconDelegate.getClass();
                if (!DropdownMenuEndIconDelegate.isEditable(autoCompleteTextView) && dropdownMenuEndIconDelegate.textInputLayout.getBoxBackgroundMode() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
                    dropdownMenuEndIconDelegate.addRippleEffect(autoCompleteTextView);
                }
            }
        }
        if (this.boxBackgroundMode == 2 && (i = this.boxStrokeWidthPx) > -1 && (i2 = this.boxStrokeColor) != 0) {
            MaterialShapeDrawable materialShapeDrawable2 = this.boxBackground;
            materialShapeDrawable2.drawableState.strokeWidth = i;
            materialShapeDrawable2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable2.drawableState;
            if (materialShapeDrawableState.strokeColor != colorStateListValueOf) {
                materialShapeDrawableState.strokeColor = colorStateListValueOf;
                materialShapeDrawable2.onStateChange(materialShapeDrawable2.getState());
            }
        }
        int iCompositeColors = this.boxBackgroundColor;
        if (this.boxBackgroundMode == 1) {
            iCompositeColors = ColorUtils.compositeColors(this.boxBackgroundColor, MaterialColors.getColor(getContext(), R.attr.colorSurface, 0));
        }
        this.boxBackgroundColor = iCompositeColors;
        this.boxBackground.setFillColor(ColorStateList.valueOf(iCompositeColors));
        if (this.endIconMode == 3) {
            this.editText.getBackground().invalidateSelf();
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.boxUnderlineDefault;
        if (materialShapeDrawable3 != null && this.boxUnderlineFocused != null) {
            if (this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0) {
                materialShapeDrawable3.setFillColor(this.editText.isFocused() ? ColorStateList.valueOf(this.defaultStrokeColor) : ColorStateList.valueOf(this.boxStrokeColor));
                this.boxUnderlineFocused.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
            }
            invalidate();
        }
        invalidate();
    }

    public final int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i = this.boxBackgroundMode;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (i == 0) {
            collapsedTextHeight = collapsingTextHelper.getCollapsedTextHeight();
        } else {
            if (i != 2) {
                return 0;
            }
            collapsedTextHeight = collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    public final boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.editText;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.originalHint != null) {
            boolean z = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint = editText.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.editText.setHint(hint);
                this.isProvidingHint = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.inputFrame;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            View childAt = frameLayout.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.editText) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        super.draw(canvas);
        boolean z = this.hintEnabled;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (z) {
            TextPaint textPaint = collapsingTextHelper.textPaint;
            int iSave = canvas.save();
            if (collapsingTextHelper.textToDraw != null && collapsingTextHelper.drawTitle) {
                textPaint.setTextSize(collapsingTextHelper.currentTextSize);
                float f = collapsingTextHelper.currentDrawX;
                float f2 = collapsingTextHelper.currentDrawY;
                float f3 = collapsingTextHelper.scale;
                if (f3 != 1.0f) {
                    canvas.scale(f3, f3, f, f2);
                }
                canvas.translate(f, f2);
                collapsingTextHelper.textLayout.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.boxUnderlineFocused == null || (materialShapeDrawable = this.boxUnderlineDefault) == null) {
            return;
        }
        materialShapeDrawable.draw(canvas);
        if (this.editText.isFocused()) {
            Rect bounds = this.boxUnderlineFocused.getBounds();
            Rect bounds2 = this.boxUnderlineDefault.getBounds();
            float f4 = collapsingTextHelper.expandedFraction;
            int iCenterX = bounds2.centerX();
            int i = bounds2.left;
            LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
            bounds.left = Math.round((i - iCenterX) * f4) + iCenterX;
            bounds.right = Math.round(f4 * (bounds2.right - iCenterX)) + iCenterX;
            this.boxUnderlineFocused.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        boolean z;
        ColorStateList colorStateList;
        if (this.inDrawableStateChanged) {
            return;
        }
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper != null) {
            collapsingTextHelper.state = drawableState;
            ColorStateList colorStateList2 = collapsingTextHelper.collapsedTextColor;
            if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = collapsingTextHelper.expandedTextColor) == null || !colorStateList.isStateful())) {
                z = false;
            } else {
                collapsingTextHelper.recalculate(false);
                z = true;
            }
        } else {
            z = false;
        }
        if (this.editText != null) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            updateLabelState(isLaidOut() && isEnabled(), false);
        }
        updateEditTextBackground();
        updateTextInputBoxState();
        if (z) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.editText;
        if (editText == null) {
            return super.getBaseline();
        }
        return calculateLabelMarginTop() + getPaddingTop() + editText.getBaseline();
    }

    public MaterialShapeDrawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        RectF rectF = this.tmpRectF;
        return zIsLayoutRtl ? this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(rectF) : this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        RectF rectF = this.tmpRectF;
        return zIsLayoutRtl ? this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(rectF) : this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        RectF rectF = this.tmpRectF;
        return zIsLayoutRtl ? this.shapeAppearanceModel.topLeftCornerSize.getCornerSize(rectF) : this.shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        RectF rectF = this.tmpRectF;
        return zIsLayoutRtl ? this.shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF) : this.shapeAppearanceModel.topLeftCornerSize.getCornerSize(rectF);
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.counterEnabled && this.counterOverflowed && (appCompatTextView = this.counterView) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    public CharSequence getError() {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.errorEnabled) {
            return indicatorViewController.errorText;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.errorViewContentDescription;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.indicatorViewController.errorView;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        AppCompatTextView appCompatTextView = this.indicatorViewController.errorView;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHelperText() {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.helperTextEnabled) {
            return indicatorViewController.helperText;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.indicatorViewController.helperTextView;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    public final int getHintCurrentCollapsedTextColor() {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        return collapsingTextHelper.getCurrentColor(collapsingTextHelper.collapsedTextColor);
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    public final int getLabelLeftBoundAlightWithPrefix(int i, boolean z) {
        int compoundPaddingLeft = this.editText.getCompoundPaddingLeft() + i;
        if (getPrefixText() == null || z) {
            return compoundPaddingLeft;
        }
        return getPrefixTextView().getPaddingLeft() + (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth());
    }

    public final int getLabelRightBoundAlignedWithSuffix(int i, boolean z) {
        int compoundPaddingRight = i - this.editText.getCompoundPaddingRight();
        return (getPrefixText() == null || !z) ? compoundPaddingRight : (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight()) + compoundPaddingRight;
    }

    public int getMaxEms() {
        return this.maxEms;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMinEms() {
        return this.minEms;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public CharSequence getPrefixText() {
        return this.startLayout.prefixText;
    }

    public ColorStateList getPrefixTextColor() {
        return this.startLayout.prefixTextView.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.startLayout.prefixTextView;
    }

    public CharSequence getStartIconContentDescription() {
        return this.startLayout.startIconView.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.startLayout.startIconView.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public final boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public final void onApplyBoxBackgroundMode() {
        int i = this.boxBackgroundMode;
        if (i == 0) {
            this.boxBackground = null;
            this.boxUnderlineDefault = null;
            this.boxUnderlineFocused = null;
        } else if (i == 1) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderlineDefault = new MaterialShapeDrawable();
            this.boxUnderlineFocused = new MaterialShapeDrawable();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), this.boxBackgroundMode, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.hintEnabled || (this.boxBackground instanceof CutoutDrawable)) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new CutoutDrawable(this.shapeAppearanceModel);
            }
            this.boxUnderlineDefault = null;
            this.boxUnderlineFocused = null;
        }
        EditText editText = this.editText;
        if (editText != null && this.boxBackground != null && editText.getBackground() == null && this.boxBackgroundMode != 0) {
            EditText editText2 = this.editText;
            MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            editText2.setBackground(materialShapeDrawable);
        }
        updateTextInputBoxState();
        if (this.boxBackgroundMode == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.editText != null && this.boxBackgroundMode == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText3 = this.editText;
                WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                EditText editText4 = this.editText;
                WeakHashMap weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                editText4.setPaddingRelative(editText4.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.editText;
        if (editText != null) {
            ThreadLocal threadLocal = DescendantOffsetUtils.matrix;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.tmpRect;
            rect.set(0, 0, width, height);
            ThreadLocal threadLocal2 = DescendantOffsetUtils.matrix;
            Matrix matrix = (Matrix) threadLocal2.get();
            if (matrix == null) {
                matrix = new Matrix();
                threadLocal2.set(matrix);
            } else {
                matrix.reset();
            }
            DescendantOffsetUtils.offsetDescendantMatrix(this, editText, matrix);
            ThreadLocal threadLocal3 = DescendantOffsetUtils.rectF;
            RectF rectF = (RectF) threadLocal3.get();
            if (rectF == null) {
                rectF = new RectF();
                threadLocal3.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
            MaterialShapeDrawable materialShapeDrawable = this.boxUnderlineDefault;
            if (materialShapeDrawable != null) {
                int i5 = rect.bottom;
                materialShapeDrawable.setBounds(rect.left, i5 - this.boxStrokeWidthDefaultPx, rect.right, i5);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.boxUnderlineFocused;
            if (materialShapeDrawable2 != null) {
                int i6 = rect.bottom;
                materialShapeDrawable2.setBounds(rect.left, i6 - this.boxStrokeWidthFocusedPx, rect.right, i6);
            }
            if (this.hintEnabled) {
                float textSize = this.editText.getTextSize();
                CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
                if (collapsingTextHelper.expandedTextSize != textSize) {
                    collapsingTextHelper.expandedTextSize = textSize;
                    collapsingTextHelper.recalculate(false);
                }
                int gravity = this.editText.getGravity();
                int i7 = (gravity & (-113)) | 48;
                if (collapsingTextHelper.collapsedTextGravity != i7) {
                    collapsingTextHelper.collapsedTextGravity = i7;
                    collapsingTextHelper.recalculate(false);
                }
                if (collapsingTextHelper.expandedTextGravity != gravity) {
                    collapsingTextHelper.expandedTextGravity = gravity;
                    collapsingTextHelper.recalculate(false);
                }
                if (this.editText == null) {
                    throw new IllegalStateException();
                }
                boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
                int i8 = rect.bottom;
                Rect rect2 = this.tmpBoundsRect;
                rect2.bottom = i8;
                int i9 = this.boxBackgroundMode;
                if (i9 == 1) {
                    rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, zIsLayoutRtl);
                    rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                    rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, zIsLayoutRtl);
                } else if (i9 != 2) {
                    rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, zIsLayoutRtl);
                    rect2.top = getPaddingTop();
                    rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, zIsLayoutRtl);
                } else {
                    rect2.left = this.editText.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - calculateLabelMarginTop();
                    rect2.right = rect.right - this.editText.getPaddingRight();
                }
                int i10 = rect2.left;
                int i11 = rect2.top;
                int i12 = rect2.right;
                int i13 = rect2.bottom;
                Rect rect3 = collapsingTextHelper.collapsedBounds;
                if (rect3.left != i10 || rect3.top != i11 || rect3.right != i12 || rect3.bottom != i13) {
                    rect3.set(i10, i11, i12, i13);
                    collapsingTextHelper.boundsChanged = true;
                    collapsingTextHelper.onBoundsChanged();
                }
                if (this.editText == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = collapsingTextHelper.tmpPaint;
                textPaint.setTextSize(collapsingTextHelper.expandedTextSize);
                textPaint.setTypeface(collapsingTextHelper.expandedTypeface);
                textPaint.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
                float f = -textPaint.ascent();
                rect2.left = this.editText.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.boxBackgroundMode != 1 || this.editText.getMinLines() > 1) ? rect.top + this.editText.getCompoundPaddingTop() : (int) (rect.centerY() - (f / 2.0f));
                rect2.right = rect.right - this.editText.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.boxBackgroundMode != 1 || this.editText.getMinLines() > 1) ? rect.bottom - this.editText.getCompoundPaddingBottom() : (int) (rect2.top + f);
                rect2.bottom = compoundPaddingBottom;
                int i14 = rect2.left;
                int i15 = rect2.top;
                int i16 = rect2.right;
                Rect rect4 = collapsingTextHelper.expandedBounds;
                if (rect4.left != i14 || rect4.top != i15 || rect4.right != i16 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i14, i15, i16, compoundPaddingBottom);
                    collapsingTextHelper.boundsChanged = true;
                    collapsingTextHelper.onBoundsChanged();
                }
                collapsingTextHelper.recalculate(false);
                if (!cutoutEnabled() || this.hintExpanded) {
                    return;
                }
                openCutout();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        EditText editText;
        int iMax;
        super.onMeasure(i, i2);
        boolean z = false;
        if (this.editText != null && this.editText.getMeasuredHeight() < (iMax = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            this.editText.setMinimumHeight(iMax);
            z = true;
        }
        boolean zUpdateDummyDrawables = updateDummyDrawables();
        if (z || zUpdateDummyDrawables) {
            this.editText.post(new AnonymousClass2(this, 1));
        }
        if (this.placeholderTextView != null && (editText = this.editText) != null) {
            this.placeholderTextView.setGravity(editText.getGravity());
            this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        }
        updateSuffixTextViewPadding();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new AnonymousClass2(this, 0));
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = false;
        boolean z2 = i == 1;
        boolean z3 = this.areCornerRadiiRtl;
        if (z2 != z3) {
            if (z2 && !z3) {
                z = true;
            }
            CornerSize cornerSize = this.shapeAppearanceModel.topLeftCornerSize;
            RectF rectF = this.tmpRectF;
            float cornerSize2 = cornerSize.getCornerSize(rectF);
            float cornerSize3 = this.shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
            float cornerSize4 = this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(rectF);
            float cornerSize5 = this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(rectF);
            float f = z ? cornerSize2 : cornerSize3;
            if (z) {
                cornerSize2 = cornerSize3;
            }
            float f2 = z ? cornerSize4 : cornerSize5;
            if (z) {
                cornerSize4 = cornerSize5;
            }
            boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
            this.areCornerRadiiRtl = zIsLayoutRtl;
            float f3 = zIsLayoutRtl ? cornerSize2 : f;
            if (!zIsLayoutRtl) {
                f = cornerSize2;
            }
            float f4 = zIsLayoutRtl ? cornerSize4 : f2;
            if (!zIsLayoutRtl) {
                f2 = cornerSize4;
            }
            MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
            if (materialShapeDrawable != null && materialShapeDrawable.drawableState.shapeAppearanceModel.topLeftCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF()) == f3) {
                MaterialShapeDrawable materialShapeDrawable2 = this.boxBackground;
                if (materialShapeDrawable2.drawableState.shapeAppearanceModel.topRightCornerSize.getCornerSize(materialShapeDrawable2.getBoundsAsRectF()) == f) {
                    MaterialShapeDrawable materialShapeDrawable3 = this.boxBackground;
                    if (materialShapeDrawable3.drawableState.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(materialShapeDrawable3.getBoundsAsRectF()) == f4) {
                        MaterialShapeDrawable materialShapeDrawable4 = this.boxBackground;
                        if (materialShapeDrawable4.drawableState.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(materialShapeDrawable4.getBoundsAsRectF()) == f2) {
                            return;
                        }
                    }
                }
            }
            ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
            builder.topLeftCornerSize = new AbsoluteCornerSize(f3);
            builder.topRightCornerSize = new AbsoluteCornerSize(f);
            builder.bottomLeftCornerSize = new AbsoluteCornerSize(f4);
            builder.bottomRightCornerSize = new AbsoluteCornerSize(f2);
            this.shapeAppearanceModel = builder.build();
            applyBoxAttributes();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = this.endIconMode != 0 && this.endIconView.checked;
        savedState.hintText = getHint();
        savedState.helperText = getHelperText();
        savedState.placeholderText = getPlaceholderText();
        return savedState;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    public final void openCutout() {
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        float f5;
        int i2;
        if (cutoutEnabled()) {
            int width = this.editText.getWidth();
            int gravity = this.editText.getGravity();
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            boolean zCalculateIsRtl = collapsingTextHelper.calculateIsRtl(collapsingTextHelper.text);
            collapsingTextHelper.isRtl = zCalculateIsRtl;
            Rect rect = collapsingTextHelper.collapsedBounds;
            if (gravity != 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (zCalculateIsRtl) {
                        i2 = rect.left;
                        f3 = i2;
                    } else {
                        f = rect.right;
                        f2 = collapsingTextHelper.collapsedTextWidth;
                    }
                } else if (zCalculateIsRtl) {
                    f = rect.right;
                    f2 = collapsingTextHelper.collapsedTextWidth;
                } else {
                    i2 = rect.left;
                    f3 = i2;
                }
                RectF rectF = this.tmpRectF;
                rectF.left = f3;
                float f6 = rect.top;
                rectF.top = f6;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f4 = (width / 2.0f) + (collapsingTextHelper.collapsedTextWidth / 2.0f);
                } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (zCalculateIsRtl) {
                        f5 = collapsingTextHelper.collapsedTextWidth;
                        f4 = f5 + f3;
                    } else {
                        i = rect.right;
                        f4 = i;
                    }
                } else if (zCalculateIsRtl) {
                    i = rect.right;
                    f4 = i;
                } else {
                    f5 = collapsingTextHelper.collapsedTextWidth;
                    f4 = f5 + f3;
                }
                rectF.right = f4;
                rectF.bottom = collapsingTextHelper.getCollapsedTextHeight() + f6;
                float f7 = rectF.left;
                float f8 = this.boxLabelCutoutPaddingPx;
                rectF.left = f7 - f8;
                rectF.right += f8;
                rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.boxStrokeWidthPx);
                CutoutDrawable cutoutDrawable = (CutoutDrawable) this.boxBackground;
                cutoutDrawable.getClass();
                cutoutDrawable.setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
            f = width / 2.0f;
            f2 = collapsingTextHelper.collapsedTextWidth / 2.0f;
            f3 = f - f2;
            RectF rectF2 = this.tmpRectF;
            rectF2.left = f3;
            float f9 = rect.top;
            rectF2.top = f9;
            if (gravity != 17) {
                f4 = (width / 2.0f) + (collapsingTextHelper.collapsedTextWidth / 2.0f);
            } else {
                f4 = (width / 2.0f) + (collapsingTextHelper.collapsedTextWidth / 2.0f);
            }
            rectF2.right = f4;
            rectF2.bottom = collapsingTextHelper.getCollapsedTextHeight() + f9;
            float f10 = rectF2.left;
            float f11 = this.boxLabelCutoutPaddingPx;
            rectF2.left = f10 - f11;
            rectF2.right += f11;
            rectF2.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF2.height() / 2.0f)) + this.boxStrokeWidthPx);
            CutoutDrawable cutoutDrawable2 = (CutoutDrawable) this.boxBackground;
            cutoutDrawable2.getClass();
            cutoutDrawable2.setCutout(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            this.focusedFilledBackgroundColor = i;
            this.hoveredFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(getContext().getColor(i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = i;
        if (this.editText != null) {
            onApplyBoxBackgroundMode();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.boxCollapsedPaddingTopPx = i;
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.boxStrokeWidthDefaultPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.boxStrokeWidthFocusedPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            IndicatorViewController indicatorViewController = this.indicatorViewController;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
                this.counterView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                indicatorViewController.addIndicator(this.counterView, 2);
                ((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                if (this.counterView != null) {
                    EditText editText = this.editText;
                    updateCounter(editText == null ? 0 : editText.getText().length());
                }
            } else {
                indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (!this.counterEnabled || this.counterView == null) {
                return;
            }
            EditText editText = this.editText;
            updateCounter(editText == null ? 0 : editText.getText().length());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.endIconView.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.endIconView.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? AbstractList.Companion.getDrawable(getContext(), i) : null);
    }

    public void setEndIconMode(int i) {
        int i2 = this.endIconMode;
        if (i2 == i) {
            return;
        }
        this.endIconMode = i;
        for (ClearTextEndIconDelegate.AnonymousClass4 anonymousClass4 : this.endIconChangedListeners) {
            switch (anonymousClass4.$r8$classId) {
                case 0:
                    ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) anonymousClass4.this$0;
                    CheckableImageButton checkableImageButton = clearTextEndIconDelegate.endIconView;
                    ClearTextEndIconDelegate.AnonymousClass2 anonymousClass2 = clearTextEndIconDelegate.onFocusChangeListener;
                    EditText editText = getEditText();
                    if (editText != null && i2 == 2) {
                        editText.post(new zzi(18, anonymousClass4, editText, false));
                        if (editText.getOnFocusChangeListener() == anonymousClass2) {
                            editText.setOnFocusChangeListener(null);
                        }
                        if (checkableImageButton.getOnFocusChangeListener() == anonymousClass2) {
                            checkableImageButton.setOnFocusChangeListener(null);
                        }
                    }
                    break;
                case 1:
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) anonymousClass4.this$0;
                    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) getEditText();
                    if (autoCompleteTextView != null && i2 == 3) {
                        autoCompleteTextView.post(new zzi(20, anonymousClass4, autoCompleteTextView, false));
                        if (autoCompleteTextView.getOnFocusChangeListener() == dropdownMenuEndIconDelegate.onFocusChangeListener) {
                            autoCompleteTextView.setOnFocusChangeListener(null);
                        }
                        autoCompleteTextView.setOnTouchListener(null);
                        autoCompleteTextView.setOnDismissListener(null);
                    }
                    if (i2 == 3) {
                        removeOnAttachStateChangeListener(dropdownMenuEndIconDelegate.onAttachStateChangeListener);
                        AccessibilityManager accessibilityManager = dropdownMenuEndIconDelegate.accessibilityManager;
                        if (accessibilityManager != null) {
                            accessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(dropdownMenuEndIconDelegate.touchExplorationStateChangeListener));
                        }
                    }
                    break;
                default:
                    EditText editText2 = getEditText();
                    if (editText2 != null && i2 == 1) {
                        editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        editText2.post(new zzi(21, anonymousClass4, editText2, false));
                    }
                    break;
            }
        }
        setEndIconVisible(i != 0);
        if (!getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i);
        }
        getEndIconDelegate().initialize();
        IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, this.endIconTintMode);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.endIconOnLongClickListener;
        CheckableImageButton checkableImageButton = this.endIconView;
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = this.endIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            IconHelper.applyIconTint(this, this.endIconView, colorStateList, this.endIconTintMode);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        if (isEndIconVisible() != z) {
            this.endIconView.setVisibility(z ? 0 : 8);
            updateEndLayoutVisibility();
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setError(CharSequence charSequence) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (!indicatorViewController.errorEnabled) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            indicatorViewController.hideError();
            return;
        }
        indicatorViewController.cancelCaptionAnimator();
        indicatorViewController.errorText = charSequence;
        indicatorViewController.errorView.setText(charSequence);
        int i = indicatorViewController.captionDisplayed;
        if (i != 1) {
            indicatorViewController.captionToShow = 1;
        }
        indicatorViewController.updateCaptionViewsVisibility(i, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.errorView, charSequence));
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorViewContentDescription = charSequence;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        TextInputLayout textInputLayout = indicatorViewController.textInputView;
        if (indicatorViewController.errorEnabled == z) {
            return;
        }
        indicatorViewController.cancelCaptionAnimator();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.context, null);
            indicatorViewController.errorView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            indicatorViewController.errorView.setTextAlignment(5);
            Typeface typeface = indicatorViewController.typeface;
            if (typeface != null) {
                indicatorViewController.errorView.setTypeface(typeface);
            }
            int i = indicatorViewController.errorTextAppearance;
            indicatorViewController.errorTextAppearance = i;
            AppCompatTextView appCompatTextView2 = indicatorViewController.errorView;
            if (appCompatTextView2 != null) {
                indicatorViewController.textInputView.setTextAppearanceCompatWithErrorFallback(appCompatTextView2, i);
            }
            ColorStateList colorStateList = indicatorViewController.errorViewTextColor;
            indicatorViewController.errorViewTextColor = colorStateList;
            AppCompatTextView appCompatTextView3 = indicatorViewController.errorView;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = indicatorViewController.errorViewContentDescription;
            indicatorViewController.errorViewContentDescription = charSequence;
            AppCompatTextView appCompatTextView4 = indicatorViewController.errorView;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            indicatorViewController.errorView.setVisibility(4);
            AppCompatTextView appCompatTextView5 = indicatorViewController.errorView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            appCompatTextView5.setAccessibilityLiveRegion(1);
            indicatorViewController.addIndicator(indicatorViewController.errorView, 0);
        } else {
            indicatorViewController.hideError();
            indicatorViewController.removeIndicator(indicatorViewController.errorView, 0);
            indicatorViewController.errorView = null;
            textInputLayout.updateEditTextBackground();
            textInputLayout.updateTextInputBoxState();
        }
        indicatorViewController.errorEnabled = z;
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? AbstractList.Companion.getDrawable(getContext(), i) : null);
        IconHelper.refreshIconDrawableState(this, this.errorIconView, this.errorIconTintList);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        View.OnLongClickListener onLongClickListener = this.errorIconOnLongClickListener;
        CheckableImageButton checkableImageButton = this.errorIconView;
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = this.errorIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        if (this.errorIconTintList != colorStateList) {
            this.errorIconTintList = colorStateList;
            IconHelper.applyIconTint(this, this.errorIconView, colorStateList, this.errorIconTintMode);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        if (this.errorIconTintMode != mode) {
            this.errorIconTintMode = mode;
            IconHelper.applyIconTint(this, this.errorIconView, this.errorIconTintList, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorTextAppearance = i;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView != null) {
            indicatorViewController.textInputView.setTextAppearanceCompatWithErrorFallback(appCompatTextView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorViewTextColor = colorStateList;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.expandedHintEnabled != z) {
            this.expandedHintEnabled = z;
            updateLabelState(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (zIsEmpty) {
            if (indicatorViewController.helperTextEnabled) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!indicatorViewController.helperTextEnabled) {
            setHelperTextEnabled(true);
        }
        indicatorViewController.cancelCaptionAnimator();
        indicatorViewController.helperText = charSequence;
        indicatorViewController.helperTextView.setText(charSequence);
        int i = indicatorViewController.captionDisplayed;
        if (i != 2) {
            indicatorViewController.captionToShow = 2;
        }
        indicatorViewController.updateCaptionViewsVisibility(i, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.helperTextView, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.helperTextViewTextColor = colorStateList;
        AppCompatTextView appCompatTextView = indicatorViewController.helperTextView;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        final IndicatorViewController indicatorViewController = this.indicatorViewController;
        TextInputLayout textInputLayout = indicatorViewController.textInputView;
        if (indicatorViewController.helperTextEnabled == z) {
            return;
        }
        indicatorViewController.cancelCaptionAnimator();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.context, null);
            indicatorViewController.helperTextView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            indicatorViewController.helperTextView.setTextAlignment(5);
            Typeface typeface = indicatorViewController.typeface;
            if (typeface != null) {
                indicatorViewController.helperTextView.setTypeface(typeface);
            }
            indicatorViewController.helperTextView.setVisibility(4);
            AppCompatTextView appCompatTextView2 = indicatorViewController.helperTextView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            appCompatTextView2.setAccessibilityLiveRegion(1);
            int i = indicatorViewController.helperTextTextAppearance;
            indicatorViewController.helperTextTextAppearance = i;
            AppCompatTextView appCompatTextView3 = indicatorViewController.helperTextView;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTextAppearance(i);
            }
            ColorStateList colorStateList = indicatorViewController.helperTextViewTextColor;
            indicatorViewController.helperTextViewTextColor = colorStateList;
            AppCompatTextView appCompatTextView4 = indicatorViewController.helperTextView;
            if (appCompatTextView4 != null && colorStateList != null) {
                appCompatTextView4.setTextColor(colorStateList);
            }
            indicatorViewController.addIndicator(indicatorViewController.helperTextView, 1);
            indicatorViewController.helperTextView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.google.android.material.textfield.IndicatorViewController.2
                @Override // android.view.View.AccessibilityDelegate
                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    EditText editText = IndicatorViewController.this.textInputView.getEditText();
                    if (editText != null) {
                        accessibilityNodeInfo.setLabeledBy(editText);
                    }
                }
            });
        } else {
            indicatorViewController.cancelCaptionAnimator();
            int i2 = indicatorViewController.captionDisplayed;
            if (i2 == 2) {
                indicatorViewController.captionToShow = 0;
            }
            indicatorViewController.updateCaptionViewsVisibility(i2, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.helperTextView, ""));
            indicatorViewController.removeIndicator(indicatorViewController.helperTextView, 1);
            indicatorViewController.helperTextView = null;
            textInputLayout.updateEditTextBackground();
            textInputLayout.updateTextInputBoxState();
        }
        indicatorViewController.helperTextEnabled = z;
    }

    public void setHelperTextTextAppearance(int i) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.helperTextTextAppearance = i;
        AppCompatTextView appCompatTextView = indicatorViewController.helperTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (z) {
                CharSequence hint = this.editText.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            } else {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        TextInputLayout textInputLayout = collapsingTextHelper.view;
        TextAppearance textAppearance = new TextAppearance(textInputLayout.getContext(), i);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            collapsingTextHelper.collapsedTextColor = colorStateList;
        }
        float f = textAppearance.textSize;
        if (f != 0.0f) {
            collapsingTextHelper.collapsedTextSize = f;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            collapsingTextHelper.collapsedShadowColor = colorStateList2;
        }
        collapsingTextHelper.collapsedShadowDx = textAppearance.shadowDx;
        collapsingTextHelper.collapsedShadowDy = textAppearance.shadowDy;
        collapsingTextHelper.collapsedShadowRadius = textAppearance.shadowRadius;
        collapsingTextHelper.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = collapsingTextHelper.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        ConnectionPool connectionPool = new ConnectionPool(collapsingTextHelper);
        textAppearance.createFallbackFont();
        collapsingTextHelper.collapsedFontCallback = new CancelableFontCallback(connectionPool, textAppearance.font);
        textAppearance.getFontAsync(textInputLayout.getContext(), collapsingTextHelper.collapsedFontCallback);
        collapsingTextHelper.recalculate(false);
        this.focusedTextColor = collapsingTextHelper.collapsedTextColor;
        if (this.editText != null) {
            updateLabelState(false, false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false, false);
            }
        }
    }

    public void setMaxEms(int i) {
        this.maxEms = i;
        EditText editText = this.editText;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
        EditText editText = this.editText;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.minEms = i;
        EditText editText = this.editText;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.minWidth = i;
        EditText editText = this.editText;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AbstractList.Companion.getDrawable(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.endIconMode != 1) {
            setEndIconMode(1);
        } else {
            if (z) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        IconHelper.applyIconTint(this, this.endIconView, colorStateList, this.endIconTintMode);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        IconHelper.applyIconTint(this, this.endIconView, this.endIconTintList, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.placeholderTextView == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
            this.placeholderTextView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            AppCompatTextView appCompatTextView2 = this.placeholderTextView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            appCompatTextView2.setImportantForAccessibility(2);
            Fade fade = new Fade();
            fade.mDuration = 87L;
            LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
            fade.mInterpolator = linearInterpolator;
            this.placeholderFadeIn = fade;
            fade.mStartDelay = 67L;
            Fade fade2 = new Fade();
            fade2.mDuration = 87L;
            fade2.mInterpolator = linearInterpolator;
            this.placeholderFadeOut = fade2;
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        EditText editText = this.editText;
        updatePlaceholderText(editText != null ? editText.getText().length() : 0);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.placeholderTextAppearance = i;
        AppCompatTextView appCompatTextView = this.placeholderTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            AppCompatTextView appCompatTextView = this.placeholderTextView;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        startCompoundLayout.getClass();
        startCompoundLayout.prefixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        startCompoundLayout.prefixTextView.setText(charSequence);
        startCompoundLayout.updateVisibility();
    }

    public void setPrefixTextAppearance(int i) {
        this.startLayout.prefixTextView.setTextAppearance(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.startLayout.prefixTextView.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.startLayout.startIconView.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? AbstractList.Companion.getDrawable(getContext(), i) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        CheckableImageButton checkableImageButton = startCompoundLayout.startIconView;
        View.OnLongClickListener onLongClickListener = startCompoundLayout.startIconOnLongClickListener;
        checkableImageButton.setOnClickListener(onClickListener);
        IconHelper.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        startCompoundLayout.startIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = startCompoundLayout.startIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        IconHelper.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (startCompoundLayout.startIconTintList != colorStateList) {
            startCompoundLayout.startIconTintList = colorStateList;
            IconHelper.applyIconTint(startCompoundLayout.textInputLayout, startCompoundLayout.startIconView, colorStateList, startCompoundLayout.startIconTintMode);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (startCompoundLayout.startIconTintMode != mode) {
            startCompoundLayout.startIconTintMode = mode;
            IconHelper.applyIconTint(startCompoundLayout.textInputLayout, startCompoundLayout.startIconView, startCompoundLayout.startIconTintList, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.startLayout.setStartIconVisible(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.suffixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public void setSuffixTextAppearance(int i) {
        this.suffixTextView.setTextAppearance(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    public final void setTextAppearanceCompatWithErrorFallback(AppCompatTextView appCompatTextView, int i) {
        try {
            appCompatTextView.setTextAppearance(i);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        appCompatTextView.setTextAppearance(R.style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(getContext().getColor(R.color.design_error));
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.editText;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.setTypefaces(typeface);
            IndicatorViewController indicatorViewController = this.indicatorViewController;
            if (typeface != indicatorViewController.typeface) {
                indicatorViewController.typeface = typeface;
                AppCompatTextView appCompatTextView = indicatorViewController.errorView;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = indicatorViewController.helperTextView;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.counterView;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        int i2 = this.counterMaxLength;
        if (i2 == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i > i2;
            Context context = getContext();
            this.counterView.setContentDescription(context.getString(this.counterOverflowed ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)));
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            String str = BidiFormatter.LRM_STRING;
            BidiFormatter bidiFormatter = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
            AppCompatTextView appCompatTextView = this.counterView;
            String string = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength));
            bidiFormatter.getClass();
            Composer composer = TextDirectionHeuristicsCompat.LTR;
            appCompatTextView.setText(string != null ? bidiFormatter.unicodeWrap(string).toString() : null);
        }
        if (this.editText == null || z == this.counterOverflowed) {
            return;
        }
        updateLabelState(false, false);
        updateTextInputBoxState();
        updateEditTextBackground();
    }

    public final void updateCounterTextAppearanceAndColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.counterView;
        if (appCompatTextView != null) {
            setTextAppearanceCompatWithErrorFallback(appCompatTextView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (!this.counterOverflowed || (colorStateList = this.counterOverflowTextColor) == null) {
                return;
            }
            this.counterView.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Code duplicated, block: B:25:0x0078  */
    public final boolean updateDummyDrawables() {
        boolean z;
        if (this.editText == null) {
            return false;
        }
        boolean z2 = true;
        if (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) {
            StartCompoundLayout startCompoundLayout = this.startLayout;
            if (startCompoundLayout.getMeasuredWidth() > 0) {
                int measuredWidth = startCompoundLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
                if (this.startDummyDrawable == null || this.startDummyDrawableWidth != measuredWidth) {
                    ColorDrawable colorDrawable = new ColorDrawable();
                    this.startDummyDrawable = colorDrawable;
                    this.startDummyDrawableWidth = measuredWidth;
                    colorDrawable.setBounds(0, 0, measuredWidth, 1);
                }
                Drawable[] compoundDrawablesRelative = this.editText.getCompoundDrawablesRelative();
                Drawable drawable = compoundDrawablesRelative[0];
                ColorDrawable colorDrawable2 = this.startDummyDrawable;
                if (drawable != colorDrawable2) {
                    this.editText.setCompoundDrawablesRelative(colorDrawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                    z = true;
                } else {
                    z = false;
                }
            } else if (this.startDummyDrawable != null) {
                Drawable[] compoundDrawablesRelative2 = this.editText.getCompoundDrawablesRelative();
                this.editText.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.startDummyDrawable = null;
                z = true;
            } else {
                z = false;
            }
        } else if (this.startDummyDrawable != null) {
            Drawable[] compoundDrawablesRelative3 = this.editText.getCompoundDrawablesRelative();
            this.editText.setCompoundDrawablesRelative(null, compoundDrawablesRelative3[1], compoundDrawablesRelative3[2], compoundDrawablesRelative3[3]);
            this.startDummyDrawable = null;
            z = true;
        } else {
            z = false;
        }
        if ((this.errorIconView.getVisibility() == 0 || ((this.endIconMode != 0 && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0) {
            int measuredWidth2 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = ((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()).getMarginStart() + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
            }
            Drawable[] compoundDrawablesRelative4 = this.editText.getCompoundDrawablesRelative();
            ColorDrawable colorDrawable3 = this.endDummyDrawable;
            if (colorDrawable3 != null && this.endDummyDrawableWidth != measuredWidth2) {
                this.endDummyDrawableWidth = measuredWidth2;
                colorDrawable3.setBounds(0, 0, measuredWidth2, 1);
                this.editText.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.endDummyDrawable, compoundDrawablesRelative4[3]);
                return true;
            }
            if (colorDrawable3 == null) {
                ColorDrawable colorDrawable4 = new ColorDrawable();
                this.endDummyDrawable = colorDrawable4;
                this.endDummyDrawableWidth = measuredWidth2;
                colorDrawable4.setBounds(0, 0, measuredWidth2, 1);
            }
            Drawable drawable2 = compoundDrawablesRelative4[2];
            ColorDrawable colorDrawable5 = this.endDummyDrawable;
            if (drawable2 != colorDrawable5) {
                this.originalEditTextEndDrawable = drawable2;
                this.editText.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], colorDrawable5, compoundDrawablesRelative4[3]);
                return true;
            }
        } else if (this.endDummyDrawable != null) {
            Drawable[] compoundDrawablesRelative5 = this.editText.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative5[2] == this.endDummyDrawable) {
                this.editText.setCompoundDrawablesRelative(compoundDrawablesRelative5[0], compoundDrawablesRelative5[1], this.originalEditTextEndDrawable, compoundDrawablesRelative5[3]);
            } else {
                z2 = z;
            }
            this.endDummyDrawable = null;
            return z2;
        }
        return z;
    }

    public final void updateEditTextBackground() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.editText;
        if (editText == null || this.boxBackgroundMode != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = DrawableUtils.CHECKED_STATE_SET;
        Drawable drawableMutate = background.mutate();
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.errorShouldBeShown()) {
            AppCompatTextView appCompatTextView2 = indicatorViewController.errorView;
            drawableMutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(appCompatTextView2 != null ? appCompatTextView2.getCurrentTextColor() : -1, PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (appCompatTextView = this.counterView) != null) {
            drawableMutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableMutate.clearColorFilter();
            this.editText.refreshDrawableState();
        }
    }

    public final void updateEndLayoutVisibility() {
        int visibility = this.endIconView.getVisibility();
        CheckableImageButton checkableImageButton = this.errorIconView;
        this.endIconFrame.setVisibility((visibility != 0 || checkableImageButton.getVisibility() == 0) ? 8 : 0);
        this.endLayout.setVisibility(isEndIconVisible() || checkableImageButton.getVisibility() == 0 || ((this.suffixText == null || this.hintExpanded) ? '\b' : (char) 0) == 0 ? 0 : 8);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    public final void updateErrorIconVisibility() {
        boolean z;
        if (getErrorIconDrawable() != null) {
            IndicatorViewController indicatorViewController = this.indicatorViewController;
            if (indicatorViewController.errorEnabled && indicatorViewController.errorShouldBeShown()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.errorIconView.setVisibility(z ? 0 : 8);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        if (this.endIconMode != 0) {
            return;
        }
        updateDummyDrawables();
    }

    public final void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            FrameLayout frameLayout = this.inputFrame;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iCalculateLabelMarginTop = calculateLabelMarginTop();
            if (iCalculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = iCalculateLabelMarginTop;
                frameLayout.requestLayout();
            }
        }
    }

    public final void updateLabelState(boolean z, boolean z2) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.editText;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.editText;
        boolean z4 = editText2 != null && editText2.hasFocus();
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        boolean zErrorShouldBeShown = indicatorViewController.errorShouldBeShown();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (colorStateList2 != null) {
            collapsingTextHelper.setCollapsedTextColor(colorStateList2);
            ColorStateList colorStateList3 = this.defaultHintTextColor;
            if (collapsingTextHelper.expandedTextColor != colorStateList3) {
                collapsingTextHelper.expandedTextColor = colorStateList3;
                collapsingTextHelper.recalculate(false);
            }
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList4 = this.defaultHintTextColor;
            int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(new int[]{-16842910}, this.disabledColor) : this.disabledColor;
            collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(colorForState);
            if (collapsingTextHelper.expandedTextColor != colorStateListValueOf) {
                collapsingTextHelper.expandedTextColor = colorStateListValueOf;
                collapsingTextHelper.recalculate(false);
            }
        } else if (zErrorShouldBeShown) {
            AppCompatTextView appCompatTextView2 = indicatorViewController.errorView;
            collapsingTextHelper.setCollapsedTextColor(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.counterOverflowed && (appCompatTextView = this.counterView) != null) {
            collapsingTextHelper.setCollapsedTextColor(appCompatTextView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (z3 || !this.expandedHintEnabled || (isEnabled() && z4)) {
            if (z2 || this.hintExpanded) {
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.animator.cancel();
                }
                if (z && this.hintAnimationEnabled) {
                    animateToExpansionFraction(1.0f);
                } else {
                    collapsingTextHelper.setExpansionFraction(1.0f);
                }
                this.hintExpanded = false;
                if (cutoutEnabled()) {
                    openCutout();
                }
                EditText editText3 = this.editText;
                updatePlaceholderText(editText3 == null ? 0 : editText3.getText().length());
                startCompoundLayout.hintExpanded = false;
                startCompoundLayout.updateVisibility();
                updateSuffixTextVisibility();
                return;
            }
            return;
        }
        if (z2 || !this.hintExpanded) {
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.animator.cancel();
            }
            if (z && this.hintAnimationEnabled) {
                animateToExpansionFraction(0.0f);
            } else {
                collapsingTextHelper.setExpansionFraction(0.0f);
            }
            if (cutoutEnabled() && !((CutoutDrawable) this.boxBackground).cutoutBounds.isEmpty() && cutoutEnabled()) {
                ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.hintExpanded = true;
            AppCompatTextView appCompatTextView3 = this.placeholderTextView;
            if (appCompatTextView3 != null && this.placeholderEnabled) {
                appCompatTextView3.setText((CharSequence) null);
                TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
                this.placeholderTextView.setVisibility(4);
            }
            startCompoundLayout.hintExpanded = true;
            startCompoundLayout.updateVisibility();
            updateSuffixTextVisibility();
        }
    }

    public final void updatePlaceholderText(int i) {
        FrameLayout frameLayout = this.inputFrame;
        if (i != 0 || this.hintExpanded) {
            AppCompatTextView appCompatTextView = this.placeholderTextView;
            if (appCompatTextView == null || !this.placeholderEnabled) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(frameLayout, this.placeholderFadeOut);
            this.placeholderTextView.setVisibility(4);
            return;
        }
        if (this.placeholderTextView == null || !this.placeholderEnabled || TextUtils.isEmpty(this.placeholderText)) {
            return;
        }
        this.placeholderTextView.setText(this.placeholderText);
        TransitionManager.beginDelayedTransition(frameLayout, this.placeholderFadeIn);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
        announceForAccessibility(this.placeholderText);
    }

    public final void updateStrokeErrorColor(boolean z, boolean z2) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z) {
            this.boxStrokeColor = colorForState2;
        } else if (z2) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    public final void updateSuffixTextViewPadding() {
        int paddingEnd;
        if (this.editText == null) {
            return;
        }
        if (isEndIconVisible() || this.errorIconView.getVisibility() == 0) {
            paddingEnd = 0;
        } else {
            EditText editText = this.editText;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = this.editText.getPaddingTop();
        int paddingBottom = this.editText.getPaddingBottom();
        WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
        this.suffixTextView.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void updateSuffixTextVisibility() {
        AppCompatTextView appCompatTextView = this.suffixTextView;
        int visibility = appCompatTextView.getVisibility();
        int i = (this.suffixText == null || this.hintExpanded) ? 8 : 0;
        if (visibility != i) {
            getEndIconDelegate().onSuffixVisibilityChanged(i == 0);
        }
        updateEndLayoutVisibility();
        appCompatTextView.setVisibility(i);
        updateDummyDrawables();
    }

    public final void updateTextInputBoxState() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.editText) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.editText) != null && editText.isHovered())) {
            z = true;
        }
        boolean zIsEnabled = isEnabled();
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (!zIsEnabled) {
            this.boxStrokeColor = this.disabledColor;
        } else if (indicatorViewController.errorShouldBeShown()) {
            if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z2, z);
            } else {
                AppCompatTextView appCompatTextView2 = indicatorViewController.errorView;
                this.boxStrokeColor = appCompatTextView2 != null ? appCompatTextView2.getCurrentTextColor() : -1;
            }
        } else if (!this.counterOverflowed || (appCompatTextView = this.counterView) == null) {
            if (z2) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
        } else if (this.strokeErrorColor != null) {
            updateStrokeErrorColor(z2, z);
        } else {
            this.boxStrokeColor = appCompatTextView.getCurrentTextColor();
        }
        updateErrorIconVisibility();
        IconHelper.refreshIconDrawableState(this, this.errorIconView, this.errorIconTintList);
        StartCompoundLayout startCompoundLayout = this.startLayout;
        IconHelper.refreshIconDrawableState(startCompoundLayout.textInputLayout, startCompoundLayout.startIconView, startCompoundLayout.startIconTintList);
        ColorStateList colorStateList = this.endIconTintList;
        CheckableImageButton checkableImageButton = this.endIconView;
        IconHelper.refreshIconDrawableState(this, checkableImageButton, colorStateList);
        EndIconDelegate endIconDelegate = getEndIconDelegate();
        endIconDelegate.getClass();
        if (endIconDelegate instanceof DropdownMenuEndIconDelegate) {
            if (!indicatorViewController.errorShouldBeShown() || getEndIconDrawable() == null) {
                IconHelper.applyIconTint(this, checkableImageButton, this.endIconTintList, this.endIconTintMode);
            } else {
                Drawable drawableMutate = getEndIconDrawable().mutate();
                AppCompatTextView appCompatTextView3 = indicatorViewController.errorView;
                drawableMutate.setTint(appCompatTextView3 != null ? appCompatTextView3.getCurrentTextColor() : -1);
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        if (this.boxBackgroundMode == 2) {
            int i = this.boxStrokeWidthPx;
            if (z2 && isEnabled()) {
                this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
            } else {
                this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
            }
            if (this.boxStrokeWidthPx != i && cutoutEnabled() && !this.hintExpanded) {
                if (cutoutEnabled()) {
                    ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
                }
                openCutout();
            }
        }
        if (this.boxBackgroundMode == 1) {
            if (!isEnabled()) {
                this.boxBackgroundColor = this.disabledFilledBackgroundColor;
            } else if (z && !z2) {
                this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
            } else if (z2) {
                this.boxBackgroundColor = this.focusedFilledBackgroundColor;
            } else {
                this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            }
        }
        applyBoxAttributes();
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.endIconView;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.applyIconTint(this, checkableImageButton, this.endIconTintList, this.endIconTintMode);
            IconHelper.refreshIconDrawableState(this, checkableImageButton, this.endIconTintList);
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.startLayout.startIconView;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.startLayout.setStartIconDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.errorIconView;
        checkableImageButton.setImageDrawable(drawable);
        updateErrorIconVisibility();
        IconHelper.applyIconTint(this, checkableImageButton, this.errorIconTintList, this.errorIconTintMode);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.TextInputLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements TextWatcher {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            switch (this.$r8$classId) {
                case 0:
                    TextInputLayout textInputLayout = (TextInputLayout) this.this$0;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState, false);
                    if (textInputLayout.counterEnabled) {
                        textInputLayout.updateCounter(editable.length());
                    }
                    if (textInputLayout.placeholderEnabled) {
                        textInputLayout.updatePlaceholderText(editable.length());
                    }
                    break;
                default:
                    ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) this.this$0;
                    if (clearTextEndIconDelegate.textInputLayout.getSuffixText() == null) {
                        clearTextEndIconDelegate.animateIcon(ClearTextEndIconDelegate.access$000(clearTextEndIconDelegate));
                        break;
                    }
                    break;
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4 = this.$r8$classId;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4 = this.$r8$classId;
        }

        private final void beforeTextChanged$com$google$android$material$textfield$ClearTextEndIconDelegate$1(int i, int i2, int i3, CharSequence charSequence) {
        }

        private final void beforeTextChanged$com$google$android$material$textfield$TextInputLayout$1(int i, int i2, int i3, CharSequence charSequence) {
        }

        private final void onTextChanged$com$google$android$material$textfield$ClearTextEndIconDelegate$1(int i, int i2, int i3, CharSequence charSequence) {
        }

        private final void onTextChanged$com$google$android$material$textfield$TextInputLayout$1(int i, int i2, int i3, CharSequence charSequence) {
        }
    }
}
