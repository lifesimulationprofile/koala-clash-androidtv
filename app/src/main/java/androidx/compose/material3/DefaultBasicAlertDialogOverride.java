package androidx.compose.material3;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import kotlin.jvm.functions.Function0;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultBasicAlertDialogOverride {
    public static final DefaultBasicAlertDialogOverride INSTANCE = new DefaultBasicAlertDialogOverride();

    public final void BasicAlertDialog(Dispatcher dispatcher, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(1565826668);
        int i2 = (gapComposer.changed(dispatcher) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            AndroidDialog_androidKt.Dialog((Function0) dispatcher.executorServiceOrNull, (DialogProperties) dispatcher.runningAsyncCalls, Thread_jvmKt.rememberComposableLambda(1163527043, new Updater$$ExternalSyntheticLambda0(17, dispatcher), gapComposer), gapComposer, 384);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 13, this, dispatcher);
        }
    }
}
