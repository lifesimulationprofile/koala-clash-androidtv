package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyCursorAnchorInfoController {
    public Rect decorationBoxBounds;
    public boolean hasPendingImmediateRequest;
    public boolean includeCharacterBounds;
    public boolean includeEditorBounds;
    public boolean includeInsertionMarker;
    public boolean includeLineBounds;
    public Rect innerTextFieldBounds;
    public final ContentCaptureSessionCompat inputMethodManager;
    public final AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1 localToScreen;
    public boolean monitorEnabled;
    public OffsetMapping offsetMapping;
    public TextFieldValue textFieldValue;
    public TextLayoutResult textLayoutResult;
    public final Object lock = new Object();
    public final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
    public final float[] matrix = Matrix.m442constructorimpl$default();
    public final android.graphics.Matrix androidMatrix = new android.graphics.Matrix();

    public LegacyCursorAnchorInfoController(AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1 androidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1, ContentCaptureSessionCompat contentCaptureSessionCompat) {
        this.localToScreen = androidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1;
        this.inputMethodManager = contentCaptureSessionCompat;
    }

    public final void updateCursorAnchorInfo() {
        CursorAnchorInfo.Builder builder;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.inputMethodManager;
        InputMethodManager imm = contentCaptureSessionCompat.getImm();
        View view = contentCaptureSessionCompat.mView;
        if (!imm.isActive(view) || this.textFieldValue == null || this.offsetMapping == null || this.textLayoutResult == null || this.innerTextFieldBounds == null || this.decorationBoxBounds == null) {
            return;
        }
        float[] fArr = this.matrix;
        Matrix.m445resetimpl(fArr);
        LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.localToScreen.$node.layoutCoordinates$delegate.getValue();
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.isAttached()) {
                layoutCoordinates = null;
            }
            if (layoutCoordinates != null) {
                layoutCoordinates.mo530transformToScreen58bKbWc(fArr);
            }
        }
        Unit unit = Unit.INSTANCE;
        Rect rect = this.decorationBoxBounds;
        Matrix.m447translateimpl(fArr, -rect.left, -rect.top);
        android.graphics.Matrix matrix = this.androidMatrix;
        BrushKt.m422setFromEL8BTi8(matrix, fArr);
        TextFieldValue textFieldValue = this.textFieldValue;
        long j = textFieldValue.selection;
        OffsetMapping offsetMapping = this.offsetMapping;
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        Rect rect2 = this.innerTextFieldBounds;
        float f = rect2.bottom;
        float f2 = rect2.top;
        Rect rect3 = this.decorationBoxBounds;
        boolean z = this.includeInsertionMarker;
        boolean z2 = this.includeCharacterBounds;
        boolean z3 = this.includeEditorBounds;
        boolean z4 = this.includeLineBounds;
        CursorAnchorInfo.Builder builder2 = this.builder;
        builder2.reset();
        builder2.setMatrix(matrix);
        TextRange textRange = textFieldValue.composition;
        int iM644getMinimpl = TextRange.m644getMinimpl(j);
        builder2.setSelectionRange(iM644getMinimpl, TextRange.m643getMaximpl(j));
        if (!z || iM644getMinimpl < 0) {
            builder = builder2;
        } else {
            int iOriginalToTransformed = offsetMapping.originalToTransformed(iM644getMinimpl);
            Rect cursorRect = textLayoutResult.getCursorRect(iOriginalToTransformed);
            float fCoerceIn = RangesKt.coerceIn(cursorRect.left, 0.0f, (int) (textLayoutResult.size >> 32));
            boolean zContainsInclusive = HandwritingGestureApi34.containsInclusive(rect2, fCoerceIn, cursorRect.top);
            boolean zContainsInclusive2 = HandwritingGestureApi34.containsInclusive(rect2, fCoerceIn, cursorRect.bottom);
            boolean z5 = textLayoutResult.getBidiRunDirection(iOriginalToTransformed) == 2;
            int i = (zContainsInclusive || zContainsInclusive2) ? 1 : 0;
            if (!zContainsInclusive || !zContainsInclusive2) {
                i |= 2;
            }
            if (z5) {
                i |= 4;
            }
            float f3 = cursorRect.top;
            float f4 = cursorRect.bottom;
            builder2.setInsertionMarkerLocation(fCoerceIn, f3, f4, f4, i);
            builder = builder2;
        }
        if (z2) {
            int iM644getMinimpl2 = textRange != null ? TextRange.m644getMinimpl(textRange.packedValue) : -1;
            int iM643getMaximpl = textRange != null ? TextRange.m643getMaximpl(textRange.packedValue) : -1;
            if (iM644getMinimpl2 >= 0 && iM644getMinimpl2 < iM643getMaximpl) {
                builder.setComposingText(iM644getMinimpl2, textFieldValue.annotatedString.text.subSequence(iM644getMinimpl2, iM643getMaximpl));
                int iOriginalToTransformed2 = offsetMapping.originalToTransformed(iM644getMinimpl2);
                int iOriginalToTransformed3 = offsetMapping.originalToTransformed(iM643getMaximpl);
                float[] fArr2 = new float[(iOriginalToTransformed3 - iOriginalToTransformed2) * 4];
                multiParagraph.m628fillBoundingBoxes8ffj60Q(ParagraphKt.TextRange(iOriginalToTransformed2, iOriginalToTransformed3), fArr2);
                while (iM644getMinimpl2 < iM643getMaximpl) {
                    int iOriginalToTransformed4 = offsetMapping.originalToTransformed(iM644getMinimpl2);
                    int i2 = (iOriginalToTransformed4 - iOriginalToTransformed2) * 4;
                    float f5 = fArr2[i2];
                    CursorAnchorInfo.Builder builder3 = builder;
                    float f6 = fArr2[i2 + 1];
                    int i3 = iM643getMaximpl;
                    float f7 = fArr2[i2 + 2];
                    float f8 = fArr2[i2 + 3];
                    int i4 = iOriginalToTransformed2;
                    int i5 = (rect2.left < f7 ? 1 : 0) & (f5 < rect2.right ? 1 : 0) & (f2 < f8 ? 1 : 0) & (f6 < f ? 1 : 0);
                    if (!HandwritingGestureApi34.containsInclusive(rect2, f5, f6) || !HandwritingGestureApi34.containsInclusive(rect2, f7, f8)) {
                        i5 |= 2;
                    }
                    if (textLayoutResult.getBidiRunDirection(iOriginalToTransformed4) == 2) {
                        i5 |= 4;
                    }
                    int i6 = iM644getMinimpl2;
                    builder3.addCharacterBounds(i6, f5, f6, f7, f8, i5);
                    iM644getMinimpl2 = i6 + 1;
                    builder = builder3;
                    iM643getMaximpl = i3;
                    iOriginalToTransformed2 = i4;
                }
            }
        }
        CursorAnchorInfo.Builder builder4 = builder;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33 && z3) {
            builder4.setEditorBoundsInfo(ComponentDialog$$ExternalSyntheticApiModelOutline0.m2m().setEditorBounds(BrushKt.toAndroidRectF(rect3)).setHandwritingBounds(BrushKt.toAndroidRectF(rect3)).build());
        }
        if (i7 >= 34 && z4 && !rect2.isEmpty()) {
            int i8 = multiParagraph.lineCount - 1;
            if (i8 < 0) {
                i8 = 0;
            }
            int iCoerceIn = RangesKt.coerceIn(multiParagraph.getLineForVerticalPosition(f2), 0, i8);
            int iCoerceIn2 = RangesKt.coerceIn(multiParagraph.getLineForVerticalPosition(f), 0, i8);
            if (iCoerceIn <= iCoerceIn2) {
                while (true) {
                    builder4.addVisibleLineBounds(textLayoutResult.getLineLeft(iCoerceIn), multiParagraph.getLineTop(iCoerceIn), textLayoutResult.getLineRight(iCoerceIn), multiParagraph.getLineBottom(iCoerceIn));
                    if (iCoerceIn == iCoerceIn2) {
                        break;
                    } else {
                        iCoerceIn++;
                    }
                }
            }
        }
        contentCaptureSessionCompat.getImm().updateCursorAnchorInfo(view, builder4.build());
        this.hasPendingImmediateRequest = false;
    }
}
