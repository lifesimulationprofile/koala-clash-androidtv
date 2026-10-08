package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SingleSelectionLayout implements SelectionLayout {
    public final int endSlot;
    public final SelectableInfo info;
    public final boolean isStartHandle;
    public final Selection previousSelection;
    public final int startSlot;

    public SingleSelectionLayout(boolean z, int i, int i2, Selection selection, SelectableInfo selectableInfo) {
        this.isStartHandle = z;
        this.startSlot = i;
        this.endSlot = i2;
        this.previousSelection = selection;
        this.info = selectableInfo;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final MutableLongObjectMap createSubSelections(Selection selection) {
        boolean z = selection.handlesCrossed;
        Selection.AnchorInfo anchorInfo = selection.end;
        Selection.AnchorInfo anchorInfo2 = selection.start;
        if ((!z && anchorInfo2.offset > anchorInfo.offset) || (z && anchorInfo2.offset <= anchorInfo.offset)) {
            selection = Selection.copy$default(selection, null, null, !z, 3);
        }
        long j = this.info.selectableId;
        MutableLongObjectMap mutableLongObjectMap = LongObjectMapKt.EmptyLongObjectMap;
        MutableLongObjectMap mutableLongObjectMap2 = new MutableLongObjectMap();
        mutableLongObjectMap2.set(j, selection);
        return mutableLongObjectMap2;
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
        return this.info.getRawCrossStatus();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final SelectableInfo getCurrentInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final SelectableInfo getEndInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final int getEndSlot() {
        return this.endSlot;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final SelectableInfo getFirstInfo() {
        return this.info;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final Selection getPreviousSelection() {
        return this.previousSelection;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final int getSize() {
        return 1;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final SelectableInfo getStartInfo() {
        return this.info;
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
        if (this.previousSelection == null || selectionLayout == null || !(selectionLayout instanceof SingleSelectionLayout)) {
            return true;
        }
        SingleSelectionLayout singleSelectionLayout = (SingleSelectionLayout) selectionLayout;
        if (this.startSlot != singleSelectionLayout.startSlot || this.endSlot != singleSelectionLayout.endSlot || this.isStartHandle != singleSelectionLayout.isStartHandle) {
            return true;
        }
        SelectableInfo selectableInfo = singleSelectionLayout.info;
        SelectableInfo selectableInfo2 = this.info;
        return (selectableInfo2.selectableId == selectableInfo.selectableId && selectableInfo2.rawStartHandleOffset == selectableInfo.rawStartHandleOffset && selectableInfo2.rawEndHandleOffset == selectableInfo.rawEndHandleOffset) ? false : true;
    }

    public final String toString() {
        return "SingleSelectionLayout(isStartHandle=" + this.isStartHandle + ", crossed=" + Modifier.CC.stringValueOf(getCrossStatus()) + ", info=\n\t" + this.info + ')';
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public final void forEachMiddleInfo(Function1 function1) {
    }
}
