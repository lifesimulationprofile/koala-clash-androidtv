package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.text.ParagraphKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionAdjustment$Companion implements BoundaryFunction {
    public final /* synthetic */ int $r8$classId;
    public static final SelectionAdjustment$Companion INSTANCE = new SelectionAdjustment$Companion(1);
    public static final SelectionAdjustment$Companion INSTANCE$1 = new SelectionAdjustment$Companion(2);
    public static final SelectionAdjustment$Companion$$ExternalSyntheticLambda0 None = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0(0);
    public static final SelectionAdjustment$Companion$$ExternalSyntheticLambda0 Word = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0(1);
    public static final SelectionAdjustment$Companion$$ExternalSyntheticLambda0 Paragraph = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0(2);
    public static final SelectionAdjustment$Companion$$ExternalSyntheticLambda0 CharacterWithWordAccelerate = new SelectionAdjustment$Companion$$ExternalSyntheticLambda0(3);

    public /* synthetic */ SelectionAdjustment$Companion(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.compose.foundation.text.selection.BoundaryFunction
    /* JADX INFO: renamed from: getBoundary-fzxv0v0 */
    public long mo213getBoundaryfzxv0v0(SelectableInfo selectableInfo, int i) {
        switch (this.$r8$classId) {
            case 1:
                String str = selectableInfo.textLayoutResult.layoutInput.text.text;
                return ParagraphKt.TextRange(BasicTextKt.findParagraphStart(str, i), BasicTextKt.findParagraphEnd(str, i));
            default:
                return selectableInfo.textLayoutResult.m638getWordBoundaryjx7JFs(i);
        }
    }
}
