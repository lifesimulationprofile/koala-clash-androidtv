package androidx.fragment.app;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.graphics.AndroidGraphicsContext;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.unit.Density;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt$ancestors$1;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper;
import androidx.fragment.app.strictmode.FragmentReuseViolation;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManagerImpl$LoaderViewModel;
import androidx.savedstate.Recreator;
import coil.request.RequestService;
import com.google.android.material.textfield.DropdownMenuEndIconDelegate;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentStateManager {
    public final RequestService mDispatcher;
    public final Fragment mFragment;
    public final Dispatcher mFragmentStore;
    public boolean mMovingToState = false;
    public int mFragmentManagerState = -1;

    public FragmentStateManager(RequestService requestService, Dispatcher dispatcher, Fragment fragment) {
        this.mDispatcher = requestService;
        this.mFragmentStore = dispatcher;
        this.mFragment = fragment;
    }

    public final void activityCreated() {
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
        }
        Bundle bundle = fragment.mSavedFragmentState;
        fragment.mChildFragmentManager.noteStateNotSaved();
        fragment.mState = 3;
        fragment.mCalled = false;
        fragment.onActivityCreated();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onActivityCreated()");
        }
        if (FragmentManagerImpl.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + fragment);
        }
        View view = fragment.mView;
        if (view != null) {
            Bundle bundle2 = fragment.mSavedFragmentState;
            SparseArray<Parcelable> sparseArray = fragment.mSavedViewState;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                fragment.mSavedViewState = null;
            }
            if (fragment.mView != null) {
                fragment.mViewLifecycleOwner.mSavedStateRegistryController.performRestore(fragment.mSavedViewRegistryState);
                fragment.mSavedViewRegistryState = null;
            }
            fragment.mCalled = false;
            fragment.onViewStateRestored(bundle2);
            if (!fragment.mCalled) {
                throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onViewStateRestored()");
            }
            if (fragment.mView != null) {
                fragment.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            }
        }
        fragment.mSavedFragmentState = null;
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(4);
        this.mDispatcher.dispatchOnFragmentActivityCreated(false);
    }

    public final void addViewToContainer() {
        View view;
        View view2;
        ArrayList arrayList = (ArrayList) this.mFragmentStore.executorServiceOrNull;
        Fragment fragment = this.mFragment;
        ViewGroup viewGroup = fragment.mContainer;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(fragment);
            for (int i = iIndexOf - 1; i >= 0; i--) {
                Fragment fragment2 = (Fragment) arrayList.get(i);
                if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                }
            }
            while (true) {
                iIndexOf++;
                if (iIndexOf >= arrayList.size()) {
                    break;
                }
                Fragment fragment3 = (Fragment) arrayList.get(iIndexOf);
                if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view);
                    break;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, iIndexOfChild);
    }

    public final void attach() {
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        Dispatcher dispatcher = this.mFragmentStore;
        if (fragment2 != null) {
            FragmentStateManager fragmentStateManager2 = (FragmentStateManager) ((HashMap) dispatcher.readyAsyncCalls).get(fragment2.mWho);
            if (fragmentStateManager2 == null) {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            fragmentStateManager = fragmentStateManager2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = (FragmentStateManager) ((HashMap) dispatcher.readyAsyncCalls).get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.moveToExpectedState();
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mFragmentManager;
        fragment.mHost = fragmentManagerImpl.mHost;
        fragment.mParentFragment = fragmentManagerImpl.mParent;
        RequestService requestService = this.mDispatcher;
        requestService.dispatchOnFragmentPreAttached(false);
        ArrayList arrayList = fragment.mOnPreAttachedListeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Fragment fragment3 = Fragment.this;
            fragment3.mSavedStateRegistryController.performAttach();
            ViewModelKt.enableSavedStateHandles(fragment3);
        }
        arrayList.clear();
        fragment.mChildFragmentManager.attachController(fragment.mHost, fragment.createFragmentContainer(), fragment);
        fragment.mState = 0;
        fragment.mCalled = false;
        fragment.onAttach(fragment.mHost.mContext);
        if (!fragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
        }
        Iterator it = fragment.mFragmentManager.mOnAttachListeners.iterator();
        while (it.hasNext()) {
            ((FragmentOnAttachListener) it.next()).onAttachFragment$1();
        }
        FragmentManagerImpl fragmentManagerImpl2 = fragment.mChildFragmentManager;
        fragmentManagerImpl2.mStateSaved = false;
        fragmentManagerImpl2.mStopped = false;
        fragmentManagerImpl2.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl2.dispatchStateChange(0);
        requestService.dispatchOnFragmentAttached(false);
    }

    public final int computeExpectedState() {
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation;
        Fragment fragment = this.mFragment;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.mFragmentManagerState;
        int iOrdinal = fragment.mMaxState.ordinal();
        int i = 0;
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                iMin = Math.max(this.mFragmentManagerState, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.mFragmentManagerState < 4 ? Math.min(iMin, fragment.mState) : Math.min(iMin, 1);
            }
        }
        if (!fragment.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager().getSpecialEffectsControllerFactory());
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperationFindPendingOperation = orCreateController.findPendingOperation(fragment);
            int i2 = specialEffectsController$FragmentStateManagerOperationFindPendingOperation != null ? specialEffectsController$FragmentStateManagerOperationFindPendingOperation.mLifecycleImpact : 0;
            ArrayList arrayList = orCreateController.mRunningOperations;
            int size = arrayList.size();
            while (true) {
                if (i >= size) {
                    specialEffectsController$FragmentStateManagerOperation = null;
                    break;
                }
                Object obj = arrayList.get(i);
                i++;
                specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
                if (specialEffectsController$FragmentStateManagerOperation.mFragment.equals(fragment) && !specialEffectsController$FragmentStateManagerOperation.mIsCanceled) {
                    break;
                }
            }
            i = (specialEffectsController$FragmentStateManagerOperation == null || !(i2 == 0 || i2 == 1)) ? i2 : specialEffectsController$FragmentStateManagerOperation.mLifecycleImpact;
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + fragment);
        }
        return iMin;
    }

    public final void create() {
        Parcelable parcelable;
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        if (fragment.mIsCreated) {
            Bundle bundle = fragment.mSavedFragmentState;
            if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
                fragment.mChildFragmentManager.restoreSaveStateInternal(parcelable);
                FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
                fragmentManagerImpl.mStateSaved = false;
                fragmentManagerImpl.mStopped = false;
                fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
                fragmentManagerImpl.dispatchStateChange(1);
            }
            fragment.mState = 1;
            return;
        }
        RequestService requestService = this.mDispatcher;
        requestService.dispatchOnFragmentPreCreated(false);
        Bundle bundle2 = fragment.mSavedFragmentState;
        fragment.mChildFragmentManager.noteStateNotSaved();
        fragment.mState = 1;
        fragment.mCalled = false;
        fragment.mLifecycleRegistry.addObserver(new Recreator(fragment, 2));
        fragment.mSavedStateRegistryController.performRestore(bundle2);
        fragment.onCreate(bundle2);
        fragment.mIsCreated = true;
        if (fragment.mCalled) {
            fragment.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            requestService.dispatchOnFragmentCreated(false);
        } else {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onCreate()");
        }
    }

    public final void createView() {
        String resourceName;
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout) {
            return;
        }
        if (FragmentManagerImpl.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater layoutInflaterOnGetLayoutInflater = fragment.onGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int i = fragment.mContainerId;
            if (i == 0) {
                viewGroup = null;
            } else {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + fragment + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.mContainer.onFindViewById(i);
                if (viewGroup == null) {
                    if (!fragment.mRestored) {
                        try {
                            resourceName = fragment.requireContext().getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
                    FragmentStrictMode.logIfDebuggingEnabled(new FragmentReuseViolation(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    FragmentStrictMode.getNearestPolicy(fragment).getClass();
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(layoutInflaterOnGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            int i2 = 0;
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                addViewToContainer();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (view2.isAttachedToWindow()) {
                ViewCompat.Api20Impl.requestApplyInsets(fragment.mView);
            } else {
                View view3 = fragment.mView;
                view3.addOnAttachStateChangeListener(new AnonymousClass1(i2, view3));
            }
            fragment.mChildFragmentManager.dispatchStateChange(2);
            this.mDispatcher.dispatchOnFragmentViewCreated(false);
            int visibility = fragment.mView.getVisibility();
            fragment.ensureAnimationInfo().mPostOnViewCreatedAlpha = fragment.mView.getAlpha();
            if (fragment.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment.mView.findFocus();
                if (viewFindFocus != null) {
                    fragment.ensureAnimationInfo().mFocusedView = viewFindFocus;
                    if (FragmentManagerImpl.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
                    }
                }
                fragment.mView.setAlpha(0.0f);
            }
        }
        fragment.mState = 2;
    }

    public final void destroy() {
        Fragment fragmentFindActiveFragment;
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "movefrom CREATED: " + fragment);
        }
        boolean zIsChangingConfigurations = true;
        int i = 0;
        boolean z = fragment.mRemoving && !fragment.isInBackStack();
        Dispatcher dispatcher = this.mFragmentStore;
        if (z) {
        }
        if (!z) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) dispatcher.runningSyncCalls;
            if (!((fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho) && fragmentManagerViewModel.mStateAutomaticallySaved) ? fragmentManagerViewModel.mHasBeenCleared : true)) {
                String str = fragment.mTargetWho;
                if (str != null && (fragmentFindActiveFragment = dispatcher.findActiveFragment(str)) != null && fragmentFindActiveFragment.mRetainInstance) {
                    fragment.mTarget = fragmentFindActiveFragment;
                }
                fragment.mState = 0;
                return;
            }
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks = fragment.mHost;
        if (fragmentActivity$HostCallbacks != null) {
            zIsChangingConfigurations = ((FragmentManagerViewModel) dispatcher.runningSyncCalls).mHasBeenCleared;
        } else {
            AppCompatActivity appCompatActivity = fragmentActivity$HostCallbacks.mContext;
            if (ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) appCompatActivity)) {
                zIsChangingConfigurations = true ^ appCompatActivity.isChangingConfigurations();
            }
        }
        if (z || zIsChangingConfigurations) {
            ((FragmentManagerViewModel) dispatcher.runningSyncCalls).clearNonConfigState(fragment);
        }
        fragment.mChildFragmentManager.dispatchDestroy();
        fragment.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        fragment.mState = 0;
        fragment.mCalled = false;
        fragment.mIsCreated = false;
        fragment.mCalled = true;
        if (!fragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDestroy()");
        }
        this.mDispatcher.dispatchOnFragmentDestroyed(false);
        ArrayList activeFragmentStateManagers = dispatcher.getActiveFragmentStateManagers();
        int size = activeFragmentStateManagers.size();
        while (i < size) {
            Object obj = activeFragmentStateManagers.get(i);
            i++;
            FragmentStateManager fragmentStateManager = (FragmentStateManager) obj;
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (fragment.mWho.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str2 = fragment.mTargetWho;
        if (str2 != null) {
            fragment.mTarget = dispatcher.findActiveFragment(str2);
        }
        dispatcher.makeInactive(this);
    }

    public final void destroyFragmentView() {
        View view;
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.mChildFragmentManager.dispatchStateChange(1);
        if (fragment.mView != null) {
            FragmentViewLifecycleOwner fragmentViewLifecycleOwner = fragment.mViewLifecycleOwner;
            fragmentViewLifecycleOwner.initialize();
            if (fragmentViewLifecycleOwner.mLifecycleRegistry.state.isAtLeast(Lifecycle.State.CREATED)) {
                fragment.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
            }
        }
        fragment.mState = 1;
        fragment.mCalled = false;
        fragment.onDestroyView();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDestroyView()");
        }
        Dispatcher dispatcher = new Dispatcher(fragment.getViewModelStore(), LoaderManagerImpl$LoaderViewModel.FACTORY, CreationExtras.Empty.INSTANCE);
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LoaderManagerImpl$LoaderViewModel.class);
        String qualifiedName = orCreateKotlinClass.getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        SparseArrayCompat sparseArrayCompat = ((LoaderManagerImpl$LoaderViewModel) dispatcher.getViewModel$lifecycle_viewmodel_release("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName), orCreateKotlinClass)).mLoaders;
        if (sparseArrayCompat.size() > 0) {
            sparseArrayCompat.valueAt(0).getClass();
            throw new ClassCastException();
        }
        fragment.mPerformedCreateView = false;
        this.mDispatcher.dispatchOnFragmentViewDestroyed(false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public final void detach() {
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.mState = -1;
        fragment.mCalled = false;
        fragment.onDetach();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDetach()");
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        if (!fragmentManagerImpl.mDestroyed) {
            fragmentManagerImpl.dispatchDestroy();
            fragment.mChildFragmentManager = new FragmentManagerImpl();
        }
        this.mDispatcher.dispatchOnFragmentDetached(false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) this.mFragmentStore.runningSyncCalls;
            if (!((fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho) && fragmentManagerViewModel.mStateAutomaticallySaved) ? fragmentManagerViewModel.mHasBeenCleared : true)) {
                return;
            }
        }
        if (FragmentManagerImpl.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.initState();
    }

    public final void ensureInflatedView() {
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManagerImpl.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            fragment.performCreateView(fragment.onGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.mChildFragmentManager.dispatchStateChange(2);
                this.mDispatcher.dispatchOnFragmentViewCreated(false);
                fragment.mState = 2;
            }
        }
    }

    public final void moveToExpectedState() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        Dispatcher dispatcher = this.mFragmentStore;
        boolean z = this.mMovingToState;
        Fragment fragment = this.mFragment;
        if (z) {
            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.mMovingToState = true;
            boolean z2 = false;
            while (true) {
                int iComputeExpectedState = computeExpectedState();
                int i = fragment.mState;
                if (iComputeExpectedState == i) {
                    if (!z2 && i == -1 && fragment.mRemoving && !fragment.isInBackStack()) {
                        if (FragmentManagerImpl.isLoggingEnabled(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + fragment);
                        }
                        ((FragmentManagerViewModel) dispatcher.runningSyncCalls).clearNonConfigState(fragment);
                        dispatcher.makeInactive(this);
                        if (FragmentManagerImpl.isLoggingEnabled(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + fragment);
                        }
                        fragment.initState();
                    }
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager().getSpecialEffectsControllerFactory());
                            if (fragment.mHidden) {
                                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                }
                                orCreateController.enqueue(3, 1, this);
                            } else {
                                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                }
                                orCreateController.enqueue(2, 1, this);
                            }
                        }
                        FragmentManagerImpl fragmentManagerImpl = fragment.mFragmentManager;
                        if (fragmentManagerImpl != null && fragment.mAdded && FragmentManagerImpl.isMenuAvailable(fragment)) {
                            fragmentManagerImpl.mNeedMenuInvalidate = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.mChildFragmentManager.dispatchOnHiddenChanged();
                    }
                    return;
                }
                if (iComputeExpectedState <= i) {
                    switch (i - 1) {
                        case -1:
                            detach();
                            break;
                        case 0:
                            destroy();
                            break;
                        case 1:
                            destroyFragmentView();
                            fragment.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManagerImpl.isLoggingEnabled(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && fragment.mSavedViewState == null) {
                                saveViewState();
                            }
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                DefaultSpecialEffectsController orCreateController2 = DefaultSpecialEffectsController.getOrCreateController(viewGroup2, fragment.getParentFragmentManager().getSpecialEffectsControllerFactory());
                                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                }
                                orCreateController2.enqueue(1, 3, this);
                            }
                            fragment.mState = 3;
                            break;
                        case 4:
                            stop();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            pause();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            attach();
                            break;
                        case 1:
                            create();
                            break;
                        case 2:
                            ensureInflatedView();
                            createView();
                            break;
                        case 3:
                            activityCreated();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                DefaultSpecialEffectsController orCreateController3 = DefaultSpecialEffectsController.getOrCreateController(viewGroup3, fragment.getParentFragmentManager().getSpecialEffectsControllerFactory());
                                int i_from = Density.CC._from(fragment.mView.getVisibility());
                                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                }
                                orCreateController3.enqueue(i_from, 2, this);
                            }
                            fragment.mState = 4;
                            break;
                        case 5:
                            start();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            resume();
                            break;
                    }
                }
                z2 = true;
            }
        } finally {
            this.mMovingToState = false;
        }
    }

    public final void pause() {
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "movefrom RESUMED: " + fragment);
        }
        fragment.mChildFragmentManager.dispatchStateChange(5);
        if (fragment.mView != null) {
            fragment.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        fragment.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        fragment.mState = 6;
        fragment.mCalled = true;
        this.mDispatcher.dispatchOnFragmentPaused(false);
    }

    public final void restoreState(ClassLoader classLoader) {
        Fragment fragment = this.mFragment;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        String string = fragment.mSavedFragmentState.getString("android:target_state");
        fragment.mTargetWho = string;
        if (string != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        boolean z = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        fragment.mUserVisibleHint = z;
        if (z) {
            return;
        }
        fragment.mDeferStart = true;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0041  */
    /* JADX WARN: Code duplicated, block: B:21:0x0052  */
    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    public final void resume() {
        boolean zRequestFocus;
        String str;
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "moveto RESUMED: " + fragment);
        }
        Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
        View view = animationInfo == null ? null : animationInfo.mFocusedView;
        if (view != null) {
            if (view == fragment.mView) {
                zRequestFocus = view.requestFocus();
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                    sb.append(view);
                    sb.append(" ");
                    if (zRequestFocus) {
                        str = "succeeded";
                    } else {
                        str = "failed";
                    }
                    sb.append(str);
                    sb.append(" on Fragment ");
                    sb.append(fragment);
                    sb.append(" resulting in focused view ");
                    sb.append(fragment.mView.findFocus());
                    Log.v("FragmentManager", sb.toString());
                }
            } else {
                ViewParent parent = view.getParent();
                while (true) {
                    if (parent != null) {
                        if (parent == fragment.mView) {
                            zRequestFocus = view.requestFocus();
                            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                                StringBuilder sb2 = new StringBuilder("requestFocus: Restoring focused view ");
                                sb2.append(view);
                                sb2.append(" ");
                                if (zRequestFocus) {
                                    str = "succeeded";
                                } else {
                                    str = "failed";
                                }
                                sb2.append(str);
                                sb2.append(" on Fragment ");
                                sb2.append(fragment);
                                sb2.append(" resulting in focused view ");
                                sb2.append(fragment.mView.findFocus());
                                Log.v("FragmentManager", sb2.toString());
                            }
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
            }
        }
        fragment.ensureAnimationInfo().mFocusedView = null;
        fragment.mChildFragmentManager.noteStateNotSaved();
        fragment.mChildFragmentManager.execPendingActions(true);
        fragment.mState = 7;
        fragment.mCalled = false;
        fragment.mCalled = true;
        if (!fragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onResume()");
        }
        LifecycleRegistry lifecycleRegistry = fragment.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (fragment.mView != null) {
            fragment.mViewLifecycleOwner.handleLifecycleEvent(event);
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(7);
        this.mDispatcher.dispatchOnFragmentResumed(false);
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final void saveViewState() {
        Fragment fragment = this.mFragment;
        if (fragment.mView == null) {
            return;
        }
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + fragment + " with view " + fragment.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.mSavedStateRegistryController.performSave(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }

    public final void start() {
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "moveto STARTED: " + fragment);
        }
        fragment.mChildFragmentManager.noteStateNotSaved();
        fragment.mChildFragmentManager.execPendingActions(true);
        fragment.mState = 5;
        fragment.mCalled = false;
        fragment.onStart();
        if (!fragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onStart()");
        }
        LifecycleRegistry lifecycleRegistry = fragment.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (fragment.mView != null) {
            fragment.mViewLifecycleOwner.handleLifecycleEvent(event);
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(5);
        this.mDispatcher.dispatchOnFragmentStarted(false);
    }

    public final void stop() {
        boolean zIsLoggingEnabled = FragmentManagerImpl.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Log.d("FragmentManager", "movefrom STARTED: " + fragment);
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
        fragmentManagerImpl.mStopped = true;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = true;
        fragmentManagerImpl.dispatchStateChange(4);
        if (fragment.mView != null) {
            fragment.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
        fragment.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        fragment.mState = 4;
        fragment.mCalled = false;
        fragment.onStop();
        if (fragment.mCalled) {
            this.mDispatcher.dispatchOnFragmentStopped(false);
            return;
        }
        throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onStop()");
    }

    public FragmentStateManager(RequestService requestService, Dispatcher dispatcher, ClassLoader classLoader, FragmentManager$3 fragmentManager$3, FragmentState fragmentState) {
        this.mDispatcher = requestService;
        this.mFragmentStore = dispatcher;
        Fragment fragmentInstantiate = fragmentManager$3.instantiate(fragmentState.mClassName);
        Bundle bundle = fragmentState.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentInstantiate.setArguments(bundle);
        fragmentInstantiate.mWho = fragmentState.mWho;
        fragmentInstantiate.mFromLayout = fragmentState.mFromLayout;
        fragmentInstantiate.mRestored = true;
        fragmentInstantiate.mFragmentId = fragmentState.mFragmentId;
        fragmentInstantiate.mContainerId = fragmentState.mContainerId;
        fragmentInstantiate.mTag = fragmentState.mTag;
        fragmentInstantiate.mRetainInstance = fragmentState.mRetainInstance;
        fragmentInstantiate.mRemoving = fragmentState.mRemoving;
        fragmentInstantiate.mDetached = fragmentState.mDetached;
        fragmentInstantiate.mHidden = fragmentState.mHidden;
        fragmentInstantiate.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        Bundle bundle2 = fragmentState.mSavedFragmentState;
        if (bundle2 != null) {
            fragmentInstantiate.mSavedFragmentState = bundle2;
        } else {
            fragmentInstantiate.mSavedFragmentState = new Bundle();
        }
        this.mFragment = fragmentInstantiate;
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentInstantiate);
        }
    }

    public FragmentStateManager(RequestService requestService, Dispatcher dispatcher, Fragment fragment, FragmentState fragmentState) {
        this.mDispatcher = requestService;
        this.mFragmentStore = dispatcher;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentStateManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$fragmentView;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.val$fragmentView = obj;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            int i = this.$r8$classId;
            Object obj = this.val$fragmentView;
            switch (i) {
                case 0:
                    View view2 = (View) obj;
                    view2.removeOnAttachStateChangeListener(this);
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api20Impl.requestApplyInsets(view2);
                    break;
                case 1:
                case 2:
                    break;
                case 3:
                    AndroidGraphicsContext androidGraphicsContext = (AndroidGraphicsContext) obj;
                    Context context = view.getContext();
                    if (!androidGraphicsContext.componentCallbackRegistered) {
                        context.getApplicationContext().registerComponentCallbacks(androidGraphicsContext.componentCallback);
                        androidGraphicsContext.componentCallbackRegistered = true;
                    }
                    break;
                case 4:
                case 5:
                    break;
                default:
                    ((DropdownMenuEndIconDelegate) obj).addTouchExplorationStateChangeListenerIfNeeded();
                    break;
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            boolean z;
            switch (this.$r8$classId) {
                case 0:
                    break;
                case 1:
                    CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) this.val$fragmentView;
                    ViewTreeObserver viewTreeObserver = cascadingMenuPopup.mTreeObserver;
                    if (viewTreeObserver != null) {
                        if (!viewTreeObserver.isAlive()) {
                            cascadingMenuPopup.mTreeObserver = view.getViewTreeObserver();
                        }
                        cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
                    }
                    view.removeOnAttachStateChangeListener(this);
                    break;
                case 2:
                    StandardMenuPopup standardMenuPopup = (StandardMenuPopup) this.val$fragmentView;
                    ViewTreeObserver viewTreeObserver2 = standardMenuPopup.mTreeObserver;
                    if (viewTreeObserver2 != null) {
                        if (!viewTreeObserver2.isAlive()) {
                            standardMenuPopup.mTreeObserver = view.getViewTreeObserver();
                        }
                        standardMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(standardMenuPopup.mGlobalLayoutListener);
                    }
                    view.removeOnAttachStateChangeListener(this);
                    break;
                case 3:
                    AndroidGraphicsContext androidGraphicsContext = (AndroidGraphicsContext) this.val$fragmentView;
                    Context context = view.getContext();
                    if (androidGraphicsContext.componentCallbackRegistered) {
                        context.getApplicationContext().unregisterComponentCallbacks(androidGraphicsContext.componentCallback);
                        androidGraphicsContext.componentCallbackRegistered = false;
                    }
                    AndroidGraphicsContext.access$clearShadowCache(androidGraphicsContext);
                    break;
                case 4:
                    AbstractComposeView abstractComposeView = (AbstractComposeView) this.val$fragmentView;
                    Iterator it = SequencesKt.generateSequence(abstractComposeView.getParent(), ViewKt$ancestors$1.INSTANCE).iterator();
                    while (true) {
                        z = false;
                        if (it.hasNext()) {
                            Object obj = (ViewParent) it.next();
                            if (obj instanceof View) {
                                Object tag = ((View) obj).getTag(R.id.is_pooling_container_tag);
                                Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
                                if (bool != null ? bool.booleanValue() : false) {
                                    z = true;
                                }
                            }
                        }
                    }
                    if (!z) {
                        abstractComposeView.disposeComposition();
                    }
                    break;
                case 5:
                    view.removeOnAttachStateChangeListener(this);
                    ((StandaloneCoroutine) this.val$fragmentView).cancel((CancellationException) null);
                    break;
                default:
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.val$fragmentView;
                    AccessibilityManager accessibilityManager = dropdownMenuEndIconDelegate.accessibilityManager;
                    if (accessibilityManager != null) {
                        accessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(dropdownMenuEndIconDelegate.touchExplorationStateChangeListener));
                    }
                    break;
            }
        }

        private final void onViewAttachedToWindow$androidx$appcompat$view$menu$CascadingMenuPopup$2(View view) {
        }

        private final void onViewAttachedToWindow$androidx$appcompat$view$menu$StandardMenuPopup$2(View view) {
        }

        private final void onViewAttachedToWindow$androidx$compose$ui$platform$ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1(View view) {
        }

        private final void onViewAttachedToWindow$androidx$compose$ui$platform$WindowRecomposerPolicy$createAndInstallWindowRecomposer$1(View view) {
        }

        private final void onViewDetachedFromWindow$androidx$fragment$app$FragmentStateManager$1(View view) {
        }
    }
}
