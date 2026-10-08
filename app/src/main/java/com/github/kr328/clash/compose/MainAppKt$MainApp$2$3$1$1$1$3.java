package com.github.kr328.clash.compose;

import android.content.Context;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.Thread_jvmKt;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.core.model.ConnectionInfo;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MainAppKt$MainApp$2$3$1$1$1$3 implements Function4 {
    public final /* synthetic */ Object $context;
    public final /* synthetic */ Object $padding;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ MainAppKt$MainApp$2$3$1$1$1$3(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.$context = obj;
        this.$padding = obj2;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        int i2;
        switch (this.$r8$classId) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj3;
                MainAppKt.ScreenWrapper((AnimatedContentScopeImpl) obj, Thread_jvmKt.rememberComposableLambda(-304818265, new LogsScreenKt.AnonymousClass1.AnonymousClass3.AnonymousClass2(1, (Context) this.$context, (PaddingValues) this.$padding), gapComposer), gapComposer, (((Number) obj4).intValue() & 14) | 48);
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                final Function2 function2 = (Function2) this.$padding;
                if ((iIntValue2 & 6) == 0) {
                    i = (gapComposer2.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                } else {
                    i = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i |= gapComposer2.changed(iIntValue) ? 32 : 16;
                }
                if (gapComposer2.shouldExecute(i & 1, (i & 147) != 146)) {
                    final ConnectionInfo connectionInfo = (ConnectionInfo) ((List) this.$context).get(iIntValue);
                    gapComposer2.startReplaceGroup(-575229047);
                    gapComposer2.startReplaceGroup(1921110637);
                    boolean zChanged = gapComposer2.changed(function2) | gapComposer2.changedInstance(connectionInfo);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                        final int i3 = 0;
                        objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$ConnectionListContent$1$1$3$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i3) {
                                    case 0:
                                        function2.invoke(connectionInfo, Boolean.FALSE);
                                        break;
                                    default:
                                        function2.invoke(connectionInfo, Boolean.TRUE);
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    gapComposer2.end(false);
                    ConnectionsScreenKt.ConnectionCard(connectionInfo, true, (Function0) objRememberedValue, gapComposer2, 48);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                final Function2 function3 = (Function2) this.$padding;
                if ((iIntValue4 & 6) == 0) {
                    i2 = (gapComposer3.changed(lazyItemScopeImpl2) ? 4 : 2) | iIntValue4;
                } else {
                    i2 = iIntValue4;
                }
                if ((iIntValue4 & 48) == 0) {
                    i2 |= gapComposer3.changed(iIntValue3) ? 32 : 16;
                }
                if (gapComposer3.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    final ConnectionInfo connectionInfo2 = (ConnectionInfo) ((List) this.$context).get(iIntValue3);
                    gapComposer3.startReplaceGroup(-574584247);
                    gapComposer3.startReplaceGroup(1921131468);
                    boolean zChanged2 = gapComposer3.changed(function3) | gapComposer3.changedInstance(connectionInfo2);
                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer$Companion.Empty) {
                        final int i4 = 1;
                        objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$ConnectionListContent$1$1$3$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i4) {
                                    case 0:
                                        function3.invoke(connectionInfo2, Boolean.FALSE);
                                        break;
                                    default:
                                        function3.invoke(connectionInfo2, Boolean.TRUE);
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    }
                    gapComposer3.end(false);
                    ConnectionsScreenKt.ConnectionCard(connectionInfo2, false, (Function0) objRememberedValue2, gapComposer3, 48);
                    gapComposer3.end(false);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
