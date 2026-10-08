package androidx.compose.ui.focus;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusOwnerImpl$takeFocus$1 extends Lambda implements Function1 {
    public final /* synthetic */ int $focusDirection;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FocusOwnerImpl$takeFocus$1(int i, int i2) {
        super(1);
        this.$r8$classId = i2;
        this.$focusDirection = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return Boolean.valueOf(((FocusTargetNode) obj).m351requestFocus3ESFkO8(this.$focusDirection));
    }
}
