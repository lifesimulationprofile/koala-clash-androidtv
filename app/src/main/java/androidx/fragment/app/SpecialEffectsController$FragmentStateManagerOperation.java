package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.unit.Density;
import androidx.core.os.CancellationSignal;
import coil.request.Parameters;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SpecialEffectsController$FragmentStateManagerOperation {
    public final ArrayList mCompletionListeners;
    public int mFinalState;
    public final Fragment mFragment;
    public final FragmentStateManager mFragmentStateManager;
    public boolean mIsCanceled;
    public boolean mIsComplete;
    public int mLifecycleImpact;
    public final HashSet mSpecialEffectsSignals;

    public SpecialEffectsController$FragmentStateManagerOperation(int i, int i2, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
        Fragment fragment = fragmentStateManager.mFragment;
        this.mCompletionListeners = new ArrayList();
        this.mSpecialEffectsSignals = new HashSet();
        this.mIsCanceled = false;
        this.mIsComplete = false;
        this.mFinalState = i;
        this.mLifecycleImpact = i2;
        this.mFragment = fragment;
        cancellationSignal.setOnCancelListener(new Parameters.Builder(22, this));
        this.mFragmentStateManager = fragmentStateManager;
    }

    public final void cancel() {
        HashSet hashSet = this.mSpecialEffectsSignals;
        if (this.mIsCanceled) {
            return;
        }
        this.mIsCanceled = true;
        if (hashSet.isEmpty()) {
            complete();
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            CancellationSignal cancellationSignal = (CancellationSignal) obj;
            synchronized (cancellationSignal) {
                try {
                    if (!cancellationSignal.mIsCanceled) {
                        cancellationSignal.mIsCanceled = true;
                        cancellationSignal.mCancelInProgress = true;
                        CancellationSignal.OnCancelListener onCancelListener = cancellationSignal.mOnCancelListener;
                        if (onCancelListener != null) {
                            try {
                                onCancelListener.onCancel();
                            } catch (Throwable th) {
                                synchronized (cancellationSignal) {
                                    cancellationSignal.mCancelInProgress = false;
                                    cancellationSignal.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (cancellationSignal) {
                            cancellationSignal.mCancelInProgress = false;
                            cancellationSignal.notifyAll();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void complete() {
        if (!this.mIsComplete) {
            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.mIsComplete = true;
            ArrayList arrayList = this.mCompletionListeners;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
        this.mFragmentStateManager.moveToExpectedState();
    }

    public final void mergeWith(int i, int i2) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i2);
        Fragment fragment = this.mFragment;
        if (iOrdinal == 0) {
            if (this.mFinalState != 1) {
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + Density.CC.stringValueOf$3(this.mFinalState) + " -> " + Density.CC.stringValueOf$3(i) + ". ");
                }
                this.mFinalState = i;
                return;
            }
            return;
        }
        if (iOrdinal == 1) {
            if (this.mFinalState == 1) {
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + Density.CC.stringValueOf$2(this.mLifecycleImpact) + " to ADDING.");
                }
                this.mFinalState = 2;
                this.mLifecycleImpact = 2;
                return;
            }
            return;
        }
        if (iOrdinal != 2) {
            return;
        }
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + Density.CC.stringValueOf$3(this.mFinalState) + " -> REMOVED. mLifecycleImpact  = " + Density.CC.stringValueOf$2(this.mLifecycleImpact) + " to REMOVING.");
        }
        this.mFinalState = 1;
        this.mLifecycleImpact = 3;
    }

    public final void onStart() {
        int i = this.mLifecycleImpact;
        FragmentStateManager fragmentStateManager = this.mFragmentStateManager;
        if (i != 2) {
            if (i == 3) {
                Fragment fragment = fragmentStateManager.mFragment;
                View viewRequireView = fragment.requireView();
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragment);
                }
                viewRequireView.clearFocus();
                return;
            }
            return;
        }
        Fragment fragment2 = fragmentStateManager.mFragment;
        View viewFindFocus = fragment2.mView.findFocus();
        if (viewFindFocus != null) {
            fragment2.ensureAnimationInfo().mFocusedView = viewFindFocus;
            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment2);
            }
        }
        View viewRequireView2 = this.mFragment.requireView();
        if (viewRequireView2.getParent() == null) {
            fragmentStateManager.addViewToContainer();
            viewRequireView2.setAlpha(0.0f);
        }
        if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
            viewRequireView2.setVisibility(4);
        }
        Fragment.AnimationInfo animationInfo = fragment2.mAnimationInfo;
        viewRequireView2.setAlpha(animationInfo == null ? 1.0f : animationInfo.mPostOnViewCreatedAlpha);
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + Density.CC.stringValueOf$3(this.mFinalState) + "} {mLifecycleImpact = " + Density.CC.stringValueOf$2(this.mLifecycleImpact) + "} {mFragment = " + this.mFragment + "}";
    }
}
