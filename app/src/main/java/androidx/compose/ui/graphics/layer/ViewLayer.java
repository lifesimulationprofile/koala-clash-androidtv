package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupLayout;
import androidx.core.view.MenuHostHelper;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ViewLayer extends View {
    public static final PopupLayout.AnonymousClass2 LayerOutlineProvider = new PopupLayout.AnonymousClass2(2);
    public boolean canUseCompositingLayer;
    public final CanvasDrawScope canvasDrawScope;
    public final CanvasHolder canvasHolder;
    public Density density;
    public Lambda drawBlock;
    public boolean isInvalidated;
    public Outline layerOutline;
    public LayoutDirection layoutDirection;
    public final DrawChildContainer ownerView;
    public GraphicsLayer parentLayer;

    public ViewLayer(DrawChildContainer drawChildContainer, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        super(drawChildContainer.getContext());
        this.ownerView = drawChildContainer;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        setOutlineProvider(LayerOutlineProvider);
        this.canUseCompositingLayer = true;
        this.density = DrawContextKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        GraphicsLayerImpl.Companion.getClass();
        this.drawBlock = GraphicsLayer$drawBlock$1.INSTANCE$1;
        setWillNotDraw(false);
        setClipBounds(null);
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
        CanvasHolder canvasHolder = this.canvasHolder;
        AndroidCanvas androidCanvas = canvasHolder.androidCanvas;
        Canvas canvas2 = androidCanvas.internalCanvas;
        androidCanvas.internalCanvas = canvas;
        Density density = this.density;
        LayoutDirection layoutDirection = this.layoutDirection;
        float width = getWidth();
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32);
        GraphicsLayer graphicsLayer = this.parentLayer;
        ?? r9 = this.drawBlock;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        Density density2 = canvasDrawScope.drawContext.getDensity();
        MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
        LayoutDirection layoutDirection2 = menuHostHelper.getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvas3 = menuHostHelper.getCanvas();
        long jM756getSizeNHjbRc = menuHostHelper.m756getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = (GraphicsLayer) menuHostHelper.mMenuProviders;
        menuHostHelper.setDensity(density);
        menuHostHelper.setLayoutDirection(layoutDirection);
        menuHostHelper.setCanvas(androidCanvas);
        menuHostHelper.m758setSizeuvyYCjk(jFloatToRawIntBits);
        menuHostHelper.mMenuProviders = graphicsLayer;
        androidCanvas.save();
        try {
            r9.invoke(canvasDrawScope);
            androidCanvas.restore();
            menuHostHelper.setDensity(density2);
            menuHostHelper.setLayoutDirection(layoutDirection2);
            menuHostHelper.setCanvas(canvas3);
            menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
            menuHostHelper.mMenuProviders = graphicsLayer2;
            canvasHolder.androidCanvas.internalCanvas = canvas2;
            this.isInvalidated = false;
        } catch (Throwable th) {
            androidCanvas.restore();
            menuHostHelper.setDensity(density2);
            menuHostHelper.setLayoutDirection(layoutDirection2);
            menuHostHelper.setCanvas(canvas3);
            menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
            menuHostHelper.mMenuProviders = graphicsLayer2;
            throw th;
        }
    }

    public final boolean getCanUseCompositingLayer$ui_graphics() {
        return this.canUseCompositingLayer;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public final View getOwnerView() {
        return this.ownerView;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return this.canUseCompositingLayer;
    }

    @Override // android.view.View
    public final void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        this.isInvalidated = true;
        super.invalidate();
    }

    public final void setCanUseCompositingLayer$ui_graphics(boolean z) {
        if (this.canUseCompositingLayer != z) {
            this.canUseCompositingLayer = z;
            invalidate();
        }
    }

    public final void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    @Override // android.view.View
    public final void forceLayout() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
