package kotlinx.coroutines;

import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.compose.foundation.lazy.LazyListKt;
import coil.network.HttpException;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import io.github.g00fy2.quickie.ScanQRCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.io.FilesKt__UtilsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: loaded from: classes.dex */
public abstract class JobKt {
    public static final Symbol CLOSED_EMPTY;
    public static final Symbol COMPLETING_ALREADY;
    public static final Symbol COMPLETING_RETRY;
    public static final Symbol COMPLETING_WAITING_CHILDREN;
    public static final Symbol DISPOSED_TASK;
    public static final Symbol RESUME_TOKEN;
    public static final Symbol SEALED;
    public static final Symbol TOO_LATE_TO_CANCEL;
    public static final Empty EMPTY_NEW = new Empty(false);
    public static final Empty EMPTY_ACTIVE = new Empty(true);

    static {
        int i = 0;
        RESUME_TOKEN = new Symbol("RESUME_TOKEN", i);
        DISPOSED_TASK = new Symbol("REMOVED_TASK", i);
        CLOSED_EMPTY = new Symbol("CLOSED_EMPTY", i);
        COMPLETING_ALREADY = new Symbol("COMPLETING_ALREADY", i);
        COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN", i);
        COMPLETING_RETRY = new Symbol("COMPLETING_RETRY", i);
        TOO_LATE_TO_CANCEL = new Symbol("TOO_LATE_TO_CANCEL", i);
        SEALED = new Symbol("SEALED", i);
    }

    public static CompletableDeferredImpl CompletableDeferred$default() {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(true);
        completableDeferredImpl.initParentJob(null);
        return completableDeferredImpl;
    }

    public static final ContextScope CoroutineScope(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key.$$INSTANCE) == null) {
            coroutineContext = coroutineContext.plus(new JobImpl(null));
        }
        return new ContextScope(coroutineContext);
    }

    public static final ContextScope MainScope() {
        SupervisorJobImpl supervisorJobImplSupervisorJob$default = SupervisorJob$default();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return new ContextScope(CameraIdUtil.plus(supervisorJobImplSupervisorJob$default, MainDispatcherLoader.dispatcher));
    }

    public static SupervisorJobImpl SupervisorJob$default() {
        return new SupervisorJobImpl(null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void awaitCancellation(ContinuationImpl continuationImpl) {
        DelayKt$awaitCancellation$1 delayKt$awaitCancellation$1;
        if (continuationImpl instanceof DelayKt$awaitCancellation$1) {
            delayKt$awaitCancellation$1 = (DelayKt$awaitCancellation$1) continuationImpl;
            int i = delayKt$awaitCancellation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                delayKt$awaitCancellation$1.label = i - Integer.MIN_VALUE;
            } else {
                delayKt$awaitCancellation$1 = new DelayKt$awaitCancellation$1(continuationImpl);
            }
        } else {
            delayKt$awaitCancellation$1 = new DelayKt$awaitCancellation$1(continuationImpl);
        }
        Object obj = delayKt$awaitCancellation$1.result;
        int i2 = delayKt$awaitCancellation$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            delayKt$awaitCancellation$1.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(delayKt$awaitCancellation$1));
            cancellableContinuationImpl.initCancellability();
            if (cancellableContinuationImpl.getResult() == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new HttpException();
    }

    public static final void cancel(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key.$$INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
        }
    }

    public static final Object coroutineScope(Function2 function2, Continuation continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation, continuation.getContext());
        return LazyListKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
    }

    public static final Object delay(long j, Continuation continuation) {
        if (j <= 0) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (j < Long.MAX_VALUE) {
            getDelay(cancellableContinuationImpl.context).scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.COROUTINE_SUSPENDED ? result : Unit.INSTANCE;
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null && !job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final CoroutineContext foldCopies(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) coroutineContext.fold(bool, new FilesKt__UtilsKt$$ExternalSyntheticLambda0(5))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) coroutineContext2.fold(bool, new FilesKt__UtilsKt$$ExternalSyntheticLambda0(5))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return coroutineContext.plus(coroutineContext2);
        }
        FilesKt__UtilsKt$$ExternalSyntheticLambda0 filesKt__UtilsKt$$ExternalSyntheticLambda0 = new FilesKt__UtilsKt$$ExternalSyntheticLambda0(6);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, filesKt__UtilsKt$$ExternalSyntheticLambda0);
        Object objFold = coroutineContext2;
        if (zBooleanValue2) {
            objFold = coroutineContext2.fold(emptyCoroutineContext, new FilesKt__UtilsKt$$ExternalSyntheticLambda0(7));
        }
        return coroutineContext3.plus((CoroutineContext) objFold);
    }

    public static final Delay getDelay(CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor$Key.$$INSTANCE);
        Delay delay = element instanceof Delay ? (Delay) element : null;
        return delay == null ? DefaultExecutorKt.DefaultDelay : delay;
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final CancellableContinuationImpl getOrCreateCancellableContinuation(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl(1, continuation);
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Symbol symbol = InlineList.REUSABLE_CLAIMED;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
            cancellableContinuationImpl = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(dispatchedContinuation, symbol);
                cancellableContinuationImpl2 = null;
                break;
            }
            if (obj instanceof CancellableContinuationImpl) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, symbol)) {
                        cancellableContinuationImpl2 = (CancellableContinuationImpl) obj;
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == obj);
            } else if (obj != symbol && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (cancellableContinuationImpl2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableContinuationImpl._state$volatile$FU;
            Object obj2 = atomicReferenceFieldUpdater2.get(cancellableContinuationImpl2);
            if (!(obj2 instanceof CompletedContinuation) || ((CompletedContinuation) obj2).idempotentResume == null) {
                CancellableContinuationImpl._decisionAndIndex$volatile$FU.set(cancellableContinuationImpl2, 536870911);
                atomicReferenceFieldUpdater2.set(cancellableContinuationImpl2, Active.INSTANCE);
                cancellableContinuationImpl = cancellableContinuationImpl2;
            } else {
                cancellableContinuationImpl2.detachChild$kotlinx_coroutines_core();
            }
            if (cancellableContinuationImpl != null) {
                return cancellableContinuationImpl;
            }
        }
        return new CancellableContinuationImpl(2, continuation);
    }

    public static final void handleCoroutineException(Throwable th, CoroutineContext coroutineContext) {
        if (th instanceof DispatchException) {
            th = ((DispatchException) th).cause;
        }
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(Job.Key.$$INSTANCE$1);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(th, coroutineContext);
            } else {
                InlineList.handleUncaughtCoroutineException(th, coroutineContext);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                ScanQRCode.addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            InlineList.handleUncaughtCoroutineException(th, coroutineContext);
        }
    }

    public static final DisposableHandle invokeOnCompletion(Job job, boolean z, JobNode jobNode) {
        if (job instanceof JobSupport) {
            return ((JobSupport) job).invokeOnCompletionInternal$kotlinx_coroutines_core(z, jobNode);
        }
        return job.invokeOnCompletion(jobNode.getOnCancelling(), z, new JobKt__JobKt$invokeOnCompletion$1(1, jobNode, JobNode.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0, 0));
    }

    public static final boolean isActive(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key.$$INSTANCE);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object joinAll(ArrayList arrayList, ContinuationImpl continuationImpl) {
        AwaitKt$joinAll$3 awaitKt$joinAll$3;
        Iterator it;
        if (continuationImpl instanceof AwaitKt$joinAll$3) {
            awaitKt$joinAll$3 = (AwaitKt$joinAll$3) continuationImpl;
            int i = awaitKt$joinAll$3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$3.label = i - Integer.MIN_VALUE;
            } else {
                awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuationImpl);
            }
        } else {
            awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuationImpl);
        }
        Object obj = awaitKt$joinAll$3.result;
        int i2 = awaitKt$joinAll$3.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            it = arrayList.iterator();
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = awaitKt$joinAll$3.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            Job job = (Job) it.next();
            awaitKt$joinAll$3.L$0 = it;
            awaitKt$joinAll$3.label = 1;
            Object objJoin = job.join(awaitKt$joinAll$3);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objJoin == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    public static StandaloneCoroutine launch$default(CoroutineScope coroutineScope, CoroutineContext.Element element, Function2 function2, int i) {
        CoroutineContext coroutineContext = element;
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        int i2 = (i & 2) != 0 ? 1 : 4;
        CoroutineContext coroutineContextNewCoroutineContext = newCoroutineContext(coroutineScope, coroutineContext);
        StandaloneCoroutine lazyStandaloneCoroutine = i2 == 2 ? new LazyStandaloneCoroutine(coroutineContextNewCoroutineContext, function2) : new StandaloneCoroutine(coroutineContextNewCoroutineContext, true);
        lazyStandaloneCoroutine.start(i2, lazyStandaloneCoroutine, function2);
        return lazyStandaloneCoroutine;
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextFoldCopies = foldCopies(coroutineScope.getCoroutineContext(), coroutineContext, true);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return (coroutineContextFoldCopies == defaultScheduler || coroutineContextFoldCopies.get(ContinuationInterceptor$Key.$$INSTANCE) != null) ? coroutineContextFoldCopies : coroutineContextFoldCopies.plus(defaultScheduler);
    }

    public static final Object recoverResult(Object obj) {
        return obj instanceof CompletedExceptionally ? new Result.Failure(((CompletedExceptionally) obj).cause) : obj;
    }

    public static final void resume(CancellableContinuationImpl cancellableContinuationImpl, Continuation continuation, boolean z) {
        Object obj = CancellableContinuationImpl._state$volatile$FU.get(cancellableContinuationImpl);
        Throwable exceptionalResult$kotlinx_coroutines_core = cancellableContinuationImpl.getExceptionalResult$kotlinx_coroutines_core(obj);
        Object failure = exceptionalResult$kotlinx_coroutines_core != null ? new Result.Failure(exceptionalResult$kotlinx_coroutines_core) : cancellableContinuationImpl.getSuccessfulResult$kotlinx_coroutines_core(obj);
        if (!z) {
            continuation.resumeWith(failure);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
        Object obj2 = dispatchedContinuation.countOrElement;
        CoroutineContext context = continuationImpl.getContext();
        Object objUpdateThreadContext = InlineList.updateThreadContext(context, obj2);
        UndispatchedCoroutine undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != InlineList.NO_THREAD_ELEMENTS ? updateUndispatchedCompletion(continuationImpl, context, objUpdateThreadContext) : null;
        try {
            continuationImpl.resumeWith(failure);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                InlineList.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }

    public static final Object runBlocking(CoroutineContext coroutineContext, Function2 function2) throws Throwable {
        EventLoopImplPlatform eventLoop$kotlinx_coroutines_core;
        CoroutineContext coroutineContextFoldCopies;
        Thread threadCurrentThread = Thread.currentThread();
        CoroutineContext.Key key = ContinuationInterceptor$Key.$$INSTANCE;
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) coroutineContext.get(key);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher == null) {
            eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
            coroutineContextFoldCopies = foldCopies(emptyCoroutineContext, coroutineContext.plus(eventLoop$kotlinx_coroutines_core), true);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            if (coroutineContextFoldCopies != defaultScheduler && coroutineContextFoldCopies.get(key) == null) {
                coroutineContextFoldCopies = coroutineContextFoldCopies.plus(defaultScheduler);
            }
        } else {
            if (coroutineDispatcher instanceof EventLoopImplPlatform) {
            }
            eventLoop$kotlinx_coroutines_core = (EventLoopImplPlatform) ThreadLocalEventLoop.ref.get();
            coroutineContextFoldCopies = foldCopies(emptyCoroutineContext, coroutineContext, true);
            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
            if (coroutineContextFoldCopies != defaultScheduler2 && coroutineContextFoldCopies.get(key) == null) {
                coroutineContextFoldCopies = coroutineContextFoldCopies.plus(defaultScheduler2);
            }
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(coroutineContextFoldCopies, threadCurrentThread, eventLoop$kotlinx_coroutines_core);
        blockingCoroutine.start(1, blockingCoroutine, function2);
        EventLoopImplPlatform eventLoopImplPlatform = blockingCoroutine.eventLoop;
        if (eventLoopImplPlatform != null) {
            eventLoopImplPlatform.incrementUseCount(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jProcessNextEvent = eventLoopImplPlatform != null ? eventLoopImplPlatform.processNextEvent() : Long.MAX_VALUE;
                if (blockingCoroutine.isCompleted()) {
                    if (eventLoopImplPlatform != null) {
                        eventLoopImplPlatform.decrementUseCount(false);
                    }
                    Object objUnboxState = unboxState(JobSupport._state$volatile$FU.get(blockingCoroutine));
                    CompletedExceptionally completedExceptionally = objUnboxState instanceof CompletedExceptionally ? (CompletedExceptionally) objUnboxState : null;
                    if (completedExceptionally == null) {
                        return objUnboxState;
                    }
                    throw completedExceptionally.cause;
                }
                LockSupport.parkNanos(blockingCoroutine, jProcessNextEvent);
            } catch (Throwable th) {
                if (eventLoopImplPlatform != null) {
                    eventLoopImplPlatform.decrementUseCount(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        blockingCoroutine.cancelImpl$kotlinx_coroutines_core(interruptedException);
        throw interruptedException;
    }

    public static final Object setupTimeout(TimeoutCoroutine timeoutCoroutine, Function2 function2) throws Throwable {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        invokeOnCompletion(timeoutCoroutine, true, new InvokeOnCompletion(1, getDelay(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.context)));
        try {
            if (function2 instanceof BaseContinuationImpl) {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
                completedExceptionally = function2.invoke(timeoutCoroutine, timeoutCoroutine);
            } else {
                completedExceptionally = zzga.wrapWithContinuationImpl(function2, timeoutCoroutine, timeoutCoroutine);
            }
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (completedExceptionally == coroutineSingletons || (objMakeCompletingOnce$kotlinx_coroutines_core = timeoutCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) == COMPLETING_WAITING_CHILDREN) {
            return coroutineSingletons;
        }
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            Throwable th2 = ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
            if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).coroutine != timeoutCoroutine) {
                throw th2;
            }
            if (completedExceptionally instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) completedExceptionally).cause;
            }
        } else {
            completedExceptionally = unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
        }
        return completedExceptionally;
    }

    public static final String toDebugString(Continuation continuation) {
        Object failure;
        if (continuation instanceof DispatchedContinuation) {
            return ((DispatchedContinuation) continuation).toString();
        }
        try {
            failure = continuation + '@' + getHexAddress(continuation);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m830exceptionOrNullimpl(failure) != null) {
            failure = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) failure;
    }

    public static final Object unboxState(Object obj) {
        Incomplete incomplete;
        IncompleteStateBox incompleteStateBox = obj instanceof IncompleteStateBox ? (IncompleteStateBox) obj : null;
        return (incompleteStateBox == null || (incomplete = incompleteStateBox.state) == null) ? obj : incomplete;
    }

    public static final UndispatchedCoroutine updateUndispatchedCompletion(Continuation continuation, CoroutineContext coroutineContext, Object obj) {
        UndispatchedCoroutine undispatchedCoroutine = null;
        if ((continuation instanceof CoroutineStackFrame) && coroutineContext.get(UndispatchedMarker.INSTANCE) != null) {
            CoroutineStackFrame callerFrame = (CoroutineStackFrame) continuation;
            while (!(callerFrame instanceof DispatchedCoroutine) && (callerFrame = callerFrame.getCallerFrame()) != null) {
                if (callerFrame instanceof UndispatchedCoroutine) {
                    undispatchedCoroutine = (UndispatchedCoroutine) callerFrame;
                    break;
                }
            }
            if (undispatchedCoroutine != null) {
                undispatchedCoroutine.saveThreadContext(coroutineContext, obj);
            }
        }
        return undispatchedCoroutine;
    }

    public static final Object withContext(CoroutineContext coroutineContext, Function2 function2, Continuation continuation) throws Throwable {
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext.fold(Boolean.FALSE, new FilesKt__UtilsKt$$ExternalSyntheticLambda0(5))).booleanValue() ? context.plus(coroutineContext) : foldCopies(context, coroutineContext, false);
        ensureActive(coroutineContextPlus);
        if (coroutineContextPlus == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation, coroutineContextPlus);
            return LazyListKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        }
        ContinuationInterceptor$Key continuationInterceptor$Key = ContinuationInterceptor$Key.$$INSTANCE;
        if (Intrinsics.areEqual(coroutineContextPlus.get(continuationInterceptor$Key), context.get(continuationInterceptor$Key))) {
            UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(continuation, coroutineContextPlus);
            CoroutineContext coroutineContext2 = undispatchedCoroutine.context;
            Object objUpdateThreadContext = InlineList.updateThreadContext(coroutineContext2, null);
            try {
                return LazyListKt.startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, function2);
            } finally {
                InlineList.restoreThreadContext(coroutineContext2, objUpdateThreadContext);
            }
        }
        DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(continuation, coroutineContextPlus);
        try {
            InlineList.resumeCancellableWith(Unit.INSTANCE, zzga.intercepted(zzga.createCoroutineUnintercepted(dispatchedCoroutine, dispatchedCoroutine, function2)));
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = DispatchedCoroutine._decision$volatile$FU;
            do {
                int i = atomicIntegerFieldUpdater.get(dispatchedCoroutine);
                if (i != 0) {
                    if (i != 2) {
                        throw new IllegalStateException("Already suspended");
                    }
                    Object objUnboxState = unboxState(JobSupport._state$volatile$FU.get(dispatchedCoroutine));
                    if (objUnboxState instanceof CompletedExceptionally) {
                        throw ((CompletedExceptionally) objUnboxState).cause;
                    }
                    return objUnboxState;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(dispatchedCoroutine, 0, 1));
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        } catch (Throwable th) {
            th = th;
            if (th instanceof DispatchException) {
                th = ((DispatchException) th).cause;
            }
            dispatchedCoroutine.resumeWith(new Result.Failure(th));
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object withTimeoutOrNull(long j, Function2 function2, ContinuationImpl continuationImpl) throws Throwable {
        TimeoutKt$withTimeoutOrNull$1 timeoutKt$withTimeoutOrNull$1;
        Ref$ObjectRef ref$ObjectRef;
        if (continuationImpl instanceof TimeoutKt$withTimeoutOrNull$1) {
            timeoutKt$withTimeoutOrNull$1 = (TimeoutKt$withTimeoutOrNull$1) continuationImpl;
            int i = timeoutKt$withTimeoutOrNull$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                timeoutKt$withTimeoutOrNull$1.label = i - Integer.MIN_VALUE;
            } else {
                timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuationImpl);
            }
        } else {
            timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuationImpl);
        }
        Object obj = timeoutKt$withTimeoutOrNull$1.result;
        int i2 = timeoutKt$withTimeoutOrNull$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (j <= 0) {
                return null;
            }
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            try {
                timeoutKt$withTimeoutOrNull$1.L$1 = ref$ObjectRef2;
                timeoutKt$withTimeoutOrNull$1.label = 1;
                TimeoutCoroutine timeoutCoroutine = new TimeoutCoroutine(j, timeoutKt$withTimeoutOrNull$1);
                ref$ObjectRef2.element = timeoutCoroutine;
                Object obj2 = setupTimeout(timeoutCoroutine, function2);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return obj2 == coroutineSingletons ? coroutineSingletons : obj2;
            } catch (TimeoutCancellationException e) {
                e = e;
                ref$ObjectRef = ref$ObjectRef2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = timeoutKt$withTimeoutOrNull$1.L$1;
            try {
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (TimeoutCancellationException e2) {
                e = e2;
            }
        }
        if (e.coroutine == ref$ObjectRef.element) {
            return null;
        }
        throw e;
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }
}
