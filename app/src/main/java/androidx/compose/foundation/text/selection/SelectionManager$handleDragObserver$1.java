package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import coil.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionManager$handleDragObserver$1 implements TextDragObserver {
    public final /* synthetic */ boolean $isStartHandle;
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object this$0;

    public SelectionManager$handleDragObserver$1(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        this.this$0 = textFieldSelectionManager;
        this.$isStartHandle = z;
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    public final void onCancel() {
        switch (this.$r8$classId) {
            case 0:
                SelectionManager selectionManager = (SelectionManager) this.this$0;
                selectionManager.showToolbar = true;
                selectionManager.updateSelectionToolbar();
                selectionManager.draggingHandle$delegate.setValue(null);
                selectionManager.currentDragPosition$delegate.setValue(null);
                break;
        }
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    /* JADX INFO: renamed from: onDown-k-4lQ0M */
    public final void mo174onDownk4lQ0M() {
        Selection selection;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResultProxy layoutResult;
        switch (this.$r8$classId) {
            case 0:
                SelectionManager selectionManager = (SelectionManager) this.this$0;
                boolean z = this.$isStartHandle;
                if ((z ? (Offset) selectionManager.startHandlePosition$delegate.getValue() : (Offset) selectionManager.endHandlePosition$delegate.getValue()) != null && (selection = selectionManager.getSelection()) != null) {
                    MultiWidgetSelectionDelegate anchorSelectable$foundation = selectionManager.getAnchorSelectable$foundation(z ? selection.start : selection.end);
                    if (anchorSelectable$foundation != null && (layoutCoordinates = anchorSelectable$foundation.getLayoutCoordinates()) != null) {
                        long jM214getHandlePositiondBAh8RU = anchorSelectable$foundation.m214getHandlePositiondBAh8RU(selection, z);
                        if ((9223372034707292159L & jM214getHandlePositiondBAh8RU) != 9205357640488583168L) {
                            selectionManager.currentDragPosition$delegate.setValue(new Offset(selectionManager.requireContainerCoordinates$foundation().mo523localPositionOfR5De75A(layoutCoordinates, SelectionHandlesKt.m218getAdjustedCoordinatesk4lQ0M(jM214getHandlePositiondBAh8RU))));
                            selectionManager.draggingHandle$delegate.setValue(z ? Handle.SelectionStart : Handle.SelectionEnd);
                            selectionManager.showToolbar = false;
                            selectionManager.updateSelectionToolbar();
                            break;
                        }
                    }
                }
                break;
            default:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.this$0;
                boolean z2 = this.$isStartHandle;
                textFieldSelectionManager.draggingHandle$delegate.setValue(z2 ? Handle.SelectionStart : Handle.SelectionEnd);
                long jM218getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m218getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m232getHandlePositiontuRUvjQ$foundation(z2));
                LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                if (legacyTextFieldState != null && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
                    long jM181translateInnerToDecorationCoordinatesMKHz9U$foundation = layoutResult.m181translateInnerToDecorationCoordinatesMKHz9U$foundation(jM218getAdjustedCoordinatesk4lQ0M);
                    textFieldSelectionManager.dragBeginPosition = jM181translateInnerToDecorationCoordinatesMKHz9U$foundation;
                    textFieldSelectionManager.currentDragPosition$delegate.setValue(new Offset(jM181translateInnerToDecorationCoordinatesMKHz9U$foundation));
                    textFieldSelectionManager.dragTotalDistance = 0L;
                    textFieldSelectionManager.previousRawDragOffset = -1;
                    LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                    if (legacyTextFieldState2 != null) {
                        legacyTextFieldState2.isInTouchMode$delegate.setValue(Boolean.TRUE);
                    }
                    textFieldSelectionManager.updateFloatingToolbar(false);
                    break;
                }
                break;
        }
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    /* JADX INFO: renamed from: onDrag-k-4lQ0M */
    public final void mo175onDragk4lQ0M(long j) {
        switch (this.$r8$classId) {
            case 0:
                SelectionManager selectionManager = (SelectionManager) this.this$0;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = selectionManager.dragBeginPosition$delegate;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = selectionManager.dragTotalDistance$delegate;
                if (selectionManager.getDraggingHandle() != null) {
                    parcelableSnapshotMutableState2.setValue(new Offset(Offset.m373plusMKHz9U(((Offset) parcelableSnapshotMutableState2.getValue()).packedValue, j)));
                    long jM373plusMKHz9U = Offset.m373plusMKHz9U(((Offset) parcelableSnapshotMutableState.getValue()).packedValue, ((Offset) parcelableSnapshotMutableState2.getValue()).packedValue);
                    if (selectionManager.m220updateSelectionjyLRC_s$foundation(jM373plusMKHz9U, ((Offset) parcelableSnapshotMutableState.getValue()).packedValue, this.$isStartHandle, SelectionAdjustment$Companion.CharacterWithWordAccelerate)) {
                        parcelableSnapshotMutableState.setValue(new Offset(jM373plusMKHz9U));
                        parcelableSnapshotMutableState2.setValue(new Offset(0L));
                    }
                    break;
                }
                break;
            default:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.this$0;
                long jM373plusMKHz9U2 = Offset.m373plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
                textFieldSelectionManager.dragTotalDistance = jM373plusMKHz9U2;
                textFieldSelectionManager.currentDragPosition$delegate.setValue(new Offset(Offset.m373plusMKHz9U(textFieldSelectionManager.dragBeginPosition, jM373plusMKHz9U2)));
                TextFieldSelectionManager.m228access$updateSelectionjSglsI8(textFieldSelectionManager, textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.m231getCurrentDragPosition_m7T9E().packedValue, false, this.$isStartHandle, SelectionAdjustment$Companion.CharacterWithWordAccelerate, true, new HapticFeedbackType(9));
                textFieldSelectionManager.updateFloatingToolbar(false);
                break;
        }
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    /* JADX INFO: renamed from: onStart-3MmeM6k */
    public final void mo176onStart3MmeM6k(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0) {
        switch (this.$r8$classId) {
            case 0:
                SelectionManager selectionManager = (SelectionManager) this.this$0;
                if (selectionManager.getDraggingHandle() == null) {
                    return;
                }
                Selection selection = selectionManager.getSelection();
                boolean z = this.$isStartHandle;
                Object obj = selectionManager.selectionRegistrar._selectableMap.get((z ? selection.start : selection.end).selectableId);
                if (obj == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("SelectionRegistrar should contain the current selection's selectableIds");
                    throw new HttpException();
                }
                MultiWidgetSelectionDelegate multiWidgetSelectionDelegate = (MultiWidgetSelectionDelegate) obj;
                LayoutCoordinates layoutCoordinates = multiWidgetSelectionDelegate.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Current selectable should have layout coordinates.");
                    throw new HttpException();
                }
                long jM214getHandlePositiondBAh8RU = multiWidgetSelectionDelegate.m214getHandlePositiondBAh8RU(selection, z);
                if ((9223372034707292159L & jM214getHandlePositiondBAh8RU) == 9205357640488583168L) {
                    return;
                }
                selectionManager.dragBeginPosition$delegate.setValue(new Offset(selectionManager.requireContainerCoordinates$foundation().mo523localPositionOfR5De75A(layoutCoordinates, SelectionHandlesKt.m218getAdjustedCoordinatesk4lQ0M(jM214getHandlePositiondBAh8RU))));
                selectionManager.dragTotalDistance$delegate.setValue(new Offset(0L));
                return;
            default:
                return;
        }
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    public final void onStop() {
        switch (this.$r8$classId) {
            case 0:
                SelectionManager selectionManager = (SelectionManager) this.this$0;
                selectionManager.showToolbar = true;
                selectionManager.updateSelectionToolbar();
                selectionManager.draggingHandle$delegate.setValue(null);
                selectionManager.currentDragPosition$delegate.setValue(null);
                break;
            default:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.this$0;
                textFieldSelectionManager.draggingHandle$delegate.setValue(null);
                textFieldSelectionManager.currentDragPosition$delegate.setValue(null);
                textFieldSelectionManager.updateFloatingToolbar(true);
                break;
        }
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    public final void onUp() {
        switch (this.$r8$classId) {
            case 0:
                SelectionManager selectionManager = (SelectionManager) this.this$0;
                selectionManager.showToolbar = true;
                selectionManager.updateSelectionToolbar();
                selectionManager.draggingHandle$delegate.setValue(null);
                selectionManager.currentDragPosition$delegate.setValue(null);
                break;
            default:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.this$0;
                textFieldSelectionManager.draggingHandle$delegate.setValue(null);
                textFieldSelectionManager.currentDragPosition$delegate.setValue(null);
                textFieldSelectionManager.updateFloatingToolbar(true);
                break;
        }
    }

    public SelectionManager$handleDragObserver$1(boolean z, SelectionManager selectionManager) {
        this.$isStartHandle = z;
        this.this$0 = selectionManager;
    }

    private final void onCancel$androidx$compose$foundation$text$selection$TextFieldSelectionManager$handleDragObserver$1() {
    }

    /* JADX INFO: renamed from: onStart-3MmeM6k$androidx$compose$foundation$text$selection$TextFieldSelectionManager$handleDragObserver$1, reason: not valid java name */
    private final void m221xb63f3ac2(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0) {
    }
}
