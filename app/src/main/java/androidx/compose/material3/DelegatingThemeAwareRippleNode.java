package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.internal.ripple.RippleModifierNode;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ObserverModifierNode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DelegatingThemeAwareRippleNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    public final boolean bounded;
    public final ColorProducer color;
    public final boolean enableDragIndication;
    public final boolean enableFocusIndication;
    public final boolean enableHoverIndication;
    public final boolean enablePressIndication;
    public final Shape focusRingShape;
    public final MutableInteractionSourceImpl interactionSource;
    public final float radius;
    public RippleModifierNode rippleNode;

    public DelegatingThemeAwareRippleNode(MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, float f, ColorProducer colorProducer, Shape shape, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.bounded = z;
        this.radius = f;
        this.color = colorProducer;
        this.focusRingShape = shape;
        this.enablePressIndication = z2;
        this.enableFocusIndication = z3;
        this.enableHoverIndication = z4;
        this.enableDragIndication = z5;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        HitTestResultKt.observeReads(this, new BasicTextKt$$ExternalSyntheticLambda0(19, this));
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        HitTestResultKt.observeReads(this, new BasicTextKt$$ExternalSyntheticLambda0(19, this));
    }
}
