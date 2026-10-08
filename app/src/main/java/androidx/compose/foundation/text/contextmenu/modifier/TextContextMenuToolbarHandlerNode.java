package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import coil.memory.RealWeakMemoryCache;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuToolbarHandlerNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, TextContextMenuDataProvider {
    public Function1 computeContentBounds;
    public Function1 onHide;
    public SuspendLambda onShow;
    public RealWeakMemoryCache requester;
    public StandaloneCoroutine textToolbarJob;
    public final DerivedSnapshotState derivedData$delegate = Stack.derivedStateOf(new BasicTextKt$$ExternalSyntheticLambda0(14, this));
    public Rect previousContentBounds = Rect.Zero;

    /* JADX WARN: Multi-variable type inference failed */
    public TextContextMenuToolbarHandlerNode(RealWeakMemoryCache realWeakMemoryCache, Function1 function1, Function1 function2, Function1 function3) {
        this.requester = realWeakMemoryCache;
        this.onShow = (SuspendLambda) function1;
        this.onHide = function2;
        this.computeContentBounds = function3;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public final Rect contentBounds(LayoutCoordinates layoutCoordinates) {
        if (!this.isAttached) {
            return this.previousContentBounds;
        }
        Rect rect = (Rect) this.computeContentBounds.invoke(layoutCoordinates);
        if (rect == null) {
            return this.previousContentBounds;
        }
        this.previousContentBounds = rect;
        return rect;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public final TextContextMenuData data() {
        return (TextContextMenuData) this.derivedData$delegate.getValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        RealWeakMemoryCache realWeakMemoryCache = this.requester;
        realWeakMemoryCache.operationsSinceCleanUp = 3;
        realWeakMemoryCache.cache = this;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        RealWeakMemoryCache realWeakMemoryCache = this.requester;
        realWeakMemoryCache.operationsSinceCleanUp = 2;
        realWeakMemoryCache.cache = null;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    /* JADX INFO: renamed from: position-tuRUvjQ */
    public final long mo184positiontuRUvjQ(LayoutCoordinates layoutCoordinates) {
        return contentBounds(layoutCoordinates).m380getTopLeftF1C5BW0();
    }
}
