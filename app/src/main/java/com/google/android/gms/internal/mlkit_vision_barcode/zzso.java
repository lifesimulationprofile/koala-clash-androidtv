package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.tooling.ReaderTraceBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzso {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.runtime.tooling.ReaderTraceBuilder, androidx.lifecycle.Lifecycle] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.composer.gapbuffer.GapAnchor] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Integer] */
    public static final List buildTrace(SlotWriter slotWriter, Integer num, int i, Integer num2) {
        int iParent;
        int iGroupKey;
        MutableObjectList mutableObjectList;
        if (slotWriter.closed || slotWriter.getSize$runtime() == 0) {
            return EmptyList.INSTANCE;
        }
        ?? readerTraceBuilder = new ReaderTraceBuilder(1, slotWriter);
        if (num2 != null) {
            iParent = num2.intValue();
        } else {
            iParent = slotWriter.parent;
            if (iParent < 0) {
                iParent = slotWriter.parent(slotWriter.groups, i);
            }
        }
        if (num == 0) {
            int iSlotIndex = slotWriter.currentSlot - slotWriter.slotIndex(slotWriter.groups, slotWriter.groupIndexToAddress(i));
            MutableIntObjectMap mutableIntObjectMap = slotWriter.deferredSlotWrites;
            num = Integer.valueOf(iSlotIndex + ((mutableIntObjectMap == null || (mutableObjectList = (MutableObjectList) mutableIntObjectMap.get(i)) == null) ? 0 : mutableObjectList._size));
        }
        int iGroupIndexToAddress = slotWriter.groupIndexToAddress(i) * 5;
        int[] iArr = slotWriter.groups;
        if (iGroupIndexToAddress < iArr.length) {
            iGroupKey = slotWriter.groupKey(i);
        } else {
            int iParent2 = iParent >= 0 ? slotWriter.parent(iArr, iParent) : iParent;
            iGroupKey = slotWriter.groupKey(iParent);
            int i2 = iParent;
            iParent = iParent2;
            i = i2;
        }
        while (i >= 0) {
            readerTraceBuilder.processEdge(iGroupKey, (slotWriter.groups[(slotWriter.groupIndexToAddress(i) * 5) + 1] & 536870912) != 0 ? slotWriter.groupObjectKey(i) : Composer$Companion.Empty, slotWriter.sourceInformationOf$runtime(i), num);
            num = slotWriter.anchor(i);
            if (iParent >= 0) {
                int iParent3 = slotWriter.parent(slotWriter.groups, iParent);
                iGroupKey = slotWriter.groupKey(iParent);
                int i3 = iParent;
                iParent = iParent3;
                i = i3;
            } else {
                i = iParent;
            }
        }
        return (ArrayList) readerTraceBuilder.internalScopeRef;
    }

    public static final Integer findSubcompositionContextGroup$lambda$0$scanGroup(SlotReader slotReader, CompositionContext compositionContext, int i, int i2) {
        Integer numFindSubcompositionContextGroup$lambda$0$scanGroup;
        int[] iArr = slotReader.groups;
        while (true) {
            if (i >= i2) {
                return null;
            }
            int i3 = iArr[(i * 5) + 3] + i;
            if (slotReader.hasMark(i) && slotReader.groupKey(i) == 206 && Intrinsics.areEqual(slotReader.objectKey(iArr, i), ComposerKt.reference)) {
                Object objGroupGet = slotReader.groupGet(i, 0);
                RememberObserverHolder rememberObserverHolder = objGroupGet instanceof RememberObserverHolder ? (RememberObserverHolder) objGroupGet : null;
                RememberObserver wrapped = rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null;
                GapComposer.CompositionContextHolder compositionContextHolder = wrapped instanceof GapComposer.CompositionContextHolder ? (GapComposer.CompositionContextHolder) wrapped : null;
                if (compositionContextHolder != null && compositionContextHolder.ref.equals(compositionContext)) {
                    return Integer.valueOf(i);
                }
            }
            if (slotReader.containsMark(i) && (numFindSubcompositionContextGroup$lambda$0$scanGroup = findSubcompositionContextGroup$lambda$0$scanGroup(slotReader, compositionContext, i + 1, i3)) != null) {
                return Integer.valueOf(numFindSubcompositionContextGroup$lambda$0$scanGroup.intValue());
            }
            i = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.runtime.tooling.ReaderTraceBuilder, androidx.lifecycle.Lifecycle] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public static final ArrayList traceForGroup(SlotReader slotReader, int i, Integer num) {
        ?? readerTraceBuilder = new ReaderTraceBuilder(0, slotReader);
        i = slotReader.parent(i);
        GapAnchor gapAnchorAnchor = slotReader.anchor(i);
        while (i >= 0) {
            readerTraceBuilder.processEdge(slotReader.groupKey(i), slotReader.hasObjectKey(i) ? slotReader.objectKey(slotReader.groups, i) : Composer$Companion.Empty, slotReader.table.sourceInformationOf(i), num);
            if (i >= 0) {
                GapAnchor gapAnchor = gapAnchorAnchor;
                gapAnchorAnchor = slotReader.anchor(i);
                i = slotReader.parent(i);
                num = gapAnchor;
            } else {
                num = gapAnchorAnchor;
            }
        }
        return (ArrayList) readerTraceBuilder.internalScopeRef;
    }
}
