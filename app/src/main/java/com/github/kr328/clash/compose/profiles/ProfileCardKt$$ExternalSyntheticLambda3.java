package com.github.kr328.clash.compose.profiles;

import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProfileCardKt$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ FocusRequester f$0;

    public /* synthetic */ ProfileCardKt$$ExternalSyntheticLambda3(FocusRequester focusRequester, int i) {
        this.$r8$classId = i;
        this.f$0 = focusRequester;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((FocusProperties) obj).setRight(this.f$0);
                break;
            default:
                ((FocusProperties) obj).setLeft(this.f$0);
                break;
        }
        return Unit.INSTANCE;
    }
}
