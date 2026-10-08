package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.SavedStateHandlesVM;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManagerImpl$LoaderViewModel;
import androidx.navigation.NavControllerViewModel;
import com.google.android.gms.internal.mlkit_vision_common.zzay;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.ClassReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentManagerViewModel extends ViewModel {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1(0);
    public final boolean mStateAutomaticallySaved;
    public final HashMap mRetainedFragments = new HashMap();
    public final HashMap mChildNonConfigs = new HashMap();
    public final HashMap mViewModelStores = new HashMap();
    public boolean mHasBeenCleared = false;
    public boolean mIsStateSaved = false;

    public FragmentManagerViewModel(boolean z) {
        this.mStateAutomaticallySaved = z;
    }

    public final void clearNonConfigState(Fragment fragment) {
        if (FragmentManagerImpl.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        clearNonConfigStateInternal(fragment.mWho);
    }

    public final void clearNonConfigStateInternal(String str) {
        HashMap map = this.mChildNonConfigs;
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) map.get(str);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.onCleared();
            map.remove(str);
        }
        HashMap map2 = this.mViewModelStores;
        ViewModelStore viewModelStore = (ViewModelStore) map2.get(str);
        if (viewModelStore != null) {
            viewModelStore.clear();
            map2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && FragmentManagerViewModel.class == obj.getClass()) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
            if (this.mRetainedFragments.equals(fragmentManagerViewModel.mRetainedFragments) && this.mChildNonConfigs.equals(fragmentManagerViewModel.mChildNonConfigs) && this.mViewModelStores.equals(fragmentManagerViewModel.mViewModelStores)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.mViewModelStores.hashCode() + ((this.mChildNonConfigs.hashCode() + (this.mRetainedFragments.hashCode() * 31)) * 31);
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        if (FragmentManagerImpl.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.mHasBeenCleared = true;
    }

    public final void removeRetainedFragment(Fragment fragment) {
        if (this.mIsStateSaved) {
            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.mRetainedFragments.remove(fragment.mWho) == null || !FragmentManagerImpl.isLoggingEnabled(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.mRetainedFragments.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.mChildNonConfigs.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.mViewModelStores.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManagerViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class AnonymousClass1 implements ViewModelProvider$Factory {
        public static AnonymousClass1 _instance;
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public final ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
            switch (this.$r8$classId) {
                case 0:
                    return create(classReference.getJClass(), mutableCreationExtras);
                case 1:
                    return new SavedStateHandlesVM();
                case 2:
                    return create(classReference.getJClass(), mutableCreationExtras);
                case 3:
                    return create(classReference.getJClass(), mutableCreationExtras);
                default:
                    return create(classReference.getJClass(), mutableCreationExtras);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public ViewModel create(Class cls) {
            switch (this.$r8$classId) {
                case 0:
                    return new FragmentManagerViewModel(true);
                case 1:
                    throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
                case 2:
                    return zzay.createViewModel(cls);
                case 3:
                    return new LoaderManagerImpl$LoaderViewModel();
                default:
                    return new NavControllerViewModel();
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
            switch (this.$r8$classId) {
                case 0:
                    return create(cls);
                case 1:
                    create(cls);
                    throw null;
                case 2:
                    return create(cls);
                case 3:
                    return new LoaderManagerImpl$LoaderViewModel();
                default:
                    return new NavControllerViewModel();
            }
        }
    }
}
