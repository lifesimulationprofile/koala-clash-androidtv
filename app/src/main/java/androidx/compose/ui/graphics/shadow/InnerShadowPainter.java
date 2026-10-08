package androidx.compose.ui.graphics.shadow;

import androidx.collection.MutableScatterMap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InnerShadowPainter extends Painter {
    public float alpha = 1.0f;
    public BlendModeColorFilter colorFilter;
    public final MenuHostHelper renderCreator;
    public final Shadow shadow;
    public final Shape shape;

    public InnerShadowPainter(Shape shape, Shadow shadow, MenuHostHelper menuHostHelper) {
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
        InnerShadowRenderer innerShadowRenderer;
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
            androidShadowContext$ShadowKey.shadow = shadow;
            MutableScatterMap mutableScatterMap = (MutableScatterMap) menuHostHelper.mMenuProviders;
            if (mutableScatterMap == null) {
                mutableScatterMap = new MutableScatterMap();
                menuHostHelper.mMenuProviders = mutableScatterMap;
            }
            InnerShadowRenderer innerShadowRenderer2 = (InnerShadowRenderer) mutableScatterMap.get(androidShadowContext$ShadowKey);
            if (innerShadowRenderer2 == null) {
                innerShadowRenderer2 = new InnerShadowRenderer(shadow, shape.mo60createOutlinePq9zytI(jMo474getSizeNHjbRc, layoutDirection, layoutNodeDrawScope));
                MutableScatterMap mutableScatterMap2 = (MutableScatterMap) menuHostHelper.mMenuProviders;
                if (mutableScatterMap2 == null) {
                    mutableScatterMap2 = new MutableScatterMap();
                    menuHostHelper.mMenuProviders = mutableScatterMap2;
                }
                mutableScatterMap2.set(AndroidShadowContext$ShadowKey.m496copyeZhPAX0$default(androidShadowContext$ShadowKey), innerShadowRenderer2);
            }
            innerShadowRenderer = innerShadowRenderer2;
        }
        BlendModeColorFilter blendModeColorFilter = this.colorFilter;
        long jMo474getSizeNHjbRc2 = layoutNodeDrawScope.mo474getSizeNHjbRc();
        Shadow shadow2 = this.shadow;
        innerShadowRenderer.m500drawShadowerFMhIw(layoutNodeDrawScope, blendModeColorFilter, jMo474getSizeNHjbRc2, shadow2.color, shadow2.brush, RangesKt.coerceIn(this.alpha * shadow2.alpha, 0.0f, 1.0f), this.shadow.blendMode);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyLayoutDirection(LayoutDirection layoutDirection) {
    }
}
