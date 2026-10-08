package dev.chrisbanes.haze;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.Surface;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import coil.request.Parameters;
import java.util.Iterator;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HazeKt {
    public static final void access$drawGraphicsLayer(Surface surface, GraphicsLayer graphicsLayer, Density density, CanvasDrawScope canvasDrawScope) {
        Canvas canvasLockHardwareCanvas = surface.lockHardwareCanvas();
        try {
            canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            CanvasDrawScope.DrawParams drawParams = canvasDrawScope.drawParams;
            LayoutDirection layoutDirection = drawParams.layoutDirection;
            Canvas canvas = AndroidCanvas_androidKt.EmptyCanvas;
            AndroidCanvas androidCanvas = new AndroidCanvas();
            androidCanvas.internalCanvas = canvasLockHardwareCanvas;
            float width = canvasLockHardwareCanvas.getWidth();
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(canvasLockHardwareCanvas.getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32);
            Density density2 = drawParams.density;
            LayoutDirection layoutDirection2 = drawParams.layoutDirection;
            androidx.compose.ui.graphics.Canvas canvas2 = drawParams.canvas;
            long j = drawParams.size;
            drawParams.density = density;
            drawParams.layoutDirection = layoutDirection;
            drawParams.canvas = androidCanvas;
            drawParams.size = jFloatToRawIntBits;
            androidCanvas.save();
            GraphicsLayerKt.drawLayer(canvasDrawScope, graphicsLayer);
            androidCanvas.restore();
            drawParams.density = density2;
            drawParams.layoutDirection = layoutDirection2;
            drawParams.canvas = canvas2;
            drawParams.size = j;
        } finally {
            surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
        }
    }

    /* JADX INFO: renamed from: createScaledContentLayer-wZMzALA, reason: not valid java name */
    public static final GraphicsLayer m825createScaledContentLayerwZMzALA(LayoutNodeDrawScope layoutNodeDrawScope, final HazeEffectNode hazeEffectNode, final float f, long j, final long j2) {
        long jM722roundToIntSizeuvyYCjk = IntSizeKt.m722roundToIntSizeuvyYCjk(Size.m389times7Ah8Wj8(f, j));
        if (((int) (jM722roundToIntSizeuvyYCjk >> 32)) <= 0 || ((int) (4294967295L & jM722roundToIntSizeuvyYCjk)) <= 0) {
            return null;
        }
        GraphicsLayer graphicsLayerCreateGraphicsLayer = ((GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext)).createGraphicsLayer();
        layoutNodeDrawScope.mo475recordJVtK1S4(graphicsLayerCreateGraphicsLayer, jM722roundToIntSizeuvyYCjk, new Function1() { // from class: dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda0
            /* JADX WARN: Code duplicated, block: B:121:0x0233  */
            /* JADX WARN: Code duplicated, block: B:140:0x0275  */
            /* JADX WARN: Code duplicated, block: B:57:0x0132  */
            /* JADX WARN: Code duplicated, block: B:76:0x0175  */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Iterator it;
                GraphicsLayer graphicsLayer;
                float f2 = f;
                long j3 = j2;
                DrawScope drawScope = (DrawScope) obj;
                Object obj2 = HazeEffectNodeKt.renderEffectCache$delegate;
                HazeEffectNode hazeEffectNode2 = hazeEffectNode;
                long j4 = hazeEffectNode2.backgroundColor;
                if (j4 == 16) {
                    j4 = hazeEffectNode2.style.backgroundColor;
                }
                if (j4 == 16) {
                    j4 = hazeEffectNode2.compositionLocalStyle.backgroundColor;
                }
                if (j4 != 16) {
                    Modifier.CC.m315drawRectnJ9OG0$default(drawScope, j4, 0L, 0.0f, 0, 126);
                }
                MenuHostHelper drawContext = drawScope.getDrawContext();
                long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    long j5 = 0;
                    ((Parameters.Builder) drawContext.mOnInvalidateMenuCallback).m792scale0AR0LA0(f2, f2, 0L);
                    long jM372minusMKHz9U = Offset.m372minusMKHz9U(j3, hazeEffectNode2.positionOnScreen);
                    char c = ' ';
                    if (((((jM372minusMKHz9U & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) != 0 || Offset.m369equalsimpl0(jM372minusMKHz9U, 0L)) {
                        for (HazeArea hazeArea : hazeEffectNode2.areas) {
                            if (hazeArea.contentDrawing) {
                                throw new IllegalArgumentException("Modifier.haze nodes can not draw Modifier.hazeChild nodes. This should not happen if you are providing correct values for zIndex on Modifier.haze. Alternatively you can use can `canDrawArea` to to filter out parent areas.");
                            }
                            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                long jM821getPositionOnScreenF1C5BW0 = hazeArea.m821getPositionOnScreenF1C5BW0();
                                if ((jM821getPositionOnScreenF1C5BW0 & 9223372034707292159L) == 9205357640488583168L) {
                                    jM821getPositionOnScreenF1C5BW0 = 0;
                                }
                                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                if (((((jM821getPositionOnScreenF1C5BW0 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) != 0 || Offset.m369equalsimpl0(jM821getPositionOnScreenF1C5BW0, 0L)) {
                                    GraphicsLayer contentLayer = hazeArea.getContentLayer();
                                    if (contentLayer == null) {
                                        contentLayer = null;
                                    } else {
                                        if (contentLayer.isReleased) {
                                            contentLayer = null;
                                        }
                                        if (contentLayer != null) {
                                            long j6 = contentLayer.size;
                                            if (((int) (j6 >> 32)) <= 0 || ((int) (j6 & 4294967295L)) <= 0) {
                                                contentLayer = null;
                                            }
                                        } else {
                                            contentLayer = null;
                                        }
                                    }
                                    if (contentLayer != null) {
                                        GraphicsLayerKt.drawLayer(drawScope, contentLayer);
                                    }
                                } else {
                                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jM821getPositionOnScreenF1C5BW0 >> 32));
                                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM821getPositionOnScreenF1C5BW0 & 4294967295L));
                                    ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(fIntBitsToFloat, fIntBitsToFloat2);
                                    try {
                                        GraphicsLayer contentLayer2 = hazeArea.getContentLayer();
                                        if (contentLayer2 == null) {
                                            contentLayer2 = null;
                                        } else {
                                            if (contentLayer2.isReleased) {
                                                contentLayer2 = null;
                                            }
                                            if (contentLayer2 != null) {
                                                long j7 = contentLayer2.size;
                                                if (((int) (j7 >> 32)) <= 0 || ((int) (j7 & 4294967295L)) <= 0) {
                                                    contentLayer2 = null;
                                                }
                                            } else {
                                                contentLayer2 = null;
                                            }
                                        }
                                        if (contentLayer2 != null) {
                                            GraphicsLayerKt.drawLayer(drawScope, contentLayer2);
                                        }
                                        ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                                    } catch (Throwable th) {
                                        ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                throw th2;
                            }
                        }
                    } else {
                        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jM372minusMKHz9U >> 32));
                        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jM372minusMKHz9U & 4294967295L));
                        ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(fIntBitsToFloat3, fIntBitsToFloat4);
                        try {
                            Iterator it2 = hazeEffectNode2.areas.iterator();
                            while (it2.hasNext()) {
                                HazeArea hazeArea2 = (HazeArea) it2.next();
                                if (hazeArea2.contentDrawing) {
                                    throw new IllegalArgumentException("Modifier.haze nodes can not draw Modifier.hazeChild nodes. This should not happen if you are providing correct values for zIndex on Modifier.haze. Alternatively you can use can `canDrawArea` to to filter out parent areas.");
                                }
                                Snapshot currentThreadSnapshot2 = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                                Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                                char c2 = c;
                                Snapshot snapshotMakeCurrentNonObservable2 = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot2);
                                try {
                                    long jM821getPositionOnScreenF1C5BW1 = hazeArea2.m821getPositionOnScreenF1C5BW0();
                                    if ((jM821getPositionOnScreenF1C5BW1 & 9223372034707292159L) != 9205357640488583168L) {
                                        j5 = jM821getPositionOnScreenF1C5BW1;
                                    }
                                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                                    if (((((j5 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) != j5 || Offset.m369equalsimpl0(j5, j5)) {
                                        it = it2;
                                        GraphicsLayer contentLayer3 = hazeArea2.getContentLayer();
                                        if (contentLayer3 == null) {
                                            graphicsLayer = null;
                                        } else {
                                            if (contentLayer3.isReleased) {
                                                contentLayer3 = null;
                                            }
                                            if (contentLayer3 != null) {
                                                long j8 = contentLayer3.size;
                                                GraphicsLayer graphicsLayer2 = contentLayer3;
                                                if (((int) (j8 >> c2)) <= 0 || ((int) (j8 & 4294967295L)) <= 0) {
                                                    graphicsLayer = null;
                                                } else {
                                                    graphicsLayer = graphicsLayer2;
                                                }
                                            } else {
                                                graphicsLayer = null;
                                            }
                                        }
                                        if (graphicsLayer != null) {
                                            GraphicsLayerKt.drawLayer(drawScope, graphicsLayer);
                                        }
                                    } else {
                                        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (j5 >> c2));
                                        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (j5 & 4294967295L));
                                        ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(fIntBitsToFloat5, fIntBitsToFloat6);
                                        try {
                                            GraphicsLayer contentLayer4 = hazeArea2.getContentLayer();
                                            if (contentLayer4 == null) {
                                                it = it2;
                                                contentLayer4 = null;
                                            } else {
                                                if (contentLayer4.isReleased) {
                                                    contentLayer4 = null;
                                                }
                                                if (contentLayer4 != null) {
                                                    it = it2;
                                                    long j9 = contentLayer4.size;
                                                    if (((int) (j9 >> c2)) <= 0 || ((int) (j9 & 4294967295L)) <= 0) {
                                                    }
                                                } else {
                                                    it = it2;
                                                }
                                                contentLayer4 = null;
                                            }
                                            if (contentLayer4 != null) {
                                                GraphicsLayerKt.drawLayer(drawScope, contentLayer4);
                                            }
                                            ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat5, -fIntBitsToFloat6);
                                        } catch (Throwable th3) {
                                            ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat5, -fIntBitsToFloat6);
                                            throw th3;
                                        }
                                    }
                                    c = c2;
                                    it2 = it;
                                    j5 = 0;
                                } catch (Throwable th4) {
                                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                                    throw th4;
                                }
                            }
                            ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                        } catch (Throwable th5) {
                            ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                            throw th5;
                        }
                    }
                    ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, jM756getSizeNHjbRc);
                    return Unit.INSTANCE;
                } catch (Throwable th6) {
                    ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, jM756getSizeNHjbRc);
                    throw th6;
                }
            }
        });
        return graphicsLayerCreateGraphicsLayer;
    }

    public static final void drawContentSafely(LayoutNodeDrawScope layoutNodeDrawScope) throws Exception {
        try {
            layoutNodeDrawScope.drawContent();
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            if (!StringsKt.contains(message, "mViewFlags", false) && !StringsKt.contains(message, "LayoutNode", false)) {
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: drawScaledContent-LF441nw, reason: not valid java name */
    public static final void m826drawScaledContentLF441nw(DrawScope drawScope, long j, long j2, boolean z, Function1 function1) {
        float fMax = Math.max(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32)) / Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L)) / Float.intBitsToFloat((int) (j2 & 4294967295L)));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L));
        MenuHostHelper drawContext = drawScope.getDrawContext();
        long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            Parameters.Builder builder = (Parameters.Builder) drawContext.mOnInvalidateMenuCallback;
            if (z) {
                builder.m790clipRectN_I0leg(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2, 1);
            }
            if ((((9187343241974906880L ^ (j & 9187343241974906880L)) - 4294967297L) & (-9223372034707292160L)) != 0 || Offset.m369equalsimpl0(j, 0L)) {
                MenuHostHelper drawContext2 = drawScope.getDrawContext();
                long jM756getSizeNHjbRc2 = drawContext2.m756getSizeNHjbRc();
                drawContext2.getCanvas().save();
                try {
                    ((Parameters.Builder) drawContext2.mOnInvalidateMenuCallback).m792scale0AR0LA0(fMax, fMax, 0L);
                    function1.invoke(drawScope);
                    drawContext2.getCanvas().restore();
                    drawContext2.m758setSizeuvyYCjk(jM756getSizeNHjbRc2);
                } catch (Throwable th) {
                    drawContext2.getCanvas().restore();
                    drawContext2.m758setSizeuvyYCjk(jM756getSizeNHjbRc2);
                    throw th;
                }
            } else {
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j >> 32));
                float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j & 4294967295L));
                ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(fIntBitsToFloat3, fIntBitsToFloat4);
                try {
                    MenuHostHelper drawContext3 = drawScope.getDrawContext();
                    long jM756getSizeNHjbRc3 = drawContext3.m756getSizeNHjbRc();
                    drawContext3.getCanvas().save();
                    try {
                        ((Parameters.Builder) drawContext3.mOnInvalidateMenuCallback).m792scale0AR0LA0(fMax, fMax, 0L);
                        function1.invoke(drawScope);
                        drawContext3.getCanvas().restore();
                        drawContext3.m758setSizeuvyYCjk(jM756getSizeNHjbRc3);
                        ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                    } catch (Throwable th2) {
                        drawContext3.getCanvas().restore();
                        drawContext3.m758setSizeuvyYCjk(jM756getSizeNHjbRc3);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                    throw th3;
                }
            }
            ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, jM756getSizeNHjbRc);
        } catch (Throwable th4) {
            ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, jM756getSizeNHjbRc);
            throw th4;
        }
    }

    /* JADX INFO: renamed from: drawScrim-DBWKusU, reason: not valid java name */
    public static final void m827drawScrimDBWKusU(DrawScope drawScope, HazeTint hazeTint, CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, long j, long j2) {
        Brush brush = hazeTint.brush;
        if (brush != null) {
            Modifier.CC.m314drawRectAsUm42w$default(drawScope, brush, j, drawScope.mo474getSizeNHjbRc(), 0.0f, null, null, hazeTint.blendMode, 56);
        } else {
            Modifier.CC.m315drawRectnJ9OG0$default(drawScope, hazeTint.color, j2, 0.0f, hazeTint.blendMode, 58);
        }
    }

    public static final HazeState rememberHazeState(GapComposer gapComposer) {
        float f = HazeDefaults.blurRadius;
        boolean z = Build.VERSION.SDK_INT >= 31;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new HazeState(z);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        HazeState hazeState = (HazeState) objRememberedValue;
        hazeState.blurEnabled$delegate.setValue(Boolean.valueOf(z));
        return hazeState;
    }

    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final BlendMode m828toAndroidBlendModes9anfk8(int i) {
        if (i == 0) {
            return BlendMode.CLEAR;
        }
        if (i == 27) {
            return BlendMode.COLOR;
        }
        if (i == 19) {
            return BlendMode.COLOR_BURN;
        }
        if (i == 18) {
            return BlendMode.COLOR_DODGE;
        }
        if (i == 16) {
            return BlendMode.DARKEN;
        }
        if (i == 22) {
            return BlendMode.DIFFERENCE;
        }
        if (i == 2) {
            return BlendMode.DST;
        }
        if (i == 10) {
            return BlendMode.DST_ATOP;
        }
        if (i == 6) {
            return BlendMode.DST_IN;
        }
        if (i == 8) {
            return BlendMode.DST_OUT;
        }
        if (i == 4) {
            return BlendMode.DST_OVER;
        }
        if (i == 23) {
            return BlendMode.EXCLUSION;
        }
        if (i == 20) {
            return BlendMode.HARD_LIGHT;
        }
        if (i == 25) {
            return BlendMode.HUE;
        }
        if (i == 17) {
            return BlendMode.LIGHTEN;
        }
        if (i == 28) {
            return BlendMode.LUMINOSITY;
        }
        if (i == 13) {
            return BlendMode.MODULATE;
        }
        if (i == 24) {
            return BlendMode.MULTIPLY;
        }
        if (i == 15) {
            return BlendMode.OVERLAY;
        }
        if (i == 26) {
            return BlendMode.SATURATION;
        }
        if (i == 14) {
            return BlendMode.SCREEN;
        }
        if (i == 21) {
            return BlendMode.SOFT_LIGHT;
        }
        if (i == 1) {
            return BlendMode.SRC;
        }
        if (i == 9) {
            return BlendMode.SRC_ATOP;
        }
        if (i == 5) {
            return BlendMode.SRC_IN;
        }
        if (i == 7) {
            return BlendMode.SRC_OUT;
        }
        return i == 3 ? BlendMode.SRC_OVER : BlendMode.SRC_IN;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v7, types: [dev.chrisbanes.haze.BlurEffect, java.lang.Object] */
    public static final void updateBlurEffectIfNeeded(HazeEffectNode hazeEffectNode, LayoutNodeDrawScope layoutNodeDrawScope) {
        boolean z;
        ?? r4;
        Object failure;
        if (Build.VERSION.SDK_INT >= 31) {
            androidx.compose.ui.graphics.Canvas canvas = layoutNodeDrawScope.canvasDrawScope.drawContext.getCanvas();
            Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
            if (((AndroidCanvas) canvas).internalCanvas.isHardwareAccelerated()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        boolean zResolveBlurEnabled = HazeEffectNodeKt.resolveBlurEnabled(hazeEffectNode);
        if (zResolveBlurEnabled && z) {
            BlurEffect blurEffect = hazeEffectNode.blurEffect;
            BlurEffect renderEffectBlurEffect = blurEffect instanceof RenderEffectBlurEffect ? blurEffect : new RenderEffectBlurEffect(hazeEffectNode);
            if (renderEffectBlurEffect.equals(blurEffect)) {
                return;
            }
            hazeEffectNode.blurEffect.cleanup();
            hazeEffectNode.blurEffect = renderEffectBlurEffect;
            return;
        }
        if (zResolveBlurEnabled) {
            BlurEffect blurEffect2 = hazeEffectNode.blurEffect;
            if (!(blurEffect2 instanceof RenderScriptBlurEffect)) {
                Object obj = null;
                if (RenderScriptBlurEffect.isEnabled) {
                    try {
                        r4 = blurEffect2;
                        failure = new RenderScriptBlurEffect(hazeEffectNode);
                    } catch (Throwable th) {
                        failure = new Result.Failure(th);
                    }
                    if (Result.m830exceptionOrNullimpl(failure) != null) {
                        RenderScriptBlurEffect.isEnabled = false;
                    }
                    obj = (RenderScriptBlurEffect) (failure instanceof Result.Failure ? null : failure);
                }
                r4 = blurEffect2;
                r4 = obj;
            }
            if (r4 != 0) {
                if (r4.equals(hazeEffectNode.blurEffect)) {
                    return;
                }
                hazeEffectNode.blurEffect.cleanup();
                hazeEffectNode.blurEffect = r4;
                return;
            }
        }
        BlurEffect blurEffect3 = hazeEffectNode.blurEffect;
        if (blurEffect3 instanceof ScrimBlurEffect) {
            return;
        }
        ScrimBlurEffect scrimBlurEffect = new ScrimBlurEffect(hazeEffectNode);
        if (scrimBlurEffect.equals(blurEffect3)) {
            return;
        }
        hazeEffectNode.blurEffect.cleanup();
        hazeEffectNode.blurEffect = scrimBlurEffect;
    }
}
