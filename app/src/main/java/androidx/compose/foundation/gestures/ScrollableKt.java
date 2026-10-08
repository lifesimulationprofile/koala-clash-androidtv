package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.collection.MutableObjectList;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.memory.RealWeakMemoryCache;
import coil.request.Parameters;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.JobKt;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ScrollableKt {
    public static final BorderKt$$ExternalSyntheticLambda1 AlwaysDrag = new BorderKt$$ExternalSyntheticLambda1(27);
    public static final DecayAnimationSpecImpl NoOpDecayAnimationSpec = new DecayAnimationSpecImpl(new Path.Companion());
    public static final BasicTextKt$$ExternalSyntheticLambda3 CanDragCalculation = new BasicTextKt$$ExternalSyntheticLambda3(4);
    public static final ScrollableKt$NoOpScrollScope$1 NoOpScrollScope = new ScrollableKt$NoOpScrollScope$1();
    public static final ScrollableKt$DefaultScrollMotionDurationScale$1 DefaultScrollMotionDurationScale = new ScrollableKt$DefaultScrollMotionDurationScale$1();
    public static final ScrollableKt$UnityDensity$1 UnityDensity = new ScrollableKt$UnityDensity$1();
    public static final BasicTextKt$$ExternalSyntheticLambda3 NoOnReport = new BasicTextKt$$ExternalSyntheticLambda3(5);

    /* JADX INFO: renamed from: access$addIndirectPointerInputChange-Qf4Zb88, reason: not valid java name */
    public static final void m95access$addIndirectPointerInputChangeQf4Zb88(Parameters.Builder builder, IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, RealWeakMemoryCache realWeakMemoryCache, long j) {
        float fIntBitsToFloat;
        MutableObjectList mutableObjectList = (MutableObjectList) realWeakMemoryCache.cache;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (indirectPointerInputChange.position >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (indirectPointerInputChange.position & 4294967295L));
        if (changedToDownIgnoreConsumed(indirectPointerInputChange)) {
            realWeakMemoryCache.operationsSinceCleanUp = 0;
            mutableObjectList.clear();
        }
        if (!access$changedToUpIgnoreConsumed(indirectPointerInputChange) && !changedToDownIgnoreConsumed(indirectPointerInputChange)) {
            if (mutableObjectList._size == 3) {
                int i = realWeakMemoryCache.operationsSinceCleanUp;
                realWeakMemoryCache.operationsSinceCleanUp = i + 1;
                mutableObjectList.set(i, indirectPointerInputChange);
            } else {
                mutableObjectList.add(indirectPointerInputChange);
            }
            if (realWeakMemoryCache.operationsSinceCleanUp == 3) {
                realWeakMemoryCache.operationsSinceCleanUp = 0;
            }
            Object[] objArr = mutableObjectList.content;
            int i2 = mutableObjectList._size;
            float fIntBitsToFloat4 = 0.0f;
            for (int i3 = 0; i3 < i2; i3++) {
                fIntBitsToFloat4 += Float.intBitsToFloat((int) (((IndirectPointerInputChange) objArr[i3]).position >> 32));
            }
            int i4 = mutableObjectList._size;
            fIntBitsToFloat2 = fIntBitsToFloat4 / i4;
            Object[] objArr2 = mutableObjectList.content;
            float fIntBitsToFloat5 = 0.0f;
            for (int i5 = 0; i5 < i4; i5++) {
                fIntBitsToFloat5 += Float.intBitsToFloat((int) (((IndirectPointerInputChange) objArr2[i5]).position & 4294967295L));
            }
            fIntBitsToFloat3 = fIntBitsToFloat5 / mutableObjectList._size;
        }
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) & 4294967295L);
        if (orientation != null) {
            int i6 = indirectPointerEventPrimaryDirectionalMotionAxis.value;
            if (i6 == 1) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32));
            } else if (i6 == 2) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L));
            }
            jFloatToRawIntBits = orientation == Orientation.Horizontal ? (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L) : (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32);
        }
        ((VirtualCameraCaptureResult) builder.entries).m18addPositionUv8p0NA(indirectPointerInputChange.uptimeMillis, Offset.m373plusMKHz9U(jFloatToRawIntBits, j));
    }

    public static final Object access$animateTo(NodeChain nodeChain, float f, AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1, DefaultDraggableAnchors defaultDraggableAnchors, Object obj, AnimationSpec animationSpec, SuspendLambda suspendLambda) {
        Object objAnimate;
        float fPositionOf = defaultDraggableAnchors.positionOf(obj);
        Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.element = Float.isNaN(((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue()) ? 0.0f : ((ParcelableSnapshotMutableFloatState) nodeChain.head).getFloatValue();
        if (!Float.isNaN(fPositionOf)) {
            float f2 = ref$FloatRef.element;
            if (f2 != fPositionOf && (objAnimate = ArcSplineKt.animate(f2, fPositionOf, f, animationSpec, new TextKt$$ExternalSyntheticLambda2(3, anchoredDraggableState$anchoredDragScope$1, ref$FloatRef), suspendLambda)) == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return objAnimate;
            }
        }
        return Unit.INSTANCE;
    }

    public static final boolean access$changedToUpIgnoreConsumed(IndirectPointerInputChange indirectPointerInputChange) {
        return indirectPointerInputChange.previousPressed && !indirectPointerInputChange.pressed;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
    
        if (r1 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        if (r1 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object access$computeTarget(androidx.compose.foundation.gestures.DefaultDraggableAnchors r5, float r6, float r7, kotlin.jvm.functions.Function1 r8, kotlin.jvm.functions.Function0 r9) {
        /*
            boolean r0 = java.lang.Float.isNaN(r6)
            if (r0 != 0) goto L88
            float r0 = java.lang.Math.abs(r7)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 0
            r3 = 1
            if (r0 <= 0) goto L13
            r0 = r3
            goto L14
        L13:
            r0 = r2
        L14:
            if (r0 == 0) goto L1c
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L1c
            r1 = r3
            goto L1d
        L1c:
            r1 = r2
        L1d:
            if (r0 != 0) goto L24
            java.lang.Object r5 = r5.closestAnchor(r6)
            goto L81
        L24:
            float r7 = java.lang.Math.abs(r7)
            java.lang.Object r9 = r9.invoke()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            float r9 = java.lang.Math.abs(r9)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L3f
            java.lang.Object r5 = r5.closestAnchor(r6, r1)
            goto L81
        L3f:
            java.lang.Object r7 = r5.closestAnchor(r6, r2)
            float r9 = r5.positionOf(r7)
            java.lang.Object r0 = r5.closestAnchor(r6, r3)
            float r5 = r5.positionOf(r0)
            float r4 = r9 - r5
            float r4 = java.lang.Math.abs(r4)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Object r8 = r8.invoke(r4)
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            float r8 = java.lang.Math.abs(r8)
            if (r1 == 0) goto L6a
            goto L6b
        L6a:
            r9 = r5
        L6b:
            float r9 = r9 - r6
            float r5 = java.lang.Math.abs(r9)
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 < 0) goto L75
            r2 = r3
        L75:
            if (r2 != r3) goto L7a
            if (r1 == 0) goto L7e
            goto L80
        L7a:
            if (r2 != 0) goto L82
            if (r1 == 0) goto L80
        L7e:
            r5 = r7
            goto L81
        L80:
            r5 = r0
        L81:
            return r5
        L82:
            coil.network.HttpException r5 = new coil.network.HttpException
            r5.<init>()
            throw r5
        L88:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "The offset provided to computeTarget must not be NaN."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.access$computeTarget(androidx.compose.foundation.gestures.DefaultDraggableAnchors, float, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$restartable(Function0 function0, Function2 function2, ContinuationImpl continuationImpl) {
        AnchoredDraggableKt$restartable$1 anchoredDraggableKt$restartable$1;
        if (continuationImpl instanceof AnchoredDraggableKt$restartable$1) {
            anchoredDraggableKt$restartable$1 = (AnchoredDraggableKt$restartable$1) continuationImpl;
            int i = anchoredDraggableKt$restartable$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anchoredDraggableKt$restartable$1.label = i - Integer.MIN_VALUE;
            } else {
                anchoredDraggableKt$restartable$1 = new AnchoredDraggableKt$restartable$1(continuationImpl);
            }
        } else {
            anchoredDraggableKt$restartable$1 = new AnchoredDraggableKt$restartable$1(continuationImpl);
        }
        Object obj = anchoredDraggableKt$restartable$1.result;
        int i2 = anchoredDraggableKt$restartable$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                NavHostKt$NavHost$28$1 navHostKt$NavHost$28$1 = new NavHostKt$NavHost$28$1(function0, function2, (Continuation) null, 6);
                anchoredDraggableKt$restartable$1.label = 1;
                Object objCoroutineScope = JobKt.coroutineScope(navHostKt$NavHost$28$1, anchoredDraggableKt$restartable$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCoroutineScope == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (AnchoredDragFinishedSignal unused) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: access$semanticsScrollBy-d-4ec7I, reason: not valid java name */
    public static final Object m96access$semanticsScrollByd4ec7I(ScrollingLogic scrollingLogic, long j, ContinuationImpl continuationImpl) {
        ScrollableKt$semanticsScrollBy$1 scrollableKt$semanticsScrollBy$1;
        Ref$FloatRef ref$FloatRef;
        ScrollingLogic scrollingLogic2;
        if (continuationImpl instanceof ScrollableKt$semanticsScrollBy$1) {
            scrollableKt$semanticsScrollBy$1 = (ScrollableKt$semanticsScrollBy$1) continuationImpl;
            int i = scrollableKt$semanticsScrollBy$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                scrollableKt$semanticsScrollBy$1.label = i - Integer.MIN_VALUE;
            } else {
                scrollableKt$semanticsScrollBy$1 = new ScrollableKt$semanticsScrollBy$1(continuationImpl);
            }
        } else {
            scrollableKt$semanticsScrollBy$1 = new ScrollableKt$semanticsScrollBy$1(continuationImpl);
        }
        Object obj = scrollableKt$semanticsScrollBy$1.result;
        int i2 = scrollableKt$semanticsScrollBy$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ref$FloatRef = new Ref$FloatRef();
            ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2(scrollingLogic, j, ref$FloatRef, (Continuation) null, 0);
            scrollableKt$semanticsScrollBy$1.L$0 = scrollingLogic;
            scrollableKt$semanticsScrollBy$1.L$1 = ref$FloatRef;
            scrollableKt$semanticsScrollBy$1.label = 1;
            Object objScroll = scrollingLogic.scroll(MutatePriority.Default, scrollableKt$semanticsScrollBy$2, scrollableKt$semanticsScrollBy$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objScroll == coroutineSingletons) {
                return coroutineSingletons;
            }
            scrollingLogic2 = scrollingLogic;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref$FloatRef ref$FloatRef2 = scrollableKt$semanticsScrollBy$1.L$1;
            ScrollingLogic scrollingLogic3 = scrollableKt$semanticsScrollBy$1.L$0;
            ResultKt.throwOnFailure(obj);
            ref$FloatRef = ref$FloatRef2;
            scrollingLogic2 = scrollingLogic3;
        }
        return new Offset(scrollingLogic2.m108toOffsettuRUvjQ(ref$FloatRef.element));
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public static final boolean allPointersUp(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine) {
        ?? r5 = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
        int size = r5.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            if (((PointerInputChange) r5.get(i)).pressed) {
                z = true;
                break;
            }
        }
        return !z;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object animateToWithDecay(NodeChain nodeChain, Object obj, float f, AnimationSpec animationSpec, DecayAnimationSpecImpl decayAnimationSpecImpl, ContinuationImpl continuationImpl) throws Throwable {
        AnchoredDraggableKt$animateToWithDecay$1 anchoredDraggableKt$animateToWithDecay$1;
        float f2;
        Ref$FloatRef ref$FloatRef;
        if (continuationImpl instanceof AnchoredDraggableKt$animateToWithDecay$1) {
            anchoredDraggableKt$animateToWithDecay$1 = (AnchoredDraggableKt$animateToWithDecay$1) continuationImpl;
            int i = anchoredDraggableKt$animateToWithDecay$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anchoredDraggableKt$animateToWithDecay$1.label = i - Integer.MIN_VALUE;
            } else {
                anchoredDraggableKt$animateToWithDecay$1 = new AnchoredDraggableKt$animateToWithDecay$1(continuationImpl);
            }
        } else {
            anchoredDraggableKt$animateToWithDecay$1 = new AnchoredDraggableKt$animateToWithDecay$1(continuationImpl);
        }
        Object obj2 = anchoredDraggableKt$animateToWithDecay$1.result;
        int i2 = anchoredDraggableKt$animateToWithDecay$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            ref$FloatRef2.element = f;
            Function4 anchoredDraggableKt$animateToWithDecay$2 = new AnchoredDraggableKt$animateToWithDecay$2(nodeChain, f, animationSpec, ref$FloatRef2, decayAnimationSpecImpl, null);
            anchoredDraggableKt$animateToWithDecay$1.L$0 = ref$FloatRef2;
            anchoredDraggableKt$animateToWithDecay$1.F$0 = f;
            anchoredDraggableKt$animateToWithDecay$1.label = 1;
            Object objAnchoredDrag = nodeChain.anchoredDrag(obj, MutatePriority.Default, anchoredDraggableKt$animateToWithDecay$2, anchoredDraggableKt$animateToWithDecay$1);
            Object obj3 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnchoredDrag == obj3) {
                return obj3;
            }
            f2 = f;
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f2 = anchoredDraggableKt$animateToWithDecay$1.F$0;
            ref$FloatRef = anchoredDraggableKt$animateToWithDecay$1.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        return new Float(f2 - ref$FloatRef.element);
    }

    public static Object animateToWithDecay$default(NodeChain nodeChain, Object obj, float f, AnchoredDraggableNode$fling$1 anchoredDraggableNode$fling$1) {
        if (nodeChain.getUsePreModifierChangeBehavior$foundation()) {
            Intrinsics.throwUninitializedPropertyAccessException("snapAnimationSpec");
            throw null;
        }
        TweenSpec tweenSpec = AnchoredDraggableDefaults.SnapAnimationSpec;
        if (!nodeChain.getUsePreModifierChangeBehavior$foundation()) {
            return animateToWithDecay(nodeChain, obj, f, tweenSpec, AnchoredDraggableDefaults.DecayAnimationSpec, anchoredDraggableNode$fling$1);
        }
        Intrinsics.throwUninitializedPropertyAccessException("decayAnimationSpec");
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0057  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062 A[LOOP:0: B:20:0x0055->B:24:0x0062, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:27:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x003d A[EDGE_INSN: B:28:0x003d->B:16:0x003d BREAK  A[LOOP:0: B:20:0x0055->B:24:0x0062], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:19:0x004c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object awaitAllPointersUp(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r6, androidx.compose.ui.input.pointer.PointerEventPass r7, kotlin.coroutines.jvm.internal.BaseContinuationImpl r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            androidx.compose.ui.input.pointer.PointerEventPass r6 = r0.L$1
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L4c
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = allPointersUp(r6)
            if (r8 != 0) goto L65
        L3d:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r2
            java.lang.Object r8 = r6.awaitPointerEvent(r7, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r1) goto L4c
            return r1
        L4c:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.lang.Object r8 = r8.changes
            int r1 = r8.size()
            r3 = 0
        L55:
            if (r3 >= r1) goto L65
            java.lang.Object r4 = r8.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            boolean r4 = r4.pressed
            if (r4 == 0) goto L62
            goto L3d
        L62:
            int r3 = r3 + 1
            goto L55
        L65:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.awaitAllPointersUp(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    public static final Object awaitEachGesture(PointerInputScope pointerInputScope, Function2 function2, Continuation continuation) {
        Object objAwaitPointerEventScope = ((SuspendingPointerInputModifierNodeImpl) pointerInputScope).awaitPointerEventScope(new ForEachGestureKt$awaitEachGesture$2(continuation.getContext(), function2, (Continuation) null), continuation);
        return objAwaitPointerEventScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    public static final boolean changedToDownIgnoreConsumed(IndirectPointerInputChange indirectPointerInputChange) {
        return !indirectPointerInputChange.previousPressed && indirectPointerInputChange.pressed;
    }

    public static DefaultFlingBehavior flingBehavior(GapComposer gapComposer) {
        float f = SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction;
        Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        boolean zChanged = gapComposer.changed(density.getDensity());
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj = Composer$Companion.Empty;
        if (zChanged || objRememberedValue == obj) {
            objRememberedValue = new DecayAnimationSpecImpl(new Toolbar.AnonymousClass1(density));
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        DecayAnimationSpecImpl decayAnimationSpecImpl = (DecayAnimationSpecImpl) objRememberedValue;
        boolean zChanged2 = gapComposer.changed(decayAnimationSpecImpl);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == obj) {
            objRememberedValue2 = new DefaultFlingBehavior(decayAnimationSpecImpl);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        return (DefaultFlingBehavior) objRememberedValue2;
    }

    /* JADX INFO: renamed from: positionChangeInternal-wfG_k4k, reason: not valid java name */
    public static final long m97positionChangeInternalwfG_k4k(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, boolean z) {
        float fIntBitsToFloat;
        long jFloatToRawIntBits;
        long j;
        long j2 = indirectPointerInputChange.previousPosition;
        if (orientation != null) {
            int i = indirectPointerEventPrimaryDirectionalMotionAxis.value;
            if (i == 1) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            } else if (i == 2) {
                fIntBitsToFloat = Float.intBitsToFloat((int) (j2 & 4294967295L));
            }
            if (orientation == Orientation.Horizontal) {
                long jFloatToRawIntBits2 = Float.floatToRawIntBits(fIntBitsToFloat);
                jFloatToRawIntBits = Float.floatToRawIntBits(0.0f);
                j = jFloatToRawIntBits2 << 32;
            } else {
                long jFloatToRawIntBits3 = Float.floatToRawIntBits(0.0f);
                jFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat);
                j = jFloatToRawIntBits3 << 32;
            }
            j2 = j | (4294967295L & jFloatToRawIntBits);
        }
        long jM372minusMKHz9U = Offset.m372minusMKHz9U(m98primaryAxisPosition_bfSUIo(indirectPointerInputChange, orientation, indirectPointerEventPrimaryDirectionalMotionAxis), j2);
        if (z || !indirectPointerInputChange.isConsumed) {
            return jM372minusMKHz9U;
        }
        return 0L;
    }

    /* JADX INFO: renamed from: primaryAxisPosition-_bfSUIo, reason: not valid java name */
    public static final long m98primaryAxisPosition_bfSUIo(IndirectPointerInputChange indirectPointerInputChange, Orientation orientation, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis) {
        float fIntBitsToFloat;
        long jFloatToRawIntBits;
        long j;
        if (orientation == null) {
            return indirectPointerInputChange.position;
        }
        int i = indirectPointerEventPrimaryDirectionalMotionAxis.value;
        if (i == 1) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.position >> 32));
        } else {
            if (i != 2) {
                return indirectPointerInputChange.position;
            }
            fIntBitsToFloat = Float.intBitsToFloat((int) (indirectPointerInputChange.position & 4294967295L));
        }
        if (orientation == Orientation.Horizontal) {
            long jFloatToRawIntBits2 = Float.floatToRawIntBits(fIntBitsToFloat);
            jFloatToRawIntBits = Float.floatToRawIntBits(0.0f);
            j = jFloatToRawIntBits2 << 32;
        } else {
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(0.0f);
            jFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat);
            j = jFloatToRawIntBits3 << 32;
        }
        return j | (4294967295L & jFloatToRawIntBits);
    }

    public static Modifier scrollable$default(TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 textFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1, Orientation orientation, boolean z, boolean z2, MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        return new ScrollableElement(textFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1, orientation, z, z2, mutableInteractionSourceImpl);
    }
}
