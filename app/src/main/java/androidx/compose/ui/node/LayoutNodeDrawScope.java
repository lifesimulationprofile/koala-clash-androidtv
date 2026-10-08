package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope {
    public final CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
    public DrawModifierNode drawNode;

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    public final void mo462drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, DrawStyle drawStyle) {
        this.canvasDrawScope.mo462drawArcyD3GUKo(j, f, f2, j2, j3, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    public final void mo463drawCircleVaOC9Bg(long j, float f, long j2, DrawStyle drawStyle) {
        this.canvasDrawScope.mo463drawCircleVaOC9Bg(j, f, j2, drawStyle);
    }

    public final void drawContent() {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        Canvas canvas = canvasDrawScope.drawContext.getCanvas();
        DelegatableNode delegatableNode = this.drawNode;
        if (delegatableNode == null) {
            throw Modifier.CC.m("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        }
        Modifier.Node node = (Modifier.Node) delegatableNode;
        Modifier.Node nodeAccess$pop = node.node.child;
        if (nodeAccess$pop != null && (nodeAccess$pop.aggregateChildKindSet & 4) != 0) {
            while (true) {
                if (nodeAccess$pop != null) {
                    int i = nodeAccess$pop.kindSet;
                    if ((i & 2) == 0) {
                        if ((i & 4) != 0) {
                            break;
                        } else {
                            nodeAccess$pop = nodeAccess$pop.child;
                        }
                    }
                }
                nodeAccess$pop = null;
                break;
            }
        } else {
            nodeAccess$pop = null;
            break;
        }
        if (nodeAccess$pop == null) {
            NodeCoordinator nodeCoordinatorM547requireCoordinator64DMado = HitTestResultKt.m547requireCoordinator64DMado(delegatableNode, 4);
            if (nodeCoordinatorM547requireCoordinator64DMado.getTail() == node.node) {
                nodeCoordinatorM547requireCoordinator64DMado = nodeCoordinatorM547requireCoordinator64DMado.wrapped;
            }
            nodeCoordinatorM547requireCoordinator64DMado.performDraw(canvas, (GraphicsLayer) canvasDrawScope.drawContext.mMenuProviders);
            return;
        }
        MutableVector mutableVector = null;
        while (nodeAccess$pop != null) {
            if (nodeAccess$pop instanceof DrawModifierNode) {
                DrawModifierNode drawModifierNode = (DrawModifierNode) nodeAccess$pop;
                GraphicsLayer graphicsLayer = (GraphicsLayer) canvasDrawScope.drawContext.mMenuProviders;
                NodeCoordinator nodeCoordinatorM547requireCoordinator64DMado2 = HitTestResultKt.m547requireCoordinator64DMado(drawModifierNode, 4);
                long jM724toSizeozmzZPI = IntSizeKt.m724toSizeozmzZPI(nodeCoordinatorM547requireCoordinator64DMado2.measuredSize);
                LayoutNode layoutNode = nodeCoordinatorM547requireCoordinator64DMado2.layoutNode;
                layoutNode.getClass();
                ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSharedDrawScope().m551drawDirecteZhPAX0$ui(canvas, jM724toSizeozmzZPI, nodeCoordinatorM547requireCoordinator64DMado2, drawModifierNode, graphicsLayer);
            } else if ((nodeAccess$pop.kindSet & 4) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                    if ((node2.kindSet & 4) != 0) {
                        i2++;
                        if (i2 == 1) {
                            nodeAccess$pop = node2;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16]);
                            }
                            if (nodeAccess$pop != null) {
                                mutableVector.add(nodeAccess$pop);
                                nodeAccess$pop = null;
                            }
                            mutableVector.add(node2);
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
        }
    }

    /* JADX INFO: renamed from: drawDirect-eZhPAX0$ui, reason: not valid java name */
    public final void m551drawDirecteZhPAX0$ui(Canvas canvas, long j, NodeCoordinator nodeCoordinator, DrawModifierNode drawModifierNode, GraphicsLayer graphicsLayer) {
        DrawModifierNode drawModifierNode2 = this.drawNode;
        this.drawNode = drawModifierNode;
        LayoutDirection layoutDirection = nodeCoordinator.layoutNode.layoutDirection;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        Density density = canvasDrawScope.drawContext.getDensity();
        MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
        LayoutDirection layoutDirection2 = menuHostHelper.getLayoutDirection();
        Canvas canvas2 = menuHostHelper.getCanvas();
        long jM756getSizeNHjbRc = menuHostHelper.m756getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = (GraphicsLayer) menuHostHelper.mMenuProviders;
        menuHostHelper.setDensity(nodeCoordinator);
        menuHostHelper.setLayoutDirection(layoutDirection);
        menuHostHelper.setCanvas(canvas);
        menuHostHelper.m758setSizeuvyYCjk(j);
        menuHostHelper.mMenuProviders = graphicsLayer;
        canvas.save();
        try {
            drawModifierNode.draw(this);
            canvas.restore();
            menuHostHelper.setDensity(density);
            menuHostHelper.setLayoutDirection(layoutDirection2);
            menuHostHelper.setCanvas(canvas2);
            menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
            menuHostHelper.mMenuProviders = graphicsLayer2;
            this.drawNode = drawModifierNode2;
        } catch (Throwable th) {
            canvas.restore();
            menuHostHelper.setDensity(density);
            menuHostHelper.setLayoutDirection(layoutDirection2);
            menuHostHelper.setCanvas(canvas2);
            menuHostHelper.m758setSizeuvyYCjk(jM756getSizeNHjbRc);
            menuHostHelper.mMenuProviders = graphicsLayer2;
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    public final void mo464drawImageAZ2fEMs(AndroidImageBitmap androidImageBitmap, long j, long j2, long j3, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo464drawImageAZ2fEMs(androidImageBitmap, j, j2, j3, f, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    public final void mo465drawImagegbVJVH8(AndroidImageBitmap androidImageBitmap, long j, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo465drawImagegbVJVH8(androidImageBitmap, j, f, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    public final void mo466drawLineNGM6Ib0(long j, long j2, long j3, float f, int i) {
        this.canvasDrawScope.mo466drawLineNGM6Ib0(j, j2, j3, f, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    public final void mo467drawPathGBMwjPU(AndroidPath androidPath, Brush brush, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo467drawPathGBMwjPU(androidPath, brush, f, drawStyle, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI */
    public final void mo468drawPathLG529CI(AndroidPath androidPath, long j, DrawStyle drawStyle) {
        this.canvasDrawScope.mo468drawPathLG529CI(androidPath, j, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w */
    public final void mo469drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo469drawRectAsUm42w(brush, j, j2, f, drawStyle, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    public final void mo470drawRectnJ9OG0(long j, long j2, long j3, float f, int i) {
        this.canvasDrawScope.mo470drawRectnJ9OG0(j, j2, j3, f, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    public final void mo471drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo471drawRoundRectZuiqVtQ(brush, j, j2, j3, f, drawStyle, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    public final void mo472drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle) {
        this.canvasDrawScope.mo472drawRoundRectuAw5IA(j, j2, j3, j4, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    public final long mo473getCenterF1C5BW0() {
        return this.canvasDrawScope.mo473getCenterF1C5BW0();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final MenuHostHelper getDrawContext() {
        return this.canvasDrawScope.drawContext;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.drawParams.layoutDirection;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc */
    public final long mo474getSizeNHjbRc() {
        return this.canvasDrawScope.drawContext.m756getSizeNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: record-JVtK1S4 */
    public final void mo475recordJVtK1S4(GraphicsLayer graphicsLayer, long j, Function1 function1) {
        graphicsLayer.m476recordmLhObY(this, getLayoutDirection(), j, new LayoutNodeDrawScope$record$1(this, this.drawNode, function1, 0));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final int mo86roundToPx0680j_4(float f) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m695$default$roundToPx0680j_4(canvasDrawScope, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final float mo87toDpGaN1DYA(long j) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m696$default$toDpGaN1DYA(j, canvasDrawScope);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo89toDpu2uoSUM(int i) {
        return this.canvasDrawScope.mo89toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final long mo90toDpSizekrfVVM(long j) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m697$default$toDpSizekrfVVM(j, canvasDrawScope);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final float mo91toPxR2X_6o(long j) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m698$default$toPxR2X_6o(j, canvasDrawScope);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo92toPx0680j_4(float f) {
        return this.canvasDrawScope.getDensity() * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final long mo93toSizeXkaWNTQ(long j) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m699$default$toSizeXkaWNTQ(j, canvasDrawScope);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo94toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.mo94toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo88toDpu2uoSUM(float f) {
        return f / this.canvasDrawScope.getDensity();
    }
}
