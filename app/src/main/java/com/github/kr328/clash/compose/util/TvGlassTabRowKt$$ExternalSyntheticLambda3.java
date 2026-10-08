package com.github.kr328.clash.compose.util;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvGlassTabRowKt$$ExternalSyntheticLambda3 implements Function3 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SnapshotStateMap f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ SnapshotStateMap f$2;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$3;

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda3(SnapshotStateMap snapshotStateMap, int i, SnapshotStateMap snapshotStateMap2, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, int i2) {
        this.$r8$classId = i2;
        this.f$0 = snapshotStateMap;
        this.f$1 = i;
        this.f$2 = snapshotStateMap2;
        this.f$3 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.$r8$classId;
        Float f = (Float) obj;
        f.floatValue();
        Float f2 = (Float) obj2;
        f2.floatValue();
        float fFloatValue = ((Float) obj3).floatValue();
        switch (i) {
            case 0:
                int i2 = this.f$1;
                this.f$0.put(Integer.valueOf(i2), f);
                this.f$2.put(Integer.valueOf(i2), f2);
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$3;
                if (parcelableSnapshotMutableFloatState.getFloatValue() == 0.0f) {
                    parcelableSnapshotMutableFloatState.setFloatValue(fFloatValue);
                }
                break;
            default:
                int i3 = this.f$1;
                this.f$0.put(Integer.valueOf(i3), f);
                this.f$2.put(Integer.valueOf(i3), f2);
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = this.f$3;
                if (parcelableSnapshotMutableFloatState2.getFloatValue() == 0.0f) {
                    parcelableSnapshotMutableFloatState2.setFloatValue(fFloatValue);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
