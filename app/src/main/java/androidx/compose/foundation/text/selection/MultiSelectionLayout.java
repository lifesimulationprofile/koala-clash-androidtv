package androidx.compose.foundation.text.selection;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import coil.network.HttpException;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MultiSelectionLayout implements SelectionLayout {
    public final int endSlot;
    public final List infoList;
    public final boolean isStartHandle;
    public final Selection previousSelection;
    public final MutableLongIntMap selectableIdToInfoListIndex;
    public final int startSlot;

    public MultiSelectionLayout(MutableLongIntMap mutableLongIntMap, List list, int i, int i2, boolean z, Selection selection) {
        this.selectableIdToInfoListIndex = mutableLongIntMap;
        this.infoList = list;
        this.startSlot = i;
        this.endSlot = i2;
        this.isStartHandle = z;
        this.previousSelection = selection;
        if (list.size() > 1) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("MultiSelectionLayout requires an infoList size greater than 1, was " + list.size() + '.');
    }

    public static void createAndPutSubSelection(MutableLongObjectMap mutableLongObjectMap, Selection selection, SelectableInfo selectableInfo, int i, int i2) {
        Selection selection2;
        if (selection.handlesCrossed) {
            selection2 = new Selection(selectableInfo.anchorForOffset(i2), selectableInfo.anchorForOffset(i), i2 > i);
        } else {
            selection2 = new Selection(selectableInfo.anchorForOffset(i), selectableInfo.anchorForOffset(i2), i > i2);
        }
        if (i > i2) {
            InlineClassHelperKt.throwIllegalStateException("minOffset should be less than or equal to maxOffset: " + selection2);
        }
        long j = selectableInfo.selectableId;
        int iFindAbsoluteInsertIndex = mutableLongObjectMap.findAbsoluteInsertIndex(j);
        Object[] objArr = mutableLongObjectMap.values;
        Object obj = objArr[iFindAbsoluteInsertIndex];
        mutableLongObjectMap.keys[iFindAbsoluteInsertIndex] = j;
        objArr[iFindAbsoluteInsertIndex] = selection2;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final MutableLongObjectMap createSubSelections(Selection selection) {
        Selection.AnchorInfo anchorInfo = selection.start;
        boolean z = selection.handlesCrossed;
        long j = anchorInfo.selectableId;
        int i = anchorInfo.offset;
        Selection.AnchorInfo anchorInfo2 = selection.end;
        long j2 = anchorInfo2.selectableId;
        int i2 = anchorInfo2.offset;
        if (j != j2) {
            MutableLongObjectMap mutableLongObjectMap = LongObjectMapKt.EmptyLongObjectMap;
            MutableLongObjectMap mutableLongObjectMap2 = new MutableLongObjectMap();
            createAndPutSubSelection(mutableLongObjectMap2, selection, getFirstInfo(), (z ? anchorInfo2 : anchorInfo).offset, getFirstInfo().textLayoutResult.layoutInput.text.text.length());
            forEachMiddleInfo(new BackHandlerKt$$ExternalSyntheticLambda2(this, mutableLongObjectMap2, selection));
            if (!z) {
                anchorInfo = anchorInfo2;
            }
            createAndPutSubSelection(mutableLongObjectMap2, selection, getCrossStatus() == 1 ? getStartInfo() : getEndInfo(), 0, anchorInfo.offset);
            return mutableLongObjectMap2;
        }
        if ((!z || i < i2) && (z || i > i2)) {
            InlineClassHelperKt.throwIllegalStateException("unexpectedly miss-crossed selection: " + selection);
        }
        long j3 = anchorInfo.selectableId;
        MutableLongObjectMap mutableLongObjectMap3 = LongObjectMapKt.EmptyLongObjectMap;
        MutableLongObjectMap mutableLongObjectMap4 = new MutableLongObjectMap();
        mutableLongObjectMap4.set(j3, selection);
        return mutableLongObjectMap4;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final void forEachMiddleInfo(Function1 function1) {
        int infoListIndexBySelectableId = getInfoListIndexBySelectableId(getFirstInfo().selectableId);
        int infoListIndexBySelectableId2 = getInfoListIndexBySelectableId((getCrossStatus() == 1 ? getStartInfo() : getEndInfo()).selectableId);
        int i = infoListIndexBySelectableId + 1;
        if (i >= infoListIndexBySelectableId2) {
            return;
        }
        while (i < infoListIndexBySelectableId2) {
            function1.invoke(this.infoList.get(i));
            i++;
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final int getCrossStatus() {
        int i = this.startSlot;
        int i2 = this.endSlot;
        if (i < i2) {
            return 2;
        }
        if (i > i2) {
            return 1;
        }
        return ((SelectableInfo) this.infoList.get(i / 2)).getRawCrossStatus();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final SelectableInfo getCurrentInfo() {
        return this.isStartHandle ? getStartInfo() : getEndInfo();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final SelectableInfo getEndInfo() {
        return (SelectableInfo) this.infoList.get(startOrEndSlotToIndex(this.endSlot, false));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final int getEndSlot() {
        return this.endSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final SelectableInfo getFirstInfo() {
        return getCrossStatus() == 1 ? getEndInfo() : getStartInfo();
    }

    public final int getInfoListIndexBySelectableId(long j) {
        try {
            return this.selectableIdToInfoListIndex.get(j);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException(Modifier.CC.m("Invalid selectableId: ", j), e);
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final Selection getPreviousSelection() {
        return this.previousSelection;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final int getSize() {
        return this.infoList.size();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final SelectableInfo getStartInfo() {
        return (SelectableInfo) this.infoList.get(startOrEndSlotToIndex(this.startSlot, true));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final int getStartSlot() {
        return this.startSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final boolean isStartHandle() {
        return this.isStartHandle;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final boolean shouldRecomputeSelection(SelectionLayout selectionLayout) {
        if (this.previousSelection != null && selectionLayout != null && (selectionLayout instanceof MultiSelectionLayout)) {
            MultiSelectionLayout multiSelectionLayout = (MultiSelectionLayout) selectionLayout;
            List list = multiSelectionLayout.infoList;
            if (this.isStartHandle == multiSelectionLayout.isStartHandle && this.startSlot == multiSelectionLayout.startSlot && this.endSlot == multiSelectionLayout.endSlot) {
                List list2 = this.infoList;
                if (list2.size() == list.size()) {
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        SelectableInfo selectableInfo = (SelectableInfo) list2.get(i);
                        SelectableInfo selectableInfo2 = (SelectableInfo) list.get(i);
                        if (selectableInfo.selectableId != selectableInfo2.selectableId || selectableInfo.rawStartHandleOffset != selectableInfo2.rawStartHandleOffset || selectableInfo.rawEndHandleOffset != selectableInfo2.rawEndHandleOffset) {
                            return true;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int startOrEndSlotToIndex(int i, boolean z) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(getCrossStatus());
        boolean z2 = z;
        if (iOrdinal == 0) {
            z2 = !z ? 1 : 0;
        } else if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new HttpException();
            }
        }
        return (i - (!z2)) / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MultiSelectionLayout(isStartHandle=");
        sb.append(this.isStartHandle);
        sb.append(", startPosition=");
        boolean z = true;
        float f = 2;
        sb.append((this.startSlot + 1) / f);
        sb.append(", endPosition=");
        sb.append((this.endSlot + 1) / f);
        sb.append(", crossed=");
        sb.append(Modifier.CC.stringValueOf(getCrossStatus()));
        sb.append(", infos=");
        StringBuilder sb2 = new StringBuilder("[\n\t");
        List list = this.infoList;
        int size = list.size();
        int i = 0;
        while (i < size) {
            SelectableInfo selectableInfo = (SelectableInfo) list.get(i);
            if (z) {
                z = false;
            } else {
                sb2.append(",\n\t");
            }
            StringBuilder sb3 = new StringBuilder();
            i++;
            sb3.append(i);
            sb3.append(" -> ");
            sb3.append(selectableInfo);
            sb2.append(sb3.toString());
        }
        sb2.append("\n]");
        sb.append(sb2.toString());
        sb.append(')');
        return sb.toString();
    }
}
