package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface CompletableDeferred<T> extends Job {
    @Override // kotlinx.coroutines.Job
    /* synthetic */ ChildHandle attachChild(ChildJob childJob);

    /* synthetic */ Object await(Continuation continuation);

    @Deprecated
    /* synthetic */ void cancel();

    @Override // kotlinx.coroutines.Job
    /* synthetic */ void cancel(CancellationException cancellationException);

    @Deprecated
    /* synthetic */ boolean cancel(Throwable th);

    boolean complete(T t);

    boolean completeExceptionally(Throwable th);

    @Override // kotlin.coroutines.CoroutineContext
    /* synthetic */ Object fold(Object obj, Function2 function2);

    @Override // kotlin.coroutines.CoroutineContext
    /* synthetic */ CoroutineContext.Element get(CoroutineContext.Key key);

    @Override // kotlinx.coroutines.Job
    /* synthetic */ CancellationException getCancellationException();

    /* synthetic */ Sequence getChildren();

    /* synthetic */ Object getCompleted();

    /* synthetic */ Throwable getCompletionExceptionOrNull();

    @Override // kotlin.coroutines.CoroutineContext.Element
    /* synthetic */ CoroutineContext.Key getKey();

    /* synthetic */ SelectClause1 getOnAwait();

    /* synthetic */ SelectClause0 getOnJoin();

    /* synthetic */ Job getParent();

    @Override // kotlinx.coroutines.Job
    /* synthetic */ DisposableHandle invokeOnCompletion(Function1 function1);

    @Override // kotlinx.coroutines.Job
    /* synthetic */ DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1 function1);

    @Override // kotlinx.coroutines.Job
    /* synthetic */ boolean isActive();

    /* synthetic */ boolean isCancelled();

    /* synthetic */ boolean isCompleted();

    @Override // kotlinx.coroutines.Job
    /* synthetic */ Object join(Continuation continuation);

    @Override // kotlin.coroutines.CoroutineContext
    /* synthetic */ CoroutineContext minusKey(CoroutineContext.Key key);

    @Override // kotlin.coroutines.CoroutineContext
    /* synthetic */ CoroutineContext plus(CoroutineContext coroutineContext);

    @Deprecated
    /* synthetic */ Job plus(Job job);

    @Override // kotlinx.coroutines.Job
    /* synthetic */ boolean start();
}
