package androidx.compose.foundation.text;

import androidx.camera.core.SurfaceRequest;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UndoManager {
    public boolean forceNextSnapshot;
    public Long lastSnapshot;
    public SurfaceRequest.AnonymousClass1 redoStack;
    public int storedCharacters;
    public SurfaceRequest.AnonymousClass1 undoStack;

    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
    public final void makeSnapshot(TextFieldValue textFieldValue) {
        SurfaceRequest.AnonymousClass1 anonymousClass1;
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        this.forceNextSnapshot = false;
        SurfaceRequest.AnonymousClass1 anonymousClass2 = this.undoStack;
        if (textFieldValue.equals(anonymousClass2 != null ? (TextFieldValue) anonymousClass2.val$requestCancellationFuture : null)) {
            return;
        }
        String str = annotatedString.text;
        SurfaceRequest.AnonymousClass1 anonymousClass3 = this.undoStack;
        if (Intrinsics.areEqual(str, anonymousClass3 != null ? ((TextFieldValue) anonymousClass3.val$requestCancellationFuture).annotatedString.text : null)) {
            SurfaceRequest.AnonymousClass1 anonymousClass4 = this.undoStack;
            if (anonymousClass4 != null) {
                anonymousClass4.val$requestCancellationFuture = textFieldValue;
                return;
            }
            return;
        }
        this.undoStack = new SurfaceRequest.AnonymousClass1(25, this.undoStack, textFieldValue, false);
        this.redoStack = null;
        int length = annotatedString.text.length() + this.storedCharacters;
        this.storedCharacters = length;
        if (length > 100000) {
            SurfaceRequest.AnonymousClass1 anonymousClass5 = this.undoStack;
            if ((anonymousClass5 != null ? (SurfaceRequest.AnonymousClass1) anonymousClass5.val$requestCancellationCompleter : null) == null) {
                return;
            }
            while (true) {
                if (anonymousClass5 == null) {
                    anonymousClass1 = null;
                } else {
                    SurfaceRequest.AnonymousClass1 anonymousClass6 = (SurfaceRequest.AnonymousClass1) anonymousClass5.val$requestCancellationCompleter;
                    if (anonymousClass6 != null) {
                        anonymousClass1 = (SurfaceRequest.AnonymousClass1) anonymousClass6.val$requestCancellationCompleter;
                    } else {
                        anonymousClass1 = null;
                    }
                }
                if (anonymousClass1 == null) {
                    break;
                } else {
                    anonymousClass5 = (SurfaceRequest.AnonymousClass1) anonymousClass5.val$requestCancellationCompleter;
                }
            }
            if (anonymousClass5 != null) {
                anonymousClass5.val$requestCancellationCompleter = null;
            }
        }
    }
}
