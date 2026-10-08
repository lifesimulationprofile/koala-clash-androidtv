package androidx.compose.material3;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlertDialogKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ComposableLambdaImpl f$0;
    public final /* synthetic */ Function2 f$1;

    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda4(ComposableLambdaImpl composableLambdaImpl, Function2 function2, int i) {
        this.$r8$classId = i;
        this.f$0 = composableLambdaImpl;
        this.f$1 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (i) {
            case 0:
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    float f = ((Dp) gapComposer.consume(InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize)).value;
                    if (Float.isNaN(f)) {
                        f = 0;
                    }
                    float f2 = f - ButtonDefaults.MinHeight;
                    float f3 = AlertDialogKt.ButtonsCrossAxisSpacing;
                    Dp dp = new Dp(f3 - f2);
                    Dp dp2 = new Dp(0);
                    Dp dp3 = new Dp(f3);
                    if (dp2.compareTo(dp3) > 0) {
                        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + dp3 + " is less than minimum " + dp2 + '.');
                    }
                    if (dp.compareTo(dp2) < 0) {
                        dp = dp2;
                    } else if (dp.compareTo(dp3) > 0) {
                        dp = dp3;
                    }
                    AlertDialogKt.m234AlertDialogFlowRowixp7dh8(dp.value, Thread_jvmKt.rememberComposableLambda(-459506658, new AlertDialogKt$$ExternalSyntheticLambda4(this.f$0, this.f$1, 1), gapComposer), gapComposer, 390);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            default:
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    this.f$0.invoke((Object) gapComposer, (Object) 0);
                    Function2 function2 = this.f$1;
                    if (function2 == null) {
                        gapComposer.startReplaceGroup(-1102003461);
                    } else {
                        gapComposer.startReplaceGroup(795735494);
                        function2.invoke(gapComposer, 0);
                    }
                    gapComposer.end(false);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
        }
    }
}
