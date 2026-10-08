package androidx.compose.ui.text.input;

import android.os.Build;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.MenuHostHelper;
import com.google.android.gms.internal.mlkit_vision_barcode.zztu;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CursorAnchorInfoController {
    public Rect decorationBoxBounds;
    public boolean hasPendingImmediateRequest;
    public boolean includeCharacterBounds;
    public boolean includeEditorBounds;
    public boolean includeInsertionMarker;
    public boolean includeLineBounds;
    public Rect innerTextFieldBounds;
    public final MenuHostHelper inputMethodManager;
    public boolean monitorEnabled;
    public OffsetMapping offsetMapping;
    public final AndroidComposeView rootPositionCalculator;
    public TextFieldValue textFieldValue;
    public TextLayoutResult textLayoutResult;
    public final Object lock = new Object();
    public Function1 textFieldToRootTransform = TextInputServiceAndroid.AnonymousClass1.INSTANCE$2;
    public final CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
    public final float[] matrix = Matrix.m442constructorimpl$default();
    public final android.graphics.Matrix androidMatrix = new android.graphics.Matrix();

    public CursorAnchorInfoController(AndroidComposeView androidComposeView, MenuHostHelper menuHostHelper) {
        this.rootPositionCalculator = androidComposeView;
        this.inputMethodManager = menuHostHelper;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.Lazy] */
    public final void updateCursorAnchorInfo() {
        CursorAnchorInfo.Builder builder;
        MenuHostHelper menuHostHelper = this.inputMethodManager;
        ?? r2 = menuHostHelper.mMenuProviders;
        InputMethodManager inputMethodManager = (InputMethodManager) r2.getValue();
        View view = (View) menuHostHelper.mOnInvalidateMenuCallback;
        if (inputMethodManager.isActive(view)) {
            Function1 function1 = this.textFieldToRootTransform;
            float[] fArr = this.matrix;
            function1.invoke(new Matrix(fArr));
            this.rootPositionCalculator.m589localToScreen58bKbWc(fArr);
            android.graphics.Matrix matrix = this.androidMatrix;
            BrushKt.m422setFromEL8BTi8(matrix, fArr);
            TextFieldValue textFieldValue = this.textFieldValue;
            long j = textFieldValue.selection;
            OffsetMapping offsetMapping = this.offsetMapping;
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
            Rect rect = this.innerTextFieldBounds;
            float f = rect.bottom;
            float f2 = rect.top;
            Rect rect2 = this.decorationBoxBounds;
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
                boolean zContainsInclusive = zztu.containsInclusive(rect, fCoerceIn, cursorRect.top);
                boolean zContainsInclusive2 = zztu.containsInclusive(rect, fCoerceIn, cursorRect.bottom);
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
                        float f6 = fArr2[i2 + 1];
                        CursorAnchorInfo.Builder builder3 = builder;
                        float f7 = fArr2[i2 + 2];
                        float f8 = fArr2[i2 + 3];
                        int i3 = iM643getMaximpl;
                        int i4 = (rect.left < f7 ? 1 : 0) & (f5 < rect.right ? 1 : 0) & (f2 < f8 ? 1 : 0) & (f6 < f ? 1 : 0);
                        if (!zztu.containsInclusive(rect, f5, f6) || !zztu.containsInclusive(rect, f7, f8)) {
                            i4 |= 2;
                        }
                        if (textLayoutResult.getBidiRunDirection(iOriginalToTransformed4) == 2) {
                            i4 |= 4;
                        }
                        int i5 = iM644getMinimpl2;
                        builder3.addCharacterBounds(i5, f5, f6, f7, f8, i4);
                        iM644getMinimpl2 = i5 + 1;
                        builder = builder3;
                        iM643getMaximpl = i3;
                    }
                }
            }
            CursorAnchorInfo.Builder builder4 = builder;
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 33 && z3) {
                builder4.setEditorBoundsInfo(ComponentDialog$$ExternalSyntheticApiModelOutline0.m2m().setEditorBounds(BrushKt.toAndroidRectF(rect2)).setHandwritingBounds(BrushKt.toAndroidRectF(rect2)).build());
            }
            if (i6 >= 34 && z4 && !rect.isEmpty()) {
                int i7 = multiParagraph.lineCount - 1;
                if (i7 < 0) {
                    i7 = 0;
                }
                int iCoerceIn = RangesKt.coerceIn(multiParagraph.getLineForVerticalPosition(f2), 0, i7);
                int iCoerceIn2 = RangesKt.coerceIn(multiParagraph.getLineForVerticalPosition(f), 0, i7);
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
            ((InputMethodManager) r2.getValue()).updateCursorAnchorInfo(view, builder4.build());
            this.hasPendingImmediateRequest = false;
        }
    }
}
