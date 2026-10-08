package androidx.lifecycle;

import android.app.Application;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import com.google.android.gms.internal.mlkit_vision_common.zzay;
import java.lang.reflect.InvocationTargetException;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelProvider$AndroidViewModelFactory extends FragmentManagerViewModel.AnonymousClass1 {
    public static final AsyncTimeout.Companion APPLICATION_KEY = new AsyncTimeout.Companion(11);
    public static ViewModelProvider$AndroidViewModelFactory _instance;
    public final Application application;

    public ViewModelProvider$AndroidViewModelFactory(Application application) {
        super(2);
        this.application = application;
    }

    @Override // androidx.fragment.app.FragmentManagerViewModel.AnonymousClass1, androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        if (this.application != null) {
            return create(cls);
        }
        Application application = (Application) mutableCreationExtras.extras.get(APPLICATION_KEY);
        if (application != null) {
            return create(cls, application);
        }
        if (AndroidViewModel.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return zzay.createViewModel(cls);
    }

    @Override // androidx.fragment.app.FragmentManagerViewModel.AnonymousClass1, androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls) {
        Application application = this.application;
        if (application != null) {
            return create(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    public static ViewModel create(Class cls, Application application) {
        if (AndroidViewModel.class.isAssignableFrom(cls)) {
            try {
                return (ViewModel) cls.getConstructor(Application.class).newInstance(application);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
        return zzay.createViewModel(cls);
    }
}
