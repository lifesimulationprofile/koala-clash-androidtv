package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.room.RoomOpenHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutItemAnimator {
    public final ArrayList disappearingItems;
    public RoomOpenHelper keyIndexMap;
    public final MutableScatterMap keyToItemInfoMap;
    public final Modifier modifier;
    public final MutableScatterSet movingAwayKeys;
    public final ArrayList movingAwayToEndBound;
    public final ArrayList movingAwayToStartBound;
    public final ArrayList movingInFromEndBound;
    public final ArrayList movingInFromStartBound;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    final class DisplayingDisappearingItemsElement extends ModifierNodeElement {
        public final LazyLayoutItemAnimator animator;

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final Modifier.Node create() {
            DisplayingDisappearingItemsNode displayingDisappearingItemsNode = new DisplayingDisappearingItemsNode();
            displayingDisappearingItemsNode.animator = this.animator;
            return displayingDisappearingItemsNode;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayingDisappearingItemsElement) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsElement) obj).animator);
        }

        public final int hashCode() {
            return this.animator.hashCode();
        }

        public final String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final void update(Modifier.Node node) {
            DisplayingDisappearingItemsNode displayingDisappearingItemsNode = (DisplayingDisappearingItemsNode) node;
            LazyLayoutItemAnimator lazyLayoutItemAnimator = displayingDisappearingItemsNode.animator;
            LazyLayoutItemAnimator lazyLayoutItemAnimator2 = this.animator;
            if (Intrinsics.areEqual(lazyLayoutItemAnimator, lazyLayoutItemAnimator2) || !displayingDisappearingItemsNode.node.isAttached) {
                return;
            }
            LazyLayoutItemAnimator lazyLayoutItemAnimator3 = displayingDisappearingItemsNode.animator;
            lazyLayoutItemAnimator3.releaseAnimations();
            lazyLayoutItemAnimator3.keyIndexMap = null;
            displayingDisappearingItemsNode.animator = lazyLayoutItemAnimator2;
        }
    }

    public LazyLayoutItemAnimator() {
        long[] jArr = ScatterMapKt.EmptyGroup;
        this.keyToItemInfoMap = new MutableScatterMap();
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.movingAwayKeys = new MutableScatterSet();
        this.movingInFromStartBound = new ArrayList();
        this.movingInFromEndBound = new ArrayList();
        this.movingAwayToStartBound = new ArrayList();
        this.movingAwayToEndBound = new ArrayList();
        this.disappearingItems = new ArrayList();
        this.modifier = new DisplayingDisappearingItemsElement(this);
    }

    public static int updateAndReturnOffsetFor(int[] iArr, LazyListMeasuredItem lazyListMeasuredItem) {
        lazyListMeasuredItem.getClass();
        int i = iArr[0] + lazyListMeasuredItem.mainAxisSizeWithSpacings;
        iArr[0] = i;
        return Math.max(0, i);
    }

    /* JADX INFO: renamed from: getMinSizeToFitDisappearingItems-YbymL2g, reason: not valid java name */
    public final long m152getMinSizeToFitDisappearingItemsYbymL2g() {
        ArrayList arrayList = this.disappearingItems;
        if (arrayList.size() <= 0) {
            return 0L;
        }
        Modifier.CC.m(arrayList.get(0));
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:118:0x009c A[EDGE_INSN: B:118:0x009c->B:34:0x009c BREAK  A[LOOP:2: B:21:0x0062->B:32:0x0097], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0093  */
    /* JADX WARN: Code duplicated, block: B:32:0x0097 A[LOOP:2: B:21:0x0062->B:32:0x0097, LOOP_END] */
    public final void onMeasured(int i, int i2, ArrayList arrayList, final RoomOpenHelper roomOpenHelper, LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1, boolean z, boolean z2, int i3, int i4) throws Throwable {
        long j;
        Throwable th;
        ArrayList arrayList2;
        final int i5;
        final RoomOpenHelper roomOpenHelper2 = this.keyIndexMap;
        this.keyIndexMap = roomOpenHelper;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) arrayList.get(i6);
            int size2 = lazyListMeasuredItem.placeables.size();
            for (int i7 = 0; i7 < size2; i7++) {
                ((Placeable) lazyListMeasuredItem.placeables.get(i7)).getParentData();
            }
        }
        MutableScatterMap mutableScatterMap = this.keyToItemInfoMap;
        if (mutableScatterMap.isEmpty()) {
            releaseAnimations();
            return;
        }
        boolean z3 = z || !z2;
        Object[] objArr = mutableScatterMap.keys;
        long[] jArr = mutableScatterMap.metadata;
        final int i8 = 2;
        int length = jArr.length - 2;
        MutableScatterSet mutableScatterSet = this.movingAwayKeys;
        if (length >= 0) {
            int i9 = 0;
            j = 255;
            while (true) {
                long j2 = jArr[i9];
                int i10 = i9;
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i10 != length) {
                        break;
                        break;
                    }
                    i9 = i10 + 1;
                } else {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    long j3 = j2;
                    for (int i12 = 0; i12 < i11; i12++) {
                        if ((j3 & 255) < 128) {
                            mutableScatterSet.add(objArr[(i10 << 3) + i12]);
                        }
                        j3 >>= 8;
                    }
                    if (i11 != 8) {
                        break;
                    } else if (i10 != length) {
                        break;
                    } else {
                        i9 = i10 + 1;
                    }
                }
            }
        } else {
            j = 255;
        }
        int size3 = arrayList.size();
        for (int i13 = 0; i13 < size3; i13++) {
            LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayList.get(i13);
            mutableScatterSet.remove(lazyListMeasuredItem2.key);
            int size4 = lazyListMeasuredItem2.placeables.size();
            for (int i14 = 0; i14 < size4; i14++) {
                ((Placeable) lazyListMeasuredItem2.placeables.get(i14)).getParentData();
            }
            Modifier.CC.m(mutableScatterMap.remove(lazyListMeasuredItem2.key));
            Unit unit = Unit.INSTANCE;
        }
        int[] iArr = new int[1];
        ArrayList arrayList3 = this.movingInFromEndBound;
        ArrayList arrayList4 = this.movingInFromStartBound;
        if (z3 && roomOpenHelper2 != null) {
            if (arrayList4.isEmpty()) {
                i5 = 0;
            } else {
                if (arrayList4.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList4, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            switch (i8) {
                                case 0:
                                    Object obj3 = ((LazyListMeasuredItem) obj).key;
                                    RoomOpenHelper roomOpenHelper3 = roomOpenHelper2;
                                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper3.getIndex(obj3)), Integer.valueOf(roomOpenHelper3.getIndex(((LazyListMeasuredItem) obj2).key)));
                                case 1:
                                    Object obj4 = ((LazyListMeasuredItem) obj).key;
                                    RoomOpenHelper roomOpenHelper4 = roomOpenHelper2;
                                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper4.getIndex(obj4)), Integer.valueOf(roomOpenHelper4.getIndex(((LazyListMeasuredItem) obj2).key)));
                                case 2:
                                    Object obj5 = ((LazyListMeasuredItem) obj2).key;
                                    RoomOpenHelper roomOpenHelper5 = roomOpenHelper2;
                                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper5.getIndex(obj5)), Integer.valueOf(roomOpenHelper5.getIndex(((LazyListMeasuredItem) obj).key)));
                                default:
                                    Object obj6 = ((LazyListMeasuredItem) obj2).key;
                                    RoomOpenHelper roomOpenHelper6 = roomOpenHelper2;
                                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper6.getIndex(obj6)), Integer.valueOf(roomOpenHelper6.getIndex(((LazyListMeasuredItem) obj).key)));
                            }
                        }
                    });
                }
                if (arrayList4.size() > 0) {
                    LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayList4.get(0);
                    updateAndReturnOffsetFor(iArr, lazyListMeasuredItem3);
                    Modifier.CC.m(mutableScatterMap.get(lazyListMeasuredItem3.key));
                    lazyListMeasuredItem3.m149getOffsetBjo55l4(0);
                    throw null;
                }
                i5 = 0;
                Arrays.fill(iArr, 0, iArr.length, 0);
            }
            if (!arrayList3.isEmpty()) {
                if (arrayList3.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList3, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            switch (i5) {
                                case 0:
                                    Object obj3 = ((LazyListMeasuredItem) obj).key;
                                    RoomOpenHelper roomOpenHelper3 = roomOpenHelper2;
                                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper3.getIndex(obj3)), Integer.valueOf(roomOpenHelper3.getIndex(((LazyListMeasuredItem) obj2).key)));
                                case 1:
                                    Object obj4 = ((LazyListMeasuredItem) obj).key;
                                    RoomOpenHelper roomOpenHelper4 = roomOpenHelper2;
                                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper4.getIndex(obj4)), Integer.valueOf(roomOpenHelper4.getIndex(((LazyListMeasuredItem) obj2).key)));
                                case 2:
                                    Object obj5 = ((LazyListMeasuredItem) obj2).key;
                                    RoomOpenHelper roomOpenHelper5 = roomOpenHelper2;
                                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper5.getIndex(obj5)), Integer.valueOf(roomOpenHelper5.getIndex(((LazyListMeasuredItem) obj).key)));
                                default:
                                    Object obj6 = ((LazyListMeasuredItem) obj2).key;
                                    RoomOpenHelper roomOpenHelper6 = roomOpenHelper2;
                                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper6.getIndex(obj6)), Integer.valueOf(roomOpenHelper6.getIndex(((LazyListMeasuredItem) obj).key)));
                            }
                        }
                    });
                }
                if (arrayList3.size() > 0) {
                    LazyListMeasuredItem lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayList3.get(i5);
                    updateAndReturnOffsetFor(iArr, lazyListMeasuredItem4);
                    Modifier.CC.m(mutableScatterMap.get(lazyListMeasuredItem4.key));
                    lazyListMeasuredItem4.m149getOffsetBjo55l4(i5);
                    throw null;
                }
                Arrays.fill(iArr, 0, iArr.length, i5);
            }
        }
        Object[] objArr2 = mutableScatterSet.elements;
        long[] jArr2 = mutableScatterSet.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            Throwable th2 = null;
            arrayList2 = arrayList3;
            int i15 = 0;
            while (true) {
                long j4 = jArr2[i15];
                th = th2;
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i16 = 8 - ((~(i15 - length2)) >>> 31);
                    long j5 = j4;
                    for (int i17 = 0; i17 < i16; i17++) {
                        if ((j5 & j) < 128) {
                            Modifier.CC.m(mutableScatterMap.get(objArr2[(i15 << 3) + i17]));
                        }
                        j5 >>= 8;
                    }
                    if (i16 != 8) {
                        break;
                    }
                }
                if (i15 == length2) {
                    break;
                }
                i15++;
                th2 = th;
            }
        } else {
            th = null;
            arrayList2 = arrayList3;
        }
        ArrayList arrayList5 = this.movingAwayToStartBound;
        if (!arrayList5.isEmpty()) {
            if (arrayList5.size() > 1) {
                final int i18 = 3;
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList5, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        switch (i18) {
                            case 0:
                                Object obj3 = ((LazyListMeasuredItem) obj).key;
                                RoomOpenHelper roomOpenHelper3 = roomOpenHelper;
                                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper3.getIndex(obj3)), Integer.valueOf(roomOpenHelper3.getIndex(((LazyListMeasuredItem) obj2).key)));
                            case 1:
                                Object obj4 = ((LazyListMeasuredItem) obj).key;
                                RoomOpenHelper roomOpenHelper4 = roomOpenHelper;
                                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper4.getIndex(obj4)), Integer.valueOf(roomOpenHelper4.getIndex(((LazyListMeasuredItem) obj2).key)));
                            case 2:
                                Object obj5 = ((LazyListMeasuredItem) obj2).key;
                                RoomOpenHelper roomOpenHelper5 = roomOpenHelper;
                                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper5.getIndex(obj5)), Integer.valueOf(roomOpenHelper5.getIndex(((LazyListMeasuredItem) obj).key)));
                            default:
                                Object obj6 = ((LazyListMeasuredItem) obj2).key;
                                RoomOpenHelper roomOpenHelper6 = roomOpenHelper;
                                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper6.getIndex(obj6)), Integer.valueOf(roomOpenHelper6.getIndex(((LazyListMeasuredItem) obj).key)));
                        }
                    }
                });
            }
            int size5 = arrayList5.size();
            for (int i19 = 0; i19 < size5; i19++) {
                LazyListMeasuredItem lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayList5.get(i19);
                Modifier.CC.m(mutableScatterMap.get(lazyListMeasuredItem5.key));
                int iUpdateAndReturnOffsetFor = updateAndReturnOffsetFor(iArr, lazyListMeasuredItem5);
                if (!z) {
                    throw th;
                }
                LazyListMeasuredItem lazyListMeasuredItem6 = (LazyListMeasuredItem) CollectionsKt.first((List) arrayList);
                long jM149getOffsetBjo55l4 = lazyListMeasuredItem6.m149getOffsetBjo55l4(0);
                lazyListMeasuredItem5.position(((int) (lazyListMeasuredItem6.isVertical ? 4294967295L & jM149getOffsetBjo55l4 : jM149getOffsetBjo55l4 >> 32)) - iUpdateAndReturnOffsetFor, i, i2);
                if (z3) {
                    Modifier.CC.m(mutableScatterMap.get(lazyListMeasuredItem5.key));
                    throw th;
                }
            }
            Arrays.fill(iArr, 0, iArr.length, 0);
        }
        ArrayList arrayList6 = this.movingAwayToEndBound;
        if (!arrayList6.isEmpty()) {
            final int i20 = 1;
            if (arrayList6.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList6, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        switch (i20) {
                            case 0:
                                Object obj3 = ((LazyListMeasuredItem) obj).key;
                                RoomOpenHelper roomOpenHelper3 = roomOpenHelper;
                                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper3.getIndex(obj3)), Integer.valueOf(roomOpenHelper3.getIndex(((LazyListMeasuredItem) obj2).key)));
                            case 1:
                                Object obj4 = ((LazyListMeasuredItem) obj).key;
                                RoomOpenHelper roomOpenHelper4 = roomOpenHelper;
                                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper4.getIndex(obj4)), Integer.valueOf(roomOpenHelper4.getIndex(((LazyListMeasuredItem) obj2).key)));
                            case 2:
                                Object obj5 = ((LazyListMeasuredItem) obj2).key;
                                RoomOpenHelper roomOpenHelper5 = roomOpenHelper;
                                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper5.getIndex(obj5)), Integer.valueOf(roomOpenHelper5.getIndex(((LazyListMeasuredItem) obj).key)));
                            default:
                                Object obj6 = ((LazyListMeasuredItem) obj2).key;
                                RoomOpenHelper roomOpenHelper6 = roomOpenHelper;
                                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(roomOpenHelper6.getIndex(obj6)), Integer.valueOf(roomOpenHelper6.getIndex(((LazyListMeasuredItem) obj).key)));
                        }
                    }
                });
            }
            if (arrayList6.size() > 0) {
                LazyListMeasuredItem lazyListMeasuredItem7 = (LazyListMeasuredItem) arrayList6.get(0);
                Modifier.CC.m(mutableScatterMap.get(lazyListMeasuredItem7.key));
                updateAndReturnOffsetFor(iArr, lazyListMeasuredItem7);
                throw th;
            }
        }
        Collections.reverse(arrayList5);
        Unit unit2 = Unit.INSTANCE;
        arrayList.addAll(0, arrayList5);
        arrayList.addAll(arrayList6);
        arrayList4.clear();
        arrayList2.clear();
        arrayList5.clear();
        arrayList6.clear();
        mutableScatterSet.clear();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x004a A[LOOP:0: B:7:0x0013->B:18:0x004a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:22:0x004d A[EDGE_INSN: B:22:0x004d->B:19:0x004d BREAK  A[LOOP:0: B:7:0x0013->B:18:0x004a], SYNTHETIC] */
    public final void releaseAnimations() {
        MutableScatterMap mutableScatterMap = this.keyToItemInfoMap;
        if (mutableScatterMap.isNotEmpty()) {
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                Modifier.CC.m(objArr[(i << 3) + i3]);
                                throw null;
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            mutableScatterMap.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {
        public LazyLayoutItemAnimator animator;

        @Override // androidx.compose.ui.node.DrawModifierNode
        public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
            ArrayList arrayList = this.animator.disappearingItems;
            if (arrayList.size() <= 0) {
                layoutNodeDrawScope.drawContent();
            } else {
                Modifier.CC.m(arrayList.get(0));
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayingDisappearingItemsNode) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsNode) obj).animator);
        }

        public final int hashCode() {
            return this.animator.hashCode();
        }

        @Override // androidx.compose.ui.Modifier.Node
        public final void onAttach() {
            this.animator.getClass();
        }

        @Override // androidx.compose.ui.Modifier.Node
        public final void onDetach() {
            LazyLayoutItemAnimator lazyLayoutItemAnimator = this.animator;
            lazyLayoutItemAnimator.releaseAnimations();
            lazyLayoutItemAnimator.keyIndexMap = null;
        }

        public final String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.animator + ')';
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public final /* synthetic */ void onMeasureResultChanged() {
        }
    }
}
