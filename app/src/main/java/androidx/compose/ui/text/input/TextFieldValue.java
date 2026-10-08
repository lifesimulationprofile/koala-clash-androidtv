package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldValue {
    public final AnnotatedString annotatedString;
    public final TextRange composition;
    public final long selection;

    public TextFieldValue(AnnotatedString annotatedString, long j, TextRange textRange) {
        TextRange textRange2;
        this.annotatedString = annotatedString;
        this.selection = ParagraphKt.m633coerceIn8ffj60Q(annotatedString.text.length(), j);
        if (textRange != null) {
            textRange2 = new TextRange(ParagraphKt.m633coerceIn8ffj60Q(annotatedString.text.length(), textRange.packedValue));
        } else {
            textRange2 = null;
        }
        this.composition = textRange2;
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static TextFieldValue m663copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString, long j, int i) {
        if ((i & 1) != 0) {
            annotatedString = textFieldValue.annotatedString;
        }
        if ((i & 2) != 0) {
            j = textFieldValue.selection;
        }
        TextRange textRange = (i & 4) != 0 ? textFieldValue.composition : null;
        textFieldValue.getClass();
        return new TextFieldValue(annotatedString, j, textRange);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        return TextRange.m640equalsimpl0(this.selection, textFieldValue.selection) && Intrinsics.areEqual(this.composition, textFieldValue.composition) && Intrinsics.areEqual(this.annotatedString, textFieldValue.annotatedString);
    }

    public final int hashCode() {
        int i;
        int iHashCode = this.annotatedString.hashCode() * 31;
        int i2 = TextRange.$r8$clinit;
        long j = this.selection;
        int i3 = (((int) (j ^ (j >>> 32))) + iHashCode) * 31;
        TextRange textRange = this.composition;
        if (textRange != null) {
            long j2 = textRange.packedValue;
            i = (int) ((j2 >>> 32) ^ j2);
        } else {
            i = 0;
        }
        return i3 + i;
    }

    public final String toString() {
        return "TextFieldValue(text='" + ((Object) this.annotatedString) + "', selection=" + ((Object) TextRange.m646toStringimpl(this.selection)) + ", composition=" + this.composition + ')';
    }

    public TextFieldValue(int i, long j, String str) {
        this(new AnnotatedString((i & 1) != 0 ? "" : str), (i & 2) != 0 ? TextRange.Zero : j, (TextRange) null);
    }
}
