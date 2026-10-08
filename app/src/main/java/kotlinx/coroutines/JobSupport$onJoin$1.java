package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class JobSupport$onJoin$1 extends FunctionReferenceImpl implements Function3 {
    public static final JobSupport$onJoin$1 INSTANCE = new JobSupport$onJoin$1(3, JobSupport.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object obj4;
        JobSupport jobSupport = (JobSupport) obj;
        SelectInstance selectInstance = (SelectInstance) obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport._state$volatile$FU;
        jobSupport.getClass();
        do {
            obj4 = JobSupport._state$volatile$FU.get(jobSupport);
            if (!(obj4 instanceof Incomplete)) {
                ((SelectImplementation) selectInstance).internalResult = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        } while (jobSupport.startInternal(obj4) < 0);
        ((SelectImplementation) selectInstance).disposableHandleOrSegment = JobKt.invokeOnCompletion(jobSupport, true, new JobSupport.SelectOnJoinCompletionHandler(jobSupport, selectInstance, 0));
        return Unit.INSTANCE;
    }
}
