package androidx.compose.foundation.selection;

import androidx.compose.material3.internal.ParentSemanticsNode;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ToggleableNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SemanticsPropertyReceiver f$0;

    public /* synthetic */ ToggleableNode$$ExternalSyntheticLambda0(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        this.$r8$classId = i;
        this.f$0 = semanticsPropertyReceiver;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        boolean z;
        boolean z2;
        switch (this.$r8$classId) {
            case 0:
                AndroidFillableData androidFillableData = (AndroidFillableData) obj;
                Boolean boolValueOf = androidFillableData.autofillValue.isToggle() ? Boolean.valueOf(androidFillableData.autofillValue.getToggleValue()) : null;
                if (boolValueOf != null) {
                    SemanticsPropertiesKt.setToggleableState(this.f$0, boolValueOf.booleanValue() ? ToggleableState.On : ToggleableState.Off);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 1:
                AndroidFillableData androidFillableData2 = (AndroidFillableData) obj;
                Boolean boolValueOf2 = androidFillableData2.autofillValue.isToggle() ? Boolean.valueOf(androidFillableData2.autofillValue.getToggleValue()) : null;
                if (boolValueOf2 != null) {
                    SemanticsPropertiesKt.setToggleableState(this.f$0, boolValueOf2.booleanValue() ? ToggleableState.On : ToggleableState.Off);
                    z2 = true;
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            default:
                ParentSemanticsNode parentSemanticsNode = (ParentSemanticsNode) ((TraversableNode) obj);
                parentSemanticsNode.semanticsConsumed = true;
                parentSemanticsNode.properties.invoke(this.f$0);
                HitTestResultKt.invalidateSemantics(parentSemanticsNode);
                return Boolean.FALSE;
        }
    }
}
