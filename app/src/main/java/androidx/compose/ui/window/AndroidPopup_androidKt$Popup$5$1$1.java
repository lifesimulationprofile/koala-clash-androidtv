package androidx.compose.ui.window;

import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPopup_androidKt$Popup$5$1$1 extends Lambda implements Function1 {
    public static final AndroidPopup_androidKt$Popup$5$1$1 INSTANCE;
    public static final AndroidPopup_androidKt$Popup$5$1$1 INSTANCE$1;
    public static final AndroidPopup_androidKt$Popup$5$1$1 INSTANCE$2;
    public static final AndroidPopup_androidKt$Popup$5$1$1 INSTANCE$3;
    public static final AndroidPopup_androidKt$Popup$5$1$1 INSTANCE$4;
    public static final AndroidPopup_androidKt$Popup$5$1$1 INSTANCE$5;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 1;
        INSTANCE$1 = new AndroidPopup_androidKt$Popup$5$1$1(i, 1);
        INSTANCE = new AndroidPopup_androidKt$Popup$5$1$1(i, 0);
        INSTANCE$2 = new AndroidPopup_androidKt$Popup$5$1$1(i, 2);
        INSTANCE$3 = new AndroidPopup_androidKt$Popup$5$1$1(i, 3);
        INSTANCE$4 = new AndroidPopup_androidKt$Popup$5$1$1(i, 4);
        INSTANCE$5 = new AndroidPopup_androidKt$Popup$5$1$1(i, 5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidPopup_androidKt$Popup$5$1$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((Number) obj).longValue();
                return Unit.INSTANCE;
            case 1:
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.IsDialog;
                Unit unit = Unit.INSTANCE;
                ((SemanticsPropertyReceiver) obj).set(semanticsPropertyKey, unit);
                return unit;
            case 2:
                return Unit.INSTANCE;
            case 3:
                KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.IsPopup;
                Unit unit2 = Unit.INSTANCE;
                ((SemanticsPropertyReceiver) obj).set(semanticsPropertyKey2, unit2);
                return unit2;
            case 4:
                return Unit.INSTANCE;
            default:
                PopupLayout popupLayout = (PopupLayout) obj;
                if (popupLayout.isAttachedToWindow()) {
                    popupLayout.updatePosition();
                }
                return Unit.INSTANCE;
        }
    }
}
