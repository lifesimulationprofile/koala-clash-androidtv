package com.github.kr328.clash.compose.profiles;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import com.github.kr328.clash.service.model.Profile;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProfileCardKt$$ExternalSyntheticLambda13 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Profile f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ ProfileCardKt$$ExternalSyntheticLambda13(Profile profile, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = profile;
        this.f$1 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        GapComposer gapComposer = (GapComposer) obj;
        ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                ProfileCardKt.TrafficDaysRow(this.f$0, gapComposer, Stack.updateChangedFlags(this.f$1 | 1));
                break;
            default:
                ProfileCardKt.CardFooter(this.f$0, gapComposer, Stack.updateChangedFlags(this.f$1 | 1));
                break;
        }
        return Unit.INSTANCE;
    }
}
