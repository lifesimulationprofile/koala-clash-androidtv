package androidx.compose.material3;

import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IconKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ IconKt$$ExternalSyntheticLambda1(String str, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        String str = this.f$0;
        SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
        switch (i) {
            case 0:
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                SemanticsPropertiesKt.m616setRolekuIjeqM(semanticsPropertyReceiver, 5);
                break;
            case 1:
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                SemanticsPropertiesKt.m616setRolekuIjeqM(semanticsPropertyReceiver, 5);
                break;
            case 2:
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                break;
            case 3:
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
                SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TraversalIndex;
                KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[11];
                semanticsPropertyReceiver.set(semanticsPropertyKey, Float.valueOf(0.0f));
                break;
            case 4:
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
                break;
            case 5:
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.LiveRegion;
                KProperty kProperty2 = SemanticsPropertiesKt.$$delegatedProperties[3];
                semanticsPropertyReceiver.set(semanticsPropertyKey2, new LiveRegionMode(1));
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
                break;
            default:
                KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                semanticsPropertyReceiver.set(SemanticsProperties.Error, str);
                break;
        }
        return Unit.INSTANCE;
    }
}
