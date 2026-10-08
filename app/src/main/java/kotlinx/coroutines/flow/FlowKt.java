package kotlinx.coroutines.flow;

import androidx.activity.compose.ComposePredictiveBackHandler$launchNewGesture$1$1;
import androidx.compose.material3.BottomSheetKt$BottomSheet$4$1$1;
import androidx.compose.material3.ThumbNode;
import androidx.compose.ui.unit.Density;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import io.github.g00fy2.quickie.ScanQRCode;
import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.LazyStandaloneCoroutine;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.NopCollector;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: loaded from: classes.dex */
public abstract class FlowKt {
    public static final Symbol NO_VALUE = new Symbol("NO_VALUE", 0);
    public static final Symbol NONE = new Symbol("NONE", 0);
    public static final Symbol PENDING = new Symbol("PENDING", 0);

    public static SharedFlowImpl MutableSharedFlow$default(int i, int i2) {
        int i3 = (i2 & 1) != 0 ? 0 : 1;
        int i4 = (i2 & 2) == 0 ? 16 : 0;
        if (i3 <= 0 && i4 <= 0 && i != 1) {
            throw new IllegalArgumentException("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ".concat(Density.CC.stringValueOf$6(i)).toString());
        }
        int i5 = i4 + i3;
        if (i5 < 0) {
            i5 = Integer.MAX_VALUE;
        }
        return new SharedFlowImpl(i3, i5, i);
    }

    public static final StateFlowImpl MutableStateFlow(Object obj) {
        if (obj == null) {
            obj = ChannelFlowKt.NULL;
        }
        return new StateFlowImpl(obj);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$invokeSafely$FlowKt__EmittersKt(ThrowingCollector throwingCollector, ComposePredictiveBackHandler$launchNewGesture$1$1 composePredictiveBackHandler$launchNewGesture$1$1, Throwable th, ContinuationImpl continuationImpl) {
        FlowKt__EmittersKt$invokeSafely$1 flowKt__EmittersKt$invokeSafely$1;
        if (continuationImpl instanceof FlowKt__EmittersKt$invokeSafely$1) {
            flowKt__EmittersKt$invokeSafely$1 = (FlowKt__EmittersKt$invokeSafely$1) continuationImpl;
            int i = flowKt__EmittersKt$invokeSafely$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$invokeSafely$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuationImpl);
            }
        } else {
            flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuationImpl);
        }
        Object obj = flowKt__EmittersKt$invokeSafely$1.result;
        int i2 = flowKt__EmittersKt$invokeSafely$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                flowKt__EmittersKt$invokeSafely$1.L$0 = th;
                flowKt__EmittersKt$invokeSafely$1.label = 1;
                Object objInvoke = composePredictiveBackHandler$launchNewGesture$1$1.invoke(throwingCollector, th, flowKt__EmittersKt$invokeSafely$1);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objInvoke == obj2) {
                    return obj2;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = flowKt__EmittersKt$invokeSafely$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                ScanQRCode.addSuppressed(th2, th);
            }
            throw th2;
        }
    }

    public static final void access$setBufferAt(Object[] objArr, long j, Object obj) {
        objArr[((int) j) & (objArr.length - 1)] = obj;
    }

    public static final ReadonlyStateFlow asStateFlow(StateFlowImpl stateFlowImpl) {
        return new ReadonlyStateFlow(stateFlowImpl, null);
    }

    public static final Object collectLatest(Flow flow, Function2 function2, SuspendLambda suspendLambda) {
        int i = FlowKt__MergeKt.$r8$clinit;
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(function2, null);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Object objCollect = new ChannelFlowTransformLatest(flowKt__MergeKt$mapLatest$1, flow, emptyCoroutineContext, -2, 1).fuse(emptyCoroutineContext, 0, 1).collect(NopCollector.INSTANCE, suspendLambda);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objCollect != coroutineSingletons) {
            objCollect = Unit.INSTANCE;
        }
        return objCollect == coroutineSingletons ? objCollect : Unit.INSTANCE;
    }

    public static final Flow distinctUntilChanged(Flow flow) {
        return ((flow instanceof StateFlow) || (flow instanceof DistinctFlowImpl)) ? flow : new DistinctFlowImpl(flow);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    /* JADX WARN: Code duplicated, block: B:28:0x0067  */
    /* JADX WARN: Code duplicated, block: B:31:0x0073 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x002f, B:25:0x0056, B:29:0x006b, B:31:0x0073, B:20:0x0047, B:24:0x0052), top: B:52:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0088 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x008a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        if (r1.emit(r10, r0) == r5) goto L33;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0085 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector r7, kotlinx.coroutines.channels.ReceiveChannel r8, boolean r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 2
            r4 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L4b
            if (r1 == r4) goto L3f
            if (r1 != r3) goto L37
            boolean r9 = r0.Z$0
            kotlinx.coroutines.channels.BufferedChannel$BufferedChannelIterator r7 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r8 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L35
        L32:
            r10 = r7
            r7 = r1
            goto L56
        L35:
            r7 = move-exception
            goto L90
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            boolean r9 = r0.Z$0
            kotlinx.coroutines.channels.BufferedChannel$BufferedChannelIterator r7 = r0.L$2
            kotlinx.coroutines.channels.ReceiveChannel r8 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L35
            goto L6b
        L4b:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r7 instanceof kotlinx.coroutines.flow.ThrowingCollector
            if (r10 != 0) goto Lab
            kotlinx.coroutines.channels.BufferedChannel$BufferedChannelIterator r10 = r8.iterator()     // Catch: java.lang.Throwable -> L35
        L56:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L35
            r0.L$2 = r10     // Catch: java.lang.Throwable -> L35
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L35
            r0.label = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r1 = r10.hasNext(r0)     // Catch: java.lang.Throwable -> L35
            if (r1 != r5) goto L67
            goto L87
        L67:
            r6 = r1
            r1 = r7
            r7 = r10
            r10 = r6
        L6b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L88
            java.lang.Object r10 = r7.next()     // Catch: java.lang.Throwable -> L35
            r0.L$0 = r1     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L35
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L35
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L35
            r0.label = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = r1.emit(r10, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r5) goto L32
        L87:
            return r5
        L88:
            if (r9 == 0) goto L8d
            r8.cancel(r2)
        L8d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L90:
            throw r7     // Catch: java.lang.Throwable -> L91
        L91:
            r10 = move-exception
            if (r9 == 0) goto Laa
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L9b
            r2 = r7
            java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
        L9b:
            if (r2 != 0) goto La7
            java.util.concurrent.CancellationException r2 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r2.<init>(r9)
            r2.initCause(r7)
        La7:
            r8.cancel(r2)
        Laa:
            throw r10
        Lab:
            kotlinx.coroutines.flow.ThrowingCollector r7 = (kotlinx.coroutines.flow.ThrowingCollector) r7
            java.lang.Throwable r7 = r7.e
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt.emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object first(Flow flow, ContinuationImpl continuationImpl) {
        FlowKt__ReduceKt$first$1 flowKt__ReduceKt$first$1;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e;
        BottomSheetKt$BottomSheet$4$1$1 bottomSheetKt$BottomSheet$4$1$1;
        Symbol symbol = ChannelFlowKt.NULL;
        if (continuationImpl instanceof FlowKt__ReduceKt$first$1) {
            flowKt__ReduceKt$first$1 = (FlowKt__ReduceKt$first$1) continuationImpl;
            int i = flowKt__ReduceKt$first$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$1.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__ReduceKt$first$1 = new FlowKt__ReduceKt$first$1(continuationImpl);
            }
        } else {
            flowKt__ReduceKt$first$1 = new FlowKt__ReduceKt$first$1(continuationImpl);
        }
        Object obj = flowKt__ReduceKt$first$1.result;
        int i2 = flowKt__ReduceKt$first$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = symbol;
            BottomSheetKt$BottomSheet$4$1$1 bottomSheetKt$BottomSheet$4$1$2 = new BottomSheetKt$BottomSheet$4$1$1(5, ref$ObjectRef);
            try {
                flowKt__ReduceKt$first$1.L$0 = ref$ObjectRef;
                flowKt__ReduceKt$first$1.L$1 = bottomSheetKt$BottomSheet$4$1$2;
                flowKt__ReduceKt$first$1.label = 1;
                Object objCollect = flow.collect(bottomSheetKt$BottomSheet$4$1$2, flowKt__ReduceKt$first$1);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCollect == obj2) {
                    return obj2;
                }
            } catch (AbortFlowException e2) {
                e = e2;
                bottomSheetKt$BottomSheet$4$1$1 = bottomSheetKt$BottomSheet$4$1$2;
                if (e.owner == bottomSheetKt$BottomSheet$4$1$1) {
                    throw e;
                }
                JobKt.ensureActive(flowKt__ReduceKt$first$1._context);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bottomSheetKt$BottomSheet$4$1$1 = flowKt__ReduceKt$first$1.L$1;
            ref$ObjectRef = flowKt__ReduceKt$first$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                if (e.owner == bottomSheetKt$BottomSheet$4$1$1) {
                    throw e;
                }
                JobKt.ensureActive(flowKt__ReduceKt$first$1._context);
            }
        }
        Object obj3 = ref$ObjectRef.element;
        if (obj3 != symbol) {
            return obj3;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    public static final Flow fuseSharedFlow(SharedFlow sharedFlow, CoroutineContext coroutineContext, int i, int i2) {
        return ((i == 0 || i == -3) && i2 == 1) ? sharedFlow : new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i, i2);
    }

    public static final ReadonlyStateFlow stateIn(SafeFlow safeFlow, ContextScope contextScope, StartedWhileSubscribed startedWhileSubscribed, Float f) {
        Channel.Factory.getClass();
        Channel.Factory factory = Channel.Factory.$$INSTANCE;
        CacheStrategy cacheStrategy = new CacheStrategy(20, safeFlow, EmptyCoroutineContext.INSTANCE);
        StateFlowImpl stateFlowImplMutableStateFlow = MutableStateFlow(f);
        CoroutineContext coroutineContext = (CoroutineContext) cacheStrategy.cacheResponse;
        Flow flow = (Flow) cacheStrategy.networkRequest;
        int i = startedWhileSubscribed.equals(SharingStarted$Companion.Eagerly) ? 1 : 4;
        Function2 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(startedWhileSubscribed, flow, stateFlowImplMutableStateFlow, f, null, 28);
        CoroutineContext coroutineContextNewCoroutineContext = JobKt.newCoroutineContext(contextScope, coroutineContext);
        StandaloneCoroutine lazyStandaloneCoroutine = i == 2 ? new LazyStandaloneCoroutine(coroutineContextNewCoroutineContext, navHostKt$NavHost$29$1) : new StandaloneCoroutine(coroutineContextNewCoroutineContext, true);
        lazyStandaloneCoroutine.start(i, lazyStandaloneCoroutine, navHostKt$NavHost$29$1);
        return new ReadonlyStateFlow(stateFlowImplMutableStateFlow, lazyStandaloneCoroutine);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object first(Flow flow, Function2 function2, ContinuationImpl continuationImpl) {
        FlowKt__ReduceKt$first$3 flowKt__ReduceKt$first$3;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e;
        ThumbNode.AnonymousClass1.C00011 c00011;
        Symbol symbol = ChannelFlowKt.NULL;
        if (continuationImpl instanceof FlowKt__ReduceKt$first$3) {
            flowKt__ReduceKt$first$3 = (FlowKt__ReduceKt$first$3) continuationImpl;
            int i = flowKt__ReduceKt$first$3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$3.label = i - Integer.MIN_VALUE;
            } else {
                flowKt__ReduceKt$first$3 = new FlowKt__ReduceKt$first$3(continuationImpl);
            }
        } else {
            flowKt__ReduceKt$first$3 = new FlowKt__ReduceKt$first$3(continuationImpl);
        }
        Object obj = flowKt__ReduceKt$first$3.result;
        int i2 = flowKt__ReduceKt$first$3.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = symbol;
            ThumbNode.AnonymousClass1.C00011 c00012 = new ThumbNode.AnonymousClass1.C00011(4, function2, ref$ObjectRef2);
            try {
                flowKt__ReduceKt$first$3.L$0 = ref$ObjectRef2;
                flowKt__ReduceKt$first$3.L$1 = c00012;
                flowKt__ReduceKt$first$3.label = 1;
                Object objCollect = flow.collect(c00012, flowKt__ReduceKt$first$3);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objCollect == obj2) {
                    return obj2;
                }
                ref$ObjectRef = ref$ObjectRef2;
            } catch (AbortFlowException e2) {
                ref$ObjectRef = ref$ObjectRef2;
                e = e2;
                c00011 = c00012;
                if (e.owner == c00011) {
                    JobKt.ensureActive(flowKt__ReduceKt$first$3._context);
                } else {
                    throw e;
                }
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c00011 = flowKt__ReduceKt$first$3.L$1;
            ref$ObjectRef = flowKt__ReduceKt$first$3.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                if (e.owner == c00011) {
                    JobKt.ensureActive(flowKt__ReduceKt$first$3._context);
                } else {
                    throw e;
                }
            }
        }
        Object obj3 = ref$ObjectRef.element;
        if (obj3 != symbol) {
            return obj3;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate");
    }
}
