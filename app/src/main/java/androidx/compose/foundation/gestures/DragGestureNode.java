package androidx.compose.foundation.gestures;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.collection.MutableLongList;
import androidx.compose.foundation.GestureConnection;
import androidx.compose.foundation.GestureNode;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.util.DataPointAtTime;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TouchBoundsExpansion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.VelocityKt;
import androidx.room.RoomOpenHelper;
import coil.memory.RealWeakMemoryCache;
import coil.network.HttpException;
import coil.request.Parameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, IndirectPointerInputModifierNode, CompositionLocalConsumerModifierNode, GestureConnection {
    public DragDetectionState$AwaitDown _awaitDownState;
    public DragDetectionState$AwaitGesturePickup _awaitGesturePickupState;
    public DragDetectionState$AwaitTouchSlop _awaitTouchSlopState;
    public DragDetectionState$Dragging _draggingState;
    public Function1 canDrag;
    public BufferedChannel channel;
    public ScrollableKt currentDragState;
    public DragInteraction$Start dragInteraction;
    public boolean enabled;
    public GestureNode gestureNode;
    public IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector;
    public MutableInteractionSourceImpl interactionSource;
    public boolean isListeningForEvents;
    public boolean isListeningForPointerInputEvents;
    public Orientation orientationLock;
    public HeadersReader touchSlopDetector;
    public Parameters.Builder velocityTracker;
    public long previousPositionOnScreen = 9205357640488583168L;
    public long nodeOffset = 0;

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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $r8$classId = 0;
        public /* synthetic */ Object L$0;
        public Ref$ObjectRef L$1;
        public Ref$ObjectRef L$2;
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass1 anonymousClass1 = DragGestureNode.this.new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                default:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.L$2, DragGestureNode.this, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                default:
                    return ((AnonymousClass1) create((Function1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Code duplicated, block: B:49:0x00b7 A[PHI: r5
          0x00b7: PHI (r5v7 kotlinx.coroutines.CoroutineScope) = 
          (r5v0 kotlinx.coroutines.CoroutineScope)
          (r5v3 kotlinx.coroutines.CoroutineScope)
          (r5v3 kotlinx.coroutines.CoroutineScope)
          (r5v3 kotlinx.coroutines.CoroutineScope)
          (r5v5 kotlinx.coroutines.CoroutineScope)
          (r5v8 kotlinx.coroutines.CoroutineScope)
         binds: [B:48:0x00af, B:75:0x0126, B:77:0x0133, B:71:0x011f, B:60:0x00e3, B:41:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:51:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:53:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:56:0x00d7  */
        /* JADX WARN: Code duplicated, block: B:58:0x00db  */
        /* JADX WARN: Code duplicated, block: B:61:0x00e5  */
        /* JADX WARN: Code duplicated, block: B:64:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:70:0x0112 A[Catch: CancellationException -> 0x0122, TryCatch #0 {CancellationException -> 0x0122, blocks: (B:68:0x010c, B:70:0x0112, B:74:0x0124, B:76:0x0128), top: B:85:0x010c }] */
        /* JADX WARN: Code duplicated, block: B:72:0x0121  */
        /* JADX WARN: Code duplicated, block: B:74:0x0124 A[Catch: CancellationException -> 0x0122, TryCatch #0 {CancellationException -> 0x0122, blocks: (B:68:0x010c, B:70:0x0112, B:74:0x0124, B:76:0x0128), top: B:85:0x010c }] */
        /* JADX WARN: Code duplicated, block: B:76:0x0128 A[Catch: CancellationException -> 0x0122, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0122, blocks: (B:68:0x010c, B:70:0x0112, B:74:0x0124, B:76:0x0128), top: B:85:0x010c }] */
        /* JADX WARN: Code duplicated, block: B:82:0x0144  */
        /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0055 -> B:27:0x0056). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x005a -> B:29:0x005b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x00e3 -> B:49:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x011f -> B:49:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0126 -> B:49:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0133 -> B:49:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0141 -> B:41:0x0088). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:61:0x00e5
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instruction units count: 352
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$ObjectRef ref$ObjectRef, DragGestureNode dragGestureNode, Continuation continuation) {
            super(2, continuation);
            this.L$2 = ref$ObjectRef;
            DragGestureNode.this = dragGestureNode;
        }
    }

    public DragGestureNode(Function1 function1, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, Orientation orientation) {
        this.orientationLock = orientation;
        this.canDrag = function1;
        this.enabled = z;
        this.interactionSource = mutableInteractionSourceImpl;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$processDragCancel(DragGestureNode dragGestureNode, ContinuationImpl continuationImpl) throws Throwable {
        DragGestureNode$processDragCancel$1 dragGestureNode$processDragCancel$1;
        if (continuationImpl instanceof DragGestureNode$processDragCancel$1) {
            dragGestureNode$processDragCancel$1 = (DragGestureNode$processDragCancel$1) continuationImpl;
            int i = dragGestureNode$processDragCancel$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragCancel$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureNode$processDragCancel$1 = new DragGestureNode$processDragCancel$1(dragGestureNode, continuationImpl);
            }
        } else {
            dragGestureNode$processDragCancel$1 = new DragGestureNode$processDragCancel$1(dragGestureNode, continuationImpl);
        }
        Object obj = dragGestureNode$processDragCancel$1.result;
        int i2 = dragGestureNode$processDragCancel$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction$Start dragInteraction$Start = dragGestureNode.dragInteraction;
            if (dragInteraction$Start != null) {
                MutableInteractionSourceImpl mutableInteractionSourceImpl = dragGestureNode.interactionSource;
                if (mutableInteractionSourceImpl != null) {
                    DragInteraction$Cancel dragInteraction$Cancel = new DragInteraction$Cancel(dragInteraction$Start);
                    dragGestureNode$processDragCancel$1.label = 1;
                    Object objEmit = mutableInteractionSourceImpl.emit(dragInteraction$Cancel, dragGestureNode$processDragCancel$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objEmit == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            dragGestureNode.onDragStopped(new DragEvent.DragStopped(0L, false));
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        dragGestureNode.dragInteraction = null;
        dragGestureNode.onDragStopped(new DragEvent.DragStopped(0L, false));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$processDragStart(DragGestureNode dragGestureNode, DragEvent.DragStarted dragStarted, ContinuationImpl continuationImpl) {
        DragGestureNode$processDragStart$1 dragGestureNode$processDragStart$1;
        MutableInteractionSourceImpl mutableInteractionSourceImpl;
        DragInteraction$Start dragInteraction$Start;
        DragEvent.DragStarted dragStarted2;
        DragInteraction$Start dragInteraction$Start2;
        if (continuationImpl instanceof DragGestureNode$processDragStart$1) {
            dragGestureNode$processDragStart$1 = (DragGestureNode$processDragStart$1) continuationImpl;
            int i = dragGestureNode$processDragStart$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragStart$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureNode$processDragStart$1 = new DragGestureNode$processDragStart$1(dragGestureNode, continuationImpl);
            }
        } else {
            dragGestureNode$processDragStart$1 = new DragGestureNode$processDragStart$1(dragGestureNode, continuationImpl);
        }
        Object obj = dragGestureNode$processDragStart$1.result;
        int i2 = dragGestureNode$processDragStart$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction$Start dragInteraction$Start3 = dragGestureNode.dragInteraction;
            if (dragInteraction$Start3 != null && (mutableInteractionSourceImpl = dragGestureNode.interactionSource) != null) {
                DragInteraction$Cancel dragInteraction$Cancel = new DragInteraction$Cancel(dragInteraction$Start3);
                dragGestureNode$processDragStart$1.L$0 = dragStarted;
                dragGestureNode$processDragStart$1.label = 1;
                if (mutableInteractionSourceImpl.emit(dragInteraction$Cancel, dragGestureNode$processDragStart$1) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            dragGestureNode.dragInteraction = dragInteraction$Start;
            dragGestureNode.mo61onDragStartedk4lQ0M(dragStarted.startPoint);
            return Unit.INSTANCE;
        }
        if (i2 == 1) {
            dragStarted = dragGestureNode$processDragStart$1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dragInteraction$Start2 = dragGestureNode$processDragStart$1.L$1;
            dragStarted2 = dragGestureNode$processDragStart$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        dragInteraction$Start = dragInteraction$Start2;
        dragStarted = dragStarted2;
        dragGestureNode.dragInteraction = dragInteraction$Start;
        dragGestureNode.mo61onDragStartedk4lQ0M(dragStarted.startPoint);
        return Unit.INSTANCE;
        dragInteraction$Start = new DragInteraction$Start();
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = dragGestureNode.interactionSource;
        if (mutableInteractionSourceImpl2 != null) {
            dragGestureNode$processDragStart$1.L$0 = dragStarted;
            dragGestureNode$processDragStart$1.L$1 = dragInteraction$Start;
            dragGestureNode$processDragStart$1.label = 2;
            if (mutableInteractionSourceImpl2.emit(dragInteraction$Start, dragGestureNode$processDragStart$1) != coroutineSingletons) {
                dragStarted2 = dragStarted;
                dragInteraction$Start2 = dragInteraction$Start;
                dragInteraction$Start = dragInteraction$Start2;
                dragStarted = dragStarted2;
            }
            return coroutineSingletons;
        }
        dragGestureNode.dragInteraction = dragInteraction$Start;
        dragGestureNode.mo61onDragStartedk4lQ0M(dragStarted.startPoint);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$processDragStop(DragGestureNode dragGestureNode, DragEvent.DragStopped dragStopped, ContinuationImpl continuationImpl) throws Throwable {
        DragGestureNode$processDragStop$1 dragGestureNode$processDragStop$1;
        if (continuationImpl instanceof DragGestureNode$processDragStop$1) {
            dragGestureNode$processDragStop$1 = (DragGestureNode$processDragStop$1) continuationImpl;
            int i = dragGestureNode$processDragStop$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragStop$1.label = i - Integer.MIN_VALUE;
            } else {
                dragGestureNode$processDragStop$1 = new DragGestureNode$processDragStop$1(dragGestureNode, continuationImpl);
            }
        } else {
            dragGestureNode$processDragStop$1 = new DragGestureNode$processDragStop$1(dragGestureNode, continuationImpl);
        }
        Object obj = dragGestureNode$processDragStop$1.result;
        int i2 = dragGestureNode$processDragStop$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            DragInteraction$Start dragInteraction$Start = dragGestureNode.dragInteraction;
            if (dragInteraction$Start != null) {
                MutableInteractionSourceImpl mutableInteractionSourceImpl = dragGestureNode.interactionSource;
                if (mutableInteractionSourceImpl != null) {
                    DragInteraction$Stop dragInteraction$Stop = new DragInteraction$Stop(dragInteraction$Start);
                    dragGestureNode$processDragStop$1.L$0 = dragStopped;
                    dragGestureNode$processDragStop$1.label = 1;
                    Object objEmit = mutableInteractionSourceImpl.emit(dragInteraction$Stop, dragGestureNode$processDragStop$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objEmit == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            dragGestureNode.onDragStopped(dragStopped);
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        dragStopped = dragGestureNode$processDragStop$1.L$0;
        ResultKt.throwOnFailure(obj);
        dragGestureNode.dragInteraction = null;
        dragGestureNode.onDragStopped(dragStopped);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: moveToAwaitTouchSlopState-aWI9W7U$default, reason: not valid java name */
    public static void m76moveToAwaitTouchSlopStateaWI9W7U$default(DragGestureNode dragGestureNode, PointerInputChange pointerInputChange, long j, long j2, int i) {
        if ((i & 4) != 0) {
            j2 = 0;
        }
        DragDetectionState$AwaitTouchSlop dragDetectionState$AwaitTouchSlop = dragGestureNode._awaitTouchSlopState;
        if (dragDetectionState$AwaitTouchSlop == null) {
            dragDetectionState$AwaitTouchSlop = new DragDetectionState$AwaitTouchSlop();
            dragDetectionState$AwaitTouchSlop.initialDown = null;
            dragDetectionState$AwaitTouchSlop.pointerId = Long.MAX_VALUE;
            dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
            dragGestureNode._awaitTouchSlopState = dragDetectionState$AwaitTouchSlop;
        }
        dragDetectionState$AwaitTouchSlop.initialDown = pointerInputChange;
        dragDetectionState$AwaitTouchSlop.pointerId = j;
        HeadersReader headersReader = dragGestureNode.touchSlopDetector;
        if (headersReader == null) {
            dragGestureNode.touchSlopDetector = new HeadersReader(dragGestureNode.orientationLock, 2);
        } else {
            headersReader.source = dragGestureNode.orientationLock;
            headersReader.headerLimit = j2;
        }
        dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
        dragGestureNode.currentDragState = dragDetectionState$AwaitTouchSlop;
    }

    public final void disposeInteractionSource$1() {
        DragInteraction$Start dragInteraction$Start = this.dragInteraction;
        if (dragInteraction$Start != null) {
            MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
            if (mutableInteractionSourceImpl != null) {
                mutableInteractionSourceImpl.tryEmit(new DragInteraction$Cancel(dragInteraction$Start));
            }
            this.dragInteraction = null;
        }
    }

    public abstract Object drag(AnonymousClass1 anonymousClass1, AnonymousClass1 anonymousClass2);

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    public final long mo31getTouchBoundsExpansionRZrCHBk() {
        return TouchBoundsExpansion.None;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return false;
    }

    @Override // androidx.compose.foundation.GestureConnection
    public final boolean isInterested(IndirectPointerInputChange indirectPointerInputChange) {
        return ScrollableKt.changedToDownIgnoreConsumed(indirectPointerInputChange) && this.enabled;
    }

    public final void moveToAwaitDownState() {
        DragDetectionState$AwaitDown dragDetectionState$AwaitDown = this._awaitDownState;
        if (dragDetectionState$AwaitDown == null) {
            dragDetectionState$AwaitDown = new DragDetectionState$AwaitDown();
            dragDetectionState$AwaitDown.awaitTouchSlop = 3;
            dragDetectionState$AwaitDown.consumedOnInitial = false;
            this._awaitDownState = dragDetectionState$AwaitDown;
        }
        dragDetectionState$AwaitDown.awaitTouchSlop = 3;
        dragDetectionState$AwaitDown.consumedOnInitial = false;
        this.currentDragState = dragDetectionState$AwaitDown;
    }

    /* JADX INFO: renamed from: moveToAwaitGesturePickupState-rnUCldI, reason: not valid java name */
    public final void m77moveToAwaitGesturePickupStaternUCldI(PointerInputChange pointerInputChange, long j, HeadersReader headersReader) {
        DragDetectionState$AwaitGesturePickup dragDetectionState$AwaitGesturePickup = this._awaitGesturePickupState;
        if (dragDetectionState$AwaitGesturePickup == null) {
            dragDetectionState$AwaitGesturePickup = new DragDetectionState$AwaitGesturePickup();
            dragDetectionState$AwaitGesturePickup.initialDown = null;
            dragDetectionState$AwaitGesturePickup.pointerId = Long.MAX_VALUE;
            this._awaitGesturePickupState = dragDetectionState$AwaitGesturePickup;
        }
        dragDetectionState$AwaitGesturePickup.initialDown = pointerInputChange;
        dragDetectionState$AwaitGesturePickup.pointerId = j;
        headersReader.headerLimit = 0L;
        this.currentDragState = dragDetectionState$AwaitGesturePickup;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onCancelIndirectPointerInput() {
        IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
        if (indirectPointerInputDragCycleDetector != null) {
            indirectPointerInputDragCycleDetector.moveToAwaitDownState();
            DragGestureNode dragGestureNode = indirectPointerInputDragCycleDetector.node;
            if (dragGestureNode.isListeningForEvents) {
                dragGestureNode.onDragEvent(DragEvent.DragCancelled.INSTANCE);
            }
            indirectPointerInputDragCycleDetector.velocityTracker = null;
            RealWeakMemoryCache realWeakMemoryCache = indirectPointerInputDragCycleDetector.offsetSmoother;
            realWeakMemoryCache.operationsSinceCleanUp = 0;
            ((MutableLongList) realWeakMemoryCache.cache)._size = 0;
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        if (this.isListeningForPointerInputEvents) {
            moveToAwaitDownState();
            if (this.isListeningForEvents) {
                requireChannel().mo842trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE);
            }
            this.velocityTracker = null;
        }
        this.isListeningForPointerInputEvents = false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource$1();
        this.nodeOffset = 0L;
        GestureNode gestureNode = this.gestureNode;
        if (gestureNode != null) {
            undelegate(gestureNode);
        }
        this.gestureNode = null;
    }

    public final void onDragEvent(DragEvent dragEvent) {
        if ((dragEvent instanceof DragEvent.DragStarted) && !this.isListeningForEvents) {
            this.isListeningForEvents = true;
            startListeningForEvents();
        }
        requireChannel().mo842trySendJP2dKIU(dragEvent);
    }

    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public abstract void mo61onDragStartedk4lQ0M(long j);

    public abstract void onDragStopped(DragEvent.DragStopped dragStopped);

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public final void onIndirectPointerEvent(RoomOpenHelper roomOpenHelper, PointerEventPass pointerEventPass) {
        Object obj;
        Object obj2;
        Object obj3;
        IndirectPointerInputChange indirectPointerInputChange;
        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;
        Object obj4;
        Object obj5;
        int i = roomOpenHelper.version;
        ArrayList arrayList = (ArrayList) roomOpenHelper.mConfiguration;
        if (this.gestureNode == null) {
            GestureNode gestureNode = new GestureNode(this);
            delegate(gestureNode);
            this.gestureNode = gestureNode;
        }
        if (this.enabled) {
            if (this.indirectPointerInputDragCycleDetector == null) {
                this.indirectPointerInputDragCycleDetector = new IndirectPointerInputDragCycleDetector(this);
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                DragGestureNode dragGestureNode = indirectPointerInputDragCycleDetector.node;
                if (indirectPointerInputDragCycleDetector.currentDragState == null) {
                    IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown = indirectPointerInputDragCycleDetector._awaitDownState;
                    if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown == null) {
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown = new IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown();
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.awaitTouchSlop = 3;
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown.consumedOnInitial = false;
                        indirectPointerInputDragCycleDetector._awaitDownState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
                    }
                    indirectPointerInputDragCycleDetector.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
                }
                ScrollableKt scrollableKt = indirectPointerInputDragCycleDetector.currentDragState;
                if (scrollableKt == null) {
                    throw new IllegalArgumentException("currentDragState should not be null");
                }
                boolean z = scrollableKt instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown;
                boolean z2 = true;
                PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                PointerEventPass pointerEventPass3 = PointerEventPass.Main;
                if (z) {
                    IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2 = (IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown) scrollableKt;
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (!ScrollableKt.changedToDownIgnoreConsumed((IndirectPointerInputChange) arrayList.get(i2))) {
                            return;
                        }
                    }
                    IndirectPointerInputChange indirectPointerInputChange2 = (IndirectPointerInputChange) CollectionsKt.first((List) arrayList);
                    int i3 = IndirectPointerInputDragCycleDetector.WhenMappings.$EnumSwitchMapping$0[CaptureSession$State$EnumUnboxingLocalUtility.ordinal(indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2.awaitTouchSlop)] == 1 ? !dragGestureNode.startDragImmediately() ? 1 : 2 : indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2.awaitTouchSlop;
                    indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2.awaitTouchSlop = i3;
                    if (pointerEventPass == pointerEventPass2 && i3 == 2) {
                        indirectPointerInputChange2.isConsumed = true;
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2.consumedOnInitial = true;
                    }
                    if (pointerEventPass == pointerEventPass3) {
                        if (i3 == 1) {
                            IndirectPointerInputDragCycleDetector.m81moveToAwaitTouchSlopStateaWI9W7U$default(indirectPointerInputDragCycleDetector, indirectPointerInputChange2, indirectPointerInputChange2.id, 0L, 12);
                            return;
                        }
                        if (indirectPointerInputDragCycleDetector$DragDetectionState$AwaitDown2.consumedOnInitial) {
                            indirectPointerInputDragCycleDetector.m84sendDragStart3f7A7Is(indirectPointerInputChange2, indirectPointerInputChange2, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), 0L);
                            indirectPointerInputDragCycleDetector.m83sendDragEventEu1f8Dk(indirectPointerInputChange2, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), 0L);
                            long j = indirectPointerInputChange2.id;
                            IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging indirectPointerInputDragCycleDetector$DragDetectionState$Dragging = indirectPointerInputDragCycleDetector._draggingState;
                            if (indirectPointerInputDragCycleDetector$DragDetectionState$Dragging == null) {
                                indirectPointerInputDragCycleDetector$DragDetectionState$Dragging = new IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging();
                                indirectPointerInputDragCycleDetector$DragDetectionState$Dragging.pointerId = Long.MAX_VALUE;
                                indirectPointerInputDragCycleDetector._draggingState = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging;
                            }
                            indirectPointerInputDragCycleDetector$DragDetectionState$Dragging.pointerId = j;
                            indirectPointerInputDragCycleDetector.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging;
                            return;
                        }
                        return;
                    }
                    return;
                }
                boolean z3 = scrollableKt instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop;
                PointerEventPass pointerEventPass4 = PointerEventPass.Final;
                if (!z3) {
                    if (scrollableKt instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup) {
                        IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup = (IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup) scrollableKt;
                        if (pointerEventPass != pointerEventPass4) {
                            return;
                        }
                        int size2 = arrayList.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            if (((IndirectPointerInputChange) arrayList.get(i4)).isConsumed) {
                                z2 = false;
                                break;
                            }
                        }
                        int size3 = arrayList.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (((IndirectPointerInputChange) arrayList.get(i5)).pressed) {
                                if (arrayList.isEmpty()) {
                                    break;
                                }
                                if (z2) {
                                    long jM372minusMKHz9U = Offset.m372minusMKHz9U(ScrollableKt.m98primaryAxisPosition_bfSUIo((IndirectPointerInputChange) CollectionsKt.first((List) arrayList), dragGestureNode.orientationLock, new IndirectPointerEventPrimaryDirectionalMotionAxis(i)), ScrollableKt.m98primaryAxisPosition_bfSUIo(indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.initialDown, dragGestureNode.orientationLock, new IndirectPointerEventPrimaryDirectionalMotionAxis(i)));
                                    IndirectPointerInputChange indirectPointerInputChange3 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.initialDown;
                                    if (indirectPointerInputChange3 == null) {
                                        throw new IllegalArgumentException("AwaitGesturePickup.initialDown was not initialized.");
                                    }
                                    IndirectPointerInputDragCycleDetector.m81moveToAwaitTouchSlopStateaWI9W7U$default(indirectPointerInputDragCycleDetector, indirectPointerInputChange3, indirectPointerInputDragCycleDetector$DragDetectionState$AwaitGesturePickup.pointerId, jM372minusMKHz9U, 8);
                                    return;
                                }
                                return;
                            }
                        }
                        indirectPointerInputDragCycleDetector.moveToAwaitDownState();
                        return;
                    }
                    if (!(scrollableKt instanceof IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging)) {
                        throw new HttpException();
                    }
                    IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging indirectPointerInputDragCycleDetector$DragDetectionState$Dragging2 = (IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging) scrollableKt;
                    if (pointerEventPass != pointerEventPass3) {
                        return;
                    }
                    long j2 = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging2.pointerId;
                    int size4 = arrayList.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size4) {
                            obj = null;
                            break;
                        }
                        obj = arrayList.get(i6);
                        if (PointerId.m510equalsimpl0(((IndirectPointerInputChange) obj).id, j2)) {
                            break;
                        } else {
                            i6++;
                        }
                    }
                    IndirectPointerInputChange indirectPointerInputChange4 = (IndirectPointerInputChange) obj;
                    if (indirectPointerInputChange4 == null) {
                        return;
                    }
                    boolean zAccess$changedToUpIgnoreConsumed = ScrollableKt.access$changedToUpIgnoreConsumed(indirectPointerInputChange4);
                    DragEvent.DragCancelled dragCancelled = DragEvent.DragCancelled.INSTANCE;
                    if (!zAccess$changedToUpIgnoreConsumed) {
                        if (indirectPointerInputChange4.isConsumed) {
                            dragGestureNode.onDragEvent(dragCancelled);
                            return;
                        } else {
                            if (Offset.m370getDistanceimpl(ScrollableKt.m97positionChangeInternalwfG_k4k(indirectPointerInputChange4, dragGestureNode.orientationLock, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), true)) == 0.0f) {
                                return;
                            }
                            indirectPointerInputDragCycleDetector.m83sendDragEventEu1f8Dk(indirectPointerInputChange4, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), ScrollableKt.m97positionChangeInternalwfG_k4k(indirectPointerInputChange4, dragGestureNode.orientationLock, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), false));
                            indirectPointerInputChange4.isConsumed = true;
                            return;
                        }
                    }
                    int size5 = arrayList.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= size5) {
                            obj2 = null;
                            break;
                        }
                        obj2 = arrayList.get(i7);
                        if (((IndirectPointerInputChange) obj2).pressed) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                    IndirectPointerInputChange indirectPointerInputChange5 = (IndirectPointerInputChange) obj2;
                    if (indirectPointerInputChange5 != null) {
                        indirectPointerInputDragCycleDetector$DragDetectionState$Dragging2.pointerId = indirectPointerInputChange5.id;
                        return;
                    }
                    if (indirectPointerInputChange4.isConsumed || !ScrollableKt.access$changedToUpIgnoreConsumed(indirectPointerInputChange4)) {
                        dragGestureNode.onDragEvent(dragCancelled);
                    } else {
                        ScrollableKt.m95access$addIndirectPointerInputChangeQf4Zb88(indirectPointerInputDragCycleDetector.requireVelocityTracker(), indirectPointerInputChange4, dragGestureNode.orientationLock, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), indirectPointerInputDragCycleDetector.touchSmooth, indirectPointerInputDragCycleDetector.nodeOffset);
                        float maximumFlingVelocity = ((ViewConfiguration) HitTestResultKt.currentValueOf(dragGestureNode, CompositionLocalsKt.LocalViewConfiguration)).getMaximumFlingVelocity();
                        long jM789calculateVelocityAH228Gc = indirectPointerInputDragCycleDetector.requireVelocityTracker().m789calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
                        VirtualCameraCaptureResult virtualCameraCaptureResult = (VirtualCameraCaptureResult) indirectPointerInputDragCycleDetector.requireVelocityTracker().entries;
                        VelocityTracker1D velocityTracker1D = (VelocityTracker1D) virtualCameraCaptureResult.mBaseCameraCaptureResult;
                        DataPointAtTime[] dataPointAtTimeArr = velocityTracker1D.samples;
                        Arrays.fill(dataPointAtTimeArr, 0, dataPointAtTimeArr.length, (Object) null);
                        velocityTracker1D.index = 0;
                        VelocityTracker1D velocityTracker1D2 = (VelocityTracker1D) virtualCameraCaptureResult.mTagBundle;
                        DataPointAtTime[] dataPointAtTimeArr2 = velocityTracker1D2.samples;
                        Arrays.fill(dataPointAtTimeArr2, 0, dataPointAtTimeArr2.length, (Object) null);
                        velocityTracker1D2.index = 0;
                        virtualCameraCaptureResult.mTimestamp = 0L;
                        dragGestureNode.onDragEvent(new DragEvent.DragStopped(DraggableKt.m80toValidVelocityTH1AsA0(jM789calculateVelocityAH228Gc), true));
                    }
                    indirectPointerInputDragCycleDetector.moveToAwaitDownState();
                    return;
                }
                IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop2 = (IndirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop) scrollableKt;
                if (pointerEventPass == pointerEventPass2) {
                    return;
                }
                int size6 = arrayList.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size6) {
                        obj3 = null;
                        break;
                    }
                    obj3 = arrayList.get(i8);
                    if (PointerId.m510equalsimpl0(((IndirectPointerInputChange) obj3).id, indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop2.pointerId)) {
                        break;
                    } else {
                        i8++;
                    }
                }
                IndirectPointerInputChange indirectPointerInputChange6 = (IndirectPointerInputChange) obj3;
                if (indirectPointerInputChange6 == null) {
                    int size7 = arrayList.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size7) {
                            obj5 = null;
                            break;
                        }
                        obj5 = arrayList.get(i9);
                        if (((IndirectPointerInputChange) obj5).pressed) {
                            break;
                        } else {
                            i9++;
                        }
                    }
                    indirectPointerInputChange = (IndirectPointerInputChange) obj5;
                    if (indirectPointerInputChange == null) {
                        indirectPointerInputDragCycleDetector.moveToAwaitDownState();
                        return;
                    }
                    indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop2.pointerId = indirectPointerInputChange.id;
                } else {
                    indirectPointerInputChange = indirectPointerInputChange6;
                }
                if (pointerEventPass != pointerEventPass3) {
                    indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop2;
                } else if (indirectPointerInputChange.isConsumed) {
                    indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop2;
                    IndirectPointerInputChange indirectPointerInputChange7 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown;
                    if (indirectPointerInputChange7 == null) {
                        throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized");
                    }
                    long j3 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId;
                    HeadersReader headersReader = indirectPointerInputDragCycleDetector.touchSlopDetector;
                    if (headersReader == null) {
                        throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized");
                    }
                    indirectPointerInputDragCycleDetector.m82moveToAwaitGesturePickupStaternUCldI(indirectPointerInputChange7, j3, headersReader);
                } else if (ScrollableKt.access$changedToUpIgnoreConsumed(indirectPointerInputChange)) {
                    int size8 = arrayList.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size8) {
                            obj4 = null;
                            break;
                        }
                        Object obj6 = arrayList.get(i10);
                        if (((IndirectPointerInputChange) obj6).pressed) {
                            obj4 = obj6;
                            break;
                        }
                        i10++;
                    }
                    IndirectPointerInputChange indirectPointerInputChange8 = (IndirectPointerInputChange) obj4;
                    if (indirectPointerInputChange8 == null) {
                        indirectPointerInputDragCycleDetector.moveToAwaitDownState();
                    } else {
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop2.pointerId = indirectPointerInputChange8.id;
                    }
                    indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop2;
                } else {
                    ViewConfiguration viewConfiguration = (ViewConfiguration) HitTestResultKt.currentValueOf(dragGestureNode, CompositionLocalsKt.LocalViewConfiguration);
                    float f = DragGestureDetectorKt.mouseToTouchSlopRatio;
                    float touchSlop = viewConfiguration.getTouchSlop();
                    HeadersReader headersReader2 = indirectPointerInputDragCycleDetector.touchSlopDetector;
                    if (headersReader2 == null) {
                        throw new IllegalArgumentException("Touch slop detector not initialized.");
                    }
                    long jM852getPostSlopOffsetqto3Fdw = headersReader2.m852getPostSlopOffsetqto3Fdw(ScrollableKt.m97positionChangeInternalwfG_k4k(indirectPointerInputChange, dragGestureNode.orientationLock, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), true), touchSlop, true);
                    if ((9223372034707292159L & jM852getPostSlopOffsetqto3Fdw) != 9205357640488583168L) {
                        indirectPointerInputChange.isConsumed = true;
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop2;
                        indirectPointerInputDragCycleDetector.m84sendDragStart3f7A7Is(indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown, indirectPointerInputChange, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), jM852getPostSlopOffsetqto3Fdw);
                        indirectPointerInputDragCycleDetector.m83sendDragEventEu1f8Dk(indirectPointerInputChange, new IndirectPointerEventPrimaryDirectionalMotionAxis(i), jM852getPostSlopOffsetqto3Fdw);
                        long j4 = indirectPointerInputChange.id;
                        IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3 = indirectPointerInputDragCycleDetector._draggingState;
                        if (indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3 == null) {
                            indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3 = new IndirectPointerInputDragCycleDetector$DragDetectionState$Dragging();
                            indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3.pointerId = Long.MAX_VALUE;
                            indirectPointerInputDragCycleDetector._draggingState = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3;
                        }
                        indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3.pointerId = j4;
                        indirectPointerInputDragCycleDetector.currentDragState = indirectPointerInputDragCycleDetector$DragDetectionState$Dragging3;
                    } else {
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop2;
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = true;
                    }
                }
                if (pointerEventPass == pointerEventPass4 && indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass) {
                    if (!indirectPointerInputChange.isConsumed) {
                        indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
                        return;
                    }
                    IndirectPointerInputChange indirectPointerInputChange9 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.initialDown;
                    if (indirectPointerInputChange9 == null) {
                        throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized");
                    }
                    long j5 = indirectPointerInputDragCycleDetector$DragDetectionState$AwaitTouchSlop.pointerId;
                    HeadersReader headersReader3 = indirectPointerInputDragCycleDetector.touchSlopDetector;
                    if (headersReader3 == null) {
                        throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized");
                    }
                    indirectPointerInputDragCycleDetector.m82moveToAwaitGesturePickupStaternUCldI(indirectPointerInputChange9, j5, headersReader3);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v50, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.lang.Object, java.util.List] */
    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo36onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        Object obj;
        Object obj2;
        PointerEventPass pointerEventPass2;
        Object obj3;
        Object obj4;
        Object obj5;
        boolean z = true;
        this.isListeningForPointerInputEvents = true;
        if (this.gestureNode == null) {
            GestureNode gestureNode = new GestureNode(this);
            delegate(gestureNode);
            this.gestureNode = gestureNode;
        }
        if (this.enabled) {
            if (this.currentDragState == null) {
                DragDetectionState$AwaitDown dragDetectionState$AwaitDown = this._awaitDownState;
                if (dragDetectionState$AwaitDown == null) {
                    dragDetectionState$AwaitDown = new DragDetectionState$AwaitDown();
                    dragDetectionState$AwaitDown.awaitTouchSlop = 3;
                    dragDetectionState$AwaitDown.consumedOnInitial = false;
                    this._awaitDownState = dragDetectionState$AwaitDown;
                }
                this.currentDragState = dragDetectionState$AwaitDown;
            }
            ScrollableKt scrollableKt = this.currentDragState;
            if (scrollableKt == null) {
                throw new IllegalArgumentException("currentDragState should not be null");
            }
            boolean z2 = scrollableKt instanceof DragDetectionState$AwaitDown;
            PointerEventPass pointerEventPass3 = PointerEventPass.Initial;
            PointerEventPass pointerEventPass4 = PointerEventPass.Main;
            if (z2) {
                DragDetectionState$AwaitDown dragDetectionState$AwaitDown2 = (DragDetectionState$AwaitDown) scrollableKt;
                if (!pointerEvent.changes.isEmpty() && TapGestureDetectorKt.isChangedToDown(pointerEvent, false, false)) {
                    PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.changes);
                    int i = WhenMappings.$EnumSwitchMapping$0[CaptureSession$State$EnumUnboxingLocalUtility.ordinal(dragDetectionState$AwaitDown2.awaitTouchSlop)] == 1 ? !startDragImmediately() ? 1 : 2 : dragDetectionState$AwaitDown2.awaitTouchSlop;
                    dragDetectionState$AwaitDown2.awaitTouchSlop = i;
                    if (pointerEventPass == pointerEventPass3 && i == 2) {
                        pointerInputChange.consume();
                        dragDetectionState$AwaitDown2.consumedOnInitial = true;
                    }
                    if (pointerEventPass == pointerEventPass4) {
                        if (i == 1) {
                            m76moveToAwaitTouchSlopStateaWI9W7U$default(this, pointerInputChange, pointerInputChange.id, 0L, 12);
                            return;
                        }
                        if (dragDetectionState$AwaitDown2.consumedOnInitial) {
                            m79sendDragStart0AR0LA0(pointerInputChange, pointerInputChange, 0L);
                            m78sendDragEventUv8p0NA(0L, pointerInputChange);
                            long j2 = pointerInputChange.id;
                            DragDetectionState$Dragging dragDetectionState$Dragging = this._draggingState;
                            if (dragDetectionState$Dragging == null) {
                                dragDetectionState$Dragging = new DragDetectionState$Dragging();
                                dragDetectionState$Dragging.pointerId = Long.MAX_VALUE;
                                this._draggingState = dragDetectionState$Dragging;
                            }
                            dragDetectionState$Dragging.pointerId = j2;
                            this.currentDragState = dragDetectionState$Dragging;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z3 = scrollableKt instanceof DragDetectionState$AwaitTouchSlop;
            PointerEventPass pointerEventPass5 = PointerEventPass.Final;
            if (!z3) {
                if (scrollableKt instanceof DragDetectionState$AwaitGesturePickup) {
                    DragDetectionState$AwaitGesturePickup dragDetectionState$AwaitGesturePickup = (DragDetectionState$AwaitGesturePickup) scrollableKt;
                    if (pointerEventPass != pointerEventPass5) {
                        return;
                    }
                    ?? r1 = pointerEvent.changes;
                    int size = r1.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (((PointerInputChange) r1.get(i2)).isConsumed()) {
                            z = false;
                            break;
                        }
                    }
                    int size2 = r1.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        if (((PointerInputChange) r1.get(i3)).pressed) {
                            if (r1.isEmpty()) {
                                break;
                            }
                            if (z) {
                                long jM372minusMKHz9U = Offset.m372minusMKHz9U(((PointerInputChange) CollectionsKt.first((List) r1)).position, dragDetectionState$AwaitGesturePickup.initialDown.position);
                                PointerInputChange pointerInputChange2 = dragDetectionState$AwaitGesturePickup.initialDown;
                                if (pointerInputChange2 == null) {
                                    throw new IllegalArgumentException("AwaitGesturePickup.initialDown was not initialized.");
                                }
                                m76moveToAwaitTouchSlopStateaWI9W7U$default(this, pointerInputChange2, dragDetectionState$AwaitGesturePickup.pointerId, jM372minusMKHz9U, 8);
                                return;
                            }
                            return;
                        }
                    }
                    moveToAwaitDownState();
                    return;
                }
                if (!(scrollableKt instanceof DragDetectionState$Dragging)) {
                    throw new HttpException();
                }
                DragDetectionState$Dragging dragDetectionState$Dragging2 = (DragDetectionState$Dragging) scrollableKt;
                if (pointerEventPass != pointerEventPass4) {
                    return;
                }
                long j3 = dragDetectionState$Dragging2.pointerId;
                ?? r2 = pointerEvent.changes;
                int size3 = r2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size3) {
                        obj = null;
                        break;
                    }
                    obj = r2.get(i4);
                    if (PointerId.m510equalsimpl0(((PointerInputChange) obj).id, j3)) {
                        break;
                    } else {
                        i4++;
                    }
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
                if (pointerInputChange3 == null) {
                    return;
                }
                boolean zChangedToUpIgnoreConsumed = PointerId.changedToUpIgnoreConsumed(pointerInputChange3);
                Object obj6 = DragEvent.DragCancelled.INSTANCE;
                if (!zChangedToUpIgnoreConsumed) {
                    if (pointerInputChange3.isConsumed()) {
                        requireChannel().mo842trySendJP2dKIU(obj6);
                        return;
                    } else {
                        if (Offset.m370getDistanceimpl(PointerId.positionChangeInternal(pointerInputChange3, true)) == 0.0f) {
                            return;
                        }
                        m78sendDragEventUv8p0NA(PointerId.positionChangeInternal(pointerInputChange3, false), pointerInputChange3);
                        pointerInputChange3.consume();
                        return;
                    }
                }
                ?? r3 = pointerEvent.changes;
                int size4 = r3.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size4) {
                        obj2 = null;
                        break;
                    }
                    obj2 = r3.get(i5);
                    if (((PointerInputChange) obj2).pressed) {
                        break;
                    } else {
                        i5++;
                    }
                }
                PointerInputChange pointerInputChange4 = (PointerInputChange) obj2;
                if (pointerInputChange4 != null) {
                    dragDetectionState$Dragging2.pointerId = pointerInputChange4.id;
                    return;
                }
                if (pointerInputChange3.isConsumed() || !PointerId.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    requireChannel().mo842trySendJP2dKIU(obj6);
                } else {
                    VelocityTrackerKt.m515addPointerInputChange0AR0LA0(requireVelocityTracker(), pointerInputChange3, 0L);
                    float maximumFlingVelocity = ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getMaximumFlingVelocity();
                    long jM789calculateVelocityAH228Gc = requireVelocityTracker().m789calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
                    VirtualCameraCaptureResult virtualCameraCaptureResult = (VirtualCameraCaptureResult) requireVelocityTracker().entries;
                    VelocityTracker1D velocityTracker1D = (VelocityTracker1D) virtualCameraCaptureResult.mBaseCameraCaptureResult;
                    DataPointAtTime[] dataPointAtTimeArr = velocityTracker1D.samples;
                    Arrays.fill(dataPointAtTimeArr, 0, dataPointAtTimeArr.length, (Object) null);
                    velocityTracker1D.index = 0;
                    VelocityTracker1D velocityTracker1D2 = (VelocityTracker1D) virtualCameraCaptureResult.mTagBundle;
                    DataPointAtTime[] dataPointAtTimeArr2 = velocityTracker1D2.samples;
                    Arrays.fill(dataPointAtTimeArr2, 0, dataPointAtTimeArr2.length, (Object) null);
                    velocityTracker1D2.index = 0;
                    virtualCameraCaptureResult.mTimestamp = 0L;
                    requireChannel().mo842trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m80toValidVelocityTH1AsA0(jM789calculateVelocityAH228Gc), false));
                    this.isListeningForPointerInputEvents = false;
                }
                moveToAwaitDownState();
                return;
            }
            DragDetectionState$AwaitTouchSlop dragDetectionState$AwaitTouchSlop = (DragDetectionState$AwaitTouchSlop) scrollableKt;
            if (pointerEventPass == pointerEventPass3) {
                return;
            }
            ?? r4 = pointerEvent.changes;
            int size5 = r4.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size5) {
                    pointerEventPass2 = pointerEventPass5;
                    obj3 = null;
                    break;
                }
                obj3 = r4.get(i6);
                int i7 = size5;
                pointerEventPass2 = pointerEventPass5;
                if (PointerId.m510equalsimpl0(((PointerInputChange) obj3).id, dragDetectionState$AwaitTouchSlop.pointerId)) {
                    break;
                }
                i6++;
                size5 = i7;
                pointerEventPass5 = pointerEventPass2;
            }
            PointerInputChange pointerInputChange5 = (PointerInputChange) obj3;
            if (pointerInputChange5 == null) {
                int size6 = r4.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size6) {
                        obj5 = null;
                        break;
                    }
                    obj5 = r4.get(i8);
                    if (((PointerInputChange) obj5).pressed) {
                        break;
                    } else {
                        i8++;
                    }
                }
                pointerInputChange5 = (PointerInputChange) obj5;
                if (pointerInputChange5 == null) {
                    moveToAwaitDownState();
                    return;
                }
                dragDetectionState$AwaitTouchSlop.pointerId = pointerInputChange5.id;
            }
            if (pointerEventPass == pointerEventPass4) {
                if (pointerInputChange5.isConsumed()) {
                    PointerInputChange pointerInputChange6 = dragDetectionState$AwaitTouchSlop.initialDown;
                    if (pointerInputChange6 == null) {
                        throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized");
                    }
                    long j4 = dragDetectionState$AwaitTouchSlop.pointerId;
                    HeadersReader headersReader = this.touchSlopDetector;
                    if (headersReader == null) {
                        throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized");
                    }
                    m77moveToAwaitGesturePickupStaternUCldI(pointerInputChange6, j4, headersReader);
                } else if (PointerId.changedToUpIgnoreConsumed(pointerInputChange5)) {
                    int size7 = r4.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size7) {
                            obj4 = null;
                            break;
                        }
                        Object obj7 = r4.get(i9);
                        if (((PointerInputChange) obj7).pressed) {
                            obj4 = obj7;
                            break;
                        }
                        i9++;
                    }
                    PointerInputChange pointerInputChange7 = (PointerInputChange) obj4;
                    if (pointerInputChange7 == null) {
                        moveToAwaitDownState();
                    } else {
                        dragDetectionState$AwaitTouchSlop.pointerId = pointerInputChange7.id;
                    }
                } else {
                    float fM75pointerSlopE8SPZFQ = DragGestureDetectorKt.m75pointerSlopE8SPZFQ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration), pointerInputChange5.type);
                    HeadersReader headersReader2 = this.touchSlopDetector;
                    if (headersReader2 == null) {
                        throw new IllegalArgumentException("Touch slop detector not initialized.");
                    }
                    long jM852getPostSlopOffsetqto3Fdw = headersReader2.m852getPostSlopOffsetqto3Fdw(PointerId.positionChangeInternal(pointerInputChange5, true), fM75pointerSlopE8SPZFQ, true);
                    if ((9223372034707292159L & jM852getPostSlopOffsetqto3Fdw) != 9205357640488583168L) {
                        boolean zIsInterested = isInterested(pointerInputChange5);
                        GestureConnection parentGestureConnection = ImageKt.getParentGestureConnection(this);
                        boolean z4 = parentGestureConnection != null && parentGestureConnection.isInterested(pointerInputChange5);
                        if (zIsInterested || !z4) {
                            pointerInputChange5.consume();
                            m79sendDragStart0AR0LA0(dragDetectionState$AwaitTouchSlop.initialDown, pointerInputChange5, jM852getPostSlopOffsetqto3Fdw);
                            m78sendDragEventUv8p0NA(jM852getPostSlopOffsetqto3Fdw, pointerInputChange5);
                            long j5 = pointerInputChange5.id;
                            DragDetectionState$Dragging dragDetectionState$Dragging3 = this._draggingState;
                            if (dragDetectionState$Dragging3 == null) {
                                dragDetectionState$Dragging3 = new DragDetectionState$Dragging();
                                dragDetectionState$Dragging3.pointerId = Long.MAX_VALUE;
                                this._draggingState = dragDetectionState$Dragging3;
                            }
                            dragDetectionState$Dragging3.pointerId = j5;
                            this.currentDragState = dragDetectionState$Dragging3;
                        } else {
                            dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = true;
                        }
                    } else {
                        dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = true;
                    }
                }
            }
            if (pointerEventPass == pointerEventPass2 && dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass) {
                if (!pointerInputChange5.isConsumed()) {
                    dragDetectionState$AwaitTouchSlop.verifyConsumptionInFinalPass = false;
                    return;
                }
                PointerInputChange pointerInputChange8 = dragDetectionState$AwaitTouchSlop.initialDown;
                if (pointerInputChange8 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.initialDown was not initialized");
                }
                long j6 = dragDetectionState$AwaitTouchSlop.pointerId;
                HeadersReader headersReader3 = this.touchSlopDetector;
                if (headersReader3 == null) {
                    throw new IllegalArgumentException("AwaitTouchSlop.touchSlopDetector was not initialized");
                }
                m77moveToAwaitGesturePickupStaternUCldI(pointerInputChange8, j6, headersReader3);
            }
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onViewConfigurationChange() {
        onCancelPointerInput();
    }

    public final Channel requireChannel() {
        BufferedChannel bufferedChannel = this.channel;
        if (bufferedChannel != null) {
            return bufferedChannel;
        }
        throw new IllegalArgumentException("Events channel not initialized.");
    }

    public final Parameters.Builder requireVelocityTracker() {
        Parameters.Builder builder = this.velocityTracker;
        if (builder != null) {
            return builder;
        }
        throw new IllegalArgumentException("Velocity Tracker not initialized.");
    }

    /* JADX INFO: renamed from: sendDragEvent-Uv8p0NA, reason: not valid java name */
    public final void m78sendDragEventUv8p0NA(long j, PointerInputChange pointerInputChange) {
        long jMo526localToScreenMKHz9U = HitTestResultKt.requireLayoutCoordinates(this.node).mo526localToScreenMKHz9U(0L);
        if (!Offset.m369equalsimpl0(this.previousPositionOnScreen, 9205357640488583168L) && !Offset.m369equalsimpl0(jMo526localToScreenMKHz9U, this.previousPositionOnScreen)) {
            this.nodeOffset = Offset.m373plusMKHz9U(this.nodeOffset, Offset.m372minusMKHz9U(jMo526localToScreenMKHz9U, this.previousPositionOnScreen));
        }
        this.previousPositionOnScreen = jMo526localToScreenMKHz9U;
        VelocityTrackerKt.m515addPointerInputChange0AR0LA0(requireVelocityTracker(), pointerInputChange, this.nodeOffset);
        requireChannel().mo842trySendJP2dKIU(new DragEvent.DragDelta(j, false));
    }

    /* JADX INFO: renamed from: sendDragStart-0AR0LA0, reason: not valid java name */
    public final void m79sendDragStart0AR0LA0(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j) {
        if (this.velocityTracker == null) {
            this.velocityTracker = new Parameters.Builder(7);
        }
        VelocityTrackerKt.m515addPointerInputChange0AR0LA0(requireVelocityTracker(), pointerInputChange, 0L);
        long jM372minusMKHz9U = Offset.m372minusMKHz9U(pointerInputChange2.position, j);
        this.nodeOffset = 0L;
        if (((Boolean) this.canDrag.invoke(new PointerType(pointerInputChange.type))).booleanValue()) {
            if (!this.isListeningForEvents) {
                if (this.channel == null) {
                    this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, 0, 6);
                }
                startListeningForEvents();
            }
            this.previousPositionOnScreen = HitTestResultKt.requireLayoutCoordinates(this).mo526localToScreenMKHz9U(0L);
            requireChannel().mo842trySendJP2dKIU(new DragEvent.DragStarted(jM372minusMKHz9U));
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return false;
    }

    public abstract boolean startDragImmediately();

    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        if (this.channel == null) {
            this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, 0, 6);
        }
        JobKt.launch$default(getCoroutineScope(), null, new AnonymousClass1(null), 3);
    }

    public final void update(Function1 function1, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, Orientation orientation, boolean z2) {
        this.canDrag = function1;
        boolean z3 = true;
        if (this.enabled != z) {
            this.enabled = z;
            if (!z) {
                disposeInteractionSource$1();
                this.indirectPointerInputDragCycleDetector = null;
            }
            z2 = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, mutableInteractionSourceImpl)) {
            disposeInteractionSource$1();
            this.interactionSource = mutableInteractionSourceImpl;
        }
        if (this.orientationLock != orientation) {
            this.orientationLock = orientation;
        } else {
            z3 = z2;
        }
        if (z3) {
            boolean z4 = this.isListeningForPointerInputEvents;
            DragEvent.DragCancelled dragCancelled = DragEvent.DragCancelled.INSTANCE;
            if (z4) {
                moveToAwaitDownState();
                if (this.isListeningForEvents) {
                    requireChannel().mo842trySendJP2dKIU(dragCancelled);
                }
                this.velocityTracker = null;
            }
            IndirectPointerInputDragCycleDetector indirectPointerInputDragCycleDetector = this.indirectPointerInputDragCycleDetector;
            if (indirectPointerInputDragCycleDetector != null) {
                indirectPointerInputDragCycleDetector.moveToAwaitDownState();
                DragGestureNode dragGestureNode = indirectPointerInputDragCycleDetector.node;
                if (dragGestureNode.isListeningForEvents) {
                    dragGestureNode.onDragEvent(dragCancelled);
                }
                indirectPointerInputDragCycleDetector.velocityTracker = null;
                RealWeakMemoryCache realWeakMemoryCache = indirectPointerInputDragCycleDetector.offsetSmoother;
                realWeakMemoryCache.operationsSinceCleanUp = 0;
                ((MutableLongList) realWeakMemoryCache.cache)._size = 0;
            }
        }
    }

    @Override // androidx.compose.foundation.GestureConnection
    public final boolean isInterested(PointerInputChange pointerInputChange) {
        if (PointerId.changedToDownIgnoreConsumed(pointerInputChange)) {
            return this.enabled;
        }
        if (!PointerId.changedToUpIgnoreConsumed(pointerInputChange)) {
            int i = 2;
            if (this.touchSlopDetector == null) {
                this.touchSlopDetector = new HeadersReader(this.orientationLock, i);
            }
            float touchSlop = ((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).getTouchSlop();
            long jPositionChangeInternal = PointerId.positionChangeInternal(pointerInputChange, false);
            HeadersReader headersReader = this.touchSlopDetector;
            if (headersReader == null) {
                throw new IllegalArgumentException("Touch slop detector not initialized.");
            }
            if (!Offset.m369equalsimpl0(headersReader.m852getPostSlopOffsetqto3Fdw(jPositionChangeInternal, touchSlop, false), 9205357640488583168L)) {
                long jM373plusMKHz9U = Offset.m373plusMKHz9U(headersReader.headerLimit, jPositionChangeInternal);
                double dAtan2 = ((double) (((float) Math.atan2(Math.abs(Float.intBitsToFloat((int) (jM373plusMKHz9U & 4294967295L))), Math.abs(Float.intBitsToFloat((int) (jM373plusMKHz9U >> 32))))) * 180)) / 3.141592653589793d;
                Orientation orientation = (Orientation) headersReader.source;
                int i2 = orientation == null ? -1 : TouchSlopDetector$WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
                if (i2 == 1 ? dAtan2 < 30.0d : !(i2 != 2 || dAtan2 <= 30.0d)) {
                    return true;
                }
            }
        }
        return false;
    }
}
