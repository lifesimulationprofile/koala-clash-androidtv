package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.BeyondBoundsLayout$BeyondBoundsScope;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope$record$1;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OneDimensionalFocusSearchKt$generateAndSearchChildren$1 extends Lambda implements Function1 {
    public final /* synthetic */ FocusTargetNode $activeNodeBeforeSearch;
    public final /* synthetic */ int $direction;
    public final /* synthetic */ Object $focusedItem;
    public final /* synthetic */ LayoutNodeDrawScope$record$1 $onFound;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ FocusTargetNode $this_generateAndSearchChildren;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OneDimensionalFocusSearchKt$generateAndSearchChildren$1(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, Object obj, int i, LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1, int i2) {
        super(1);
        this.$r8$classId = i2;
        this.$activeNodeBeforeSearch = focusTargetNode;
        this.$this_generateAndSearchChildren = focusTargetNode2;
        this.$focusedItem = obj;
        this.$direction = i;
        this.$onFound = layoutNodeDrawScope$record$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                BeyondBoundsLayout$BeyondBoundsScope beyondBoundsLayout$BeyondBoundsScope = (BeyondBoundsLayout$BeyondBoundsScope) obj;
                FocusTargetNode focusTargetNode = this.$this_generateAndSearchChildren;
                if (this.$activeNodeBeforeSearch != ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).getActiveFocusTargetNode()) {
                    return Boolean.TRUE;
                }
                boolean zM363searchChildren4C6V_qg = FocusTraversalKt.m363searchChildren4C6V_qg(focusTargetNode, (FocusTargetNode) this.$focusedItem, this.$direction, this.$onFound);
                Boolean boolValueOf = Boolean.valueOf(zM363searchChildren4C6V_qg);
                if (zM363searchChildren4C6V_qg || !beyondBoundsLayout$BeyondBoundsScope.getHasMoreContent()) {
                    return boolValueOf;
                }
                return null;
            default:
                BeyondBoundsLayout$BeyondBoundsScope beyondBoundsLayout$BeyondBoundsScope2 = (BeyondBoundsLayout$BeyondBoundsScope) obj;
                FocusTargetNode focusTargetNode2 = this.$this_generateAndSearchChildren;
                if (this.$activeNodeBeforeSearch != ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode2)).getFocusOwner()).getActiveFocusTargetNode()) {
                    return Boolean.TRUE;
                }
                boolean zM362searchChildren4C6V_qg = FocusTraversalKt.m362searchChildren4C6V_qg(this.$direction, focusTargetNode2, (Rect) this.$focusedItem, this.$onFound);
                Boolean boolValueOf2 = Boolean.valueOf(zM362searchChildren4C6V_qg);
                if (zM362searchChildren4C6V_qg || !beyondBoundsLayout$BeyondBoundsScope2.getHasMoreContent()) {
                    return boolValueOf2;
                }
                return null;
        }
    }
}
