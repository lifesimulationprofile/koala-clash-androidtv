package androidx.navigation;

import android.os.Bundle;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import androidx.compose.ui.window.PopupLayout;
import androidx.compose.ui.window.PopupProperties;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavController$executeRestoreState$3 extends Lambda implements Function1 {
    public final /* synthetic */ Object $args;
    public final /* synthetic */ Object $entries;
    public final /* synthetic */ Object $lastNavigatedIndex;
    public final /* synthetic */ Object $navigated;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavController$executeRestoreState$3(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        super(1);
        this.$r8$classId = i;
        this.$navigated = obj;
        this.$entries = obj2;
        this.$lastNavigatedIndex = obj3;
        this.this$0 = obj4;
        this.$args = obj5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        List listSubList;
        switch (this.$r8$classId) {
            case 0:
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                Ref$IntRef ref$IntRef = (Ref$IntRef) this.$lastNavigatedIndex;
                ((Ref$BooleanRef) this.$navigated).element = true;
                ArrayList arrayList = (ArrayList) this.$entries;
                int iIndexOf = arrayList.indexOf(navBackStackEntry);
                if (iIndexOf != -1) {
                    int i = iIndexOf + 1;
                    listSubList = arrayList.subList(ref$IntRef.element, i);
                    ref$IntRef.element = i;
                } else {
                    listSubList = EmptyList.INSTANCE;
                }
                ((NavHostController) this.this$0).addEntryToBackStack(navBackStackEntry.destination, (Bundle) this.$args, navBackStackEntry, listSubList);
                return Unit.INSTANCE;
            default:
                PopupLayout popupLayout = (PopupLayout) this.$navigated;
                popupLayout.windowManager.addView(popupLayout, popupLayout.params);
                popupLayout.updateParameters((Function0) this.$entries, (PopupProperties) this.$lastNavigatedIndex, (String) this.this$0, (LayoutDirection) this.$args);
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(0, popupLayout);
        }
    }
}
