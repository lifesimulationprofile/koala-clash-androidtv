package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.material3.ThumbNode;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDebugIndication implements IndicationNodeFactory {
    public static final DefaultDebugIndication INSTANCE = new DefaultDebugIndication();

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public final DelegatableNode create(MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        return new DefaultDebugIndicationInstance(mutableInteractionSourceImpl);
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public final int hashCode() {
        return -1;
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DefaultDebugIndicationInstance extends Modifier.Node implements DrawModifierNode {
        public final MutableInteractionSourceImpl interactionSource;
        public boolean isFocused;
        public boolean isHovered;
        public boolean isPressed;

        public DefaultDebugIndicationInstance(MutableInteractionSourceImpl mutableInteractionSourceImpl) {
            this.interactionSource = mutableInteractionSourceImpl;
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
            layoutNodeDrawScope.drawContent();
            CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
            if (this.isPressed) {
                long j = Color.Black;
                Modifier.CC.m315drawRectnJ9OG0$default(layoutNodeDrawScope, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.3f, Color.m438getColorSpaceimpl(j)), canvasDrawScope.drawContext.m756getSizeNHjbRc(), 0.0f, 0, 122);
            } else if (this.isHovered || this.isFocused) {
                long j2 = Color.Black;
                Modifier.CC.m315drawRectnJ9OG0$default(layoutNodeDrawScope, BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.1f, Color.m438getColorSpaceimpl(j2)), canvasDrawScope.drawContext.m756getSizeNHjbRc(), 0.0f, 0, 122);
            }
        }

        @Override // androidx.compose.ui.Modifier.Node
        public final void onAttach() {
            JobKt.launch$default(getCoroutineScope(), null, new ThumbNode.AnonymousClass1(this, (Continuation) null, 2), 3);
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public final /* synthetic */ void onMeasureResultChanged() {
        }
    }
}
