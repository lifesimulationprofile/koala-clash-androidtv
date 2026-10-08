package androidx.compose.ui.platform;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeViewContext$ProvideCompositionLocals$2 extends Lambda implements Function2 {
    public final /* synthetic */ Function2 $content;
    public final /* synthetic */ AndroidComposeView $owner;
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ ComposeViewContext this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewContext$ProvideCompositionLocals$2(AndroidComposeView androidComposeView, ComposeViewContext composeViewContext, Function2 function2) {
        super(2);
        this.$owner = androidComposeView;
        this.this$0 = composeViewContext;
        this.$content = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.startReplaceGroup(866651995);
                    CompositionLocalsKt.ProvideCommonCompositionLocals(this.$owner, this.this$0.uriHandler, this.$content, gapComposer, 0);
                    gapComposer.end(false);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                ((Number) obj2).intValue();
                this.this$0.ProvideCompositionLocals$ui(this.$owner, this.$content, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewContext$ProvideCompositionLocals$2(ComposeViewContext composeViewContext, AndroidComposeView androidComposeView, Function2 function2, int i) {
        super(2);
        this.this$0 = composeViewContext;
        this.$owner = androidComposeView;
        this.$content = function2;
    }
}
