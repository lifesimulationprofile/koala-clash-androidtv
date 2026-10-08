package androidx.compose.foundation.text;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.EditingBuffer;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.MenuHostHelper;
import coil.request.RequestService;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyTextFieldState {
    public LayoutCoordinates _layoutCoordinates;
    public final ParcelableSnapshotMutableState autofillHighlightOn$delegate;
    public final ParcelableSnapshotMutableState deletionPreviewHighlightRange$delegate;
    public final ParcelableSnapshotMutableState handleState$delegate;
    public final ParcelableSnapshotMutableState hasFocus$delegate;
    public final AndroidPaint highlightPaint;
    public TextInputSession inputSession;
    public final ParcelableSnapshotMutableState isInTouchMode$delegate;
    public boolean isLayoutResultStale;
    public final ParcelableSnapshotMutableState justAutofilled$delegate;
    public final MenuHostHelper keyboardActionRunner;
    public final SoftwareKeyboardController keyboardController;
    public final ParcelableSnapshotMutableState layoutResultState;
    public final ParcelableSnapshotMutableState minHeightForSingleLineField$delegate;
    public final CoreTextFieldKt$$ExternalSyntheticLambda4 onImeActionPerformed;
    public final CoreTextFieldKt$$ExternalSyntheticLambda4 onImeActionPerformedWithResult;
    public final CoreTextFieldKt$$ExternalSyntheticLambda4 onValueChange;
    public Function1 onValueChangeOriginal;
    public final RequestService processor;
    public final RecomposeScopeImpl recomposeScope;
    public long selectionBackgroundColor;
    public final ParcelableSnapshotMutableState selectionPreviewHighlightRange$delegate;
    public final ParcelableSnapshotMutableState showCursorHandle$delegate;
    public final ParcelableSnapshotMutableState showFloatingToolbar$delegate;
    public final ParcelableSnapshotMutableState showSelectionHandleEnd$delegate;
    public final ParcelableSnapshotMutableState showSelectionHandleStart$delegate;
    public TextDelegate textDelegate;
    public AnnotatedString untransformedText;

    public LegacyTextFieldState(TextDelegate textDelegate, RecomposeScopeImpl recomposeScopeImpl, SoftwareKeyboardController softwareKeyboardController) {
        this.textDelegate = textDelegate;
        this.recomposeScope = recomposeScopeImpl;
        this.keyboardController = softwareKeyboardController;
        RequestService requestService = new RequestService(11, false);
        AnnotatedString annotatedString = AnnotatedStringKt.EmptyAnnotatedString;
        long j = TextRange.Zero;
        TextFieldValue textFieldValue = new TextFieldValue(annotatedString, j, (TextRange) null);
        requestService.systemCallbacks = textFieldValue;
        requestService.hardwareBitmapService = new EditingBuffer(annotatedString, textFieldValue.selection);
        this.processor = requestService;
        Boolean bool = Boolean.FALSE;
        this.hasFocus$delegate = Stack.mutableStateOf$default(bool);
        this.minHeightForSingleLineField$delegate = Stack.mutableStateOf$default(new Dp(0));
        this.layoutResultState = Stack.mutableStateOf$default(null);
        this.handleState$delegate = Stack.mutableStateOf$default(HandleState.None);
        this.showFloatingToolbar$delegate = Stack.mutableStateOf$default(bool);
        this.showSelectionHandleStart$delegate = Stack.mutableStateOf$default(bool);
        this.showSelectionHandleEnd$delegate = Stack.mutableStateOf$default(bool);
        this.showCursorHandle$delegate = Stack.mutableStateOf$default(bool);
        this.isLayoutResultStale = true;
        this.isInTouchMode$delegate = Stack.mutableStateOf$default(Boolean.TRUE);
        this.keyboardActionRunner = new MenuHostHelper(softwareKeyboardController);
        this.autofillHighlightOn$delegate = Stack.mutableStateOf$default(bool);
        this.justAutofilled$delegate = Stack.mutableStateOf$default(bool);
        this.onValueChangeOriginal = new BasicTextKt$$ExternalSyntheticLambda3(20);
        this.onValueChange = new CoreTextFieldKt$$ExternalSyntheticLambda4(this, 1);
        this.onImeActionPerformed = new CoreTextFieldKt$$ExternalSyntheticLambda4(this, 2);
        this.onImeActionPerformedWithResult = new CoreTextFieldKt$$ExternalSyntheticLambda4(this, 3);
        this.highlightPaint = BrushKt.Paint();
        this.selectionBackgroundColor = Color.Unspecified;
        this.selectionPreviewHighlightRange$delegate = Stack.mutableStateOf$default(new TextRange(j));
        this.deletionPreviewHighlightRange$delegate = Stack.mutableStateOf$default(new TextRange(j));
    }

    public final HandleState getHandleState() {
        return (HandleState) this.handleState$delegate.getValue();
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this._layoutCoordinates;
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    public final TextLayoutResultProxy getLayoutResult() {
        return (TextLayoutResultProxy) this.layoutResultState.getValue();
    }

    /* JADX INFO: renamed from: setDeletionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m172setDeletionPreviewHighlightRange5zctL8(long j) {
        this.deletionPreviewHighlightRange$delegate.setValue(new TextRange(j));
    }

    /* JADX INFO: renamed from: setSelectionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m173setSelectionPreviewHighlightRange5zctL8(long j) {
        this.selectionPreviewHighlightRange$delegate.setValue(new TextRange(j));
    }
}
