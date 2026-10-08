package androidx.compose.runtime;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.BorderCache;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.BorderModifierNode;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.foundation.style.ResolvedStyle;
import androidx.compose.foundation.style.StyleOuterNode;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LongPressTextDragObserverKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.modifier.AddTextContextMenuDataComponentsNode;
import androidx.compose.foundation.text.contextmenu.modifier.AddTextContextMenuDataComponentsWithContextNode;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.input.internal.RecordingInputConnection;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectableInfo;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.material3.FadeInFadeOutAnimationItem;
import androidx.compose.material3.ModalBottomSheetDialogWrapper;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.MultiParagraph$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import androidx.core.view.MenuHostHelper;
import coil.network.HttpException;
import coil.request.Parameters;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Recomposer$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Recomposer$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:191:0x0512  */
    /* JADX WARN: Code duplicated, block: B:201:0x054f  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        BlendModeColorFilter blendModeColorFilter;
        int i;
        boolean z;
        AndroidImageBitmap androidImageBitmapM412ImageBitmapx__hDU$default;
        AndroidCanvas androidCanvasCanvas;
        LazyListMeasureResult lazyListMeasureResult;
        int i2 = 5;
        int i3 = 10;
        int i4 = 11;
        float f = 0.0f;
        LazyListMeasureResult lazyListMeasureResult2 = null;
        switch (this.$r8$classId) {
            case 0:
                ((CompositionImpl) this.f$0).recordReadOf(obj);
                return Unit.INSTANCE;
            case 1:
                AnimationScope animationScope = (AnimationScope) obj;
                ((Function2) this.f$0).invoke(animationScope.value$delegate.getValue(), ArcSplineKt.FloatToVector.convertFromVector.invoke(animationScope.velocityVector));
                return Unit.INSTANCE;
            case 2:
                BorderModifierNode borderModifierNode = (BorderModifierNode) this.f$0;
                CacheDrawScope cacheDrawScope = (CacheDrawScope) obj;
                if (cacheDrawScope.getDensity() * borderModifierNode.width < 0.0f || Size.m386getMinDimensionimpl(cacheDrawScope.cacheParams.mo337getSizeNHjbRc()) <= 0.0f) {
                    return cacheDrawScope.onDrawWithContent(new BorderKt$$ExternalSyntheticLambda1(0));
                }
                float f2 = 2;
                final float fMin = Math.min(Dp.m704equalsimpl0(borderModifierNode.width, 0.0f) ? 1.0f : (float) Math.ceil(cacheDrawScope.getDensity() * borderModifierNode.width), (float) Math.ceil(Size.m386getMinDimensionimpl(cacheDrawScope.cacheParams.mo337getSizeNHjbRc()) / f2));
                final float f3 = fMin / f2;
                final long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L);
                final long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo337getSizeNHjbRc() >> 32)) - fMin)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo337getSizeNHjbRc() & 4294967295L)) - fMin)) & 4294967295L);
                float f4 = fMin * f2;
                boolean z2 = f4 > Size.m386getMinDimensionimpl(cacheDrawScope.cacheParams.mo337getSizeNHjbRc());
                BrushKt brushKtMo60createOutlinePq9zytI = borderModifierNode.shape.mo60createOutlinePq9zytI(cacheDrawScope.cacheParams.mo337getSizeNHjbRc(), cacheDrawScope.cacheParams.getLayoutDirection(), cacheDrawScope);
                if (!(brushKtMo60createOutlinePq9zytI instanceof Outline$Generic)) {
                    if (!(brushKtMo60createOutlinePq9zytI instanceof Outline$Rounded)) {
                        boolean z3 = z2;
                        if (!(brushKtMo60createOutlinePq9zytI instanceof Outline$Rectangle)) {
                            throw new HttpException();
                        }
                        final SolidColor solidColor = borderModifierNode.brush;
                        if (z3) {
                            jFloatToRawIntBits = 0;
                        }
                        final long j = jFloatToRawIntBits;
                        if (z3) {
                            jFloatToRawIntBits2 = cacheDrawScope.cacheParams.mo337getSizeNHjbRc();
                        }
                        final long j2 = jFloatToRawIntBits2;
                        final DrawStyle stroke = z3 ? Fill.INSTANCE : new Stroke(fMin, 0.0f, 0, 0, 30);
                        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj2;
                                layoutNodeDrawScope.drawContent();
                                Modifier.CC.m314drawRectAsUm42w$default(layoutNodeDrawScope, solidColor, j, j2, 0.0f, stroke, null, 0, 104);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    final SolidColor solidColor2 = borderModifierNode.brush;
                    RoundRect roundRect = ((Outline$Rounded) brushKtMo60createOutlinePq9zytI).roundRect;
                    if (RoundRectKt.isSimple(roundRect)) {
                        final long j3 = roundRect.topLeftCornerRadius;
                        final Stroke stroke2 = new Stroke(fMin, 0.0f, 0, 0, 30);
                        final boolean z4 = z2;
                        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) throws Throwable {
                                MenuHostHelper menuHostHelper;
                                long j4;
                                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj2;
                                layoutNodeDrawScope.drawContent();
                                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                                boolean z5 = z4;
                                Brush brush = solidColor2;
                                long j5 = j3;
                                if (z5) {
                                    Modifier.CC.m316drawRoundRectZuiqVtQ$default(layoutNodeDrawScope, brush, 0L, 0L, j5, 0.0f, null, null, 0, 246);
                                } else {
                                    float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
                                    float f5 = f3;
                                    if (fIntBitsToFloat < f5) {
                                        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() >> 32));
                                        float f6 = fMin;
                                        float f7 = fIntBitsToFloat2 - f6;
                                        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() & 4294967295L)) - f6;
                                        MenuHostHelper menuHostHelper2 = canvasDrawScope.drawContext;
                                        long jM756getSizeNHjbRc = menuHostHelper2.m756getSizeNHjbRc();
                                        menuHostHelper2.getCanvas().save();
                                        try {
                                            ((Parameters.Builder) menuHostHelper2.mOnInvalidateMenuCallback).m790clipRectN_I0leg(f6, f6, f7, fIntBitsToFloat3, 0);
                                            menuHostHelper = menuHostHelper2;
                                            try {
                                                Modifier.CC.m316drawRoundRectZuiqVtQ$default(layoutNodeDrawScope, brush, 0L, 0L, j5, 0.0f, null, null, 0, 246);
                                                ImageAnalysis$$ExternalSyntheticLambda1.m(menuHostHelper, jM756getSizeNHjbRc);
                                            } catch (Throwable th) {
                                                th = th;
                                                j4 = jM756getSizeNHjbRc;
                                                ImageAnalysis$$ExternalSyntheticLambda1.m(menuHostHelper, j4);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            menuHostHelper = menuHostHelper2;
                                            j4 = jM756getSizeNHjbRc;
                                        }
                                    } else {
                                        Modifier.CC.m316drawRoundRectZuiqVtQ$default(layoutNodeDrawScope, brush, jFloatToRawIntBits, jFloatToRawIntBits2, ImageKt.m54shrinkKibmq7A(f5, j5), 0.0f, stroke2, null, 0, 208);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    boolean z5 = z2;
                    if (borderModifierNode.borderCache == null) {
                        borderModifierNode.borderCache = new BorderCache();
                    }
                    BorderCache borderCache = borderModifierNode.borderCache;
                    AndroidPath androidPathPath = borderCache.borderPath;
                    if (androidPathPath == null) {
                        androidPathPath = AndroidPath_androidKt.Path();
                        borderCache.borderPath = androidPathPath;
                    }
                    androidPathPath.reset();
                    Modifier.CC.addRoundRect$default(androidPathPath, roundRect);
                    if (!z5) {
                        AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
                        Modifier.CC.addRoundRect$default(androidPathPath2, new RoundRect(fMin, fMin, roundRect.getWidth() - fMin, roundRect.getHeight() - fMin, ImageKt.m54shrinkKibmq7A(fMin, roundRect.topLeftCornerRadius), ImageKt.m54shrinkKibmq7A(fMin, roundRect.topRightCornerRadius), ImageKt.m54shrinkKibmq7A(fMin, roundRect.bottomRightCornerRadius), ImageKt.m54shrinkKibmq7A(fMin, roundRect.bottomLeftCornerRadius)));
                        androidPathPath.m409opN5in7k0(androidPathPath, androidPathPath2, 0);
                    }
                    return cacheDrawScope.onDrawWithContent(new BackHandlerKt$$ExternalSyntheticLambda2(i3, androidPathPath, solidColor2));
                }
                SolidColor solidColor3 = borderModifierNode.brush;
                Outline$Generic outline$Generic = (Outline$Generic) brushKtMo60createOutlinePq9zytI;
                AndroidPath androidPath = outline$Generic.path;
                if (z2) {
                    return cacheDrawScope.onDrawWithContent(new BackHandlerKt$$ExternalSyntheticLambda2(i4, outline$Generic, solidColor3));
                }
                if (ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) solidColor3)) {
                    long j4 = solidColor3.value;
                    blendModeColorFilter = new BlendModeColorFilter(5, BrushKt.Color(Color.m440getRedimpl(j4), Color.m439getGreenimpl(j4), Color.m437getBlueimpl(j4), 1.0f, Color.m438getColorSpaceimpl(j4)));
                    i = 1;
                } else {
                    blendModeColorFilter = null;
                    i = 0;
                }
                Rect bounds = androidPath.getBounds();
                float f5 = bounds.top;
                float f6 = bounds.left;
                if (borderModifierNode.borderCache == null) {
                    borderModifierNode.borderCache = new BorderCache();
                }
                BorderCache borderCache2 = borderModifierNode.borderCache;
                AndroidPath androidPathPath3 = borderCache2.borderPath;
                if (androidPathPath3 == null) {
                    androidPathPath3 = AndroidPath_androidKt.Path();
                    borderCache2.borderPath = androidPathPath3;
                }
                androidPathPath3.reset();
                Modifier.CC.addRect$default(androidPathPath3, bounds);
                androidPathPath3.m409opN5in7k0(androidPathPath3, androidPath, 0);
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                long jCeil = (((long) ((int) Math.ceil(bounds.right - f6))) << 32) | (((long) ((int) Math.ceil(bounds.bottom - f5))) & 4294967295L);
                BorderCache borderCache3 = borderModifierNode.borderCache;
                AndroidImageBitmap androidImageBitmap = borderCache3.imageBitmap;
                AndroidCanvas androidCanvas = borderCache3.canvas;
                ImageBitmapConfig imageBitmapConfig = androidImageBitmap != null ? new ImageBitmapConfig(androidImageBitmap.m400getConfig_sVssgQ()) : null;
                if (imageBitmapConfig != null && imageBitmapConfig.value == 0) {
                    z = true;
                } else {
                    ImageBitmapConfig imageBitmapConfig2 = androidImageBitmap != null ? new ImageBitmapConfig(androidImageBitmap.m400getConfig_sVssgQ()) : null;
                    if (ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) imageBitmapConfig2) && i == imageBitmapConfig2.value) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (androidImageBitmap == null || androidCanvas == null) {
                    androidImageBitmapM412ImageBitmapx__hDU$default = BrushKt.m412ImageBitmapx__hDU$default((int) (jCeil >> 32), (int) (jCeil & 4294967295L), i);
                    borderCache3.imageBitmap = androidImageBitmapM412ImageBitmapx__hDU$default;
                    androidCanvasCanvas = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default);
                    borderCache3.canvas = androidCanvasCanvas;
                } else {
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo337getSizeNHjbRc() >> 32));
                    Bitmap bitmap = androidImageBitmap.bitmap;
                    if (fIntBitsToFloat > bitmap.getWidth() || Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo337getSizeNHjbRc() & 4294967295L)) > bitmap.getHeight() || !z) {
                        androidImageBitmapM412ImageBitmapx__hDU$default = BrushKt.m412ImageBitmapx__hDU$default((int) (jCeil >> 32), (int) (jCeil & 4294967295L), i);
                        borderCache3.imageBitmap = androidImageBitmapM412ImageBitmapx__hDU$default;
                        androidCanvasCanvas = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default);
                        borderCache3.canvas = androidCanvasCanvas;
                    } else {
                        androidImageBitmapM412ImageBitmapx__hDU$default = androidImageBitmap;
                        androidCanvasCanvas = androidCanvas;
                    }
                }
                CanvasDrawScope canvasDrawScope = borderCache3.canvasDrawScope;
                if (canvasDrawScope == null) {
                    canvasDrawScope = new CanvasDrawScope();
                    borderCache3.canvasDrawScope = canvasDrawScope;
                }
                MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
                CanvasDrawScope.DrawParams drawParams = canvasDrawScope.drawParams;
                long jM724toSizeozmzZPI = IntSizeKt.m724toSizeozmzZPI(jCeil);
                LayoutDirection layoutDirection = cacheDrawScope.cacheParams.getLayoutDirection();
                CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
                Density density = drawParams.density;
                LayoutDirection layoutDirection2 = drawParams.layoutDirection;
                AndroidPath androidPath2 = androidPathPath3;
                Canvas canvas = drawParams.canvas;
                long j5 = drawParams.size;
                drawParams.density = cacheDrawScope;
                drawParams.layoutDirection = layoutDirection;
                drawParams.canvas = androidCanvasCanvas;
                drawParams.size = jM724toSizeozmzZPI;
                androidCanvasCanvas.save();
                Modifier.CC.m315drawRectnJ9OG0$default(canvasDrawScope2, Color.Black, jM724toSizeozmzZPI, 0.0f, 0, 58);
                float f7 = -f6;
                float f8 = -f5;
                ((Parameters.Builder) menuHostHelper.mOnInvalidateMenuCallback).translate(f7, f8);
                try {
                    Modifier.CC.m312drawPathGBMwjPU$default(canvasDrawScope2, outline$Generic.path, solidColor3, 0.0f, new Stroke(f4, 0.0f, 0, 0, 30), null, 0, 52);
                    float f9 = 1;
                    float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (menuHostHelper.m756getSizeNHjbRc() >> 32)) + f9) / Float.intBitsToFloat((int) (menuHostHelper.m756getSizeNHjbRc() >> 32));
                    float fIntBitsToFloat3 = (Float.intBitsToFloat((int) (menuHostHelper.m756getSizeNHjbRc() & 4294967295L)) + f9) / Float.intBitsToFloat((int) (menuHostHelper.m756getSizeNHjbRc() & 4294967295L));
                    long jMo473getCenterF1C5BW0 = canvasDrawScope2.mo473getCenterF1C5BW0();
                    AndroidCanvas androidCanvas2 = androidCanvasCanvas;
                    long jM756getSizeNHjbRc = menuHostHelper.m756getSizeNHjbRc();
                    menuHostHelper.getCanvas().save();
                    try {
                        ((Parameters.Builder) menuHostHelper.mOnInvalidateMenuCallback).m792scale0AR0LA0(fIntBitsToFloat2, fIntBitsToFloat3, jMo473getCenterF1C5BW0);
                        Modifier.CC.m312drawPathGBMwjPU$default(canvasDrawScope2, androidPath2, solidColor3, 0.0f, null, null, 0, 28);
                        menuHostHelper.getCanvas().restore();
                        menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
                        ((Parameters.Builder) menuHostHelper.mOnInvalidateMenuCallback).translate(-f7, -f8);
                        androidCanvas2.restore();
                        drawParams.density = density;
                        drawParams.layoutDirection = layoutDirection2;
                        drawParams.canvas = canvas;
                        drawParams.size = j5;
                        androidImageBitmapM412ImageBitmapx__hDU$default.bitmap.prepareToDraw();
                        ref$ObjectRef.element = androidImageBitmapM412ImageBitmapx__hDU$default;
                        return cacheDrawScope.onDrawWithContent(new MultiParagraph$$ExternalSyntheticLambda0(bounds, ref$ObjectRef, jCeil, blendModeColorFilter));
                    } catch (Throwable th) {
                        menuHostHelper.getCanvas().restore();
                        menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
                        throw th;
                    }
                } catch (Throwable th2) {
                    ((Parameters.Builder) menuHostHelper.mOnInvalidateMenuCallback).translate(-f7, -f8);
                    throw th2;
                }
            case 3:
                ScrollState scrollState = (ScrollState) this.f$0;
                float fFloatValue = ((Float) obj).floatValue();
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = scrollState.value$delegate;
                float intValue = parcelableSnapshotMutableIntState.getIntValue() + fFloatValue + scrollState.accumulator;
                float fCoerceIn = RangesKt.coerceIn(intValue, 0.0f, scrollState._maxValueState.getIntValue());
                boolean z6 = intValue == fCoerceIn;
                float intValue2 = fCoerceIn - parcelableSnapshotMutableIntState.getIntValue();
                int iRound = Math.round(intValue2);
                parcelableSnapshotMutableIntState.setIntValue(parcelableSnapshotMutableIntState.getIntValue() + iRound);
                scrollState.accumulator = intValue2 - iRound;
                if (!z6) {
                    fFloatValue = intValue2;
                }
                return Float.valueOf(fFloatValue);
            case 4:
                ((LongPressTextDragObserverKt$$ExternalSyntheticLambda1) this.f$0).invoke();
                return Unit.INSTANCE;
            case 5:
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                ((TextKt$$ExternalSyntheticLambda2) this.f$0).invoke(pointerInputChange, Float.valueOf(Float.intBitsToFloat((int) (PointerId.positionChangeInternal(pointerInputChange, false) >> 32))));
                pointerInputChange.consume();
                return Unit.INSTANCE;
            case 6:
                ScrollingLogic scrollingLogic = (ScrollingLogic) this.f$0;
                return new Offset(scrollingLogic.m105performScroll3eAAhYA(scrollingLogic.outerStateScope, ((Offset) obj).packedValue, scrollingLogic.latestScrollSource));
            case 7:
                MutableVector mutableVector = (MutableVector) this.f$0;
                Object[] objArr = mutableVector.content;
                int i5 = mutableVector.size;
                for (int i6 = 0; i6 < i5; i6++) {
                    ((MeasureResult) objArr[i6]).placeChildren();
                }
                return Unit.INSTANCE;
            case 8:
                Object obj2 = this.f$0;
                ((Integer) obj).intValue();
                return obj2;
            case 9:
                LazyListState lazyListState = (LazyListState) this.f$0;
                float f10 = -((Float) obj).floatValue();
                if ((f10 >= 0.0f || lazyListState.getCanScrollForward()) && (f10 <= 0.0f || lazyListState.getCanScrollBackward())) {
                    if (Math.abs(lazyListState.scrollToBeConsumed) > 0.5f) {
                        InlineClassHelperKt.throwIllegalStateException("entered drag with non-zero pending scroll");
                    }
                    lazyListState.executeRequestsInHighPriorityMode = true;
                    float f11 = lazyListState.scrollToBeConsumed + f10;
                    lazyListState.scrollToBeConsumed = f11;
                    if (Math.abs(f11) > 0.5f) {
                        float f12 = lazyListState.scrollToBeConsumed;
                        int iRound2 = Math.round(f12);
                        LazyListMeasureResult lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure = ((LazyListMeasureResult) lazyListState.layoutInfoState.getValue()).copyWithScrollDeltaWithoutRemeasure(iRound2, !lazyListState.hasLookaheadOccurred);
                        if (lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure == null || (lazyListMeasureResult = lazyListState.approachLayoutInfo) == null) {
                            lazyListMeasureResult2 = lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure;
                        } else {
                            LazyListMeasureResult lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure2 = lazyListMeasureResult.copyWithScrollDeltaWithoutRemeasure(iRound2, true);
                            if (lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure2 != null) {
                                lazyListState.approachLayoutInfo = lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure2;
                                lazyListMeasureResult2 = lazyListMeasureResultCopyWithScrollDeltaWithoutRemeasure;
                            }
                        }
                        if (lazyListMeasureResult2 != null) {
                            lazyListState.applyMeasureResult$foundation(lazyListMeasureResult2, lazyListState.hasLookaheadOccurred, true);
                            lazyListState.placementScopeInvalidator.setValue(Unit.INSTANCE);
                            lazyListState.notifyPrefetchOnScroll(f12 - lazyListState.scrollToBeConsumed, lazyListMeasureResult2);
                        } else {
                            LayoutNode layoutNode = lazyListState.remeasurement;
                            if (layoutNode != null) {
                                layoutNode.forceRemeasure();
                            }
                            lazyListState.notifyPrefetchOnScroll(f12 - lazyListState.scrollToBeConsumed, lazyListState.getLayoutInfo());
                        }
                    }
                    if (Math.abs(lazyListState.scrollToBeConsumed) > 0.5f) {
                        f10 -= lazyListState.scrollToBeConsumed;
                        lazyListState.scrollToBeConsumed = 0.0f;
                    }
                    f = f10;
                }
                return Float.valueOf(-f);
            case 10:
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(3, (LazyLayoutItemContentFactory.CachedItemContent) this.f$0);
            case 11:
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(i2, (LazyLayoutPinnableItem) this.f$0);
            case 12:
                SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) this.f$0;
                return Boolean.valueOf(saveableStateRegistry != null ? saveableStateRegistry.canBeSaved(obj) : true);
            case 13:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default = StyleOuterNode.resolveAnimatedStyleFor$foundation$default((StyleOuterNode) this.f$0, 4);
                reusableGraphicsLayerScope.setAlpha(resolvedStyleResolveAnimatedStyleFor$foundation$default.alpha);
                reusableGraphicsLayerScope.setScaleX(resolvedStyleResolveAnimatedStyleFor$foundation$default.scaleX);
                reusableGraphicsLayerScope.setScaleY(resolvedStyleResolveAnimatedStyleFor$foundation$default.scaleY);
                reusableGraphicsLayerScope.setTranslationX(resolvedStyleResolveAnimatedStyleFor$foundation$default.translationX);
                reusableGraphicsLayerScope.setTranslationY(resolvedStyleResolveAnimatedStyleFor$foundation$default.translationY);
                reusableGraphicsLayerScope.setRotationX(resolvedStyleResolveAnimatedStyleFor$foundation$default.rotationX);
                reusableGraphicsLayerScope.setRotationY(resolvedStyleResolveAnimatedStyleFor$foundation$default.rotationY);
                reusableGraphicsLayerScope.setRotationZ(resolvedStyleResolveAnimatedStyleFor$foundation$default.rotationZ);
                reusableGraphicsLayerScope.m450setTransformOrigin__ExYCQ(resolvedStyleResolveAnimatedStyleFor$foundation$default.transformOrigin);
                reusableGraphicsLayerScope.setClip(resolvedStyleResolveAnimatedStyleFor$foundation$default.clip);
                reusableGraphicsLayerScope.setShape(resolvedStyleResolveAnimatedStyleFor$foundation$default.shape);
                return Unit.INSTANCE;
            case 14:
                ((SemanticsPropertyReceiver) obj).set(SelectionHandlesKt.SelectionHandleInfoKey, new SelectionHandleInfo(Handle.Cursor, ((OffsetProvider) this.f$0).mo169provideF1C5BW0(), 2, true));
                return Unit.INSTANCE;
            case 15:
                TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) this.f$0;
                float fFloatValue2 = ((Float) obj).floatValue();
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = textFieldScrollerPosition.offset$delegate;
                float floatValue = parcelableSnapshotMutableFloatState.getFloatValue() + fFloatValue2;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = textFieldScrollerPosition.maximum$delegate;
                if (floatValue > parcelableSnapshotMutableFloatState2.getFloatValue()) {
                    fFloatValue2 = parcelableSnapshotMutableFloatState2.getFloatValue() - parcelableSnapshotMutableFloatState.getFloatValue();
                } else if (floatValue < 0.0f) {
                    fFloatValue2 = -parcelableSnapshotMutableFloatState.getFloatValue();
                }
                parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState.getFloatValue() + fFloatValue2);
                return Float.valueOf(fFloatValue2);
            case 16:
                Drawable drawable = (Drawable) this.f$0;
                DrawScope drawScope = (DrawScope) obj;
                Canvas canvas2 = drawScope.getDrawContext().getCanvas();
                drawable.setBounds(0, 0, (int) Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32)), (int) Float.intBitsToFloat((int) (4294967295L & drawScope.mo474getSizeNHjbRc())));
                android.graphics.Canvas canvas3 = AndroidCanvas_androidKt.EmptyCanvas;
                drawable.draw(((AndroidCanvas) canvas2).internalCanvas);
                return Unit.INSTANCE;
            case 17:
                AddTextContextMenuDataComponentsWithContextNode addTextContextMenuDataComponentsWithContextNode = (AddTextContextMenuDataComponentsWithContextNode) this.f$0;
                addTextContextMenuDataComponentsWithContextNode.builder.invoke((TextContextMenuBuilderScope) obj, HitTestResultKt.currentValueOf(addTextContextMenuDataComponentsWithContextNode, AndroidCompositionLocals_androidKt.LocalContext));
                return Unit.INSTANCE;
            case 18:
                ((Function1) obj).invoke((TextContextMenuBuilderScope) this.f$0);
                return Unit.INSTANCE;
            case 19:
                Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = (Recomposer$$ExternalSyntheticLambda0) this.f$0;
                TraversableNode traversableNode = (TraversableNode) obj;
                if (!(traversableNode instanceof AddTextContextMenuDataComponentsNode)) {
                    throw new IllegalStateException("TextContextMenuDataNode.TraverseKey key must only be attached to instances of TextContextMenuDataNode.");
                }
                recomposer$$ExternalSyntheticLambda0.invoke(((AddTextContextMenuDataComponentsNode) traversableNode).builder);
                return Boolean.TRUE;
            case 20:
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(8, (BasicTextContextMenuProvider) this.f$0);
            case 21:
                ((RecordingInputConnection) this.f$0).addEditCommandWithBatch((EditCommand) obj);
                return Unit.INSTANCE;
            case 22:
                PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
                if (((MouseSelectionObserver) this.f$0).mo209onExtendDragk4lQ0M(pointerInputChange2.position)) {
                    pointerInputChange2.consume();
                }
                return Unit.INSTANCE;
            case 23:
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) this.f$0;
                if (((SelectableInfo) obj).textLayoutResult.layoutInput.text.text.length() > 0) {
                    ref$BooleanRef.element = false;
                }
                return Unit.INSTANCE;
            case 24:
                ArrayList arrayList = (ArrayList) this.f$0;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList.get(i7), 0, 0);
                }
                return Unit.INSTANCE;
            case 25:
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper = (ModalBottomSheetDialogWrapper) this.f$0;
                modalBottomSheetDialogWrapper.show();
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(i3, modalBottomSheetDialogWrapper);
            case 26:
                return Boolean.valueOf(Intrinsics.areEqual(((FadeInFadeOutAnimationItem) obj).key, (SnackbarHostState.SnackbarDataImpl) this.f$0));
            case 27:
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(i4, (TooltipStateImpl) this.f$0);
            case 28:
                Recomposer recomposer = (Recomposer) this.f$0;
                Throwable th3 = (Throwable) obj;
                CancellationException cancellationException = new CancellationException("Recomposer effect job completed");
                cancellationException.initCause(th3);
                synchronized (recomposer.stateLock) {
                    try {
                        Job job = recomposer.runnerJob;
                        if (job != null) {
                            StateFlowImpl stateFlowImpl = recomposer._state;
                            Recomposer.State state = Recomposer.State.ShuttingDown;
                            stateFlowImpl.getClass();
                            stateFlowImpl.updateState(null, state);
                            job.cancel(cancellationException);
                            recomposer.workContinuation = null;
                            job.invokeOnCompletion(new BlurEffectKt$$ExternalSyntheticLambda1(9, recomposer, th3));
                        } else {
                            recomposer.closeCause = cancellationException;
                            StateFlowImpl stateFlowImpl2 = recomposer._state;
                            Recomposer.State state2 = Recomposer.State.ShutDown;
                            stateFlowImpl2.getClass();
                            stateFlowImpl2.updateState(null, state2);
                            Unit unit = Unit.INSTANCE;
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
                return Unit.INSTANCE;
            default:
                SingleSubscriptionSnapshotFlowManager singleSubscriptionSnapshotFlowManager = (SingleSubscriptionSnapshotFlowManager) this.f$0;
                SendChannel sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
                if (!Intrinsics.areEqual(sendChannel, sendChannel)) {
                    PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
                }
                MutableScatterSet mutableScatterSet = singleSubscriptionSnapshotFlowManager.workingWatchSet;
                Object obj3 = singleSubscriptionSnapshotFlowManager.workingSoleWatchedObject;
                if (mutableScatterSet != null) {
                    if (obj3 != null) {
                        PreconditionsKt.throwIllegalStateException("workingSoleWatchedObject must be null when workingWatchSet is non-null");
                    }
                    mutableScatterSet.add(obj);
                } else if (obj3 == null) {
                    singleSubscriptionSnapshotFlowManager.workingSoleWatchedObject = obj;
                } else {
                    MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                    MutableScatterSet mutableScatterSet3 = new MutableScatterSet();
                    mutableScatterSet3.add(obj3);
                    mutableScatterSet3.add(obj);
                    singleSubscriptionSnapshotFlowManager.workingWatchSet = mutableScatterSet3;
                    singleSubscriptionSnapshotFlowManager.workingSoleWatchedObject = null;
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ Recomposer$$ExternalSyntheticLambda0(Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0, JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1) {
        this.$r8$classId = 19;
        this.f$0 = recomposer$$ExternalSyntheticLambda0;
    }
}
