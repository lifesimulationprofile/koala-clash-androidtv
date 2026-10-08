package androidx.compose.foundation.text;

import androidx.compose.foundation.DefaultDebugIndication;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.style.BooleanPredefinedKey;
import androidx.compose.foundation.style.InteractionSet;
import androidx.compose.foundation.style.MutableStyleState;
import androidx.compose.foundation.style.MutableStyleState$processInteractions$2$emit$1;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextInputService;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldKt$CoreTextField$5$1$2 implements FlowCollector {
    public final /* synthetic */ Object $imeOptions;
    public final /* synthetic */ Object $manager;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $state;
    public final /* synthetic */ Object $textInputService;

    public /* synthetic */ CoreTextFieldKt$CoreTextField$5$1$2(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.$state = obj;
        this.$textInputService = obj2;
        this.$manager = obj3;
        this.$imeOptions = obj4;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ChannelFlowTransformLatest$flowCollect$3$1$emit$1 channelFlowTransformLatest$flowCollect$3$1$emit$1;
        CoreTextFieldKt$CoreTextField$5$1$2 coreTextFieldKt$CoreTextField$5$1$2;
        switch (this.$r8$classId) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.$manager;
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.$state;
                if (zBooleanValue && legacyTextFieldState.getHasFocus()) {
                    BasicTextKt.startInputSession((TextInputService) this.$textInputService, legacyTextFieldState, textFieldSelectionManager.getValue$foundation(), (ImeOptions) this.$imeOptions, textFieldSelectionManager.offsetMapping);
                } else {
                    BasicTextKt.endInputSession(legacyTextFieldState);
                }
                return Unit.INSTANCE;
            case 1:
                Interaction interaction = (Interaction) obj;
                Ref$IntRef ref$IntRef = (Ref$IntRef) this.$manager;
                Ref$IntRef ref$IntRef2 = (Ref$IntRef) this.$textInputService;
                Ref$IntRef ref$IntRef3 = (Ref$IntRef) this.$state;
                boolean z = true;
                if (interaction instanceof PressInteraction.Press) {
                    ref$IntRef3.element++;
                } else if ((interaction instanceof PressInteraction.Release) || (interaction instanceof PressInteraction.Cancel)) {
                    ref$IntRef3.element--;
                } else if (interaction instanceof HoverInteraction$Enter) {
                    ref$IntRef2.element++;
                } else if (interaction instanceof HoverInteraction$Exit) {
                    ref$IntRef2.element--;
                } else if (interaction instanceof FocusInteraction$Focus) {
                    ref$IntRef.element++;
                } else if (interaction instanceof FocusInteraction$Unfocus) {
                    ref$IntRef.element--;
                }
                int i = ref$IntRef3.element;
                boolean z2 = false;
                boolean z3 = i > 0;
                boolean z4 = ref$IntRef2.element > 0;
                boolean z5 = ref$IntRef.element > 0;
                DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance = (DefaultDebugIndication.DefaultDebugIndicationInstance) this.$imeOptions;
                if (defaultDebugIndicationInstance.isPressed != z3) {
                    defaultDebugIndicationInstance.isPressed = z3;
                    z2 = true;
                }
                if (defaultDebugIndicationInstance.isHovered != z4) {
                    defaultDebugIndicationInstance.isHovered = z4;
                    z2 = true;
                }
                if (defaultDebugIndicationInstance.isFocused != z5) {
                    defaultDebugIndicationInstance.isFocused = z5;
                } else {
                    z = z2;
                }
                if (z) {
                    HitTestResultKt.invalidateDraw(defaultDebugIndicationInstance);
                }
                return Unit.INSTANCE;
            case 2:
                return emit((Interaction) obj, continuation);
            default:
                if (continuation instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) {
                    channelFlowTransformLatest$flowCollect$3$1$emit$1 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) continuation;
                    int i2 = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.label = i2 - Integer.MIN_VALUE;
                    } else {
                        channelFlowTransformLatest$flowCollect$3$1$emit$1 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, continuation);
                    }
                } else {
                    channelFlowTransformLatest$flowCollect$3$1$emit$1 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, continuation);
                }
                Object obj2 = channelFlowTransformLatest$flowCollect$3$1$emit$1.result;
                int i3 = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    Job job = (Job) ((Ref$ObjectRef) this.$state).element;
                    if (job != null) {
                        job.cancel(new ChildCancelledException("Child of the scoped flow was cancelled", 0));
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0 = this;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.L$1 = obj;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.L$2 = job;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.label = 1;
                        Object objJoin = job.join(channelFlowTransformLatest$flowCollect$3$1$emit$1);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objJoin == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    coreTextFieldKt$CoreTextField$5$1$2 = this;
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj = channelFlowTransformLatest$flowCollect$3$1$emit$1.L$1;
                    coreTextFieldKt$CoreTextField$5$1$2 = channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                ((Ref$ObjectRef) coreTextFieldKt$CoreTextField$5$1$2.$state).element = JobKt.launch$default((CoroutineScope) coreTextFieldKt$CoreTextField$5$1$2.$textInputService, null, new ChannelFlowTransformLatest.AnonymousClass3((ChannelFlowTransformLatest) coreTextFieldKt$CoreTextField$5$1$2.$manager, (FlowCollector) coreTextFieldKt$CoreTextField$5$1$2.$imeOptions, obj, null), 1);
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    public Object emit(Interaction interaction, Continuation continuation) {
        MutableStyleState$processInteractions$2$emit$1 mutableStyleState$processInteractions$2$emit$1;
        Interaction interaction2;
        Iterator it;
        InteractionSet interactionSet = (InteractionSet) this.$imeOptions;
        InteractionSet interactionSet2 = (InteractionSet) this.$manager;
        InteractionSet interactionSet3 = (InteractionSet) this.$state;
        MutableStyleState mutableStyleState = (MutableStyleState) this.$textInputService;
        if (continuation instanceof MutableStyleState$processInteractions$2$emit$1) {
            mutableStyleState$processInteractions$2$emit$1 = (MutableStyleState$processInteractions$2$emit$1) continuation;
            int i = mutableStyleState$processInteractions$2$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                mutableStyleState$processInteractions$2$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                mutableStyleState$processInteractions$2$emit$1 = new MutableStyleState$processInteractions$2$emit$1(this, continuation);
            }
        } else {
            mutableStyleState$processInteractions$2$emit$1 = new MutableStyleState$processInteractions$2$emit$1(this, continuation);
        }
        Object obj = mutableStyleState$processInteractions$2$emit$1.result;
        int i2 = mutableStyleState$processInteractions$2$emit$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (interaction instanceof PressInteraction.Press) {
                interactionSet3.add(interaction);
                mutableStyleState.setPressed(true);
            } else if (interaction instanceof PressInteraction.Release) {
                interactionSet3.remove(((PressInteraction.Release) interaction).press);
                mutableStyleState.setPressed(interactionSet3.setOrValue != null);
            } else if (interaction instanceof PressInteraction.Cancel) {
                interactionSet3.remove(((PressInteraction.Cancel) interaction).press);
                mutableStyleState.setPressed(interactionSet3.setOrValue != null);
            } else if (interaction instanceof HoverInteraction$Enter) {
                interactionSet2.add(interaction);
                mutableStyleState.setHovered(true);
            } else if (interaction instanceof HoverInteraction$Exit) {
                interactionSet2.remove(((HoverInteraction$Exit) interaction).enter);
                mutableStyleState.setHovered(interactionSet2.setOrValue != null);
            } else if (interaction instanceof FocusInteraction$Focus) {
                interactionSet.add(interaction);
                mutableStyleState.setFocused(true);
            } else if (interaction instanceof FocusInteraction$Unfocus) {
                interactionSet.remove(((FocusInteraction$Unfocus) interaction).focus);
                mutableStyleState.setFocused(interactionSet.setOrValue != null);
            } else {
                interaction2 = interaction;
                it = mutableStyleState.customStates.entries.iterator();
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        it = mutableStyleState$processInteractions$2$emit$1.L$2;
        MutableStyleState mutableStyleState2 = mutableStyleState$processInteractions$2$emit$1.L$1;
        Interaction interaction3 = mutableStyleState$processInteractions$2$emit$1.L$0;
        ResultKt.throwOnFailure(obj);
        mutableStyleState = mutableStyleState2;
        interaction2 = interaction3;
        while (it.hasNext()) {
            BooleanPredefinedKey booleanPredefinedKey = (BooleanPredefinedKey) ((Map.Entry) it.next()).getKey();
            mutableStyleState$processInteractions$2$emit$1.L$0 = interaction2;
            mutableStyleState$processInteractions$2$emit$1.L$1 = mutableStyleState;
            mutableStyleState$processInteractions$2$emit$1.L$2 = it;
            mutableStyleState$processInteractions$2$emit$1.label = 1;
            booleanPredefinedKey.getClass();
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (unit == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
