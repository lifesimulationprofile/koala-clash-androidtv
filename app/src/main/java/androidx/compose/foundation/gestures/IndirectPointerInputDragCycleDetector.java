package androidx.compose.foundation.gestures;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectList;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.HitTestResultKt;
import coil.memory.RealWeakMemoryCache;
import coil.request.Parameters;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IndirectPointerInputDragCycleDetector {
    public IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown _awaitDownState;
    public IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup _awaitGesturePickupState;
    public IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop _awaitTouchSlopState;
    public IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging _draggingState;
    public ScrollableKt currentDragState;
    public final DragGestureNode node;
    public long nodeOffset;
    public final RealWeakMemoryCache offsetSmoother;
    public long previousPositionOnScreen = 9205357640488583168L;
    public HeadersReader touchSlopDetector;
    public final RealWeakMemoryCache touchSmooth;
    public Parameters.Builder velocityTracker;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CaptureSession$State$EnumUnboxingLocalUtility.values(3).length];
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public IndirectPointerInputDragCycleDetector(DragGestureNode dragGestureNode) {
        this.node = dragGestureNode;
        boolean z = false;
        RealWeakMemoryCache realWeakMemoryCache = new RealWeakMemoryCache(2, z);
        realWeakMemoryCache.cache = new MutableObjectList();
        this.touchSmooth = realWeakMemoryCache;
        RealWeakMemoryCache realWeakMemoryCache2 = new RealWeakMemoryCache(3, z);
        realWeakMemoryCache2.cache = new MutableLongList();
        this.offsetSmoother = realWeakMemoryCache2;
        this.nodeOffset = 0L;
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U$default, reason: not valid java name */
    public static void m81moveToAwaitTouchSlopStateaWI9W7U$default(IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector, IndirectPointerInputChange indirectPointerInputChange, long j, long j2, int i) {
        if ((i & 4) != 0) {
            j2 = 0;
        }
        DragGestureNode dragGestureNode = indirectPointerInputDragCycleDetector.node;
        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = indirectPointerInputDragCycleDetector._awaitTouchSlopState;
        if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop == null) {
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = new IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop();
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown = null;
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId = Long.MAX_VALUE;
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
            indirectPointerInputDragCycleDetector._awaitTouchSlopState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;
        }
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown = indirectPointerInputChange;
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId = j;
        HeadersReader headersReader = indirectPointerInputDragCycleDetector.touchSlopDetector;
        if (headersReader == null) {
            indirectPointerInputDragCycleDetector.touchSlopDetector = new HeadersReader(dragGestureNode.orientationLock, 2);
        } else {
            headersReader.source = dragGestureNode.orientationLock;
            headersReader.headerLimit = j2;
        }
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
        indirectPointerInputDragCycleDetector.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;
    }

    public final void moveToAwaitDownState() {
        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown = this._awaitDownState;
        if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown == null) {
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown = new IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown();
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.awaitTouchSlop = 3;
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.consumedOnInitial = false;
            this._awaitDownState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
        }
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.awaitTouchSlop = 3;
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.consumedOnInitial = false;
        this.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
    }

    /* JADX INFO: renamed from: moveToAwaitGesturePickupState-rnUCldI, reason: not valid java name */
    public final void m82moveToAwaitGesturePickupStaternUCldI(IndirectPointerInputChange indirectPointerInputChange, long j, HeadersReader headersReader) {
        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup = this._awaitGesturePickupState;
        if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup == null) {
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup = new IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup();
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.initialDown = null;
            indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.pointerId = Long.MAX_VALUE;
            this._awaitGesturePickupState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;
        }
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.initialDown = indirectPointerInputChange;
        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.pointerId = j;
        headersReader.headerLimit = 0L;
        this.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup;
    }

    public final Parameters.Builder requireVelocityTracker() {
        Parameters.Builder builder = this.velocityTracker;
        if (builder != null) {
            return builder;
        }
        throw new IllegalArgumentException("Velocity Tracker not initialized.");
    }

    /* JADX INFO: renamed from: sendDragEvent-Eu1f8Dk, reason: not valid java name */
    public final void m83sendDragEventEu1f8Dk(IndirectPointerInputChange indirectPointerInputChange, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, long j) {
        DragGestureNode dragGestureNode = this.node;
        long jMo526localToScreenMKHz9U = HitTestResultKt.requireLayoutCoordinates(dragGestureNode).mo526localToScreenMKHz9U(0L);
        if (!Offset.m369equalsimpl0(this.previousPositionOnScreen, 9205357640488583168L) && !Offset.m369equalsimpl0(jMo526localToScreenMKHz9U, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.m373plusMKHz9U(this.nodeOffset, Offset.m372minusMKHz9U(jMo526localToScreenMKHz9U, this.previousPositionOnScreen));
        }
        this.previousPositionOnScreen = jMo526localToScreenMKHz9U;
        Orientation orientation = dragGestureNode.orientationLock;
        int i = DraggableKt.$r8$clinit;
        if (Math.abs(Float.intBitsToFloat((int) (orientation == Orientation.Vertical ? j & 4294967295L : j >> 32))) > 2.0f) {
            ScrollableKt.m95access$addIndirectPointerInputChangeQf4Zb88(requireVelocityTracker(), indirectPointerInputChange, dragGestureNode.orientationLock, indirectPointerEventPrimaryDirectionalMotionAxis, this.touchSmooth, this.nodeOffset);
            RealWeakMemoryCache realWeakMemoryCache = this.offsetSmoother;
            MutableLongList mutableLongList = (MutableLongList) realWeakMemoryCache.cache;
            int i2 = mutableLongList._size;
            if (i2 == 3) {
                int i3 = realWeakMemoryCache.operationsSinceCleanUp;
                realWeakMemoryCache.operationsSinceCleanUp = i3 + 1;
                if (i3 < 0 || i3 >= i2) {
                    RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
                    throw null;
                }
                long[] jArr = mutableLongList.content;
                long j2 = jArr[i3];
                jArr[i3] = j;
            } else {
                mutableLongList.add(j);
            }
            if (realWeakMemoryCache.operationsSinceCleanUp == 3) {
                realWeakMemoryCache.operationsSinceCleanUp = 0;
            }
            long[] jArr2 = mutableLongList.content;
            int i4 = mutableLongList._size;
            float fIntBitsToFloat = 0.0f;
            float fIntBitsToFloat2 = 0.0f;
            for (int i5 = 0; i5 < i4; i5++) {
                fIntBitsToFloat2 += Float.intBitsToFloat((int) (jArr2[i5] >> 32));
            }
            int i6 = mutableLongList._size;
            float f = fIntBitsToFloat2 / i6;
            long[] jArr3 = mutableLongList.content;
            for (int i7 = 0; i7 < i6; i7++) {
                fIntBitsToFloat += Float.intBitsToFloat((int) (jArr3[i7] & 4294967295L));
            }
            dragGestureNode.onDragEvent(new DragEvent.DragDelta((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat / mutableLongList._size)) & 4294967295L), true));
        }
    }

    /* JADX INFO: renamed from: sendDragStart-3f7A7Is, reason: not valid java name */
    public final void m84sendDragStart3f7A7Is(IndirectPointerInputChange indirectPointerInputChange, IndirectPointerInputChange indirectPointerInputChange2, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, long j) {
        if (this.velocityTracker == null) {
            this.velocityTracker = new Parameters.Builder(7);
        }
        this.nodeOffset = 0L;
        Parameters.Builder builderRequireVelocityTracker = requireVelocityTracker();
        DragGestureNode dragGestureNode = this.node;
        ScrollableKt.m95access$addIndirectPointerInputChangeQf4Zb88(builderRequireVelocityTracker, indirectPointerInputChange, dragGestureNode.orientationLock, indirectPointerEventPrimaryDirectionalMotionAxis, this.touchSmooth, this.nodeOffset);
        long jM372minusMKHz9U = Offset.m372minusMKHz9U(ScrollableKt.m98primaryAxisPosition_bfSUIo(indirectPointerInputChange2, dragGestureNode.orientationLock, indirectPointerEventPrimaryDirectionalMotionAxis), j);
        if (((Boolean) dragGestureNode.canDrag.invoke(new PointerType(1))).booleanValue()) {
            this.previousPositionOnScreen = HitTestResultKt.requireLayoutCoordinates(dragGestureNode).mo526localToScreenMKHz9U(0L);
            dragGestureNode.onDragEvent(new DragEvent.DragStarted(jM372minusMKHz9U));
        }
        RealWeakMemoryCache realWeakMemoryCache = this.offsetSmoother;
        realWeakMemoryCache.operationsSinceCleanUp = 0;
        ((MutableLongList) realWeakMemoryCache.cache)._size = 0;
    }
}
