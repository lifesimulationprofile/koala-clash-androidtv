package androidx.compose.foundation.lazy.layout;

import androidx.camera.view.PreviewView;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import coil.network.HttpException;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsProviderModifierNode extends Modifier.Node implements LayoutModifierNode, DelegatableNode {
    public static final LazyLayoutBeyondBoundsProviderModifierNode$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope = new LazyLayoutBeyondBoundsProviderModifierNode$Companion$emptyBeyondBoundsScope$1();
    public PreviewView.AnonymousClass1 beyondBoundsInfo;
    public Orientation orientation;
    public boolean reverseLayout;
    public LazyListBeyondBoundsState state;

    /* JADX INFO: renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m150hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsInfo$Interval lazyLayoutBeyondBoundsInfo$Interval, int i) {
        if (i == 5 || i == 6) {
            if (this.orientation == Orientation.Horizontal) {
                return false;
            }
        } else if (i == 3 || i == 4) {
            if (this.orientation == Orientation.Vertical) {
                return false;
            }
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction");
        }
        if (m151isForward4vf7U8o(i)) {
            if (lazyLayoutBeyondBoundsInfo$Interval.end >= this.state.state.getLayoutInfo().totalItemsCount - 1) {
                return false;
            }
        } else if (lazyLayoutBeyondBoundsInfo$Interval.start <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: isForward-4vf7U8o, reason: not valid java name */
    public final boolean m151isForward4vf7U8o(int i) {
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            if (i == 5) {
                return this.reverseLayout;
            }
            if (i == 6) {
                if (this.reverseLayout) {
                    return false;
                }
            } else if (i == 3) {
                int iOrdinal = HitTestResultKt.requireLayoutNode(this).layoutDirection.ordinal();
                if (iOrdinal == 0) {
                    return this.reverseLayout;
                }
                if (iOrdinal != 1) {
                    throw new HttpException();
                }
                if (this.reverseLayout) {
                    return false;
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction");
                }
                int iOrdinal2 = HitTestResultKt.requireLayoutNode(this).layoutDirection.ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 == 1) {
                        return this.reverseLayout;
                    }
                    throw new HttpException();
                }
                if (this.reverseLayout) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$maxIntrinsicHeight(this, lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo25measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 2, 1, 2), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(j);
        return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo517measureBRTryo0, 6));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo25measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 1, 2, 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$minIntrinsicWidth(this, lookaheadCapablePlaceable, measurable, i);
    }
}
