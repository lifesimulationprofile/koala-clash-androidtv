package androidx.compose.foundation;

import android.view.View;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public DerivedSnapshotState anchorPositionInRootState;
    public Density density;
    public BufferedChannel drawSignalChannel;
    public PlatformMagnifier magnifier;
    public Function1 onSizeChanged;
    public PlatformMagnifierFactory platformMagnifierFactory;
    public IntSize previousSize;
    public Function1 sourceCenter;
    public View view;
    public final ParcelableSnapshotMutableState layoutCoordinates$delegate = new ParcelableSnapshotMutableState(null, NeverEqualPolicy.INSTANCE);
    public long sourceCenterInRoot = 9205357640488583168L;

    public MagnifierNode(Function1 function1, Function1 function2, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = function1;
        this.onSizeChanged = function2;
        this.platformMagnifierFactory = platformMagnifierFactory;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(Magnifier_androidKt.MagnifierPositionInRoot, new MagnifierNode$$ExternalSyntheticLambda0(this, 1));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        layoutNodeDrawScope.drawContent();
        BufferedChannel bufferedChannel = this.drawSignalChannel;
        if (bufferedChannel != null) {
            bufferedChannel.mo842trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: getAnchorPositionInRoot-F1C5BW0, reason: not valid java name */
    public final long m55getAnchorPositionInRootF1C5BW0() {
        if (this.anchorPositionInRootState == null) {
            this.anchorPositionInRootState = Stack.derivedStateOf(new MagnifierNode$$ExternalSyntheticLambda0(this, 2));
        }
        DerivedSnapshotState derivedSnapshotState = this.anchorPositionInRootState;
        if (derivedSnapshotState != null) {
            return ((Offset) derivedSnapshotState.getValue()).packedValue;
        }
        return 9205357640488583168L;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return true;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        onObservedReadsChanged();
        this.drawSignalChannel = ChannelKt.Channel$default(0, 0, 7);
        JobKt.launch$default(getCoroutineScope(), null, new ThumbNode.AnonymousClass1(this, (Continuation) null, 4), 1);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            ((PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl) platformMagnifier).dismiss();
        }
        this.magnifier = null;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.layoutCoordinates$delegate.setValue(nodeCoordinator);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        HitTestResultKt.observeReads(this, new MagnifierNode$$ExternalSyntheticLambda0(this, 0));
    }

    public final void recreateMagnifier() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            ((PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl) platformMagnifier).dismiss();
        }
        View viewRequireView = this.view;
        if (viewRequireView == null) {
            viewRequireView = HitTestResultKt.requireView(this);
        }
        this.view = viewRequireView;
        Density density = this.density;
        if (density == null) {
            density = HitTestResultKt.requireLayoutNode(this).density;
        }
        this.density = density;
        this.magnifier = this.platformMagnifierFactory.mo58createnHHXs2Y(viewRequireView, density);
        updateSizeIfNecessary();
    }

    public final void updateMagnifier() {
        Density density = this.density;
        if (density == null) {
            density = HitTestResultKt.requireLayoutNode(this).density;
            this.density = density;
        }
        long j = ((Offset) this.sourceCenter.invoke(density)).packedValue;
        if ((j & 9223372034707292159L) == 9205357640488583168L || (9223372034707292159L & m55getAnchorPositionInRootF1C5BW0()) == 9205357640488583168L) {
            this.sourceCenterInRoot = 9205357640488583168L;
            PlatformMagnifier platformMagnifier = this.magnifier;
            if (platformMagnifier != null) {
                ((PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl) platformMagnifier).dismiss();
                return;
            }
            return;
        }
        this.sourceCenterInRoot = Offset.m373plusMKHz9U(m55getAnchorPositionInRootF1C5BW0(), j);
        if (this.magnifier == null) {
            recreateMagnifier();
        }
        PlatformMagnifier platformMagnifier2 = this.magnifier;
        if (platformMagnifier2 != null) {
            platformMagnifier2.mo57updateWko1d7g(this.sourceCenterInRoot, 9205357640488583168L);
        }
        updateSizeIfNecessary();
    }

    public final void updateSizeIfNecessary() {
        Density density;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier == null || (density = this.density) == null) {
            return;
        }
        PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl platformMagnifierImpl = (PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl) platformMagnifier;
        long jM59getSizeYbymL2g = platformMagnifierImpl.m59getSizeYbymL2g();
        IntSize intSize = this.previousSize;
        if (ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) intSize) && jM59getSizeYbymL2g == intSize.packedValue) {
            return;
        }
        this.onSizeChanged.invoke(new DpSize(density.mo90toDpSizekrfVVM(IntSizeKt.m724toSizeozmzZPI(platformMagnifierImpl.m59getSizeYbymL2g()))));
        this.previousSize = new IntSize(platformMagnifierImpl.m59getSizeYbymL2g());
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }
}
