package kotlinx.coroutines;

import java.util.concurrent.ScheduledFuture;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DisposeOnCancel implements CancelHandler {
    public final /* synthetic */ int $r8$classId;
    public final Object handle;

    public /* synthetic */ DisposeOnCancel(int i, Object obj) {
        this.$r8$classId = i;
        this.handle = obj;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public final void invoke(Throwable th) {
        switch (this.$r8$classId) {
            case 0:
                ((DisposableHandle) this.handle).dispose();
                break;
            case 1:
                ((ScheduledFuture) this.handle).cancel(false);
                break;
            default:
                ((Function1) this.handle).invoke(th);
                break;
        }
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "DisposeOnCancel[" + ((DisposableHandle) this.handle) + ']';
            case 1:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.handle) + ']';
            default:
                return "CancelHandler.UserSupplied[" + ((Function1) this.handle).getClass().getSimpleName() + '@' + JobKt.getHexAddress(this) + ']';
        }
    }
}
