package androidx.fragment.app;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import coil.request.RequestService;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentActivity$HostCallbacks extends FragmentContainer implements ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener {
    public final AppCompatActivity mActivity;
    public final AppCompatActivity mContext;
    public final FragmentManagerImpl mFragmentManager;
    public final Handler mHandler;
    public final /* synthetic */ AppCompatActivity this$0;

    public FragmentActivity$HostCallbacks(AppCompatActivity appCompatActivity) {
        this.this$0 = appCompatActivity;
        Handler handler = new Handler();
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = appCompatActivity;
        this.mContext = appCompatActivity;
        this.mHandler = handler;
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ComponentActivity$activityResultRegistry$1 getActivityResultRegistry() {
        return this.this$0.activityResultRegistry;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.this$0.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.this$0.getOnBackPressedDispatcher();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final RequestService getSavedStateRegistry() {
        return (RequestService) this.this$0.savedStateRegistryController.hardwareBitmapService;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.this$0.getViewModelStore();
    }

    @Override // androidx.fragment.app.FragmentContainer
    public final View onFindViewById(int i) {
        return this.this$0.findViewById(i);
    }

    @Override // androidx.fragment.app.FragmentContainer
    public final boolean onHasView() {
        Window window = this.this$0.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentOnAttachListener
    public final void onAttachFragment$1() {
    }
}
