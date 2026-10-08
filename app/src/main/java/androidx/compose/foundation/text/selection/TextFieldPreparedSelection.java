package androidx.compose.foundation.text.selection;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldPreparedSelection {
    public final AnnotatedString annotatedString;
    public final TextFieldValue currentValue;
    public final TextLayoutResult layoutResult;
    public final TextLayoutResultProxy layoutResultProxy;
    public final OffsetMapping offsetMapping;
    public final long originalSelection;
    public final AnnotatedString originalText;
    public long selection;
    public final TextPreparedSelectionState state;

    public TextFieldPreparedSelection(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy, TextPreparedSelectionState textPreparedSelectionState) {
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        long j = textFieldValue.selection;
        TextLayoutResult textLayoutResult = textLayoutResultProxy != null ? textLayoutResultProxy.value : null;
        this.originalText = annotatedString;
        this.originalSelection = j;
        this.layoutResult = textLayoutResult;
        this.offsetMapping = offsetMapping;
        this.state = textPreparedSelectionState;
        this.selection = j;
        this.annotatedString = annotatedString;
        this.currentValue = textFieldValue;
        this.layoutResultProxy = textLayoutResultProxy;
    }

    public final List deleteIfSelectedOr(Function1 function1) {
        if (!TextRange.m641getCollapsedimpl(this.selection)) {
            return AppCompatHintHelper.listOf(new CommitTextCommand("", 0), new SetSelectionCommand(TextRange.m644getMinimpl(this.selection), TextRange.m644getMinimpl(this.selection)));
        }
        EditCommand editCommand = (EditCommand) function1.invoke(this);
        if (editCommand != null) {
            return Collections.singletonList(editCommand);
        }
        return null;
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult == null) {
            return null;
        }
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        int iM643getMaximpl = TextRange.m643getMaximpl(this.selection);
        OffsetMapping offsetMapping = this.offsetMapping;
        return Integer.valueOf(offsetMapping.transformedToOriginal(multiParagraph.getLineEnd(multiParagraph.getLineForOffset(offsetMapping.originalToTransformed(iM643getMaximpl)), true)));
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult == null) {
            return null;
        }
        int iM644getMinimpl = TextRange.m644getMinimpl(this.selection);
        OffsetMapping offsetMapping = this.offsetMapping;
        return Integer.valueOf(offsetMapping.transformedToOriginal(textLayoutResult.getLineStart(textLayoutResult.multiParagraph.getLineForOffset(offsetMapping.originalToTransformed(iM644getMinimpl)))));
    }

    public final Integer getNextWordOffset() {
        int length;
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult == null) {
            return null;
        }
        int iTransformedEndOffset = transformedEndOffset();
        while (true) {
            AnnotatedString annotatedString = this.originalText;
            if (iTransformedEndOffset < annotatedString.text.length()) {
                int length2 = this.annotatedString.text.length() - 1;
                if (iTransformedEndOffset <= length2) {
                    length2 = iTransformedEndOffset;
                }
                long jM638getWordBoundaryjx7JFs = textLayoutResult.m638getWordBoundaryjx7JFs(length2);
                int i = TextRange.$r8$clinit;
                int i2 = (int) (jM638getWordBoundaryjx7JFs & 4294967295L);
                if (i2 > iTransformedEndOffset) {
                    length = this.offsetMapping.transformedToOriginal(i2);
                    break;
                }
                iTransformedEndOffset++;
            } else {
                length = annotatedString.text.length();
                break;
            }
        }
        return Integer.valueOf(length);
    }

    public final Integer getPreviousWordOffset() {
        int iTransformedToOriginal;
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult == null) {
            return null;
        }
        for (int iTransformedEndOffset = transformedEndOffset(); iTransformedEndOffset > 0; iTransformedEndOffset--) {
            int length = this.annotatedString.text.length() - 1;
            if (iTransformedEndOffset <= length) {
                length = iTransformedEndOffset;
            }
            long jM638getWordBoundaryjx7JFs = textLayoutResult.m638getWordBoundaryjx7JFs(length);
            int i = TextRange.$r8$clinit;
            int i2 = (int) (jM638getWordBoundaryjx7JFs >> 32);
            if (i2 < iTransformedEndOffset) {
                iTransformedToOriginal = this.offsetMapping.transformedToOriginal(i2);
                return Integer.valueOf(iTransformedToOriginal);
            }
        }
        iTransformedToOriginal = 0;
        return Integer.valueOf(iTransformedToOriginal);
    }

    public final boolean isLtr() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        return (textLayoutResult != null ? textLayoutResult.getParagraphDirection(transformedEndOffset()) : 0) != 2;
    }

    public final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i) {
        int iTransformedEndOffset = transformedEndOffset();
        TextPreparedSelectionState textPreparedSelectionState = this.state;
        if (textPreparedSelectionState.cachedX == null) {
            textPreparedSelectionState.cachedX = Float.valueOf(textLayoutResult.getCursorRect(iTransformedEndOffset).left);
        }
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        int lineForOffset = multiParagraph.getLineForOffset(iTransformedEndOffset) + i;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= multiParagraph.lineCount) {
            return this.annotatedString.text.length();
        }
        float lineBottom = multiParagraph.getLineBottom(lineForOffset) - 1;
        Float f = textPreparedSelectionState.cachedX;
        float fFloatValue = f.floatValue();
        if ((isLtr() && fFloatValue >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && fFloatValue <= textLayoutResult.getLineLeft(lineForOffset))) {
            return multiParagraph.getLineEnd(lineForOffset, true);
        }
        return this.offsetMapping.transformedToOriginal(multiParagraph.m629getOffsetForPositionk4lQ0M((((long) Float.floatToRawIntBits(lineBottom)) & 4294967295L) | (Float.floatToRawIntBits(f.floatValue()) << 32)));
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    public final int jumpByPagesOffset(TextLayoutResultProxy textLayoutResultProxy, int i) {
        Rect rectLocalBoundingBoxOf;
        LayoutCoordinates layoutCoordinates = textLayoutResultProxy.innerTextFieldCoordinates;
        TextLayoutResult textLayoutResult = textLayoutResultProxy.value;
        if (layoutCoordinates == null) {
            rectLocalBoundingBoxOf = Rect.Zero;
        } else {
            LayoutCoordinates layoutCoordinates2 = textLayoutResultProxy.decorationBoxCoordinates;
            rectLocalBoundingBoxOf = layoutCoordinates2 != null ? layoutCoordinates2.localBoundingBoxOf(layoutCoordinates, true) : null;
            if (rectLocalBoundingBoxOf == null) {
                rectLocalBoundingBoxOf = Rect.Zero;
            }
        }
        long j = this.currentValue.selection;
        int i2 = TextRange.$r8$clinit;
        int i3 = (int) (j & 4294967295L);
        OffsetMapping offsetMapping = this.offsetMapping;
        Rect cursorRect = textLayoutResult.getCursorRect(offsetMapping.originalToTransformed(i3));
        float f = cursorRect.left;
        return offsetMapping.transformedToOriginal(textLayoutResult.multiParagraph.m629getOffsetForPositionk4lQ0M((((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (rectLocalBoundingBoxOf.m379getSizeNHjbRc() & 4294967295L)) * i) + cursorRect.top)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
    }

    public final void moveCursorLeft() {
        TextPreparedSelectionState textPreparedSelectionState = this.state;
        textPreparedSelectionState.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        if (annotatedString.text.length() > 0) {
            if (isLtr()) {
                moveCursorPrev();
                return;
            }
            textPreparedSelectionState.cachedX = null;
            if (annotatedString.text.length() > 0) {
                String str = annotatedString.text;
                long j = this.selection;
                int i = TextRange.$r8$clinit;
                int iFindFollowingBreak = BasicTextKt.findFollowingBreak(str, (int) (j & 4294967295L));
                if (iFindFollowingBreak != -1) {
                    setSelection(iFindFollowingBreak, iFindFollowingBreak);
                }
            }
        }
    }

    public final void moveCursorNextByParagraph() {
        this.state.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        String str = annotatedString.text;
        String str2 = annotatedString.text;
        if (str.length() > 0) {
            int iFindParagraphEnd = BasicTextKt.findParagraphEnd(str2, TextRange.m643getMaximpl(this.selection));
            if (iFindParagraphEnd == TextRange.m643getMaximpl(this.selection) && iFindParagraphEnd != str2.length()) {
                iFindParagraphEnd = BasicTextKt.findParagraphEnd(str2, iFindParagraphEnd + 1);
            }
            setSelection(iFindParagraphEnd, iFindParagraphEnd);
        }
    }

    public final void moveCursorPrev() {
        this.state.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        if (annotatedString.text.length() > 0) {
            String str = annotatedString.text;
            long j = this.selection;
            int i = TextRange.$r8$clinit;
            int iFindPrecedingBreak = BasicTextKt.findPrecedingBreak(str, (int) (j & 4294967295L));
            if (iFindPrecedingBreak != -1) {
                setSelection(iFindPrecedingBreak, iFindPrecedingBreak);
            }
        }
    }

    public final void moveCursorPrevByParagraph() {
        this.state.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        String str = annotatedString.text;
        String str2 = annotatedString.text;
        if (str.length() > 0) {
            int iFindParagraphStart = BasicTextKt.findParagraphStart(str2, TextRange.m644getMinimpl(this.selection));
            if (iFindParagraphStart == TextRange.m644getMinimpl(this.selection) && iFindParagraphStart != 0) {
                iFindParagraphStart = BasicTextKt.findParagraphStart(str2, iFindParagraphStart - 1);
            }
            setSelection(iFindParagraphStart, iFindParagraphStart);
        }
    }

    public final void moveCursorRight() {
        TextPreparedSelectionState textPreparedSelectionState = this.state;
        textPreparedSelectionState.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        if (annotatedString.text.length() > 0) {
            if (!isLtr()) {
                moveCursorPrev();
                return;
            }
            textPreparedSelectionState.cachedX = null;
            if (annotatedString.text.length() > 0) {
                String str = annotatedString.text;
                long j = this.selection;
                int i = TextRange.$r8$clinit;
                int iFindFollowingBreak = BasicTextKt.findFollowingBreak(str, (int) (j & 4294967295L));
                if (iFindFollowingBreak != -1) {
                    setSelection(iFindFollowingBreak, iFindFollowingBreak);
                }
            }
        }
    }

    public final void moveCursorToLineEnd() {
        Integer lineEndByOffset;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() <= 0 || (lineEndByOffset = getLineEndByOffset()) == null) {
            return;
        }
        int iIntValue = lineEndByOffset.intValue();
        setSelection(iIntValue, iIntValue);
    }

    public final void moveCursorToLineStart() {
        Integer lineStartByOffset;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() <= 0 || (lineStartByOffset = getLineStartByOffset()) == null) {
            return;
        }
        int iIntValue = lineStartByOffset.intValue();
        setSelection(iIntValue, iIntValue);
    }

    public final void selectMovement() {
        if (this.annotatedString.text.length() > 0) {
            int i = TextRange.$r8$clinit;
            this.selection = ParagraphKt.TextRange((int) (this.originalSelection >> 32), (int) (this.selection & 4294967295L));
        }
    }

    public final void setSelection(int i, int i2) {
        this.selection = ParagraphKt.TextRange(i, i2);
    }

    public final int transformedEndOffset() {
        long j = this.selection;
        int i = TextRange.$r8$clinit;
        return this.offsetMapping.originalToTransformed((int) (j & 4294967295L));
    }
}
