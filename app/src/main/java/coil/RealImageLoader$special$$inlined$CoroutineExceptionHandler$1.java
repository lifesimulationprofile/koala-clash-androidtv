package coil;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealImageLoader$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public final /* synthetic */ RealImageLoader this$0;

    /* JADX WARN: Illegal instructions before constructor call */
    public RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(RealImageLoader realImageLoader) {
        Job.Key key = Job.Key.$$INSTANCE$1;
        this.this$0 = realImageLoader;
        super(key);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(Throwable th, CoroutineContext coroutineContext) {
        this.this$0.getClass();
    }
}
