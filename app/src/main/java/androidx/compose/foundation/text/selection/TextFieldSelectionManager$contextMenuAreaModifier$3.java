package androidx.compose.foundation.text.selection;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager$contextMenuAreaModifier$3 extends SuspendLambda implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldSelectionManager$contextMenuAreaModifier$3(TextFieldSelectionManager textFieldSelectionManager, Continuation continuation, int i) {
        super(1, continuation);
        this.$r8$classId = i;
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Continuation continuation = (Continuation) obj;
        switch (this.$r8$classId) {
            case 0:
                return new TextFieldSelectionManager$contextMenuAreaModifier$3(this.this$0, continuation, 0).invokeSuspend(Unit.INSTANCE);
            case 1:
                return new TextFieldSelectionManager$contextMenuAreaModifier$3(this.this$0, continuation, 1).invokeSuspend(Unit.INSTANCE);
            case 2:
                return new TextFieldSelectionManager$contextMenuAreaModifier$3(this.this$0, continuation, 2).invokeSuspend(Unit.INSTANCE);
            default:
                return new TextFieldSelectionManager$contextMenuAreaModifier$3(this.this$0, continuation, 3).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.this$0.textToolbarShownViaProvider = false;
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                this.this$0.cut$foundation();
                break;
            case 2:
                ResultKt.throwOnFailure(obj);
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.copy$foundation(textFieldSelectionManager.textToolbarShownViaProvider);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                this.this$0.paste$foundation();
                break;
        }
        return Unit.INSTANCE;
    }
}
