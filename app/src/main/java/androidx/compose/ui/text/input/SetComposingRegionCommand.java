package androidx.compose.ui.text.input;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.github.kr328.clash.log.LogcatCache;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SetComposingRegionCommand implements EditCommand {
    public final int end;
    public final int start;

    public SetComposingRegionCommand(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(EditingBuffer editingBuffer) {
        boolean z = editingBuffer.compositionStart != -1;
        LogcatCache logcatCache = editingBuffer.gapBuffer;
        if (z) {
            editingBuffer.compositionStart = -1;
            editingBuffer.compositionEnd = -1;
        }
        int iCoerceIn = RangesKt.coerceIn(this.start, 0, logcatCache.getLength());
        int iCoerceIn2 = RangesKt.coerceIn(this.end, 0, logcatCache.getLength());
        if (iCoerceIn != iCoerceIn2) {
            if (iCoerceIn < iCoerceIn2) {
                editingBuffer.setComposition$ui_text(iCoerceIn, iCoerceIn2);
            } else {
                editingBuffer.setComposition$ui_text(iCoerceIn2, iCoerceIn);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetComposingRegionCommand)) {
            return false;
        }
        SetComposingRegionCommand setComposingRegionCommand = (SetComposingRegionCommand) obj;
        return this.start == setComposingRegionCommand.start && this.end == setComposingRegionCommand.end;
    }

    public final int hashCode() {
        return (this.start * 31) + this.end;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SetComposingRegionCommand(start=");
        sb.append(this.start);
        sb.append(", end=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.end, ')');
    }
}
