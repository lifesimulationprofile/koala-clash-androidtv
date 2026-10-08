package androidx.compose.ui.window;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.navigationevent.OnBackInvokedDefaultInput;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Api33Impl$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    public final void onBackInvoked() {
        switch (this.$r8$classId) {
            case 0:
                Function0 function0 = (Function0) this.f$0;
                if (function0 != null) {
                    function0.invoke();
                }
                break;
            case 1:
                ((AppCompatDelegateImpl) this.f$0).onBackPressed();
                break;
            case 2:
                ((Runnable) this.f$0).run();
                break;
            default:
                ((OnBackInvokedDefaultInput) this.f$0).dispatchOnBackCompleted();
                break;
        }
    }
}
