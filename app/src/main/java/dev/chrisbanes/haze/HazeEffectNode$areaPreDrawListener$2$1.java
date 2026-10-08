package dev.chrisbanes.haze;

import androidx.compose.ui.node.HitTestResultKt;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HazeEffectNode$areaPreDrawListener$2$1 implements FunctionAdapter {
    public final /* synthetic */ HazeEffectNode $tmp0;

    public HazeEffectNode$areaPreDrawListener$2$1(HazeEffectNode hazeEffectNode) {
        this.$tmp0 = hazeEffectNode;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof HazeEffectNode$areaPreDrawListener$2$1) && (obj instanceof FunctionAdapter)) {
            return getFunctionDelegate().equals(((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return new FunctionReferenceImpl(0, this.$tmp0, HitTestResultKt.class, "invalidateDraw", "invalidateDraw(Landroidx/compose/ui/node/DrawModifierNode;)V", 1, 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
