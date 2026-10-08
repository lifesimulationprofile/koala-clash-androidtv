package coil.intercept;

import coil.request.ImageRequest;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EngineInterceptor$execute$1 extends ContinuationImpl {
    public EngineInterceptor L$0;
    public ImageRequest L$1;
    public Object L$2;
    public Object L$3;
    public Ref$ObjectRef L$4;
    public Ref$ObjectRef L$5;
    public Ref$ObjectRef L$6;
    public Ref$ObjectRef L$7;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ EngineInterceptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$execute$1(EngineInterceptor engineInterceptor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = engineInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EngineInterceptor.access$execute(this.this$0, null, null, null, null, this);
    }
}
