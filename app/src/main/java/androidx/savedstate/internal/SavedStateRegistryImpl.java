package androidx.savedstate.internal;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistryOwner;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import java.util.LinkedHashMap;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryImpl {
    public boolean attached;
    public boolean isRestored;
    public final BitmapFactoryDecoder$$ExternalSyntheticLambda2 onAttach;
    public final SavedStateRegistryOwner owner;
    public Bundle restoredState;
    public final AsyncTimeout.Companion lock = new AsyncTimeout.Companion(13);
    public final LinkedHashMap keyToProviders = new LinkedHashMap();
    public boolean isAllowingSavingState = true;

    public SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, BitmapFactoryDecoder$$ExternalSyntheticLambda2 bitmapFactoryDecoder$$ExternalSyntheticLambda2) {
        this.owner = savedStateRegistryOwner;
        this.onAttach = bitmapFactoryDecoder$$ExternalSyntheticLambda2;
    }

    public final void performAttach() {
        SavedStateRegistryOwner savedStateRegistryOwner = this.owner;
        if (savedStateRegistryOwner.getLifecycle().getCurrentState() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        if (this.attached) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        this.onAttach.invoke();
        savedStateRegistryOwner.getLifecycle().addObserver(new NavController$$ExternalSyntheticLambda0(1, this));
        this.attached = true;
    }
}
