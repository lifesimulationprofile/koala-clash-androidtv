package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MaterialThemeKt$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ int f$5;

    public /* synthetic */ MaterialThemeKt$$ExternalSyntheticLambda5(PopupPositionProvider popupPositionProvider, ComposableLambdaImpl composableLambdaImpl, TooltipStateImpl tooltipStateImpl, Modifier modifier, ComposableLambdaImpl composableLambdaImpl2, int i) {
        this.$r8$classId = 2;
        this.f$0 = popupPositionProvider;
        this.f$4 = composableLambdaImpl;
        this.f$1 = tooltipStateImpl;
        this.f$2 = modifier;
        this.f$3 = composableLambdaImpl2;
        this.f$5 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                MaterialThemeKt.MaterialTheme((ColorScheme) this.f$0, (MotionScheme) this.f$1, (Shapes) this.f$2, (Typography) this.f$3, (ComposableLambdaImpl) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$5 | 1));
                break;
            case 1:
                ((Integer) obj2).intValue();
                ArcSplineKt.UpdateInitialAndTargetValues((Transition) this.f$0, (Transition.TransitionAnimationState) this.f$1, this.f$2, this.f$3, (FiniteAnimationSpec) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$5 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                LayoutUtilKt.BasicTooltipBox((PopupPositionProvider) this.f$0, (ComposableLambdaImpl) this.f$4, (TooltipStateImpl) this.f$1, (Modifier) this.f$2, (ComposableLambdaImpl) this.f$3, (GapComposer) obj, Stack.updateChangedFlags(this.f$5 | 1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ MaterialThemeKt$$ExternalSyntheticLambda5(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
        this.f$5 = i;
    }
}
