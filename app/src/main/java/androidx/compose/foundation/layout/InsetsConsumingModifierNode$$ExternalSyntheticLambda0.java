package androidx.compose.foundation.layout;

import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InsetsConsumingModifierNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ InsetsConsumingModifierNode f$0;

    public /* synthetic */ InsetsConsumingModifierNode$$ExternalSyntheticLambda0(InsetsConsumingModifierNode insetsConsumingModifierNode, int i) {
        this.$r8$classId = i;
        this.f$0 = insetsConsumingModifierNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TraversableNode traversableNode = (TraversableNode) obj;
        switch (this.$r8$classId) {
            case 0:
                InsetsConsumingModifierNode insetsConsumingModifierNode = (InsetsConsumingModifierNode) traversableNode;
                WindowInsets windowInsets = this.f$0.consumedInsets;
                if (!Intrinsics.areEqual(insetsConsumingModifierNode.ancestorConsumedInsets, windowInsets)) {
                    insetsConsumingModifierNode.ancestorConsumedInsets = windowInsets;
                    insetsConsumingModifierNode.insetsInvalidated();
                }
                return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
            default:
                this.f$0.ancestorConsumedInsets = ((InsetsConsumingModifierNode) traversableNode).consumedInsets;
                return Boolean.FALSE;
        }
    }
}
