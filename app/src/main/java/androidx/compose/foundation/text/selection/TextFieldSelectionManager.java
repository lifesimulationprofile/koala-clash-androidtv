package androidx.compose.foundation.text.selection;

import android.content.ClipDescription;
import androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.platform.AndroidClipboard;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import coil.memory.RealWeakMemoryCache;
import com.google.android.gms.tasks.zzr;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager {
    public Clipboard clipboard;
    public CoroutineScope coroutineScope;
    public final ParcelableSnapshotMutableState currentDragPosition$delegate;
    public long dragBeginPosition;
    public TextRange dragBeginSelection;
    public long dragTotalDistance;
    public final ParcelableSnapshotMutableState draggingHandle$delegate;
    public final ParcelableSnapshotMutableState editable$delegate;
    public final ParcelableSnapshotMutableState enabled$delegate;
    public FocusRequester focusRequester;
    public HapticFeedback hapticFeedBack;
    public final ParcelableSnapshotMutableState hasAvailableTextToPaste$delegate;
    public TextRange latestSelection;
    public final zzr mouseSelectionObserver;
    public TextFieldValue oldValue;
    public PlatformSelectionBehaviorsImpl platformSelectionBehaviors;
    public int previousRawDragOffset;
    public SingleSelectionLayout previousSelectionLayout;
    public Function0 requestAutofillAction;
    public LegacyTextFieldState state;
    public boolean textToolbarShownViaProvider;
    public final RealWeakMemoryCache toolbarRequester;
    public final TextFieldSelectionManager$touchSelectionObserver$1 touchSelectionObserver;
    public final UndoManager undoManager;
    public OffsetMapping offsetMapping = BasicTextKt.ValidatingEmptyOffsetMappingIdentity;
    public Function1 onValueChange = new SaversKt$$ExternalSyntheticLambda10(6);
    public final ParcelableSnapshotMutableState valueState = Stack.mutableStateOf$default(new TextFieldValue(7, 0, (String) null));

    /* JADX WARN: Type inference failed for: r6v14, types: [androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1] */
    public TextFieldSelectionManager(UndoManager undoManager) {
        this.undoManager = undoManager;
        Boolean bool = Boolean.TRUE;
        this.editable$delegate = Stack.mutableStateOf$default(bool);
        this.enabled$delegate = Stack.mutableStateOf$default(bool);
        this.dragBeginPosition = 0L;
        this.dragTotalDistance = 0L;
        this.draggingHandle$delegate = Stack.mutableStateOf$default(null);
        this.currentDragPosition$delegate = Stack.mutableStateOf$default(null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue(7, 0L, (String) null);
        this.hasAvailableTextToPaste$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
        this.toolbarRequester = new RealWeakMemoryCache(4);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            public TextRange runningSelection;
            public boolean isLongPressSelectionOnly = true;
            public SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustmentMode = SelectionAdjustment$Companion.None;

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onCancel() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public final void mo175onDragk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                long jM228access$updateSelectionjSglsI8;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                if (!textFieldSelectionManager.getEnabled() || textFieldSelectionManager.getValue$foundation().annotatedString.text.length() == 0) {
                    return;
                }
                textFieldSelectionManager.dragTotalDistance = Offset.m373plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
                LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                if (legacyTextFieldState != null && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
                    textFieldSelectionManager.currentDragPosition$delegate.setValue(new Offset(Offset.m373plusMKHz9U(textFieldSelectionManager.dragBeginPosition, textFieldSelectionManager.dragTotalDistance)));
                    if (textFieldSelectionManager.dragBeginSelection != null || layoutResult.m179isPositionOnTextk4lQ0M(textFieldSelectionManager.m231getCurrentDragPosition_m7T9E().packedValue)) {
                        TextRange textRange = textFieldSelectionManager.dragBeginSelection;
                        int iM178getOffsetForPosition3MmeM6k = textRange != null ? (int) (textRange.packedValue >> 32) : layoutResult.m178getOffsetForPosition3MmeM6k(textFieldSelectionManager.dragBeginPosition, false);
                        int iM178getOffsetForPosition3MmeM6k2 = layoutResult.m178getOffsetForPosition3MmeM6k(textFieldSelectionManager.m231getCurrentDragPosition_m7T9E().packedValue, false);
                        if (textFieldSelectionManager.dragBeginSelection == null && iM178getOffsetForPosition3MmeM6k == iM178getOffsetForPosition3MmeM6k2) {
                            return;
                        } else {
                            jM228access$updateSelectionjSglsI8 = TextFieldSelectionManager.m228access$updateSelectionjSglsI8(textFieldSelectionManager, textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.m231getCurrentDragPosition_m7T9E().packedValue, false, false, this.selectionAdjustmentMode, true, new HapticFeedbackType(9));
                        }
                    } else {
                        jM228access$updateSelectionjSglsI8 = TextFieldSelectionManager.m228access$updateSelectionjSglsI8(textFieldSelectionManager, textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.m231getCurrentDragPosition_m7T9E().packedValue, false, false, textFieldSelectionManager.offsetMapping.transformedToOriginal(layoutResult.m178getOffsetForPosition3MmeM6k(textFieldSelectionManager.dragBeginPosition, true)) == textFieldSelectionManager.offsetMapping.transformedToOriginal(layoutResult.m178getOffsetForPosition3MmeM6k(textFieldSelectionManager.m231getCurrentDragPosition_m7T9E().packedValue, true)) ? SelectionAdjustment$Companion.None : SelectionAdjustment$Companion.Word, true, new HapticFeedbackType(9));
                    }
                    this.runningSelection = new TextRange(jM228access$updateSelectionjSglsI8);
                    if (!TextRange.m639equalsimpl(jM228access$updateSelectionjSglsI8, textFieldSelectionManager.dragBeginSelection)) {
                        this.isLongPressSelectionOnly = false;
                    }
                }
                textFieldSelectionManager.updateFloatingToolbar(false);
            }

            public final void onEnd() {
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.draggingHandle$delegate.setValue(null);
                textFieldSelectionManager.currentDragPosition$delegate.setValue(null);
                this.selectionAdjustmentMode = SelectionAdjustment$Companion.None;
                textFieldSelectionManager.updateFloatingToolbar(true);
                TextRange textRange = this.runningSelection;
                boolean zM641getCollapsedimpl = TextRange.m641getCollapsedimpl(textRange != null ? textRange.packedValue : textFieldSelectionManager.getValue$foundation().selection);
                textFieldSelectionManager.setHandleState(zM641getCollapsedimpl ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                if (legacyTextFieldState != null) {
                    legacyTextFieldState.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(!zM641getCollapsedimpl && SimpleLayoutKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true)));
                }
                LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                if (legacyTextFieldState2 != null) {
                    legacyTextFieldState2.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(!zM641getCollapsedimpl && SimpleLayoutKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false)));
                }
                LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager.state;
                if (legacyTextFieldState3 != null) {
                    legacyTextFieldState3.showCursorHandle$delegate.setValue(Boolean.valueOf(zM641getCollapsedimpl && SimpleLayoutKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true)));
                }
                if (this.isLongPressSelectionOnly) {
                    TextFieldSelectionManager.m227access$maybeSuggestSelectionOEnZFl4(textFieldSelectionManager, textFieldSelectionManager.dragBeginSelection);
                }
                textFieldSelectionManager.dragBeginSelection = null;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k */
            public final void mo176onStart3MmeM6k(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0) {
                long j2;
                TextLayoutResultProxy layoutResult;
                TextLayoutResultProxy layoutResult2;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldSelectionManager.draggingHandle$delegate;
                if (textFieldSelectionManager.getEnabled() && ((Handle) parcelableSnapshotMutableState.getValue()) == null) {
                    parcelableSnapshotMutableState.setValue(Handle.SelectionEnd);
                    textFieldSelectionManager.previousRawDragOffset = -1;
                    this.isLongPressSelectionOnly = true;
                    this.selectionAdjustmentMode = selectionAdjustment$Companion$$ExternalSyntheticLambda0;
                    textFieldSelectionManager.hideSelectionToolbar$foundation();
                    LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                    if (legacyTextFieldState == null || (layoutResult2 = legacyTextFieldState.getLayoutResult()) == null || !layoutResult2.m179isPositionOnTextk4lQ0M(j)) {
                        j2 = j;
                        LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                        if (legacyTextFieldState2 != null && (layoutResult = legacyTextFieldState2.getLayoutResult()) != null) {
                            int iTransformedToOriginal = textFieldSelectionManager.offsetMapping.transformedToOriginal(layoutResult.m178getOffsetForPosition3MmeM6k(j2, true));
                            TextFieldValue textFieldValueM229createTextFieldValueFDrldGo = TextFieldSelectionManager.m229createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation().annotatedString, ParagraphKt.TextRange(iTransformedToOriginal, iTransformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation(false);
                            HapticFeedback hapticFeedback = textFieldSelectionManager.hapticFeedBack;
                            if (hapticFeedback != null) {
                                ((PlatformHapticFeedback) hapticFeedback).m503performHapticFeedbackCdsT49E(0);
                            }
                            textFieldSelectionManager.onValueChange.invoke(textFieldValueM229createTextFieldValueFDrldGo);
                            textFieldSelectionManager.latestSelection = new TextRange(textFieldValueM229createTextFieldValueFDrldGo.selection);
                        }
                        this.isLongPressSelectionOnly = false;
                    } else {
                        if (textFieldSelectionManager.getValue$foundation().annotatedString.text.length() == 0) {
                            return;
                        }
                        textFieldSelectionManager.enterSelectionMode$foundation(false);
                        long jM228access$updateSelectionjSglsI8 = TextFieldSelectionManager.m228access$updateSelectionjSglsI8(textFieldSelectionManager, TextFieldValue.m663copy3r_uNRQ$default(textFieldSelectionManager.getValue$foundation(), null, TextRange.Zero, 5), j, true, false, this.selectionAdjustmentMode, true, new HapticFeedbackType(0));
                        j2 = j;
                        textFieldSelectionManager.dragBeginSelection = new TextRange(jM228access$updateSelectionjSglsI8);
                        this.runningSelection = new TextRange(jM228access$updateSelectionjSglsI8);
                    }
                    textFieldSelectionManager.setHandleState(HandleState.None);
                    textFieldSelectionManager.dragBeginPosition = j2;
                    textFieldSelectionManager.currentDragPosition$delegate.setValue(new Offset(j2));
                    textFieldSelectionManager.dragTotalDistance = 0L;
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onStop() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public final void mo174onDownk4lQ0M() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onUp() {
            }
        };
        zzr zzrVar = new zzr();
        zzrVar.zzb = this;
        zzrVar.zzc = true;
        this.mouseSelectionObserver = zzrVar;
    }

    public static final Pair access$getContextTextAndSelection(TextFieldSelectionManager textFieldSelectionManager) {
        String str;
        TextRange textRange;
        AnnotatedString transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation();
        if (transformedText$foundation == null || (str = transformedText$foundation.text) == null || (textRange = textFieldSelectionManager.latestSelection) == null) {
            return null;
        }
        long j = textRange.packedValue;
        return new Pair(str, new TextRange(ParagraphKt.TextRange(textFieldSelectionManager.offsetMapping.originalToTransformed((int) (j >> 32)), textFieldSelectionManager.offsetMapping.originalToTransformed((int) (j & 4294967295L)))));
    }

    /* JADX INFO: renamed from: access$maybeSuggestSelection-OEnZFl4, reason: not valid java name */
    public static final void m227access$maybeSuggestSelectionOEnZFl4(TextFieldSelectionManager textFieldSelectionManager, TextRange textRange) {
        AnnotatedString transformedText$foundation;
        String str;
        CoroutineScope coroutineScope;
        if (textRange == null) {
            return;
        }
        long j = textRange.packedValue;
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = textFieldSelectionManager.platformSelectionBehaviors;
        if (platformSelectionBehaviorsImpl == null || (transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation()) == null || (str = transformedText$foundation.text) == null) {
            return;
        }
        OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
        long jTextRange = ParagraphKt.TextRange(offsetMapping.originalToTransformed((int) (j >> 32)), offsetMapping.originalToTransformed((int) (j & 4294967295L)));
        if (str.length() <= 0 || TextRange.m641getCollapsedimpl(jTextRange) || (coroutineScope = textFieldSelectionManager.coroutineScope) == null) {
            return;
        }
        JobKt.launch$default(coroutineScope, null, new ContentInViewNode$launchAnimation$2.AnonymousClass1(platformSelectionBehaviorsImpl, str, jTextRange, textRange, textFieldSelectionManager, offsetMapping, null), 3);
    }

    /* JADX INFO: renamed from: access$updateSelection-jSglsI8, reason: not valid java name */
    public static final long m228access$updateSelectionjSglsI8(TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, long j, boolean z, boolean z2, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0, boolean z3, HapticFeedbackType hapticFeedbackType) {
        TextLayoutResultProxy layoutResult;
        long j2;
        Selection selection;
        boolean z4;
        boolean z5;
        HapticFeedback hapticFeedback;
        int i;
        LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.Zero;
        }
        OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
        long j3 = textFieldValue.selection;
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        int i2 = TextRange.$r8$clinit;
        long jTextRange = ParagraphKt.TextRange(offsetMapping.originalToTransformed((int) (j3 >> 32)), textFieldSelectionManager.offsetMapping.originalToTransformed((int) (j3 & 4294967295L)));
        int iM178getOffsetForPosition3MmeM6k = layoutResult.m178getOffsetForPosition3MmeM6k(j, false);
        int i3 = (z2 || z) ? iM178getOffsetForPosition3MmeM6k : (int) (jTextRange >> 32);
        int i4 = (!z2 || z) ? iM178getOffsetForPosition3MmeM6k : (int) (jTextRange & 4294967295L);
        SingleSelectionLayout singleSelectionLayout = textFieldSelectionManager.previousSelectionLayout;
        int i5 = (z || singleSelectionLayout == null || (i = textFieldSelectionManager.previousRawDragOffset) == -1) ? -1 : i;
        TextLayoutResult textLayoutResult = layoutResult.value;
        if (z) {
            j2 = 4294967295L;
            selection = null;
        } else {
            j2 = 4294967295L;
            int i6 = (int) (jTextRange >> 32);
            Selection.AnchorInfo anchorInfo = new Selection.AnchorInfo(SimpleLayoutKt.getTextDirectionForOffset(textLayoutResult, i6), i6, 1L);
            int i7 = (int) (jTextRange & 4294967295L);
            selection = new Selection(anchorInfo, new Selection.AnchorInfo(SimpleLayoutKt.getTextDirectionForOffset(textLayoutResult, i7), i7, 1L), TextRange.m645getReversedimpl(jTextRange));
        }
        SingleSelectionLayout singleSelectionLayout2 = new SingleSelectionLayout(z2, 1, 1, selection, new SelectableInfo(1L, 1, i3, i4, i5, textLayoutResult));
        if (!singleSelectionLayout2.shouldRecomputeSelection(singleSelectionLayout)) {
            return j3;
        }
        textFieldSelectionManager.previousSelectionLayout = singleSelectionLayout2;
        textFieldSelectionManager.previousRawDragOffset = iM178getOffsetForPosition3MmeM6k;
        Selection selectionAdjust = selectionAdjustment$Companion$$ExternalSyntheticLambda0.adjust(singleSelectionLayout2);
        long jTextRange2 = ParagraphKt.TextRange(textFieldSelectionManager.offsetMapping.transformedToOriginal(selectionAdjust.start.offset), textFieldSelectionManager.offsetMapping.transformedToOriginal(selectionAdjust.end.offset));
        if (TextRange.m640equalsimpl0(jTextRange2, j3)) {
            return j3;
        }
        boolean z6 = TextRange.m645getReversedimpl(jTextRange2) != TextRange.m645getReversedimpl(j3) && TextRange.m640equalsimpl0(ParagraphKt.TextRange((int) (jTextRange2 & j2), (int) (jTextRange2 >> 32)), j3);
        boolean z7 = TextRange.m641getCollapsedimpl(jTextRange2) && TextRange.m641getCollapsedimpl(j3);
        if (z3 && annotatedString.text.length() > 0 && !z6 && !z7 && hapticFeedbackType != null && (hapticFeedback = textFieldSelectionManager.hapticFeedBack) != null) {
            ((PlatformHapticFeedback) hapticFeedback).m503performHapticFeedbackCdsT49E(hapticFeedbackType.value);
        }
        textFieldSelectionManager.onValueChange.invoke(m229createTextFieldValueFDrldGo(annotatedString, jTextRange2));
        textFieldSelectionManager.latestSelection = new TextRange(jTextRange2);
        if (!z3) {
            textFieldSelectionManager.updateFloatingToolbar(!TextRange.m641getCollapsedimpl(jTextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.isInTouchMode$delegate.setValue(Boolean.valueOf(z3));
        }
        LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(!TextRange.m641getCollapsedimpl(jTextRange2) && SimpleLayoutKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true)));
        }
        LegacyTextFieldState legacyTextFieldState4 = textFieldSelectionManager.state;
        if (legacyTextFieldState4 != null) {
            if (TextRange.m641getCollapsedimpl(jTextRange2)) {
                z4 = false;
            } else {
                z4 = false;
                if (SimpleLayoutKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false)) {
                    z5 = true;
                }
                legacyTextFieldState4.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(z5));
            }
            z5 = z4;
            legacyTextFieldState4.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(z5));
        } else {
            z4 = false;
        }
        LegacyTextFieldState legacyTextFieldState5 = textFieldSelectionManager.state;
        if (legacyTextFieldState5 != null) {
            legacyTextFieldState5.showCursorHandle$delegate.setValue(Boolean.valueOf((TextRange.m641getCollapsedimpl(jTextRange2) && SimpleLayoutKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true)) ? true : z4));
        }
        return jTextRange2;
    }

    /* JADX INFO: renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public static TextFieldValue m229createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j) {
        return new TextFieldValue(annotatedString, j, (TextRange) null);
    }

    public final StandaloneCoroutine copy$foundation(boolean z) {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return JobKt.launch$default(coroutineScope, null, new TextFieldSelectionManager$copy$1(this, z, null), 1);
        }
        return null;
    }

    public final void cut$foundation() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            JobKt.launch$default(coroutineScope, null, new TextFieldSelectionManager$cut$1(this, null, 0), 1);
        }
    }

    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation, reason: not valid java name */
    public final void m230deselect_kEHs6E$foundation(Offset offset) {
        if (!TextRange.m641getCollapsedimpl(getValue$foundation().selection)) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            int iM643getMaximpl = (offset == null || layoutResult == null) ? TextRange.m643getMaximpl(getValue$foundation().selection) : this.offsetMapping.transformedToOriginal(layoutResult.m178getOffsetForPosition3MmeM6k(offset.packedValue, true));
            TextFieldValue textFieldValueM663copy3r_uNRQ$default = TextFieldValue.m663copy3r_uNRQ$default(getValue$foundation(), null, ParagraphKt.TextRange(iM643getMaximpl, iM643getMaximpl), 5);
            this.onValueChange.invoke(textFieldValueM663copy3r_uNRQ$default);
            this.latestSelection = new TextRange(textFieldValueM663copy3r_uNRQ$default.selection);
        }
        setHandleState((offset == null || getValue$foundation().annotatedString.text.length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    public final void enterSelectionMode$foundation(boolean z) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null && !legacyTextFieldState.getHasFocus() && (focusRequester = this.focusRequester) != null) {
            FocusRequester.m349requestFocus3ESFkO8$default(focusRequester);
        }
        this.oldValue = getValue$foundation();
        updateFloatingToolbar(z);
        setHandleState(HandleState.Selection);
    }

    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m231getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    public final boolean getEnabled() {
        return ((Boolean) this.enabled$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ$foundation, reason: not valid java name */
    public final long m232getHandlePositiontuRUvjQ$foundation(boolean z) {
        TextLayoutResultProxy layoutResult;
        long j;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return 9205357640488583168L;
        }
        TextLayoutResult textLayoutResult = layoutResult.value;
        AnnotatedString transformedText$foundation = getTransformedText$foundation();
        if (transformedText$foundation == null) {
            return 9205357640488583168L;
        }
        if (!Intrinsics.areEqual(transformedText$foundation.text, textLayoutResult.layoutInput.text.text)) {
            return 9205357640488583168L;
        }
        TextFieldValue value$foundation = getValue$foundation();
        if (z) {
            long j2 = value$foundation.selection;
            int i = TextRange.$r8$clinit;
            j = j2 >> 32;
        } else {
            long j3 = value$foundation.selection;
            int i2 = TextRange.$r8$clinit;
            j = j3 & 4294967295L;
        }
        return SimpleLayoutKt.getSelectionHandleCoordinates(textLayoutResult, this.offsetMapping.originalToTransformed((int) j), z, TextRange.m645getReversedimpl(getValue$foundation().selection));
    }

    public final AnnotatedString getTransformedText$foundation() {
        TextDelegate textDelegate;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (textDelegate = legacyTextFieldState.textDelegate) == null) {
            return null;
        }
        return textDelegate.text;
    }

    public final TextFieldValue getValue$foundation() {
        return (TextFieldValue) this.valueState.getValue();
    }

    public final void hideSelectionToolbar$foundation() {
        StandaloneCoroutine standaloneCoroutine;
        TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode = (TextContextMenuToolbarHandlerNode) this.toolbarRequester.cache;
        if (textContextMenuToolbarHandlerNode == null || (standaloneCoroutine = textContextMenuToolbarHandlerNode.textToolbarJob) == null) {
            return;
        }
        standaloneCoroutine.cancel((CancellationException) null);
        textContextMenuToolbarHandlerNode.textToolbarJob = null;
    }

    public final void paste$foundation() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            JobKt.launch$default(coroutineScope, null, new TextFieldSelectionManager$cut$1(this, null, 2), 1);
        }
    }

    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.handleState$delegate.setValue(handleState);
            }
        }
    }

    public final void showSelectionToolbar$foundation() {
        LegacyTextFieldState legacyTextFieldState;
        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (getEnabled() && ((legacyTextFieldState = this.state) == null || ((Boolean) legacyTextFieldState.isInTouchMode$delegate.getValue()).booleanValue())) {
                Unit unit = Unit.INSTANCE;
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                this.toolbarRequester.show();
                return;
            }
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        } catch (Throwable th) {
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateClipboardEntry$foundation(ContinuationImpl continuationImpl) {
        TextFieldSelectionManager$updateClipboardEntry$1 textFieldSelectionManager$updateClipboardEntry$1;
        TextFieldSelectionManager textFieldSelectionManager;
        if (continuationImpl instanceof TextFieldSelectionManager$updateClipboardEntry$1) {
            textFieldSelectionManager$updateClipboardEntry$1 = (TextFieldSelectionManager$updateClipboardEntry$1) continuationImpl;
            int i = textFieldSelectionManager$updateClipboardEntry$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                textFieldSelectionManager$updateClipboardEntry$1.label = i - Integer.MIN_VALUE;
            } else {
                textFieldSelectionManager$updateClipboardEntry$1 = new TextFieldSelectionManager$updateClipboardEntry$1(this, continuationImpl);
            }
        } else {
            textFieldSelectionManager$updateClipboardEntry$1 = new TextFieldSelectionManager$updateClipboardEntry$1(this, continuationImpl);
        }
        Object objValueOf = textFieldSelectionManager$updateClipboardEntry$1.result;
        int i2 = textFieldSelectionManager$updateClipboardEntry$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objValueOf);
            Clipboard clipboard = this.clipboard;
            if (clipboard != null) {
                textFieldSelectionManager$updateClipboardEntry$1.L$0 = this;
                textFieldSelectionManager$updateClipboardEntry$1.label = 1;
                ClipDescription primaryClipDescription = ((AndroidClipboard) clipboard).androidClipboardManager.getClipboardManager().getPrimaryClipDescription();
                objValueOf = Boolean.valueOf(primaryClipDescription != null && primaryClipDescription.hasMimeType("text/*"));
                Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objValueOf == obj) {
                    return obj;
                }
                textFieldSelectionManager = this;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        textFieldSelectionManager = textFieldSelectionManager$updateClipboardEntry$1.L$0;
        ResultKt.throwOnFailure(objValueOf);
        Boolean bool = (Boolean) objValueOf;
        bool.getClass();
        textFieldSelectionManager.hasAvailableTextToPaste$delegate.setValue(bool);
        return Unit.INSTANCE;
    }

    public final void updateFloatingToolbar(boolean z) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.showFloatingToolbar$delegate.setValue(Boolean.valueOf(z));
        }
        if (z) {
            showSelectionToolbar$foundation();
        } else {
            hideSelectionToolbar$foundation();
        }
    }
}
