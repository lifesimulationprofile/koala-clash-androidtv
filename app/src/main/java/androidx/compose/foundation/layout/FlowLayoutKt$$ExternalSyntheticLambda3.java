package androidx.compose.foundation.layout;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FlowLayoutKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ int f$5;
    public final /* synthetic */ Object f$6;

    public /* synthetic */ FlowLayoutKt$$ExternalSyntheticLambda3(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, BiasAlignment.Vertical vertical2, int i, int i2, ComposableLambdaImpl composableLambdaImpl, int i3) {
        this.f$0 = modifier;
        this.f$1 = horizontal;
        this.f$2 = vertical;
        this.f$3 = vertical2;
        this.f$4 = i;
        this.f$5 = i2;
        this.f$6 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1572865);
                OffsetKt.FlowRow(this.f$0, (Arrangement.Horizontal) this.f$1, (Arrangement.Vertical) this.f$2, (BiasAlignment.Vertical) this.f$3, this.f$4, this.f$5, (ComposableLambdaImpl) this.f$6, (GapComposer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                ConnectionsScreenKt.m806StatCellSj8uqqQ((String) this.f$1, (String) this.f$2, this.f$0, (Color) this.f$3, (String) this.f$6, (GapComposer) obj, Stack.updateChangedFlags(this.f$4 | 1), this.f$5);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ FlowLayoutKt$$ExternalSyntheticLambda3(String str, String str2, Modifier modifier, Color color, String str3, int i, int i2) {
        this.f$1 = str;
        this.f$2 = str2;
        this.f$0 = modifier;
        this.f$3 = color;
        this.f$6 = str3;
        this.f$4 = i;
        this.f$5 = i2;
    }
}
