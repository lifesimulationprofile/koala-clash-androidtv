package androidx.compose.material3;

import androidx.camera.core.SurfaceRequest;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.node.NodeChain;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SheetState f$0;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda4(SheetState sheetState, int i) {
        this.$r8$classId = i;
        this.f$0 = sheetState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((Float) obj).floatValue();
                return Float.valueOf(((Number) this.f$0.positionalThreshold.invoke()).floatValue());
            case 1:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                SurfaceRequest.AnonymousClass1 anonymousClass1 = this.f$0.anchoredDraggableState;
                float floatValue = ((ParcelableSnapshotMutableFloatState) ((NodeChain) anonymousClass1.val$requestCancellationCompleter).head).getFloatValue();
                float fMinPosition = ((NodeChain) anonymousClass1.val$requestCancellationCompleter).getAnchors().minPosition();
                float f = floatValue < fMinPosition ? fMinPosition - floatValue : 0.0f;
                reusableGraphicsLayerScope.setScaleY(f > 0.0f ? (Float.intBitsToFloat((int) (reusableGraphicsLayerScope.size & 4294967295L)) + f) / Float.intBitsToFloat((int) (4294967295L & reusableGraphicsLayerScope.size)) : 1.0f);
                reusableGraphicsLayerScope.m450setTransformOrigin__ExYCQ(BrushKt.TransformOrigin(0.5f, 0.0f));
                return Unit.INSTANCE;
            default:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj;
                SurfaceRequest.AnonymousClass1 anonymousClass2 = this.f$0.anchoredDraggableState;
                float floatValue2 = ((ParcelableSnapshotMutableFloatState) ((NodeChain) anonymousClass2.val$requestCancellationCompleter).head).getFloatValue();
                float fMinPosition2 = ((NodeChain) anonymousClass2.val$requestCancellationCompleter).getAnchors().minPosition();
                float f2 = floatValue2 < fMinPosition2 ? fMinPosition2 - floatValue2 : 0.0f;
                reusableGraphicsLayerScope2.setScaleY(f2 > 0.0f ? 1 / ((Float.intBitsToFloat((int) (reusableGraphicsLayerScope2.size & 4294967295L)) + f2) / Float.intBitsToFloat((int) (reusableGraphicsLayerScope2.size & 4294967295L))) : 1.0f);
                reusableGraphicsLayerScope2.m450setTransformOrigin__ExYCQ(BrushKt.TransformOrigin(0.5f, 0.0f));
                return Unit.INSTANCE;
        }
    }
}
