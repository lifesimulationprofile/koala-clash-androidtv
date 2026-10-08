package androidx.compose.foundation.text;

import android.text.Spanned;
import android.view.KeyEvent;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifierKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifier;
import androidx.compose.foundation.text.input.internal.HandwritingGestureApi34;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$3;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$cut$1;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda14;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ScrimKt$Scrim$dismissModifier$1$1;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda5;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.ThumbNode;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.TooltipStateImpl$show$cancellableShow$1;
import androidx.compose.runtime.BroadcastFrameClock$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerHoverIconModifierElement;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.input.EditingBuffer;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessLookupCallback;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import androidx.navigation.NavOptions;
import coil.RealImageLoader$executeMain$result$1;
import coil.request.RequestService;
import coil.util.ContinuationCallback;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda10;
import com.github.kr328.clash.LogcatActivity$$ExternalSyntheticLambda4;
import com.github.kr328.clash.LogcatActivity$writeLogTo$2$1;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BasicTextKt {
    public static final int AltShift = 9;
    public static final int CtrlShift = 10;
    public static final int ShiftMeta = 12;
    public static final PreviewView.AnonymousClass1 defaultKeyMapping = new PreviewView.AnonymousClass1(28, new KeyMappingKt$commonKeyMapping$1(0));
    public static final KeyMappingKt$commonKeyMapping$1 platformDefaultKeyMapping = new KeyMappingKt$commonKeyMapping$1(1);
    public static final AndroidPointerIconType handwritingPointerIcon = new AndroidPointerIconType(1022);
    public static final NavOptions.Builder ValidatingEmptyOffsetMappingIdentity = new NavOptions.Builder(0, 0);

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 7671. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    /* JADX INFO: renamed from: BasicText-RWo7tUw, reason: not valid java name */
    public static final void m166BasicTextRWo7tUw(java.lang.String r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.text.TextStyle r28, int r29, boolean r30, int r31, int r32, androidx.compose.runtime.GapComposer r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 767
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m166BasicTextRWo7tUw(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, int, boolean, int, int, androidx.compose.runtime.GapComposer, int, int):void");
    }

    public static final void CommonContextMenuArea(TextFieldSelectionManager textFieldSelectionManager, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        Modifier modifierTextContextMenuToolbarHandler;
        gapComposer.startRestartGroup(1533506138);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.startReplaceGroup(-885604480);
            if (textFieldSelectionManager.getEnabled()) {
                Continuation continuation = null;
                modifierTextContextMenuToolbarHandler = TextContextMenuModifierKt.textContextMenuToolbarHandler(TextContextMenuModifierKt.showTextContextMenuOnSecondaryClick(new TextFieldSelectionManager$cut$1(textFieldSelectionManager, continuation, 1)), textFieldSelectionManager.toolbarRequester, new TooltipStateImpl$show$cancellableShow$1(textFieldSelectionManager, continuation, 2), new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager, continuation, 0), new CoreTextFieldKt$$ExternalSyntheticLambda10(textFieldSelectionManager, 2));
            } else {
                modifierTextContextMenuToolbarHandler = Modifier.Companion.$$INSTANCE;
            }
            AndroidTextContextMenuToolbarProvider_androidKt.ProvideDefaultPlatformTextContextMenuProviders(modifierTextContextMenuToolbarHandler, composableLambdaImpl, gapComposer, i2 & 112);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ContextMenu_androidKt$$ExternalSyntheticLambda1(textFieldSelectionManager, composableLambdaImpl, i, 1);
        }
    }

    public static final void ContextMenuArea(TextFieldSelectionManager textFieldSelectionManager, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(2080741862);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            CommonContextMenuArea(textFieldSelectionManager, composableLambdaImpl, gapComposer, i2 & 126);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ContextMenu_androidKt$$ExternalSyntheticLambda1(textFieldSelectionManager, composableLambdaImpl, i, 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:217:0x0443  */
    /* JADX WARN: Code duplicated, block: B:218:0x044c  */
    /* JADX WARN: Code duplicated, block: B:220:0x0454  */
    /* JADX WARN: Code duplicated, block: B:227:0x0471  */
    /* JADX WARN: Code duplicated, block: B:230:0x0489  */
    /* JADX WARN: Code duplicated, block: B:233:0x0494  */
    /* JADX WARN: Code duplicated, block: B:236:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:238:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:241:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:244:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:247:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:250:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:253:0x0562  */
    /* JADX WARN: Code duplicated, block: B:254:0x0564  */
    /* JADX WARN: Code duplicated, block: B:257:0x056e  */
    /* JADX WARN: Code duplicated, block: B:258:0x0570  */
    /* JADX WARN: Code duplicated, block: B:261:0x0580  */
    /* JADX WARN: Code duplicated, block: B:262:0x0583  */
    /* JADX WARN: Code duplicated, block: B:276:0x05de  */
    /* JADX WARN: Code duplicated, block: B:283:0x0643  */
    /* JADX WARN: Code duplicated, block: B:285:0x0649 A[PHI: r33
      0x0649: PHI (r33v4 androidx.compose.foundation.text.LegacyTextFieldState) = 
      (r33v2 androidx.compose.foundation.text.LegacyTextFieldState)
      (r33v6 androidx.compose.foundation.text.LegacyTextFieldState)
     binds: [B:284:0x0647, B:282:0x0640] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:286:0x064b  */
    /* JADX WARN: Code duplicated, block: B:289:0x0654 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:292:0x0668  */
    /* JADX WARN: Code duplicated, block: B:295:0x06b1  */
    /* JADX WARN: Code duplicated, block: B:296:0x06bc  */
    /* JADX WARN: Code duplicated, block: B:299:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:300:0x06f2  */
    /* JADX WARN: Code duplicated, block: B:303:0x0705  */
    /* JADX WARN: Code duplicated, block: B:304:0x0707  */
    /* JADX WARN: Code duplicated, block: B:307:0x0714 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:310:0x071b  */
    /* JADX WARN: Code duplicated, block: B:313:0x074c  */
    /* JADX WARN: Code duplicated, block: B:321:0x0781  */
    /* JADX WARN: Code duplicated, block: B:323:0x0784  */
    /* JADX WARN: Code duplicated, block: B:324:0x079c  */
    /* JADX WARN: Code duplicated, block: B:327:0x07ab A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:328:0x07ad  */
    /* JADX WARN: Code duplicated, block: B:331:0x07c7  */
    /* JADX WARN: Code duplicated, block: B:332:0x07c9  */
    /* JADX WARN: Code duplicated, block: B:335:0x07cf  */
    /* JADX WARN: Code duplicated, block: B:337:0x07d5  */
    /* JADX WARN: Code duplicated, block: B:343:0x07e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:346:0x07e8  */
    /* JADX WARN: Code duplicated, block: B:349:0x0804  */
    /* JADX WARN: Code duplicated, block: B:350:0x0806  */
    /* JADX WARN: Code duplicated, block: B:354:0x0825  */
    /* JADX WARN: Code duplicated, block: B:356:0x0829  */
    /* JADX WARN: Code duplicated, block: B:360:0x0847 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:361:0x0849  */
    /* JADX WARN: Code duplicated, block: B:364:0x0876  */
    /* JADX WARN: Code duplicated, block: B:367:0x088a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:368:0x088c  */
    /* JADX WARN: Code duplicated, block: B:371:0x0905  */
    /* JADX WARN: Code duplicated, block: B:378:0x092c  */
    /* JADX WARN: Code duplicated, block: B:380:0x092f  */
    /* JADX WARN: Code duplicated, block: B:385:0x0942  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void CoreTextField(final TextFieldValue textFieldValue, Function1 function1, Modifier modifier, TextStyle textStyle, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0, Function1 function2, final MutableInteractionSourceImpl mutableInteractionSourceImpl, SolidColor solidColor, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, final boolean z2, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i3, int i4) {
        int i5;
        int i6;
        GapComposer gapComposer2;
        int i7;
        TextRange textRange;
        boolean z3;
        TextStyle textStyle2;
        TextRange textRange2;
        Density density;
        FontFamily$Resolver fontFamily$Resolver;
        Density density2;
        long j;
        boolean z4;
        boolean z5;
        long j2;
        TextFieldValue textFieldValue2;
        TextFieldValue textFieldValueM663copy3r_uNRQ$default;
        TextFieldValue textFieldValue3;
        Object objRememberedValue;
        final UndoManager undoManager;
        long jCurrentTimeMillis;
        Object objRememberedValue2;
        final CoroutineScope coroutineScope;
        Object objRememberedValue3;
        final BringIntoViewRequesterImpl bringIntoViewRequesterImpl;
        Object objRememberedValue4;
        final TextFieldSelectionManager textFieldSelectionManager;
        int i8;
        boolean z6;
        boolean z7;
        int i9;
        boolean z8;
        int i10;
        boolean zChangedInstance;
        Object obj;
        GapComposer gapComposer3;
        final TextInputService textInputService;
        final ImeOptions imeOptions2;
        boolean z9;
        TextFieldValue textFieldValue4;
        Modifier.Companion companion;
        MutableState mutableStateRememberUpdatedState;
        Unit unit;
        LegacyTextFieldState legacyTextFieldState;
        boolean z10;
        boolean z11;
        Object realImageLoader$executeMain$result$1;
        Unit unit2;
        CoroutineScope coroutineScope2;
        LegacyTextFieldState legacyTextFieldState2;
        MutableState mutableState;
        Modifier suspendPointerInputElement;
        MenuKt$$ExternalSyntheticLambda0 menuKt$$ExternalSyntheticLambda0;
        int i11;
        boolean z12;
        boolean z13;
        boolean zChangedInstance2;
        Object objRememberedValue5;
        OffsetMapping offsetMapping;
        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier;
        OffsetMapping offsetMapping2;
        TextInputService textInputService2;
        final TextFieldSelectionManager textFieldSelectionManager2;
        final LegacyTextFieldState legacyTextFieldState3;
        boolean z14;
        OffsetMapping offsetMapping3;
        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier2;
        Modifier modifierThen;
        boolean zChangedInstance3;
        Object objRememberedValue6;
        boolean z15;
        boolean z16;
        Object objRememberedValue7;
        ImeOptions imeOptions3;
        final boolean z17;
        int i12;
        boolean z18;
        boolean zChanged;
        Object objRememberedValue8;
        Object solidColor2;
        long j3;
        boolean zChangedInstance4;
        Object objRememberedValue9;
        int i13;
        Modifier modifierThen2;
        Long l;
        long j4 = textFieldValue.selection;
        TextRange textRange3 = textFieldValue.composition;
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        gapComposer.startRestartGroup(31062401);
        if ((i3 & 6) == 0) {
            i5 = i3 | (gapComposer.changed(textFieldValue) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= gapComposer.changed(textStyle) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= gapComposer.changed(zslControlImpl$$ExternalSyntheticLambda0) ? 16384 : 8192;
        }
        if ((i3 & 196608) == 0) {
            i5 |= gapComposer.changedInstance(function2) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= gapComposer.changed(mutableInteractionSourceImpl) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= gapComposer.changed(solidColor) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= gapComposer.changed(z) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= gapComposer.changed(i) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (gapComposer.changed(i2) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= gapComposer.changed(imeOptions) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= gapComposer.changed(keyboardActions) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i6 |= gapComposer.changed(z2) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= gapComposer.changed(false) ? 16384 : 8192;
        }
        if ((i4 & 196608) == 0) {
            i6 |= gapComposer.changedInstance(composableLambdaImpl) ? 131072 : 65536;
        }
        int i14 = i6 | 1572864;
        if (gapComposer.shouldExecute(i5 & 1, ((i5 & 306783379) == 306783378 && (599187 & i14) == 599186) ? false : true)) {
            gapComposer.startDefaults();
            if ((i3 & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            Object objRememberedValue10 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = new FocusRequester();
                gapComposer.updateRememberedValue(objRememberedValue10);
            }
            FocusRequester focusRequester = (FocusRequester) objRememberedValue10;
            Object objRememberedValue11 = gapComposer.rememberedValue();
            if (objRememberedValue11 == neverEqualPolicy) {
                LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 legacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 = LegacyPlatformTextInputServiceAdapter_androidKt.inputMethodManagerFactory;
                objRememberedValue11 = new AndroidLegacyPlatformTextInputServiceAdapter();
                gapComposer.updateRememberedValue(objRememberedValue11);
            }
            AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter = (AndroidLegacyPlatformTextInputServiceAdapter) objRememberedValue11;
            Object objRememberedValue12 = gapComposer.rememberedValue();
            if (objRememberedValue12 == neverEqualPolicy) {
                objRememberedValue12 = new TextInputService(androidLegacyPlatformTextInputServiceAdapter);
                gapComposer.updateRememberedValue(objRememberedValue12);
            }
            TextInputService textInputService3 = (TextInputService) objRememberedValue12;
            Density density3 = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            FontFamily$Resolver fontFamily$Resolver2 = (FontFamily$Resolver) gapComposer.consume(CompositionLocalsKt.LocalFontFamilyResolver);
            long j5 = ((TextSelectionColors) gapComposer.consume(TextSelectionColorsKt.LocalTextSelectionColors)).backgroundColor;
            FocusOwner focusOwner = (FocusOwner) gapComposer.consume(CompositionLocalsKt.LocalFocusManager);
            WindowInfo windowInfo = (WindowInfo) gapComposer.consume(CompositionLocalsKt.LocalWindowInfo);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            Orientation orientation = Orientation.Vertical;
            Orientation orientation2 = (i == 1 && !z && imeOptions.singleLine) ? Orientation.Horizontal : orientation;
            gapComposer.startReplaceGroup(-213744626);
            Object[] objArr = {orientation2};
            RequestService requestService = TextFieldScrollerPosition.Saver;
            boolean zChanged2 = gapComposer.changed(orientation2.ordinal());
            Object objRememberedValue13 = gapComposer.rememberedValue();
            int i15 = 10;
            if (zChanged2 || objRememberedValue13 == neverEqualPolicy) {
                objRememberedValue13 = new BasicTextKt$$ExternalSyntheticLambda0(i15, orientation2);
                gapComposer.updateRememberedValue(objRememberedValue13);
            }
            final TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) SaverKt.rememberSaveable(objArr, requestService, (Function0) objRememberedValue13, gapComposer, 0);
            gapComposer.end(false);
            if (((Orientation) textFieldScrollerPosition.orientation$delegate.getValue()) != orientation2) {
                throw new IllegalArgumentException("Mismatching scroller orientation; ".concat(orientation2 == orientation ? "only single-line, non-wrap text fields can scroll horizontally" : "single-line, non-wrap text fields can only scroll horizontally"));
            }
            int i16 = i5 & 14;
            boolean z19 = (i16 == 4) | ((i5 & 57344) == 16384);
            Object objRememberedValue14 = gapComposer.rememberedValue();
            if (z19 || objRememberedValue14 == neverEqualPolicy) {
                TransformedText transformedTextFilterWithValidation = filterWithValidation(zslControlImpl$$ExternalSyntheticLambda0, annotatedString);
                OffsetMapping offsetMapping4 = transformedTextFilterWithValidation.offsetMapping;
                if (textRange3 != null) {
                    textRange = textRange3;
                    long j6 = textRange.packedValue;
                    int i17 = TextRange.$r8$clinit;
                    int iOriginalToTransformed = offsetMapping4.originalToTransformed((int) (j6 >> 32));
                    int iOriginalToTransformed2 = offsetMapping4.originalToTransformed((int) (j6 & 4294967295L));
                    int iMin = Math.min(iOriginalToTransformed, iOriginalToTransformed2);
                    int iMax = Math.max(iOriginalToTransformed, iOriginalToTransformed2);
                    AnnotatedString.Builder builder = new AnnotatedString.Builder(transformedTextFilterWithValidation.text);
                    i7 = i16;
                    builder.annotations.add(new AnnotatedString.Builder.MutableRange(new SpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.Underline, null, 61439), iMin, iMax, ""));
                    objRememberedValue14 = new TransformedText(builder.toAnnotatedString(), offsetMapping4);
                } else {
                    i7 = i16;
                    textRange = textRange3;
                    objRememberedValue14 = transformedTextFilterWithValidation;
                }
                gapComposer.updateRememberedValue(objRememberedValue14);
            } else {
                i7 = i16;
                annotatedString = annotatedString;
                textRange = textRange3;
            }
            TransformedText transformedText = (TransformedText) objRememberedValue14;
            AnnotatedString annotatedString2 = transformedText.text;
            final OffsetMapping offsetMapping5 = transformedText.offsetMapping;
            RecomposeScopeImpl currentRecomposeScope$runtime = gapComposer.getCurrentRecomposeScope$runtime();
            if (currentRecomposeScope$runtime == null) {
                throw new IllegalStateException("no recompose scope found");
            }
            currentRecomposeScope$runtime.setUsed();
            boolean zChanged3 = gapComposer.changed(softwareKeyboardController);
            Object objRememberedValue15 = gapComposer.rememberedValue();
            if (zChanged3 || objRememberedValue15 == neverEqualPolicy) {
                TextRange textRange4 = textRange;
                z3 = z;
                textStyle2 = textStyle;
                TextDelegate textDelegate = new TextDelegate(annotatedString2, textStyle2, z3, density3, fontFamily$Resolver2, 0);
                textRange2 = textRange4;
                density = density3;
                fontFamily$Resolver = fontFamily$Resolver2;
                objRememberedValue15 = new LegacyTextFieldState(textDelegate, currentRecomposeScope$runtime, softwareKeyboardController);
                gapComposer.updateRememberedValue(objRememberedValue15);
            } else {
                textStyle2 = textStyle;
                textRange2 = textRange;
                density = density3;
                z3 = z;
                fontFamily$Resolver = fontFamily$Resolver2;
            }
            final LegacyTextFieldState legacyTextFieldState4 = (LegacyTextFieldState) objRememberedValue15;
            legacyTextFieldState4.onValueChangeOriginal = function1;
            legacyTextFieldState4.selectionBackgroundColor = j5;
            MenuHostHelper menuHostHelper = legacyTextFieldState4.keyboardActionRunner;
            menuHostHelper.mMenuProviders = keyboardActions;
            menuHostHelper.mProviderToLifecycleContainers = r30;
            legacyTextFieldState4.untransformedText = annotatedString;
            TextDelegate textDelegate2 = legacyTextFieldState4.textDelegate;
            if (Intrinsics.areEqual(textDelegate2.text, annotatedString2) && Intrinsics.areEqual(textDelegate2.style, textStyle2) && textDelegate2.softWrap == z3 && textDelegate2.overflow == 1 && textDelegate2.maxLines == Integer.MAX_VALUE && textDelegate2.minLines == 1 && Intrinsics.areEqual(textDelegate2.density, density) && Intrinsics.areEqual(textDelegate2.placeholders, EmptyList.INSTANCE) && textDelegate2.fontFamilyResolver == fontFamily$Resolver) {
                density2 = density;
            } else {
                density2 = density;
                textDelegate2 = new TextDelegate(annotatedString2, textStyle2, z3, density2, fontFamily$Resolver, 0);
            }
            if (legacyTextFieldState4.textDelegate != textDelegate2) {
                legacyTextFieldState4.isLayoutResultStale = true;
            }
            legacyTextFieldState4.textDelegate = textDelegate2;
            RequestService requestService2 = legacyTextFieldState4.processor;
            TextInputSession textInputSession = legacyTextFieldState4.inputSession;
            requestService2.getClass();
            TextRange textRange5 = textRange2;
            boolean zAreEqual = Intrinsics.areEqual(textRange5, ((EditingBuffer) requestService2.hardwareBitmapService).m659getCompositionMzsxiRA$ui_text());
            if (Intrinsics.areEqual(((TextFieldValue) requestService2.systemCallbacks).annotatedString.text, annotatedString.text)) {
                j = r16;
                if (TextRange.m640equalsimpl0(((TextFieldValue) requestService2.systemCallbacks).selection, j)) {
                    z4 = false;
                } else {
                    ((EditingBuffer) requestService2.hardwareBitmapService).setSelection$ui_text(TextRange.m644getMinimpl(j), TextRange.m643getMaximpl(j));
                    z5 = true;
                    z4 = false;
                }
                if (textRange5 == null) {
                    EditingBuffer editingBuffer = (EditingBuffer) requestService2.hardwareBitmapService;
                    editingBuffer.compositionStart = -1;
                    editingBuffer.compositionEnd = -1;
                } else {
                    j2 = textRange5.packedValue;
                    if (!TextRange.m641getCollapsedimpl(j2)) {
                        ((EditingBuffer) requestService2.hardwareBitmapService).setComposition$ui_text(TextRange.m644getMinimpl(j2), TextRange.m643getMaximpl(j2));
                    }
                }
                if (z4 && (z5 || zAreEqual)) {
                    textFieldValueM663copy3r_uNRQ$default = textFieldValue;
                    textFieldValue2 = textFieldValueM663copy3r_uNRQ$default;
                } else {
                    EditingBuffer editingBuffer2 = (EditingBuffer) requestService2.hardwareBitmapService;
                    editingBuffer2.compositionStart = -1;
                    editingBuffer2.compositionEnd = -1;
                    textFieldValue2 = textFieldValue;
                    textFieldValueM663copy3r_uNRQ$default = TextFieldValue.m663copy3r_uNRQ$default(textFieldValue2, null, 0L, 3);
                }
                textFieldValue3 = (TextFieldValue) requestService2.systemCallbacks;
                requestService2.systemCallbacks = textFieldValueM663copy3r_uNRQ$default;
                if (textInputSession != null) {
                    textInputSession.updateState(textFieldValue3, textFieldValueM663copy3r_uNRQ$default);
                }
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new UndoManager();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                undoManager = (UndoManager) objRememberedValue;
                jCurrentTimeMillis = System.currentTimeMillis();
                if (undoManager.forceNextSnapshot) {
                    undoManager.lastSnapshot = Long.valueOf(jCurrentTimeMillis);
                    undoManager.makeSnapshot(textFieldValue2);
                } else {
                    l = undoManager.lastSnapshot;
                    if (jCurrentTimeMillis > (l != null ? l.longValue() : 0L) + ((long) 5000)) {
                        undoManager.lastSnapshot = Long.valueOf(jCurrentTimeMillis);
                        undoManager.makeSnapshot(textFieldValue2);
                    }
                }
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                coroutineScope = (CoroutineScope) objRememberedValue2;
                objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new BringIntoViewRequesterImpl();
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                bringIntoViewRequesterImpl = (BringIntoViewRequesterImpl) objRememberedValue3;
                objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new TextFieldSelectionManager(undoManager);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue4;
                textFieldSelectionManager.offsetMapping = offsetMapping5;
                textFieldSelectionManager.onValueChange = legacyTextFieldState4.onValueChange;
                textFieldSelectionManager.state = legacyTextFieldState4;
                textFieldSelectionManager.valueState.setValue(textFieldValue2);
                textFieldSelectionManager.latestSelection = new TextRange(j);
                textFieldSelectionManager.clipboard = (Clipboard) gapComposer.consume(CompositionLocalsKt.LocalClipboard);
                textFieldSelectionManager.coroutineScope = coroutineScope;
                textFieldSelectionManager.hapticFeedBack = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
                textFieldSelectionManager.focusRequester = focusRequester;
                textFieldSelectionManager.editable$delegate.setValue(true);
                textFieldSelectionManager.enabled$delegate.setValue(Boolean.valueOf(z2));
                gapComposer.startReplaceGroup(1966756105);
                textFieldSelectionManager.platformSelectionBehaviors = PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, textStyle2.spanStyle.localeList, gapComposer, 6);
                gapComposer.end(false);
                legacyTextFieldState4.getHasFocus();
                boolean zChangedInstance5 = gapComposer.changedInstance(legacyTextFieldState4);
                i8 = i14 & 7168;
                if (i8 == 2048) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z20 = zChangedInstance5 | z6;
                if ((i14 & 57344) == 16384) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean zChangedInstance6 = z7 | z20 | gapComposer.changedInstance(textInputService3);
                i9 = i7;
                if (i9 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                i10 = (i14 & 112) ^ 48;
                zChangedInstance = zChangedInstance6 | z8 | ((i10 <= 32 && gapComposer.changed(imeOptions)) || (i14 & 48) == 32) | gapComposer.changedInstance(offsetMapping5) | gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(bringIntoViewRequesterImpl) | gapComposer.changedInstance(textFieldSelectionManager);
                Object objRememberedValue16 = gapComposer.rememberedValue();
                if (!zChangedInstance || objRememberedValue16 == neverEqualPolicy) {
                    gapComposer3 = gapComposer;
                    textInputService = textInputService3;
                    final TextFieldValue textFieldValue5 = textFieldValue2;
                    imeOptions2 = imeOptions;
                    obj = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            TextLayoutResultProxy layoutResult;
                            FocusStateImpl focusStateImpl = (FocusStateImpl) obj2;
                            LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                            if (legacyTextFieldState5.getHasFocus() == focusStateImpl.isFocused()) {
                                return Unit.INSTANCE;
                            }
                            legacyTextFieldState5.hasFocus$delegate.setValue(Boolean.valueOf(focusStateImpl.isFocused()));
                            boolean hasFocus = legacyTextFieldState5.getHasFocus();
                            TextFieldValue textFieldValue6 = textFieldValue5;
                            OffsetMapping offsetMapping6 = offsetMapping5;
                            if (hasFocus && z2) {
                                BasicTextKt.startInputSession(textInputService, legacyTextFieldState5, textFieldValue6, imeOptions2, offsetMapping6);
                            } else {
                                BasicTextKt.endInputSession(legacyTextFieldState5);
                            }
                            if (focusStateImpl.isFocused() && (layoutResult = legacyTextFieldState5.getLayoutResult()) != null) {
                                JobKt.launch$default(coroutineScope, null, new RealImageLoader$executeMain$result$1(bringIntoViewRequesterImpl, textFieldValue6, legacyTextFieldState5, layoutResult, offsetMapping6, null, 5), 3);
                            }
                            if (!focusStateImpl.isFocused()) {
                                textFieldSelectionManager.m230deselect_kEHs6E$foundation(null);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    z9 = z2;
                    textFieldValue4 = textFieldValue5;
                    textFieldSelectionManager = textFieldSelectionManager;
                    gapComposer3.updateRememberedValue(obj);
                } else {
                    obj = objRememberedValue16;
                    z9 = z2;
                    textFieldValue4 = textFieldValue2;
                    gapComposer3 = gapComposer;
                    textInputService = textInputService3;
                    imeOptions2 = imeOptions;
                }
                companion = Modifier.Companion.$$INSTANCE;
                Modifier modifierFocusable = ImageKt.focusable(FocusTraversalKt.onFocusChanged(FocusTraversalKt.focusRequester(companion, r3), (Function1) obj), z9, mutableInteractionSourceImpl);
                mutableStateRememberUpdatedState = Stack.rememberUpdatedState(Boolean.valueOf(z9), gapComposer3);
                unit = Unit.INSTANCE;
                boolean zChanged4 = gapComposer3.changed(mutableStateRememberUpdatedState) | gapComposer3.changedInstance(legacyTextFieldState4) | gapComposer3.changedInstance(textInputService) | gapComposer3.changedInstance(textFieldSelectionManager);
                if (i10 > 32 || !gapComposer3.changed(imeOptions2)) {
                    legacyTextFieldState = legacyTextFieldState4;
                    if ((i14 & 48) != 32) {
                        z10 = false;
                    }
                    z11 = zChanged4 | z10;
                    Object objRememberedValue17 = gapComposer3.rememberedValue();
                    if (!z11 || objRememberedValue17 == neverEqualPolicy) {
                        unit2 = unit;
                        coroutineScope2 = coroutineScope;
                        legacyTextFieldState2 = legacyTextFieldState;
                        realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(legacyTextFieldState2, mutableStateRememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions2, null, 4);
                        mutableState = mutableStateRememberUpdatedState;
                        gapComposer3.updateRememberedValue(realImageLoader$executeMain$result$1);
                    } else {
                        realImageLoader$executeMain$result$1 = objRememberedValue17;
                        coroutineScope2 = coroutineScope;
                        unit2 = unit;
                        legacyTextFieldState2 = legacyTextFieldState;
                        mutableState = mutableStateRememberUpdatedState;
                    }
                    Stack.LaunchedEffect(gapComposer3, unit2, (Function2) realImageLoader$executeMain$result$1);
                    suspendPointerInputElement = new SuspendPointerInputElement(8675309, null, new ScrimKt$Scrim$dismissModifier$1$1(5, new CoreTextFieldKt$$ExternalSyntheticLambda4(legacyTextFieldState2, 4)), 6);
                    menuKt$$ExternalSyntheticLambda0 = new MenuKt$$ExternalSyntheticLambda0(legacyTextFieldState2, (FocusRequester) r3, z2, textFieldSelectionManager, offsetMapping5);
                    if (z2) {
                        i11 = 2;
                        suspendPointerInputElement = suspendPointerInputElement.then(new ComposedModifier(new AlertDialogKt$$ExternalSyntheticLambda14(i11, menuKt$$ExternalSyntheticLambda0, mutableInteractionSourceImpl)));
                    } else {
                        i11 = 2;
                    }
                    Modifier modifierThen3 = suspendPointerInputElement.then(new SuspendPointerInputElement(textFieldSelectionManager.mouseSelectionObserver, textFieldSelectionManager.touchSelectionObserver, new ScrimKt$Scrim$dismissModifier$1$1(i11, textFieldSelectionManager), 4));
                    PointerIcon.Companion.getClass();
                    Modifier modifierThen4 = modifierThen3.then(new PointerHoverIconModifierElement());
                    Modifier modifierDrawBehind = ClipKt.drawBehind(r28, new LifecycleEffectKt$$ExternalSyntheticLambda1(legacyTextFieldState2, textFieldValue4, offsetMapping5, 7));
                    boolean zChangedInstance7 = gapComposer3.changedInstance(legacyTextFieldState2);
                    if (i8 == 2048) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean zChanged5 = zChangedInstance7 | z12 | gapComposer3.changed(windowInfo) | gapComposer3.changedInstance(textFieldSelectionManager);
                    if (i9 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    zChangedInstance2 = zChanged5 | z13 | gapComposer3.changedInstance(offsetMapping5);
                    objRememberedValue5 = gapComposer3.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue5 == r2) {
                        offsetMapping = offsetMapping5;
                        CoreTextFieldKt$$ExternalSyntheticLambda9 coreTextFieldKt$$ExternalSyntheticLambda9 = new CoreTextFieldKt$$ExternalSyntheticLambda9(legacyTextFieldState2, z2, windowInfo, textFieldSelectionManager, textFieldValue4, offsetMapping);
                        gapComposer3.updateRememberedValue(coreTextFieldKt$$ExternalSyntheticLambda9);
                        objRememberedValue5 = coreTextFieldKt$$ExternalSyntheticLambda9;
                    } else {
                        offsetMapping = offsetMapping5;
                    }
                    Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(r28, (Function1) objRememberedValue5);
                    LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState2;
                    offsetMapping2 = offsetMapping;
                    textInputService2 = textInputService;
                    textFieldSelectionManager2 = textFieldSelectionManager;
                    coreTextFieldSemanticsModifier = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState5, z2, offsetMapping2, textFieldSelectionManager2, imeOptions, focusRequester);
                    legacyTextFieldState3 = legacyTextFieldState5;
                    if (!z2 && ((Boolean) ((LazyWindowInfo) windowInfo).isWindowFocused$delegate.getValue()).booleanValue() && TextRange.m641getCollapsedimpl(((TextRange) legacyTextFieldState3.selectionPreviewHighlightRange$delegate.getValue()).packedValue) && TextRange.m641getCollapsedimpl(((TextRange) legacyTextFieldState3.deletionPreviewHighlightRange$delegate.getValue()).packedValue)) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        coreTextFieldSemanticsModifier2 = coreTextFieldSemanticsModifier;
                        SnackbarHostKt$$ExternalSyntheticLambda1 snackbarHostKt$$ExternalSyntheticLambda1 = new SnackbarHostKt$$ExternalSyntheticLambda1(solidColor, legacyTextFieldState3, textFieldValue, offsetMapping2, 2);
                        legacyTextFieldState3 = legacyTextFieldState3;
                        offsetMapping3 = offsetMapping2;
                        modifierThen = companion.then(new ComposedModifier(snackbarHostKt$$ExternalSyntheticLambda1));
                    } else {
                        offsetMapping3 = offsetMapping2;
                        coreTextFieldSemanticsModifier2 = coreTextFieldSemanticsModifier;
                        modifierThen = r28;
                    }
                    zChangedInstance3 = gapComposer3.changedInstance(textFieldSelectionManager2);
                    objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue6 == r2) {
                        objRememberedValue6 = new CoreTextFieldKt$$ExternalSyntheticLambda10(textFieldSelectionManager2, 0);
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    }
                    Stack.DisposableEffect(textFieldSelectionManager2, (Function1) objRememberedValue6, gapComposer3);
                    boolean zChangedInstance8 = gapComposer3.changedInstance(legacyTextFieldState3) | gapComposer3.changedInstance(textInputService2);
                    if (i9 == 4) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    z16 = zChangedInstance8 | z15 | ((i10 <= 32 && gapComposer3.changed(imeOptions)) || (i14 & 48) == 32);
                    objRememberedValue7 = gapComposer3.rememberedValue();
                    if (!z16 || objRememberedValue7 == r2) {
                        FilesActivity$$ExternalSyntheticLambda10 filesActivity$$ExternalSyntheticLambda10 = new FilesActivity$$ExternalSyntheticLambda10(legacyTextFieldState3, textInputService2, textFieldValue, imeOptions, 4);
                        imeOptions3 = imeOptions;
                        gapComposer3.updateRememberedValue(filesActivity$$ExternalSyntheticLambda10);
                        objRememberedValue7 = filesActivity$$ExternalSyntheticLambda10;
                    } else {
                        imeOptions3 = imeOptions;
                    }
                    Stack.DisposableEffect(imeOptions3, (Function1) objRememberedValue7, gapComposer3);
                    final CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4 = legacyTextFieldState3.onValueChange;
                    if (i == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    final int i18 = imeOptions3.imeAction;
                    CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier3 = coreTextFieldSemanticsModifier2;
                    final OffsetMapping offsetMapping6 = offsetMapping3;
                    final boolean z21 = true;
                    ComposedModifier composedModifier = new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.text.TextFieldKeyInputKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            GapComposer gapComposer4 = (GapComposer) obj3;
                            ((Integer) obj4).getClass();
                            gapComposer4.startReplaceGroup(851809892);
                            Object objRememberedValue18 = gapComposer4.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                            if (objRememberedValue18 == neverEqualPolicy2) {
                                objRememberedValue18 = new TextPreparedSelectionState();
                                gapComposer4.updateRememberedValue(objRememberedValue18);
                            }
                            TextPreparedSelectionState textPreparedSelectionState = (TextPreparedSelectionState) objRememberedValue18;
                            Object objRememberedValue19 = gapComposer4.rememberedValue();
                            if (objRememberedValue19 == neverEqualPolicy2) {
                                objRememberedValue19 = new DeadKeyCombiner();
                                gapComposer4.updateRememberedValue(objRememberedValue19);
                            }
                            TextFieldKeyInput textFieldKeyInput = new TextFieldKeyInput(legacyTextFieldState3, textFieldSelectionManager2, textFieldValue, z21, z17, textPreparedSelectionState, offsetMapping6, undoManager, (DeadKeyCombiner) objRememberedValue19, coreTextFieldKt$$ExternalSyntheticLambda4, i18);
                            boolean zChangedInstance9 = gapComposer4.changedInstance(textFieldKeyInput);
                            Object objRememberedValue20 = gapComposer4.rememberedValue();
                            if (zChangedInstance9 || objRememberedValue20 == neverEqualPolicy2) {
                                JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, textFieldKeyInput, TextFieldKeyInput.class, "process", "process-ZmokQxo(Landroid/view/KeyEvent;)Z", 0, 0, 2);
                                gapComposer4.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$1);
                                objRememberedValue20 = jobKt__JobKt$invokeOnCompletion$1;
                            }
                            Modifier modifierOnKeyEvent = Key_androidKt.onKeyEvent(Modifier.Companion.$$INSTANCE, (Function1) ((FunctionReferenceImpl) objRememberedValue20));
                            gapComposer4.end(false);
                            return modifierOnKeyEvent;
                        }
                    });
                    i12 = imeOptions3.keyboardType;
                    if (i12 == 7 && i12 != 8) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                    zChanged = gapComposer3.changed(z18) | gapComposer3.changedInstance(androidLegacyPlatformTextInputServiceAdapter);
                    objRememberedValue8 = gapComposer3.rememberedValue();
                    if (zChanged || objRememberedValue8 == r2) {
                        objRememberedValue8 = new CoreTextFieldKt$$ExternalSyntheticLambda12(z18, androidLegacyPlatformTextInputServiceAdapter);
                        gapComposer3.updateRememberedValue(objRememberedValue8);
                    }
                    Modifier modifierStylusHandwriting = StylusHandwritingKt.stylusHandwriting(zBooleanValue, z18, (Function0) objRememberedValue8);
                    solidColor2 = (Brush) gapComposer3.consume(AutofillHighlightKt.LocalAutofillHighlightBrush);
                    j3 = ((Color) gapComposer3.consume(AutofillHighlightKt.LocalAutofillHighlightColor)).value;
                    if (!Color.m435equalsimpl0(j3, BrushKt.Color(1308617531))) {
                        solidColor2 = new SolidColor(j3);
                    }
                    zChangedInstance4 = gapComposer3.changedInstance(legacyTextFieldState3) | gapComposer3.changed(solidColor2);
                    objRememberedValue9 = gapComposer3.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue9 == r2) {
                        objRememberedValue9 = new BackHandlerKt$$ExternalSyntheticLambda2(26, legacyTextFieldState3, solidColor2);
                        gapComposer3.updateRememberedValue(objRememberedValue9);
                    }
                    Modifier modifierAddTextContextMenuComponentsWithContext = TextContextMenuModifierKt.addTextContextMenuComponentsWithContext(RulerKt.onGloballyPositioned(Key_androidKt.onPreviewKeyEvent(Key_androidKt.onPreviewKeyEvent(HandwritingGestureApi34.legacyTextInputAdapter(modifier.then(ClipKt.drawWithContent(r28, (Function1) objRememberedValue9)), androidLegacyPlatformTextInputServiceAdapter, legacyTextFieldState3, textFieldSelectionManager2).then(modifierStylusHandwriting).then(modifierFocusable), new ContinuationCallback(2, focusOwner, legacyTextFieldState3)), new ContinuationCallback(1, legacyTextFieldState3, textFieldSelectionManager2)).then(composedModifier).then(new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                            ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldScrollerPosition2.orientation$delegate;
                            GapComposer gapComposer4 = (GapComposer) obj3;
                            ((Integer) obj4).getClass();
                            gapComposer4.startReplaceGroup(-2137546592);
                            boolean z22 = ((Orientation) parcelableSnapshotMutableState.getValue()) == Orientation.Vertical || !(gapComposer4.consume(CompositionLocalsKt.LocalLayoutDirection) == LayoutDirection.Rtl);
                            boolean zChanged6 = gapComposer4.changed(textFieldScrollerPosition2);
                            Object objRememberedValue18 = gapComposer4.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                            if (zChanged6 || objRememberedValue18 == neverEqualPolicy2) {
                                objRememberedValue18 = new Recomposer$$ExternalSyntheticLambda0(15, textFieldScrollerPosition2);
                                gapComposer4.updateRememberedValue(objRememberedValue18);
                            }
                            MutableState mutableStateRememberUpdatedState2 = Stack.rememberUpdatedState((Function1) objRememberedValue18, gapComposer4);
                            Object objRememberedValue19 = gapComposer4.rememberedValue();
                            if (objRememberedValue19 == neverEqualPolicy2) {
                                DefaultScrollableState defaultScrollableState = new DefaultScrollableState(new TooltipKt$$ExternalSyntheticLambda7(mutableStateRememberUpdatedState2, 1));
                                gapComposer4.updateRememberedValue(defaultScrollableState);
                                objRememberedValue19 = defaultScrollableState;
                            }
                            ScrollableState scrollableState = (ScrollableState) objRememberedValue19;
                            boolean zChanged7 = gapComposer4.changed(scrollableState) | gapComposer4.changed(textFieldScrollerPosition2);
                            Object objRememberedValue20 = gapComposer4.rememberedValue();
                            if (zChanged7 || objRememberedValue20 == neverEqualPolicy2) {
                                objRememberedValue20 = new ScrollableState(textFieldScrollerPosition2) { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1
                                    public final DerivedSnapshotState canScrollBackward$delegate;
                                    public final DerivedSnapshotState canScrollForward$delegate;

                                    {
                                        final int i19 = 0;
                                        this.canScrollForward$delegate = Stack.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$$ExternalSyntheticLambda0
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                switch (i19) {
                                                    case 0:
                                                        TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                        return Boolean.valueOf(textFieldScrollerPosition3.offset$delegate.getFloatValue() < textFieldScrollerPosition3.maximum$delegate.getFloatValue());
                                                    default:
                                                        return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() > 0.0f);
                                                }
                                            }
                                        });
                                        final int i20 = 1;
                                        this.canScrollBackward$delegate = Stack.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$$ExternalSyntheticLambda0
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                switch (i20) {
                                                    case 0:
                                                        TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                        return Boolean.valueOf(textFieldScrollerPosition3.offset$delegate.getFloatValue() < textFieldScrollerPosition3.maximum$delegate.getFloatValue());
                                                    default:
                                                        return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() > 0.0f);
                                                }
                                            }
                                        });
                                    }

                                    @Override // androidx.compose.foundation.gestures.ScrollableState
                                    public final float dispatchRawDelta(float f) {
                                        return this.$$delegate_0.dispatchRawDelta(f);
                                    }

                                    @Override // androidx.compose.foundation.gestures.ScrollableState
                                    public final boolean getCanScrollBackward() {
                                        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
                                    }

                                    @Override // androidx.compose.foundation.gestures.ScrollableState
                                    public final boolean getCanScrollForward() {
                                        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
                                    }

                                    @Override // androidx.compose.foundation.gestures.ScrollableState
                                    public final boolean isScrollInProgress() {
                                        return this.$$delegate_0.isScrollInProgress();
                                    }

                                    @Override // androidx.compose.foundation.gestures.ScrollableState
                                    public final Object scroll(MutatePriority mutatePriority, Function2 function3, ContinuationImpl continuationImpl) {
                                        return this.$$delegate_0.scroll(mutatePriority, function3, continuationImpl);
                                    }
                                };
                                gapComposer4.updateRememberedValue(objRememberedValue20);
                            }
                            Modifier modifierScrollable$default = ScrollableKt.scrollable$default((TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) objRememberedValue20, (Orientation) parcelableSnapshotMutableState.getValue(), z2 && textFieldScrollerPosition2.maximum$delegate.getFloatValue() != 0.0f, z22, mutableInteractionSourceImpl);
                            gapComposer4.end(false);
                            return modifierScrollable$default;
                        }
                    })).then(modifierThen4).then(coreTextFieldSemanticsModifier3), new CoreTextFieldKt$$ExternalSyntheticLambda4(legacyTextFieldState3, 0)), new TextKt$$ExternalSyntheticLambda2(10, textFieldSelectionManager2, coroutineScope2));
                    i13 = (!z2 && legacyTextFieldState3.getHasFocus() && ((Boolean) legacyTextFieldState3.isInTouchMode$delegate.getValue()).booleanValue() && ((Boolean) r3.isWindowFocused$delegate.getValue()).booleanValue()) ? 1 : 0;
                    if (i13 == 0 && Magnifier_androidKt.isPlatformMagnifierSupported$default()) {
                        modifierThen2 = r28.then(new ComposedModifier(new SheetDefaultsKt$$ExternalSyntheticLambda5(4, textFieldSelectionManager2)));
                    } else {
                        modifierThen2 = r28;
                    }
                    gapComposer2 = gapComposer;
                    CoreTextFieldRootBox(modifierAddTextContextMenuComponentsWithContext, textFieldSelectionManager2, Thread_jvmKt.rememberComposableLambda(-814563849, new OutlinedTextFieldKt$$ExternalSyntheticLambda1(composableLambdaImpl, legacyTextFieldState3, textStyle, i2, i, textFieldScrollerPosition, textFieldValue, zslControlImpl$$ExternalSyntheticLambda0, modifierThen, modifierDrawBehind, modifierOnGloballyPositioned, modifierThen2, bringIntoViewRequesterImpl, textFieldSelectionManager2, (boolean) i13, function2, offsetMapping6, density2), gapComposer2), gapComposer2, 384);
                } else {
                    legacyTextFieldState = legacyTextFieldState4;
                }
                z10 = true;
                z11 = zChanged4 | z10;
                Object objRememberedValue18 = gapComposer3.rememberedValue();
                if (z11) {
                    unit2 = unit;
                    coroutineScope2 = coroutineScope;
                    legacyTextFieldState2 = legacyTextFieldState;
                    realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(legacyTextFieldState2, mutableStateRememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions2, null, 4);
                    mutableState = mutableStateRememberUpdatedState;
                    gapComposer3.updateRememberedValue(realImageLoader$executeMain$result$1);
                } else {
                    unit2 = unit;
                    coroutineScope2 = coroutineScope;
                    legacyTextFieldState2 = legacyTextFieldState;
                    realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(legacyTextFieldState2, mutableStateRememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions2, null, 4);
                    mutableState = mutableStateRememberUpdatedState;
                    gapComposer3.updateRememberedValue(realImageLoader$executeMain$result$1);
                }
                Stack.LaunchedEffect(gapComposer3, unit2, (Function2) realImageLoader$executeMain$result$1);
                suspendPointerInputElement = new SuspendPointerInputElement(8675309, null, new ScrimKt$Scrim$dismissModifier$1$1(5, new CoreTextFieldKt$$ExternalSyntheticLambda4(legacyTextFieldState2, 4)), 6);
                menuKt$$ExternalSyntheticLambda0 = new MenuKt$$ExternalSyntheticLambda0(legacyTextFieldState2, (FocusRequester) r3, z2, textFieldSelectionManager, offsetMapping5);
                if (z2) {
                    i11 = 2;
                    suspendPointerInputElement = suspendPointerInputElement.then(new ComposedModifier(new AlertDialogKt$$ExternalSyntheticLambda14(i11, menuKt$$ExternalSyntheticLambda0, mutableInteractionSourceImpl)));
                } else {
                    i11 = 2;
                }
                Modifier modifierThen5 = suspendPointerInputElement.then(new SuspendPointerInputElement(textFieldSelectionManager.mouseSelectionObserver, textFieldSelectionManager.touchSelectionObserver, new ScrimKt$Scrim$dismissModifier$1$1(i11, textFieldSelectionManager), 4));
                PointerIcon.Companion.getClass();
                Modifier modifierThen6 = modifierThen5.then(new PointerHoverIconModifierElement());
                Modifier modifierDrawBehind2 = ClipKt.drawBehind(r28, new LifecycleEffectKt$$ExternalSyntheticLambda1(legacyTextFieldState2, textFieldValue4, offsetMapping5, 7));
                boolean zChangedInstance9 = gapComposer3.changedInstance(legacyTextFieldState2);
                if (i8 == 2048) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChanged6 = zChangedInstance9 | z12 | gapComposer3.changed(windowInfo) | gapComposer3.changedInstance(textFieldSelectionManager);
                if (i9 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                zChangedInstance2 = zChanged6 | z13 | gapComposer3.changedInstance(offsetMapping5);
                objRememberedValue5 = gapComposer3.rememberedValue();
                if (zChangedInstance2) {
                    offsetMapping = offsetMapping5;
                    CoreTextFieldKt$$ExternalSyntheticLambda9 coreTextFieldKt$$ExternalSyntheticLambda10 = new CoreTextFieldKt$$ExternalSyntheticLambda9(legacyTextFieldState2, z2, windowInfo, textFieldSelectionManager, textFieldValue4, offsetMapping);
                    gapComposer3.updateRememberedValue(coreTextFieldKt$$ExternalSyntheticLambda10);
                    objRememberedValue5 = coreTextFieldKt$$ExternalSyntheticLambda10;
                } else {
                    offsetMapping = offsetMapping5;
                    CoreTextFieldKt$$ExternalSyntheticLambda9 coreTextFieldKt$$ExternalSyntheticLambda11 = new CoreTextFieldKt$$ExternalSyntheticLambda9(legacyTextFieldState2, z2, windowInfo, textFieldSelectionManager, textFieldValue4, offsetMapping);
                    gapComposer3.updateRememberedValue(coreTextFieldKt$$ExternalSyntheticLambda11);
                    objRememberedValue5 = coreTextFieldKt$$ExternalSyntheticLambda11;
                }
                Modifier modifierOnGloballyPositioned2 = RulerKt.onGloballyPositioned(r28, (Function1) objRememberedValue5);
                LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState2;
                offsetMapping2 = offsetMapping;
                textInputService2 = textInputService;
                textFieldSelectionManager2 = textFieldSelectionManager;
                coreTextFieldSemanticsModifier = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState6, z2, offsetMapping2, textFieldSelectionManager2, imeOptions, focusRequester);
                legacyTextFieldState3 = legacyTextFieldState6;
                if (!z2) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                if (z14) {
                    coreTextFieldSemanticsModifier2 = coreTextFieldSemanticsModifier;
                    SnackbarHostKt$$ExternalSyntheticLambda1 snackbarHostKt$$ExternalSyntheticLambda2 = new SnackbarHostKt$$ExternalSyntheticLambda1(solidColor, legacyTextFieldState3, textFieldValue, offsetMapping2, 2);
                    legacyTextFieldState3 = legacyTextFieldState3;
                    offsetMapping3 = offsetMapping2;
                    modifierThen = companion.then(new ComposedModifier(snackbarHostKt$$ExternalSyntheticLambda2));
                } else {
                    offsetMapping3 = offsetMapping2;
                    coreTextFieldSemanticsModifier2 = coreTextFieldSemanticsModifier;
                    modifierThen = r28;
                }
                zChangedInstance3 = gapComposer3.changedInstance(textFieldSelectionManager2);
                objRememberedValue6 = gapComposer3.rememberedValue();
                if (zChangedInstance3) {
                    objRememberedValue6 = new CoreTextFieldKt$$ExternalSyntheticLambda10(textFieldSelectionManager2, 0);
                    gapComposer3.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new CoreTextFieldKt$$ExternalSyntheticLambda10(textFieldSelectionManager2, 0);
                    gapComposer3.updateRememberedValue(objRememberedValue6);
                }
                Stack.DisposableEffect(textFieldSelectionManager2, (Function1) objRememberedValue6, gapComposer3);
                boolean zChangedInstance10 = gapComposer3.changedInstance(legacyTextFieldState3) | gapComposer3.changedInstance(textInputService2);
                if (i9 == 4) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                z16 = zChangedInstance10 | z15 | ((i10 <= 32 && gapComposer3.changed(imeOptions)) || (i14 & 48) == 32);
                objRememberedValue7 = gapComposer3.rememberedValue();
                if (z16) {
                    FilesActivity$$ExternalSyntheticLambda10 filesActivity$$ExternalSyntheticLambda11 = new FilesActivity$$ExternalSyntheticLambda10(legacyTextFieldState3, textInputService2, textFieldValue, imeOptions, 4);
                    imeOptions3 = imeOptions;
                    gapComposer3.updateRememberedValue(filesActivity$$ExternalSyntheticLambda11);
                    objRememberedValue7 = filesActivity$$ExternalSyntheticLambda11;
                } else {
                    FilesActivity$$ExternalSyntheticLambda10 filesActivity$$ExternalSyntheticLambda12 = new FilesActivity$$ExternalSyntheticLambda10(legacyTextFieldState3, textInputService2, textFieldValue, imeOptions, 4);
                    imeOptions3 = imeOptions;
                    gapComposer3.updateRememberedValue(filesActivity$$ExternalSyntheticLambda12);
                    objRememberedValue7 = filesActivity$$ExternalSyntheticLambda12;
                }
                Stack.DisposableEffect(imeOptions3, (Function1) objRememberedValue7, gapComposer3);
                final Function1 coreTextFieldKt$$ExternalSyntheticLambda5 = legacyTextFieldState3.onValueChange;
                if (i == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                final int i19 = imeOptions3.imeAction;
                CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier4 = coreTextFieldSemanticsModifier2;
                final OffsetMapping offsetMapping7 = offsetMapping3;
                final boolean z22 = true;
                ComposedModifier composedModifier2 = new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.text.TextFieldKeyInputKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        GapComposer gapComposer4 = (GapComposer) obj3;
                        ((Integer) obj4).getClass();
                        gapComposer4.startReplaceGroup(851809892);
                        Object objRememberedValue19 = gapComposer4.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (objRememberedValue19 == neverEqualPolicy2) {
                            objRememberedValue19 = new TextPreparedSelectionState();
                            gapComposer4.updateRememberedValue(objRememberedValue19);
                        }
                        TextPreparedSelectionState textPreparedSelectionState = (TextPreparedSelectionState) objRememberedValue19;
                        Object objRememberedValue110 = gapComposer4.rememberedValue();
                        if (objRememberedValue110 == neverEqualPolicy2) {
                            objRememberedValue110 = new DeadKeyCombiner();
                            gapComposer4.updateRememberedValue(objRememberedValue110);
                        }
                        TextFieldKeyInput textFieldKeyInput = new TextFieldKeyInput(legacyTextFieldState3, textFieldSelectionManager2, textFieldValue, z22, z17, textPreparedSelectionState, offsetMapping7, undoManager, (DeadKeyCombiner) objRememberedValue110, coreTextFieldKt$$ExternalSyntheticLambda5, i19);
                        boolean zChangedInstance11 = gapComposer4.changedInstance(textFieldKeyInput);
                        Object objRememberedValue20 = gapComposer4.rememberedValue();
                        if (zChangedInstance11 || objRememberedValue20 == neverEqualPolicy2) {
                            JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, textFieldKeyInput, TextFieldKeyInput.class, "process", "process-ZmokQxo(Landroid/view/KeyEvent;)Z", 0, 0, 2);
                            gapComposer4.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$1);
                            objRememberedValue20 = jobKt__JobKt$invokeOnCompletion$1;
                        }
                        Modifier modifierOnKeyEvent = Key_androidKt.onKeyEvent(Modifier.Companion.$$INSTANCE, (Function1) ((FunctionReferenceImpl) objRememberedValue20));
                        gapComposer4.end(false);
                        return modifierOnKeyEvent;
                    }
                });
                i12 = imeOptions3.keyboardType;
                if (i12 == 7) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                boolean zBooleanValue2 = ((Boolean) mutableState.getValue()).booleanValue();
                zChanged = gapComposer3.changed(z18) | gapComposer3.changedInstance(androidLegacyPlatformTextInputServiceAdapter);
                objRememberedValue8 = gapComposer3.rememberedValue();
                if (zChanged) {
                    objRememberedValue8 = new CoreTextFieldKt$$ExternalSyntheticLambda12(z18, androidLegacyPlatformTextInputServiceAdapter);
                    gapComposer3.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new CoreTextFieldKt$$ExternalSyntheticLambda12(z18, androidLegacyPlatformTextInputServiceAdapter);
                    gapComposer3.updateRememberedValue(objRememberedValue8);
                }
                Modifier modifierStylusHandwriting2 = StylusHandwritingKt.stylusHandwriting(zBooleanValue2, z18, (Function0) objRememberedValue8);
                solidColor2 = (Brush) gapComposer3.consume(AutofillHighlightKt.LocalAutofillHighlightBrush);
                j3 = ((Color) gapComposer3.consume(AutofillHighlightKt.LocalAutofillHighlightColor)).value;
                if (!Color.m435equalsimpl0(j3, BrushKt.Color(1308617531))) {
                    solidColor2 = new SolidColor(j3);
                }
                zChangedInstance4 = gapComposer3.changedInstance(legacyTextFieldState3) | gapComposer3.changed(solidColor2);
                objRememberedValue9 = gapComposer3.rememberedValue();
                if (zChangedInstance4) {
                    objRememberedValue9 = new BackHandlerKt$$ExternalSyntheticLambda2(26, legacyTextFieldState3, solidColor2);
                    gapComposer3.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new BackHandlerKt$$ExternalSyntheticLambda2(26, legacyTextFieldState3, solidColor2);
                    gapComposer3.updateRememberedValue(objRememberedValue9);
                }
                Modifier modifierAddTextContextMenuComponentsWithContext2 = TextContextMenuModifierKt.addTextContextMenuComponentsWithContext(RulerKt.onGloballyPositioned(Key_androidKt.onPreviewKeyEvent(Key_androidKt.onPreviewKeyEvent(HandwritingGestureApi34.legacyTextInputAdapter(modifier.then(ClipKt.drawWithContent(r28, (Function1) objRememberedValue9)), androidLegacyPlatformTextInputServiceAdapter, legacyTextFieldState3, textFieldSelectionManager2).then(modifierStylusHandwriting2).then(modifierFocusable), new ContinuationCallback(2, focusOwner, legacyTextFieldState3)), new ContinuationCallback(1, legacyTextFieldState3, textFieldSelectionManager2)).then(composedModifier2).then(new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                        ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldScrollerPosition2.orientation$delegate;
                        GapComposer gapComposer4 = (GapComposer) obj3;
                        ((Integer) obj4).getClass();
                        gapComposer4.startReplaceGroup(-2137546592);
                        boolean z23 = ((Orientation) parcelableSnapshotMutableState.getValue()) == Orientation.Vertical || !(gapComposer4.consume(CompositionLocalsKt.LocalLayoutDirection) == LayoutDirection.Rtl);
                        boolean zChanged7 = gapComposer4.changed(textFieldScrollerPosition2);
                        Object objRememberedValue19 = gapComposer4.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zChanged7 || objRememberedValue19 == neverEqualPolicy2) {
                            objRememberedValue19 = new Recomposer$$ExternalSyntheticLambda0(15, textFieldScrollerPosition2);
                            gapComposer4.updateRememberedValue(objRememberedValue19);
                        }
                        MutableState mutableStateRememberUpdatedState2 = Stack.rememberUpdatedState((Function1) objRememberedValue19, gapComposer4);
                        Object objRememberedValue110 = gapComposer4.rememberedValue();
                        if (objRememberedValue110 == neverEqualPolicy2) {
                            DefaultScrollableState defaultScrollableState = new DefaultScrollableState(new TooltipKt$$ExternalSyntheticLambda7(mutableStateRememberUpdatedState2, 1));
                            gapComposer4.updateRememberedValue(defaultScrollableState);
                            objRememberedValue110 = defaultScrollableState;
                        }
                        ScrollableState scrollableState = (ScrollableState) objRememberedValue110;
                        boolean zChanged8 = gapComposer4.changed(scrollableState) | gapComposer4.changed(textFieldScrollerPosition2);
                        Object objRememberedValue20 = gapComposer4.rememberedValue();
                        if (zChanged8 || objRememberedValue20 == neverEqualPolicy2) {
                            objRememberedValue20 = new ScrollableState(textFieldScrollerPosition2) { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1
                                public final DerivedSnapshotState canScrollBackward$delegate;
                                public final DerivedSnapshotState canScrollForward$delegate;

                                {
                                    final int i110 = 0;
                                    this.canScrollForward$delegate = Stack.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            switch (i110) {
                                                case 0:
                                                    TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                    return Boolean.valueOf(textFieldScrollerPosition3.offset$delegate.getFloatValue() < textFieldScrollerPosition3.maximum$delegate.getFloatValue());
                                                default:
                                                    return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() > 0.0f);
                                            }
                                        }
                                    });
                                    final int i20 = 1;
                                    this.canScrollBackward$delegate = Stack.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            switch (i20) {
                                                case 0:
                                                    TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                    return Boolean.valueOf(textFieldScrollerPosition3.offset$delegate.getFloatValue() < textFieldScrollerPosition3.maximum$delegate.getFloatValue());
                                                default:
                                                    return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() > 0.0f);
                                            }
                                        }
                                    });
                                }

                                @Override // androidx.compose.foundation.gestures.ScrollableState
                                public final float dispatchRawDelta(float f) {
                                    return this.$$delegate_0.dispatchRawDelta(f);
                                }

                                @Override // androidx.compose.foundation.gestures.ScrollableState
                                public final boolean getCanScrollBackward() {
                                    return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
                                }

                                @Override // androidx.compose.foundation.gestures.ScrollableState
                                public final boolean getCanScrollForward() {
                                    return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
                                }

                                @Override // androidx.compose.foundation.gestures.ScrollableState
                                public final boolean isScrollInProgress() {
                                    return this.$$delegate_0.isScrollInProgress();
                                }

                                @Override // androidx.compose.foundation.gestures.ScrollableState
                                public final Object scroll(MutatePriority mutatePriority, Function2 function3, ContinuationImpl continuationImpl) {
                                    return this.$$delegate_0.scroll(mutatePriority, function3, continuationImpl);
                                }
                            };
                            gapComposer4.updateRememberedValue(objRememberedValue20);
                        }
                        Modifier modifierScrollable$default = ScrollableKt.scrollable$default((TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) objRememberedValue20, (Orientation) parcelableSnapshotMutableState.getValue(), z2 && textFieldScrollerPosition2.maximum$delegate.getFloatValue() != 0.0f, z23, mutableInteractionSourceImpl);
                        gapComposer4.end(false);
                        return modifierScrollable$default;
                    }
                })).then(modifierThen6).then(coreTextFieldSemanticsModifier4), new CoreTextFieldKt$$ExternalSyntheticLambda4(legacyTextFieldState3, 0)), new TextKt$$ExternalSyntheticLambda2(10, textFieldSelectionManager2, coroutineScope2));
                if (!z2) {
                }
                if (i13 == 0) {
                    modifierThen2 = r28;
                } else {
                    modifierThen2 = r28;
                }
                gapComposer2 = gapComposer;
                CoreTextFieldRootBox(modifierAddTextContextMenuComponentsWithContext2, textFieldSelectionManager2, Thread_jvmKt.rememberComposableLambda(-814563849, new OutlinedTextFieldKt$$ExternalSyntheticLambda1(composableLambdaImpl, legacyTextFieldState3, textStyle, i2, i, textFieldScrollerPosition, textFieldValue, zslControlImpl$$ExternalSyntheticLambda0, modifierThen, modifierDrawBehind2, modifierOnGloballyPositioned2, modifierThen2, bringIntoViewRequesterImpl, textFieldSelectionManager2, (boolean) i13, function2, offsetMapping7, density2), gapComposer2), gapComposer2, 384);
            } else {
                j = j4;
                requestService2.hardwareBitmapService = new EditingBuffer(annotatedString, j);
                z4 = true;
            }
            z5 = false;
            if (textRange5 == null) {
                EditingBuffer editingBuffer3 = (EditingBuffer) requestService2.hardwareBitmapService;
                editingBuffer3.compositionStart = -1;
                editingBuffer3.compositionEnd = -1;
            } else {
                j2 = textRange5.packedValue;
                if (!TextRange.m641getCollapsedimpl(j2)) {
                    ((EditingBuffer) requestService2.hardwareBitmapService).setComposition$ui_text(TextRange.m644getMinimpl(j2), TextRange.m643getMaximpl(j2));
                }
            }
            if (z4) {
                EditingBuffer editingBuffer4 = (EditingBuffer) requestService2.hardwareBitmapService;
                editingBuffer4.compositionStart = -1;
                editingBuffer4.compositionEnd = -1;
                textFieldValue2 = textFieldValue;
                textFieldValueM663copy3r_uNRQ$default = TextFieldValue.m663copy3r_uNRQ$default(textFieldValue2, null, 0L, 3);
            } else {
                EditingBuffer editingBuffer5 = (EditingBuffer) requestService2.hardwareBitmapService;
                editingBuffer5.compositionStart = -1;
                editingBuffer5.compositionEnd = -1;
                textFieldValue2 = textFieldValue;
                textFieldValueM663copy3r_uNRQ$default = TextFieldValue.m663copy3r_uNRQ$default(textFieldValue2, null, 0L, 3);
            }
            textFieldValue3 = (TextFieldValue) requestService2.systemCallbacks;
            requestService2.systemCallbacks = textFieldValueM663copy3r_uNRQ$default;
            if (textInputSession != null) {
                textInputSession.updateState(textFieldValue3, textFieldValueM663copy3r_uNRQ$default);
            }
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new UndoManager();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            undoManager = (UndoManager) objRememberedValue;
            jCurrentTimeMillis = System.currentTimeMillis();
            if (undoManager.forceNextSnapshot) {
                undoManager.lastSnapshot = Long.valueOf(jCurrentTimeMillis);
                undoManager.makeSnapshot(textFieldValue2);
            } else {
                l = undoManager.lastSnapshot;
                if (jCurrentTimeMillis > (l != null ? l.longValue() : 0L) + ((long) 5000)) {
                    undoManager.lastSnapshot = Long.valueOf(jCurrentTimeMillis);
                    undoManager.makeSnapshot(textFieldValue2);
                }
            }
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            coroutineScope = (CoroutineScope) objRememberedValue2;
            objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new BringIntoViewRequesterImpl();
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            bringIntoViewRequesterImpl = (BringIntoViewRequesterImpl) objRememberedValue3;
            objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new TextFieldSelectionManager(undoManager);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue4;
            textFieldSelectionManager.offsetMapping = offsetMapping5;
            textFieldSelectionManager.onValueChange = legacyTextFieldState4.onValueChange;
            textFieldSelectionManager.state = legacyTextFieldState4;
            textFieldSelectionManager.valueState.setValue(textFieldValue2);
            textFieldSelectionManager.latestSelection = new TextRange(j);
            textFieldSelectionManager.clipboard = (Clipboard) gapComposer.consume(CompositionLocalsKt.LocalClipboard);
            textFieldSelectionManager.coroutineScope = coroutineScope;
            textFieldSelectionManager.hapticFeedBack = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
            textFieldSelectionManager.focusRequester = focusRequester;
            textFieldSelectionManager.editable$delegate.setValue(true);
            textFieldSelectionManager.enabled$delegate.setValue(Boolean.valueOf(z2));
            gapComposer.startReplaceGroup(1966756105);
            textFieldSelectionManager.platformSelectionBehaviors = PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, textStyle2.spanStyle.localeList, gapComposer, 6);
            gapComposer.end(false);
            legacyTextFieldState4.getHasFocus();
            boolean zChangedInstance11 = gapComposer.changedInstance(legacyTextFieldState4);
            i8 = i14 & 7168;
            if (i8 == 2048) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z23 = zChangedInstance11 | z6;
            if ((i14 & 57344) == 16384) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean zChangedInstance12 = z7 | z23 | gapComposer.changedInstance(textInputService3);
            i9 = i7;
            if (i9 == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            i10 = (i14 & 112) ^ 48;
            zChangedInstance = zChangedInstance12 | z8 | ((i10 <= 32 && gapComposer.changed(imeOptions)) || (i14 & 48) == 32) | gapComposer.changedInstance(offsetMapping5) | gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(bringIntoViewRequesterImpl) | gapComposer.changedInstance(textFieldSelectionManager);
            Object objRememberedValue19 = gapComposer.rememberedValue();
            if (zChangedInstance) {
                gapComposer3 = gapComposer;
                textInputService = textInputService3;
                final TextFieldValue textFieldValue6 = textFieldValue2;
                imeOptions2 = imeOptions;
                obj = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        TextLayoutResultProxy layoutResult;
                        FocusStateImpl focusStateImpl = (FocusStateImpl) obj2;
                        LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState4;
                        if (legacyTextFieldState7.getHasFocus() == focusStateImpl.isFocused()) {
                            return Unit.INSTANCE;
                        }
                        legacyTextFieldState7.hasFocus$delegate.setValue(Boolean.valueOf(focusStateImpl.isFocused()));
                        boolean hasFocus = legacyTextFieldState7.getHasFocus();
                        TextFieldValue textFieldValue7 = textFieldValue6;
                        OffsetMapping offsetMapping8 = offsetMapping5;
                        if (hasFocus && z2) {
                            BasicTextKt.startInputSession(textInputService, legacyTextFieldState7, textFieldValue7, imeOptions2, offsetMapping8);
                        } else {
                            BasicTextKt.endInputSession(legacyTextFieldState7);
                        }
                        if (focusStateImpl.isFocused() && (layoutResult = legacyTextFieldState7.getLayoutResult()) != null) {
                            JobKt.launch$default(coroutineScope, null, new RealImageLoader$executeMain$result$1(bringIntoViewRequesterImpl, textFieldValue7, legacyTextFieldState7, layoutResult, offsetMapping8, null, 5), 3);
                        }
                        if (!focusStateImpl.isFocused()) {
                            textFieldSelectionManager.m230deselect_kEHs6E$foundation(null);
                        }
                        return Unit.INSTANCE;
                    }
                };
                z9 = z2;
                textFieldValue4 = textFieldValue6;
                textFieldSelectionManager = textFieldSelectionManager;
                gapComposer3.updateRememberedValue(obj);
            } else {
                gapComposer3 = gapComposer;
                textInputService = textInputService3;
                final TextFieldValue textFieldValue7 = textFieldValue2;
                imeOptions2 = imeOptions;
                obj = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        TextLayoutResultProxy layoutResult;
                        FocusStateImpl focusStateImpl = (FocusStateImpl) obj2;
                        LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState4;
                        if (legacyTextFieldState7.getHasFocus() == focusStateImpl.isFocused()) {
                            return Unit.INSTANCE;
                        }
                        legacyTextFieldState7.hasFocus$delegate.setValue(Boolean.valueOf(focusStateImpl.isFocused()));
                        boolean hasFocus = legacyTextFieldState7.getHasFocus();
                        TextFieldValue textFieldValue8 = textFieldValue7;
                        OffsetMapping offsetMapping8 = offsetMapping5;
                        if (hasFocus && z2) {
                            BasicTextKt.startInputSession(textInputService, legacyTextFieldState7, textFieldValue8, imeOptions2, offsetMapping8);
                        } else {
                            BasicTextKt.endInputSession(legacyTextFieldState7);
                        }
                        if (focusStateImpl.isFocused() && (layoutResult = legacyTextFieldState7.getLayoutResult()) != null) {
                            JobKt.launch$default(coroutineScope, null, new RealImageLoader$executeMain$result$1(bringIntoViewRequesterImpl, textFieldValue8, legacyTextFieldState7, layoutResult, offsetMapping8, null, 5), 3);
                        }
                        if (!focusStateImpl.isFocused()) {
                            textFieldSelectionManager.m230deselect_kEHs6E$foundation(null);
                        }
                        return Unit.INSTANCE;
                    }
                };
                z9 = z2;
                textFieldValue4 = textFieldValue7;
                textFieldSelectionManager = textFieldSelectionManager;
                gapComposer3.updateRememberedValue(obj);
            }
            companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFocusable2 = ImageKt.focusable(FocusTraversalKt.onFocusChanged(FocusTraversalKt.focusRequester(companion, r3), (Function1) obj), z9, mutableInteractionSourceImpl);
            mutableStateRememberUpdatedState = Stack.rememberUpdatedState(Boolean.valueOf(z9), gapComposer3);
            unit = Unit.INSTANCE;
            boolean zChanged7 = gapComposer3.changed(mutableStateRememberUpdatedState) | gapComposer3.changedInstance(legacyTextFieldState4) | gapComposer3.changedInstance(textInputService) | gapComposer3.changedInstance(textFieldSelectionManager);
            if (i10 > 32) {
                legacyTextFieldState = legacyTextFieldState4;
                if ((i14 & 48) != 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else {
                legacyTextFieldState = legacyTextFieldState4;
                if ((i14 & 48) != 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            z11 = zChanged7 | z10;
            Object objRememberedValue110 = gapComposer3.rememberedValue();
            if (z11) {
                unit2 = unit;
                coroutineScope2 = coroutineScope;
                legacyTextFieldState2 = legacyTextFieldState;
                realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(legacyTextFieldState2, mutableStateRememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions2, null, 4);
                mutableState = mutableStateRememberUpdatedState;
                gapComposer3.updateRememberedValue(realImageLoader$executeMain$result$1);
            } else {
                unit2 = unit;
                coroutineScope2 = coroutineScope;
                legacyTextFieldState2 = legacyTextFieldState;
                realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(legacyTextFieldState2, mutableStateRememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions2, null, 4);
                mutableState = mutableStateRememberUpdatedState;
                gapComposer3.updateRememberedValue(realImageLoader$executeMain$result$1);
            }
            Stack.LaunchedEffect(gapComposer3, unit2, (Function2) realImageLoader$executeMain$result$1);
            suspendPointerInputElement = new SuspendPointerInputElement(8675309, null, new ScrimKt$Scrim$dismissModifier$1$1(5, new CoreTextFieldKt$$ExternalSyntheticLambda4(legacyTextFieldState2, 4)), 6);
            menuKt$$ExternalSyntheticLambda0 = new MenuKt$$ExternalSyntheticLambda0(legacyTextFieldState2, (FocusRequester) r3, z2, textFieldSelectionManager, offsetMapping5);
            if (z2) {
                i11 = 2;
                suspendPointerInputElement = suspendPointerInputElement.then(new ComposedModifier(new AlertDialogKt$$ExternalSyntheticLambda14(i11, menuKt$$ExternalSyntheticLambda0, mutableInteractionSourceImpl)));
            } else {
                i11 = 2;
            }
            Modifier modifierThen7 = suspendPointerInputElement.then(new SuspendPointerInputElement(textFieldSelectionManager.mouseSelectionObserver, textFieldSelectionManager.touchSelectionObserver, new ScrimKt$Scrim$dismissModifier$1$1(i11, textFieldSelectionManager), 4));
            PointerIcon.Companion.getClass();
            Modifier modifierThen8 = modifierThen7.then(new PointerHoverIconModifierElement());
            Modifier modifierDrawBehind3 = ClipKt.drawBehind(r28, new LifecycleEffectKt$$ExternalSyntheticLambda1(legacyTextFieldState2, textFieldValue4, offsetMapping5, 7));
            boolean zChangedInstance13 = gapComposer3.changedInstance(legacyTextFieldState2);
            if (i8 == 2048) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean zChanged8 = zChangedInstance13 | z12 | gapComposer3.changed(windowInfo) | gapComposer3.changedInstance(textFieldSelectionManager);
            if (i9 == 4) {
                z13 = true;
            } else {
                z13 = false;
            }
            zChangedInstance2 = zChanged8 | z13 | gapComposer3.changedInstance(offsetMapping5);
            objRememberedValue5 = gapComposer3.rememberedValue();
            if (zChangedInstance2) {
                offsetMapping = offsetMapping5;
                CoreTextFieldKt$$ExternalSyntheticLambda9 coreTextFieldKt$$ExternalSyntheticLambda12 = new CoreTextFieldKt$$ExternalSyntheticLambda9(legacyTextFieldState2, z2, windowInfo, textFieldSelectionManager, textFieldValue4, offsetMapping);
                gapComposer3.updateRememberedValue(coreTextFieldKt$$ExternalSyntheticLambda12);
                objRememberedValue5 = coreTextFieldKt$$ExternalSyntheticLambda12;
            } else {
                offsetMapping = offsetMapping5;
                CoreTextFieldKt$$ExternalSyntheticLambda9 coreTextFieldKt$$ExternalSyntheticLambda13 = new CoreTextFieldKt$$ExternalSyntheticLambda9(legacyTextFieldState2, z2, windowInfo, textFieldSelectionManager, textFieldValue4, offsetMapping);
                gapComposer3.updateRememberedValue(coreTextFieldKt$$ExternalSyntheticLambda13);
                objRememberedValue5 = coreTextFieldKt$$ExternalSyntheticLambda13;
            }
            Modifier modifierOnGloballyPositioned3 = RulerKt.onGloballyPositioned(r28, (Function1) objRememberedValue5);
            LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState2;
            offsetMapping2 = offsetMapping;
            textInputService2 = textInputService;
            textFieldSelectionManager2 = textFieldSelectionManager;
            coreTextFieldSemanticsModifier = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState7, z2, offsetMapping2, textFieldSelectionManager2, imeOptions, focusRequester);
            legacyTextFieldState3 = legacyTextFieldState7;
            if (!z2) {
                z14 = false;
            } else {
                z14 = false;
            }
            if (z14) {
                coreTextFieldSemanticsModifier2 = coreTextFieldSemanticsModifier;
                SnackbarHostKt$$ExternalSyntheticLambda1 snackbarHostKt$$ExternalSyntheticLambda3 = new SnackbarHostKt$$ExternalSyntheticLambda1(solidColor, legacyTextFieldState3, textFieldValue, offsetMapping2, 2);
                legacyTextFieldState3 = legacyTextFieldState3;
                offsetMapping3 = offsetMapping2;
                modifierThen = companion.then(new ComposedModifier(snackbarHostKt$$ExternalSyntheticLambda3));
            } else {
                offsetMapping3 = offsetMapping2;
                coreTextFieldSemanticsModifier2 = coreTextFieldSemanticsModifier;
                modifierThen = r28;
            }
            zChangedInstance3 = gapComposer3.changedInstance(textFieldSelectionManager2);
            objRememberedValue6 = gapComposer3.rememberedValue();
            if (zChangedInstance3) {
                objRememberedValue6 = new CoreTextFieldKt$$ExternalSyntheticLambda10(textFieldSelectionManager2, 0);
                gapComposer3.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new CoreTextFieldKt$$ExternalSyntheticLambda10(textFieldSelectionManager2, 0);
                gapComposer3.updateRememberedValue(objRememberedValue6);
            }
            Stack.DisposableEffect(textFieldSelectionManager2, (Function1) objRememberedValue6, gapComposer3);
            boolean zChangedInstance14 = gapComposer3.changedInstance(legacyTextFieldState3) | gapComposer3.changedInstance(textInputService2);
            if (i9 == 4) {
                z15 = true;
            } else {
                z15 = false;
            }
            z16 = zChangedInstance14 | z15 | ((i10 <= 32 && gapComposer3.changed(imeOptions)) || (i14 & 48) == 32);
            objRememberedValue7 = gapComposer3.rememberedValue();
            if (z16) {
                FilesActivity$$ExternalSyntheticLambda10 filesActivity$$ExternalSyntheticLambda13 = new FilesActivity$$ExternalSyntheticLambda10(legacyTextFieldState3, textInputService2, textFieldValue, imeOptions, 4);
                imeOptions3 = imeOptions;
                gapComposer3.updateRememberedValue(filesActivity$$ExternalSyntheticLambda13);
                objRememberedValue7 = filesActivity$$ExternalSyntheticLambda13;
            } else {
                FilesActivity$$ExternalSyntheticLambda10 filesActivity$$ExternalSyntheticLambda14 = new FilesActivity$$ExternalSyntheticLambda10(legacyTextFieldState3, textInputService2, textFieldValue, imeOptions, 4);
                imeOptions3 = imeOptions;
                gapComposer3.updateRememberedValue(filesActivity$$ExternalSyntheticLambda14);
                objRememberedValue7 = filesActivity$$ExternalSyntheticLambda14;
            }
            Stack.DisposableEffect(imeOptions3, (Function1) objRememberedValue7, gapComposer3);
            final Function1 coreTextFieldKt$$ExternalSyntheticLambda6 = legacyTextFieldState3.onValueChange;
            if (i == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            final int i110 = imeOptions3.imeAction;
            CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier5 = coreTextFieldSemanticsModifier2;
            final OffsetMapping offsetMapping8 = offsetMapping3;
            final boolean z24 = true;
            ComposedModifier composedModifier3 = new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.text.TextFieldKeyInputKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    GapComposer gapComposer4 = (GapComposer) obj3;
                    ((Integer) obj4).getClass();
                    gapComposer4.startReplaceGroup(851809892);
                    Object objRememberedValue111 = gapComposer4.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                    if (objRememberedValue111 == neverEqualPolicy2) {
                        objRememberedValue111 = new TextPreparedSelectionState();
                        gapComposer4.updateRememberedValue(objRememberedValue111);
                    }
                    TextPreparedSelectionState textPreparedSelectionState = (TextPreparedSelectionState) objRememberedValue111;
                    Object objRememberedValue112 = gapComposer4.rememberedValue();
                    if (objRememberedValue112 == neverEqualPolicy2) {
                        objRememberedValue112 = new DeadKeyCombiner();
                        gapComposer4.updateRememberedValue(objRememberedValue112);
                    }
                    TextFieldKeyInput textFieldKeyInput = new TextFieldKeyInput(legacyTextFieldState3, textFieldSelectionManager2, textFieldValue, z24, z17, textPreparedSelectionState, offsetMapping8, undoManager, (DeadKeyCombiner) objRememberedValue112, coreTextFieldKt$$ExternalSyntheticLambda6, i110);
                    boolean zChangedInstance15 = gapComposer4.changedInstance(textFieldKeyInput);
                    Object objRememberedValue20 = gapComposer4.rememberedValue();
                    if (zChangedInstance15 || objRememberedValue20 == neverEqualPolicy2) {
                        JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, textFieldKeyInput, TextFieldKeyInput.class, "process", "process-ZmokQxo(Landroid/view/KeyEvent;)Z", 0, 0, 2);
                        gapComposer4.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$1);
                        objRememberedValue20 = jobKt__JobKt$invokeOnCompletion$1;
                    }
                    Modifier modifierOnKeyEvent = Key_androidKt.onKeyEvent(Modifier.Companion.$$INSTANCE, (Function1) ((FunctionReferenceImpl) objRememberedValue20));
                    gapComposer4.end(false);
                    return modifierOnKeyEvent;
                }
            });
            i12 = imeOptions3.keyboardType;
            if (i12 == 7) {
                z18 = false;
            } else {
                z18 = true;
            }
            boolean zBooleanValue3 = ((Boolean) mutableState.getValue()).booleanValue();
            zChanged = gapComposer3.changed(z18) | gapComposer3.changedInstance(androidLegacyPlatformTextInputServiceAdapter);
            objRememberedValue8 = gapComposer3.rememberedValue();
            if (zChanged) {
                objRememberedValue8 = new CoreTextFieldKt$$ExternalSyntheticLambda12(z18, androidLegacyPlatformTextInputServiceAdapter);
                gapComposer3.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new CoreTextFieldKt$$ExternalSyntheticLambda12(z18, androidLegacyPlatformTextInputServiceAdapter);
                gapComposer3.updateRememberedValue(objRememberedValue8);
            }
            Modifier modifierStylusHandwriting3 = StylusHandwritingKt.stylusHandwriting(zBooleanValue3, z18, (Function0) objRememberedValue8);
            solidColor2 = (Brush) gapComposer3.consume(AutofillHighlightKt.LocalAutofillHighlightBrush);
            j3 = ((Color) gapComposer3.consume(AutofillHighlightKt.LocalAutofillHighlightColor)).value;
            if (!Color.m435equalsimpl0(j3, BrushKt.Color(1308617531))) {
                solidColor2 = new SolidColor(j3);
            }
            zChangedInstance4 = gapComposer3.changedInstance(legacyTextFieldState3) | gapComposer3.changed(solidColor2);
            objRememberedValue9 = gapComposer3.rememberedValue();
            if (zChangedInstance4) {
                objRememberedValue9 = new BackHandlerKt$$ExternalSyntheticLambda2(26, legacyTextFieldState3, solidColor2);
                gapComposer3.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new BackHandlerKt$$ExternalSyntheticLambda2(26, legacyTextFieldState3, solidColor2);
                gapComposer3.updateRememberedValue(objRememberedValue9);
            }
            Modifier modifierAddTextContextMenuComponentsWithContext3 = TextContextMenuModifierKt.addTextContextMenuComponentsWithContext(RulerKt.onGloballyPositioned(Key_androidKt.onPreviewKeyEvent(Key_androidKt.onPreviewKeyEvent(HandwritingGestureApi34.legacyTextInputAdapter(modifier.then(ClipKt.drawWithContent(r28, (Function1) objRememberedValue9)), androidLegacyPlatformTextInputServiceAdapter, legacyTextFieldState3, textFieldSelectionManager2).then(modifierStylusHandwriting3).then(modifierFocusable2), new ContinuationCallback(2, focusOwner, legacyTextFieldState3)), new ContinuationCallback(1, legacyTextFieldState3, textFieldSelectionManager2)).then(composedModifier3).then(new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldScrollerPosition2.orientation$delegate;
                    GapComposer gapComposer4 = (GapComposer) obj3;
                    ((Integer) obj4).getClass();
                    gapComposer4.startReplaceGroup(-2137546592);
                    boolean z25 = ((Orientation) parcelableSnapshotMutableState.getValue()) == Orientation.Vertical || !(gapComposer4.consume(CompositionLocalsKt.LocalLayoutDirection) == LayoutDirection.Rtl);
                    boolean zChanged9 = gapComposer4.changed(textFieldScrollerPosition2);
                    Object objRememberedValue111 = gapComposer4.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                    if (zChanged9 || objRememberedValue111 == neverEqualPolicy2) {
                        objRememberedValue111 = new Recomposer$$ExternalSyntheticLambda0(15, textFieldScrollerPosition2);
                        gapComposer4.updateRememberedValue(objRememberedValue111);
                    }
                    MutableState mutableStateRememberUpdatedState2 = Stack.rememberUpdatedState((Function1) objRememberedValue111, gapComposer4);
                    Object objRememberedValue112 = gapComposer4.rememberedValue();
                    if (objRememberedValue112 == neverEqualPolicy2) {
                        DefaultScrollableState defaultScrollableState = new DefaultScrollableState(new TooltipKt$$ExternalSyntheticLambda7(mutableStateRememberUpdatedState2, 1));
                        gapComposer4.updateRememberedValue(defaultScrollableState);
                        objRememberedValue112 = defaultScrollableState;
                    }
                    ScrollableState scrollableState = (ScrollableState) objRememberedValue112;
                    boolean zChanged10 = gapComposer4.changed(scrollableState) | gapComposer4.changed(textFieldScrollerPosition2);
                    Object objRememberedValue20 = gapComposer4.rememberedValue();
                    if (zChanged10 || objRememberedValue20 == neverEqualPolicy2) {
                        objRememberedValue20 = new ScrollableState(textFieldScrollerPosition2) { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1
                            public final DerivedSnapshotState canScrollBackward$delegate;
                            public final DerivedSnapshotState canScrollForward$delegate;

                            {
                                final int i111 = 0;
                                this.canScrollForward$delegate = Stack.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        switch (i111) {
                                            case 0:
                                                TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                return Boolean.valueOf(textFieldScrollerPosition3.offset$delegate.getFloatValue() < textFieldScrollerPosition3.maximum$delegate.getFloatValue());
                                            default:
                                                return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() > 0.0f);
                                        }
                                    }
                                });
                                final int i20 = 1;
                                this.canScrollBackward$delegate = Stack.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        switch (i20) {
                                            case 0:
                                                TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                return Boolean.valueOf(textFieldScrollerPosition3.offset$delegate.getFloatValue() < textFieldScrollerPosition3.maximum$delegate.getFloatValue());
                                            default:
                                                return Boolean.valueOf(textFieldScrollerPosition2.offset$delegate.getFloatValue() > 0.0f);
                                        }
                                    }
                                });
                            }

                            @Override // androidx.compose.foundation.gestures.ScrollableState
                            public final float dispatchRawDelta(float f) {
                                return this.$$delegate_0.dispatchRawDelta(f);
                            }

                            @Override // androidx.compose.foundation.gestures.ScrollableState
                            public final boolean getCanScrollBackward() {
                                return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
                            }

                            @Override // androidx.compose.foundation.gestures.ScrollableState
                            public final boolean getCanScrollForward() {
                                return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
                            }

                            @Override // androidx.compose.foundation.gestures.ScrollableState
                            public final boolean isScrollInProgress() {
                                return this.$$delegate_0.isScrollInProgress();
                            }

                            @Override // androidx.compose.foundation.gestures.ScrollableState
                            public final Object scroll(MutatePriority mutatePriority, Function2 function3, ContinuationImpl continuationImpl) {
                                return this.$$delegate_0.scroll(mutatePriority, function3, continuationImpl);
                            }
                        };
                        gapComposer4.updateRememberedValue(objRememberedValue20);
                    }
                    Modifier modifierScrollable$default = ScrollableKt.scrollable$default((TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) objRememberedValue20, (Orientation) parcelableSnapshotMutableState.getValue(), z2 && textFieldScrollerPosition2.maximum$delegate.getFloatValue() != 0.0f, z25, mutableInteractionSourceImpl);
                    gapComposer4.end(false);
                    return modifierScrollable$default;
                }
            })).then(modifierThen8).then(coreTextFieldSemanticsModifier5), new CoreTextFieldKt$$ExternalSyntheticLambda4(legacyTextFieldState3, 0)), new TextKt$$ExternalSyntheticLambda2(10, textFieldSelectionManager2, coroutineScope2));
            if (!z2) {
            }
            if (i13 == 0) {
                modifierThen2 = r28;
            } else {
                modifierThen2 = r28;
            }
            gapComposer2 = gapComposer;
            CoreTextFieldRootBox(modifierAddTextContextMenuComponentsWithContext3, textFieldSelectionManager2, Thread_jvmKt.rememberComposableLambda(-814563849, new OutlinedTextFieldKt$$ExternalSyntheticLambda1(composableLambdaImpl, legacyTextFieldState3, textStyle, i2, i, textFieldScrollerPosition, textFieldValue, zslControlImpl$$ExternalSyntheticLambda0, modifierThen, modifierDrawBehind3, modifierOnGloballyPositioned3, modifierThen2, bringIntoViewRequesterImpl, textFieldSelectionManager2, (boolean) i13, function2, offsetMapping8, density2), gapComposer2), gapComposer2, 384);
        } else {
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CoreTextFieldKt$$ExternalSyntheticLambda6(textFieldValue, function1, modifier, textStyle, zslControlImpl$$ExternalSyntheticLambda0, function2, mutableInteractionSourceImpl, solidColor, z, i, i2, imeOptions, keyboardActions, z2, composableLambdaImpl, i3, i4);
        }
    }

    public static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(2036174316);
        int i2 = (gapComposer.changed(modifier) ? 4 : 2) | i | (gapComposer.changedInstance(textFieldSelectionManager) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
            long j = gapComposer.compositeKeyHashCode;
            int i3 = (int) ((j >>> 32) ^ j);
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            ContextMenuArea(textFieldSelectionManager, composableLambdaImpl, gapComposer, (i2 >> 3) & 126);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(modifier, textFieldSelectionManager, composableLambdaImpl, i, 2);
        }
    }

    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager textFieldSelectionManager, boolean z, GapComposer gapComposer, int i) {
        TextLayoutResultProxy layoutResult;
        gapComposer.startRestartGroup(626339208);
        int i2 = (gapComposer.changedInstance(textFieldSelectionManager) ? 4 : 2) | i | (gapComposer.changed(z) ? 32 : 16);
        int i3 = 1;
        if (!gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.skipToGroupEnd();
        } else if (z) {
            gapComposer.startReplaceGroup(1530097388);
            LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
            TextLayoutResult textLayoutResult = null;
            if (legacyTextFieldState != null && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
                TextLayoutResult textLayoutResult2 = layoutResult.value;
                LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                if (!(legacyTextFieldState2 != null ? legacyTextFieldState2.isLayoutResultStale : true)) {
                    textLayoutResult = textLayoutResult2;
                }
            }
            if (textLayoutResult == null) {
                gapComposer.startReplaceGroup(1530097387);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1530097388);
                if (TextRange.m641getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection)) {
                    gapComposer.startReplaceGroup(2110860558);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(2109807302);
                    int iOriginalToTransformed = textFieldSelectionManager.offsetMapping.originalToTransformed((int) (textFieldSelectionManager.getValue$foundation().selection >> 32));
                    int iOriginalToTransformed2 = textFieldSelectionManager.offsetMapping.originalToTransformed((int) (textFieldSelectionManager.getValue$foundation().selection & 4294967295L));
                    int bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                    int bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                    LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager.state;
                    if (legacyTextFieldState3 == null || !((Boolean) legacyTextFieldState3.showSelectionHandleStart$delegate.getValue()).booleanValue()) {
                        gapComposer.startReplaceGroup(2110490542);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(2110225306);
                        SimpleLayoutKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, gapComposer, ((i2 << 6) & 896) | 6);
                        gapComposer.end(false);
                    }
                    LegacyTextFieldState legacyTextFieldState4 = textFieldSelectionManager.state;
                    if (legacyTextFieldState4 == null || !((Boolean) legacyTextFieldState4.showSelectionHandleEnd$delegate.getValue()).booleanValue()) {
                        gapComposer.startReplaceGroup(2110838734);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(2110574459);
                        SimpleLayoutKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, gapComposer, ((i2 << 6) & 896) | 6);
                        gapComposer.end(false);
                    }
                    gapComposer.end(false);
                }
                LegacyTextFieldState legacyTextFieldState5 = textFieldSelectionManager.state;
                if (legacyTextFieldState5 != null) {
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = legacyTextFieldState5.showFloatingToolbar$delegate;
                    if (!Intrinsics.areEqual(textFieldSelectionManager.oldValue.annotatedString.text, textFieldSelectionManager.getValue$foundation().annotatedString.text)) {
                        parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                    }
                    if (legacyTextFieldState5.getHasFocus()) {
                        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
                gapComposer.end(false);
            }
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(1989076778);
            gapComposer.end(false);
            textFieldSelectionManager.hideSelectionToolbar$foundation();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogcatActivity$$ExternalSyntheticLambda4(i, i3, textFieldSelectionManager, z);
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, GapComposer gapComposer, int i) {
        AnnotatedString transformedText$foundation;
        gapComposer.startRestartGroup(-1436003720);
        int i2 = 2;
        int i3 = (gapComposer.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        int i4 = 0;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 3) != 2)) {
            LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
            if (legacyTextFieldState == null || !((Boolean) legacyTextFieldState.showCursorHandle$delegate.getValue()).booleanValue() || (transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation()) == null || transformedText$foundation.text.length() <= 0) {
                gapComposer.startReplaceGroup(-2111042550);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-2112351432);
                boolean zChanged = gapComposer.changed(textFieldSelectionManager);
                Object objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                if (zChanged || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
                        @Override // androidx.compose.foundation.text.TextDragObserver
                        /* JADX INFO: renamed from: onDrag-k-4lQ0M */
                        public final void mo175onDragk4lQ0M(long j) {
                            TextLayoutResultProxy layoutResult;
                            HapticFeedback hapticFeedback;
                            TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                            textFieldSelectionManager2.dragTotalDistance = Offset.m373plusMKHz9U(textFieldSelectionManager2.dragTotalDistance, j);
                            LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager2.state;
                            if (legacyTextFieldState2 == null || (layoutResult = legacyTextFieldState2.getLayoutResult()) == null) {
                                return;
                            }
                            textFieldSelectionManager2.currentDragPosition$delegate.setValue(new Offset(Offset.m373plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                            int iTransformedToOriginal = textFieldSelectionManager2.offsetMapping.transformedToOriginal(layoutResult.m178getOffsetForPosition3MmeM6k(textFieldSelectionManager2.m231getCurrentDragPosition_m7T9E().packedValue, true));
                            long jTextRange = ParagraphKt.TextRange(iTransformedToOriginal, iTransformedToOriginal);
                            if (TextRange.m640equalsimpl0(jTextRange, textFieldSelectionManager2.getValue$foundation().selection)) {
                                return;
                            }
                            LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager2.state;
                            if ((legacyTextFieldState3 == null || ((Boolean) legacyTextFieldState3.isInTouchMode$delegate.getValue()).booleanValue()) && (hapticFeedback = textFieldSelectionManager2.hapticFeedBack) != null) {
                                ((PlatformHapticFeedback) hapticFeedback).m503performHapticFeedbackCdsT49E(9);
                            }
                            textFieldSelectionManager2.onValueChange.invoke(TextFieldSelectionManager.m229createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation().annotatedString, jTextRange));
                            textFieldSelectionManager2.latestSelection = new TextRange(jTextRange);
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        /* JADX INFO: renamed from: onStart-3MmeM6k */
                        public final void mo176onStart3MmeM6k(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0) {
                            TextLayoutResultProxy layoutResult;
                            TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                            long jM218getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m218getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager2.m232getHandlePositiontuRUvjQ$foundation(true));
                            LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager2.state;
                            if (legacyTextFieldState2 == null || (layoutResult = legacyTextFieldState2.getLayoutResult()) == null) {
                                return;
                            }
                            long jM181translateInnerToDecorationCoordinatesMKHz9U$foundation = layoutResult.m181translateInnerToDecorationCoordinatesMKHz9U$foundation(jM218getAdjustedCoordinatesk4lQ0M);
                            textFieldSelectionManager2.dragBeginPosition = jM181translateInnerToDecorationCoordinatesMKHz9U$foundation;
                            textFieldSelectionManager2.currentDragPosition$delegate.setValue(new Offset(jM181translateInnerToDecorationCoordinatesMKHz9U$foundation));
                            textFieldSelectionManager2.dragTotalDistance = 0L;
                            textFieldSelectionManager2.draggingHandle$delegate.setValue(Handle.Cursor);
                            textFieldSelectionManager2.updateFloatingToolbar(false);
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        public final void onStop() {
                            TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                            textFieldSelectionManager2.draggingHandle$delegate.setValue(null);
                            textFieldSelectionManager2.currentDragPosition$delegate.setValue(null);
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        public final void onUp() {
                            TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                            textFieldSelectionManager2.draggingHandle$delegate.setValue(null);
                            textFieldSelectionManager2.currentDragPosition$delegate.setValue(null);
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        public final void onCancel() {
                        }

                        @Override // androidx.compose.foundation.text.TextDragObserver
                        /* JADX INFO: renamed from: onDown-k-4lQ0M */
                        public final void mo174onDownk4lQ0M() {
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                long j = textFieldSelectionManager.getValue$foundation().selection;
                int i5 = TextRange.$r8$clinit;
                int iOriginalToTransformed = offsetMapping.originalToTransformed((int) (j >> 32));
                LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                TextLayoutResult textLayoutResult = (legacyTextFieldState2 != null ? legacyTextFieldState2.getLayoutResult() : null).value;
                Rect cursorRect = textLayoutResult.getCursorRect(RangesKt.coerceIn(iOriginalToTransformed, 0, textLayoutResult.layoutInput.text.text.length()));
                final long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((density.mo92toPx0680j_4(TextFieldCursor_androidKt.DefaultCursorThickness) / 2) + cursorRect.left)) << 32) | (((long) Float.floatToRawIntBits(cursorRect.bottom)) & 4294967295L);
                boolean zChanged2 = gapComposer.changed(jFloatToRawIntBits);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* JADX INFO: renamed from: provide-F1C5BW0, reason: not valid java name */
                        public final long mo169provideF1C5BW0() {
                            return jFloatToRawIntBits;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) objRememberedValue2;
                boolean zChangedInstance = gapComposer.changedInstance(textDragObserver) | gapComposer.changedInstance(textFieldSelectionManager);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(i4, textDragObserver, textFieldSelectionManager);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                SuspendPointerInputElement suspendPointerInputElement = new SuspendPointerInputElement(textDragObserver, null, (PointerInputEventHandler) objRememberedValue3, 6);
                boolean zChanged3 = gapComposer.changed(jFloatToRawIntBits);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new BroadcastFrameClock$$ExternalSyntheticLambda0(i2, jFloatToRawIntBits);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                AndroidCursorHandle_androidKt.m165CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics(suspendPointerInputElement, false, (Function1) objRememberedValue4), 0L, gapComposer, 0);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Updater$$ExternalSyntheticLambda0(i, 8, textFieldSelectionManager);
        }
    }

    public static final Rect access$getCursorRectInScroller(Placeable.PlacementScope placementScope, int i, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z, int i2) {
        Rect cursorRect = textLayoutResult != null ? textLayoutResult.getCursorRect(transformedText.offsetMapping.originalToTransformed(i)) : Rect.Zero;
        float f = cursorRect.left;
        float f2 = TextFieldCursor_androidKt.DefaultCursorThickness;
        placementScope.getClass();
        int iM695$default$roundToPx0680j_4 = Density.CC.m695$default$roundToPx0680j_4(placementScope, f2);
        return Rect.copy$default(cursorRect, z ? (i2 - f) - iM695$default$roundToPx0680j_4 : f, z ? i2 - f : iM695$default$roundToPx0680j_4 + f, 0.0f, 10);
    }

    /* JADX INFO: renamed from: access$isKeyCode-YhN2O0w, reason: not valid java name */
    public static final boolean m167access$isKeyCodeYhN2O0w(int i, KeyEvent keyEvent) {
        return ((int) (Key_androidKt.m505getKeyZmokQxo(keyEvent) >> 32)) == i;
    }

    public static final int ceilToIntPx(float f) {
        return Math.round((float) Math.ceil(f));
    }

    public static final Object detectDownAndDragGesturesWithObserver(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation continuation) {
        Object objCoroutineScope = JobKt.coroutineScope(new LogcatActivity$writeLogTo$2$1(pointerInputScope, textDragObserver, null, 1), continuation);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession textInputSession = legacyTextFieldState.inputSession;
        if (textInputSession != null) {
            legacyTextFieldState.onValueChange.invoke(TextFieldValue.m663copy3r_uNRQ$default((TextFieldValue) legacyTextFieldState.processor.systemCallbacks, null, 0L, 3));
            TextInputService textInputService = textInputSession.textInputService;
            AtomicReference atomicReference = textInputService._currentInputSession;
            while (!atomicReference.compareAndSet(textInputSession, null)) {
                if (atomicReference.get() != textInputSession) {
                }
            }
            textInputService.platformTextInputService.stopInput();
        }
        legacyTextFieldState.inputSession = null;
    }

    public static final TransformedText filterWithValidation(ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0, AnnotatedString annotatedString) {
        zslControlImpl$$ExternalSyntheticLambda0.getClass();
        int length = annotatedString.text.length();
        int length2 = annotatedString.text.length();
        int iMin = Math.min(length, 100);
        for (int i = 0; i < iMin; i++) {
            validateOriginalToTransformed(i, length2, i);
        }
        validateOriginalToTransformed(length, length2, length);
        int iMin2 = Math.min(length2, 100);
        for (int i2 = 0; i2 < iMin2; i2++) {
            validateTransformedToOriginal(i2, length, i2);
        }
        validateTransformedToOriginal(length2, length, length2);
        return new TransformedText(annotatedString, new NavOptions.Builder(annotatedString.text.length(), annotatedString.text.length()));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.text.BreakIterator] */
    /* JADX WARN: Type inference failed for: r4v2, types: [coil.ImageLoader$Builder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final int findFollowingBreak(String str, int i) {
        ?? r5;
        ?? r6;
        int spanEnd;
        EmojiCompat emojiCompatIfLoaded = getEmojiCompatIfLoaded();
        Integer num = null;
        if (emojiCompatIfLoaded != null) {
            Preconditions.checkState("Not initialized yet", emojiCompatIfLoaded.getLoadState() == 1);
            Preconditions.checkNotNull(str, "charSequence cannot be null");
            ?? r4 = emojiCompatIfLoaded.mHelper.mProcessor;
            r4.getClass();
            if (i < 0 || i >= str.length()) {
                r6 = str;
                spanEnd = -1;
            } else if (str instanceof Spanned) {
                Spanned spanned = (Spanned) str;
                TypefaceEmojiSpan[] typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) spanned.getSpans(i, i + 1, TypefaceEmojiSpan.class);
                if (typefaceEmojiSpanArr.length > 0) {
                    spanEnd = spanned.getSpanEnd(typefaceEmojiSpanArr[0]);
                    r6 = str;
                } else {
                    ?? r7 = str;
                    spanEnd = ((EmojiProcessor$EmojiProcessLookupCallback) r4.process(r7, Math.max(0, i - 16), Math.min(str.length(), i + 16), Integer.MAX_VALUE, true, new EmojiProcessor$EmojiProcessLookupCallback(i))).end;
                    r6 = r7;
                }
            } else {
                ?? r8 = str;
                spanEnd = ((EmojiProcessor$EmojiProcessLookupCallback) r4.process(r8, Math.max(0, i - 16), Math.min(str.length(), i + 16), Integer.MAX_VALUE, true, new EmojiProcessor$EmojiProcessLookupCallback(i))).end;
                r6 = r8;
            }
            Integer numValueOf = Integer.valueOf(spanEnd);
            r5 = r6;
            if (spanEnd != -1) {
                num = numValueOf;
            }
        } else {
            r5 = str;
        }
        if (num != null) {
            r5 = r6;
            return num.intValue();
        }
        r5 = r6;
        ?? characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(r5);
        return characterInstance.following(i);
    }

    public static final int findParagraphEnd(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            if (charSequence.charAt(i) == '\n') {
                return i;
            }
            i++;
        }
        return charSequence.length();
    }

    public static final int findParagraphStart(CharSequence charSequence, int i) {
        while (i > 0) {
            if (charSequence.charAt(i - 1) == '\n') {
                return i;
            }
            i--;
        }
        return 0;
    }

    public static final int findPrecedingBreak(String str, int i) {
        EmojiCompat emojiCompatIfLoaded = getEmojiCompatIfLoaded();
        Integer num = null;
        if (emojiCompatIfLoaded != null) {
            Integer numValueOf = Integer.valueOf(emojiCompatIfLoaded.getEmojiStart(str, Math.max(0, i - 1)));
            if (numValueOf.intValue() != -1) {
                num = numValueOf;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(str);
        return characterInstance.preceding(i);
    }

    public static final EmojiCompat getEmojiCompatIfLoaded() {
        if (!EmojiCompat.isConfigured()) {
            return null;
        }
        EmojiCompat emojiCompat = EmojiCompat.get();
        if (emojiCompat.getLoadState() == 1) {
            return emojiCompat;
        }
        return null;
    }

    public static final float getLineHeight(TextLayoutResult textLayoutResult, int i) {
        if (i < 0) {
            return 0.0f;
        }
        TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        if (textLayoutInput.text.text.length() == 0) {
            return 0.0f;
        }
        int iMin = Math.min(multiParagraph.getLineForOffset(i), Math.min(multiParagraph.maxLines - 1, multiParagraph.lineCount - 1));
        if (i > multiParagraph.getLineEnd(iMin, false)) {
            return 0.0f;
        }
        multiParagraph.requireLineIndexInRange(iMin);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByLineIndex(iMin, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int i2 = iMin - paragraphInfo.startLineIndex;
        TextLayout textLayout = androidParagraph.layout;
        return textLayout.getLineBottom(i2) - textLayout.getLineTop(i2);
    }

    /* JADX INFO: renamed from: getModifiers-ZmokQxo, reason: not valid java name */
    public static final int m168getModifiersZmokQxo(KeyEvent keyEvent) {
        return (keyEvent.isAltPressed() ? 1 : 0) | (keyEvent.isCtrlPressed() ? 2 : 0) | (keyEvent.isMetaPressed() ? 4 : 0) | (keyEvent.isShiftPressed() ? 8 : 0);
    }

    public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult == null) {
                return;
            }
            TextInputSession textInputSession = legacyTextFieldState.inputSession;
            if (textInputSession == null) {
                return;
            }
            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
            if (layoutCoordinates == null) {
                return;
            }
            notifyFocusedRect$foundation(textFieldValue, legacyTextFieldState.textDelegate, layoutResult.value, layoutCoordinates, textInputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
            Unit unit = Unit.INSTANCE;
        } finally {
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    public static void notifyFocusedRect$foundation(TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, TextInputSession textInputSession, boolean z, OffsetMapping offsetMapping) {
        Rect boundingBox;
        if (z) {
            int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m643getMaximpl(textFieldValue.selection));
            String str = TextFieldDelegateKt.EmptyTextReplacement;
            if (iOriginalToTransformed < textLayoutResult.layoutInput.text.text.length()) {
                boundingBox = textLayoutResult.getBoundingBox(iOriginalToTransformed);
            } else {
                boundingBox = iOriginalToTransformed != 0 ? textLayoutResult.getBoundingBox(iOriginalToTransformed - 1) : new Rect(0.0f, 0.0f, 1.0f, (int) (TextFieldDelegateKt.computeSizeForDefaultText(textDelegate.style, textDelegate.density, textDelegate.fontFamilyResolver, TextFieldDelegateKt.EmptyTextReplacement, 1) & 4294967295L));
            }
            float f = boundingBox.top;
            float f2 = boundingBox.left;
            long jMo525localToRootMKHz9U = layoutCoordinates.mo525localToRootMKHz9U((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
            Rect rectM382Recttz77jQw = RectKt.m382Recttz77jQw((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo525localToRootMKHz9U & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo525localToRootMKHz9U >> 32)))) << 32), (((long) Float.floatToRawIntBits(boundingBox.right - f2)) << 32) | (((long) Float.floatToRawIntBits(boundingBox.bottom - f)) & 4294967295L));
            if (Intrinsics.areEqual((TextInputSession) textInputSession.textInputService._currentInputSession.get(), textInputSession)) {
                textInputSession.platformTextInputService.notifyFocusedRect(rectM382Recttz77jQw);
            }
        }
    }

    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        RequestService requestService = legacyTextFieldState.processor;
        CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4 = legacyTextFieldState.onValueChange;
        CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda5 = legacyTextFieldState.onImeActionPerformed;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        LifecycleEffectKt$$ExternalSyntheticLambda1 lifecycleEffectKt$$ExternalSyntheticLambda1 = new LifecycleEffectKt$$ExternalSyntheticLambda1((Object) requestService, (Function1) coreTextFieldKt$$ExternalSyntheticLambda4, (Object) ref$ObjectRef, 8);
        PlatformTextInputService platformTextInputService = textInputService.platformTextInputService;
        platformTextInputService.startInput(textFieldValue, imeOptions, lifecycleEffectKt$$ExternalSyntheticLambda1, coreTextFieldKt$$ExternalSyntheticLambda5);
        TextInputSession textInputSession = new TextInputSession(textInputService, platformTextInputService);
        textInputService._currentInputSession.set(textInputSession);
        ref$ObjectRef.element = textInputSession;
        legacyTextFieldState.inputSession = textInputSession;
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    public static final void validateMinMaxLines(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            InlineClassHelperKt.throwIllegalArgumentException("both minLines " + i + " and maxLines " + i2 + " must be greater than zero");
        }
        if (i <= i2) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("minLines " + i + " must be less than or equal to maxLines " + i2);
    }

    public static final void validateOriginalToTransformed(int i, int i2, int i3) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("OffsetMapping.originalToTransformed returned invalid mapping: " + i3 + " -> " + i + " is not in range of transformed text [0, " + i2 + ']');
    }

    public static final void validateTransformedToOriginal(int i, int i2, int i3) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("OffsetMapping.transformedToOriginal returned invalid mapping: " + i3 + " -> " + i + " is not in range of original text [0, " + i2 + ']');
    }

    public static final void ContextMenuArea(SelectionManager selectionManager, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-954926513);
        int i2 = (gapComposer.changedInstance(selectionManager) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            CommonContextMenuArea(selectionManager, composableLambdaImpl, gapComposer, i2 & 126);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ContextMenu_androidKt$$ExternalSyntheticLambda0(selectionManager, composableLambdaImpl, i, 0);
        }
    }

    public static final void CommonContextMenuArea(SelectionManager selectionManager, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-614342087);
        int i2 = (gapComposer.changedInstance(selectionManager) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.startReplaceGroup(-1009319487);
            Continuation continuation = null;
            AndroidTextContextMenuToolbarProvider_androidKt.ProvideDefaultPlatformTextContextMenuProviders(TextContextMenuModifierKt.textContextMenuToolbarHandler(TextContextMenuModifierKt.showTextContextMenuOnSecondaryClick(new ThumbNode.AnonymousClass1(selectionManager, continuation, 9)), selectionManager.toolbarRequester, new TooltipStateImpl$show$cancellableShow$1(selectionManager, continuation, 1), null, new SelectionManager$$ExternalSyntheticLambda1(selectionManager, 4)), composableLambdaImpl, gapComposer, 48);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ContextMenu_androidKt$$ExternalSyntheticLambda0(selectionManager, composableLambdaImpl, i, 1);
        }
    }
}
