package com.github.kr328.clash;

import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.store.ServiceStore;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NetworkSettingsActivity$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NetworkSettingsActivity f$0;

    public /* synthetic */ NetworkSettingsActivity$$ExternalSyntheticLambda0(NetworkSettingsActivity networkSettingsActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = networkSettingsActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        NetworkSettingsActivity networkSettingsActivity = this.f$0;
        switch (i) {
            case 0:
                int i2 = NetworkSettingsActivity.$r8$clinit;
                return new UiStore(networkSettingsActivity);
            case 1:
                int i3 = NetworkSettingsActivity.$r8$clinit;
                return new ServiceStore(networkSettingsActivity);
            case 2:
                networkSettingsActivity.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(AccessControlActivity.class)));
                return Unit.INSTANCE;
            default:
                networkSettingsActivity.finish();
                return Unit.INSTANCE;
        }
    }
}
