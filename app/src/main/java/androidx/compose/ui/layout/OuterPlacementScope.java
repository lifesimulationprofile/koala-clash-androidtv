package androidx.compose.ui.layout;

import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OuterPlacementScope extends Placeable.PlacementScope {
    public final /* synthetic */ int $r8$classId;
    public final Object owner;

    public /* synthetic */ OuterPlacementScope(int i, Object obj) {
        this.$r8$classId = i;
        this.owner = obj;
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public float current(VerticalRuler verticalRuler) {
        float fIntBitsToFloat;
        int iIndexOf;
        switch (this.$r8$classId) {
            case 1:
                Function2 function2 = verticalRuler.calculate;
                if (function2 != null) {
                    return ((Number) function2.invoke(this, Float.valueOf(Float.NaN))).floatValue();
                }
                LookaheadCapablePlaceable lookaheadCapablePlaceable = (LookaheadCapablePlaceable) this.owner;
                if (lookaheadCapablePlaceable.isPlacingForAlignment) {
                    return Float.NaN;
                }
                LookaheadCapablePlaceable lookaheadCapablePlaceable2 = lookaheadCapablePlaceable;
                while (true) {
                    RulerTrackingMap rulerTrackingMap = lookaheadCapablePlaceable2.rulerValues;
                    float f = (rulerTrackingMap == null || (iIndexOf = ArraysKt.indexOf((VerticalRuler[]) rulerTrackingMap.rulers, verticalRuler)) < 0) ? Float.NaN : ((float[]) rulerTrackingMap.values)[iIndexOf];
                    if (!Float.isNaN(f)) {
                        lookaheadCapablePlaceable2.addRulerReader(lookaheadCapablePlaceable.getLayoutNode(), verticalRuler);
                        LayoutCoordinates coordinates = lookaheadCapablePlaceable2.getCoordinates();
                        LayoutCoordinates coordinates2 = lookaheadCapablePlaceable.getCoordinates();
                        switch (verticalRuler.$r8$classId) {
                            case 0:
                                fIntBitsToFloat = Float.intBitsToFloat((int) (coordinates2.mo523localPositionOfR5De75A(coordinates, (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(((int) (coordinates.mo522getSizeYbymL2g() & 4294967295L)) / 2.0f)) & 4294967295L)) >> 32));
                                break;
                            default:
                                fIntBitsToFloat = Float.intBitsToFloat((int) (coordinates2.mo523localPositionOfR5De75A(coordinates, (((long) Float.floatToRawIntBits(f)) & 4294967295L) | (((long) Float.floatToRawIntBits(((int) (coordinates.mo522getSizeYbymL2g() >> 32)) / 2.0f)) << 32)) & 4294967295L));
                                break;
                        }
                        return fIntBitsToFloat;
                    }
                    LookaheadCapablePlaceable parent = lookaheadCapablePlaceable2.getParent();
                    if (parent == null) {
                        lookaheadCapablePlaceable2.addRulerReader(lookaheadCapablePlaceable.getLayoutNode(), verticalRuler);
                        return Float.NaN;
                    }
                    lookaheadCapablePlaceable2 = parent;
                }
                break;
            default:
                return super.current(verticalRuler);
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        switch (this.$r8$classId) {
            case 0:
                return ((AndroidComposeView) this.owner).getDensity().getDensity();
            default:
                return ((LookaheadCapablePlaceable) this.owner).getDensity();
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        switch (this.$r8$classId) {
            case 0:
                return ((AndroidComposeView) this.owner).getDensity().getFontScale();
            default:
                return ((LookaheadCapablePlaceable) this.owner).getFontScale();
        }
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public final LayoutDirection getParentLayoutDirection() {
        switch (this.$r8$classId) {
            case 0:
                return ((AndroidComposeView) this.owner).getLayoutDirection();
            default:
                return ((LookaheadCapablePlaceable) this.owner).getLayoutDirection();
        }
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public final int getParentWidth() {
        switch (this.$r8$classId) {
            case 0:
                return ((AndroidComposeView) this.owner).getRoot().layoutDelegate.measurePassDelegate.width;
            default:
                return ((LookaheadCapablePlaceable) this.owner).getMeasuredWidth();
        }
    }
}
