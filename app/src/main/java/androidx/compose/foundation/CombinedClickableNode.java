package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.room.RoomOpenHelper;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CombinedClickableNode extends AbstractClickableNode {
    public final MutableLongObjectMap doubleKeyClickStates;
    public PointerInputChange downEvent;
    public long firstTapUpTime;
    public boolean hapticFeedbackEnabled;
    public boolean ignoreNextUp;
    public IndirectPointerInputChange indirectDownEvent;
    public long indirectFirstTapUpTime;
    public boolean indirectIgnoreNextUp;
    public boolean indirectIsSecondTap;
    public StandaloneCoroutine indirectLongPressJob;
    public boolean indirectLongPressTriggered;
    public StandaloneCoroutine indirectTapJob;
    public boolean isSecondTap;
    public final MutableLongObjectMap longKeyPressJobs;
    public StandaloneCoroutine longPressJob;
    public boolean longPressTriggered;
    public Function0 onLongClick;
    public StandaloneCoroutine tapJob;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class DoubleKeyClickState {
    }

    public CombinedClickableNode(Function0 function0, Function0 function1) {
        super(null, null, true, true, null, null, function0);
        this.onLongClick = function1;
        this.hapticFeedbackEnabled = true;
        MutableLongObjectMap mutableLongObjectMap = LongObjectMapKt.EmptyLongObjectMap;
        this.longKeyPressJobs = new MutableLongObjectMap();
        this.doubleKeyClickStates = new MutableLongObjectMap();
        this.firstTapUpTime = -1L;
        this.indirectFirstTapUpTime = -1L;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public final void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.onLongClick != null) {
            BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda0 = new BasicTextKt$$ExternalSyntheticLambda0(2, this);
            KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
            semanticsPropertyReceiver.set(SemanticsActions.OnLongClick, new AccessibilityAction(null, basicTextKt$$ExternalSyntheticLambda0));
        }
    }

    public final void cancelInput$1(boolean z) {
        if (z) {
            this.indirectDownEvent = null;
            StandaloneCoroutine standaloneCoroutine = this.indirectLongPressJob;
            if (standaloneCoroutine != null) {
                standaloneCoroutine.cancel((CancellationException) null);
            }
            this.indirectLongPressJob = null;
            StandaloneCoroutine standaloneCoroutine2 = this.indirectTapJob;
            if (standaloneCoroutine2 != null) {
                standaloneCoroutine2.cancel((CancellationException) null);
            }
            this.indirectTapJob = null;
            this.indirectIsSecondTap = false;
            this.indirectLongPressTriggered = false;
            this.indirectFirstTapUpTime = -1L;
            this.indirectIgnoreNextUp = false;
        } else {
            this.downEvent = null;
            StandaloneCoroutine standaloneCoroutine3 = this.longPressJob;
            if (standaloneCoroutine3 != null) {
                standaloneCoroutine3.cancel((CancellationException) null);
            }
            this.longPressJob = null;
            StandaloneCoroutine standaloneCoroutine4 = this.tapJob;
            if (standaloneCoroutine4 != null) {
                standaloneCoroutine4.cancel((CancellationException) null);
            }
            this.tapJob = null;
            this.isSecondTap = false;
            this.longPressTriggered = false;
            this.firstTapUpTime = -1L;
            this.ignoreNextUp = false;
        }
        handlePressInteractionCancel(z);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public final SuspendingPointerInputModifierNodeImpl createPointerInputNodeIfNeeded() {
        return null;
    }

    public final void handleUpEvent(long j, IndirectPointerInputChange indirectPointerInputChange) {
        if (this.enabled && !this.indirectIgnoreNextUp) {
            m32handlePressInteractionRelease3MmeM6k(indirectPointerInputChange.position, true);
            this.indirectFirstTapUpTime = j;
            if (!this.indirectLongPressTriggered && !this.indirectIsSecondTap) {
                this.onClick.invoke();
            }
        }
        this.indirectDownEvent = null;
        this.indirectIgnoreNextUp = false;
        this.indirectIsSecondTap = false;
        StandaloneCoroutine standaloneCoroutine = this.indirectLongPressJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel((CancellationException) null);
        }
        this.indirectLongPressJob = null;
        this.indirectLongPressTriggered = false;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onCancelIndirectPointerInput() {
        cancelInput$1(true);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public final void onCancelKeyInput() {
        resetKeyPressState();
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        super.onCancelPointerInput();
        cancelInput$1(false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo */
    public final boolean mo33onClickKeyDownEventZmokQxo(KeyEvent keyEvent) {
        boolean z;
        long jM505getKeyZmokQxo = Key_androidKt.m505getKeyZmokQxo(keyEvent);
        if (this.onLongClick != null) {
            MutableLongObjectMap mutableLongObjectMap = this.longKeyPressJobs;
            if (mutableLongObjectMap.get(jM505getKeyZmokQxo) == null) {
                mutableLongObjectMap.set(jM505getKeyZmokQxo, JobKt.launch$default(getCoroutineScope(), null, new CombinedClickableNode$handleDownEvent$1(this, null, 2), 3));
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        return z;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo */
    public final void mo34onClickKeyUpEventZmokQxo(KeyEvent keyEvent) {
        long jM505getKeyZmokQxo = Key_androidKt.m505getKeyZmokQxo(keyEvent);
        MutableLongObjectMap mutableLongObjectMap = this.longKeyPressJobs;
        boolean z = false;
        if (mutableLongObjectMap.get(jM505getKeyZmokQxo) != null) {
            Job job = (Job) mutableLongObjectMap.get(jM505getKeyZmokQxo);
            if (job != null) {
                if (job.isActive()) {
                    job.cancel(null);
                } else {
                    z = true;
                }
            }
            mutableLongObjectMap.remove(jM505getKeyZmokQxo);
        }
        if (z) {
            return;
        }
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
        int i = 0;
        if (pointerEventPass != PointerEventPass.Main) {
            if (pointerEventPass != PointerEventPass.Final || this.indirectDownEvent == null || this.indirectLongPressTriggered) {
                return;
            }
            int size = arrayList.size();
            while (i < size) {
                IndirectPointerInputChange indirectPointerInputChange = (IndirectPointerInputChange) arrayList.get(i);
                if (indirectPointerInputChange.isConsumed && !indirectPointerInputChange.equals(this.indirectDownEvent)) {
                    cancelInput$1(true);
                    return;
                }
                i++;
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
                        StandaloneCoroutine standaloneCoroutine = this.indirectTapJob;
                        if (standaloneCoroutine != null && standaloneCoroutine.isActive()) {
                            ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getClass();
                            if (indirectPointerInputChange2.uptimeMillis - this.indirectFirstTapUpTime < 40) {
                                this.indirectIgnoreNextUp = true;
                                return;
                            }
                            this.indirectIsSecondTap = true;
                            StandaloneCoroutine standaloneCoroutine2 = this.indirectTapJob;
                            if (standaloneCoroutine2 != null) {
                                standaloneCoroutine2.cancel((CancellationException) null);
                            }
                            this.indirectTapJob = null;
                        }
                        this.indirectLongPressTriggered = false;
                        handlePressInteractionStart(indirectPointerInputChange2);
                        if (this.onLongClick != null) {
                            this.indirectLongPressJob = JobKt.launch$default(getCoroutineScope(), null, new CombinedClickableNode$handleDownEvent$1(this, null, 1), 3);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.indirectLongPressTriggered) {
            int size3 = arrayList.size();
            for (int i3 = 0; i3 < size3; i3++) {
                IndirectPointerInputChange indirectPointerInputChange3 = (IndirectPointerInputChange) arrayList.get(i3);
                if (!indirectPointerInputChange3.previousPressed || indirectPointerInputChange3.pressed) {
                    int size4 = arrayList.size();
                    while (i < size4) {
                        ((IndirectPointerInputChange) arrayList.get(i)).isConsumed = true;
                        i++;
                    }
                    return;
                }
            }
            IndirectPointerInputChange indirectPointerInputChange4 = (IndirectPointerInputChange) arrayList.get(0);
            indirectPointerInputChange4.isConsumed = true;
            handleUpEvent(indirectPointerInputChange4.uptimeMillis, this.indirectDownEvent);
            return;
        }
        int size5 = arrayList.size();
        for (int i4 = 0; i4 < size5; i4++) {
            IndirectPointerInputChange indirectPointerInputChange5 = (IndirectPointerInputChange) arrayList.get(i4);
            if (indirectPointerInputChange5.isConsumed || !indirectPointerInputChange5.previousPressed || indirectPointerInputChange5.pressed) {
                float touchSlop = ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getTouchSlop();
                int size6 = arrayList.size();
                for (int i5 = 0; i5 < size6; i5++) {
                    IndirectPointerInputChange indirectPointerInputChange6 = (IndirectPointerInputChange) arrayList.get(i5);
                    boolean z = Math.abs(Offset.m370getDistanceimpl(Offset.m372minusMKHz9U(indirectPointerInputChange6.position, this.indirectDownEvent.position))) > touchSlop;
                    if (indirectPointerInputChange6.isConsumed || z) {
                        cancelInput$1(true);
                        return;
                    }
                }
                return;
            }
        }
        IndirectPointerInputChange indirectPointerInputChange7 = (IndirectPointerInputChange) arrayList.get(0);
        indirectPointerInputChange7.isConsumed = true;
        handleUpEvent(indirectPointerInputChange7.uptimeMillis, this.indirectDownEvent);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object, java.util.List] */
    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo36onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        super.mo36onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        if (pointerEventPass != PointerEventPass.Main) {
            if (pointerEventPass != PointerEventPass.Final || this.downEvent == null || this.longPressTriggered) {
                return;
            }
            ?? r7 = pointerEvent.changes;
            int size = r7.size();
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChange = (PointerInputChange) r7.get(i);
                if (pointerInputChange.isConsumed() && !pointerInputChange.equals(this.downEvent)) {
                    cancelInput$1(false);
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
                    StandaloneCoroutine standaloneCoroutine = this.tapJob;
                    if (standaloneCoroutine != null && standaloneCoroutine.isActive()) {
                        ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getClass();
                        if (pointerInputChange2.uptimeMillis - this.firstTapUpTime < 40) {
                            this.ignoreNextUp = true;
                            return;
                        }
                        this.isSecondTap = true;
                        StandaloneCoroutine standaloneCoroutine2 = this.tapJob;
                        if (standaloneCoroutine2 != null) {
                            standaloneCoroutine2.cancel((CancellationException) null);
                        }
                        this.tapJob = null;
                    }
                    this.longPressTriggered = false;
                    handlePressInteractionStart(pointerInputChange2);
                    if (this.onLongClick != null) {
                        this.longPressJob = JobKt.launch$default(getCoroutineScope(), null, new CombinedClickableNode$handleDownEvent$1(this, null, 0), 3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        boolean z = pointerEvent.classification == 2;
        ?? r8 = pointerEvent.changes;
        if (z && !this.longPressTriggered && this.enabled && this.onLongClick != null) {
            StandaloneCoroutine standaloneCoroutine3 = this.longPressJob;
            if (standaloneCoroutine3 != null) {
                standaloneCoroutine3.cancel((CancellationException) null);
            }
            this.longPressJob = null;
            Function0 function0 = this.onLongClick;
            if (function0 != null) {
                function0.invoke();
            }
            if (this.hapticFeedbackEnabled) {
                ((PlatformHapticFeedback) ((HapticFeedback) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalHapticFeedback))).m503performHapticFeedbackCdsT49E(0);
            }
            this.longPressTriggered = true;
        }
        if (this.longPressTriggered) {
            int size2 = r8.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (!PointerId.changedToUpIgnoreConsumed((PointerInputChange) r8.get(i2))) {
                    int size3 = r8.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        ((PointerInputChange) r8.get(i3)).consume();
                    }
                    return;
                }
            }
            PointerInputChange pointerInputChange3 = (PointerInputChange) r8.get(0);
            pointerInputChange3.consume();
            handleUpEvent(pointerInputChange3.uptimeMillis, this.downEvent);
            return;
        }
        int size4 = r8.size();
        for (int i4 = 0; i4 < size4; i4++) {
            if (!PointerId.changedToUp((PointerInputChange) r8.get(i4))) {
                long jM30getExtendedTouchPaddinghWWAJMo = m30getExtendedTouchPaddinghWWAJMo(j);
                int size5 = r8.size();
                for (int i5 = 0; i5 < size5; i5++) {
                    PointerInputChange pointerInputChange4 = (PointerInputChange) r8.get(i5);
                    if (pointerInputChange4.isConsumed() || PointerId.m511isOutOfBoundsjwHxaWs(pointerInputChange4, j, jM30getExtendedTouchPaddinghWWAJMo)) {
                        cancelInput$1(false);
                        return;
                    }
                }
                return;
            }
        }
        PointerInputChange pointerInputChange5 = (PointerInputChange) r8.get(0);
        pointerInputChange5.consume();
        handleUpEvent(pointerInputChange5.uptimeMillis, this.downEvent);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        resetKeyPressState();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00af A[LOOP:2: B:24:0x007f->B:35:0x00af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b2 A[EDGE_INSN: B:44:0x00b2->B:36:0x00b2 BREAK  A[LOOP:2: B:24:0x007f->B:35:0x00af], SYNTHETIC] */
    public final void resetKeyPressState() {
        char c;
        long j;
        long j2;
        long j3;
        MutableLongObjectMap mutableLongObjectMap = this.longKeyPressJobs;
        Object[] objArr = mutableLongObjectMap.values;
        long[] jArr = mutableLongObjectMap.metadata;
        int length = jArr.length - 2;
        char c2 = 7;
        long j4 = -9187201950435737472L;
        if (length >= 0) {
            int i = 0;
            j2 = 128;
            while (true) {
                long j5 = jArr[i];
                j3 = 255;
                if ((((~j5) << c2) & j5 & j4) != j4) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    int i3 = 0;
                    while (i3 < i2) {
                        if ((j5 & 255) < 128) {
                            ((Job) objArr[(i << 3) + i3]).cancel(null);
                        }
                        j5 >>= 8;
                        i3++;
                        c2 = c2;
                        j4 = j4;
                    }
                    c = c2;
                    j = j4;
                    if (i2 != 8) {
                        break;
                    }
                } else {
                    c = c2;
                    j = j4;
                }
                if (i == length) {
                    break;
                }
                i++;
                c2 = c;
                j4 = j;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 128;
            j3 = 255;
        }
        mutableLongObjectMap.clear();
        MutableLongObjectMap mutableLongObjectMap2 = this.doubleKeyClickStates;
        Object[] objArr2 = mutableLongObjectMap2.values;
        long[] jArr2 = mutableLongObjectMap2.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i4 = 0;
            while (true) {
                long j6 = jArr2[i4];
                if ((((~j6) << c) & j6 & j) == j) {
                    if (i4 != length2) {
                        break;
                        break;
                    }
                    i4++;
                } else {
                    int i5 = 8 - ((~(i4 - length2)) >>> 31);
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((j6 & j3) < j2) {
                            ((DoubleKeyClickState) objArr2[(i4 << 3) + i6]).getClass();
                            throw null;
                        }
                        j6 >>= 8;
                    }
                    if (i5 != 8) {
                        break;
                    } else if (i4 != length2) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        mutableLongObjectMap2.clear();
    }

    public final void handleUpEvent(long j, PointerInputChange pointerInputChange) {
        if (this.enabled && !this.ignoreNextUp) {
            m32handlePressInteractionRelease3MmeM6k(pointerInputChange.position, false);
            this.firstTapUpTime = j;
            if (!this.longPressTriggered && !this.isSecondTap) {
                this.onClick.invoke();
            }
        }
        this.downEvent = null;
        this.ignoreNextUp = false;
        this.isSecondTap = false;
        StandaloneCoroutine standaloneCoroutine = this.longPressJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel((CancellationException) null);
        }
        this.longPressJob = null;
        this.longPressTriggered = false;
    }
}
