package androidx.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry$LifecycleContainer;
import androidx.activity.result.ActivityResultRegistry$register$2;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.os.BundleCompat;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHostHelper;
import androidx.fragment.app.FragmentManager$2;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.navigationevent.DirectNavigationEventInput;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import androidx.tracing.Trace;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import coil.request.RequestService;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.koala.clash.R;
import io.github.g00fy2.quickie.ScanQRCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComponentActivity extends androidx.core.app.ComponentActivity implements ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, NavigationEventDispatcherOwner, ActivityResultRegistryOwner {
    public ViewModelStore _viewModelStore;
    public final ComponentActivity$activityResultRegistry$1 activityResultRegistry;
    public final ContextAwareHelper contextAwareHelper = new ContextAwareHelper();
    public final SynchronizedLazyImpl defaultViewModelProviderFactory$delegate;
    public boolean dispatchingOnMultiWindowModeChanged;
    public boolean dispatchingOnPictureInPictureModeChanged;
    public final SynchronizedLazyImpl fullyDrawnReporter$delegate;
    public final MenuHostHelper menuHostHelper;
    public final AtomicInteger nextLocalRequestCode;
    public final SynchronizedLazyImpl onBackPressedDispatcher$delegate;
    public final SynchronizedLazyImpl onBackPressedInput$delegate;
    public final CopyOnWriteArrayList onConfigurationChangedListeners;
    public final CopyOnWriteArrayList onMultiWindowModeChangedListeners;
    public final CopyOnWriteArrayList onNewIntentListeners;
    public final CopyOnWriteArrayList onPictureInPictureModeChangedListeners;
    public final CopyOnWriteArrayList onTrimMemoryListeners;
    public final CopyOnWriteArrayList onUserLeaveHintListeners;
    public final ReportFullyDrawnExecutorImpl reportFullyDrawnExecutor;
    public final RequestService savedStateRegistryController;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class NonConfigurationInstances {
        public ViewModelStore viewModelStore;
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ReportFullyDrawnExecutorImpl implements ViewTreeObserver.OnDrawListener, Runnable, Executor {
        public Runnable currentRunnable;
        public final long endWatchTimeMillis = SystemClock.uptimeMillis() + ((long) ModuleDescriptor.MODULE_VERSION);
        public boolean onDrawScheduled;
        public final /* synthetic */ AppCompatActivity this$0;

        public ReportFullyDrawnExecutorImpl(AppCompatActivity appCompatActivity) {
            this.this$0 = appCompatActivity;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.currentRunnable = runnable;
            View decorView = this.this$0.getWindow().getDecorView();
            if (!this.onDrawScheduled) {
                decorView.postOnAnimation(new Preview$$ExternalSyntheticLambda0(1, this));
            } else if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            boolean z;
            Runnable runnable = this.currentRunnable;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.endWatchTimeMillis) {
                    this.onDrawScheduled = false;
                    this.this$0.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.currentRunnable = null;
            FullyDrawnReporter fullyDrawnReporter = (FullyDrawnReporter) this.this$0.fullyDrawnReporter$delegate.getValue();
            synchronized (fullyDrawnReporter.lock) {
                z = fullyDrawnReporter.reportedFullyDrawn;
            }
            if (z) {
                this.onDrawScheduled = false;
                this.this$0.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public static void $r8$lambda$vCwjfXDiSGcirCy4I008VOiJ_lw(AppCompatActivity appCompatActivity) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            if (!Intrinsics.areEqual(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        } catch (NullPointerException e2) {
            if (!Intrinsics.areEqual(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e2;
            }
        }
    }

    public ComponentActivity() {
        final AppCompatActivity appCompatActivity = (AppCompatActivity) this;
        this.menuHostHelper = new MenuHostHelper((Runnable) new ComponentActivity$$ExternalSyntheticLambda1(appCompatActivity, 0));
        RequestService requestService = new RequestService(new SavedStateRegistryImpl(this, new BitmapFactoryDecoder$$ExternalSyntheticLambda2(1, this)), 26);
        this.savedStateRegistryController = requestService;
        this.reportFullyDrawnExecutor = new ReportFullyDrawnExecutorImpl(appCompatActivity);
        this.fullyDrawnReporter$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda2(appCompatActivity, 0));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new ComponentActivity$activityResultRegistry$1(appCompatActivity);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList();
        this.onNewIntentListeners = new CopyOnWriteArrayList();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList();
        this.onBackPressedInput$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda2(appCompatActivity, 2));
        LifecycleRegistry lifecycleRegistry = this.lifecycleRegistry;
        if (lifecycleRegistry == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        final int i = 0;
        lifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Window window;
                View viewPeekDecorView;
                switch (i) {
                    case 0:
                        AppCompatActivity appCompatActivity2 = appCompatActivity;
                        if (event == Lifecycle.Event.ON_STOP && (window = appCompatActivity2.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        AppCompatActivity appCompatActivity3 = appCompatActivity;
                        if (event == Lifecycle.Event.ON_DESTROY) {
                            appCompatActivity3.contextAwareHelper.context = null;
                            if (!appCompatActivity3.isChangingConfigurations()) {
                                appCompatActivity3.getViewModelStore().clear();
                            }
                            ComponentActivity.ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl = appCompatActivity3.reportFullyDrawnExecutor;
                            AppCompatActivity appCompatActivity4 = reportFullyDrawnExecutorImpl.this$0;
                            appCompatActivity4.getWindow().getDecorView().removeCallbacks(reportFullyDrawnExecutorImpl);
                            appCompatActivity4.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(reportFullyDrawnExecutorImpl);
                        }
                        break;
                }
            }
        });
        final int i2 = 1;
        this.lifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Window window;
                View viewPeekDecorView;
                switch (i2) {
                    case 0:
                        AppCompatActivity appCompatActivity2 = appCompatActivity;
                        if (event == Lifecycle.Event.ON_STOP && (window = appCompatActivity2.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        AppCompatActivity appCompatActivity3 = appCompatActivity;
                        if (event == Lifecycle.Event.ON_DESTROY) {
                            appCompatActivity3.contextAwareHelper.context = null;
                            if (!appCompatActivity3.isChangingConfigurations()) {
                                appCompatActivity3.getViewModelStore().clear();
                            }
                            ComponentActivity.ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl = appCompatActivity3.reportFullyDrawnExecutor;
                            AppCompatActivity appCompatActivity4 = reportFullyDrawnExecutorImpl.this$0;
                            appCompatActivity4.getWindow().getDecorView().removeCallbacks(reportFullyDrawnExecutorImpl);
                            appCompatActivity4.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(reportFullyDrawnExecutorImpl);
                        }
                        break;
                }
            }
        });
        this.lifecycleRegistry.addObserver(new Recreator(appCompatActivity, i2));
        requestService.performAttach();
        ViewModelKt.enableSavedStateHandles(this);
        if (Build.VERSION.SDK_INT == 23) {
            this.lifecycleRegistry.addObserver(new ImmLeaksCleaner(appCompatActivity));
        }
        ((RequestService) requestService.hardwareBitmapService).registerSavedStateProvider("android:support:activity-result", new ComponentActivity$$ExternalSyntheticLambda6(appCompatActivity, 0));
        addOnContextAvailableListener(new ComponentActivity$$ExternalSyntheticLambda7(appCompatActivity, 0));
        this.defaultViewModelProviderFactory$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda2(appCompatActivity, 3));
        this.onBackPressedDispatcher$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda2(appCompatActivity, 4));
    }

    public final void addOnConfigurationChangedListener(Consumer consumer) {
        this.onConfigurationChangedListeners.add(consumer);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        ContextAwareHelper contextAwareHelper = this.contextAwareHelper;
        if (contextAwareHelper.context != null) {
            onContextAvailableListener.onContextAvailable();
        }
        contextAwareHelper.listeners.add(onContextAvailableListener);
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ComponentActivity$activityResultRegistry$1 getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final MutableCreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(0);
        if (getApplication() != null) {
            mutableCreationExtras.set(ViewModelProvider$AndroidViewModelFactory.APPLICATION_KEY, getApplication());
        }
        mutableCreationExtras.set(ViewModelKt.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(ViewModelKt.VIEW_MODEL_STORE_OWNER_KEY, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            mutableCreationExtras.set(ViewModelKt.DEFAULT_ARGS_KEY, extras);
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        return (ViewModelProvider$Factory) this.defaultViewModelProviderFactory$delegate.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // androidx.navigationevent.NavigationEventDispatcherOwner
    public final Dispatcher getNavigationEventDispatcher() {
        return getOnBackPressedDispatcher().eventDispatcher;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (OnBackPressedDispatcher) this.onBackPressedDispatcher$delegate.getValue();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final RequestService getSavedStateRegistry() {
        return (RequestService) this.savedStateRegistryController.hardwareBitmapService;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this._viewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this._viewModelStore = nonConfigurationInstances.viewModelStore;
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new ViewModelStore();
            }
        }
        return this._viewModelStore;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.activityResultRegistry.dispatchResult(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        ((DirectNavigationEventInput) this.onBackPressedInput$delegate.getValue()).dispatchOnBackCompleted();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.onConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.performRestore(bundle);
        ContextAwareHelper contextAwareHelper = this.contextAwareHelper;
        contextAwareHelper.context = this;
        Iterator it = contextAwareHelper.listeners.iterator();
        while (it.hasNext()) {
            ((OnContextAvailableListener) it.next()).onContextAvailable();
        }
        super.onCreate(bundle);
        int i = ReportFragment.$r8$clinit;
        ReportFragment.Companion.injectIfNeededIn(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.menuHostHelper.mMenuProviders).iterator();
        while (it.hasNext()) {
            ((FragmentManager$2) it.next()).this$0.dispatchCreateOptionsMenu();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            Iterator it = ((CopyOnWriteArrayList) this.menuHostHelper.mMenuProviders).iterator();
            while (it.hasNext()) {
                if (((FragmentManager$2) it.next()).this$0.dispatchOptionsItemSelected()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator it = this.onMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(new MultiWindowModeChangedInfo(z));
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.onNewIntentListeners.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Iterator it = ((CopyOnWriteArrayList) this.menuHostHelper.mMenuProviders).iterator();
        while (it.hasNext()) {
            ((FragmentManager$2) it.next()).this$0.dispatchOptionsMenuClosed();
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator it = this.onPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(new PictureInPictureModeChangedInfo(z));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.menuHostHelper.mMenuProviders).iterator();
        while (it.hasNext()) {
            ((FragmentManager$2) it.next()).this$0.dispatchPrepareOptionsMenu();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.activityResultRegistry.dispatchResult(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        ViewModelStore viewModelStore = this._viewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.viewModelStore;
        }
        if (viewModelStore == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.viewModelStore = viewModelStore;
        return nonConfigurationInstances2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        LifecycleRegistry lifecycleRegistry = this.lifecycleRegistry;
        if (lifecycleRegistry != null) {
            lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.savedStateRegistryController.performSave(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.onUserLeaveHintListeners.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final ActivityResultRegistry$register$2 registerForActivityResult(final ActivityResultCallback activityResultCallback, final ScanQRCode scanQRCode) {
        final String str = "activity_rq#" + this.nextLocalRequestCode.getAndIncrement();
        final ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1 = this.activityResultRegistry;
        LinkedHashMap linkedHashMap = componentActivity$activityResultRegistry$1.keyToLifecycleContainers;
        LifecycleRegistry lifecycleRegistry = this.lifecycleRegistry;
        if (lifecycleRegistry.state.isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("LifecycleOwner " + this + " is attempting to register while current state is " + lifecycleRegistry.state + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        componentActivity$activityResultRegistry$1.registerKey(str);
        ActivityResultRegistry$LifecycleContainer activityResultRegistry$LifecycleContainer = (ActivityResultRegistry$LifecycleContainer) linkedHashMap.get(str);
        if (activityResultRegistry$LifecycleContainer == null) {
            activityResultRegistry$LifecycleContainer = new ActivityResultRegistry$LifecycleContainer(lifecycleRegistry);
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Lifecycle.Event event2 = Lifecycle.Event.ON_START;
                ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$2 = componentActivity$activityResultRegistry$1;
                String str2 = str;
                if (event2 != event) {
                    if (Lifecycle.Event.ON_STOP == event) {
                        componentActivity$activityResultRegistry$2.keyToCallback.remove(str2);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY == event) {
                            componentActivity$activityResultRegistry$2.unregister$activity(str2);
                            return;
                        }
                        return;
                    }
                }
                LinkedHashMap linkedHashMap2 = componentActivity$activityResultRegistry$2.keyToCallback;
                Bundle bundle = componentActivity$activityResultRegistry$2.pendingResults;
                LinkedHashMap linkedHashMap3 = componentActivity$activityResultRegistry$2.parsedPendingResults;
                ActivityResultCallback activityResultCallback2 = activityResultCallback;
                ScanQRCode scanQRCode2 = scanQRCode;
                linkedHashMap2.put(str2, new ActivityResultRegistry$CallbackAndContract(activityResultCallback2, scanQRCode2));
                if (linkedHashMap3.containsKey(str2)) {
                    Object obj = linkedHashMap3.get(str2);
                    linkedHashMap3.remove(str2);
                    activityResultCallback2.onActivityResult(obj);
                }
                ActivityResult activityResult = (ActivityResult) BundleCompat.getParcelable(str2, bundle);
                if (activityResult != null) {
                    bundle.remove(str2);
                    activityResultCallback2.onActivityResult(scanQRCode2.parseResult(activityResult.resultCode, activityResult.data));
                }
            }
        };
        activityResultRegistry$LifecycleContainer.lifecycle.addObserver(lifecycleEventObserver);
        activityResultRegistry$LifecycleContainer.observers.add(lifecycleEventObserver);
        linkedHashMap.put(str, activityResultRegistry$LifecycleContainer);
        return new ActivityResultRegistry$register$2(componentActivity$activityResultRegistry$1, str, scanQRCode, 0);
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            FullyDrawnReporter fullyDrawnReporter = (FullyDrawnReporter) this.fullyDrawnReporter$delegate.getValue();
            synchronized (fullyDrawnReporter.lock) {
                try {
                    fullyDrawnReporter.reportedFullyDrawn = true;
                    ArrayList arrayList = fullyDrawnReporter.onReportCallbacks;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((Function0) obj).invoke();
                    }
                    fullyDrawnReporter.onReportCallbacks.clear();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            android.os.Trace.endSection();
        } catch (Throwable th2) {
            android.os.Trace.endSection();
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        ViewModelKt.set(getWindow().getDecorView(), (LifecycleOwner) this);
        ViewModelKt.set(getWindow().getDecorView(), (ViewModelStoreOwner) this);
        ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
        getWindow().getDecorView().setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        getWindow().getDecorView().setTag(R.id.report_drawn, this);
        getWindow().getDecorView().setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
        View decorView = getWindow().getDecorView();
        ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl = this.reportFullyDrawnExecutor;
        if (!reportFullyDrawnExecutorImpl.onDrawScheduled) {
            reportFullyDrawnExecutorImpl.onDrawScheduled = true;
            decorView.getViewTreeObserver().addOnDrawListener(reportFullyDrawnExecutorImpl);
        }
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator it = this.onMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).accept(new MultiWindowModeChangedInfo(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator it = this.onPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).accept(new PictureInPictureModeChangedInfo(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }
}
