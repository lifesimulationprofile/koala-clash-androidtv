package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.Handshake;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollElement extends ModifierNodeElement {
    public final NestedScrollConnection connection;

    public NestedScrollElement(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new NestedScrollNode(this.connection, null);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof NestedScrollElement) && Intrinsics.areEqual(((NestedScrollElement) obj).connection, this.connection);
    }

    public final int hashCode() {
        return this.connection.hashCode() * 31;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        NestedScrollNode nestedScrollNode = (NestedScrollNode) node;
        nestedScrollNode.connection = this.connection;
        Dispatcher dispatcher = nestedScrollNode.resolvedDispatcher;
        if (((NestedScrollNode) dispatcher.executorServiceOrNull) == nestedScrollNode) {
            dispatcher.executorServiceOrNull = null;
        }
        Dispatcher dispatcher2 = new Dispatcher(8);
        nestedScrollNode.resolvedDispatcher = dispatcher2;
        if (nestedScrollNode.isAttached) {
            dispatcher2.executorServiceOrNull = nestedScrollNode;
            dispatcher2.readyAsyncCalls = null;
            nestedScrollNode.lastKnownParentNode = null;
            dispatcher2.runningAsyncCalls = new Handshake.AnonymousClass2(5, nestedScrollNode);
            dispatcher2.runningSyncCalls = nestedScrollNode.getCoroutineScope();
        }
    }
}
