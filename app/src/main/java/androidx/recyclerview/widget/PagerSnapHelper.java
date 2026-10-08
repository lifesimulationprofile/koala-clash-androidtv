package androidx.recyclerview.widget;

import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PagerSnapHelper extends RecyclerView.OnFlingListener {
    public OrientationHelper$1 mHorizontalHelper;
    public RecyclerView mRecyclerView;
    public final SnapHelper$1 mScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.SnapHelper$1
        public boolean mScrolled = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && this.mScrolled) {
                this.mScrolled = false;
                this.this$0.snapToTargetExistingView();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.mScrolled = true;
        }
    };
    public OrientationHelper$1 mVerticalHelper;

    public static int distanceToCenter(View view, EmojiCompat.Config config) {
        return ((config.getDecoratedMeasurement(view) / 2) + config.getDecoratedStart(view)) - ((config.getTotalSpace() / 2) + config.getStartAfterPadding());
    }

    public static View findCenterView(RecyclerView.LayoutManager layoutManager, EmojiCompat.Config config) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int totalSpace = (config.getTotalSpace() / 2) + config.getStartAfterPadding();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int iAbs = Math.abs(((config.getDecoratedMeasurement(childAt) / 2) + config.getDecoratedStart(childAt)) - totalSpace);
            if (iAbs < i) {
                view = childAt;
                i = iAbs;
            }
        }
        return view;
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(view, getVerticalHelper(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public final EmojiCompat.Config getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper$1 orientationHelper$1 = this.mHorizontalHelper;
        if (orientationHelper$1 == null || ((RecyclerView.LayoutManager) orientationHelper$1.mMetadataLoader) != layoutManager) {
            this.mHorizontalHelper = new OrientationHelper$1(layoutManager, 0);
        }
        return this.mHorizontalHelper;
    }

    public final EmojiCompat.Config getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper$1 orientationHelper$1 = this.mVerticalHelper;
        if (orientationHelper$1 == null || ((RecyclerView.LayoutManager) orientationHelper$1.mMetadataLoader) != layoutManager) {
            this.mVerticalHelper = new OrientationHelper$1(layoutManager, 1);
        }
        return this.mVerticalHelper;
    }

    public final void snapToTargetExistingView() {
        RecyclerView.LayoutManager layoutManager;
        View viewFindCenterView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager.canScrollVertically()) {
            viewFindCenterView = findCenterView(layoutManager, getVerticalHelper(layoutManager));
        } else {
            viewFindCenterView = layoutManager.canScrollHorizontally() ? findCenterView(layoutManager, getHorizontalHelper(layoutManager)) : null;
        }
        if (viewFindCenterView == null) {
            return;
        }
        int[] iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, viewFindCenterView);
        int i = iArrCalculateDistanceToFinalSnap[0];
        if (i == 0 && iArrCalculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy$1(i, iArrCalculateDistanceToFinalSnap[1], false);
    }
}
