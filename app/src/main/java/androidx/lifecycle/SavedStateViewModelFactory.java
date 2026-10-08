package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import coil.request.RequestService;
import com.google.android.gms.internal.mlkit_vision_common.zzay;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.ClassReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateViewModelFactory implements ViewModelProvider$Factory {
    public final Application application;
    public final Bundle defaultArgs;
    public final ViewModelProvider$AndroidViewModelFactory factory;
    public final Lifecycle lifecycle;
    public final RequestService savedStateRegistry;

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        ViewModelProvider$AndroidViewModelFactory viewModelProvider$AndroidViewModelFactory;
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        if (application != null) {
            if (ViewModelProvider$AndroidViewModelFactory._instance == null) {
                ViewModelProvider$AndroidViewModelFactory._instance = new ViewModelProvider$AndroidViewModelFactory(application);
            }
            viewModelProvider$AndroidViewModelFactory = ViewModelProvider$AndroidViewModelFactory._instance;
        } else {
            viewModelProvider$AndroidViewModelFactory = new ViewModelProvider$AndroidViewModelFactory(null);
        }
        this.factory = viewModelProvider$AndroidViewModelFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
        return create(classReference.getJClass(), mutableCreationExtras);
    }

    public final ViewModel create$1(Class cls, String str) {
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        Application application = this.application;
        Constructor constructorFindMatchingConstructor = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE) : SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE);
        int i = 2;
        if (constructorFindMatchingConstructor != null) {
            SavedStateHandleController savedStateHandleControllerCreate = ViewModelKt.create(this.savedStateRegistry, lifecycle, str, this.defaultArgs);
            SavedStateHandle savedStateHandle = savedStateHandleControllerCreate.handle;
            ViewModel viewModelNewInstance = (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, savedStateHandle) : SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, application, savedStateHandle);
            viewModelNewInstance.addCloseable("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerCreate);
            return viewModelNewInstance;
        }
        if (application != null) {
            return this.factory.create(cls);
        }
        if (FragmentManagerViewModel.AnonymousClass1._instance == null) {
            FragmentManagerViewModel.AnonymousClass1._instance = new FragmentManagerViewModel.AnonymousClass1(i);
        }
        FragmentManagerViewModel.AnonymousClass1._instance.getClass();
        return zzay.createViewModel(cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        Constructor constructorFindMatchingConstructor;
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        String str = (String) linkedHashMap.get(AtomicReference.VIEW_MODEL_KEY);
        if (str != null) {
            if (linkedHashMap.get(ViewModelKt.SAVED_STATE_REGISTRY_OWNER_KEY) != null && linkedHashMap.get(ViewModelKt.VIEW_MODEL_STORE_OWNER_KEY) != null) {
                Application application = (Application) linkedHashMap.get(ViewModelProvider$AndroidViewModelFactory.APPLICATION_KEY);
                boolean zIsAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
                if (zIsAssignableFrom && application != null) {
                    constructorFindMatchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE);
                } else {
                    constructorFindMatchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE);
                }
                if (constructorFindMatchingConstructor == null) {
                    return this.factory.create(cls, mutableCreationExtras);
                }
                return (!zIsAssignableFrom || application == null) ? SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, ViewModelKt.createSavedStateHandle(mutableCreationExtras)) : SavedStateViewModelFactory_androidKt.newInstance(cls, constructorFindMatchingConstructor, application, ViewModelKt.createSavedStateHandle(mutableCreationExtras));
            }
            if (this.lifecycle != null) {
                return create$1(cls, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create$1(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
