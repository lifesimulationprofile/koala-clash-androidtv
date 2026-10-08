package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class EnterExitTransitionElement extends ModifierNodeElement {
    public final EnterTransitionImpl enter;
    public final ExitTransitionImpl exit;
    public final EnterExitTransitionKt$$ExternalSyntheticLambda0 graphicsLayerBlock;
    public final Function0 isEnabled;
    public final Transition.DeferredAnimation offsetAnimation;
    public final Transition.DeferredAnimation sizeAnimation;
    public final Transition.DeferredAnimation slideAnimation;
    public final Transition transition;

    public EnterExitTransitionElement(Transition transition, Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition.DeferredAnimation deferredAnimation3, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, Function0 function0, EnterExitTransitionKt$$ExternalSyntheticLambda0 enterExitTransitionKt$$ExternalSyntheticLambda0) {
        this.transition = transition;
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.slideAnimation = deferredAnimation3;
        this.enter = enterTransitionImpl;
        this.exit = exitTransitionImpl;
        this.isEnabled = function0;
        this.graphicsLayerBlock = enterExitTransitionKt$$ExternalSyntheticLambda0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new EnterExitTransitionModifierNode(this.transition, this.sizeAnimation, this.offsetAnimation, this.slideAnimation, this.enter, this.exit, this.isEnabled, this.graphicsLayerBlock);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof EnterExitTransitionElement)) {
            return false;
        }
        EnterExitTransitionElement enterExitTransitionElement = (EnterExitTransitionElement) obj;
        return Intrinsics.areEqual(enterExitTransitionElement.transition, this.transition) && Intrinsics.areEqual(enterExitTransitionElement.sizeAnimation, this.sizeAnimation) && Intrinsics.areEqual(enterExitTransitionElement.offsetAnimation, this.offsetAnimation) && Intrinsics.areEqual(enterExitTransitionElement.slideAnimation, this.slideAnimation) && Intrinsics.areEqual(enterExitTransitionElement.enter, this.enter) && Intrinsics.areEqual(enterExitTransitionElement.exit, this.exit) && enterExitTransitionElement.isEnabled == this.isEnabled && Intrinsics.areEqual(enterExitTransitionElement.graphicsLayerBlock, this.graphicsLayerBlock);
    }

    public final int hashCode() {
        int iHashCode = this.transition.hashCode() * 31;
        Transition.DeferredAnimation deferredAnimation = this.sizeAnimation;
        int iHashCode2 = (iHashCode + (deferredAnimation != null ? deferredAnimation.hashCode() : 0)) * 31;
        Transition.DeferredAnimation deferredAnimation2 = this.offsetAnimation;
        int iHashCode3 = (iHashCode2 + (deferredAnimation2 != null ? deferredAnimation2.hashCode() : 0)) * 31;
        Transition.DeferredAnimation deferredAnimation3 = this.slideAnimation;
        return this.graphicsLayerBlock.hashCode() + ((this.isEnabled.hashCode() + ((this.exit.data.hashCode() + ((this.enter.data.hashCode() + ((iHashCode3 + (deferredAnimation3 != null ? deferredAnimation3.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        EnterExitTransitionModifierNode enterExitTransitionModifierNode = (EnterExitTransitionModifierNode) node;
        enterExitTransitionModifierNode.transition = this.transition;
        enterExitTransitionModifierNode.sizeAnimation = this.sizeAnimation;
        enterExitTransitionModifierNode.offsetAnimation = this.offsetAnimation;
        enterExitTransitionModifierNode.slideAnimation = this.slideAnimation;
        enterExitTransitionModifierNode.enter = this.enter;
        enterExitTransitionModifierNode.exit = this.exit;
        enterExitTransitionModifierNode.isEnabled = this.isEnabled;
        enterExitTransitionModifierNode.graphicsLayerBlock = this.graphicsLayerBlock;
    }
}
