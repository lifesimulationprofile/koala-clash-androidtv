package androidx.compose.ui.focus;

import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusableChildrenComparator implements Comparator {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        FocusTargetNode focusTargetNode = (FocusTargetNode) obj;
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) obj2;
        int i = 0;
        if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode) && FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
            LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNode2);
            if (!Intrinsics.areEqual(layoutNodeRequireLayoutNode, layoutNodeRequireLayoutNode2)) {
                Object[] objArr = new LayoutNode[16];
                int i2 = 0;
                while (layoutNodeRequireLayoutNode != null) {
                    int i3 = i2 + 1;
                    if (objArr.length < i3) {
                        int length = objArr.length;
                        Object[] objArr2 = new Object[Math.max(i3, length * 2)];
                        System.arraycopy(objArr, 0, objArr2, 0, length);
                        objArr = objArr2;
                    }
                    if (i2 != 0) {
                        System.arraycopy(objArr, 0, objArr, 0 + 1, i2 + 0);
                    }
                    objArr[0] = layoutNodeRequireLayoutNode;
                    i2++;
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                }
                Object[] objArr3 = new LayoutNode[16];
                int i4 = 0;
                while (layoutNodeRequireLayoutNode2 != null) {
                    int i5 = i4 + 1;
                    if (objArr3.length < i5) {
                        int length2 = objArr3.length;
                        Object[] objArr4 = new Object[Math.max(i5, length2 * 2)];
                        System.arraycopy(objArr3, 0, objArr4, 0, length2);
                        objArr3 = objArr4;
                    }
                    if (i4 != 0) {
                        System.arraycopy(objArr3, 0, objArr3, 0 + 1, i4 + 0);
                    }
                    objArr3[0] = layoutNodeRequireLayoutNode2;
                    i4++;
                    layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                }
                int iMin = Math.min(i2 - 1, i4 - 1);
                if (iMin >= 0) {
                    while (Intrinsics.areEqual(objArr[i], objArr3[i])) {
                        if (i != iMin) {
                            i++;
                        }
                    }
                    return Intrinsics.compare(((LayoutNode) objArr[i]).getPlaceOrder$ui(), ((LayoutNode) objArr3[i]).getPlaceOrder$ui());
                }
                throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.");
            }
        } else {
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode)) {
                return -1;
            }
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
                return 1;
            }
        }
        return 0;
    }
}
