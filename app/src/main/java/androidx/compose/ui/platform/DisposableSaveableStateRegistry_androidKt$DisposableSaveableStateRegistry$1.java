package androidx.compose.ui.platform;

import androidx.savedstate.internal.SavedStateRegistryImpl;
import coil.request.RequestService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1 extends Lambda implements Function0 {
    public final /* synthetic */ RequestService $androidxRegistry;
    public final /* synthetic */ String $key;
    public final /* synthetic */ boolean $registered;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1(boolean z, RequestService requestService, String str) {
        super(0);
        this.$registered = z;
        this.$androidxRegistry = requestService;
        this.$key = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (this.$registered) {
            RequestService requestService = this.$androidxRegistry;
            String str = this.$key;
            SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) requestService.systemCallbacks;
            synchronized (savedStateRegistryImpl.lock) {
            }
        }
        return Unit.INSTANCE;
    }
}
