package androidx.compose.foundation.text.modifiers;

import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyListIntervalContent$$ExternalSyntheticLambda2;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.selection.SelectionRegistrarImpl;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerHoverIconModifierElement;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionController implements RememberObserver {
    public final long backgroundSelectionColor;
    public final Modifier modifier;
    public StaticTextSelectionParams params = StaticTextSelectionParams.Empty;
    public MultiWidgetSelectionDelegate selectable;
    public final long selectableId;
    public final SelectionRegistrarImpl selectionRegistrar;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$mouseSelectionObserver$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$longPressDragObserver$1, java.lang.Object] */
    public SelectionController(final long j, final SelectionRegistrarImpl selectionRegistrarImpl, long j2) {
        this.selectableId = j;
        this.selectionRegistrar = selectionRegistrarImpl;
        this.backgroundSelectionColor = j2;
        final SelectionController$$ExternalSyntheticLambda0 selectionController$$ExternalSyntheticLambda0 = new SelectionController$$ExternalSyntheticLambda0(this, 2);
        final ?? r6 = new TextDragObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$longPressDragObserver$1
            public long lastPosition = 0;
            public long dragTotalDistance = 0;
            public SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustmentMode = SelectionAdjustment$Companion.None;

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onCancel() {
                SelectionManager$$ExternalSyntheticLambda0 selectionManager$$ExternalSyntheticLambda0;
                long j3 = j;
                SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                if (!SelectionRegistrarKt.hasSelection(selectionRegistrarImpl2, j3) || (selectionManager$$ExternalSyntheticLambda0 = selectionRegistrarImpl2.onSelectionUpdateEndCallback) == null) {
                    return;
                }
                selectionManager$$ExternalSyntheticLambda0.invoke();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public final void mo175onDragk4lQ0M(long j3) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) selectionController$$ExternalSyntheticLambda0.invoke();
                if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
                    return;
                }
                SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                if (SelectionRegistrarKt.hasSelection(selectionRegistrarImpl2, j)) {
                    long jM373plusMKHz9U = Offset.m373plusMKHz9U(this.dragTotalDistance, j3);
                    this.dragTotalDistance = jM373plusMKHz9U;
                    long jM373plusMKHz9U2 = Offset.m373plusMKHz9U(this.lastPosition, jM373plusMKHz9U);
                    if (selectionRegistrarImpl2.m222notifySelectionUpdatenjBpvok(layoutCoordinates, jM373plusMKHz9U2, this.lastPosition, this.selectionAdjustmentMode, true)) {
                        this.lastPosition = jM373plusMKHz9U2;
                        this.dragTotalDistance = 0L;
                    }
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k */
            public final void mo176onStart3MmeM6k(long j3, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0) {
                this.selectionAdjustmentMode = selectionAdjustment$Companion$$ExternalSyntheticLambda0;
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) selectionController$$ExternalSyntheticLambda0.invoke();
                SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                if (layoutCoordinates != null) {
                    if (!layoutCoordinates.isAttached()) {
                        return;
                    }
                    SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda1 = this.selectionAdjustmentMode;
                    LazyListIntervalContent$$ExternalSyntheticLambda2 lazyListIntervalContent$$ExternalSyntheticLambda2 = selectionRegistrarImpl2.onSelectionUpdateStartCallback;
                    if (lazyListIntervalContent$$ExternalSyntheticLambda2 != null) {
                        lazyListIntervalContent$$ExternalSyntheticLambda2.invoke(Boolean.TRUE, layoutCoordinates, new Offset(j3), selectionAdjustment$Companion$$ExternalSyntheticLambda1);
                    }
                    this.lastPosition = j3;
                }
                if (SelectionRegistrarKt.hasSelection(selectionRegistrarImpl2, j)) {
                    this.dragTotalDistance = 0L;
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onStop() {
                SelectionManager$$ExternalSyntheticLambda0 selectionManager$$ExternalSyntheticLambda0;
                long j3 = j;
                SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                if (!SelectionRegistrarKt.hasSelection(selectionRegistrarImpl2, j3) || (selectionManager$$ExternalSyntheticLambda0 = selectionRegistrarImpl2.onSelectionUpdateEndCallback) == null) {
                    return;
                }
                selectionManager$$ExternalSyntheticLambda0.invoke();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public final void mo174onDownk4lQ0M() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public final void onUp() {
            }
        };
        final ?? r0 = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$mouseSelectionObserver$1
            public long lastPosition = 0;

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onDrag-3MmeM6k, reason: not valid java name */
            public final boolean mo207onDrag3MmeM6k(long j3, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) selectionController$$ExternalSyntheticLambda0.invoke();
                if (layoutCoordinates == null) {
                    return true;
                }
                if (!layoutCoordinates.isAttached()) {
                    return false;
                }
                SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                if (!SelectionRegistrarKt.hasSelection(selectionRegistrarImpl2, j)) {
                    return false;
                }
                if (!selectionRegistrarImpl2.m222notifySelectionUpdatenjBpvok(layoutCoordinates, j3, this.lastPosition, selectionAdjustment$Companion$$ExternalSyntheticLambda0, false)) {
                    return true;
                }
                this.lastPosition = j3;
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public final void onDragDone() {
                SelectionManager$$ExternalSyntheticLambda0 selectionManager$$ExternalSyntheticLambda0 = selectionRegistrarImpl.onSelectionUpdateEndCallback;
                if (selectionManager$$ExternalSyntheticLambda0 != null) {
                    selectionManager$$ExternalSyntheticLambda0.invoke();
                }
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtend-k-4lQ0M, reason: not valid java name */
            public final boolean mo208onExtendk4lQ0M(long j3) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) selectionController$$ExternalSyntheticLambda0.invoke();
                if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
                    return false;
                }
                long j4 = this.lastPosition;
                SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0 = SelectionAdjustment$Companion.None;
                SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                if (selectionRegistrarImpl2.m222notifySelectionUpdatenjBpvok(layoutCoordinates, j3, j4, selectionAdjustment$Companion$$ExternalSyntheticLambda0, false)) {
                    this.lastPosition = j3;
                }
                return SelectionRegistrarKt.hasSelection(selectionRegistrarImpl2, j);
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
            public final boolean mo209onExtendDragk4lQ0M(long j3) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) selectionController$$ExternalSyntheticLambda0.invoke();
                if (layoutCoordinates == null) {
                    return true;
                }
                if (!layoutCoordinates.isAttached()) {
                    return false;
                }
                SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                if (!SelectionRegistrarKt.hasSelection(selectionRegistrarImpl2, j)) {
                    return false;
                }
                if (!selectionRegistrarImpl2.m222notifySelectionUpdatenjBpvok(layoutCoordinates, j3, this.lastPosition, SelectionAdjustment$Companion.None, false)) {
                    return true;
                }
                this.lastPosition = j3;
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onStart-9KIMszo, reason: not valid java name */
            public final boolean mo210onStart9KIMszo(long j3, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0, int i) {
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) selectionController$$ExternalSyntheticLambda0.invoke();
                if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
                    return false;
                }
                SelectionRegistrarImpl selectionRegistrarImpl2 = selectionRegistrarImpl;
                LazyListIntervalContent$$ExternalSyntheticLambda2 lazyListIntervalContent$$ExternalSyntheticLambda2 = selectionRegistrarImpl2.onSelectionUpdateStartCallback;
                if (lazyListIntervalContent$$ExternalSyntheticLambda2 != null) {
                    lazyListIntervalContent$$ExternalSyntheticLambda2.invoke(Boolean.FALSE, layoutCoordinates, new Offset(j3), selectionAdjustment$Companion$$ExternalSyntheticLambda0);
                }
                this.lastPosition = j3;
                return SelectionRegistrarKt.hasSelection(selectionRegistrarImpl2, j);
            }
        };
        SuspendPointerInputElement suspendPointerInputElement = new SuspendPointerInputElement(r0, r6, new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeDefaultSelectionModifier$1
            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                Object objAwaitSelectionGestures = SimpleLayoutKt.awaitSelectionGestures(pointerInputScope, r0, r6, continuation);
                return objAwaitSelectionGestures == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitSelectionGestures : Unit.INSTANCE;
            }
        }, 4);
        PointerIcon.Companion.getClass();
        this.modifier = suspendPointerInputElement.then(new PointerHoverIconModifierElement());
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        MultiWidgetSelectionDelegate multiWidgetSelectionDelegate = this.selectable;
        if (multiWidgetSelectionDelegate != null) {
            this.selectionRegistrar.unsubscribe(multiWidgetSelectionDelegate);
            this.selectable = null;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        MultiWidgetSelectionDelegate multiWidgetSelectionDelegate = this.selectable;
        if (multiWidgetSelectionDelegate != null) {
            this.selectionRegistrar.unsubscribe(multiWidgetSelectionDelegate);
            this.selectable = null;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        SelectionController$$ExternalSyntheticLambda0 selectionController$$ExternalSyntheticLambda0 = new SelectionController$$ExternalSyntheticLambda0(this, 0);
        SelectionController$$ExternalSyntheticLambda0 selectionController$$ExternalSyntheticLambda1 = new SelectionController$$ExternalSyntheticLambda0(this, 1);
        long j = this.selectableId;
        MultiWidgetSelectionDelegate multiWidgetSelectionDelegate = new MultiWidgetSelectionDelegate(j, selectionController$$ExternalSyntheticLambda0, selectionController$$ExternalSyntheticLambda1);
        SelectionRegistrarImpl selectionRegistrarImpl = this.selectionRegistrar;
        MutableLongObjectMap mutableLongObjectMap = selectionRegistrarImpl._selectableMap;
        if (j == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("The selectable contains an invalid id: " + j);
        }
        if (mutableLongObjectMap.containsKey(j)) {
            InlineClassHelperKt.throwIllegalArgumentException("Another selectable with the id: " + multiWidgetSelectionDelegate + ".selectableId has already subscribed.");
        }
        mutableLongObjectMap.set(j, multiWidgetSelectionDelegate);
        selectionRegistrarImpl._selectables.add(multiWidgetSelectionDelegate);
        selectionRegistrarImpl.sorted = false;
        this.selectable = multiWidgetSelectionDelegate;
    }

    public final void updateTextLayout(TextLayoutResult textLayoutResult) {
        SelectionManager$$ExternalSyntheticLambda1 selectionManager$$ExternalSyntheticLambda1;
        TextLayoutResult textLayoutResult2 = this.params.textLayoutResult;
        if (textLayoutResult2 != null && !Intrinsics.areEqual(textLayoutResult2.layoutInput.text, textLayoutResult.layoutInput.text) && (selectionManager$$ExternalSyntheticLambda1 = this.selectionRegistrar.onSelectableChangeCallback) != null) {
            selectionManager$$ExternalSyntheticLambda1.invoke(Long.valueOf(this.selectableId));
        }
        this.params = StaticTextSelectionParams.copy$default(this.params, null, textLayoutResult, 1);
    }
}
