package kotlinx.coroutines.selects;

import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectImplementation implements CancelHandler, SelectInstance, Waiter {
    public static final /* synthetic */ AtomicReferenceFieldUpdater state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");
    public final CoroutineContext context;
    public Object disposableHandleOrSegment;
    private volatile /* synthetic */ Object state$volatile = SelectKt.STATE_REG;
    public ArrayList clauses = new ArrayList(2);
    public int indexInSegment = -1;
    public Object internalResult = SelectKt.NO_RESULT;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ClauseData {
        public final SuspendLambda block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment = -1;
        public final Function3 onCancellationConstructor;
        public final Function3 processResFunc;
        public final Function3 regFunc;

        public ClauseData(Object obj, Function3 function3, Function3 function4, SuspendLambda suspendLambda, Function3 function5) {
            this.clauseObject = obj;
            this.regFunc = function3;
            this.processResFunc = function4;
            this.block = suspendLambda;
            this.onCancellationConstructor = function5;
        }

        public final void dispose() {
            Object obj = this.disposableHandleOrSegment;
            if (obj instanceof Segment) {
                ((Segment) obj).onCancellation(this.indexInSegment, SelectImplementation.this.context);
                return;
            }
            DisposableHandle disposableHandle = obj instanceof DisposableHandle ? (DisposableHandle) obj : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public SelectImplementation L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectImplementation.this.doSelectSuspend(this);
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.context = coroutineContext;
    }

    public final Object complete(ContinuationImpl continuationImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
        ClauseData clauseData = (ClauseData) atomicReferenceFieldUpdater.get(this);
        Object obj = this.internalResult;
        ArrayList arrayList = this.clauses;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                ClauseData clauseData2 = (ClauseData) obj2;
                if (clauseData2 != clauseData) {
                    clauseData2.dispose();
                }
            }
            atomicReferenceFieldUpdater.set(this, SelectKt.STATE_COMPLETED);
            this.internalResult = SelectKt.NO_RESULT;
            this.clauses = null;
        }
        return ((Function2) clauseData.block).invoke(clauseData.processResFunc.invoke(clauseData.clauseObject, null, obj), continuationImpl);
    }

    public final Object doSelect(ContinuationImpl continuationImpl) {
        return state$volatile$FU.get(this) instanceof ClauseData ? complete(continuationImpl) : doSelectSuspend(continuationImpl);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object doSelectSuspend(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        SelectImplementation selectImplementation;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(anonymousClass1));
            cancellableContinuationImpl.initCancellability();
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
                Object obj2 = atomicReferenceFieldUpdater.get(this);
                Symbol symbol = SelectKt.STATE_REG;
                if (obj2 == symbol) {
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, cancellableContinuationImpl)) {
                            cancellableContinuationImpl.invokeOnCancellationImpl(this);
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj2);
                } else {
                    if (!(obj2 instanceof List)) {
                        if (!(obj2 instanceof ClauseData)) {
                            throw new IllegalStateException(("unexpected state: " + obj2).toString());
                        }
                        Unit unit = Unit.INSTANCE;
                        Object obj3 = this.internalResult;
                        Function3 function3 = ((ClauseData) obj2).onCancellationConstructor;
                        cancellableContinuationImpl.resume(unit, function3 != null ? (Function3) function3.invoke(this, null, obj3) : null);
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, symbol)) {
                            Iterator it = ((Iterable) obj2).iterator();
                            while (it.hasNext()) {
                                ClauseData clauseDataFindClause = findClause(it.next());
                                clauseDataFindClause.disposableHandleOrSegment = null;
                                clauseDataFindClause.indexInSegment = -1;
                                register(clauseDataFindClause, true);
                            }
                            break;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj2);
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result != coroutineSingletons) {
                result = Unit.INSTANCE;
            }
            if (result != coroutineSingletons) {
                selectImplementation = this;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        selectImplementation = anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 2;
        Object objComplete = selectImplementation.complete(anonymousClass1);
        return objComplete == coroutineSingletons ? coroutineSingletons : objComplete;
    }

    public final ClauseData findClause(Object obj) {
        ArrayList arrayList = this.clauses;
        Object obj2 = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj3 = arrayList.get(i);
            i++;
            if (((ClauseData) obj3).clauseObject == obj) {
                obj2 = obj3;
                break;
            }
        }
        ClauseData clauseData = (ClauseData) obj2;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(SelectClause1 selectClause1, Function2 function2) {
        Dispatcher dispatcher = (Dispatcher) selectClause1;
        register(new ClauseData(dispatcher.executorServiceOrNull, (Function3) dispatcher.readyAsyncCalls, (Function3) dispatcher.runningAsyncCalls, (SuspendLambda) function2, (Function3) dispatcher.runningSyncCalls), false);
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment segment, int i) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = i;
    }

    public final void register(ClauseData clauseData, boolean z) {
        Object obj = clauseData.clauseObject;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
        if (atomicReferenceFieldUpdater.get(this) instanceof ClauseData) {
            return;
        }
        if (!z) {
            ArrayList arrayList = this.clauses;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    if (((ClauseData) obj2).clauseObject == obj) {
                        throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
                    }
                }
            }
        }
        clauseData.regFunc.invoke(obj, this, null);
        if (this.internalResult != SelectKt.NO_RESULT) {
            atomicReferenceFieldUpdater.set(this, clauseData);
            return;
        }
        if (!z) {
            this.clauses.add(clauseData);
        }
        clauseData.disposableHandleOrSegment = this.disposableHandleOrSegment;
        clauseData.indexInSegment = this.indexInSegment;
        this.disposableHandleOrSegment = null;
        this.indexInSegment = -1;
    }

    public final int trySelectInternal(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof CancellableContinuation)) {
                if (Intrinsics.areEqual(obj3, SelectKt.STATE_COMPLETED) || (obj3 instanceof ClauseData)) {
                    return 3;
                }
                if (Intrinsics.areEqual(obj3, SelectKt.STATE_CANCELLED)) {
                    return 2;
                }
                if (Intrinsics.areEqual(obj3, SelectKt.STATE_REG)) {
                    List listSingletonList = Collections.singletonList(obj);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, listSingletonList)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj3) {
                        }
                    }
                    return 1;
                }
                if (!(obj3 instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                }
                ArrayList arrayListPlus = CollectionsKt.plus((Collection) obj3, obj);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj3, arrayListPlus)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj3) {
                    }
                }
                return 1;
            }
            ClauseData clauseDataFindClause = findClause(obj);
            if (clauseDataFindClause == null) {
                continue;
            } else {
                Function3 function3 = clauseDataFindClause.onCancellationConstructor;
                Function3 function4 = function3 != null ? (Function3) function3.invoke(this, null, obj2) : null;
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, clauseDataFindClause)) {
                        CancellableContinuation cancellableContinuation = (CancellableContinuation) obj3;
                        this.internalResult = obj2;
                        Symbol symbolTryResume = cancellableContinuation.tryResume(Unit.INSTANCE, function4);
                        if (symbolTryResume == null) {
                            this.internalResult = SelectKt.NO_RESULT;
                            return 2;
                        }
                        cancellableContinuation.completeResume(symbolTryResume);
                        return 0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj3);
            }
        }
    }

    @Override // kotlinx.coroutines.CancelHandler
    public final void invoke(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.STATE_COMPLETED) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, SelectKt.STATE_CANCELLED)) {
                    ArrayList arrayList = this.clauses;
                    if (arrayList == null) {
                        return;
                    }
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj2 = arrayList.get(i);
                        i++;
                        ((ClauseData) obj2).dispose();
                    }
                    this.internalResult = SelectKt.NO_RESULT;
                    this.clauses = null;
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }
}
