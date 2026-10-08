package com.github.kr328.clash.compose;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ManagedActivityResultLauncher;
import com.github.kr328.clash.util.ClashKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda15 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ ManagedActivityResultLauncher f$1;

    public /* synthetic */ TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda15(Context context, ManagedActivityResultLauncher managedActivityResultLauncher, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
        this.f$1 = managedActivityResultLauncher;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        switch (this.$r8$classId) {
            case 0:
                Intent intentStartClashService = ClashKt.startClashService(this.f$0);
                if (intentStartClashService != null) {
                    this.f$1.launch(intentStartClashService);
                }
                break;
            default:
                Intent intentStartClashService2 = ClashKt.startClashService(this.f$0);
                if (intentStartClashService2 != null) {
                    this.f$1.launch(intentStartClashService2);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
