package kotlinx.coroutines.flow;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.compose.ui.Modifier;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StartedWhileSubscribed {
    public final boolean equals(Object obj) {
        return obj instanceof StartedWhileSubscribed;
    }

    public final int hashCode() {
        return (((int) 0) * 31) + ((int) 9223372034707292160L);
    }

    public final String toString() {
        return Modifier.CC.m(new StringBuilder("SharingStarted.WhileSubscribed("), CollectionsKt.joinToString$default(AppCompatHintHelper.build(new ListBuilder(2)), null, null, null, null, 63), ')');
    }
}
