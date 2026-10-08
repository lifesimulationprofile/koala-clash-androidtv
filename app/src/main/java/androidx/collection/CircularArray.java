package androidx.collection;

import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;
import androidx.recyclerview.widget.RecyclerView;
import com.github.kr328.clash.core.model.LogMessage;
import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CircularArray {
    public final /* synthetic */ int $r8$classId;
    public int capacityBitmask;
    public Object elements;
    public int head;
    public int tail;

    public /* synthetic */ CircularArray(int i) {
        this.$r8$classId = i;
    }

    public void addLast(LogMessage logMessage) {
        Object[] objArr = (Object[]) this.elements;
        int i = this.tail;
        objArr[i] = logMessage;
        int i2 = this.capacityBitmask & (i + 1);
        this.tail = i2;
        int i3 = this.head;
        if (i2 == i3) {
            int length = objArr.length;
            int i4 = length - i3;
            int i5 = length << 1;
            if (i5 < 0) {
                throw new RuntimeException("Max array capacity exceeded");
            }
            Object[] objArr2 = new Object[i5];
            ArraysKt.copyInto(objArr, objArr2, 0, i3, length);
            ArraysKt.copyInto((Object[]) this.elements, objArr2, i4, 0, this.head);
            this.elements = objArr2;
            this.head = 0;
            this.tail = length;
            this.capacityBitmask = i5 - 1;
        }
    }

    public void addPosition(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i3 = this.capacityBitmask;
        int i4 = i3 * 2;
        int[] iArr = (int[]) this.elements;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.elements = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i4 >= iArr.length) {
            int[] iArr3 = new int[i3 * 4];
            this.elements = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = (int[]) this.elements;
        iArr4[i4] = i;
        iArr4[i4 + 1] = i2;
        this.capacityBitmask++;
    }

    public void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z) {
        this.capacityBitmask = 0;
        int[] iArr = (int[]) this.elements;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
        if (recyclerView.mAdapter == null || layoutManager == null || !layoutManager.mItemPrefetchEnabled) {
            return;
        }
        if (z) {
            if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
            }
        } else if (!recyclerView.hasPendingAdapterUpdates()) {
            layoutManager.collectAdjacentPrefetchPositions(this.head, this.tail, recyclerView.mState, this);
        }
        int i = this.capacityBitmask;
        if (i > layoutManager.mPrefetchMaxCountObserved) {
            layoutManager.mPrefetchMaxCountObserved = i;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
            recyclerView.mRecycler.updateViewCacheSize();
        }
    }

    public int gapLength() {
        return this.capacityBitmask - this.tail;
    }

    public int getInt(int i) {
        return ((Operations) this.elements).intArgs[this.tail + i];
    }

    /* JADX INFO: renamed from: getObject-PtL-UHM, reason: not valid java name */
    public Object m20getObjectPtLUHM(int i) {
        return ((Operations) this.elements).objectArgs[this.capacityBitmask + i];
    }

    public void removeFromStart() {
        if (1 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = ((Object[]) this.elements).length;
        int i = this.head;
        if (1 < length - i) {
            length = i + 1;
        }
        while (i < length) {
            ((Object[]) this.elements)[i] = null;
            i++;
        }
        int i2 = this.head;
        int i3 = length - i2;
        int i4 = 1 - i3;
        this.head = this.capacityBitmask & (i2 + i3);
        if (i4 > 0) {
            for (int i5 = 0; i5 < i4; i5++) {
                ((Object[]) this.elements)[i5] = null;
            }
            this.head = i4;
        }
    }

    public int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                return "";
            default:
                return super.toString();
        }
    }

    public CircularArray(Operations operations) {
        this.$r8$classId = 1;
        this.elements = operations;
    }
}
