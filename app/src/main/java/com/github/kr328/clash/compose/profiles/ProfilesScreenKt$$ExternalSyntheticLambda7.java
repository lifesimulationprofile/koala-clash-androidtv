package com.github.kr328.clash.compose.profiles;

import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import androidx.compose.foundation.text.AndroidCursorHandle_androidKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.internal.mlkit_vision_common.zzit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProfilesScreenKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ ProfilesScreenKt$$ExternalSyntheticLambda7(int i, int i2, Object obj) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).intValue();
                zzit.AddProfilePillButton((Function0) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(this.f$1 | 1));
                break;
            case 1:
                LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) this.f$0;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    RoomOpenHelper roomOpenHelper = lazyListItemProviderImpl.intervalContent.intervals;
                    int i = this.f$1;
                    IntervalList$Interval intervalList$Interval = roomOpenHelper.get(i);
                    ((ComposableLambdaImpl) intervalList$Interval.value.mProviderToLifecycleContainers).invoke((Object) lazyListItemProviderImpl.itemScope, (Object) Integer.valueOf(i - intervalList$Interval.startIndex), (Object) gapComposer, (Object) 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                ((Integer) obj2).getClass();
                AndroidCursorHandle_androidKt.DefaultCursorHandle((Modifier) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1), this.f$1);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ProfilesScreenKt$$ExternalSyntheticLambda7(Modifier modifier, int i, int i2) {
        this.$r8$classId = 2;
        this.f$0 = modifier;
        this.f$1 = i2;
    }
}
