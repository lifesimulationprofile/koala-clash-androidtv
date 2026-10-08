package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.navigation.compose.NavHostKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RulerKt {
    public static final ContentScale$Companion$Fit$1 ReusedSlotId = new ContentScale$Companion$Fit$1(4);
    public static final Object UnspecifiedSlotId = new Object();

    public static final void SubcomposeLayout(Modifier modifier, Function2 function2, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-1298353104);
        int i2 = i | 6 | (gapComposer.changedInstance(function2) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new SubcomposeLayoutState(ContentScale$Companion$Fit$1.INSTANCE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            SubcomposeLayout((SubcomposeLayoutState) objRememberedValue, companion, function2, gapComposer, (i2 << 3) & 1008);
            modifier = companion;
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new NavHostKt.AnonymousClass32.AnonymousClass1(i, 3, modifier, function2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    public static final float access$mergeRulerValues(Placeable.PlacementScope placementScope, boolean z, VerticalRuler[] verticalRulerArr, float f) {
        float f2 = Float.NaN;
        for (VerticalRuler verticalRuler : verticalRulerArr) {
            float fCurrent = placementScope.current(verticalRuler);
            if (Float.isNaN(f2)) {
                f2 = fCurrent;
            } else if (z == (fCurrent > f2)) {
                f2 = fCurrent;
            }
        }
        return Float.isNaN(f2) ? f : f2;
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.localBoundingBoxOf(layoutCoordinates, true) : new Rect(0.0f, 0.0f, (int) (layoutCoordinates.mo522getSizeYbymL2g() >> 32), (int) (layoutCoordinates.mo522getSizeYbymL2g() & 4294967295L));
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates, boolean z) {
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = findRootCoordinates(layoutCoordinates);
        float fMo522getSizeYbymL2g = (int) (layoutCoordinatesFindRootCoordinates.mo522getSizeYbymL2g() >> 32);
        float fMo522getSizeYbymL2g2 = (int) (layoutCoordinatesFindRootCoordinates.mo522getSizeYbymL2g() & 4294967295L);
        Rect rectLocalBoundingBoxOf = layoutCoordinatesFindRootCoordinates.localBoundingBoxOf(layoutCoordinates, z);
        float f = rectLocalBoundingBoxOf.bottom;
        float f2 = rectLocalBoundingBoxOf.right;
        float f3 = rectLocalBoundingBoxOf.top;
        float f4 = rectLocalBoundingBoxOf.left;
        if (z) {
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > fMo522getSizeYbymL2g) {
                f4 = fMo522getSizeYbymL2g;
            }
        }
        if (z) {
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            if (f3 > fMo522getSizeYbymL2g2) {
                f3 = fMo522getSizeYbymL2g2;
            }
        }
        if (z) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 <= fMo522getSizeYbymL2g) {
                fMo522getSizeYbymL2g = f2;
            }
            f2 = fMo522getSizeYbymL2g;
        }
        if (z) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f <= fMo522getSizeYbymL2g2) {
                fMo522getSizeYbymL2g2 = f;
            }
            f = fMo522getSizeYbymL2g2;
        }
        if (f4 == f2 || f3 == f) {
            return Rect.Zero;
        }
        long jMo527localToWindowMKHz9U = layoutCoordinatesFindRootCoordinates.mo527localToWindowMKHz9U((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
        long jMo527localToWindowMKHz9U2 = layoutCoordinatesFindRootCoordinates.mo527localToWindowMKHz9U((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
        long jMo527localToWindowMKHz9U3 = layoutCoordinatesFindRootCoordinates.mo527localToWindowMKHz9U((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
        long jMo527localToWindowMKHz9U4 = layoutCoordinatesFindRootCoordinates.mo527localToWindowMKHz9U((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jMo527localToWindowMKHz9U >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jMo527localToWindowMKHz9U2 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jMo527localToWindowMKHz9U4 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jMo527localToWindowMKHz9U3 >> 32));
        float fMin = Math.min(fIntBitsToFloat, Math.min(fIntBitsToFloat2, Math.min(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fMax = Math.max(fIntBitsToFloat, Math.max(fIntBitsToFloat2, Math.max(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jMo527localToWindowMKHz9U & 4294967295L));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jMo527localToWindowMKHz9U2 & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jMo527localToWindowMKHz9U4 & 4294967295L));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jMo527localToWindowMKHz9U3 & 4294967295L));
        return new Rect(fMin, Math.min(fIntBitsToFloat5, Math.min(fIntBitsToFloat6, Math.min(fIntBitsToFloat7, fIntBitsToFloat8))), fMax, Math.max(fIntBitsToFloat5, Math.max(fIntBitsToFloat6, Math.max(fIntBitsToFloat7, fIntBitsToFloat8))));
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m538equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
        while (true) {
            NodeCoordinator nodeCoordinator3 = nodeCoordinator2;
            NodeCoordinator nodeCoordinator4 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator3;
            if (nodeCoordinator == null) {
                return nodeCoordinator4;
            }
            nodeCoordinator2 = nodeCoordinator.wrappedBy;
        }
    }

    public static final Object getLayoutId(Measurable measurable) {
        Object parentData = measurable.getParentData();
        LayoutIdModifier layoutIdModifier = parentData instanceof LayoutIdModifier ? (LayoutIdModifier) parentData : null;
        if (layoutIdModifier != null) {
            return layoutIdModifier.layoutId;
        }
        return null;
    }

    public static final LookaheadDelegate getRootLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        LayoutNode layoutNode = lookaheadDelegate.coordinator.layoutNode;
        while (true) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            if ((parent$ui != null ? parent$ui.lookaheadRoot : null) == null) {
                return ((NodeCoordinator) layoutNode.nodes.outerCoordinator).getLookaheadDelegate();
            }
            layoutNode.getParent$ui();
            layoutNode = layoutNode.getParent$ui().lookaheadRoot;
        }
    }

    public static final Modifier layout(Modifier modifier, Function3 function3) {
        return modifier.then(new LayoutElement(function3));
    }

    public static final Modifier layoutId(Modifier modifier, String str) {
        return modifier.then(new LayoutIdElement(str));
    }

    public static final Modifier onGloballyPositioned(Modifier modifier, Function1 function1) {
        return modifier.then(new OnGloballyPositionedElement(function1));
    }

    public static final Modifier onSizeChanged(Modifier modifier, Function1 function1) {
        return modifier.then(new OnSizeChangedModifier(function1));
    }

    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m539timesUQTWf7w(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) * Float.intBitsToFloat((int) (j >> 32));
        return (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) * Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static final void SubcomposeLayout(final SubcomposeLayoutState subcomposeLayoutState, final Modifier modifier, final Function2 function2, GapComposer gapComposer, final int i) {
        int i2;
        gapComposer.startRestartGroup(-511989831);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(subcomposeLayoutState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            long j = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            GapComposer.CompositionContextImpl compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifier);
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = LayoutNode$Companion$Constructor$1.INSTANCE;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, subcomposeLayoutState, subcomposeLayoutState.setRoot);
            Stack.m295setimpl(gapComposer, compositionContextImplRememberCompositionContext, subcomposeLayoutState.setCompositionContext);
            Stack.m295setimpl(gapComposer, function2, subcomposeLayoutState.setMeasurePolicy);
            ComposeUiNode.Companion.getClass();
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            gapComposer.end(true);
            if (!gapComposer.getSkipping()) {
                gapComposer.startReplaceGroup(-1259245908);
                boolean zChangedInstance = gapComposer.changedInstance(subcomposeLayoutState);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new Handshake.AnonymousClass2(7, subcomposeLayoutState);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Stack.SideEffect((Function0) objRememberedValue, gapComposer);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1259187287);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Number) obj2).intValue();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    RulerKt.SubcomposeLayout(subcomposeLayoutState, modifier, function2, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
