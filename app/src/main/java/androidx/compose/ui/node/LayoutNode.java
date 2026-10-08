package androidx.compose.ui.node;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import androidx.room.RoomOpenHelper;
import coil.memory.MemoryCacheService;
import coil.network.HttpException;
import coil.request.RequestService;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNode implements ComposeNodeLifecycleCallback, OwnerScope, ComposeUiNode {
    public final RequestService _foldedChildren;
    public LayoutNode _foldedParent;
    public NodeCoordinator _innerLayerCoordinator;
    public Modifier _modifier;
    public SemanticsConfiguration _semanticsConfiguration;
    public MutableVector _unfoldedChildren;
    public final MutableVector _zSortedChildren;
    public boolean addedToRectList;
    public boolean canMultiMeasure;
    public CompositionLocalMap compositionLocalMap;
    public Density density;
    public int depth;
    public int globallyPositionedObservers;
    public boolean hasPositionalLayerTransformationsInOffsetFromRoot;
    public boolean ignoreRemeasureRequests;
    public boolean innerLayerCoordinatorIsDirty;
    public RequestService intrinsicsPolicy;
    public int intrinsicsUsageByParent;
    public boolean isCurrentlyCalculatingSemanticsConfiguration;
    public boolean isDeactivated;
    public boolean isSemanticsInvalidated;
    public final boolean isVirtual;
    public final LayoutNodeLayoutDelegate layoutDelegate;
    public LayoutDirection layoutDirection;
    public LayoutNode lookaheadRoot;
    public MeasurePolicy measurePolicy;
    public boolean needsOnGloballyPositionedDispatch;
    public final NodeChain nodes;
    public long outerToInnerOffset;
    public boolean outerToInnerOffsetDirty;
    public Owner owner;
    public Modifier pendingModifier;
    public int previousIntrinsicsUsageByParent;
    public boolean rectInParentDirty;
    public int semanticsId;
    public LayoutNodeSubcompositionsState subcompositionsState;
    public boolean unfoldedVirtualChildrenListDirty;
    public ViewConfiguration viewConfiguration;
    public int virtualChildrenCount;
    public boolean zSortedChildrenInvalidated;
    public static final LayoutNode$Companion$ErrorMeasurePolicy$1 ErrorMeasurePolicy = new LayoutNode$Companion$ErrorMeasurePolicy$1("Undefined intrinsics block and it is required");
    public static final LayoutNode$Companion$DummyViewConfiguration$1 DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
    public static final LayoutNode$$ExternalSyntheticLambda0 ZComparator = new LayoutNode$$ExternalSyntheticLambda0(0);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        public final String error;

        public NoIntrinsicsMeasurePolicy(String str) {
            this.error = str;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            throw new IllegalStateException(this.error.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CaptureSession$State$EnumUnboxingLocalUtility.values(5).length];
            try {
                iArr[4] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode(int i) {
        this(SemanticsModifierKt.lastIdentifier.addAndGet(1), (i & 1) == 0);
    }

    private final String exceptionMessageForParentingOrOwnership(LayoutNode layoutNode) {
        StringBuilder sb = new StringBuilder("Cannot insert ");
        sb.append(layoutNode);
        sb.append(" because it already has a parent or an owner. This tree: ");
        sb.append(debugTreeToString(0));
        sb.append(" Other tree: ");
        LayoutNode layoutNode2 = layoutNode._foldedParent;
        sb.append(layoutNode2 != null ? layoutNode2.debugTreeToString(0) : null);
        return sb.toString();
    }

    public static void requestLookaheadRemeasure$ui$default(LayoutNode layoutNode, boolean z, int i) {
        LayoutNode parent$ui;
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        if (layoutNode.lookaheadRoot == null) {
            InlineClassHelperKt.throwIllegalStateException("Lookahead measure cannot be requested on a node that is not a part of the LookaheadScope");
        }
        Owner owner = layoutNode.owner;
        if (owner == null || layoutNode.ignoreRemeasureRequests || layoutNode.isVirtual) {
            return;
        }
        ((AndroidComposeView) owner).onRequestMeasure(layoutNode, true, z, z2);
        if (z3) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate.lookaheadPassDelegate.layoutNodeLayoutDelegate;
            LayoutNode parent$ui2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
            int i2 = layoutNodeLayoutDelegate.layoutNode.intrinsicsUsageByParent;
            if (parent$ui2 == null || i2 == 3) {
                return;
            }
            while (parent$ui2.intrinsicsUsageByParent == i2 && (parent$ui = parent$ui2.getParent$ui()) != null) {
                parent$ui2 = parent$ui;
            }
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i2);
            if (iOrdinal == 0) {
                if (parent$ui2.lookaheadRoot != null) {
                    requestLookaheadRemeasure$ui$default(parent$ui2, z, 6);
                    return;
                } else {
                    requestRemeasure$ui$default(parent$ui2, z, 6);
                    return;
                }
            }
            if (iOrdinal != 1) {
                throw new IllegalStateException("Intrinsics isn't used by the parent");
            }
            if (parent$ui2.lookaheadRoot != null) {
                parent$ui2.requestLookaheadRelayout$ui(z);
            } else {
                parent$ui2.requestRelayout$ui(z);
            }
        }
    }

    public static void requestRemeasure$ui$default(LayoutNode layoutNode, boolean z, int i) {
        Owner owner;
        LayoutNode parent$ui;
        if ((i & 1) != 0) {
            z = false;
        }
        boolean z2 = (i & 2) != 0;
        boolean z3 = (i & 4) != 0;
        if (layoutNode.ignoreRemeasureRequests || layoutNode.isVirtual || (owner = layoutNode.owner) == null) {
            return;
        }
        ((AndroidComposeView) owner).onRequestMeasure(layoutNode, false, z, z2);
        if (z3) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate.measurePassDelegate.layoutNodeLayoutDelegate;
            LayoutNode parent$ui2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
            int i2 = layoutNodeLayoutDelegate.layoutNode.intrinsicsUsageByParent;
            if (parent$ui2 == null || i2 == 3) {
                return;
            }
            while (parent$ui2.intrinsicsUsageByParent == i2 && (parent$ui = parent$ui2.getParent$ui()) != null) {
                parent$ui2 = parent$ui;
            }
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i2);
            if (iOrdinal == 0) {
                requestRemeasure$ui$default(parent$ui2, z, 6);
            } else {
                if (iOrdinal != 1) {
                    throw new IllegalStateException("Intrinsics isn't used by the parent");
                }
                parent$ui2.requestRelayout$ui(z);
            }
        }
    }

    public static void rescheduleRemeasureOrRelayout$ui(LayoutNode layoutNode) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (WhenMappings.$EnumSwitchMapping$0[CaptureSession$State$EnumUnboxingLocalUtility.ordinal(layoutNodeLayoutDelegate.layoutState)] != 1) {
            throw new IllegalStateException("Unexpected state ".concat(Modifier.CC.stringValueOf$4(layoutNodeLayoutDelegate.layoutState)));
        }
        if (layoutNodeLayoutDelegate.lookaheadMeasurePending) {
            requestLookaheadRemeasure$ui$default(layoutNode, true, 6);
            return;
        }
        if (layoutNodeLayoutDelegate.lookaheadLayoutPending) {
            layoutNode.requestLookaheadRelayout$ui(true);
        }
        if (layoutNode.getMeasurePending$ui()) {
            requestRemeasure$ui$default(layoutNode, true, 6);
        } else if (layoutNode.getLayoutPending$ui()) {
            layoutNode.requestRelayout$ui(true);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 5611. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final void applyModifier(androidx.compose.ui.Modifier r20) {
        /*
            Method dump skipped, instruction units count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.applyModifier(androidx.compose.ui.Modifier):void");
    }

    public final void attach$ui(Owner owner) {
        LayoutNode layoutNode;
        AndroidAutofillManager androidAutofillManager;
        SemanticsConfiguration semanticsConfiguration;
        if (this.owner != null) {
            InlineClassHelperKt.throwIllegalStateException("Cannot attach " + this + " as it already is attached.  Tree: " + debugTreeToString(0));
        }
        LayoutNode layoutNode2 = this._foldedParent;
        if (layoutNode2 != null && !Intrinsics.areEqual(layoutNode2.owner, owner)) {
            StringBuilder sb = new StringBuilder("Attaching to a different owner(");
            sb.append(owner);
            sb.append(") than the parent's owner(");
            LayoutNode parent$ui = getParent$ui();
            sb.append(parent$ui != null ? parent$ui.owner : null);
            sb.append("). This tree: ");
            sb.append(debugTreeToString(0));
            sb.append(" Parent tree: ");
            LayoutNode layoutNode3 = this._foldedParent;
            sb.append(layoutNode3 != null ? layoutNode3.debugTreeToString(0) : null);
            InlineClassHelperKt.throwIllegalStateException(sb.toString());
        }
        LayoutNode parent$ui2 = getParent$ui();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (parent$ui2 == null) {
            layoutNodeLayoutDelegate.measurePassDelegate.isPlaced = true;
            ((AndroidComposeView) owner).getRectManager().recalculateRectIfDirty(this);
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate._placedState = 1;
            }
        }
        NodeChain nodeChain = this.nodes;
        ((NodeCoordinator) nodeChain.outerCoordinator).wrappedBy = parent$ui2 != null ? (InnerNodeCoordinator) parent$ui2.nodes.innerCoordinator : null;
        this.owner = owner;
        this.depth = (parent$ui2 != null ? parent$ui2.depth : -1) + 1;
        Modifier modifier = this.pendingModifier;
        if (modifier != null) {
            applyModifier(modifier);
        }
        this.pendingModifier = null;
        AndroidComposeView androidComposeView = (AndroidComposeView) owner;
        androidComposeView.getLayoutNodes().set(this.semanticsId, this);
        LayoutNode layoutNode4 = this._foldedParent;
        if (layoutNode4 == null || (layoutNode = layoutNode4.lookaheadRoot) == null) {
            layoutNode = this.lookaheadRoot;
        }
        setLookaheadRoot(layoutNode);
        if (this.lookaheadRoot == null && nodeChain.m565hasH91voCI$ui(512)) {
            setLookaheadRoot(this);
        }
        if (!this.isDeactivated) {
            for (Modifier.Node node = (Modifier.Node) nodeChain.head; node != null; node = node.child) {
                node.markAsAttached$ui();
            }
        }
        MutableVector mutableVector = (MutableVector) this._foldedChildren.systemCallbacks;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((LayoutNode) objArr[i2]).attach$ui(owner);
        }
        if (!this.isDeactivated) {
            nodeChain.runAttachLifecycle();
        }
        invalidateMeasurements$ui();
        if (parent$ui2 != null) {
            parent$ui2.invalidateMeasurements$ui();
        }
        layoutNodeLayoutDelegate.updateParentData();
        if (!this.isDeactivated && nodeChain.m565hasH91voCI$ui(8)) {
            invalidateSemantics$ui();
        }
        androidComposeView.getClass();
        if (!AndroidComposeView.autofillSupported() || (androidAutofillManager = androidComposeView._autofillManager) == null || (semanticsConfiguration = getSemanticsConfiguration()) == null || !semanticsConfiguration.props.contains(SemanticsProperties.ContentType)) {
            return;
        }
        androidAutofillManager.currentlyDisplayedIDs.add(this.semanticsId);
        androidAutofillManager.platformAutofillManager.notifyViewVisibilityChanged(androidAutofillManager.view, this.semanticsId, true);
    }

    public final void clearSubtreeIntrinsicsUsage$ui() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = 3;
        MutableVector mutableVector = get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i2];
            if (layoutNode.intrinsicsUsageByParent != 3) {
                layoutNode.clearSubtreeIntrinsicsUsage$ui();
            }
        }
    }

    public final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = 3;
        MutableVector mutableVector = get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i2];
            if (layoutNode.intrinsicsUsageByParent == 2) {
                layoutNode.clearSubtreePlacementIntrinsicsUsage();
            }
        }
    }

    public final String debugTreeToString(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector mutableVector = get_children$ui();
        Object[] objArr = mutableVector.content;
        int i3 = mutableVector.size;
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(((LayoutNode) objArr[i4]).debugTreeToString(i + 1));
        }
        String string = sb.toString();
        return i == 0 ? string.substring(0, string.length() - 1) : string;
    }

    public final void detach$ui() {
        AndroidAutofillManager androidAutofillManager;
        LookaheadAlignmentLines lookaheadAlignmentLines;
        Owner owner = this.owner;
        if (owner == null) {
            StringBuilder sb = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui = getParent$ui();
            sb.append(parent$ui != null ? parent$ui.debugTreeToString(0) : null);
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(sb.toString());
            throw new HttpException();
        }
        LayoutNode parent$ui2 = getParent$ui();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (parent$ui2 != null) {
            parent$ui2.invalidateLayer$ui();
            parent$ui2.invalidateMeasurements$ui();
            layoutNodeLayoutDelegate.measurePassDelegate.measuredByParent = 3;
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.measuredByParent = 3;
            }
        }
        LookaheadAlignmentLines lookaheadAlignmentLines2 = layoutNodeLayoutDelegate.measurePassDelegate.alignmentLines;
        lookaheadAlignmentLines2.dirty = true;
        lookaheadAlignmentLines2.usedDuringParentMeasurement = false;
        lookaheadAlignmentLines2.previousUsedDuringParentLayout = false;
        lookaheadAlignmentLines2.usedDuringParentLayout = false;
        lookaheadAlignmentLines2.usedByModifierMeasurement = false;
        lookaheadAlignmentLines2.usedByModifierLayout = false;
        lookaheadAlignmentLines2.queryOwner = null;
        LookaheadPassDelegate lookaheadPassDelegate2 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null && (lookaheadAlignmentLines = lookaheadPassDelegate2.alignmentLines) != null) {
            lookaheadAlignmentLines.dirty = true;
            lookaheadAlignmentLines.usedDuringParentMeasurement = false;
            lookaheadAlignmentLines.previousUsedDuringParentLayout = false;
            lookaheadAlignmentLines.usedDuringParentLayout = false;
            lookaheadAlignmentLines.usedByModifierMeasurement = false;
            lookaheadAlignmentLines.usedByModifierLayout = false;
            lookaheadAlignmentLines.queryOwner = null;
        }
        NodeChain nodeChain = this.nodes;
        Modifier.Node node = (TailModifierNode) nodeChain.tail;
        NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
        for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
            nodeCoordinator2.releaseLayer();
            if (nodeCoordinator2.layoutNode.isPlaced()) {
                nodeCoordinator2.onUnplaced();
            }
        }
        for (Modifier.Node node2 = node; node2 != null; node2 = node2.parent) {
            if (node2.isAttached) {
                node2.runDetachLifecycle$ui();
            }
        }
        this.ignoreRemeasureRequests = true;
        MutableVector mutableVector = (MutableVector) this._foldedChildren.systemCallbacks;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((LayoutNode) objArr[i2]).detach$ui();
        }
        Unit unit = Unit.INSTANCE;
        this.ignoreRemeasureRequests = false;
        while (node != null) {
            if (node.isAttached) {
                node.markAsDetached$ui();
            }
            node = node.parent;
        }
        AndroidComposeView androidComposeView = (AndroidComposeView) owner;
        androidComposeView.getLayoutNodes().remove(this.semanticsId);
        MeasureAndLayoutDelegate measureAndLayoutDelegate = androidComposeView.measureAndLayoutDelegate;
        MenuHostHelper menuHostHelper = measureAndLayoutDelegate.relayoutNodes;
        ((MemoryCacheService) menuHostHelper.mOnInvalidateMenuCallback).remove(this);
        ((MemoryCacheService) menuHostHelper.mMenuProviders).remove(this);
        ((MemoryCacheService) menuHostHelper.mProviderToLifecycleContainers).remove(this);
        ((MutableVector) measureAndLayoutDelegate.onPositionedDispatcher.systemCallbacks).remove(this);
        androidComposeView.observationClearRequested = true;
        if (AndroidComposeView.autofillSupported() && (androidAutofillManager = androidComposeView._autofillManager) != null && androidAutofillManager.currentlyDisplayedIDs.remove(this.semanticsId)) {
            androidAutofillManager.platformAutofillManager.notifyViewVisibilityChanged(androidAutofillManager.view, this.semanticsId, false);
        }
        androidComposeView.getRectManager().remove(this);
        this.owner = null;
        setLookaheadRoot(null);
        this.depth = 0;
        MeasurePassDelegate measurePassDelegate = layoutNodeLayoutDelegate.measurePassDelegate;
        measurePassDelegate.placeOrder = Integer.MAX_VALUE;
        measurePassDelegate.previousPlaceOrder = Integer.MAX_VALUE;
        measurePassDelegate.isPlaced = false;
        LookaheadPassDelegate lookaheadPassDelegate3 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate3 != null) {
            lookaheadPassDelegate3.placeOrder = Integer.MAX_VALUE;
            lookaheadPassDelegate3.previousPlaceOrder = Integer.MAX_VALUE;
            lookaheadPassDelegate3._placedState = 3;
        }
        if (nodeChain.m565hasH91voCI$ui(8)) {
            SemanticsConfiguration semanticsConfiguration = this._semanticsConfiguration;
            this._semanticsConfiguration = null;
            this.isSemanticsInvalidated = false;
            androidComposeView.getSemanticsOwner().notifySemanticsChange$ui(this, semanticsConfiguration);
            androidComposeView.onSemanticsChange();
        }
    }

    public final void draw$ui(Canvas canvas, GraphicsLayer graphicsLayer) throws Throwable {
        try {
            ((NodeCoordinator) this.nodes.outerCoordinator).draw(canvas, graphicsLayer);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    public final void forceRemeasure() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui$default(this, false, 5);
        } else {
            requestRemeasure$ui$default(this, false, 5);
        }
        MeasurePassDelegate measurePassDelegate = this.layoutDelegate.measurePassDelegate;
        Constraints constraints = measurePassDelegate.measuredOnce ? new Constraints(measurePassDelegate.measurementConstraints) : null;
        if (constraints != null) {
            Owner owner = this.owner;
            if (owner != null) {
                ((AndroidComposeView) owner).m591measureAndLayout0kLqBqw(this, constraints.value);
                return;
            }
            return;
        }
        Owner owner2 = this.owner;
        if (owner2 != null) {
            ((AndroidComposeView) owner2).measureAndLayout(true);
        }
    }

    public final List getChildLookaheadMeasurables$ui() {
        LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        MutableVector mutableVector = lookaheadPassDelegate._childDelegates;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = lookaheadPassDelegate.layoutNodeLayoutDelegate;
        layoutNodeLayoutDelegate.layoutNode.getChildren$ui();
        if (!lookaheadPassDelegate.childDelegatesDirty) {
            return mutableVector.asMutableList();
        }
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        MutableVector mutableVector2 = layoutNode.get_children$ui();
        Object[] objArr = mutableVector2.content;
        int i = mutableVector2.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (mutableVector.size <= i2) {
                mutableVector.add(layoutNode2.layoutDelegate.lookaheadPassDelegate);
            } else {
                LookaheadPassDelegate lookaheadPassDelegate2 = layoutNode2.layoutDelegate.lookaheadPassDelegate;
                Object[] objArr2 = mutableVector.content;
                Object obj = objArr2[i2];
                objArr2[i2] = lookaheadPassDelegate2;
            }
        }
        mutableVector.removeRange(((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).objectList).size, mutableVector.size);
        lookaheadPassDelegate.childDelegatesDirty = false;
        return mutableVector.asMutableList();
    }

    public final List getChildMeasurables$ui() {
        return this.layoutDelegate.measurePassDelegate.getChildDelegates$ui();
    }

    public final List getChildren$ui() {
        return get_children$ui().asMutableList();
    }

    public final List getFoldedChildren$ui() {
        return ((MutableVector) this._foldedChildren.systemCallbacks).asMutableList();
    }

    public final boolean getLayoutPending$ui() {
        return this.layoutDelegate.measurePassDelegate.layoutPending;
    }

    public final boolean getMeasurePending$ui() {
        return this.layoutDelegate.measurePassDelegate.measurePending;
    }

    public final int getMeasuredByParent$ui() {
        return this.layoutDelegate.measurePassDelegate.measuredByParent;
    }

    public final int getMeasuredByParentInLookahead$ui() {
        int i;
        LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate == null || (i = lookaheadPassDelegate.measuredByParent) == 0) {
            return 3;
        }
        return i;
    }

    public final RequestService getOrCreateIntrinsicsPolicy() {
        RequestService requestService = this.intrinsicsPolicy;
        if (requestService != null) {
            return requestService;
        }
        RequestService requestService2 = new RequestService(this, this.measurePolicy);
        this.intrinsicsPolicy = requestService2;
        return requestService2;
    }

    public final LayoutNode getParent$ui() {
        LayoutNode layoutNode = this._foldedParent;
        while (layoutNode != null && layoutNode.isVirtual) {
            layoutNode = layoutNode._foldedParent;
        }
        return layoutNode;
    }

    public final int getPlaceOrder$ui() {
        return this.layoutDelegate.measurePassDelegate.placeOrder;
    }

    public final SemanticsConfiguration getSemanticsConfiguration() {
        if (isAttached() && !this.isDeactivated && this.nodes.m565hasH91voCI$ui(8)) {
            return this._semanticsConfiguration;
        }
        return null;
    }

    public final MutableVector getZSortedChildren() {
        boolean z = this.zSortedChildrenInvalidated;
        MutableVector mutableVector = this._zSortedChildren;
        if (z) {
            mutableVector.clear();
            mutableVector.addAll(mutableVector.size, get_children$ui());
            Arrays.sort(mutableVector.content, 0, mutableVector.size, ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return mutableVector;
    }

    public final MutableVector get_children$ui() {
        updateChildrenIfDirty$ui();
        return this.virtualChildrenCount == 0 ? (MutableVector) this._foldedChildren.systemCallbacks : this._unfoldedChildren;
    }

    /* JADX INFO: renamed from: hitTest-6fMxITs$ui, reason: not valid java name */
    public final void m549hitTest6fMxITs$ui(long j, HitTestResult hitTestResult, int i, boolean z) {
        NodeChain nodeChain = this.nodes;
        NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
        ((NodeCoordinator) nodeChain.outerCoordinator).m574hitTestqzLsGqo(NodeCoordinator.PointerInputSource, nodeCoordinator.m569fromParentPosition8S9VItk(j), hitTestResult, i, z);
    }

    public final void insertAt$ui(int i, LayoutNode layoutNode) {
        if (layoutNode._foldedParent != null && layoutNode.owner != null) {
            InlineClassHelperKt.throwIllegalStateException(exceptionMessageForParentingOrOwnership(layoutNode));
        }
        layoutNode._foldedParent = this;
        RequestService requestService = this._foldedChildren;
        ((MutableVector) requestService.systemCallbacks).add(i, layoutNode);
        ((Handshake.AnonymousClass2) requestService.hardwareBitmapService).invoke();
        onZSortedChildrenInvalidated$ui();
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        Owner owner = this.owner;
        if (owner != null) {
            layoutNode.attach$ui(owner);
        }
        if (layoutNode.layoutDelegate.childrenAccessingCoordinatesDuringPlacement > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
        }
        if (layoutNode.globallyPositionedObservers > 0) {
            setGloballyPositionedObservers(this.globallyPositionedObservers + 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v5 */
    public final void invalidateDrawForSubtree(boolean z) {
        if (z) {
            LayoutNode parent$ui = getParent$ui();
            if (parent$ui != null) {
                parent$ui.invalidateLayer$ui();
            } else {
                Owner owner = this.owner;
                if (owner != null) {
                    ((AndroidComposeView) owner).invalidate();
                }
            }
        }
        Modifier.Node node = (Modifier.Node) this.nodes.head;
        if ((node.aggregateChildKindSet & 2) != 0) {
            while (node != null) {
                if ((node.kindSet & 2) != 0) {
                    ?? Access$pop = node;
                    ?? mutableVector = 0;
                    while (Access$pop != 0) {
                        if (Access$pop instanceof LayoutModifierNode) {
                            OwnedLayer ownedLayer = HitTestResultKt.m547requireCoordinator64DMado((LayoutModifierNode) Access$pop, 2).layer;
                            if (ownedLayer != null) {
                                GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
                                AndroidComposeView androidComposeView = graphicsLayerOwnerLayer.ownerView;
                                if (!graphicsLayerOwnerLayer.isDirty && !graphicsLayerOwnerLayer.isDestroyed) {
                                    androidComposeView.invalidate();
                                    if (true != graphicsLayerOwnerLayer.isDirty) {
                                        graphicsLayerOwnerLayer.isDirty = true;
                                        androidComposeView.notifyLayerIsDirty$ui(graphicsLayerOwnerLayer, true);
                                    }
                                }
                            }
                        } else if ((Access$pop.kindSet & 2) != 0 && (Access$pop instanceof DelegatingNode)) {
                            Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                            int i = 0;
                            while (node2 != null) {
                                if ((node2.kindSet & 2) != 0) {
                                    i++;
                                    if (i == 1) {
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                        mutableVector = mutableVector;
                                        Access$pop = node2;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (Access$pop != 0) {
                                            mutableVector.add(Access$pop);
                                            Access$pop = 0;
                                        }
                                        mutableVector.add(node2);
                                    }
                                } else {
                                    Access$pop = Access$pop;
                                    mutableVector = mutableVector;
                                }
                                node2 = node2.child;
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
                            }
                            if (i == 1) {
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
                            } else {
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
                            }
                        }
                        Access$pop = HitTestResultKt.access$pop(mutableVector);
                    }
                }
                if ((node.aggregateChildKindSet & 2) == 0) {
                    break;
                } else {
                    node = node.child;
                }
            }
        }
        MutableVector mutableVector2 = get_children$ui();
        Object[] objArr = mutableVector2.content;
        int i2 = mutableVector2.size;
        for (int i3 = 0; i3 < i2; i3++) {
            ((LayoutNode) objArr[i3]).invalidateDrawForSubtree(false);
        }
    }

    public final void invalidateLayer$ui() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeChain nodeChain = this.nodes;
            NodeCoordinator nodeCoordinator = (InnerNodeCoordinator) nodeChain.innerCoordinator;
            NodeCoordinator nodeCoordinator2 = ((NodeCoordinator) nodeChain.outerCoordinator).wrappedBy;
            this._innerLayerCoordinator = null;
            while (!Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) {
                if ((nodeCoordinator != null ? nodeCoordinator.layer : null) != null) {
                    this._innerLayerCoordinator = nodeCoordinator;
                    break;
                }
                nodeCoordinator = nodeCoordinator != null ? nodeCoordinator.wrappedBy : null;
            }
            this.innerLayerCoordinatorIsDirty = false;
        }
        NodeCoordinator nodeCoordinator3 = this._innerLayerCoordinator;
        if (nodeCoordinator3 != null && nodeCoordinator3.layer == null) {
            throw Modifier.CC.m("layer was not set. This error is usually caused by operating off of the UI thread. Did you call invalidate() instead of postInvalidate()?");
        }
        if (nodeCoordinator3 != null) {
            nodeCoordinator3.invalidateLayer();
            return;
        }
        LayoutNode parent$ui = getParent$ui();
        if (parent$ui != null) {
            parent$ui.invalidateLayer$ui();
            return;
        }
        Owner owner = this.owner;
        if (owner != null) {
            ((AndroidComposeView) owner).invalidate();
        }
    }

    public final void invalidateLayers$ui() {
        NodeChain nodeChain = this.nodes;
        NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
        InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) nodeChain.innerCoordinator;
        while (nodeCoordinator != innerNodeCoordinator) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) nodeCoordinator;
            OwnedLayer ownedLayer = layoutModifierNodeCoordinator.layer;
            if (ownedLayer != null) {
                ownedLayer.invalidate();
            }
            nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
        }
        OwnedLayer ownedLayer2 = ((InnerNodeCoordinator) nodeChain.innerCoordinator).layer;
        if (ownedLayer2 != null) {
            ownedLayer2.invalidate();
        }
    }

    public final void invalidateMeasurementForSubtree() {
        requestRemeasure$ui$default(this, false, 7);
        MutableVector mutableVector = get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((LayoutNode) objArr[i2]).invalidateMeasurementForSubtree();
        }
    }

    public final void invalidateMeasurements$ui() {
        if (this.isVirtual) {
            LayoutNode parent$ui = getParent$ui();
            if (parent$ui != null) {
                parent$ui.invalidateMeasurements$ui();
                return;
            }
            return;
        }
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui$default(this, false, 7);
        } else {
            requestRemeasure$ui$default(this, false, 7);
        }
    }

    public final void invalidateSemantics$ui() {
        if (this.isCurrentlyCalculatingSemanticsConfiguration) {
            return;
        }
        if (((NodeChain$sentinelHead$1) this.nodes.sentinelHead).child != null || this.pendingModifier != null) {
            this.isSemanticsInvalidated = true;
            return;
        }
        SemanticsConfiguration semanticsConfiguration = this._semanticsConfiguration;
        this.isCurrentlyCalculatingSemanticsConfiguration = true;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new SemanticsConfiguration();
        OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(this)).getSnapshotObserver();
        DialogHostKt$DialogHost$1$1$1 dialogHostKt$DialogHost$1$1$1 = new DialogHostKt$DialogHost$1$1$1(4, this, ref$ObjectRef);
        snapshotObserver.observer.observeReads(this, snapshotObserver.onCommitAffectingSemantics, dialogHostKt$DialogHost$1$1$1);
        this.isCurrentlyCalculatingSemanticsConfiguration = false;
        this._semanticsConfiguration = (SemanticsConfiguration) ref$ObjectRef.element;
        this.isSemanticsInvalidated = false;
        AndroidComposeView androidComposeView = (AndroidComposeView) LayoutNodeKt.requireOwner(this);
        androidComposeView.getSemanticsOwner().notifySemanticsChange$ui(this, semanticsConfiguration);
        androidComposeView.onSemanticsChange();
    }

    public final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (layoutNode = this._foldedParent) == null) {
            return;
        }
        layoutNode.invalidateUnfoldedVirtualChildren();
    }

    public final boolean isAttached() {
        return this.owner != null;
    }

    public final boolean isPlaced() {
        return this.layoutDelegate.measurePassDelegate.isPlaced;
    }

    public final Boolean isPlacedInLookahead() {
        LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            return Boolean.valueOf(lookaheadPassDelegate._placedState != 3);
        }
        return null;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return isAttached();
    }

    public final void lookaheadReplace$ui() {
        LayoutNode parent$ui;
        if (this.intrinsicsUsageByParent == 3) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        boolean z = true;
        try {
            lookaheadPassDelegate.relayoutWithoutParentInProgress = true;
            if (!lookaheadPassDelegate.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace() called on item that was not placed");
            }
            lookaheadPassDelegate.onNodePlacedCalled = false;
            if (lookaheadPassDelegate._placedState == 3) {
                z = false;
            }
            lookaheadPassDelegate.m557placeSelfMLgxB_4$1(lookaheadPassDelegate.lastPosition, lookaheadPassDelegate.lastLayerBlock);
            if (z && !lookaheadPassDelegate.onNodePlacedCalled && (parent$ui = lookaheadPassDelegate.layoutNodeLayoutDelegate.layoutNode.getParent$ui()) != null) {
                parent$ui.requestLookaheadRelayout$ui(false);
            }
        } finally {
            lookaheadPassDelegate.relayoutWithoutParentInProgress = false;
        }
    }

    public final void move$ui(int i, int i2, int i3) {
        if (i == i2) {
            return;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i > i2 ? i + i4 : i;
            int i6 = i > i2 ? i2 + i4 : (i2 + i3) - 2;
            RequestService requestService = this._foldedChildren;
            MutableVector mutableVector = (MutableVector) requestService.systemCallbacks;
            Handshake.AnonymousClass2 anonymousClass2 = (Handshake.AnonymousClass2) requestService.hardwareBitmapService;
            Object objRemoveAt = mutableVector.removeAt(i5);
            anonymousClass2.invoke();
            ((MutableVector) requestService.systemCallbacks).add(i6, (LayoutNode) objRemoveAt);
            anonymousClass2.invoke();
        }
        onZSortedChildrenInvalidated$ui();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui();
    }

    public final void onChildRemoved(LayoutNode layoutNode) {
        if (layoutNode.layoutDelegate.childrenAccessingCoordinatesDuringPlacement > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement - 1);
        }
        if (this.owner != null) {
            layoutNode.detach$ui();
        }
        layoutNode._foldedParent = null;
        if (layoutNode.globallyPositionedObservers > 0) {
            setGloballyPositionedObservers(this.globallyPositionedObservers - 1);
        }
        ((NodeCoordinator) layoutNode.nodes.outerCoordinator).wrappedBy = null;
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector mutableVector = (MutableVector) layoutNode._foldedChildren.systemCallbacks;
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((NodeCoordinator) ((LayoutNode) objArr[i2]).nodes.outerCoordinator).wrappedBy = null;
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui();
    }

    public final void onCoordinatorRectChanged$ui(NodeCoordinator nodeCoordinator) {
        Owner owner = this.owner;
        RectManager rectManager = owner != null ? ((AndroidComposeView) owner).getRectManager() : null;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        boolean z = layoutNodeLayoutDelegate.layoutState != 5 || getMeasurePending$ui() || getLayoutPending$ui();
        if (this.addedToRectList && rectManager != null) {
            if (nodeCoordinator == ((NodeCoordinator) this.nodes.outerCoordinator)) {
                this.rectInParentDirty = true;
                if (!z) {
                    rectManager.recalculateRectIfDirty(this);
                }
            } else {
                this.outerToInnerOffsetDirty = true;
                MutableVector mutableVector = get_children$ui();
                Object[] objArr = mutableVector.content;
                int i = mutableVector.size;
                for (int i2 = 0; i2 < i; i2++) {
                    LayoutNode layoutNode = (LayoutNode) objArr[i2];
                    layoutNode.rectInParentDirty = true;
                    if (!z) {
                        rectManager.recalculateRectIfDirty(layoutNode);
                    }
                }
                if (this.addedToRectList) {
                    rectManager.isDirty = true;
                    RoomOpenHelper roomOpenHelper = rectManager.rects;
                    int i3 = this.semanticsId & 33554431;
                    long[] jArr = (long[]) roomOpenHelper.mConfiguration;
                    int i4 = roomOpenHelper.version;
                    for (int i5 = 0; i5 < jArr.length - 2 && i5 < i4; i5 += 3) {
                        int i6 = i5 + 2;
                        long j = jArr[i6];
                        if ((((int) j) & 33554431) == i3) {
                            jArr[i6] = (((j >> 63) & 1) << 60) | j;
                            break;
                        }
                    }
                }
                rectManager.scheduleDebounceCallback();
            }
        }
        layoutNodeLayoutDelegate.measurePassDelegate.requestLayoutIfCoordinatesAreUsedAndNotifyChildren();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onDeactivate() {
        AndroidAutofillManager androidAutofillManager;
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.markActiveNodesAsReused(true);
        }
        this.isDeactivated = true;
        Modifier.Node node = (TailModifierNode) this.nodes.tail;
        for (Modifier.Node node2 = node; node2 != null; node2 = node2.parent) {
            if (node2.isAttached) {
                node2.reset$ui();
            }
        }
        for (Modifier.Node node3 = node; node3 != null; node3 = node3.parent) {
            if (node3.isAttached) {
                node3.runDetachLifecycle$ui();
            }
        }
        while (node != null) {
            if (node.isAttached) {
                node.markAsDetached$ui();
            }
            node = node.parent;
        }
        if (isAttached()) {
            this._semanticsConfiguration = null;
            this.isSemanticsInvalidated = false;
        }
        Owner owner = this.owner;
        if (owner != null) {
            AndroidComposeView androidComposeView = (AndroidComposeView) owner;
            if (AndroidComposeView.autofillSupported() && (androidAutofillManager = androidComposeView._autofillManager) != null && androidAutofillManager.currentlyDisplayedIDs.remove(this.semanticsId)) {
                androidAutofillManager.platformAutofillManager.notifyViewVisibilityChanged(androidAutofillManager.view, this.semanticsId, false);
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onRelease() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onRelease();
        }
        NodeChain nodeChain = this.nodes;
        NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
        for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
            nodeCoordinator2.onRelease();
        }
    }

    public final void onZSortedChildrenInvalidated$ui() {
        if (!this.isVirtual) {
            this.zSortedChildrenInvalidated = true;
            return;
        }
        LayoutNode parent$ui = getParent$ui();
        if (parent$ui != null) {
            parent$ui.onZSortedChildrenInvalidated$ui();
        }
    }

    public final void removeAll$ui() {
        RequestService requestService = this._foldedChildren;
        MutableVector mutableVector = (MutableVector) requestService.systemCallbacks;
        MutableVector mutableVector2 = (MutableVector) requestService.systemCallbacks;
        int i = mutableVector.size;
        while (true) {
            i--;
            if (-1 >= i) {
                mutableVector2.clear();
                ((Handshake.AnonymousClass2) requestService.hardwareBitmapService).invoke();
                return;
            }
            onChildRemoved((LayoutNode) mutableVector2.content[i]);
        }
    }

    public final void removeAt$ui(int i, int i2) {
        if (i2 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("count (" + i2 + ") must be greater than 0");
        }
        int i3 = (i2 + i) - 1;
        if (i > i3) {
            return;
        }
        while (true) {
            RequestService requestService = this._foldedChildren;
            onChildRemoved((LayoutNode) ((MutableVector) requestService.systemCallbacks).content[i3]);
            Object objRemoveAt = ((MutableVector) requestService.systemCallbacks).removeAt(i3);
            ((Handshake.AnonymousClass2) requestService.hardwareBitmapService).invoke();
            if (i3 == i) {
                return;
            } else {
                i3--;
            }
        }
    }

    public final void replace$ui() {
        LayoutNode parent$ui;
        if (this.intrinsicsUsageByParent == 3) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        MeasurePassDelegate measurePassDelegate = this.layoutDelegate.measurePassDelegate;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = measurePassDelegate.layoutNodeLayoutDelegate;
        try {
            measurePassDelegate.relayoutWithoutParentInProgress = true;
            if (!measurePassDelegate.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace called on unplaced item");
            }
            boolean z = measurePassDelegate.isPlaced;
            measurePassDelegate.m563placeOuterCoordinatorMLgxB_4(measurePassDelegate.lastPosition, measurePassDelegate.lastZIndex, measurePassDelegate.lastLayerBlock);
            if (z && !measurePassDelegate.onNodePlacedCalled && (parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui()) != null) {
                parent$ui.requestRelayout$ui(false);
            }
            measurePassDelegate.relayoutWithoutParentInProgress = false;
        } catch (Throwable th) {
            try {
                layoutNodeLayoutDelegate.layoutNode.rethrowWithComposeStackTrace(th);
                throw null;
            } catch (Throwable th2) {
                measurePassDelegate.relayoutWithoutParentInProgress = false;
                throw th2;
            }
        }
    }

    public final void requestLookaheadRelayout$ui(boolean z) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        ((AndroidComposeView) owner).onRequestRelayout(this, true, z);
    }

    public final void requestRelayout$ui(boolean z) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        ((AndroidComposeView) owner).onRequestRelayout(this, false, z);
    }

    public final void resetSubtreeIntrinsicsUsage$ui() {
        MutableVector mutableVector = get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i2];
            int i3 = layoutNode.previousIntrinsicsUsageByParent;
            layoutNode.intrinsicsUsageByParent = i3;
            if (i3 != 3) {
                layoutNode.resetSubtreeIntrinsicsUsage$ui();
            }
        }
    }

    public final void rethrowWithComposeStackTrace(Throwable th) throws Throwable {
        CompositionLocalMap compositionLocalMap = this.compositionLocalMap;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionErrorContextKt.LocalCompositionErrorContext;
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) compositionLocalMap;
        persistentCompositionLocalHashMap.getClass();
        CompositionErrorContextImpl compositionErrorContextImpl = (CompositionErrorContextImpl) Stack.read(persistentCompositionLocalHashMap, staticProvidableCompositionLocal);
        if (compositionErrorContextImpl == null) {
            throw th;
        }
        ComposeStackTraceKt.tryAttachComposeStackTrace(th, new Recomposer$$ExternalSyntheticLambda6(19, compositionErrorContextImpl, this));
        throw th;
    }

    public final void setDensity(Density density) {
        if (Intrinsics.areEqual(this.density, density)) {
            return;
        }
        this.density = density;
        invalidateMeasurements$ui();
        LayoutNode parent$ui = getParent$ui();
        if (parent$ui != null) {
            parent$ui.invalidateLayer$ui();
        } else {
            Owner owner = this.owner;
            if (owner != null) {
                ((AndroidComposeView) owner).invalidate();
            }
        }
        invalidateLayers$ui();
        for (Modifier.Node node = (Modifier.Node) this.nodes.head; node != null; node = node.child) {
            node.onDensityChange();
        }
    }

    public final void setGloballyPositionedObservers(int i) {
        LayoutNode parent$ui;
        LayoutNode parent$ui2;
        int i2 = this.globallyPositionedObservers;
        if (i2 != i) {
            if (i > 0 && i2 == 0 && (parent$ui2 = getParent$ui()) != null) {
                parent$ui2.setGloballyPositionedObservers(parent$ui2.globallyPositionedObservers + 1);
            }
            if (i == 0 && this.globallyPositionedObservers > 0 && (parent$ui = getParent$ui()) != null) {
                parent$ui.setGloballyPositionedObservers(parent$ui.globallyPositionedObservers - 1);
            }
            this.globallyPositionedObservers = i;
        }
    }

    public final void setLookaheadRoot(LayoutNode layoutNode) {
        if (Intrinsics.areEqual(layoutNode, this.lookaheadRoot)) {
            return;
        }
        this.lookaheadRoot = layoutNode;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (layoutNode != null) {
            if (layoutNodeLayoutDelegate.lookaheadPassDelegate == null) {
                layoutNodeLayoutDelegate.lookaheadPassDelegate = new LookaheadPassDelegate(layoutNodeLayoutDelegate);
            }
            NodeChain nodeChain = this.nodes;
            NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
            for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
                nodeCoordinator2.ensureLookaheadDelegateCreated();
            }
        } else {
            layoutNodeLayoutDelegate.lookaheadPassDelegate = null;
            layoutNodeLayoutDelegate.lookaheadLayoutPending = false;
            layoutNodeLayoutDelegate.lookaheadMeasurePending = false;
        }
        invalidateMeasurements$ui();
    }

    public final void setMeasurePolicy(MeasurePolicy measurePolicy) {
        if (Intrinsics.areEqual(this.measurePolicy, measurePolicy)) {
            return;
        }
        this.measurePolicy = measurePolicy;
        RequestService requestService = this.intrinsicsPolicy;
        if (requestService != null) {
            ((ParcelableSnapshotMutableState) requestService.hardwareBitmapService).setValue(measurePolicy);
        }
        invalidateMeasurements$ui();
    }

    public final void setModifier(Modifier modifier) {
        if (this.isVirtual && this._modifier != Modifier.Companion.$$INSTANCE) {
            InlineClassHelperKt.throwIllegalArgumentException("Modifiers are not supported on virtual LayoutNodes");
        }
        if (this.isDeactivated) {
            InlineClassHelperKt.throwIllegalArgumentException("modifier is updated when deactivated");
        }
        if (!isAttached()) {
            this.pendingModifier = modifier;
            return;
        }
        applyModifier(modifier);
        if (this.isSemanticsInvalidated) {
            invalidateSemantics$ui();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final void setViewConfiguration(ViewConfiguration viewConfiguration) {
        if (Intrinsics.areEqual(this.viewConfiguration, viewConfiguration)) {
            return;
        }
        this.viewConfiguration = viewConfiguration;
        Modifier.Node node = (Modifier.Node) this.nodes.head;
        if ((node.aggregateChildKindSet & 16) != 0) {
            while (node != null) {
                if ((node.kindSet & 16) != 0) {
                    ?? Access$pop = node;
                    ?? mutableVector = 0;
                    while (Access$pop != 0) {
                        if (Access$pop instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) Access$pop).onViewConfigurationChange();
                        } else if ((Access$pop.kindSet & 16) != 0 && (Access$pop instanceof DelegatingNode)) {
                            Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                            int i = 0;
                            Access$pop = Access$pop;
                            mutableVector = mutableVector;
                            while (node2 != null) {
                                if ((node2.kindSet & 16) != 0) {
                                    i++;
                                    if (i == 1) {
                                        mutableVector = mutableVector;
                                        Access$pop = node2;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (Access$pop != 0) {
                                            mutableVector.add(Access$pop);
                                            Access$pop = 0;
                                        }
                                        mutableVector.add(node2);
                                    }
                                }
                                node2 = node2.child;
                                Access$pop = Access$pop;
                                mutableVector = mutableVector;
                            }
                            if (i == 1) {
                            }
                        }
                        Access$pop = HitTestResultKt.access$pop(mutableVector);
                    }
                }
                if ((node.aggregateChildKindSet & 16) == 0) {
                    return;
                } else {
                    node = node.child;
                }
            }
        }
    }

    public final String toString() {
        return InvertMatrixKt.simpleIdentityToString(this) + " children: " + ((MutableVector) ((MutableObjectList.ObjectListMutableList) getChildren$ui()).objectList).size + " measurePolicy: " + this.measurePolicy + " deactivated: " + this.isDeactivated;
    }

    public final void updateChildrenIfDirty$ui() {
        if (this.virtualChildrenCount <= 0 || !this.unfoldedVirtualChildrenListDirty) {
            return;
        }
        this.unfoldedVirtualChildrenListDirty = false;
        MutableVector mutableVector = this._unfoldedChildren;
        if (mutableVector == null) {
            mutableVector = new MutableVector(new LayoutNode[16]);
            this._unfoldedChildren = mutableVector;
        }
        mutableVector.clear();
        MutableVector mutableVector2 = (MutableVector) this._foldedChildren.systemCallbacks;
        Object[] objArr = mutableVector2.content;
        int i = mutableVector2.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i2];
            if (layoutNode.isVirtual) {
                mutableVector.addAll(mutableVector.size, layoutNode.get_children$ui());
            } else {
                mutableVector.add(layoutNode);
            }
        }
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        layoutNodeLayoutDelegate.measurePassDelegate.childDelegatesDirty = true;
        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.childDelegatesDirty = true;
        }
    }

    public LayoutNode(int i, boolean z) {
        this.isVirtual = z;
        this.semanticsId = i;
        this.outerToInnerOffset = 9223372034707292159L;
        this.outerToInnerOffsetDirty = true;
        this.rectInParentDirty = true;
        this._foldedChildren = new RequestService(6, new MutableVector(new LayoutNode[16]), new Handshake.AnonymousClass2(8, this));
        this._zSortedChildren = new MutableVector(new LayoutNode[16]);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.density = LayoutNodeKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        CompositionLocalMap.Companion.getClass();
        this.compositionLocalMap = CompositionLocalMap.Companion.Empty;
        this.intrinsicsUsageByParent = 3;
        this.previousIntrinsicsUsageByParent = 3;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this._modifier = Modifier.Companion.$$INSTANCE;
    }
}
