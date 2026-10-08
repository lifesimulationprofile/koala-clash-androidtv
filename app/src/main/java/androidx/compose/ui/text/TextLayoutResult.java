package androidx.compose.ui.text;

import android.graphics.RectF;
import android.text.Layout;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.IntSize;
import com.github.kr328.clash.log.LogcatCache;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutResult {
    public final float firstBaseline;
    public final float lastBaseline;
    public final TextLayoutInput layoutInput;
    public final MultiParagraph multiParagraph;
    public final ArrayList placeholderRects;
    public final long size;

    public TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j) {
        this.layoutInput = textLayoutInput;
        this.multiParagraph = multiParagraph;
        this.size = j;
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        float lineBaseline = 0.0f;
        this.firstBaseline = arrayList.isEmpty() ? 0.0f : ((ParagraphInfo) arrayList.get(0)).paragraph.layout.getLineBaseline(0);
        if (!arrayList.isEmpty()) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt.last(arrayList);
            TextLayout textLayout = paragraphInfo.paragraph.layout;
            lineBaseline = textLayout.getLineBaseline(textLayout.lineCount - 1) + paragraphInfo.top;
        }
        this.lastBaseline = lineBaseline;
        this.placeholderRects = multiParagraph.placeholderRects;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutResult)) {
            return false;
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) obj;
        return Intrinsics.areEqual(this.layoutInput, textLayoutResult.layoutInput) && this.multiParagraph.equals(textLayoutResult.multiParagraph) && IntSize.m720equalsimpl0(this.size, textLayoutResult.size) && this.firstBaseline == textLayoutResult.firstBaseline && this.lastBaseline == textLayoutResult.lastBaseline && Intrinsics.areEqual(this.placeholderRects, textLayoutResult.placeholderRects);
    }

    public final int getBidiRunDirection(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        multiParagraph.requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i == ((AnnotatedString) multiParagraph.intrinsics.url).text.length() ? AppCompatHintHelper.getLastIndex(arrayList) : ParagraphKt.findParagraphByIndex(i, arrayList));
        return paragraphInfo.paragraph.layout.layout.isRtlCharAt(paragraphInfo.toLocalIndex(i)) ? 2 : 1;
    }

    public final Rect getBoundingBox(int i) {
        float secondaryHorizontal;
        float secondaryHorizontal2;
        float primaryHorizontal;
        float primaryHorizontal2;
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRange(i);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int localIndex = paragraphInfo.toLocalIndex(i);
        CharSequence charSequence = androidParagraph.charSequence;
        if (localIndex < 0 || localIndex >= charSequence.length()) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(localIndex, "offset(", ") is out of bounds [0,");
            sbM.append(charSequence.length());
            sbM.append(')');
            InlineClassHelperKt.throwIllegalArgumentException(sbM.toString());
        }
        TextLayout textLayout = androidParagraph.layout;
        Layout layout = textLayout.layout;
        int lineForOffset = layout.getLineForOffset(localIndex);
        float lineTop = textLayout.getLineTop(lineForOffset);
        float lineBottom = textLayout.getLineBottom(lineForOffset);
        boolean z = layout.getParagraphDirection(lineForOffset) == 1;
        boolean zIsRtlCharAt = layout.isRtlCharAt(localIndex);
        if (!z || zIsRtlCharAt) {
            if (z && zIsRtlCharAt) {
                primaryHorizontal = textLayout.getSecondaryHorizontal(localIndex, false);
                primaryHorizontal2 = textLayout.getSecondaryHorizontal(localIndex + 1, true);
            } else if (zIsRtlCharAt) {
                primaryHorizontal = textLayout.getPrimaryHorizontal(localIndex, false);
                primaryHorizontal2 = textLayout.getPrimaryHorizontal(localIndex + 1, true);
            } else {
                secondaryHorizontal = textLayout.getSecondaryHorizontal(localIndex, false);
                secondaryHorizontal2 = textLayout.getSecondaryHorizontal(localIndex + 1, true);
            }
            float f = primaryHorizontal;
            secondaryHorizontal = primaryHorizontal2;
            secondaryHorizontal2 = f;
        } else {
            secondaryHorizontal = textLayout.getPrimaryHorizontal(localIndex, false);
            secondaryHorizontal2 = textLayout.getPrimaryHorizontal(localIndex + 1, true);
        }
        RectF rectF = new RectF(secondaryHorizontal, lineTop, secondaryHorizontal2, lineBottom);
        return paragraphInfo.toGlobal(new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom));
    }

    public final Rect getCursorRect(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        multiParagraph.requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i == ((AnnotatedString) multiParagraph.intrinsics.url).text.length() ? AppCompatHintHelper.getLastIndex(arrayList) : ParagraphKt.findParagraphByIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int localIndex = paragraphInfo.toLocalIndex(i);
        CharSequence charSequence = androidParagraph.charSequence;
        TextLayout textLayout = androidParagraph.layout;
        if (localIndex < 0 || localIndex > charSequence.length()) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(localIndex, "offset(", ") is out of bounds [0,");
            sbM.append(charSequence.length());
            sbM.append(']');
            InlineClassHelperKt.throwIllegalArgumentException(sbM.toString());
        }
        float primaryHorizontal = textLayout.getPrimaryHorizontal(localIndex, false);
        int lineForOffset = textLayout.layout.getLineForOffset(localIndex);
        return paragraphInfo.toGlobal(new Rect(primaryHorizontal, textLayout.getLineTop(lineForOffset), primaryHorizontal, textLayout.getLineBottom(lineForOffset)));
    }

    public final boolean getHasVisualOverflow() {
        long j = this.size;
        float f = (int) (j >> 32);
        MultiParagraph multiParagraph = this.multiParagraph;
        return f < multiParagraph.width || multiParagraph.didExceedMaxLines || ((float) ((int) (j & 4294967295L))) < multiParagraph.height;
    }

    public final float getLineLeft(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(i);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int i2 = i - paragraphInfo.startLineIndex;
        TextLayout textLayout = androidParagraph.layout;
        return textLayout.layout.getLineLeft(i2) + (i2 == textLayout.lineCount + (-1) ? textLayout.leftPadding : 0.0f);
    }

    public final float getLineRight(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(i);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int i2 = i - paragraphInfo.startLineIndex;
        TextLayout textLayout = androidParagraph.layout;
        return textLayout.layout.getLineRight(i2) + (i2 == textLayout.lineCount + (-1) ? textLayout.rightPadding : 0.0f);
    }

    public final int getLineStart(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(i);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        return androidParagraph.layout.layout.getLineStart(i - paragraphInfo.startLineIndex) + paragraphInfo.startIndex;
    }

    public final int getParagraphDirection(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        multiParagraph.requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i == ((AnnotatedString) multiParagraph.intrinsics.url).text.length() ? AppCompatHintHelper.getLastIndex(arrayList) : ParagraphKt.findParagraphByIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int localIndex = paragraphInfo.toLocalIndex(i);
        TextLayout textLayout = androidParagraph.layout;
        return textLayout.layout.getParagraphDirection(textLayout.layout.getLineForOffset(localIndex)) == 1 ? 1 : 2;
    }

    public final AndroidPath getPathForRange(int i, int i2) {
        MultiParagraph multiParagraph = this.multiParagraph;
        AnnotatedString annotatedString = (AnnotatedString) multiParagraph.intrinsics.url;
        if (i < 0 || i > i2 || i2 > annotatedString.text.length()) {
            InlineClassHelperKt.throwIllegalArgumentException("Start(" + i + ") or End(" + i2 + ") is out of range [0.." + annotatedString.text.length() + "), or start > end!");
        }
        if (i == i2) {
            return AndroidPath_androidKt.Path();
        }
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        ParagraphKt.m634findParagraphsByRangeSbBc2M(multiParagraph.paragraphInfoList, ParagraphKt.TextRange(i, i2), new MultiParagraph$$ExternalSyntheticLambda1(androidPathPath, i, i2, 0));
        return androidPathPath;
    }

    /* JADX INFO: renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m638getWordBoundaryjx7JFs(int i) {
        int iPrevBoundary;
        int iNextBoundary;
        int iNextBoundary2;
        MultiParagraph multiParagraph = this.multiParagraph;
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        multiParagraph.requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i == ((AnnotatedString) multiParagraph.intrinsics.url).text.length() ? AppCompatHintHelper.getLastIndex(arrayList) : ParagraphKt.findParagraphByIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int localIndex = paragraphInfo.toLocalIndex(i);
        LogcatCache wordIterator = androidParagraph.layout.getWordIterator();
        if (wordIterator.isOnPunctuation(wordIterator.prevBoundary(localIndex))) {
            wordIterator.checkOffsetIsValid(localIndex);
            iPrevBoundary = localIndex;
            while (iPrevBoundary != -1 && (!wordIterator.isOnPunctuation(iPrevBoundary) || wordIterator.isAfterPunctuation(iPrevBoundary))) {
                iPrevBoundary = wordIterator.prevBoundary(iPrevBoundary);
            }
        } else {
            wordIterator.checkOffsetIsValid(localIndex);
            if (wordIterator.isOnLetterOrDigitOrEmoji(localIndex)) {
                iPrevBoundary = (!wordIterator.isBoundary(localIndex) || wordIterator.isAfterLetterOrDigitOrEmoji(localIndex)) ? wordIterator.prevBoundary(localIndex) : localIndex;
            } else {
                iPrevBoundary = wordIterator.isAfterLetterOrDigitOrEmoji(localIndex) ? wordIterator.prevBoundary(localIndex) : -1;
            }
        }
        if (iPrevBoundary == -1) {
            iPrevBoundary = localIndex;
        }
        if (wordIterator.isAfterPunctuation(wordIterator.nextBoundary(localIndex))) {
            wordIterator.checkOffsetIsValid(localIndex);
            iNextBoundary = localIndex;
            while (iNextBoundary != -1 && (wordIterator.isOnPunctuation(iNextBoundary) || !wordIterator.isAfterPunctuation(iNextBoundary))) {
                iNextBoundary = wordIterator.nextBoundary(iNextBoundary);
            }
        } else {
            wordIterator.checkOffsetIsValid(localIndex);
            if (wordIterator.isAfterLetterOrDigitOrEmoji(localIndex)) {
                if (!wordIterator.isBoundary(localIndex) || wordIterator.isOnLetterOrDigitOrEmoji(localIndex)) {
                    iNextBoundary2 = wordIterator.nextBoundary(localIndex);
                    iNextBoundary = iNextBoundary2;
                } else {
                    iNextBoundary = localIndex;
                }
            } else if (wordIterator.isOnLetterOrDigitOrEmoji(localIndex)) {
                iNextBoundary2 = wordIterator.nextBoundary(localIndex);
                iNextBoundary = iNextBoundary2;
            } else {
                iNextBoundary = -1;
            }
        }
        if (iNextBoundary != -1) {
            localIndex = iNextBoundary;
        }
        return paragraphInfo.m631toGlobalxdX6G0(ParagraphKt.TextRange(iPrevBoundary, localIndex), false);
    }

    public final int hashCode() {
        int iHashCode = (this.multiParagraph.hashCode() + (this.layoutInput.hashCode() * 31)) * 31;
        long j = this.size;
        return this.placeholderRects.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.lastBaseline, ImageAnalysis$$ExternalSyntheticLambda1.m(this.firstBaseline, (((int) (j ^ (j >>> 32))) + iHashCode) * 31, 31), 31);
    }

    public final String toString() {
        return "TextLayoutResult(layoutInput=" + this.layoutInput + ", multiParagraph=" + this.multiParagraph + ", size=" + ((Object) IntSize.m721toStringimpl(this.size)) + ", firstBaseline=" + this.firstBaseline + ", lastBaseline=" + this.lastBaseline + ", placeholderRects=" + this.placeholderRects + ')';
    }
}
