package kotlinx.coroutines;

import androidx.camera.camera2.internal.CameraIdUtil;
import coil.network.HttpException;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import io.github.g00fy2.quickie.ScanQRCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.internal.ListClosed;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class JobSupport implements Job, ChildJob, ParentJob {
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    public static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AwaitContinuation extends CancellableContinuationImpl {
        public final JobSupport job;

        public AwaitContinuation(Continuation continuation, JobSupport jobSupport) {
            super(1, continuation);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final Throwable getContinuationCancellationCause(JobSupport jobSupport) {
            Throwable rootCause;
            JobSupport jobSupport2 = this.job;
            jobSupport2.getClass();
            Object obj = JobSupport._state$volatile$FU.get(jobSupport2);
            if (!(obj instanceof Finishing) || (rootCause = ((Finishing) obj).getRootCause()) == null) {
                return obj instanceof CompletedExceptionally ? ((CompletedExceptionally) obj).cause : jobSupport.getCancellationException();
            }
            return rootCause;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final String nameString() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ChildCompletion extends JobNode {
        public final ChildHandleNode child;
        public final JobSupport parent;
        public final Object proposedUpdate;
        public final Finishing state;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        @Override // kotlinx.coroutines.JobNode
        public final boolean getOnCancelling() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public final void invoke(Throwable th) {
            ChildHandleNode childHandleNode = this.child;
            ChildHandleNode childHandleNodeNextChild = JobSupport.nextChild(childHandleNode);
            JobSupport jobSupport = this.parent;
            Finishing finishing = this.state;
            Object obj = this.proposedUpdate;
            if (childHandleNodeNextChild == null || !jobSupport.tryWaitForChild(finishing, childHandleNodeNextChild, obj)) {
                finishing.list.addLast(new ListClosed(2), 2);
                ChildHandleNode childHandleNodeNextChild2 = JobSupport.nextChild(childHandleNode);
                if (childHandleNodeNextChild2 == null || !jobSupport.tryWaitForChild(finishing, childHandleNodeNextChild2, obj)) {
                    jobSupport.afterCompletion(jobSupport.finalizeFinishingState(finishing, obj));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Finishing implements Incomplete {
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile = 0;
        private volatile /* synthetic */ Object _rootCause$volatile;
        public final NodeList list;
        public static final /* synthetic */ AtomicIntegerFieldUpdater _isCompleting$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting$volatile");
        public static final /* synthetic */ AtomicReferenceFieldUpdater _rootCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause$volatile");
        public static final /* synthetic */ AtomicReferenceFieldUpdater _exceptionsHolder$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder$volatile");

        public Finishing(NodeList nodeList, Throwable th) {
            this.list = nodeList;
            this._rootCause$volatile = th;
        }

        public final void addExceptionLocked(Throwable th) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                _rootCause$volatile$FU.set(this, th);
                return;
            }
            if (th == rootCause) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _exceptionsHolder$volatile$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                    return;
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
            if (th == obj) {
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(th);
            atomicReferenceFieldUpdater.set(this, arrayList);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final NodeList getList() {
            return this.list;
        }

        public final Throwable getRootCause() {
            return (Throwable) _rootCause$volatile$FU.get(this);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean isActive() {
            return getRootCause() == null;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        public final ArrayList sealLocked(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _exceptionsHolder$volatile$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayList = (ArrayList) obj;
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayList.add(0, rootCause);
            }
            if (th != null && !th.equals(rootCause)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, JobKt.SEALED);
            return arrayList;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Finishing[cancelling=");
            sb.append(isCancelling());
            sb.append(", completing=");
            sb.append(_isCompleting$volatile$FU.get(this) == 1);
            sb.append(", rootCause=");
            sb.append(getRootCause());
            sb.append(", exceptions=");
            sb.append(_exceptionsHolder$volatile$FU.get(this));
            sb.append(", list=");
            sb.append(this.list);
            sb.append(']');
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SelectOnJoinCompletionHandler extends JobNode {
        public final /* synthetic */ int $r8$classId;
        public final SelectInstance select;
        public final /* synthetic */ JobSupport this$0;

        public /* synthetic */ SelectOnJoinCompletionHandler(JobSupport jobSupport, SelectInstance selectInstance, int i) {
            this.$r8$classId = i;
            this.this$0 = jobSupport;
            this.select = selectInstance;
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
                    ((SelectImplementation) this.select).trySelectInternal(this.this$0, Unit.INSTANCE);
                    break;
                default:
                    JobSupport jobSupport = this.this$0;
                    jobSupport.getClass();
                    Object objUnboxState = JobSupport._state$volatile$FU.get(jobSupport);
                    if (!(objUnboxState instanceof CompletedExceptionally)) {
                        objUnboxState = JobKt.unboxState(objUnboxState);
                    }
                    ((SelectImplementation) this.select).trySelectInternal(jobSupport, objUnboxState);
                    break;
            }
        }
    }

    public JobSupport(boolean z) {
        this._state$volatile = z ? JobKt.EMPTY_ACTIVE : JobKt.EMPTY_NEW;
    }

    public static ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode._prev$volatile$FU;
            LockFreeLinkedListNode lockFreeLinkedListNodeCorrectPrev = lockFreeLinkedListNode.correctPrev();
            if (lockFreeLinkedListNodeCorrectPrev == null) {
                Object obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                while (true) {
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    if (!lockFreeLinkedListNode.isRemoved()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                }
            } else {
                lockFreeLinkedListNode = lockFreeLinkedListNodeCorrectPrev;
            }
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public static String stateString(Object obj) {
        if (!(obj instanceof Finishing)) {
            if (obj instanceof Incomplete) {
                return ((Incomplete) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        Finishing finishing = (Finishing) obj;
        if (finishing.isCancelling()) {
            return "Cancelling";
        }
        return Finishing._isCompleting$volatile$FU.get(finishing) == 1 ? "Completing" : "Active";
    }

    public static CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new JobCancellationException(jobSupport.cancellationExceptionMessage(), th, jobSupport) : cancellationException;
    }

    public void afterResume(Object obj) {
        afterCompletion(obj);
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob childJob) {
        ChildHandleNode childHandleNode = new ChildHandleNode(childJob);
        childHandleNode.job = this;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                if (empty.isActive) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, childHandleNode)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                        }
                    }
                    break loop0;
                }
                promoteEmptyToNodeList(empty);
            } else {
                boolean z = obj instanceof Incomplete;
                NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
                Throwable rootCause = null;
                if (!z) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    CompletedExceptionally completedExceptionally = obj2 instanceof CompletedExceptionally ? (CompletedExceptionally) obj2 : null;
                    childHandleNode.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                    return nonDisposableHandle;
                }
                NodeList list = ((Incomplete) obj).getList();
                if (list != null) {
                    if (list.addLast(childHandleNode, 7)) {
                        break;
                    }
                    boolean zAddLast = list.addLast(childHandleNode, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof Finishing) {
                        rootCause = ((Finishing) obj3).getRootCause();
                    } else {
                        CompletedExceptionally completedExceptionally2 = obj3 instanceof CompletedExceptionally ? (CompletedExceptionally) obj3 : null;
                        if (completedExceptionally2 != null) {
                            rootCause = completedExceptionally2.cause;
                        }
                    }
                    childHandleNode.invoke(rootCause);
                    if (zAddLast) {
                        break;
                    }
                    return nonDisposableHandle;
                }
                promoteSingleToNodeList((JobNode) obj);
            }
        }
        return childHandleNode;
    }

    public Object await(Continuation continuation) {
        return awaitInternal(continuation);
    }

    public final Object awaitInternal(Continuation continuation) throws Throwable {
        Object obj;
        do {
            obj = _state$volatile$FU.get(this);
            if (!(obj instanceof Incomplete)) {
                if (obj instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) obj).cause;
                }
                return JobKt.unboxState(obj);
            }
        } while (startInternal(obj) < 0);
        AwaitContinuation awaitContinuation = new AwaitContinuation(zzga.intercepted(continuation), this);
        awaitContinuation.initCancellability();
        awaitContinuation.invokeOnCancellationImpl(new DisposeOnCancel(0, JobKt.invokeOnCompletion(this, true, new InvokeOnCompletion(2, awaitContinuation))));
        return awaitContinuation.getResult();
    }

    public final /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e A[PHI: r0
      0x003e: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v13 java.lang.Object) binds: [B:3:0x0008, B:16:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x005e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0061 A[Catch: all -> 0x0067, TRY_LEAVE, TryCatch #0 {, blocks: (B:24:0x004f, B:29:0x0061, B:34:0x0069, B:36:0x0072, B:37:0x0076), top: B:81:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0069 A[Catch: all -> 0x0067, TRY_ENTER, TryCatch #0 {, blocks: (B:24:0x004f, B:29:0x0061, B:34:0x0069, B:36:0x0072, B:37:0x0076), top: B:81:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0072 A[Catch: all -> 0x0067, TryCatch #0 {, blocks: (B:24:0x004f, B:29:0x0061, B:34:0x0069, B:36:0x0072, B:37:0x0076), top: B:81:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0085  */
    /* JADX WARN: Code duplicated, block: B:42:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x0095  */
    /* JADX WARN: Code duplicated, block: B:48:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:78:0x0105 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x0106  */
    /* JADX WARN: Code duplicated, block: B:81:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x004e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[LOOP:2: B:56:0x00b4->B:98:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x0042, please report this as an issue */
    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) {
        Throwable thCreateCauseException;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2;
        boolean z;
        Throwable rootCause;
        Symbol symbol;
        Incomplete incomplete;
        NodeList orPromoteCancellingList;
        Finishing finishing;
        Object objTryMakeCompleting;
        Object objTryMakeCompleting2 = JobKt.COMPLETING_ALREADY;
        if (getOnCancelComplete$kotlinx_coroutines_core()) {
            do {
                Object obj3 = _state$volatile$FU.get(this);
                if (obj3 instanceof Incomplete) {
                    if (obj3 instanceof Finishing) {
                        if (Finishing._isCompleting$volatile$FU.get((Finishing) obj3) == 1) {
                        }
                    }
                    objTryMakeCompleting2 = tryMakeCompleting(obj3, new CompletedExceptionally(createCauseException(obj), false));
                }
                objTryMakeCompleting2 = JobKt.COMPLETING_ALREADY;
                break;
            } while (objTryMakeCompleting2 == JobKt.COMPLETING_RETRY);
            if (objTryMakeCompleting2 != JobKt.COMPLETING_WAITING_CHILDREN) {
                if (objTryMakeCompleting2 == JobKt.COMPLETING_ALREADY) {
                    thCreateCauseException = null;
                    loop1: while (true) {
                        atomicReferenceFieldUpdater = _state$volatile$FU;
                        obj2 = atomicReferenceFieldUpdater.get(this);
                        if (obj2 instanceof Finishing) {
                            synchronized (obj2) {
                                if (Finishing._exceptionsHolder$volatile$FU.get((Finishing) obj2) == JobKt.SEALED) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    symbol = JobKt.TOO_LATE_TO_CANCEL;
                                } else {
                                    boolean zIsCancelling = ((Finishing) obj2).isCancelling();
                                    if (thCreateCauseException == null) {
                                        thCreateCauseException = createCauseException(obj);
                                    }
                                    ((Finishing) obj2).addExceptionLocked(thCreateCauseException);
                                    rootCause = zIsCancelling ? null : ((Finishing) obj2).getRootCause();
                                    if (rootCause != null) {
                                        notifyCancelling(((Finishing) obj2).list, rootCause);
                                    }
                                    symbol = JobKt.COMPLETING_ALREADY;
                                }
                            }
                        } else if (obj2 instanceof Incomplete) {
                            if (thCreateCauseException == null) {
                                thCreateCauseException = createCauseException(obj);
                            }
                            incomplete = (Incomplete) obj2;
                            if (incomplete.isActive()) {
                                orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
                                if (orPromoteCancellingList == null) {
                                    continue;
                                } else {
                                    finishing = new Finishing(orPromoteCancellingList, thCreateCauseException);
                                    while (true) {
                                        if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, finishing)) {
                                            notifyCancelling(orPromoteCancellingList, thCreateCauseException);
                                            symbol = JobKt.COMPLETING_ALREADY;
                                        } else if (atomicReferenceFieldUpdater.get(this) != incomplete) {
                                        }
                                    }
                                }
                            } else {
                                objTryMakeCompleting = tryMakeCompleting(obj2, new CompletedExceptionally(thCreateCauseException, false));
                                if (objTryMakeCompleting != JobKt.COMPLETING_ALREADY) {
                                    throw new IllegalStateException(("Cannot happen in " + obj2).toString());
                                }
                                if (objTryMakeCompleting != JobKt.COMPLETING_RETRY) {
                                    objTryMakeCompleting2 = objTryMakeCompleting;
                                    break;
                                }
                            }
                        } else {
                            symbol = JobKt.TOO_LATE_TO_CANCEL;
                        }
                        objTryMakeCompleting2 = symbol;
                        break;
                    }
                }
                if (objTryMakeCompleting2 != JobKt.COMPLETING_ALREADY && objTryMakeCompleting2 != JobKt.COMPLETING_WAITING_CHILDREN) {
                    if (objTryMakeCompleting2 == JobKt.TOO_LATE_TO_CANCEL) {
                        return false;
                    }
                    afterCompletion(objTryMakeCompleting2);
                    return true;
                }
            }
        } else {
            if (objTryMakeCompleting2 == JobKt.COMPLETING_ALREADY) {
                thCreateCauseException = null;
                loop1: while (true) {
                    atomicReferenceFieldUpdater = _state$volatile$FU;
                    obj2 = atomicReferenceFieldUpdater.get(this);
                    if (obj2 instanceof Finishing) {
                        synchronized (obj2) {
                            if (Finishing._exceptionsHolder$volatile$FU.get((Finishing) obj2) == JobKt.SEALED) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                symbol = JobKt.TOO_LATE_TO_CANCEL;
                            } else {
                                boolean zIsCancelling2 = ((Finishing) obj2).isCancelling();
                                if (thCreateCauseException == null) {
                                    thCreateCauseException = createCauseException(obj);
                                }
                                ((Finishing) obj2).addExceptionLocked(thCreateCauseException);
                                if (zIsCancelling2) {
                                }
                                if (rootCause != null) {
                                    notifyCancelling(((Finishing) obj2).list, rootCause);
                                }
                                symbol = JobKt.COMPLETING_ALREADY;
                            }
                        }
                    } else if (obj2 instanceof Incomplete) {
                        if (thCreateCauseException == null) {
                            thCreateCauseException = createCauseException(obj);
                        }
                        incomplete = (Incomplete) obj2;
                        if (incomplete.isActive()) {
                            orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
                            if (orPromoteCancellingList == null) {
                                continue;
                            } else {
                                finishing = new Finishing(orPromoteCancellingList, thCreateCauseException);
                                while (true) {
                                    if (atomicReferenceFieldUpdater.compareAndSet(this, incomplete, finishing)) {
                                        notifyCancelling(orPromoteCancellingList, thCreateCauseException);
                                        symbol = JobKt.COMPLETING_ALREADY;
                                    } else if (atomicReferenceFieldUpdater.get(this) != incomplete) {
                                    }
                                }
                            }
                        } else {
                            objTryMakeCompleting = tryMakeCompleting(obj2, new CompletedExceptionally(thCreateCauseException, false));
                            if (objTryMakeCompleting != JobKt.COMPLETING_ALREADY) {
                                throw new IllegalStateException(("Cannot happen in " + obj2).toString());
                            }
                            if (objTryMakeCompleting != JobKt.COMPLETING_RETRY) {
                                objTryMakeCompleting2 = objTryMakeCompleting;
                                break;
                            }
                        }
                    } else {
                        symbol = JobKt.TOO_LATE_TO_CANCEL;
                    }
                    objTryMakeCompleting2 = symbol;
                    break;
                }
            }
            if (objTryMakeCompleting2 != JobKt.COMPLETING_ALREADY) {
                if (objTryMakeCompleting2 == JobKt.TOO_LATE_TO_CANCEL) {
                    return false;
                }
                afterCompletion(objTryMakeCompleting2);
                return true;
            }
        }
        return true;
    }

    public void cancelInternal(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public final boolean cancelParent(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle childHandle = (ChildHandle) _parentHandle$volatile$FU.get(this);
        if (childHandle == null || childHandle == NonDisposableHandle.INSTANCE) {
            return z;
        }
        return childHandle.childCancelled(th) || z;
    }

    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th) && getHandlesException$kotlinx_coroutines_core();
    }

    public boolean complete(Object obj) {
        return makeCompleting$kotlinx_coroutines_core(obj);
    }

    public final void completeStateFinalization(Incomplete incomplete, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$volatile$FU;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        if (childHandle != null) {
            childHandle.dispose();
            atomicReferenceFieldUpdater.set(this, NonDisposableHandle.INSTANCE);
        }
        HttpException httpException = null;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
                return;
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new HttpException("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            list.addLast(new ListClosed(1), 1);
            for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) LockFreeLinkedListNode._next$volatile$FU.get(list); !nextNode.equals(list); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof JobNode) {
                    try {
                        ((JobNode) nextNode).invoke(th);
                    } catch (Throwable th3) {
                        if (httpException != null) {
                            ScanQRCode.addSuppressed(httpException, th3);
                        } else {
                            httpException = new HttpException("Exception in completion handler " + nextNode + " for " + this, th3);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            }
            if (httpException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(httpException);
            }
        }
    }

    public final Throwable createCauseException(Object obj) {
        Throwable rootCause;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        JobSupport jobSupport = (JobSupport) ((ParentJob) obj);
        Object obj2 = _state$volatile$FU.get(jobSupport);
        if (obj2 instanceof Finishing) {
            rootCause = ((Finishing) obj2).getRootCause();
        } else if (obj2 instanceof CompletedExceptionally) {
            rootCause = ((CompletedExceptionally) obj2).cause;
        } else {
            if (obj2 instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj2).toString());
            }
            rootCause = null;
        }
        CancellationException cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        return cancellationException == null ? new JobCancellationException("Parent job is ".concat(stateString(obj2)), rootCause, jobSupport) : cancellationException;
    }

    public final Object finalizeFinishingState(Finishing finishing, Object obj) {
        Throwable finalRootCause;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        synchronized (finishing) {
            finishing.isCancelling();
            ArrayList arrayListSealLocked = finishing.sealLocked(th);
            finalRootCause = getFinalRootCause(finishing, arrayListSealLocked);
            if (finalRootCause != null && arrayListSealLocked.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListSealLocked.size()));
                int size = arrayListSealLocked.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayListSealLocked.get(i);
                    i++;
                    Throwable th2 = (Throwable) obj2;
                    if (th2 != finalRootCause && th2 != finalRootCause && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        ScanQRCode.addSuppressed(finalRootCause, th2);
                    }
                }
            }
        }
        if (finalRootCause != null && finalRootCause != th) {
            obj = new CompletedExceptionally(finalRootCause, false);
        }
        if (finalRootCause != null && (cancelParent(finalRootCause) || handleJobException(finalRootCause))) {
            CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) obj;
            completedExceptionally2.getClass();
            CompletedExceptionally._handled$volatile$FU.compareAndSet(completedExceptionally2, 0, 1);
        }
        onCompletionInternal(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        Object incompleteStateBox = obj instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, finishing, incompleteStateBox) && atomicReferenceFieldUpdater.get(this) == finishing) {
        }
        completeStateFinalization(finishing, obj);
        return obj;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object obj = _state$volatile$FU.get(this);
        if (!(obj instanceof Finishing)) {
            if (!(obj instanceof Incomplete)) {
                return obj instanceof CompletedExceptionally ? toCancellationException$default(this, ((CompletedExceptionally) obj).cause) : new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        Throwable rootCause = ((Finishing) obj).getRootCause();
        if (rootCause == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        CancellationException cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = cancellationExceptionMessage();
        }
        return new JobCancellationException(strConcat, rootCause, this);
    }

    public final Sequence getChildren() {
        return new LinesSequence(new JobSupport$children$1(this, (Continuation) null, 0));
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object obj = _state$volatile$FU.get(this);
        if (obj instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    public final Throwable getFinalRootCause(Finishing finishing, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (finishing.isCancelling()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        do {
            if (i2 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i2);
            i2++;
        } while (((Throwable) obj) instanceof CancellationException);
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj3 = arrayList.get(i);
                i++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj2 = obj3;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key.$$INSTANCE;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return this instanceof CompletableDeferredImpl;
    }

    public final SelectClause0 getOnJoin() {
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, JobSupport$onJoin$1.INSTANCE);
        return new ByteString.Companion(20);
    }

    public final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            promoteSingleToNodeList((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    public final Job getParent() {
        ChildHandle childHandle = (ChildHandle) _parentHandle$volatile$FU.get(this);
        if (childHandle != null) {
            return childHandle.getParent();
        }
        return null;
    }

    public boolean handleJobException(Throwable th) {
        return false;
    }

    public final void initParentJob(Job job) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _parentHandle$volatile$FU;
        NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
        if (job == null) {
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
            return;
        }
        job.start();
        ChildHandle childHandleAttachChild = job.attachChild(this);
        atomicReferenceFieldUpdater.set(this, childHandleAttachChild);
        if (isCompleted()) {
            childHandleAttachChild.dispose();
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
        }
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1 function1) {
        return invokeOnCompletionInternal$kotlinx_coroutines_core(true, new InvokeOnCompletion(0, function1));
    }

    public final DisposableHandle invokeOnCompletionInternal$kotlinx_coroutines_core(boolean z, JobNode jobNode) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean z2;
        boolean zAddLast;
        jobNode.job = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = _state$volatile$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z3 = obj instanceof Empty;
            NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
            z2 = true;
            if (!z3) {
                if (!(obj instanceof Incomplete)) {
                    z2 = false;
                    break;
                }
                Incomplete incomplete = (Incomplete) obj;
                NodeList list = incomplete.getList();
                if (list == null) {
                    promoteSingleToNodeList((JobNode) obj);
                } else {
                    if (jobNode.getOnCancelling()) {
                        Finishing finishing = incomplete instanceof Finishing ? (Finishing) incomplete : null;
                        Throwable rootCause = finishing != null ? finishing.getRootCause() : null;
                        if (rootCause == null) {
                            zAddLast = list.addLast(jobNode, 5);
                        } else if (z) {
                            jobNode.invoke(rootCause);
                            return nonDisposableHandle;
                        }
                    } else {
                        zAddLast = list.addLast(jobNode, 1);
                    }
                    if (zAddLast) {
                        break;
                    }
                }
            } else {
                Empty empty = (Empty) obj;
                if (empty.isActive) {
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, jobNode)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj);
                } else {
                    promoteEmptyToNodeList(empty);
                }
            }
            return nonDisposableHandle;
        }
        if (z2) {
            return jobNode;
        }
        if (z) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            CompletedExceptionally completedExceptionally = obj2 instanceof CompletedExceptionally ? (CompletedExceptionally) obj2 : null;
            jobNode.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
        }
        return nonDisposableHandle;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object obj = _state$volatile$FU.get(this);
        return (obj instanceof Incomplete) && ((Incomplete) obj).isActive();
    }

    public final boolean isCancelled() {
        Object obj = _state$volatile$FU.get(this);
        if (obj instanceof CompletedExceptionally) {
            return true;
        }
        return (obj instanceof Finishing) && ((Finishing) obj).isCancelling();
    }

    public final boolean isCompleted() {
        return !(_state$volatile$FU.get(this) instanceof Incomplete);
    }

    public boolean isScopedCoroutine() {
        return this instanceof BlockingCoroutine;
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation continuation) {
        Object obj;
        do {
            obj = _state$volatile$FU.get(this);
            if (!(obj instanceof Incomplete)) {
                JobKt.ensureActive(continuation.getContext());
                return Unit.INSTANCE;
            }
        } while (startInternal(obj) < 0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzga.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellationImpl(new DisposeOnCancel(0, JobKt.invokeOnCompletion(this, true, new ChildContinuation(cancellableContinuationImpl, 1))));
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (result != coroutineSingletons) {
            result = Unit.INSTANCE;
        }
        return result == coroutineSingletons ? result : Unit.INSTANCE;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object obj) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(_state$volatile$FU.get(this), obj);
            if (objTryMakeCompleting == JobKt.COMPLETING_ALREADY) {
                return false;
            }
            if (objTryMakeCompleting == JobKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        } while (objTryMakeCompleting == JobKt.COMPLETING_RETRY);
        afterCompletion(objTryMakeCompleting);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(_state$volatile$FU.get(this), obj);
            if (objTryMakeCompleting == JobKt.COMPLETING_ALREADY) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
                throw new IllegalStateException(str, completedExceptionally != null ? completedExceptionally.cause : null);
            }
        } while (objTryMakeCompleting == JobKt.COMPLETING_RETRY);
        return objTryMakeCompleting;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    public String nameString$kotlinx_coroutines_core() {
        return getClass().getSimpleName();
    }

    public final void notifyCancelling(NodeList nodeList, Throwable th) {
        nodeList.addLast(new ListClosed(4), 4);
        HttpException httpException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) LockFreeLinkedListNode._next$volatile$FU.get(nodeList); !nextNode.equals(nodeList); nextNode = nextNode.getNextNode()) {
            if ((nextNode instanceof JobNode) && ((JobNode) nextNode).getOnCancelling()) {
                try {
                    ((JobNode) nextNode).invoke(th);
                } catch (Throwable th2) {
                    if (httpException != null) {
                        ScanQRCode.addSuppressed(httpException, th2);
                    } else {
                        httpException = new HttpException("Exception in completion handler " + nextNode + " for " + this, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (httpException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(httpException);
        }
        cancelParent(th);
    }

    public final Job plus(Job job) {
        return job;
    }

    public final void promoteEmptyToNodeList(Empty empty) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        NodeList nodeList = new NodeList();
        Object inactiveNodeList = nodeList;
        if (!empty.isActive) {
            inactiveNodeList = new InactiveNodeList(nodeList);
        }
        do {
            atomicReferenceFieldUpdater = _state$volatile$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, empty, inactiveNodeList)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == empty);
    }

    public final void promoteSingleToNodeList(JobNode jobNode) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        NodeList nodeList = new NodeList();
        jobNode.getClass();
        LockFreeLinkedListNode._prev$volatile$FU.set(nodeList, jobNode);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = LockFreeLinkedListNode._next$volatile$FU;
        atomicReferenceFieldUpdater2.set(nodeList, jobNode);
        loop0: while (atomicReferenceFieldUpdater2.get(jobNode) == jobNode) {
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(jobNode, jobNode, nodeList)) {
                    nodeList.finishAdd(jobNode);
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater2.get(jobNode) == jobNode);
        }
        LockFreeLinkedListNode nextNode = jobNode.getNextNode();
        do {
            atomicReferenceFieldUpdater = _state$volatile$FU;
            if (atomicReferenceFieldUpdater.compareAndSet(this, jobNode, nextNode)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == jobNode);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int iStartInternal;
        do {
            iStartInternal = startInternal(_state$volatile$FU.get(this));
            if (iStartInternal == 0) {
                return false;
            }
        } while (iStartInternal != 1);
        return true;
    }

    public final int startInternal(Object obj) {
        boolean z = obj instanceof Empty;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        if (z) {
            if (((Empty) obj).isActive) {
                return 0;
            }
            Empty empty = JobKt.EMPTY_ACTIVE;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, empty)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            onStart();
            return 1;
        }
        if (!(obj instanceof InactiveNodeList)) {
            return 0;
        }
        NodeList nodeList = ((InactiveNodeList) obj).list;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nodeList)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        onStart();
        return 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameString$kotlinx_coroutines_core() + '{' + stateString(_state$volatile$FU.get(this)) + '}');
        sb.append('@');
        sb.append(JobKt.getHexAddress(this));
        return sb.toString();
    }

    public final Object tryMakeCompleting(Object obj, Object obj2) {
        if (!(obj instanceof Incomplete)) {
            return JobKt.COMPLETING_ALREADY;
        }
        if (((obj instanceof Empty) || (obj instanceof JobNode)) && !(obj instanceof ChildHandleNode) && !(obj2 instanceof CompletedExceptionally)) {
            Incomplete incomplete = (Incomplete) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
            Object incompleteStateBox = obj2 instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, incomplete, incompleteStateBox)) {
                if (atomicReferenceFieldUpdater.get(this) != incomplete) {
                    return JobKt.COMPLETING_RETRY;
                }
            }
            onCompletionInternal(obj2);
            completeStateFinalization(incomplete, obj2);
            return obj2;
        }
        Incomplete incomplete2 = (Incomplete) obj;
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete2);
        if (orPromoteCancellingList == null) {
            return JobKt.COMPLETING_RETRY;
        }
        Finishing finishing = incomplete2 instanceof Finishing ? (Finishing) incomplete2 : null;
        if (finishing == null) {
            finishing = new Finishing(orPromoteCancellingList, null);
        }
        synchronized (finishing) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Finishing._isCompleting$volatile$FU;
            if (atomicIntegerFieldUpdater.get(finishing) == 1) {
                return JobKt.COMPLETING_ALREADY;
            }
            atomicIntegerFieldUpdater.set(finishing, 1);
            if (finishing != incomplete2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, incomplete2, finishing)) {
                    if (atomicReferenceFieldUpdater2.get(this) != incomplete2) {
                        return JobKt.COMPLETING_RETRY;
                    }
                }
            }
            boolean zIsCancelling = finishing.isCancelling();
            CompletedExceptionally completedExceptionally = obj2 instanceof CompletedExceptionally ? (CompletedExceptionally) obj2 : null;
            if (completedExceptionally != null) {
                finishing.addExceptionLocked(completedExceptionally.cause);
            }
            Throwable rootCause = zIsCancelling ? null : finishing.getRootCause();
            Unit unit = Unit.INSTANCE;
            if (rootCause != null) {
                notifyCancelling(orPromoteCancellingList, rootCause);
            }
            ChildHandleNode childHandleNodeNextChild = nextChild(orPromoteCancellingList);
            if (childHandleNodeNextChild != null && tryWaitForChild(finishing, childHandleNodeNextChild, obj2)) {
                return JobKt.COMPLETING_WAITING_CHILDREN;
            }
            orPromoteCancellingList.addLast(new ListClosed(2), 2);
            ChildHandleNode childHandleNodeNextChild2 = nextChild(orPromoteCancellingList);
            return (childHandleNodeNextChild2 == null || !tryWaitForChild(finishing, childHandleNodeNextChild2, obj2)) ? finalizeFinishingState(finishing, obj2) : JobKt.COMPLETING_WAITING_CHILDREN;
        }
    }

    public final boolean tryWaitForChild(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (JobKt.invokeOnCompletion(childHandleNode.childJob, false, new ChildCompletion(this, finishing, childHandleNode, obj)) == NonDisposableHandle.INSTANCE) {
            childHandleNode = nextChild(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ boolean cancel(Throwable th) {
        cancelInternal(th != null ? toCancellationException$default(this, th) : new JobCancellationException(cancellationExceptionMessage(), null, this));
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CameraIdUtil.plus(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1 function1) {
        JobNode invokeOnCompletion;
        if (z) {
            invokeOnCompletion = new InvokeOnCancelling(function1);
        } else {
            invokeOnCompletion = new InvokeOnCompletion(0, function1);
        }
        return invokeOnCompletionInternal$kotlinx_coroutines_core(z2, invokeOnCompletion);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    public void onStart() {
    }

    public void afterCompletion(Object obj) {
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(HttpException httpException) {
        throw httpException;
    }

    public void onCompletionInternal(Object obj) {
    }
}
