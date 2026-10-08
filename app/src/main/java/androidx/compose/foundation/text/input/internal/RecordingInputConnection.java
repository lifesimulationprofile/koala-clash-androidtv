package androidx.compose.foundation.text.input.internal;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextInclusionStrategy$Companion;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextInCodePointsCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.SetComposingRegionCommand;
import androidx.compose.ui.text.input.SetComposingTextCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1;
import androidx.core.view.WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatcherMatchResult;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RecordingInputConnection implements InputConnection {
    public final boolean autoCorrect;
    public int batchDepth;
    public int currentExtractedTextRequestToken;
    public final Toolbar.AnonymousClass1 eventCallback;
    public boolean extractedTextMonitorMode;
    public final LegacyTextFieldState legacyTextFieldState;
    public final TextFieldSelectionManager textFieldSelectionManager;
    public TextFieldValue textFieldValue;
    public final ViewConfiguration viewConfiguration;
    public final ArrayList editCommands = new ArrayList();
    public boolean isActive = true;

    public RecordingInputConnection(TextFieldValue textFieldValue, Toolbar.AnonymousClass1 anonymousClass1, boolean z, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration) {
        this.eventCallback = anonymousClass1;
        this.autoCorrect = z;
        this.legacyTextFieldState = legacyTextFieldState;
        this.textFieldSelectionManager = textFieldSelectionManager;
        this.viewConfiguration = viewConfiguration;
        this.textFieldValue = textFieldValue;
    }

    public final void addEditCommandWithBatch(EditCommand editCommand) {
        this.batchDepth++;
        try {
            this.editCommands.add(editCommand);
        } finally {
            endBatchEditInternal();
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        this.batchDepth++;
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean clearMetaKeyStates(int i) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
        ArrayList arrayList = ((LegacyTextInputMethodRequest) this.eventCallback.this$0).ics;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(((WeakReference) arrayList.get(i)).get(), this)) {
                arrayList.remove(i);
                return;
            }
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z = this.isActive;
        return z ? this.autoCorrect : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new CommitTextCommand(String.valueOf(charSequence), i));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextCommand(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    public final boolean endBatchEditInternal() {
        int i = this.batchDepth - 1;
        this.batchDepth = i;
        if (i == 0) {
            ArrayList arrayList = this.editCommands;
            if (!arrayList.isEmpty()) {
                ((LegacyTextInputMethodRequest) this.eventCallback.this$0).onEditCommand.invoke(new ArrayList(arrayList));
                arrayList.clear();
            }
        }
        return this.batchDepth > 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new FinishComposingTextCommand());
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int i) {
        TextFieldValue textFieldValue = this.textFieldValue;
        return TextUtils.getCapsMode(textFieldValue.annotatedString.text, TextRange.m644getMinimpl(textFieldValue.selection), i);
    }

    @Override // android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = (i & 1) != 0;
        this.extractedTextMonitorMode = z;
        if (z) {
            this.currentExtractedTextRequestToken = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return HandwritingGestureApi34.access$toExtractedText(this.textFieldValue);
    }

    @Override // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int i) {
        if (TextRange.m641getCollapsedimpl(this.textFieldValue.selection)) {
            return null;
        }
        return TextFieldValueKt.getSelectedText(this.textFieldValue).text;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int i, int i2) {
        return TextFieldValueKt.getTextAfterSelection(this.textFieldValue, i).text;
    }

    @Override // android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int i, int i2) {
        return TextFieldValueKt.getTextBeforeSelection(this.textFieldValue, i).text;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int i) {
        boolean z = this.isActive;
        if (z) {
            z = false;
            switch (i) {
                case R.id.selectAll:
                    addEditCommandWithBatch(new SetSelectionCommand(0, this.textFieldValue.annotatedString.text.length()));
                    break;
                case R.id.cut:
                    sendSynthesizedKeyEvent(277);
                    return false;
                case R.id.copy:
                    sendSynthesizedKeyEvent(278);
                    return false;
                case R.id.paste:
                    sendSynthesizedKeyEvent(279);
                    return false;
                default:
                    return false;
            }
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int i) {
        int i2;
        boolean z = this.isActive;
        if (z) {
            z = true;
            if (i != 0) {
                switch (i) {
                    case 2:
                        i2 = 2;
                        break;
                    case 3:
                        i2 = 3;
                        break;
                    case 4:
                        i2 = 4;
                        break;
                    case 5:
                        i2 = 6;
                        break;
                    case 6:
                        i2 = 7;
                        break;
                    case 7:
                        i2 = 5;
                        break;
                    default:
                        Log.w("RecordingIC", "IME sends unsupported Editor Action: " + i);
                        i2 = 1;
                        break;
                }
            } else {
                i2 = 1;
            }
            ((LegacyTextInputMethodRequest) this.eventCallback.this$0).onImeActionPerformed.invoke(new ImeAction(i2));
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0276  */
    /* JADX WARN: Code duplicated, block: B:170:0x03da  */
    @Override // android.view.inputmethod.InputConnection
    public final void performHandwritingGesture(HandwritingGesture handwritingGesture, Executor executor, IntConsumer intConsumer) {
        int iFallbackOnLegacyTextField;
        AnnotatedString annotatedString;
        char c;
        long jM630getRangeForRect86BmAI;
        int i;
        int i2;
        int i3;
        String string;
        int i4;
        int iM194access$getOffsetForHandwritingGestured4ec7I;
        TextLayoutResultProxy layoutResult;
        int iM194access$getOffsetForHandwritingGestured4ec7I2;
        TextLayoutResultProxy layoutResult2;
        TextLayoutInput textLayoutInput;
        if (Build.VERSION.SDK_INT >= 34) {
            Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(21, this);
            LegacyTextFieldState legacyTextFieldState = this.legacyTextFieldState;
            if (legacyTextFieldState == null || (annotatedString = legacyTextFieldState.untransformedText) == null) {
                iFallbackOnLegacyTextField = 3;
            } else {
                TextLayoutResultProxy layoutResult3 = legacyTextFieldState.getLayoutResult();
                if (annotatedString.equals((layoutResult3 == null || (textLayoutInput = layoutResult3.value.layoutInput) == null) ? null : textLayoutInput.text)) {
                    boolean zM193m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m193m((Object) handwritingGesture);
                    iFallbackOnLegacyTextField = 1;
                    TextFieldSelectionManager textFieldSelectionManager = this.textFieldSelectionManager;
                    if (zM193m) {
                        SelectGesture selectGestureM190m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m190m((Object) handwritingGesture);
                        long jM197getRangeForScreenRectOH9lIzo = HandwritingGestureApi34.m197getRangeForScreenRectOH9lIzo(legacyTextFieldState, BrushKt.toComposeRect(selectGestureM190m.getSelectionArea()), selectGestureM190m.getGranularity() != 1 ? 0 : 1);
                        if (TextRange.m641getCollapsedimpl(jM197getRangeForScreenRectOH9lIzo)) {
                            iFallbackOnLegacyTextField = HandwritingGestureApi34.fallbackOnLegacyTextField(WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m769m((Object) selectGestureM190m), recomposer$$ExternalSyntheticLambda0);
                        } else {
                            recomposer$$ExternalSyntheticLambda0.invoke(new SetSelectionCommand((int) (jM197getRangeForScreenRectOH9lIzo >> 32), (int) (jM197getRangeForScreenRectOH9lIzo & 4294967295L)));
                            if (textFieldSelectionManager != null) {
                                textFieldSelectionManager.enterSelectionMode$foundation(true);
                            }
                        }
                    } else if (EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$3(handwritingGesture)) {
                        DeleteGesture deleteGestureM = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m((Object) handwritingGesture);
                        int i5 = deleteGestureM.getGranularity() != 1 ? 0 : 1;
                        long jM197getRangeForScreenRectOH9lIzo2 = HandwritingGestureApi34.m197getRangeForScreenRectOH9lIzo(legacyTextFieldState, BrushKt.toComposeRect(deleteGestureM.getDeletionArea()), i5);
                        if (TextRange.m641getCollapsedimpl(jM197getRangeForScreenRectOH9lIzo2)) {
                            iFallbackOnLegacyTextField = HandwritingGestureApi34.fallbackOnLegacyTextField(WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m769m((Object) deleteGestureM), recomposer$$ExternalSyntheticLambda0);
                        } else {
                            HandwritingGestureApi34.m198performDeletionOnLegacyTextFieldvJH6DeI(jM197getRangeForScreenRectOH9lIzo2, annotatedString, i5 == 1, recomposer$$ExternalSyntheticLambda0);
                        }
                    } else if (EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$4(handwritingGesture)) {
                        SelectRangeGesture selectRangeGestureM191m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m191m((Object) handwritingGesture);
                        long jM195access$getRangeForScreenRectsO048IG0 = HandwritingGestureApi34.m195access$getRangeForScreenRectsO048IG0(legacyTextFieldState, BrushKt.toComposeRect(selectRangeGestureM191m.getSelectionStartArea()), BrushKt.toComposeRect(selectRangeGestureM191m.getSelectionEndArea()), selectRangeGestureM191m.getGranularity() != 1 ? 0 : 1);
                        if (TextRange.m641getCollapsedimpl(jM195access$getRangeForScreenRectsO048IG0)) {
                            iFallbackOnLegacyTextField = HandwritingGestureApi34.fallbackOnLegacyTextField(WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m769m((Object) selectRangeGestureM191m), recomposer$$ExternalSyntheticLambda0);
                        } else {
                            recomposer$$ExternalSyntheticLambda0.invoke(new SetSelectionCommand((int) (jM195access$getRangeForScreenRectsO048IG0 >> 32), (int) (jM195access$getRangeForScreenRectsO048IG0 & 4294967295L)));
                            if (textFieldSelectionManager != null) {
                                textFieldSelectionManager.enterSelectionMode$foundation(true);
                            }
                        }
                    } else if (EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$5(handwritingGesture)) {
                        DeleteRangeGesture deleteRangeGestureM186m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m186m((Object) handwritingGesture);
                        int i6 = deleteRangeGestureM186m.getGranularity() != 1 ? 0 : 1;
                        long jM195access$getRangeForScreenRectsO048IG1 = HandwritingGestureApi34.m195access$getRangeForScreenRectsO048IG0(legacyTextFieldState, BrushKt.toComposeRect(deleteRangeGestureM186m.getDeletionStartArea()), BrushKt.toComposeRect(deleteRangeGestureM186m.getDeletionEndArea()), i6);
                        if (TextRange.m641getCollapsedimpl(jM195access$getRangeForScreenRectsO048IG1)) {
                            iFallbackOnLegacyTextField = HandwritingGestureApi34.fallbackOnLegacyTextField(WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m769m((Object) deleteRangeGestureM186m), recomposer$$ExternalSyntheticLambda0);
                        } else {
                            HandwritingGestureApi34.m198performDeletionOnLegacyTextFieldvJH6DeI(jM195access$getRangeForScreenRectsO048IG1, annotatedString, i6 == 1, recomposer$$ExternalSyntheticLambda0);
                        }
                    } else {
                        boolean zM$6 = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$6(handwritingGesture);
                        ViewConfiguration viewConfiguration = this.viewConfiguration;
                        int i7 = -1;
                        if (zM$6) {
                            JoinOrSplitGesture joinOrSplitGestureM188m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m188m((Object) handwritingGesture);
                            if (viewConfiguration == null || (iM194access$getOffsetForHandwritingGestured4ec7I2 = HandwritingGestureApi34.m194access$getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGestureApi34.access$toOffset(joinOrSplitGestureM188m.getJoinOrSplitPoint()), viewConfiguration)) == -1 || ((layoutResult2 = legacyTextFieldState.getLayoutResult()) != null && HandwritingGestureApi34.access$isBiDiBoundary(layoutResult2.value, iM194access$getOffsetForHandwritingGestured4ec7I2))) {
                                iFallbackOnLegacyTextField = HandwritingGestureApi34.fallbackOnLegacyTextField(WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m769m((Object) joinOrSplitGestureM188m), recomposer$$ExternalSyntheticLambda0);
                            } else {
                                int iCharCount = iM194access$getOffsetForHandwritingGestured4ec7I2;
                                while (iCharCount > 0) {
                                    int iCodePointBefore = Character.codePointBefore(annotatedString, iCharCount);
                                    if (!HandwritingGestureApi34.isWhitespace(iCodePointBefore)) {
                                        break;
                                    } else {
                                        iCharCount -= Character.charCount(iCodePointBefore);
                                    }
                                }
                                while (iM194access$getOffsetForHandwritingGestured4ec7I2 < annotatedString.text.length()) {
                                    int iCodePointAt = Character.codePointAt(annotatedString, iM194access$getOffsetForHandwritingGestured4ec7I2);
                                    if (!HandwritingGestureApi34.isWhitespace(iCodePointAt)) {
                                        break;
                                    } else {
                                        iM194access$getOffsetForHandwritingGestured4ec7I2 += Character.charCount(iCodePointAt);
                                    }
                                }
                                long jTextRange = ParagraphKt.TextRange(iCharCount, iM194access$getOffsetForHandwritingGestured4ec7I2);
                                if (TextRange.m641getCollapsedimpl(jTextRange)) {
                                    int i8 = (int) (jTextRange >> 32);
                                    recomposer$$ExternalSyntheticLambda0.invoke(new HandwritingGesture_androidKt$compoundEditCommand$1(new EditCommand[]{new SetSelectionCommand(i8, i8), new CommitTextCommand(" ", 1)}));
                                } else {
                                    HandwritingGestureApi34.m198performDeletionOnLegacyTextFieldvJH6DeI(jTextRange, annotatedString, false, recomposer$$ExternalSyntheticLambda0);
                                }
                            }
                        } else if (EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$1(handwritingGesture)) {
                            InsertGesture insertGestureM187m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m187m((Object) handwritingGesture);
                            if (viewConfiguration == null || (iM194access$getOffsetForHandwritingGestured4ec7I = HandwritingGestureApi34.m194access$getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGestureApi34.access$toOffset(insertGestureM187m.getInsertionPoint()), viewConfiguration)) == -1 || ((layoutResult = legacyTextFieldState.getLayoutResult()) != null && HandwritingGestureApi34.access$isBiDiBoundary(layoutResult.value, iM194access$getOffsetForHandwritingGestured4ec7I))) {
                                iFallbackOnLegacyTextField = HandwritingGestureApi34.fallbackOnLegacyTextField(WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m769m((Object) insertGestureM187m), recomposer$$ExternalSyntheticLambda0);
                            } else {
                                recomposer$$ExternalSyntheticLambda0.invoke(new HandwritingGesture_androidKt$compoundEditCommand$1(new EditCommand[]{new SetSelectionCommand(iM194access$getOffsetForHandwritingGestured4ec7I, iM194access$getOffsetForHandwritingGestured4ec7I), new CommitTextCommand(insertGestureM187m.getTextToInsert(), 1)}));
                            }
                        } else if (EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$2(handwritingGesture)) {
                            RemoveSpaceGesture removeSpaceGestureM189m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m189m((Object) handwritingGesture);
                            TextLayoutResultProxy layoutResult4 = legacyTextFieldState.getLayoutResult();
                            TextLayoutResult textLayoutResult = layoutResult4 != null ? layoutResult4.value : null;
                            long jAccess$toOffset = HandwritingGestureApi34.access$toOffset(removeSpaceGestureM189m.getStartPoint());
                            long jAccess$toOffset2 = HandwritingGestureApi34.access$toOffset(removeSpaceGestureM189m.getEndPoint());
                            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                            if (textLayoutResult != null) {
                                MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
                                if (layoutCoordinates == null) {
                                    c = ' ';
                                    jM630getRangeForRect86BmAI = TextRange.Zero;
                                } else {
                                    long jMo528screenToLocalMKHz9U = layoutCoordinates.mo528screenToLocalMKHz9U(jAccess$toOffset);
                                    long jMo528screenToLocalMKHz9U2 = layoutCoordinates.mo528screenToLocalMKHz9U(jAccess$toOffset2);
                                    int iM196getLineForHandwritingGestured4ec7I = HandwritingGestureApi34.m196getLineForHandwritingGestured4ec7I(multiParagraph, jMo528screenToLocalMKHz9U, viewConfiguration);
                                    int iM196getLineForHandwritingGestured4ec7I2 = HandwritingGestureApi34.m196getLineForHandwritingGestured4ec7I(multiParagraph, jMo528screenToLocalMKHz9U2, viewConfiguration);
                                    if (iM196getLineForHandwritingGestured4ec7I != -1) {
                                        if (iM196getLineForHandwritingGestured4ec7I2 != -1) {
                                            iM196getLineForHandwritingGestured4ec7I = Math.min(iM196getLineForHandwritingGestured4ec7I, iM196getLineForHandwritingGestured4ec7I2);
                                        }
                                        iM196getLineForHandwritingGestured4ec7I2 = iM196getLineForHandwritingGestured4ec7I;
                                    } else if (iM196getLineForHandwritingGestured4ec7I2 == -1) {
                                        jM630getRangeForRect86BmAI = TextRange.Zero;
                                        c = ' ';
                                    }
                                    c = ' ';
                                    float lineBottom = (multiParagraph.getLineBottom(iM196getLineForHandwritingGestured4ec7I2) + multiParagraph.getLineTop(iM196getLineForHandwritingGestured4ec7I2)) / 2;
                                    int i9 = (int) (jMo528screenToLocalMKHz9U >> 32);
                                    int i10 = (int) (jMo528screenToLocalMKHz9U2 >> 32);
                                    jM630getRangeForRect86BmAI = multiParagraph.m630getRangeForRect86BmAI(new Rect(Math.min(Float.intBitsToFloat(i9), Float.intBitsToFloat(i10)), lineBottom - 0.1f, Math.max(Float.intBitsToFloat(i9), Float.intBitsToFloat(i10)), lineBottom + 0.1f), 0, TextInclusionStrategy$Companion.AnyOverlap);
                                }
                            } else {
                                c = ' ';
                                jM630getRangeForRect86BmAI = TextRange.Zero;
                            }
                            if (TextRange.m641getCollapsedimpl(jM630getRangeForRect86BmAI)) {
                                iFallbackOnLegacyTextField = HandwritingGestureApi34.fallbackOnLegacyTextField(WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m769m((Object) removeSpaceGestureM189m), recomposer$$ExternalSyntheticLambda0);
                            } else {
                                String str = annotatedString.subSequence(TextRange.m644getMinimpl(jM630getRangeForRect86BmAI), TextRange.m643getMaximpl(jM630getRangeForRect86BmAI)).text;
                                Matcher matcher = Pattern.compile("\\s+").matcher(str);
                                MatcherMatchResult matcherMatchResult = !matcher.find(0) ? null : new MatcherMatchResult(matcher, str);
                                if (matcherMatchResult == null) {
                                    string = str.toString();
                                    i4 = -1;
                                    i2 = -1;
                                    i = -1;
                                } else {
                                    int length = str.length();
                                    StringBuilder sb = new StringBuilder(length);
                                    MatcherMatchResult matcherMatchResult2 = matcherMatchResult;
                                    i = -1;
                                    int i11 = 0;
                                    while (true) {
                                        sb.append((CharSequence) str, i11, matcherMatchResult2.getRange().first);
                                        if (i == i7) {
                                            i = matcherMatchResult2.getRange().first;
                                        }
                                        i2 = matcherMatchResult2.getRange().last + iFallbackOnLegacyTextField;
                                        sb.append((CharSequence) "");
                                        i3 = matcherMatchResult2.getRange().last + iFallbackOnLegacyTextField;
                                        CharSequence charSequence = matcherMatchResult2.input;
                                        Matcher matcher2 = matcherMatchResult2.matcher;
                                        int iEnd = matcher2.end() + (matcher2.end() == matcher2.start() ? 1 : 0);
                                        if (iEnd <= charSequence.length()) {
                                            Matcher matcher3 = matcher2.pattern().matcher(charSequence);
                                            matcherMatchResult2 = !matcher3.find(iEnd) ? null : new MatcherMatchResult(matcher3, charSequence);
                                        } else {
                                            matcherMatchResult2 = null;
                                        }
                                        if (i3 >= length || matcherMatchResult2 == null) {
                                            break;
                                        }
                                        i11 = i3;
                                        iFallbackOnLegacyTextField = 1;
                                        i7 = -1;
                                    }
                                    if (i3 < length) {
                                        sb.append((CharSequence) str, i3, length);
                                    }
                                    string = sb.toString();
                                    i4 = -1;
                                }
                                if (i == i4 || i2 == i4) {
                                    iFallbackOnLegacyTextField = HandwritingGestureApi34.fallbackOnLegacyTextField(WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m769m((Object) removeSpaceGestureM189m), recomposer$$ExternalSyntheticLambda0);
                                } else {
                                    int i12 = (int) (jM630getRangeForRect86BmAI >> c);
                                    recomposer$$ExternalSyntheticLambda0.invoke(new HandwritingGesture_androidKt$compoundEditCommand$1(new EditCommand[]{new SetSelectionCommand(i12 + i, i12 + i2), new CommitTextCommand(string.substring(i, string.length() - (TextRange.m642getLengthimpl(jM630getRangeForRect86BmAI) - i2)), 1)}));
                                    iFallbackOnLegacyTextField = 1;
                                }
                            }
                        } else {
                            iFallbackOnLegacyTextField = 2;
                        }
                    }
                } else {
                    iFallbackOnLegacyTextField = 3;
                }
            }
            if (intConsumer == null) {
                return;
            }
            if (executor != null) {
                executor.execute(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(iFallbackOnLegacyTextField, 3, intConsumer));
            } else {
                intConsumer.accept(iFallbackOnLegacyTextField);
            }
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z = this.isActive;
        if (z) {
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        LegacyTextFieldState legacyTextFieldState;
        AnnotatedString annotatedString;
        TextLayoutInput textLayoutInput;
        if (Build.VERSION.SDK_INT >= 34 && (legacyTextFieldState = this.legacyTextFieldState) != null && (annotatedString = legacyTextFieldState.untransformedText) != null) {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (annotatedString.equals((layoutResult == null || (textLayoutInput = layoutResult.value.layoutInput) == null) ? null : textLayoutInput.text)) {
                boolean zM193m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m193m((Object) previewableHandwritingGesture);
                HandleState handleState = HandleState.None;
                TextFieldSelectionManager textFieldSelectionManager = this.textFieldSelectionManager;
                if (zM193m) {
                    SelectGesture selectGestureM190m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m190m((Object) previewableHandwritingGesture);
                    if (textFieldSelectionManager != null) {
                        long jM197getRangeForScreenRectOH9lIzo = HandwritingGestureApi34.m197getRangeForScreenRectOH9lIzo(legacyTextFieldState, BrushKt.toComposeRect(selectGestureM190m.getSelectionArea()), selectGestureM190m.getGranularity() != 1 ? 0 : 1);
                        LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                        if (legacyTextFieldState2 != null) {
                            legacyTextFieldState2.m173setSelectionPreviewHighlightRange5zctL8(jM197getRangeForScreenRectOH9lIzo);
                        }
                        LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager.state;
                        if (legacyTextFieldState3 != null) {
                            legacyTextFieldState3.m172setDeletionPreviewHighlightRange5zctL8(TextRange.Zero);
                        }
                        if (!TextRange.m641getCollapsedimpl(jM197getRangeForScreenRectOH9lIzo)) {
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                        }
                    }
                } else if (EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$3(previewableHandwritingGesture)) {
                    DeleteGesture deleteGestureM = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m((Object) previewableHandwritingGesture);
                    if (textFieldSelectionManager != null) {
                        long jM197getRangeForScreenRectOH9lIzo2 = HandwritingGestureApi34.m197getRangeForScreenRectOH9lIzo(legacyTextFieldState, BrushKt.toComposeRect(deleteGestureM.getDeletionArea()), deleteGestureM.getGranularity() != 1 ? 0 : 1);
                        LegacyTextFieldState legacyTextFieldState4 = textFieldSelectionManager.state;
                        if (legacyTextFieldState4 != null) {
                            legacyTextFieldState4.m172setDeletionPreviewHighlightRange5zctL8(jM197getRangeForScreenRectOH9lIzo2);
                        }
                        LegacyTextFieldState legacyTextFieldState5 = textFieldSelectionManager.state;
                        if (legacyTextFieldState5 != null) {
                            legacyTextFieldState5.m173setSelectionPreviewHighlightRange5zctL8(TextRange.Zero);
                        }
                        if (!TextRange.m641getCollapsedimpl(jM197getRangeForScreenRectOH9lIzo2)) {
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                        }
                    }
                } else if (EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$4(previewableHandwritingGesture)) {
                    SelectRangeGesture selectRangeGestureM191m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m191m((Object) previewableHandwritingGesture);
                    if (textFieldSelectionManager != null) {
                        long jM195access$getRangeForScreenRectsO048IG0 = HandwritingGestureApi34.m195access$getRangeForScreenRectsO048IG0(legacyTextFieldState, BrushKt.toComposeRect(selectRangeGestureM191m.getSelectionStartArea()), BrushKt.toComposeRect(selectRangeGestureM191m.getSelectionEndArea()), selectRangeGestureM191m.getGranularity() != 1 ? 0 : 1);
                        LegacyTextFieldState legacyTextFieldState6 = textFieldSelectionManager.state;
                        if (legacyTextFieldState6 != null) {
                            legacyTextFieldState6.m173setSelectionPreviewHighlightRange5zctL8(jM195access$getRangeForScreenRectsO048IG0);
                        }
                        LegacyTextFieldState legacyTextFieldState7 = textFieldSelectionManager.state;
                        if (legacyTextFieldState7 != null) {
                            legacyTextFieldState7.m172setDeletionPreviewHighlightRange5zctL8(TextRange.Zero);
                        }
                        if (!TextRange.m641getCollapsedimpl(jM195access$getRangeForScreenRectsO048IG0)) {
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                        }
                    }
                } else if (EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$5(previewableHandwritingGesture)) {
                    DeleteRangeGesture deleteRangeGestureM186m = EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m186m((Object) previewableHandwritingGesture);
                    if (textFieldSelectionManager != null) {
                        long jM195access$getRangeForScreenRectsO048IG1 = HandwritingGestureApi34.m195access$getRangeForScreenRectsO048IG0(legacyTextFieldState, BrushKt.toComposeRect(deleteRangeGestureM186m.getDeletionStartArea()), BrushKt.toComposeRect(deleteRangeGestureM186m.getDeletionEndArea()), deleteRangeGestureM186m.getGranularity() != 1 ? 0 : 1);
                        LegacyTextFieldState legacyTextFieldState8 = textFieldSelectionManager.state;
                        if (legacyTextFieldState8 != null) {
                            legacyTextFieldState8.m172setDeletionPreviewHighlightRange5zctL8(jM195access$getRangeForScreenRectsO048IG1);
                        }
                        LegacyTextFieldState legacyTextFieldState9 = textFieldSelectionManager.state;
                        if (legacyTextFieldState9 != null) {
                            legacyTextFieldState9.m173setSelectionPreviewHighlightRange5zctL8(TextRange.Zero);
                        }
                        if (!TextRange.m641getCollapsedimpl(jM195access$getRangeForScreenRectsO048IG1)) {
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                        }
                    }
                }
                if (cancellationSignal != null) {
                    cancellationSignal.setOnCancelListener(new HandwritingGestureApi34$$ExternalSyntheticLambda31(0, textFieldSelectionManager));
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean reportFullscreenMode(boolean z) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0065 A[Catch: all -> 0x006f, TryCatch #0 {all -> 0x006f, blocks: (B:44:0x005b, B:46:0x0065, B:48:0x006b, B:51:0x0071), top: B:57:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:48:0x006b A[Catch: all -> 0x006f, TryCatch #0 {all -> 0x006f, blocks: (B:44:0x005b, B:46:0x0065, B:48:0x006b, B:51:0x0071), top: B:57:0x005b }] */
    /* JADX WARN: Code duplicated, block: B:57:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        LegacyCursorAnchorInfoController legacyCursorAnchorInfoController;
        boolean z4 = this.isActive;
        if (!z4) {
            return z4;
        }
        boolean z5 = false;
        boolean z6 = (i & 1) != 0;
        boolean z7 = (i & 2) != 0;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            z2 = (i & 16) != 0;
            z3 = (i & 8) != 0;
            boolean z8 = (i & 4) != 0;
            if (i2 >= 34 && (i & 32) != 0) {
                z5 = true;
            }
            if (z2 || z3 || z8 || z5) {
                z = z5;
                z5 = z8;
            } else {
                if (i2 >= 34) {
                    z = true;
                    z5 = true;
                } else {
                    z = z5;
                    z5 = true;
                }
                z2 = z5;
            }
            legacyCursorAnchorInfoController = ((LegacyTextInputMethodRequest) this.eventCallback.this$0).cursorAnchorInfoController;
            synchronized (legacyCursorAnchorInfoController.lock) {
                try {
                    legacyCursorAnchorInfoController.includeInsertionMarker = z2;
                    legacyCursorAnchorInfoController.includeCharacterBounds = z3;
                    legacyCursorAnchorInfoController.includeEditorBounds = z5;
                    legacyCursorAnchorInfoController.includeLineBounds = z;
                    if (z6) {
                        legacyCursorAnchorInfoController.hasPendingImmediateRequest = true;
                        if (legacyCursorAnchorInfoController.textFieldValue != null) {
                            legacyCursorAnchorInfoController.updateCursorAnchorInfo();
                        }
                    }
                    legacyCursorAnchorInfoController.monitorEnabled = z7;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        z = false;
        z2 = true;
        z3 = z2;
        legacyCursorAnchorInfoController = ((LegacyTextInputMethodRequest) this.eventCallback.this$0).cursorAnchorInfoController;
        synchronized (legacyCursorAnchorInfoController.lock) {
            legacyCursorAnchorInfoController.includeInsertionMarker = z2;
            legacyCursorAnchorInfoController.includeCharacterBounds = z3;
            legacyCursorAnchorInfoController.includeEditorBounds = z5;
            legacyCursorAnchorInfoController.includeLineBounds = z;
            if (z6) {
                legacyCursorAnchorInfoController.hasPendingImmediateRequest = true;
                if (legacyCursorAnchorInfoController.textFieldValue != null) {
                    legacyCursorAnchorInfoController.updateCursorAnchorInfo();
                }
            }
            legacyCursorAnchorInfoController.monitorEnabled = z7;
            Unit unit2 = Unit.INSTANCE;
            return true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, kotlin.Lazy] */
    @Override // android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        ((BaseInputConnection) ((LegacyTextInputMethodRequest) this.eventCallback.this$0).baseInputConnection$delegate.getValue()).sendKeyEvent(keyEvent);
        return true;
    }

    public final void sendSynthesizedKeyEvent(int i) {
        sendKeyEvent(new KeyEvent(0, i));
        sendKeyEvent(new KeyEvent(1, i));
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int i, int i2) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingRegionCommand(i, i2));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(charSequence), i));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setSelection(int i, int i2) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new SetSelectionCommand(i, i2));
        return true;
    }
}
