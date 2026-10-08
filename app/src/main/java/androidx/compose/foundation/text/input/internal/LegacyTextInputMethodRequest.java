package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyTextInputMethodRequest {
    public final LegacyCursorAnchorInfoController cursorAnchorInfoController;
    public Rect focusedRect;
    public final ContentCaptureSessionCompat inputMethodManager;
    public LegacyTextFieldState legacyTextFieldState;
    public TextFieldSelectionManager textFieldSelectionManager;
    public final View view;
    public ViewConfiguration viewConfiguration;
    public Function1 onEditCommand = new SaversKt$$ExternalSyntheticLambda10(1);
    public Function1 onImeActionPerformed = new SaversKt$$ExternalSyntheticLambda10(2);
    public TextFieldValue state = new TextFieldValue(4, TextRange.Zero, "");
    public ImeOptions imeOptions = ImeOptions.Default;
    public final ArrayList ics = new ArrayList();
    public final Object baseInputConnection$delegate = LazyKt__LazyJVMKt.lazy(3, new BasicTextKt$$ExternalSyntheticLambda0(16, this));

    public LegacyTextInputMethodRequest(View view, AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1 androidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1, ContentCaptureSessionCompat contentCaptureSessionCompat) {
        this.view = view;
        this.inputMethodManager = contentCaptureSessionCompat;
        this.cursorAnchorInfoController = new LegacyCursorAnchorInfoController(androidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1, contentCaptureSessionCompat);
    }

    public final RecordingInputConnection createInputConnection(EditorInfo editorInfo) {
        int i;
        int i2;
        TextFieldValue textFieldValue = this.state;
        String str = textFieldValue.annotatedString.text;
        long j = textFieldValue.selection;
        ImeOptions imeOptions = this.imeOptions;
        int i3 = imeOptions.imeAction;
        int i4 = imeOptions.keyboardType;
        boolean z = imeOptions.singleLine;
        if (i3 == 1) {
            i = z ? 6 : 0;
        } else if (i3 == 0) {
            i = 1;
        } else if (i3 == 2) {
            i = 2;
        } else if (i3 == 6) {
            i = 5;
        } else if (i3 == 5) {
            i = 7;
        } else if (i3 == 3) {
            i = 3;
        } else if (i3 == 4) {
            i = 4;
        } else {
            if (i3 != 7) {
                throw new IllegalStateException("invalid ImeAction");
            }
        }
        editorInfo.imeOptions = i;
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = imeOptions.hintLocales;
            if (Intrinsics.areEqual(localeList, LocaleList.Empty)) {
                editorInfo.hintLocales = null;
            } else {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10));
                Iterator it = localeList.localeList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Locale) it.next()).platformLocale);
                }
                java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
                editorInfo.hintLocales = LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length));
            }
        }
        if (i4 == 1) {
            i2 = 1;
        } else if (i4 == 2) {
            editorInfo.imeOptions |= Integer.MIN_VALUE;
            i2 = 1;
        } else if (i4 == 3) {
            i2 = 2;
        } else if (i4 == 4) {
            i2 = 3;
        } else if (i4 == 5) {
            i2 = 17;
        } else if (i4 == 6) {
            i2 = 33;
        } else if (i4 == 7) {
            i2 = 129;
        } else if (i4 == 8) {
            i2 = 18;
        } else {
            if (i4 != 9) {
                throw new IllegalStateException("Invalid Keyboard Type");
            }
            i2 = 8194;
        }
        editorInfo.inputType = i2;
        if (!z && (i2 & 1) == 1) {
            editorInfo.inputType = 131072 | i2;
            if (imeOptions.imeAction == 1) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        int i5 = editorInfo.inputType;
        if ((i5 & 1) == 1) {
            int i6 = imeOptions.capitalization;
            if (i6 == 1) {
                editorInfo.inputType = i5 | 4096;
            } else if (i6 == 2) {
                editorInfo.inputType = i5 | 8192;
            } else if (i6 == 3) {
                editorInfo.inputType = i5 | 16384;
            }
            if (imeOptions.autoCorrect) {
                editorInfo.inputType |= 32768;
            }
        }
        int i7 = TextRange.$r8$clinit;
        editorInfo.initialSelStart = (int) (j >> 32);
        editorInfo.initialSelEnd = (int) (j & 4294967295L);
        EditorInfoCompat.setInitialSurroundingText(editorInfo, str);
        editorInfo.imeOptions |= 33554432;
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported || i4 == 7 || i4 == 8) {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
        } else {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, true);
            editorInfo.setSupportedHandwritingGestures(AppCompatHintHelper.listOf(EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m192m(), EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$3(), EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$1(), EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$2(), EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$4(), EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$5(), EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$6()));
            editorInfo.setSupportedHandwritingGesturePreviews(ArraysKt.toSet(new Class[]{EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m192m(), EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$3(), EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$1(), EditorInfoApi34$$ExternalSyntheticApiModelOutline0.m$2()}));
        }
        LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 legacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 = LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory;
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new Toolbar.AnonymousClass1(28, this), this.imeOptions.autoCorrect, this.legacyTextFieldState, this.textFieldSelectionManager, this.viewConfiguration);
        this.ics.add(new WeakReference(recordingInputConnection));
        return recordingInputConnection;
    }
}
