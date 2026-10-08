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
import androidx.compose.ui.unit.IntSize;
import androidx.navigation.Navigator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    public boolean duringAlignmentLinesQuery;
    public boolean isPlaced;
    public boolean isPlacedByParent;
    public Function1 lastLayerBlock;
    public float lastZIndex;
    public boolean layingOutChildren;
    public final MeasurePassDelegate$layoutChildrenBlock$1 layoutChildrenBlock;
    public final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    public boolean layoutPending;
    public boolean layoutPendingForAlignment;
    public boolean measurePending;
    public boolean measuredOnce;
    public boolean needsCoordinatesUpdate;
    public boolean onNodePlacedCalled;
    public Object parentData;
    public final MeasurePassDelegate$layoutChildrenBlock$1 performMeasureBlock;
    public final MeasurePassDelegate$layoutChildrenBlock$1 placeOuterCoordinatorBlock;
    public Function1 placeOuterCoordinatorLayerBlock;
    public float placeOuterCoordinatorZIndex;
    public boolean placedOnce;
    public boolean relayoutWithoutParentInProgress;
    public float zIndex;
    public int previousPlaceOrder = Integer.MAX_VALUE;
    public int placeOrder = Integer.MAX_VALUE;
    public int measuredByParent = 3;
    public long lastPosition = 0;
    public boolean parentDataDirty = true;
    public final LookaheadAlignmentLines alignmentLines = new LookaheadAlignmentLines(this, 1);
    public final MutableVector _childDelegates = new MutableVector(new MeasurePassDelegate[16]);
    public boolean childDelegatesDirty = true;
    public long performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
    public long placeOuterCoordinatorPosition = 0;

    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1] */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1] */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1] */
    public MeasurePassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
        final int i = 1;
        this.performMeasureBlock = new Function0(this) { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1
            public final /* synthetic */ MeasurePassDelegate this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Placeable.PlacementScope placementScope;
                int i2 = i;
                MeasurePassDelegate measurePassDelegate = this.this$0;
                switch (i2) {
                    case 0:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = measurePassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildPlaceOrder = 0;
                        MutableVector mutableVector = layoutNodeLayoutDelegate2.layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i3 = mutableVector.size;
                        for (int i4 = 0; i4 < i3; i4++) {
                            MeasurePassDelegate measurePassDelegate2 = ((LayoutNode) objArr[i4]).layoutDelegate.measurePassDelegate;
                            measurePassDelegate2.previousPlaceOrder = measurePassDelegate2.placeOrder;
                            measurePassDelegate2.placeOrder = Integer.MAX_VALUE;
                            measurePassDelegate2.isPlacedByParent = false;
                            if (measurePassDelegate2.measuredByParent == 2) {
                                measurePassDelegate2.measuredByParent = 3;
                            }
                        }
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        LayoutNode layoutNode2 = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i5 = mutableVector2.size;
                        for (int i6 = 0; i6 < i5; i6++) {
                            ((LayoutNode) objArr2[i6]).layoutDelegate.measurePassDelegate.alignmentLines.usedDuringParentLayout = false;
                            Unit unit = Unit.INSTANCE;
                        }
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i7 = ((MutableVector) objectListMutableList.objectList).size;
                            for (int i8 = 0; i8 < i7; i8++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList.get(i8)).nodes.outerCoordinator).isPlacingForAlignment = true;
                            }
                        }
                        measurePassDelegate.getInnerCoordinator().getMeasureResult$ui().placeChildren();
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i9 = ((MutableVector) objectListMutableList2.objectList).size;
                            for (int i10 = 0; i10 < i9; i10++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList2.get(i10)).nodes.outerCoordinator).isPlacingForAlignment = false;
                            }
                        }
                        MutableVector mutableVector3 = layoutNode2.get_children$ui();
                        Object[] objArr3 = mutableVector3.content;
                        int i11 = mutableVector3.size;
                        for (int i12 = 0; i12 < i11; i12++) {
                            LayoutNode layoutNode3 = (LayoutNode) objArr3[i12];
                            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = layoutNode3.layoutDelegate;
                            if (layoutNodeLayoutDelegate3.measurePassDelegate.previousPlaceOrder != layoutNode3.getPlaceOrder$ui()) {
                                layoutNode2.onZSortedChildrenInvalidated$ui();
                                layoutNode2.invalidateLayer$ui();
                                if (layoutNode3.getPlaceOrder$ui() == Integer.MAX_VALUE) {
                                    if (layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement || HitTestResultKt.isOutMostLookaheadRoot(layoutNode3)) {
                                        layoutNodeLayoutDelegate3.lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui(false);
                                    }
                                    layoutNodeLayoutDelegate3.measurePassDelegate.markSubtreeAsNotPlaced();
                                }
                            }
                        }
                        MutableVector mutableVector4 = layoutNode2.get_children$ui();
                        Object[] objArr4 = mutableVector4.content;
                        int i13 = mutableVector4.size;
                        for (int i14 = 0; i14 < i13; i14++) {
                            LookaheadAlignmentLines lookaheadAlignmentLines = ((LayoutNode) objArr4[i14]).layoutDelegate.measurePassDelegate.alignmentLines;
                            lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        measurePassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().mo517measureBRTryo0(measurePassDelegate.performMeasureConstraints);
                        break;
                    default:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate4 = measurePassDelegate.layoutNodeLayoutDelegate;
                        NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator().wrappedBy;
                        if (nodeCoordinator == null || (placementScope = nodeCoordinator.placementScope) == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate4.layoutNode)).getPlacementScope();
                        }
                        Function1 function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
                        if (function1 == null) {
                            NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.getClass();
                            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, outerCoordinator);
                            outerCoordinator.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j, outerCoordinator.apparentToRealOffset), f, null);
                        } else {
                            NodeCoordinator outerCoordinator2 = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j2 = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f2 = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.getClass();
                            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, outerCoordinator2);
                            outerCoordinator2.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j2, outerCoordinator2.apparentToRealOffset), f2, function1);
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        };
        final int i2 = 0;
        this.layoutChildrenBlock = new Function0(this) { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1
            public final /* synthetic */ MeasurePassDelegate this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Placeable.PlacementScope placementScope;
                int i3 = i2;
                MeasurePassDelegate measurePassDelegate = this.this$0;
                switch (i3) {
                    case 0:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = measurePassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildPlaceOrder = 0;
                        MutableVector mutableVector = layoutNodeLayoutDelegate2.layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i4 = mutableVector.size;
                        for (int i5 = 0; i5 < i4; i5++) {
                            MeasurePassDelegate measurePassDelegate2 = ((LayoutNode) objArr[i5]).layoutDelegate.measurePassDelegate;
                            measurePassDelegate2.previousPlaceOrder = measurePassDelegate2.placeOrder;
                            measurePassDelegate2.placeOrder = Integer.MAX_VALUE;
                            measurePassDelegate2.isPlacedByParent = false;
                            if (measurePassDelegate2.measuredByParent == 2) {
                                measurePassDelegate2.measuredByParent = 3;
                            }
                        }
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        LayoutNode layoutNode2 = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i6 = mutableVector2.size;
                        for (int i7 = 0; i7 < i6; i7++) {
                            ((LayoutNode) objArr2[i7]).layoutDelegate.measurePassDelegate.alignmentLines.usedDuringParentLayout = false;
                            Unit unit = Unit.INSTANCE;
                        }
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i8 = ((MutableVector) objectListMutableList.objectList).size;
                            for (int i9 = 0; i9 < i8; i9++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList.get(i9)).nodes.outerCoordinator).isPlacingForAlignment = true;
                            }
                        }
                        measurePassDelegate.getInnerCoordinator().getMeasureResult$ui().placeChildren();
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i10 = ((MutableVector) objectListMutableList2.objectList).size;
                            for (int i11 = 0; i11 < i10; i11++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList2.get(i11)).nodes.outerCoordinator).isPlacingForAlignment = false;
                            }
                        }
                        MutableVector mutableVector3 = layoutNode2.get_children$ui();
                        Object[] objArr3 = mutableVector3.content;
                        int i12 = mutableVector3.size;
                        for (int i13 = 0; i13 < i12; i13++) {
                            LayoutNode layoutNode3 = (LayoutNode) objArr3[i13];
                            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = layoutNode3.layoutDelegate;
                            if (layoutNodeLayoutDelegate3.measurePassDelegate.previousPlaceOrder != layoutNode3.getPlaceOrder$ui()) {
                                layoutNode2.onZSortedChildrenInvalidated$ui();
                                layoutNode2.invalidateLayer$ui();
                                if (layoutNode3.getPlaceOrder$ui() == Integer.MAX_VALUE) {
                                    if (layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement || HitTestResultKt.isOutMostLookaheadRoot(layoutNode3)) {
                                        layoutNodeLayoutDelegate3.lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui(false);
                                    }
                                    layoutNodeLayoutDelegate3.measurePassDelegate.markSubtreeAsNotPlaced();
                                }
                            }
                        }
                        MutableVector mutableVector4 = layoutNode2.get_children$ui();
                        Object[] objArr4 = mutableVector4.content;
                        int i14 = mutableVector4.size;
                        for (int i15 = 0; i15 < i14; i15++) {
                            LookaheadAlignmentLines lookaheadAlignmentLines = ((LayoutNode) objArr4[i15]).layoutDelegate.measurePassDelegate.alignmentLines;
                            lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        measurePassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().mo517measureBRTryo0(measurePassDelegate.performMeasureConstraints);
                        break;
                    default:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate4 = measurePassDelegate.layoutNodeLayoutDelegate;
                        NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator().wrappedBy;
                        if (nodeCoordinator == null || (placementScope = nodeCoordinator.placementScope) == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate4.layoutNode)).getPlacementScope();
                        }
                        Function1 function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
                        if (function1 == null) {
                            NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.getClass();
                            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, outerCoordinator);
                            outerCoordinator.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j, outerCoordinator.apparentToRealOffset), f, null);
                        } else {
                            NodeCoordinator outerCoordinator2 = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j2 = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f2 = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.getClass();
                            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, outerCoordinator2);
                            outerCoordinator2.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j2, outerCoordinator2.apparentToRealOffset), f2, function1);
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        };
        final int i3 = 2;
        this.placeOuterCoordinatorBlock = new Function0(this) { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1
            public final /* synthetic */ MeasurePassDelegate this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Placeable.PlacementScope placementScope;
                int i4 = i3;
                MeasurePassDelegate measurePassDelegate = this.this$0;
                switch (i4) {
                    case 0:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = measurePassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildPlaceOrder = 0;
                        MutableVector mutableVector = layoutNodeLayoutDelegate2.layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i5 = mutableVector.size;
                        for (int i6 = 0; i6 < i5; i6++) {
                            MeasurePassDelegate measurePassDelegate2 = ((LayoutNode) objArr[i6]).layoutDelegate.measurePassDelegate;
                            measurePassDelegate2.previousPlaceOrder = measurePassDelegate2.placeOrder;
                            measurePassDelegate2.placeOrder = Integer.MAX_VALUE;
                            measurePassDelegate2.isPlacedByParent = false;
                            if (measurePassDelegate2.measuredByParent == 2) {
                                measurePassDelegate2.measuredByParent = 3;
                            }
                        }
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        LayoutNode layoutNode2 = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i7 = mutableVector2.size;
                        for (int i8 = 0; i8 < i7; i8++) {
                            ((LayoutNode) objArr2[i8]).layoutDelegate.measurePassDelegate.alignmentLines.usedDuringParentLayout = false;
                            Unit unit = Unit.INSTANCE;
                        }
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i9 = ((MutableVector) objectListMutableList.objectList).size;
                            for (int i10 = 0; i10 < i9; i10++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList.get(i10)).nodes.outerCoordinator).isPlacingForAlignment = true;
                            }
                        }
                        measurePassDelegate.getInnerCoordinator().getMeasureResult$ui().placeChildren();
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode2.getChildren$ui();
                            int i11 = ((MutableVector) objectListMutableList2.objectList).size;
                            for (int i12 = 0; i12 < i11; i12++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList2.get(i12)).nodes.outerCoordinator).isPlacingForAlignment = false;
                            }
                        }
                        MutableVector mutableVector3 = layoutNode2.get_children$ui();
                        Object[] objArr3 = mutableVector3.content;
                        int i13 = mutableVector3.size;
                        for (int i14 = 0; i14 < i13; i14++) {
                            LayoutNode layoutNode3 = (LayoutNode) objArr3[i14];
                            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = layoutNode3.layoutDelegate;
                            if (layoutNodeLayoutDelegate3.measurePassDelegate.previousPlaceOrder != layoutNode3.getPlaceOrder$ui()) {
                                layoutNode2.onZSortedChildrenInvalidated$ui();
                                layoutNode2.invalidateLayer$ui();
                                if (layoutNode3.getPlaceOrder$ui() == Integer.MAX_VALUE) {
                                    if (layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement || HitTestResultKt.isOutMostLookaheadRoot(layoutNode3)) {
                                        layoutNodeLayoutDelegate3.lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui(false);
                                    }
                                    layoutNodeLayoutDelegate3.measurePassDelegate.markSubtreeAsNotPlaced();
                                }
                            }
                        }
                        MutableVector mutableVector4 = layoutNode2.get_children$ui();
                        Object[] objArr4 = mutableVector4.content;
                        int i15 = mutableVector4.size;
                        for (int i16 = 0; i16 < i15; i16++) {
                            LookaheadAlignmentLines lookaheadAlignmentLines = ((LayoutNode) objArr4[i16]).layoutDelegate.measurePassDelegate.alignmentLines;
                            lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        measurePassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().mo517measureBRTryo0(measurePassDelegate.performMeasureConstraints);
                        break;
                    default:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate4 = measurePassDelegate.layoutNodeLayoutDelegate;
                        NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator().wrappedBy;
                        if (nodeCoordinator == null || (placementScope = nodeCoordinator.placementScope) == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate4.layoutNode)).getPlacementScope();
                        }
                        Function1 function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
                        if (function1 == null) {
                            NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.getClass();
                            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, outerCoordinator);
                            outerCoordinator.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j, outerCoordinator.apparentToRealOffset), f, null);
                        } else {
                            NodeCoordinator outerCoordinator2 = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j2 = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f2 = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.getClass();
                            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, outerCoordinator2);
                            outerCoordinator2.mo521placeAtf8xVGno(IntOffset.m714plusqkQi6aY(j2, outerCoordinator2.apparentToRealOffset), f2, function1);
                        }
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
            anonymousClass1.invoke(((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate);
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int get(AlignmentLine alignmentLine) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        int i = parent$ui != null ? parent$ui.layoutDelegate.layoutState : 0;
        LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
        if (i == 1) {
            lookaheadAlignmentLines.usedDuringParentMeasurement = true;
        } else {
            LayoutNode parent$ui2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
            if ((parent$ui2 != null ? parent$ui2.layoutDelegate.layoutState : 0) == 3) {
                lookaheadAlignmentLines.usedDuringParentLayout = true;
            }
        }
        this.duringAlignmentLinesQuery = true;
        int i2 = layoutNodeLayoutDelegate.getOuterCoordinator().get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i2;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final LookaheadAlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    public final List getChildDelegates$ui() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        layoutNodeLayoutDelegate.layoutNode.updateChildrenIfDirty$ui();
        boolean z = this.childDelegatesDirty;
        MutableVector mutableVector = this._childDelegates;
        if (!z) {
            return mutableVector.asMutableList();
        }
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        MutableVector mutableVector2 = layoutNode.get_children$ui();
        Object[] objArr = mutableVector2.content;
        int i = mutableVector2.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (mutableVector.size <= i2) {
                mutableVector.add(layoutNode2.layoutDelegate.measurePassDelegate);
            } else {
                MeasurePassDelegate measurePassDelegate = layoutNode2.layoutDelegate.measurePassDelegate;
                Object[] objArr2 = mutableVector.content;
                Object obj = objArr2[i2];
                objArr2[i2] = measurePassDelegate;
            }
        }
        mutableVector.removeRange(((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).objectList).size, mutableVector.size);
        this.childDelegatesDirty = false;
        return mutableVector.asMutableList();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final InnerNodeCoordinator getInnerCoordinator() {
        return (InnerNodeCoordinator) this.layoutNodeLayoutDelegate.layoutNode.nodes.innerCoordinator;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int getMeasuredHeight() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int getMeasuredWidth() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getMeasuredWidth();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        LayoutNode parent$ui = this.layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        if (parent$ui == null || (layoutNodeLayoutDelegate = parent$ui.layoutDelegate) == null) {
            return null;
        }
        return layoutNodeLayoutDelegate.measurePassDelegate;
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
    public final void layoutChildren() throws Throwable {
        boolean zM564remeasureBRTryo0;
        this.layingOutChildren = true;
        LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
        lookaheadAlignmentLines.recalculateQueryOwner();
        boolean z = this.layoutPending;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (z) {
            MutableVector mutableVector = layoutNodeLayoutDelegate.layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                LayoutNode layoutNode = (LayoutNode) objArr[i2];
                boolean measurePending$ui = layoutNode.getMeasurePending$ui();
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode.layoutDelegate;
                if (measurePending$ui && layoutNode.getMeasuredByParent$ui() == 1) {
                    MeasurePassDelegate measurePassDelegate = layoutNodeLayoutDelegate2.measurePassDelegate;
                    Constraints constraints = measurePassDelegate.measuredOnce ? new Constraints(measurePassDelegate.measurementConstraints) : null;
                    if (constraints != null) {
                        if (layoutNode.intrinsicsUsageByParent == 3) {
                            layoutNode.clearSubtreeIntrinsicsUsage$ui();
                        }
                        zM564remeasureBRTryo0 = layoutNodeLayoutDelegate2.measurePassDelegate.m564remeasureBRTryo0(constraints.value);
                    } else {
                        zM564remeasureBRTryo0 = false;
                    }
                    if (zM564remeasureBRTryo0) {
                        LayoutNode.requestRemeasure$ui$default(layoutNodeLayoutDelegate.layoutNode, false, 7);
                    }
                }
            }
        }
        if (this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment && this.layoutPending)) {
            this.layoutPending = false;
            int i3 = layoutNodeLayoutDelegate.layoutState;
            layoutNodeLayoutDelegate.layoutState = 3;
            layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(false);
            LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode2)).getSnapshotObserver();
            snapshotObserver.observer.observeReads(layoutNode2, snapshotObserver.onCommitAffectingLayout, this.layoutChildrenBlock);
            layoutNodeLayoutDelegate.layoutState = i3;
            this.layoutPendingForAlignment = false;
        }
        if (lookaheadAlignmentLines.usedDuringParentLayout) {
            lookaheadAlignmentLines.previousUsedDuringParentLayout = true;
        }
        if (lookaheadAlignmentLines.dirty && lookaheadAlignmentLines.getRequired$ui()) {
            lookaheadAlignmentLines.recalculate();
        }
        this.layingOutChildren = false;
    }

    public final void markNodeAndSubtreeAsPlaced$1() {
        boolean z = this.isPlaced;
        this.isPlaced = true;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        NodeChain nodeChain = layoutNode.nodes;
        if (!z) {
            ((InnerNodeCoordinator) nodeChain.innerCoordinator).onPlaced();
            ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getRectManager().recalculateRectIfDirty(layoutNodeLayoutDelegate.layoutNode);
            if (layoutNode.getMeasurePending$ui()) {
                LayoutNode.requestRemeasure$ui$default(layoutNode, true, 6);
            } else if (layoutNode.layoutDelegate.lookaheadMeasurePending) {
                LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, true, 6);
            }
        }
        NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
        for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
            if (nodeCoordinator2.lastLayerDrawingWasSkipped) {
                nodeCoordinator2.invalidateLayer();
            }
        }
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (layoutNode2.getPlaceOrder$ui() != Integer.MAX_VALUE) {
                layoutNode2.layoutDelegate.measurePassDelegate.markNodeAndSubtreeAsPlaced$1();
                LayoutNode.rescheduleRemeasureOrRelayout$ui(layoutNode2);
            }
        }
    }

    public final void markSubtreeAsNotPlaced() {
        if (this.isPlaced) {
            this.isPlaced = false;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
            LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
            ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getRectManager().remove(layoutNode2);
            NodeChain nodeChain = layoutNode2.nodes;
            NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
            for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
                nodeCoordinator2.onUnplaced();
                nodeCoordinator2.releaseLayer();
            }
            MutableVector mutableVector = layoutNode2.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate.markSubtreeAsNotPlaced();
            }
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicHeight(int i) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
            return layoutNodeLayoutDelegate.lookaheadPassDelegate.maxIntrinsicHeight(i);
        }
        onIntrinsicsQueried$1();
        return layoutNodeLayoutDelegate.getOuterCoordinator().maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicWidth(int i) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
            return layoutNodeLayoutDelegate.lookaheadPassDelegate.maxIntrinsicWidth(i);
        }
        onIntrinsicsQueried$1();
        return layoutNodeLayoutDelegate.getOuterCoordinator().maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public final Placeable mo517measureBRTryo0(long j) throws Throwable {
        int i;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        if (layoutNode.intrinsicsUsageByParent == 3) {
            layoutNode.clearSubtreeIntrinsicsUsage$ui();
        }
        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNode2)) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            lookaheadPassDelegate.measuredByParent = 3;
            lookaheadPassDelegate.mo517measureBRTryo0(j);
        }
        LayoutNode parent$ui = layoutNode2.getParent$ui();
        if (parent$ui != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui.layoutDelegate;
            if (this.measuredByParent != 3 && !layoutNode2.canMultiMeasure) {
                InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(layoutNodeLayoutDelegate2.layoutState);
            if (iOrdinal != 0) {
                i = 2;
                if (iOrdinal != 2) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is ".concat(Modifier.CC.stringValueOf$4(layoutNodeLayoutDelegate2.layoutState)));
                }
            } else {
                i = 1;
            }
            this.measuredByParent = i;
        } else {
            this.measuredByParent = 3;
        }
        m564remeasureBRTryo0(j);
        return this;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicHeight(int i) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
            return layoutNodeLayoutDelegate.lookaheadPassDelegate.minIntrinsicHeight(i);
        }
        onIntrinsicsQueried$1();
        return layoutNodeLayoutDelegate.getOuterCoordinator().minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicWidth(int i) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
            return layoutNodeLayoutDelegate.lookaheadPassDelegate.minIntrinsicWidth(i);
        }
        onIntrinsicsQueried$1();
        return layoutNodeLayoutDelegate.getOuterCoordinator().minIntrinsicWidth(i);
    }

    public final void onIntrinsicsQueried$1() {
        int i;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode.requestRemeasure$ui$default(layoutNodeLayoutDelegate.layoutNode, false, 7);
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

    public final void onNodePlaced$ui() throws Throwable {
        this.onNodePlacedCalled = true;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        float f = getInnerCoordinator().zIndex;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        NodeChain nodeChain = layoutNode.nodes;
        NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
        InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) nodeChain.innerCoordinator;
        while (nodeCoordinator != innerNodeCoordinator) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) nodeCoordinator;
            f += layoutModifierNodeCoordinator.zIndex;
            nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
        }
        if (f != this.zIndex) {
            this.zIndex = f;
            if (parent$ui != null) {
                parent$ui.onZSortedChildrenInvalidated$ui();
            }
            if (parent$ui != null) {
                parent$ui.invalidateLayer$ui();
            }
        }
        if (!getInnerCoordinator().isPlacingForAlignment) {
            boolean z = this.isPlaced;
            if (!z || this.alignmentLines.getQueried$ui()) {
                markNodeAndSubtreeAsPlaced$1();
            }
            if (z) {
                ((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).onPlaced();
            } else {
                if (parent$ui != null) {
                    parent$ui.invalidateLayer$ui();
                }
                if (this.relayoutWithoutParentInProgress && parent$ui != null) {
                    parent$ui.requestRelayout$ui(false);
                }
            }
        }
        if (parent$ui != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui.layoutDelegate;
            if (!this.relayoutWithoutParentInProgress && layoutNodeLayoutDelegate2.layoutState == 3) {
                if (this.placeOrder != Integer.MAX_VALUE) {
                    InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                }
                int i = layoutNodeLayoutDelegate2.nextChildPlaceOrder;
                this.placeOrder = i;
                layoutNodeLayoutDelegate2.nextChildPlaceOrder = i + 1;
            }
        } else {
            this.placeOrder = 0;
        }
        layoutChildren();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo521placeAtf8xVGno(long j, float f, Function1 function1) throws Throwable {
        Placeable.PlacementScope placementScope;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        try {
            this.isPlacedByParent = true;
            if (!IntOffset.m712equalsimpl0(j, this.lastPosition) || function1 != this.lastLayerBlock || this.needsCoordinatesUpdate) {
                if (layoutNodeLayoutDelegate.coordinatesAccessedDuringModifierPlacement || layoutNodeLayoutDelegate.coordinatesAccessedDuringPlacement || this.needsCoordinatesUpdate) {
                    this.layoutPending = true;
                    this.needsCoordinatesUpdate = false;
                }
            }
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                if (lookaheadPassDelegate._placedState == 3 && !HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate2.layoutNode)) {
                    layoutNodeLayoutDelegate2.detachedFromParentLookaheadPlacement = true;
                }
            }
            LookaheadPassDelegate lookaheadPassDelegate2 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate2 != null && lookaheadPassDelegate2.getNeedsToBePlacedInApproach()) {
                NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate.getOuterCoordinator().wrappedBy;
                if (nodeCoordinator == null || (placementScope = nodeCoordinator.placementScope) == null) {
                    placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode2)).getPlacementScope();
                }
                LookaheadPassDelegate lookaheadPassDelegate3 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                LayoutNode parent$ui = layoutNode2.getParent$ui();
                if (parent$ui != null) {
                    parent$ui.layoutDelegate.nextChildLookaheadPlaceOrder = 0;
                }
                lookaheadPassDelegate3.placeOrder = Integer.MAX_VALUE;
                Placeable.PlacementScope.place$default(placementScope, lookaheadPassDelegate3, (int) (j >> 32), (int) (4294967295L & j));
            }
            LookaheadPassDelegate lookaheadPassDelegate4 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate4 != null && !lookaheadPassDelegate4.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("Error: Placement happened before lookahead.");
            }
            m563placeOuterCoordinatorMLgxB_4(j, f, function1);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    /* JADX INFO: renamed from: placeOuterCoordinator-MLgxB_4, reason: not valid java name */
    public final void m563placeOuterCoordinatorMLgxB_4(long j, float f, Function1 function1) throws Throwable {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        if (layoutNode.isDeactivated) {
            InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
        }
        layoutNodeLayoutDelegate.layoutState = 3;
        this.lastPosition = j;
        this.lastZIndex = f;
        this.lastLayerBlock = function1;
        this.onNodePlacedCalled = false;
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode2);
        if (this.layoutPending || !this.isPlaced) {
            this.alignmentLines.usedByModifierLayout = false;
            layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(false);
            this.placeOuterCoordinatorLayerBlock = function1;
            this.placeOuterCoordinatorPosition = j;
            this.placeOuterCoordinatorZIndex = f;
            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) ownerRequireOwner).getSnapshotObserver();
            snapshotObserver.observer.observeReads(layoutNode2, snapshotObserver.onCommitAffectingLayoutModifier, this.placeOuterCoordinatorBlock);
        } else {
            NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate.getOuterCoordinator();
            outerCoordinator.m576placeSelfMLgxB_4(IntOffset.m714plusqkQi6aY(j, outerCoordinator.apparentToRealOffset), f, function1);
            onNodePlaced$ui();
        }
        layoutNodeLayoutDelegate.layoutState = 5;
        if (layoutNodeLayoutDelegate.getOuterCoordinator().isPlacingForAlignment && (layoutNodeLayoutDelegate.coordinatesAccessedDuringModifierPlacement || layoutNodeLayoutDelegate.coordinatesAccessedDuringPlacement)) {
            requestLayout();
        }
        this.placedOnce = true;
    }

    /* JADX INFO: renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m564remeasureBRTryo0(long j) throws Throwable {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        try {
            if (layoutNode.isDeactivated) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode2);
            LayoutNode parent$ui = layoutNode2.getParent$ui();
            boolean z = true;
            layoutNode2.canMultiMeasure = layoutNode2.canMultiMeasure || (parent$ui != null && parent$ui.canMultiMeasure);
            if (!layoutNode2.getMeasurePending$ui() && Constraints.m677equalsimpl0(this.measurementConstraints, j)) {
                ((AndroidComposeView) ownerRequireOwner).forceMeasureTheSubtree(layoutNode2, false);
                layoutNode2.resetSubtreeIntrinsicsUsage$ui();
                return false;
            }
            this.alignmentLines.usedByModifierMeasurement = false;
            MutableVector mutableVector = layoutNode2.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate.alignmentLines.usedDuringParentMeasurement = false;
                Unit unit = Unit.INSTANCE;
            }
            this.measuredOnce = true;
            long j2 = layoutNodeLayoutDelegate.getOuterCoordinator().measuredSize;
            m535setMeasurementConstraintsBRTryo0(j);
            if (layoutNodeLayoutDelegate.layoutState != 5) {
                InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
            }
            this.performMeasureConstraints = j;
            layoutNodeLayoutDelegate.layoutState = 1;
            this.measurePending = false;
            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode2)).getSnapshotObserver();
            snapshotObserver.observer.observeReads(layoutNode2, snapshotObserver.onCommitAffectingMeasure, this.performMeasureBlock);
            if (layoutNodeLayoutDelegate.layoutState == 1) {
                this.layoutPending = true;
                this.layoutPendingForAlignment = true;
                layoutNodeLayoutDelegate.layoutState = 5;
            }
            if (IntSize.m720equalsimpl0(layoutNodeLayoutDelegate.getOuterCoordinator().measuredSize, j2) && layoutNodeLayoutDelegate.getOuterCoordinator().width == this.width && layoutNodeLayoutDelegate.getOuterCoordinator().height == this.height) {
                z = false;
            }
            m534setMeasuredSizeozmzZPI((((long) layoutNodeLayoutDelegate.getOuterCoordinator().height) & 4294967295L) | (((long) layoutNodeLayoutDelegate.getOuterCoordinator().width) << 32));
            return z;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void requestLayout() {
        this.layoutNodeLayoutDelegate.layoutNode.requestRelayout$ui(false);
    }

    public final void requestLayoutIfCoordinatesAreUsedAndNotifyChildren() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        if (!layoutNode.isPlaced() || layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement <= 0) {
            return;
        }
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode2.layoutDelegate;
        if ((layoutNodeLayoutDelegate2.coordinatesAccessedDuringPlacement || layoutNodeLayoutDelegate2.coordinatesAccessedDuringModifierPlacement) && !layoutNodeLayoutDelegate2.measurePassDelegate.layoutPending) {
            layoutNode2.requestRelayout$ui(false);
        }
        MutableVector mutableVector = layoutNode2.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate.requestLayoutIfCoordinatesAreUsedAndNotifyChildren();
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void requestMeasure() {
        LayoutNode.requestRemeasure$ui$default(this.layoutNodeLayoutDelegate.layoutNode, false, 7);
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public final void updatePlacedUnderMotionFrameOfReference(boolean z) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (z != layoutNodeLayoutDelegate.getOuterCoordinator().isPlacedUnderMotionFrameOfReference) {
            layoutNodeLayoutDelegate.getOuterCoordinator().isPlacedUnderMotionFrameOfReference = z;
            this.needsCoordinatesUpdate = true;
        }
    }
}
