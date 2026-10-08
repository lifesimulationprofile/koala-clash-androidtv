package androidx.compose.material3.internal;

import androidx.camera.core.SurfaceRequest;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$FloatRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialAnchoredDraggableState$anchoredDrag$3 extends ContinuationImpl {
    public Ref$FloatRef L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SurfaceRequest.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialAnchoredDraggableState$anchoredDrag$3(SurfaceRequest.AnonymousClass1 anonymousClass1, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.anchoredDrag$material3(null, 0.0f, this);
    }
}
