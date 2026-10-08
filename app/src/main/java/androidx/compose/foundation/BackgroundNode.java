package androidx.compose.foundation;

import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BackgroundNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode, SemanticsModifierNode {
    public float alpha;
    public Brush brush;
    public long color;
    public LayoutDirection lastLayoutDirection;
    public BrushKt lastOutline;
    public Shape lastShape;
    public long lastSize;
    public Shape shape;
    public BrushKt tmpOutline;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setShape(semanticsPropertyReceiver, this.shape);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        BrushKt brushKt;
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        if (this.shape == BrushKt.RectangleShape) {
            if (!Color.m435equalsimpl0(this.color, Color.Unspecified)) {
                Modifier.CC.m315drawRectnJ9OG0$default(layoutNodeDrawScope, this.color, 0L, 0.0f, 0, 126);
            }
            Brush brush = this.brush;
            if (brush != null) {
                Modifier.CC.m314drawRectAsUm42w$default(layoutNodeDrawScope, brush, 0L, 0L, this.alpha, null, null, 0, 118);
            }
        } else {
            if (Size.m384equalsimpl0(canvasDrawScope.drawContext.m756getSizeNHjbRc(), this.lastSize) && layoutNodeDrawScope.getLayoutDirection() == this.lastLayoutDirection && Intrinsics.areEqual(this.lastShape, this.shape)) {
                brushKt = this.lastOutline;
            } else {
                HitTestResultKt.observeReads(this, new Recomposer$$ExternalSyntheticLambda6(4, this, layoutNodeDrawScope));
                brushKt = this.tmpOutline;
                this.tmpOutline = null;
            }
            this.lastOutline = brushKt;
            this.lastSize = canvasDrawScope.drawContext.m756getSizeNHjbRc();
            this.lastLayoutDirection = layoutNodeDrawScope.getLayoutDirection();
            this.lastShape = this.shape;
            if (!Color.m435equalsimpl0(this.color, Color.Unspecified)) {
                BrushKt.m416drawOutlinewDX37Ww$default(layoutNodeDrawScope, brushKt, this.color);
            }
            Brush brush2 = this.brush;
            if (brush2 != null) {
                BrushKt.m415drawOutlinehn5TExg$default(layoutNodeDrawScope, brushKt, brush2, this.alpha, 56);
            }
        }
        layoutNodeDrawScope.drawContent();
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean isImportantForBounds() {
        return false;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        this.lastSize = 9205357640488583168L;
        this.lastLayoutDirection = null;
        this.lastOutline = null;
        this.lastShape = null;
        HitTestResultKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }
}
