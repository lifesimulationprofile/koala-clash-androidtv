package androidx.compose.foundation.lazy;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.core.view.MenuHostHelper;
import androidx.room.RoomOpenHelper;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListIntervalContent {
    public final RoomOpenHelper intervals = new RoomOpenHelper(2, (byte) 0);

    public LazyListIntervalContent(Function1 function1) {
        function1.invoke(this);
    }

    public final void items(int i, Function1 function1, Function1 function2, ComposableLambdaImpl composableLambdaImpl) {
        this.intervals.addInterval(i, new MenuHostHelper(function1, function2, composableLambdaImpl, 12));
    }
}
