package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1;
import androidx.compose.foundation.lazy.LazyListState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $index;
    public int label;
    public final /* synthetic */ LazyLayoutSemanticsModifierNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, int i, Continuation continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutSemanticsModifierNode;
        this.$index = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2(this.this$0, this.$index, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 = this.this$0.state;
            this.label = 1;
            Object objScrollToItem$default = LazyListState.scrollToItem$default(lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1.$state, this.$index, this);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objScrollToItem$default != obj2) {
                objScrollToItem$default = Unit.INSTANCE;
            }
            if (objScrollToItem$default == obj2) {
                return obj2;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
