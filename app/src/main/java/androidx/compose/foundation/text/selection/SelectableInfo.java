package androidx.compose.foundation.text.selection;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectableInfo {
    public final int rawEndHandleOffset;
    public final int rawPreviousHandleOffset;
    public final int rawStartHandleOffset;
    public final long selectableId;
    public final int slot;
    public final TextLayoutResult textLayoutResult;

    public SelectableInfo(long j, int i, int i2, int i3, int i4, TextLayoutResult textLayoutResult) {
        this.selectableId = j;
        this.slot = i;
        this.rawStartHandleOffset = i2;
        this.rawEndHandleOffset = i3;
        this.rawPreviousHandleOffset = i4;
        this.textLayoutResult = textLayoutResult;
    }

    public final Selection.AnchorInfo anchorForOffset(int i) {
        return new Selection.AnchorInfo(SimpleLayoutKt.getTextDirectionForOffset(this.textLayoutResult, i), i, this.selectableId);
    }

    public final int getRawCrossStatus() {
        int i = this.rawStartHandleOffset;
        int i2 = this.rawEndHandleOffset;
        if (i < i2) {
            return 2;
        }
        return i > i2 ? 1 : 3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SelectionInfo(id=");
        sb.append(this.selectableId);
        sb.append(", range=(");
        int i = this.rawStartHandleOffset;
        sb.append(i);
        sb.append('-');
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        sb.append(Density.CC.stringValueOf(SimpleLayoutKt.getTextDirectionForOffset(textLayoutResult, i)));
        sb.append(',');
        int i2 = this.rawEndHandleOffset;
        sb.append(i2);
        sb.append('-');
        sb.append(Density.CC.stringValueOf(SimpleLayoutKt.getTextDirectionForOffset(textLayoutResult, i2)));
        sb.append("), prevOffset=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.rawPreviousHandleOffset, ')');
    }
}
