package com.github.kr328.clash.compose;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.focus.FocusRequester;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvMainAppKt$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$1;

    public /* synthetic */ TvMainAppKt$$ExternalSyntheticLambda2(List list, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, int i) {
        this.$r8$classId = i;
        this.f$0 = list;
        this.f$1 = parcelableSnapshotMutableIntState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$1;
        List list = this.f$0;
        switch (i) {
            case 0:
                parcelableSnapshotMutableIntState.setIntValue(0);
                FocusRequester.m349requestFocus3ESFkO8$default((FocusRequester) list.get(0));
                break;
            default:
                float f = TvMainAppKt.TvOverscanHorizontal;
                FocusRequester.m349requestFocus3ESFkO8$default((FocusRequester) list.get(parcelableSnapshotMutableIntState.getIntValue()));
                break;
        }
        return Unit.INSTANCE;
    }
}
