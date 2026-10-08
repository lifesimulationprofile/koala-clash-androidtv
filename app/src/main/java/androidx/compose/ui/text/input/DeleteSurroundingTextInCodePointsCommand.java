package androidx.compose.ui.text.input;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.github.kr328.clash.log.LogcatCache;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public final int lengthAfterCursor;
    public final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i, int i2) {
        this.lengthBeforeCursor = i;
        this.lengthAfterCursor = i2;
        if (i >= 0 && i2 >= 0) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(EditingBuffer editingBuffer) {
        int i = 0;
        for (int i2 = 0; i2 < this.lengthBeforeCursor; i2++) {
            int i3 = i + 1;
            int i4 = editingBuffer.selectionStart;
            if (i4 <= i3) {
                i = i4;
                break;
            }
            i = (Character.isHighSurrogate(editingBuffer.get$ui_text((i4 - i3) + (-1))) && Character.isLowSurrogate(editingBuffer.get$ui_text(editingBuffer.selectionStart - i3))) ? i + 2 : i3;
        }
        int length = 0;
        for (int i5 = 0; i5 < this.lengthAfterCursor; i5++) {
            int i6 = length + 1;
            int i7 = editingBuffer.selectionEnd;
            LogcatCache logcatCache = editingBuffer.gapBuffer;
            if (i7 + i6 >= logcatCache.getLength()) {
                length = logcatCache.getLength() - editingBuffer.selectionEnd;
                break;
            }
            length = (Character.isHighSurrogate(editingBuffer.get$ui_text((editingBuffer.selectionEnd + i6) + (-1))) && Character.isLowSurrogate(editingBuffer.get$ui_text(editingBuffer.selectionEnd + i6))) ? length + 2 : i6;
        }
        int i8 = editingBuffer.selectionEnd;
        editingBuffer.delete$ui_text(i8, length + i8);
        int i9 = editingBuffer.selectionStart;
        editingBuffer.delete$ui_text(i9 - i, i9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) obj;
        return this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor;
    }

    public final int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=");
        sb.append(this.lengthBeforeCursor);
        sb.append(", lengthAfterCursor=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.lengthAfterCursor, ')');
    }
}
