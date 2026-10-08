package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CoreTextFieldSemanticsModifierNode f$0;

    public /* synthetic */ CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode, int i) {
        this.$r8$classId = i;
        this.f$0 = coreTextFieldSemanticsModifierNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = this.f$0;
        switch (i) {
            case 0:
                HitTestResultKt.requestAutofill(coreTextFieldSemanticsModifierNode);
                return Unit.INSTANCE;
            case 1:
                coreTextFieldSemanticsModifierNode.manager.enterSelectionMode$foundation(true);
                return Boolean.TRUE;
            case 2:
                coreTextFieldSemanticsModifierNode.manager.copy$foundation(true);
                return Boolean.TRUE;
            case 3:
                coreTextFieldSemanticsModifierNode.manager.cut$foundation();
                return Boolean.TRUE;
            case 4:
                HitTestResultKt.requestAutofill(coreTextFieldSemanticsModifierNode);
                return Unit.INSTANCE;
            case 5:
                coreTextFieldSemanticsModifierNode.manager.paste$foundation();
                return Boolean.TRUE;
            case 6:
                CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4 = coreTextFieldSemanticsModifierNode.state.onImeActionPerformed;
                coreTextFieldKt$$ExternalSyntheticLambda4.f$0.keyboardActionRunner.m757runActionKlQnJC8(coreTextFieldSemanticsModifierNode.imeOptions.imeAction);
                Unit unit = Unit.INSTANCE;
                return Boolean.TRUE;
            default:
                LegacyTextFieldState legacyTextFieldState = coreTextFieldSemanticsModifierNode.state;
                FocusRequester focusRequester = coreTextFieldSemanticsModifierNode.focusRequester;
                if (legacyTextFieldState.getHasFocus()) {
                    SoftwareKeyboardController softwareKeyboardController = legacyTextFieldState.keyboardController;
                    if (softwareKeyboardController != null) {
                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController).show();
                    }
                } else {
                    FocusRequester.m349requestFocus3ESFkO8$default(focusRequester);
                }
                return Boolean.TRUE;
        }
    }
}
