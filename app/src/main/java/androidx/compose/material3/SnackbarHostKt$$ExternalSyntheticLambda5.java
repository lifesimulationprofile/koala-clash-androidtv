package androidx.compose.material3;

import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnackbarHostKt$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda5(boolean z, String str, SnackbarHostState.SnackbarDataImpl snackbarDataImpl) {
        this.f$0 = z;
        this.f$1 = str;
        this.f$2 = snackbarDataImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        boolean z = this.f$0;
        switch (i) {
            case 0:
                String str = (String) obj3;
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj2;
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                if (z) {
                    KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                    SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.LiveRegion;
                    KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[3];
                    semanticsPropertyReceiver.set(semanticsPropertyKey, new LiveRegionMode(0));
                }
                SnackbarHostKt$$ExternalSyntheticLambda6 snackbarHostKt$$ExternalSyntheticLambda6 = new SnackbarHostKt$$ExternalSyntheticLambda6(snackbarDataImpl, 0);
                KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                semanticsPropertyReceiver.set(SemanticsActions.Dismiss, new AccessibilityAction(null, snackbarHostKt$$ExternalSyntheticLambda6));
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
                return Unit.INSTANCE;
            default:
                Function0 function0 = (Function0) obj3;
                Function1 function1 = (Function1) obj2;
                SheetValue sheetValue = (SheetValue) obj;
                if (z && sheetValue == SheetValue.PartiallyExpanded) {
                    sheetValue = SheetValue.Expanded;
                }
                return new SheetState(z, function0, sheetValue, function1);
        }
    }

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda5(boolean z, Function0 function0, Function0 function1, Function1 function2) {
        this.f$0 = z;
        this.f$1 = function0;
        this.f$2 = function2;
    }
}
