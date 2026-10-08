package androidx.core.view;

import android.content.ClipDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.app.TwilightManager$TwilightState;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.core.AutoValue_SurfaceOutput_CameraInputInfo;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceEdge$$ExternalSyntheticLambda4;
import androidx.camera.core.processing.util.AutoValue_OutConfig;
import androidx.camera.view.PreviewView;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.material3.internal.ripple.AndroidRippleNode;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.ComposePausableCompositionException;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.ThreadMap;
import androidx.compose.runtime.internal.Thread_androidKt;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.SortedSet;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.font.TypefaceResult$Immutable;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleDelegate;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl;
import androidx.emoji2.text.EmojiProcessor$MarkExclusionCallback;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import coil.memory.MemoryCacheService;
import coil.network.EmptyNetworkObserver;
import coil.network.HttpException;
import coil.request.Parameters;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.ImportedDao_Impl$1;
import com.github.kr328.clash.service.data.ImportedDao_Impl$2;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import com.google.android.gms.tasks.zzg;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzt;
import com.google.common.util.concurrent.ListenableFuture;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import okhttp3.Handshake;
import okhttp3.Request;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MenuHostHelper implements FutureCallback, CallbackToFutureAdapter.Resolver, Applier, PlatformLocaleDelegate, InputContentInfoCompat$InputContentInfoCompatImpl {
    public static MenuHostHelper sInstance;
    public final /* synthetic */ int $r8$classId;
    public Object mMenuProviders;
    public Object mOnInvalidateMenuCallback;
    public Object mProviderToLifecycleContainers;

    public /* synthetic */ MenuHostHelper(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.mOnInvalidateMenuCallback = obj;
        this.mMenuProviders = obj2;
        this.mProviderToLifecycleContainers = obj3;
    }

    public static MenuHostHelper obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new MenuHostHelper(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public void add(int i, LayoutNode layoutNode) {
        MemoryCacheService memoryCacheService = (MemoryCacheService) this.mOnInvalidateMenuCallback;
        MemoryCacheService memoryCacheService2 = (MemoryCacheService) this.mMenuProviders;
        MemoryCacheService memoryCacheService3 = (MemoryCacheService) this.mProviderToLifecycleContainers;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal == 0) {
            memoryCacheService.add(layoutNode);
            memoryCacheService3.add(layoutNode);
            return;
        }
        if (iOrdinal == 1) {
            memoryCacheService2.add(layoutNode);
            memoryCacheService3.add(layoutNode);
            return;
        }
        if (iOrdinal == 2) {
            if (layoutNode.lookaheadRoot != null) {
                memoryCacheService3.add(layoutNode);
                return;
            } else {
                memoryCacheService.add(layoutNode);
                return;
            }
        }
        if (iOrdinal != 3) {
            throw new HttpException();
        }
        if (layoutNode.lookaheadRoot != null) {
            memoryCacheService3.add(layoutNode);
        } else {
            memoryCacheService2.add(layoutNode);
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void apply(Object obj, Function2 function2) {
        switch (this.$r8$classId) {
            case 17:
                ((MutableIntList) this.mOnInvalidateMenuCallback).add(7);
                MutableObjectList mutableObjectList = (MutableObjectList) this.mMenuProviders;
                mutableObjectList.add(function2);
                mutableObjectList.add(obj);
                break;
            default:
                function2.invoke(this.mProviderToLifecycleContainers, obj);
                break;
        }
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        zzg zzgVar = new zzg(5, this);
        zzt zztVarDirectExecutor = HexFormatKt.directExecutor();
        ResolvableFuture resolvableFuture = completer.cancellationFuture;
        if (resolvableFuture != null) {
            resolvableFuture.addListener(zzgVar, zztVarDirectExecutor);
        }
        ((HandlerScheduledExecutorService.HandlerScheduledFuture) this.mProviderToLifecycleContainers).mCompleter.set(completer);
        return "HandlerScheduledFuture-" + ((Callable) this.mMenuProviders).toString();
    }

    public void clear() {
        ((ArrayList) this.mMenuProviders).clear();
        this.mProviderToLifecycleContainers = this.mOnInvalidateMenuCallback;
        ((LayoutNode) this.mOnInvalidateMenuCallback).removeAll$ui();
    }

    public boolean contains(LayoutNode layoutNode) {
        return !(layoutNode.lookaheadRoot == null) && (((SortedSet) ((MemoryCacheService) this.mOnInvalidateMenuCallback).imageLoader).contains(layoutNode) || ((SortedSet) ((MemoryCacheService) this.mMenuProviders).imageLoader).contains(layoutNode));
    }

    public void createAndSendSurfaceOutput(SurfaceEdge surfaceEdge, Map.Entry entry) {
        SurfaceEdge surfaceEdge2 = (SurfaceEdge) entry.getValue();
        AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo = null;
        AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo2 = new AutoValue_SurfaceOutput_CameraInputInfo(surfaceEdge.mStreamSpec.resolution, ((AutoValue_OutConfig) entry.getKey()).getCropRect, surfaceEdge.mHasCameraTransform ? (CameraInternal) this.mMenuProviders : null, ((AutoValue_OutConfig) entry.getKey()).getRotationDegrees, ((AutoValue_OutConfig) entry.getKey()).isMirroring);
        int i = ((AutoValue_OutConfig) entry.getKey()).getFormat;
        surfaceEdge2.getClass();
        CharsKt.checkMainThread();
        surfaceEdge2.checkNotClosed();
        Preconditions.checkState("Consumer can only be linked once.", !surfaceEdge2.mHasConsumer);
        surfaceEdge2.mHasConsumer = true;
        SurfaceEdge.SettableSurface settableSurface = surfaceEdge2.mSettableSurface;
        ChainingListenableFuture chainingListenableFutureTransformAsync = Futures.transformAsync(settableSurface.getSurface(), new SurfaceEdge$$ExternalSyntheticLambda4(surfaceEdge2, settableSurface, i, autoValue_SurfaceOutput_CameraInputInfo2, autoValue_SurfaceOutput_CameraInputInfo), HexFormatKt.mainThreadExecutor());
        chainingListenableFutureTransformAsync.addListener(new zzi(1, chainingListenableFutureTransformAsync, new SurfaceRequest.AnonymousClass1(16, this, surfaceEdge2)), HexFormatKt.mainThreadExecutor());
    }

    public Object dequeue() {
        Object objRemoveLast;
        synchronized (this.mMenuProviders) {
            objRemoveLast = ((ArrayDeque) this.mOnInvalidateMenuCallback).removeLast();
        }
        return objRemoveLast;
    }

    @Override // androidx.compose.runtime.Applier
    public void down(Object obj) {
        switch (this.$r8$classId) {
            case 17:
                ((MutableIntList) this.mOnInvalidateMenuCallback).add(1);
                ((MutableObjectList) this.mMenuProviders).add(obj);
                break;
            default:
                ((ArrayList) this.mMenuProviders).add(this.mProviderToLifecycleContainers);
                this.mProviderToLifecycleContainers = obj;
                break;
        }
    }

    public void drawBorder(LayoutNodeDrawScope layoutNodeDrawScope, Function0 function0, Function0 function1, final SolidColor solidColor, BrushKt brushKt) {
        Object blurEffectKt$$ExternalSyntheticLambda1;
        final Http2Connection.Builder builder = (Http2Connection.Builder) this.mOnInvalidateMenuCallback;
        final BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda0 = new BasicTextKt$$ExternalSyntheticLambda0(23, this);
        builder.socket = function0;
        builder.connectionName = function1;
        if (!solidColor.equals((SolidColor) builder.source) || !Intrinsics.areEqual(brushKt, (BrushKt) builder.sink) || ((Function1) builder.listener) == null) {
            builder.source = solidColor;
            builder.sink = brushKt;
            if (brushKt instanceof Outline$Generic) {
                final Outline$Generic outline$Generic = (Outline$Generic) brushKt;
                AndroidPath androidPath = outline$Generic.path;
                final Rect bounds = androidPath.getBounds();
                if (((PreviewView.AnonymousClass1) builder.taskRunner) == null) {
                    builder.taskRunner = new PreviewView.AnonymousClass1(29, false);
                }
                PreviewView.AnonymousClass1 anonymousClass1 = (PreviewView.AnonymousClass1) builder.taskRunner;
                AndroidPath androidPathPath = (AndroidPath) anonymousClass1.this$0;
                if (androidPathPath == null) {
                    androidPathPath = AndroidPath_androidKt.Path();
                    anonymousClass1.this$0 = androidPathPath;
                }
                final AndroidPath androidPath2 = androidPathPath;
                androidPath2.reset();
                Modifier.CC.addRect$default(androidPath2, bounds);
                androidPath2.m409opN5in7k0(androidPath2, androidPath, 0);
                final long jCeil = (((long) ((int) Math.ceil(bounds.right - bounds.left))) << 32) | (((long) ((int) Math.ceil(bounds.bottom - bounds.top))) & 4294967295L);
                blurEffectKt$$ExternalSyntheticLambda1 = new Function1() { // from class: androidx.compose.material3.internal.ripple.BorderLogic$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        long j = jCeil;
                        BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda1 = basicTextKt$$ExternalSyntheticLambda0;
                        final AndroidPath androidPath3 = androidPath2;
                        DrawScope drawScope = (DrawScope) obj;
                        Http2Connection.Builder builder2 = builder;
                        float f = ((Dp) ((Function0) builder2.socket).invoke()).value;
                        float f2 = 2;
                        float fMin = Math.min(Dp.m704equalsimpl0(f, 0.0f) ? 1.0f : (float) Math.ceil(drawScope.mo92toPx0680j_4(f)), (float) Math.ceil((Size.m386getMinDimensionimpl(drawScope.mo474getSizeNHjbRc()) - (((float) Math.ceil(drawScope.mo92toPx0680j_4(((Dp) ((Function0) builder2.connectionName).invoke()).value))) * f2)) / f2));
                        final float f3 = fMin < 0.0f ? 0.0f : fMin;
                        final float fCeil = (float) Math.ceil(drawScope.mo92toPx0680j_4(((Dp) ((Function0) builder2.connectionName).invoke()).value));
                        final Outline$Generic outline$Generic2 = outline$Generic;
                        final SolidColor solidColor2 = solidColor;
                        if (fCeil != 0.0f || f2 * f3 <= Size.m386getMinDimensionimpl(drawScope.mo474getSizeNHjbRc())) {
                            final Rect rect = bounds;
                            float f4 = rect.left;
                            float f5 = rect.top;
                            ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(f4, f5);
                            try {
                                GraphicsLayer graphicsLayer = (GraphicsLayer) basicTextKt$$ExternalSyntheticLambda1.invoke();
                                GraphicsLayerImpl graphicsLayerImpl = graphicsLayer.impl;
                                if (graphicsLayerImpl.mo480getCompositingStrategyke2Ky5w() != 1) {
                                    graphicsLayerImpl.mo484setCompositingStrategyWpw9cng(1);
                                }
                                drawScope.mo475recordJVtK1S4(graphicsLayer, j, new Function1() { // from class: androidx.compose.material3.internal.ripple.BorderLogic$createDrawGenericBorder$lambda$1$0$0$$inlined$drawBorderCache-95KtPRI$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        SolidColor solidColor3 = solidColor2;
                                        DrawScope drawScope2 = (DrawScope) obj2;
                                        float f6 = fCeil;
                                        Outline$Generic outline$Generic3 = outline$Generic2;
                                        Rect rect2 = rect;
                                        float f7 = -rect2.left;
                                        float f8 = -rect2.top;
                                        ((Parameters.Builder) drawScope2.getDrawContext().mOnInvalidateMenuCallback).translate(f7, f8);
                                        try {
                                            float f9 = 2;
                                            Modifier.CC.m312drawPathGBMwjPU$default(drawScope2, outline$Generic3.path, solidColor3, 0.0f, new Stroke((f3 + f6) * f9, 0.0f, 0, 0, 30), null, 0, 52);
                                            Modifier.CC.m312drawPathGBMwjPU$default(drawScope2, outline$Generic3.path, solidColor3, 0.0f, new Stroke(f6 * f9, 0.0f, 0, 0, 30), null, 0, 20);
                                            float f10 = 1;
                                            float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope2.mo474getSizeNHjbRc() >> 32)) + f10) / Float.intBitsToFloat((int) (drawScope2.mo474getSizeNHjbRc() >> 32));
                                            float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (drawScope2.mo474getSizeNHjbRc() & 4294967295L)) + f10) / Float.intBitsToFloat((int) (drawScope2.mo474getSizeNHjbRc() & 4294967295L));
                                            long jMo473getCenterF1C5BW0 = drawScope2.mo473getCenterF1C5BW0();
                                            MenuHostHelper drawContext = drawScope2.getDrawContext();
                                            long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
                                            drawContext.getCanvas().save();
                                            try {
                                                ((Parameters.Builder) drawContext.mOnInvalidateMenuCallback).m792scale0AR0LA0(fIntBitsToFloat, fIntBitsToFloat2, jMo473getCenterF1C5BW0);
                                                Modifier.CC.m312drawPathGBMwjPU$default(drawScope2, androidPath3, solidColor3, 0.0f, null, null, 0, 28);
                                                drawContext.getCanvas().restore();
                                                drawContext.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
                                                ((Parameters.Builder) drawScope2.getDrawContext().mOnInvalidateMenuCallback).translate(-f7, -f8);
                                                return Unit.INSTANCE;
                                            } catch (Throwable th) {
                                                drawContext.getCanvas().restore();
                                                drawContext.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            ((Parameters.Builder) drawScope2.getDrawContext().mOnInvalidateMenuCallback).translate(-f7, -f8);
                                            throw th2;
                                        }
                                    }
                                });
                                GraphicsLayerKt.drawLayer(drawScope, graphicsLayer);
                            } finally {
                                ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-f4, -f5);
                            }
                        } else {
                            Modifier.CC.m312drawPathGBMwjPU$default(drawScope, outline$Generic2.path, solidColor2, 0.0f, null, null, 0, 60);
                        }
                        return Unit.INSTANCE;
                    }
                };
            } else if (brushKt instanceof Outline$Rounded) {
                Outline$Rounded outline$Rounded = (Outline$Rounded) brushKt;
                if (RoundRectKt.isSimple(outline$Rounded.roundRect)) {
                    blurEffectKt$$ExternalSyntheticLambda1 = new LifecycleEffectKt$$ExternalSyntheticLambda1(builder, outline$Rounded, solidColor, 16);
                } else {
                    if (((PreviewView.AnonymousClass1) builder.taskRunner) == null) {
                        builder.taskRunner = new PreviewView.AnonymousClass1(29, false);
                    }
                    PreviewView.AnonymousClass1 anonymousClass2 = (PreviewView.AnonymousClass1) builder.taskRunner;
                    AndroidPath androidPathPath2 = (AndroidPath) anonymousClass2.this$0;
                    if (androidPathPath2 == null) {
                        androidPathPath2 = AndroidPath_androidKt.Path();
                        anonymousClass2.this$0 = androidPathPath2;
                    }
                    Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                    ref$FloatRef.element = Float.NaN;
                    blurEffectKt$$ExternalSyntheticLambda1 = new BorderLogic$$ExternalSyntheticLambda1(builder, ref$FloatRef, new Ref$ObjectRef(), androidPathPath2, outline$Rounded, solidColor);
                }
            } else {
                if (!(brushKt instanceof Outline$Rectangle)) {
                    throw new HttpException();
                }
                blurEffectKt$$ExternalSyntheticLambda1 = new BlurEffectKt$$ExternalSyntheticLambda1(5, builder, solidColor);
            }
            builder.listener = blurEffectKt$$ExternalSyntheticLambda1;
        }
        ((Function1) builder.listener).invoke(layoutNodeDrawScope);
    }

    public void enqueue(ImageProxy imageProxy) throws Exception {
        Object objDequeue;
        ImageInfo imageInfo = imageProxy.getImageInfo();
        CameraCaptureResult cameraCaptureResult = imageInfo instanceof CameraCaptureResultImageInfo ? ((CameraCaptureResultImageInfo) imageInfo).mCameraCaptureResult : null;
        if ((cameraCaptureResult.getAfState() != CameraCaptureMetaData$AfState.LOCKED_FOCUSED && cameraCaptureResult.getAfState() != CameraCaptureMetaData$AfState.PASSIVE_FOCUSED) || cameraCaptureResult.getAeState() != CameraCaptureMetaData$AeState.CONVERGED || cameraCaptureResult.getAwbState() != CameraCaptureMetaData$AwbState.CONVERGED) {
            ((ZslControlImpl$$ExternalSyntheticLambda0) this.mProviderToLifecycleContainers).getClass();
            imageProxy.close();
            return;
        }
        synchronized (this.mMenuProviders) {
            try {
                objDequeue = ((ArrayDeque) this.mOnInvalidateMenuCallback).size() >= 3 ? dequeue() : null;
                ((ArrayDeque) this.mOnInvalidateMenuCallback).addFirst(imageProxy);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (((ZslControlImpl$$ExternalSyntheticLambda0) this.mProviderToLifecycleContainers) == null || objDequeue == null) {
            return;
        }
        ((ImageProxy) objDequeue).close();
    }

    public Object get() {
        long jCurrentThreadId = Thread_jvmKt.currentThreadId();
        if (jCurrentThreadId == Thread_androidKt.MainThreadId) {
            return this.mProviderToLifecycleContainers;
        }
        ThreadMap threadMap = (ThreadMap) ((AtomicReference) this.mOnInvalidateMenuCallback).get();
        int iFind = threadMap.find(jCurrentThreadId);
        if (iFind >= 0) {
            return threadMap.values[iFind];
        }
        return null;
    }

    public Canvas getCanvas() {
        return ((CanvasDrawScope) this.mProviderToLifecycleContainers).drawParams.canvas;
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = (TypedArray) this.mMenuProviders;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = AbstractList.Companion.getColorStateList((Context) this.mOnInvalidateMenuCallback, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Uri getContentUri() {
        return (Uri) this.mOnInvalidateMenuCallback;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public LocaleList getCurrent() {
        android.os.LocaleList localeList = android.os.LocaleList.getDefault();
        synchronized (((EmptyNetworkObserver) this.mProviderToLifecycleContainers)) {
            try {
                LocaleList localeList2 = (LocaleList) this.mMenuProviders;
                if (localeList2 != null && localeList == ((android.os.LocaleList) this.mOnInvalidateMenuCallback)) {
                    return localeList2;
                }
                int size = localeList.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList.add(new Locale(localeList.get(i)));
                }
                LocaleList localeList3 = new LocaleList(arrayList);
                this.mOnInvalidateMenuCallback = localeList;
                this.mMenuProviders = localeList3;
                return localeList3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Density getDensity() {
        return ((CanvasDrawScope) this.mProviderToLifecycleContainers).drawParams.density;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public ClipDescription getDescription() {
        return (ClipDescription) this.mMenuProviders;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.mMenuProviders;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : AbstractList.Companion.getDrawable((Context) this.mOnInvalidateMenuCallback, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        Drawable drawable;
        if (!((TypedArray) this.mMenuProviders).hasValue(i) || (resourceId = ((TypedArray) this.mMenuProviders).getResourceId(i, 0)) == 0) {
            return null;
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = (Context) this.mOnInvalidateMenuCallback;
        synchronized (appCompatDrawableManager) {
            drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
        }
        return drawable;
    }

    public Typeface getFont(int i, int i2, AppCompatTextHelper.AnonymousClass1 anonymousClass1) {
        int resourceId = ((TypedArray) this.mMenuProviders).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.mProviderToLifecycleContainers) == null) {
            this.mProviderToLifecycleContainers = new TypedValue();
        }
        Context context = (Context) this.mOnInvalidateMenuCallback;
        TypedValue typedValue = (TypedValue) this.mProviderToLifecycleContainers;
        ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.loadFont(context, resourceId, typedValue, i2, anonymousClass1, true, false);
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Object getInputContentInfo() {
        return null;
    }

    public KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = (KeyboardActions) this.mMenuProviders;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        throw null;
    }

    public LayoutDirection getLayoutDirection() {
        return ((CanvasDrawScope) this.mProviderToLifecycleContainers).drawParams.layoutDirection;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Uri getLinkUri() {
        return (Uri) this.mProviderToLifecycleContainers;
    }

    public android.util.Size[] getOutputSizes(int i) {
        List arrayList;
        ArrayList arrayList2;
        HashMap map = (HashMap) this.mProviderToLifecycleContainers;
        if (map.containsKey(Integer.valueOf(i))) {
            if (((android.util.Size[]) map.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (android.util.Size[]) ((android.util.Size[]) map.get(Integer.valueOf(i))).clone();
        }
        android.util.Size[] outputSizes = ((StreamConfigurationMap) ((PreviewView.AnonymousClass1) this.mOnInvalidateMenuCallback).this$0).getOutputSizes(i);
        if (outputSizes == null || outputSizes.length == 0) {
            Logger.w("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i);
            return outputSizes;
        }
        SurfaceRequest.AnonymousClass1 anonymousClass1 = (SurfaceRequest.AnonymousClass1) this.mMenuProviders;
        anonymousClass1.getClass();
        ArrayList arrayList3 = new ArrayList(Arrays.asList(outputSizes));
        if (((ExtraSupportedOutputSizeQuirk) anonymousClass1.val$requestCancellationCompleter) != null) {
            android.util.Size[] sizeArr = (i == 34 && "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL)) ? new android.util.Size[]{new android.util.Size(1440, 1080), new android.util.Size(960, 720)} : new android.util.Size[0];
            if (sizeArr.length > 0) {
                arrayList3.addAll(Arrays.asList(sizeArr));
            }
        }
        EmojiProcessor$MarkExclusionCallback emojiProcessor$MarkExclusionCallback = (EmojiProcessor$MarkExclusionCallback) anonymousClass1.val$requestCancellationFuture;
        emojiProcessor$MarkExclusionCallback.getClass();
        if (((ExcludedSupportedSizesQuirk) DeviceQuirks.sQuirks.get(ExcludedSupportedSizesQuirk.class)) == null) {
            arrayList = new ArrayList();
        } else {
            String str = emojiProcessor$MarkExclusionCallback.mExclusion;
            String str2 = Build.BRAND;
            if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList2.add(new android.util.Size(4160, 3120));
                    arrayList2.add(new android.util.Size(4000, 3000));
                }
            } else if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList2.add(new android.util.Size(4160, 3120));
                    arrayList2.add(new android.util.Size(4000, 3000));
                }
            } else if ("HUAWEI".equalsIgnoreCase(str2) && "HWANE".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && (i == 34 || i == 35)) {
                    arrayList2.add(new android.util.Size(720, 720));
                    arrayList2.add(new android.util.Size(400, 400));
                }
            } else if (ExcludedSupportedSizesQuirk.isSamsungJ7PrimeApi27Above()) {
                arrayList2 = new ArrayList();
                if (str.equals("0")) {
                    if (i == 34) {
                        arrayList2.add(new android.util.Size(4128, 3096));
                        arrayList2.add(new android.util.Size(4128, 2322));
                        arrayList2.add(new android.util.Size(3088, 3088));
                        arrayList2.add(new android.util.Size(3264, 2448));
                        arrayList2.add(new android.util.Size(3264, 1836));
                        arrayList2.add(new android.util.Size(2048, 1536));
                        arrayList2.add(new android.util.Size(2048, 1152));
                        arrayList2.add(new android.util.Size(1920, 1080));
                    } else if (i == 35) {
                        arrayList2.add(new android.util.Size(4128, 2322));
                        arrayList2.add(new android.util.Size(3088, 3088));
                        arrayList2.add(new android.util.Size(3264, 2448));
                        arrayList2.add(new android.util.Size(3264, 1836));
                        arrayList2.add(new android.util.Size(2048, 1536));
                        arrayList2.add(new android.util.Size(2048, 1152));
                        arrayList2.add(new android.util.Size(1920, 1080));
                    }
                } else if (str.equals("1") && (i == 34 || i == 35)) {
                    arrayList2.add(new android.util.Size(3264, 2448));
                    arrayList2.add(new android.util.Size(3264, 1836));
                    arrayList2.add(new android.util.Size(2448, 2448));
                    arrayList2.add(new android.util.Size(1920, 1920));
                    arrayList2.add(new android.util.Size(2048, 1536));
                    arrayList2.add(new android.util.Size(2048, 1152));
                    arrayList2.add(new android.util.Size(1920, 1080));
                }
            } else if (ExcludedSupportedSizesQuirk.isSamsungJ7Api27Above()) {
                arrayList2 = new ArrayList();
                if (str.equals("0")) {
                    if (i == 34) {
                        arrayList2.add(new android.util.Size(4128, 3096));
                        arrayList2.add(new android.util.Size(4128, 2322));
                        arrayList2.add(new android.util.Size(3088, 3088));
                        arrayList2.add(new android.util.Size(3264, 2448));
                        arrayList2.add(new android.util.Size(3264, 1836));
                        arrayList2.add(new android.util.Size(2048, 1536));
                        arrayList2.add(new android.util.Size(2048, 1152));
                        arrayList2.add(new android.util.Size(1920, 1080));
                    } else if (i == 35) {
                        arrayList2.add(new android.util.Size(2048, 1536));
                        arrayList2.add(new android.util.Size(2048, 1152));
                        arrayList2.add(new android.util.Size(1920, 1080));
                    }
                } else if (str.equals("1") && (i == 34 || i == 35)) {
                    arrayList2.add(new android.util.Size(2576, 1932));
                    arrayList2.add(new android.util.Size(2560, 1440));
                    arrayList2.add(new android.util.Size(1920, 1920));
                    arrayList2.add(new android.util.Size(2048, 1536));
                    arrayList2.add(new android.util.Size(2048, 1152));
                    arrayList2.add(new android.util.Size(1920, 1080));
                }
            } else if ("REDMI".equalsIgnoreCase(str2) && "joyeuse".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList2.add(new android.util.Size(9280, 6944));
                }
            } else {
                Logger.w("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
                arrayList = Collections.EMPTY_LIST;
            }
            arrayList = arrayList2;
        }
        if (!arrayList.isEmpty()) {
            arrayList3.removeAll(arrayList);
        }
        if (arrayList3.isEmpty()) {
            Logger.w("OutputSizesCorrector", "Sizes array becomes empty after excluding problematic output sizes.");
        }
        android.util.Size[] sizeArr2 = (android.util.Size[]) arrayList3.toArray(new android.util.Size[0]);
        map.put(Integer.valueOf(i), sizeArr2);
        return (android.util.Size[]) sizeArr2.clone();
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public long m756getSizeNHjbRc() {
        return ((CanvasDrawScope) this.mProviderToLifecycleContainers).drawParams.size;
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int i, Object obj) {
        switch (this.$r8$classId) {
            case 17:
                MutableIntList mutableIntList = (MutableIntList) this.mOnInvalidateMenuCallback;
                mutableIntList.add(5);
                mutableIntList.add(i);
                ((MutableObjectList) this.mMenuProviders).add(obj);
                break;
            default:
                ((LayoutNode) this.mProviderToLifecycleContainers).insertAt$ui(i, (LayoutNode) obj);
                break;
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int i, Object obj) {
        switch (this.$r8$classId) {
            case 17:
                MutableIntList mutableIntList = (MutableIntList) this.mOnInvalidateMenuCallback;
                mutableIntList.add(6);
                mutableIntList.add(i);
                ((MutableObjectList) this.mMenuProviders).add(obj);
                break;
            default:
                break;
        }
    }

    public boolean isNotEmpty() {
        return !(((SortedSet) ((MemoryCacheService) this.mOnInvalidateMenuCallback).imageLoader).isEmpty() && ((SortedSet) ((MemoryCacheService) this.mProviderToLifecycleContainers).imageLoader).isEmpty() && ((SortedSet) ((MemoryCacheService) this.mMenuProviders).imageLoader).isEmpty());
    }

    public boolean isStaleResolvedFont() {
        if (((State) this.mOnInvalidateMenuCallback).getValue() != this.mProviderToLifecycleContainers) {
            return true;
        }
        MenuHostHelper menuHostHelper = (MenuHostHelper) this.mMenuProviders;
        return menuHostHelper != null && menuHostHelper.isStaleResolvedFont();
    }

    public boolean measure(ConstraintLayout.Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        BasicMeasure$Measure basicMeasure$Measure = (BasicMeasure$Measure) this.mMenuProviders;
        int[] iArr = constraintWidget.mListDimensionBehaviors;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        basicMeasure$Measure.horizontalBehavior = iArr[0];
        basicMeasure$Measure.verticalBehavior = iArr[1];
        basicMeasure$Measure.horizontalDimension = constraintWidget.getWidth();
        basicMeasure$Measure.verticalDimension = constraintWidget.getHeight();
        basicMeasure$Measure.measuredNeedsSolverPass = false;
        basicMeasure$Measure.useCurrentDimensions = z;
        boolean z2 = basicMeasure$Measure.horizontalBehavior == 3;
        boolean z3 = basicMeasure$Measure.verticalBehavior == 3;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z5 = z3 && constraintWidget.mDimensionRatio > 0.0f;
        if (z4 && iArr2[0] == 4) {
            basicMeasure$Measure.horizontalBehavior = 1;
        }
        if (z5 && iArr2[1] == 4) {
            basicMeasure$Measure.verticalBehavior = 1;
        }
        measurer.measure(constraintWidget, basicMeasure$Measure);
        constraintWidget.setWidth(basicMeasure$Measure.measuredWidth);
        constraintWidget.setHeight(basicMeasure$Measure.measuredHeight);
        constraintWidget.hasBaseline = basicMeasure$Measure.measuredHasBaseline;
        int i = basicMeasure$Measure.measuredBaseline;
        constraintWidget.mBaselineDistance = i;
        constraintWidget.hasBaseline = i > 0;
        basicMeasure$Measure.useCurrentDimensions = false;
        return basicMeasure$Measure.measuredNeedsSolverPass;
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int i, int i2, int i3) {
        switch (this.$r8$classId) {
            case 17:
                MutableIntList mutableIntList = (MutableIntList) this.mOnInvalidateMenuCallback;
                mutableIntList.add(3);
                mutableIntList.add(i);
                mutableIntList.add(i2);
                mutableIntList.add(i3);
                break;
            default:
                ((LayoutNode) this.mProviderToLifecycleContainers).move$ui(i, i2, i3);
                break;
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void onEndChanges() {
        switch (this.$r8$classId) {
            case 17:
                break;
            default:
                Owner owner = ((LayoutNode) this.mOnInvalidateMenuCallback).owner;
                if (owner != null) {
                    ((AndroidComposeView) owner).onEndApplyChanges();
                }
                break;
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onFailure(Throwable th) {
        switch (this.$r8$classId) {
            case 6:
                CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.mMenuProviders;
                if (!(th instanceof CancellationException)) {
                    completer.set(null);
                } else {
                    Preconditions.checkState(null, completer.setException(new SurfaceRequest.RequestCancelledException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), (String) this.mProviderToLifecycleContainers, " cancelled."), th)));
                }
                break;
            default:
                ((ZoomControl) this.mProviderToLifecycleContainers).mCaptureResultListener = null;
                ArrayList arrayList = (ArrayList) this.mOnInvalidateMenuCallback;
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((CameraInfoInternal) this.mMenuProviders).removeSessionCaptureCallback((CameraCaptureCallback) obj);
                    }
                    arrayList.clear();
                }
                break;
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onSuccess(Object obj) {
        switch (this.$r8$classId) {
            case 6:
                Futures.propagateTransform(true, (ListenableFuture) this.mOnInvalidateMenuCallback, (CallbackToFutureAdapter.Completer) this.mMenuProviders, HexFormatKt.directExecutor());
                break;
            default:
                ((ZoomControl) this.mProviderToLifecycleContainers).mCaptureResultListener = null;
                break;
        }
    }

    public void playTo(MenuHostHelper menuHostHelper, zzky zzkyVar) {
        Exception exc;
        MutableIntList mutableIntList = (MutableIntList) this.mOnInvalidateMenuCallback;
        int i = mutableIntList._size;
        MutableObjectList mutableObjectList = (MutableObjectList) this.mMenuProviders;
        MutableObjectList mutableObjectList2 = new MutableObjectList();
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            try {
                try {
                    switch (mutableIntList.get(i2)) {
                        case 0:
                            menuHostHelper.up();
                            i2 = i4;
                            break;
                        case 1:
                            int i5 = i3 + 1;
                            menuHostHelper.down(mutableObjectList.get(i3));
                            i3 = i5;
                            i2 = i4;
                            break;
                        case 2:
                            int i6 = i2 + 2;
                            i2 += 3;
                            menuHostHelper.remove(mutableIntList.get(i4), mutableIntList.get(i6));
                            break;
                        case 3:
                            int i7 = i2 + 2;
                            try {
                                int i8 = i2 + 3;
                                try {
                                    i2 += 4;
                                    menuHostHelper.move(mutableIntList.get(i4), mutableIntList.get(i7), mutableIntList.get(i8));
                                } catch (Exception e) {
                                    exc = e;
                                    i2 = i8;
                                    throw new ComposePausableCompositionException(mutableObjectList, mutableObjectList2, mutableIntList, i2 - 1, exc);
                                }
                            } catch (Exception e2) {
                                exc = e2;
                                i2 = i7;
                            }
                            break;
                        case 4:
                            menuHostHelper.clear();
                            i2 = i4;
                            break;
                        case 5:
                            i2 += 2;
                            int i9 = i3 + 1;
                            menuHostHelper.insertBottomUp(mutableIntList.get(i4), mutableObjectList.get(i3));
                            i3 = i9;
                            break;
                        case 6:
                            i2 += 2;
                            try {
                                mutableIntList.get(i4);
                                int i10 = i3 + 1;
                                i3 = i10;
                            } catch (Exception e3) {
                                exc = e3;
                                throw new ComposePausableCompositionException(mutableObjectList, mutableObjectList2, mutableIntList, i2 - 1, exc);
                            }
                            break;
                        case 7:
                            int i11 = i3 + 1;
                            Object obj = mutableObjectList.get(i3);
                            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, obj);
                            i3 += 2;
                            menuHostHelper.apply(mutableObjectList.get(i11), (Function2) obj);
                            i2 = i4;
                            break;
                        case 8:
                            Object obj2 = menuHostHelper.mProviderToLifecycleContainers;
                            if (obj2 instanceof ComposeNodeLifecycleCallback) {
                                ComposeNodeLifecycleCallback composeNodeLifecycleCallback = (ComposeNodeLifecycleCallback) obj2;
                                if (((MutableVector) zzkyVar.zze).remove(composeNodeLifecycleCallback)) {
                                    composeNodeLifecycleCallback.onDeactivate();
                                }
                            }
                            mutableObjectList2.add(obj2);
                            menuHostHelper.reuse();
                            i2 = i4;
                            break;
                        default:
                            i2 = i4;
                            break;
                    }
                } catch (Exception e4) {
                    exc = e4;
                    i2 = i4;
                }
            } catch (Throwable th) {
                menuHostHelper.onEndChanges();
                throw th;
            }
        }
        if (i3 != mutableObjectList._size) {
            ComposerKt.composeImmediateRuntimeError("Applier operation size mismatch");
        }
        mutableObjectList.clear();
        mutableIntList._size = 0;
        menuHostHelper.onEndChanges();
    }

    public void recycle() {
        ((TypedArray) this.mMenuProviders).recycle();
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int i, int i2) {
        switch (this.$r8$classId) {
            case 17:
                MutableIntList mutableIntList = (MutableIntList) this.mOnInvalidateMenuCallback;
                mutableIntList.add(2);
                mutableIntList.add(i);
                mutableIntList.add(i2);
                break;
            default:
                ((LayoutNode) this.mProviderToLifecycleContainers).removeAt$ui(i, i2);
                break;
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void reuse() {
        RectManager rectManager;
        AndroidAutofillManager androidAutofillManager;
        RectManager rectManager2;
        switch (this.$r8$classId) {
            case 17:
                ((MutableIntList) this.mOnInvalidateMenuCallback).add(8);
                break;
            default:
                LayoutNode layoutNode = (LayoutNode) this.mProviderToLifecycleContainers;
                NodeChain nodeChain = layoutNode.nodes;
                if (!layoutNode.isAttached()) {
                    InlineClassHelperKt.throwIllegalArgumentException("onReuse is only expected on attached node");
                }
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode.subcompositionsState;
                if (layoutNodeSubcompositionsState != null) {
                    layoutNodeSubcompositionsState.markActiveNodesAsReused(false);
                }
                layoutNode.isCurrentlyCalculatingSemanticsConfiguration = false;
                if (layoutNode.isDeactivated) {
                    layoutNode.isDeactivated = false;
                } else {
                    Modifier.Node node = (TailModifierNode) nodeChain.tail;
                    for (Modifier.Node node2 = node; node2 != null; node2 = node2.parent) {
                        if (node2.isAttached) {
                            node2.reset$ui();
                        }
                    }
                    for (Modifier.Node node3 = node; node3 != null; node3 = node3.parent) {
                        if (node3.isAttached) {
                            node3.runDetachLifecycle$ui();
                        }
                    }
                    while (node != null) {
                        if (node.isAttached) {
                            node.markAsDetached$ui();
                        }
                        node = node.parent;
                    }
                }
                int i = layoutNode.semanticsId;
                Owner owner = layoutNode.owner;
                if (owner != null && (rectManager2 = ((AndroidComposeView) owner).getRectManager()) != null) {
                    rectManager2.remove(layoutNode);
                }
                layoutNode.semanticsId = SemanticsModifierKt.lastIdentifier.addAndGet(1);
                Owner owner2 = layoutNode.owner;
                if (owner2 != null) {
                    AndroidComposeView androidComposeView = (AndroidComposeView) owner2;
                    androidComposeView.getLayoutNodes().remove(i);
                    androidComposeView.getLayoutNodes().set(layoutNode.semanticsId, layoutNode);
                }
                for (Modifier.Node node4 = (Modifier.Node) nodeChain.head; node4 != null; node4 = node4.child) {
                    node4.markAsAttached$ui();
                }
                nodeChain.runAttachLifecycle();
                if (nodeChain.m565hasH91voCI$ui(8)) {
                    layoutNode.invalidateSemantics$ui();
                }
                LayoutNode.rescheduleRemeasureOrRelayout$ui(layoutNode);
                Owner owner3 = layoutNode.owner;
                if (owner3 != null) {
                    AndroidComposeView androidComposeView2 = (AndroidComposeView) owner3;
                    if (AndroidComposeView.autofillSupported() && (androidAutofillManager = androidComposeView2._autofillManager) != null) {
                        AndroidComposeView androidComposeView3 = androidAutofillManager.view;
                        Parameters.Builder builder = androidAutofillManager.platformAutofillManager;
                        MutableIntSet mutableIntSet = androidAutofillManager.currentlyDisplayedIDs;
                        if (mutableIntSet.remove(i)) {
                            builder.notifyViewVisibilityChanged(androidComposeView3, i, false);
                        }
                        SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
                        if (semanticsConfiguration != null && semanticsConfiguration.props.contains(SemanticsProperties.ContentType)) {
                            mutableIntSet.add(layoutNode.semanticsId);
                            builder.notifyViewVisibilityChanged(androidComposeView3, layoutNode.semanticsId, true);
                        }
                    }
                }
                Owner owner4 = layoutNode.owner;
                if (owner4 != null && (rectManager = ((AndroidComposeView) owner4).getRectManager()) != null) {
                    rectManager.recalculateRectIfDirty(layoutNode);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: renamed from: runAction-KlQnJC8, reason: not valid java name */
    public boolean m757runActionKlQnJC8(int i) {
        SoftwareKeyboardController softwareKeyboardController;
        if (i == 7 || i == 2 || i == 6 || i == 5 || i == 3 || i == 4) {
            getKeyboardActions();
        } else if (i != 1 && i != 0) {
            throw new IllegalStateException("invalid ImeAction");
        }
        if (i == 6) {
            FocusOwner focusOwner = (FocusOwner) this.mProviderToLifecycleContainers;
            if (focusOwner != null) {
                ((FocusOwnerImpl) focusOwner).m346moveFocusaToIllA(1, true);
                return true;
            }
            Intrinsics.throwUninitializedPropertyAccessException("focusManager");
            throw null;
        }
        if (i != 5) {
            if (i != 7 || (softwareKeyboardController = (SoftwareKeyboardController) this.mOnInvalidateMenuCallback) == null) {
                return false;
            }
            ((DelegatingSoftwareKeyboardController) softwareKeyboardController).hide();
            return true;
        }
        FocusOwner focusOwner2 = (FocusOwner) this.mProviderToLifecycleContainers;
        if (focusOwner2 != null) {
            ((FocusOwnerImpl) focusOwner2).m346moveFocusaToIllA(2, true);
            return true;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        throw null;
    }

    public void set(Object obj) {
        long jCurrentThreadId = Thread_jvmKt.currentThreadId();
        if (jCurrentThreadId == Thread_androidKt.MainThreadId) {
            this.mProviderToLifecycleContainers = obj;
            return;
        }
        synchronized (this.mMenuProviders) {
            ThreadMap threadMap = (ThreadMap) ((AtomicReference) this.mOnInvalidateMenuCallback).get();
            int iFind = threadMap.find(jCurrentThreadId);
            if (iFind >= 0) {
                threadMap.values[iFind] = obj;
            } else {
                ((AtomicReference) this.mOnInvalidateMenuCallback).set(threadMap.newWith(jCurrentThreadId, obj));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void setCanvas(Canvas canvas) {
        ((CanvasDrawScope) this.mProviderToLifecycleContainers).drawParams.canvas = canvas;
    }

    public void setDensity(Density density) {
        ((CanvasDrawScope) this.mProviderToLifecycleContainers).drawParams.density = density;
    }

    public void setLayoutDirection(LayoutDirection layoutDirection) {
        ((CanvasDrawScope) this.mProviderToLifecycleContainers).drawParams.layoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
    public void m758setSizeuvyYCjk(long j) {
        ((CanvasDrawScope) this.mProviderToLifecycleContainers).drawParams.size = j;
    }

    public void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2) {
        int i3 = constraintWidgetContainer.mMinWidth;
        int i4 = constraintWidgetContainer.mMinHeight;
        constraintWidgetContainer.mMinWidth = 0;
        constraintWidgetContainer.mMinHeight = 0;
        constraintWidgetContainer.setWidth(i);
        constraintWidgetContainer.setHeight(i2);
        if (i3 < 0) {
            constraintWidgetContainer.mMinWidth = 0;
        } else {
            constraintWidgetContainer.mMinWidth = i3;
        }
        if (i4 < 0) {
            constraintWidgetContainer.mMinHeight = 0;
        } else {
            constraintWidgetContainer.mMinHeight = i4;
        }
        ((ConstraintWidgetContainer) this.mProviderToLifecycleContainers).layout();
    }

    public void unregister() {
        MutableScatterMap mutableScatterMap = (MutableScatterMap) this.mOnInvalidateMenuCallback;
        String str = (String) this.mMenuProviders;
        List list = (List) mutableScatterMap.remove(str);
        if (list != null) {
            list.remove((Function0) this.mProviderToLifecycleContainers);
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        mutableScatterMap.set(str, list);
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        switch (this.$r8$classId) {
            case 17:
                ((MutableIntList) this.mOnInvalidateMenuCallback).add(0);
                break;
            default:
                this.mProviderToLifecycleContainers = Stack.m293popimpl((ArrayList) this.mMenuProviders);
                break;
        }
    }

    public /* synthetic */ MenuHostHelper(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.$r8$classId = i;
        this.mProviderToLifecycleContainers = obj;
        this.mOnInvalidateMenuCallback = obj2;
        this.mMenuProviders = obj3;
    }

    public MenuHostHelper(Recomposer$$ExternalSyntheticLambda1 recomposer$$ExternalSyntheticLambda1) {
        this.$r8$classId = 16;
        this.mOnInvalidateMenuCallback = new AtomicInt(0);
        this.mMenuProviders = new Request(6);
        this.mProviderToLifecycleContainers = new Recomposer$$ExternalSyntheticLambda6(18, this, recomposer$$ExternalSyntheticLambda1);
    }

    public MenuHostHelper(SoftwareKeyboardController softwareKeyboardController) {
        this.$r8$classId = 14;
        this.mOnInvalidateMenuCallback = softwareKeyboardController;
    }

    public MenuHostHelper(Database_Impl database_Impl) {
        this.$r8$classId = 1;
        this.mOnInvalidateMenuCallback = database_Impl;
        this.mMenuProviders = new ImportedDao_Impl$1(this, database_Impl, 1);
        this.mProviderToLifecycleContainers = new ImportedDao_Impl$2(database_Impl, 2);
    }

    public MenuHostHelper(StreamConfigurationMap streamConfigurationMap, SurfaceRequest.AnonymousClass1 anonymousClass1) {
        this.$r8$classId = 5;
        this.mProviderToLifecycleContainers = new HashMap();
        new HashMap();
        new HashMap();
        this.mOnInvalidateMenuCallback = new PreviewView.AnonymousClass1(10, streamConfigurationMap);
        this.mMenuProviders = anonymousClass1;
    }

    public MenuHostHelper(ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0) {
        this.$r8$classId = 8;
        this.mMenuProviders = new Object();
        this.mOnInvalidateMenuCallback = new ArrayDeque(3);
        this.mProviderToLifecycleContainers = zslControlImpl$$ExternalSyntheticLambda0;
    }

    public MenuHostHelper(View view) {
        this.$r8$classId = 24;
        this.mOnInvalidateMenuCallback = view;
        this.mMenuProviders = LazyKt__LazyJVMKt.lazy(3, new Handshake.AnonymousClass2(14, this));
        this.mProviderToLifecycleContainers = new Parameters.Builder(view);
    }

    public MenuHostHelper(CanvasDrawScope canvasDrawScope) {
        this.$r8$classId = 20;
        this.mProviderToLifecycleContainers = canvasDrawScope;
        this.mOnInvalidateMenuCallback = new Parameters.Builder(5, this);
    }

    private final /* synthetic */ void onEndChanges$androidx$compose$runtime$RecordingApplier() {
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public void requestPermission() {
    }

    public MenuHostHelper(Context context, TypedArray typedArray) {
        this.$r8$classId = 3;
        this.mOnInvalidateMenuCallback = context;
        this.mMenuProviders = typedArray;
    }

    public MenuHostHelper(Runnable runnable) {
        this.$r8$classId = 0;
        this.mMenuProviders = new CopyOnWriteArrayList();
        this.mProviderToLifecycleContainers = new HashMap();
        this.mOnInvalidateMenuCallback = runnable;
    }

    public MenuHostHelper(Context context, LocationManager locationManager) {
        this.$r8$classId = 2;
        this.mProviderToLifecycleContainers = new TwilightManager$TwilightState();
        this.mOnInvalidateMenuCallback = context;
        this.mMenuProviders = locationManager;
    }

    public MenuHostHelper(ConstraintWidgetContainer constraintWidgetContainer) {
        this.$r8$classId = 28;
        this.mOnInvalidateMenuCallback = new ArrayList();
        this.mMenuProviders = new BasicMeasure$Measure();
        this.mProviderToLifecycleContainers = constraintWidgetContainer;
    }

    public MenuHostHelper(CameraInternal cameraInternal, DefaultSurfaceProcessor defaultSurfaceProcessor) {
        this.$r8$classId = 9;
        this.mMenuProviders = cameraInternal;
        this.mOnInvalidateMenuCallback = defaultSurfaceProcessor;
    }

    public MenuHostHelper(TypefaceResult$Immutable typefaceResult$Immutable, MenuHostHelper menuHostHelper) {
        this.$r8$classId = 26;
        this.mOnInvalidateMenuCallback = typefaceResult$Immutable;
        this.mMenuProviders = menuHostHelper;
        this.mProviderToLifecycleContainers = typefaceResult$Immutable.value;
    }

    public MenuHostHelper(LayoutNode layoutNode) {
        this.$r8$classId = 23;
        this.mOnInvalidateMenuCallback = layoutNode;
        this.mMenuProviders = new ArrayList();
        this.mProviderToLifecycleContainers = layoutNode;
    }

    public MenuHostHelper(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 18:
                this.mOnInvalidateMenuCallback = new AtomicReference(Thread_jvmKt.emptyThreadMap);
                this.mMenuProviders = new Object();
                break;
            case 21:
                break;
            case 22:
                this.mOnInvalidateMenuCallback = new MemoryCacheService(6);
                this.mMenuProviders = new MemoryCacheService(6);
                this.mProviderToLifecycleContainers = new MemoryCacheService(6);
                break;
            case 25:
                this.mProviderToLifecycleContainers = new EmptyNetworkObserver();
                break;
            case 27:
                this.mOnInvalidateMenuCallback = new WeakHashMap();
                this.mMenuProviders = new WeakHashMap();
                this.mProviderToLifecycleContainers = new WeakHashMap();
                break;
            default:
                long[] jArr = ScatterMapKt.EmptyGroup;
                this.mOnInvalidateMenuCallback = new MutableScatterMap();
                break;
        }
    }

    public MenuHostHelper(Object obj) {
        this.$r8$classId = 17;
        this.mOnInvalidateMenuCallback = new MutableIntList();
        this.mMenuProviders = new MutableObjectList();
        this.mProviderToLifecycleContainers = obj;
    }

    public MenuHostHelper(AndroidRippleNode androidRippleNode) {
        this.$r8$classId = 15;
        this.mProviderToLifecycleContainers = androidRippleNode;
        this.mOnInvalidateMenuCallback = new Http2Connection.Builder();
    }

    public MenuHostHelper(SurfaceRequest.AnonymousClass1 anonymousClass1) {
        this.$r8$classId = 4;
        this.mProviderToLifecycleContainers = anonymousClass1;
        this.mMenuProviders = new AtomicBoolean(false);
        this.mOnInvalidateMenuCallback = ((Camera2CameraImpl) anonymousClass1.val$requestCancellationFuture).mScheduledExecutorService.schedule(new Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0(0, this), 2000L, TimeUnit.MILLISECONDS);
    }
}
