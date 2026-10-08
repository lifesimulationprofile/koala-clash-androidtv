package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.modifiers.SelectionController$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MultiWidgetSelectionDelegate {
    public TextLayoutResult _previousTextLayoutResult;
    public final SelectionController$$ExternalSyntheticLambda0 coordinatesCallback;
    public final SelectionController$$ExternalSyntheticLambda0 layoutResultCallback;
    public final long selectableId;
    public final MultiWidgetSelectionDelegate lock = this;
    public int _previousLastVisibleOffset = -1;

    public MultiWidgetSelectionDelegate(long j, SelectionController$$ExternalSyntheticLambda0 selectionController$$ExternalSyntheticLambda0, SelectionController$$ExternalSyntheticLambda0 selectionController$$ExternalSyntheticLambda1) {
        this.selectableId = j;
        this.coordinatesCallback = selectionController$$ExternalSyntheticLambda0;
        this.layoutResultCallback = selectionController$$ExternalSyntheticLambda1;
    }

    /* JADX INFO: renamed from: getHandlePosition-dBAh8RU, reason: not valid java name */
    public final long m214getHandlePositiondBAh8RU(Selection selection, boolean z) {
        TextLayoutResult textLayoutResult;
        Selection.AnchorInfo anchorInfo = selection.end;
        Selection.AnchorInfo anchorInfo2 = selection.start;
        long j = this.selectableId;
        if (z && anchorInfo2.selectableId != j) {
            return 9205357640488583168L;
        }
        if ((!z && anchorInfo.selectableId != j) || getLayoutCoordinates() == null || (textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke()) == null) {
            return 9205357640488583168L;
        }
        return SimpleLayoutKt.getSelectionHandleCoordinates(textLayoutResult, RangesKt.coerceIn(z ? anchorInfo2.offset : anchorInfo.offset, 0, getLastVisibleOffset(textLayoutResult)), z, selection.handlesCrossed);
    }

    public final int getLastVisibleOffset(TextLayoutResult textLayoutResult) {
        int i;
        synchronized (this.lock) {
            try {
                if (this._previousTextLayoutResult != textLayoutResult) {
                    MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
                    boolean z = multiParagraph.didExceedMaxLines;
                    int i2 = 0;
                    if (!(z || ((float) ((int) (textLayoutResult.size & 4294967295L))) < multiParagraph.height) || z) {
                        i2 = multiParagraph.lineCount - 1;
                    } else {
                        int lineForVerticalPosition = multiParagraph.getLineForVerticalPosition((int) (textLayoutResult.size & 4294967295L));
                        int i3 = textLayoutResult.multiParagraph.lineCount - 1;
                        if (lineForVerticalPosition > i3) {
                            lineForVerticalPosition = i3;
                        }
                        while (lineForVerticalPosition >= 0 && textLayoutResult.multiParagraph.getLineTop(lineForVerticalPosition) >= ((int) (textLayoutResult.size & 4294967295L))) {
                            lineForVerticalPosition--;
                        }
                        if (lineForVerticalPosition >= 0) {
                            i2 = lineForVerticalPosition;
                        }
                    }
                    this._previousLastVisibleOffset = textLayoutResult.multiParagraph.getLineEnd(i2, true);
                    this._previousTextLayoutResult = textLayoutResult;
                }
                i = this._previousLastVisibleOffset;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.coordinatesCallback.invoke();
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    public final AnnotatedString getText() {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke();
        return textLayoutResult == null ? new AnnotatedString("") : textLayoutResult.layoutInput.text;
    }
}
