package androidx.compose.ui.draganddrop;

import androidx.compose.ui.input.pointer.HoverIconModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import coil.memory.MemoryCacheService;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DragAndDropNode$acceptDragAndDropTransfer$1 extends Lambda implements Function1 {
    public final /* synthetic */ Ref$BooleanRef $handled;
    public final /* synthetic */ int $r8$classId = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragAndDropNode$acceptDragAndDropTransfer$1(MemoryCacheService memoryCacheService, DragAndDropNode dragAndDropNode, Ref$BooleanRef ref$BooleanRef) {
        super(1);
        this.$handled = ref$BooleanRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                DragAndDropNode dragAndDropNode = (DragAndDropNode) obj;
                if (!dragAndDropNode.isAttached) {
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
                if (dragAndDropNode.thisDragAndDropTarget != null) {
                    InlineClassHelperKt.throwIllegalStateException("DragAndDropTarget self reference must be null at the start of a drag and drop session");
                }
                dragAndDropNode.thisDragAndDropTarget = null;
                Ref$BooleanRef ref$BooleanRef = this.$handled;
                ref$BooleanRef.element = ref$BooleanRef.element;
                return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
            default:
                if (!((HoverIconModifierNode) obj).cursorInBoundsOfNode) {
                    return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                }
                this.$handled.element = false;
                return TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragAndDropNode$acceptDragAndDropTransfer$1(Ref$BooleanRef ref$BooleanRef) {
        super(1);
        this.$handled = ref$BooleanRef;
    }
}
