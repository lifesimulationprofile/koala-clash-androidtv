package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPinnableItem {
    public boolean isDisposed;
    public final Object key;
    public LazyLayoutPinnableItem parentHandle;
    public final LazyLayoutPinnedItemList pinnedItemList;
    public int pinsCount;
    public int index = -1;
    public final ParcelableSnapshotMutableState _parentPinnableContainer$delegate = Stack.mutableStateOf$default(null);

    public LazyLayoutPinnableItem(Object obj, LazyLayoutPinnedItemList lazyLayoutPinnedItemList) {
        this.key = obj;
        this.pinnedItemList = lazyLayoutPinnedItemList;
    }

    public final LazyLayoutPinnableItem pin() {
        if (this.isDisposed) {
            InlineClassHelperKt.throwIllegalStateException("Pin should not be called on an already disposed item ");
        }
        if (this.pinsCount == 0) {
            this.pinnedItemList.items.add(this);
            LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) this._parentPinnableContainer$delegate.getValue();
            if (lazyLayoutPinnableItem != null) {
                lazyLayoutPinnableItem.pin();
            } else {
                lazyLayoutPinnableItem = null;
            }
            this.parentHandle = lazyLayoutPinnableItem;
        }
        this.pinsCount++;
        return this;
    }

    public final void release() {
        if (this.isDisposed) {
            return;
        }
        if (this.pinsCount <= 0) {
            InlineClassHelperKt.throwIllegalStateException("Release should only be called once");
        }
        int i = this.pinsCount - 1;
        this.pinsCount = i;
        if (i == 0) {
            this.pinnedItemList.items.remove(this);
            LazyLayoutPinnableItem lazyLayoutPinnableItem = this.parentHandle;
            if (lazyLayoutPinnableItem != null) {
                lazyLayoutPinnableItem.release();
            }
            this.parentHandle = null;
        }
    }
}
