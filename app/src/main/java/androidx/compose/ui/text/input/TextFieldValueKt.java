package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextFieldValueKt {
    public static final AnnotatedString getSelectedText(TextFieldValue textFieldValue) {
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        long j = textFieldValue.selection;
        annotatedString.getClass();
        return annotatedString.subSequence(TextRange.m644getMinimpl(j), TextRange.m643getMaximpl(j));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue textFieldValue, int i) {
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        AnnotatedString annotatedString2 = textFieldValue.annotatedString;
        long j = textFieldValue.selection;
        int iM643getMaximpl = TextRange.m643getMaximpl(j);
        int iM643getMaximpl2 = TextRange.m643getMaximpl(j);
        int length = iM643getMaximpl2 + i;
        if (((i ^ length) & (iM643getMaximpl2 ^ length)) < 0) {
            length = annotatedString2.text.length();
        }
        return annotatedString.subSequence(iM643getMaximpl, Math.min(length, annotatedString2.text.length()));
    }

    public static final AnnotatedString getTextBeforeSelection(TextFieldValue textFieldValue, int i) {
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        long j = textFieldValue.selection;
        int iM644getMinimpl = TextRange.m644getMinimpl(j);
        int i2 = iM644getMinimpl - i;
        if (((iM644getMinimpl ^ i2) & (i ^ iM644getMinimpl)) < 0) {
            i2 = 0;
        }
        return annotatedString.subSequence(Math.max(0, i2), TextRange.m644getMinimpl(j));
    }
}
