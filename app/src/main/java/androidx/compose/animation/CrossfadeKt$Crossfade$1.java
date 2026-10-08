package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CrossfadeKt$Crossfade$1 extends Lambda implements Function2 {
    public final /* synthetic */ int $$changed;
    public final /* synthetic */ Object $animationSpec;
    public final /* synthetic */ ComposableLambdaImpl $content;
    public final /* synthetic */ Object $label;
    public final /* synthetic */ Object $modifier;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $targetState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CrossfadeKt$Crossfade$1(Object obj, Object obj2, Object obj3, Object obj4, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        super(2);
        this.$r8$classId = i2;
        this.$targetState = obj;
        this.$modifier = obj2;
        this.$animationSpec = obj3;
        this.$label = obj4;
        this.$content = composableLambdaImpl;
        this.$$changed = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Number) obj2).intValue();
                Modifier modifier = (Modifier) this.$modifier;
                TweenSpec tweenSpec = (TweenSpec) this.$animationSpec;
                String str = (String) this.$label;
                Scale.Crossfade(this.$targetState, modifier, tweenSpec, str, this.$content, (GapComposer) obj, Stack.updateChangedFlags(this.$$changed | 1));
                break;
            case 1:
                ((Number) obj2).intValue();
                Transition transition = (Transition) this.$targetState;
                Function1 function1 = (Function1) this.$modifier;
                EnterTransitionImpl enterTransitionImpl = (EnterTransitionImpl) this.$animationSpec;
                ExitTransitionImpl exitTransitionImpl = (ExitTransitionImpl) this.$label;
                Scale.AnimatedVisibilityImpl(transition, function1, enterTransitionImpl, exitTransitionImpl, this.$content, (GapComposer) obj, Stack.updateChangedFlags(this.$$changed | 1));
                break;
            default:
                ((Number) obj2).intValue();
                Transition transition2 = (Transition) this.$targetState;
                Modifier modifier2 = (Modifier) this.$modifier;
                TweenSpec tweenSpec2 = (TweenSpec) this.$animationSpec;
                Function1 function2 = (Function1) this.$label;
                Scale.Crossfade(transition2, modifier2, tweenSpec2, function2, this.$content, (GapComposer) obj, Stack.updateChangedFlags(this.$$changed | 1));
                break;
        }
        return Unit.INSTANCE;
    }
}
