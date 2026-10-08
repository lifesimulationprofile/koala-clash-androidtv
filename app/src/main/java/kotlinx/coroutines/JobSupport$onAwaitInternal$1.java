package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class JobSupport$onAwaitInternal$1 extends FunctionReferenceImpl implements Function3 {
    public static final JobSupport$onAwaitInternal$1 INSTANCE = new JobSupport$onAwaitInternal$1(3, JobSupport.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object objUnboxState;
        JobSupport jobSupport = (JobSupport) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport._state$volatile$FU;
        jobSupport.getClass();
        do {
            objUnboxState = JobSupport._state$volatile$FU.get(jobSupport);
            if (!(objUnboxState instanceof Incomplete)) {
                if (!(objUnboxState instanceof CompletedExceptionally)) {
                    objUnboxState = JobKt.unboxState(objUnboxState);
                }
                ((SelectImplementation) selectInstance).internalResult = objUnboxState;
            }
            return Unit.INSTANCE;
        } while (jobSupport.startInternal(objUnboxState) < 0);
        ((SelectImplementation) selectInstance).disposableHandleOrSegment = JobKt.invokeOnCompletion(jobSupport, true, new JobSupport.SelectOnJoinCompletionHandler(jobSupport, selectInstance, 1));
        return Unit.INSTANCE;
    }
}
