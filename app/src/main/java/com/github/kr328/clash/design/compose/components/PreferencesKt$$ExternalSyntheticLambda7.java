package com.github.kr328.clash.design.compose.components;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PreferencesKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Modifier f$1;

    public /* synthetic */ PreferencesKt$$ExternalSyntheticLambda7(String str, Modifier modifier, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = str;
        this.f$1 = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        GapComposer gapComposer = (GapComposer) obj;
        ((Integer) obj2).getClass();
        switch (i) {
            case 0:
                zzjo.PreferenceTip(this.f$0, this.f$1, gapComposer, Stack.updateChangedFlags(1));
                break;
            default:
                zzjo.PreferenceCategory(this.f$0, this.f$1, gapComposer, Stack.updateChangedFlags(1));
                break;
        }
        return Unit.INSTANCE;
    }
}
