package com.github.kr328.clash.compose.proxy;

import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import com.google.android.gms.internal.mlkit_vision_common.zziz;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProxySelectorSheetKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ ProxySelectorSheetKt$$ExternalSyntheticLambda3(Function0 function0, boolean z, int i, int i2) {
        this.f$0 = function0;
        this.f$1 = z;
        this.f$2 = i;
        this.f$3 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(this.f$2 | 1);
                zziz.ProxySelectorSheet((Function0) this.f$0, this.f$1, (GapComposer) obj, iUpdateChangedFlags, this.f$3);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(this.f$3 | 1);
                SimpleLayoutKt.TextFieldSelectionHandle(this.f$1, this.f$2, (TextFieldSelectionManager) this.f$0, (GapComposer) obj, iUpdateChangedFlags2);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ProxySelectorSheetKt$$ExternalSyntheticLambda3(boolean z, int i, TextFieldSelectionManager textFieldSelectionManager, int i2) {
        this.f$1 = z;
        this.f$2 = i;
        this.f$0 = textFieldSelectionManager;
        this.f$3 = i2;
    }
}
