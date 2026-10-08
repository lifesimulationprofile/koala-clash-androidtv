package com.github.kr328.clash.compose;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.github.kr328.clash.PropertiesActivity;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.common.util.IntentKt;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.util.ClashKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainAppKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ MainAppKt$$ExternalSyntheticLambda1(Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                if (((ActivityResult) obj).resultCode == -1) {
                    ClashKt.startClashService(this.f$0);
                }
                break;
            case 1:
                Intent intent = ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(PropertiesActivity.class));
                IntentKt.setUUID(intent, ((Profile) obj).uuid);
                this.f$0.startActivity(intent);
                break;
            case 2:
                if (((ActivityResult) obj).resultCode == -1) {
                    ClashKt.startClashService(this.f$0);
                }
                break;
            default:
                Intent intent2 = ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(PropertiesActivity.class));
                IntentKt.setUUID(intent2, ((Profile) obj).uuid);
                this.f$0.startActivity(intent2);
                break;
        }
        return Unit.INSTANCE;
    }
}
