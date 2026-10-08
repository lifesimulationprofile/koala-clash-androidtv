package com.github.kr328.clash.compose;

import android.content.Context;
import com.github.kr328.clash.AppSettingsActivity;
import com.github.kr328.clash.ConnectionsActivity;
import com.github.kr328.clash.LogcatActivity;
import com.github.kr328.clash.LogcatService;
import com.github.kr328.clash.LogsActivity;
import com.github.kr328.clash.NetworkSettingsActivity;
import com.github.kr328.clash.ProvidersActivity;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.util.ClashKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(AppSettingsActivity.class)));
                break;
            case 1:
                ClashKt.stopClashService(this.f$0);
                break;
            case 2:
                this.f$0.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(AppSettingsActivity.class)));
                break;
            case 3:
                this.f$0.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(NetworkSettingsActivity.class)));
                break;
            case 4:
                this.f$0.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(ConnectionsActivity.class)));
                break;
            case 5:
                boolean z = LogcatService.running;
                Context context = this.f$0;
                if (z) {
                    context.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogcatActivity.class)));
                } else {
                    context.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogsActivity.class)));
                }
                break;
            case 6:
                this.f$0.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(ProvidersActivity.class)));
                break;
            case 7:
                ClashKt.stopClashService(this.f$0);
                break;
            case 8:
                this.f$0.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(NetworkSettingsActivity.class)));
                break;
            case 9:
                this.f$0.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(ConnectionsActivity.class)));
                break;
            case 10:
                boolean z2 = LogcatService.running;
                Context context2 = this.f$0;
                if (z2) {
                    context2.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogcatActivity.class)));
                } else {
                    context2.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogsActivity.class)));
                }
                break;
            default:
                this.f$0.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(ProvidersActivity.class)));
                break;
        }
        return Unit.INSTANCE;
    }
}
