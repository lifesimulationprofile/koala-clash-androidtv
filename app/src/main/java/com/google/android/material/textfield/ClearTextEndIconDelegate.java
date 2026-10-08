package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.koala.clash.R;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ClearTextEndIconDelegate extends EndIconDelegate {
    public final TextInputLayout.AnonymousClass1 clearTextEndIconTextWatcher;
    public final AnonymousClass3 clearTextOnEditTextAttachedListener;
    public final AnonymousClass4 endIconChangedListener;
    public AnimatorSet iconInAnim;
    public ValueAnimator iconOutAnim;
    public final AnonymousClass2 onFocusChangeListener;

    /* JADX INFO: renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements View.OnFocusChangeListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ EndIconDelegate this$0;

        public /* synthetic */ AnonymousClass2(EndIconDelegate endIconDelegate, int i) {
            this.$r8$classId = i;
            this.this$0 = endIconDelegate;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            switch (this.$r8$classId) {
                case 0:
                    ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) this.this$0;
                    clearTextEndIconDelegate.animateIcon(ClearTextEndIconDelegate.access$000(clearTextEndIconDelegate));
                    break;
                default:
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.this$0;
                    dropdownMenuEndIconDelegate.textInputLayout.setEndIconActivated(z);
                    if (!z) {
                        dropdownMenuEndIconDelegate.setEndIconChecked(false);
                        dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ EndIconDelegate this$0;

        public /* synthetic */ AnonymousClass3(EndIconDelegate endIconDelegate, int i) {
            this.$r8$classId = i;
            this.this$0 = endIconDelegate;
        }

        public final void onEditTextAttached(TextInputLayout textInputLayout) {
            int i = this.$r8$classId;
            EndIconDelegate endIconDelegate = this.this$0;
            switch (i) {
                case 0:
                    EditText editText = textInputLayout.getEditText();
                    ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) endIconDelegate;
                    textInputLayout.setEndIconVisible(ClearTextEndIconDelegate.access$000(clearTextEndIconDelegate));
                    AnonymousClass2 anonymousClass2 = clearTextEndIconDelegate.onFocusChangeListener;
                    editText.setOnFocusChangeListener(anonymousClass2);
                    clearTextEndIconDelegate.endIconView.setOnFocusChangeListener(anonymousClass2);
                    TextInputLayout.AnonymousClass1 anonymousClass1 = clearTextEndIconDelegate.clearTextEndIconTextWatcher;
                    editText.removeTextChangedListener(anonymousClass1);
                    editText.addTextChangedListener(anonymousClass1);
                    return;
                case 1:
                    EditText editText2 = textInputLayout.getEditText();
                    if (!(editText2 instanceof AutoCompleteTextView)) {
                        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                    }
                    final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText2;
                    final DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) endIconDelegate;
                    DropdownMenuEndIconDelegate.AnonymousClass1 anonymousClass3 = dropdownMenuEndIconDelegate.exposedDropdownEndIconTextWatcher;
                    int boxBackgroundMode = dropdownMenuEndIconDelegate.textInputLayout.getBoxBackgroundMode();
                    if (boxBackgroundMode == 2) {
                        autoCompleteTextView.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.outlinedPopupBackground);
                    } else if (boxBackgroundMode == 1) {
                        autoCompleteTextView.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.filledPopupBackground);
                    }
                    dropdownMenuEndIconDelegate.addRippleEffect(autoCompleteTextView);
                    autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.9
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 1) {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
                                long j = jCurrentTimeMillis - dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt;
                                if (j < 0 || j > 300) {
                                    dropdownMenuEndIconDelegate2.dropdownPopupDirty = false;
                                }
                                DropdownMenuEndIconDelegate.access$500(dropdownMenuEndIconDelegate2, autoCompleteTextView);
                                dropdownMenuEndIconDelegate2.dropdownPopupDirty = true;
                                dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt = System.currentTimeMillis();
                            }
                            return false;
                        }
                    });
                    autoCompleteTextView.setOnFocusChangeListener(dropdownMenuEndIconDelegate.onFocusChangeListener);
                    autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.10
                        @Override // android.widget.AutoCompleteTextView.OnDismissListener
                        public final void onDismiss() {
                            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
                            dropdownMenuEndIconDelegate2.dropdownPopupDirty = true;
                            dropdownMenuEndIconDelegate2.dropdownPopupActivatedAt = System.currentTimeMillis();
                            dropdownMenuEndIconDelegate2.setEndIconChecked(false);
                        }
                    });
                    autoCompleteTextView.setThreshold(0);
                    autoCompleteTextView.removeTextChangedListener(anonymousClass3);
                    autoCompleteTextView.addTextChangedListener(anonymousClass3);
                    textInputLayout.setEndIconCheckable(true);
                    textInputLayout.setErrorIconDrawable((Drawable) null);
                    if (autoCompleteTextView.getKeyListener() == null && dropdownMenuEndIconDelegate.accessibilityManager.isTouchExplorationEnabled()) {
                        CheckableImageButton checkableImageButton = dropdownMenuEndIconDelegate.endIconView;
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        checkableImageButton.setImportantForAccessibility(2);
                    }
                    textInputLayout.setTextInputAccessibilityDelegate(dropdownMenuEndIconDelegate.accessibilityDelegate);
                    textInputLayout.setEndIconVisible(true);
                    return;
                default:
                    EditText editText3 = textInputLayout.getEditText();
                    PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = (PasswordToggleEndIconDelegate) endIconDelegate;
                    passwordToggleEndIconDelegate.endIconView.setChecked(true ^ PasswordToggleEndIconDelegate.access$000(passwordToggleEndIconDelegate));
                    DropdownMenuEndIconDelegate.AnonymousClass1 anonymousClass4 = passwordToggleEndIconDelegate.textWatcher;
                    editText3.removeTextChangedListener(anonymousClass4);
                    editText3.addTextChangedListener(anonymousClass4);
                    return;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.ClearTextEndIconDelegate$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass4 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ EndIconDelegate this$0;

        public /* synthetic */ AnonymousClass4(EndIconDelegate endIconDelegate, int i) {
            this.$r8$classId = i;
            this.this$0 = endIconDelegate;
        }
    }

    public ClearTextEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.clearTextEndIconTextWatcher = new TextInputLayout.AnonymousClass1(1, this);
        int i2 = 0;
        this.onFocusChangeListener = new AnonymousClass2(this, i2);
        this.clearTextOnEditTextAttachedListener = new AnonymousClass3(this, i2);
        this.endIconChangedListener = new AnonymousClass4(this, i2);
    }

    public static boolean access$000(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        EditText editText = clearTextEndIconDelegate.textInputLayout.getEditText();
        if (editText != null) {
            return (editText.hasFocus() || clearTextEndIconDelegate.endIconView.hasFocus()) && editText.getText().length() > 0;
        }
        return false;
    }

    public final void animateIcon(boolean z) {
        boolean z2 = this.textInputLayout.isEndIconVisible() == z;
        if (z && !this.iconInAnim.isRunning()) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z2) {
                this.iconInAnim.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.iconInAnim.cancel();
        this.iconOutAnim.start();
        if (z2) {
            this.iconOutAnim.end();
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        int i = this.customEndIcon;
        if (i == 0) {
            i = R.drawable.mtrl_ic_cancel;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(i);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        final int i2 = 0;
        textInputLayout.setEndIconCheckable(false);
        textInputLayout.setEndIconOnClickListener(new Toolbar.AnonymousClass4(5, this));
        LinkedHashSet linkedHashSet = textInputLayout.editTextAttachedListeners;
        AnonymousClass3 anonymousClass3 = this.clearTextOnEditTextAttachedListener;
        linkedHashSet.add(anonymousClass3);
        if (textInputLayout.editText != null) {
            anonymousClass3.onEditTextAttached(textInputLayout);
        }
        textInputLayout.endIconChangedListeners.add(this.endIconChangedListener);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(150L);
        final int i3 = 1;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i3) {
                    case 0:
                        this.this$0.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        ClearTextEndIconDelegate clearTextEndIconDelegate = this.this$0;
                        clearTextEndIconDelegate.endIconView.setScaleX(fFloatValue);
                        clearTextEndIconDelegate.endIconView.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat2.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        this.this$0.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        ClearTextEndIconDelegate clearTextEndIconDelegate = this.this$0;
                        clearTextEndIconDelegate.endIconView.setScaleX(fFloatValue);
                        clearTextEndIconDelegate.endIconView.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.iconInAnim.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.6
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                switch (i2) {
                    case 1:
                        this.this$0.textInputLayout.setEndIconVisible(false);
                        break;
                    default:
                        super.onAnimationEnd(animator);
                        break;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                switch (i2) {
                    case 0:
                        this.this$0.textInputLayout.setEndIconVisible(true);
                        break;
                    default:
                        super.onAnimationStart(animator);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        this.this$0.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        ClearTextEndIconDelegate clearTextEndIconDelegate = this.this$0;
                        clearTextEndIconDelegate.endIconView.setScaleX(fFloatValue);
                        clearTextEndIconDelegate.endIconView.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.iconOutAnim = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.6
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                switch (i3) {
                    case 1:
                        this.this$0.textInputLayout.setEndIconVisible(false);
                        break;
                    default:
                        super.onAnimationEnd(animator);
                        break;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                switch (i3) {
                    case 0:
                        this.this$0.textInputLayout.setEndIconVisible(true);
                        break;
                    default:
                        super.onAnimationStart(animator);
                        break;
                }
            }
        });
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void onSuffixVisibilityChanged(boolean z) {
        if (this.textInputLayout.getSuffixText() == null) {
            return;
        }
        animateIcon(z);
    }
}
