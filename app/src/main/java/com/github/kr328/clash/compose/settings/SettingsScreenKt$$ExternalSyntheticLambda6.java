package com.github.kr328.clash.compose.settings;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.google.android.gms.internal.mlkit_vision_common.zzje;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SettingsScreenKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ Modifier f$2;

    public /* synthetic */ SettingsScreenKt$$ExternalSyntheticLambda6(Function0 function0, Modifier modifier, boolean z, int i) {
        this.f$1 = function0;
        this.f$2 = modifier;
        this.f$0 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        GapComposer gapComposer = (GapComposer) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                zzje.BuildInfoFooter(Stack.updateChangedFlags(1), gapComposer, this.f$2, this.f$1, this.f$0);
                break;
            default:
                ConnectionsScreenKt.ConnectionsScreen(Stack.updateChangedFlags(1), gapComposer, this.f$2, this.f$1, this.f$0);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ SettingsScreenKt$$ExternalSyntheticLambda6(boolean z, Function0 function0, Modifier modifier, int i) {
        this.f$0 = z;
        this.f$1 = function0;
        this.f$2 = modifier;
    }
}
