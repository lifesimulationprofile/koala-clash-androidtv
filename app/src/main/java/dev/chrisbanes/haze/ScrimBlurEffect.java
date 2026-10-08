package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntSizeKt;
import coil.util.ContinuationCallback;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrimBlurEffect implements BlurEffect {
    public final HazeEffectNode node;

    public ScrimBlurEffect(HazeEffectNode hazeEffectNode) {
        this.node = hazeEffectNode;
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final void drawEffect(LayoutNodeDrawScope layoutNodeDrawScope) {
        Object obj = HazeEffectNodeKt.renderEffectCache$delegate;
        HazeEffectNode hazeEffectNode = this.node;
        HazeTint hazeTint = hazeEffectNode.fallbackTint;
        HazeTint hazeTint2 = null;
        if (!hazeTint.isSpecified()) {
            hazeTint = null;
        }
        if (hazeTint == null) {
            hazeTint = hazeEffectNode.style.fallbackTint;
            if (!hazeTint.isSpecified()) {
                hazeTint = null;
            }
            if (hazeTint == null) {
                hazeTint = hazeEffectNode.compositionLocalStyle.fallbackTint;
            }
        }
        if (!hazeTint.isSpecified()) {
            hazeTint = null;
        }
        if (hazeTint == null) {
            HazeTint hazeTint3 = (HazeTint) CollectionsKt.firstOrNull(HazeEffectNodeKt.resolveTints(hazeEffectNode));
            if (hazeTint3 != null) {
                Brush brush = hazeTint3.brush;
                float fResolveBlurRadius = HazeEffectNodeKt.resolveBlurRadius(hazeEffectNode);
                if (Float.isNaN(fResolveBlurRadius)) {
                    fResolveBlurRadius = 0;
                }
                if (brush != null) {
                    hazeTint2 = hazeTint3;
                } else {
                    if (Float.isNaN(fResolveBlurRadius)) {
                        fResolveBlurRadius = HazeDefaults.blurRadius;
                    }
                    long j = hazeTint3.color;
                    float fM436getAlphaimpl = Color.m436getAlphaimpl(j) * ((fResolveBlurRadius / 72) + 1);
                    if (fM436getAlphaimpl > 1.0f) {
                        fM436getAlphaimpl = 1.0f;
                    }
                    hazeTint2 = new HazeTint(BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), fM436getAlphaimpl, Color.m438getColorSpaceimpl(j)), hazeTint3.blendMode, brush);
                }
            }
            if (hazeTint2 == null) {
                return;
            }
        } else {
            hazeTint2 = hazeTint;
        }
        float f = hazeEffectNode.alpha;
        if (f >= 1.0f) {
            HazeKt.m827drawScrimDBWKusU(layoutNodeDrawScope, hazeTint2, hazeEffectNode, 0L, layoutNodeDrawScope.mo474getSizeNHjbRc());
            return;
        }
        GraphicsContext graphicsContext = (GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext);
        GraphicsLayer graphicsLayerCreateGraphicsLayer = graphicsContext.createGraphicsLayer();
        try {
            graphicsLayerCreateGraphicsLayer.setAlpha(f);
            layoutNodeDrawScope.mo475recordJVtK1S4(graphicsLayerCreateGraphicsLayer, IntSizeKt.m723toIntSizeuvyYCjk(layoutNodeDrawScope.mo474getSizeNHjbRc()), new ContinuationCallback(9, hazeTint2, this));
            GraphicsLayerKt.drawLayer(layoutNodeDrawScope, graphicsLayerCreateGraphicsLayer);
            Unit unit = Unit.INSTANCE;
        } finally {
            graphicsContext.releaseGraphicsLayer(graphicsLayerCreateGraphicsLayer);
        }
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final /* bridge */ void cleanup() {
    }
}
