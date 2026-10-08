package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.node.NodeChain;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ float f$1;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda13(Object obj, float f, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = f;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                float floatValue = ((ParcelableSnapshotMutableFloatState) ((NodeChain) ((SheetState) this.f$0).anchoredDraggableState.val$requestCancellationCompleter).head).getFloatValue();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (reusableGraphicsLayerScope.size & 4294967295L));
                if (!Float.isNaN(floatValue) && !Float.isNaN(fIntBitsToFloat) && fIntBitsToFloat != 0.0f) {
                    float f = this.f$1;
                    reusableGraphicsLayerScope.setScaleX(BottomSheetKt.calculateSheetPredictiveBackScaleX(reusableGraphicsLayerScope, f));
                    reusableGraphicsLayerScope.setScaleY(BottomSheetKt.calculateSheetPredictiveBackScaleY(reusableGraphicsLayerScope, f));
                    reusableGraphicsLayerScope.m450setTransformOrigin__ExYCQ(BrushKt.TransformOrigin(0.5f, (floatValue + fIntBitsToFloat) / fIntBitsToFloat));
                }
                break;
            default:
                Transition transition = (Transition) this.f$0;
                long jLongValue = ((Long) obj).longValue();
                boolean zIsSeeking = transition.isSeeking();
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = transition.startTimeNanos$delegate;
                if (!zIsSeeking) {
                    if (parcelableSnapshotMutableLongState.getLongValue() == Long.MIN_VALUE) {
                        parcelableSnapshotMutableLongState.setLongValue(jLongValue);
                        ((ParcelableSnapshotMutableState) transition.transitionState.internalScopeRef).setValue(Boolean.TRUE);
                    }
                    long longValue = jLongValue - parcelableSnapshotMutableLongState.getLongValue();
                    float f2 = this.f$1;
                    if (f2 != 0.0f) {
                        longValue = MathKt.roundToLong(longValue / ((double) f2));
                    }
                    transition.setPlayTimeNanos(longValue);
                    transition.onFrame$animation_core(longValue, f2 == 0.0f);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
