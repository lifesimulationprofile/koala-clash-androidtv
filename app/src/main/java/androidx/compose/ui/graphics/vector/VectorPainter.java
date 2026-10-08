package androidx.compose.ui.graphics.vector;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import coil.request.Parameters;
import kotlin.Unit;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VectorPainter extends Painter {
    public float currentAlpha;
    public BlendModeColorFilter currentColorFilter;
    public final ParcelableSnapshotMutableState drawInvalidation$delegate;
    public final VectorComponent vector;
    public final ParcelableSnapshotMutableState size$delegate = Stack.mutableStateOf$default(new Size(0));
    public final ParcelableSnapshotMutableState autoMirror$delegate = Stack.mutableStateOf$default(Boolean.FALSE);

    public VectorPainter(GroupComponent groupComponent) {
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.invalidateCallback = new Handshake.AnonymousClass2(3, this);
        this.vector = vectorComponent;
        this.drawInvalidation$delegate = new ParcelableSnapshotMutableState(Unit.INSTANCE, NeverEqualPolicy.INSTANCE);
        this.currentAlpha = 1.0f;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyAlpha(float f) {
        this.currentAlpha = f;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.currentColorFilter = blendModeColorFilter;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo492getIntrinsicSizeNHjbRc() {
        return ((Size) this.size$delegate.getValue()).packedValue;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        BlendModeColorFilter blendModeColorFilter = this.currentColorFilter;
        VectorComponent vectorComponent = this.vector;
        if (blendModeColorFilter == null) {
            blendModeColorFilter = (BlendModeColorFilter) vectorComponent.intrinsicColorFilter$delegate.getValue();
        }
        if (((Boolean) this.autoMirror$delegate.getValue()).booleanValue() && layoutNodeDrawScope.getLayoutDirection() == LayoutDirection.Rtl) {
            long jMo473getCenterF1C5BW0 = canvasDrawScope.mo473getCenterF1C5BW0();
            MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
            long jM756getSizeNHjbRc = menuHostHelper.m756getSizeNHjbRc();
            menuHostHelper.getCanvas().save();
            try {
                ((Parameters.Builder) menuHostHelper.mOnInvalidateMenuCallback).m792scale0AR0LA0(-1.0f, 1.0f, jMo473getCenterF1C5BW0);
                vectorComponent.draw(layoutNodeDrawScope, this.currentAlpha, blendModeColorFilter);
                ImageAnalysis$$ExternalSyntheticLambda1.m(menuHostHelper, jM756getSizeNHjbRc);
            } catch (Throwable th) {
                ImageAnalysis$$ExternalSyntheticLambda1.m(menuHostHelper, jM756getSizeNHjbRc);
                throw th;
            }
        } else {
            vectorComponent.draw(layoutNodeDrawScope, this.currentAlpha, blendModeColorFilter);
        }
        this.drawInvalidation$delegate.getValue();
        Unit unit = Unit.INSTANCE;
    }
}
