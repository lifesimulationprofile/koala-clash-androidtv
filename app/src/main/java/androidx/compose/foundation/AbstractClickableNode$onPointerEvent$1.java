package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import coil.RealImageLoader$execute$3;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AbstractClickableNode$onPointerEvent$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AbstractClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractClickableNode$onPointerEvent$1(AbstractClickableNode abstractClickableNode, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = abstractClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new AbstractClickableNode$onPointerEvent$1(this.this$0, continuation, 0);
            default:
                return new AbstractClickableNode$onPointerEvent$1(this.this$0, continuation, 1);
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
        return ((AbstractClickableNode$onPointerEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                AbstractClickableNode abstractClickableNode = this.this$0;
                if (abstractClickableNode.hoverInteraction == null) {
                    HoverInteraction$Enter hoverInteraction$Enter = new HoverInteraction$Enter();
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = abstractClickableNode.interactionSource;
                    if (mutableInteractionSourceImpl != null) {
                        JobKt.launch$default(abstractClickableNode.getCoroutineScope(), null, new RealImageLoader$execute$3(mutableInteractionSourceImpl, hoverInteraction$Enter, null, 2), 3);
                    }
                    abstractClickableNode.hoverInteraction = hoverInteraction$Enter;
                }
                break;
            default:
                ResultKt.throwOnFailure(obj);
                AbstractClickableNode abstractClickableNode2 = this.this$0;
                HoverInteraction$Enter hoverInteraction$Enter2 = abstractClickableNode2.hoverInteraction;
                if (hoverInteraction$Enter2 != null) {
                    HoverInteraction$Exit hoverInteraction$Exit = new HoverInteraction$Exit(hoverInteraction$Enter2);
                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = abstractClickableNode2.interactionSource;
                    Continuation continuation = null;
                    if (mutableInteractionSourceImpl2 != null) {
                        JobKt.launch$default(abstractClickableNode2.getCoroutineScope(), null, new RealImageLoader$execute$3(mutableInteractionSourceImpl2, hoverInteraction$Exit, continuation, 3), 3);
                    }
                    abstractClickableNode2.hoverInteraction = null;
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
