package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.RealImageLoader$execute$3;
import coil.network.HttpException;
import com.github.kr328.clash.FilesActivity$Content$1$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TapGestureDetectorKt {
    public static final DraggableKt$NoOpOnDragStarted$1 NoPressGesture = new DraggableKt$NoOpOnDragStarted$1(3, null, 2);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends ContinuationImpl {
        public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
        public PointerEventPass L$1;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
        public PointerEventPass L$1;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.awaitPrimaryFirstDown(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00081 extends ContinuationImpl {
        public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00091 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Function1 L$3;
        public Object L$4;
        public Object L$5;
        public Object L$6;
        public Object L$7;
        public Object L$8;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.processTapGesture(null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00102 extends SuspendLambda implements Function2 {
        public final /* synthetic */ PointerInputChange $down;
        public final /* synthetic */ Function3 $onPress;
        public final /* synthetic */ PressGestureScopeImpl $pressScope;
        public final /* synthetic */ int $r8$classId;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C00102(Function3 function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.$onPress = function3;
            this.$pressScope = pressGestureScopeImpl;
            this.$down = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new C00102(this.$onPress, this.$pressScope, this.$down, continuation, 0);
                default:
                    return new C00102(this.$onPress, this.$pressScope, this.$down, continuation, 1);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return ((C00102) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Offset offset = new Offset(this.$down.position);
                        this.label = 1;
                        Object objInvoke = this.$onPress.invoke(this.$pressScope, offset, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objInvoke == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                default:
                    int i2 = this.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Offset offset2 = new Offset(this.$down.position);
                        this.label = 1;
                        Object objInvoke2 = this.$onPress.invoke(this.$pressScope, offset2, this);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objInvoke2 == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$processTapGesture$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ PressGestureScopeImpl $pressScope;
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass3(this.$pressScope, continuation, 0);
                case 1:
                    return new AnonymousClass3(this.$pressScope, continuation, 1);
                case 2:
                    return new AnonymousClass3(this.$pressScope, continuation, 2);
                case 3:
                    return new AnonymousClass3(this.$pressScope, continuation, 3);
                case 4:
                    return new AnonymousClass3(this.$pressScope, continuation, 4);
                case 5:
                    return new AnonymousClass3(this.$pressScope, continuation, 5);
                case 6:
                    return new AnonymousClass3(this.$pressScope, continuation, 6);
                default:
                    return new AnonymousClass3(this.$pressScope, continuation, 7);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (this.$r8$classId) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    break;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    break;
                case 3:
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    break;
                case 4:
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    break;
                case 5:
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    break;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00111 extends ContinuationImpl {
        public Ref$ObjectRef L$0;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForLongPress(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00122 extends ContinuationImpl {
        public SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine L$0;
        public PointerEventPass L$1;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:18:0x004b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitFirstDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r5, boolean r6, androidx.compose.ui.input.pointer.PointerEventPass r7, kotlin.coroutines.jvm.internal.BaseContinuationImpl r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            boolean r5 = r0.Z$0
            androidx.compose.ui.input.pointer.PointerEventPass r6 = r0.L$1
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L4b
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
        L3a:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r2
            java.lang.Object r8 = r5.awaitPointerEvent(r7, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r1) goto L4b
            return r1
        L4b:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            r1 = 0
            boolean r3 = isChangedToDown(r8, r6, r1)
            if (r3 == 0) goto L3a
            java.lang.Object r5 = r8.changes
            java.lang.Object r5 = r5.get(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, BaseContinuationImpl baseContinuationImpl, int i) {
        return awaitFirstDown(pointerEventHandlerCoroutine, (i & 1) != 0, (i & 2) != 0 ? PointerEventPass.Main : PointerEventPass.Initial, baseContinuationImpl);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0045 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x004f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0043 -> B:18:0x0046). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitPrimaryFirstDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r5, androidx.compose.ui.input.pointer.PointerEventPass r6, kotlin.coroutines.jvm.internal.BaseContinuationImpl r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            androidx.compose.ui.input.pointer.PointerEventPass r5 = r0.L$1
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L46
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
        L37:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r2
            java.lang.Object r7 = r5.awaitPointerEvent(r6, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r7 != r1) goto L46
            return r1
        L46:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            r1 = 0
            boolean r3 = isChangedToDown(r7, r1, r2)
            if (r3 == 0) goto L37
            java.lang.Object r5 = r7.changes
            java.lang.Object r5 = r5.get(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitPrimaryFirstDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x004b A[LOOP:0: B:19:0x0049->B:20:0x004b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x006a A[LOOP:1: B:22:0x005d->B:26:0x006a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003c -> B:18:0x003f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object consumeUntilUp(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.C00081
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.C00081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L3f
        L27:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2f:
            kotlin.ResultKt.throwOnFailure(r8)
        L32:
            r0.L$0 = r7
            r0.label = r2
            java.lang.Object r8 = androidx.compose.ui.Modifier.CC.awaitPointerEvent$default(r7, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r8 != r1) goto L3f
            return r1
        L3f:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.lang.Object r1 = r8.changes
            int r3 = r1.size()
            r4 = 0
            r5 = r4
        L49:
            if (r5 >= r3) goto L57
            java.lang.Object r6 = r1.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            r6.consume()
            int r5 = r5 + 1
            goto L49
        L57:
            java.lang.Object r8 = r8.changes
            int r1 = r8.size()
        L5d:
            if (r4 >= r1) goto L6d
            java.lang.Object r3 = r8.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
            boolean r3 = r3.pressed
            if (r3 == 0) goto L6a
            goto L32
        L6a:
            int r4 = r4 + 1
            goto L5d
        L6d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, Continuation continuation) {
        Object objCoroutineScope = JobKt.coroutineScope(new FilesActivity$Content$1$1(pointerInputScope, null, null, NoPressGesture, function1, null), continuation);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public static final boolean isChangedToDown(PointerEvent pointerEvent, boolean z, boolean z2) {
        if (z2) {
            ?? r7 = pointerEvent.changes;
            int size = r7.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    if ((pointerEvent.buttons & 33) != 0) {
                        break;
                    }
                    return false;
                }
                if (((PointerInputChange) r7.get(i)).type != 2) {
                    break;
                }
                i++;
            }
        }
        ?? r5 = pointerEvent.changes;
        int size2 = r5.size();
        for (int i2 = 0; i2 < size2; i2++) {
            PointerInputChange pointerInputChange = (PointerInputChange) r5.get(i2);
            if (!(z ? PointerId.changedToDown(pointerInputChange) : PointerId.changedToDownIgnoreConsumed(pointerInputChange))) {
                return false;
            }
        }
        return true;
    }

    public static StandaloneCoroutine launchAwaitingReset$default(CoroutineScope coroutineScope, Job job, Function2 function2) {
        return JobKt.launch$default(coroutineScope, null, new NavHostKt$NavHost$28$1(job, function2, (Continuation) null), 1);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:102:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:103:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:107:0x03df  */
    /* JADX WARN: Code duplicated, block: B:26:0x0192  */
    /* JADX WARN: Code duplicated, block: B:27:0x01af  */
    /* JADX WARN: Code duplicated, block: B:29:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:32:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:35:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:38:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:41:0x020f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0236  */
    /* JADX WARN: Code duplicated, block: B:47:0x0244  */
    /* JADX WARN: Code duplicated, block: B:49:0x0248  */
    /* JADX WARN: Code duplicated, block: B:50:0x024d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0251  */
    /* JADX WARN: Code duplicated, block: B:55:0x0259  */
    /* JADX WARN: Code duplicated, block: B:56:0x0266  */
    /* JADX WARN: Code duplicated, block: B:58:0x0277 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0279 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x027b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0287  */
    /* JADX WARN: Code duplicated, block: B:64:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x02bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x02be  */
    /* JADX WARN: Code duplicated, block: B:69:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x02da  */
    /* JADX WARN: Code duplicated, block: B:72:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:74:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:77:0x0319  */
    /* JADX WARN: Code duplicated, block: B:79:0x0323  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:82:0x033f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0357  */
    /* JADX WARN: Code duplicated, block: B:88:0x037e  */
    /* JADX WARN: Code duplicated, block: B:91:0x038c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0390  */
    /* JADX WARN: Code duplicated, block: B:95:0x039c  */
    /* JADX WARN: Code duplicated, block: B:97:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:99:0x03a9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v35, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext$Element] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v6, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r23v2, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v16, types: [androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v31, types: [androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r9v21, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    public static final Object processTapGesture(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, Function1 function1, Function1 function2, Function3 function3, Function1 function4, BaseContinuationImpl baseContinuationImpl) {
        C00091 c00091;
        Function1 function5;
        Function1 function6;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2;
        Function1 function7;
        CoroutineScope coroutineScope2;
        PressGestureScopeImpl pressGestureScopeImpl2;
        Function3 function8;
        PointerInputChange pointerInputChange;
        ?? r1;
        StandaloneCoroutine standaloneCoroutineLaunch$default;
        PressGestureScopeImpl pressGestureScopeImpl3;
        Function3 function9;
        Object objWaitForLongPress;
        Function1 function10;
        Job job;
        Function1 function11;
        Function3 function12;
        Object objWaitForUpOrCancellation;
        Function1 function13;
        Function1 function14;
        boolean z;
        ?? r3;
        ?? r2;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine3;
        PressGestureScopeImpl pressGestureScopeImpl4;
        Job jobLaunchAwaitingReset$default;
        Function1 function15;
        Function3 function16;
        Object objWithTimeoutOrNull;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine4;
        Function3 function17;
        Function1 function18;
        LongPressResult longPressResult;
        ?? r4;
        CoroutineScope coroutineScope3;
        PressGestureScopeImpl pressGestureScopeImpl5;
        ?? r5;
        ?? r6;
        ?? r7;
        PointerInputChange pointerInputChange2;
        StandaloneCoroutine standaloneCoroutineLaunch$default2;
        ?? r8;
        PressGestureScopeImpl pressGestureScopeImpl6;
        Object objWaitForLongPress2;
        Job job2;
        PointerInputChange pointerInputChange3;
        ?? r9;
        Function1 function19;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine5;
        CoroutineScope coroutineScope4;
        ?? r0;
        Function1 function20;
        CoroutineScope coroutineScope5;
        ?? r10;
        ?? r11;
        ?? r12;
        ?? r13;
        ?? r14;
        LongPressResult longPressResult2;
        ?? r15;
        Job job3;
        CoroutineScope coroutineScope6;
        ?? r16;
        if (baseContinuationImpl instanceof C00091) {
            c00091 = (C00091) baseContinuationImpl;
            int i = c00091.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00091.label = i - Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(baseContinuationImpl);
            }
        } else {
            c00091 = new C00091(baseContinuationImpl);
        }
        Object objWaitForUpOrCancellation2 = c00091.result;
        int i2 = c00091.label;
        PointerEventPass pointerEventPass = PointerEventPass.Main;
        LongPressResult.Success success = LongPressResult.Success.INSTANCE;
        DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = NoPressGesture;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i2) {
            case 0:
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                c00091.L$0 = pointerEventHandlerCoroutine;
                c00091.L$1 = coroutineScope;
                c00091.L$2 = pressGestureScopeImpl;
                function5 = function1;
                c00091.L$3 = function5;
                function6 = function2;
                c00091.L$4 = function6;
                c00091.L$5 = function3;
                c00091.L$6 = function4;
                c00091.label = 1;
                Object objAwaitFirstDown$default = awaitFirstDown$default(pointerEventHandlerCoroutine, c00091, 3);
                if (objAwaitFirstDown$default != coroutineSingletons) {
                    pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine;
                    function7 = function4;
                    coroutineScope2 = coroutineScope;
                    objWaitForUpOrCancellation2 = objAwaitFirstDown$default;
                    pressGestureScopeImpl2 = pressGestureScopeImpl;
                    function8 = function3;
                    PointerInputChange pointerInputChange4 = (PointerInputChange) objWaitForUpOrCancellation2;
                    pointerInputChange4.consume();
                    pointerInputChange = pointerInputChange4;
                    r1 = 0;
                    z = false;
                    standaloneCoroutineLaunch$default = JobKt.launch$default(coroutineScope2, null, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, r1, 0), 1);
                    if (function8 != draggableKt$NoOpOnDragStarted$1) {
                        Function3 function21 = function8;
                        PressGestureScopeImpl pressGestureScopeImpl7 = pressGestureScopeImpl2;
                        function9 = function21;
                        pressGestureScopeImpl3 = pressGestureScopeImpl7;
                        launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default, new C00102(function21, pressGestureScopeImpl7, pointerInputChange, r1, 0));
                    } else {
                        pressGestureScopeImpl3 = pressGestureScopeImpl2;
                        function9 = function8;
                    }
                    if (function6 == null) {
                        c00091.L$0 = pointerEventHandlerCoroutine2;
                        c00091.L$1 = coroutineScope2;
                        c00091.L$2 = pressGestureScopeImpl3;
                        c00091.L$3 = function5;
                        c00091.L$4 = function6;
                        c00091.L$5 = function9;
                        c00091.L$6 = function7;
                        c00091.L$7 = standaloneCoroutineLaunch$default;
                        c00091.label = 2;
                        objWaitForUpOrCancellation = waitForUpOrCancellation(pointerEventHandlerCoroutine2, pointerEventPass, c00091);
                        if (objWaitForUpOrCancellation != coroutineSingletons) {
                            function10 = function7;
                            job = standaloneCoroutineLaunch$default;
                            Function1 function22 = function6;
                            function13 = function5;
                            function14 = function22;
                            r2 = z;
                            r3 = (PointerInputChange) objWaitForUpOrCancellation;
                            pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine2;
                            pressGestureScopeImpl4 = pressGestureScopeImpl3;
                            if (r3 == 0) {
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 3));
                            } else {
                                r3.consume();
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 4));
                            }
                            if (r3 != 0) {
                                if (function13 == null) {
                                    c00091.L$0 = pointerEventHandlerCoroutine3;
                                    c00091.L$1 = coroutineScope2;
                                    c00091.L$2 = pressGestureScopeImpl4;
                                    c00091.L$3 = function13;
                                    c00091.L$4 = function14;
                                    c00091.L$5 = function9;
                                    c00091.L$6 = function10;
                                    c00091.L$7 = r3;
                                    c00091.L$8 = jobLaunchAwaitingReset$default;
                                    c00091.label = 5;
                                    function15 = function13;
                                    function16 = function9;
                                    objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(r3, r2), c00091);
                                    if (objWithTimeoutOrNull != coroutineSingletons) {
                                        pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                        function17 = function16;
                                        function18 = function15;
                                        r7 = r2;
                                        r6 = r3;
                                        pointerInputChange2 = (PointerInputChange) objWithTimeoutOrNull;
                                        if (pointerInputChange2 != null) {
                                            standaloneCoroutineLaunch$default2 = JobKt.launch$default(coroutineScope2, r7, new RealImageLoader$execute$3(jobLaunchAwaitingReset$default, pressGestureScopeImpl4, r7, 9), 1);
                                            if (function17 != draggableKt$NoOpOnDragStarted$1) {
                                                ?? r23 = r7;
                                                PressGestureScopeImpl pressGestureScopeImpl8 = pressGestureScopeImpl4;
                                                C00102 c00102 = new C00102(function17, pressGestureScopeImpl8, pointerInputChange2, r23, 1);
                                                pressGestureScopeImpl6 = pressGestureScopeImpl8;
                                                r8 = r23;
                                                launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default2, c00102);
                                            } else {
                                                r8 = r7;
                                                pressGestureScopeImpl6 = pressGestureScopeImpl4;
                                            }
                                            if (function14 == null) {
                                                c00091.L$0 = coroutineScope2;
                                                c00091.L$1 = pressGestureScopeImpl6;
                                                c00091.L$2 = function18;
                                                c00091.L$3 = function10;
                                                c00091.L$4 = standaloneCoroutineLaunch$default2;
                                                c00091.L$5 = r6;
                                                c00091.L$6 = r8;
                                                c00091.L$7 = r8;
                                                c00091.L$8 = r8;
                                                c00091.label = 6;
                                                objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                                if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                                    ?? r17 = r6;
                                                    job2 = standaloneCoroutineLaunch$default2;
                                                    r0 = r17;
                                                    function20 = function18;
                                                    coroutineScope5 = coroutineScope2;
                                                    r10 = r8;
                                                    r13 = r0;
                                                    r12 = r10;
                                                    r11 = (PointerInputChange) objWaitForUpOrCancellation2;
                                                    if (r11 != 0) {
                                                        r11.consume();
                                                        launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                        function20.invoke(new Offset(r11.position));
                                                    } else {
                                                        launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                        if (function10 != null) {
                                                            function10.invoke(new Offset(r13.position));
                                                        }
                                                    }
                                                }
                                            } else {
                                                c00091.L$0 = pointerEventHandlerCoroutine4;
                                                c00091.L$1 = coroutineScope2;
                                                c00091.L$2 = pressGestureScopeImpl6;
                                                c00091.L$3 = function18;
                                                c00091.L$4 = function14;
                                                c00091.L$5 = function10;
                                                c00091.L$6 = standaloneCoroutineLaunch$default2;
                                                c00091.L$7 = r6;
                                                c00091.L$8 = r22;
                                                c00091.label = 7;
                                                objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                                if (objWaitForLongPress2 != coroutineSingletons) {
                                                    Function1 function23 = function10;
                                                    job2 = standaloneCoroutineLaunch$default2;
                                                    pointerInputChange3 = pointerInputChange2;
                                                    objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                                    r9 = r6;
                                                    pressGestureScopeImpl6 = pressGestureScopeImpl6;
                                                    function19 = function23;
                                                    CoroutineScope coroutineScope7 = coroutineScope2;
                                                    pointerEventHandlerCoroutine5 = pointerEventHandlerCoroutine4;
                                                    coroutineScope4 = coroutineScope7;
                                                    r14 = r8;
                                                    longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                                    if (Intrinsics.areEqual(longPressResult2, success)) {
                                                        function14.invoke(new Offset(pointerInputChange3.position));
                                                        c00091.L$0 = coroutineScope4;
                                                        c00091.L$1 = pressGestureScopeImpl6;
                                                        c00091.L$2 = job2;
                                                        c00091.L$3 = r14;
                                                        c00091.L$4 = r14;
                                                        c00091.L$5 = r14;
                                                        c00091.L$6 = r14;
                                                        c00091.L$7 = r14;
                                                        c00091.L$8 = r14;
                                                        c00091.label = 8;
                                                        if (consumeUntilUp(pointerEventHandlerCoroutine5, c00091) != coroutineSingletons) {
                                                            job3 = job2;
                                                            coroutineScope6 = coroutineScope4;
                                                            r16 = r14;
                                                            launchAwaitingReset$default(coroutineScope6, job3, new AnonymousClass3(pressGestureScopeImpl6, r16, 7));
                                                            return Unit.INSTANCE;
                                                        }
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Released) {
                                                            function10 = function19;
                                                            r15 = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                throw new HttpException();
                                                            }
                                                            function10 = function19;
                                                            r15 = r14;
                                                        }
                                                        function20 = function18;
                                                        coroutineScope5 = coroutineScope4;
                                                        r13 = r9;
                                                        r12 = r14;
                                                        r11 = r15;
                                                        if (r11 != 0) {
                                                            r11.consume();
                                                            launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                            function20.invoke(new Offset(r11.position));
                                                        } else {
                                                            launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                            if (function10 != null) {
                                                                function10.invoke(new Offset(r13.position));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (function10 != null) {
                                            function10.invoke(new Offset(r6.position));
                                        }
                                    }
                                } else if (function10 != null) {
                                    function10.invoke(new Offset(r3.position));
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    } else {
                        c00091.L$0 = pointerEventHandlerCoroutine2;
                        c00091.L$1 = coroutineScope2;
                        c00091.L$2 = pressGestureScopeImpl3;
                        c00091.L$3 = function5;
                        c00091.L$4 = function6;
                        c00091.L$5 = function9;
                        c00091.L$6 = function7;
                        c00091.L$7 = pointerInputChange;
                        c00091.L$8 = standaloneCoroutineLaunch$default;
                        c00091.label = 3;
                        objWaitForLongPress = waitForLongPress(pointerEventHandlerCoroutine2, pointerEventPass, c00091);
                        if (objWaitForLongPress != coroutineSingletons) {
                            function10 = function7;
                            job = standaloneCoroutineLaunch$default;
                            Function3 function24 = function9;
                            function11 = function5;
                            function12 = function24;
                            longPressResult = (LongPressResult) objWaitForLongPress;
                            if (!Intrinsics.areEqual(longPressResult, success)) {
                                if (longPressResult instanceof LongPressResult.Released) {
                                    r4 = ((LongPressResult.Released) longPressResult).finalUpChange;
                                } else {
                                    if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                        throw new HttpException();
                                    }
                                    r4 = r1;
                                }
                                Function1 function25 = function11;
                                function9 = function12;
                                function14 = function6;
                                function13 = function25;
                                r2 = r1;
                                r3 = r4;
                                pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine2;
                                pressGestureScopeImpl4 = pressGestureScopeImpl3;
                                if (r3 == 0) {
                                    jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 3));
                                } else {
                                    r3.consume();
                                    jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 4));
                                }
                                if (r3 != 0) {
                                    if (function13 == null) {
                                        c00091.L$0 = pointerEventHandlerCoroutine3;
                                        c00091.L$1 = coroutineScope2;
                                        c00091.L$2 = pressGestureScopeImpl4;
                                        c00091.L$3 = function13;
                                        c00091.L$4 = function14;
                                        c00091.L$5 = function9;
                                        c00091.L$6 = function10;
                                        c00091.L$7 = r3;
                                        c00091.L$8 = jobLaunchAwaitingReset$default;
                                        c00091.label = 5;
                                        function15 = function13;
                                        function16 = function9;
                                        objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(r3, r2), c00091);
                                        if (objWithTimeoutOrNull != coroutineSingletons) {
                                            pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                            function17 = function16;
                                            function18 = function15;
                                            r7 = r2;
                                            r6 = r3;
                                            pointerInputChange2 = (PointerInputChange) objWithTimeoutOrNull;
                                            if (pointerInputChange2 != null) {
                                                standaloneCoroutineLaunch$default2 = JobKt.launch$default(coroutineScope2, r7, new RealImageLoader$execute$3(jobLaunchAwaitingReset$default, pressGestureScopeImpl4, r7, 9), 1);
                                                if (function17 != draggableKt$NoOpOnDragStarted$1) {
                                                    ?? r24 = r7;
                                                    PressGestureScopeImpl pressGestureScopeImpl9 = pressGestureScopeImpl4;
                                                    C00102 c00103 = new C00102(function17, pressGestureScopeImpl9, pointerInputChange2, r24, 1);
                                                    pressGestureScopeImpl6 = pressGestureScopeImpl9;
                                                    r8 = r24;
                                                    launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default2, c00103);
                                                } else {
                                                    r8 = r7;
                                                    pressGestureScopeImpl6 = pressGestureScopeImpl4;
                                                }
                                                if (function14 == null) {
                                                    c00091.L$0 = coroutineScope2;
                                                    c00091.L$1 = pressGestureScopeImpl6;
                                                    c00091.L$2 = function18;
                                                    c00091.L$3 = function10;
                                                    c00091.L$4 = standaloneCoroutineLaunch$default2;
                                                    c00091.L$5 = r6;
                                                    c00091.L$6 = r8;
                                                    c00091.L$7 = r8;
                                                    c00091.L$8 = r8;
                                                    c00091.label = 6;
                                                    objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                                    if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                                        ?? r18 = r6;
                                                        job2 = standaloneCoroutineLaunch$default2;
                                                        r0 = r18;
                                                        function20 = function18;
                                                        coroutineScope5 = coroutineScope2;
                                                        r10 = r8;
                                                        r13 = r0;
                                                        r12 = r10;
                                                        r11 = (PointerInputChange) objWaitForUpOrCancellation2;
                                                        if (r11 != 0) {
                                                            r11.consume();
                                                            launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                            function20.invoke(new Offset(r11.position));
                                                        } else {
                                                            launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                            if (function10 != null) {
                                                                function10.invoke(new Offset(r13.position));
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    c00091.L$0 = pointerEventHandlerCoroutine4;
                                                    c00091.L$1 = coroutineScope2;
                                                    c00091.L$2 = pressGestureScopeImpl6;
                                                    c00091.L$3 = function18;
                                                    c00091.L$4 = function14;
                                                    c00091.L$5 = function10;
                                                    c00091.L$6 = standaloneCoroutineLaunch$default2;
                                                    c00091.L$7 = r6;
                                                    c00091.L$8 = r22;
                                                    c00091.label = 7;
                                                    objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                                    if (objWaitForLongPress2 != coroutineSingletons) {
                                                        Function1 function26 = function10;
                                                        job2 = standaloneCoroutineLaunch$default2;
                                                        pointerInputChange3 = pointerInputChange2;
                                                        objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                                        r9 = r6;
                                                        pressGestureScopeImpl6 = pressGestureScopeImpl6;
                                                        function19 = function26;
                                                        CoroutineScope coroutineScope8 = coroutineScope2;
                                                        pointerEventHandlerCoroutine5 = pointerEventHandlerCoroutine4;
                                                        coroutineScope4 = coroutineScope8;
                                                        r14 = r8;
                                                        longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                                        if (Intrinsics.areEqual(longPressResult2, success)) {
                                                            function14.invoke(new Offset(pointerInputChange3.position));
                                                            c00091.L$0 = coroutineScope4;
                                                            c00091.L$1 = pressGestureScopeImpl6;
                                                            c00091.L$2 = job2;
                                                            c00091.L$3 = r14;
                                                            c00091.L$4 = r14;
                                                            c00091.L$5 = r14;
                                                            c00091.L$6 = r14;
                                                            c00091.L$7 = r14;
                                                            c00091.L$8 = r14;
                                                            c00091.label = 8;
                                                            if (consumeUntilUp(pointerEventHandlerCoroutine5, c00091) != coroutineSingletons) {
                                                                job3 = job2;
                                                                coroutineScope6 = coroutineScope4;
                                                                r16 = r14;
                                                                launchAwaitingReset$default(coroutineScope6, job3, new AnonymousClass3(pressGestureScopeImpl6, r16, 7));
                                                                return Unit.INSTANCE;
                                                            }
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Released) {
                                                                function10 = function19;
                                                                r15 = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                            } else {
                                                                if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                    throw new HttpException();
                                                                }
                                                                function10 = function19;
                                                                r15 = r14;
                                                            }
                                                            function20 = function18;
                                                            coroutineScope5 = coroutineScope4;
                                                            r13 = r9;
                                                            r12 = r14;
                                                            r11 = r15;
                                                            if (r11 != 0) {
                                                                r11.consume();
                                                                launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                                function20.invoke(new Offset(r11.position));
                                                            } else {
                                                                launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                                if (function10 != null) {
                                                                    function10.invoke(new Offset(r13.position));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (function10 != null) {
                                                function10.invoke(new Offset(r6.position));
                                            }
                                        }
                                    } else if (function10 != null) {
                                        function10.invoke(new Offset(r3.position));
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                            function6.invoke(new Offset(pointerInputChange.position));
                            c00091.L$0 = coroutineScope2;
                            c00091.L$1 = pressGestureScopeImpl3;
                            c00091.L$2 = job;
                            c00091.L$3 = r1;
                            c00091.L$4 = r1;
                            c00091.L$5 = r1;
                            c00091.L$6 = r1;
                            c00091.L$7 = r1;
                            c00091.L$8 = r1;
                            c00091.label = 4;
                            if (consumeUntilUp(pointerEventHandlerCoroutine2, c00091) != coroutineSingletons) {
                                coroutineScope3 = coroutineScope2;
                                pressGestureScopeImpl5 = pressGestureScopeImpl3;
                                r5 = r1;
                                launchAwaitingReset$default(coroutineScope3, job, new AnonymousClass3(pressGestureScopeImpl5, r5, 0));
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }
                return coroutineSingletons;
            case 1:
                function7 = (Function1) c00091.L$6;
                function8 = (Function3) c00091.L$5;
                Function1 function27 = (Function1) c00091.L$4;
                Function1 function28 = c00091.L$3;
                pressGestureScopeImpl2 = (PressGestureScopeImpl) c00091.L$2;
                coroutineScope2 = (CoroutineScope) c00091.L$1;
                pointerEventHandlerCoroutine2 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00091.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                function6 = function27;
                function5 = function28;
                PointerInputChange pointerInputChange5 = (PointerInputChange) objWaitForUpOrCancellation2;
                pointerInputChange5.consume();
                pointerInputChange = pointerInputChange5;
                r1 = 0;
                z = false;
                standaloneCoroutineLaunch$default = JobKt.launch$default(coroutineScope2, null, new TapGestureDetectorKt$processTapGesture$resetJob$1(pressGestureScopeImpl2, r1, 0), 1);
                if (function8 != draggableKt$NoOpOnDragStarted$1) {
                    Function3 function29 = function8;
                    PressGestureScopeImpl pressGestureScopeImpl10 = pressGestureScopeImpl2;
                    function9 = function29;
                    pressGestureScopeImpl3 = pressGestureScopeImpl10;
                    launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default, new C00102(function29, pressGestureScopeImpl10, pointerInputChange, r1, 0));
                } else {
                    pressGestureScopeImpl3 = pressGestureScopeImpl2;
                    function9 = function8;
                }
                if (function6 == null) {
                    c00091.L$0 = pointerEventHandlerCoroutine2;
                    c00091.L$1 = coroutineScope2;
                    c00091.L$2 = pressGestureScopeImpl3;
                    c00091.L$3 = function5;
                    c00091.L$4 = function6;
                    c00091.L$5 = function9;
                    c00091.L$6 = function7;
                    c00091.L$7 = standaloneCoroutineLaunch$default;
                    c00091.label = 2;
                    objWaitForUpOrCancellation = waitForUpOrCancellation(pointerEventHandlerCoroutine2, pointerEventPass, c00091);
                    if (objWaitForUpOrCancellation != coroutineSingletons) {
                        function10 = function7;
                        job = standaloneCoroutineLaunch$default;
                        Function1 function210 = function6;
                        function13 = function5;
                        function14 = function210;
                        r2 = z;
                        r3 = (PointerInputChange) objWaitForUpOrCancellation;
                        pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine2;
                        pressGestureScopeImpl4 = pressGestureScopeImpl3;
                        if (r3 == 0) {
                            jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 3));
                        } else {
                            r3.consume();
                            jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 4));
                        }
                        if (r3 != 0) {
                            if (function13 == null) {
                                c00091.L$0 = pointerEventHandlerCoroutine3;
                                c00091.L$1 = coroutineScope2;
                                c00091.L$2 = pressGestureScopeImpl4;
                                c00091.L$3 = function13;
                                c00091.L$4 = function14;
                                c00091.L$5 = function9;
                                c00091.L$6 = function10;
                                c00091.L$7 = r3;
                                c00091.L$8 = jobLaunchAwaitingReset$default;
                                c00091.label = 5;
                                function15 = function13;
                                function16 = function9;
                                objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(r3, r2), c00091);
                                if (objWithTimeoutOrNull != coroutineSingletons) {
                                    pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                    function17 = function16;
                                    function18 = function15;
                                    r7 = r2;
                                    r6 = r3;
                                    pointerInputChange2 = (PointerInputChange) objWithTimeoutOrNull;
                                    if (pointerInputChange2 != null) {
                                        standaloneCoroutineLaunch$default2 = JobKt.launch$default(coroutineScope2, r7, new RealImageLoader$execute$3(jobLaunchAwaitingReset$default, pressGestureScopeImpl4, r7, 9), 1);
                                        if (function17 != draggableKt$NoOpOnDragStarted$1) {
                                            ?? r25 = r7;
                                            PressGestureScopeImpl pressGestureScopeImpl11 = pressGestureScopeImpl4;
                                            C00102 c00104 = new C00102(function17, pressGestureScopeImpl11, pointerInputChange2, r25, 1);
                                            pressGestureScopeImpl6 = pressGestureScopeImpl11;
                                            r8 = r25;
                                            launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default2, c00104);
                                        } else {
                                            r8 = r7;
                                            pressGestureScopeImpl6 = pressGestureScopeImpl4;
                                        }
                                        if (function14 == null) {
                                            c00091.L$0 = coroutineScope2;
                                            c00091.L$1 = pressGestureScopeImpl6;
                                            c00091.L$2 = function18;
                                            c00091.L$3 = function10;
                                            c00091.L$4 = standaloneCoroutineLaunch$default2;
                                            c00091.L$5 = r6;
                                            c00091.L$6 = r8;
                                            c00091.L$7 = r8;
                                            c00091.L$8 = r8;
                                            c00091.label = 6;
                                            objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                            if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                                ?? r19 = r6;
                                                job2 = standaloneCoroutineLaunch$default2;
                                                r0 = r19;
                                                function20 = function18;
                                                coroutineScope5 = coroutineScope2;
                                                r10 = r8;
                                                r13 = r0;
                                                r12 = r10;
                                                r11 = (PointerInputChange) objWaitForUpOrCancellation2;
                                                if (r11 != 0) {
                                                    r11.consume();
                                                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                    function20.invoke(new Offset(r11.position));
                                                } else {
                                                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                    if (function10 != null) {
                                                        function10.invoke(new Offset(r13.position));
                                                    }
                                                }
                                            }
                                        } else {
                                            c00091.L$0 = pointerEventHandlerCoroutine4;
                                            c00091.L$1 = coroutineScope2;
                                            c00091.L$2 = pressGestureScopeImpl6;
                                            c00091.L$3 = function18;
                                            c00091.L$4 = function14;
                                            c00091.L$5 = function10;
                                            c00091.L$6 = standaloneCoroutineLaunch$default2;
                                            c00091.L$7 = r6;
                                            c00091.L$8 = r22;
                                            c00091.label = 7;
                                            objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                            if (objWaitForLongPress2 != coroutineSingletons) {
                                                Function1 function211 = function10;
                                                job2 = standaloneCoroutineLaunch$default2;
                                                pointerInputChange3 = pointerInputChange2;
                                                objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                                r9 = r6;
                                                pressGestureScopeImpl6 = pressGestureScopeImpl6;
                                                function19 = function211;
                                                CoroutineScope coroutineScope9 = coroutineScope2;
                                                pointerEventHandlerCoroutine5 = pointerEventHandlerCoroutine4;
                                                coroutineScope4 = coroutineScope9;
                                                r14 = r8;
                                                longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                                if (Intrinsics.areEqual(longPressResult2, success)) {
                                                    function14.invoke(new Offset(pointerInputChange3.position));
                                                    c00091.L$0 = coroutineScope4;
                                                    c00091.L$1 = pressGestureScopeImpl6;
                                                    c00091.L$2 = job2;
                                                    c00091.L$3 = r14;
                                                    c00091.L$4 = r14;
                                                    c00091.L$5 = r14;
                                                    c00091.L$6 = r14;
                                                    c00091.L$7 = r14;
                                                    c00091.L$8 = r14;
                                                    c00091.label = 8;
                                                    if (consumeUntilUp(pointerEventHandlerCoroutine5, c00091) != coroutineSingletons) {
                                                        job3 = job2;
                                                        coroutineScope6 = coroutineScope4;
                                                        r16 = r14;
                                                        launchAwaitingReset$default(coroutineScope6, job3, new AnonymousClass3(pressGestureScopeImpl6, r16, 7));
                                                        return Unit.INSTANCE;
                                                    }
                                                } else {
                                                    if (longPressResult2 instanceof LongPressResult.Released) {
                                                        function10 = function19;
                                                        r15 = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                            throw new HttpException();
                                                        }
                                                        function10 = function19;
                                                        r15 = r14;
                                                    }
                                                    function20 = function18;
                                                    coroutineScope5 = coroutineScope4;
                                                    r13 = r9;
                                                    r12 = r14;
                                                    r11 = r15;
                                                    if (r11 != 0) {
                                                        r11.consume();
                                                        launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                        function20.invoke(new Offset(r11.position));
                                                    } else {
                                                        launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                        if (function10 != null) {
                                                            function10.invoke(new Offset(r13.position));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (function10 != null) {
                                        function10.invoke(new Offset(r6.position));
                                    }
                                }
                            } else if (function10 != null) {
                                function10.invoke(new Offset(r3.position));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    c00091.L$0 = pointerEventHandlerCoroutine2;
                    c00091.L$1 = coroutineScope2;
                    c00091.L$2 = pressGestureScopeImpl3;
                    c00091.L$3 = function5;
                    c00091.L$4 = function6;
                    c00091.L$5 = function9;
                    c00091.L$6 = function7;
                    c00091.L$7 = pointerInputChange;
                    c00091.L$8 = standaloneCoroutineLaunch$default;
                    c00091.label = 3;
                    objWaitForLongPress = waitForLongPress(pointerEventHandlerCoroutine2, pointerEventPass, c00091);
                    if (objWaitForLongPress != coroutineSingletons) {
                        function10 = function7;
                        job = standaloneCoroutineLaunch$default;
                        Function3 function212 = function9;
                        function11 = function5;
                        function12 = function212;
                        longPressResult = (LongPressResult) objWaitForLongPress;
                        if (!Intrinsics.areEqual(longPressResult, success)) {
                            if (longPressResult instanceof LongPressResult.Released) {
                                r4 = ((LongPressResult.Released) longPressResult).finalUpChange;
                            } else {
                                if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                    throw new HttpException();
                                }
                                r4 = r1;
                            }
                            Function1 function213 = function11;
                            function9 = function12;
                            function14 = function6;
                            function13 = function213;
                            r2 = r1;
                            r3 = r4;
                            pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine2;
                            pressGestureScopeImpl4 = pressGestureScopeImpl3;
                            if (r3 == 0) {
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 3));
                            } else {
                                r3.consume();
                                jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 4));
                            }
                            if (r3 != 0) {
                                if (function13 == null) {
                                    c00091.L$0 = pointerEventHandlerCoroutine3;
                                    c00091.L$1 = coroutineScope2;
                                    c00091.L$2 = pressGestureScopeImpl4;
                                    c00091.L$3 = function13;
                                    c00091.L$4 = function14;
                                    c00091.L$5 = function9;
                                    c00091.L$6 = function10;
                                    c00091.L$7 = r3;
                                    c00091.L$8 = jobLaunchAwaitingReset$default;
                                    c00091.label = 5;
                                    function15 = function13;
                                    function16 = function9;
                                    objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(r3, r2), c00091);
                                    if (objWithTimeoutOrNull != coroutineSingletons) {
                                        pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                        function17 = function16;
                                        function18 = function15;
                                        r7 = r2;
                                        r6 = r3;
                                        pointerInputChange2 = (PointerInputChange) objWithTimeoutOrNull;
                                        if (pointerInputChange2 != null) {
                                            standaloneCoroutineLaunch$default2 = JobKt.launch$default(coroutineScope2, r7, new RealImageLoader$execute$3(jobLaunchAwaitingReset$default, pressGestureScopeImpl4, r7, 9), 1);
                                            if (function17 != draggableKt$NoOpOnDragStarted$1) {
                                                ?? r26 = r7;
                                                PressGestureScopeImpl pressGestureScopeImpl12 = pressGestureScopeImpl4;
                                                C00102 c00105 = new C00102(function17, pressGestureScopeImpl12, pointerInputChange2, r26, 1);
                                                pressGestureScopeImpl6 = pressGestureScopeImpl12;
                                                r8 = r26;
                                                launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default2, c00105);
                                            } else {
                                                r8 = r7;
                                                pressGestureScopeImpl6 = pressGestureScopeImpl4;
                                            }
                                            if (function14 == null) {
                                                c00091.L$0 = coroutineScope2;
                                                c00091.L$1 = pressGestureScopeImpl6;
                                                c00091.L$2 = function18;
                                                c00091.L$3 = function10;
                                                c00091.L$4 = standaloneCoroutineLaunch$default2;
                                                c00091.L$5 = r6;
                                                c00091.L$6 = r8;
                                                c00091.L$7 = r8;
                                                c00091.L$8 = r8;
                                                c00091.label = 6;
                                                objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                                if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                                    ?? r110 = r6;
                                                    job2 = standaloneCoroutineLaunch$default2;
                                                    r0 = r110;
                                                    function20 = function18;
                                                    coroutineScope5 = coroutineScope2;
                                                    r10 = r8;
                                                    r13 = r0;
                                                    r12 = r10;
                                                    r11 = (PointerInputChange) objWaitForUpOrCancellation2;
                                                    if (r11 != 0) {
                                                        r11.consume();
                                                        launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                        function20.invoke(new Offset(r11.position));
                                                    } else {
                                                        launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                        if (function10 != null) {
                                                            function10.invoke(new Offset(r13.position));
                                                        }
                                                    }
                                                }
                                            } else {
                                                c00091.L$0 = pointerEventHandlerCoroutine4;
                                                c00091.L$1 = coroutineScope2;
                                                c00091.L$2 = pressGestureScopeImpl6;
                                                c00091.L$3 = function18;
                                                c00091.L$4 = function14;
                                                c00091.L$5 = function10;
                                                c00091.L$6 = standaloneCoroutineLaunch$default2;
                                                c00091.L$7 = r6;
                                                c00091.L$8 = r22;
                                                c00091.label = 7;
                                                objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                                if (objWaitForLongPress2 != coroutineSingletons) {
                                                    Function1 function214 = function10;
                                                    job2 = standaloneCoroutineLaunch$default2;
                                                    pointerInputChange3 = pointerInputChange2;
                                                    objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                                    r9 = r6;
                                                    pressGestureScopeImpl6 = pressGestureScopeImpl6;
                                                    function19 = function214;
                                                    CoroutineScope coroutineScope10 = coroutineScope2;
                                                    pointerEventHandlerCoroutine5 = pointerEventHandlerCoroutine4;
                                                    coroutineScope4 = coroutineScope10;
                                                    r14 = r8;
                                                    longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                                    if (Intrinsics.areEqual(longPressResult2, success)) {
                                                        function14.invoke(new Offset(pointerInputChange3.position));
                                                        c00091.L$0 = coroutineScope4;
                                                        c00091.L$1 = pressGestureScopeImpl6;
                                                        c00091.L$2 = job2;
                                                        c00091.L$3 = r14;
                                                        c00091.L$4 = r14;
                                                        c00091.L$5 = r14;
                                                        c00091.L$6 = r14;
                                                        c00091.L$7 = r14;
                                                        c00091.L$8 = r14;
                                                        c00091.label = 8;
                                                        if (consumeUntilUp(pointerEventHandlerCoroutine5, c00091) != coroutineSingletons) {
                                                            job3 = job2;
                                                            coroutineScope6 = coroutineScope4;
                                                            r16 = r14;
                                                            launchAwaitingReset$default(coroutineScope6, job3, new AnonymousClass3(pressGestureScopeImpl6, r16, 7));
                                                            return Unit.INSTANCE;
                                                        }
                                                    } else {
                                                        if (longPressResult2 instanceof LongPressResult.Released) {
                                                            function10 = function19;
                                                            r15 = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                        } else {
                                                            if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                                throw new HttpException();
                                                            }
                                                            function10 = function19;
                                                            r15 = r14;
                                                        }
                                                        function20 = function18;
                                                        coroutineScope5 = coroutineScope4;
                                                        r13 = r9;
                                                        r12 = r14;
                                                        r11 = r15;
                                                        if (r11 != 0) {
                                                            r11.consume();
                                                            launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                            function20.invoke(new Offset(r11.position));
                                                        } else {
                                                            launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                            if (function10 != null) {
                                                                function10.invoke(new Offset(r13.position));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (function10 != null) {
                                            function10.invoke(new Offset(r6.position));
                                        }
                                    }
                                } else if (function10 != null) {
                                    function10.invoke(new Offset(r3.position));
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        function6.invoke(new Offset(pointerInputChange.position));
                        c00091.L$0 = coroutineScope2;
                        c00091.L$1 = pressGestureScopeImpl3;
                        c00091.L$2 = job;
                        c00091.L$3 = r1;
                        c00091.L$4 = r1;
                        c00091.L$5 = r1;
                        c00091.L$6 = r1;
                        c00091.L$7 = r1;
                        c00091.L$8 = r1;
                        c00091.label = 4;
                        if (consumeUntilUp(pointerEventHandlerCoroutine2, c00091) != coroutineSingletons) {
                            coroutineScope3 = coroutineScope2;
                            pressGestureScopeImpl5 = pressGestureScopeImpl3;
                            r5 = r1;
                            launchAwaitingReset$default(coroutineScope3, job, new AnonymousClass3(pressGestureScopeImpl5, r5, 0));
                            return Unit.INSTANCE;
                        }
                    }
                }
                return coroutineSingletons;
            case 2:
                job = (Job) c00091.L$7;
                Function1 function30 = (Function1) c00091.L$6;
                Function3 function31 = (Function3) c00091.L$5;
                function14 = (Function1) c00091.L$4;
                function13 = c00091.L$3;
                PressGestureScopeImpl pressGestureScopeImpl13 = (PressGestureScopeImpl) c00091.L$2;
                coroutineScope2 = (CoroutineScope) c00091.L$1;
                pointerEventHandlerCoroutine2 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00091.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                pressGestureScopeImpl3 = pressGestureScopeImpl13;
                function9 = function31;
                function10 = function30;
                objWaitForUpOrCancellation = objWaitForUpOrCancellation2;
                z = false;
                r2 = z;
                r3 = (PointerInputChange) objWaitForUpOrCancellation;
                pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine2;
                pressGestureScopeImpl4 = pressGestureScopeImpl3;
                if (r3 == 0) {
                    jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 3));
                } else {
                    r3.consume();
                    jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 4));
                }
                if (r3 != 0) {
                    if (function13 == null) {
                        c00091.L$0 = pointerEventHandlerCoroutine3;
                        c00091.L$1 = coroutineScope2;
                        c00091.L$2 = pressGestureScopeImpl4;
                        c00091.L$3 = function13;
                        c00091.L$4 = function14;
                        c00091.L$5 = function9;
                        c00091.L$6 = function10;
                        c00091.L$7 = r3;
                        c00091.L$8 = jobLaunchAwaitingReset$default;
                        c00091.label = 5;
                        function15 = function13;
                        function16 = function9;
                        objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(r3, r2), c00091);
                        if (objWithTimeoutOrNull != coroutineSingletons) {
                            pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                            function17 = function16;
                            function18 = function15;
                            r7 = r2;
                            r6 = r3;
                            pointerInputChange2 = (PointerInputChange) objWithTimeoutOrNull;
                            if (pointerInputChange2 != null) {
                                standaloneCoroutineLaunch$default2 = JobKt.launch$default(coroutineScope2, r7, new RealImageLoader$execute$3(jobLaunchAwaitingReset$default, pressGestureScopeImpl4, r7, 9), 1);
                                if (function17 != draggableKt$NoOpOnDragStarted$1) {
                                    ?? r27 = r7;
                                    PressGestureScopeImpl pressGestureScopeImpl14 = pressGestureScopeImpl4;
                                    C00102 c00106 = new C00102(function17, pressGestureScopeImpl14, pointerInputChange2, r27, 1);
                                    pressGestureScopeImpl6 = pressGestureScopeImpl14;
                                    r8 = r27;
                                    launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default2, c00106);
                                } else {
                                    r8 = r7;
                                    pressGestureScopeImpl6 = pressGestureScopeImpl4;
                                }
                                if (function14 == null) {
                                    c00091.L$0 = coroutineScope2;
                                    c00091.L$1 = pressGestureScopeImpl6;
                                    c00091.L$2 = function18;
                                    c00091.L$3 = function10;
                                    c00091.L$4 = standaloneCoroutineLaunch$default2;
                                    c00091.L$5 = r6;
                                    c00091.L$6 = r8;
                                    c00091.L$7 = r8;
                                    c00091.L$8 = r8;
                                    c00091.label = 6;
                                    objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                    if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                        ?? r111 = r6;
                                        job2 = standaloneCoroutineLaunch$default2;
                                        r0 = r111;
                                        function20 = function18;
                                        coroutineScope5 = coroutineScope2;
                                        r10 = r8;
                                        r13 = r0;
                                        r12 = r10;
                                        r11 = (PointerInputChange) objWaitForUpOrCancellation2;
                                        if (r11 != 0) {
                                            r11.consume();
                                            launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                            function20.invoke(new Offset(r11.position));
                                        } else {
                                            launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                            if (function10 != null) {
                                                function10.invoke(new Offset(r13.position));
                                            }
                                        }
                                    }
                                } else {
                                    c00091.L$0 = pointerEventHandlerCoroutine4;
                                    c00091.L$1 = coroutineScope2;
                                    c00091.L$2 = pressGestureScopeImpl6;
                                    c00091.L$3 = function18;
                                    c00091.L$4 = function14;
                                    c00091.L$5 = function10;
                                    c00091.L$6 = standaloneCoroutineLaunch$default2;
                                    c00091.L$7 = r6;
                                    c00091.L$8 = r22;
                                    c00091.label = 7;
                                    objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                    if (objWaitForLongPress2 != coroutineSingletons) {
                                        Function1 function215 = function10;
                                        job2 = standaloneCoroutineLaunch$default2;
                                        pointerInputChange3 = pointerInputChange2;
                                        objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                        r9 = r6;
                                        pressGestureScopeImpl6 = pressGestureScopeImpl6;
                                        function19 = function215;
                                        CoroutineScope coroutineScope11 = coroutineScope2;
                                        pointerEventHandlerCoroutine5 = pointerEventHandlerCoroutine4;
                                        coroutineScope4 = coroutineScope11;
                                        r14 = r8;
                                        longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                        if (Intrinsics.areEqual(longPressResult2, success)) {
                                            function14.invoke(new Offset(pointerInputChange3.position));
                                            c00091.L$0 = coroutineScope4;
                                            c00091.L$1 = pressGestureScopeImpl6;
                                            c00091.L$2 = job2;
                                            c00091.L$3 = r14;
                                            c00091.L$4 = r14;
                                            c00091.L$5 = r14;
                                            c00091.L$6 = r14;
                                            c00091.L$7 = r14;
                                            c00091.L$8 = r14;
                                            c00091.label = 8;
                                            if (consumeUntilUp(pointerEventHandlerCoroutine5, c00091) != coroutineSingletons) {
                                                job3 = job2;
                                                coroutineScope6 = coroutineScope4;
                                                r16 = r14;
                                                launchAwaitingReset$default(coroutineScope6, job3, new AnonymousClass3(pressGestureScopeImpl6, r16, 7));
                                                return Unit.INSTANCE;
                                            }
                                        } else {
                                            if (longPressResult2 instanceof LongPressResult.Released) {
                                                function10 = function19;
                                                r15 = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                            } else {
                                                if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                    throw new HttpException();
                                                }
                                                function10 = function19;
                                                r15 = r14;
                                            }
                                            function20 = function18;
                                            coroutineScope5 = coroutineScope4;
                                            r13 = r9;
                                            r12 = r14;
                                            r11 = r15;
                                            if (r11 != 0) {
                                                r11.consume();
                                                launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                function20.invoke(new Offset(r11.position));
                                            } else {
                                                launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                if (function10 != null) {
                                                    function10.invoke(new Offset(r13.position));
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (function10 != null) {
                                function10.invoke(new Offset(r6.position));
                            }
                        }
                        return coroutineSingletons;
                    }
                    if (function10 != null) {
                        function10.invoke(new Offset(r3.position));
                    }
                }
                return Unit.INSTANCE;
            case 3:
                job = (Job) c00091.L$8;
                pointerInputChange = (PointerInputChange) c00091.L$7;
                function10 = (Function1) c00091.L$6;
                function12 = (Function3) c00091.L$5;
                function6 = (Function1) c00091.L$4;
                function11 = c00091.L$3;
                PressGestureScopeImpl pressGestureScopeImpl15 = (PressGestureScopeImpl) c00091.L$2;
                CoroutineScope coroutineScope12 = (CoroutineScope) c00091.L$1;
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine6 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00091.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                pressGestureScopeImpl3 = pressGestureScopeImpl15;
                coroutineScope2 = coroutineScope12;
                pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine6;
                objWaitForLongPress = objWaitForUpOrCancellation2;
                r1 = 0;
                longPressResult = (LongPressResult) objWaitForLongPress;
                if (!Intrinsics.areEqual(longPressResult, success)) {
                    if (longPressResult instanceof LongPressResult.Released) {
                        r4 = ((LongPressResult.Released) longPressResult).finalUpChange;
                    } else {
                        if (!(longPressResult instanceof LongPressResult.Canceled)) {
                            throw new HttpException();
                        }
                        r4 = r1;
                    }
                    Function1 function216 = function11;
                    function9 = function12;
                    function14 = function6;
                    function13 = function216;
                    r2 = r1;
                    r3 = r4;
                    pointerEventHandlerCoroutine3 = pointerEventHandlerCoroutine2;
                    pressGestureScopeImpl4 = pressGestureScopeImpl3;
                    if (r3 == 0) {
                        jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 3));
                    } else {
                        r3.consume();
                        jobLaunchAwaitingReset$default = launchAwaitingReset$default(coroutineScope2, job, new AnonymousClass3(pressGestureScopeImpl4, r2, 4));
                    }
                    if (r3 != 0) {
                        if (function13 == null) {
                            c00091.L$0 = pointerEventHandlerCoroutine3;
                            c00091.L$1 = coroutineScope2;
                            c00091.L$2 = pressGestureScopeImpl4;
                            c00091.L$3 = function13;
                            c00091.L$4 = function14;
                            c00091.L$5 = function9;
                            c00091.L$6 = function10;
                            c00091.L$7 = r3;
                            c00091.L$8 = jobLaunchAwaitingReset$default;
                            c00091.label = 5;
                            function15 = function13;
                            function16 = function9;
                            objWithTimeoutOrNull = pointerEventHandlerCoroutine3.withTimeoutOrNull(pointerEventHandlerCoroutine3.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(r3, r2), c00091);
                            if (objWithTimeoutOrNull != coroutineSingletons) {
                                pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine3;
                                function17 = function16;
                                function18 = function15;
                                r7 = r2;
                                r6 = r3;
                                pointerInputChange2 = (PointerInputChange) objWithTimeoutOrNull;
                                if (pointerInputChange2 != null) {
                                    standaloneCoroutineLaunch$default2 = JobKt.launch$default(coroutineScope2, r7, new RealImageLoader$execute$3(jobLaunchAwaitingReset$default, pressGestureScopeImpl4, r7, 9), 1);
                                    if (function17 != draggableKt$NoOpOnDragStarted$1) {
                                        ?? r28 = r7;
                                        PressGestureScopeImpl pressGestureScopeImpl16 = pressGestureScopeImpl4;
                                        C00102 c00107 = new C00102(function17, pressGestureScopeImpl16, pointerInputChange2, r28, 1);
                                        pressGestureScopeImpl6 = pressGestureScopeImpl16;
                                        r8 = r28;
                                        launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default2, c00107);
                                    } else {
                                        r8 = r7;
                                        pressGestureScopeImpl6 = pressGestureScopeImpl4;
                                    }
                                    if (function14 == null) {
                                        c00091.L$0 = coroutineScope2;
                                        c00091.L$1 = pressGestureScopeImpl6;
                                        c00091.L$2 = function18;
                                        c00091.L$3 = function10;
                                        c00091.L$4 = standaloneCoroutineLaunch$default2;
                                        c00091.L$5 = r6;
                                        c00091.L$6 = r8;
                                        c00091.L$7 = r8;
                                        c00091.L$8 = r8;
                                        c00091.label = 6;
                                        objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                        if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                                            ?? r112 = r6;
                                            job2 = standaloneCoroutineLaunch$default2;
                                            r0 = r112;
                                            function20 = function18;
                                            coroutineScope5 = coroutineScope2;
                                            r10 = r8;
                                            r13 = r0;
                                            r12 = r10;
                                            r11 = (PointerInputChange) objWaitForUpOrCancellation2;
                                            if (r11 != 0) {
                                                r11.consume();
                                                launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                function20.invoke(new Offset(r11.position));
                                            } else {
                                                launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                if (function10 != null) {
                                                    function10.invoke(new Offset(r13.position));
                                                }
                                            }
                                        }
                                    } else {
                                        c00091.L$0 = pointerEventHandlerCoroutine4;
                                        c00091.L$1 = coroutineScope2;
                                        c00091.L$2 = pressGestureScopeImpl6;
                                        c00091.L$3 = function18;
                                        c00091.L$4 = function14;
                                        c00091.L$5 = function10;
                                        c00091.L$6 = standaloneCoroutineLaunch$default2;
                                        c00091.L$7 = r6;
                                        c00091.L$8 = r22;
                                        c00091.label = 7;
                                        objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                                        if (objWaitForLongPress2 != coroutineSingletons) {
                                            Function1 function217 = function10;
                                            job2 = standaloneCoroutineLaunch$default2;
                                            pointerInputChange3 = pointerInputChange2;
                                            objWaitForUpOrCancellation2 = objWaitForLongPress2;
                                            r9 = r6;
                                            pressGestureScopeImpl6 = pressGestureScopeImpl6;
                                            function19 = function217;
                                            CoroutineScope coroutineScope13 = coroutineScope2;
                                            pointerEventHandlerCoroutine5 = pointerEventHandlerCoroutine4;
                                            coroutineScope4 = coroutineScope13;
                                            r14 = r8;
                                            longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                                            if (Intrinsics.areEqual(longPressResult2, success)) {
                                                function14.invoke(new Offset(pointerInputChange3.position));
                                                c00091.L$0 = coroutineScope4;
                                                c00091.L$1 = pressGestureScopeImpl6;
                                                c00091.L$2 = job2;
                                                c00091.L$3 = r14;
                                                c00091.L$4 = r14;
                                                c00091.L$5 = r14;
                                                c00091.L$6 = r14;
                                                c00091.L$7 = r14;
                                                c00091.L$8 = r14;
                                                c00091.label = 8;
                                                if (consumeUntilUp(pointerEventHandlerCoroutine5, c00091) != coroutineSingletons) {
                                                    job3 = job2;
                                                    coroutineScope6 = coroutineScope4;
                                                    r16 = r14;
                                                    launchAwaitingReset$default(coroutineScope6, job3, new AnonymousClass3(pressGestureScopeImpl6, r16, 7));
                                                    return Unit.INSTANCE;
                                                }
                                            } else {
                                                if (longPressResult2 instanceof LongPressResult.Released) {
                                                    function10 = function19;
                                                    r15 = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                                } else {
                                                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                                                        throw new HttpException();
                                                    }
                                                    function10 = function19;
                                                    r15 = r14;
                                                }
                                                function20 = function18;
                                                coroutineScope5 = coroutineScope4;
                                                r13 = r9;
                                                r12 = r14;
                                                r11 = r15;
                                                if (r11 != 0) {
                                                    r11.consume();
                                                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                                    function20.invoke(new Offset(r11.position));
                                                } else {
                                                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                                    if (function10 != null) {
                                                        function10.invoke(new Offset(r13.position));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (function10 != null) {
                                    function10.invoke(new Offset(r6.position));
                                }
                            }
                        } else if (function10 != null) {
                            function10.invoke(new Offset(r3.position));
                        }
                    }
                    return Unit.INSTANCE;
                }
                function6.invoke(new Offset(pointerInputChange.position));
                c00091.L$0 = coroutineScope2;
                c00091.L$1 = pressGestureScopeImpl3;
                c00091.L$2 = job;
                c00091.L$3 = r1;
                c00091.L$4 = r1;
                c00091.L$5 = r1;
                c00091.L$6 = r1;
                c00091.L$7 = r1;
                c00091.L$8 = r1;
                c00091.label = 4;
                if (consumeUntilUp(pointerEventHandlerCoroutine2, c00091) != coroutineSingletons) {
                    coroutineScope3 = coroutineScope2;
                    pressGestureScopeImpl5 = pressGestureScopeImpl3;
                    r5 = r1;
                    launchAwaitingReset$default(coroutineScope3, job, new AnonymousClass3(pressGestureScopeImpl5, r5, 0));
                    return Unit.INSTANCE;
                }
                return coroutineSingletons;
            case 4:
                job = (Job) c00091.L$2;
                pressGestureScopeImpl5 = (PressGestureScopeImpl) c00091.L$1;
                coroutineScope3 = (CoroutineScope) c00091.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                r5 = 0;
                launchAwaitingReset$default(coroutineScope3, job, new AnonymousClass3(pressGestureScopeImpl5, r5, 0));
                return Unit.INSTANCE;
            case 5:
                jobLaunchAwaitingReset$default = (Job) c00091.L$8;
                PointerInputChange pointerInputChange6 = (PointerInputChange) c00091.L$7;
                function10 = (Function1) c00091.L$6;
                function17 = (Function3) c00091.L$5;
                Function1 function32 = (Function1) c00091.L$4;
                Function1 function33 = c00091.L$3;
                pressGestureScopeImpl4 = (PressGestureScopeImpl) c00091.L$2;
                CoroutineScope coroutineScope14 = (CoroutineScope) c00091.L$1;
                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine7 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00091.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                pointerEventHandlerCoroutine4 = pointerEventHandlerCoroutine7;
                function14 = function32;
                success = success;
                function18 = function33;
                coroutineScope2 = coroutineScope14;
                objWithTimeoutOrNull = objWaitForUpOrCancellation2;
                r7 = 0;
                r6 = pointerInputChange6;
                pointerInputChange2 = (PointerInputChange) objWithTimeoutOrNull;
                if (pointerInputChange2 != null) {
                    standaloneCoroutineLaunch$default2 = JobKt.launch$default(coroutineScope2, r7, new RealImageLoader$execute$3(jobLaunchAwaitingReset$default, pressGestureScopeImpl4, r7, 9), 1);
                    if (function17 != draggableKt$NoOpOnDragStarted$1) {
                        ?? r29 = r7;
                        PressGestureScopeImpl pressGestureScopeImpl17 = pressGestureScopeImpl4;
                        C00102 c00108 = new C00102(function17, pressGestureScopeImpl17, pointerInputChange2, r29, 1);
                        pressGestureScopeImpl6 = pressGestureScopeImpl17;
                        r8 = r29;
                        launchAwaitingReset$default(coroutineScope2, standaloneCoroutineLaunch$default2, c00108);
                    } else {
                        r8 = r7;
                        pressGestureScopeImpl6 = pressGestureScopeImpl4;
                    }
                    if (function14 == null) {
                        c00091.L$0 = coroutineScope2;
                        c00091.L$1 = pressGestureScopeImpl6;
                        c00091.L$2 = function18;
                        c00091.L$3 = function10;
                        c00091.L$4 = standaloneCoroutineLaunch$default2;
                        c00091.L$5 = r6;
                        c00091.L$6 = r8;
                        c00091.L$7 = r8;
                        c00091.L$8 = r8;
                        c00091.label = 6;
                        objWaitForUpOrCancellation2 = waitForUpOrCancellation(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                        if (objWaitForUpOrCancellation2 != coroutineSingletons) {
                            ?? r113 = r6;
                            job2 = standaloneCoroutineLaunch$default2;
                            r0 = r113;
                            function20 = function18;
                            coroutineScope5 = coroutineScope2;
                            r10 = r8;
                            r13 = r0;
                            r12 = r10;
                            r11 = (PointerInputChange) objWaitForUpOrCancellation2;
                            if (r11 != 0) {
                                r11.consume();
                                launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                function20.invoke(new Offset(r11.position));
                            } else {
                                launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                if (function10 != null) {
                                    function10.invoke(new Offset(r13.position));
                                }
                            }
                        }
                    } else {
                        c00091.L$0 = pointerEventHandlerCoroutine4;
                        c00091.L$1 = coroutineScope2;
                        c00091.L$2 = pressGestureScopeImpl6;
                        c00091.L$3 = function18;
                        c00091.L$4 = function14;
                        c00091.L$5 = function10;
                        c00091.L$6 = standaloneCoroutineLaunch$default2;
                        c00091.L$7 = r6;
                        c00091.L$8 = r22;
                        c00091.label = 7;
                        objWaitForLongPress2 = waitForLongPress(pointerEventHandlerCoroutine4, pointerEventPass, c00091);
                        if (objWaitForLongPress2 != coroutineSingletons) {
                            Function1 function218 = function10;
                            job2 = standaloneCoroutineLaunch$default2;
                            pointerInputChange3 = pointerInputChange2;
                            objWaitForUpOrCancellation2 = objWaitForLongPress2;
                            r9 = r6;
                            pressGestureScopeImpl6 = pressGestureScopeImpl6;
                            function19 = function218;
                            CoroutineScope coroutineScope15 = coroutineScope2;
                            pointerEventHandlerCoroutine5 = pointerEventHandlerCoroutine4;
                            coroutineScope4 = coroutineScope15;
                            r14 = r8;
                            longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                            if (Intrinsics.areEqual(longPressResult2, success)) {
                                function14.invoke(new Offset(pointerInputChange3.position));
                                c00091.L$0 = coroutineScope4;
                                c00091.L$1 = pressGestureScopeImpl6;
                                c00091.L$2 = job2;
                                c00091.L$3 = r14;
                                c00091.L$4 = r14;
                                c00091.L$5 = r14;
                                c00091.L$6 = r14;
                                c00091.L$7 = r14;
                                c00091.L$8 = r14;
                                c00091.label = 8;
                                if (consumeUntilUp(pointerEventHandlerCoroutine5, c00091) != coroutineSingletons) {
                                    job3 = job2;
                                    coroutineScope6 = coroutineScope4;
                                    r16 = r14;
                                    launchAwaitingReset$default(coroutineScope6, job3, new AnonymousClass3(pressGestureScopeImpl6, r16, 7));
                                    return Unit.INSTANCE;
                                }
                            } else {
                                if (longPressResult2 instanceof LongPressResult.Released) {
                                    function10 = function19;
                                    r15 = ((LongPressResult.Released) longPressResult2).finalUpChange;
                                } else {
                                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                                        throw new HttpException();
                                    }
                                    function10 = function19;
                                    r15 = r14;
                                }
                                function20 = function18;
                                coroutineScope5 = coroutineScope4;
                                r13 = r9;
                                r12 = r14;
                                r11 = r15;
                                if (r11 != 0) {
                                    r11.consume();
                                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                                    function20.invoke(new Offset(r11.position));
                                } else {
                                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                                    if (function10 != null) {
                                        function10.invoke(new Offset(r13.position));
                                    }
                                }
                            }
                        }
                    }
                    return coroutineSingletons;
                }
                if (function10 != null) {
                    function10.invoke(new Offset(r6.position));
                }
                return Unit.INSTANCE;
            case 6:
                PointerInputChange pointerInputChange7 = (PointerInputChange) c00091.L$5;
                job2 = (Job) c00091.L$4;
                function10 = c00091.L$3;
                function20 = (Function1) c00091.L$2;
                pressGestureScopeImpl6 = (PressGestureScopeImpl) c00091.L$1;
                coroutineScope5 = (CoroutineScope) c00091.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                r10 = 0;
                r0 = pointerInputChange7;
                r13 = r0;
                r12 = r10;
                r11 = (PointerInputChange) objWaitForUpOrCancellation2;
                if (r11 != 0) {
                    r11.consume();
                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                    function20.invoke(new Offset(r11.position));
                } else {
                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                    if (function10 != null) {
                        function10.invoke(new Offset(r13.position));
                    }
                }
                return Unit.INSTANCE;
            case 7:
                pointerInputChange3 = (PointerInputChange) c00091.L$8;
                PointerInputChange pointerInputChange8 = (PointerInputChange) c00091.L$7;
                job2 = (Job) c00091.L$6;
                Function1 function34 = (Function1) c00091.L$5;
                Function1 function35 = (Function1) c00091.L$4;
                function18 = c00091.L$3;
                PressGestureScopeImpl pressGestureScopeImpl18 = (PressGestureScopeImpl) c00091.L$2;
                coroutineScope4 = (CoroutineScope) c00091.L$1;
                pointerEventHandlerCoroutine5 = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) c00091.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                success = success;
                function14 = function35;
                r14 = 0;
                function19 = function34;
                r9 = pointerInputChange8;
                pressGestureScopeImpl6 = pressGestureScopeImpl18;
                longPressResult2 = (LongPressResult) objWaitForUpOrCancellation2;
                if (Intrinsics.areEqual(longPressResult2, success)) {
                    function14.invoke(new Offset(pointerInputChange3.position));
                    c00091.L$0 = coroutineScope4;
                    c00091.L$1 = pressGestureScopeImpl6;
                    c00091.L$2 = job2;
                    c00091.L$3 = r14;
                    c00091.L$4 = r14;
                    c00091.L$5 = r14;
                    c00091.L$6 = r14;
                    c00091.L$7 = r14;
                    c00091.L$8 = r14;
                    c00091.label = 8;
                    if (consumeUntilUp(pointerEventHandlerCoroutine5, c00091) != coroutineSingletons) {
                        job3 = job2;
                        coroutineScope6 = coroutineScope4;
                        r16 = r14;
                        launchAwaitingReset$default(coroutineScope6, job3, new AnonymousClass3(pressGestureScopeImpl6, r16, 7));
                        return Unit.INSTANCE;
                    }
                    return coroutineSingletons;
                }
                if (longPressResult2 instanceof LongPressResult.Released) {
                    function10 = function19;
                    r15 = ((LongPressResult.Released) longPressResult2).finalUpChange;
                } else {
                    if (longPressResult2 instanceof LongPressResult.Canceled) {
                        throw new HttpException();
                    }
                    function10 = function19;
                    r15 = r14;
                }
                function20 = function18;
                coroutineScope5 = coroutineScope4;
                r13 = r9;
                r12 = r14;
                r11 = r15;
                if (r11 != 0) {
                    r11.consume();
                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 5));
                    function20.invoke(new Offset(r11.position));
                } else {
                    launchAwaitingReset$default(coroutineScope5, job2, new AnonymousClass3(pressGestureScopeImpl6, r12, 6));
                    if (function10 != null) {
                        function10.invoke(new Offset(r13.position));
                    }
                }
                return Unit.INSTANCE;
            case 8:
                job3 = (Job) c00091.L$2;
                pressGestureScopeImpl6 = (PressGestureScopeImpl) c00091.L$1;
                coroutineScope6 = (CoroutineScope) c00091.L$0;
                ResultKt.throwOnFailure(objWaitForUpOrCancellation2);
                r16 = 0;
                launchAwaitingReset$default(coroutineScope6, job3, new AnonymousClass3(pressGestureScopeImpl6, r16, 7));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object waitForLongPress(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, PointerEventPass pointerEventPass, ContinuationImpl continuationImpl) {
        C00111 c00111;
        Ref$ObjectRef ref$ObjectRef;
        if (continuationImpl instanceof C00111) {
            c00111 = (C00111) continuationImpl;
            int i = c00111.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00111.label = i - Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuationImpl);
            }
        } else {
            c00111 = new C00111(continuationImpl);
        }
        Object obj = c00111.result;
        int i2 = c00111.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                ref$ObjectRef2.element = LongPressResult.Canceled.INSTANCE;
                long longPressTimeoutMillis = pointerEventHandlerCoroutine.getViewConfiguration().getLongPressTimeoutMillis();
                Function2 forEachGestureKt$awaitEachGesture$2 = new ForEachGestureKt$awaitEachGesture$2(pointerEventPass, ref$ObjectRef2, null, 2);
                c00111.L$0 = ref$ObjectRef2;
                c00111.label = 1;
                Object objWithTimeout = pointerEventHandlerCoroutine.withTimeout(longPressTimeoutMillis, forEachGestureKt$awaitEachGesture$2, c00111);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithTimeout == obj2) {
                    return obj2;
                }
                ref$ObjectRef = ref$ObjectRef2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$ObjectRef = c00111.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return ref$ObjectRef.element;
        } catch (PointerEventTimeoutCancellationException unused) {
            return LongPressResult.Success.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0061  */
    /* JADX WARN: Code duplicated, block: B:28:0x0074  */
    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    /* JADX WARN: Code duplicated, block: B:44:0x00bd A[LOOP:1: B:23:0x005f->B:44:0x00bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x006d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00b8 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r15v10, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009e -> B:13:0x002e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.attributes.AttrNode.contains(AttrNode.java:103)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.getNextIfNodeInfo(IfRegionMaker.java:613)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.getNextIf(IfRegionMaker.java:602)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.mergeNestedIfNodes(IfRegionMaker.java:409)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        */
    public static final java.lang.Object waitForUpOrCancellation(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r13, androidx.compose.ui.input.pointer.PointerEventPass r14, kotlin.coroutines.jvm.internal.BaseContinuationImpl r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt.C00122
            if (r0 == 0) goto L13
            r0 = r15
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt.C00122) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 0
            r4 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L43
            if (r1 == r4) goto L3b
            if (r1 != r2) goto L33
            androidx.compose.ui.input.pointer.PointerEventPass r13 = r0.L$1
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r14 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r15)
        L2e:
            r12 = r14
            r14 = r13
            r13 = r12
            goto La1
        L33:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3b:
            androidx.compose.ui.input.pointer.PointerEventPass r13 = r0.L$1
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r14 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L56
        L43:
            kotlin.ResultKt.throwOnFailure(r15)
        L46:
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r4
            java.lang.Object r15 = r13.awaitPointerEvent(r14, r0)
            if (r15 != r5) goto L53
            goto La0
        L53:
            r12 = r14
            r14 = r13
            r13 = r12
        L56:
            androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15
            java.lang.Object r15 = r15.changes
            int r1 = r15.size()
            r6 = r3
        L5f:
            if (r6 >= r1) goto Lc0
            java.lang.Object r7 = r15.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.changedToUp(r7)
            if (r7 != 0) goto Lbd
            int r1 = r15.size()
            r6 = r3
        L72:
            if (r6 >= r1) goto L92
            java.lang.Object r7 = r15.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r8 = r7.isConsumed()
            if (r8 != 0) goto Lb8
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r8 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.this
            long r8 = r8.boundsSize
            long r10 = r14.m514getExtendedTouchPaddingNHjbRc()
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m511isOutOfBoundsjwHxaWs(r7, r8, r10)
            if (r7 == 0) goto L8f
            goto Lb8
        L8f:
            int r6 = r6 + 1
            goto L72
        L92:
            r0.L$0 = r14
            r0.L$1 = r13
            r0.label = r2
            androidx.compose.ui.input.pointer.PointerEventPass r15 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            java.lang.Object r15 = r14.awaitPointerEvent(r15, r0)
            if (r15 != r5) goto L2e
        La0:
            return r5
        La1:
            androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15
            java.lang.Object r15 = r15.changes
            int r1 = r15.size()
            r6 = r3
        Laa:
            if (r6 >= r1) goto L46
            java.lang.Object r7 = r15.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r7 = r7.isConsumed()
            if (r7 == 0) goto Lba
        Lb8:
            r13 = 0
            return r13
        Lba:
            int r6 = r6 + 1
            goto Laa
        Lbd:
            int r6 = r6 + 1
            goto L5f
        Lc0:
            java.lang.Object r13 = r15.get(r3)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }
}
