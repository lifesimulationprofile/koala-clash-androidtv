package androidx.activity.compose;

import android.view.View;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.GestureConnection;
import androidx.compose.foundation.gestures.AnchoredDraggableNode;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.layout.OffsetPxNode;
import androidx.compose.foundation.layout.PaddingNode;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.style.StyleAnimations;
import androidx.compose.foundation.style.StyleOuterNode;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.MultiSelectionLayout;
import androidx.compose.foundation.text.selection.SelectableInfo;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.spatial.ThrottledCallbacks;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.compose.NavHostKt$NavHost$26$1$invoke$$inlined$onDispose$1;
import androidx.navigation.compose.NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.RealImageLoader$execute$3;
import coil.disk.DiskLruCache;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BackHandlerKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ BackHandlerKt$$ExternalSyntheticLambda2(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean zBooleanValue;
        StyleAnimations styleAnimations;
        switch (this.$r8$classId) {
            case 0:
                BackHandlerDispatcherCompat backHandlerDispatcherCompat = (BackHandlerDispatcherCompat) this.f$0;
                ComposeBackHandler composeBackHandler = (ComposeBackHandler) this.f$1;
                backHandlerDispatcherCompat.addHandler(composeBackHandler);
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(1, backHandlerDispatcherCompat, composeBackHandler);
            case 1:
                BackHandlerDispatcherCompat backHandlerDispatcherCompat2 = (BackHandlerDispatcherCompat) this.f$0;
                ComposePredictiveBackHandler composePredictiveBackHandler = (ComposePredictiveBackHandler) this.f$1;
                backHandlerDispatcherCompat2.addHandler(composePredictiveBackHandler);
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(2, backHandlerDispatcherCompat2, composePredictiveBackHandler);
            case 2:
                InfiniteTransition infiniteTransition = (InfiniteTransition) this.f$0;
                InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) this.f$1;
                infiniteTransition._animations.add(transitionAnimationState);
                infiniteTransition.refreshChildNeeded$delegate.setValue(Boolean.TRUE);
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(3, infiniteTransition, transitionAnimationState);
            case 3:
                JobKt.launch$default((CoroutineScope) this.f$0, null, new NavHostKt$NavHost$29$1.AnonymousClass1.C00041((Transition) this.f$1, null), 1);
                return new NavHostKt$NavHost$26$1$invoke$$inlined$onDispose$1(1);
            case 4:
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(5, (Transition) this.f$0, (Transition.DeferredAnimation) this.f$1);
            case 5:
                Lifecycle lifecycle = (Lifecycle) this.f$0;
                ((SeekableTransitionState) lifecycle).setSnapshotStateObserver$animation_core(new SnapshotStateObserver(new BackHandlerKt$$ExternalSyntheticLambda2(7, Thread.currentThread(), (CoroutineScope) this.f$1)));
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(2, lifecycle);
            case 6:
                Transition transition = (Transition) this.f$0;
                Transition transition2 = (Transition) this.f$1;
                transition._transitions.add(transition2);
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(4, transition, transition2);
            case 7:
                CoroutineScope coroutineScope = (CoroutineScope) this.f$1;
                Function0 function0 = (Function0) obj;
                if (this.f$0 == Thread.currentThread()) {
                    function0.invoke();
                } else {
                    JobKt.launch$default(coroutineScope, null, new DiskLruCache.AnonymousClass1(function0, null, 1), 3);
                }
                return Unit.INSTANCE;
            case 8:
                Transition transition3 = (Transition) this.f$0;
                Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) this.f$1;
                transition3._animations.add(transitionAnimationState2);
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(6, transition3, transitionAnimationState2);
            case 9:
                ((MutableInteractionSourceImpl) this.f$0).tryEmit((PressInteraction.Cancel) this.f$1);
                return Unit.INSTANCE;
            case 10:
                AndroidPath androidPath = (AndroidPath) this.f$0;
                Brush brush = (Brush) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                Modifier.CC.m312drawPathGBMwjPU$default(layoutNodeDrawScope, androidPath, brush, 0.0f, null, null, 0, 60);
                return Unit.INSTANCE;
            case 11:
                Outline$Generic outline$Generic = (Outline$Generic) this.f$0;
                Brush brush2 = (Brush) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope2 = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope2.drawContent();
                Modifier.CC.m312drawPathGBMwjPU$default(layoutNodeDrawScope2, outline$Generic.path, brush2, 0.0f, null, null, 0, 60);
                return Unit.INSTANCE;
            case 12:
                IndirectPointerInputChange indirectPointerInputChange = (IndirectPointerInputChange) this.f$0;
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) this.f$1;
                boolean z = ref$BooleanRef.element || ((GestureConnection) obj).isInterested(indirectPointerInputChange);
                ref$BooleanRef.element = z;
                return Boolean.valueOf(!z);
            case 13:
                PointerInputChange pointerInputChange = (PointerInputChange) this.f$0;
                Ref$BooleanRef ref$BooleanRef2 = (Ref$BooleanRef) this.f$1;
                boolean z2 = ref$BooleanRef2.element || ((GestureConnection) obj).isInterested(pointerInputChange);
                ref$BooleanRef2.element = z2;
                return Boolean.valueOf(!z2);
            case 14:
                ((MutableInteractionSourceImpl) this.f$0).tryEmit((Interaction) this.f$1);
                return Unit.INSTANCE;
            case 15:
                AnchoredDraggableNode anchoredDraggableNode = (AnchoredDraggableNode) this.f$0;
                AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = (AnchoredDraggableState$anchoredDragScope$1) this.f$1;
                long j = ((DragEvent.DragDelta) obj).delta;
                Boolean bool = anchoredDraggableNode.reverseDirection;
                if (bool == null) {
                    zBooleanValue = HitTestResultKt.requireLayoutNode(anchoredDraggableNode).layoutDirection == LayoutDirection.Rtl && anchoredDraggableNode.orientation == Orientation.Horizontal;
                } else {
                    zBooleanValue = bool.booleanValue();
                }
                long jM374timestuRUvjQ = Offset.m374timestuRUvjQ(zBooleanValue ? -1.0f : 1.0f, j);
                anchoredDraggableState$anchoredDragScope$1.dragTo(anchoredDraggableNode.state.newOffsetForDelta$foundation(Float.intBitsToFloat((int) (anchoredDraggableNode.orientation == Orientation.Vertical ? jM374timestuRUvjQ & 4294967295L : jM374timestuRUvjQ >> 32))), 0.0f);
                return Unit.INSTANCE;
            case 16:
                ((MutableVector) ((Toolbar.AnonymousClass1) this.f$0).this$0).remove((ContentInViewNode.Request) this.f$1);
                return Unit.INSTANCE;
            case 17:
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) this.f$0;
                ScrollingLogic scrollingLogic = (ScrollingLogic) this.f$1;
                DragEvent.DragDelta dragDelta = (DragEvent.DragDelta) obj;
                float f = dragDelta.isIndirectPointerEvent ? -1.0f : 1.0f;
                long j2 = dragDelta.delta;
                scrollingLogic$nestedScrollScope$1.m110scrollByWithOverscrollOzD1aCk(1, Offset.m374timestuRUvjQ(f, scrollingLogic.orientation == Orientation.Horizontal ? Offset.m368copydBAh8RU$default(0.0f, 1, j2) : Offset.m368copydBAh8RU$default(0.0f, 2, j2)));
                return Unit.INSTANCE;
            case 18:
                UpdatableAnimationState updatableAnimationState = (UpdatableAnimationState) this.f$0;
                Function1 function1 = (Function1) this.f$1;
                ((Long) obj).longValue();
                float f2 = updatableAnimationState.value;
                updatableAnimationState.value = 0.0f;
                function1.invoke(Float.valueOf(f2));
                return Unit.INSTANCE;
            case 19:
                OffsetPxNode offsetPxNode = (OffsetPxNode) this.f$0;
                Placeable placeable = (Placeable) this.f$1;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                long j3 = ((IntOffset) offsetPxNode.offset.invoke(placementScope)).packedValue;
                if (offsetPxNode.rtlAware) {
                    Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable, (int) (j3 >> 32), (int) (4294967295L & j3), null, 12);
                } else {
                    Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, (int) (j3 >> 32), (int) (4294967295L & j3), null, 12);
                }
                return Unit.INSTANCE;
            case 20:
                PaddingNode paddingNode = (PaddingNode) this.f$0;
                Placeable placeable2 = (Placeable) this.f$1;
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                if (paddingNode.rtlAware) {
                    float f3 = paddingNode.start;
                    placementScope2.getClass();
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, Density.CC.m695$default$roundToPx0680j_4(placementScope2, f3), Density.CC.m695$default$roundToPx0680j_4(placementScope2, paddingNode.top));
                } else {
                    float f4 = paddingNode.start;
                    placementScope2.getClass();
                    Placeable.PlacementScope.place$default(placementScope2, placeable2, Density.CC.m695$default$roundToPx0680j_4(placementScope2, f4), Density.CC.m695$default$roundToPx0680j_4(placementScope2, paddingNode.top));
                }
                return Unit.INSTANCE;
            case 21:
                WindowInsetsHolder windowInsetsHolder = (WindowInsetsHolder) this.f$0;
                View view = (View) this.f$1;
                windowInsetsHolder.incrementAccessors(view);
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(7, windowInsetsHolder, view);
            case 22:
                AwaitFirstLayoutModifier.Node node = (AwaitFirstLayoutModifier.Node) this.f$0;
                AwaitFirstLayoutModifier awaitFirstLayoutModifier = (AwaitFirstLayoutModifier) this.f$1;
                ThrottledCallbacks.Entry entry = node.handle;
                if (entry != null) {
                    entry.unregister();
                }
                node.handle = null;
                CompletableDeferredImpl completableDeferredImpl = awaitFirstLayoutModifier.lock;
                if (completableDeferredImpl != null) {
                    completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
                }
                awaitFirstLayoutModifier.lock = null;
                return Unit.INSTANCE;
            case 23:
                LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) this.f$0;
                MutableScatterSet mutableScatterSet = lazySaveableStateHolder.previouslyComposedKeys;
                Object obj2 = this.f$1;
                mutableScatterSet.minusAssign(obj2);
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(8, lazySaveableStateHolder, obj2);
            case 24:
                return new LazySaveableStateHolder((SaveableStateRegistry) this.f$0, (Map) obj, (SaveableStateHolder) this.f$1);
            case 25:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.f$0;
                StyleOuterNode styleOuterNode = (StyleOuterNode) this.f$1;
                TraversableNode traversableNode = (TraversableNode) obj;
                if (traversableNode instanceof StyleOuterNode) {
                    StyleOuterNode styleOuterNode2 = (StyleOuterNode) traversableNode;
                    if ((styleOuterNode2._resolved.flags & 96) != 0 || ((styleAnimations = styleOuterNode2.animations) != null && styleAnimations.size > 0)) {
                        MutableObjectList mutableObjectList = (MutableObjectList) ref$ObjectRef.element;
                        if (mutableObjectList == null) {
                            mutableObjectList = new MutableObjectList();
                            ref$ObjectRef.element = mutableObjectList;
                            styleOuterNode.ancestorNodes = mutableObjectList;
                        }
                        mutableObjectList.add(traversableNode);
                    }
                }
                return Boolean.TRUE;
            case 26:
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.f$0;
                Brush brush3 = (Brush) this.f$1;
                LayoutNodeDrawScope layoutNodeDrawScope3 = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope3.drawContent();
                if (((Boolean) legacyTextFieldState.autofillHighlightOn$delegate.getValue()).booleanValue() || ((Boolean) legacyTextFieldState.justAutofilled$delegate.getValue()).booleanValue()) {
                    Modifier.CC.m314drawRectAsUm42w$default(layoutNodeDrawScope3, brush3, 0L, 0L, 0.0f, null, null, 0, 126);
                }
                return Unit.INSTANCE;
            case 27:
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(9, (MutableState) this.f$0, (MutableInteractionSourceImpl) this.f$1);
            case 28:
                SelectableInfo selectableInfo = (SelectableInfo) obj;
                MultiSelectionLayout.createAndPutSubSelection((MutableLongObjectMap) this.f$0, (Selection) this.f$1, selectableInfo, 0, selectableInfo.textLayoutResult.layoutInput.text.text.length());
                return Unit.INSTANCE;
            default:
                JobKt.launch$default((CoroutineScope) this.f$0, null, new RealImageLoader$execute$3((Clipboard) this.f$1, (AnnotatedString) obj, null, 17), 1);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ BackHandlerKt$$ExternalSyntheticLambda2(MultiSelectionLayout multiSelectionLayout, MutableLongObjectMap mutableLongObjectMap, Selection selection) {
        this.$r8$classId = 28;
        this.f$0 = mutableLongObjectMap;
        this.f$1 = selection;
    }
}
