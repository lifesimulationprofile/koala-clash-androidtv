package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeUiNode$Companion$SetModifier$1 extends Lambda implements Function2 {
    public static final ComposeUiNode$Companion$SetModifier$1 INSTANCE;
    public static final ComposeUiNode$Companion$SetModifier$1 INSTANCE$1;
    public static final ComposeUiNode$Companion$SetModifier$1 INSTANCE$2;
    public static final ComposeUiNode$Companion$SetModifier$1 INSTANCE$3;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 2;
        INSTANCE$1 = new ComposeUiNode$Companion$SetModifier$1(i, 1);
        INSTANCE$2 = new ComposeUiNode$Companion$SetModifier$1(i, 2);
        INSTANCE = new ComposeUiNode$Companion$SetModifier$1(i, 0);
        INSTANCE$3 = new ComposeUiNode$Companion$SetModifier$1(i, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComposeUiNode$Companion$SetModifier$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((LayoutNode) ((ComposeUiNode) obj)).setModifier((Modifier) obj2);
                break;
            case 1:
                ((Number) obj2).intValue();
                ((LayoutNode) ((ComposeUiNode) obj)).getClass();
                break;
            case 2:
                ((LayoutNode) ((ComposeUiNode) obj)).setMeasurePolicy((MeasurePolicy) obj2);
                break;
            default:
                CompositionLocalMap compositionLocalMap = (CompositionLocalMap) obj2;
                LayoutNode layoutNode = (LayoutNode) ((ComposeUiNode) obj);
                layoutNode.compositionLocalMap = compositionLocalMap;
                NodeChain nodeChain = layoutNode.nodes;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalDensity;
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) compositionLocalMap;
                persistentCompositionLocalHashMap.getClass();
                layoutNode.setDensity((Density) Stack.read(persistentCompositionLocalHashMap, staticProvidableCompositionLocal));
                LayoutDirection layoutDirection = (LayoutDirection) Stack.read(persistentCompositionLocalHashMap, CompositionLocalsKt.LocalLayoutDirection);
                if (layoutNode.layoutDirection != layoutDirection) {
                    layoutNode.layoutDirection = layoutDirection;
                    layoutNode.invalidateMeasurements$ui();
                    LayoutNode parent$ui = layoutNode.getParent$ui();
                    if (parent$ui != null) {
                        parent$ui.invalidateLayer$ui();
                    } else {
                        Owner owner = layoutNode.owner;
                        if (owner != null) {
                            ((AndroidComposeView) owner).invalidate();
                        }
                    }
                    layoutNode.invalidateLayers$ui();
                    for (Modifier.Node node = (Modifier.Node) nodeChain.head; node != null; node = node.child) {
                        node.onLayoutDirectionChange();
                    }
                }
                layoutNode.setViewConfiguration((ViewConfiguration) Stack.read(persistentCompositionLocalHashMap, CompositionLocalsKt.LocalViewConfiguration));
                Modifier.Node node2 = (Modifier.Node) nodeChain.head;
                if ((node2.aggregateChildKindSet & 32768) != 0) {
                    while (node2 != null) {
                        if ((node2.kindSet & 32768) != 0) {
                            ?? Access$pop = node2;
                            ?? mutableVector = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof CompositionLocalConsumerModifierNode) {
                                    Modifier.Node node3 = ((Modifier.Node) ((CompositionLocalConsumerModifierNode) Access$pop)).node;
                                    if (node3.isAttached) {
                                        NodeKindKt.autoInvalidateUpdatedNode(node3);
                                    } else {
                                        node3.updatedNodeAwaitingAttachForInvalidation = true;
                                    }
                                } else if ((Access$pop.kindSet & 32768) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node4 = ((DelegatingNode) Access$pop).delegate;
                                    int i = 0;
                                    while (node4 != null) {
                                        if ((node4.kindSet & 32768) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Access$pop = Access$pop;
                                                mutableVector = mutableVector;
                                                mutableVector = mutableVector;
                                                Access$pop = node4;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Access$pop != 0) {
                                                    mutableVector.add(Access$pop);
                                                    Access$pop = 0;
                                                }
                                                mutableVector.add(node4);
                                            }
                                        } else {
                                            Access$pop = Access$pop;
                                            mutableVector = mutableVector;
                                        }
                                        node4 = node4.child;
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
                        if ((node2.aggregateChildKindSet & 32768) != 0) {
                            node2 = node2.child;
                        }
                    }
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
