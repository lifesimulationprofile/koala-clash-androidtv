package com.github.kr328.clash.compose.profiles;

import com.github.kr328.clash.service.model.Profile;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfilesScreenKt$ProfilesScreen$2$1$2$1$2$2$1 implements Function0 {
    public final /* synthetic */ Function1 $onEditProfile;
    public final /* synthetic */ Profile $profile;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ProfilesScreenKt$ProfilesScreen$2$1$2$1$2$2$1(Function1 function1, Profile profile, int i) {
        this.$r8$classId = i;
        this.$onEditProfile = function1;
        this.$profile = profile;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                this.$onEditProfile.invoke(this.$profile);
                break;
            default:
                this.$onEditProfile.invoke(this.$profile);
                break;
        }
        return Unit.INSTANCE;
    }
}
