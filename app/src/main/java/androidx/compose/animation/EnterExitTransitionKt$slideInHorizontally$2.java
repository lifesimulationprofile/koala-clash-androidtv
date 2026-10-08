package androidx.compose.animation;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionKt$slideInHorizontally$2 extends Lambda implements Function1 {
    public final /* synthetic */ Function1 $initialOffsetX;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EnterExitTransitionKt$slideInHorizontally$2(Function1 function1, int i) {
        super(1);
        this.$r8$classId = i;
        this.$initialOffsetX = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return new IntOffset((((long) ((Number) this.$initialOffsetX.invoke(Integer.valueOf((int) (((IntSize) obj).packedValue >> 32)))).intValue()) << 32) | (((long) 0) & 4294967295L));
            default:
                return new IntOffset((((long) ((Number) this.$initialOffsetX.invoke(Integer.valueOf((int) (((IntSize) obj).packedValue >> 32)))).intValue()) << 32) | (((long) 0) & 4294967295L));
        }
    }
}
