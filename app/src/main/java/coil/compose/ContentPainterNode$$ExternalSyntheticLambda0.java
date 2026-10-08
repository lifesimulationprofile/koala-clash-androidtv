package coil.compose;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContentPainterNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Placeable f$0;

    public /* synthetic */ ContentPainterNode$$ExternalSyntheticLambda0(Placeable placeable, int i) {
        this.$r8$classId = i;
        this.f$0 = placeable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
        switch (this.$r8$classId) {
            case 0:
                Placeable.PlacementScope.placeRelative$default(placementScope, this.f$0, 0, 0);
                break;
            case 1:
                Placeable.PlacementScope.placeRelative$default(placementScope, this.f$0, 0, 0);
                break;
            case 2:
                LayoutDirection parentLayoutDirection = placementScope.getParentLayoutDirection();
                LayoutDirection layoutDirection = LayoutDirection.Ltr;
                Placeable placeable = this.f$0;
                if (parentLayoutDirection == layoutDirection || placementScope.getParentWidth() == 0) {
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                    placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(0L, placeable.apparentToRealOffset), 0.0f, null);
                } else {
                    int i = (int) 0;
                    long parentWidth = ((long) ((placementScope.getParentWidth() - placeable.width) - i)) << 32;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                    placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY((((long) i) & 4294967295L) | parentWidth, placeable.apparentToRealOffset), 0.0f, null);
                }
                break;
            case 3:
                Placeable.PlacementScope.placeRelative$default(placementScope, this.f$0, 0, 0);
                break;
            case 4:
                Placeable.PlacementScope.placeRelative$default(placementScope, this.f$0, 0, 0);
                break;
            case 5:
                Placeable.PlacementScope.place$default(placementScope, this.f$0, 0, 0);
                break;
            case 6:
                Placeable.PlacementScope.place$default(placementScope, this.f$0, 0, 0);
                break;
            case 7:
                Placeable.PlacementScope.placeRelative$default(placementScope, this.f$0, 0, 0);
                break;
            case 8:
                Placeable.PlacementScope.placeRelative$default(placementScope, this.f$0, 0, 0);
                break;
            case 9:
                Placeable.PlacementScope.place$default(placementScope, this.f$0, 0, 0);
                break;
            case 10:
                Placeable.PlacementScope.place$default(placementScope, this.f$0, 0, 0);
                break;
            case 11:
                Placeable.PlacementScope.place$default(placementScope, this.f$0, 0, 0);
                break;
            default:
                Placeable.PlacementScope.place$default(placementScope, this.f$0, 0, 0);
                break;
        }
        return Unit.INSTANCE;
    }
}
