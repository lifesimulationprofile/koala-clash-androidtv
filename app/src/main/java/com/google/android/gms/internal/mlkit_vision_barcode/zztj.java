package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.compose.foundation.style.InteractionSet;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zztj {
    public static final boolean calculateIfHorizontallyStacked(ArrayList arrayList) {
        List list;
        long j;
        if (arrayList.size() >= 2) {
            if (arrayList.size() <= 1) {
                list = EmptyList.INSTANCE;
            } else {
                ArrayList arrayList2 = new ArrayList();
                Object obj = arrayList.get(0);
                int lastIndex = AppCompatHintHelper.getLastIndex(arrayList);
                int i = 0;
                while (i < lastIndex) {
                    i++;
                    Object obj2 = arrayList.get(i);
                    SemanticsNode semanticsNode = (SemanticsNode) obj2;
                    SemanticsNode semanticsNode2 = (SemanticsNode) obj;
                    arrayList2.add(new Offset((((long) Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (semanticsNode2.getBoundsInRoot().m378getCenterF1C5BW0() >> 32)) - Float.intBitsToFloat((int) (semanticsNode.getBoundsInRoot().m378getCenterF1C5BW0() >> 32))))) << 32) | (((long) Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (semanticsNode2.getBoundsInRoot().m378getCenterF1C5BW0() & 4294967295L)) - Float.intBitsToFloat((int) (semanticsNode.getBoundsInRoot().m378getCenterF1C5BW0() & 4294967295L))))) & 4294967295L)));
                    obj = obj2;
                }
                list = arrayList2;
            }
            if (list.size() == 1) {
                j = ((Offset) CollectionsKt.first(list)).packedValue;
            } else {
                if (list.isEmpty()) {
                    ListUtilsKt.throwUnsupportedOperationException("Empty collection can't be reduced.");
                }
                Object objFirst = CollectionsKt.first(list);
                int lastIndex2 = AppCompatHintHelper.getLastIndex(list);
                if (1 <= lastIndex2) {
                    int i2 = 1;
                    while (true) {
                        objFirst = new Offset(Offset.m373plusMKHz9U(((Offset) objFirst).packedValue, ((Offset) list.get(i2)).packedValue));
                        if (i2 == lastIndex2) {
                            break;
                        }
                        i2++;
                    }
                }
                j = ((Offset) objFirst).packedValue;
            }
            if (Float.intBitsToFloat((int) (4294967295L & j)) >= Float.intBitsToFloat((int) (j >> 32))) {
                return false;
            }
        }
        return true;
    }

    public static final void setCollectionInfo(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object obj = semanticsNode.getConfig().props.get(SemanticsProperties.CollectionInfo);
        if (obj == null) {
            obj = null;
        }
        CollectionInfo collectionInfo = (CollectionInfo) obj;
        if (collectionInfo != null) {
            accessibilityNodeInfoCompat.setCollectionInfo(ExposureStateImpl.obtain(collectionInfo.rowCount, collectionInfo.columnCount, 0));
            return;
        }
        ArrayList arrayList = new ArrayList();
        Object obj2 = semanticsNode.getConfig().props.get(SemanticsProperties.SelectableGroup);
        if ((obj2 != null ? obj2 : null) != null) {
            List children$ui$default = SemanticsNode.getChildren$ui$default(4, semanticsNode);
            int size = children$ui$default.size();
            for (int i = 0; i < size; i++) {
                SemanticsNode semanticsNode2 = (SemanticsNode) children$ui$default.get(i);
                if (semanticsNode2.getConfig().props.containsKey(SemanticsProperties.Selected)) {
                    arrayList.add(semanticsNode2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        boolean zCalculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
        accessibilityNodeInfoCompat.setCollectionInfo(ExposureStateImpl.obtain(zCalculateIfHorizontallyStacked ? 1 : arrayList.size(), zCalculateIfHorizontallyStacked ? arrayList.size() : 1, 0));
    }

    public static final void setCollectionItemInfo(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object obj = semanticsNode.getConfig().props.get(SemanticsProperties.CollectionItemInfo);
        if (obj == null) {
            obj = null;
        }
        if (obj != null) {
            throw new ClassCastException();
        }
        SemanticsNode parent = semanticsNode.getParent();
        if (parent == null) {
            return;
        }
        Object obj2 = parent.getConfig().props.get(SemanticsProperties.SelectableGroup);
        if (obj2 == null) {
            obj2 = null;
        }
        if (obj2 != null) {
            Object obj3 = parent.getConfig().props.get(SemanticsProperties.CollectionInfo);
            CollectionInfo collectionInfo = (CollectionInfo) (obj3 != null ? obj3 : null);
            if (collectionInfo == null || (collectionInfo.rowCount >= 0 && collectionInfo.columnCount >= 0)) {
                if (semanticsNode.getConfig().props.containsKey(SemanticsProperties.Selected)) {
                    ArrayList arrayList = new ArrayList();
                    List children$ui$default = SemanticsNode.getChildren$ui$default(4, parent);
                    int size = children$ui$default.size();
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        SemanticsNode semanticsNode2 = (SemanticsNode) children$ui$default.get(i2);
                        if (semanticsNode2.getConfig().props.containsKey(SemanticsProperties.Selected)) {
                            arrayList.add(semanticsNode2);
                            if (semanticsNode2.layoutNode.getPlaceOrder$ui() < semanticsNode.layoutNode.getPlaceOrder$ui()) {
                                i++;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    boolean zCalculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
                    int i3 = zCalculateIfHorizontallyStacked ? 0 : i;
                    int i4 = zCalculateIfHorizontallyStacked ? i : 0;
                    Object obj4 = semanticsNode.getConfig().props.get(SemanticsProperties.Selected);
                    if (obj4 == null) {
                        obj4 = Boolean.FALSE;
                    }
                    accessibilityNodeInfoCompat.setCollectionItemInfo(InteractionSet.obtain(((Boolean) obj4).booleanValue(), i3, 1, i4, 1));
                }
            }
        }
    }
}
