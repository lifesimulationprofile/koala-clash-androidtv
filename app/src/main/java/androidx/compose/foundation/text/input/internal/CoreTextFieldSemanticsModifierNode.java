package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.autofill.AutofillValue;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda5;
import androidx.compose.ui.autofill.AndroidContentType;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentDataType$Companion;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import kotlin.Unit;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldSemanticsModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public boolean enabled;
    public FocusRequester focusRequester;
    public ImeOptions imeOptions;
    public TextFieldSelectionManager manager;
    public OffsetMapping offsetMapping;
    public LegacyTextFieldState state;
    public TransformedText transformedText;
    public TextFieldValue value;

    public static void handleTextUpdateFromSemantics(LegacyTextFieldState legacyTextFieldState, String str, boolean z) {
        if (z) {
            TextInputSession textInputSession = legacyTextFieldState.inputSession;
            CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4 = legacyTextFieldState.onValueChange;
            if (textInputSession == null) {
                int length = str.length();
                coreTextFieldKt$$ExternalSyntheticLambda4.invoke(new TextFieldValue(4, ParagraphKt.TextRange(length, length), str));
            } else {
                TextFieldValue textFieldValueApply = legacyTextFieldState.processor.apply(AppCompatHintHelper.listOf(new DeleteAllCommand(), new CommitTextCommand(str, 1)));
                textInputSession.updateState(null, textFieldValueApply);
                coreTextFieldKt$$ExternalSyntheticLambda4.invoke(textFieldValueApply);
            }
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AnnotatedString annotatedString = this.value.annotatedString;
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.InputText;
        KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
        KProperty kProperty = kPropertyArr2[18];
        semanticsPropertyReceiver.set(semanticsPropertyKey, annotatedString);
        AnnotatedString annotatedString2 = this.transformedText.text;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.EditableText;
        KProperty kProperty2 = kPropertyArr2[19];
        semanticsPropertyReceiver.set(semanticsPropertyKey2, annotatedString2);
        long j = this.value.selection;
        SemanticsPropertyKey semanticsPropertyKey3 = SemanticsProperties.TextSelectionRange;
        KProperty kProperty3 = kPropertyArr2[20];
        semanticsPropertyReceiver.set(semanticsPropertyKey3, new TextRange(j));
        SemanticsPropertyKey semanticsPropertyKey4 = SemanticsProperties.ContentDataType;
        KProperty kProperty4 = kPropertyArr2[9];
        semanticsPropertyReceiver.set(semanticsPropertyKey4, ContentDataType$Companion.Text);
        AndroidFillableData androidFillableData = Build.VERSION.SDK_INT >= 26 ? new AndroidFillableData(AutofillValue.forText(this.value.annotatedString)) : null;
        if (androidFillableData != null) {
            SemanticsPropertyKey semanticsPropertyKey5 = SemanticsProperties.FillableData;
            KProperty kProperty5 = kPropertyArr2[10];
            semanticsPropertyReceiver.set(semanticsPropertyKey5, androidFillableData);
        }
        semanticsPropertyReceiver.set(SemanticsActions.OnFillData, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(this, 0)));
        int i = this.imeOptions.keyboardType;
        if (i == 6) {
            ContentType.Companion.getClass();
            AndroidContentType androidContentType = ContentType.Companion.EmailAddress;
            SemanticsPropertyKey semanticsPropertyKey6 = SemanticsProperties.ContentType;
            KProperty kProperty6 = kPropertyArr2[8];
            semanticsPropertyReceiver.set(semanticsPropertyKey6, androidContentType);
        } else if (i == 7 || i == 8) {
            ContentType.Companion.getClass();
            AndroidContentType androidContentType2 = ContentType.Companion.Password;
            SemanticsPropertyKey semanticsPropertyKey7 = SemanticsProperties.ContentType;
            KProperty kProperty7 = kPropertyArr2[8];
            semanticsPropertyReceiver.set(semanticsPropertyKey7, androidContentType2);
        } else if (i == 4) {
            ContentType.Companion.getClass();
            AndroidContentType androidContentType3 = ContentType.Companion.PhoneNumber;
            SemanticsPropertyKey semanticsPropertyKey8 = SemanticsProperties.ContentType;
            KProperty kProperty8 = kPropertyArr2[8];
            semanticsPropertyReceiver.set(semanticsPropertyKey8, androidContentType3);
        }
        if (!this.enabled) {
            semanticsPropertyReceiver.set(SemanticsProperties.Disabled, Unit.INSTANCE);
        }
        boolean z = this.enabled;
        SemanticsPropertyKey semanticsPropertyKey9 = SemanticsProperties.IsEditable;
        KProperty kProperty9 = kPropertyArr2[28];
        semanticsPropertyReceiver.set(semanticsPropertyKey9, Boolean.valueOf(z));
        semanticsPropertyReceiver.set(SemanticsActions.GetTextLayoutResult, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(this, 1)));
        int i2 = 2;
        if (z) {
            semanticsPropertyReceiver.set(SemanticsActions.SetText, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(this, i2)));
            semanticsPropertyReceiver.set(SemanticsActions.InsertTextAtCursor, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(this, semanticsPropertyReceiver)));
        }
        semanticsPropertyReceiver.set(SemanticsActions.SetSelection, new AccessibilityAction(null, new SheetDefaultsKt$$ExternalSyntheticLambda5(i2, this)));
        int i3 = this.imeOptions.imeAction;
        CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0 coreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0 = new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, 6);
        semanticsPropertyReceiver.set(SemanticsProperties.ImeAction, new ImeAction(i3));
        semanticsPropertyReceiver.set(SemanticsActions.OnImeAction, new AccessibilityAction(null, coreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0));
        semanticsPropertyReceiver.set(SemanticsActions.OnClick, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, 7)));
        semanticsPropertyReceiver.set(SemanticsActions.OnLongClick, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, 1)));
        if (!TextRange.m641getCollapsedimpl(this.value.selection)) {
            semanticsPropertyReceiver.set(SemanticsActions.CopyText, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, 2)));
            if (this.enabled) {
                semanticsPropertyReceiver.set(SemanticsActions.CutText, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, 3)));
            }
        }
        if (this.enabled) {
            semanticsPropertyReceiver.set(SemanticsActions.PasteText, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, 5)));
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return true;
    }
}
