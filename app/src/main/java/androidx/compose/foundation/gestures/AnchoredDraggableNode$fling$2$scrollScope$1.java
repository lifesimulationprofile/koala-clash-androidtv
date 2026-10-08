package androidx.compose.foundation.gestures;

import androidx.camera.core.SurfaceRequest;
import androidx.compose.foundation.MutationInterruptedException;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.node.NodeChain;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableNode$fling$2$scrollScope$1 implements ScrollScope {
    public final /* synthetic */ Object $$this$anchoredDrag;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ AnchoredDraggableNode$fling$2$scrollScope$1(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.this$0 = obj;
        this.$$this$anchoredDrag = obj2;
    }

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public final float scrollBy(float f) {
        switch (this.$r8$classId) {
            case 0:
                AnchoredDraggableNode anchoredDraggableNode = (AnchoredDraggableNode) this.this$0;
                float fNewOffsetForDelta$foundation = anchoredDraggableNode.state.newOffsetForDelta$foundation(f);
                float floatValue = fNewOffsetForDelta$foundation - ((ParcelableSnapshotMutableFloatState) anchoredDraggableNode.state.head).getFloatValue();
                ((AnchoredDraggableState$anchoredDragScope$1) this.$$this$anchoredDrag).dragTo(fNewOffsetForDelta$foundation, 0.0f);
                return floatValue;
            case 1:
                ScrollingLogic scrollingLogic = (ScrollingLogic) this.this$0;
                if (Math.abs(f) == 0.0f || ((Boolean) scrollingLogic.isScrollableNodeAttached.invoke()).booleanValue()) {
                    return scrollingLogic.reverseIfNeeded(scrollingLogic.m107toFloatk4lQ0M(((ScrollingLogic$nestedScrollScope$1) this.$$this$anchoredDrag).m110scrollByWithOverscrollOzD1aCk(2, scrollingLogic.m106reverseIfNeededMKHz9U(scrollingLogic.m108toOffsettuRUvjQ(f)))));
                }
                throw new MutationInterruptedException("The fling animation was cancelled", 1);
            default:
                NodeChain nodeChain = (NodeChain) ((SurfaceRequest.AnonymousClass1) this.this$0).val$requestCancellationCompleter;
                float fCoerceIn = RangesKt.coerceIn((Float.isNaN(((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue()) ? 0.0f : ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue()) + f, nodeChain.getAnchors().minPosition(), nodeChain.getAnchors().maxPosition());
                float floatValue2 = fCoerceIn - ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue();
                ((AnchoredDraggableState$anchoredDragScope$1) this.$$this$anchoredDrag).dragTo(fCoerceIn, 0.0f);
                return floatValue2;
        }
    }
}
