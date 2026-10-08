package androidx.compose.foundation;

import android.os.Build;
import android.view.KeyEvent;
import android.widget.EdgeEffect;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageKt {
    public static final void Canvas(Modifier modifier, Function1 function1, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-932836462);
        int i2 = (gapComposer.changed(modifier) ? 4 : 2) | i | (gapComposer.changedInstance(function1) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            OffsetKt.Spacer(gapComposer, ClipKt.drawBehind(modifier, function1));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 1, modifier, function1);
        }
    }

    public static final void Image(final Painter painter, final String str, final Modifier modifier, Alignment alignment, final ContentScale contentScale, float f, GapComposer gapComposer, final int i, final int i2) {
        Alignment alignment2;
        int i3;
        int i4;
        int i5;
        final Alignment alignment3;
        final float f2;
        gapComposer.startRestartGroup(1142754848);
        int i6 = (gapComposer.changedInstance(painter) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i6 |= gapComposer.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i3 = i6 | 3072;
            alignment2 = alignment;
        } else {
            alignment2 = alignment;
            i3 = i6 | (gapComposer.changed(alignment2) ? 2048 : 1024);
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changed(contentScale) ? 16384 : 8192;
        }
        int i8 = i2 & 32;
        if (i8 != 0) {
            i4 = i3 | 196608;
        } else {
            i4 = i3 | (gapComposer.changed(f) ? 131072 : 65536);
        }
        if ((i2 & 64) != 0) {
            i5 = 1572864;
        } else {
            i5 = gapComposer.changed((Object) null) ? 1048576 : 524288;
        }
        int i9 = i4 | i5;
        if (gapComposer.shouldExecute(i9 & 1, (599187 & i9) != 599186)) {
            Alignment alignment4 = i7 != 0 ? Alignment.Companion.Center : alignment2;
            float f3 = i8 != 0 ? 1.0f : f;
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            Modifier modifierSemantics = Modifier.Companion.$$INSTANCE;
            if (str != null) {
                gapComposer.startReplaceGroup(1899222916);
                boolean z = (i9 & 112) == 32;
                Object objRememberedValue = gapComposer.rememberedValue();
                if (z || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new IconKt$$ExternalSyntheticLambda1(str, 1);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                modifierSemantics = SemanticsModifierKt.semantics(modifierSemantics, false, (Function1) objRememberedValue);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1899381698);
                gapComposer.end(false);
            }
            Modifier modifierPaint$default = ClipKt.paint$default(ClipKt.clipToBounds(modifier.then(modifierSemantics)), painter, alignment4, contentScale, f3, null, 2);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = ImageKt$Image$1$1.INSTANCE;
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue2;
            long j = gapComposer.compositeKeyHashCode;
            int i10 = (int) ((j >>> 32) ^ j);
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierPaint$default);
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i10), ComposeUiNode.Companion.SetCompositeKeyHash);
            gapComposer.end(true);
            alignment3 = alignment4;
            f2 = f3;
        } else {
            gapComposer.skipToGroupEnd();
            alignment3 = alignment2;
            f2 = f;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.ImageKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ImageKt.Image(painter, str, modifier, alignment3, contentScale, f2, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static float absorbToRelaxIfNeeded(EdgeEffect edgeEffect, float f, float f2, Density density) {
        float f3 = EdgeEffectCompat_androidKt.PlatformFlingScrollFriction;
        double density2 = density.getDensity() * 386.0878f * 160.0f * 0.84f;
        double dAbs = Math.abs(f) * 0.35f;
        double d = ((double) EdgeEffectCompat_androidKt.PlatformFlingScrollFriction) * density2;
        float fExp = (float) (Math.exp((EdgeEffectCompat_androidKt.DecelerationRate / EdgeEffectCompat_androidKt.DecelMinusOne) * Math.log(dAbs / d)) * d);
        int i = Build.VERSION.SDK_INT;
        if (fExp > (i >= 31 ? Api31Impl.getDistance(edgeEffect) : 0.0f) * f2) {
            return 0.0f;
        }
        int iRoundToInt = MathKt.roundToInt(f);
        if (i >= 31) {
            edgeEffect.onAbsorb(iRoundToInt);
            return f;
        }
        if (edgeEffect.isFinished()) {
            edgeEffect.onAbsorb(iRoundToInt);
        }
        return f;
    }

    /* JADX INFO: renamed from: background-bw27NRU, reason: not valid java name */
    public static final Modifier m47backgroundbw27NRU(Modifier modifier, long j, Shape shape) {
        return modifier.then(new BackgroundElement(j, null, shape, 2));
    }

    /* JADX INFO: renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m48borderxT4_qwU(float f, long j, Modifier modifier, Shape shape) {
        return modifier.then(new BorderModifierNodeElement(f, new SolidColor(j), shape));
    }

    /* JADX INFO: renamed from: checkScrollableContainerConstraints-K40F9xA, reason: not valid java name */
    public static final void m49checkScrollableContainerConstraintsK40F9xA(long j, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            if (Constraints.m682getMaxHeightimpl(j) != Integer.MAX_VALUE) {
                return;
            }
            InlineClassHelperKt.throwIllegalStateException("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        } else {
            if (Constraints.m683getMaxWidthimpl(j) != Integer.MAX_VALUE) {
                return;
            }
            InlineClassHelperKt.throwIllegalStateException("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        }
    }

    /* JADX INFO: renamed from: clickable-O2vRcR0$default, reason: not valid java name */
    public static Modifier m50clickableO2vRcR0$default(Modifier modifier, MutableInteractionSourceImpl mutableInteractionSourceImpl, final RippleNodeFactory rippleNodeFactory, boolean z, Role role, final Function0 function0, int i) {
        Modifier modifierThen;
        if ((i & 4) != 0) {
            z = true;
        }
        final boolean z2 = z;
        if ((i & 16) != 0) {
            role = null;
        }
        final Role role2 = role;
        if (rippleNodeFactory != null) {
            modifierThen = new ClickableElement(mutableInteractionSourceImpl, rippleNodeFactory, false, z2, null, role2, function0);
        } else if (rippleNodeFactory == null) {
            modifierThen = new ClickableElement(mutableInteractionSourceImpl, null, false, z2, null, role2, function0);
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            modifierThen = mutableInteractionSourceImpl != null ? IndicationKt.indication(companion, mutableInteractionSourceImpl, rippleNodeFactory).then(new ClickableElement(mutableInteractionSourceImpl, null, false, z2, null, role2, function0)) : companion.then(new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    GapComposer gapComposer = (GapComposer) obj2;
                    ((Number) obj3).intValue();
                    gapComposer.startReplaceGroup(-1525724089);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new MutableInteractionSourceImpl();
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
                    Modifier modifierThen2 = IndicationKt.indication(Modifier.Companion.$$INSTANCE, mutableInteractionSourceImpl2, rippleNodeFactory).then(new ClickableElement(mutableInteractionSourceImpl2, null, false, z2, null, role2, function0));
                    gapComposer.end(false);
                    return modifierThen2;
                }
            }));
        }
        return modifier.then(modifierThen);
    }

    /* JADX INFO: renamed from: clickable-oSLSa3U$default, reason: not valid java name */
    public static Modifier m51clickableoSLSa3U$default(Modifier modifier, boolean z, String str, Function0 function0, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 2) != 0) {
            str = null;
        }
        return modifier.then(new ClickableElement(null, null, true, z2, str, null, function0));
    }

    public static final Modifier focusGroup(Modifier modifier) {
        return modifier.then(FocusGroupElement.INSTANCE);
    }

    public static final Modifier focusable(Modifier modifier, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        return modifier.then(z ? new FocusableElement(mutableInteractionSourceImpl) : Modifier.Companion.$$INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.foundation.GestureConnection, androidx.compose.ui.node.DelegatingNode] */
    public static final GestureConnection getParentGestureConnection(DelegatingNode delegatingNode) {
        TraversableNode traversableNodeFindNearestAncestor = HitTestResultKt.findNearestAncestor(delegatingNode, GestureNode.TraverseKey);
        GestureNode gestureNode = traversableNodeFindNearestAncestor instanceof GestureNode ? (GestureNode) traversableNodeFindNearestAncestor : null;
        if (gestureNode != null) {
            return gestureNode.gestureConnection;
        }
        return null;
    }

    /* JADX INFO: renamed from: isEnter-ZmokQxo, reason: not valid java name */
    public static final boolean m53isEnterZmokQxo(KeyEvent keyEvent) {
        long jM505getKeyZmokQxo = Key_androidKt.m505getKeyZmokQxo(keyEvent);
        int i = Key.$r8$clinit;
        return Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.DirectionCenter) || Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.Enter) || Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.NumPadEnter) || Key.m504equalsimpl0(jM505getKeyZmokQxo, Key.Spacebar);
    }

    public static final ScrollState rememberScrollState(GapComposer gapComposer) {
        Object[] objArr = new Object[0];
        boolean zChanged = gapComposer.changed(0);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new ImmLeaksCleaner$$ExternalSyntheticLambda0(8);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (ScrollState) SaverKt.rememberSaveable(objArr, ScrollState.Saver, (Function0) objRememberedValue, gapComposer, 0);
    }

    public static Modifier scrollableArea$default(Modifier modifier, LazyListState lazyListState, Orientation orientation, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        float f = ClipScrollableContainerKt.MaxSupportedElevation;
        Orientation orientation2 = Orientation.Vertical;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        return modifier.then(orientation == orientation2 ? ClipKt.clip(companion, VerticalScrollableClipShape.INSTANCE) : ClipKt.clip(companion, VerticalScrollableClipShape.INSTANCE$1)).then(new ScrollableAreaElement(androidEdgeEffectOverscrollEffect, flingBehavior, orientation, lazyListState, mutableInteractionSourceImpl, z, z2, false));
    }

    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m54shrinkKibmq7A(float f, long j) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f);
        return (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L);
    }

    public static Modifier verticalScroll$default(Modifier modifier, ScrollState scrollState) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = scrollState.internalInteractionSource;
        float f = ClipScrollableContainerKt.MaxSupportedElevation;
        return modifier.then(ClipKt.clip(Modifier.Companion.$$INSTANCE, VerticalScrollableClipShape.INSTANCE)).then(new ScrollableAreaElement(null, null, Orientation.Vertical, scrollState, mutableInteractionSourceImpl, true, false, true)).then(new ScrollingLayoutElement(scrollState));
    }
}
