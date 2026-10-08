package androidx.compose.animation.core;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Transition$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Transition f$0;

    public /* synthetic */ Transition$$ExternalSyntheticLambda0(Transition transition, int i) {
        this.$r8$classId = i;
        this.f$0 = transition;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                Transition transition = this.f$0;
                return Boolean.valueOf((Intrinsics.areEqual(transition.targetState$delegate.getValue(), transition.transitionState.mo773getCurrentState()) && transition.startTimeNanos$delegate.getLongValue() == Long.MIN_VALUE && !((Boolean) transition.updateChildrenNeeded$delegate.getValue()).booleanValue()) ? false : true);
            default:
                return Long.valueOf(this.f$0.calculateTotalDurationNanos());
        }
    }
}
