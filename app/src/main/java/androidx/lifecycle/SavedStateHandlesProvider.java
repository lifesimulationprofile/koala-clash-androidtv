package androidx.lifecycle;

import android.os.Bundle;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda4;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import coil.request.RequestService;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry$SavedStateProvider {
    public boolean restored;
    public Bundle restoredState;
    public final RequestService savedStateRegistry;
    public final SynchronizedLazyImpl viewModel$delegate;

    public SavedStateHandlesProvider(RequestService requestService, ViewModelStoreOwner viewModelStoreOwner) {
        this.savedStateRegistry = requestService;
        this.viewModel$delegate = new SynchronizedLazyImpl(new BasicTextKt$$ExternalSyntheticLambda0(29, viewModelStoreOwner));
    }

    public final void performRestore() {
        if (this.restored) {
            return;
        }
        Bundle bundleConsumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            bundleBundleOf.putAll(bundle);
        }
        if (bundleConsumeRestoredStateForKey != null) {
            bundleBundleOf.putAll(bundleConsumeRestoredStateForKey);
        }
        this.restoredState = bundleBundleOf;
        this.restored = true;
    }

    @Override // androidx.savedstate.SavedStateRegistry$SavedStateProvider
    public final Bundle saveState() {
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            bundleBundleOf.putAll(bundle);
        }
        for (Map.Entry entry : ((SavedStateHandlesVM) this.viewModel$delegate.getValue()).handles.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleSaveState = ((FragmentManager$$ExternalSyntheticLambda4) ((SavedStateHandle) entry.getValue()).impl.lazyCacheControl).saveState();
            if (!bundleSaveState.isEmpty()) {
                bundleBundleOf.putBundle(str, bundleSaveState);
            }
        }
        this.restored = false;
        return bundleBundleOf;
    }
}
