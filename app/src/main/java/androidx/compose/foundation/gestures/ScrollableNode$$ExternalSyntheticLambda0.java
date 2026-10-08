package androidx.compose.foundation.gestures;

import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScrollableNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ScrollableNode f$0;

    public /* synthetic */ ScrollableNode$$ExternalSyntheticLambda0(ScrollableNode scrollableNode, int i) {
        this.$r8$classId = i;
        this.f$0 = scrollableNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return Boolean.valueOf(this.f$0.isAttached);
            default:
                FocusTargetNode focusTargetNode = this.f$0.focusTargetModifierNode;
                if (!focusTargetNode.node.isAttached) {
                    return null;
                }
                FocusStateImpl focusState = focusTargetNode.getFocusState();
                if (!focusState.getHasFocus()) {
                    return null;
                }
                if (focusState.isFocused()) {
                    return focusTargetNode.fetchFocusRect$ui(null);
                }
                FocusTargetNode activeFocusTargetNode = ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).getActiveFocusTargetNode();
                if (activeFocusTargetNode != null) {
                    return activeFocusTargetNode.fetchFocusRect$ui(HitTestResultKt.requireLayoutCoordinates(focusTargetNode));
                }
                return null;
        }
    }
}
