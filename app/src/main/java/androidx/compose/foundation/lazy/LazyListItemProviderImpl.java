package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.DefaultLazyKey;
import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.room.RoomOpenHelper;
import com.github.kr328.clash.compose.profiles.ProfilesScreenKt$$ExternalSyntheticLambda7;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListItemProviderImpl {
    public final LazyListIntervalContent intervalContent;
    public final LazyItemScopeImpl itemScope;
    public final RoomOpenHelper keyIndexMap;
    public final LazyListState state;

    public LazyListItemProviderImpl(LazyListState lazyListState, LazyListIntervalContent lazyListIntervalContent, LazyItemScopeImpl lazyItemScopeImpl, RoomOpenHelper roomOpenHelper) {
        this.state = lazyListState;
        this.intervalContent = lazyListIntervalContent;
        this.itemScope = lazyItemScopeImpl;
        this.keyIndexMap = roomOpenHelper;
    }

    public final void Item(int i, Object obj, GapComposer gapComposer, int i2) {
        int i3;
        Object obj2;
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(-462424778);
        int i4 = (gapComposer.changed(i) ? 4 : 2) | i2 | (gapComposer.changedInstance(obj) ? 32 : 16) | (gapComposer.changed(this) ? 256 : 128);
        if (gapComposer.shouldExecute(i4 & 1, (i4 & 147) != 146)) {
            i3 = i;
            obj2 = obj;
            gapComposer2 = gapComposer;
            LazyLayoutKt.LazyLayoutPinnableItem(obj2, i3, this.state.pinnedItems, Thread_jvmKt.rememberComposableLambda(-824725566, new ProfilesScreenKt$$ExternalSyntheticLambda7(i, 1, this), gapComposer), gapComposer2, ((i4 >> 3) & 14) | 3072 | ((i4 << 3) & 112));
        } else {
            i3 = i;
            obj2 = obj;
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LazyListItemProviderImpl$$ExternalSyntheticLambda1(this, i3, obj2, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyListItemProviderImpl)) {
            return false;
        }
        return Intrinsics.areEqual(this.intervalContent, ((LazyListItemProviderImpl) obj).intervalContent);
    }

    public final Object getContentType(int i) {
        LazyListIntervalContent lazyListIntervalContent = this.intervalContent;
        lazyListIntervalContent.getClass();
        IntervalList$Interval intervalList$Interval = lazyListIntervalContent.intervals.get(i);
        return ((Function1) intervalList$Interval.value.mMenuProviders).invoke(Integer.valueOf(i - intervalList$Interval.startIndex));
    }

    public final int getItemCount() {
        LazyListIntervalContent lazyListIntervalContent = this.intervalContent;
        lazyListIntervalContent.getClass();
        return lazyListIntervalContent.intervals.version;
    }

    public final Object getKey(int i) {
        Object objInvoke;
        RoomOpenHelper roomOpenHelper = this.keyIndexMap;
        Object[] objArr = (Object[]) roomOpenHelper.mDelegate;
        int i2 = i - roomOpenHelper.version;
        Object obj = (i2 < 0 || i2 >= objArr.length) ? null : objArr[i2];
        if (obj != null) {
            return obj;
        }
        LazyListIntervalContent lazyListIntervalContent = this.intervalContent;
        lazyListIntervalContent.getClass();
        IntervalList$Interval intervalList$Interval = lazyListIntervalContent.intervals.get(i);
        int i3 = i - intervalList$Interval.startIndex;
        Function1 function1 = (Function1) intervalList$Interval.value.mOnInvalidateMenuCallback;
        return (function1 == null || (objInvoke = function1.invoke(Integer.valueOf(i3))) == null) ? new DefaultLazyKey(i) : objInvoke;
    }

    public final int hashCode() {
        return this.intervalContent.hashCode();
    }
}
