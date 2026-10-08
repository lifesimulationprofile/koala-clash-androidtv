package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionAdjustment$Companion$$ExternalSyntheticLambda0 {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: Code duplicated, block: B:27:0x006c  */
    public final Selection adjust(SelectionLayout selectionLayout) {
        Selection.AnchorInfo anchorInfoAccess$updateSelectionBoundary;
        Selection.AnchorInfo anchorInfoAccess$updateSelectionBoundary2;
        boolean z;
        Selection selectionCopy$default;
        switch (this.$r8$classId) {
            case 0:
                return new Selection(selectionLayout.getStartInfo().anchorForOffset(selectionLayout.getStartInfo().rawStartHandleOffset), selectionLayout.getEndInfo().anchorForOffset(selectionLayout.getEndInfo().rawEndHandleOffset), selectionLayout.getCrossStatus() == 1);
            case 1:
                return SimpleLayoutKt.access$adjustToBoundaries(selectionLayout, SelectionAdjustment$Companion.INSTANCE$1);
            case 2:
                return SimpleLayoutKt.access$adjustToBoundaries(selectionLayout, SelectionAdjustment$Companion.INSTANCE);
            default:
                Selection previousSelection = selectionLayout.getPreviousSelection();
                if (previousSelection == null) {
                    return SimpleLayoutKt.access$adjustToBoundaries(selectionLayout, SelectionAdjustment$Companion.INSTANCE$1);
                }
                Selection.AnchorInfo anchorInfo = previousSelection.end;
                Selection.AnchorInfo anchorInfo2 = previousSelection.start;
                if (selectionLayout.isStartHandle()) {
                    anchorInfoAccess$updateSelectionBoundary2 = SimpleLayoutKt.access$updateSelectionBoundary(selectionLayout, selectionLayout.getStartInfo(), anchorInfo2);
                    anchorInfoAccess$updateSelectionBoundary = anchorInfo;
                    anchorInfo = anchorInfo2;
                    anchorInfo2 = anchorInfoAccess$updateSelectionBoundary2;
                } else {
                    anchorInfoAccess$updateSelectionBoundary = SimpleLayoutKt.access$updateSelectionBoundary(selectionLayout, selectionLayout.getEndInfo(), anchorInfo);
                    anchorInfoAccess$updateSelectionBoundary2 = anchorInfoAccess$updateSelectionBoundary;
                }
                if (Intrinsics.areEqual(anchorInfoAccess$updateSelectionBoundary2, anchorInfo)) {
                    return previousSelection;
                }
                boolean z2 = true;
                if (selectionLayout.getCrossStatus() != 1 && (selectionLayout.getCrossStatus() != 3 || anchorInfo2.offset <= anchorInfoAccess$updateSelectionBoundary.offset)) {
                    z2 = false;
                }
                Selection selection = new Selection(anchorInfo2, anchorInfoAccess$updateSelectionBoundary, z2);
                boolean z3 = false;
                Selection.AnchorInfo anchorInfo3 = selection.start;
                long j = anchorInfo3.selectableId;
                Selection.AnchorInfo anchorInfo4 = selection.end;
                if (j != anchorInfo4.selectableId) {
                    boolean z4 = selection.handlesCrossed;
                    if ((z4 ? anchorInfo3 : anchorInfo4).offset == 0) {
                        if (z4) {
                            anchorInfo3 = anchorInfo4;
                        }
                        if (selectionLayout.getFirstInfo().textLayoutResult.layoutInput.text.text.length() != anchorInfo3.offset) {
                            z = false;
                        } else {
                            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                            ref$BooleanRef.element = true;
                            selectionLayout.forEachMiddleInfo(new Recomposer$$ExternalSyntheticLambda0(23, ref$BooleanRef));
                            z = ref$BooleanRef.element;
                        }
                    } else {
                        z = false;
                    }
                } else if (anchorInfo3.offset == anchorInfo4.offset) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return selection;
                }
                String str = selectionLayout.getCurrentInfo().textLayoutResult.layoutInput.text.text;
                if (selectionLayout.getSize() > 1 || selectionLayout.getPreviousSelection() == null) {
                    return selection;
                }
                if (str.length() == 0) {
                    return selection;
                }
                SelectableInfo currentInfo = selectionLayout.getCurrentInfo();
                String str2 = currentInfo.textLayoutResult.layoutInput.text.text;
                int i = currentInfo.rawStartHandleOffset;
                int length = str2.length();
                if (i == 0) {
                    int iFindFollowingBreak = BasicTextKt.findFollowingBreak(str2, 0);
                    selectionCopy$default = selectionLayout.isStartHandle() ? Selection.copy$default(selection, SimpleLayoutKt.changeOffset(selection.start, currentInfo, iFindFollowingBreak), null, true, 2) : Selection.copy$default(selection, null, SimpleLayoutKt.changeOffset(selection.end, currentInfo, iFindFollowingBreak), false, 1);
                } else if (i == length) {
                    int iFindPrecedingBreak = BasicTextKt.findPrecedingBreak(str2, length);
                    selectionCopy$default = selectionLayout.isStartHandle() ? Selection.copy$default(selection, SimpleLayoutKt.changeOffset(selection.start, currentInfo, iFindPrecedingBreak), null, false, 2) : Selection.copy$default(selection, null, SimpleLayoutKt.changeOffset(selection.end, currentInfo, iFindPrecedingBreak), true, 1);
                } else {
                    Selection previousSelection2 = selectionLayout.getPreviousSelection();
                    if (previousSelection2 != null && previousSelection2.handlesCrossed) {
                        z3 = true;
                    }
                    int iFindPrecedingBreak2 = selectionLayout.isStartHandle() ^ z3 ? BasicTextKt.findPrecedingBreak(str2, i) : BasicTextKt.findFollowingBreak(str2, i);
                    selectionCopy$default = selectionLayout.isStartHandle() ? Selection.copy$default(selection, SimpleLayoutKt.changeOffset(selection.start, currentInfo, iFindPrecedingBreak2), null, z3, 2) : Selection.copy$default(selection, null, SimpleLayoutKt.changeOffset(selection.end, currentInfo, iFindPrecedingBreak2), z3, 1);
                }
                return selectionCopy$default;
        }
    }
}
