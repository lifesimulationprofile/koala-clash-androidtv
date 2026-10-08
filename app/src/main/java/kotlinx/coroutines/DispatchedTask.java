package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.scheduling.Task;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DispatchedTask extends Task {
    public int resumeMode;

    public DispatchedTask(int i) {
        super(0L, false);
        this.resumeMode = i;
    }

    public abstract Continuation getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th) {
        JobKt.handleCoroutineException(new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th), getDelegate$kotlinx_coroutines_core().getContext());
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) getDelegate$kotlinx_coroutines_core();
            ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            CoroutineContext context = continuationImpl.getContext();
            Object objUpdateThreadContext = InlineList.updateThreadContext(context, obj);
            Job job = null;
            UndispatchedCoroutine undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != InlineList.NO_THREAD_ELEMENTS ? JobKt.updateUndispatchedCompletion(continuationImpl, context, objUpdateThreadContext) : null;
            try {
                CoroutineContext context2 = continuationImpl.getContext();
                Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                if (exceptionalResult$kotlinx_coroutines_core == null) {
                    int i = this.resumeMode;
                    boolean z = true;
                    if (i != 1 && i != 2) {
                        z = false;
                    }
                    if (z) {
                        job = (Job) context2.get(Job.Key.$$INSTANCE);
                    }
                }
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(cancellationException);
                    continuationImpl.resumeWith(new Result.Failure(cancellationException));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    continuationImpl.resumeWith(new Result.Failure(exceptionalResult$kotlinx_coroutines_core));
                } else {
                    continuationImpl.resumeWith(getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core));
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                    InlineList.restoreThreadContext(context, objUpdateThreadContext);
                }
            }
        } catch (DispatchException e) {
            JobKt.handleCoroutineException(e.cause, getDelegate$kotlinx_coroutines_core().getContext());
        } catch (Throwable th) {
            handleFatalException$kotlinx_coroutines_core(th);
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    public void cancelCompletedResult$kotlinx_coroutines_core(CancellationException cancellationException) {
    }

    public Object getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }
}
