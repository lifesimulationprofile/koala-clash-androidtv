package androidx.compose.ui.node;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.foundation.IndicationModifier;
import androidx.compose.foundation.lazy.LazyListState$remeasurementModifier$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.modifier.EmptyMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.AppendedSemanticsElement;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Function;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalModifierNode, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, OwnerScope, BuildDrawCacheParams {
    public Modifier.Element element;

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public final void applyFocusProperties(FocusProperties focusProperties) {
        Modifier.Element element = this.element;
        InlineClassHelperKt.throwIllegalStateException("applyFocusProperties called on wrong node");
        element.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) this.element;
        appendedSemanticsElement.getClass();
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = appendedSemanticsElement.mergeDescendants;
        appendedSemanticsElement.properties.invoke(semanticsConfiguration);
        SemanticsConfiguration semanticsConfiguration2 = (SemanticsConfiguration) semanticsPropertyReceiver;
        MutableScatterMap mutableScatterMap = semanticsConfiguration2.props;
        if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
            semanticsConfiguration2.isMergingSemanticsOfDescendants = true;
        }
        if (semanticsConfiguration.isClearingSemantics) {
            semanticsConfiguration2.isClearingSemantics = true;
        }
        MutableScatterMap mutableScatterMap2 = semanticsConfiguration.props;
        Object[] objArr = mutableScatterMap2.keys;
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8;
                int i3 = 8 - ((~(i - length)) >>> 31);
                int i4 = 0;
                while (i4 < i3) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        Object obj = objArr[i5];
                        Object obj2 = objArr2[i5];
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                        if (!mutableScatterMap.contains(semanticsPropertyKey)) {
                            mutableScatterMap.set(semanticsPropertyKey, obj2);
                        } else if (obj2 instanceof AccessibilityAction) {
                            AccessibilityAction accessibilityAction = (AccessibilityAction) mutableScatterMap.get(semanticsPropertyKey);
                            String str = accessibilityAction.label;
                            if (str == null) {
                                str = ((AccessibilityAction) obj2).label;
                            }
                            Function function = accessibilityAction.action;
                            if (function == null) {
                                function = ((AccessibilityAction) obj2).action;
                            }
                            mutableScatterMap.set(semanticsPropertyKey, new AccessibilityAction(str, function));
                        }
                    }
                    j >>= i2;
                    i4++;
                    i2 = i2;
                }
                if (i3 != i2) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        ((IndicationModifier) this.element).getClass();
        throw null;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final Density getDensity() {
        return HitTestResultKt.requireLayoutNode(this).density;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final LayoutDirection getLayoutDirection() {
        return HitTestResultKt.requireLayoutNode(this).layoutDirection;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final EmptyMap getProvidedValues() {
        return EmptyMap.INSTANCE;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    /* JADX INFO: renamed from: getSize-NH-jbRc */
    public final long mo337getSizeNHjbRc() {
        return IntSizeKt.m724toSizeozmzZPI(HitTestResultKt.m547requireCoordinator64DMado(this, 128).measuredSize);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    public final long mo31getTouchBoundsExpansionRZrCHBk() {
        return TouchBoundsExpansion.None;
    }

    public final void initializeModifier(boolean z) {
        if (!this.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("initializeModifier called on unattached node");
        }
        Modifier.Element element = this.element;
        if ((this.kindSet & 4) != 0 && !z) {
            HitTestResultKt.invalidateLayer(this);
        }
        if ((this.kindSet & 2) != 0) {
            if (((TailModifierNode) HitTestResultKt.requireLayoutNode(this).nodes.tail).attachHasBeenRun) {
                NodeCoordinator nodeCoordinator = this.coordinator;
                ((LayoutModifierNodeCoordinator) nodeCoordinator).setLayoutModifierNode$ui(this);
                OwnedLayer ownedLayer = nodeCoordinator.layer;
                if (ownedLayer != null) {
                    ((GraphicsLayerOwnerLayer) ownedLayer).invalidate();
                }
            }
            if (!z) {
                HitTestResultKt.invalidateLayer(this);
                HitTestResultKt.requireLayoutNode(this).invalidateMeasurements$ui();
            }
        }
        if (element instanceof LazyListState$remeasurementModifier$1) {
            ((LazyListState$remeasurementModifier$1) element).this$0.remeasurement = HitTestResultKt.requireLayoutNode(this);
        }
        if ((this.kindSet & 8) != 0) {
            ((AndroidComposeView) HitTestResultKt.requireOwner(this)).onSemanticsChange();
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final boolean interceptOutOfBoundsChildEvents() {
        this.element.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return true;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return this.isAttached;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return ((LayoutModifier) this.element).maxIntrinsicHeight(lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return ((LayoutModifier) this.element).maxIntrinsicWidth(lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return ((LayoutModifier) this.element).mo170measure3p2s80s(measureScope, measurable, j);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return ((LayoutModifier) this.element).minIntrinsicHeight(lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return ((LayoutModifier) this.element).minIntrinsicWidth(lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public final Object modifyParentData(Object obj) {
        return (AnimatedContentTransitionScopeImpl.ChildData) this.element;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        initializeModifier(true);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        this.element.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        if (!this.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("unInitializeModifier called on unattached node");
        }
        if ((this.kindSet & 8) != 0) {
            ((AndroidComposeView) HitTestResultKt.requireOwner(this)).onSemanticsChange();
        }
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusStateImpl focusStateImpl) {
        Modifier.Element element = this.element;
        InlineClassHelperKt.throwIllegalStateException("onFocusEvent called on wrong node");
        element.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.element.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void onMeasureResultChanged() {
        HitTestResultKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public final void mo36onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.element.getClass();
        throw new ClassCastException();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onViewConfigurationChange() {
        onCancelPointerInput();
        throw null;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final boolean sharePointerInputWithSiblings() {
        this.element.getClass();
        throw new ClassCastException();
    }

    public final String toString() {
        return this.element.toString();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDensityChange() {
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(LayoutCoordinates layoutCoordinates) {
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final void mo66onRemeasuredozmzZPI(long j) {
    }
}
