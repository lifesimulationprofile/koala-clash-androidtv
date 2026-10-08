package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TypefaceUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CollapsingTextHelper {
    public boolean boundsChanged;
    public final Rect collapsedBounds;
    public float collapsedDrawX;
    public float collapsedDrawY;
    public CancelableFontCallback collapsedFontCallback;
    public float collapsedLetterSpacing;
    public ColorStateList collapsedShadowColor;
    public float collapsedShadowDx;
    public float collapsedShadowDy;
    public float collapsedShadowRadius;
    public ColorStateList collapsedTextColor;
    public float collapsedTextWidth;
    public Typeface collapsedTypeface;
    public Typeface collapsedTypefaceBold;
    public Typeface collapsedTypefaceDefault;
    public final RectF currentBounds;
    public float currentDrawX;
    public float currentDrawY;
    public float currentLetterSpacing;
    public float currentShadowDx;
    public float currentShadowDy;
    public float currentShadowRadius;
    public float currentTextSize;
    public Typeface currentTypeface;
    public boolean drawTitle;
    public final Rect expandedBounds;
    public float expandedDrawX;
    public float expandedDrawY;
    public float expandedFraction;
    public float expandedLetterSpacing;
    public ColorStateList expandedTextColor;
    public Bitmap expandedTitleTexture;
    public Typeface expandedTypeface;
    public Typeface expandedTypefaceBold;
    public Typeface expandedTypefaceDefault;
    public boolean isRtl;
    public TimeInterpolator positionInterpolator;
    public float scale;
    public int[] state;
    public CharSequence text;
    public StaticLayout textLayout;
    public final TextPaint textPaint;
    public TimeInterpolator textSizeInterpolator;
    public CharSequence textToDraw;
    public CharSequence textToDrawCollapsed;
    public final TextPaint tmpPaint;
    public final TextInputLayout view;
    public int expandedTextGravity = 16;
    public int collapsedTextGravity = 16;
    public float expandedTextSize = 15.0f;
    public float collapsedTextSize = 15.0f;

    public CollapsingTextHelper(TextInputLayout textInputLayout) {
        this.view = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.textPaint = textPaint;
        this.tmpPaint = new TextPaint(textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        maybeUpdateFontWeightAdjustment(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int blendARGB(float f, int i, int i2) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i2) * f) + (Color.alpha(i) * f2)), Math.round((Color.red(i2) * f) + (Color.red(i) * f2)), Math.round((Color.green(i2) * f) + (Color.green(i) * f2)), Math.round((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    public static float lerp(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return AnimationUtils.lerp(f, f2, f3);
    }

    public final boolean calculateIsRtl(CharSequence charSequence) {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        return (this.view.getLayoutDirection() == 1 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, charSequence.length());
    }

    public final void calculateUsingTextSize(float f, boolean z) {
        boolean z2;
        float f2;
        float f3;
        boolean z3;
        if (this.text == null) {
            return;
        }
        float fWidth = this.collapsedBounds.width();
        float fWidth2 = this.expandedBounds.width();
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            f2 = this.collapsedTextSize;
            f3 = this.collapsedLetterSpacing;
            this.scale = 1.0f;
            Typeface typeface = this.currentTypeface;
            Typeface typeface2 = this.collapsedTypeface;
            if (typeface != typeface2) {
                this.currentTypeface = typeface2;
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            float f4 = this.expandedTextSize;
            float f5 = this.expandedLetterSpacing;
            Typeface typeface3 = this.currentTypeface;
            Typeface typeface4 = this.expandedTypeface;
            if (typeface3 != typeface4) {
                this.currentTypeface = typeface4;
                z2 = true;
            } else {
                z2 = false;
            }
            if (Math.abs(f - 0.0f) < 1.0E-5f) {
                this.scale = 1.0f;
            } else {
                this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator) / this.expandedTextSize;
            }
            float f6 = this.collapsedTextSize / this.expandedTextSize;
            fWidth = (!z && fWidth2 * f6 > fWidth) ? Math.min(fWidth / f6, fWidth2) : fWidth2;
            f2 = f4;
            f3 = f5;
            z3 = z2;
        }
        if (fWidth > 0.0f) {
            z3 = ((this.currentTextSize > f2 ? 1 : (this.currentTextSize == f2 ? 0 : -1)) != 0) || ((this.currentLetterSpacing > f3 ? 1 : (this.currentLetterSpacing == f3 ? 0 : -1)) != 0) || this.boundsChanged || z3;
            this.currentTextSize = f2;
            this.currentLetterSpacing = f3;
            this.boundsChanged = false;
        }
        if (this.textToDraw == null || z3) {
            float f7 = this.currentTextSize;
            TextPaint textPaint = this.textPaint;
            textPaint.setTextSize(f7);
            textPaint.setTypeface(this.currentTypeface);
            textPaint.setLetterSpacing(this.currentLetterSpacing);
            textPaint.setLinearText(this.scale != 1.0f);
            boolean zCalculateIsRtl = calculateIsRtl(this.text);
            this.isRtl = zCalculateIsRtl;
            Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
            StaticLayoutBuilderCompat staticLayoutBuilderCompat = new StaticLayoutBuilderCompat(this.text, textPaint, (int) fWidth);
            staticLayoutBuilderCompat.ellipsize = TextUtils.TruncateAt.END;
            staticLayoutBuilderCompat.isRtl = zCalculateIsRtl;
            staticLayoutBuilderCompat.alignment = alignment;
            staticLayoutBuilderCompat.includePad = false;
            staticLayoutBuilderCompat.maxLines = 1;
            staticLayoutBuilderCompat.lineSpacingMultiplier = 1.0f;
            staticLayoutBuilderCompat.hyphenationFrequency = 1;
            StaticLayout staticLayoutBuild = staticLayoutBuilderCompat.build();
            staticLayoutBuild.getClass();
            this.textLayout = staticLayoutBuild;
            this.textToDraw = staticLayoutBuild.getText();
        }
    }

    public final float getCollapsedTextHeight() {
        float f = this.collapsedTextSize;
        TextPaint textPaint = this.tmpPaint;
        textPaint.setTextSize(f);
        textPaint.setTypeface(this.collapsedTypeface);
        textPaint.setLetterSpacing(this.collapsedLetterSpacing);
        return -textPaint.ascent();
    }

    public final int getCurrentColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void maybeUpdateFontWeightAdjustment(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.collapsedTypefaceDefault;
            if (typeface != null) {
                this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface);
            }
            Typeface typeface2 = this.expandedTypefaceDefault;
            if (typeface2 != null) {
                this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface2);
            }
            Typeface typeface3 = this.collapsedTypefaceBold;
            if (typeface3 == null) {
                typeface3 = this.collapsedTypefaceDefault;
            }
            this.collapsedTypeface = typeface3;
            Typeface typeface4 = this.expandedTypefaceBold;
            if (typeface4 == null) {
                typeface4 = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = typeface4;
            recalculate(true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    public final void onBoundsChanged() {
        boolean z;
        Rect rect = this.collapsedBounds;
        if (rect.width() <= 0 || rect.height() <= 0) {
            z = false;
        } else {
            Rect rect2 = this.expandedBounds;
            if (rect2.width() <= 0 || rect2.height() <= 0) {
                z = false;
            } else {
                z = true;
            }
        }
        this.drawTitle = z;
    }

    public final void recalculate(boolean z) {
        StaticLayout staticLayout;
        TextInputLayout textInputLayout = this.view;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z) {
            return;
        }
        calculateUsingTextSize(1.0f, z);
        CharSequence charSequence = this.textToDraw;
        TextPaint textPaint = this.textPaint;
        if (charSequence != null && (staticLayout = this.textLayout) != null) {
            this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.textToDrawCollapsed;
        if (charSequence2 != null) {
            this.collapsedTextWidth = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.collapsedTextWidth = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int i = absoluteGravity & 112;
        Rect rect = this.collapsedBounds;
        if (i == 48) {
            this.collapsedDrawY = rect.top;
        } else if (i != 80) {
            this.collapsedDrawY = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.collapsedDrawY = textPaint.ascent() + rect.bottom;
        }
        int i2 = absoluteGravity & 8388615;
        if (i2 == 1) {
            this.collapsedDrawX = rect.centerX() - (this.collapsedTextWidth / 2.0f);
        } else if (i2 != 5) {
            this.collapsedDrawX = rect.left;
        } else {
            this.collapsedDrawX = rect.right - this.collapsedTextWidth;
        }
        calculateUsingTextSize(0.0f, z);
        StaticLayout staticLayout2 = this.textLayout;
        float height = staticLayout2 != null ? staticLayout2.getHeight() : 0.0f;
        CharSequence charSequence3 = this.textToDraw;
        float fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout3 = this.textLayout;
        if (staticLayout3 != null) {
            staticLayout3.getLineCount();
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        Rect rect2 = this.expandedBounds;
        if (i3 == 48) {
            this.expandedDrawY = rect2.top;
        } else if (i3 != 80) {
            this.expandedDrawY = rect2.centerY() - (height / 2.0f);
        } else {
            this.expandedDrawY = textPaint.descent() + (rect2.bottom - height);
        }
        int i4 = absoluteGravity2 & 8388615;
        if (i4 == 1) {
            this.expandedDrawX = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i4 != 5) {
            this.expandedDrawX = rect2.left;
        } else {
            this.expandedDrawX = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
        setInterpolatedTextSize(this.expandedFraction);
        float f = this.expandedFraction;
        float fLerp = lerp(rect2.left, rect.left, f, this.positionInterpolator);
        RectF rectF = this.currentBounds;
        rectF.left = fLerp;
        rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        rectF.right = lerp(rect2.right, rect.right, f, this.positionInterpolator);
        rectF.bottom = lerp(rect2.bottom, rect.bottom, f, this.positionInterpolator);
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        setInterpolatedTextSize(f);
        FastOutSlowInInterpolator fastOutSlowInInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        lerp(0.0f, 1.0f, 1.0f - f, fastOutSlowInInterpolator);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        textInputLayout.postInvalidateOnAnimation();
        lerp(1.0f, 0.0f, f, fastOutSlowInInterpolator);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.collapsedTextColor;
        ColorStateList colorStateList2 = this.expandedTextColor;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(blendARGB(f, getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor)));
        } else {
            textPaint.setColor(getCurrentColor(colorStateList));
        }
        float f2 = this.collapsedLetterSpacing;
        float f3 = this.expandedLetterSpacing;
        if (f2 != f3) {
            textPaint.setLetterSpacing(lerp(f3, f2, f, fastOutSlowInInterpolator));
        } else {
            textPaint.setLetterSpacing(f2);
        }
        this.currentShadowRadius = AnimationUtils.lerp(0.0f, this.collapsedShadowRadius, f);
        this.currentShadowDx = AnimationUtils.lerp(0.0f, this.collapsedShadowDx, f);
        this.currentShadowDy = AnimationUtils.lerp(0.0f, this.collapsedShadowDy, f);
        textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB(f, 0, getCurrentColor(this.collapsedShadowColor)));
        textInputLayout.postInvalidateOnAnimation();
    }

    public final void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate(false);
        }
    }

    public final boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        if (this.collapsedTypefaceDefault == typeface) {
            return false;
        }
        this.collapsedTypefaceDefault = typeface;
        Typeface typefaceMaybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.collapsedTypefaceBold = typefaceMaybeCopyWithFontWeightAdjustment;
        if (typefaceMaybeCopyWithFontWeightAdjustment == null) {
            typefaceMaybeCopyWithFontWeightAdjustment = this.collapsedTypefaceDefault;
        }
        this.collapsedTypeface = typefaceMaybeCopyWithFontWeightAdjustment;
        return true;
    }

    public final void setExpansionFraction(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.expandedFraction) {
            this.expandedFraction = f;
            Rect rect = this.expandedBounds;
            float f2 = rect.left;
            Rect rect2 = this.collapsedBounds;
            float fLerp = lerp(f2, rect2.left, f, this.positionInterpolator);
            RectF rectF = this.currentBounds;
            rectF.left = fLerp;
            rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
            rectF.right = lerp(rect.right, rect2.right, f, this.positionInterpolator);
            rectF.bottom = lerp(rect.bottom, rect2.bottom, f, this.positionInterpolator);
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
            setInterpolatedTextSize(f);
            FastOutSlowInInterpolator fastOutSlowInInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            lerp(0.0f, 1.0f, 1.0f - f, fastOutSlowInInterpolator);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            TextInputLayout textInputLayout = this.view;
            textInputLayout.postInvalidateOnAnimation();
            lerp(1.0f, 0.0f, f, fastOutSlowInInterpolator);
            textInputLayout.postInvalidateOnAnimation();
            ColorStateList colorStateList = this.collapsedTextColor;
            ColorStateList colorStateList2 = this.expandedTextColor;
            TextPaint textPaint = this.textPaint;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(blendARGB(f, getCurrentColor(colorStateList2), getCurrentColor(this.collapsedTextColor)));
            } else {
                textPaint.setColor(getCurrentColor(colorStateList));
            }
            float f3 = this.collapsedLetterSpacing;
            float f4 = this.expandedLetterSpacing;
            if (f3 != f4) {
                textPaint.setLetterSpacing(lerp(f4, f3, f, fastOutSlowInInterpolator));
            } else {
                textPaint.setLetterSpacing(f3);
            }
            this.currentShadowRadius = AnimationUtils.lerp(0.0f, this.collapsedShadowRadius, f);
            this.currentShadowDx = AnimationUtils.lerp(0.0f, this.collapsedShadowDx, f);
            this.currentShadowDy = AnimationUtils.lerp(0.0f, this.collapsedShadowDy, f);
            textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB(f, 0, getCurrentColor(this.collapsedShadowColor)));
            textInputLayout.postInvalidateOnAnimation();
        }
    }

    public final void setInterpolatedTextSize(float f) {
        calculateUsingTextSize(f, false);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        this.view.postInvalidateOnAnimation();
    }

    public final void setTypefaces(Typeface typeface) {
        boolean z;
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        if (this.expandedTypefaceDefault != typeface) {
            this.expandedTypefaceDefault = typeface;
            Typeface typefaceMaybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
            this.expandedTypefaceBold = typefaceMaybeCopyWithFontWeightAdjustment;
            if (typefaceMaybeCopyWithFontWeightAdjustment == null) {
                typefaceMaybeCopyWithFontWeightAdjustment = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = typefaceMaybeCopyWithFontWeightAdjustment;
            z = true;
        } else {
            z = false;
        }
        if (collapsedTypefaceInternal || z) {
            recalculate(false);
        }
    }
}
