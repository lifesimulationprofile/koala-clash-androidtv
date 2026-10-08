package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzsf {
    public static List moveGroup(SlotWriter slotWriter, int i, SlotWriter slotWriter2, boolean z, boolean z2, boolean z3) {
        List list;
        boolean z4;
        int iGroupSize = slotWriter.groupSize(i);
        int i2 = i + iGroupSize;
        int iDataIndex = slotWriter.dataIndex(i);
        int iDataIndex2 = slotWriter.dataIndex(i2);
        int i3 = iDataIndex2 - iDataIndex;
        boolean z5 = i >= 0 && (slotWriter.groups[(slotWriter.groupIndexToAddress(i) * 5) + 1] & 201326592) != 0;
        slotWriter2.insertGroups(iGroupSize);
        slotWriter2.insertSlots(i3, slotWriter2.currentGroup);
        if (slotWriter.groupGapStart < i2) {
            slotWriter.moveGroupGapTo(i2);
        }
        if (slotWriter.slotsGapStart < iDataIndex2) {
            slotWriter.moveSlotGapTo(iDataIndex2, i2);
        }
        int[] iArr = slotWriter2.groups;
        int i4 = slotWriter2.currentGroup;
        int i5 = i4 * 5;
        ArraysKt.copyInto(i5, i * 5, i2 * 5, slotWriter.groups, iArr);
        Object[] objArr = slotWriter2.slots;
        int i6 = slotWriter2.currentSlot;
        System.arraycopy(slotWriter.slots, iDataIndex, objArr, i6, i3);
        int i7 = slotWriter2.parent;
        iArr[i5 + 2] = i7;
        int i8 = i4 - i;
        int i9 = i4 + iGroupSize;
        int iDataIndex3 = i6 - slotWriter2.dataIndex(iArr, i4);
        int i10 = slotWriter2.slotsGapOwner;
        int i11 = slotWriter2.slotsGapLen;
        int length = objArr.length;
        boolean z6 = z5;
        int i12 = i10;
        int i13 = i4;
        while (i13 < i9) {
            if (i13 != i4) {
                int i14 = (i13 * 5) + 2;
                iArr[i14] = iArr[i14] + i8;
            }
            int[] iArr2 = iArr;
            iArr2[(i13 * 5) + 4] = SlotWriter.dataIndexToDataAnchor(slotWriter2.dataIndex(iArr, i13) + iDataIndex3, i12 < i13 ? 0 : slotWriter2.slotsGapStart, i11, length);
            if (i13 == i12) {
                i12++;
            }
            i13++;
            i4 = i4;
            iArr = iArr2;
        }
        int[] iArr3 = iArr;
        slotWriter2.slotsGapOwner = i12;
        int iAccess$locationOf = SlotTableKt.access$locationOf(slotWriter.anchors, i, slotWriter.getSize$runtime());
        int iAccess$locationOf2 = SlotTableKt.access$locationOf(slotWriter.anchors, i2, slotWriter.getSize$runtime());
        if (iAccess$locationOf < iAccess$locationOf2) {
            ArrayList arrayList = slotWriter.anchors;
            ArrayList arrayList2 = new ArrayList(iAccess$locationOf2 - iAccess$locationOf);
            for (int i15 = iAccess$locationOf; i15 < iAccess$locationOf2; i15++) {
                GapAnchor gapAnchor = (GapAnchor) arrayList.get(i15);
                gapAnchor.location += i8;
                arrayList2.add(gapAnchor);
            }
            slotWriter2.anchors.addAll(SlotTableKt.access$locationOf(slotWriter2.anchors, slotWriter2.currentGroup, slotWriter2.getSize$runtime()), arrayList2);
            arrayList.subList(iAccess$locationOf, iAccess$locationOf2).clear();
            list = arrayList2;
        } else {
            list = EmptyList.INSTANCE;
        }
        if (!list.isEmpty()) {
            HashMap map = slotWriter.sourceInformationMap;
            HashMap map2 = slotWriter2.sourceInformationMap;
            if (map != null && map2 != null) {
                int size = list.size();
                for (int i16 = 0; i16 < size; i16++) {
                }
            }
        }
        int i17 = slotWriter2.parent;
        slotWriter2.sourceInformationOf$runtime(i7);
        int iParent = slotWriter.parent(slotWriter.groups, i);
        if (!z3) {
            z4 = false;
        } else if (z) {
            boolean z7 = iParent >= 0;
            if (z7) {
                slotWriter.startGroup();
                slotWriter.advanceBy(iParent - slotWriter.currentGroup);
                slotWriter.startGroup();
            }
            slotWriter.advanceBy(i - slotWriter.currentGroup);
            boolean zRemoveGroup = slotWriter.removeGroup();
            if (z7) {
                slotWriter.skipToGroupEnd();
                slotWriter.endGroup();
                slotWriter.skipToGroupEnd();
                slotWriter.endGroup();
            }
            z4 = zRemoveGroup;
        } else {
            boolean zRemoveGroups = slotWriter.removeGroups(i, iGroupSize);
            slotWriter.removeSlots(iDataIndex, i3, i - 1);
            z4 = zRemoveGroups;
        }
        if (z4) {
            ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
        }
        int i18 = slotWriter2.nodeCount;
        int i19 = iArr3[i5 + 1];
        slotWriter2.nodeCount = i18 + ((1073741824 & i19) != 0 ? 1 : i19 & 67108863);
        if (z2) {
            slotWriter2.currentGroup = i9;
            slotWriter2.currentSlot = i6 + i3;
        }
        if (z6) {
            slotWriter2.updateContainsMark(i7);
        }
        return list;
    }
}
