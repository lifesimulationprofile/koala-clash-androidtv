package com.github.kr328.clash.compose;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.github.kr328.clash.compose.profiles.ProfileCardKt;
import com.github.kr328.clash.service.model.Profile;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PropertiesScreenKt$$ExternalSyntheticLambda9 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Profile f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Function f$3;
    public final /* synthetic */ Function0 f$4;
    public final /* synthetic */ Function0 f$5;
    public final /* synthetic */ Function0 f$6;
    public final /* synthetic */ Modifier f$7;

    public /* synthetic */ PropertiesScreenKt$$ExternalSyntheticLambda9(Profile profile, boolean z, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Modifier modifier, boolean z2, int i) {
        this.f$0 = profile;
        this.f$1 = z;
        this.f$4 = function0;
        this.f$5 = function1;
        this.f$6 = function2;
        this.f$3 = function3;
        this.f$7 = modifier;
        this.f$2 = z2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(3073);
                PropertiesScreenKt.PropertiesScreen(this.f$0, this.f$1, this.f$2, (Function1) this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (GapComposer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                ProfileCardKt.ProfileCard(this.f$0, this.f$1, this.f$4, this.f$5, this.f$6, (Function0) this.f$3, this.f$7, this.f$2, (GapComposer) obj, iUpdateChangedFlags2);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ PropertiesScreenKt$$ExternalSyntheticLambda9(Profile profile, boolean z, boolean z2, Function1 function1, Function0 function0, Function0 function2, Function0 function3, Modifier modifier, int i) {
        this.f$0 = profile;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = function1;
        this.f$4 = function0;
        this.f$5 = function2;
        this.f$6 = function3;
        this.f$7 = modifier;
    }
}
