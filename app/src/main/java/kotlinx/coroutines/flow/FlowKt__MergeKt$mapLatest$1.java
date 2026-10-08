package kotlinx.coroutines.flow;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.compose.foundation.gestures.AnchoredDraggableNode;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.DragGestureNode;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FlowKt__MergeKt$mapLatest$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object $transform;
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MergeKt$mapLatest$1(DragGestureNode.AnonymousClass1 anonymousClass1, AnchoredDraggableNode anchoredDraggableNode, Continuation continuation) {
        super(3, continuation);
        this.L$1 = anonymousClass1;
        this.$transform = anchoredDraggableNode;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.$r8$classId) {
            case 0:
                FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1((SuspendLambda) this.$transform, (Continuation) obj3);
                flowKt__MergeKt$mapLatest$1.L$0 = (FlowCollector) obj;
                flowKt__MergeKt$mapLatest$1.L$1 = obj2;
                return flowKt__MergeKt$mapLatest$1.invokeSuspend(Unit.INSTANCE);
            default:
                FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$2 = new FlowKt__MergeKt$mapLatest$1((DragGestureNode.AnonymousClass1) this.L$1, (AnchoredDraggableNode) this.$transform, (Continuation) obj3);
                flowKt__MergeKt$mapLatest$2.L$0 = (AnchoredDraggableState$anchoredDragScope$1) obj;
                return flowKt__MergeKt$mapLatest$2.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i != 0) {
                    if (i == 1) {
                        flowCollector = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                Object obj2 = this.L$1;
                ?? r4 = (SuspendLambda) this.$transform;
                this.L$0 = flowCollector;
                this.label = 1;
                obj = r4.invoke(obj2, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                this.L$0 = null;
                this.label = 2;
                if (flowCollector.emit(obj, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return Unit.INSTANCE;
            default:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = (AnchoredDraggableState$anchoredDragScope$1) this.L$0;
                    DragGestureNode.AnonymousClass1 anonymousClass1 = (DragGestureNode.AnonymousClass1) this.L$1;
                    BackHandlerKt$$ExternalSyntheticLambda2 backHandlerKt$$ExternalSyntheticLambda2 = new BackHandlerKt$$ExternalSyntheticLambda2(15, (AnchoredDraggableNode) this.$transform, anchoredDraggableState$anchoredDragScope$1);
                    this.label = 1;
                    Object objInvoke = anonymousClass1.invoke(backHandlerKt$$ExternalSyntheticLambda2, this);
                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objInvoke == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$mapLatest$1(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.$transform = (SuspendLambda) function2;
    }
}
