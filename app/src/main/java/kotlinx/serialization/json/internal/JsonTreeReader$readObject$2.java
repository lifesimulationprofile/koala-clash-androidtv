package kotlinx.serialization.json.internal;

import coil.memory.RealWeakMemoryCache;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveScopeImpl;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class JsonTreeReader$readObject$2 extends ContinuationImpl {
    public DeepRecursiveScopeImpl L$0;
    public RealWeakMemoryCache L$1;
    public LinkedHashMap L$2;
    public String L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ RealWeakMemoryCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(RealWeakMemoryCache realWeakMemoryCache, BaseContinuationImpl baseContinuationImpl) {
        super(baseContinuationImpl);
        this.this$0 = realWeakMemoryCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RealWeakMemoryCache.access$readObject(this.this$0, null, this);
    }
}
