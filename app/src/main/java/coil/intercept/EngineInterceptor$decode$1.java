package coil.intercept;

import coil.ComponentRegistry;
import coil.EventListener$Companion$NONE$1;
import coil.fetch.SourceResult;
import coil.request.ImageRequest;
import coil.request.Options;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EngineInterceptor$decode$1 extends ContinuationImpl {
    public int I$0;
    public EngineInterceptor L$0;
    public SourceResult L$1;
    public ComponentRegistry L$2;
    public ImageRequest L$3;
    public Object L$4;
    public Options L$5;
    public EventListener$Companion$NONE$1 L$6;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ EngineInterceptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$decode$1(EngineInterceptor engineInterceptor, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = engineInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EngineInterceptor.access$decode(this.this$0, null, null, null, null, null, null, this);
    }
}
