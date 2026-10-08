package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import coil.network.HttpException;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class GraphicsLayerKt {
    public static final void drawLayer(DrawScope drawScope, GraphicsLayer graphicsLayer) {
        boolean z;
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        GraphicsLayer graphicsLayer2 = (GraphicsLayer) drawScope.getDrawContext().mMenuProviders;
        GraphicsLayerImpl graphicsLayerImpl = graphicsLayer.impl;
        if (graphicsLayer.isReleased) {
            return;
        }
        graphicsLayer.configureOutlineAndClip();
        if (!graphicsLayerImpl.getHasDisplayList()) {
            try {
                graphicsLayer.impl.record(graphicsLayer.density, graphicsLayer.layoutDirection, graphicsLayer, graphicsLayer.clipDrawBlock);
            } catch (Throwable unused) {
            }
        }
        boolean z2 = graphicsLayerImpl.getShadowElevation() > 0.0f;
        if (z2) {
            canvas.enableZ();
        }
        android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
        AndroidCanvas androidCanvas = (AndroidCanvas) canvas;
        android.graphics.Canvas canvas3 = androidCanvas.internalCanvas;
        boolean zIsHardwareAccelerated = canvas3.isHardwareAccelerated();
        if (!zIsHardwareAccelerated) {
            long j = graphicsLayer.topLeft;
            float f = (int) (j >> 32);
            float f2 = (int) (j & 4294967295L);
            long j2 = graphicsLayer.size;
            float f3 = ((int) (j2 >> 32)) + f;
            float f4 = f2 + ((int) (j2 & 4294967295L));
            float alpha = graphicsLayerImpl.getAlpha();
            BlendModeColorFilter colorFilter = graphicsLayerImpl.getColorFilter();
            int iMo479getBlendMode0nO6VwU = graphicsLayerImpl.mo479getBlendMode0nO6VwU();
            if (alpha < 1.0f || iMo479getBlendMode0nO6VwU != 3 || colorFilter != null || graphicsLayerImpl.mo480getCompositingStrategyke2Ky5w() == 1) {
                AndroidPaint androidPaintPaint = graphicsLayer.softwareLayerPaint;
                if (androidPaintPaint == null) {
                    androidPaintPaint = BrushKt.Paint();
                    graphicsLayer.softwareLayerPaint = androidPaintPaint;
                }
                androidPaintPaint.setAlpha(alpha);
                androidPaintPaint.m403setBlendModes9anfk8(iMo479getBlendMode0nO6VwU);
                androidPaintPaint.setColorFilter(colorFilter);
                canvas3.saveLayer(f, f2, f3, f4, BrushKt.getNativePaint(androidPaintPaint));
            } else {
                canvas3.save();
            }
            canvas3.translate(f, f2);
            canvas3.concat(graphicsLayerImpl.calculateMatrix());
        }
        boolean z3 = !zIsHardwareAccelerated && graphicsLayer.clip;
        if (z3) {
            canvas.save();
            BrushKt outline = graphicsLayer.getOutline();
            if (outline instanceof Outline$Rectangle) {
                canvas.mo394clipRectmtrdDE(((Outline$Rectangle) outline).rect);
            } else if (outline instanceof Outline$Rounded) {
                AndroidPath androidPathPath = graphicsLayer.roundRectClipPath;
                if (androidPathPath != null) {
                    androidPathPath.internalPath.rewind();
                } else {
                    androidPathPath = AndroidPath_androidKt.Path();
                    graphicsLayer.roundRectClipPath = androidPathPath;
                }
                Modifier.CC.addRoundRect$default(androidPathPath, ((Outline$Rounded) outline).roundRect);
                canvas.mo392clipPathmtrdDE(androidPathPath);
            } else {
                if (!(outline instanceof Outline$Generic)) {
                    throw new HttpException();
                }
                canvas.mo392clipPathmtrdDE(((Outline$Generic) outline).path);
            }
        }
        if (graphicsLayer2 != null) {
            Exchange exchange = graphicsLayer2.childDependenciesTracker;
            if (!exchange.hasFailure) {
                InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) exchange.codec;
            if (mutableScatterSet != null) {
                mutableScatterSet.add(graphicsLayer);
            } else if (((GraphicsLayer) exchange.call) != null) {
                MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                MutableScatterSet mutableScatterSet3 = new MutableScatterSet();
                mutableScatterSet3.add((GraphicsLayer) exchange.call);
                mutableScatterSet3.add(graphicsLayer);
                exchange.codec = mutableScatterSet3;
                exchange.call = null;
            } else {
                exchange.call = graphicsLayer;
            }
            MutableScatterSet mutableScatterSet4 = (MutableScatterSet) exchange.connection;
            if (mutableScatterSet4 != null) {
                z = !mutableScatterSet4.remove(graphicsLayer);
            } else if (((GraphicsLayer) exchange.finder) != graphicsLayer) {
                z = true;
            } else {
                exchange.finder = null;
                z = false;
            }
            if (z) {
                graphicsLayer.parentLayerUsages++;
            }
        }
        if (androidCanvas.internalCanvas.isHardwareAccelerated()) {
            graphicsLayerImpl.draw(canvas);
        } else {
            CanvasDrawScope canvasDrawScope = graphicsLayer.softwareDrawScope;
            if (canvasDrawScope == null) {
                canvasDrawScope = new CanvasDrawScope();
                graphicsLayer.softwareDrawScope = canvasDrawScope;
            }
            MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
            Density density = graphicsLayer.density;
            LayoutDirection layoutDirection = graphicsLayer.layoutDirection;
            long jM724toSizeozmzZPI = IntSizeKt.m724toSizeozmzZPI(graphicsLayer.size);
            Density density2 = menuHostHelper.getDensity();
            LayoutDirection layoutDirection2 = menuHostHelper.getLayoutDirection();
            Canvas canvas4 = menuHostHelper.getCanvas();
            long jM756getSizeNHjbRc = menuHostHelper.m756getSizeNHjbRc();
            GraphicsLayer graphicsLayer3 = (GraphicsLayer) menuHostHelper.mMenuProviders;
            menuHostHelper.setDensity(density);
            menuHostHelper.setLayoutDirection(layoutDirection);
            menuHostHelper.setCanvas(canvas);
            menuHostHelper.m758setSizeuvyYCjk(jM724toSizeozmzZPI);
            menuHostHelper.mMenuProviders = graphicsLayer;
            canvas.save();
            try {
                graphicsLayer.drawWithChildTracking(canvasDrawScope);
                canvas.restore();
                menuHostHelper.setDensity(density2);
                menuHostHelper.setLayoutDirection(layoutDirection2);
                menuHostHelper.setCanvas(canvas4);
                menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
                menuHostHelper.mMenuProviders = graphicsLayer3;
            } catch (Throwable th) {
                canvas.restore();
                menuHostHelper.setDensity(density2);
                menuHostHelper.setLayoutDirection(layoutDirection2);
                menuHostHelper.setCanvas(canvas4);
                menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
                menuHostHelper.mMenuProviders = graphicsLayer3;
                throw th;
            }
        }
        if (z3) {
            canvas.restore();
        }
        if (z2) {
            canvas.disableZ();
        }
        if (zIsHardwareAccelerated) {
            return;
        }
        canvas3.restore();
    }
}
