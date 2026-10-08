package androidx.recyclerview.widget;

import android.os.Trace;
import androidx.collection.CircularArray;
import androidx.core.os.TraceCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GapWorker implements Runnable {
    public static final ThreadLocal sGapWorker = new ThreadLocal();
    public static final AnonymousClass1 sTaskComparator = new AnonymousClass1(0);
    public long mFrameIntervalNs;
    public long mPostTimeNs;
    public ArrayList mRecyclerViews;
    public ArrayList mTasks;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.GapWorker$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Comparator {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00bc, code lost:
        
            if (r0 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c5, code lost:
        
            if (r0 != false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
        
            return 1;
         */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int compare(java.lang.Object r7, java.lang.Object r8) {
            /*
                Method dump skipped, instruction units count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GapWorker.AnonymousClass1.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;
    }

    public static RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i, long j) {
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return null;
            }
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder viewHolderTryGetViewHolderForPositionByDeadline = recycler.tryGetViewHolderForPositionByDeadline(i, j);
            if (viewHolderTryGetViewHolderForPositionByDeadline != null) {
                if (!viewHolderTryGetViewHolderForPositionByDeadline.isBound() || viewHolderTryGetViewHolderForPositionByDeadline.isInvalid()) {
                    recycler.addViewHolderToRecycledViewPool(viewHolderTryGetViewHolderForPositionByDeadline, false);
                } else {
                    recycler.recycleView(viewHolderTryGetViewHolderForPositionByDeadline.itemView);
                }
            }
            return viewHolderTryGetViewHolderForPositionByDeadline;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public final void postFromTraversal(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.mIsAttached && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        CircularArray circularArray = recyclerView.mPrefetchRegistry;
        circularArray.head = i;
        circularArray.tail = i2;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00cd  */
    public final void prefetch(long j) {
        Task task;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Task task2;
        ArrayList arrayList = this.mTasks;
        ArrayList arrayList2 = this.mRecyclerViews;
        int size = arrayList2.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList2.get(i2);
            int windowVisibility = recyclerView3.getWindowVisibility();
            CircularArray circularArray = recyclerView3.mPrefetchRegistry;
            if (windowVisibility == 0) {
                circularArray.collectPrefetchPositionsFromView(recyclerView3, false);
                i += circularArray.capacityBitmask;
            }
        }
        arrayList.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList2.get(i4);
            if (recyclerView4.getWindowVisibility() == 0) {
                CircularArray circularArray2 = recyclerView4.mPrefetchRegistry;
                int iAbs = Math.abs(circularArray2.tail) + Math.abs(circularArray2.head);
                for (int i5 = 0; i5 < circularArray2.capacityBitmask * 2; i5 += 2) {
                    if (i3 >= arrayList.size()) {
                        task2 = new Task();
                        arrayList.add(task2);
                    } else {
                        task2 = (Task) arrayList.get(i3);
                    }
                    int[] iArr = (int[]) circularArray2.elements;
                    int i6 = iArr[i5 + 1];
                    task2.immediate = i6 <= iAbs;
                    task2.viewVelocity = iAbs;
                    task2.distanceToItem = i6;
                    task2.view = recyclerView4;
                    task2.position = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(arrayList, sTaskComparator);
        for (int i7 = 0; i7 < arrayList.size() && (recyclerView = (task = (Task) arrayList.get(i7)).view) != null; i7++) {
            RecyclerView.ViewHolder viewHolderPrefetchPositionWithDeadline = prefetchPositionWithDeadline(recyclerView, task.position, task.immediate ? Long.MAX_VALUE : j);
            if (viewHolderPrefetchPositionWithDeadline != null && viewHolderPrefetchPositionWithDeadline.mNestedRecyclerView != null && viewHolderPrefetchPositionWithDeadline.isBound() && !viewHolderPrefetchPositionWithDeadline.isInvalid() && (recyclerView2 = (RecyclerView) viewHolderPrefetchPositionWithDeadline.mNestedRecyclerView.get()) != null) {
                if (recyclerView2.mDataSetHasChangedAfterLayout && recyclerView2.mChildHelper.getUnfilteredChildCount() != 0) {
                    RecyclerView.Recycler recycler = recyclerView2.mRecycler;
                    RecyclerView.ItemAnimator itemAnimator = recyclerView2.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimations();
                    }
                    RecyclerView.LayoutManager layoutManager = recyclerView2.mLayout;
                    if (layoutManager != null) {
                        layoutManager.removeAndRecycleAllViews(recycler);
                        recyclerView2.mLayout.removeAndRecycleScrapInt(recycler);
                    }
                    recycler.mAttachedScrap.clear();
                    recycler.recycleAndClearCachedViews();
                }
                CircularArray circularArray3 = recyclerView2.mPrefetchRegistry;
                circularArray3.collectPrefetchPositionsFromView(recyclerView2, true);
                if (circularArray3.capacityBitmask != 0) {
                    try {
                        int i8 = TraceCompat.$r8$clinit;
                        Trace.beginSection("RV Nested Prefetch");
                        RecyclerView.State state = recyclerView2.mState;
                        RecyclerView.Adapter adapter = recyclerView2.mAdapter;
                        state.mLayoutStep = 1;
                        state.mItemCount = adapter.getItemCount();
                        state.mInPreLayout = false;
                        state.mTrackOldChangeHolders = false;
                        state.mIsMeasuring = false;
                        for (int i9 = 0; i9 < circularArray3.capacityBitmask * 2; i9 += 2) {
                            prefetchPositionWithDeadline(recyclerView2, ((int[]) circularArray3.elements)[i9], j);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        int i10 = TraceCompat.$r8$clinit;
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            task.immediate = false;
            task.viewVelocity = 0;
            task.distanceToItem = 0;
            task.view = null;
            task.position = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.mRecyclerViews;
        try {
            int i = TraceCompat.$r8$clinit;
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    prefetch(TimeUnit.MILLISECONDS.toNanos(jMax) + this.mFrameIntervalNs);
                }
            }
            this.mPostTimeNs = 0L;
        } finally {
            this.mPostTimeNs = 0L;
            int i3 = TraceCompat.$r8$clinit;
            Trace.endSection();
        }
    }
}
