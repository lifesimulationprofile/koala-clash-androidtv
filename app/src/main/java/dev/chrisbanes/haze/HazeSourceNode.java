package dev.chrisbanes.haze;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntSizeKt;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import com.github.kr328.clash.FilesActivity$showError$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HazeSourceNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, LayoutAwareModifierNode, DrawModifierNode, TraversableNode, ObserverModifierNode {
    public final HazeArea area;
    public StandaloneCoroutine preDrawJob;
    public HazeState state;

    public HazeSourceNode(HazeState hazeState) {
        HazeArea hazeArea = new HazeArea();
        this.area = hazeArea;
        hazeArea.zIndex$delegate.setFloatValue(0.0f);
        this.state = hazeState;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:3:0x0004, B:7:0x0010, B:9:0x0022, B:11:0x0030, B:20:0x0044, B:19:0x003b, B:21:0x0050), top: B:25:0x0004 }] */
    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        HazeArea hazeArea = this.area;
        try {
            hazeArea.contentDrawing = true;
            if (this.isAttached) {
                if (MathKt.roundToInt(Size.m386getMinDimensionimpl(layoutNodeDrawScope.canvasDrawScope.drawContext.m756getSizeNHjbRc())) >= 1) {
                    GraphicsContext graphicsContext = (GraphicsContext) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalGraphicsContext);
                    GraphicsLayer contentLayer = hazeArea.getContentLayer();
                    if (contentLayer == null) {
                        contentLayer = graphicsContext.createGraphicsLayer();
                        hazeArea.contentLayer$delegate.setValue(contentLayer);
                    } else {
                        if (contentLayer.isReleased) {
                            contentLayer = null;
                        }
                        if (contentLayer == null) {
                            contentLayer = graphicsContext.createGraphicsLayer();
                            hazeArea.contentLayer$delegate.setValue(contentLayer);
                        }
                    }
                    layoutNodeDrawScope.mo475recordJVtK1S4(contentLayer, IntSizeKt.m723toIntSizeuvyYCjk(layoutNodeDrawScope.mo474getSizeNHjbRc()), new HazeEffectNode$$ExternalSyntheticLambda2(layoutNodeDrawScope, contentLayer));
                    GraphicsLayerKt.drawLayer(layoutNodeDrawScope, contentLayer);
                } else {
                    HazeKt.drawContentSafely(layoutNodeDrawScope);
                }
            }
        } finally {
            hazeArea.contentDrawing = false;
            launchPreDraw();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return HazeTraversableNodeKeys.Source;
    }

    public final StandaloneCoroutine launchPreDraw() {
        return JobKt.launch$default(getCoroutineScope(), null, new ThumbNode.AnonymousClass1(this, (Continuation) null, 26), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        Continuation continuation;
        ComponentActivity componentActivity;
        this.state._areas.add(this.area);
        Context baseContext = (Context) HitTestResultKt.currentValueOf(this, AndroidCompositionLocals_androidKt.LocalContext);
        while (true) {
            continuation = null;
            if (!(baseContext instanceof ComponentActivity)) {
                if (!(baseContext instanceof ContextWrapper)) {
                    componentActivity = null;
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            } else {
                componentActivity = (ComponentActivity) baseContext;
                break;
            }
        }
        if (componentActivity != null) {
            JobKt.launch$default(getCoroutineScope(), null, new FilesActivity$showError$1(componentActivity, this, continuation, 19), 3);
        }
        onObservedReadsChanged();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        HazeArea hazeArea = this.area;
        hazeArea.positionOnScreen$delegate.setValue(new Offset(9205357640488583168L));
        hazeArea.size$delegate.setValue(new Size(9205357640488583168L));
        hazeArea.contentDrawing = false;
        GraphicsLayer contentLayer = hazeArea.getContentLayer();
        if (contentLayer != null) {
            ((GraphicsContext) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(contentLayer);
        }
        hazeArea.contentLayer$delegate.setValue(null);
        this.state._areas.remove(hazeArea);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        onPositioned$1(nodeCoordinator);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        HitTestResultKt.observeReads(this, new BitmapFactoryDecoder$$ExternalSyntheticLambda2(15, this));
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(LayoutCoordinates layoutCoordinates) {
        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if ((this.area.m821getPositionOnScreenF1C5BW0() & 9223372034707292159L) == 9205357640488583168L) {
                onPositioned$1(layoutCoordinates);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    public final void onPositioned$1(LayoutCoordinates layoutCoordinates) {
        if (this.isAttached) {
            long jMo526localToScreenMKHz9U = layoutCoordinates.mo526localToScreenMKHz9U(0L);
            HazeArea hazeArea = this.area;
            hazeArea.positionOnScreen$delegate.setValue(new Offset(jMo526localToScreenMKHz9U));
            hazeArea.size$delegate.setValue(new Size(IntSizeKt.m724toSizeozmzZPI(layoutCoordinates.mo522getSizeYbymL2g())));
            hazeArea.windowId = ((View) HitTestResultKt.currentValueOf(this, AndroidCompositionLocals_androidKt.LocalView)).getWindowId();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        HazeArea hazeArea = this.area;
        hazeArea.positionOnScreen$delegate.setValue(new Offset(9205357640488583168L));
        hazeArea.size$delegate.setValue(new Size(9205357640488583168L));
        hazeArea.contentDrawing = false;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* bridge */ void onMeasureResultChanged() {
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final /* bridge */ void mo66onRemeasuredozmzZPI(long j) {
    }
}
