package androidx.navigation;

import android.os.CancellationSignal;
import android.os.Looper;
import android.view.Choreographer;
import android.view.View;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.compose.animation.ContentTransform;
import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.foundation.text.input.internal.RecordingInputConnection;
import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.graphics.BlockGraphicsLayerModifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.SimpleGraphicsLayerModifier;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.WeakReference;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.platform.AndroidUiDispatcher;
import androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1;
import androidx.compose.ui.platform.ComposeViewContext;
import androidx.compose.ui.platform.InputMethodSession;
import androidx.compose.ui.platform.WrappedComposition;
import androidx.compose.ui.text.input.NullableInputConnectionWrapperApi21;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1;
import androidx.compose.ui.window.PopupLayout;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.NavHostKt$NavHost$26$1$invoke$$inlined$onDispose$1;
import androidx.navigation.compose.NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavController$handleDeepLink$2 extends Lambda implements Function1 {
    public final /* synthetic */ Object $node;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavController$handleDeepLink$2(int i, Object obj, Object obj2) {
        super(1);
        this.$r8$classId = i;
        this.$node = obj;
        this.this$0 = obj2;
    }

    private final Object invoke$androidx$compose$ui$platform$AndroidUiFrameClock$withFrameNanos$2$1(Object obj) {
        AndroidUiDispatcher androidUiDispatcher = (AndroidUiDispatcher) this.$node;
        AndroidUiFrameClock$withFrameNanos$2$callback$1 androidUiFrameClock$withFrameNanos$2$callback$1 = (AndroidUiFrameClock$withFrameNanos$2$callback$1) this.this$0;
        synchronized (androidUiDispatcher.lock) {
            androidUiDispatcher.toRunOnFrame.remove(androidUiFrameClock$withFrameNanos$2$callback$1);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        RecordingInputConnection recordingInputConnection;
        Lifecycle lifecycle;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                NavOptionsBuilder navOptionsBuilder = (NavOptionsBuilder) obj;
                NavHostController navHostController = (NavHostController) this.this$0;
                Unit unit = Unit.INSTANCE;
                NavOptions.Builder builder = navOptionsBuilder.builder;
                builder.enterAnim = 0;
                builder.exitAnim = 0;
                NavDestination navDestination = (NavDestination) this.$node;
                if (navDestination instanceof NavGraph) {
                    int i2 = NavDestination.$r8$clinit;
                    for (NavDestination navDestination2 : SequencesKt.generateSequence(navDestination, NavController$activity$1.INSTANCE$5)) {
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) navHostController.backQueue.lastOrNull();
                        NavDestination navDestination3 = navBackStackEntry != null ? navBackStackEntry.destination : null;
                        if (Intrinsics.areEqual(navDestination2, navDestination3 != null ? navDestination3.parent : null)) {
                        }
                    }
                    int i3 = NavGraph.$r8$clinit;
                    NavGraph navGraph = navHostController._graph;
                    if (navGraph == null) {
                        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
                    }
                    navOptionsBuilder.popUpToId = NavGraph.Companion.findStartDestination(navGraph).id;
                    Unit unit2 = Unit.INSTANCE;
                    navOptionsBuilder.saveState = true;
                }
                return Unit.INSTANCE;
            case 1:
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                Placeable placeable = (Placeable) this.$node;
                float floatValue = ((ContentTransform) this.this$0).targetContentZIndex$delegate.getFloatValue();
                placementScope.getClass();
                long j = 0;
                Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
                placeable.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY((j & 4294967295L) | (j << 32), placeable.apparentToRealOffset), floatValue, null);
                return Unit.INSTANCE;
            case 2:
                Placeable.PlacementScope.placeWithLayer$default((Placeable.PlacementScope) obj, (Placeable) this.$node, 0, 0, ((BlockGraphicsLayerModifier) this.this$0).layerBlock, 4);
                return Unit.INSTANCE;
            case 3:
                Placeable.PlacementScope.placeWithLayer$default((Placeable.PlacementScope) obj, (Placeable) this.$node, 0, 0, ((SimpleGraphicsLayerModifier) this.this$0).layerBlock, 4);
                return Unit.INSTANCE;
            case 4:
                DrawScope drawScope = (DrawScope) obj;
                CanvasDrawScope canvasDrawScope = (CanvasDrawScope) this.$node;
                Density density = drawScope.getDrawContext().getDensity();
                LayoutDirection layoutDirection = drawScope.getDrawContext().getLayoutDirection();
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                long jM756getSizeNHjbRc = drawScope.getDrawContext().m756getSizeNHjbRc();
                GraphicsLayer graphicsLayer = (GraphicsLayer) drawScope.getDrawContext().mMenuProviders;
                Function1 function1 = (Function1) this.this$0;
                MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
                Density density2 = menuHostHelper.getDensity();
                LayoutDirection layoutDirection2 = menuHostHelper.getLayoutDirection();
                Canvas canvas2 = menuHostHelper.getCanvas();
                long jM756getSizeNHjbRc2 = menuHostHelper.m756getSizeNHjbRc();
                GraphicsLayer graphicsLayer2 = (GraphicsLayer) menuHostHelper.mMenuProviders;
                menuHostHelper.setDensity(density);
                menuHostHelper.setLayoutDirection(layoutDirection);
                menuHostHelper.setCanvas(canvas);
                menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
                menuHostHelper.mMenuProviders = graphicsLayer;
                canvas.save();
                try {
                    function1.invoke(canvasDrawScope);
                    return Unit.INSTANCE;
                } finally {
                    canvas.restore();
                    menuHostHelper.setDensity(density2);
                    menuHostHelper.setLayoutDirection(layoutDirection2);
                    menuHostHelper.setCanvas(canvas2);
                    menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc2);
                    menuHostHelper.mMenuProviders = graphicsLayer2;
                }
            case 5:
                return new InputMethodSession((LegacyTextInputMethodRequest) this.$node, new Handshake.AnonymousClass2(9, (AndroidPlatformTextInputSession) this.this$0));
            case 6:
                InputMethodSession inputMethodSession = (InputMethodSession) this.$node;
                synchronized (inputMethodSession.lock) {
                    try {
                        inputMethodSession.disposed = true;
                        MutableVector mutableVector = inputMethodSession.connections;
                        Object[] objArr = mutableVector.content;
                        int i4 = mutableVector.size;
                        while (i < i4) {
                            NullableInputConnectionWrapperApi21 nullableInputConnectionWrapperApi21 = (NullableInputConnectionWrapperApi21) ((WeakReference) objArr[i]).get();
                            if (nullableInputConnectionWrapperApi21 != null && (recordingInputConnection = nullableInputConnectionWrapperApi21.delegate) != null) {
                                nullableInputConnectionWrapperApi21.closeDelegate(recordingInputConnection);
                                nullableInputConnectionWrapperApi21.delegate = null;
                            }
                            i++;
                        }
                        inputMethodSession.connections.clear();
                        Unit unit3 = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                TextInputService textInputService = ((AndroidPlatformTextInputSession) this.this$0).textInputService;
                textInputService._currentInputSession.set(null);
                textInputService.platformTextInputService.stopInput();
                return Unit.INSTANCE;
            case 7:
                return invoke$androidx$compose$ui$platform$AndroidUiFrameClock$withFrameNanos$2$1(obj);
            case 8:
                ((Choreographer) ((BroadcastFrameClock) this.$node).onNewAwaiters).removeFrameCallback((AndroidUiFrameClock$withFrameNanos$2$callback$1) this.this$0);
                return Unit.INSTANCE;
            case 9:
                ComposeViewContext composeViewContext = (ComposeViewContext) obj;
                Function2 function2 = (Function2) this.this$0;
                WrappedComposition wrappedComposition = (WrappedComposition) this.$node;
                if (!wrappedComposition.disposed) {
                    LifecycleOwner lifecycleOwner = composeViewContext.lifecycleOwner;
                    View view = composeViewContext.view;
                    Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
                    wrappedComposition.lastContent = function2;
                    if (wrappedComposition.addedToLifecycle == null) {
                        if (Intrinsics.areEqual(Looper.myLooper(), view.getHandler().getLooper())) {
                            wrappedComposition.addedToLifecycle = lifecycle2;
                            lifecycle2.addObserver(wrappedComposition);
                        } else {
                            view.post(new Preview$$ExternalSyntheticLambda1(24, wrappedComposition, lifecycle2));
                        }
                    } else if (lifecycle2.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                        wrappedComposition.original.setContent(new ComposableLambdaImpl(-1723985096, new NavHostKt$NavHost$29$1.AnonymousClass1(wrappedComposition, composeViewContext, function2, 2), true));
                    }
                }
                return Unit.INSTANCE;
            case 10:
                PopupLayout popupLayout = (PopupLayout) this.$node;
                popupLayout.setPositionProvider((PopupPositionProvider) this.this$0);
                popupLayout.updatePosition();
                return new AndroidPopup_androidKt$Popup$4$1$invoke$$inlined$onDispose$1();
            case 11:
                NavHostController navHostController2 = (NavHostController) this.this$0;
                LifecycleOwner lifecycleOwner2 = (LifecycleOwner) this.$node;
                NavController$$ExternalSyntheticLambda0 navController$$ExternalSyntheticLambda0 = navHostController2.lifecycleObserver;
                if (!lifecycleOwner2.equals(navHostController2.lifecycleOwner)) {
                    LifecycleOwner lifecycleOwner3 = navHostController2.lifecycleOwner;
                    if (lifecycleOwner3 != null && (lifecycle = lifecycleOwner3.getLifecycle()) != null) {
                        lifecycle.removeObserver(navController$$ExternalSyntheticLambda0);
                    }
                    navHostController2.lifecycleOwner = lifecycleOwner2;
                    lifecycleOwner2.getLifecycle().addObserver(navController$$ExternalSyntheticLambda0);
                }
                return new NavHostKt$NavHost$26$1$invoke$$inlined$onDispose$1(0);
            case 12:
                return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(i, (State) this.$node, (ComposeNavigator) this.this$0);
            default:
                ((CancellationSignal) this.$node).cancel();
                ((StandaloneCoroutine) this.this$0).cancel((CancellationException) null);
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavController$handleDeepLink$2(NavHostController navHostController, LifecycleOwner lifecycleOwner) {
        super(1);
        this.$r8$classId = 11;
        this.this$0 = navHostController;
        this.$node = lifecycleOwner;
    }
}
