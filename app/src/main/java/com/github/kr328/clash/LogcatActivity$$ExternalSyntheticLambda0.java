package com.github.kr328.clash;

import com.github.kr328.clash.common.util.ComponentsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LogcatActivity$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LogcatActivity f$0;

    public /* synthetic */ LogcatActivity$$ExternalSyntheticLambda0(LogcatActivity logcatActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = logcatActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        LogcatActivity logcatActivity = this.f$0;
        switch (i) {
            case 0:
                int i2 = LogcatActivity.$r8$clinit;
                logcatActivity.stopService(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogcatService.class)));
                logcatActivity.finish();
                break;
            case 1:
                int i3 = LogcatActivity.$r8$clinit;
                logcatActivity.finish();
                break;
            default:
                int i4 = LogcatActivity.$r8$clinit;
                logcatActivity.finish();
                break;
        }
        return Unit.INSTANCE;
    }
}
