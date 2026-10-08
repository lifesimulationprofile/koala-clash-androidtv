package androidx.compose.foundation.selection;

import android.os.Build;
import android.view.autofill.AutofillValue;
import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentDataType$Companion;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ToggleableNode extends ClickableNode {
    public final BasicTextKt$$ExternalSyntheticLambda0 _onClick;
    public Function1 onValueChange;
    public boolean value;

    public ToggleableNode(boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z2, Role role, Function1 function1) {
        super(mutableInteractionSourceImpl, null, false, z2, null, role, new CheckboxKt$$ExternalSyntheticLambda0(function1, z, 1));
        this.value = z;
        this.onValueChange = function1;
        this._onClick = new BasicTextKt$$ExternalSyntheticLambda0(7, this);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public final void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setToggleableState(semanticsPropertyReceiver, this.value ? ToggleableState.On : ToggleableState.Off);
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDataType;
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        KProperty kProperty = kPropertyArr[9];
        semanticsPropertyReceiver.set(semanticsPropertyKey, ContentDataType$Companion.Toggle);
        AndroidFillableData androidFillableData = Build.VERSION.SDK_INT >= 26 ? new AndroidFillableData(AutofillValue.forToggle(this.value)) : null;
        if (androidFillableData != null) {
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.FillableData;
            KProperty kProperty2 = kPropertyArr[10];
            semanticsPropertyReceiver.set(semanticsPropertyKey2, androidFillableData);
        }
        semanticsPropertyReceiver.set(SemanticsActions.OnFillData, new AccessibilityAction(null, new ToggleableNode$$ExternalSyntheticLambda0(semanticsPropertyReceiver, 0)));
    }
}
