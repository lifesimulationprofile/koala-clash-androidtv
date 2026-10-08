package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.room.RoomOpenHelper;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class ClickableNode extends AbstractClickableNode {
    public PointerInputChange downEvent;
    public IndirectPointerInputChange indirectDownEvent;

    public final void cancelInput(boolean z) {
        if (z) {
            this.indirectDownEvent = null;
        } else {
            this.downEvent = null;
        }
        handlePressInteractionCancel(z);
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onCancelIndirectPointerInput() {
        cancelInput(true);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        super.onCancelPointerInput();
        cancelInput(false);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo */
    public final boolean mo33onClickKeyDownEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo */
    public final void mo34onClickKeyUpEventZmokQxo(KeyEvent keyEvent) {
        this.onClick.invoke();
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onIndirectPointerEvent(RoomOpenHelper roomOpenHelper, PointerEventPass pointerEventPass) {
        ArrayList arrayList = (ArrayList) roomOpenHelper.mConfiguration;
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled && this.gestureNode == null) {
            GestureNode gestureNode = new GestureNode(this);
            delegate(gestureNode);
            this.gestureNode = gestureNode;
        }
        if (pointerEventPass != PointerEventPass.Main) {
            if (pointerEventPass != PointerEventPass.Final || this.indirectDownEvent == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                IndirectPointerInputChange indirectPointerInputChange = (IndirectPointerInputChange) arrayList.get(i);
                if (indirectPointerInputChange.isConsumed && !indirectPointerInputChange.equals(this.indirectDownEvent)) {
                    cancelInput(true);
                    return;
                }
            }
            return;
        }
        if (this.indirectDownEvent == null) {
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (ScrollableKt.changedToDownIgnoreConsumed((IndirectPointerInputChange) arrayList.get(i2))) {
                    IndirectPointerInputChange indirectPointerInputChange2 = (IndirectPointerInputChange) arrayList.get(0);
                    indirectPointerInputChange2.isConsumed = true;
                    this.indirectDownEvent = indirectPointerInputChange2;
                    if (this.enabled) {
                        handlePressInteractionStart(indirectPointerInputChange2);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        int size3 = arrayList.size();
        for (int i3 = 0; i3 < size3; i3++) {
            IndirectPointerInputChange indirectPointerInputChange3 = (IndirectPointerInputChange) arrayList.get(i3);
            if (indirectPointerInputChange3.isConsumed || !indirectPointerInputChange3.previousPressed || indirectPointerInputChange3.pressed) {
                float touchSlop = ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getTouchSlop();
                int size4 = arrayList.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    IndirectPointerInputChange indirectPointerInputChange4 = (IndirectPointerInputChange) arrayList.get(i4);
                    boolean z = Math.abs(Offset.m370getDistanceimpl(Offset.m372minusMKHz9U(indirectPointerInputChange4.position, this.indirectDownEvent.position))) > touchSlop;
                    if (indirectPointerInputChange4.isConsumed || z) {
                        cancelInput(true);
                        return;
                    }
                }
                return;
            }
        }
        ((IndirectPointerInputChange) arrayList.get(0)).isConsumed = true;
        if (this.enabled) {
            m32handlePressInteractionRelease3MmeM6k(this.indirectDownEvent.position, true);
            this.onClick.invoke();
        }
        this.indirectDownEvent = null;
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo36onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        super.mo36onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        if (pointerEventPass != PointerEventPass.Main) {
            if (pointerEventPass != PointerEventPass.Final || this.downEvent == null) {
                return;
            }
            ?? r7 = pointerEvent.changes;
            int size = r7.size();
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChange = (PointerInputChange) r7.get(i);
                if (pointerInputChange.isConsumed() && !pointerInputChange.equals(this.downEvent)) {
                    cancelInput(false);
                    return;
                }
            }
            return;
        }
        if (this.downEvent == null) {
            if (TapGestureDetectorKt.isChangedToDown(pointerEvent, true, false)) {
                PointerInputChange pointerInputChange2 = (PointerInputChange) pointerEvent.changes.get(0);
                pointerInputChange2.consume();
                this.downEvent = pointerInputChange2;
                if (this.enabled) {
                    handlePressInteractionStart(pointerInputChange2);
                    return;
                }
                return;
            }
            return;
        }
        ?? r8 = pointerEvent.changes;
        int size2 = r8.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (!PointerId.changedToUp((PointerInputChange) r8.get(i2))) {
                long jM30getExtendedTouchPaddinghWWAJMo = m30getExtendedTouchPaddinghWWAJMo(j);
                int size3 = r8.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    PointerInputChange pointerInputChange3 = (PointerInputChange) r8.get(i3);
                    if (pointerInputChange3.isConsumed() || PointerId.m511isOutOfBoundsjwHxaWs(pointerInputChange3, j, jM30getExtendedTouchPaddinghWWAJMo)) {
                        cancelInput(false);
                        return;
                    }
                }
                return;
            }
        }
        ((PointerInputChange) r8.get(0)).consume();
        if (this.enabled) {
            m32handlePressInteractionRelease3MmeM6k(this.downEvent.position, false);
            this.onClick.invoke();
        }
        this.downEvent = null;
    }
}
