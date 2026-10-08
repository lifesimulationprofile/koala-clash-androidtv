package androidx.navigation.compose;

import android.os.IBinder;
import android.view.KeyEvent;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawModifierNodeImpl;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.input.pointer.HitPathTracker;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.platform.ScrollObservationScope;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.navigation.NavBackStackEntry;
import com.github.kr328.kaidl.SuspendTransactionKt$$ExternalSyntheticLambda0;
import com.github.kr328.kaidl.SuspendTransactionKt$suspendTransact$2$link$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DialogHostKt$DialogHost$1$1$1 extends Lambda implements Function0 {
    public final /* synthetic */ Object $backStackEntry;
    public final /* synthetic */ Object $dialogNavigator;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogHostKt$DialogHost$1$1$1(int i, Object obj, Object obj2) {
        super(0);
        this.$r8$classId = i;
        this.$dialogNavigator = obj;
        this.$backStackEntry = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v11 */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        SemanticsNode semanticsNode;
        LayoutNode layoutNode;
        Rect rect;
        int i = this.$r8$classId;
        Object obj = this.$backStackEntry;
        Object obj2 = this.$dialogNavigator;
        switch (i) {
            case 0:
                ((DialogNavigator) obj2).popBackStack((NavBackStackEntry) obj, false);
                return Unit.INSTANCE;
            case 1:
                ((CacheDrawModifierNodeImpl) obj2).block.invoke((CacheDrawScope) obj);
                return Unit.INSTANCE;
            case 2:
                ((Ref$ObjectRef) obj2).element = ((FocusTargetNode) obj).fetchFocusProperties$ui();
                return Unit.INSTANCE;
            case 3:
                ((HitPathTracker) obj2).removePointerInputModifierNode((Modifier.Node) obj);
                return Unit.INSTANCE;
            case 4:
                NodeChain nodeChain = ((LayoutNode) obj2).nodes;
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj;
                if ((((Modifier.Node) nodeChain.head).aggregateChildKindSet & 8) != 0) {
                    for (Modifier.Node node = (TailModifierNode) nodeChain.tail; node != null; node = node.parent) {
                        if ((node.kindSet & 8) != 0) {
                            ?? Access$pop = node;
                            ?? mutableVector = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof SemanticsModifierNode) {
                                    SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) Access$pop;
                                    if (semanticsModifierNode.getShouldClearDescendantSemantics()) {
                                        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
                                        ref$ObjectRef.element = semanticsConfiguration;
                                        semanticsConfiguration.isClearingSemantics = true;
                                    }
                                    if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                        ((SemanticsConfiguration) ref$ObjectRef.element).isMergingSemanticsOfDescendants = true;
                                    }
                                    semanticsModifierNode.applySemantics((SemanticsPropertyReceiver) ref$ObjectRef.element);
                                } else if ((Access$pop.kindSet & 8) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                                    int i2 = 0;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 8) != 0) {
                                            i2++;
                                            if (i2 == 1) {
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
                                    if (i2 == 1) {
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
                    }
                }
                return Unit.INSTANCE;
            case 5:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
                ((Function1) obj2).invoke(reusableGraphicsLayerScope);
                NodeCoordinator nodeCoordinator = (NodeCoordinator) obj;
                boolean zAreEqual = Intrinsics.areEqual(nodeCoordinator.lastShape, reusableGraphicsLayerScope.shape);
                boolean z = nodeCoordinator.lastClip;
                boolean z2 = reusableGraphicsLayerScope.clip;
                boolean z3 = z != z2;
                if (!zAreEqual || z3) {
                    nodeCoordinator.lastShape = reusableGraphicsLayerScope.shape;
                    nodeCoordinator.lastClip = z2;
                    if (nodeCoordinator.wasLayerBlockInvoked && (z3 || (z2 && !zAreEqual))) {
                        nodeCoordinator.layoutNode.invalidateSemantics$ui();
                    }
                }
                nodeCoordinator.wasLayerBlockInvoked = true;
                reusableGraphicsLayerScope.outline = reusableGraphicsLayerScope.shape.mo60createOutlinePq9zytI(reusableGraphicsLayerScope.size, reusableGraphicsLayerScope.layoutDirection, reusableGraphicsLayerScope.graphicsDensity);
                return Unit.INSTANCE;
            case 6:
                return Boolean.valueOf(super/*android.view.ViewGroup*/.dispatchKeyEvent((KeyEvent) obj));
            case 7:
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = (AndroidComposeViewAccessibilityDelegateCompat) obj;
                ScrollObservationScope scrollObservationScope = (ScrollObservationScope) obj2;
                ScrollAxisRange scrollAxisRange = scrollObservationScope.horizontalScrollAxisRange;
                ScrollAxisRange scrollAxisRange2 = scrollObservationScope.verticalScrollAxisRange;
                Float f = scrollObservationScope.oldXValue;
                Float f2 = scrollObservationScope.oldYValue;
                float fFloatValue = (scrollAxisRange == null || f == null) ? 0.0f : ((Number) scrollAxisRange.value.invoke()).floatValue() - f.floatValue();
                float fFloatValue2 = (scrollAxisRange2 == null || f2 == null) ? 0.0f : ((Number) scrollAxisRange2.value.invoke()).floatValue() - f2.floatValue();
                if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                    int iSemanticsNodeIdToAccessibilityVirtualNodeId = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(scrollObservationScope.semanticsNodeId);
                    SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId);
                    if (semanticsNodeWithAdjustedBounds != null) {
                        try {
                            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI;
                            if (accessibilityNodeInfoCompat != null) {
                                accessibilityNodeInfoCompat.mInfo.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds));
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException unused) {
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                    SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId);
                    if (semanticsNodeWithAdjustedBounds2 != null) {
                        try {
                            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI;
                            if (accessibilityNodeInfoCompat2 != null) {
                                accessibilityNodeInfoCompat2.mInfo.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds2));
                                Unit unit3 = Unit.INSTANCE;
                            }
                        } catch (IllegalStateException unused2) {
                            Unit unit4 = Unit.INSTANCE;
                        }
                    }
                    androidComposeViewAccessibilityDelegateCompat.view.invalidate();
                    SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds3 = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes().get(iSemanticsNodeIdToAccessibilityVirtualNodeId);
                    if (semanticsNodeWithAdjustedBounds3 != null && (semanticsNode = semanticsNodeWithAdjustedBounds3.semanticsNode) != null && (layoutNode = semanticsNode.layoutNode) != null) {
                        if (scrollAxisRange != null) {
                            androidComposeViewAccessibilityDelegateCompat.pendingHorizontalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, scrollAxisRange);
                        }
                        if (scrollAxisRange2 != null) {
                            androidComposeViewAccessibilityDelegateCompat.pendingVerticalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, scrollAxisRange2);
                        }
                        androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                    }
                    break;
                }
                if (scrollAxisRange != null) {
                    scrollObservationScope.oldXValue = (Float) scrollAxisRange.value.invoke();
                }
                if (scrollAxisRange2 != null) {
                    scrollObservationScope.oldYValue = (Float) scrollAxisRange2.value.invoke();
                }
                return Unit.INSTANCE;
            case 8:
                Function0 function0 = (Function0) obj2;
                if (function0 != null && (rect = (Rect) function0.invoke()) != null) {
                    return rect;
                }
                NodeCoordinator nodeCoordinator2 = (NodeCoordinator) obj;
                if (!nodeCoordinator2.getTail().isAttached) {
                    nodeCoordinator2 = null;
                }
                if (nodeCoordinator2 != null) {
                    return RectKt.m382Recttz77jQw(0L, IntSizeKt.m724toSizeozmzZPI(nodeCoordinator2.measuredSize));
                }
                return null;
            case 9:
                try {
                    ((IBinder) obj2).unlinkToDeath((SuspendTransactionKt$suspendTransact$2$link$1) obj, 0);
                    break;
                } catch (Exception unused3) {
                }
                return Unit.INSTANCE;
            default:
                try {
                    ((IBinder) obj2).unlinkToDeath((SuspendTransactionKt$$ExternalSyntheticLambda0) obj, 0);
                    break;
                } catch (Exception unused4) {
                }
                return Unit.INSTANCE;
        }
    }
}
