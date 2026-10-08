package androidx.compose.animation.core;

import androidx.compose.runtime.DisposableEffectResult;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TransitionKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Transition f$0;

    public /* synthetic */ TransitionKt$$ExternalSyntheticLambda1(Transition transition, int i) {
        this.$r8$classId = i;
        this.f$0 = transition;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                final int i = 0;
                final Transition transition = this.f$0;
                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$lambda$1$0$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        switch (i) {
                            case 0:
                                Transition transition2 = transition;
                                transition2.onTransitionEnd$animation_core();
                                transition2.transitionState.transitionRemoved$animation_core();
                                break;
                            default:
                                Transition transition3 = transition;
                                transition3.onTransitionEnd$animation_core();
                                transition3.transitionState.transitionRemoved$animation_core();
                                break;
                        }
                    }
                };
            default:
                final int i2 = 1;
                final Transition transition2 = this.f$0;
                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$lambda$1$0$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        switch (i2) {
                            case 0:
                                Transition transition3 = transition2;
                                transition3.onTransitionEnd$animation_core();
                                transition3.transitionState.transitionRemoved$animation_core();
                                break;
                            default:
                                Transition transition4 = transition2;
                                transition4.onTransitionEnd$animation_core();
                                transition4.transitionState.transitionRemoved$animation_core();
                                break;
                        }
                    }
                };
        }
    }
}
