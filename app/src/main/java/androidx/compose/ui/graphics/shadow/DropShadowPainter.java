package androidx.compose.ui.graphics.shadow;

import androidx.collection.MutableScatterMap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import coil.request.Parameters;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DropShadowPainter extends Painter {
    public float alpha = 1.0f;
    public BlendModeColorFilter colorFilter;
    public final MenuHostHelper renderCreator;
    public final Shadow shadow;
    public final Shape shape;

    public DropShadowPainter(Shape shape, Shadow shadow, MenuHostHelper menuHostHelper) {
        this.shape = shape;
        this.shadow = shadow;
        this.renderCreator = menuHostHelper;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyAlpha(float f) {
        this.alpha = f;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.colorFilter = blendModeColorFilter;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo492getIntrinsicSizeNHjbRc() {
        return 9205357640488583168L;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        DropShadowRenderer dropShadowRenderer;
        MenuHostHelper menuHostHelper = this.renderCreator;
        Shape shape = this.shape;
        long jMo474getSizeNHjbRc = layoutNodeDrawScope.mo474getSizeNHjbRc();
        LayoutDirection layoutDirection = layoutNodeDrawScope.getLayoutDirection();
        Shadow shadow = this.shadow;
        synchronized (menuHostHelper) {
            AndroidShadowContext$ShadowKey androidShadowContext$ShadowKey = (AndroidShadowContext$ShadowKey) menuHostHelper.mProviderToLifecycleContainers;
            if (androidShadowContext$ShadowKey == null) {
                AndroidShadowContext$ShadowKey androidShadowContext$ShadowKey2 = new AndroidShadowContext$ShadowKey(BrushKt.RectangleShape, 0L, LayoutDirection.Ltr, 1.0f, null);
                menuHostHelper.mProviderToLifecycleContainers = androidShadowContext$ShadowKey2;
                androidShadowContext$ShadowKey = androidShadowContext$ShadowKey2;
            }
            androidShadowContext$ShadowKey.shape = shape;
            androidShadowContext$ShadowKey.size = jMo474getSizeNHjbRc;
            androidShadowContext$ShadowKey.layoutDirection = layoutDirection;
            androidShadowContext$ShadowKey.density = layoutNodeDrawScope.canvasDrawScope.getDensity();
            androidShadowContext$ShadowKey.shadow = new Shadow(shadow.radius, shadow.spread, 0L, shadow.color, shadow.brush, shadow.alpha, shadow.blendMode);
            MutableScatterMap mutableScatterMap = (MutableScatterMap) menuHostHelper.mOnInvalidateMenuCallback;
            if (mutableScatterMap == null) {
                mutableScatterMap = new MutableScatterMap();
                menuHostHelper.mOnInvalidateMenuCallback = mutableScatterMap;
            }
            dropShadowRenderer = (DropShadowRenderer) mutableScatterMap.get(androidShadowContext$ShadowKey);
            if (dropShadowRenderer == null) {
                dropShadowRenderer = new DropShadowRenderer(shadow, shape.mo60createOutlinePq9zytI(jMo474getSizeNHjbRc, layoutDirection, layoutNodeDrawScope));
                MutableScatterMap mutableScatterMap2 = (MutableScatterMap) menuHostHelper.mOnInvalidateMenuCallback;
                if (mutableScatterMap2 == null) {
                    mutableScatterMap2 = new MutableScatterMap();
                    menuHostHelper.mOnInvalidateMenuCallback = mutableScatterMap2;
                }
                mutableScatterMap2.set(AndroidShadowContext$ShadowKey.m496copyeZhPAX0$default(androidShadowContext$ShadowKey), dropShadowRenderer);
            }
        }
        float fMo92toPx0680j_4 = layoutNodeDrawScope.mo92toPx0680j_4(DpOffset.m707getXD9Ej5fM(this.shadow.offset));
        float fMo92toPx0680j_5 = layoutNodeDrawScope.mo92toPx0680j_4(DpOffset.m708getYD9Ej5fM(this.shadow.offset));
        ((Parameters.Builder) layoutNodeDrawScope.canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(fMo92toPx0680j_4, fMo92toPx0680j_5);
        try {
            BlendModeColorFilter blendModeColorFilter = this.colorFilter;
            long jMo474getSizeNHjbRc2 = layoutNodeDrawScope.mo474getSizeNHjbRc();
            Shadow shadow2 = dropShadowRenderer.shadow;
            dropShadowRenderer.m500drawShadowerFMhIw(layoutNodeDrawScope, blendModeColorFilter, jMo474getSizeNHjbRc2, shadow2.color, shadow2.brush, RangesKt.coerceIn(this.alpha * shadow2.alpha, 0.0f, 1.0f), dropShadowRenderer.shadow.blendMode);
        } finally {
            ((Parameters.Builder) layoutNodeDrawScope.canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(-fMo92toPx0680j_4, -fMo92toPx0680j_5);
        }
    }
}
