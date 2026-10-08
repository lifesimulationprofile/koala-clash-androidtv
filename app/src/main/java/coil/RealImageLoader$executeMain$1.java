package coil;

import android.graphics.Bitmap;
import coil.request.BaseRequestDelegate;
import coil.request.ImageRequest;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealImageLoader$executeMain$1 extends ContinuationImpl {
    public RealImageLoader L$0;
    public BaseRequestDelegate L$1;
    public ImageRequest L$2;
    public EventListener$Companion$NONE$1 L$3;
    public Bitmap L$4;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ RealImageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$executeMain$1(RealImageLoader realImageLoader, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = realImageLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RealImageLoader.access$executeMain(this.this$0, null, 0, this);
    }
}
