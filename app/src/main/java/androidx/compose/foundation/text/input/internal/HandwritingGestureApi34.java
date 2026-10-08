package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.HandwritingGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextInclusionStrategy$Companion;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HandwritingGestureApi34 {
    /* JADX INFO: renamed from: access$getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m194access$getOffsetForHandwritingGestured4ec7I(LegacyTextFieldState legacyTextFieldState, long j, ViewConfiguration viewConfiguration) {
        long jMo528screenToLocalMKHz9U;
        int iM196getLineForHandwritingGestured4ec7I;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            MultiParagraph multiParagraph = layoutResult.value.multiParagraph;
            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
            if (layoutCoordinates != null && (iM196getLineForHandwritingGestured4ec7I = m196getLineForHandwritingGestured4ec7I(multiParagraph, (jMo528screenToLocalMKHz9U = layoutCoordinates.mo528screenToLocalMKHz9U(j)), viewConfiguration)) != -1) {
                return multiParagraph.m629getOffsetForPositionk4lQ0M(Offset.m368copydBAh8RU$default((multiParagraph.getLineBottom(iM196getLineForHandwritingGestured4ec7I) + multiParagraph.getLineTop(iM196getLineForHandwritingGestured4ec7I)) / 2.0f, 1, jMo528screenToLocalMKHz9U));
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: access$getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m195access$getRangeForScreenRectsO048IG0(LegacyTextFieldState legacyTextFieldState, Rect rect, Rect rect2, int i) {
        long jM197getRangeForScreenRectOH9lIzo = m197getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect, i);
        if (TextRange.m641getCollapsedimpl(jM197getRangeForScreenRectOH9lIzo)) {
            return TextRange.Zero;
        }
        long jM197getRangeForScreenRectOH9lIzo2 = m197getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect2, i);
        if (TextRange.m641getCollapsedimpl(jM197getRangeForScreenRectOH9lIzo2)) {
            return TextRange.Zero;
        }
        int i2 = (int) (jM197getRangeForScreenRectOH9lIzo >> 32);
        int i3 = (int) (jM197getRangeForScreenRectOH9lIzo2 & 4294967295L);
        return ParagraphKt.TextRange(Math.min(i2, i2), Math.max(i3, i3));
    }

    public static final boolean access$isBiDiBoundary(TextLayoutResult textLayoutResult, int i) {
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        int lineForOffset = multiParagraph.getLineForOffset(i);
        return i == textLayoutResult.getLineStart(lineForOffset) || i == multiParagraph.getLineEnd(lineForOffset, false) ? textLayoutResult.getParagraphDirection(i) != textLayoutResult.getBidiRunDirection(i) : textLayoutResult.getBidiRunDirection(i) != textLayoutResult.getBidiRunDirection(i - 1);
    }

    public static final ExtractedText access$toExtractedText(TextFieldValue textFieldValue) {
        ExtractedText extractedText = new ExtractedText();
        String str = textFieldValue.annotatedString.text;
        extractedText.text = str;
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = str.length();
        extractedText.partialStartOffset = -1;
        long j = textFieldValue.selection;
        extractedText.selectionStart = TextRange.m644getMinimpl(j);
        extractedText.selectionEnd = TextRange.m643getMaximpl(j);
        extractedText.flags = !StringsKt.contains$default(textFieldValue.annotatedString.text, '\n') ? 1 : 0;
        return extractedText;
    }

    public static final long access$toOffset(PointF pointF) {
        float f = pointF.x;
        float f2 = pointF.y;
        return (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L);
    }

    public static final boolean containsInclusive(Rect rect, float f, float f2) {
        float f3 = rect.left;
        if (f > rect.right || f3 > f) {
            return false;
        }
        return f2 <= rect.bottom && rect.top <= f2;
    }

    public static int fallbackOnLegacyTextField(HandwritingGesture handwritingGesture, Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0) {
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        recomposer$$ExternalSyntheticLambda0.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* JADX INFO: renamed from: getLineForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m196getLineForHandwritingGestured4ec7I(MultiParagraph multiParagraph, long j, ViewConfiguration viewConfiguration) {
        float handwritingGestureLineMargin = viewConfiguration != null ? viewConfiguration.getHandwritingGestureLineMargin() : 0.0f;
        int i = (int) (4294967295L & j);
        int lineForVerticalPosition = multiParagraph.getLineForVerticalPosition(Float.intBitsToFloat(i));
        if (Float.intBitsToFloat(i) < multiParagraph.getLineTop(lineForVerticalPosition) - handwritingGestureLineMargin || Float.intBitsToFloat(i) > multiParagraph.getLineBottom(lineForVerticalPosition) + handwritingGestureLineMargin) {
            return -1;
        }
        int i2 = (int) (j >> 32);
        if (Float.intBitsToFloat(i2) < (-handwritingGestureLineMargin) || Float.intBitsToFloat(i2) > multiParagraph.width + handwritingGestureLineMargin) {
            return -1;
        }
        return lineForVerticalPosition;
    }

    /* JADX INFO: renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m197getRangeForScreenRectOH9lIzo(LegacyTextFieldState legacyTextFieldState, Rect rect, int i) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        MultiParagraph multiParagraph = layoutResult != null ? layoutResult.value.multiParagraph : null;
        LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
        return (multiParagraph == null || layoutCoordinates == null) ? TextRange.Zero : multiParagraph.m630getRangeForRect86BmAI(rect.m381translatek4lQ0M(layoutCoordinates.mo528screenToLocalMKHz9U(0L)), i, TextInclusionStrategy$Companion.ContainsCenter);
    }

    public static final boolean isPunctuation(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    public static final boolean isWhitespace(int i) {
        return Character.isWhitespace(i) || i == 160;
    }

    public static final boolean isWhitespaceExceptNewline(int i) {
        int type;
        return (!isWhitespace(i) || (type = Character.getType(i)) == 14 || type == 13 || i == 10) ? false : true;
    }

    public static final Modifier legacyTextInputAdapter(Modifier modifier, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        return modifier.then(new LegacyAdaptingPlatformTextInputModifier(androidLegacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager));
    }

    /* JADX INFO: renamed from: performDeletionOnLegacyTextField-vJH6DeI, reason: not valid java name */
    public static void m198performDeletionOnLegacyTextFieldvJH6DeI(long j, AnnotatedString annotatedString, boolean z, Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0) {
        if (z) {
            int i = TextRange.$r8$clinit;
            int iCharCount = (int) (j >> 32);
            int iCharCount2 = (int) (j & 4294967295L);
            int iCodePointBefore = iCharCount > 0 ? Character.codePointBefore(annotatedString, iCharCount) : 10;
            int iCodePointAt = iCharCount2 < annotatedString.text.length() ? Character.codePointAt(annotatedString, iCharCount2) : 10;
            if (isWhitespaceExceptNewline(iCodePointBefore) && (isWhitespace(iCodePointAt) || isPunctuation(iCodePointAt))) {
                do {
                    iCharCount -= Character.charCount(iCodePointBefore);
                    if (iCharCount == 0) {
                        break;
                    } else {
                        iCodePointBefore = Character.codePointBefore(annotatedString, iCharCount);
                    }
                } while (isWhitespaceExceptNewline(iCodePointBefore));
                j = ParagraphKt.TextRange(iCharCount, iCharCount2);
            } else if (isWhitespaceExceptNewline(iCodePointAt) && (isWhitespace(iCodePointBefore) || isPunctuation(iCodePointBefore))) {
                do {
                    iCharCount2 += Character.charCount(iCodePointAt);
                    if (iCharCount2 == annotatedString.text.length()) {
                        break;
                    } else {
                        iCodePointAt = Character.codePointAt(annotatedString, iCharCount2);
                    }
                } while (isWhitespaceExceptNewline(iCodePointAt));
                j = ParagraphKt.TextRange(iCharCount, iCharCount2);
            }
        }
        int i2 = (int) (4294967295L & j);
        recomposer$$ExternalSyntheticLambda0.invoke(new HandwritingGesture_androidKt$compoundEditCommand$1(new EditCommand[]{new SetSelectionCommand(i2, i2), new DeleteSurroundingTextCommand(TextRange.m642getLengthimpl(j), 0)}));
    }
}
