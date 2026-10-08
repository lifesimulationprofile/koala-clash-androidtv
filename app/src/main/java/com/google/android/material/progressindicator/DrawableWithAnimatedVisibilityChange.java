package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import androidx.transition.ViewUtils;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable {
    public static final ViewUtils.AnonymousClass1 GROW_FRACTION = new ViewUtils.AnonymousClass1(Float.class, "growFraction", 8);
    public ArrayList animationCallbacks;
    public final LinearProgressIndicatorSpec baseSpec;
    public final Context context;
    public float growFraction;
    public ObjectAnimator hideAnimator;
    public boolean ignoreCallbacks;
    public ObjectAnimator showAnimator;
    public int totalAlpha;
    public final Paint paint = new Paint();
    public AnimatorDurationScaleProvider animatorDurationScaleProvider = new AnimatorDurationScaleProvider();

    public DrawableWithAnimatedVisibilityChange(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        this.context = context;
        this.baseSpec = linearProgressIndicatorSpec;
        setAlpha(255);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.totalAlpha;
    }

    public final float getGrowFraction() {
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.baseSpec;
        if (linearProgressIndicatorSpec.showAnimationBehavior == 0 && linearProgressIndicatorSpec.hideAnimationBehavior == 0) {
            return 1.0f;
        }
        return this.growFraction;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ObjectAnimator objectAnimator = this.showAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return true;
        }
        ObjectAnimator objectAnimator2 = this.hideAnimator;
        return objectAnimator2 != null && objectAnimator2.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.totalAlpha = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return setVisible(z, z2, true);
    }

    public boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        ObjectAnimator objectAnimator = this.showAnimator;
        final int i = 0;
        ViewUtils.AnonymousClass1 anonymousClass1 = GROW_FRACTION;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, anonymousClass1, 0.0f, 1.0f);
            this.showAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            ObjectAnimator objectAnimator2 = this.showAnimator;
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.showAnimator = objectAnimator2;
            objectAnimator2.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.1
                public final /* synthetic */ DrawableWithAnimatedVisibilityChange this$0;

                {
                    this.this$0 = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    switch (i) {
                        case 1:
                            super.onAnimationEnd(animator);
                            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = this.this$0;
                            DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                            ArrayList arrayList = drawableWithAnimatedVisibilityChange.animationCallbacks;
                            if (arrayList != null && !drawableWithAnimatedVisibilityChange.ignoreCallbacks) {
                                int size = arrayList.size();
                                int i2 = 0;
                                while (i2 < size) {
                                    Object obj = arrayList.get(i2);
                                    i2++;
                                    ((BaseProgressIndicator.AnonymousClass3) obj).onAnimationEnd();
                                }
                                break;
                            }
                            break;
                        default:
                            super.onAnimationEnd(animator);
                            break;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    switch (i) {
                        case 0:
                            super.onAnimationStart(animator);
                            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = this.this$0;
                            ArrayList arrayList = drawableWithAnimatedVisibilityChange.animationCallbacks;
                            if (arrayList != null && !drawableWithAnimatedVisibilityChange.ignoreCallbacks) {
                                int size = arrayList.size();
                                int i2 = 0;
                                while (i2 < size) {
                                    Object obj = arrayList.get(i2);
                                    i2++;
                                    ((BaseProgressIndicator.AnonymousClass3) obj).getClass();
                                }
                                break;
                            }
                            break;
                        default:
                            super.onAnimationStart(animator);
                            break;
                    }
                }
            });
        }
        final int i2 = 1;
        if (this.hideAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, anonymousClass1, 1.0f, 0.0f);
            this.hideAnimator = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            ObjectAnimator objectAnimator3 = this.hideAnimator;
            if (objectAnimator3 != null && objectAnimator3.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.hideAnimator = objectAnimator3;
            objectAnimator3.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.1
                public final /* synthetic */ DrawableWithAnimatedVisibilityChange this$0;

                {
                    this.this$0 = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    switch (i2) {
                        case 1:
                            super.onAnimationEnd(animator);
                            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = this.this$0;
                            DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                            ArrayList arrayList = drawableWithAnimatedVisibilityChange.animationCallbacks;
                            if (arrayList != null && !drawableWithAnimatedVisibilityChange.ignoreCallbacks) {
                                int size = arrayList.size();
                                int i3 = 0;
                                while (i3 < size) {
                                    Object obj = arrayList.get(i3);
                                    i3++;
                                    ((BaseProgressIndicator.AnonymousClass3) obj).onAnimationEnd();
                                }
                                break;
                            }
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
                            super.onAnimationStart(animator);
                            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = this.this$0;
                            ArrayList arrayList = drawableWithAnimatedVisibilityChange.animationCallbacks;
                            if (arrayList != null && !drawableWithAnimatedVisibilityChange.ignoreCallbacks) {
                                int size = arrayList.size();
                                int i3 = 0;
                                while (i3 < size) {
                                    Object obj = arrayList.get(i3);
                                    i3++;
                                    ((BaseProgressIndicator.AnonymousClass3) obj).getClass();
                                }
                                break;
                            }
                            break;
                        default:
                            super.onAnimationStart(animator);
                            break;
                    }
                }
            });
        }
        if (isVisible() || z) {
            ObjectAnimator objectAnimator4 = z ? this.showAnimator : this.hideAnimator;
            if (!z3) {
                if (objectAnimator4.isRunning()) {
                    objectAnimator4.end();
                } else {
                    boolean z4 = this.ignoreCallbacks;
                    this.ignoreCallbacks = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.ignoreCallbacks = z4;
                }
                return super.setVisible(z, false);
            }
            if (!z3 || !objectAnimator4.isRunning()) {
                boolean z5 = !z || super.setVisible(z, false);
                LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.baseSpec;
                if (!z ? linearProgressIndicatorSpec.hideAnimationBehavior != 0 : linearProgressIndicatorSpec.showAnimationBehavior != 0) {
                    boolean z6 = this.ignoreCallbacks;
                    this.ignoreCallbacks = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.ignoreCallbacks = z6;
                    return z5;
                }
                if (z2 || !objectAnimator4.isPaused()) {
                    objectAnimator4.start();
                    return z5;
                }
                objectAnimator4.resume();
                return z5;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        setVisibleInternal(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        setVisibleInternal(false, true, false);
    }

    public final void unregisterAnimationCallback(BaseProgressIndicator.AnonymousClass3 anonymousClass3) {
        ArrayList arrayList = this.animationCallbacks;
        if (arrayList == null || !arrayList.contains(anonymousClass3)) {
            return;
        }
        this.animationCallbacks.remove(anonymousClass3);
        if (this.animationCallbacks.isEmpty()) {
            this.animationCallbacks = null;
        }
    }

    public final boolean setVisible(boolean z, boolean z2, boolean z3) {
        AnimatorDurationScaleProvider animatorDurationScaleProvider = this.animatorDurationScaleProvider;
        ContentResolver contentResolver = this.context.getContentResolver();
        animatorDurationScaleProvider.getClass();
        return setVisibleInternal(z, z2, z3 && Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) > 0.0f);
    }
}
