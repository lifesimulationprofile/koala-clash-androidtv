package androidx.savedstate;

import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import coil.request.RequestService;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final SavedStateRegistryOwner owner;

    public /* synthetic */ Recreator(SavedStateRegistryOwner savedStateRegistryOwner, int i) {
        this.$r8$classId = i;
        this.owner = savedStateRegistryOwner;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        View view;
        switch (this.$r8$classId) {
            case 0:
                if (event != Lifecycle.Event.ON_CREATE) {
                    throw new AssertionError("Next event must be ON_CREATE");
                }
                lifecycleOwner.getLifecycle().removeObserver(this);
                SavedStateRegistryOwner savedStateRegistryOwner = this.owner;
                Bundle bundleConsumeRestoredStateForKey = savedStateRegistryOwner.getSavedStateRegistry().consumeRestoredStateForKey("androidx.savedstate.Restarter");
                if (bundleConsumeRestoredStateForKey == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundleConsumeRestoredStateForKey.getStringArrayList("classes_to_restore");
                if (stringArrayList == null) {
                    throw new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                }
                int size = stringArrayList.size();
                int i = 0;
                while (i < size) {
                    String str = stringArrayList.get(i);
                    i++;
                    String str2 = str;
                    try {
                        Class<? extends U> clsAsSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry$AutoRecreated.class);
                        try {
                            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                if (!(savedStateRegistryOwner instanceof ViewModelStoreOwner)) {
                                    throw new IllegalStateException(("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: " + savedStateRegistryOwner).toString());
                                }
                                ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                                RequestService savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                                viewModelStore.getClass();
                                LinkedHashMap linkedHashMap = viewModelStore.map;
                                Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                                while (it.hasNext()) {
                                    ViewModel viewModel = (ViewModel) linkedHashMap.get((String) it.next());
                                    if (viewModel != null) {
                                        ViewModelKt.attachHandleIfNeeded(viewModel, savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                                    }
                                }
                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                    savedStateRegistry.runOnNextRecreation();
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(CaptureSession$State$EnumUnboxingLocalUtility.m("Failed to instantiate ", str2), e);
                            }
                        } catch (NoSuchMethodException e2) {
                            throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                        }
                    } catch (ClassNotFoundException e3) {
                        throw new RuntimeException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Class ", str2, " wasn't found"), e3);
                    }
                }
                return;
            case 1:
                AppCompatActivity appCompatActivity = (AppCompatActivity) this.owner;
                if (appCompatActivity._viewModelStore == null) {
                    ComponentActivity.NonConfigurationInstances nonConfigurationInstances = (ComponentActivity.NonConfigurationInstances) appCompatActivity.getLastNonConfigurationInstance();
                    if (nonConfigurationInstances != null) {
                        appCompatActivity._viewModelStore = nonConfigurationInstances.viewModelStore;
                    }
                    if (appCompatActivity._viewModelStore == null) {
                        appCompatActivity._viewModelStore = new ViewModelStore();
                    }
                }
                appCompatActivity.lifecycleRegistry.removeObserver(this);
                return;
            default:
                if (event != Lifecycle.Event.ON_STOP || (view = ((Fragment) this.owner).mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
                return;
        }
    }
}
