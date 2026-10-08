package androidx.navigation;

import android.os.Bundle;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.pointer.HoverIconModifierNode;
import androidx.compose.ui.node.TraversableNode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavGraphNavigator$navigate$missingRequiredArgs$1 extends Lambda implements Function1 {
    public final /* synthetic */ Ref$ObjectRef $args;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavGraphNavigator$navigate$missingRequiredArgs$1(Ref$ObjectRef ref$ObjectRef, int i) {
        super(1);
        this.$r8$classId = i;
        this.$args = ref$ObjectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        switch (this.$r8$classId) {
            case 0:
                String str = (String) obj;
                Object obj2 = this.$args.element;
                boolean z2 = true;
                if (obj2 != null && ((Bundle) obj2).containsKey(str)) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            case 1:
                Object obj3 = (TraversableNode) obj;
                if (((Modifier.Node) obj3).node.isAttached) {
                    this.$args.element = obj3;
                    z = false;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                HoverIconModifierNode hoverIconModifierNode = (HoverIconModifierNode) obj;
                Ref$ObjectRef ref$ObjectRef = this.$args;
                Object obj4 = ref$ObjectRef.element;
                if (obj4 == null && hoverIconModifierNode.cursorInBoundsOfNode) {
                    ref$ObjectRef.element = hoverIconModifierNode;
                } else if (obj4 != null) {
                    hoverIconModifierNode.getClass();
                }
                return Boolean.TRUE;
            default:
                this.$args.element = (FocusTargetNode) obj;
                return Boolean.TRUE;
        }
    }
}
