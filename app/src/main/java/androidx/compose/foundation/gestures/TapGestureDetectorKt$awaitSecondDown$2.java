package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TapGestureDetectorKt$awaitSecondDown$2 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ Object $firstUp;
    public final /* synthetic */ int $r8$classId = 1;
    public long J$0;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$awaitSecondDown$2(long j, Ref$LongRef ref$LongRef, Continuation continuation) {
        super(2, continuation);
        this.J$0 = j;
        this.$firstUp = ref$LongRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$2 = new TapGestureDetectorKt$awaitSecondDown$2((PointerInputChange) this.$firstUp, continuation);
                tapGestureDetectorKt$awaitSecondDown$2.L$0 = obj;
                return tapGestureDetectorKt$awaitSecondDown$2;
            default:
                TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$3 = new TapGestureDetectorKt$awaitSecondDown$2(this.J$0, (Ref$LongRef) this.$firstUp, continuation);
                tapGestureDetectorKt$awaitSecondDown$3.L$0 = obj;
                return tapGestureDetectorKt$awaitSecondDown$3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((TapGestureDetectorKt$awaitSecondDown$2) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a3 A[PHI: r0 r2
      0x00a3: PHI (r0v6 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine) = 
      (r0v5 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
      (r0v7 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
     binds: [B:29:0x008a, B:34:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x00a3: PHI (r2v2 long) = (r2v1 long), (r2v3 long) binds: [B:29:0x008a, B:34:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b3 A[PHI: r0 r2 r8
      0x00b3: PHI (r0v7 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine) = 
      (r0v6 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
      (r0v10 androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine)
     binds: [B:31:0x00b0, B:26:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x00b3: PHI (r2v3 long) = (r2v2 long), (r2v4 long) binds: [B:31:0x00b0, B:26:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x00b3: PHI (r8v5 java.lang.Object) = (r8v4 java.lang.Object), (r8v0 java.lang.Object) binds: [B:31:0x00b0, B:26:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b0 -> B:33:0x00b3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.$r8$classId
            switch(r0) {
                case 0: goto L71;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r7.$firstUp
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref$LongRef) r0
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L20
            if (r1 != r2) goto L18
            java.lang.Object r1 = r7.L$0
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r1 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L3e
        L18:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L20:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r1 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r1
            long r3 = r7.J$0
            androidx.compose.runtime.Updater$$ExternalSyntheticLambda0 r8 = new androidx.compose.runtime.Updater$$ExternalSyntheticLambda0
            r5 = 13
            r8.<init>(r5, r0)
            r7.L$0 = r1
            r7.label = r2
            java.lang.Object r8 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m71awaitTouchSlopOrCancellationjO51t88(r1, r3, r8, r7)
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r2) goto L3e
            goto L70
        L3e:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 == 0) goto L56
            long r2 = r0.element
            r4 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            long r2 = r2 & r4
            r4 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L56
            androidx.compose.foundation.text.selection.DownResolution r2 = androidx.compose.foundation.text.selection.DownResolution.Drag
            goto L70
        L56:
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r8 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.this
            androidx.compose.ui.input.pointer.PointerEvent r8 = r8.currentEvent
            java.lang.Object r8 = r8.changes
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r0 = androidx.compose.ui.input.pointer.PointerId.changedToUpIgnoreConsumed(r8)
            if (r0 == 0) goto L6e
            r8.consume()
            androidx.compose.foundation.text.selection.DownResolution r2 = androidx.compose.foundation.text.selection.DownResolution.Up
            goto L70
        L6e:
            androidx.compose.foundation.text.selection.DownResolution r2 = androidx.compose.foundation.text.selection.DownResolution.Cancel
        L70:
            return r2
        L71:
            int r0 = r7.label
            r1 = 1
            if (r0 == 0) goto L8a
            if (r0 != r1) goto L82
            long r2 = r7.J$0
            java.lang.Object r0 = r7.L$0
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lb3
        L82:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L8a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r8 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) r8
            java.lang.Object r0 = r7.$firstUp
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            long r2 = r0.uptimeMillis
            androidx.compose.ui.platform.ViewConfiguration r0 = r8.getViewConfiguration()
            r0.getClass()
            r4 = 40
            long r4 = r4 + r2
            r0 = r8
            r2 = r4
        La3:
            r7.L$0 = r0
            r7.J$0 = r2
            r7.label = r1
            r8 = 3
            java.lang.Object r8 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r0, r7, r8)
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r4) goto Lb3
            goto Lbc
        Lb3:
            r4 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            long r5 = r4.uptimeMillis
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 < 0) goto La3
        Lbc:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$awaitSecondDown$2(PointerInputChange pointerInputChange, Continuation continuation) {
        super(2, continuation);
        this.$firstUp = pointerInputChange;
    }
}
