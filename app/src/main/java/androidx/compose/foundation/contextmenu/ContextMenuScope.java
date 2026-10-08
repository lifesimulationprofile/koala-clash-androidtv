package androidx.compose.foundation.contextmenu;

import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContextMenuScope {
    public final SnapshotStateList composables = new SnapshotStateList();

    public static void item$default(ContextMenuScope contextMenuScope, Function2 function2, ComposableLambdaImpl composableLambdaImpl, Function0 function0, int i) {
        if ((i & 8) != 0) {
            composableLambdaImpl = null;
        }
        contextMenuScope.composables.add(new ComposableLambdaImpl(-1789283891, new SnackbarHostKt$$ExternalSyntheticLambda1(function2, contextMenuScope, composableLambdaImpl, function0, 1), true));
    }

    public final void Content$foundation(ContextMenuColors contextMenuColors, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-798501095);
        int i2 = (gapComposer.changed(contextMenuColors) ? 4 : 2) | i | (gapComposer.changed(this) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            SnapshotStateList snapshotStateList = this.composables;
            int size = snapshotStateList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((Function3) snapshotStateList.get(i3)).invoke(contextMenuColors, gapComposer, Integer.valueOf(i2 & 14));
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 2, this, contextMenuColors);
        }
    }
}
