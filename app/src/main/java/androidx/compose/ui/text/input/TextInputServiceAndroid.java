package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$2$4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextInputServiceAndroid implements PlatformTextInputService {
    public final Object baseInputConnection$delegate;
    public final CursorAnchorInfoController cursorAnchorInfoController;
    public boolean editorHasFocus;
    public Rect focusedRect;
    public Preview$$ExternalSyntheticLambda0 frameCallback;
    public final ArrayList ics;
    public ImeOptions imeOptions;
    public final TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0 inputCommandProcessorExecutor;
    public final MenuHostHelper inputMethodManager;
    public Function1 onEditCommand;
    public Function1 onImeActionPerformed;
    public TextFieldValue state;
    public final MutableVector textInputCommandQueue;
    public final View view;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TextInputCommand {
        public static final /* synthetic */ TextInputCommand[] $VALUES;
        public static final TextInputCommand HideKeyboard;
        public static final TextInputCommand ShowKeyboard;
        public static final TextInputCommand StartInput;
        public static final TextInputCommand StopInput;

        static {
            TextInputCommand textInputCommand = new TextInputCommand("StartInput", 0);
            StartInput = textInputCommand;
            TextInputCommand textInputCommand2 = new TextInputCommand("StopInput", 1);
            StopInput = textInputCommand2;
            TextInputCommand textInputCommand3 = new TextInputCommand("ShowKeyboard", 2);
            ShowKeyboard = textInputCommand3;
            TextInputCommand textInputCommand4 = new TextInputCommand("HideKeyboard", 3);
            HideKeyboard = textInputCommand4;
            $VALUES = new TextInputCommand[]{textInputCommand, textInputCommand2, textInputCommand3, textInputCommand4};
        }

        public static TextInputCommand valueOf(String str) {
            return (TextInputCommand) Enum.valueOf(TextInputCommand.class, str);
        }

        public static TextInputCommand[] values() {
            return (TextInputCommand[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends Lambda implements Function1 {
        public static final AnonymousClass1 INSTANCE;
        public static final AnonymousClass1 INSTANCE$1;
        public static final AnonymousClass1 INSTANCE$2;
        public static final AnonymousClass1 INSTANCE$3;
        public static final AnonymousClass1 INSTANCE$4;
        public static final AnonymousClass1 INSTANCE$5;
        public final /* synthetic */ int $r8$classId;

        static {
            int i = 1;
            INSTANCE$1 = new AnonymousClass1(i, 1);
            INSTANCE$2 = new AnonymousClass1(i, 2);
            INSTANCE$3 = new AnonymousClass1(i, 3);
            INSTANCE$4 = new AnonymousClass1(i, 4);
            INSTANCE = new AnonymousClass1(i, 0);
            INSTANCE$5 = new AnonymousClass1(i, 5);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, int i2) {
            super(i);
            this.$r8$classId = i2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Object invoke(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    break;
                case 1:
                    float[] fArr = ((Matrix) obj).values;
                    break;
                case 2:
                    float[] fArr2 = ((Matrix) obj).values;
                    break;
                case 3:
                    break;
                case 4:
                    int i = ((ImeAction) obj).value;
                    break;
                default:
                    int i2 = ((ImeAction) obj).value;
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public TextInputServiceAndroid(View view, AndroidComposeView androidComposeView) {
        MenuHostHelper menuHostHelper = new MenuHostHelper(view);
        TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0 textInputServiceAndroid_androidKt$$ExternalSyntheticLambda0 = new TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0(Choreographer.getInstance());
        this.view = view;
        this.inputMethodManager = menuHostHelper;
        this.inputCommandProcessorExecutor = textInputServiceAndroid_androidKt$$ExternalSyntheticLambda0;
        this.onEditCommand = AnonymousClass1.INSTANCE$3;
        this.onImeActionPerformed = AnonymousClass1.INSTANCE$4;
        this.state = new TextFieldValue(4, TextRange.Zero, "");
        this.imeOptions = ImeOptions.Default;
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt__LazyJVMKt.lazy(3, new Handshake.AnonymousClass2(15, this));
        this.cursorAnchorInfoController = new CursorAnchorInfoController(androidComposeView, menuHostHelper);
        this.textInputCommandQueue = new MutableVector(new TextInputCommand[16]);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void hideSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.HideKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        this.focusedRect = new Rect(MathKt.roundToInt(rect.left), MathKt.roundToInt(rect.top), MathKt.roundToInt(rect.right), MathKt.roundToInt(rect.bottom));
        if (!this.ics.isEmpty() || (rect2 = this.focusedRect) == null) {
            return;
        }
        this.view.requestRectangleOnScreen(new Rect(rect2));
    }

    public final void sendInputCommand(TextInputCommand textInputCommand) {
        this.textInputCommandQueue.add(textInputCommand);
        if (this.frameCallback == null) {
            Preview$$ExternalSyntheticLambda0 preview$$ExternalSyntheticLambda0 = new Preview$$ExternalSyntheticLambda0(29, this);
            this.inputCommandProcessorExecutor.execute(preview$$ExternalSyntheticLambda0);
            this.frameCallback = preview$$ExternalSyntheticLambda0;
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void showSoftwareKeyboard() {
        sendInputCommand(TextInputCommand.ShowKeyboard);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, LifecycleEffectKt$$ExternalSyntheticLambda1 lifecycleEffectKt$$ExternalSyntheticLambda1, CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4) {
        this.editorHasFocus = true;
        this.state = textFieldValue;
        this.imeOptions = imeOptions;
        this.onEditCommand = lifecycleEffectKt$$ExternalSyntheticLambda1;
        this.onImeActionPerformed = coreTextFieldKt$$ExternalSyntheticLambda4;
        sendInputCommand(TextInputCommand.StartInput);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = AnonymousClass1.INSTANCE;
        this.onImeActionPerformed = AnonymousClass1.INSTANCE$5;
        this.focusedRect = null;
        sendInputCommand(TextInputCommand.StopInput);
    }

    /* JADX WARN: Type inference failed for: r14v14, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r14v22, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, kotlin.Lazy] */
    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        boolean z = (TextRange.m640equalsimpl0(this.state.selection, textFieldValue2.selection) && Intrinsics.areEqual(this.state.composition, textFieldValue2.composition)) ? false : true;
        this.state = textFieldValue2;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = (RecordingInputConnection) ((WeakReference) this.ics.get(i)).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.mTextFieldValue = textFieldValue2;
            }
        }
        CursorAnchorInfoController cursorAnchorInfoController = this.cursorAnchorInfoController;
        synchronized (cursorAnchorInfoController.lock) {
            cursorAnchorInfoController.textFieldValue = null;
            cursorAnchorInfoController.offsetMapping = null;
            cursorAnchorInfoController.textLayoutResult = null;
            cursorAnchorInfoController.textFieldToRootTransform = AnonymousClass1.INSTANCE$1;
            cursorAnchorInfoController.innerTextFieldBounds = null;
            cursorAnchorInfoController.decorationBoxBounds = null;
            Unit unit = Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
            if (z) {
                MenuHostHelper menuHostHelper = this.inputMethodManager;
                int iM644getMinimpl = TextRange.m644getMinimpl(textFieldValue2.selection);
                int iM643getMaximpl = TextRange.m643getMaximpl(textFieldValue2.selection);
                TextRange textRange = this.state.composition;
                int iM644getMinimpl2 = textRange != null ? TextRange.m644getMinimpl(textRange.packedValue) : -1;
                TextRange textRange2 = this.state.composition;
                ((InputMethodManager) menuHostHelper.mMenuProviders.getValue()).updateSelection((View) menuHostHelper.mOnInvalidateMenuCallback, iM644getMinimpl, iM643getMaximpl, iM644getMinimpl2, textRange2 != null ? TextRange.m643getMaximpl(textRange2.packedValue) : -1);
                return;
            }
            return;
        }
        if (textFieldValue != null && (!Intrinsics.areEqual(textFieldValue.annotatedString.text, textFieldValue2.annotatedString.text) || (TextRange.m640equalsimpl0(textFieldValue.selection, textFieldValue2.selection) && !Intrinsics.areEqual(textFieldValue.composition, textFieldValue2.composition)))) {
            MenuHostHelper menuHostHelper2 = this.inputMethodManager;
            ((InputMethodManager) menuHostHelper2.mMenuProviders.getValue()).restartInput((View) menuHostHelper2.mOnInvalidateMenuCallback);
            return;
        }
        int size2 = this.ics.size();
        for (int i2 = 0; i2 < size2; i2++) {
            RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) ((WeakReference) this.ics.get(i2)).get();
            if (recordingInputConnection2 != null) {
                TextFieldValue textFieldValue3 = this.state;
                MenuHostHelper menuHostHelper3 = this.inputMethodManager;
                if (recordingInputConnection2.isActive) {
                    recordingInputConnection2.mTextFieldValue = textFieldValue3;
                    if (recordingInputConnection2.extractedTextMonitorMode) {
                        ((InputMethodManager) menuHostHelper3.mMenuProviders.getValue()).updateExtractedText((View) menuHostHelper3.mOnInvalidateMenuCallback, recordingInputConnection2.currentExtractedTextRequestToken, InputState_androidKt.toExtractedText(textFieldValue3));
                    }
                    TextRange textRange3 = textFieldValue3.composition;
                    long j = textFieldValue3.selection;
                    int iM644getMinimpl3 = textRange3 != null ? TextRange.m644getMinimpl(textRange3.packedValue) : -1;
                    TextRange textRange4 = textFieldValue3.composition;
                    ((InputMethodManager) menuHostHelper3.mMenuProviders.getValue()).updateSelection((View) menuHostHelper3.mOnInvalidateMenuCallback, TextRange.m644getMinimpl(j), TextRange.m643getMaximpl(j), iM644getMinimpl3, textRange4 != null ? TextRange.m643getMaximpl(textRange4.packedValue) : -1);
                }
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, RenderScriptBlurEffect$updateSurface$2$4 renderScriptBlurEffect$updateSurface$2$4, androidx.compose.ui.geometry.Rect rect, androidx.compose.ui.geometry.Rect rect2) {
        CursorAnchorInfoController cursorAnchorInfoController = this.cursorAnchorInfoController;
        synchronized (cursorAnchorInfoController.lock) {
            try {
                cursorAnchorInfoController.textFieldValue = textFieldValue;
                cursorAnchorInfoController.offsetMapping = offsetMapping;
                cursorAnchorInfoController.textLayoutResult = textLayoutResult;
                cursorAnchorInfoController.textFieldToRootTransform = renderScriptBlurEffect$updateSurface$2$4;
                cursorAnchorInfoController.innerTextFieldBounds = rect;
                cursorAnchorInfoController.decorationBoxBounds = rect2;
                if (cursorAnchorInfoController.hasPendingImmediateRequest || cursorAnchorInfoController.monitorEnabled) {
                    cursorAnchorInfoController.updateCursorAnchorInfo();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void startInput() {
        sendInputCommand(TextInputCommand.StartInput);
    }
}
