package androidx.activity.compose;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.compose.material3.SheetValue;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.fragment.app.FragmentManager$1;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import com.github.kr328.clash.AccessControlActivity;
import com.github.kr328.clash.design.compose.components.LiquidGlassNavItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BackHandlerKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ BackHandlerKt$$ExternalSyntheticLambda1(int i, Object obj, boolean z) {
        this.$r8$classId = i;
        this.f$1 = z;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0057  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        boolean z = false;
        z = false;
        boolean zBooleanValue = true;
        zBooleanValue = true;
        Object obj2 = this.f$0;
        boolean z2 = this.f$1;
        switch (i) {
            case 0:
                ComposeBackHandler composeBackHandler = (ComposeBackHandler) obj2;
                ((FragmentManager$1) composeBackHandler.mContext).setEnabled(z2);
                ((BackHandlerCompat$navigationEventHandler$1) composeBackHandler.mMenuItems).setBackEnabled(z2);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1((LifecycleStartStopEffectScope) obj, composeBackHandler, z ? 1 : 0);
            case 1:
                ComposePredictiveBackHandler composePredictiveBackHandler = (ComposePredictiveBackHandler) obj2;
                composePredictiveBackHandler.setBackEnabled(z2);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1((LifecycleStartStopEffectScope) obj, composePredictiveBackHandler, zBooleanValue ? 1 : 0);
            case 2:
                AccessControlActivity accessControlActivity = (AccessControlActivity) obj2;
                PackageInfo packageInfo = (PackageInfo) obj;
                if (z2) {
                    z = true;
                } else {
                    int i2 = AccessControlActivity.$r8$clinit;
                    accessControlActivity.getClass();
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if (applicationInfo != null && (applicationInfo.flags & 1) == 0) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            case 3:
                MutableState mutableState = (MutableState) obj2;
                SheetValue sheetValue = (SheetValue) obj;
                if (z2 && sheetValue == SheetValue.Hidden) {
                    zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            default:
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                SemanticsPropertiesKt.m616setRolekuIjeqM(semanticsPropertyReceiver, 4);
                SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.Selected;
                KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[23];
                semanticsPropertyReceiver.set(semanticsPropertyKey, Boolean.valueOf(z2));
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, ((LiquidGlassNavItem) obj2).label);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ BackHandlerKt$$ExternalSyntheticLambda1(BaseMenuWrapper baseMenuWrapper, boolean z, int i) {
        this.$r8$classId = i;
        this.f$0 = baseMenuWrapper;
        this.f$1 = z;
    }
}
