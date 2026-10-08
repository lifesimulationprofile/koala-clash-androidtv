package androidx.lifecycle;

import android.os.Bundle;
import android.view.View;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.core.os.BundleKt;
import androidx.core.viewtree.ViewTree;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import coil.network.EmptyNetworkObserver;
import coil.request.RequestService;
import com.google.android.gms.dynamite.zze;
import com.koala.clash.R;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModelKt {
    public static final Path.Companion SAVED_STATE_REGISTRY_OWNER_KEY = new Path.Companion();
    public static final EmptyNetworkObserver VIEW_MODEL_STORE_OWNER_KEY = new EmptyNetworkObserver();
    public static final zze DEFAULT_ARGS_KEY = new zze(11);
    public static final SynchronizedObject VIEW_MODEL_SCOPE_LOCK = new SynchronizedObject();

    public static final void attachHandleIfNeeded(ViewModel viewModel, RequestService requestService, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getCloseable("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.isAttached) {
            return;
        }
        savedStateHandleController.attachToLifecycle(requestService, lifecycle);
        tryToAddRecreator(requestService, lifecycle);
    }

    public static final SavedStateHandleController create(RequestService requestService, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandle savedStateHandle;
        Bundle bundleConsumeRestoredStateForKey = requestService.consumeRestoredStateForKey(str);
        if (bundleConsumeRestoredStateForKey != null) {
            bundle = bundleConsumeRestoredStateForKey;
        }
        if (bundle == null) {
            savedStateHandle = new SavedStateHandle();
        } else {
            bundle.setClassLoader(SavedStateHandle.class.getClassLoader());
            MapBuilder mapBuilder = new MapBuilder(bundle.size());
            for (String str2 : bundle.keySet()) {
                mapBuilder.put(str2, bundle.get(str2));
            }
            savedStateHandle = new SavedStateHandle(MapsKt__MapsKt.build(mapBuilder));
        }
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, savedStateHandle);
        savedStateHandleController.attachToLifecycle(requestService, lifecycle);
        tryToAddRecreator(requestService, lifecycle);
        return savedStateHandleController;
    }

    public static final SavedStateHandle createSavedStateHandle(MutableCreationExtras mutableCreationExtras) {
        SavedStateHandle savedStateHandle;
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) linkedHashMap.get(SAVED_STATE_REGISTRY_OWNER_KEY);
        if (savedStateRegistryOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) linkedHashMap.get(VIEW_MODEL_STORE_OWNER_KEY);
        if (viewModelStoreOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(DEFAULT_ARGS_KEY);
        String str = (String) linkedHashMap.get(AtomicReference.VIEW_MODEL_KEY);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        SavedStateRegistry$SavedStateProvider savedStateProvider = savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle2 = null;
        SavedStateHandlesProvider savedStateHandlesProvider = savedStateProvider instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) savedStateProvider : null;
        if (savedStateHandlesProvider == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = ((SavedStateHandlesVM) ((Dispatcher) ByteString.Companion.create$default(viewModelStoreOwner, new FragmentManagerViewModel.AnonymousClass1(1), 4).base).getViewModel$lifecycle_viewmodel_release("androidx.lifecycle.internal.SavedStateHandlesVM", Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class))).handles;
        SavedStateHandle savedStateHandle2 = (SavedStateHandle) linkedHashMap2.get(str);
        if (savedStateHandle2 != null) {
            return savedStateHandle2;
        }
        savedStateHandlesProvider.performRestore();
        Bundle bundle3 = savedStateHandlesProvider.restoredState;
        if (bundle3 != null && bundle3.containsKey(str)) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                bundle4 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                savedStateHandlesProvider.restoredState = null;
            }
            bundle2 = bundle4;
        }
        if (bundle2 != null) {
            bundle = bundle2;
        }
        if (bundle == null) {
            savedStateHandle = new SavedStateHandle();
        } else {
            bundle.setClassLoader(SavedStateHandle.class.getClassLoader());
            MapBuilder mapBuilder = new MapBuilder(bundle.size());
            for (String str2 : bundle.keySet()) {
                mapBuilder.put(str2, bundle.get(str2));
            }
            savedStateHandle = new SavedStateHandle(MapsKt__MapsKt.build(mapBuilder));
        }
        linkedHashMap2.put(str, savedStateHandle);
        return savedStateHandle;
    }

    public static final void enableSavedStateHandles(SavedStateRegistryOwner savedStateRegistryOwner) {
        Lifecycle.State currentState = savedStateRegistryOwner.getLifecycle().getCurrentState();
        if (currentState != Lifecycle.State.INITIALIZED && currentState != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(savedStateRegistryOwner.getSavedStateRegistry(), (ViewModelStoreOwner) savedStateRegistryOwner);
            savedStateRegistryOwner.getSavedStateRegistry().registerSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            savedStateRegistryOwner.getLifecycle().addObserver(new SavedStateHandleAttacher(0, savedStateHandlesProvider));
        }
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public static final ViewModelStoreOwner m774get(View view) {
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
            ViewModelStoreOwner viewModelStoreOwner = tag instanceof ViewModelStoreOwner ? (ViewModelStoreOwner) tag : null;
            if (viewModelStoreOwner != null) {
                return viewModelStoreOwner;
            }
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return null;
    }

    public static final LifecycleCoroutineScopeImpl getLifecycleScope(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        AtomicReference atomicReference = (AtomicReference) lifecycle.internalScopeRef;
        while (true) {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) ((java.util.concurrent.atomic.AtomicReference) atomicReference.base).get();
            if (lifecycleCoroutineScopeImpl != null) {
                return lifecycleCoroutineScopeImpl;
            }
            SupervisorJobImpl supervisorJobImplSupervisorJob$default = JobKt.SupervisorJob$default();
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = new LifecycleCoroutineScopeImpl(lifecycle, CameraIdUtil.plus(supervisorJobImplSupervisorJob$default, ((HandlerContext) MainDispatcherLoader.dispatcher).immediate));
            java.util.concurrent.atomic.AtomicReference atomicReference2 = (java.util.concurrent.atomic.AtomicReference) atomicReference.base;
            do {
                Continuation continuation = null;
                if (atomicReference2.compareAndSet(null, lifecycleCoroutineScopeImpl2)) {
                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                    JobKt.launch$default(lifecycleCoroutineScopeImpl2, ((HandlerContext) MainDispatcherLoader.dispatcher).immediate, new InterruptibleKt$runInterruptible$2(lifecycleCoroutineScopeImpl2, continuation, 2), 2);
                    return lifecycleCoroutineScopeImpl2;
                }
            } while (atomicReference2.get() == null);
        }
    }

    public static final CloseableCoroutineScope getViewModelScope(ViewModel viewModel) {
        CloseableCoroutineScope closeableCoroutineScope;
        synchronized (VIEW_MODEL_SCOPE_LOCK) {
            closeableCoroutineScope = (CloseableCoroutineScope) viewModel.getCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
            if (closeableCoroutineScope == null) {
                CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
                try {
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    coroutineContext = ((HandlerContext) MainDispatcherLoader.dispatcher).immediate;
                } catch (IllegalStateException | NotImplementedError unused) {
                }
                CloseableCoroutineScope closeableCoroutineScope2 = new CloseableCoroutineScope(coroutineContext.plus(JobKt.SupervisorJob$default()));
                viewModel.addCloseable("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", closeableCoroutineScope2);
                closeableCoroutineScope = closeableCoroutineScope2;
            }
        }
        return closeableCoroutineScope;
    }

    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, SuspendLambda suspendLambda) {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        }
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return Unit.INSTANCE;
        }
        Object objCoroutineScope = JobKt.coroutineScope(new NavHostKt$NavHost$29$1(lifecycle, state, function2, (Continuation) null), suspendLambda);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    public static final void set(View view, ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }

    public static void tryToAddRecreator(RequestService requestService, Lifecycle lifecycle) {
        Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState == Lifecycle.State.INITIALIZED || currentState.isAtLeast(Lifecycle.State.STARTED)) {
            requestService.runOnNextRecreation();
        } else {
            lifecycle.addObserver(new DefaultLifecycleObserverAdapter(1, lifecycle, requestService));
        }
    }

    public static final void set(View view, LifecycleOwner lifecycleOwner) {
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }

    public static final LifecycleOwner get(View view) {
        while (view != null) {
            Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
            LifecycleOwner lifecycleOwner = tag instanceof LifecycleOwner ? (LifecycleOwner) tag : null;
            if (lifecycleOwner != null) {
                return lifecycleOwner;
            }
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return null;
    }
}
