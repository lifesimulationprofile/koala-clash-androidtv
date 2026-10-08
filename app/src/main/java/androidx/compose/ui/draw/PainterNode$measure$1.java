package androidx.compose.ui.draw;

import androidx.compose.ui.layout.Placeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PainterNode$measure$1 extends Lambda implements Function1 {
    public final /* synthetic */ Placeable $placeable;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PainterNode$measure$1(Placeable placeable, int i) {
        super(1);
        this.$r8$classId = i;
        this.$placeable = placeable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, this.$placeable, 0, 0);
                break;
            case 1:
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, this.$placeable, 0, 0);
                break;
            case 2:
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, this.$placeable, 0, 0);
                break;
            case 3:
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, this.$placeable, 0, 0);
                break;
            case 4:
                Placeable.PlacementScope.placeRelativeWithLayer$default((Placeable.PlacementScope) obj, this.$placeable, 0, 0, null, 12);
                break;
            case 5:
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, this.$placeable, 0, 0);
                break;
            default:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, this.$placeable, 0, 0);
                break;
        }
        return Unit.INSTANCE;
    }
}
