package com.github.kr328.clash.log;

import android.util.Log;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import com.github.kr328.clash.core.model.FetchStatus;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.service.remote.IFetchObserver;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LogcatReader$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Ref$ObjectRef f$0;

    public /* synthetic */ LogcatReader$$ExternalSyntheticLambda3(Ref$ObjectRef ref$ObjectRef, int i) {
        this.$r8$classId = i;
        this.f$0 = ref$ObjectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Ref$ObjectRef ref$ObjectRef = this.f$0;
        switch (i) {
            case 0:
                List list = (List) obj;
                Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull((String) list.get(0));
                Date date = longOrNull != null ? new Date(longOrNull.longValue()) : (Date) ref$ObjectRef.element;
                LogMessage logMessage = StringsKt__StringsJVMKt.toLongOrNull((String) list.get(0)) != null ? new LogMessage(LogMessage.Level.valueOf((String) list.get(1)), (String) list.get(2), date) : new LogMessage(LogMessage.Level.Warning, CollectionsKt.joinToString$default(list, ":", null, null, null, 62), date);
                ref$ObjectRef.element = date;
                return logMessage;
            case 1:
                LazyLayoutPrefetchState lazyLayoutPrefetchState = ((TraversablePrefetchStateNode) ((TraversableNode) obj)).prefetchState;
                List listMutableListOf = (List) ref$ObjectRef.element;
                if (listMutableListOf != null) {
                    listMutableListOf.add(lazyLayoutPrefetchState);
                } else {
                    listMutableListOf = AppCompatHintHelper.mutableListOf(lazyLayoutPrefetchState);
                }
                ref$ObjectRef.element = listMutableListOf;
                return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
            default:
                FetchStatus fetchStatus = (FetchStatus) obj;
                try {
                    IFetchObserver iFetchObserver = (IFetchObserver) ref$ObjectRef.element;
                    if (iFetchObserver != null) {
                        iFetchObserver.updateStatus(fetchStatus);
                    }
                    break;
                } catch (Exception e) {
                    ref$ObjectRef.element = null;
                    Log.w("KoalaClash", "Report fetch status: " + e, e);
                }
                return Unit.INSTANCE;
        }
    }
}
