package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusRequester {
    public final MutableVector focusRequesterNodes = new MutableVector(new FocusRequesterModifierNode[16]);
    public static final FocusRequester Default = new FocusRequester();
    public static final FocusRequester Cancel = new FocusRequester();
    public static final FocusRequester Redirect = new FocusRequester();

    /* JADX INFO: renamed from: requestFocus-3ESFkO8$default, reason: not valid java name */
    public static void m349requestFocus3ESFkO8$default(FocusRequester focusRequester) {
        focusRequester.getClass();
        if (focusRequester == Default) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
        }
        if (focusRequester == Cancel) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
        }
        MutableVector mutableVector = focusRequester.focusRequesterNodes;
        int i = mutableVector.size;
        if (i == 0) {
            System.out.println((Object) "FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
            return;
        }
        Object[] objArr = mutableVector.content;
        for (int i2 = 0; i2 < i; i2++) {
            Modifier.Node node = (Modifier.Node) ((FocusRequesterModifierNode) objArr[i2]);
            if (!node.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
            }
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
            Modifier.Node node2 = node.node;
            Modifier.Node node3 = node2.child;
            if (node3 == null) {
                HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, node2);
            } else {
                mutableVector2.add(node3);
            }
            while (true) {
                int i3 = mutableVector2.size;
                if (i3 == 0) {
                    break;
                }
                Modifier.Node nodeAccess$pop = (Modifier.Node) mutableVector2.removeAt(i3 - 1);
                if ((nodeAccess$pop.aggregateChildKindSet & 1024) == 0) {
                    HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, nodeAccess$pop);
                } else {
                    while (nodeAccess$pop != null) {
                        if ((nodeAccess$pop.kindSet & 1024) != 0) {
                            MutableVector mutableVector3 = null;
                            while (nodeAccess$pop != null) {
                                if (nodeAccess$pop instanceof FocusTargetNode) {
                                    if (((FocusTargetNode) nodeAccess$pop).m351requestFocus3ESFkO8(7)) {
                                        break;
                                    }
                                } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node node4 = ((DelegatingNode) nodeAccess$pop).delegate; node4 != null; node4 = node4.child) {
                                        if ((node4.kindSet & 1024) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                nodeAccess$pop = node4;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodeAccess$pop != null) {
                                                    mutableVector3.add(nodeAccess$pop);
                                                    nodeAccess$pop = null;
                                                }
                                                mutableVector3.add(node4);
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                nodeAccess$pop = HitTestResultKt.access$pop(mutableVector3);
                            }
                            break;
                        }
                        nodeAccess$pop = nodeAccess$pop.child;
                    }
                }
            }
        }
    }
}
