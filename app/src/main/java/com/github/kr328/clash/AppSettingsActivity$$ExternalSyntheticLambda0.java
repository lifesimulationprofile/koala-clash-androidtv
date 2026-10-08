package com.github.kr328.clash;

import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.store.ServiceStore;
import com.github.kr328.clash.store.AppStore;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppSettingsActivity$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AppSettingsActivity f$0;

    public /* synthetic */ AppSettingsActivity$$ExternalSyntheticLambda0(AppSettingsActivity appSettingsActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = appSettingsActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        AppSettingsActivity appSettingsActivity = this.f$0;
        switch (i) {
            case 0:
                int i2 = AppSettingsActivity.$r8$clinit;
                return new UiStore(appSettingsActivity);
            case 1:
                int i3 = AppSettingsActivity.$r8$clinit;
                return new ServiceStore(appSettingsActivity);
            case 2:
                int i4 = AppSettingsActivity.$r8$clinit;
                return new AppStore(appSettingsActivity);
            default:
                appSettingsActivity.finish();
                return Unit.INSTANCE;
        }
    }
}
