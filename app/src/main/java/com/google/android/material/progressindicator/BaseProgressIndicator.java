package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProgressIndicator extends ProgressBar {
    public AnimatorDurationScaleProvider animatorDurationScaleProvider;
    public final AnonymousClass1 delayedHide;
    public final AnonymousClass1 delayedShow;
    public final AnonymousClass3 hideAnimationCallback;
    public boolean isIndeterminateModeChangeRequested;
    public final boolean isParentDoneInitializing;
    public final int minHideDelay;
    public final LinearProgressIndicatorSpec spec;
    public int storedProgress;
    public final AnonymousClass3 switchIndeterminateModeCallback;
    public int visibilityAfterHide;

    /* JADX INFO: renamed from: com.google.android.material.progressindicator.BaseProgressIndicator$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ BaseProgressIndicator this$0;

        public /* synthetic */ AnonymousClass3(BaseProgressIndicator baseProgressIndicator, int i) {
            this.$r8$classId = i;
            this.this$0 = baseProgressIndicator;
        }

        public final void onAnimationEnd() {
            switch (this.$r8$classId) {
                case 0:
                    BaseProgressIndicator baseProgressIndicator = this.this$0;
                    baseProgressIndicator.setIndeterminate(false);
                    baseProgressIndicator.setProgressCompat(baseProgressIndicator.storedProgress);
                    break;
                default:
                    BaseProgressIndicator baseProgressIndicator2 = this.this$0;
                    if (!baseProgressIndicator2.isIndeterminateModeChangeRequested) {
                        baseProgressIndicator2.setVisibility(baseProgressIndicator2.visibilityAfterHide);
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.material.progressindicator.BaseProgressIndicator$1] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.material.progressindicator.BaseProgressIndicator$1] */
    public BaseProgressIndicator(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_ProgressIndicator), attributeSet, R.attr.linearProgressIndicatorStyle);
        this.isIndeterminateModeChangeRequested = false;
        this.visibilityAfterHide = 4;
        final int i = 0;
        this.delayedShow = new Runnable(this) { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            public final /* synthetic */ BaseProgressIndicator this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        BaseProgressIndicator baseProgressIndicator = this.this$0;
                        if (baseProgressIndicator.minHideDelay > 0) {
                            SystemClock.uptimeMillis();
                        }
                        baseProgressIndicator.setVisibility(0);
                        break;
                    default:
                        BaseProgressIndicator baseProgressIndicator2 = this.this$0;
                        ((DrawableWithAnimatedVisibilityChange) baseProgressIndicator2.getCurrentDrawable()).setVisible(false, false, true);
                        if ((baseProgressIndicator2.getProgressDrawable() == null || !baseProgressIndicator2.getProgressDrawable().isVisible()) && (baseProgressIndicator2.getIndeterminateDrawable() == null || !baseProgressIndicator2.getIndeterminateDrawable().isVisible())) {
                            baseProgressIndicator2.setVisibility(4);
                        }
                        baseProgressIndicator2.getClass();
                        break;
                }
            }
        };
        final int i2 = 1;
        this.delayedHide = new Runnable(this) { // from class: com.google.android.material.progressindicator.BaseProgressIndicator.1
            public final /* synthetic */ BaseProgressIndicator this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        BaseProgressIndicator baseProgressIndicator = this.this$0;
                        if (baseProgressIndicator.minHideDelay > 0) {
                            SystemClock.uptimeMillis();
                        }
                        baseProgressIndicator.setVisibility(0);
                        break;
                    default:
                        BaseProgressIndicator baseProgressIndicator2 = this.this$0;
                        ((DrawableWithAnimatedVisibilityChange) baseProgressIndicator2.getCurrentDrawable()).setVisible(false, false, true);
                        if ((baseProgressIndicator2.getProgressDrawable() == null || !baseProgressIndicator2.getProgressDrawable().isVisible()) && (baseProgressIndicator2.getIndeterminateDrawable() == null || !baseProgressIndicator2.getIndeterminateDrawable().isVisible())) {
                            baseProgressIndicator2.setVisibility(4);
                        }
                        baseProgressIndicator2.getClass();
                        break;
                }
            }
        };
        this.switchIndeterminateModeCallback = new AnonymousClass3(this, 0);
        this.hideAnimationCallback = new AnonymousClass3(this, 1);
        Context context2 = getContext();
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = new LinearProgressIndicatorSpec();
        linearProgressIndicatorSpec.indicatorColors = new int[0];
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        ViewUtils.checkCompatibleTheme(context2, attributeSet, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        int[] iArr = R$styleable.BaseProgressIndicator;
        ViewUtils.checkTextAppearance(context2, attributeSet, iArr, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        linearProgressIndicatorSpec.trackThickness = MaterialResources.getDimensionPixelSize(context2, typedArrayObtainStyledAttributes, 8, dimensionPixelSize);
        linearProgressIndicatorSpec.trackCornerRadius = Math.min(MaterialResources.getDimensionPixelSize(context2, typedArrayObtainStyledAttributes, 7, 0), linearProgressIndicatorSpec.trackThickness / 2);
        linearProgressIndicatorSpec.showAnimationBehavior = typedArrayObtainStyledAttributes.getInt(4, 0);
        linearProgressIndicatorSpec.hideAnimationBehavior = typedArrayObtainStyledAttributes.getInt(1, 0);
        if (!typedArrayObtainStyledAttributes.hasValue(2)) {
            linearProgressIndicatorSpec.indicatorColors = new int[]{MaterialColors.getColor(context2, R.attr.colorPrimary, -1)};
        } else if (typedArrayObtainStyledAttributes.peekValue(2).type != 1) {
            linearProgressIndicatorSpec.indicatorColors = new int[]{typedArrayObtainStyledAttributes.getColor(2, -1)};
        } else {
            int[] intArray = context2.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(2, -1));
            linearProgressIndicatorSpec.indicatorColors = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            linearProgressIndicatorSpec.trackColor = typedArrayObtainStyledAttributes.getColor(6, -1);
        } else {
            linearProgressIndicatorSpec.trackColor = linearProgressIndicatorSpec.indicatorColors[0];
            TypedArray typedArrayObtainStyledAttributes2 = context2.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
            float f = typedArrayObtainStyledAttributes2.getFloat(0, 0.2f);
            typedArrayObtainStyledAttributes2.recycle();
            linearProgressIndicatorSpec.trackColor = MaterialColors.compositeARGBWithAlpha(linearProgressIndicatorSpec.trackColor, (int) (f * 255.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
        ViewUtils.checkCompatibleTheme(context2, attributeSet, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        int[] iArr2 = R$styleable.LinearProgressIndicator;
        ViewUtils.checkTextAppearance(context2, attributeSet, iArr2, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator, new int[0]);
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr2, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        linearProgressIndicatorSpec.indeterminateAnimationType = typedArrayObtainStyledAttributes3.getInt(0, 1);
        linearProgressIndicatorSpec.indicatorDirection = typedArrayObtainStyledAttributes3.getInt(1, 0);
        typedArrayObtainStyledAttributes3.recycle();
        linearProgressIndicatorSpec.validateSpec();
        linearProgressIndicatorSpec.drawHorizontallyInverse = linearProgressIndicatorSpec.indicatorDirection == 1;
        this.spec = linearProgressIndicatorSpec;
        ViewUtils.checkCompatibleTheme(context2, attributeSet, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        ViewUtils.checkTextAppearance(context2, attributeSet, iArr, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator, new int[0]);
        TypedArray typedArrayObtainStyledAttributes4 = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        typedArrayObtainStyledAttributes4.getInt(5, -1);
        this.minHideDelay = Math.min(typedArrayObtainStyledAttributes4.getInt(3, -1), 1000);
        typedArrayObtainStyledAttributes4.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    private DrawingDelegate getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().drawingDelegate;
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().drawingDelegate;
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    public int getTrackColor() {
        return this.spec.trackColor;
    }

    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().animatorDelegate.registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
        }
        DeterminateDrawable progressDrawable = getProgressDrawable();
        AnonymousClass3 anonymousClass3 = this.hideAnimationCallback;
        if (progressDrawable != null) {
            DeterminateDrawable progressDrawable2 = getProgressDrawable();
            if (progressDrawable2.animationCallbacks == null) {
                progressDrawable2.animationCallbacks = new ArrayList();
            }
            if (!progressDrawable2.animationCallbacks.contains(anonymousClass3)) {
                progressDrawable2.animationCallbacks.add(anonymousClass3);
            }
        }
        if (getIndeterminateDrawable() != null) {
            IndeterminateDrawable indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable.animationCallbacks == null) {
                indeterminateDrawable.animationCallbacks = new ArrayList();
            }
            if (!indeterminateDrawable.animationCallbacks.contains(anonymousClass3)) {
                indeterminateDrawable.animationCallbacks.add(anonymousClass3);
            }
        }
        if (visibleToUser()) {
            if (this.minHideDelay > 0) {
                SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, false);
        IndeterminateDrawable indeterminateDrawable = getIndeterminateDrawable();
        AnonymousClass3 anonymousClass3 = this.hideAnimationCallback;
        if (indeterminateDrawable != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(anonymousClass3);
            getIndeterminateDrawable().animatorDelegate.unregisterAnimatorsCompleteCallback();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(anonymousClass3);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
            DrawingDelegate currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            int i3 = ((LinearDrawingDelegate) currentDrawingDelegate).spec.trackThickness;
            setMeasuredDimension(getMeasuredWidth(), i3 < 0 ? getMeasuredHeight() : i3 + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        boolean z = i == 0;
        if (this.isParentDoneInitializing) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.isParentDoneInitializing) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, false);
        }
    }

    public void setAnimatorDurationScaleProvider(AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.animatorDurationScaleProvider = animatorDurationScaleProvider;
        if (getProgressDrawable() != null) {
            getProgressDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider;
        }
    }

    public void setHideAnimationBehavior(int i) {
        this.spec.hideAnimationBehavior = i;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        try {
            if (z == isIndeterminate()) {
                return;
            }
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange != null) {
                drawableWithAnimatedVisibilityChange.setVisible(false, false, false);
            }
            super.setIndeterminate(z);
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange2 != null) {
                drawableWithAnimatedVisibilityChange2.setVisible(visibleToUser(), false, false);
            }
            if ((drawableWithAnimatedVisibilityChange2 instanceof IndeterminateDrawable) && visibleToUser()) {
                ((IndeterminateDrawable) drawableWithAnimatedVisibilityChange2).animatorDelegate.startAnimator();
            }
            this.isIndeterminateModeChangeRequested = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof IndeterminateDrawable)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((DrawableWithAnimatedVisibilityChange) drawable).setVisible(false, false, false);
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.spec.indicatorColors = iArr;
        getIndeterminateDrawable().animatorDelegate.invalidateSpecValues();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i);
    }

    public void setProgressCompat(int i) {
        if (!isIndeterminate()) {
            super.setProgress(i);
            if (getProgressDrawable() != null) {
                getProgressDrawable().jumpToCurrentState();
                return;
            }
            return;
        }
        if (getProgressDrawable() != null) {
            this.storedProgress = i;
            this.isIndeterminateModeChangeRequested = true;
            if (getIndeterminateDrawable().isVisible()) {
                AnimatorDurationScaleProvider animatorDurationScaleProvider = this.animatorDurationScaleProvider;
                ContentResolver contentResolver = getContext().getContentResolver();
                animatorDurationScaleProvider.getClass();
                if (Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) != 0.0f) {
                    getIndeterminateDrawable().animatorDelegate.requestCancelAnimatorAfterCurrentCycle();
                    return;
                }
            }
            getIndeterminateDrawable();
            this.switchIndeterminateModeCallback.onAnimationEnd();
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof DeterminateDrawable)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.setVisible(false, false, false);
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.setLevel((int) ((getProgress() / getMax()) * 10000.0f));
        }
    }

    public void setShowAnimationBehavior(int i) {
        this.spec.showAnimationBehavior = i;
        invalidate();
    }

    public void setTrackColor(int i) {
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.spec;
        if (linearProgressIndicatorSpec.trackColor != i) {
            linearProgressIndicatorSpec.trackColor = i;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i) {
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.spec;
        if (linearProgressIndicatorSpec.trackCornerRadius != i) {
            linearProgressIndicatorSpec.trackCornerRadius = Math.min(i, linearProgressIndicatorSpec.trackThickness / 2);
        }
    }

    public void setTrackThickness(int i) {
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.spec;
        if (linearProgressIndicatorSpec.trackThickness != i) {
            linearProgressIndicatorSpec.trackThickness = i;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i) {
        if (i != 0 && i != 4 && i != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.visibilityAfterHide = i;
    }

    public final boolean visibleToUser() {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (!isAttachedToWindow() || getWindowVisibility() != 0) {
            return false;
        }
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar
    public IndeterminateDrawable getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public DeterminateDrawable getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
