package androidx.compose.foundation.gestures;

import androidx.navigation.compose.NavHostKt$NavHost$25$1$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableKt$restartable$2$1$emit$1 extends ContinuationImpl {
    public Object L$0;
    public Job L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ NavHostKt$NavHost$25$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableKt$restartable$2$1$emit$1(NavHostKt$NavHost$25$1$1 navHostKt$NavHost$25$1$1, Continuation continuation) {
        super(continuation);
        this.this$0 = navHostKt$NavHost$25$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
