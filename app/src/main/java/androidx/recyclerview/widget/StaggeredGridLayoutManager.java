package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.collection.CircularArray;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.fragment.app.FragmentState;
import coil.request.RequestService;
import com.google.android.gms.tasks.zzg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView$SmoothScroller$ScrollVectorProvider {
    public final AnchorInfo mAnchorInfo;
    public final zzg mCheckForGapsRunnable;
    public final int mGapStrategy;
    public boolean mLastLayoutFromEnd;
    public boolean mLastLayoutRTL;
    public final LayoutState mLayoutState;
    public final RequestService mLazySpanLookup;
    public final int mOrientation;
    public SavedState mPendingSavedState;
    public int[] mPrefetchDistances;
    public final EmojiCompat.Config mPrimaryOrientation;
    public final BitSet mRemainingSpans;
    public boolean mReverseLayout;
    public final EmojiCompat.Config mSecondaryOrientation;
    public int mSizePerSpan;
    public final boolean mSmoothScrollbarEnabled;
    public final int mSpanCount;
    public final Span[] mSpans;
    public final Rect mTmpRect;
    public boolean mShouldReverseLayout = false;
    public int mPendingScrollPosition = -1;
    public int mPendingScrollPositionOffset = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnchorInfo {
        public boolean mInvalidateOffsets;
        public boolean mLayoutFromEnd;
        public int mOffset;
        public int mPosition;
        public int[] mSpanReferenceLines;
        public boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public final void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class LayoutParams extends RecyclerView.LayoutParams {
        public Span mSpan;
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new FragmentState.AnonymousClass1(12);
        public boolean mAnchorLayoutFromEnd;
        public int mAnchorPosition;
        public ArrayList mFullSpanItems;
        public boolean mLastLayoutRTL;
        public boolean mReverseLayout;
        public int[] mSpanLookup;
        public int mSpanLookupSize;
        public int[] mSpanOffsets;
        public int mSpanOffsetsSize;
        public int mVisibleAnchorPosition;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Span {
        public final int mIndex;
        public final ArrayList mViews = new ArrayList();
        public int mCachedStart = Integer.MIN_VALUE;
        public int mCachedEnd = Integer.MIN_VALUE;
        public int mDeletedSize = 0;

        public Span(int i) {
            this.mIndex = i;
        }

        public final void calculateCachedEnd() {
            ArrayList arrayList = this.mViews;
            View view = (View) arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            layoutParams.getClass();
        }

        public final void clear() {
            this.mViews.clear();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
        }

        public final int findFirstPartiallyVisibleItemPosition() {
            boolean z = StaggeredGridLayoutManager.this.mReverseLayout;
            ArrayList arrayList = this.mViews;
            return z ? findOnePartiallyVisibleChild(arrayList.size() - 1, -1) : findOnePartiallyVisibleChild(0, arrayList.size());
        }

        public final int findLastPartiallyVisibleItemPosition() {
            boolean z = StaggeredGridLayoutManager.this.mReverseLayout;
            ArrayList arrayList = this.mViews;
            return z ? findOnePartiallyVisibleChild(0, arrayList.size()) : findOnePartiallyVisibleChild(arrayList.size() - 1, -1);
        }

        public final int findOnePartiallyVisibleChild(int i, int i2) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            int startAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = (View) this.mViews.get(i);
                int decoratedStart = staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedEnd(view);
                boolean z = decoratedStart <= endAfterPadding;
                boolean z2 = decoratedEnd >= startAfterPadding;
                if (z && z2 && (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding)) {
                    return RecyclerView.LayoutManager.getPosition(view);
                }
                i += i3;
            }
            return -1;
        }

        public final int getEndLine(int i) {
            int i2 = this.mCachedEnd;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public final View getFocusableViewAfter(int i, int i2) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            ArrayList arrayList = this.mViews;
            View view = null;
            if (i2 != -1) {
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    View view2 = (View) arrayList.get(size);
                    if ((staggeredGridLayoutManager.mReverseLayout && RecyclerView.LayoutManager.getPosition(view2) >= i) || ((!staggeredGridLayoutManager.mReverseLayout && RecyclerView.LayoutManager.getPosition(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
                return view;
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                View view3 = (View) arrayList.get(i3);
                if ((staggeredGridLayoutManager.mReverseLayout && RecyclerView.LayoutManager.getPosition(view3) <= i) || ((!staggeredGridLayoutManager.mReverseLayout && RecyclerView.LayoutManager.getPosition(view3) >= i) || !view3.hasFocusable())) {
                    break;
                }
                i3++;
                view = view3;
            }
            return view;
        }

        public final int getStartLine(int i) {
            int i2 = this.mCachedStart;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            ArrayList arrayList = this.mViews;
            if (arrayList.size() == 0) {
                return i;
            }
            View view = (View) arrayList.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            layoutParams.getClass();
            return this.mCachedStart;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        RequestService requestService = new RequestService(22, false);
        this.mLazySpanLookup = requestService;
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo();
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new zzg(17, this);
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i3 != this.mOrientation) {
            this.mOrientation = i3;
            EmojiCompat.Config config = this.mPrimaryOrientation;
            this.mPrimaryOrientation = this.mSecondaryOrientation;
            this.mSecondaryOrientation = config;
            requestLayout();
        }
        int i4 = properties.spanCount;
        assertNotInLayoutOrScroll(null);
        if (i4 != this.mSpanCount) {
            requestService.clear();
            requestLayout();
            this.mSpanCount = i4;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new Span[this.mSpanCount];
            for (int i5 = 0; i5 < this.mSpanCount; i5++) {
                this.mSpans[i5] = new Span(i5);
            }
            requestLayout();
        }
        boolean z = properties.reverseLayout;
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mReverseLayout != z) {
            savedState.mReverseLayout = z;
        }
        this.mReverseLayout = z;
        requestLayout();
        LayoutState layoutState = new LayoutState();
        layoutState.mRecycle = true;
        layoutState.mStartLine = 0;
        layoutState.mEndLine = 0;
        this.mLayoutState = layoutState;
        this.mPrimaryOrientation = EmojiCompat.Config.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = EmojiCompat.Config.createOrientationHelper(this, 1 - this.mOrientation);
    }

    public static int updateSpecWithExtra(int i, int i2, int i3) {
        int mode;
        return (!(i2 == 0 && i3 == 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void assertNotInLayoutOrScroll(String str) {
        RecyclerView recyclerView;
        if (this.mPendingSavedState != null || (recyclerView = this.mRecyclerView) == null) {
            return;
        }
        recyclerView.assertNotInLayoutOrScroll(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public final boolean checkForGaps() {
        int firstChildPosition;
        if (getChildCount() != 0 && this.mGapStrategy != 0 && this.mIsAttachedToWindow) {
            if (this.mShouldReverseLayout) {
                firstChildPosition = getLastChildPosition();
                getFirstChildPosition();
            } else {
                firstChildPosition = getFirstChildPosition();
                getLastChildPosition();
            }
            if (firstChildPosition == 0 && hasGapsToFix() != null) {
                this.mLazySpanLookup.clear();
                this.mRequestedSimpleAnimations = true;
                requestLayout();
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, CircularArray circularArray) {
        LayoutState layoutState;
        int endLine;
        int startLine;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        prepareLayoutStateForDelta(i, state);
        int[] iArr = this.mPrefetchDistances;
        if (iArr == null || iArr.length < this.mSpanCount) {
            this.mPrefetchDistances = new int[this.mSpanCount];
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = this.mSpanCount;
            layoutState = this.mLayoutState;
            if (i3 >= i5) {
                break;
            }
            if (layoutState.mItemDirection == -1) {
                endLine = layoutState.mStartLine;
                startLine = this.mSpans[i3].getStartLine(endLine);
            } else {
                endLine = this.mSpans[i3].getEndLine(layoutState.mEndLine);
                startLine = layoutState.mEndLine;
            }
            int i6 = endLine - startLine;
            if (i6 >= 0) {
                this.mPrefetchDistances[i4] = i6;
                i4++;
            }
            i3++;
        }
        Arrays.sort(this.mPrefetchDistances, 0, i4);
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = layoutState.mCurrentPosition;
            if (i8 < 0 || i8 >= state.getItemCount()) {
                return;
            }
            circularArray.addPosition(layoutState.mCurrentPosition, this.mPrefetchDistances[i7]);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset$1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    public final int computeScrollOffset$1(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000c  */
    @Override // androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int i) {
        int i2 = -1;
        if (getChildCount() != 0) {
            if ((i < getFirstChildPosition()) == this.mShouldReverseLayout) {
                i2 = 1;
            }
        } else if (this.mShouldReverseLayout) {
            i2 = 1;
        }
        PointF pointF = new PointF();
        if (i2 == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = i2;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = i2;
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset$1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    public final int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        Span span;
        ?? r8;
        int startLine;
        int decoratedMeasurement;
        int startAfterPadding;
        int decoratedMeasurement2;
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 1;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        LayoutState layoutState2 = this.mLayoutState;
        int i6 = layoutState2.mInfinite ? layoutState.mLayoutDirection == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : layoutState.mLayoutDirection == 1 ? layoutState.mEndLine + layoutState.mAvailable : layoutState.mStartLine - layoutState.mAvailable;
        int i7 = layoutState.mLayoutDirection;
        for (int i8 = 0; i8 < this.mSpanCount; i8++) {
            if (!this.mSpans[i8].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i8], i7, i6);
            }
        }
        int endAfterPadding = this.mShouldReverseLayout ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
        boolean z = false;
        while (true) {
            int i9 = layoutState.mCurrentPosition;
            if (i9 < 0 || i9 >= state.getItemCount() || (!layoutState2.mInfinite && this.mRemainingSpans.isEmpty())) {
                break;
            }
            View view = recycler.tryGetViewHolderForPositionByDeadline(layoutState.mCurrentPosition, Long.MAX_VALUE).itemView;
            layoutState.mCurrentPosition += layoutState.mItemDirection;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int layoutPosition = layoutParams.mViewHolder.getLayoutPosition();
            RequestService requestService = this.mLazySpanLookup;
            int[] iArr = (int[]) requestService.systemCallbacks;
            int i10 = (iArr == null || layoutPosition >= iArr.length) ? -1 : iArr[layoutPosition];
            if (i10 == -1) {
                if (preferLastSpan(layoutState.mLayoutDirection)) {
                    i3 = this.mSpanCount - i5;
                    i2 = -1;
                    i = -1;
                } else {
                    i = i5;
                    i2 = this.mSpanCount;
                    i3 = i4;
                }
                Span span2 = null;
                if (layoutState.mLayoutDirection == i5) {
                    int startAfterPadding2 = this.mPrimaryOrientation.getStartAfterPadding();
                    int i11 = Integer.MAX_VALUE;
                    while (i3 != i2) {
                        Span span3 = this.mSpans[i3];
                        int endLine = span3.getEndLine(startAfterPadding2);
                        if (endLine < i11) {
                            i11 = endLine;
                            span2 = span3;
                        }
                        i3 += i;
                    }
                } else {
                    int endAfterPadding2 = this.mPrimaryOrientation.getEndAfterPadding();
                    int i12 = Integer.MIN_VALUE;
                    while (i3 != i2) {
                        Span span4 = this.mSpans[i3];
                        int startLine2 = span4.getStartLine(endAfterPadding2);
                        if (startLine2 > i12) {
                            span2 = span4;
                            i12 = startLine2;
                        }
                        i3 += i;
                    }
                }
                span = span2;
                requestService.ensureSize(layoutPosition);
                ((int[]) requestService.systemCallbacks)[layoutPosition] = span.mIndex;
            } else {
                span = this.mSpans[i10];
            }
            layoutParams.mSpan = span;
            if (layoutState.mLayoutDirection == 1) {
                r8 = 0;
                addViewInt(view, -1, false);
            } else {
                r8 = 0;
                addViewInt(view, 0, false);
            }
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin$1(view, RecyclerView.LayoutManager.getChildMeasureSpec(r8, this.mSizePerSpan, this.mWidthMode, r8, ((ViewGroup.MarginLayoutParams) layoutParams).width), RecyclerView.LayoutManager.getChildMeasureSpec(true, this.mHeight, this.mHeightMode, getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
            } else {
                measureChildWithDecorationsAndMargin$1(view, RecyclerView.LayoutManager.getChildMeasureSpec(true, this.mWidth, this.mWidthMode, getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams).width), RecyclerView.LayoutManager.getChildMeasureSpec(false, this.mSizePerSpan, this.mHeightMode, 0, ((ViewGroup.MarginLayoutParams) layoutParams).height));
            }
            if (layoutState.mLayoutDirection == 1) {
                decoratedMeasurement = span.getEndLine(endAfterPadding);
                startLine = this.mPrimaryOrientation.getDecoratedMeasurement(view) + decoratedMeasurement;
            } else {
                startLine = span.getStartLine(endAfterPadding);
                decoratedMeasurement = startLine - this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
            if (layoutState.mLayoutDirection == 1) {
                Span span5 = layoutParams.mSpan;
                span5.getClass();
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.mSpan = span5;
                ArrayList arrayList = span5.mViews;
                arrayList.add(view);
                span5.mCachedEnd = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    span5.mCachedStart = Integer.MIN_VALUE;
                }
                if (layoutParams2.mViewHolder.isRemoved() || layoutParams2.mViewHolder.isUpdated()) {
                    span5.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view) + span5.mDeletedSize;
                }
            } else {
                Span span6 = layoutParams.mSpan;
                span6.getClass();
                LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                layoutParams3.mSpan = span6;
                ArrayList arrayList2 = span6.mViews;
                arrayList2.add(0, view);
                span6.mCachedStart = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    span6.mCachedEnd = Integer.MIN_VALUE;
                }
                if (layoutParams3.mViewHolder.isRemoved() || layoutParams3.mViewHolder.isUpdated()) {
                    span6.mDeletedSize = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view) + span6.mDeletedSize;
                }
            }
            if (isLayoutRTL() && this.mOrientation == 1) {
                decoratedMeasurement2 = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - span.mIndex) * this.mSizePerSpan);
                startAfterPadding = decoratedMeasurement2 - this.mSecondaryOrientation.getDecoratedMeasurement(view);
            } else {
                startAfterPadding = this.mSecondaryOrientation.getStartAfterPadding() + (span.mIndex * this.mSizePerSpan);
                decoratedMeasurement2 = this.mSecondaryOrientation.getDecoratedMeasurement(view) + startAfterPadding;
            }
            if (this.mOrientation == 1) {
                RecyclerView.LayoutManager.layoutDecoratedWithMargins(view, startAfterPadding, decoratedMeasurement, decoratedMeasurement2, startLine);
            } else {
                RecyclerView.LayoutManager.layoutDecoratedWithMargins(view, decoratedMeasurement, startAfterPadding, startLine, decoratedMeasurement2);
            }
            updateRemainingSpans(span, layoutState2.mLayoutDirection, i6);
            recycle(recycler, layoutState2);
            if (layoutState2.mStopInFocusable && view.hasFocusable()) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
            i5 = 1;
            z = true;
            i4 = 0;
        }
        if (!z) {
            recycle(recycler, layoutState2);
        }
        int startAfterPadding3 = layoutState2.mLayoutDirection == -1 ? this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding()) : getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        if (startAfterPadding3 > 0) {
            return Math.min(layoutState.mAvailable, startAfterPadding3);
        }
        return 0;
    }

    public final View findFirstVisibleItemClosestToEnd(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final View findFirstVisibleItemClosestToStart(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (!z || i <= 0) {
                return;
            }
            this.mPrimaryOrientation.offsetChildren(i);
        }
    }

    public final void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int iScrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (!z || iScrollBy <= 0) {
                return;
            }
            this.mPrimaryOrientation.offsetChildren(-iScrollBy);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return RecyclerView.LayoutManager.getPosition(getChildAt(0));
    }

    public final int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return RecyclerView.LayoutManager.getPosition(getChildAt(childCount - 1));
    }

    public final int getMaxEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    public final int getMinStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x0036 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0039  */
    /* JADX WARN: Code duplicated, block: B:26:0x0041  */
    /* JADX WARN: Code duplicated, block: B:29:0x0050 A[LOOP:0: B:25:0x003f->B:29:0x0050, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0053 A[EDGE_INSN: B:30:0x0053->B:31:0x0054 BREAK  A[LOOP:0: B:25:0x003f->B:29:0x0050]] */
    /* JADX WARN: Code duplicated, block: B:32:0x0056  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x0077 A[LOOP:1: B:34:0x0066->B:38:0x0077, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0092  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00db  */
    /* JADX WARN: Code duplicated, block: B:63:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0054 A[EDGE_INSN: B:64:0x0054->B:31:0x0054 BREAK  A[LOOP:0: B:25:0x003f->B:29:0x0050], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x007b A[EDGE_INSN: B:66:0x007b->B:40:0x007b BREAK  A[LOOP:1: B:34:0x0066->B:38:0x0077], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    public final void handleUpdate(int i, int i2, int i3) {
        int i4;
        int i5;
        RequestService requestService;
        int[] iArr;
        int lastChildPosition;
        ArrayList arrayList;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
        int size;
        int i6;
        int i7;
        int size2;
        int lastChildPosition2 = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
            } else {
                i4 = i + 1;
                i5 = i2;
            }
            requestService = this.mLazySpanLookup;
            iArr = (int[]) requestService.systemCallbacks;
            if (iArr != null && i5 < iArr.length) {
                arrayList = (ArrayList) requestService.hardwareBitmapService;
                if (arrayList != null) {
                    if (arrayList == null) {
                        size2 = arrayList.size() - 1;
                        while (true) {
                            if (size2 >= 0) {
                                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = null;
                                break;
                            }
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) requestService.hardwareBitmapService).get(size2);
                            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition == i5) {
                                break;
                            } else {
                                size2--;
                            }
                        }
                    } else {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = null;
                        break;
                    }
                    if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem != null) {
                        ((ArrayList) requestService.hardwareBitmapService).remove(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                    }
                    size = ((ArrayList) requestService.hardwareBitmapService).size();
                    i6 = 0;
                    while (true) {
                        if (i6 < size) {
                            i6 = -1;
                            break;
                        } else if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) requestService.hardwareBitmapService).get(i6)).mPosition >= i5) {
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (i6 != -1) {
                        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) requestService.hardwareBitmapService).get(i6);
                        ((ArrayList) requestService.hardwareBitmapService).remove(i6);
                        i7 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.mPosition;
                    } else {
                        i7 = -1;
                    }
                } else {
                    i7 = -1;
                }
                if (i7 == -1) {
                    int[] iArr2 = (int[]) requestService.systemCallbacks;
                    Arrays.fill(iArr2, i5, iArr2.length, -1);
                    int length = ((int[]) requestService.systemCallbacks).length;
                } else {
                    Arrays.fill((int[]) requestService.systemCallbacks, i5, Math.min(i7 + 1, ((int[]) requestService.systemCallbacks).length), -1);
                }
            }
            if (i3 != 1) {
                requestService.offsetForAddition(i, i2);
            } else if (i3 != 2) {
                requestService.offsetForRemoval(i, i2);
            } else if (i3 == 8) {
                requestService.offsetForRemoval(i, 1);
                requestService.offsetForAddition(i2, 1);
            }
            if (i4 <= lastChildPosition2) {
                return;
            }
            if (this.mShouldReverseLayout) {
                lastChildPosition = getFirstChildPosition();
            } else {
                lastChildPosition = getLastChildPosition();
            }
            if (i5 <= lastChildPosition) {
                requestLayout();
            }
        }
        i4 = i + i2;
        i5 = i;
        requestService = this.mLazySpanLookup;
        iArr = (int[]) requestService.systemCallbacks;
        if (iArr != null) {
            arrayList = (ArrayList) requestService.hardwareBitmapService;
            if (arrayList != null) {
                if (arrayList == null) {
                    size2 = arrayList.size() - 1;
                    while (true) {
                        if (size2 >= 0) {
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = null;
                            break;
                        }
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) requestService.hardwareBitmapService).get(size2);
                        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition == i5) {
                            break;
                            break;
                        }
                        size2--;
                    }
                } else {
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = null;
                    break;
                }
                if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem != null) {
                    ((ArrayList) requestService.hardwareBitmapService).remove(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                }
                size = ((ArrayList) requestService.hardwareBitmapService).size();
                i6 = 0;
                while (true) {
                    if (i6 < size) {
                        i6 = -1;
                        break;
                    } else {
                        if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) requestService.hardwareBitmapService).get(i6)).mPosition >= i5) {
                            break;
                            break;
                        }
                        i6++;
                    }
                }
                if (i6 != -1) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem3 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) requestService.hardwareBitmapService).get(i6);
                    ((ArrayList) requestService.hardwareBitmapService).remove(i6);
                    i7 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem3.mPosition;
                } else {
                    i7 = -1;
                }
            } else {
                i7 = -1;
            }
            if (i7 == -1) {
                int[] iArr3 = (int[]) requestService.systemCallbacks;
                Arrays.fill(iArr3, i5, iArr3.length, -1);
                int length2 = ((int[]) requestService.systemCallbacks).length;
            } else {
                Arrays.fill((int[]) requestService.systemCallbacks, i5, Math.min(i7 + 1, ((int[]) requestService.systemCallbacks).length), -1);
            }
        }
        if (i3 != 1) {
            requestService.offsetForAddition(i, i2);
        } else if (i3 != 2) {
            requestService.offsetForRemoval(i, i2);
        } else if (i3 == 8) {
            requestService.offsetForRemoval(i, 1);
            requestService.offsetForAddition(i2, 1);
        }
        if (i4 <= lastChildPosition2) {
            return;
        }
        if (this.mShouldReverseLayout) {
            lastChildPosition = getFirstChildPosition();
        } else {
            lastChildPosition = getLastChildPosition();
        }
        if (i5 <= lastChildPosition) {
            requestLayout();
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x002c A[SYNTHETIC] */
    public final View hasGapsToFix() {
        boolean z;
        boolean z2;
        int childCount = getChildCount();
        int i = childCount - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(0, this.mSpanCount, true);
        byte b = (this.mOrientation == 1 && isLayoutRTL()) ? (byte) 1 : (byte) -1;
        if (this.mShouldReverseLayout) {
            childCount = -1;
        } else {
            i = 0;
        }
        int i2 = i < childCount ? 1 : -1;
        while (i != childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.mSpan.mIndex)) {
                Span span = layoutParams.mSpan;
                if (this.mShouldReverseLayout) {
                    int i3 = span.mCachedEnd;
                    if (i3 == Integer.MIN_VALUE) {
                        span.calculateCachedEnd();
                        i3 = span.mCachedEnd;
                    }
                    if (i3 < this.mPrimaryOrientation.getEndAfterPadding()) {
                        ArrayList arrayList = span.mViews;
                        ((LayoutParams) ((View) arrayList.get(arrayList.size() - 1)).getLayoutParams()).getClass();
                        return childAt;
                    }
                } else {
                    int i4 = span.mCachedStart;
                    ArrayList arrayList2 = span.mViews;
                    if (i4 == Integer.MIN_VALUE) {
                        View view = (View) arrayList2.get(0);
                        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                        span.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                        layoutParams2.getClass();
                        i4 = span.mCachedStart;
                    }
                    if (i4 > this.mPrimaryOrientation.getStartAfterPadding()) {
                        ((LayoutParams) ((View) arrayList2.get(0)).getLayoutParams()).getClass();
                        return childAt;
                    }
                }
                bitSet.clear(layoutParams.mSpan.mIndex);
            }
            i += i2;
            if (i != childCount) {
                View childAt2 = getChildAt(i);
                if (this.mShouldReverseLayout) {
                    int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (decoratedEnd >= decoratedEnd2) {
                        if (decoratedEnd == decoratedEnd2) {
                            if (layoutParams.mSpan.mIndex - ((LayoutParams) childAt2.getLayoutParams()).mSpan.mIndex < 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (b < 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z != z2) {
                            }
                        } else {
                            continue;
                        }
                    }
                    return childAt;
                }
                int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                if (decoratedStart <= decoratedStart2) {
                    if (decoratedStart == decoratedStart2) {
                        if (layoutParams.mSpan.mIndex - ((LayoutParams) childAt2.getLayoutParams()).mSpan.mIndex < 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (b < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z != z2) {
                        }
                    } else {
                        continue;
                    }
                }
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return this.mGapStrategy != 0;
    }

    public final boolean isLayoutRTL() {
        RecyclerView recyclerView = this.mRecyclerView;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        return recyclerView.getLayoutDirection() == 1;
    }

    public final void measureChildWithDecorationsAndMargin$1(View view, int i, int i2) {
        RecyclerView recyclerView = this.mRecyclerView;
        Rect rect = this.mTmpRect;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.getItemDecorInsetsForChild(view));
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iUpdateSpecWithExtra = updateSpecWithExtra(i, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int iUpdateSpecWithExtra2 = updateSpecWithExtra(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.bottom);
        if (shouldMeasureChild(view, iUpdateSpecWithExtra, iUpdateSpecWithExtra2, layoutParams)) {
            view.measure(iUpdateSpecWithExtra, iUpdateSpecWithExtra2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            Span span = this.mSpans[i2];
            int i3 = span.mCachedStart;
            if (i3 != Integer.MIN_VALUE) {
                span.mCachedStart = i3 + i;
            }
            int i4 = span.mCachedEnd;
            if (i4 != Integer.MIN_VALUE) {
                span.mCachedEnd = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            Span span = this.mSpans[i2];
            int i3 = span.mCachedStart;
            if (i3 != Integer.MIN_VALUE) {
                span.mCachedStart = i3 + i;
            }
            int i4 = span.mCachedEnd;
            if (i4 != Integer.MIN_VALUE) {
                span.mCachedEnd = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged() {
        this.mLazySpanLookup.clear();
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.mCheckForGapsRunnable);
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0048  */
    /* JADX WARN: Code duplicated, block: B:37:0x0053  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View viewFindContainingItemView;
        int i2;
        if (getChildCount() != 0) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || ((ArrayList) this.mChildHelper.options).contains(viewFindContainingItemView)) {
                viewFindContainingItemView = null;
            }
            if (viewFindContainingItemView != null) {
                resolveShouldLayoutReverse$1();
                if (i != 1) {
                    if (i != 2) {
                        if (i != 17) {
                            if (i != 33) {
                                if (i == 66 ? this.mOrientation == 0 : !(i != 130 || this.mOrientation != 1)) {
                                    i2 = 1;
                                }
                            } else if (this.mOrientation == 1) {
                                i2 = -1;
                            }
                            i2 = Integer.MIN_VALUE;
                        } else if (this.mOrientation == 0) {
                            i2 = -1;
                        } else {
                            i2 = Integer.MIN_VALUE;
                        }
                    } else if (this.mOrientation != 1 && isLayoutRTL()) {
                        i2 = -1;
                    } else {
                        i2 = 1;
                    }
                } else if (this.mOrientation != 1 && isLayoutRTL()) {
                    i2 = 1;
                } else {
                    i2 = -1;
                }
                if (i2 != Integer.MIN_VALUE) {
                    LayoutParams layoutParams = (LayoutParams) viewFindContainingItemView.getLayoutParams();
                    layoutParams.getClass();
                    Span span = layoutParams.mSpan;
                    int lastChildPosition = i2 == 1 ? getLastChildPosition() : getFirstChildPosition();
                    updateLayoutState(lastChildPosition, state);
                    setLayoutStateDirection(i2);
                    LayoutState layoutState = this.mLayoutState;
                    layoutState.mCurrentPosition = layoutState.mItemDirection + lastChildPosition;
                    layoutState.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * 0.33333334f);
                    layoutState.mStopInFocusable = true;
                    layoutState.mRecycle = false;
                    fill(recycler, layoutState, state);
                    this.mLastLayoutFromEnd = this.mShouldReverseLayout;
                    View focusableViewAfter = span.getFocusableViewAfter(lastChildPosition, i2);
                    if (focusableViewAfter != null && focusableViewAfter != viewFindContainingItemView) {
                        return focusableViewAfter;
                    }
                    if (preferLastSpan(i2)) {
                        for (int i3 = this.mSpanCount - 1; i3 >= 0; i3--) {
                            View focusableViewAfter2 = this.mSpans[i3].getFocusableViewAfter(lastChildPosition, i2);
                            if (focusableViewAfter2 != null && focusableViewAfter2 != viewFindContainingItemView) {
                                return focusableViewAfter2;
                            }
                        }
                    } else {
                        for (int i4 = 0; i4 < this.mSpanCount; i4++) {
                            View focusableViewAfter3 = this.mSpans[i4].getFocusableViewAfter(lastChildPosition, i2);
                            if (focusableViewAfter3 != null && focusableViewAfter3 != viewFindContainingItemView) {
                                return focusableViewAfter3;
                            }
                        }
                    }
                    boolean z = (this.mReverseLayout ^ true) == (i2 == -1);
                    View viewFindViewByPosition = findViewByPosition(z ? span.findFirstPartiallyVisibleItemPosition() : span.findLastPartiallyVisibleItemPosition());
                    if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                        return viewFindViewByPosition;
                    }
                    if (preferLastSpan(i2)) {
                        for (int i5 = this.mSpanCount - 1; i5 >= 0; i5--) {
                            if (i5 != span.mIndex) {
                                View viewFindViewByPosition2 = findViewByPosition(z ? this.mSpans[i5].findFirstPartiallyVisibleItemPosition() : this.mSpans[i5].findLastPartiallyVisibleItemPosition());
                                if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                                    return viewFindViewByPosition2;
                                }
                            }
                        }
                    } else {
                        for (int i6 = 0; i6 < this.mSpanCount; i6++) {
                            View viewFindViewByPosition3 = findViewByPosition(z ? this.mSpans[i6].findFirstPartiallyVisibleItemPosition() : this.mSpans[i6].findLastPartiallyVisibleItemPosition());
                            if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                                return viewFindViewByPosition3;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewFindFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View viewFindFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (viewFindFirstVisibleItemClosestToStart == null || viewFindFirstVisibleItemClosestToEnd == null) {
                return;
            }
            int position = RecyclerView.LayoutManager.getPosition(viewFindFirstVisibleItemClosestToStart);
            int position2 = RecyclerView.LayoutManager.getPosition(viewFindFirstVisibleItemClosestToEnd);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(int i, int i2) {
        handleUpdate(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsMoved(int i, int i2) {
        handleUpdate(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(int i, int i2) {
        handleUpdate(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsUpdated(int i, int i2) {
        handleUpdate(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State state) {
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.mAnchorPosition = -1;
                savedState.mVisibleAnchorPosition = -1;
                savedState.mSpanOffsets = null;
                savedState.mSpanOffsetsSize = 0;
                savedState.mSpanLookupSize = 0;
                savedState.mSpanLookup = null;
                savedState.mFullSpanItems = null;
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable onSaveInstanceState() {
        int startLine;
        int startAfterPadding;
        int[] iArr;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            SavedState savedState2 = new SavedState();
            savedState2.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            savedState2.mAnchorPosition = savedState.mAnchorPosition;
            savedState2.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            savedState2.mSpanOffsets = savedState.mSpanOffsets;
            savedState2.mSpanLookupSize = savedState.mSpanLookupSize;
            savedState2.mSpanLookup = savedState.mSpanLookup;
            savedState2.mReverseLayout = savedState.mReverseLayout;
            savedState2.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            savedState2.mLastLayoutRTL = savedState.mLastLayoutRTL;
            savedState2.mFullSpanItems = savedState.mFullSpanItems;
            return savedState2;
        }
        SavedState savedState3 = new SavedState();
        savedState3.mReverseLayout = this.mReverseLayout;
        savedState3.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState3.mLastLayoutRTL = this.mLastLayoutRTL;
        RequestService requestService = this.mLazySpanLookup;
        if (requestService == null || (iArr = (int[]) requestService.systemCallbacks) == null) {
            savedState3.mSpanLookupSize = 0;
        } else {
            savedState3.mSpanLookup = iArr;
            savedState3.mSpanLookupSize = iArr.length;
            savedState3.mFullSpanItems = (ArrayList) requestService.hardwareBitmapService;
        }
        if (getChildCount() <= 0) {
            savedState3.mAnchorPosition = -1;
            savedState3.mVisibleAnchorPosition = -1;
            savedState3.mSpanOffsetsSize = 0;
            return savedState3;
        }
        savedState3.mAnchorPosition = this.mLastLayoutFromEnd ? getLastChildPosition() : getFirstChildPosition();
        View viewFindFirstVisibleItemClosestToEnd = this.mShouldReverseLayout ? findFirstVisibleItemClosestToEnd(true) : findFirstVisibleItemClosestToStart(true);
        savedState3.mVisibleAnchorPosition = viewFindFirstVisibleItemClosestToEnd != null ? RecyclerView.LayoutManager.getPosition(viewFindFirstVisibleItemClosestToEnd) : -1;
        int i = this.mSpanCount;
        savedState3.mSpanOffsetsSize = i;
        savedState3.mSpanOffsets = new int[i];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            if (this.mLastLayoutFromEnd) {
                startLine = this.mSpans[i2].getEndLine(Integer.MIN_VALUE);
                if (startLine != Integer.MIN_VALUE) {
                    startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                    startLine -= startAfterPadding;
                }
            } else {
                startLine = this.mSpans[i2].getStartLine(Integer.MIN_VALUE);
                if (startLine != Integer.MIN_VALUE) {
                    startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                    startLine -= startAfterPadding;
                }
            }
            savedState3.mSpanOffsets[i2] = startLine;
        }
        return savedState3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int i) {
        if (i == 0) {
            checkForGaps();
        }
    }

    public final boolean preferLastSpan(int i) {
        if (this.mOrientation == 0) {
            return (i == -1) != this.mShouldReverseLayout;
        }
        return ((i == -1) == this.mShouldReverseLayout) == isLayoutRTL();
    }

    public final void prepareLayoutStateForDelta(int i, RecyclerView.State state) {
        int firstChildPosition;
        int i2;
        if (i > 0) {
            firstChildPosition = getLastChildPosition();
            i2 = 1;
        } else {
            firstChildPosition = getFirstChildPosition();
            i2 = -1;
        }
        LayoutState layoutState = this.mLayoutState;
        layoutState.mRecycle = true;
        updateLayoutState(firstChildPosition, state);
        setLayoutStateDirection(i2);
        layoutState.mCurrentPosition = firstChildPosition + layoutState.mItemDirection;
        layoutState.mAvailable = Math.abs(i);
    }

    public final void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int iMin;
        if (!layoutState.mRecycle || layoutState.mInfinite) {
            return;
        }
        if (layoutState.mAvailable == 0) {
            if (layoutState.mLayoutDirection == -1) {
                recycleFromEnd(recycler, layoutState.mEndLine);
                return;
            } else {
                recycleFromStart(recycler, layoutState.mStartLine);
                return;
            }
        }
        int i = 1;
        if (layoutState.mLayoutDirection == -1) {
            int i2 = layoutState.mStartLine;
            int startLine = this.mSpans[0].getStartLine(i2);
            while (i < this.mSpanCount) {
                int startLine2 = this.mSpans[i].getStartLine(i2);
                if (startLine2 > startLine) {
                    startLine = startLine2;
                }
                i++;
            }
            int i3 = i2 - startLine;
            recycleFromEnd(recycler, i3 < 0 ? layoutState.mEndLine : layoutState.mEndLine - Math.min(i3, layoutState.mAvailable));
            return;
        }
        int i4 = layoutState.mEndLine;
        int endLine = this.mSpans[0].getEndLine(i4);
        while (i < this.mSpanCount) {
            int endLine2 = this.mSpans[i].getEndLine(i4);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
            i++;
        }
        int i5 = endLine - layoutState.mEndLine;
        if (i5 < 0) {
            iMin = layoutState.mStartLine;
        } else {
            iMin = Math.min(i5, layoutState.mAvailable) + layoutState.mStartLine;
        }
        recycleFromStart(recycler, iMin);
    }

    public final void recycleFromEnd(RecyclerView.Recycler recycler, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) < i || this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.getClass();
            if (layoutParams.mSpan.mViews.size() == 1) {
                return;
            }
            Span span = layoutParams.mSpan;
            ArrayList arrayList = span.mViews;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.mSpan = null;
            if (layoutParams2.mViewHolder.isRemoved() || layoutParams2.mViewHolder.isUpdated()) {
                span.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
            if (size == 1) {
                span.mCachedStart = Integer.MIN_VALUE;
            }
            span.mCachedEnd = Integer.MIN_VALUE;
            removeAndRecycleView(childAt, recycler);
        }
    }

    public final void recycleFromStart(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > i || this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.getClass();
            if (layoutParams.mSpan.mViews.size() == 1) {
                return;
            }
            Span span = layoutParams.mSpan;
            ArrayList arrayList = span.mViews;
            View view = (View) arrayList.remove(0);
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.mSpan = null;
            if (arrayList.size() == 0) {
                span.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams2.mViewHolder.isRemoved() || layoutParams2.mViewHolder.isUpdated()) {
                span.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
            span.mCachedStart = Integer.MIN_VALUE;
            removeAndRecycleView(childAt, recycler);
        }
    }

    public final void resolveShouldLayoutReverse$1() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public final int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i, state);
        LayoutState layoutState = this.mLayoutState;
        int iFill = fill(recycler, layoutState, state);
        if (layoutState.mAvailable >= iFill) {
            i = i < 0 ? -iFill : iFill;
        }
        this.mPrimaryOrientation.offsetChildren(-i);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        layoutState.mAvailable = 0;
        recycle(recycler, layoutState);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int i) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mAnchorPosition != i) {
            savedState.mSpanOffsets = null;
            savedState.mSpanOffsetsSize = 0;
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    public final void setLayoutStateDirection(int i) {
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = i;
        layoutState.mItemDirection = this.mShouldReverseLayout != (i == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int i3 = this.mOrientation;
        int i4 = this.mSpanCount;
        if (i3 == 1) {
            int iHeight = rect.height() + paddingBottom;
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            iChooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, iHeight, recyclerView.getMinimumHeight());
            iChooseSize = RecyclerView.LayoutManager.chooseSize(i, (this.mSizePerSpan * i4) + paddingRight, this.mRecyclerView.getMinimumWidth());
        } else {
            int iWidth = rect.width() + paddingRight;
            RecyclerView recyclerView2 = this.mRecyclerView;
            WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
            iChooseSize = RecyclerView.LayoutManager.chooseSize(i, iWidth, recyclerView2.getMinimumWidth());
            iChooseSize2 = RecyclerView.LayoutManager.chooseSize(i2, (this.mSizePerSpan * i4) + paddingBottom, this.mRecyclerView.getMinimumHeight());
        }
        this.mRecyclerView.setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.mTargetPosition = i;
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }

    public final void updateLayoutState(int i, RecyclerView.State state) {
        int totalSpace;
        int totalSpace2;
        int i2;
        LayoutState layoutState = this.mLayoutState;
        boolean z = false;
        layoutState.mAvailable = 0;
        layoutState.mCurrentPosition = i;
        LinearSmoothScroller linearSmoothScroller = this.mSmoothScroller;
        if (linearSmoothScroller == null || !linearSmoothScroller.mRunning || (i2 = state.mTargetPosition) == -1) {
            totalSpace = 0;
            totalSpace2 = 0;
        } else {
            if (this.mShouldReverseLayout == (i2 < i)) {
                totalSpace = this.mPrimaryOrientation.getTotalSpace();
                totalSpace2 = 0;
            } else {
                totalSpace2 = this.mPrimaryOrientation.getTotalSpace();
                totalSpace = 0;
            }
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || !recyclerView.mClipToPadding) {
            layoutState.mEndLine = this.mPrimaryOrientation.getEnd() + totalSpace;
            layoutState.mStartLine = -totalSpace2;
        } else {
            layoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - totalSpace2;
            layoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + totalSpace;
        }
        layoutState.mStopInFocusable = false;
        layoutState.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
            z = true;
        }
        layoutState.mInfinite = z;
    }

    public final void updateRemainingSpans(Span span, int i, int i2) {
        int i3 = span.mDeletedSize;
        int i4 = span.mIndex;
        if (i != -1) {
            int i5 = span.mCachedEnd;
            if (i5 == Integer.MIN_VALUE) {
                span.calculateCachedEnd();
                i5 = span.mCachedEnd;
            }
            if (i5 - i3 >= i2) {
                this.mRemainingSpans.set(i4, false);
                return;
            }
            return;
        }
        int i6 = span.mCachedStart;
        if (i6 == Integer.MIN_VALUE) {
            View view = (View) span.mViews.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            span.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            layoutParams.getClass();
            i6 = span.mCachedStart;
        }
        if (i6 + i3 <= i2) {
            this.mRemainingSpans.set(i4, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:109:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:123:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:125:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:131:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:133:0x0209  */
    /* JADX WARN: Code duplicated, block: B:254:0x0417  */
    /* JADX WARN: Code duplicated, block: B:265:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:0x01fc A[SYNTHETIC] */
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        boolean z2;
        SavedState savedState;
        int childCount;
        int i;
        int position;
        int position2;
        int childCount2;
        int i2;
        boolean z3;
        SavedState savedState2 = this.mPendingSavedState;
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (!(savedState2 == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            anchorInfo.reset();
            return;
        }
        boolean z4 = anchorInfo.mValid;
        StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
        boolean z5 = (z4 && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) ? false : true;
        RequestService requestService = this.mLazySpanLookup;
        if (z5) {
            anchorInfo.reset();
            SavedState savedState3 = this.mPendingSavedState;
            if (savedState3 != null) {
                int i3 = savedState3.mSpanOffsetsSize;
                if (i3 > 0) {
                    if (i3 == this.mSpanCount) {
                        for (int i4 = 0; i4 < this.mSpanCount; i4++) {
                            this.mSpans[i4].clear();
                            SavedState savedState4 = this.mPendingSavedState;
                            int endAfterPadding = savedState4.mSpanOffsets[i4];
                            if (endAfterPadding != Integer.MIN_VALUE) {
                                endAfterPadding += savedState4.mAnchorLayoutFromEnd ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
                            }
                            Span span = this.mSpans[i4];
                            span.mCachedStart = endAfterPadding;
                            span.mCachedEnd = endAfterPadding;
                        }
                    } else {
                        savedState3.mSpanOffsets = null;
                        savedState3.mSpanOffsetsSize = 0;
                        savedState3.mSpanLookupSize = 0;
                        savedState3.mSpanLookup = null;
                        savedState3.mFullSpanItems = null;
                        savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
                    }
                }
                SavedState savedState5 = this.mPendingSavedState;
                this.mLastLayoutRTL = savedState5.mLastLayoutRTL;
                boolean z6 = savedState5.mReverseLayout;
                assertNotInLayoutOrScroll(null);
                SavedState savedState6 = this.mPendingSavedState;
                if (savedState6 != null && savedState6.mReverseLayout != z6) {
                    savedState6.mReverseLayout = z6;
                }
                this.mReverseLayout = z6;
                requestLayout();
                resolveShouldLayoutReverse$1();
                SavedState savedState7 = this.mPendingSavedState;
                int i5 = savedState7.mAnchorPosition;
                if (i5 != -1) {
                    this.mPendingScrollPosition = i5;
                    anchorInfo.mLayoutFromEnd = savedState7.mAnchorLayoutFromEnd;
                } else {
                    anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
                }
                if (savedState7.mSpanLookupSize > 1) {
                    requestService.systemCallbacks = savedState7.mSpanLookup;
                    requestService.hardwareBitmapService = savedState7.mFullSpanItems;
                }
            } else {
                resolveShouldLayoutReverse$1();
                anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
            }
            if (state.mInPreLayout || (i2 = this.mPendingScrollPosition) == -1) {
                if (this.mLastLayoutFromEnd) {
                    int itemCount = state.getItemCount();
                    childCount2 = getChildCount() - 1;
                    while (true) {
                        if (childCount2 < 0) {
                            position2 = 0;
                            break;
                        }
                        position2 = RecyclerView.LayoutManager.getPosition(getChildAt(childCount2));
                        if (position2 < 0 && position2 < itemCount) {
                            break;
                        } else {
                            childCount2--;
                        }
                    }
                } else {
                    int itemCount2 = state.getItemCount();
                    childCount = getChildCount();
                    i = 0;
                    while (true) {
                        if (i >= childCount) {
                            position2 = 0;
                            break;
                        }
                        position = RecyclerView.LayoutManager.getPosition(getChildAt(i));
                        if (position < 0 && position < itemCount2) {
                            position2 = position;
                            break;
                        }
                        i++;
                    }
                }
                anchorInfo.mPosition = position2;
                anchorInfo.mOffset = Integer.MIN_VALUE;
            } else if (i2 < 0 || i2 >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                if (this.mLastLayoutFromEnd) {
                    int itemCount3 = state.getItemCount();
                    childCount2 = getChildCount() - 1;
                    while (true) {
                        if (childCount2 < 0) {
                            position2 = 0;
                            break;
                        } else {
                            position2 = RecyclerView.LayoutManager.getPosition(getChildAt(childCount2));
                            if (position2 < 0) {
                            }
                            childCount2--;
                        }
                    }
                } else {
                    int itemCount4 = state.getItemCount();
                    childCount = getChildCount();
                    i = 0;
                    while (true) {
                        if (i >= childCount) {
                            position2 = 0;
                            break;
                        } else {
                            position = RecyclerView.LayoutManager.getPosition(getChildAt(i));
                            if (position < 0) {
                            }
                            i++;
                        }
                    }
                }
                anchorInfo.mPosition = position2;
                anchorInfo.mOffset = Integer.MIN_VALUE;
            } else {
                SavedState savedState8 = this.mPendingSavedState;
                if (savedState8 == null || savedState8.mAnchorPosition == -1 || savedState8.mSpanOffsetsSize < 1) {
                    View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (viewFindViewByPosition != null) {
                        anchorInfo.mPosition = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
                        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                            if (anchorInfo.mLayoutFromEnd) {
                                anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(viewFindViewByPosition);
                            } else {
                                anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(viewFindViewByPosition);
                            }
                        } else if (this.mPrimaryOrientation.getDecoratedMeasurement(viewFindViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                            anchorInfo.mOffset = anchorInfo.mLayoutFromEnd ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
                        } else {
                            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(viewFindViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                            if (decoratedStart < 0) {
                                anchorInfo.mOffset = -decoratedStart;
                            } else {
                                int endAfterPadding2 = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(viewFindViewByPosition);
                                if (endAfterPadding2 < 0) {
                                    anchorInfo.mOffset = endAfterPadding2;
                                } else {
                                    anchorInfo.mOffset = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        int i6 = this.mPendingScrollPosition;
                        anchorInfo.mPosition = i6;
                        int i7 = this.mPendingScrollPositionOffset;
                        if (i7 == Integer.MIN_VALUE) {
                            if (getChildCount() != 0) {
                                if ((i6 < getFirstChildPosition()) != this.mShouldReverseLayout) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                            } else if (this.mShouldReverseLayout) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            anchorInfo.mLayoutFromEnd = z3;
                            anchorInfo.mOffset = z3 ? staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding() : staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding();
                        } else if (anchorInfo.mLayoutFromEnd) {
                            anchorInfo.mOffset = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding() - i7;
                        } else {
                            anchorInfo.mOffset = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding() + i7;
                        }
                        anchorInfo.mInvalidateOffsets = true;
                    }
                } else {
                    anchorInfo.mOffset = Integer.MIN_VALUE;
                    anchorInfo.mPosition = this.mPendingScrollPosition;
                }
            }
            anchorInfo.mValid = true;
        }
        if (this.mPendingSavedState == null && this.mPendingScrollPosition == -1 && (anchorInfo.mLayoutFromEnd != this.mLastLayoutFromEnd || isLayoutRTL() != this.mLastLayoutRTL)) {
            requestService.clear();
            anchorInfo.mInvalidateOffsets = true;
        }
        if (getChildCount() > 0 && ((savedState = this.mPendingSavedState) == null || savedState.mSpanOffsetsSize < 1)) {
            if (anchorInfo.mInvalidateOffsets) {
                for (int i8 = 0; i8 < this.mSpanCount; i8++) {
                    this.mSpans[i8].clear();
                    int i9 = anchorInfo.mOffset;
                    if (i9 != Integer.MIN_VALUE) {
                        Span span2 = this.mSpans[i8];
                        span2.mCachedStart = i9;
                        span2.mCachedEnd = i9;
                    }
                }
            } else if (z5 || anchorInfo.mSpanReferenceLines == null) {
                for (int i10 = 0; i10 < this.mSpanCount; i10++) {
                    Span span3 = this.mSpans[i10];
                    boolean z7 = this.mShouldReverseLayout;
                    int i11 = anchorInfo.mOffset;
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    int endLine = z7 ? span3.getEndLine(Integer.MIN_VALUE) : span3.getStartLine(Integer.MIN_VALUE);
                    span3.clear();
                    if (endLine != Integer.MIN_VALUE && ((!z7 || endLine >= staggeredGridLayoutManager2.mPrimaryOrientation.getEndAfterPadding()) && (z7 || endLine <= staggeredGridLayoutManager2.mPrimaryOrientation.getStartAfterPadding()))) {
                        if (i11 != Integer.MIN_VALUE) {
                            endLine += i11;
                        }
                        span3.mCachedEnd = endLine;
                        span3.mCachedStart = endLine;
                    }
                }
                Span[] spanArr = this.mSpans;
                int length = spanArr.length;
                int[] iArr = anchorInfo.mSpanReferenceLines;
                if (iArr == null || iArr.length < length) {
                    anchorInfo.mSpanReferenceLines = new int[staggeredGridLayoutManager.mSpans.length];
                }
                for (int i12 = 0; i12 < length; i12++) {
                    anchorInfo.mSpanReferenceLines[i12] = spanArr[i12].getStartLine(Integer.MIN_VALUE);
                }
            } else {
                for (int i13 = 0; i13 < this.mSpanCount; i13++) {
                    Span span4 = this.mSpans[i13];
                    span4.clear();
                    int i14 = anchorInfo.mSpanReferenceLines[i13];
                    span4.mCachedStart = i14;
                    span4.mCachedEnd = i14;
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mRecycle = false;
        int totalSpace = this.mSecondaryOrientation.getTotalSpace();
        this.mSizePerSpan = totalSpace / this.mSpanCount;
        View.MeasureSpec.makeMeasureSpec(totalSpace, this.mSecondaryOrientation.getMode());
        updateLayoutState(anchorInfo.mPosition, state);
        if (anchorInfo.mLayoutFromEnd) {
            setLayoutStateDirection(-1);
            fill(recycler, layoutState, state);
            setLayoutStateDirection(1);
            layoutState.mCurrentPosition = anchorInfo.mPosition + layoutState.mItemDirection;
            fill(recycler, layoutState, state);
        } else {
            setLayoutStateDirection(1);
            fill(recycler, layoutState, state);
            setLayoutStateDirection(-1);
            layoutState.mCurrentPosition = anchorInfo.mPosition + layoutState.mItemDirection;
            fill(recycler, layoutState, state);
        }
        if (this.mSecondaryOrientation.getMode() != 1073741824) {
            int childCount3 = getChildCount();
            float fMax = 0.0f;
            for (int i15 = 0; i15 < childCount3; i15++) {
                View childAt = getChildAt(i15);
                float decoratedMeasurement = this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement >= fMax) {
                    ((LayoutParams) childAt.getLayoutParams()).getClass();
                    fMax = Math.max(fMax, decoratedMeasurement);
                }
            }
            int i16 = this.mSizePerSpan;
            int iRound = Math.round(fMax * this.mSpanCount);
            if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
                iRound = Math.min(iRound, this.mSecondaryOrientation.getTotalSpace());
            }
            this.mSizePerSpan = iRound / this.mSpanCount;
            View.MeasureSpec.makeMeasureSpec(iRound, this.mSecondaryOrientation.getMode());
            if (this.mSizePerSpan != i16) {
                for (int i17 = 0; i17 < childCount3; i17++) {
                    View childAt2 = getChildAt(i17);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    layoutParams.getClass();
                    if (isLayoutRTL() && this.mOrientation == 1) {
                        int i18 = -((this.mSpanCount - 1) - layoutParams.mSpan.mIndex);
                        childAt2.offsetLeftAndRight((this.mSizePerSpan * i18) - (i18 * i16));
                    } else {
                        int i19 = layoutParams.mSpan.mIndex;
                        int i20 = this.mSizePerSpan * i19;
                        int i21 = i19 * i16;
                        if (this.mOrientation == 1) {
                            childAt2.offsetLeftAndRight(i20 - i21);
                        } else {
                            childAt2.offsetTopAndBottom(i20 - i21);
                        }
                    }
                }
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout) {
                fixEndGap(recycler, state, true);
                fixStartGap(recycler, state, false);
            } else {
                fixStartGap(recycler, state, true);
                fixEndGap(recycler, state, false);
            }
        }
        if (z && !state.mInPreLayout && this.mGapStrategy != 0 && getChildCount() > 0 && hasGapsToFix() != null) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.removeCallbacks(this.mCheckForGapsRunnable);
            }
            z2 = checkForGaps();
        }
        if (state.mInPreLayout) {
            anchorInfo.reset();
        }
        this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        if (z2) {
            anchorInfo.reset();
            onLayoutChildren(recycler, state, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
