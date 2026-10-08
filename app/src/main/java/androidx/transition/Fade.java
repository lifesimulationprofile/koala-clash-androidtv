package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.koala.clash.R;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Fade extends Transition {
    public static final String[] sTransitionProperties = {"android:visibility:visibility", "android:visibility:parent"};
    public final int mMode;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class FadeAnimatorListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public boolean mLayerTypeChanged = false;
        public final View mView;

        public FadeAnimatorListener(View view) {
            this.mView = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            ViewUtils.IMPL.setTransitionAlpha(this.mView, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            View view = this.mView;
            if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                view.setLayerType(2, null);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition transition) {
            throw null;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionPause() {
            View view = this.mView;
            view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? ViewUtils.IMPL.getTransitionAlpha(view) : 0.0f));
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionResume() {
            this.mView.setTag(R.id.transition_pause_alpha, null);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition transition) {
            throw null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            boolean z2 = this.mLayerTypeChanged;
            View view = this.mView;
            if (z2) {
                view.setLayerType(0, null);
            }
            if (z) {
                return;
            }
            ViewUtilsApi23 viewUtilsApi23 = ViewUtils.IMPL;
            viewUtilsApi23.setTransitionAlpha(view, 1.0f);
            viewUtilsApi23.getClass();
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd$1(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionStart$1(Transition transition) {
        }
    }

    public Fade(int i) {
        this();
        this.mMode = i;
    }

    public static void captureValues$1(TransitionValues transitionValues) {
        View view = transitionValues.view;
        int visibility = view.getVisibility();
        HashMap map = transitionValues.values;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float getStartAlpha(TransitionValues transitionValues, float f) {
        Float f2;
        return (transitionValues == null || (f2 = (Float) transitionValues.values.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0052  */
    /* JADX WARN: Code duplicated, block: B:7:0x002f  */
    public static Visibility$VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Visibility$VisibilityInfo visibility$VisibilityInfo = new Visibility$VisibilityInfo();
        visibility$VisibilityInfo.mVisibilityChange = false;
        visibility$VisibilityInfo.mFadeIn = false;
        if (transitionValues != null) {
            HashMap map = transitionValues.values;
            if (map.containsKey("android:visibility:visibility")) {
                visibility$VisibilityInfo.mStartVisibility = ((Integer) map.get("android:visibility:visibility")).intValue();
                visibility$VisibilityInfo.mStartParent = (ViewGroup) map.get("android:visibility:parent");
            } else {
                visibility$VisibilityInfo.mStartVisibility = -1;
                visibility$VisibilityInfo.mStartParent = null;
            }
        } else {
            visibility$VisibilityInfo.mStartVisibility = -1;
            visibility$VisibilityInfo.mStartParent = null;
        }
        if (transitionValues2 != null) {
            HashMap map2 = transitionValues2.values;
            if (map2.containsKey("android:visibility:visibility")) {
                visibility$VisibilityInfo.mEndVisibility = ((Integer) map2.get("android:visibility:visibility")).intValue();
                visibility$VisibilityInfo.mEndParent = (ViewGroup) map2.get("android:visibility:parent");
            } else {
                visibility$VisibilityInfo.mEndVisibility = -1;
                visibility$VisibilityInfo.mEndParent = null;
            }
        } else {
            visibility$VisibilityInfo.mEndVisibility = -1;
            visibility$VisibilityInfo.mEndParent = null;
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i = visibility$VisibilityInfo.mStartVisibility;
            int i2 = visibility$VisibilityInfo.mEndVisibility;
            if (i != i2 || visibility$VisibilityInfo.mStartParent != visibility$VisibilityInfo.mEndParent) {
                if (i != i2) {
                    if (i == 0) {
                        visibility$VisibilityInfo.mFadeIn = false;
                        visibility$VisibilityInfo.mVisibilityChange = true;
                        return visibility$VisibilityInfo;
                    }
                    if (i2 == 0) {
                        visibility$VisibilityInfo.mFadeIn = true;
                        visibility$VisibilityInfo.mVisibilityChange = true;
                        return visibility$VisibilityInfo;
                    }
                } else {
                    if (visibility$VisibilityInfo.mEndParent == null) {
                        visibility$VisibilityInfo.mFadeIn = false;
                        visibility$VisibilityInfo.mVisibilityChange = true;
                        return visibility$VisibilityInfo;
                    }
                    if (visibility$VisibilityInfo.mStartParent == null) {
                        visibility$VisibilityInfo.mFadeIn = true;
                        visibility$VisibilityInfo.mVisibilityChange = true;
                        return visibility$VisibilityInfo;
                    }
                }
            }
        } else {
            if (transitionValues == null && visibility$VisibilityInfo.mEndVisibility == 0) {
                visibility$VisibilityInfo.mFadeIn = true;
                visibility$VisibilityInfo.mVisibilityChange = true;
                return visibility$VisibilityInfo;
            }
            if (transitionValues2 == null && visibility$VisibilityInfo.mStartVisibility == 0) {
                visibility$VisibilityInfo.mFadeIn = false;
                visibility$VisibilityInfo.mVisibilityChange = true;
            }
        }
        return visibility$VisibilityInfo;
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues$1(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        captureValues$1(transitionValues);
        View view = transitionValues.view;
        Float fValueOf = (Float) view.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            fValueOf = view.getVisibility() == 0 ? Float.valueOf(ViewUtils.IMPL.getTransitionAlpha(view)) : Float.valueOf(0.0f);
        }
        transitionValues.values.put("android:fade:transitionAlpha", fValueOf);
    }

    public final ObjectAnimator createAnimation(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.IMPL.setTransitionAlpha(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, ViewUtils.TRANSITION_ALPHA, f2);
        FadeAnimatorListener fadeAnimatorListener = new FadeAnimatorListener(view);
        objectAnimatorOfFloat.addListener(fadeAnimatorListener);
        getRootTransition().addListener(fadeAnimatorListener);
        return objectAnimatorOfFloat;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x009e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:58:0x0131  */
    /* JADX WARN: Code duplicated, block: B:61:0x013a  */
    /* JADX WARN: Code duplicated, block: B:63:0x013e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0140  */
    /* JADX WARN: Code duplicated, block: B:65:0x0148  */
    /* JADX WARN: Code duplicated, block: B:66:0x015e  */
    /* JADX WARN: Code duplicated, block: B:69:0x017a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:74:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x01de  */
    /* JADX WARN: Code duplicated, block: B:81:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:83:0x020b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0212  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (getVisibilityChangeInfo(getMatchedTransitionValues(r3, false), getTransitionValues(r3, false)).mVisibilityChange != false) goto L9;
     */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator createAnimator(android.view.ViewGroup r25, androidx.transition.TransitionValues r26, androidx.transition.TransitionValues r27) {
        /*
            Method dump skipped, instruction units count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Fade.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    public final String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public final boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey("android:visibility:visibility") != transitionValues.values.containsKey("android:visibility:visibility")) {
            return false;
        }
        Visibility$VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityChangeInfo.mVisibilityChange) {
            return visibilityChangeInfo.mStartVisibility == 0 || visibilityChangeInfo.mEndVisibility == 0;
        }
        return false;
    }

    public Fade() {
        this.mMode = 3;
    }
}
