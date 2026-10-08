package kotlinx.coroutines;

import kotlin.Result;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InvokeOnCompletion extends JobNode {
    public final /* synthetic */ int $r8$classId;
    public final Object handler;

    public /* synthetic */ InvokeOnCompletion(int i, Object obj) {
        this.$r8$classId = i;
        this.handler = obj;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean getOnCancelling() {
        switch (this.$r8$classId) {
        }
        return false;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        switch (this.$r8$classId) {
            case 0:
                ((Function1) this.handler).invoke(th);
                break;
            case 1:
                ((DisposableHandle) this.handler).dispose();
                break;
            default:
                JobSupport.AwaitContinuation awaitContinuation = (JobSupport.AwaitContinuation) this.handler;
                Object obj = JobSupport._state$volatile$FU.get(getJob());
                if (!(obj instanceof CompletedExceptionally)) {
                    awaitContinuation.resumeWith(JobKt.unboxState(obj));
                } else {
                    awaitContinuation.resumeWith(new Result.Failure(((CompletedExceptionally) obj).cause));
                }
                break;
        }
    }
}
