package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.MaterialResources;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IndicatorViewController {
    public AnimatorSet captionAnimator;
    public FrameLayout captionArea;
    public int captionDisplayed;
    public int captionToShow;
    public final float captionTranslationYPx;
    public final Context context;
    public boolean errorEnabled;
    public CharSequence errorText;
    public int errorTextAppearance;
    public AppCompatTextView errorView;
    public CharSequence errorViewContentDescription;
    public ColorStateList errorViewTextColor;
    public CharSequence helperText;
    public boolean helperTextEnabled;
    public int helperTextTextAppearance;
    public AppCompatTextView helperTextView;
    public ColorStateList helperTextViewTextColor;
    public LinearLayout indicatorArea;
    public int indicatorsAdded;
    public final TextInputLayout textInputView;
    public Typeface typeface;

    public IndicatorViewController(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.context = context;
        this.textInputView = textInputLayout;
        this.captionTranslationYPx = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public final void addIndicator(AppCompatTextView appCompatTextView, int i) {
        if (this.indicatorArea == null && this.captionArea == null) {
            Context context = this.context;
            LinearLayout linearLayout = new LinearLayout(context);
            this.indicatorArea = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.indicatorArea;
            TextInputLayout textInputLayout = this.textInputView;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.captionArea = new FrameLayout(context);
            this.indicatorArea.addView(this.captionArea, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                adjustIndicatorPadding();
            }
        }
        if (i == 0 || i == 1) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(appCompatTextView);
        } else {
            this.indicatorArea.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
    }

    public final void adjustIndicatorPadding() {
        if (this.indicatorArea != null) {
            TextInputLayout textInputLayout = this.textInputView;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.context;
                boolean zIsFontScaleAtLeast1_3 = MaterialResources.isFontScaleAtLeast1_3(context);
                LinearLayout linearLayout = this.indicatorArea;
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                int paddingStart = editText.getPaddingStart();
                if (zIsFontScaleAtLeast1_3) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zIsFontScaleAtLeast1_3) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (zIsFontScaleAtLeast1_3) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void cancelCaptionAnimator() {
        AnimatorSet animatorSet = this.captionAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void createCaptionAnimators(ArrayList arrayList, boolean z, AppCompatTextView appCompatTextView, int i, int i2, int i3) {
        if (appCompatTextView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, i3 == i ? 1.0f : 0.0f);
            objectAnimatorOfFloat.setDuration(167L);
            objectAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            arrayList.add(objectAnimatorOfFloat);
            if (i3 == i) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.captionTranslationYPx, 0.0f);
                objectAnimatorOfFloat2.setDuration(217L);
                objectAnimatorOfFloat2.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                arrayList.add(objectAnimatorOfFloat2);
            }
        }
    }

    public final boolean errorShouldBeShown() {
        return (this.captionToShow != 1 || this.errorView == null || TextUtils.isEmpty(this.errorText)) ? false : true;
    }

    public final TextView getCaptionViewFromDisplayState(int i) {
        if (i == 1) {
            return this.errorView;
        }
        if (i != 2) {
            return null;
        }
        return this.helperTextView;
    }

    public final void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) {
            if (!this.helperTextEnabled || TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 0;
            } else {
                this.captionToShow = 2;
            }
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, ""));
    }

    public final void removeIndicator(AppCompatTextView appCompatTextView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.indicatorArea;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.captionArea) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i2 = this.indicatorsAdded - 1;
        this.indicatorsAdded = i2;
        LinearLayout linearLayout2 = this.indicatorArea;
        if (i2 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean shouldAnimateCaptionView(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        TextInputLayout textInputLayout = this.textInputView;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.captionToShow == this.captionDisplayed && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void updateCaptionViewsVisibility(final int i, final int i2, boolean z) {
        TextView captionViewFromDisplayState;
        TextView captionViewFromDisplayState2;
        IndicatorViewController indicatorViewController = this;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            indicatorViewController.captionAnimator = animatorSet;
            ArrayList arrayList = new ArrayList();
            indicatorViewController.createCaptionAnimators(arrayList, indicatorViewController.helperTextEnabled, indicatorViewController.helperTextView, 2, i, i2);
            indicatorViewController.createCaptionAnimators(arrayList, indicatorViewController.errorEnabled, indicatorViewController.errorView, 1, i, i2);
            int size = arrayList.size();
            long jMax = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Animator animator = (Animator) arrayList.get(i3);
                jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
            valueAnimatorOfInt.setDuration(jMax);
            arrayList.add(0, valueAnimatorOfInt);
            animatorSet.playTogether(arrayList);
            final TextView captionViewFromDisplayState3 = getCaptionViewFromDisplayState(i);
            final TextView captionViewFromDisplayState4 = indicatorViewController.getCaptionViewFromDisplayState(i2);
            indicatorViewController = this;
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.IndicatorViewController.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    AppCompatTextView appCompatTextView;
                    int i4 = i2;
                    IndicatorViewController indicatorViewController2 = IndicatorViewController.this;
                    indicatorViewController2.captionDisplayed = i4;
                    indicatorViewController2.captionAnimator = null;
                    TextView textView = captionViewFromDisplayState3;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (i == 1 && (appCompatTextView = indicatorViewController2.errorView) != null) {
                            appCompatTextView.setText((CharSequence) null);
                        }
                    }
                    TextView textView2 = captionViewFromDisplayState4;
                    if (textView2 != null) {
                        textView2.setTranslationY(0.0f);
                        textView2.setAlpha(1.0f);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator2) {
                    TextView textView = captionViewFromDisplayState4;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (captionViewFromDisplayState2 = indicatorViewController.getCaptionViewFromDisplayState(i2)) != null) {
                captionViewFromDisplayState2.setVisibility(0);
                captionViewFromDisplayState2.setAlpha(1.0f);
            }
            if (i != 0 && (captionViewFromDisplayState = getCaptionViewFromDisplayState(i)) != null) {
                captionViewFromDisplayState.setVisibility(4);
                if (i == 1) {
                    captionViewFromDisplayState.setText((CharSequence) null);
                }
            }
            indicatorViewController.captionDisplayed = i2;
        }
        TextInputLayout textInputLayout = indicatorViewController.textInputView;
        textInputLayout.updateEditTextBackground();
        textInputLayout.updateLabelState(z, false);
        textInputLayout.updateTextInputBoxState();
    }
}
