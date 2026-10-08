package androidx.compose.foundation.lazy;

import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPassesKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import coil.request.RequestService;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListState implements ScrollableState {
    public static final RequestService Saver;
    public final SurfaceRequest.AnonymousClass1 _lazyLayoutScrollDeltaBetweenPasses;
    public LazyListMeasureResult approachLayoutInfo;
    public final AwaitFirstLayoutModifier awaitLayoutModifier;
    public final PreviewView.AnonymousClass1 beyondBoundsInfo;
    public final ParcelableSnapshotMutableState canScrollBackward$delegate;
    public final ParcelableSnapshotMutableState canScrollForward$delegate;
    public boolean executeRequestsInHighPriorityMode;
    public boolean hasLookaheadOccurred;
    public final MutableInteractionSourceImpl internalInteractionSource;
    public final LazyLayoutItemAnimator itemAnimator;
    public final ParcelableSnapshotMutableState layoutInfoState;
    public final MutableState measurementScopeInvalidator;
    public final LazyLayoutPinnedItemList pinnedItems;
    public final MutableState placementScopeInvalidator;
    public final Toolbar.AnonymousClass1 prefetchScope;
    public final LazyLayoutPrefetchState prefetchState;
    public final DefaultLazyListPrefetchStrategy prefetchStrategy;
    public final boolean prefetchingEnabled;
    public LayoutNode remeasurement;
    public final LazyListState$remeasurementModifier$1 remeasurementModifier;
    public final Exchange scrollPosition;
    public float scrollToBeConsumed;
    public final DefaultScrollableState scrollableState;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$scroll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public MutatePriority L$0;
        public SuspendLambda L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyListState.this.scroll(null, null, this);
        }
    }

    static {
        SaversKt$$ExternalSyntheticLambda0 saversKt$$ExternalSyntheticLambda0 = new SaversKt$$ExternalSyntheticLambda0(2);
        BasicTextKt$$ExternalSyntheticLambda3 basicTextKt$$ExternalSyntheticLambda3 = new BasicTextKt$$ExternalSyntheticLambda3(15);
        ScaffoldKt$$ExternalSyntheticLambda3 scaffoldKt$$ExternalSyntheticLambda3 = new ScaffoldKt$$ExternalSyntheticLambda3(6, saversKt$$ExternalSyntheticLambda0);
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, basicTextKt$$ExternalSyntheticLambda3);
        Saver = new RequestService(2, scaffoldKt$$ExternalSyntheticLambda3, basicTextKt$$ExternalSyntheticLambda3);
    }

    public LazyListState(int i, int i2) {
        DefaultLazyListPrefetchStrategy defaultLazyListPrefetchStrategy = new DefaultLazyListPrefetchStrategy();
        defaultLazyListPrefetchStrategy.indexToPrefetch = -1;
        defaultLazyListPrefetchStrategy.previousPassItemCount = -1;
        this.prefetchStrategy = defaultLazyListPrefetchStrategy;
        Exchange exchange = new Exchange();
        exchange.call = new ParcelableSnapshotMutableIntState(i);
        exchange.finder = new ParcelableSnapshotMutableIntState(i2);
        exchange.connection = new LazyLayoutNearestRangeState(i);
        this.scrollPosition = exchange;
        LazyListMeasureResult lazyListMeasureResult = LazyListStateKt.EmptyLazyListMeasureResult;
        NeverEqualPolicy neverEqualPolicy = NeverEqualPolicy.INSTANCE;
        this.layoutInfoState = new ParcelableSnapshotMutableState(lazyListMeasureResult, neverEqualPolicy);
        this.internalInteractionSource = new MutableInteractionSourceImpl();
        this.scrollableState = new DefaultScrollableState(new Recomposer$$ExternalSyntheticLambda0(9, this));
        this.prefetchingEnabled = true;
        this.remeasurementModifier = new LazyListState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyLayoutItemAnimator();
        this.beyondBoundsInfo = new PreviewView.AnonymousClass1(27);
        this.prefetchState = new LazyLayoutPrefetchState(new LazyListState$$ExternalSyntheticLambda3(this, i));
        this.prefetchScope = new Toolbar.AnonymousClass1(27, this);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        Unit unit = Unit.INSTANCE;
        this.measurementScopeInvalidator = new ParcelableSnapshotMutableState(unit, neverEqualPolicy);
        Boolean bool = Boolean.FALSE;
        this.canScrollForward$delegate = Stack.mutableStateOf$default(bool);
        this.canScrollBackward$delegate = Stack.mutableStateOf$default(bool);
        this.placementScopeInvalidator = new ParcelableSnapshotMutableState(unit, neverEqualPolicy);
        SurfaceRequest.AnonymousClass1 anonymousClass1 = new SurfaceRequest.AnonymousClass1(24, false);
        TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
        Float fValueOf = Float.valueOf(0.0f);
        anonymousClass1.val$requestCancellationFuture = new AnimationState(twoWayConverterImpl, fValueOf, (AnimationVector) twoWayConverterImpl.convertToVector.invoke(fValueOf), Long.MIN_VALUE, Long.MIN_VALUE, false);
        this._lazyLayoutScrollDeltaBetweenPasses = anonymousClass1;
    }

    public static Object scrollToItem$default(LazyListState lazyListState, int i, SuspendLambda suspendLambda) throws Throwable {
        lazyListState.getClass();
        Object objScroll = lazyListState.scroll(MutatePriority.Default, new ThumbNode.AnonymousClass1(lazyListState, i, (Continuation) null), suspendLambda);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public final void applyMeasureResult$foundation(LazyListMeasureResult lazyListMeasureResult, boolean z, boolean z2) {
        TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
        ?? r3 = lazyListMeasureResult.visibleItemsInfo;
        int i = lazyListMeasureResult.totalItemsCount;
        int i2 = lazyListMeasureResult.firstVisibleItemScrollOffset;
        LazyListMeasuredItem lazyListMeasuredItem = lazyListMeasureResult.firstVisibleItem;
        this.prefetchState.idealNestedPrefetchCount = r3.size();
        SurfaceRequest.AnonymousClass1 anonymousClass1 = this._lazyLayoutScrollDeltaBetweenPasses;
        Exchange exchange = this.scrollPosition;
        Continuation continuation = null;
        if (!z && this.hasLookaheadOccurred) {
            this.approachLayoutInfo = lazyListMeasureResult;
            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                if (((Number) ((AnimationState) anonymousClass1.val$requestCancellationFuture).value$delegate.getValue()).floatValue() != 0.0f && lazyListMeasuredItem != null && lazyListMeasuredItem.index == ((ParcelableSnapshotMutableIntState) exchange.call).getIntValue() && i2 == ((ParcelableSnapshotMutableIntState) exchange.finder).getIntValue()) {
                    StandaloneCoroutine standaloneCoroutine = (StandaloneCoroutine) anonymousClass1.val$requestCancellationCompleter;
                    if (standaloneCoroutine != null) {
                        standaloneCoroutine.cancel((CancellationException) null);
                    }
                    anonymousClass1.val$requestCancellationFuture = new AnimationState(twoWayConverterImpl, Float.valueOf(0.0f), null, 60);
                }
                Unit unit = Unit.INSTANCE;
                return;
            } finally {
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }
        if (z) {
            this.hasLookaheadOccurred = true;
        }
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(((lazyListMeasuredItem != null ? lazyListMeasuredItem.index : 0) == 0 && i2 == 0) ? false : true));
        this.canScrollForward$delegate.setValue(Boolean.valueOf(lazyListMeasureResult.canScrollForward));
        this.scrollToBeConsumed -= lazyListMeasureResult.consumedScroll;
        this.layoutInfoState.setValue(lazyListMeasureResult);
        if (z2) {
            exchange.getClass();
            if (!(((float) i2) >= 0.0f)) {
                InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
            }
            ((ParcelableSnapshotMutableIntState) exchange.finder).setIntValue(i2);
            anonymousClass1 = anonymousClass1;
        } else {
            LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) CollectionsKt.firstOrNull(r3);
            LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(r3);
            AndroidTrace_androidKt.traceValue("firstVisibleItem:index", lazyListMeasuredItem2 != null ? lazyListMeasuredItem2.index : -1L);
            AndroidTrace_androidKt.traceValue("lastVisibleItem:index", lazyListMeasuredItem3 != null ? lazyListMeasuredItem3.index : -1L);
            exchange.getClass();
            exchange.codec = lazyListMeasuredItem != null ? lazyListMeasuredItem.key : null;
            if (exchange.hasFailure || i > 0) {
                exchange.hasFailure = true;
                if (!(((float) i2) >= 0.0f)) {
                    InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
                }
                exchange.update(lazyListMeasuredItem != null ? lazyListMeasuredItem.index : 0, i2);
            }
            if (this.prefetchingEnabled) {
                DefaultLazyListPrefetchStrategy defaultLazyListPrefetchStrategy = this.prefetchStrategy;
                int i3 = defaultLazyListPrefetchStrategy.indexToPrefetch;
                boolean z3 = defaultLazyListPrefetchStrategy.wasScrollingForward;
                if (i3 != -1 && !r3.isEmpty() && i3 != DefaultLazyListPrefetchStrategy.calculateIndexToPrefetch(lazyListMeasureResult, z3)) {
                    defaultLazyListPrefetchStrategy.indexToPrefetch = -1;
                    LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = defaultLazyListPrefetchStrategy.currentPrefetchHandle;
                    if (prefetchHandle != null) {
                        prefetchHandle.cancel();
                    }
                    defaultLazyListPrefetchStrategy.currentPrefetchHandle = null;
                }
                int i4 = defaultLazyListPrefetchStrategy.previousPassItemCount;
                if (i4 != -1 && defaultLazyListPrefetchStrategy.previousPassDelta != 0.0f && i4 != i && !r3.isEmpty()) {
                    int iCalculateIndexToPrefetch = DefaultLazyListPrefetchStrategy.calculateIndexToPrefetch(lazyListMeasureResult, defaultLazyListPrefetchStrategy.previousPassDelta < 0.0f);
                    if (iCalculateIndexToPrefetch >= 0 && iCalculateIndexToPrefetch < i) {
                        defaultLazyListPrefetchStrategy.indexToPrefetch = iCalculateIndexToPrefetch;
                        defaultLazyListPrefetchStrategy.currentPrefetchHandle = LazyItemScope$CC.schedulePrefetch$default(this.prefetchScope, iCalculateIndexToPrefetch);
                    }
                }
                defaultLazyListPrefetchStrategy.previousPassItemCount = i;
            }
        }
        if (z) {
            float f = lazyListMeasureResult.scrollBackAmount;
            Density density = lazyListMeasureResult.density;
            CoroutineScope coroutineScope = lazyListMeasureResult.coroutineScope;
            anonymousClass1.getClass();
            if (f <= density.mo92toPx0680j_4(LazyLayoutScrollDeltaBetweenPassesKt.DeltaThresholdForScrollAnimation)) {
                return;
            }
            Snapshot currentThreadSnapshot2 = SnapshotId_jvmKt.getCurrentThreadSnapshot();
            Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable2 = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot2);
            SurfaceRequest.AnonymousClass1 anonymousClass2 = anonymousClass1;
            try {
                float fFloatValue = ((Number) ((AnimationState) anonymousClass2.val$requestCancellationFuture).value$delegate.getValue()).floatValue();
                StandaloneCoroutine standaloneCoroutine2 = (StandaloneCoroutine) anonymousClass2.val$requestCancellationCompleter;
                if (standaloneCoroutine2 != null) {
                    standaloneCoroutine2.cancel((CancellationException) null);
                }
                AnimationState animationState = (AnimationState) anonymousClass2.val$requestCancellationFuture;
                if (animationState.isRunning) {
                    anonymousClass2.val$requestCancellationFuture = ArcSplineKt.copy$default(animationState, fFloatValue - f, 0.0f, 30);
                } else {
                    anonymousClass2.val$requestCancellationFuture = new AnimationState(twoWayConverterImpl, Float.valueOf(-f), null, 60);
                }
                anonymousClass2.val$requestCancellationCompleter = JobKt.launch$default(coroutineScope, null, new ThumbNode.AnonymousClass1(anonymousClass2, continuation, 7), 3);
                Unit unit2 = Unit.INSTANCE;
            } finally {
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
            }
        }
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final LazyListMeasureResult getLayoutInfo() {
        return (LazyListMeasureResult) this.layoutInfoState.getValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.List] */
    public final void notifyPrefetchOnScroll(float f, LazyListMeasureResult lazyListMeasureResult) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
        if (this.prefetchingEnabled) {
            ?? r0 = lazyListMeasureResult.visibleItemsInfo;
            ?? r1 = lazyListMeasureResult.visibleItemsInfo;
            boolean zIsEmpty = r0.isEmpty();
            DefaultLazyListPrefetchStrategy defaultLazyListPrefetchStrategy = this.prefetchStrategy;
            if (!zIsEmpty) {
                boolean z = f < 0.0f;
                int iCalculateIndexToPrefetch = DefaultLazyListPrefetchStrategy.calculateIndexToPrefetch(lazyListMeasureResult, z);
                if (iCalculateIndexToPrefetch >= 0 && iCalculateIndexToPrefetch < lazyListMeasureResult.totalItemsCount) {
                    if (iCalculateIndexToPrefetch != defaultLazyListPrefetchStrategy.indexToPrefetch) {
                        if (defaultLazyListPrefetchStrategy.wasScrollingForward != z) {
                            defaultLazyListPrefetchStrategy.indexToPrefetch = -1;
                            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle3 = defaultLazyListPrefetchStrategy.currentPrefetchHandle;
                            if (prefetchHandle3 != null) {
                                prefetchHandle3.cancel();
                            }
                            defaultLazyListPrefetchStrategy.currentPrefetchHandle = null;
                        }
                        defaultLazyListPrefetchStrategy.wasScrollingForward = z;
                        defaultLazyListPrefetchStrategy.indexToPrefetch = iCalculateIndexToPrefetch;
                        defaultLazyListPrefetchStrategy.currentPrefetchHandle = LazyItemScope$CC.schedulePrefetch$default(this.prefetchScope, iCalculateIndexToPrefetch);
                    }
                    if (z) {
                        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) CollectionsKt.last(r1);
                        if (((lazyListMeasuredItem.offset + lazyListMeasuredItem.size) + lazyListMeasureResult.mainAxisItemSpacing) - lazyListMeasureResult.viewportEndOffset < (-f) && (prefetchHandle2 = defaultLazyListPrefetchStrategy.currentPrefetchHandle) != null) {
                            prefetchHandle2.markAsUrgent();
                        }
                    } else if (lazyListMeasureResult.viewportStartOffset - ((LazyListMeasuredItem) CollectionsKt.first((List) r1)).offset < f && (prefetchHandle = defaultLazyListPrefetchStrategy.currentPrefetchHandle) != null) {
                        prefetchHandle.markAsUrgent();
                    }
                }
            }
            defaultLazyListPrefetchStrategy.previousPassDelta = f;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (r5.scrollableState.scroll(r6, r7, r0) == r4) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scroll(androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.LazyListState.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = (androidx.compose.foundation.lazy.LazyListState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = new androidx.compose.foundation.lazy.LazyListState$scroll$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L86
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.coroutines.jvm.internal.SuspendLambda r6 = r0.L$1
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.foundation.MutatePriority r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L76
        L3d:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.runtime.ParcelableSnapshotMutableState r8 = r5.layoutInfoState
            java.lang.Object r8 = r8.getValue()
            androidx.compose.foundation.lazy.LazyListMeasureResult r1 = androidx.compose.foundation.lazy.LazyListStateKt.EmptyLazyListMeasureResult
            if (r8 != r1) goto L76
            r0.L$0 = r6
            r8 = r7
            kotlin.coroutines.jvm.internal.SuspendLambda r8 = (kotlin.coroutines.jvm.internal.SuspendLambda) r8
            r0.L$1 = r8
            r0.label = r3
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r8 = r5.awaitLayoutModifier
            kotlinx.coroutines.CompletableDeferredImpl r1 = r8.lock
            if (r1 != 0) goto L6a
            kotlinx.coroutines.CompletableDeferredImpl r1 = kotlinx.coroutines.JobKt.CompletableDeferred$default()
            r8.lock = r1
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$Node r8 = r8.attachedNode
            if (r8 == 0) goto L6a
            boolean r3 = r8.isAttached
            if (r3 == 0) goto L6a
            r8.requestOnAfterLayoutCallback()
        L6a:
            java.lang.Object r8 = r1.awaitInternal(r0)
            if (r8 != r4) goto L71
            goto L73
        L71:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L73:
            if (r8 != r4) goto L76
            goto L85
        L76:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r2
            androidx.compose.foundation.gestures.DefaultScrollableState r8 = r5.scrollableState
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r4) goto L86
        L85:
            return r4
        L86:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
