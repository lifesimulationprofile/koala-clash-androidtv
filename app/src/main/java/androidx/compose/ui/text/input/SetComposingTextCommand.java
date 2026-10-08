package androidx.compose.ui.text.input;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SetComposingTextCommand implements EditCommand {
    public final AnnotatedString annotatedString;
    public final int newCursorPosition;

    public SetComposingTextCommand(String str, int i) {
        this.annotatedString = new AnnotatedString(str);
        this.newCursorPosition = i;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(EditingBuffer editingBuffer) {
        int i = editingBuffer.compositionStart;
        AnnotatedString annotatedString = this.annotatedString;
        if (i != -1) {
            int i2 = editingBuffer.compositionEnd;
            String str = annotatedString.text;
            String str2 = annotatedString.text;
            editingBuffer.replace$ui_text(i, i2, str);
            if (str2.length() > 0) {
                editingBuffer.setComposition$ui_text(i, str2.length() + i);
            }
        } else {
            int i3 = editingBuffer.selectionStart;
            int i4 = editingBuffer.selectionEnd;
            String str3 = annotatedString.text;
            String str4 = annotatedString.text;
            editingBuffer.replace$ui_text(i3, i4, str3);
            if (str4.length() > 0) {
                editingBuffer.setComposition$ui_text(i3, str4.length() + i3);
            }
        }
        int i5 = editingBuffer.selectionStart;
        int i6 = editingBuffer.selectionEnd;
        int i7 = i5 == i6 ? i6 : -1;
        int i8 = this.newCursorPosition;
        int iCoerceIn = RangesKt.coerceIn(i8 > 0 ? (i7 + i8) - 1 : (i7 + i8) - annotatedString.text.length(), 0, editingBuffer.gapBuffer.getLength());
        editingBuffer.setSelection$ui_text(iCoerceIn, iCoerceIn);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetComposingTextCommand)) {
            return false;
        }
        SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) obj;
        return Intrinsics.areEqual(this.annotatedString.text, setComposingTextCommand.annotatedString.text) && this.newCursorPosition == setComposingTextCommand.newCursorPosition;
    }

    public final int hashCode() {
        return (this.annotatedString.text.hashCode() * 31) + this.newCursorPosition;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SetComposingTextCommand(text='");
        sb.append(this.annotatedString.text);
        sb.append("', newCursorPosition=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.newCursorPosition, ')');
    }
}
