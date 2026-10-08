package androidx.navigation.compose;

import android.view.View;
import androidx.activity.compose.ComposeBackHandler;
import androidx.activity.compose.ComposePredictiveBackHandler;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.core.view.ViewCompat;
import androidx.navigation.NavBackStackEntry;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    public final /* synthetic */ Object $composeNavigator$inlined;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $visibleEntries$delegate$inlined;

    public /* synthetic */ NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.$visibleEntries$delegate$inlined = obj;
        this.$composeNavigator$inlined = obj2;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public final void dispose() throws Exception {
        int i = this.$r8$classId;
        Object obj = this.$composeNavigator$inlined;
        Object obj2 = this.$visibleEntries$delegate$inlined;
        switch (i) {
            case 0:
                Iterator it = ((List) ((State) obj2).getValue()).iterator();
                while (it.hasNext()) {
                    ((ComposeNavigator) obj).getState().markTransitionComplete((NavBackStackEntry) it.next());
                }
                break;
            case 1:
                ((BackHandlerDispatcherCompat) obj2).removeHandler((ComposeBackHandler) obj);
                break;
            case 2:
                ((BackHandlerDispatcherCompat) obj2).removeHandler((ComposePredictiveBackHandler) obj);
                break;
            case 3:
                ((InfiniteTransition) obj2)._animations.remove((InfiniteTransition.TransitionAnimationState) obj);
                break;
            case 4:
                ((Transition) obj2)._transitions.remove((Transition) obj);
                break;
            case 5:
                Transition transition = (Transition) obj2;
                transition.getClass();
                Transition.DeferredAnimation.DeferredAnimationData deferredAnimationData = (Transition.DeferredAnimation.DeferredAnimationData) ((Transition.DeferredAnimation) obj).data$delegate.getValue();
                if (deferredAnimationData != null) {
                    transition._animations.remove(deferredAnimationData.animation);
                }
                break;
            case 6:
                ((Transition) obj2)._animations.remove((Transition.TransitionAnimationState) obj);
                break;
            case 7:
                WindowInsetsHolder windowInsetsHolder = (WindowInsetsHolder) obj2;
                View view = (View) obj;
                int i2 = windowInsetsHolder.accessCount - 1;
                windowInsetsHolder.accessCount = i2;
                if (i2 == 0) {
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(view, null);
                    ViewCompat.setWindowInsetsAnimationCallback(view, null);
                    view.removeOnAttachStateChangeListener(windowInsetsHolder.insetsListener);
                }
                break;
            case 8:
                ((LazySaveableStateHolder) obj2).previouslyComposedKeys.plusAssign(obj);
                break;
            case 9:
                MutableState mutableState = (MutableState) obj2;
                PressInteraction.Press press = (PressInteraction.Press) mutableState.getValue();
                if (press != null) {
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) obj;
                    if (mutableInteractionSourceImpl != null) {
                        mutableInteractionSourceImpl.tryEmit(cancel);
                    }
                    mutableState.setValue(null);
                }
                break;
            default:
                ((NavBackStackEntry) obj2)._lifecycle.removeObserver((DialogHostKt$PopulateVisibleList$1$1$1$$ExternalSyntheticLambda0) obj);
                break;
        }
    }
}
