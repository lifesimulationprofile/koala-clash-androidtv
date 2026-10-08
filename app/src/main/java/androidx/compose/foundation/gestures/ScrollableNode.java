package androidx.compose.foundation.gestures;

import android.os.Build;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.EdgeEffect;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.view.PreviewView;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.Api31Impl;
import androidx.compose.foundation.EdgeEffectWrapper;
import androidx.compose.foundation.GestureNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.RealImageLoader$execute$3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableNode extends DragGestureNode implements KeyInputModifierNode, SemanticsModifierNode {
    public final ContentInViewNode contentInViewNode;
    public final DefaultFlingBehavior defaultFlingBehavior;
    public FlingBehavior flingBehavior;
    public final FocusTargetNode focusTargetModifierNode;
    public MouseWheelScrollingLogic mouseWheelScrollingLogic;
    public final ScrollableNestedScrollConnection nestedScrollConnection;
    public final Dispatcher nestedScrollDispatcher;
    public AndroidEdgeEffectOverscrollEffect overscrollEffect;
    public Updater$$ExternalSyntheticLambda0 scrollByAction;
    public ScrollableNode$onKeyEvent$1 scrollByOffsetAction;
    public final ScrollingLogic scrollingLogic;
    public TrackpadScrollingLogic trackpadScrollingLogic;

    public ScrollableNode(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, FlingBehavior flingBehavior, Orientation orientation, ScrollableState scrollableState, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, boolean z2) {
        super(ScrollableKt.CanDragCalculation, z, mutableInteractionSourceImpl, orientation);
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.flingBehavior = flingBehavior;
        Dispatcher dispatcher = new Dispatcher(8);
        this.nestedScrollDispatcher = dispatcher;
        DefaultFlingBehavior defaultFlingBehavior = new DefaultFlingBehavior(new DecayAnimationSpecImpl(new Toolbar.AnonymousClass1(ScrollableKt.UnityDensity)));
        this.defaultFlingBehavior = defaultFlingBehavior;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2 = this.overscrollEffect;
        FlingBehavior flingBehavior2 = this.flingBehavior;
        ScrollingLogic scrollingLogic = new ScrollingLogic(scrollableState, androidEdgeEffectOverscrollEffect2, flingBehavior2 == null ? defaultFlingBehavior : flingBehavior2, orientation, z2, dispatcher, this, new ScrollableNode$$ExternalSyntheticLambda0(this, 0));
        this.scrollingLogic = scrollingLogic;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection = new ScrollableNestedScrollConnection(scrollingLogic, z);
        this.nestedScrollConnection = scrollableNestedScrollConnection;
        FocusTargetNode focusTargetNode = new FocusTargetNode(2, null, 10);
        delegate(focusTargetNode);
        this.focusTargetModifierNode = focusTargetNode;
        ContentInViewNode contentInViewNode = new ContentInViewNode(orientation, scrollingLogic, z2, new ScrollableNode$$ExternalSyntheticLambda0(this, 1));
        delegate(contentInViewNode);
        this.contentInViewNode = contentInViewNode;
        delegate(new NestedScrollNode(scrollableNestedScrollConnection, dispatcher));
        BringIntoViewResponderNode bringIntoViewResponderNode = new BringIntoViewResponderNode();
        bringIntoViewResponderNode.responder = contentInViewNode;
        delegate(bringIntoViewResponderNode);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.enabled && (this.scrollByAction == null || this.scrollByOffsetAction == null)) {
            this.scrollByAction = new Updater$$ExternalSyntheticLambda0(3, this);
            this.scrollByOffsetAction = new ScrollableNode$onKeyEvent$1(this, null);
        }
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = this.scrollByAction;
        if (updater$$ExternalSyntheticLambda0 != null) {
            KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
            semanticsPropertyReceiver.set(SemanticsActions.ScrollBy, new AccessibilityAction(null, updater$$ExternalSyntheticLambda0));
        }
        ScrollableNode$onKeyEvent$1 scrollableNode$onKeyEvent$1 = this.scrollByOffsetAction;
        if (scrollableNode$onKeyEvent$1 != null) {
            KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
            semanticsPropertyReceiver.set(SemanticsActions.ScrollByOffset, scrollableNode$onKeyEvent$1);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final Object drag(DragGestureNode.AnonymousClass1 anonymousClass1, DragGestureNode.AnonymousClass1 anonymousClass2) {
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        Object objScroll = scrollingLogic.scroll(MutatePriority.UserInput, new NavHostKt$NavHost$28$1(anonymousClass1, scrollingLogic, (Continuation) null, 11), anonymousClass2);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return true;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        if (this.isAttached) {
            Density density = HitTestResultKt.requireLayoutNode(this).density;
            DefaultFlingBehavior defaultFlingBehavior = this.defaultFlingBehavior;
            defaultFlingBehavior.getClass();
            defaultFlingBehavior.flingDecay = new DecayAnimationSpecImpl(new Toolbar.AnonymousClass1(density));
        }
        MouseWheelScrollingLogic mouseWheelScrollingLogic = this.mouseWheelScrollingLogic;
        if (mouseWheelScrollingLogic != null) {
            mouseWheelScrollingLogic.density = HitTestResultKt.requireLayoutNode(this).density;
        }
        TrackpadScrollingLogic trackpadScrollingLogic = this.trackpadScrollingLogic;
        if (trackpadScrollingLogic != null) {
            trackpadScrollingLogic.density = HitTestResultKt.requireLayoutNode(this).density;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDensityChange() {
        onCancelPointerInput();
        if (this.isAttached) {
            Density density = HitTestResultKt.requireLayoutNode(this).density;
            DefaultFlingBehavior defaultFlingBehavior = this.defaultFlingBehavior;
            defaultFlingBehavior.getClass();
            defaultFlingBehavior.flingDecay = new DecayAnimationSpecImpl(new Toolbar.AnonymousClass1(density));
        }
        MouseWheelScrollingLogic mouseWheelScrollingLogic = this.mouseWheelScrollingLogic;
        if (mouseWheelScrollingLogic != null) {
            mouseWheelScrollingLogic.density = HitTestResultKt.requireLayoutNode(this).density;
        }
        TrackpadScrollingLogic trackpadScrollingLogic = this.trackpadScrollingLogic;
        if (trackpadScrollingLogic != null) {
            trackpadScrollingLogic.density = HitTestResultKt.requireLayoutNode(this).density;
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final void onDragStopped(DragEvent.DragStopped dragStopped) {
        JobKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, new RealImageLoader$execute$3(dragStopped, this, null, 8), 3);
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    public final boolean mo35onKeyEventZmokQxo(KeyEvent keyEvent) {
        long jFloatToRawIntBits;
        int iFloatToRawIntBits;
        if (!this.enabled) {
            return false;
        }
        if ((!Key.m504equalsimpl0(Key_androidKt.m505getKeyZmokQxo(keyEvent), Key.PageDown) && !Key.m504equalsimpl0(Key_androidKt.Key(keyEvent.getKeyCode()), Key.PageUp)) || Key_androidKt.m506getTypeZmokQxo(keyEvent) != 2 || keyEvent.isCtrlPressed()) {
            return false;
        }
        Orientation orientation = this.scrollingLogic.orientation;
        Orientation orientation2 = Orientation.Vertical;
        ContentInViewNode contentInViewNode = this.contentInViewNode;
        if (orientation == orientation2) {
            int iM64getViewportSizeOrZeroYbymL2g$foundation = (int) (contentInViewNode.m64getViewportSizeOrZeroYbymL2g$foundation() & 4294967295L);
            float f = Key.m504equalsimpl0(Key_androidKt.Key(keyEvent.getKeyCode()), Key.PageUp) ? iM64getViewportSizeOrZeroYbymL2g$foundation : -iM64getViewportSizeOrZeroYbymL2g$foundation;
            jFloatToRawIntBits = Float.floatToRawIntBits(0.0f);
            iFloatToRawIntBits = Float.floatToRawIntBits(f);
        } else {
            int iM64getViewportSizeOrZeroYbymL2g$foundation2 = (int) (contentInViewNode.m64getViewportSizeOrZeroYbymL2g$foundation() >> 32);
            jFloatToRawIntBits = Float.floatToRawIntBits(Key.m504equalsimpl0(Key_androidKt.Key(keyEvent.getKeyCode()), Key.PageUp) ? iM64getViewportSizeOrZeroYbymL2g$foundation2 : -iM64getViewportSizeOrZeroYbymL2g$foundation2);
            iFloatToRawIntBits = Float.floatToRawIntBits(0.0f);
        }
        JobKt.launch$default(getCoroutineScope(), null, new ScrollableNode$onKeyEvent$1(this, (jFloatToRawIntBits << 32) | (((long) iFloatToRawIntBits) & 4294967295L), null, 0), 3);
        return true;
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo36onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        PointerEventPass pointerEventPass2;
        PointerEventPass pointerEventPass3;
        int i;
        ?? r10 = pointerEvent.changes;
        int size = r10.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((Boolean) this.canDrag.invoke(new PointerType(((PointerInputChange) r10.get(i2)).type))).booleanValue()) {
                super.mo36onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
                break;
            }
        }
        if (this.gestureNode == null) {
            GestureNode gestureNode = new GestureNode(this);
            delegate(gestureNode);
            this.gestureNode = gestureNode;
        }
        if (this.enabled) {
            Continuation continuation = null;
            ScrollingLogic scrollingLogic = this.scrollingLogic;
            PointerEventPass pointerEventPass4 = PointerEventPass.Initial;
            if (pointerEventPass == pointerEventPass4 && pointerEvent.type == 6) {
                if (this.mouseWheelScrollingLogic == null) {
                    pointerEventPass2 = pointerEventPass4;
                    this.mouseWheelScrollingLogic = new MouseWheelScrollingLogic(scrollingLogic, new PreviewView.AnonymousClass1(24, ViewConfiguration.get(HitTestResultKt.requireView(this).getContext())), new ComposableLambdaImpl.AnonymousClass1(2, this, ScrollableNode.class, "onWheelScrollStopped", "onWheelScrollStopped-TH1AsA0(J)V", 4, 1), HitTestResultKt.requireLayoutNode(this).density);
                } else {
                    pointerEventPass2 = pointerEventPass4;
                }
                MouseWheelScrollingLogic mouseWheelScrollingLogic = this.mouseWheelScrollingLogic;
                if (mouseWheelScrollingLogic != null) {
                    CoroutineScope coroutineScope = getCoroutineScope();
                    if (mouseWheelScrollingLogic.receivingMouseWheelEventsJob == null) {
                        mouseWheelScrollingLogic.receivingMouseWheelEventsJob = JobKt.launch$default(coroutineScope, null, new RealImageLoader$execute$3(mouseWheelScrollingLogic, continuation, 5), 3);
                    }
                }
            } else {
                pointerEventPass2 = pointerEventPass4;
            }
            MouseWheelScrollingLogic mouseWheelScrollingLogic2 = this.mouseWheelScrollingLogic;
            PointerEventPass pointerEventPass5 = PointerEventPass.Main;
            if (mouseWheelScrollingLogic2 == null || pointerEvent.type != 6) {
                pointerEventPass3 = pointerEventPass2;
                break;
            }
            int size2 = r10.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size2) {
                    pointerEventPass3 = pointerEventPass2;
                    if (pointerEventPass == pointerEventPass3 && mouseWheelScrollingLogic2.isScrolling) {
                        mouseWheelScrollingLogic2.m85onMouseWheelO0kMr_c(pointerEvent);
                        NonTouchScrollingLogic.consume$foundation(pointerEvent);
                    }
                    if (pointerEventPass != pointerEventPass5 || mouseWheelScrollingLogic2.isScrolling || !mouseWheelScrollingLogic2.m85onMouseWheelO0kMr_c(pointerEvent)) {
                        break;
                        break;
                        break;
                    } else {
                        NonTouchScrollingLogic.consume$foundation(pointerEvent);
                        break;
                    }
                }
                if (((PointerInputChange) r10.get(i3)).isConsumed()) {
                    pointerEventPass3 = pointerEventPass2;
                    break;
                }
                i3++;
            }
            if (pointerEventPass == pointerEventPass3 && ((i = pointerEvent.type) == 10 || i == 11 || i == 12)) {
                if (this.trackpadScrollingLogic == null) {
                    this.trackpadScrollingLogic = new TrackpadScrollingLogic(scrollingLogic, new ComposableLambdaImpl.AnonymousClass1(2, this, ScrollableNode.class, "onTrackpadScrollStopped", "onTrackpadScrollStopped-TH1AsA0(J)V", 4, 2), HitTestResultKt.requireLayoutNode(this).density);
                }
                TrackpadScrollingLogic trackpadScrollingLogic = this.trackpadScrollingLogic;
                if (trackpadScrollingLogic != null) {
                    CoroutineScope coroutineScope2 = getCoroutineScope();
                    if (trackpadScrollingLogic.receivingPanEventsJob == null) {
                        trackpadScrollingLogic.receivingPanEventsJob = JobKt.launch$default(coroutineScope2, null, new NavHostKt$NavHost$29$1(trackpadScrollingLogic, continuation, 3), 3);
                    }
                }
            }
            TrackpadScrollingLogic trackpadScrollingLogic2 = this.trackpadScrollingLogic;
            if (trackpadScrollingLogic2 != null) {
                int i4 = pointerEvent.type;
                if (i4 == 10 || i4 == 11 || i4 == 12) {
                    int size3 = r10.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        if (((PointerInputChange) r10.get(i5)).isConsumed()) {
                            return;
                        }
                    }
                    if (pointerEventPass == pointerEventPass3 && trackpadScrollingLogic2.isScrolling) {
                        trackpadScrollingLogic2.onPan(pointerEvent);
                        NonTouchScrollingLogic.consume$foundation(pointerEvent);
                    }
                    if (pointerEventPass == pointerEventPass5 && !trackpadScrollingLogic2.isScrolling && trackpadScrollingLogic2.onPan(pointerEvent)) {
                        NonTouchScrollingLogic.consume$foundation(pointerEvent);
                    }
                }
            }
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    public final boolean mo37onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public final boolean startDragImmediately() {
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        if (scrollingLogic.scrollableState.isScrollInProgress()) {
            return true;
        }
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = scrollingLogic.overscrollEffect;
        if (androidEdgeEffectOverscrollEffect == null) {
            return false;
        }
        EdgeEffectWrapper edgeEffectWrapper = androidEdgeEffectOverscrollEffect.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? Api31Impl.getDistance(edgeEffect) : 0.0f) != 0.0f) {
                return true;
            }
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? Api31Impl.getDistance(edgeEffect2) : 0.0f) != 0.0f) {
                return true;
            }
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            if ((Build.VERSION.SDK_INT >= 31 ? Api31Impl.getDistance(edgeEffect3) : 0.0f) != 0.0f) {
                return true;
            }
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            return (Build.VERSION.SDK_INT >= 31 ? Api31Impl.getDistance(edgeEffect4) : 0.0f) != 0.0f;
        }
        return false;
    }

    public final void update(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, FlingBehavior flingBehavior, Orientation orientation, ScrollableState scrollableState, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        if (this.enabled != z) {
            this.nestedScrollConnection.enabled = z;
            z3 = true;
        } else {
            z3 = false;
        }
        FlingBehavior flingBehavior2 = flingBehavior == null ? this.defaultFlingBehavior : flingBehavior;
        ScrollingLogic scrollingLogic = this.scrollingLogic;
        if (!Intrinsics.areEqual(scrollingLogic.scrollableState, scrollableState)) {
            scrollingLogic.scrollableState = scrollableState;
            z5 = true;
        }
        scrollingLogic.overscrollEffect = androidEdgeEffectOverscrollEffect;
        if (scrollingLogic.orientation != orientation) {
            scrollingLogic.orientation = orientation;
            z5 = true;
        }
        if (scrollingLogic.reverseDirection != z2) {
            scrollingLogic.reverseDirection = z2;
        } else {
            z4 = z5;
        }
        scrollingLogic.flingBehavior = flingBehavior2;
        scrollingLogic.nestedScrollDispatcher = this.nestedScrollDispatcher;
        ContentInViewNode contentInViewNode = this.contentInViewNode;
        contentInViewNode.orientation = orientation;
        contentInViewNode.reverseDirection = z2;
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.flingBehavior = flingBehavior;
        BasicTextKt$$ExternalSyntheticLambda3 basicTextKt$$ExternalSyntheticLambda3 = ScrollableKt.CanDragCalculation;
        Orientation orientation2 = scrollingLogic.orientation;
        Orientation orientation3 = Orientation.Vertical;
        if (orientation2 != orientation3) {
            orientation3 = Orientation.Horizontal;
        }
        update(basicTextKt$$ExternalSyntheticLambda3, z, mutableInteractionSourceImpl, orientation3, z4);
        if (z3) {
            this.scrollByAction = null;
            this.scrollByOffsetAction = null;
            HitTestResultKt.invalidateSemantics(this);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public final void mo61onDragStartedk4lQ0M(long j) {
    }
}
