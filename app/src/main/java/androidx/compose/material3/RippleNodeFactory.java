package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import coil.request.Parameters;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RippleNodeFactory implements IndicationNodeFactory {
    public final boolean bounded;
    public final long color;
    public final boolean enableDragIndication;
    public final boolean enableFocusIndication;
    public final boolean enableHoverIndication;
    public final boolean enablePressIndication;
    public final Shape focusRingShape;
    public final float radius;

    public RippleNodeFactory(boolean z, float f, long j, Shape shape, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (shape == null) {
            Dp dp = Dp.m704equalsimpl0(f, Float.NaN) ? null : new Dp(f);
            shape = dp != null ? RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(dp.value) : null;
            if (shape == null) {
                shape = BrushKt.RectangleShape;
            }
        }
        this.bounded = z;
        this.radius = f;
        this.color = j;
        this.focusRingShape = shape;
        this.enablePressIndication = z2;
        this.enableFocusIndication = z3;
        this.enableHoverIndication = z4;
        this.enableDragIndication = z5;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public final DelegatableNode create(MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        return new DelegatingThemeAwareRippleNode(mutableInteractionSourceImpl, this.bounded, this.radius, new Parameters.Builder(1, this), this.focusRingShape, this.enablePressIndication, this.enableFocusIndication, this.enableHoverIndication, this.enableDragIndication);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleNodeFactory)) {
            return false;
        }
        RippleNodeFactory rippleNodeFactory = (RippleNodeFactory) obj;
        return this.bounded == rippleNodeFactory.bounded && Dp.m704equalsimpl0(this.radius, rippleNodeFactory.radius) && Color.m435equalsimpl0(this.color, rippleNodeFactory.color) && Intrinsics.areEqual(this.focusRingShape, rippleNodeFactory.focusRingShape) && this.enablePressIndication == rippleNodeFactory.enablePressIndication && this.enableFocusIndication == rippleNodeFactory.enableFocusIndication && this.enableHoverIndication == rippleNodeFactory.enableHoverIndication && this.enableDragIndication == rippleNodeFactory.enableDragIndication;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public final int hashCode() {
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.radius, (this.bounded ? 1231 : 1237) * 31, 961);
        int i = Color.$r8$clinit;
        return ((((((((this.focusRingShape.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(iM, 31, this.color)) * 31) + (this.enablePressIndication ? 1231 : 1237)) * 31) + (this.enableFocusIndication ? 1231 : 1237)) * 31) + (this.enableHoverIndication ? 1231 : 1237)) * 31) + (this.enableDragIndication ? 1231 : 1237);
    }
}
