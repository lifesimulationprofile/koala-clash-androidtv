package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.GapComposer;
import androidx.lifecycle.AtomicReference;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.ClassReference;
import okhttp3.Dispatcher;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModelKt {
    public static final ViewModel viewModel(ClassReference classReference, ViewModelStoreOwner viewModelStoreOwner, ViewModelProvider$Factory viewModelProvider$Factory, CreationExtras creationExtras, GapComposer gapComposer) {
        AtomicReference atomicReference;
        if (viewModelProvider$Factory != null) {
            atomicReference = new AtomicReference(viewModelStoreOwner.getViewModelStore(), viewModelProvider$Factory, creationExtras);
        } else {
            atomicReference = viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? new AtomicReference(viewModelStoreOwner.getViewModelStore(), ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory(), creationExtras) : ByteString.Companion.create$default(viewModelStoreOwner, null, 6);
        }
        Dispatcher dispatcher = (Dispatcher) atomicReference.base;
        String qualifiedName = classReference.getQualifiedName();
        if (qualifiedName != null) {
            return dispatcher.getViewModel$lifecycle_viewmodel_release("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName), classReference);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
