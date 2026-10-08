package androidx.compose.ui.text.input;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CommitTextCommand implements EditCommand {
    public final AnnotatedString annotatedString;
    public final int newCursorPosition;

    public CommitTextCommand(AnnotatedString annotatedString, int i) {
        this.annotatedString = annotatedString;
        this.newCursorPosition = i;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(EditingBuffer editingBuffer) {
        int i = editingBuffer.compositionStart;
        AnnotatedString annotatedString = this.annotatedString;
        if (i != -1) {
            editingBuffer.replace$ui_text(i, editingBuffer.compositionEnd, annotatedString.text);
        } else {
            editingBuffer.replace$ui_text(editingBuffer.selectionStart, editingBuffer.selectionEnd, annotatedString.text);
        }
        int i2 = editingBuffer.selectionStart;
        int i3 = editingBuffer.selectionEnd;
        int i4 = i2 == i3 ? i3 : -1;
        int i5 = this.newCursorPosition;
        int iCoerceIn = RangesKt.coerceIn(i5 > 0 ? (i4 + i5) - 1 : (i4 + i5) - annotatedString.text.length(), 0, editingBuffer.gapBuffer.getLength());
        editingBuffer.setSelection$ui_text(iCoerceIn, iCoerceIn);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommitTextCommand)) {
            return false;
        }
        CommitTextCommand commitTextCommand = (CommitTextCommand) obj;
        return Intrinsics.areEqual(this.annotatedString.text, commitTextCommand.annotatedString.text) && this.newCursorPosition == commitTextCommand.newCursorPosition;
    }

    public final int hashCode() {
        return (this.annotatedString.text.hashCode() * 31) + this.newCursorPosition;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CommitTextCommand(text='");
        sb.append(this.annotatedString.text);
        sb.append("', newCursorPosition=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.newCursorPosition, ')');
    }

    public CommitTextCommand(String str, int i) {
        this(new AnnotatedString(str), i);
    }
}
