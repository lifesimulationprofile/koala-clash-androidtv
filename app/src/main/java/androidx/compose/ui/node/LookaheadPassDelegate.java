package androidx.compose.ui.node;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.navigation.Navigator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    public boolean duringAlignmentLinesQuery;
    public Function1 lastLayerBlock;
    public boolean layingOutChildren;
    public final LookaheadPassDelegate$layoutChildrenBlock$1 layoutChildrenBlock;
    public final LookaheadPassDelegate$layoutChildrenBlock$1 layoutModifierBlock;
    public final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    public Constraints lookaheadConstraints;
    public boolean measuredOnce;
    public boolean onNodePlacedCalled;
    public Object parentData;
    public final LookaheadPassDelegate$layoutChildrenBlock$1 performMeasureBlock;
    public boolean placedOnce;
    public boolean relayoutWithoutParentInProgress;
    public int previousPlaceOrder = Integer.MAX_VALUE;
    public int placeOrder = Integer.MAX_VALUE;
    public int measuredByParent = 3;
    public long lastPosition = 0;
    public int _placedState = 3;
    public final LookaheadAlignmentLines alignmentLines = new LookaheadAlignmentLines(this, 0);
    public final MutableVector _childDelegates = new MutableVector(new LookaheadPassDelegate[16]);
    public boolean childDelegatesDirty = true;
    public boolean parentDataDirty = true;
    public long performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.node.LookaheadPassDelegate$layoutChildrenBlock$1] */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.node.LookaheadPassDelegate$layoutChildrenBlock$1] */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.node.LookaheadPassDelegate$layoutChildrenBlock$1] */
    public LookaheadPassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
        final int i = 0;
        this.layoutChildrenBlock = new Function0(this) { // from class: androidx.compose.ui.node.LookaheadPassDelegate$layoutChildrenBlock$1
            public final /* synthetic */ LookaheadPassDelegate this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LookaheadDelegate lookaheadDelegate;
                int i2 = i;
                LookaheadPassDelegate lookaheadPassDelegate = this.this$0;
                switch (i2) {
                    case 0:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder = 0;
                        MutableVector mutableVector = layoutNodeLayoutDelegate2.layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i3 = mutableVector.size;
                        for (int i4 = 0; i4 < i3; i4++) {
                            LookaheadPassDelegate lookaheadPassDelegate2 = ((LayoutNode) objArr[i4]).layoutDelegate.lookaheadPassDelegate;
                            lookaheadPassDelegate2.previousPlaceOrder = lookaheadPassDelegate2.placeOrder;
                            lookaheadPassDelegate2.placeOrder = Integer.MAX_VALUE;
                            if (lookaheadPassDelegate2.measuredByParent == 2) {
                                lookaheadPassDelegate2.measuredByParent = 3;
                            }
                        }
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        LayoutNode layoutNode2 = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i5 = mutableVector2.size;
                        for (int i6 = 0; i6 < i5; i6++) {
                            ((LayoutNode) objArr2[i6]).layoutDelegate.lookaheadPassDelegate.alignmentLines.usedDuringParentLayout = false;
                            Unit unit = Unit.INSTANCE;
                        }
                        InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
                        if (lookaheadDelegateImpl != null) {
                            boolean z = lookaheadDelegateImpl.isPlacingForAlignment;
                            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i7 = ((MutableVector) objectListMutableList.objectList).size;
                            for (int i8 = 0; i8 < i7; i8++) {
                                LookaheadDelegate lookaheadDelegate2 = ((NodeCoordinator) ((LayoutNode) objectListMutableList.get(i8)).nodes.outerCoordinator).getLookaheadDelegate();
                                if (lookaheadDelegate2 != null) {
                                    lookaheadDelegate2.isPlacingForAlignment = z;
                                }
                            }
                        }
                        lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate.getMeasureResult$ui().placeChildren();
                        if (lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate != null) {
                            MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i9 = ((MutableVector) objectListMutableList2.objectList).size;
                            for (int i10 = 0; i10 < i9; i10++) {
                                LookaheadDelegate lookaheadDelegate3 = ((NodeCoordinator) ((LayoutNode) objectListMutableList2.get(i10)).nodes.outerCoordinator).getLookaheadDelegate();
                                if (lookaheadDelegate3 != null) {
                                    lookaheadDelegate3.isPlacingForAlignment = false;
                                }
                            }
                        }
                        MutableVector mutableVector3 = layoutNode2.get_children$ui();
                        Object[] objArr3 = mutableVector3.content;
                        int i11 = mutableVector3.size;
                        for (int i12 = 0; i12 < i11; i12++) {
                            LookaheadPassDelegate lookaheadPassDelegate3 = ((LayoutNode) objArr3[i12]).layoutDelegate.lookaheadPassDelegate;
                            int i13 = lookaheadPassDelegate3.previousPlaceOrder;
                            int i14 = lookaheadPassDelegate3.placeOrder;
                            if (i13 != i14 && i14 == Integer.MAX_VALUE) {
                                lookaheadPassDelegate3.markNodeAndSubtreeAsNotPlaced$ui(true);
                            }
                        }
                        MutableVector mutableVector4 = layoutNode2.get_children$ui();
                        Object[] objArr4 = mutableVector4.content;
                        int i15 = mutableVector4.size;
                        for (int i16 = 0; i16 < i15; i16++) {
                            LookaheadAlignmentLines lookaheadAlignmentLines = ((LayoutNode) objArr4[i16]).layoutDelegate.lookaheadPassDelegate.alignmentLines;
                            lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        Placeable.PlacementScope placementScope = null;
                        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate3.layoutNode) || layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement) {
                            NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator != null) {
                                placementScope = nodeCoordinator.placementScope;
                            }
                        } else {
                            NodeCoordinator nodeCoordinator2 = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator2 != null && (lookaheadDelegate = nodeCoordinator2.getLookaheadDelegate()) != null) {
                                placementScope = lookaheadDelegate.placementScope;
                            }
                        }
                        if (placementScope == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate3.layoutNode)).getPlacementScope();
                        }
                        Placeable.PlacementScope.m536place70tqf50$default(placementScope, layoutNodeLayoutDelegate3.getOuterCoordinator().getLookaheadDelegate(), lookaheadPassDelegate.lastPosition);
                        break;
                    default:
                        lookaheadPassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().mo517measureBRTryo0(lookaheadPassDelegate.performMeasureConstraints);
                        break;
                }
                return Unit.INSTANCE;
            }
        };
        this.parentData = layoutNodeLayoutDelegate.measurePassDelegate.parentData;
        final int i2 = 2;
        this.performMeasureBlock = new Function0(this) { // from class: androidx.compose.ui.node.LookaheadPassDelegate$layoutChildrenBlock$1
            public final /* synthetic */ LookaheadPassDelegate this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LookaheadDelegate lookaheadDelegate;
                int i3 = i2;
                LookaheadPassDelegate lookaheadPassDelegate = this.this$0;
                switch (i3) {
                    case 0:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder = 0;
                        MutableVector mutableVector = layoutNodeLayoutDelegate2.layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i4 = mutableVector.size;
                        for (int i5 = 0; i5 < i4; i5++) {
                            LookaheadPassDelegate lookaheadPassDelegate2 = ((LayoutNode) objArr[i5]).layoutDelegate.lookaheadPassDelegate;
                            lookaheadPassDelegate2.previousPlaceOrder = lookaheadPassDelegate2.placeOrder;
                            lookaheadPassDelegate2.placeOrder = Integer.MAX_VALUE;
                            if (lookaheadPassDelegate2.measuredByParent == 2) {
                                lookaheadPassDelegate2.measuredByParent = 3;
                            }
                        }
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        LayoutNode layoutNode2 = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i6 = mutableVector2.size;
                        for (int i7 = 0; i7 < i6; i7++) {
                            ((LayoutNode) objArr2[i7]).layoutDelegate.lookaheadPassDelegate.alignmentLines.usedDuringParentLayout = false;
                            Unit unit = Unit.INSTANCE;
                        }
                        InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
                        if (lookaheadDelegateImpl != null) {
                            boolean z = lookaheadDelegateImpl.isPlacingForAlignment;
                            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i8 = ((MutableVector) objectListMutableList.objectList).size;
                            for (int i9 = 0; i9 < i8; i9++) {
                                LookaheadDelegate lookaheadDelegate2 = ((NodeCoordinator) ((LayoutNode) objectListMutableList.get(i9)).nodes.outerCoordinator).getLookaheadDelegate();
                                if (lookaheadDelegate2 != null) {
                                    lookaheadDelegate2.isPlacingForAlignment = z;
                                }
                            }
                        }
                        lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate.getMeasureResult$ui().placeChildren();
                        if (lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate != null) {
                            MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i10 = ((MutableVector) objectListMutableList2.objectList).size;
                            for (int i11 = 0; i11 < i10; i11++) {
                                LookaheadDelegate lookaheadDelegate3 = ((NodeCoordinator) ((LayoutNode) objectListMutableList2.get(i11)).nodes.outerCoordinator).getLookaheadDelegate();
                                if (lookaheadDelegate3 != null) {
                                    lookaheadDelegate3.isPlacingForAlignment = false;
                                }
                            }
                        }
                        MutableVector mutableVector3 = layoutNode2.get_children$ui();
                        Object[] objArr3 = mutableVector3.content;
                        int i12 = mutableVector3.size;
                        for (int i13 = 0; i13 < i12; i13++) {
                            LookaheadPassDelegate lookaheadPassDelegate3 = ((LayoutNode) objArr3[i13]).layoutDelegate.lookaheadPassDelegate;
                            int i14 = lookaheadPassDelegate3.previousPlaceOrder;
                            int i15 = lookaheadPassDelegate3.placeOrder;
                            if (i14 != i15 && i15 == Integer.MAX_VALUE) {
                                lookaheadPassDelegate3.markNodeAndSubtreeAsNotPlaced$ui(true);
                            }
                        }
                        MutableVector mutableVector4 = layoutNode2.get_children$ui();
                        Object[] objArr4 = mutableVector4.content;
                        int i16 = mutableVector4.size;
                        for (int i17 = 0; i17 < i16; i17++) {
                            LookaheadAlignmentLines lookaheadAlignmentLines = ((LayoutNode) objArr4[i17]).layoutDelegate.lookaheadPassDelegate.alignmentLines;
                            lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        Placeable.PlacementScope placementScope = null;
                        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate3.layoutNode) || layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement) {
                            NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator != null) {
                                placementScope = nodeCoordinator.placementScope;
                            }
                        } else {
                            NodeCoordinator nodeCoordinator2 = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator2 != null && (lookaheadDelegate = nodeCoordinator2.getLookaheadDelegate()) != null) {
                                placementScope = lookaheadDelegate.placementScope;
                            }
                        }
                        if (placementScope == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate3.layoutNode)).getPlacementScope();
                        }
                        Placeable.PlacementScope.m536place70tqf50$default(placementScope, layoutNodeLayoutDelegate3.getOuterCoordinator().getLookaheadDelegate(), lookaheadPassDelegate.lastPosition);
                        break;
                    default:
                        lookaheadPassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().mo517measureBRTryo0(lookaheadPassDelegate.performMeasureConstraints);
                        break;
                }
                return Unit.INSTANCE;
            }
        };
        final int i3 = 1;
        this.layoutModifierBlock = new Function0(this) { // from class: androidx.compose.ui.node.LookaheadPassDelegate$layoutChildrenBlock$1
            public final /* synthetic */ LookaheadPassDelegate this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LookaheadDelegate lookaheadDelegate;
                int i4 = i3;
                LookaheadPassDelegate lookaheadPassDelegate = this.this$0;
                switch (i4) {
                    case 0:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder = 0;
                        MutableVector mutableVector = layoutNodeLayoutDelegate2.layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i5 = mutableVector.size;
                        for (int i6 = 0; i6 < i5; i6++) {
                            LookaheadPassDelegate lookaheadPassDelegate2 = ((LayoutNode) objArr[i6]).layoutDelegate.lookaheadPassDelegate;
                            lookaheadPassDelegate2.previousPlaceOrder = lookaheadPassDelegate2.placeOrder;
                            lookaheadPassDelegate2.placeOrder = Integer.MAX_VALUE;
                            if (lookaheadPassDelegate2.measuredByParent == 2) {
                                lookaheadPassDelegate2.measuredByParent = 3;
                            }
                        }
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        LayoutNode layoutNode2 = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i7 = mutableVector2.size;
                        for (int i8 = 0; i8 < i7; i8++) {
                            ((LayoutNode) objArr2[i8]).layoutDelegate.lookaheadPassDelegate.alignmentLines.usedDuringParentLayout = false;
                            Unit unit = Unit.INSTANCE;
                        }
                        InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
                        if (lookaheadDelegateImpl != null) {
                            boolean z = lookaheadDelegateImpl.isPlacingForAlignment;
                            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i9 = ((MutableVector) objectListMutableList.objectList).size;
                            for (int i10 = 0; i10 < i9; i10++) {
                                LookaheadDelegate lookaheadDelegate2 = ((NodeCoordinator) ((LayoutNode) objectListMutableList.get(i10)).nodes.outerCoordinator).getLookaheadDelegate();
                                if (lookaheadDelegate2 != null) {
                                    lookaheadDelegate2.isPlacingForAlignment = z;
                                }
                            }
                        }
                        lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate.getMeasureResult$ui().placeChildren();
                        if (lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate != null) {
                            MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i11 = ((MutableVector) objectListMutableList2.objectList).size;
                            for (int i12 = 0; i12 < i11; i12++) {
                                LookaheadDelegate lookaheadDelegate3 = ((NodeCoordinator) ((LayoutNode) objectListMutableList2.get(i12)).nodes.outerCoordinator).getLookaheadDelegate();
                                if (lookaheadDelegate3 != null) {
                                    lookaheadDelegate3.isPlacingForAlignment = false;
                                }
                            }
                        }
                        MutableVector mutableVector3 = layoutNode2.get_children$ui();
                        Object[] objArr3 = mutableVector3.content;
                        int i13 = mutableVector3.size;
                        for (int i14 = 0; i14 < i13; i14++) {
                            LookaheadPassDelegate lookaheadPassDelegate3 = ((LayoutNode) objArr3[i14]).layoutDelegate.lookaheadPassDelegate;
                            int i15 = lookaheadPassDelegate3.previousPlaceOrder;
                            int i16 = lookaheadPassDelegate3.placeOrder;
                            if (i15 != i16 && i16 == Integer.MAX_VALUE) {
                                lookaheadPassDelegate3.markNodeAndSubtreeAsNotPlaced$ui(true);
                            }
                        }
                        MutableVector mutableVector4 = layoutNode2.get_children$ui();
                        Object[] objArr4 = mutableVector4.content;
                        int i17 = mutableVector4.size;
                        for (int i18 = 0; i18 < i17; i18++) {
                            LookaheadAlignmentLines lookaheadAlignmentLines = ((LayoutNode) objArr4[i18]).layoutDelegate.lookaheadPassDelegate.alignmentLines;
                            lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        Placeable.PlacementScope placementScope = null;
                        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate3.layoutNode) || layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement) {
                            NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator != null) {
                                placementScope = nodeCoordinator.placementScope;
                            }
                        } else {
                            NodeCoordinator nodeCoordinator2 = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator2 != null && (lookaheadDelegate = nodeCoordinator2.getLookaheadDelegate()) != null) {
                                placementScope = lookaheadDelegate.placementScope;
                            }
                        }
                        if (placementScope == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate3.layoutNode)).getPlacementScope();
                        }
                        Placeable.PlacementScope.m536place70tqf50$default(placementScope, layoutNodeLayoutDelegate3.getOuterCoordinator().getLookaheadDelegate(), lookaheadPassDelegate.lastPosition);
                        break;
                    default:
                        lookaheadPassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().mo517measureBRTryo0(lookaheadPassDelegate.performMeasureConstraints);
                        break;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void forEachChildAlignmentLinesOwner(Navigator.AnonymousClass1 anonymousClass1) {
        MutableVector mutableVector = this.layoutNodeLayoutDelegate.layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            anonymousClass1.invoke(((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate);
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int get(AlignmentLine alignmentLine) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        int i = parent$ui != null ? parent$ui.layoutDelegate.layoutState : 0;
        LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
        if (i == 2) {
            lookaheadAlignmentLines.usedDuringParentMeasurement = true;
        } else {
            LayoutNode parent$ui2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
            if ((parent$ui2 != null ? parent$ui2.layoutDelegate.layoutState : 0) == 4) {
                lookaheadAlignmentLines.usedDuringParentLayout = true;
            }
        }
        this.duringAlignmentLinesQuery = true;
        int i2 = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i2;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final LookaheadAlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final InnerNodeCoordinator getInnerCoordinator() {
        return (InnerNodeCoordinator) this.layoutNodeLayoutDelegate.layoutNode.nodes.innerCoordinator;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int getMeasuredHeight() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int getMeasuredWidth() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().getMeasuredWidth();
    }

    public final boolean getNeedsToBePlacedInApproach() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        return HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode) || layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        LayoutNode parent$ui = this.layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        if (parent$ui == null || (layoutNodeLayoutDelegate = parent$ui.layoutDelegate) == null) {
            return null;
        }
        return layoutNodeLayoutDelegate.lookaheadPassDelegate;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measurable
    public final Object getParentData() {
        return this.parentData;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final int getPlaceOrder() {
        return this.placeOrder;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void layoutChildren() {
        this.layingOutChildren = true;
        LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
        lookaheadAlignmentLines.recalculateQueryOwner();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        boolean z = layoutNodeLayoutDelegate.lookaheadLayoutPending;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        if (z) {
            MutableVector mutableVector = layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
                if (layoutNode2.layoutDelegate.lookaheadMeasurePending && layoutNode2.getMeasuredByParentInLookahead$ui() == 1) {
                    LookaheadPassDelegate lookaheadPassDelegate = layoutNode2.layoutDelegate.lookaheadPassDelegate;
                    if (lookaheadPassDelegate.m558remeasureBRTryo0((lookaheadPassDelegate != null ? lookaheadPassDelegate.lookaheadConstraints : null).value)) {
                        LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, false, 7);
                    }
                }
            }
        }
        InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl = getInnerCoordinator().lookaheadDelegate;
        if (layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegateImpl.isPlacingForAlignment && layoutNodeLayoutDelegate.lookaheadLayoutPending)) {
            layoutNodeLayoutDelegate.lookaheadLayoutPending = false;
            int i3 = layoutNodeLayoutDelegate.layoutState;
            layoutNodeLayoutDelegate.layoutState = 4;
            layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSnapshotObserver();
            snapshotObserver.observer.observeReads(layoutNode, snapshotObserver.onCommitAffectingLookahead, this.layoutChildrenBlock);
            layoutNodeLayoutDelegate.layoutState = i3;
            if (layoutNodeLayoutDelegate.lookaheadCoordinatesAccessedDuringPlacement && lookaheadDelegateImpl.isPlacingForAlignment) {
                requestLayout();
            }
            layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = false;
        }
        if (lookaheadAlignmentLines.usedDuringParentLayout) {
            lookaheadAlignmentLines.previousUsedDuringParentLayout = true;
        }
        if (lookaheadAlignmentLines.dirty && lookaheadAlignmentLines.getRequired$ui()) {
            lookaheadAlignmentLines.recalculate();
        }
        this.layingOutChildren = false;
    }

    public final void markNodeAndSubtreeAsNotPlaced$ui(boolean z) {
        if (z && getNeedsToBePlacedInApproach()) {
            return;
        }
        if (z || getNeedsToBePlacedInApproach()) {
            this._placedState = 3;
            MutableVector mutableVector = this.layoutNodeLayoutDelegate.layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui(true);
            }
        }
    }

    public final void markNodeAndSubtreeAsPlaced() {
        int i = this._placedState;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        boolean z = layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        if (z) {
            this._placedState = 2;
        } else {
            this._placedState = 1;
        }
        if (i != 1 && layoutNodeLayoutDelegate.lookaheadMeasurePending) {
            LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, true, 6);
        }
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i2 = mutableVector.size;
        for (int i3 = 0; i3 < i2; i3++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i3];
            LookaheadPassDelegate lookaheadPassDelegate = layoutNode2.layoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate == null) {
                throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
            }
            if (lookaheadPassDelegate.placeOrder != Integer.MAX_VALUE) {
                lookaheadPassDelegate.markNodeAndSubtreeAsPlaced();
                LayoutNode.rescheduleRemeasureOrRelayout$ui(layoutNode2);
            }
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicHeight(int i) {
        onIntrinsicsQueried();
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicWidth(int i) {
        onIntrinsicsQueried();
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().maxIntrinsicWidth(i);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public final Placeable mo517measureBRTryo0(long j) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode parent$ui = layoutNode.getParent$ui();
        int i = 2;
        if ((parent$ui != null ? parent$ui.layoutDelegate.layoutState : 0) == 2) {
            layoutNodeLayoutDelegate.detachedFromParentLookaheadPass = false;
        } else {
            LayoutNode parent$ui2 = layoutNode2.getParent$ui();
            if ((parent$ui2 != null ? parent$ui2.layoutDelegate.layoutState : 0) == 4) {
                layoutNodeLayoutDelegate.detachedFromParentLookaheadPass = false;
            }
        }
        LayoutNode parent$ui3 = layoutNode2.getParent$ui();
        if (parent$ui3 != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui3.layoutDelegate;
            if (this.measuredByParent != 3 && !layoutNode2.canMultiMeasure) {
                InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(layoutNodeLayoutDelegate2.layoutState);
            if (iOrdinal == 0 || iOrdinal == 1) {
                i = 1;
            } else if (iOrdinal != 2 && iOrdinal != 3) {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is ".concat(Modifier.CC.stringValueOf$4(layoutNodeLayoutDelegate2.layoutState)));
            }
            this.measuredByParent = i;
        } else {
            this.measuredByParent = 3;
        }
        if (layoutNode2.intrinsicsUsageByParent == 3) {
            layoutNode2.clearSubtreeIntrinsicsUsage$ui();
        }
        m558remeasureBRTryo0(j);
        return this;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicHeight(int i) {
        onIntrinsicsQueried();
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicWidth(int i) {
        onIntrinsicsQueried();
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate().minIntrinsicWidth(i);
    }

    public final void notifyChildrenUsingLookaheadCoordinatesWhilePlacing() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (layoutNodeLayoutDelegate.childrenAccessingLookaheadCoordinatesDuringPlacement > 0) {
            MutableVector mutableVector = layoutNodeLayoutDelegate.layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                LayoutNode layoutNode = (LayoutNode) objArr[i2];
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode.layoutDelegate;
                if ((layoutNodeLayoutDelegate2.lookaheadCoordinatesAccessedDuringPlacement || layoutNodeLayoutDelegate2.lookaheadCoordinatesAccessedDuringModifierPlacement) && !layoutNodeLayoutDelegate2.lookaheadLayoutPending) {
                    layoutNode.requestLookaheadRelayout$ui(false);
                }
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate2.lookaheadPassDelegate;
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
                }
            }
        }
    }

    public final void onIntrinsicsQueried() {
        int i;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode.requestLookaheadRemeasure$ui$default(layoutNodeLayoutDelegate.layoutNode, false, 7);
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode parent$ui = layoutNode.getParent$ui();
        if (parent$ui == null || layoutNode.intrinsicsUsageByParent != 3) {
            return;
        }
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(parent$ui.layoutDelegate.layoutState);
        if (iOrdinal != 0) {
            i = 2;
            if (iOrdinal != 2) {
                i = parent$ui.intrinsicsUsageByParent;
            }
        } else {
            i = 1;
        }
        layoutNode.intrinsicsUsageByParent = i;
    }

    public final void onNodePlaced$ui() {
        int i;
        this.onNodePlacedCalled = true;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        int i2 = this._placedState;
        if ((i2 != 1 && !layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement) || (i2 != 2 && layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement)) {
            markNodeAndSubtreeAsPlaced();
            if (this.relayoutWithoutParentInProgress && parent$ui != null) {
                parent$ui.requestLookaheadRelayout$ui(false);
            }
        }
        if (parent$ui != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui.layoutDelegate;
            if (!this.relayoutWithoutParentInProgress && ((i = layoutNodeLayoutDelegate2.layoutState) == 3 || i == 4)) {
                if (this.placeOrder != Integer.MAX_VALUE) {
                    InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                }
                int i3 = layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder;
                this.placeOrder = i3;
                layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder = i3 + 1;
            }
        } else {
            this.placeOrder = 0;
        }
        layoutChildren();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo521placeAtf8xVGno(long j, float f, Function1 function1) throws Throwable {
        m557placeSelfMLgxB_4$1(j, function1);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0068 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0006, B:5:0x000d, B:9:0x0016, B:12:0x001b, B:14:0x001f, B:15:0x0024, B:17:0x0033, B:19:0x0037, B:22:0x003d, B:21:0x003b, B:23:0x0040, B:25:0x004a, B:30:0x0053, B:32:0x007e, B:31:0x0068), top: B:36:0x0006 }] */
    /* JADX INFO: renamed from: placeSelf-MLgxB_4$1, reason: not valid java name */
    public final void m557placeSelfMLgxB_4$1(long j, Function1 function1) throws Throwable {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        try {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            if ((parent$ui != null ? parent$ui.layoutDelegate.layoutState : 0) == 4) {
                layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement = false;
            }
            if (layoutNode2.isDeactivated) {
                InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
            }
            layoutNodeLayoutDelegate.layoutState = 4;
            boolean z = true;
            this.placedOnce = true;
            this.onNodePlacedCalled = false;
            if (!IntOffset.m712equalsimpl0(j, this.lastPosition)) {
                if (layoutNodeLayoutDelegate.lookaheadCoordinatesAccessedDuringModifierPlacement || layoutNodeLayoutDelegate.lookaheadCoordinatesAccessedDuringPlacement) {
                    layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
                }
                notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }
            Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode2);
            this.lastPosition = j;
            if (layoutNodeLayoutDelegate.lookaheadLayoutPending) {
                layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringModifierPlacement(false);
                this.alignmentLines.usedByModifierLayout = false;
                OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) ownerRequireOwner).getSnapshotObserver();
                snapshotObserver.observer.observeReads(layoutNode2, snapshotObserver.onCommitAffectingLayoutModifierInLookahead, this.layoutModifierBlock);
            } else {
                if (this._placedState == 3) {
                    z = false;
                }
                if (z) {
                    LookaheadDelegate lookaheadDelegate = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
                    lookaheadDelegate.m555placeSelfgyyYBs(IntOffset.m714plusqkQi6aY(j, lookaheadDelegate.apparentToRealOffset));
                    onNodePlaced$ui();
                } else {
                    layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringModifierPlacement(false);
                    this.alignmentLines.usedByModifierLayout = false;
                    OwnerSnapshotObserver snapshotObserver2 = ((AndroidComposeView) ownerRequireOwner).getSnapshotObserver();
                    snapshotObserver2.observer.observeReads(layoutNode2, snapshotObserver2.onCommitAffectingLayoutModifierInLookahead, this.layoutModifierBlock);
                }
            }
            this.lastLayerBlock = function1;
            layoutNodeLayoutDelegate.layoutState = 5;
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    /* JADX INFO: renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m558remeasureBRTryo0(long j) throws Throwable {
        long j2;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        try {
            if (layoutNode.isDeactivated) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            LayoutNode parent$ui = layoutNode2.getParent$ui();
            layoutNode2.canMultiMeasure = layoutNode2.canMultiMeasure || (parent$ui != null && parent$ui.canMultiMeasure);
            if (!layoutNode2.layoutDelegate.lookaheadMeasurePending) {
                Constraints constraints = this.lookaheadConstraints;
                if (constraints == null ? false : Constraints.m677equalsimpl0(constraints.value, j)) {
                    Owner owner = layoutNode2.owner;
                    if (owner != null) {
                        ((AndroidComposeView) owner).forceMeasureTheSubtree(layoutNode2, true);
                    }
                    layoutNode2.resetSubtreeIntrinsicsUsage$ui();
                    return false;
                }
            }
            this.lookaheadConstraints = new Constraints(j);
            m535setMeasurementConstraintsBRTryo0(j);
            this.alignmentLines.usedByModifierMeasurement = false;
            MutableVector mutableVector = layoutNode2.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate.alignmentLines.usedDuringParentMeasurement = false;
                Unit unit = Unit.INSTANCE;
            }
            if (this.measuredOnce) {
                j2 = this.measuredSize;
            } else {
                long j3 = Integer.MIN_VALUE;
                j2 = (j3 & 4294967295L) | (j3 << 32);
            }
            this.measuredOnce = true;
            LookaheadDelegate lookaheadDelegate = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
            if (!(lookaheadDelegate != null)) {
                InlineClassHelperKt.throwIllegalStateException("Lookahead result from lookaheadRemeasure cannot be null");
            }
            layoutNodeLayoutDelegate.m552performLookaheadMeasureBRTryo0$ui(j);
            m534setMeasuredSizeozmzZPI((((long) lookaheadDelegate.height) & 4294967295L) | (((long) lookaheadDelegate.width) << 32));
            return (((int) (j2 >> 32)) == lookaheadDelegate.width && ((int) (j2 & 4294967295L)) == lookaheadDelegate.height) ? false : true;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void requestLayout() {
        this.layoutNodeLayoutDelegate.layoutNode.requestLookaheadRelayout$ui(false);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void requestMeasure() {
        LayoutNode.requestLookaheadRemeasure$ui$default(this.layoutNodeLayoutDelegate.layoutNode, false, 7);
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public final void updatePlacedUnderMotionFrameOfReference(boolean z) {
        LookaheadDelegate lookaheadDelegate;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LookaheadDelegate lookaheadDelegate2 = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        if (Boolean.valueOf(z).equals(lookaheadDelegate2 != null ? Boolean.valueOf(lookaheadDelegate2.isPlacedUnderMotionFrameOfReference) : null) || (lookaheadDelegate = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate()) == null) {
            return;
        }
        lookaheadDelegate.isPlacedUnderMotionFrameOfReference = z;
    }
}
