package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasureResult implements MeasureResult {
    public final int afterContentPadding;
    public final boolean canScrollForward;
    public final long childConstraints;
    public final float consumedScroll;
    public final CoroutineScope coroutineScope;
    public final Density density;
    public final LazyListMeasuredItem firstVisibleItem;
    public final int firstVisibleItemScrollOffset;
    public final int mainAxisItemSpacing;
    public final MeasureResult measureResult;
    public final Orientation orientation;
    public final boolean remeasureNeeded;
    public final boolean reverseLayout;
    public final float scrollBackAmount;
    public final int totalItemsCount;
    public final int viewportEndOffset;
    public final int viewportStartOffset;
    public final Object visibleItemsInfo;

    public LazyListMeasureResult(LazyListMeasuredItem lazyListMeasuredItem, int i, boolean z, float f, MeasureResult measureResult, float f2, boolean z2, CoroutineScope coroutineScope, Density density, long j, List list, int i2, int i3, int i4, boolean z3, Orientation orientation, int i5, int i6) {
        this.firstVisibleItem = lazyListMeasuredItem;
        this.firstVisibleItemScrollOffset = i;
        this.canScrollForward = z;
        this.consumedScroll = f;
        this.measureResult = measureResult;
        this.scrollBackAmount = f2;
        this.remeasureNeeded = z2;
        this.coroutineScope = coroutineScope;
        this.density = density;
        this.childConstraints = j;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i2;
        this.viewportEndOffset = i3;
        this.totalItemsCount = i4;
        this.reverseLayout = z3;
        this.orientation = orientation;
        this.afterContentPadding = i5;
        this.mainAxisItemSpacing = i6;
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public final LazyListMeasureResult copyWithScrollDeltaWithoutRemeasure(int i, boolean z) {
        LazyListMeasuredItem lazyListMeasuredItem;
        if (this.remeasureNeeded) {
            return null;
        }
        ?? r15 = this.visibleItemsInfo;
        if (r15.isEmpty() || (lazyListMeasuredItem = this.firstVisibleItem) == null) {
            return null;
        }
        int i2 = lazyListMeasuredItem.mainAxisSizeWithSpacings;
        int i3 = this.firstVisibleItemScrollOffset - i;
        if (i3 < 0 || i3 >= i2) {
            return null;
        }
        LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) CollectionsKt.first((List) r15);
        LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) CollectionsKt.last(r15);
        if (lazyListMeasuredItem2.nonScrollableItem || lazyListMeasuredItem3.nonScrollableItem) {
            return null;
        }
        int i4 = this.viewportEndOffset;
        int i5 = this.viewportStartOffset;
        if (i < 0) {
            if (Math.min((lazyListMeasuredItem2.offset + lazyListMeasuredItem2.mainAxisSizeWithSpacings) - i5, (lazyListMeasuredItem3.offset + lazyListMeasuredItem3.mainAxisSizeWithSpacings) - i4) <= (-i)) {
                return null;
            }
        } else if (Math.min(i5 - lazyListMeasuredItem2.offset, i4 - lazyListMeasuredItem3.offset) <= i) {
            return null;
        }
        int size = r15.size();
        for (int i6 = 0; i6 < size; i6++) {
            LazyListMeasuredItem lazyListMeasuredItem4 = (LazyListMeasuredItem) r15.get(i6);
            boolean z2 = lazyListMeasuredItem4.isVertical;
            int[] iArr = lazyListMeasuredItem4.placeableOffsets;
            if (!lazyListMeasuredItem4.nonScrollableItem) {
                lazyListMeasuredItem4.offset += i;
                int length = iArr.length;
                for (int i7 = 0; i7 < length; i7++) {
                    int i8 = i7 & 1;
                    if ((z2 && i8 != 0) || (!z2 && i8 == 0)) {
                        iArr[i7] = iArr[i7] + i;
                    }
                }
                if (z) {
                    int size2 = lazyListMeasuredItem4.placeables.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        Modifier.CC.m(lazyListMeasuredItem4.animator.keyToItemInfoMap.get(lazyListMeasuredItem4.key));
                    }
                }
            }
        }
        return new LazyListMeasureResult(this.firstVisibleItem, i3, this.canScrollForward || i > 0, i, this.measureResult, this.scrollBackAmount, this.remeasureNeeded, this.coroutineScope, this.density, this.childConstraints, r15, this.viewportStartOffset, this.viewportEndOffset, this.totalItemsCount, this.reverseLayout, this.orientation, this.afterContentPadding, this.mainAxisItemSpacing);
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final Map getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getHeight() {
        return this.measureResult.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final Function1 getRulers() {
        return this.measureResult.getRulers();
    }

    /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    public final long m148getViewportSizeYbymL2g() {
        MeasureResult measureResult = this.measureResult;
        return (((long) measureResult.getWidth()) << 32) | (((long) measureResult.getHeight()) & 4294967295L);
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getWidth() {
        return this.measureResult.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final void placeChildren() {
        this.measureResult.placeChildren();
    }
}
