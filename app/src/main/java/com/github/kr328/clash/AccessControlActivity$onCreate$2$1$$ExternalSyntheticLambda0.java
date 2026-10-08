package com.github.kr328.clash;

import android.content.pm.PackageInfo;
import com.github.kr328.clash.design.model.AppInfoSort;
import com.github.kr328.clash.design.store.UiStore;
import com.google.android.gms.tasks.zzr;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccessControlActivity$onCreate$2$1$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AccessControlActivity f$0;

    public /* synthetic */ AccessControlActivity$onCreate$2$1$$ExternalSyntheticLambda0(AccessControlActivity accessControlActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = accessControlActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object value;
        int i = this.$r8$classId;
        int i2 = 1;
        int i3 = 3;
        Continuation continuation = null;
        AccessControlActivity accessControlActivity = this.f$0;
        switch (i) {
            case 0:
                String str = (String) obj;
                Set set = accessControlActivity.selected;
                if (set != null) {
                    if (!set.add(str)) {
                        Set set2 = accessControlActivity.selected;
                        if (set2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("selected");
                            throw null;
                        }
                        set2.remove(str);
                    }
                    StateFlowImpl stateFlowImpl = accessControlActivity.selectionVersion;
                    do {
                        value = stateFlowImpl.getValue();
                    } while (!stateFlowImpl.compareAndSet(value, Integer.valueOf(((Number) value).intValue() + 1)));
                }
                return Unit.INSTANCE;
            case 1:
                AppInfoSort appInfoSort = (AppInfoSort) obj;
                int i4 = AccessControlActivity.$r8$clinit;
                Dispatcher dispatcher = accessControlActivity.getUiStore().accessControlSort$delegate;
                KProperty kProperty = UiStore.$$delegatedProperties[8];
                dispatcher.setValue(appInfoSort);
                StateFlowImpl stateFlowImpl2 = accessControlActivity.sortFlow;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, appInfoSort);
                JobKt.launch$default(accessControlActivity, null, new AccessControlActivity$finish$1$1(accessControlActivity, continuation, i2), 3);
                return Unit.INSTANCE;
            case 2:
                Boolean bool = (Boolean) obj;
                bool.getClass();
                int i5 = AccessControlActivity.$r8$clinit;
                zzr zzrVar = accessControlActivity.getUiStore().accessControlReverse$delegate;
                KProperty kProperty2 = UiStore.$$delegatedProperties[9];
                zzrVar.setValue(bool);
                StateFlowImpl stateFlowImpl3 = accessControlActivity.reverseFlow;
                stateFlowImpl3.getClass();
                stateFlowImpl3.updateState(null, bool);
                JobKt.launch$default(accessControlActivity, null, new AccessControlActivity$finish$1$1(accessControlActivity, continuation, 2), 3);
                return Unit.INSTANCE;
            case 3:
                Boolean bool2 = (Boolean) obj;
                bool2.getClass();
                int i6 = AccessControlActivity.$r8$clinit;
                zzr zzrVar2 = accessControlActivity.getUiStore().accessControlSystemApp$delegate;
                KProperty kProperty3 = UiStore.$$delegatedProperties[10];
                zzrVar2.setValue(bool2);
                StateFlowImpl stateFlowImpl4 = accessControlActivity.systemAppsFlow;
                stateFlowImpl4.getClass();
                stateFlowImpl4.updateState(null, bool2);
                JobKt.launch$default(accessControlActivity, null, new AccessControlActivity$finish$1$1(accessControlActivity, continuation, i3), 3);
                return Unit.INSTANCE;
            default:
                return Boolean.valueOf(!Intrinsics.areEqual(((PackageInfo) obj).packageName, accessControlActivity.getPackageName()));
        }
    }
}
