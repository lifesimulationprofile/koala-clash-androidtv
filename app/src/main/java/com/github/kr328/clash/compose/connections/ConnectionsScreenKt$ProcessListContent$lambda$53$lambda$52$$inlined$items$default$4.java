package com.github.kr328.clash.compose.connections;

import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import com.github.kr328.clash.compose.profiles.ProfilesScreenKt$ProfilesScreen$2$1$2$1$2$2$1;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzjf;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionsScreenKt$ProcessListContent$lambda$53$lambda$52$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ List $items;
    public final /* synthetic */ Function1 $onSelectProcess$inlined;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ConnectionsScreenKt$ProcessListContent$lambda$53$lambda$52$$inlined$items$default$4(int i, List list, Function1 function1) {
        this.$r8$classId = i;
        this.$items = list;
        this.$onSelectProcess$inlined = function1;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        int i2;
        switch (this.$r8$classId) {
            case 0:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                GapComposer gapComposer = (GapComposer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                if ((iIntValue2 & 6) == 0) {
                    i = (gapComposer.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                } else {
                    i = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i |= gapComposer.changed(iIntValue) ? 32 : 16;
                }
                if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    ProcessGroup processGroup = (ProcessGroup) this.$items.get(iIntValue);
                    gapComposer.startReplaceGroup(1849404898);
                    gapComposer.startReplaceGroup(-1464361285);
                    Function1 function1 = this.$onSelectProcess$inlined;
                    boolean zChanged = gapComposer.changed(function1) | gapComposer.changedInstance(processGroup);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new Http2Connection.ReaderRunnable(5, function1, processGroup);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    gapComposer.end(false);
                    ConnectionsScreenKt.ProcessCard(processGroup, (Function0) objRememberedValue, gapComposer, 0);
                    gapComposer.end(false);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                if ((iIntValue4 & 6) == 0) {
                    i2 = (gapComposer2.changed(lazyItemScopeImpl2) ? 4 : 2) | iIntValue4;
                } else {
                    i2 = iIntValue4;
                }
                if ((iIntValue4 & 48) == 0) {
                    i2 |= gapComposer2.changed(iIntValue3) ? 32 : 16;
                }
                if (gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    Profile profile = (Profile) this.$items.get(iIntValue3);
                    gapComposer2.startReplaceGroup(906780171);
                    gapComposer2.startReplaceGroup(-1217671761);
                    Function1 function2 = this.$onSelectProcess$inlined;
                    boolean zChanged2 = gapComposer2.changed(function2) | gapComposer2.changedInstance(profile);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer$Companion.Empty) {
                        objRememberedValue2 = new ProfilesScreenKt$ProfilesScreen$2$1$2$1$2$2$1(function2, profile, 1);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    gapComposer2.end(false);
                    zzjf.ProfileItem(profile, (Function0) objRememberedValue2, gapComposer2, 0);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
