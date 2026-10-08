package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import coil.memory.RealWeakMemoryCache;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class TextContextMenuToolbarHandlerElement extends ModifierNodeElement {
    public final Function1 computeContentBounds;
    public final Function1 onHide;
    public final SuspendLambda onShow;
    public final RealWeakMemoryCache requester;

    /* JADX WARN: Multi-variable type inference failed */
    public TextContextMenuToolbarHandlerElement(RealWeakMemoryCache realWeakMemoryCache, Function1 function1, Function1 function2, Function1 function3) {
        this.requester = realWeakMemoryCache;
        this.onShow = (SuspendLambda) function1;
        this.onHide = function2;
        this.computeContentBounds = function3;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new TextContextMenuToolbarHandlerNode(this.requester, this.onShow, this.onHide, this.computeContentBounds);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextContextMenuToolbarHandlerElement)) {
            return false;
        }
        TextContextMenuToolbarHandlerElement textContextMenuToolbarHandlerElement = (TextContextMenuToolbarHandlerElement) obj;
        return this.requester == textContextMenuToolbarHandlerElement.requester && this.onShow == textContextMenuToolbarHandlerElement.onShow && this.onHide == textContextMenuToolbarHandlerElement.onHide && this.computeContentBounds == textContextMenuToolbarHandlerElement.computeContentBounds;
    }

    public final int hashCode() {
        int iHashCode = (this.onShow.hashCode() + (this.requester.hashCode() * 31)) * 31;
        Function1 function1 = this.onHide;
        return this.computeContentBounds.hashCode() + ((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode = (TextContextMenuToolbarHandlerNode) node;
        textContextMenuToolbarHandlerNode.requester.cache = null;
        RealWeakMemoryCache realWeakMemoryCache = this.requester;
        textContextMenuToolbarHandlerNode.requester = realWeakMemoryCache;
        realWeakMemoryCache.cache = textContextMenuToolbarHandlerNode;
        realWeakMemoryCache.operationsSinceCleanUp = textContextMenuToolbarHandlerNode.isAttached ? 3 : 2;
        textContextMenuToolbarHandlerNode.onShow = this.onShow;
        textContextMenuToolbarHandlerNode.onHide = this.onHide;
        textContextMenuToolbarHandlerNode.computeContentBounds = this.computeContentBounds;
    }
}
