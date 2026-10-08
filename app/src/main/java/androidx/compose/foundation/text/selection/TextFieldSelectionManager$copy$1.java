package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.ui.platform.AndroidClipboard;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValueKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager$copy$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $cancelSelection;
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager$copy$1(TextFieldSelectionManager textFieldSelectionManager, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 0;
        this.this$0 = textFieldSelectionManager;
        this.$cancelSelection = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new TextFieldSelectionManager$copy$1((TextFieldSelectionManager) this.this$0, this.$cancelSelection, continuation);
            case 1:
                return new TextFieldSelectionManager$copy$1(this.$cancelSelection, (Function1) this.this$0, continuation, 1);
            default:
                return new TextFieldSelectionManager$copy$1(this.$cancelSelection, (Function1) this.this$0, continuation, 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((TextFieldSelectionManager$copy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AnnotatedString selectedText;
        switch (this.$r8$classId) {
            case 0:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.this$0;
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (TextRange.m641getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection)) {
                        selectedText = null;
                    } else {
                        selectedText = TextFieldValueKt.getSelectedText(textFieldSelectionManager.getValue$foundation());
                        if (this.$cancelSelection) {
                            int iM643getMaximpl = TextRange.m643getMaximpl(textFieldSelectionManager.getValue$foundation().selection);
                            textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m229createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation().annotatedString, ParagraphKt.TextRange(iM643getMaximpl, iM643getMaximpl)));
                            textFieldSelectionManager.setHandleState(HandleState.None);
                        }
                    }
                    if (selectedText == null) {
                        return Unit.INSTANCE;
                    }
                    Clipboard clipboard = textFieldSelectionManager.clipboard;
                    if (clipboard != null) {
                        ClipEntry clipEntry = ClipboardUtils_androidKt.toClipEntry(selectedText);
                        this.label = 1;
                        Unit clipEntry2 = ((AndroidClipboard) clipboard).setClipEntry(clipEntry);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (clipEntry2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$cancelSelection) {
                        Function1 function1 = (Function1) this.this$0;
                        this.label = 1;
                        Object objInvoke = function1.invoke(this);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objInvoke == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$cancelSelection) {
                        Function1 function2 = (Function1) this.this$0;
                        this.label = 1;
                        Object objInvoke2 = function2.invoke(this);
                        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objInvoke2 == coroutineSingletons3) {
                            return coroutineSingletons3;
                        }
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldSelectionManager$copy$1(boolean z, Function1 function1, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$cancelSelection = z;
        this.this$0 = function1;
    }
}
