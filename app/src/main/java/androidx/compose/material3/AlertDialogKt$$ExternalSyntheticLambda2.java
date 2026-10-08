package androidx.compose.material3;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlertDialogKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ ComposableLambdaImpl f$1;
    public final /* synthetic */ long f$10;
    public final /* synthetic */ long f$11;
    public final /* synthetic */ float f$12;
    public final /* synthetic */ DialogProperties f$13;
    public final /* synthetic */ int f$14;
    public final /* synthetic */ int f$15;
    public final /* synthetic */ Modifier f$2;
    public final /* synthetic */ Function2 f$3;
    public final /* synthetic */ Function2 f$4;
    public final /* synthetic */ Function2 f$5;
    public final /* synthetic */ Function2 f$6;
    public final /* synthetic */ Shape f$7;
    public final /* synthetic */ long f$8;
    public final /* synthetic */ long f$9;

    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda2(Function0 function0, ComposableLambdaImpl composableLambdaImpl, Modifier modifier, Function2 function2, Function2 function3, Function2 function4, Function2 function5, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, int i, int i2, int i3) {
        this.$r8$classId = i3;
        this.f$0 = function0;
        this.f$1 = composableLambdaImpl;
        this.f$2 = modifier;
        this.f$3 = function2;
        this.f$4 = function3;
        this.f$5 = function4;
        this.f$6 = function5;
        this.f$7 = shape;
        this.f$8 = j;
        this.f$9 = j2;
        this.f$10 = j3;
        this.f$11 = j4;
        this.f$12 = f;
        this.f$13 = dialogProperties;
        this.f$14 = i;
        this.f$15 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        GapComposer gapComposer = (GapComposer) obj;
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                AlertDialogKt.m235AlertDialogImplwrnwzgE(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, gapComposer, Stack.updateChangedFlags(this.f$14 | 1), Stack.updateChangedFlags(this.f$15));
                break;
            default:
                ((Integer) obj2).getClass();
                ScrimKt.m263AlertDialogOix01E0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, gapComposer, Stack.updateChangedFlags(this.f$14 | 1), this.f$15);
                break;
        }
        return Unit.INSTANCE;
    }
}
