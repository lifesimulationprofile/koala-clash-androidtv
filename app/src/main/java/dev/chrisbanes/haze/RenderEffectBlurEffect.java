package dev.chrisbanes.haze;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidRenderEffect;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RenderEffectBlurEffect implements BlurEffect {
    public final HazeEffectNode node;
    public AndroidRenderEffect renderEffect;

    public RenderEffectBlurEffect(HazeEffectNode hazeEffectNode) {
        this.node = hazeEffectNode;
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final void drawEffect(LayoutNodeDrawScope layoutNodeDrawScope) {
        StringsKt__StringsKt$$ExternalSyntheticLambda0 stringsKt__StringsKt$$ExternalSyntheticLambda0 = new StringsKt__StringsKt$$ExternalSyntheticLambda0(2, this);
        HazeEffectNode hazeEffectNode = this.node;
        float fM824calculateInputScaleFactor3ABfNKs$default = HazeEffectNodeKt.m824calculateInputScaleFactor3ABfNKs$default(hazeEffectNode);
        boolean z = hazeEffectNode.blurredEdgeTreatment != null;
        GraphicsContext graphicsContext = (GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext);
        GraphicsLayer graphicsLayerM825createScaledContentLayerwZMzALA = HazeKt.m825createScaledContentLayerwZMzALA(layoutNodeDrawScope, hazeEffectNode, fM824calculateInputScaleFactor3ABfNKs$default, hazeEffectNode.layerSize, hazeEffectNode.layerOffset);
        if (graphicsLayerM825createScaledContentLayerwZMzALA != null) {
            graphicsLayerM825createScaledContentLayerwZMzALA.setClip(z);
            HazeKt.m826drawScaledContentLF441nw(layoutNodeDrawScope, hazeEffectNode.layerOffset ^ (-9223372034707292160L), Size.m389times7Ah8Wj8(fM824calculateInputScaleFactor3ABfNKs$default, layoutNodeDrawScope.mo474getSizeNHjbRc()), z, new BlurEffectKt$$ExternalSyntheticLambda1(0, stringsKt__StringsKt$$ExternalSyntheticLambda0, graphicsLayerM825createScaledContentLayerwZMzALA));
            graphicsContext.releaseGraphicsLayer(graphicsLayerM825createScaledContentLayerwZMzALA);
        }
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final /* bridge */ void cleanup() {
    }
}
