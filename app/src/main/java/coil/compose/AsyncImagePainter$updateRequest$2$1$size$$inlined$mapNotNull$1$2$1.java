package coil.compose;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1$2$1(ConstraintsSizeResolver$size$$inlined$mapNotNull$1$2 constraintsSizeResolver$size$$inlined$mapNotNull$1$2, Continuation continuation) {
        super(continuation);
        this.this$0 = constraintsSizeResolver$size$$inlined$mapNotNull$1$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
