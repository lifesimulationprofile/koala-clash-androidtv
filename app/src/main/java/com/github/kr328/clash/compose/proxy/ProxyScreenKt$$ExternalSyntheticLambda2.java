package com.github.kr328.clash.compose.proxy;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.google.android.gms.internal.mlkit_vision_common.zzir;
import com.google.android.gms.internal.mlkit_vision_common.zzjb;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProxyScreenKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ ProxyScreenKt$$ExternalSyntheticLambda2(ImageVector imageVector, String str, boolean z, Function0 function0, int i) {
        this.$r8$classId = 2;
        this.f$1 = imageVector;
        this.f$0 = str;
        this.f$2 = z;
        this.f$3 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                ProxyScreenKt.ProxyGroupCard((String) this.f$0, (String) this.f$1, this.f$2, this.f$3, (GapComposer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(3073);
                ConnectionsScreenKt.ConnectionDetailSheet((ConnectionInfo) this.f$0, this.f$2, this.f$3, (Function0) this.f$1, (GapComposer) obj, iUpdateChangedFlags2);
                break;
            case 2:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(1);
                zzir.TrailingIconButton((ImageVector) this.f$1, (String) this.f$0, this.f$2, this.f$3, (GapComposer) obj, iUpdateChangedFlags3);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags4 = Stack.updateChangedFlags(1);
                zzjb.SegmentedPill((String) this.f$0, this.f$2, this.f$3, (Modifier) this.f$1, (GapComposer) obj, iUpdateChangedFlags4);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ProxyScreenKt$$ExternalSyntheticLambda2(Object obj, boolean z, Function0 function0, Object obj2, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$2 = z;
        this.f$3 = function0;
        this.f$1 = obj2;
    }

    public /* synthetic */ ProxyScreenKt$$ExternalSyntheticLambda2(String str, String str2, boolean z, Function0 function0, int i) {
        this.$r8$classId = 0;
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = z;
        this.f$3 = function0;
    }
}
