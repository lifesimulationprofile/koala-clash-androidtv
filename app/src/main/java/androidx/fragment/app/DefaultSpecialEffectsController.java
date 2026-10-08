package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.unit.Density;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import coil.request.RequestService;
import com.google.android.gms.tasks.zzg;
import com.google.android.gms.tasks.zzi;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;
import okhttp3.Dispatcher;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultSpecialEffectsController {
    public final ViewGroup mContainer;
    public final ArrayList mPendingOperations = new ArrayList();
    public final ArrayList mRunningOperations = new ArrayList();
    public boolean mOperationDirectionIsPop = false;
    public boolean mIsContainerPostponed = false;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnimationInfo extends BaseMenuWrapper {
        public RequestService mAnimation;
        public boolean mIsPop;
        public boolean mLoadedAnim;

        /* JADX WARN: Code duplicated, block: B:17:0x0027  */
        /* JADX WARN: Code duplicated, block: B:79:0x00e5 A[Catch: RuntimeException -> 0x00eb, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x00eb, blocks: (B:77:0x00df, B:79:0x00e5), top: B:90:0x00df }] */
        public final RequestService getAnimation(Context context) {
            int i;
            RequestService requestService;
            Animator animatorLoadAnimator;
            int activityTransitResId;
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.mContext;
            Fragment fragment = specialEffectsController$FragmentStateManagerOperation.mFragment;
            boolean z = specialEffectsController$FragmentStateManagerOperation.mFinalState == 2;
            boolean z2 = this.mIsPop;
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            int i2 = animationInfo == null ? 0 : animationInfo.mNextTransition;
            if (z2) {
                if (z) {
                    if (animationInfo == null) {
                        i = 0;
                    } else {
                        i = animationInfo.mPopEnterAnim;
                    }
                } else if (animationInfo == null) {
                    i = 0;
                } else {
                    i = animationInfo.mPopExitAnim;
                }
            } else if (z) {
                if (animationInfo == null) {
                    i = 0;
                } else {
                    i = animationInfo.mEnterAnim;
                }
            } else if (animationInfo == null) {
                i = 0;
            } else {
                i = animationInfo.mExitAnim;
            }
            fragment.setAnimations(0, 0, 0, 0);
            ViewGroup viewGroup = fragment.mContainer;
            RequestService requestService2 = null;
            if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
                fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
            }
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
                if (i == 0 && i2 != 0) {
                    if (i2 == 4097) {
                        activityTransitResId = z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                    } else if (i2 == 8194) {
                        activityTransitResId = z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
                    } else if (i2 == 8197) {
                        activityTransitResId = z ? FragmentAnim.toActivityTransitResId(context, android.R.attr.activityCloseEnterAnimation) : FragmentAnim.toActivityTransitResId(context, android.R.attr.activityCloseExitAnimation);
                    } else if (i2 == 4099) {
                        activityTransitResId = z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
                    } else if (i2 != 4100) {
                        activityTransitResId = -1;
                    } else {
                        activityTransitResId = z ? FragmentAnim.toActivityTransitResId(context, android.R.attr.activityOpenEnterAnimation) : FragmentAnim.toActivityTransitResId(context, android.R.attr.activityOpenExitAnimation);
                    }
                    i = activityTransitResId;
                }
                if (i != 0) {
                    boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(i));
                    if (zEquals) {
                        try {
                            Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, i);
                            if (animationLoadAnimation != null) {
                                requestService = new RequestService(animationLoadAnimation);
                                requestService2 = requestService;
                            }
                        } catch (Resources.NotFoundException e) {
                            throw e;
                        } catch (RuntimeException unused) {
                            try {
                                animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
                                if (animatorLoadAnimator != null) {
                                    requestService = new RequestService(animatorLoadAnimator);
                                    requestService2 = requestService;
                                }
                            } catch (RuntimeException e2) {
                                if (zEquals) {
                                    throw e2;
                                }
                                Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, i);
                                if (animationLoadAnimation2 != null) {
                                    requestService2 = new RequestService(animationLoadAnimation2);
                                }
                            }
                        }
                    } else {
                        animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
                        if (animatorLoadAnimator != null) {
                            requestService = new RequestService(animatorLoadAnimator);
                            requestService2 = requestService;
                        }
                    }
                }
            }
            this.mAnimation = requestService2;
            this.mLoadedAnim = true;
            return requestService2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TransitionInfo extends BaseMenuWrapper {
    }

    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    public static DefaultSpecialEffectsController getOrCreateController(ViewGroup viewGroup, ByteString.Companion companion) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof DefaultSpecialEffectsController) {
            return (DefaultSpecialEffectsController) tag;
        }
        companion.getClass();
        DefaultSpecialEffectsController defaultSpecialEffectsController = new DefaultSpecialEffectsController(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, defaultSpecialEffectsController);
        return defaultSpecialEffectsController;
    }

    public final void enqueue(int i, int i2, FragmentStateManager fragmentStateManager) {
        synchronized (this.mPendingOperations) {
            try {
                CancellationSignal cancellationSignal = new CancellationSignal();
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperationFindPendingOperation = findPendingOperation(fragmentStateManager.mFragment);
                if (specialEffectsController$FragmentStateManagerOperationFindPendingOperation != null) {
                    specialEffectsController$FragmentStateManagerOperationFindPendingOperation.mergeWith(i, i2);
                    return;
                }
                final SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = new SpecialEffectsController$FragmentStateManagerOperation(i, i2, fragmentStateManager, cancellationSignal);
                this.mPendingOperations.add(specialEffectsController$FragmentStateManagerOperation);
                final int i3 = 0;
                specialEffectsController$FragmentStateManagerOperation.mCompletionListeners.add(new Runnable(this) { // from class: androidx.fragment.app.SpecialEffectsController$1
                    public final /* synthetic */ DefaultSpecialEffectsController this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i3) {
                            case 0:
                                ArrayList arrayList = this.this$0.mPendingOperations;
                                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation;
                                if (arrayList.contains(specialEffectsController$FragmentStateManagerOperation2)) {
                                    Density.CC._applyState(specialEffectsController$FragmentStateManagerOperation2.mFragment.mView, specialEffectsController$FragmentStateManagerOperation2.mFinalState);
                                }
                                break;
                            default:
                                DefaultSpecialEffectsController defaultSpecialEffectsController = this.this$0;
                                ArrayList arrayList2 = defaultSpecialEffectsController.mPendingOperations;
                                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation;
                                arrayList2.remove(specialEffectsController$FragmentStateManagerOperation3);
                                defaultSpecialEffectsController.mRunningOperations.remove(specialEffectsController$FragmentStateManagerOperation3);
                                break;
                        }
                    }
                });
                final int i4 = 1;
                specialEffectsController$FragmentStateManagerOperation.mCompletionListeners.add(new Runnable(this) { // from class: androidx.fragment.app.SpecialEffectsController$1
                    public final /* synthetic */ DefaultSpecialEffectsController this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i4) {
                            case 0:
                                ArrayList arrayList = this.this$0.mPendingOperations;
                                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation;
                                if (arrayList.contains(specialEffectsController$FragmentStateManagerOperation2)) {
                                    Density.CC._applyState(specialEffectsController$FragmentStateManagerOperation2.mFragment.mView, specialEffectsController$FragmentStateManagerOperation2.mFinalState);
                                }
                                break;
                            default:
                                DefaultSpecialEffectsController defaultSpecialEffectsController = this.this$0;
                                ArrayList arrayList2 = defaultSpecialEffectsController.mPendingOperations;
                                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3 = specialEffectsController$FragmentStateManagerOperation;
                                arrayList2.remove(specialEffectsController$FragmentStateManagerOperation3);
                                defaultSpecialEffectsController.mRunningOperations.remove(specialEffectsController$FragmentStateManagerOperation3);
                                break;
                        }
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void executeOperations(ArrayList arrayList, boolean z) {
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = null;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3 = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            int i_from = Density.CC._from(specialEffectsController$FragmentStateManagerOperation3.mFragment.mView);
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(specialEffectsController$FragmentStateManagerOperation3.mFinalState);
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2 || iOrdinal == 3) {
                    }
                } else if (i_from != 2) {
                    specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation3;
                }
            }
            if (i_from == 2 && specialEffectsController$FragmentStateManagerOperation == null) {
                specialEffectsController$FragmentStateManagerOperation = specialEffectsController$FragmentStateManagerOperation3;
            }
        }
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Executing operations from " + specialEffectsController$FragmentStateManagerOperation + " to " + specialEffectsController$FragmentStateManagerOperation2);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList(arrayList2);
        Fragment fragment = ((SpecialEffectsController$FragmentStateManagerOperation) arrayList2.get(arrayList2.size() - 1)).mFragment;
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            Fragment.AnimationInfo animationInfo = ((SpecialEffectsController$FragmentStateManagerOperation) obj2).mFragment.mAnimationInfo;
            Fragment.AnimationInfo animationInfo2 = fragment.mAnimationInfo;
            animationInfo.mEnterAnim = animationInfo2.mEnterAnim;
            animationInfo.mExitAnim = animationInfo2.mExitAnim;
            animationInfo.mPopEnterAnim = animationInfo2.mPopEnterAnim;
            animationInfo.mPopExitAnim = animationInfo2.mPopExitAnim;
        }
        int size3 = arrayList2.size();
        int i3 = 0;
        while (i3 < size3) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation4 = (SpecialEffectsController$FragmentStateManagerOperation) obj3;
            CancellationSignal cancellationSignal = new CancellationSignal();
            specialEffectsController$FragmentStateManagerOperation4.onStart();
            HashSet hashSet = specialEffectsController$FragmentStateManagerOperation4.mSpecialEffectsSignals;
            hashSet.add(cancellationSignal);
            AnimationInfo animationInfo3 = new AnimationInfo(specialEffectsController$FragmentStateManagerOperation4, cancellationSignal);
            animationInfo3.mLoadedAnim = false;
            animationInfo3.mIsPop = z;
            arrayList3.add(animationInfo3);
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            specialEffectsController$FragmentStateManagerOperation4.onStart();
            hashSet.add(cancellationSignal2);
            boolean z2 = !z ? specialEffectsController$FragmentStateManagerOperation4 != specialEffectsController$FragmentStateManagerOperation2 : specialEffectsController$FragmentStateManagerOperation4 != specialEffectsController$FragmentStateManagerOperation;
            TransitionInfo transitionInfo = new TransitionInfo(specialEffectsController$FragmentStateManagerOperation4, cancellationSignal2);
            int i4 = specialEffectsController$FragmentStateManagerOperation4.mFinalState;
            Fragment fragment2 = specialEffectsController$FragmentStateManagerOperation4.mFragment;
            if (i4 == 2) {
                if (z) {
                    Fragment.AnimationInfo animationInfo4 = fragment2.mAnimationInfo;
                } else {
                    fragment2.getClass();
                }
                if (z) {
                    Fragment.AnimationInfo animationInfo5 = fragment2.mAnimationInfo;
                } else {
                    Fragment.AnimationInfo animationInfo6 = fragment2.mAnimationInfo;
                }
            } else if (z) {
                Fragment.AnimationInfo animationInfo7 = fragment2.mAnimationInfo;
            } else {
                fragment2.getClass();
            }
            if (z2) {
                if (z) {
                    Fragment.AnimationInfo animationInfo8 = fragment2.mAnimationInfo;
                } else {
                    fragment2.getClass();
                }
            }
            arrayList4.add(transitionInfo);
            specialEffectsController$FragmentStateManagerOperation4.mCompletionListeners.add(new zzi(this, arrayList5, specialEffectsController$FragmentStateManagerOperation4));
            arrayList2 = arrayList;
        }
        HashMap map = new HashMap();
        int size4 = arrayList4.size();
        int i5 = 0;
        while (i5 < size4) {
            Object obj4 = arrayList4.get(i5);
            i5++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation5 = (SpecialEffectsController$FragmentStateManagerOperation) ((TransitionInfo) obj4).mContext;
            if (Density.CC._from(specialEffectsController$FragmentStateManagerOperation5.mFragment.mView) != specialEffectsController$FragmentStateManagerOperation5.mFinalState) {
            }
        }
        int size5 = arrayList4.size();
        int i6 = 0;
        while (i6 < size5) {
            Object obj5 = arrayList4.get(i6);
            i6++;
            TransitionInfo transitionInfo2 = (TransitionInfo) obj5;
            map.put((SpecialEffectsController$FragmentStateManagerOperation) transitionInfo2.mContext, Boolean.FALSE);
            transitionInfo2.completeSpecialEffect();
        }
        boolean zContainsValue = map.containsValue(Boolean.TRUE);
        ViewGroup viewGroup = this.mContainer;
        Context context = viewGroup.getContext();
        ArrayList arrayList6 = new ArrayList();
        int size6 = arrayList3.size();
        boolean z3 = false;
        int i7 = 0;
        while (i7 < size6) {
            Object obj6 = arrayList3.get(i7);
            i7++;
            final AnimationInfo animationInfo9 = (AnimationInfo) obj6;
            zContainsValue = zContainsValue;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation6 = (SpecialEffectsController$FragmentStateManagerOperation) animationInfo9.mContext;
            arrayList3 = arrayList3;
            int i_from2 = Density.CC._from(specialEffectsController$FragmentStateManagerOperation6.mFragment.mView);
            int i8 = specialEffectsController$FragmentStateManagerOperation6.mFinalState;
            size6 = size6;
            if (i_from2 == i8 || !(i_from2 == 2 || i8 == 2)) {
                z3 = z3;
                animationInfo9.completeSpecialEffect();
                viewGroup = viewGroup;
                z3 = z3;
            } else {
                RequestService animation = animationInfo9.getAnimation(context);
                if (animation == null) {
                    animationInfo9.completeSpecialEffect();
                } else {
                    Animator animator = (Animator) animation.hardwareBitmapService;
                    if (animator == null) {
                        arrayList6.add(animationInfo9);
                    } else {
                        final SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation7 = (SpecialEffectsController$FragmentStateManagerOperation) animationInfo9.mContext;
                        Fragment fragment3 = specialEffectsController$FragmentStateManagerOperation7.mFragment;
                        if (Boolean.TRUE.equals(map.get(specialEffectsController$FragmentStateManagerOperation7))) {
                            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment3 + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo9.completeSpecialEffect();
                            viewGroup = viewGroup;
                            z3 = z3;
                        } else {
                            final boolean z4 = specialEffectsController$FragmentStateManagerOperation7.mFinalState == 3;
                            if (z4) {
                                arrayList5.remove(specialEffectsController$FragmentStateManagerOperation7);
                            }
                            final View view = fragment3.mView;
                            viewGroup.startViewTransition(view);
                            final ViewGroup viewGroup2 = viewGroup;
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator2) {
                                    ViewGroup viewGroup3 = viewGroup2;
                                    View view2 = view;
                                    viewGroup3.endViewTransition(view2);
                                    boolean z5 = z4;
                                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation8 = specialEffectsController$FragmentStateManagerOperation7;
                                    if (z5) {
                                        Density.CC._applyState(view2, specialEffectsController$FragmentStateManagerOperation8.mFinalState);
                                    }
                                    animationInfo9.completeSpecialEffect();
                                    if (FragmentManagerImpl.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "Animator from operation " + specialEffectsController$FragmentStateManagerOperation8 + " has ended.");
                                    }
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Animator from operation " + specialEffectsController$FragmentStateManagerOperation7 + " has started.");
                            }
                            ((CancellationSignal) animationInfo9.mMenuItems).setOnCancelListener(new RequestService(18, animator, specialEffectsController$FragmentStateManagerOperation7));
                            viewGroup = viewGroup2;
                            z3 = true;
                        }
                    }
                }
                viewGroup = viewGroup;
                z3 = z3;
            }
        }
        boolean z5 = zContainsValue;
        boolean z6 = z3;
        ViewGroup viewGroup3 = viewGroup;
        int size7 = arrayList6.size();
        int i9 = 0;
        while (i9 < size7) {
            Object obj7 = arrayList6.get(i9);
            i9++;
            AnimationInfo animationInfo10 = (AnimationInfo) obj7;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation8 = (SpecialEffectsController$FragmentStateManagerOperation) animationInfo10.mContext;
            Fragment fragment4 = specialEffectsController$FragmentStateManagerOperation8.mFragment;
            if (z5) {
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment4 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo10.completeSpecialEffect();
            } else if (z6) {
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment4 + " as Animations cannot run alongside Animators.");
                }
                animationInfo10.completeSpecialEffect();
            } else {
                View view2 = fragment4.mView;
                RequestService animation2 = animationInfo10.getAnimation(context);
                animation2.getClass();
                Animation animation3 = (Animation) animation2.systemCallbacks;
                animation3.getClass();
                int i10 = size7;
                if (specialEffectsController$FragmentStateManagerOperation8.mFinalState != 1) {
                    view2.startAnimation(animation3);
                    animationInfo10.completeSpecialEffect();
                } else {
                    viewGroup3.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation3, viewGroup3, view2);
                    endViewTransitionAnimation.setAnimationListener(new AnonymousClass4(specialEffectsController$FragmentStateManagerOperation8, viewGroup3, view2, animationInfo10));
                    view2.startAnimation(endViewTransitionAnimation);
                    if (FragmentManagerImpl.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Animation from operation " + specialEffectsController$FragmentStateManagerOperation8 + " has started.");
                    }
                }
                ((CancellationSignal) animationInfo10.mMenuItems).setOnCancelListener(new Dispatcher(view2, viewGroup3, animationInfo10, specialEffectsController$FragmentStateManagerOperation8));
                size7 = i10;
            }
        }
        int size8 = arrayList5.size();
        int i11 = 0;
        while (i11 < size8) {
            Object obj8 = arrayList5.get(i11);
            i11++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation9 = (SpecialEffectsController$FragmentStateManagerOperation) obj8;
            Density.CC._applyState(specialEffectsController$FragmentStateManagerOperation9.mFragment.mView, specialEffectsController$FragmentStateManagerOperation9.mFinalState);
        }
        arrayList5.clear();
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + specialEffectsController$FragmentStateManagerOperation + " to " + specialEffectsController$FragmentStateManagerOperation2);
        }
    }

    public final void executePendingOperations() {
        if (this.mIsContainerPostponed) {
            return;
        }
        ViewGroup viewGroup = this.mContainer;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (!viewGroup.isAttachedToWindow()) {
            forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }
        synchronized (this.mPendingOperations) {
            try {
                if (!this.mPendingOperations.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.mRunningOperations);
                    this.mRunningOperations.clear();
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
                        if (FragmentManagerImpl.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + specialEffectsController$FragmentStateManagerOperation);
                        }
                        specialEffectsController$FragmentStateManagerOperation.cancel();
                        if (!specialEffectsController$FragmentStateManagerOperation.mIsComplete) {
                            this.mRunningOperations.add(specialEffectsController$FragmentStateManagerOperation);
                        }
                    }
                    updateFinalState();
                    ArrayList arrayList2 = new ArrayList(this.mPendingOperations);
                    this.mPendingOperations.clear();
                    this.mRunningOperations.addAll(arrayList2);
                    if (FragmentManagerImpl.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        ((SpecialEffectsController$FragmentStateManagerOperation) obj2).onStart();
                    }
                    executeOperations(arrayList2, this.mOperationDirectionIsPop);
                    this.mOperationDirectionIsPop = false;
                    if (FragmentManagerImpl.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final SpecialEffectsController$FragmentStateManagerOperation findPendingOperation(Fragment fragment) {
        ArrayList arrayList = this.mPendingOperations;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            if (specialEffectsController$FragmentStateManagerOperation.mFragment.equals(fragment) && !specialEffectsController$FragmentStateManagerOperation.mIsCanceled) {
                return specialEffectsController$FragmentStateManagerOperation;
            }
        }
        return null;
    }

    public final void forceCompleteAllOperations() {
        String str;
        String str2;
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.mContainer;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.mPendingOperations) {
            try {
                updateFinalState();
                ArrayList arrayList = this.mPendingOperations;
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((SpecialEffectsController$FragmentStateManagerOperation) obj).onStart();
                }
                ArrayList arrayList2 = new ArrayList(this.mRunningOperations);
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj2;
                    if (FragmentManagerImpl.isLoggingEnabled(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.mContainer + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(specialEffectsController$FragmentStateManagerOperation);
                        Log.v("FragmentManager", sb.toString());
                    }
                    specialEffectsController$FragmentStateManagerOperation.cancel();
                }
                ArrayList arrayList3 = new ArrayList(this.mPendingOperations);
                int size3 = arrayList3.size();
                while (i < size3) {
                    Object obj3 = arrayList3.get(i);
                    i++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = (SpecialEffectsController$FragmentStateManagerOperation) obj3;
                    if (FragmentManagerImpl.isLoggingEnabled(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.mContainer + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(specialEffectsController$FragmentStateManagerOperation2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    specialEffectsController$FragmentStateManagerOperation2.cancel();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void updateFinalState() {
        ArrayList arrayList = this.mPendingOperations;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            if (specialEffectsController$FragmentStateManagerOperation.mLifecycleImpact == 2) {
                specialEffectsController$FragmentStateManagerOperation.mergeWith(Density.CC._from(specialEffectsController$FragmentStateManagerOperation.mFragment.requireView().getVisibility()), 1);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass4 implements Animation.AnimationListener {
        public final /* synthetic */ AnimationInfo val$animationInfo;
        public final /* synthetic */ ViewGroup val$container;
        public final /* synthetic */ SpecialEffectsController$FragmentStateManagerOperation val$operation;
        public final /* synthetic */ View val$viewToAnimate;

        public AnonymousClass4(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, ViewGroup viewGroup, View view, AnimationInfo animationInfo) {
            this.val$operation = specialEffectsController$FragmentStateManagerOperation;
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$animationInfo = animationInfo;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            this.val$container.post(new zzg(12, this));
            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.val$operation + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.val$operation + " has reached onAnimationStart.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }
    }
}
