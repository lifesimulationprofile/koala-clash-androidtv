package androidx.compose.material3;

import android.content.Context;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.platform.AbstractComposeView;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheetDialogLayout extends AbstractComposeView {
    public final ParcelableSnapshotMutableState content$delegate;
    public boolean shouldCreateCompositionOnAttachedToWindow;

    public ModalBottomSheetDialogLayout(Context context) {
        super(context);
        this.content$delegate = Stack.mutableStateOf$default(ScrimKt.f8lambda$91331245);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void Content$1(int i, GapComposer gapComposer) {
        gapComposer.startRestartGroup(576708319);
        int i2 = (gapComposer.changedInstance(this) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            ((Function2) this.content$delegate.getValue()).invoke(gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Updater$$ExternalSyntheticLambda0(i, 19, this);
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }
}
