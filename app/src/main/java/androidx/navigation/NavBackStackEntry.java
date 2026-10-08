package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import coil.request.RequestService;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public final Context context;
    public final SavedStateViewModelFactory defaultViewModelProviderFactory;
    public NavDestination destination;
    public Lifecycle.State hostLifecycleState;
    public final String id;
    public final Bundle immutableArgs;
    public Lifecycle.State maxLifecycle;
    public final Bundle savedState;
    public boolean savedStateRegistryAttached;
    public final NavControllerViewModel viewModelStoreProvider;
    public final LifecycleRegistry _lifecycle = new LifecycleRegistry(this, true);
    public final RequestService savedStateRegistryController = new RequestService(new SavedStateRegistryImpl(this, new BitmapFactoryDecoder$$ExternalSyntheticLambda2(1, this)), 26);

    public NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavControllerViewModel navControllerViewModel, String str, Bundle bundle2) {
        this.context = context;
        this.destination = navDestination;
        this.immutableArgs = bundle;
        this.hostLifecycleState = state;
        this.viewModelStoreProvider = navControllerViewModel;
        this.id = str;
        this.savedState = bundle2;
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(17, this));
        this.maxLifecycle = Lifecycle.State.INITIALIZED;
        this.defaultViewModelProviderFactory = (SavedStateViewModelFactory) synchronizedLazyImpl.getValue();
    }

    public final boolean equals(Object obj) {
        Set<String> setKeySet;
        if (obj != null && (obj instanceof NavBackStackEntry)) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            Bundle bundle = navBackStackEntry.immutableArgs;
            if (Intrinsics.areEqual(this.id, navBackStackEntry.id) && Intrinsics.areEqual(this.destination, navBackStackEntry.destination) && Intrinsics.areEqual(this._lifecycle, navBackStackEntry._lifecycle) && Intrinsics.areEqual((RequestService) this.savedStateRegistryController.hardwareBitmapService, (RequestService) navBackStackEntry.savedStateRegistryController.hardwareBitmapService)) {
                Bundle bundle2 = this.immutableArgs;
                if (Intrinsics.areEqual(bundle2, bundle)) {
                    return true;
                }
                if (bundle2 != null && (setKeySet = bundle2.keySet()) != null) {
                    Set<String> set = setKeySet;
                    if ((set instanceof Collection) && set.isEmpty()) {
                        return true;
                    }
                    for (String str : set) {
                        if (!Intrinsics.areEqual(bundle2.get(str), bundle != null ? bundle.get(str) : null)) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final Bundle getArguments() {
        Bundle bundle = this.immutableArgs;
        if (bundle == null) {
            return null;
        }
        return new Bundle(bundle);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final MutableCreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(0);
        Context context = this.context;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application != null) {
            mutableCreationExtras.set(ViewModelProvider$AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        mutableCreationExtras.set(ViewModelKt.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(ViewModelKt.VIEW_MODEL_STORE_OWNER_KEY, this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mutableCreationExtras.set(ViewModelKt.DEFAULT_ARGS_KEY, arguments);
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public final ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        return this.defaultViewModelProviderFactory;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this._lifecycle;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final RequestService getSavedStateRegistry() {
        return (RequestService) this.savedStateRegistryController.hardwareBitmapService;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        if (!this.savedStateRegistryAttached) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
        }
        if (this._lifecycle.state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.");
        }
        NavControllerViewModel navControllerViewModel = this.viewModelStoreProvider;
        if (navControllerViewModel == null) {
            throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
        }
        LinkedHashMap linkedHashMap = navControllerViewModel.viewModelStores;
        String str = this.id;
        ViewModelStore viewModelStore = (ViewModelStore) linkedHashMap.get(str);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        linkedHashMap.put(str, viewModelStore2);
        return viewModelStore2;
    }

    public final int hashCode() {
        Set<String> setKeySet;
        int iHashCode = this.destination.hashCode() + (this.id.hashCode() * 31);
        Bundle bundle = this.immutableArgs;
        if (bundle != null && (setKeySet = bundle.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                int i = iHashCode * 31;
                Object obj = bundle.get((String) it.next());
                iHashCode = i + (obj != null ? obj.hashCode() : 0);
            }
        }
        return ((RequestService) this.savedStateRegistryController.hardwareBitmapService).hashCode() + ((this._lifecycle.hashCode() + (iHashCode * 31)) * 31);
    }

    public final void setMaxLifecycle(Lifecycle.State state) {
        this.maxLifecycle = state;
        updateState();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NavBackStackEntry");
        sb.append("(" + this.id + ')');
        sb.append(" destination=");
        sb.append(this.destination);
        return sb.toString();
    }

    public final void updateState() {
        if (!this.savedStateRegistryAttached) {
            RequestService requestService = this.savedStateRegistryController;
            requestService.performAttach();
            this.savedStateRegistryAttached = true;
            if (this.viewModelStoreProvider != null) {
                ViewModelKt.enableSavedStateHandles(this);
            }
            requestService.performRestore(this.savedState);
        }
        int iOrdinal = this.hostLifecycleState.ordinal();
        int iOrdinal2 = this.maxLifecycle.ordinal();
        LifecycleRegistry lifecycleRegistry = this._lifecycle;
        if (iOrdinal < iOrdinal2) {
            lifecycleRegistry.setCurrentState(this.hostLifecycleState);
        } else {
            lifecycleRegistry.setCurrentState(this.maxLifecycle);
        }
    }
}
