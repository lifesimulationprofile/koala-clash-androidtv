package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Visibility$DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
    public final int mFinalVisibility;
    public boolean mLayoutSuppressed;
    public final ViewGroup mParent;
    public final View mView;
    public boolean mCanceled = false;
    public final boolean mSuppressLayout = true;

    public Visibility$DisappearListener(View view, int i) {
        this.mView = view;
        this.mFinalVisibility = i;
        this.mParent = (ViewGroup) view.getParent();
        suppressLayout(true);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.mCanceled = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.mCanceled) {
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            ViewGroup viewGroup = this.mParent;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        suppressLayout(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionEnd$1(Transition transition) {
        transition.removeListener(this);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionPause() {
        suppressLayout(false);
        if (this.mCanceled) {
            return;
        }
        ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionResume() {
        suppressLayout(true);
        if (this.mCanceled) {
            return;
        }
        ViewUtils.setTransitionVisibility(this.mView, 0);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        throw null;
    }

    public final void suppressLayout(boolean z) {
        ViewGroup viewGroup;
        if (!this.mSuppressLayout || this.mLayoutSuppressed == z || (viewGroup = this.mParent) == null) {
            return;
        }
        this.mLayoutSuppressed = z;
        ViewGroupUtils.suppressLayout(viewGroup, z);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            ViewUtils.setTransitionVisibility(this.mView, 0);
            ViewGroup viewGroup = this.mParent;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (z) {
            return;
        }
        if (!this.mCanceled) {
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            ViewGroup viewGroup = this.mParent;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        suppressLayout(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionStart$1(Transition transition) {
    }
}
