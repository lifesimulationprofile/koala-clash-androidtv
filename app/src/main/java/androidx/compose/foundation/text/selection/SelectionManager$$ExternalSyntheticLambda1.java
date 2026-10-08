package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifierKt;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import coil.network.HttpException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionManager$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SelectionManager f$0;

    public /* synthetic */ SelectionManager$$ExternalSyntheticLambda1(SelectionManager selectionManager, int i) {
        this.$r8$classId = i;
        this.f$0 = selectionManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Selection.AnchorInfo anchorInfo;
        Selection.AnchorInfo anchorInfo2;
        switch (this.$r8$classId) {
            case 0:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj;
                SelectionManager selectionManager = this.f$0;
                selectionManager.containerLayoutCoordinates = layoutCoordinates;
                if (((Boolean) selectionManager.hasFocus$delegate.getValue()).booleanValue() && selectionManager.getSelection() != null) {
                    Offset offset = layoutCoordinates != null ? new Offset(layoutCoordinates.mo527localToWindowMKHz9U(0L)) : null;
                    if (!Intrinsics.areEqual(selectionManager.previousPosition, offset)) {
                        selectionManager.previousPosition = offset;
                        selectionManager.updateHandleOffsets();
                        selectionManager.updateSelectionToolbar();
                    }
                }
                return Unit.INSTANCE;
            case 1:
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(9, this.f$0);
            case 2:
                long jLongValue = ((Long) obj).longValue();
                SelectionManager selectionManager2 = this.f$0;
                if (selectionManager2.selectionRegistrar.getSubselections().containsKey(jLongValue)) {
                    selectionManager2.onRelease();
                    selectionManager2.setSelection(null);
                }
                return Unit.INSTANCE;
            case 3:
                long jLongValue2 = ((Long) obj).longValue();
                SelectionManager selectionManager3 = this.f$0;
                Selection selection = selectionManager3.getSelection();
                if (selection != null && (anchorInfo2 = selection.start) != null && jLongValue2 == anchorInfo2.selectableId) {
                    selectionManager3.startHandlePosition$delegate.setValue(null);
                }
                Selection selection2 = selectionManager3.getSelection();
                if (selection2 != null && (anchorInfo = selection2.end) != null && jLongValue2 == anchorInfo.selectableId) {
                    selectionManager3.endHandlePosition$delegate.setValue(null);
                }
                if (selectionManager3.selectionRegistrar.getSubselections().containsKey(jLongValue2)) {
                    selectionManager3.updateSelectionToolbar();
                }
                return Unit.INSTANCE;
            case 4:
                LayoutCoordinates layoutCoordinates2 = (LayoutCoordinates) obj;
                SelectionManager selectionManager4 = this.f$0;
                Rect rect = (Rect) selectionManager4.derivedContentRect$delegate.getValue();
                if (rect == null) {
                    return null;
                }
                LayoutCoordinates layoutCoordinates3 = selectionManager4.containerLayoutCoordinates;
                if (layoutCoordinates3 != null) {
                    return TextContextMenuModifierKt.translateRootToDestination(rect, layoutCoordinates3, layoutCoordinates2);
                }
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
                throw new HttpException();
            case 5:
                SelectionManager selectionManager5 = this.f$0;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = selectionManager5.hasFocus$delegate;
                FocusStateImpl focusStateImpl = (FocusStateImpl) obj;
                if (!focusStateImpl.getHasFocus() && ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                    selectionManager5.onRelease();
                }
                parcelableSnapshotMutableState.setValue(Boolean.valueOf(focusStateImpl.getHasFocus()));
                return Unit.INSTANCE;
            case 6:
                this.f$0.setInTouchMode(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            case 7:
                this.f$0.setSelection((Selection) obj);
                return Unit.INSTANCE;
            default:
                long jLongValue3 = ((Long) obj).longValue();
                SelectionManager selectionManager6 = this.f$0;
                if (selectionManager6.selectionRegistrar.getSubselections().containsKey(jLongValue3)) {
                    selectionManager6.positionChangeState$delegate.setValue(Unit.INSTANCE);
                    selectionManager6.updateHandleOffsets();
                    selectionManager6.updateSelectionToolbar();
                }
                return Unit.INSTANCE;
        }
    }
}
