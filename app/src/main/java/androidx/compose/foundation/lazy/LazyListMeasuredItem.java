package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy$measure$1;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasuredItem {
    public final LazyLayoutItemAnimator animator;
    public final Object contentType;
    public final int crossAxisSize;
    public final Alignment.Horizontal horizontalAlignment;
    public final int index;
    public final boolean isVertical;
    public final Object key;
    public final LayoutDirection layoutDirection;
    public int mainAxisLayoutSize = Integer.MIN_VALUE;
    public final int mainAxisSizeWithSpacings;
    public boolean nonScrollableItem;
    public int offset;
    public final int[] placeableOffsets;
    public final List placeables;
    public final boolean reverseLayout;
    public final int size;
    public final int spacing;
    public final BiasAlignment.Vertical verticalAlignment;
    public final long visualOffset;

    public LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, BiasAlignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        int size = list.size();
        int i5 = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Placeable placeable = (Placeable) list.get(i6);
            boolean z3 = this.isVertical;
            i5 += z3 ? placeable.height : placeable.width;
            iMax = Math.max(iMax, !z3 ? placeable.height : placeable.width);
        }
        this.size = i5;
        int i7 = i5 + this.spacing;
        this.mainAxisSizeWithSpacings = i7 >= 0 ? i7 : 0;
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public final long m149getOffsetBjo55l4(int i) {
        if (i == 0 && this.placeables.size() == 0) {
            if (this.isVertical) {
                return (4294967295L & ((long) this.offset)) | (((long) 0) << 32);
            }
            return (4294967295L & ((long) 0)) | (((long) this.offset) << 32);
        }
        int i2 = i * 2;
        int[] iArr = this.placeableOffsets;
        int i3 = iArr[i2];
        return (4294967295L & ((long) iArr[i2 + 1])) | (((long) i3) << 32);
    }

    public final void place(Placeable.PlacementScope placementScope) {
        RootMeasurePolicy$measure$1 rootMeasurePolicy$measure$1 = RootMeasurePolicy$measure$1.INSTANCE$1;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
        }
        List list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = (Placeable) list.get(i);
            boolean z = this.isVertical;
            if (z) {
                int i2 = placeable.height;
            } else {
                int i3 = placeable.width;
            }
            long jM149getOffsetBjo55l4 = m149getOffsetBjo55l4(i);
            Modifier.CC.m(this.animator.keyToItemInfoMap.get(this.key));
            if (this.reverseLayout) {
                if (z) {
                    jM149getOffsetBjo55l4 = (((long) ((this.mainAxisLayoutSize - ((int) (jM149getOffsetBjo55l4 & 4294967295L))) - (z ? placeable.height : placeable.width))) & 4294967295L) | (((long) ((int) (jM149getOffsetBjo55l4 >> 32))) << 32);
                } else {
                    jM149getOffsetBjo55l4 = (((long) ((this.mainAxisLayoutSize - ((int) (jM149getOffsetBjo55l4 >> 32))) - (z ? placeable.height : placeable.width))) << 32) | (((long) ((int) (jM149getOffsetBjo55l4 & 4294967295L))) & 4294967295L);
                }
            }
            long jM714plusqkQi6aY = IntOffset.m714plusqkQi6aY(jM149getOffsetBjo55l4, this.visualOffset);
            if (z) {
                int i4 = PlaceableKt.$r8$clinit;
                placementScope.getClass();
                Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(jM714plusqkQi6aY, placeable.apparentToRealOffset), 0.0f, rootMeasurePolicy$measure$1);
            } else {
                int i5 = PlaceableKt.$r8$clinit;
                if (placementScope.getParentLayoutDirection() == LayoutDirection.Ltr || placementScope.getParentWidth() == 0) {
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                    placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(jM714plusqkQi6aY, placeable.apparentToRealOffset), 0.0f, rootMeasurePolicy$measure$1);
                } else {
                    long parentWidth = ((long) ((placementScope.getParentWidth() - placeable.width) - ((int) (jM714plusqkQi6aY >> 32)))) << 32;
                    Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                    placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY((((long) ((int) (jM714plusqkQi6aY & 4294967295L))) & 4294967295L) | parentWidth, placeable.apparentToRealOffset), 0.0f, rootMeasurePolicy$measure$1);
                }
            }
        }
    }

    public final void position(int i, int i2, int i3) {
        int i4;
        this.offset = i;
        boolean z = this.isVertical;
        this.mainAxisLayoutSize = z ? i3 : i2;
        List list = this.placeables;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = (Placeable) list.get(i5);
            int i6 = i5 * 2;
            int[] iArr = this.placeableOffsets;
            if (z) {
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw LazyItemScope$CC.m("null horizontalAlignment when isVertical == true");
                }
                iArr[i6] = horizontal.align(placeable.width, i2, this.layoutDirection);
                iArr[i6 + 1] = i;
                i4 = placeable.height;
            } else {
                iArr[i6] = i;
                int i7 = i6 + 1;
                BiasAlignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw LazyItemScope$CC.m("null verticalAlignment when isVertical == false");
                }
                iArr[i7] = vertical.align(placeable.height, i3);
                i4 = placeable.width;
            }
            i += i4;
        }
    }
}
