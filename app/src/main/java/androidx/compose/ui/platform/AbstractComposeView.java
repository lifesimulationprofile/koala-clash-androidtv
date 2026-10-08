package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Trace;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.window.PopupLayout$Content$4;
import androidx.core.viewtree.ViewTree;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.fragment.app.FragmentLayoutInflaterFactory;
import androidx.fragment.app.FragmentStateManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import coil.RealImageLoader$execute$3;
import coil.disk.DiskLruCache;
import coil.network.HttpException;
import com.koala.clash.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.internal.connection.RealConnection$connectTls$1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractComposeView extends ViewGroup {
    public WeakReference cachedViewTreeCompositionContext;
    public ComposeViewContext composeViewContext;
    public WrappedComposition composition;
    public boolean creatingComposition;
    public RealConnection$connectTls$1 disposeViewCompositionStrategy;
    public boolean isTransitionGroupSet;
    public CompositionContext parentContext;
    public IBinder previousAttachedWindowToken;
    public boolean showLayoutBounds;

    public AbstractComposeView(Context context) {
        super(context, null, 0);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        FragmentStateManager.AnonymousClass1 anonymousClass1 = new FragmentStateManager.AnonymousClass1(4, this);
        addOnAttachStateChangeListener(anonymousClass1);
        ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0 = new ZslControlImpl$$ExternalSyntheticLambda0(17);
        PoolingContainer.getPoolingContainerListenerHolder(this).listeners.add(zslControlImpl$$ExternalSyntheticLambda0);
        this.disposeViewCompositionStrategy = new RealConnection$connectTls$1(this, anonymousClass1, zslControlImpl$$ExternalSyntheticLambda0, 1);
    }

    private final void setParentContext(CompositionContext compositionContext) {
        if (this.parentContext != compositionContext) {
            this.parentContext = compositionContext;
            if (compositionContext != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            WrappedComposition wrappedComposition = this.composition;
            if (wrappedComposition != null) {
                wrappedComposition.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    public abstract void Content$1(int i, GapComposer gapComposer);

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        checkAddView();
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        return super.addViewInLayout(view, i, layoutParams);
    }

    public final void attachedToWindow() {
        if (isAttachedToWindow()) {
            setPreviousAttachedWindowToken(getWindowToken());
            if (this.composeViewContext == null) {
                AndroidComposeView androidComposeView = null;
                if (getChildCount() != 0) {
                    View childAt = getChildAt(0);
                    if (childAt instanceof AndroidComposeView) {
                        androidComposeView = (AndroidComposeView) childAt;
                    }
                }
                if (androidComposeView != null) {
                    androidComposeView.setComposeViewContext(updateAutoCreatedComposeViewContext(InvertMatrixKt.findViewTreeComposeViewRoot(this), androidComposeView.getComposeViewContext()));
                }
            }
            if (getShouldCreateCompositionOnAttachedToWindow()) {
                ensureCompositionCreated();
            }
        }
    }

    public final void checkAddView() {
        if (this.creatingComposition) {
            return;
        }
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    public final void createComposition() {
        ComposeViewContext composeViewContext;
        View view;
        if (this.parentContext == null && !isAttachedToWindow() && ((composeViewContext = this.composeViewContext) == null || (view = composeViewContext.view) == null || !view.isAttachedToWindow())) {
            throw new IllegalStateException("createComposition requires a previous call to createComposition(ComposeViewContext), a parent reference, or the View to be attached to a window. Attach the View or call setParentCompositionReference.");
        }
        ensureCompositionCreated();
    }

    public final void disposeComposition() {
        View childAt = getChildAt(0);
        AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
        if (androidComposeView != null && androidComposeView.composeViewContextIncrementedDuringInit) {
            androidComposeView.getComposeViewContext().decrementViewCount$ui();
            androidComposeView.composeViewContextIncrementedDuringInit = false;
        }
        WrappedComposition wrappedComposition = this.composition;
        if (wrappedComposition != null) {
            wrappedComposition.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    public final void ensureCompositionCreated() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                Trace.beginSection("Compose:initializeView");
                try {
                    ComposeViewContext composeViewContextResolveComposeViewContext = this.composeViewContext;
                    if (composeViewContextResolveComposeViewContext == null) {
                        composeViewContextResolveComposeViewContext = resolveComposeViewContext();
                    }
                    this.composition = Wrapper_androidKt.setContent(this, composeViewContextResolveComposeViewContext, new ComposableLambdaImpl(1003123809, new PopupLayout$Content$4(4, this), true));
                    Unit unit = Unit.INSTANCE;
                    Trace.endSection();
                    this.creatingComposition = false;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } catch (Throwable th2) {
                this.creatingComposition = false;
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: getAutoClearFocusBehavior-4UtRPd4, reason: not valid java name */
    public final int m583getAutoClearFocusBehavior4UtRPd4() {
        Object tag = getTag(R.id.auto_clear_focus_behavior_tag);
        AutoClearFocusBehavior autoClearFocusBehavior = tag instanceof AutoClearFocusBehavior ? (AutoClearFocusBehavior) tag : null;
        if (autoClearFocusBehavior != null) {
            return autoClearFocusBehavior.value;
        }
        return 1;
    }

    public final ComposeViewContext getComposeViewContext$ui() {
        return this.composeViewContext;
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void internalOnLayout$ui(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    public void internalOnMeasure$ui(int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i, i2);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(i2)));
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingBottom() + getPaddingTop() + childAt.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public final boolean isTransitionGroup() {
        return !this.isTransitionGroupSet || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MutableScatterMap mutableScatterMap = WindowRecomposer_androidKt.animationScale;
        Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(this);
        View view = this;
        while (parentOrViewTreeDisjointParent instanceof View) {
            View view2 = (View) parentOrViewTreeDisjointParent;
            if (view2.getId() == 16908290) {
                break;
            }
            view = view2;
            parentOrViewTreeDisjointParent = view2.getParent();
        }
        if (view.getParent() == null) {
            getHandler().postAtFrontOfQueue(new Preview$$ExternalSyntheticLambda0(27, this));
        } else {
            attachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        internalOnLayout$ui(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        ensureCompositionCreated();
        internalOnMeasure$ui(i, i2);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    public final ComposeViewContext resolveComposeViewContext() {
        ComposeViewContext composeViewContext;
        ViewModelStoreOwner viewModelStoreOwner;
        if (getChildCount() == 0) {
            composeViewContext = null;
        } else {
            View childAt = getChildAt(0);
            AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
            if (androidComposeView != null) {
                composeViewContext = androidComposeView.getComposeViewContext();
            } else {
                composeViewContext = null;
            }
        }
        View viewFindViewTreeComposeViewRoot = InvertMatrixKt.findViewTreeComposeViewRoot(this);
        ComposeViewContext composeViewContext2 = InvertMatrixKt.getComposeViewContext(viewFindViewTreeComposeViewRoot);
        if (composeViewContext2 != null) {
            return updateAutoCreatedComposeViewContext(viewFindViewTreeComposeViewRoot, composeViewContext2);
        }
        CompositionContext compositionContextResolveParentCompositionContext = resolveParentCompositionContext();
        LifecycleOwner lifecycleOwner = ViewModelKt.get(viewFindViewTreeComposeViewRoot);
        if (lifecycleOwner == null) {
            lifecycleOwner = composeViewContext != null ? composeViewContext.lifecycleOwner : null;
            if (lifecycleOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(viewFindViewTreeComposeViewRoot);
        if (savedStateRegistryOwner == null) {
            savedStateRegistryOwner = composeViewContext != null ? composeViewContext.savedStateRegistryOwner : null;
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeSavedStateRegistryOwner!");
            }
        }
        SavedStateRegistryOwner savedStateRegistryOwner2 = savedStateRegistryOwner;
        ViewModelStoreOwner viewModelStoreOwnerM774get = ViewModelKt.m774get(viewFindViewTreeComposeViewRoot);
        if (viewModelStoreOwnerM774get == null) {
            viewModelStoreOwner = composeViewContext != null ? composeViewContext.viewModelStoreOwner : null;
        } else {
            viewModelStoreOwner = viewModelStoreOwnerM774get;
        }
        ComposeViewContext composeViewContext3 = new ComposeViewContext(InvertMatrixKt.getComposeViewContext(InvertMatrixKt.findViewTreeComposeViewRoot(viewFindViewTreeComposeViewRoot)), viewFindViewTreeComposeViewRoot, compositionContextResolveParentCompositionContext, lifecycleOwner2, savedStateRegistryOwner2, viewModelStoreOwner);
        viewFindViewTreeComposeViewRoot.setTag(R.id.androidx_compose_ui_view_compose_view_context, new WeakReference(composeViewContext3));
        return composeViewContext3;
    }

    public final CompositionContext resolveParentCompositionContext() {
        final Recomposer recomposer;
        CoroutineContext coroutineContext;
        final BroadcastFrameClock broadcastFrameClock;
        Object parentOrViewTreeDisjointParent;
        CompositionContext compositionContext = this.parentContext;
        if (compositionContext == null) {
            compositionContext = WindowRecomposer_androidKt.getCompositionContext(this);
            if (compositionContext == null) {
                ViewParent parent = getParent();
                while (true) {
                    if (compositionContext != null || !(parentOrViewTreeDisjointParent instanceof View)) {
                        parentOrViewTreeDisjointParent = parent;
                        break;
                    }
                    parentOrViewTreeDisjointParent = parent;
                    View view = (View) parentOrViewTreeDisjointParent;
                    compositionContext = WindowRecomposer_androidKt.getCompositionContext(view);
                    parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
                }
            }
            boolean z = false;
            if (compositionContext != null) {
                CompositionContext compositionContext2 = (!(compositionContext instanceof Recomposer) || ((Recomposer.State) ((Recomposer) compositionContext)._state.getValue()).compareTo(Recomposer.State.ShuttingDown) > 0) ? compositionContext : null;
                if (compositionContext2 != null) {
                    this.cachedViewTreeCompositionContext = new WeakReference(compositionContext2);
                }
            } else {
                compositionContext = null;
            }
            if (compositionContext == null) {
                WeakReference weakReference = this.cachedViewTreeCompositionContext;
                if (weakReference == null || (compositionContext = (CompositionContext) weakReference.get()) == null || ((compositionContext instanceof Recomposer) && ((Recomposer.State) ((Recomposer) compositionContext)._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0)) {
                    compositionContext = null;
                }
                if (compositionContext == null) {
                    if (!isAttachedToWindow()) {
                        InlineClassHelperKt.throwIllegalStateException("Cannot locate windowRecomposer; View " + this + " is not attached to a window");
                    }
                    View view2 = this;
                    Object parent2 = ViewTree.getParentOrViewTreeDisjointParent(this);
                    while (parent2 instanceof View) {
                        View view3 = (View) parent2;
                        if (view3.getId() == 16908290) {
                            break;
                        }
                        view2 = view3;
                        parent2 = view3.getParent();
                    }
                    CompositionContext compositionContext3 = WindowRecomposer_androidKt.getCompositionContext(view2);
                    if (compositionContext3 == null) {
                        ((WindowRecomposerFactory$Companion$$ExternalSyntheticLambda0) WindowRecomposerPolicy.factory.get()).getClass();
                        CoroutineContext coroutineContext2 = EmptyCoroutineContext.INSTANCE;
                        SynchronizedLazyImpl synchronizedLazyImpl = AndroidUiDispatcher.Main$delegate;
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            coroutineContext = (CoroutineContext) AndroidUiDispatcher.Main$delegate.getValue();
                        } else {
                            coroutineContext = (CoroutineContext) AndroidUiDispatcher.currentThread.get();
                            if (coroutineContext == null) {
                                throw new IllegalStateException("no AndroidUiDispatcher for this thread");
                            }
                        }
                        CoroutineContext coroutineContextPlus = coroutineContext.plus(coroutineContext2);
                        BroadcastFrameClock broadcastFrameClock2 = (BroadcastFrameClock) coroutineContextPlus.get(NeverEqualPolicy.$$INSTANCE);
                        if (broadcastFrameClock2 != null) {
                            broadcastFrameClock = new BroadcastFrameClock(broadcastFrameClock2);
                            DiskLruCache.Editor editor = (DiskLruCache.Editor) broadcastFrameClock.queue;
                            synchronized (editor.entry) {
                                editor.closed = false;
                                Unit unit = Unit.INSTANCE;
                            }
                        } else {
                            broadcastFrameClock = null;
                        }
                        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                        CoroutineContext motionDurationScaleImpl = (MotionDurationScale) coroutineContextPlus.get(Alignment.Companion.$$INSTANCE);
                        if (motionDurationScaleImpl == null) {
                            motionDurationScaleImpl = new MotionDurationScaleImpl(view2.getContext().getApplicationContext());
                            ref$ObjectRef.element = motionDurationScaleImpl;
                        }
                        if (broadcastFrameClock != null) {
                            coroutineContext2 = broadcastFrameClock;
                        }
                        CoroutineContext coroutineContextPlus2 = coroutineContextPlus.plus(coroutineContext2).plus(motionDurationScaleImpl);
                        recomposer = new Recomposer(coroutineContextPlus2);
                        recomposer.pauseCompositionFrameClock();
                        final ContextScope contextScopeCoroutineScope = JobKt.CoroutineScope(coroutineContextPlus2);
                        LifecycleOwner lifecycleOwner = ViewModelKt.get(view2);
                        Lifecycle lifecycle = lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null;
                        if (lifecycle == null) {
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("ViewTreeLifecycleOwner not found from " + view2);
                            throw new HttpException();
                        }
                        view2.addOnAttachStateChangeListener(new FragmentLayoutInflaterFactory.AnonymousClass1(view2, recomposer));
                        lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2

                            /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                            public abstract /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[Lifecycle.Event.values().length];
                                    try {
                                        iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    try {
                                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                                    } catch (NoSuchFieldError unused4) {
                                    }
                                    try {
                                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
                                    } catch (NoSuchFieldError unused5) {
                                    }
                                    try {
                                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
                                    } catch (NoSuchFieldError unused6) {
                                    }
                                    try {
                                        iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
                                    } catch (NoSuchFieldError unused7) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            @Override // androidx.lifecycle.LifecycleEventObserver
                            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                                switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
                                    case 1:
                                        JobKt.launch$default(contextScopeCoroutineScope, null, new NavHostKt$NavHost$29$1(ref$ObjectRef, recomposer, lifecycleOwner2, this, null, 8), 1);
                                        return;
                                    case 2:
                                        BroadcastFrameClock broadcastFrameClock3 = broadcastFrameClock;
                                        if (broadcastFrameClock3 != null) {
                                            DiskLruCache.Editor editor2 = (DiskLruCache.Editor) broadcastFrameClock3.queue;
                                            synchronized (editor2.entry) {
                                                try {
                                                    if (!editor2.isOpen()) {
                                                        ArrayList arrayList = (ArrayList) editor2.written;
                                                        editor2.written = (ArrayList) editor2.this$0;
                                                        editor2.this$0 = arrayList;
                                                        editor2.closed = true;
                                                        int size = arrayList.size();
                                                        for (int i = 0; i < size; i++) {
                                                            ((Continuation) arrayList.get(i)).resumeWith(Unit.INSTANCE);
                                                        }
                                                        arrayList.clear();
                                                        Unit unit2 = Unit.INSTANCE;
                                                    }
                                                } catch (Throwable th) {
                                                    throw th;
                                                }
                                                break;
                                            }
                                        }
                                        recomposer.resumeCompositionFrameClock();
                                        return;
                                    case 3:
                                        recomposer.pauseCompositionFrameClock();
                                        return;
                                    case 4:
                                        recomposer.cancel();
                                        return;
                                    case 5:
                                    case 6:
                                    case 7:
                                        return;
                                    default:
                                        throw new HttpException();
                                }
                            }
                        });
                        view2.setTag(R.id.androidx_compose_ui_view_composition_context, recomposer);
                        GlobalScope globalScope = GlobalScope.INSTANCE;
                        Handler handler = view2.getHandler();
                        int i = HandlerDispatcherKt.$r8$clinit;
                        view2.addOnAttachStateChangeListener(new FragmentStateManager.AnonymousClass1(5, JobKt.launch$default(globalScope, new HandlerContext(handler, "windowRecomposer cleanup", false).immediate, new RealImageLoader$execute$3(recomposer, view2, z ? 1 : 0, 24), 2)));
                    } else {
                        if (!(compositionContext3 instanceof Recomposer)) {
                            throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer");
                        }
                        recomposer = (Recomposer) compositionContext3;
                    }
                    Recomposer recomposer2 = ((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) > 0 ? recomposer : null;
                    if (recomposer2 != null) {
                        this.cachedViewTreeCompositionContext = new WeakReference(recomposer2);
                    }
                    return recomposer;
                }
            }
        }
        return compositionContext;
    }

    /* JADX INFO: renamed from: setAutoClearFocusBehavior-17tfJxM, reason: not valid java name */
    public final void m584setAutoClearFocusBehavior17tfJxM(int i) {
        setTag(R.id.auto_clear_focus_behavior_tag, new AutoClearFocusBehavior(i));
    }

    public final void setComposeViewContext$ui(ComposeViewContext composeViewContext) {
        if (this.composeViewContext != composeViewContext) {
            if (composeViewContext == null) {
                disposeComposition();
            } else if (getChildCount() != 0) {
                View childAt = getChildAt(0);
                AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
                if (androidComposeView != null) {
                    if (androidComposeView.getCoroutineContext() != composeViewContext.compositionContext.getEffectCoroutineContext()) {
                        disposeComposition();
                    }
                    androidComposeView.setComposeViewContext(composeViewContext);
                }
            }
            this.composeViewContext = composeViewContext;
        }
    }

    public final void setParentCompositionContext(CompositionContext compositionContext) {
        setParentContext(compositionContext);
    }

    public final void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((AndroidComposeView) ((Owner) childAt)).setShowLayoutBounds(z);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean z) {
        super.setTransitionGroup(z);
        this.isTransitionGroupSet = true;
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy viewCompositionStrategy) {
        RealConnection$connectTls$1 realConnection$connectTls$1 = this.disposeViewCompositionStrategy;
        if (realConnection$connectTls$1 != null) {
            realConnection$connectTls$1.invoke();
        }
        ((InvertMatrixKt) viewCompositionStrategy).getClass();
        FragmentStateManager.AnonymousClass1 anonymousClass1 = new FragmentStateManager.AnonymousClass1(4, this);
        addOnAttachStateChangeListener(anonymousClass1);
        ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0 = new ZslControlImpl$$ExternalSyntheticLambda0(17);
        PoolingContainer.getPoolingContainerListenerHolder(this).listeners.add(zslControlImpl$$ExternalSyntheticLambda0);
        this.disposeViewCompositionStrategy = new RealConnection$connectTls$1(this, anonymousClass1, zslControlImpl$$ExternalSyntheticLambda0, 1);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final ComposeViewContext updateAutoCreatedComposeViewContext(View view, ComposeViewContext composeViewContext) {
        CompositionContext compositionContextResolveParentCompositionContext = resolveParentCompositionContext();
        LifecycleOwner lifecycleOwner = ViewModelKt.get(view);
        ViewModelStoreOwner viewModelStoreOwnerM774get = ViewModelKt.m774get(view);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(view);
        CompositionContext compositionContext = composeViewContext.compositionContext;
        SavedStateRegistryOwner savedStateRegistryOwner2 = composeViewContext.savedStateRegistryOwner;
        LifecycleOwner lifecycleOwner2 = composeViewContext.lifecycleOwner;
        if (compositionContextResolveParentCompositionContext == compositionContext && lifecycleOwner == lifecycleOwner2 && viewModelStoreOwnerM774get == composeViewContext.viewModelStoreOwner && savedStateRegistryOwner == savedStateRegistryOwner2) {
            return composeViewContext;
        }
        if (compositionContextResolveParentCompositionContext.getEffectCoroutineContext() != composeViewContext.compositionContext.getEffectCoroutineContext()) {
            disposeComposition();
        }
        if (lifecycleOwner == null) {
            lifecycleOwner = lifecycleOwner2;
        }
        ComposeViewContext composeViewContext2 = new ComposeViewContext(composeViewContext, view, compositionContextResolveParentCompositionContext, lifecycleOwner, savedStateRegistryOwner == null ? savedStateRegistryOwner2 : savedStateRegistryOwner, viewModelStoreOwnerM774get);
        view.setTag(R.id.androidx_compose_ui_view_compose_view_context, new WeakReference(composeViewContext2));
        return composeViewContext2;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        checkAddView();
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        checkAddView();
        return super.addViewInLayout(view, i, layoutParams, z);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i2) {
        checkAddView();
        super.addView(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, i, layoutParams);
    }

    public static /* synthetic */ void getComposeViewContext$ui$annotations() {
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }
}
