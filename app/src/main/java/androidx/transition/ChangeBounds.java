package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ChangeBounds extends Transition {
    public static final String[] sTransitionProperties = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final ViewUtils.AnonymousClass1 TOP_LEFT_PROPERTY = new ViewUtils.AnonymousClass1(PointF.class, "topLeft", 2);
    public static final ViewUtils.AnonymousClass1 BOTTOM_RIGHT_PROPERTY = new ViewUtils.AnonymousClass1(PointF.class, "bottomRight", 3);
    public static final ViewUtils.AnonymousClass1 BOTTOM_RIGHT_ONLY_PROPERTY = new ViewUtils.AnonymousClass1(PointF.class, "bottomRight", 4);
    public static final ViewUtils.AnonymousClass1 TOP_LEFT_ONLY_PROPERTY = new ViewUtils.AnonymousClass1(PointF.class, "topLeft", 5);
    public static final ViewUtils.AnonymousClass1 POSITION_PROPERTY = new ViewUtils.AnonymousClass1(PointF.class, "position", 6);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SuppressLayoutListener extends TransitionListenerAdapter {
        public boolean mCanceled = false;
        public final ViewGroup mParent;

        public SuppressLayoutListener(ViewGroup viewGroup) {
            this.mParent = viewGroup;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
            this.mCanceled = true;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition transition) {
            if (!this.mCanceled) {
                ViewGroupUtils.suppressLayout(this.mParent, false);
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void onTransitionPause() {
            ViewGroupUtils.suppressLayout(this.mParent, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void onTransitionResume() {
            ViewGroupUtils.suppressLayout(this.mParent, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ViewBounds {
        public int mBottom;
        public int mBottomRightCalls;
        public int mLeft;
        public int mRight;
        public int mTop;
        public int mTopLeftCalls;
        public final View mView;

        public ViewBounds(View view) {
            this.mView = view;
        }
    }

    public static void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        HashMap map = transitionValues.values;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", view.getParent());
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        ChangeBounds changeBounds;
        Animator animatorOfObject;
        if (transitionValues != null) {
            HashMap map = transitionValues.values;
            if (transitionValues2 != null) {
                HashMap map2 = transitionValues2.values;
                ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
                if (viewGroup2 != null && viewGroup3 != null) {
                    View view = transitionValues2.view;
                    Rect rect = (Rect) map.get("android:changeBounds:bounds");
                    Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
                    int i2 = rect.left;
                    int i3 = rect2.left;
                    int i4 = rect.top;
                    int i5 = rect2.top;
                    int i6 = rect.right;
                    int i7 = rect2.right;
                    int i8 = rect.bottom;
                    int i9 = rect2.bottom;
                    int i10 = i6 - i2;
                    int i11 = i8 - i4;
                    int i12 = i7 - i3;
                    int i13 = i9 - i5;
                    Rect rect3 = (Rect) map.get("android:changeBounds:clip");
                    Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
                    if ((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0)) {
                        i = 0;
                    } else {
                        i = (i2 == i3 && i4 == i5) ? 0 : 1;
                        if (i6 != i7 || i8 != i9) {
                            i++;
                        }
                    }
                    if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                        i++;
                    }
                    int i14 = i;
                    if (i14 > 0) {
                        ViewUtils.setLeftTopRightBottom(view, i2, i4, i6, i8);
                        if (i14 != 2) {
                            changeBounds = this;
                            if (i2 == i3 && i4 == i5) {
                                changeBounds.mPathMotion.getClass();
                                animatorOfObject = ObjectAnimator.ofObject(view, BOTTOM_RIGHT_ONLY_PROPERTY, (TypeConverter) null, Path.Companion.getPath(i6, i8, i7, i9));
                            } else {
                                changeBounds.mPathMotion.getClass();
                                animatorOfObject = ObjectAnimator.ofObject(view, TOP_LEFT_ONLY_PROPERTY, (TypeConverter) null, Path.Companion.getPath(i2, i4, i3, i5));
                            }
                        } else if (i10 == i12 && i11 == i13) {
                            changeBounds = this;
                            changeBounds.mPathMotion.getClass();
                            animatorOfObject = ObjectAnimator.ofObject(view, POSITION_PROPERTY, (TypeConverter) null, Path.Companion.getPath(i2, i4, i3, i5));
                        } else {
                            changeBounds = this;
                            ViewBounds viewBounds = new ViewBounds(view);
                            changeBounds.mPathMotion.getClass();
                            ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(viewBounds, TOP_LEFT_PROPERTY, (TypeConverter) null, Path.Companion.getPath(i2, i4, i3, i5));
                            changeBounds.mPathMotion.getClass();
                            ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(viewBounds, BOTTOM_RIGHT_PROPERTY, (TypeConverter) null, Path.Companion.getPath(i6, i8, i7, i9));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(objectAnimatorOfObject, objectAnimatorOfObject2);
                            animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.6
                                private final ViewBounds mViewBounds;

                                {
                                    this.mViewBounds = viewBounds;
                                }
                            });
                            animatorOfObject = animatorSet;
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            ViewGroupUtils.suppressLayout(viewGroup4, true);
                            changeBounds.getRootTransition().addListener(new SuppressLayoutListener(viewGroup4));
                        }
                        return animatorOfObject;
                    }
                }
            }
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public final String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
