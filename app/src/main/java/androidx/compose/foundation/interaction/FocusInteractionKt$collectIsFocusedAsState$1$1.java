package androidx.compose.foundation.interaction;

import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusInteractionKt$collectIsFocusedAsState$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $isFocused;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MutableInteractionSourceImpl $this_collectIsFocusedAsState;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FocusInteractionKt$collectIsFocusedAsState$1$1(MutableInteractionSourceImpl mutableInteractionSourceImpl, MutableState mutableState, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$this_collectIsFocusedAsState = mutableInteractionSourceImpl;
        this.$isFocused = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new FocusInteractionKt$collectIsFocusedAsState$1$1(this.$this_collectIsFocusedAsState, this.$isFocused, continuation, 0);
            default:
                return new FocusInteractionKt$collectIsFocusedAsState$1$1(this.$this_collectIsFocusedAsState, this.$isFocused, continuation, 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((FocusInteractionKt$collectIsFocusedAsState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                final ArrayList arrayList = new ArrayList();
                SharedFlowImpl sharedFlowImpl = this.$this_collectIsFocusedAsState.interactions;
                final MutableState mutableState = this.$isFocused;
                final int i2 = 0;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.interaction.FocusInteractionKt$collectIsFocusedAsState$1$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation) {
                        switch (i2) {
                            case 0:
                                Interaction interaction = (Interaction) obj2;
                                boolean z = interaction instanceof FocusInteraction$Focus;
                                ArrayList arrayList2 = arrayList;
                                if (z) {
                                    arrayList2.add(interaction);
                                } else if (interaction instanceof FocusInteraction$Unfocus) {
                                    arrayList2.remove(((FocusInteraction$Unfocus) interaction).focus);
                                }
                                mutableState.setValue(Boolean.valueOf(!arrayList2.isEmpty()));
                                break;
                            default:
                                Interaction interaction2 = (Interaction) obj2;
                                boolean z2 = interaction2 instanceof PressInteraction.Press;
                                ArrayList arrayList3 = arrayList;
                                if (z2) {
                                    arrayList3.add(interaction2);
                                } else if (interaction2 instanceof PressInteraction.Release) {
                                    arrayList3.remove(((PressInteraction.Release) interaction2).press);
                                } else if (interaction2 instanceof PressInteraction.Cancel) {
                                    arrayList3.remove(((PressInteraction.Cancel) interaction2).press);
                                }
                                mutableState.setValue(Boolean.valueOf(!arrayList3.isEmpty()));
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                sharedFlowImpl.getClass();
                SharedFlowImpl.collect$suspendImpl(sharedFlowImpl, flowCollector, this);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            default:
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                final ArrayList arrayList2 = new ArrayList();
                SharedFlowImpl sharedFlowImpl2 = this.$this_collectIsFocusedAsState.interactions;
                final MutableState mutableState2 = this.$isFocused;
                final int i4 = 1;
                FlowCollector flowCollector2 = new FlowCollector() { // from class: androidx.compose.foundation.interaction.FocusInteractionKt$collectIsFocusedAsState$1$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation) {
                        switch (i4) {
                            case 0:
                                Interaction interaction = (Interaction) obj2;
                                boolean z = interaction instanceof FocusInteraction$Focus;
                                ArrayList arrayList3 = arrayList2;
                                if (z) {
                                    arrayList3.add(interaction);
                                } else if (interaction instanceof FocusInteraction$Unfocus) {
                                    arrayList3.remove(((FocusInteraction$Unfocus) interaction).focus);
                                }
                                mutableState2.setValue(Boolean.valueOf(!arrayList3.isEmpty()));
                                break;
                            default:
                                Interaction interaction2 = (Interaction) obj2;
                                boolean z2 = interaction2 instanceof PressInteraction.Press;
                                ArrayList arrayList4 = arrayList2;
                                if (z2) {
                                    arrayList4.add(interaction2);
                                } else if (interaction2 instanceof PressInteraction.Release) {
                                    arrayList4.remove(((PressInteraction.Release) interaction2).press);
                                } else if (interaction2 instanceof PressInteraction.Cancel) {
                                    arrayList4.remove(((PressInteraction.Cancel) interaction2).press);
                                }
                                mutableState2.setValue(Boolean.valueOf(!arrayList4.isEmpty()));
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                sharedFlowImpl2.getClass();
                SharedFlowImpl.collect$suspendImpl(sharedFlowImpl2, flowCollector2, this);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }
}
