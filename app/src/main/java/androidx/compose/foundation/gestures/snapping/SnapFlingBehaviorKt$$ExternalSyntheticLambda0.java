package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnapFlingBehaviorKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ float f$0;
    public final /* synthetic */ Ref$FloatRef f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ SnapFlingBehaviorKt$$ExternalSyntheticLambda0(float f, Ref$FloatRef ref$FloatRef, Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = f;
        this.f$1 = ref$FloatRef;
        this.f$2 = obj;
        this.f$3 = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        float fScrollBy;
        switch (this.$r8$classId) {
            case 0:
                ScrollScope scrollScope = (ScrollScope) this.f$2;
                Function1 function1 = (Function1) this.f$3;
                AnimationScope animationScope = (AnimationScope) obj;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = animationScope.value$delegate;
                float fAbs = Math.abs(((Number) parcelableSnapshotMutableState.getValue()).floatValue());
                float f = this.f$0;
                float fAbs2 = Math.abs(f);
                Ref$FloatRef ref$FloatRef = this.f$1;
                if (fAbs >= fAbs2) {
                    float fCoerceToTarget = UuidKt.coerceToTarget(((Number) parcelableSnapshotMutableState.getValue()).floatValue(), f);
                    UuidKt.animateDecay$consumeDelta(animationScope, scrollScope, function1, fCoerceToTarget - ref$FloatRef.element);
                    animationScope.cancelAnimation();
                    ref$FloatRef.element = fCoerceToTarget;
                } else {
                    UuidKt.animateDecay$consumeDelta(animationScope, scrollScope, function1, ((Number) parcelableSnapshotMutableState.getValue()).floatValue() - ref$FloatRef.element);
                    ref$FloatRef.element = ((Number) parcelableSnapshotMutableState.getValue()).floatValue();
                }
                break;
            case 1:
                ScrollScope scrollScope2 = (ScrollScope) this.f$2;
                Function1 function2 = (Function1) this.f$3;
                AnimationScope animationScope2 = (AnimationScope) obj;
                float fCoerceToTarget2 = UuidKt.coerceToTarget(((Number) animationScope2.value$delegate.getValue()).floatValue(), this.f$0);
                Ref$FloatRef ref$FloatRef2 = this.f$1;
                float f2 = fCoerceToTarget2 - ref$FloatRef2.element;
                try {
                    fScrollBy = scrollScope2.scrollBy(f2);
                } catch (CancellationException unused) {
                    animationScope2.cancelAnimation();
                    fScrollBy = 0.0f;
                }
                function2.invoke(Float.valueOf(fScrollBy));
                if (Math.abs(f2 - fScrollBy) > 0.5f || fCoerceToTarget2 != ((Number) animationScope2.value$delegate.getValue()).floatValue()) {
                    animationScope2.cancelAnimation();
                }
                ref$FloatRef2.element += fScrollBy;
                break;
            default:
                AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = (AnchoredDraggableState$anchoredDragScope$1) this.f$2;
                Ref$FloatRef ref$FloatRef3 = (Ref$FloatRef) this.f$3;
                AnimationScope animationScope3 = (AnimationScope) obj;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = animationScope3.value$delegate;
                float fFloatValue = ((Number) parcelableSnapshotMutableState2.getValue()).floatValue();
                float f3 = this.f$0;
                Ref$FloatRef ref$FloatRef4 = this.f$1;
                if ((fFloatValue >= f3 || ref$FloatRef4.element <= f3) && (((Number) parcelableSnapshotMutableState2.getValue()).floatValue() <= f3 || ref$FloatRef4.element >= f3)) {
                    anchoredDraggableState$anchoredDragScope$1.dragTo(((Number) parcelableSnapshotMutableState2.getValue()).floatValue(), ((Number) animationScope3.getVelocity()).floatValue());
                    ref$FloatRef3.element = ((Number) animationScope3.getVelocity()).floatValue();
                    ref$FloatRef4.element = ((Number) parcelableSnapshotMutableState2.getValue()).floatValue();
                } else {
                    float fFloatValue2 = ((Number) parcelableSnapshotMutableState2.getValue()).floatValue();
                    if (f3 == 0.0f) {
                        f3 = 0.0f;
                    } else if (f3 <= 0.0f ? fFloatValue2 >= f3 : fFloatValue2 <= f3) {
                        f3 = fFloatValue2;
                    }
                    anchoredDraggableState$anchoredDragScope$1.dragTo(f3, ((Number) animationScope3.getVelocity()).floatValue());
                    ref$FloatRef3.element = Float.isNaN(((Number) animationScope3.getVelocity()).floatValue()) ? 0.0f : ((Number) animationScope3.getVelocity()).floatValue();
                    ref$FloatRef4.element = f3;
                    animationScope3.cancelAnimation();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
