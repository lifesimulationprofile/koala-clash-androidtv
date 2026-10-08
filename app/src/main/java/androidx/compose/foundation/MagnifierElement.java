package androidx.compose.foundation;

import android.view.View;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MagnifierElement extends ModifierNodeElement {
    public final Function1 onSizeChanged;
    public final PlatformMagnifierFactory platformMagnifierFactory;
    public final Function1 sourceCenter;

    public MagnifierElement(Function1 function1, Function1 function2, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = function1;
        this.onSizeChanged = function2;
        this.platformMagnifierFactory = platformMagnifierFactory;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new MagnifierNode(this.sourceCenter, this.onSizeChanged, this.platformMagnifierFactory);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        int i = (int) 9205357638345293824L;
        return this.platformMagnifierFactory.hashCode() + ((this.onSizeChanged.hashCode() + ((((Float.floatToIntBits(Float.NaN) + ImageAnalysis$$ExternalSyntheticLambda1.m(Float.NaN, (i + ((((Float.floatToIntBits(Float.NaN) + (this.sourceCenter.hashCode() * 961)) * 31) + 1231) * 31)) * 31, 31)) * 31) + 1231) * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        MagnifierNode magnifierNode = (MagnifierNode) node;
        magnifierNode.getClass();
        PlatformMagnifierFactory platformMagnifierFactory = magnifierNode.platformMagnifierFactory;
        View view = magnifierNode.view;
        Density density = magnifierNode.density;
        magnifierNode.sourceCenter = this.sourceCenter;
        magnifierNode.onSizeChanged = this.onSizeChanged;
        PlatformMagnifierFactory platformMagnifierFactory2 = this.platformMagnifierFactory;
        magnifierNode.platformMagnifierFactory = platformMagnifierFactory2;
        View viewRequireView = HitTestResultKt.requireView(magnifierNode);
        Density density2 = HitTestResultKt.requireLayoutNode(magnifierNode).density;
        if (magnifierNode.magnifier != null) {
            SemanticsPropertyKey semanticsPropertyKey = Magnifier_androidKt.MagnifierPositionInRoot;
            if (((!Float.isNaN(Float.NaN) || !Float.isNaN(Float.NaN)) && !platformMagnifierFactory2.getCanUpdateZoom()) || !Dp.m704equalsimpl0(Float.NaN, Float.NaN) || !Dp.m704equalsimpl0(Float.NaN, Float.NaN) || !platformMagnifierFactory2.equals(platformMagnifierFactory) || !viewRequireView.equals(view) || !Intrinsics.areEqual(density2, density)) {
                magnifierNode.recreateMagnifier();
            }
        }
        magnifierNode.updateMagnifier();
    }
}
