package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.AnchoredDraggableState$$ExternalSyntheticLambda1;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.intercept.EngineInterceptor;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TooltipStateImpl {
    public CancellableContinuationImpl job;
    public final MutatorMutex mutatorMutex;
    public final MutableTransitionState transition = new MutableTransitionState(Boolean.FALSE);

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipStateImpl$show$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends SuspendLambda implements Function1 {
        public final /* synthetic */ Function $cancellableShow;
        public final /* synthetic */ Object $mutatePriority;
        public final /* synthetic */ int $r8$classId;
        public int label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Function function, Continuation continuation, int i) {
            super(1, continuation);
            this.$r8$classId = i;
            this.this$0 = obj;
            this.$mutatePriority = obj2;
            this.$cancellableShow = function;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass2((TooltipStateImpl) this.this$0, (MutatePriority) this.$mutatePriority, (TooltipStateImpl$show$cancellableShow$1) this.$cancellableShow, (Continuation) obj, 0).invokeSuspend(Unit.INSTANCE);
                default:
                    Continuation continuation = (Continuation) obj;
                    return new AnonymousClass2((NodeChain) this.this$0, this.$mutatePriority, (Function4) this.$cancellableShow, continuation, 1).invokeSuspend(Unit.INSTANCE);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    TooltipStateImpl$show$cancellableShow$1 tooltipStateImpl$show$cancellableShow$1 = (TooltipStateImpl$show$cancellableShow$1) this.$cancellableShow;
                    MutatePriority mutatePriority = (MutatePriority) this.$mutatePriority;
                    TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) this.this$0;
                    int i = this.label;
                    MutatePriority mutatePriority2 = MutatePriority.PreventUserInput;
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            MutatePriority mutatePriority3 = MutatePriority.UserInput;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (mutatePriority == mutatePriority3) {
                                this.label = 1;
                                if (tooltipStateImpl$show$cancellableShow$1.invoke(this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            } else {
                                ThumbNode.AnonymousClass1 anonymousClass1 = new ThumbNode.AnonymousClass1(tooltipStateImpl$show$cancellableShow$1, (Continuation) null, 11);
                                this.label = 2;
                                if (JobKt.setupTimeout(new TimeoutCoroutine(1500L, this), anonymousClass1) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                        } else {
                            if (i != 1 && i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        if (mutatePriority != mutatePriority2) {
                            tooltipStateImpl.dismiss();
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        if (mutatePriority != mutatePriority2) {
                            tooltipStateImpl.dismiss();
                        }
                        throw th;
                    }
                default:
                    NodeChain nodeChain = (NodeChain) this.this$0;
                    int i2 = this.label;
                    Object obj2 = this.$mutatePriority;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ((ParcelableSnapshotMutableState) nodeChain.buffer).setValue(obj2);
                        AnchoredDraggableState$$ExternalSyntheticLambda1 anchoredDraggableState$$ExternalSyntheticLambda1 = new AnchoredDraggableState$$ExternalSyntheticLambda1(nodeChain, 2);
                        NavHostKt$NavHost$28$1 navHostKt$NavHost$28$1 = new NavHostKt$NavHost$28$1((Function4) this.$cancellableShow, nodeChain, (Continuation) null, 8);
                        this.label = 1;
                        Object objAccess$restartable = ScrollableKt.access$restartable(anchoredDraggableState$$ExternalSyntheticLambda1, navHostKt$NavHost$28$1, this);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objAccess$restartable == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    if (((Boolean) ((Function1) nodeChain.layoutNode).invoke(obj2)).booleanValue()) {
                        ((AnchoredDraggableState$anchoredDragScope$1) nodeChain.cachedDiffer).dragTo(nodeChain.getAnchors().positionOf(obj2), ((ParcelableSnapshotMutableFloatState) nodeChain.current).getFloatValue());
                        ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).setValue(obj2);
                        nodeChain.setCurrentValue(obj2);
                    }
                    return Unit.INSTANCE;
            }
        }
    }

    public TooltipStateImpl(MutatorMutex mutatorMutex) {
        this.mutatorMutex = mutatorMutex;
    }

    public final void dismiss() {
        this.transition.targetState$delegate.setValue(Boolean.FALSE);
    }

    public final boolean isVisible() {
        MutableTransitionState mutableTransitionState = this.transition;
        return ((Boolean) mutableTransitionState.currentState$delegate.getValue()).booleanValue() || ((Boolean) mutableTransitionState.targetState$delegate.getValue()).booleanValue();
    }

    public final Object show(MutatePriority mutatePriority, SuspendLambda suspendLambda) {
        Continuation continuation = null;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, mutatePriority, new TooltipStateImpl$show$cancellableShow$1(this, continuation, 0), continuation, 0);
        MutatorMutex mutatorMutex = this.mutatorMutex;
        mutatorMutex.getClass();
        Object objCoroutineScope = JobKt.coroutineScope(new EngineInterceptor.AnonymousClass2(mutatePriority, mutatorMutex, anonymousClass2, null), suspendLambda);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }
}
