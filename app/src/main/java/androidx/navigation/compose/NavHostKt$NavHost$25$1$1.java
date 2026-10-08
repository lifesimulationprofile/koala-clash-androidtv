package androidx.navigation.compose;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.gestures.AnchoredDragFinishedSignal;
import androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ProduceStateScopeImpl;
import androidx.compose.runtime.Recomposer$join$2;
import com.github.kr328.clash.FilesActivity$showError$1;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostKt$NavHost$25$1$1 implements FlowCollector {
    public final Object $currentBackStack$delegate;
    public final Object $inPredictiveBack$delegate;
    public final Object $progress$delegate;
    public final /* synthetic */ int $r8$classId;

    public NavHostKt$NavHost$25$1$1(ProduceStateScopeImpl produceStateScopeImpl, Transition transition, MutableState mutableState) {
        this.$r8$classId = 1;
        this.$inPredictiveBack$delegate = produceStateScopeImpl;
        this.$progress$delegate = transition;
        this.$currentBackStack$delegate = mutableState;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    /* JADX WARN: Code duplicated, block: B:37:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        AnchoredDraggableKt$restartable$2$1$emit$1 anchoredDraggableKt$restartable$2$1$emit$1;
        FlowKt__LimitKt$dropWhile$1$1$emit$1 flowKt__LimitKt$dropWhile$1$1$emit$1;
        NavHostKt$NavHost$25$1$1 navHostKt$NavHost$25$1$1;
        FlowCollector flowCollector;
        switch (this.$r8$classId) {
            case 0:
                BackEventCompat backEventCompat = (BackEventCompat) obj;
                if (((List) ((MutableState) this.$currentBackStack$delegate).getValue()).size() > 1) {
                    ((MutableState) this.$inPredictiveBack$delegate).setValue(Boolean.TRUE);
                    ((ParcelableSnapshotMutableFloatState) this.$progress$delegate).setFloatValue(backEventCompat.progress);
                }
                return Unit.INSTANCE;
            case 1:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                Transition transition = (Transition) this.$progress$delegate;
                ((ProduceStateScopeImpl) this.$inPredictiveBack$delegate).setValue(Boolean.valueOf(zBooleanValue ? ((Boolean) ((Function2) ((MutableState) this.$currentBackStack$delegate).getValue()).invoke(transition.transitionState.mo773getCurrentState(), transition.targetState$delegate.getValue())).booleanValue() : false));
                return Unit.INSTANCE;
            case 2:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.$currentBackStack$delegate;
                if (continuation instanceof AnchoredDraggableKt$restartable$2$1$emit$1) {
                    anchoredDraggableKt$restartable$2$1$emit$1 = (AnchoredDraggableKt$restartable$2$1$emit$1) continuation;
                    int i = anchoredDraggableKt$restartable$2$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        anchoredDraggableKt$restartable$2$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        anchoredDraggableKt$restartable$2$1$emit$1 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, continuation);
                    }
                } else {
                    anchoredDraggableKt$restartable$2$1$emit$1 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, continuation);
                }
                Object obj2 = anchoredDraggableKt$restartable$2$1$emit$1.result;
                int i2 = anchoredDraggableKt$restartable$2$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    Job job = (Job) ref$ObjectRef.element;
                    if (job != null) {
                        job.cancel(new AnchoredDragFinishedSignal());
                        anchoredDraggableKt$restartable$2$1$emit$1.L$0 = obj;
                        anchoredDraggableKt$restartable$2$1$emit$1.L$1 = job;
                        anchoredDraggableKt$restartable$2$1$emit$1.label = 1;
                        Object objJoin = job.join(anchoredDraggableKt$restartable$2$1$emit$1);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objJoin == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj = anchoredDraggableKt$restartable$2$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                CoroutineScope coroutineScope = (CoroutineScope) this.$inPredictiveBack$delegate;
                ref$ObjectRef.element = JobKt.launch$default(coroutineScope, null, new NavHostKt$NavHost$28$1((Function2) this.$progress$delegate, obj, coroutineScope, null, 5), 1);
                return Unit.INSTANCE;
            case 3:
                if (continuation instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) {
                    flowKt__LimitKt$dropWhile$1$1$emit$1 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) continuation;
                    int i3 = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        flowKt__LimitKt$dropWhile$1$1$emit$1.label = i3 - Integer.MIN_VALUE;
                    } else {
                        flowKt__LimitKt$dropWhile$1$1$emit$1 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, continuation);
                    }
                } else {
                    flowKt__LimitKt$dropWhile$1$1$emit$1 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, continuation);
                }
                Object objInvoke = flowKt__LimitKt$dropWhile$1$1$emit$1.result;
                int i4 = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 == 2) {
                            obj = flowKt__LimitKt$dropWhile$1$1$emit$1.L$1;
                            navHostKt$NavHost$25$1$1 = flowKt__LimitKt$dropWhile$1$1$emit$1.L$0;
                            ResultKt.throwOnFailure(objInvoke);
                            if (!((Boolean) objInvoke).booleanValue()) {
                                ((Ref$BooleanRef) navHostKt$NavHost$25$1$1.$currentBackStack$delegate).element = true;
                                flowCollector = (FlowCollector) navHostKt$NavHost$25$1$1.$inPredictiveBack$delegate;
                                flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = null;
                                flowKt__LimitKt$dropWhile$1$1$emit$1.L$1 = null;
                                flowKt__LimitKt$dropWhile$1$1$emit$1.label = 3;
                                if (flowCollector.emit(obj, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutineSingletons2) {
                                    return coroutineSingletons2;
                                }
                            }
                        } else if (i4 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                    ResultKt.throwOnFailure(objInvoke);
                } else {
                    ResultKt.throwOnFailure(objInvoke);
                    if (((Ref$BooleanRef) this.$currentBackStack$delegate).element) {
                        FlowCollector flowCollector2 = (FlowCollector) this.$inPredictiveBack$delegate;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.label = 1;
                        if (flowCollector2.emit(obj, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        Recomposer$join$2 recomposer$join$2 = (Recomposer$join$2) this.$progress$delegate;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = this;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.L$1 = obj;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.label = 2;
                        objInvoke = recomposer$join$2.invoke(obj, flowKt__LimitKt$dropWhile$1$1$emit$1);
                        if (objInvoke == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                        navHostKt$NavHost$25$1$1 = this;
                        if (!((Boolean) objInvoke).booleanValue()) {
                            ((Ref$BooleanRef) navHostKt$NavHost$25$1$1.$currentBackStack$delegate).element = true;
                            flowCollector = (FlowCollector) navHostKt$NavHost$25$1$1.$inPredictiveBack$delegate;
                            flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = null;
                            flowKt__LimitKt$dropWhile$1$1$emit$1.L$1 = null;
                            flowKt__LimitKt$dropWhile$1$1$emit$1.label = 3;
                            if (flowCollector.emit(obj, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            default:
                Object objWithContextUndispatched = ChannelFlowKt.withContextUndispatched((CoroutineContext) this.$currentBackStack$delegate, obj, this.$inPredictiveBack$delegate, (FilesActivity$showError$1) this.$progress$delegate, continuation);
                return objWithContextUndispatched == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContextUndispatched : Unit.INSTANCE;
        }
    }

    public /* synthetic */ NavHostKt$NavHost$25$1$1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.$currentBackStack$delegate = obj;
        this.$inPredictiveBack$delegate = obj2;
        this.$progress$delegate = obj3;
    }

    public NavHostKt$NavHost$25$1$1(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        this.$r8$classId = 4;
        this.$currentBackStack$delegate = coroutineContext;
        this.$inPredictiveBack$delegate = coroutineContext.fold(0, InlineList.countAll);
        this.$progress$delegate = new FilesActivity$showError$1(flowCollector, null, 22);
    }
}
