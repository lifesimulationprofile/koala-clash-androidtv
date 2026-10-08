package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
final class ThumbElement extends ModifierNodeElement {
    public final FiniteAnimationSpec animationSpec;
    public final boolean checked;
    public final MutableInteractionSourceImpl interactionSource;

    public ThumbElement(MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, FiniteAnimationSpec finiteAnimationSpec) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.checked = z;
        this.animationSpec = finiteAnimationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ThumbNode thumbNode = new ThumbNode();
        thumbNode.interactionSource = this.interactionSource;
        thumbNode.checked = this.checked;
        thumbNode.animationSpec = this.animationSpec;
        thumbNode.initialOffset = Float.NaN;
        thumbNode.initialSize = Float.NaN;
        return thumbNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThumbElement)) {
            return false;
        }
        ThumbElement thumbElement = (ThumbElement) obj;
        return Intrinsics.areEqual(this.interactionSource, thumbElement.interactionSource) && this.checked == thumbElement.checked && Intrinsics.areEqual(this.animationSpec, thumbElement.animationSpec);
    }

    public final int hashCode() {
        return this.animationSpec.hashCode() + (((this.interactionSource.hashCode() * 31) + (this.checked ? 1231 : 1237)) * 31);
    }

    public final String toString() {
        return "ThumbElement(interactionSource=" + this.interactionSource + ", checked=" + this.checked + ", animationSpec=" + this.animationSpec + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ThumbNode thumbNode = (ThumbNode) node;
        thumbNode.interactionSource = this.interactionSource;
        boolean z = thumbNode.checked;
        boolean z2 = this.checked;
        if (z != z2) {
            HitTestResultKt.invalidateMeasurement(thumbNode);
        }
        thumbNode.checked = z2;
        thumbNode.animationSpec = this.animationSpec;
        if (thumbNode.sizeAnim == null && !Float.isNaN(thumbNode.initialSize)) {
            thumbNode.sizeAnim = ArcSplineKt.Animatable$default(thumbNode.initialSize);
        }
        if (thumbNode.offsetAnim != null || Float.isNaN(thumbNode.initialOffset)) {
            return;
        }
        thumbNode.offsetAnim = ArcSplineKt.Animatable$default(thumbNode.initialOffset);
    }
}
