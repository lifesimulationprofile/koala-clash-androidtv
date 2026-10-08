package androidx.compose.material3;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PrecisionPointer_androidKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        new StaticProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(29));
    }

    public static final void EnsurePrecisionPointerListenersRegistered(ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(442516910);
        if (gapComposer.shouldExecute(i & 1, (i & 3) != 2)) {
            gapComposer.startReplaceGroup(1766838549);
            gapComposer.end(false);
            gapComposer.startReplaceGroup(1767392772);
            composableLambdaImpl.invoke((Object) gapComposer, (Object) 6);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FlowLayoutKt$$ExternalSyntheticLambda0(composableLambdaImpl, i, 2);
        }
    }
}
