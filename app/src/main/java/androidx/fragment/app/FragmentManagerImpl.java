package androidx.fragment.app;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry$register$2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.unit.Density;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHostHelper;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManagerImpl$LoaderViewModel;
import coil.request.Parameters;
import coil.request.RequestService;
import com.google.android.gms.tasks.zzg;
import com.koala.clash.R;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import okhttp3.Dispatcher;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentManagerImpl {
    public ArrayList mBackStack;
    public FragmentContainer mContainer;
    public ArrayList mCreatedMenus;
    public int mCurState;
    public final ByteString.Companion mDefaultSpecialEffectsControllerFactory;
    public boolean mDestroyed;
    public final zzg mExecCommit;
    public boolean mExecutingActions;
    public boolean mHavePendingDeferredStart;
    public FragmentActivity$HostCallbacks mHost;
    public final FragmentManager$3 mHostFragmentFactory;
    public ArrayDeque mLaunchedFragments;
    public final RequestService mLifecycleCallbacksDispatcher;
    public final FragmentManager$2 mMenuProvider;
    public boolean mNeedMenuInvalidate;
    public FragmentManagerViewModel mNonConfig;
    public final CopyOnWriteArrayList mOnAttachListeners;
    public final FragmentManager$1 mOnBackPressedCallback;
    public OnBackPressedDispatcher mOnBackPressedDispatcher;
    public final FragmentManager$$ExternalSyntheticLambda0 mOnConfigurationChangedListener;
    public final FragmentManager$$ExternalSyntheticLambda0 mOnMultiWindowModeChangedListener;
    public final FragmentManager$$ExternalSyntheticLambda0 mOnPictureInPictureModeChangedListener;
    public final FragmentManager$$ExternalSyntheticLambda0 mOnTrimMemoryListener;
    public Fragment mParent;
    public Fragment mPrimaryNav;
    public ActivityResultRegistry$register$2 mRequestPermissions;
    public ActivityResultRegistry$register$2 mStartActivityForResult;
    public ActivityResultRegistry$register$2 mStartIntentSenderForResult;
    public boolean mStateSaved;
    public boolean mStopped;
    public ArrayList mTmpAddedFragments;
    public ArrayList mTmpIsPop;
    public ArrayList mTmpRecords;
    public final ArrayList mPendingActions = new ArrayList();
    public final Dispatcher mFragmentStore = new Dispatcher(13);
    public final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
    public final AtomicInteger mBackStackIndex = new AtomicInteger();
    public final Map mBackStackStates = Collections.synchronizedMap(new HashMap());
    public final Map mResults = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0] */
    public FragmentManagerImpl() {
        final int i = 0;
        this.mOnBackPressedCallback = new FragmentManager$1(i, this, false);
        Collections.synchronizedMap(new HashMap());
        this.mLifecycleCallbacksDispatcher = new RequestService(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList();
        this.mOnConfigurationChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0
            public final /* synthetic */ FragmentManagerImpl f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        FragmentManagerImpl fragmentManagerImpl = this.f$0;
                        if (fragmentManagerImpl.isParentAdded()) {
                            fragmentManagerImpl.dispatchConfigurationChanged(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManagerImpl fragmentManagerImpl2 = this.f$0;
                        if (fragmentManagerImpl2.isParentAdded() && num.intValue() == 80) {
                            fragmentManagerImpl2.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManagerImpl fragmentManagerImpl3 = this.f$0;
                        if (fragmentManagerImpl3.isParentAdded()) {
                            boolean z = multiWindowModeChangedInfo.isInMultiWindowMode;
                            fragmentManagerImpl3.dispatchMultiWindowModeChanged(false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManagerImpl fragmentManagerImpl4 = this.f$0;
                        if (fragmentManagerImpl4.isParentAdded()) {
                            boolean z2 = pictureInPictureModeChangedInfo.isInPictureInPictureMode;
                            fragmentManagerImpl4.dispatchPictureInPictureModeChanged(false);
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mOnTrimMemoryListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0
            public final /* synthetic */ FragmentManagerImpl f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        FragmentManagerImpl fragmentManagerImpl = this.f$0;
                        if (fragmentManagerImpl.isParentAdded()) {
                            fragmentManagerImpl.dispatchConfigurationChanged(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManagerImpl fragmentManagerImpl2 = this.f$0;
                        if (fragmentManagerImpl2.isParentAdded() && num.intValue() == 80) {
                            fragmentManagerImpl2.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManagerImpl fragmentManagerImpl3 = this.f$0;
                        if (fragmentManagerImpl3.isParentAdded()) {
                            boolean z = multiWindowModeChangedInfo.isInMultiWindowMode;
                            fragmentManagerImpl3.dispatchMultiWindowModeChanged(false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManagerImpl fragmentManagerImpl4 = this.f$0;
                        if (fragmentManagerImpl4.isParentAdded()) {
                            boolean z2 = pictureInPictureModeChangedInfo.isInPictureInPictureMode;
                            fragmentManagerImpl4.dispatchPictureInPictureModeChanged(false);
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.mOnMultiWindowModeChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0
            public final /* synthetic */ FragmentManagerImpl f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        FragmentManagerImpl fragmentManagerImpl = this.f$0;
                        if (fragmentManagerImpl.isParentAdded()) {
                            fragmentManagerImpl.dispatchConfigurationChanged(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManagerImpl fragmentManagerImpl2 = this.f$0;
                        if (fragmentManagerImpl2.isParentAdded() && num.intValue() == 80) {
                            fragmentManagerImpl2.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManagerImpl fragmentManagerImpl3 = this.f$0;
                        if (fragmentManagerImpl3.isParentAdded()) {
                            boolean z = multiWindowModeChangedInfo.isInMultiWindowMode;
                            fragmentManagerImpl3.dispatchMultiWindowModeChanged(false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManagerImpl fragmentManagerImpl4 = this.f$0;
                        if (fragmentManagerImpl4.isParentAdded()) {
                            boolean z2 = pictureInPictureModeChangedInfo.isInPictureInPictureMode;
                            fragmentManagerImpl4.dispatchPictureInPictureModeChanged(false);
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.mOnPictureInPictureModeChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0
            public final /* synthetic */ FragmentManagerImpl f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        FragmentManagerImpl fragmentManagerImpl = this.f$0;
                        if (fragmentManagerImpl.isParentAdded()) {
                            fragmentManagerImpl.dispatchConfigurationChanged(false);
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        FragmentManagerImpl fragmentManagerImpl2 = this.f$0;
                        if (fragmentManagerImpl2.isParentAdded() && num.intValue() == 80) {
                            fragmentManagerImpl2.dispatchLowMemory(false);
                            break;
                        }
                        break;
                    case 2:
                        MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                        FragmentManagerImpl fragmentManagerImpl3 = this.f$0;
                        if (fragmentManagerImpl3.isParentAdded()) {
                            boolean z = multiWindowModeChangedInfo.isInMultiWindowMode;
                            fragmentManagerImpl3.dispatchMultiWindowModeChanged(false);
                        }
                        break;
                    default:
                        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                        FragmentManagerImpl fragmentManagerImpl4 = this.f$0;
                        if (fragmentManagerImpl4.isParentAdded()) {
                            boolean z2 = pictureInPictureModeChangedInfo.isInPictureInPictureMode;
                            fragmentManagerImpl4.dispatchPictureInPictureModeChanged(false);
                        }
                        break;
                }
            }
        };
        this.mMenuProvider = new FragmentManager$2(this);
        this.mCurState = -1;
        this.mHostFragmentFactory = new FragmentManager$3(this);
        this.mDefaultSpecialEffectsControllerFactory = new ByteString.Companion(10);
        this.mLaunchedFragments = new ArrayDeque();
        this.mExecCommit = new zzg(14, this);
    }

    public static boolean isLoggingEnabled(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean isMenuAvailable(Fragment fragment) {
        fragment.getClass();
        ArrayList activeFragments = fragment.mChildFragmentManager.mFragmentStore.getActiveFragments();
        int size = activeFragments.size();
        boolean zIsMenuAvailable = false;
        int i = 0;
        while (i < size) {
            Object obj = activeFragments.get(i);
            i++;
            Fragment fragment2 = (Fragment) obj;
            if (fragment2 != null) {
                zIsMenuAvailable = isMenuAvailable(fragment2);
            }
            if (zIsMenuAvailable) {
                return true;
            }
        }
        return false;
    }

    public static boolean isParentMenuVisible(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        if (fragment.mMenuVisible) {
            return fragment.mFragmentManager == null || isParentMenuVisible(fragment.mParentFragment);
        }
        return false;
    }

    public static boolean isPrimaryNavigation(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManagerImpl fragmentManagerImpl = fragment.mFragmentManager;
        return fragment.equals(fragmentManagerImpl.mPrimaryNav) && isPrimaryNavigation(fragmentManagerImpl.mParent);
    }

    public static void showFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final FragmentStateManager addFragment(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str);
        }
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        FragmentStateManager fragmentStateManagerCreateOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        Dispatcher dispatcher = this.mFragmentStore;
        dispatcher.makeActive(fragmentStateManagerCreateOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            dispatcher.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return fragmentStateManagerCreateOrGetFragmentStateManager;
    }

    public final void attachController(FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks, FragmentContainer fragmentContainer, final Fragment fragment) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = fragmentActivity$HostCallbacks;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
        CopyOnWriteArrayList copyOnWriteArrayList = this.mOnAttachListeners;
        if (fragment != null) {
            copyOnWriteArrayList.add(new FragmentOnAttachListener() { // from class: androidx.fragment.app.FragmentManager$7
                @Override // androidx.fragment.app.FragmentOnAttachListener
                public final void onAttachFragment$1() {
                    fragment.getClass();
                }
            });
        } else if (fragmentActivity$HostCallbacks != null) {
            copyOnWriteArrayList.add(fragmentActivity$HostCallbacks);
        }
        if (this.mParent != null) {
            updateOnBackPressedCallbackEnabled();
        }
        if (fragmentActivity$HostCallbacks != null) {
            OnBackPressedDispatcher onBackPressedDispatcher = fragmentActivity$HostCallbacks.this$0.getOnBackPressedDispatcher();
            this.mOnBackPressedDispatcher = onBackPressedDispatcher;
            onBackPressedDispatcher.addCallback(this.mOnBackPressedCallback, fragment != null ? fragment : fragmentActivity$HostCallbacks);
        }
        if (fragment != null) {
            FragmentManagerViewModel fragmentManagerViewModel = fragment.mFragmentManager.mNonConfig;
            HashMap map = fragmentManagerViewModel.mChildNonConfigs;
            FragmentManagerViewModel fragmentManagerViewModel2 = (FragmentManagerViewModel) map.get(fragment.mWho);
            if (fragmentManagerViewModel2 == null) {
                fragmentManagerViewModel2 = new FragmentManagerViewModel(fragmentManagerViewModel.mStateAutomaticallySaved);
                map.put(fragment.mWho, fragmentManagerViewModel2);
            }
            this.mNonConfig = fragmentManagerViewModel2;
        } else if (fragmentActivity$HostCallbacks != null) {
            Dispatcher dispatcher = new Dispatcher(fragmentActivity$HostCallbacks.this$0.getViewModelStore(), FragmentManagerViewModel.FACTORY, CreationExtras.Empty.INSTANCE);
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FragmentManagerViewModel.class);
            String qualifiedName = orCreateKotlinClass.getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.mNonConfig = (FragmentManagerViewModel) dispatcher.getViewModel$lifecycle_viewmodel_release("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName), orCreateKotlinClass);
        } else {
            this.mNonConfig = new FragmentManagerViewModel(false);
        }
        FragmentManagerViewModel fragmentManagerViewModel3 = this.mNonConfig;
        fragmentManagerViewModel3.mIsStateSaved = this.mStateSaved || this.mStopped;
        this.mFragmentStore.runningSyncCalls = fragmentManagerViewModel3;
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks2 = this.mHost;
        if (fragmentActivity$HostCallbacks2 != null && fragment == null) {
            RequestService savedStateRegistry = fragmentActivity$HostCallbacks2.getSavedStateRegistry();
            savedStateRegistry.registerSavedStateProvider("android:support:fragments", new FragmentManager$$ExternalSyntheticLambda4(0, this));
            Bundle bundleConsumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey("android:support:fragments");
            if (bundleConsumeRestoredStateForKey != null) {
                restoreSaveStateInternal(bundleConsumeRestoredStateForKey);
            }
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks3 = this.mHost;
        if (fragmentActivity$HostCallbacks3 != null) {
            ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1 = fragmentActivity$HostCallbacks3.this$0.activityResultRegistry;
            String strM = CaptureSession$State$EnumUnboxingLocalUtility.m("FragmentManager:", fragment != null ? ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), fragment.mWho, ":") : "");
            this.mStartActivityForResult = componentActivity$activityResultRegistry$1.register(ImageAnalysis$$ExternalSyntheticLambda1.m(strM, "StartActivityForResult"), new ScanQRCode(5), new Parameters.Builder(21, this));
            final int i = 0;
            this.mStartIntentSenderForResult = componentActivity$activityResultRegistry$1.register(ImageAnalysis$$ExternalSyntheticLambda1.m(strM, "StartIntentSenderForResult"), new ScanQRCode(6), new ActivityResultCallback(this) { // from class: androidx.fragment.app.FragmentManager$9
                public final /* synthetic */ FragmentManagerImpl this$0;

                {
                    this.this$0 = this;
                }

                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    switch (i) {
                        case 0:
                            ActivityResult activityResult = (ActivityResult) obj;
                            FragmentManagerImpl fragmentManagerImpl = this.this$0;
                            FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) fragmentManagerImpl.mLaunchedFragments.pollFirst();
                            if (fragmentManager$LaunchedFragmentInfo == null) {
                                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                            } else {
                                String str = fragmentManager$LaunchedFragmentInfo.mWho;
                                int i2 = fragmentManager$LaunchedFragmentInfo.mRequestCode;
                                Fragment fragmentFindFragmentByWho = fragmentManagerImpl.mFragmentStore.findFragmentByWho(str);
                                if (fragmentFindFragmentByWho == null) {
                                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                                } else {
                                    fragmentFindFragmentByWho.onActivityResult(i2, activityResult.resultCode, activityResult.data);
                                }
                            }
                            break;
                        default:
                            Map map2 = (Map) obj;
                            ArrayList arrayList = new ArrayList(map2.values());
                            int[] iArr = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue() ? 0 : -1;
                            }
                            FragmentManagerImpl fragmentManagerImpl2 = this.this$0;
                            FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo2 = (FragmentManager$LaunchedFragmentInfo) fragmentManagerImpl2.mLaunchedFragments.pollFirst();
                            if (fragmentManager$LaunchedFragmentInfo2 == null) {
                                Log.w("FragmentManager", "No permissions were requested for " + this);
                            } else {
                                String str2 = fragmentManager$LaunchedFragmentInfo2.mWho;
                                if (fragmentManagerImpl2.mFragmentStore.findFragmentByWho(str2) == null) {
                                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                                }
                            }
                            break;
                    }
                }
            });
            final int i2 = 1;
            this.mRequestPermissions = componentActivity$activityResultRegistry$1.register(ImageAnalysis$$ExternalSyntheticLambda1.m(strM, "RequestPermissions"), new ScanQRCode(3), new ActivityResultCallback(this) { // from class: androidx.fragment.app.FragmentManager$9
                public final /* synthetic */ FragmentManagerImpl this$0;

                {
                    this.this$0 = this;
                }

                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    switch (i2) {
                        case 0:
                            ActivityResult activityResult = (ActivityResult) obj;
                            FragmentManagerImpl fragmentManagerImpl = this.this$0;
                            FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) fragmentManagerImpl.mLaunchedFragments.pollFirst();
                            if (fragmentManager$LaunchedFragmentInfo == null) {
                                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                            } else {
                                String str = fragmentManager$LaunchedFragmentInfo.mWho;
                                int i3 = fragmentManager$LaunchedFragmentInfo.mRequestCode;
                                Fragment fragmentFindFragmentByWho = fragmentManagerImpl.mFragmentStore.findFragmentByWho(str);
                                if (fragmentFindFragmentByWho == null) {
                                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                                } else {
                                    fragmentFindFragmentByWho.onActivityResult(i3, activityResult.resultCode, activityResult.data);
                                }
                            }
                            break;
                        default:
                            Map map2 = (Map) obj;
                            ArrayList arrayList = new ArrayList(map2.values());
                            int[] iArr = new int[arrayList.size()];
                            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                iArr[i4] = ((Boolean) arrayList.get(i4)).booleanValue() ? 0 : -1;
                            }
                            FragmentManagerImpl fragmentManagerImpl2 = this.this$0;
                            FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo2 = (FragmentManager$LaunchedFragmentInfo) fragmentManagerImpl2.mLaunchedFragments.pollFirst();
                            if (fragmentManager$LaunchedFragmentInfo2 == null) {
                                Log.w("FragmentManager", "No permissions were requested for " + this);
                            } else {
                                String str2 = fragmentManager$LaunchedFragmentInfo2.mWho;
                                if (fragmentManagerImpl2.mFragmentStore.findFragmentByWho(str2) == null) {
                                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                                }
                            }
                            break;
                    }
                }
            });
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks4 = this.mHost;
        if (fragmentActivity$HostCallbacks4 != null) {
            fragmentActivity$HostCallbacks4.this$0.addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks5 = this.mHost;
        if (fragmentActivity$HostCallbacks5 != null) {
            fragmentActivity$HostCallbacks5.this$0.onTrimMemoryListeners.add(this.mOnTrimMemoryListener);
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks6 = this.mHost;
        if (fragmentActivity$HostCallbacks6 != null) {
            fragmentActivity$HostCallbacks6.this$0.onMultiWindowModeChangedListeners.add(this.mOnMultiWindowModeChangedListener);
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks7 = this.mHost;
        if (fragmentActivity$HostCallbacks7 != null) {
            fragmentActivity$HostCallbacks7.this$0.onPictureInPictureModeChangedListeners.add(this.mOnPictureInPictureModeChangedListener);
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks8 = this.mHost;
        if (fragmentActivity$HostCallbacks8 == null || fragment != null) {
            return;
        }
        MenuHostHelper menuHostHelper = fragmentActivity$HostCallbacks8.this$0.menuHostHelper;
        ((CopyOnWriteArrayList) menuHostHelper.mMenuProviders).add(this.mMenuProvider);
        ((Runnable) menuHostHelper.mOnInvalidateMenuCallback).run();
    }

    public final void attachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.mFragmentStore.addFragment(fragment);
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    public final void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public final HashSet collectAllSpecialEffectsController() {
        HashSet hashSet = new HashSet();
        ArrayList activeFragmentStateManagers = this.mFragmentStore.getActiveFragmentStateManagers();
        int size = activeFragmentStateManagers.size();
        int i = 0;
        while (i < size) {
            Object obj = activeFragmentStateManagers.get(i);
            i++;
            ViewGroup viewGroup = ((FragmentStateManager) obj).mFragment.mContainer;
            if (viewGroup != null) {
                hashSet.add(DefaultSpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
            }
        }
        return hashSet;
    }

    public final FragmentStateManager createOrGetFragmentStateManager(Fragment fragment) {
        String str = fragment.mWho;
        Dispatcher dispatcher = this.mFragmentStore;
        FragmentStateManager fragmentStateManager = (FragmentStateManager) ((HashMap) dispatcher.readyAsyncCalls).get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, dispatcher, fragment);
        fragmentStateManager2.restoreState(this.mHost.mContext.getClassLoader());
        fragmentStateManager2.mFragmentManagerState = this.mCurState;
        return fragmentStateManager2;
    }

    public final void detachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            Dispatcher dispatcher = this.mFragmentStore;
            synchronized (((ArrayList) dispatcher.executorServiceOrNull)) {
                ((ArrayList) dispatcher.executorServiceOrNull).remove(fragment);
            }
            fragment.mAdded = false;
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            setVisibleRemovingFragment(fragment);
        }
    }

    public final void dispatchConfigurationChanged(boolean z) {
        if (z && this.mHost != null) {
            throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.mCalled = true;
                if (z) {
                    fragment.mChildFragmentManager.dispatchConfigurationChanged(true);
                }
            }
        }
    }

    public final boolean dispatchContextItemSelected() {
        if (this.mCurState >= 1) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    if (!fragment.mHidden ? fragment.mChildFragmentManager.dispatchContextItemSelected() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean dispatchCreateOptionsMenu() {
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && isParentMenuVisible(fragment)) {
                if (!fragment.mHidden ? fragment.mChildFragmentManager.dispatchCreateOptionsMenu() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    z = true;
                }
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); i++) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.getClass();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public final void dispatchDestroy() {
        boolean z;
        this.mDestroyed = true;
        execPendingActions(true);
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (it.hasNext()) {
            ((DefaultSpecialEffectsController) it.next()).forceCompleteAllOperations();
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks = this.mHost;
        Dispatcher dispatcher = this.mFragmentStore;
        if (fragmentActivity$HostCallbacks != null) {
            z = ((FragmentManagerViewModel) dispatcher.runningSyncCalls).mHasBeenCleared;
        } else {
            AppCompatActivity appCompatActivity = fragmentActivity$HostCallbacks.mContext;
            z = ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) appCompatActivity) ? !appCompatActivity.isChangingConfigurations() : true;
        }
        if (z) {
            Iterator it2 = this.mBackStackStates.values().iterator();
            while (it2.hasNext()) {
                ArrayList arrayList = ((BackStackState) it2.next()).mFragments;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    String str = (String) obj;
                    FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) dispatcher.runningSyncCalls;
                    fragmentManagerViewModel.getClass();
                    if (isLoggingEnabled(3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    fragmentManagerViewModel.clearNonConfigStateInternal(str);
                }
            }
        }
        dispatchStateChange(-1);
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks2 = this.mHost;
        if (fragmentActivity$HostCallbacks2 != null) {
            fragmentActivity$HostCallbacks2.this$0.onTrimMemoryListeners.remove(this.mOnTrimMemoryListener);
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks3 = this.mHost;
        if (fragmentActivity$HostCallbacks3 != null) {
            fragmentActivity$HostCallbacks3.this$0.onConfigurationChangedListeners.remove(this.mOnConfigurationChangedListener);
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks4 = this.mHost;
        if (fragmentActivity$HostCallbacks4 != null) {
            fragmentActivity$HostCallbacks4.this$0.onMultiWindowModeChangedListeners.remove(this.mOnMultiWindowModeChangedListener);
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks5 = this.mHost;
        if (fragmentActivity$HostCallbacks5 != null) {
            fragmentActivity$HostCallbacks5.this$0.onPictureInPictureModeChangedListeners.remove(this.mOnPictureInPictureModeChangedListener);
        }
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks6 = this.mHost;
        if (fragmentActivity$HostCallbacks6 != null) {
            MenuHostHelper menuHostHelper = fragmentActivity$HostCallbacks6.this$0.menuHostHelper;
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) menuHostHelper.mMenuProviders;
            FragmentManager$2 fragmentManager$2 = this.mMenuProvider;
            copyOnWriteArrayList.remove(fragmentManager$2);
            if (((HashMap) menuHostHelper.mProviderToLifecycleContainers).remove(fragmentManager$2) != null) {
                throw new ClassCastException();
            }
            ((Runnable) menuHostHelper.mOnInvalidateMenuCallback).run();
        }
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
        ActivityResultRegistry$register$2 activityResultRegistry$register$2 = this.mStartActivityForResult;
        if (activityResultRegistry$register$2 != null) {
            activityResultRegistry$register$2.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    public final void dispatchLowMemory(boolean z) {
        if (z && this.mHost != null) {
            throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.mCalled = true;
                if (z) {
                    fragment.mChildFragmentManager.dispatchLowMemory(true);
                }
            }
        }
    }

    public final void dispatchMultiWindowModeChanged(boolean z) {
        if (z && this.mHost != null) {
            throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && z) {
                fragment.mChildFragmentManager.dispatchMultiWindowModeChanged(true);
            }
        }
    }

    public final void dispatchOnHiddenChanged() {
        ArrayList activeFragments = this.mFragmentStore.getActiveFragments();
        int size = activeFragments.size();
        int i = 0;
        while (i < size) {
            Object obj = activeFragments.get(i);
            i++;
            Fragment fragment = (Fragment) obj;
            if (fragment != null) {
                fragment.isHidden();
                fragment.mChildFragmentManager.dispatchOnHiddenChanged();
            }
        }
    }

    public final boolean dispatchOptionsItemSelected() {
        if (this.mCurState >= 1) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    if (!fragment.mHidden ? fragment.mChildFragmentManager.dispatchOptionsItemSelected() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed() {
        if (this.mCurState < 1) {
            return;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && !fragment.mHidden) {
                fragment.mChildFragmentManager.dispatchOptionsMenuClosed();
            }
        }
    }

    public final void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho))) {
                fragment.mFragmentManager.getClass();
                boolean zIsPrimaryNavigation = isPrimaryNavigation(fragment);
                Boolean bool = fragment.mIsPrimaryNavigationFragment;
                if (bool == null || bool.booleanValue() != zIsPrimaryNavigation) {
                    fragment.mIsPrimaryNavigationFragment = Boolean.valueOf(zIsPrimaryNavigation);
                    FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
                    fragmentManagerImpl.updateOnBackPressedCallbackEnabled();
                    fragmentManagerImpl.dispatchParentPrimaryNavigationFragmentChanged(fragmentManagerImpl.mPrimaryNav);
                }
            }
        }
    }

    public final void dispatchPictureInPictureModeChanged(boolean z) {
        if (z && this.mHost != null) {
            throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && z) {
                fragment.mChildFragmentManager.dispatchPictureInPictureModeChanged(true);
            }
        }
    }

    public final boolean dispatchPrepareOptionsMenu() {
        if (this.mCurState < 1) {
            return false;
        }
        boolean z = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && isParentMenuVisible(fragment)) {
                if (!fragment.mHidden ? fragment.mChildFragmentManager.dispatchPrepareOptionsMenu() : false) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            for (FragmentStateManager fragmentStateManager : ((HashMap) this.mFragmentStore.readyAsyncCalls).values()) {
                if (fragmentStateManager != null) {
                    fragmentStateManager.mFragmentManagerState = i;
                }
            }
            moveToState(i, false);
            Iterator it = collectAllSpecialEffectsController().iterator();
            while (it.hasNext()) {
                ((DefaultSpecialEffectsController) it.next()).forceCompleteAllOperations();
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    public final void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2;
        String strM = ImageAnalysis$$ExternalSyntheticLambda1.m(str, "    ");
        Dispatcher dispatcher = this.mFragmentStore;
        ArrayList arrayList = (ArrayList) dispatcher.executorServiceOrNull;
        String strM2 = ImageAnalysis$$ExternalSyntheticLambda1.m(str, "    ");
        HashMap map = (HashMap) dispatcher.readyAsyncCalls;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : map.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    Fragment fragment = fragmentStateManager.mFragment;
                    printWriter.println(fragment);
                    fragment.getClass();
                    printWriter.print(strM2);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(fragment.mFragmentId));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(fragment.mContainerId));
                    printWriter.print(" mTag=");
                    printWriter.println(fragment.mTag);
                    printWriter.print(strM2);
                    printWriter.print("mState=");
                    printWriter.print(fragment.mState);
                    printWriter.print(" mWho=");
                    printWriter.print(fragment.mWho);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(fragment.mBackStackNesting);
                    printWriter.print(strM2);
                    printWriter.print("mAdded=");
                    printWriter.print(fragment.mAdded);
                    printWriter.print(" mRemoving=");
                    printWriter.print(fragment.mRemoving);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(fragment.mFromLayout);
                    printWriter.print(" mInLayout=");
                    printWriter.println(fragment.mInLayout);
                    printWriter.print(strM2);
                    printWriter.print("mHidden=");
                    printWriter.print(fragment.mHidden);
                    printWriter.print(" mDetached=");
                    printWriter.print(fragment.mDetached);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(fragment.mMenuVisible);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(strM2);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(fragment.mRetainInstance);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(fragment.mUserVisibleHint);
                    if (fragment.mFragmentManager != null) {
                        printWriter.print(strM2);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(fragment.mFragmentManager);
                    }
                    if (fragment.mHost != null) {
                        printWriter.print(strM2);
                        printWriter.print("mHost=");
                        printWriter.println(fragment.mHost);
                    }
                    if (fragment.mParentFragment != null) {
                        printWriter.print(strM2);
                        printWriter.print("mParentFragment=");
                        printWriter.println(fragment.mParentFragment);
                    }
                    if (fragment.mArguments != null) {
                        printWriter.print(strM2);
                        printWriter.print("mArguments=");
                        printWriter.println(fragment.mArguments);
                    }
                    if (fragment.mSavedFragmentState != null) {
                        printWriter.print(strM2);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(fragment.mSavedFragmentState);
                    }
                    if (fragment.mSavedViewState != null) {
                        printWriter.print(strM2);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(fragment.mSavedViewState);
                    }
                    if (fragment.mSavedViewRegistryState != null) {
                        printWriter.print(strM2);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(fragment.mSavedViewRegistryState);
                    }
                    Object objFindActiveFragment = fragment.mTarget;
                    if (objFindActiveFragment == null) {
                        FragmentManagerImpl fragmentManagerImpl = fragment.mFragmentManager;
                        objFindActiveFragment = (fragmentManagerImpl == null || (str2 = fragment.mTargetWho) == null) ? null : fragmentManagerImpl.mFragmentStore.findActiveFragment(str2);
                    }
                    if (objFindActiveFragment != null) {
                        printWriter.print(strM2);
                        printWriter.print("mTarget=");
                        printWriter.print(objFindActiveFragment);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(fragment.mTargetRequestCode);
                    }
                    printWriter.print(strM2);
                    printWriter.print("mPopDirection=");
                    Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
                    printWriter.println(animationInfo == null ? false : animationInfo.mIsPop);
                    Fragment.AnimationInfo animationInfo2 = fragment.mAnimationInfo;
                    if ((animationInfo2 == null ? 0 : animationInfo2.mEnterAnim) != 0) {
                        printWriter.print(strM2);
                        printWriter.print("getEnterAnim=");
                        Fragment.AnimationInfo animationInfo3 = fragment.mAnimationInfo;
                        printWriter.println(animationInfo3 == null ? 0 : animationInfo3.mEnterAnim);
                    }
                    Fragment.AnimationInfo animationInfo4 = fragment.mAnimationInfo;
                    if ((animationInfo4 == null ? 0 : animationInfo4.mExitAnim) != 0) {
                        printWriter.print(strM2);
                        printWriter.print("getExitAnim=");
                        Fragment.AnimationInfo animationInfo5 = fragment.mAnimationInfo;
                        printWriter.println(animationInfo5 == null ? 0 : animationInfo5.mExitAnim);
                    }
                    Fragment.AnimationInfo animationInfo6 = fragment.mAnimationInfo;
                    if ((animationInfo6 == null ? 0 : animationInfo6.mPopEnterAnim) != 0) {
                        printWriter.print(strM2);
                        printWriter.print("getPopEnterAnim=");
                        Fragment.AnimationInfo animationInfo7 = fragment.mAnimationInfo;
                        printWriter.println(animationInfo7 == null ? 0 : animationInfo7.mPopEnterAnim);
                    }
                    Fragment.AnimationInfo animationInfo8 = fragment.mAnimationInfo;
                    if ((animationInfo8 == null ? 0 : animationInfo8.mPopExitAnim) != 0) {
                        printWriter.print(strM2);
                        printWriter.print("getPopExitAnim=");
                        Fragment.AnimationInfo animationInfo9 = fragment.mAnimationInfo;
                        printWriter.println(animationInfo9 == null ? 0 : animationInfo9.mPopExitAnim);
                    }
                    if (fragment.mContainer != null) {
                        printWriter.print(strM2);
                        printWriter.print("mContainer=");
                        printWriter.println(fragment.mContainer);
                    }
                    if (fragment.mView != null) {
                        printWriter.print(strM2);
                        printWriter.print("mView=");
                        printWriter.println(fragment.mView);
                    }
                    if (fragment.getContext() != null) {
                        Dispatcher dispatcher2 = new Dispatcher(fragment.getViewModelStore(), LoaderManagerImpl$LoaderViewModel.FACTORY, CreationExtras.Empty.INSTANCE);
                        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LoaderManagerImpl$LoaderViewModel.class);
                        String qualifiedName = orCreateKotlinClass.getQualifiedName();
                        if (qualifiedName == null) {
                            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                        }
                        SparseArrayCompat sparseArrayCompat = ((LoaderManagerImpl$LoaderViewModel) dispatcher2.getViewModel$lifecycle_viewmodel_release("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName), orCreateKotlinClass)).mLoaders;
                        if (sparseArrayCompat.size() > 0) {
                            printWriter.print(strM2);
                            printWriter.println("Loaders:");
                            if (sparseArrayCompat.size() > 0) {
                                if (sparseArrayCompat.valueAt(0) != null) {
                                    throw new ClassCastException();
                                }
                                printWriter.print(strM2);
                                printWriter.print("  #");
                                printWriter.print(sparseArrayCompat.keyAt(0));
                                printWriter.print(": ");
                                throw null;
                            }
                        }
                    }
                    printWriter.print(strM2);
                    printWriter.println("Child " + fragment.mChildFragmentManager + ":");
                    fragment.mChildFragmentManager.dump(ImageAnalysis$$ExternalSyntheticLambda1.m(strM2, "  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size3; i++) {
                Fragment fragment2 = (Fragment) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.mCreatedMenus;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment3 = (Fragment) this.mCreatedMenus.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList arrayList3 = this.mBackStack;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(strM, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            try {
                int size4 = this.mPendingActions.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (FragmentManager$OpGenerator) this.mPendingActions.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    public final void enqueueAction(FragmentManager$OpGenerator fragmentManager$OpGenerator, boolean z) {
        if (!z) {
            if (this.mHost == null) {
                if (!this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (this.mStateSaved || this.mStopped) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.mPendingActions) {
            try {
                if (this.mHost == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.mPendingActions.add(fragmentManager$OpGenerator);
                    scheduleCommit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.mHost == null) {
            if (!this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && (this.mStateSaved || this.mStopped)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList();
            this.mTmpIsPop = new ArrayList();
        }
    }

    public final boolean execPendingActions(boolean z) {
        boolean zGenerateOps;
        ensureExecReady(z);
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = this.mTmpRecords;
            ArrayList arrayList2 = this.mTmpIsPop;
            synchronized (this.mPendingActions) {
                if (this.mPendingActions.isEmpty()) {
                    zGenerateOps = false;
                } else {
                    try {
                        int size = this.mPendingActions.size();
                        zGenerateOps = false;
                        for (int i = 0; i < size; i++) {
                            zGenerateOps |= ((FragmentManager$OpGenerator) this.mPendingActions.get(i)).generateOps(arrayList, arrayList2);
                        }
                        this.mPendingActions.clear();
                        this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                    } catch (Throwable th) {
                        this.mPendingActions.clear();
                        this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                        throw th;
                    }
                }
            }
            if (!zGenerateOps) {
                updateOnBackPressedCallbackEnabled();
                doPendingDeferredStart();
                ((HashMap) this.mFragmentStore.readyAsyncCalls).values().removeAll(Collections.singleton(null));
                return z2;
            }
            z2 = true;
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th2) {
                cleanupExec();
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x022b A[PHI: r14
      0x022b: PHI (r14v23 int) = (r14v22 int), (r14v24 int) binds: [B:103:0x021b, B:108:0x0227] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x0179  */
    /* JADX WARN: Code duplicated, block: B:65:0x017f  */
    public final void executeOpsTogether(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        ViewGroup viewGroup;
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        int i6;
        Dispatcher dispatcher = this.mFragmentStore;
        boolean z5 = ((BackStackRecord) arrayList.get(i)).mReorderingAllowed;
        ArrayList arrayList3 = this.mTmpAddedFragments;
        if (arrayList3 == null) {
            this.mTmpAddedFragments = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.mTmpAddedFragments.addAll(dispatcher.getFragments());
        Fragment fragment = this.mPrimaryNav;
        int i7 = i;
        boolean z6 = false;
        while (true) {
            int i8 = 1;
            if (i7 >= i2) {
                boolean z7 = z5;
                this.mTmpAddedFragments.clear();
                if (!z7 && this.mCurState >= 1) {
                    for (int i9 = i; i9 < i2; i9++) {
                        ArrayList arrayList4 = ((BackStackRecord) arrayList.get(i9)).mOps;
                        int size = arrayList4.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj = arrayList4.get(i10);
                            i10++;
                            Fragment fragment2 = ((FragmentTransaction$Op) obj).mFragment;
                            if (fragment2 != null && fragment2.mFragmentManager != null) {
                                dispatcher.makeActive(createOrGetFragmentStateManager(fragment2));
                            }
                        }
                    }
                }
                for (int i11 = i; i11 < i2; i11++) {
                    BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i11);
                    if (((Boolean) arrayList2.get(i11)).booleanValue()) {
                        backStackRecord.bumpBackStackNesting(-1);
                        FragmentManagerImpl fragmentManagerImpl = backStackRecord.mManager;
                        ArrayList arrayList5 = backStackRecord.mOps;
                        boolean z8 = true;
                        for (int size2 = arrayList5.size() - 1; size2 >= 0; size2--) {
                            FragmentTransaction$Op fragmentTransaction$Op = (FragmentTransaction$Op) arrayList5.get(size2);
                            Fragment fragment3 = fragmentTransaction$Op.mFragment;
                            if (fragment3 != null) {
                                if (fragment3.mAnimationInfo != null) {
                                    fragment3.ensureAnimationInfo().mIsPop = z8;
                                }
                                int i12 = backStackRecord.mTransition;
                                int i13 = 8194;
                                int i14 = 4097;
                                if (i12 != 4097) {
                                    if (i12 != 8194) {
                                        i13 = 4100;
                                        i14 = 8197;
                                        if (i12 != 8197) {
                                            if (i12 == 4099) {
                                                i13 = 4099;
                                            } else if (i12 != 4100) {
                                                i13 = 0;
                                            } else {
                                                i13 = i14;
                                            }
                                        }
                                    } else {
                                        i13 = i14;
                                    }
                                }
                                if (fragment3.mAnimationInfo != null || i13 != 0) {
                                    fragment3.ensureAnimationInfo();
                                    fragment3.mAnimationInfo.mNextTransition = i13;
                                }
                                fragment3.ensureAnimationInfo();
                                fragment3.mAnimationInfo.getClass();
                            }
                            switch (fragmentTransaction$Op.mCmd) {
                                case 1:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    z8 = true;
                                    fragmentManagerImpl.setExitAnimationOrder(fragment3, true);
                                    fragmentManagerImpl.removeFragment(fragment3);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + fragmentTransaction$Op.mCmd);
                                case 3:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManagerImpl.addFragment(fragment3);
                                    z8 = true;
                                    break;
                                case 4:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManagerImpl.getClass();
                                    showFragment(fragment3);
                                    z8 = true;
                                    break;
                                case 5:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManagerImpl.setExitAnimationOrder(fragment3, true);
                                    fragmentManagerImpl.hideFragment(fragment3);
                                    z8 = true;
                                    break;
                                case 6:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManagerImpl.attachFragment(fragment3);
                                    z8 = true;
                                    break;
                                case 7:
                                    fragment3.setAnimations(fragmentTransaction$Op.mEnterAnim, fragmentTransaction$Op.mExitAnim, fragmentTransaction$Op.mPopEnterAnim, fragmentTransaction$Op.mPopExitAnim);
                                    fragmentManagerImpl.setExitAnimationOrder(fragment3, true);
                                    fragmentManagerImpl.detachFragment(fragment3);
                                    z8 = true;
                                    break;
                                case 8:
                                    fragmentManagerImpl.setPrimaryNavigationFragment(null);
                                    z8 = true;
                                    break;
                                case 9:
                                    fragmentManagerImpl.setPrimaryNavigationFragment(fragment3);
                                    z8 = true;
                                    break;
                                case 10:
                                    fragmentManagerImpl.setMaxLifecycle(fragment3, fragmentTransaction$Op.mOldMaxState);
                                    z8 = true;
                                    break;
                            }
                        }
                    } else {
                        backStackRecord.bumpBackStackNesting(1);
                        FragmentManagerImpl fragmentManagerImpl2 = backStackRecord.mManager;
                        ArrayList arrayList6 = backStackRecord.mOps;
                        int size3 = arrayList6.size();
                        for (int i15 = 0; i15 < size3; i15++) {
                            FragmentTransaction$Op fragmentTransaction$Op2 = (FragmentTransaction$Op) arrayList6.get(i15);
                            Fragment fragment4 = fragmentTransaction$Op2.mFragment;
                            if (fragment4 != null) {
                                if (fragment4.mAnimationInfo != null) {
                                    fragment4.ensureAnimationInfo().mIsPop = false;
                                }
                                int i16 = backStackRecord.mTransition;
                                if (fragment4.mAnimationInfo != null || i16 != 0) {
                                    fragment4.ensureAnimationInfo();
                                    fragment4.mAnimationInfo.mNextTransition = i16;
                                }
                                fragment4.ensureAnimationInfo();
                                fragment4.mAnimationInfo.getClass();
                            }
                            switch (fragmentTransaction$Op2.mCmd) {
                                case 1:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManagerImpl2.setExitAnimationOrder(fragment4, false);
                                    fragmentManagerImpl2.addFragment(fragment4);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + fragmentTransaction$Op2.mCmd);
                                case 3:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManagerImpl2.removeFragment(fragment4);
                                    break;
                                case 4:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManagerImpl2.hideFragment(fragment4);
                                    break;
                                case 5:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManagerImpl2.setExitAnimationOrder(fragment4, false);
                                    showFragment(fragment4);
                                    break;
                                case 6:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManagerImpl2.detachFragment(fragment4);
                                    break;
                                case 7:
                                    fragment4.setAnimations(fragmentTransaction$Op2.mEnterAnim, fragmentTransaction$Op2.mExitAnim, fragmentTransaction$Op2.mPopEnterAnim, fragmentTransaction$Op2.mPopExitAnim);
                                    fragmentManagerImpl2.setExitAnimationOrder(fragment4, false);
                                    fragmentManagerImpl2.attachFragment(fragment4);
                                    break;
                                case 8:
                                    fragmentManagerImpl2.setPrimaryNavigationFragment(fragment4);
                                    break;
                                case 9:
                                    fragmentManagerImpl2.setPrimaryNavigationFragment(null);
                                    break;
                                case 10:
                                    fragmentManagerImpl2.setMaxLifecycle(fragment4, fragmentTransaction$Op2.mCurrentMaxState);
                                    break;
                            }
                        }
                    }
                }
                boolean zBooleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
                for (int i17 = i; i17 < i2; i17++) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) arrayList.get(i17);
                    if (zBooleanValue) {
                        for (int size4 = backStackRecord2.mOps.size() - 1; size4 >= 0; size4--) {
                            Fragment fragment5 = ((FragmentTransaction$Op) backStackRecord2.mOps.get(size4)).mFragment;
                            if (fragment5 != null) {
                                createOrGetFragmentStateManager(fragment5).moveToExpectedState();
                            }
                        }
                    } else {
                        ArrayList arrayList7 = backStackRecord2.mOps;
                        int size5 = arrayList7.size();
                        int i18 = 0;
                        while (i18 < size5) {
                            Object obj2 = arrayList7.get(i18);
                            i18++;
                            Fragment fragment6 = ((FragmentTransaction$Op) obj2).mFragment;
                            if (fragment6 != null) {
                                createOrGetFragmentStateManager(fragment6).moveToExpectedState();
                            }
                        }
                    }
                }
                moveToState(this.mCurState, true);
                HashSet<DefaultSpecialEffectsController> hashSet = new HashSet();
                for (int i19 = i; i19 < i2; i19++) {
                    ArrayList arrayList8 = ((BackStackRecord) arrayList.get(i19)).mOps;
                    int size6 = arrayList8.size();
                    int i20 = 0;
                    while (i20 < size6) {
                        Object obj3 = arrayList8.get(i20);
                        i20++;
                        Fragment fragment7 = ((FragmentTransaction$Op) obj3).mFragment;
                        if (fragment7 != null && (viewGroup = fragment7.mContainer) != null) {
                            hashSet.add(DefaultSpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
                        }
                    }
                }
                for (DefaultSpecialEffectsController defaultSpecialEffectsController : hashSet) {
                    defaultSpecialEffectsController.mOperationDirectionIsPop = zBooleanValue;
                    synchronized (defaultSpecialEffectsController.mPendingOperations) {
                        try {
                            defaultSpecialEffectsController.updateFinalState();
                            defaultSpecialEffectsController.mIsContainerPostponed = false;
                            for (int size7 = defaultSpecialEffectsController.mPendingOperations.size() - 1; size7 >= 0; size7--) {
                                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) defaultSpecialEffectsController.mPendingOperations.get(size7);
                                int i_from = Density.CC._from(specialEffectsController$FragmentStateManagerOperation.mFragment.mView);
                                if (specialEffectsController$FragmentStateManagerOperation.mFinalState == 2 && i_from != 2) {
                                    Fragment.AnimationInfo animationInfo = specialEffectsController$FragmentStateManagerOperation.mFragment.mAnimationInfo;
                                    defaultSpecialEffectsController.mIsContainerPostponed = false;
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    defaultSpecialEffectsController.executePendingOperations();
                }
                for (int i21 = i; i21 < i2; i21++) {
                    BackStackRecord backStackRecord3 = (BackStackRecord) arrayList.get(i21);
                    if (((Boolean) arrayList2.get(i21)).booleanValue() && backStackRecord3.mIndex >= 0) {
                        backStackRecord3.mIndex = -1;
                    }
                    backStackRecord3.getClass();
                }
                return;
            }
            BackStackRecord backStackRecord4 = (BackStackRecord) arrayList.get(i7);
            if (((Boolean) arrayList2.get(i7)).booleanValue()) {
                z = z5;
                i3 = i7;
                z2 = z6;
                int i22 = 1;
                ArrayList arrayList9 = this.mTmpAddedFragments;
                ArrayList arrayList10 = backStackRecord4.mOps;
                int size8 = arrayList10.size() - 1;
                while (size8 >= 0) {
                    FragmentTransaction$Op fragmentTransaction$Op3 = (FragmentTransaction$Op) arrayList10.get(size8);
                    int i23 = fragmentTransaction$Op3.mCmd;
                    if (i23 == i22) {
                        arrayList9.remove(fragmentTransaction$Op3.mFragment);
                    } else if (i23 != 3) {
                        switch (i23) {
                            case 6:
                                arrayList9.add(fragmentTransaction$Op3.mFragment);
                                break;
                            case 7:
                                arrayList9.remove(fragmentTransaction$Op3.mFragment);
                                break;
                            case 8:
                                fragment = null;
                                break;
                            case 9:
                                fragment = fragmentTransaction$Op3.mFragment;
                                break;
                            case 10:
                                fragmentTransaction$Op3.mCurrentMaxState = fragmentTransaction$Op3.mOldMaxState;
                                break;
                        }
                    } else {
                        arrayList9.add(fragmentTransaction$Op3.mFragment);
                    }
                    size8--;
                    i22 = 1;
                }
            } else {
                ArrayList arrayList11 = this.mTmpAddedFragments;
                ArrayList arrayList12 = backStackRecord4.mOps;
                int i24 = 0;
                while (i24 < arrayList12.size()) {
                    FragmentTransaction$Op fragmentTransaction$Op4 = (FragmentTransaction$Op) arrayList12.get(i24);
                    int i25 = fragmentTransaction$Op4.mCmd;
                    if (i25 != i8) {
                        z3 = z5;
                        if (i25 != 2) {
                            if (i25 == 3 || i25 == 6) {
                                arrayList11.remove(fragmentTransaction$Op4.mFragment);
                                Fragment fragment8 = fragmentTransaction$Op4.mFragment;
                                if (fragment8 == fragment) {
                                    arrayList12.add(i24, new FragmentTransaction$Op(9, fragment8));
                                    i24++;
                                    i5 = i7;
                                    z4 = z6;
                                    i4 = 1;
                                    fragment = null;
                                }
                            } else if (i25 == 7) {
                                i4 = 1;
                            } else if (i25 == 8) {
                                arrayList12.add(i24, new FragmentTransaction$Op(9, fragment, 0));
                                fragmentTransaction$Op4.mFromExpandedOp = true;
                                i24++;
                                fragment = fragmentTransaction$Op4.mFragment;
                            }
                            i5 = i7;
                            z4 = z6;
                            i4 = 1;
                        } else {
                            Fragment fragment9 = fragmentTransaction$Op4.mFragment;
                            int i26 = fragment9.mContainerId;
                            int size9 = arrayList11.size() - 1;
                            boolean z9 = false;
                            while (size9 >= 0) {
                                int i27 = size9;
                                Fragment fragment10 = (Fragment) arrayList11.get(size9);
                                int i28 = i7;
                                if (fragment10.mContainerId != i26) {
                                    z6 = z6;
                                } else if (fragment10 == fragment9) {
                                    z6 = z6;
                                    z9 = true;
                                } else {
                                    if (fragment10 == fragment) {
                                        i6 = 0;
                                        arrayList12.add(i24, new FragmentTransaction$Op(9, fragment10, 0));
                                        i24++;
                                        fragment = null;
                                    } else {
                                        i6 = 0;
                                    }
                                    FragmentTransaction$Op fragmentTransaction$Op5 = new FragmentTransaction$Op(3, fragment10, i6);
                                    fragmentTransaction$Op5.mEnterAnim = fragmentTransaction$Op4.mEnterAnim;
                                    fragmentTransaction$Op5.mPopEnterAnim = fragmentTransaction$Op4.mPopEnterAnim;
                                    fragmentTransaction$Op5.mExitAnim = fragmentTransaction$Op4.mExitAnim;
                                    fragmentTransaction$Op5.mPopExitAnim = fragmentTransaction$Op4.mPopExitAnim;
                                    arrayList12.add(i24, fragmentTransaction$Op5);
                                    arrayList11.remove(fragment10);
                                    i24++;
                                    fragment = fragment;
                                }
                                size9 = i27 - 1;
                                z6 = z6;
                                i7 = i28;
                            }
                            i5 = i7;
                            z4 = z6;
                            i4 = 1;
                            if (z9) {
                                arrayList12.remove(i24);
                                i24--;
                            } else {
                                fragmentTransaction$Op4.mCmd = 1;
                                fragmentTransaction$Op4.mFromExpandedOp = true;
                                arrayList11.add(fragment9);
                            }
                        }
                        i24 += i4;
                        i8 = i4;
                        z5 = z3;
                        z6 = z4;
                        i7 = i5;
                    } else {
                        z3 = z5;
                        i4 = i8;
                    }
                    i5 = i7;
                    z4 = z6;
                    arrayList11.add(fragmentTransaction$Op4.mFragment);
                    i24 += i4;
                    i8 = i4;
                    z5 = z3;
                    z6 = z4;
                    i7 = i5;
                }
                z = z5;
                i3 = i7;
                z2 = z6;
            }
            z6 = z2 || backStackRecord4.mAddToBackStack;
            i7 = i3 + 1;
            z5 = z;
        }
    }

    public final Fragment findFragmentById(int i) {
        Dispatcher dispatcher = this.mFragmentStore;
        ArrayList arrayList = (ArrayList) dispatcher.executorServiceOrNull;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (FragmentStateManager fragmentStateManager : ((HashMap) dispatcher.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final ViewGroup getFragmentContainer(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId <= 0 || !this.mContainer.onHasView()) {
            return null;
        }
        View viewOnFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
        if (viewOnFindViewById instanceof ViewGroup) {
            return (ViewGroup) viewOnFindViewById;
        }
        return null;
    }

    public final FragmentManager$3 getFragmentFactory() {
        Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getFragmentFactory() : this.mHostFragmentFactory;
    }

    public final ByteString.Companion getSpecialEffectsControllerFactory() {
        Fragment fragment = this.mParent;
        return fragment != null ? fragment.mFragmentManager.getSpecialEffectsControllerFactory() : this.mDefaultSpecialEffectsControllerFactory;
    }

    public final void hideFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        setVisibleRemovingFragment(fragment);
    }

    public final boolean isParentAdded() {
        Fragment fragment = this.mParent;
        if (fragment == null) {
            return true;
        }
        return fragment.mHost != null && fragment.mAdded && fragment.getParentFragmentManager().isParentAdded();
    }

    public final void moveToState(int i, boolean z) {
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks;
        if (this.mHost == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.mCurState) {
            this.mCurState = i;
            Dispatcher dispatcher = this.mFragmentStore;
            HashMap map = (HashMap) dispatcher.readyAsyncCalls;
            ArrayList arrayList = (ArrayList) dispatcher.executorServiceOrNull;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                FragmentStateManager fragmentStateManager = (FragmentStateManager) map.get(((Fragment) obj).mWho);
                if (fragmentStateManager != null) {
                    fragmentStateManager.moveToExpectedState();
                }
            }
            for (FragmentStateManager fragmentStateManager2 : map.values()) {
                if (fragmentStateManager2 != null) {
                    fragmentStateManager2.moveToExpectedState();
                    Fragment fragment = fragmentStateManager2.mFragment;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        dispatcher.makeInactive(fragmentStateManager2);
                    }
                }
            }
            startPendingDeferredFragments();
            if (this.mNeedMenuInvalidate && (fragmentActivity$HostCallbacks = this.mHost) != null && this.mCurState == 7) {
                fragmentActivity$HostCallbacks.this$0.invalidateOptionsMenu();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    public final void noteStateNotSaved() {
        if (this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.mIsStateSaved = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.mChildFragmentManager.noteStateNotSaved();
            }
        }
    }

    public final boolean popBackStackImmediate() {
        return popBackStackImmediate(-1, 0);
    }

    public final boolean popBackStackState(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        boolean z = (i2 & 1) != 0;
        ArrayList arrayList3 = this.mBackStack;
        int size = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (i < 0) {
                size = z ? 0 : this.mBackStack.size() - 1;
            } else {
                int size2 = this.mBackStack.size() - 1;
                while (size2 >= 0) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(size2);
                    if (i >= 0 && i == backStackRecord.mIndex) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    size = size2;
                } else if (z) {
                    size = size2;
                    while (size > 0) {
                        BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStack.get(size - 1);
                        if (i < 0 || i != backStackRecord2.mIndex) {
                            break;
                        }
                        size--;
                    }
                } else if (size2 != this.mBackStack.size() - 1) {
                    size = size2 + 1;
                }
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.mBackStack.size() - 1; size3 >= size; size3--) {
            arrayList.add((BackStackRecord) this.mBackStack.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void removeFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        Dispatcher dispatcher = this.mFragmentStore;
        synchronized (((ArrayList) dispatcher.executorServiceOrNull)) {
            ((ArrayList) dispatcher.executorServiceOrNull).remove(fragment);
        }
        fragment.mAdded = false;
        if (isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mRemoving = true;
        setVisibleRemovingFragment(fragment);
    }

    public final void removeRedundantOperationsAndExecute(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((BackStackRecord) arrayList.get(i)).mReorderingAllowed) {
                if (i2 != i) {
                    executeOpsTogether(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((BackStackRecord) arrayList.get(i2)).mReorderingAllowed) {
                        i2++;
                    }
                }
                executeOpsTogether(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            executeOpsTogether(arrayList, arrayList2, i2, size);
        }
    }

    public final void restoreSaveStateInternal(Parcelable parcelable) {
        RequestService requestService;
        int i;
        boolean z;
        int i2;
        FragmentStateManager fragmentStateManager;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.mHost.mContext.getClassLoader());
                this.mResults.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.mHost.mContext.getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        Dispatcher dispatcher = this.mFragmentStore;
        HashMap map = (HashMap) dispatcher.runningAsyncCalls;
        HashMap map2 = (HashMap) dispatcher.readyAsyncCalls;
        map.clear();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            FragmentState fragmentState = (FragmentState) obj;
            map.put(fragmentState.mWho, fragmentState);
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        map2.clear();
        ArrayList arrayList2 = fragmentManagerState.mActive;
        int size2 = arrayList2.size();
        int i4 = 0;
        while (true) {
            requestService = this.mLifecycleCallbacksDispatcher;
            i = 2;
            if (i4 >= size2) {
                break;
            }
            Object obj2 = arrayList2.get(i4);
            i4++;
            FragmentState fragmentState2 = (FragmentState) ((HashMap) dispatcher.runningAsyncCalls).remove((String) obj2);
            if (fragmentState2 != null) {
                Fragment fragment = (Fragment) this.mNonConfig.mRetainedFragments.get(fragmentState2.mWho);
                if (fragment != null) {
                    if (isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    fragmentStateManager = new FragmentStateManager(requestService, dispatcher, fragment, fragmentState2);
                } else {
                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.mContext.getClassLoader(), getFragmentFactory(), fragmentState2);
                }
                Fragment fragment2 = fragmentStateManager.mFragment;
                fragment2.mFragmentManager = this;
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                }
                fragmentStateManager.restoreState(this.mHost.mContext.getClassLoader());
                dispatcher.makeActive(fragmentStateManager);
                fragmentStateManager.mFragmentManagerState = this.mCurState;
            }
        }
        FragmentManagerViewModel fragmentManagerViewModel = this.mNonConfig;
        fragmentManagerViewModel.getClass();
        ArrayList arrayList3 = new ArrayList(fragmentManagerViewModel.mRetainedFragments.values());
        int size3 = arrayList3.size();
        int i5 = 0;
        while (true) {
            z = true;
            if (i5 >= size3) {
                break;
            }
            Object obj3 = arrayList3.get(i5);
            i5++;
            Fragment fragment3 = (Fragment) obj3;
            if (map2.get(fragment3.mWho) == null) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                }
                this.mNonConfig.removeRetainedFragment(fragment3);
                fragment3.mFragmentManager = this;
                FragmentStateManager fragmentStateManager2 = new FragmentStateManager(requestService, dispatcher, fragment3);
                fragmentStateManager2.mFragmentManagerState = 1;
                fragmentStateManager2.moveToExpectedState();
                fragment3.mRemoving = true;
                fragmentStateManager2.moveToExpectedState();
            }
        }
        ArrayList arrayList4 = fragmentManagerState.mAdded;
        ((ArrayList) dispatcher.executorServiceOrNull).clear();
        if (arrayList4 != null) {
            int size4 = arrayList4.size();
            int i6 = 0;
            while (i6 < size4) {
                Object obj4 = arrayList4.get(i6);
                i6++;
                String str3 = (String) obj4;
                Fragment fragmentFindActiveFragment = dispatcher.findActiveFragment(str3);
                if (fragmentFindActiveFragment == null) {
                    throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("No instantiated fragment for (", str3, ")"));
                }
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + fragmentFindActiveFragment);
                }
                dispatcher.addFragment(fragmentFindActiveFragment);
            }
        }
        if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
            int i7 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.mBackStack;
                if (i7 >= backStackRecordStateArr.length) {
                    break;
                }
                BackStackRecordState backStackRecordState = backStackRecordStateArr[i7];
                ArrayList arrayList5 = backStackRecordState.mFragmentWhos;
                BackStackRecord backStackRecord = new BackStackRecord(this);
                int[] iArr = backStackRecordState.mOps;
                int i8 = 0;
                int i9 = 0;
                while (i8 < iArr.length) {
                    FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op();
                    int i10 = i8 + 1;
                    int i11 = i;
                    fragmentTransaction$Op.mCmd = iArr[i8];
                    if (isLoggingEnabled(i11)) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i9 + " base fragment #" + iArr[i10]);
                    }
                    fragmentTransaction$Op.mOldMaxState = Lifecycle.State.values()[backStackRecordState.mOldMaxLifecycleStates[i9]];
                    fragmentTransaction$Op.mCurrentMaxState = Lifecycle.State.values()[backStackRecordState.mCurrentMaxLifecycleStates[i9]];
                    int i12 = i8 + 2;
                    fragmentTransaction$Op.mFromExpandedOp = iArr[i10] != 0 ? z : false;
                    int i13 = iArr[i12];
                    fragmentTransaction$Op.mEnterAnim = i13;
                    int i14 = iArr[i8 + 3];
                    fragmentTransaction$Op.mExitAnim = i14;
                    int i15 = i8 + 5;
                    int i16 = iArr[i8 + 4];
                    fragmentTransaction$Op.mPopEnterAnim = i16;
                    i8 += 6;
                    int[] iArr2 = iArr;
                    int i17 = iArr2[i15];
                    fragmentTransaction$Op.mPopExitAnim = i17;
                    backStackRecord.mEnterAnim = i13;
                    backStackRecord.mExitAnim = i14;
                    backStackRecord.mPopEnterAnim = i16;
                    backStackRecord.mPopExitAnim = i17;
                    backStackRecord.addOp(fragmentTransaction$Op);
                    i9++;
                    i = i11;
                    iArr = iArr2;
                    z = true;
                }
                int i18 = i;
                backStackRecord.mTransition = backStackRecordState.mTransition;
                backStackRecord.mName = backStackRecordState.mName;
                backStackRecord.mAddToBackStack = true;
                backStackRecord.mBreadCrumbTitleRes = backStackRecordState.mBreadCrumbTitleRes;
                backStackRecord.mBreadCrumbTitleText = backStackRecordState.mBreadCrumbTitleText;
                backStackRecord.mBreadCrumbShortTitleRes = backStackRecordState.mBreadCrumbShortTitleRes;
                backStackRecord.mBreadCrumbShortTitleText = backStackRecordState.mBreadCrumbShortTitleText;
                backStackRecord.mSharedElementSourceNames = backStackRecordState.mSharedElementSourceNames;
                backStackRecord.mSharedElementTargetNames = backStackRecordState.mSharedElementTargetNames;
                backStackRecord.mReorderingAllowed = backStackRecordState.mReorderingAllowed;
                backStackRecord.mIndex = backStackRecordState.mIndex;
                for (int i19 = 0; i19 < arrayList5.size(); i19++) {
                    String str4 = (String) arrayList5.get(i19);
                    if (str4 != null) {
                        ((FragmentTransaction$Op) backStackRecord.mOps.get(i19)).mFragment = dispatcher.findActiveFragment(str4);
                    }
                }
                backStackRecord.bumpBackStackNesting(1);
                if (isLoggingEnabled(i18)) {
                    StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i7, "restoreAllState: back stack #", " (index ");
                    sbM.append(backStackRecord.mIndex);
                    sbM.append("): ");
                    sbM.append(backStackRecord);
                    Log.v("FragmentManager", sbM.toString());
                    PrintWriter printWriter = new PrintWriter(new LogWriter());
                    backStackRecord.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(backStackRecord);
                i7++;
                i = i18;
                z = true;
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
        String str5 = fragmentManagerState.mPrimaryNavActiveWho;
        if (str5 != null) {
            Fragment fragmentFindActiveFragment2 = dispatcher.findActiveFragment(str5);
            this.mPrimaryNav = fragmentFindActiveFragment2;
            dispatchParentPrimaryNavigationFragmentChanged(fragmentFindActiveFragment2);
        }
        ArrayList arrayList6 = fragmentManagerState.mBackStackStateKeys;
        if (arrayList6 != null) {
            while (i2 < arrayList6.size()) {
                this.mBackStackStates.put((String) arrayList6.get(i2), (BackStackState) fragmentManagerState.mBackStackStates.get(i2));
                i2++;
            }
        }
        this.mLaunchedFragments = new ArrayDeque(fragmentManagerState.mLaunchedFragments);
    }

    public final Bundle saveAllStateInternal() {
        int i;
        ArrayList arrayList;
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            DefaultSpecialEffectsController defaultSpecialEffectsController = (DefaultSpecialEffectsController) it.next();
            if (defaultSpecialEffectsController.mIsContainerPostponed) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                defaultSpecialEffectsController.mIsContainerPostponed = false;
                defaultSpecialEffectsController.executePendingOperations();
            }
        }
        Iterator it2 = collectAllSpecialEffectsController().iterator();
        while (it2.hasNext()) {
            ((DefaultSpecialEffectsController) it2.next()).forceCompleteAllOperations();
        }
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.mIsStateSaved = true;
        Dispatcher dispatcher = this.mFragmentStore;
        dispatcher.getClass();
        HashMap map = (HashMap) dispatcher.readyAsyncCalls;
        ArrayList arrayList2 = new ArrayList(map.size());
        Iterator it3 = map.values().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            FragmentStateManager fragmentStateManager = (FragmentStateManager) it3.next();
            if (fragmentStateManager != null) {
                Fragment fragment = fragmentStateManager.mFragment;
                FragmentState fragmentState = new FragmentState(fragment);
                if (fragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                } else {
                    Bundle bundle2 = new Bundle();
                    fragment.onSaveInstanceState(bundle2);
                    fragment.mSavedStateRegistryController.performSave(bundle2);
                    bundle2.putParcelable("android:support:fragments", fragment.mChildFragmentManager.saveAllStateInternal());
                    fragmentStateManager.mDispatcher.dispatchOnFragmentSaveInstanceState(false);
                    Bundle bundle3 = bundle2.isEmpty() ? null : bundle2;
                    if (fragment.mView != null) {
                        fragmentStateManager.saveViewState();
                    }
                    if (fragment.mSavedViewState != null) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
                    }
                    if (fragment.mSavedViewRegistryState != null) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
                    }
                    if (!fragment.mUserVisibleHint) {
                        if (bundle3 == null) {
                            bundle3 = new Bundle();
                        }
                        bundle3.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
                    }
                    fragmentState.mSavedFragmentState = bundle3;
                    if (fragment.mTargetWho != null) {
                        if (bundle3 == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        fragmentState.mSavedFragmentState.putString("android:target_state", fragment.mTargetWho);
                        int i2 = fragment.mTargetRequestCode;
                        if (i2 != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", i2);
                        }
                    }
                }
                arrayList2.add(fragment.mWho);
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragment.mSavedFragmentState);
                }
            }
        }
        Dispatcher dispatcher2 = this.mFragmentStore;
        dispatcher2.getClass();
        ArrayList arrayList3 = new ArrayList(((HashMap) dispatcher2.runningAsyncCalls).values());
        if (!arrayList3.isEmpty()) {
            Dispatcher dispatcher3 = this.mFragmentStore;
            synchronized (((ArrayList) dispatcher3.executorServiceOrNull)) {
                try {
                    if (((ArrayList) dispatcher3.executorServiceOrNull).isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(((ArrayList) dispatcher3.executorServiceOrNull).size());
                        ArrayList arrayList4 = (ArrayList) dispatcher3.executorServiceOrNull;
                        int size2 = arrayList4.size();
                        int i3 = 0;
                        while (i3 < size2) {
                            Object obj = arrayList4.get(i3);
                            i3++;
                            Fragment fragment2 = (Fragment) obj;
                            arrayList.add(fragment2.mWho);
                            if (isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment2.mWho + "): " + fragment2);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ArrayList arrayList5 = this.mBackStack;
            if (arrayList5 == null || (size = arrayList5.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i4 = 0; i4 < size; i4++) {
                    backStackRecordStateArr[i4] = new BackStackRecordState((BackStackRecord) this.mBackStack.get(i4));
                    if (isLoggingEnabled(2)) {
                        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i4, "saveAllState: adding back stack #", ": ");
                        sbM.append(this.mBackStack.get(i4));
                        Log.v("FragmentManager", sbM.toString());
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mPrimaryNavActiveWho = null;
            ArrayList arrayList6 = new ArrayList();
            fragmentManagerState.mBackStackStateKeys = arrayList6;
            ArrayList arrayList7 = new ArrayList();
            fragmentManagerState.mBackStackStates = arrayList7;
            fragmentManagerState.mActive = arrayList2;
            fragmentManagerState.mAdded = arrayList;
            fragmentManagerState.mBackStack = backStackRecordStateArr;
            fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
            Fragment fragment3 = this.mPrimaryNav;
            if (fragment3 != null) {
                fragmentManagerState.mPrimaryNavActiveWho = fragment3.mWho;
            }
            arrayList6.addAll(this.mBackStackStates.keySet());
            arrayList7.addAll(this.mBackStackStates.values());
            fragmentManagerState.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.mResults.keySet()) {
                bundle.putBundle(CaptureSession$State$EnumUnboxingLocalUtility.m("result_", str), (Bundle) this.mResults.get(str));
            }
            int size3 = arrayList3.size();
            while (i < size3) {
                Object obj2 = arrayList3.get(i);
                i++;
                FragmentState fragmentState2 = (FragmentState) obj2;
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable("state", fragmentState2);
                bundle.putBundle("fragment_" + fragmentState2.mWho, bundle4);
            }
        } else if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void scheduleCommit() {
        synchronized (this.mPendingActions) {
            try {
                if (this.mPendingActions.size() == 1) {
                    this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                    this.mHost.mHandler.post(this.mExecCommit);
                    updateOnBackPressedCallbackEnabled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setExitAnimationOrder(Fragment fragment, boolean z) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer == null || !(fragmentContainer instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
    }

    public final void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.mPrimaryNav;
        this.mPrimaryNav = fragment;
        dispatchParentPrimaryNavigationFragmentChanged(fragment2);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public final void setVisibleRemovingFragment(Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null) {
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            if ((animationInfo == null ? 0 : animationInfo.mPopExitAnim) + (animationInfo == null ? 0 : animationInfo.mPopEnterAnim) + (animationInfo == null ? 0 : animationInfo.mExitAnim) + (animationInfo == null ? 0 : animationInfo.mEnterAnim) > 0) {
                if (fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    fragmentContainer.setTag(R.id.visible_removing_fragment_view_tag, fragment);
                }
                Fragment fragment2 = (Fragment) fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag);
                Fragment.AnimationInfo animationInfo2 = fragment.mAnimationInfo;
                boolean z = animationInfo2 != null ? animationInfo2.mIsPop : false;
                if (fragment2.mAnimationInfo == null) {
                    return;
                }
                fragment2.ensureAnimationInfo().mIsPop = z;
            }
        }
    }

    public final void startPendingDeferredFragments() {
        ArrayList activeFragmentStateManagers = this.mFragmentStore.getActiveFragmentStateManagers();
        int size = activeFragmentStateManagers.size();
        int i = 0;
        while (i < size) {
            Object obj = activeFragmentStateManagers.get(i);
            i++;
            FragmentStateManager fragmentStateManager = (FragmentStateManager) obj;
            Fragment fragment = fragmentStateManager.mFragment;
            if (fragment.mDeferStart) {
                if (this.mExecutingActions) {
                    this.mHavePendingDeferredStart = true;
                } else {
                    fragment.mDeferStart = false;
                    fragmentStateManager.moveToExpectedState();
                }
            }
        }
    }

    public final void throwException(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter());
        FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks = this.mHost;
        if (fragmentActivity$HostCallbacks == null) {
            try {
                dump("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw illegalStateException;
            }
        }
        try {
            fragmentActivity$HostCallbacks.this$0.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw illegalStateException;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.mParent;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            sb.append("}");
        } else {
            FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks = this.mHost;
            if (fragmentActivity$HostCallbacks != null) {
                sb.append(fragmentActivity$HostCallbacks.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void updateOnBackPressedCallbackEnabled() {
        synchronized (this.mPendingActions) {
            try {
                if (!this.mPendingActions.isEmpty()) {
                    this.mOnBackPressedCallback.setEnabled(true);
                    return;
                }
                FragmentManager$1 fragmentManager$1 = this.mOnBackPressedCallback;
                ArrayList arrayList = this.mBackStack;
                fragmentManager$1.setEnabled((arrayList != null ? arrayList.size() : 0) > 0 && isPrimaryNavigation(this.mParent));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean popBackStackImmediate(int i, int i2) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && i < 0 && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean zPopBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, i, i2);
        if (zPopBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        ((HashMap) this.mFragmentStore.readyAsyncCalls).values().removeAll(Collections.singleton(null));
        return zPopBackStackState;
    }
}
