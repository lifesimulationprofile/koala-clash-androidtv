package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.ContextMenu_androidKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionContainerKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ SelectionManager f$0;
    public final /* synthetic */ SelectionRegistrarImpl f$1;
    public final /* synthetic */ ComposableLambdaImpl f$2;

    public /* synthetic */ SelectionContainerKt$$ExternalSyntheticLambda4(SelectionManager selectionManager, SelectionRegistrarImpl selectionRegistrarImpl, ComposableLambdaImpl composableLambdaImpl) {
        this.f$0 = selectionManager;
        this.f$1 = selectionRegistrarImpl;
        this.f$2 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    SelectionRegistrarImpl selectionRegistrarImpl = this.f$1;
                    ComposableLambdaImpl composableLambdaImpl = this.f$2;
                    SelectionManager selectionManager = this.f$0;
                    BasicTextKt.ContextMenuArea(selectionManager, Thread_jvmKt.rememberComposableLambda(-284825865, new SelectionContainerKt$$ExternalSyntheticLambda4(selectionRegistrarImpl, composableLambdaImpl, selectionManager), gapComposer), gapComposer, 48);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    Stack.CompositionLocalProvider(SelectionRegistrarKt.LocalSelectionRegistrar.defaultProvidedValue$runtime(this.f$1), Thread_jvmKt.rememberComposableLambda(610483127, new ContextMenu_androidKt$$ExternalSyntheticLambda0(this.f$2, this.f$0), gapComposer), gapComposer, 56);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ SelectionContainerKt$$ExternalSyntheticLambda4(SelectionRegistrarImpl selectionRegistrarImpl, ComposableLambdaImpl composableLambdaImpl, SelectionManager selectionManager) {
        this.f$1 = selectionRegistrarImpl;
        this.f$2 = composableLambdaImpl;
        this.f$0 = selectionManager;
    }
}
