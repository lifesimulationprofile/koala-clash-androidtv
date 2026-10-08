package androidx.compose.material3.internal;

import androidx.compose.animation.core.Transition;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldImplKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ State f$0;
    public final /* synthetic */ TextFieldColors f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ Transition f$6;
    public final /* synthetic */ TextStyle f$7;
    public final /* synthetic */ TextStyle f$8;
    public final /* synthetic */ Function3 f$9;

    public /* synthetic */ TextFieldImplKt$$ExternalSyntheticLambda1(Transition.TransitionAnimationState transitionAnimationState, TextFieldColors textFieldColors, boolean z, boolean z2, boolean z3, boolean z4, Transition transition, TextStyle textStyle, TextStyle textStyle2, Function3 function3) {
        this.f$0 = transitionAnimationState;
        this.f$1 = textFieldColors;
        this.f$2 = z;
        this.f$3 = z2;
        this.f$4 = z3;
        this.f$5 = z4;
        this.f$6 = transition;
        this.f$7 = textStyle;
        this.f$8 = textStyle2;
        this.f$9 = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                TextFieldImplKt.DecoratedLabel(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    TextFieldImplKt.DecoratedLabel(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, gapComposer, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ TextFieldImplKt$$ExternalSyntheticLambda1(State state, TextFieldColors textFieldColors, boolean z, boolean z2, boolean z3, boolean z4, Transition transition, TextStyle textStyle, TextStyle textStyle2, Function3 function3, int i) {
        this.f$0 = state;
        this.f$1 = textFieldColors;
        this.f$2 = z;
        this.f$3 = z2;
        this.f$4 = z3;
        this.f$5 = z4;
        this.f$6 = transition;
        this.f$7 = textStyle;
        this.f$8 = textStyle2;
        this.f$9 = function3;
    }
}
