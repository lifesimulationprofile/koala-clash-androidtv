package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldSemanticsModifier extends ModifierNodeElement {
    public final boolean enabled;
    public final FocusRequester focusRequester;
    public final ImeOptions imeOptions;
    public final TextFieldSelectionManager manager;
    public final OffsetMapping offsetMapping;
    public final LegacyTextFieldState state;
    public final TransformedText transformedText;
    public final TextFieldValue value;

    public CoreTextFieldSemanticsModifier(TransformedText transformedText, TextFieldValue textFieldValue, LegacyTextFieldState legacyTextFieldState, boolean z, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, ImeOptions imeOptions, FocusRequester focusRequester) {
        this.transformedText = transformedText;
        this.value = textFieldValue;
        this.state = legacyTextFieldState;
        this.enabled = z;
        this.offsetMapping = offsetMapping;
        this.manager = textFieldSelectionManager;
        this.imeOptions = imeOptions;
        this.focusRequester = focusRequester;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = new CoreTextFieldSemanticsModifierNode();
        coreTextFieldSemanticsModifierNode.transformedText = this.transformedText;
        coreTextFieldSemanticsModifierNode.value = this.value;
        coreTextFieldSemanticsModifierNode.state = this.state;
        coreTextFieldSemanticsModifierNode.enabled = this.enabled;
        coreTextFieldSemanticsModifierNode.offsetMapping = this.offsetMapping;
        TextFieldSelectionManager textFieldSelectionManager = this.manager;
        coreTextFieldSemanticsModifierNode.manager = textFieldSelectionManager;
        coreTextFieldSemanticsModifierNode.imeOptions = this.imeOptions;
        coreTextFieldSemanticsModifierNode.focusRequester = this.focusRequester;
        textFieldSelectionManager.requestAutofillAction = new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(coreTextFieldSemanticsModifierNode, 4);
        return coreTextFieldSemanticsModifierNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoreTextFieldSemanticsModifier)) {
            return false;
        }
        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier = (CoreTextFieldSemanticsModifier) obj;
        return this.transformedText.equals(coreTextFieldSemanticsModifier.transformedText) && this.value.equals(coreTextFieldSemanticsModifier.value) && this.state.equals(coreTextFieldSemanticsModifier.state) && this.enabled == coreTextFieldSemanticsModifier.enabled && this.offsetMapping.equals(coreTextFieldSemanticsModifier.offsetMapping) && this.manager.equals(coreTextFieldSemanticsModifier.manager) && Intrinsics.areEqual(this.imeOptions, coreTextFieldSemanticsModifier.imeOptions) && Intrinsics.areEqual(this.focusRequester, coreTextFieldSemanticsModifier.focusRequester);
    }

    public final int hashCode() {
        return this.focusRequester.hashCode() + ((this.imeOptions.hashCode() + ((this.manager.hashCode() + ((this.offsetMapping.hashCode() + ((((((((this.state.hashCode() + ((this.value.hashCode() + (this.transformedText.hashCode() * 31)) * 31)) * 31) + 1237) * 31) + (this.enabled ? 1231 : 1237)) * 31) + 1237) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "CoreTextFieldSemanticsModifier(transformedText=" + this.transformedText + ", value=" + this.value + ", state=" + this.state + ", readOnly=false, enabled=" + this.enabled + ", isPassword=false, offsetMapping=" + this.offsetMapping + ", manager=" + this.manager + ", imeOptions=" + this.imeOptions + ", focusRequester=" + this.focusRequester + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = (CoreTextFieldSemanticsModifierNode) node;
        boolean z = coreTextFieldSemanticsModifierNode.enabled;
        ImeOptions imeOptions = coreTextFieldSemanticsModifierNode.imeOptions;
        TextFieldSelectionManager textFieldSelectionManager = coreTextFieldSemanticsModifierNode.manager;
        coreTextFieldSemanticsModifierNode.transformedText = this.transformedText;
        TextFieldValue textFieldValue = this.value;
        coreTextFieldSemanticsModifierNode.value = textFieldValue;
        coreTextFieldSemanticsModifierNode.state = this.state;
        boolean z2 = this.enabled;
        coreTextFieldSemanticsModifierNode.enabled = z2;
        coreTextFieldSemanticsModifierNode.offsetMapping = this.offsetMapping;
        TextFieldSelectionManager textFieldSelectionManager2 = this.manager;
        coreTextFieldSemanticsModifierNode.manager = textFieldSelectionManager2;
        ImeOptions imeOptions2 = this.imeOptions;
        coreTextFieldSemanticsModifierNode.imeOptions = imeOptions2;
        coreTextFieldSemanticsModifierNode.focusRequester = this.focusRequester;
        if (z2 != z || z2 != z || !Intrinsics.areEqual(imeOptions2, imeOptions) || !TextRange.m641getCollapsedimpl(textFieldValue.selection)) {
            HitTestResultKt.invalidateSemantics(coreTextFieldSemanticsModifierNode);
        }
        if (textFieldSelectionManager2.equals(textFieldSelectionManager)) {
            return;
        }
        textFieldSelectionManager2.requestAutofillAction = new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(coreTextFieldSemanticsModifierNode, 0);
    }
}
