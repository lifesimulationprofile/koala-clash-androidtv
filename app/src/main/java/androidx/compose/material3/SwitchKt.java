package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.semantics.Role;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SwitchKt {
    public static final SnapSpec SnapSpec;
    public static final float SwitchHeight;
    public static final float SwitchWidth;
    public static final float ThumbDiameter;
    public static final float ThumbPadding;
    public static final float UncheckedThumbDiameter;

    static {
        float f = SwitchTokens.SelectedHandleWidth;
        ThumbDiameter = f;
        UncheckedThumbDiameter = SwitchTokens.UnselectedHandleWidth;
        SwitchWidth = SwitchTokens.TrackWidth;
        float f2 = SwitchTokens.TrackHeight;
        SwitchHeight = f2;
        ThumbPadding = (f2 - f) / 2;
        SnapSpec = new SnapSpec(0);
    }

    public static final void Switch(boolean z, Function1 function1, Modifier modifier, boolean z2, SwitchColors switchColors, GapComposer gapComposer, int i) {
        Modifier modifier2;
        boolean z3;
        boolean z4;
        Modifier modifier3;
        boolean z5;
        gapComposer.startRestartGroup(-263339167);
        int i2 = i | (gapComposer.changed(z) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | 28032 | (gapComposer.changed(switchColors) ? 131072 : 65536) | 1572864;
        if (gapComposer.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            gapComposer.startDefaults();
            int i3 = i & 1;
            Modifier modifierM155toggleableO2vRcR0 = Modifier.Companion.$$INSTANCE;
            if (i3 == 0 || gapComposer.getDefaultsInvalid()) {
                z4 = true;
                modifier3 = modifierM155toggleableO2vRcR0;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
                z4 = z2;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(1768510810);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new MutableInteractionSourceImpl();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer.end(false);
            if (function1 != null) {
                HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                boolean z6 = z4;
                modifierM155toggleableO2vRcR0 = SelectableKt.m155toggleableO2vRcR0(MinimumInteractiveModifier.INSTANCE, z, mutableInteractionSourceImpl, z6, new Role(2), function1);
                z5 = z6;
            } else {
                z5 = z4;
            }
            Modifier modifierM138requiredSizeVpY3zN4 = SizeKt.m138requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(modifierM155toggleableO2vRcR0)), SwitchWidth, SwitchHeight);
            float f = SwitchTokens.PressedHandleWidth;
            SwitchImpl(modifierM138requiredSizeVpY3zN4, z, z5, switchColors, mutableInteractionSourceImpl, ShapesKt.getValue(7, gapComposer), gapComposer, ((i2 << 3) & 112) | 384 | ((i2 >> 6) & 7168) | 24576);
            z3 = z5;
            modifier2 = modifier3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            z3 = z2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SwitchKt$$ExternalSyntheticLambda0(z, function1, modifier2, z3, switchColors, i, 0);
        }
    }

    public static final void SwitchImpl(final Modifier modifier, final boolean z, final boolean z2, final SwitchColors switchColors, final MutableInteractionSourceImpl mutableInteractionSourceImpl, Shape shape, GapComposer gapComposer, final int i) {
        int i2;
        Shape shape2;
        char c;
        long j;
        char c2;
        long j2;
        long j3;
        gapComposer.startRestartGroup(-670917213);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(switchColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changedInstance(null) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(mutableInteractionSourceImpl) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changed(shape) ? 1048576 : 524288;
        }
        if (gapComposer.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            if (!z2) {
                c = ' ';
                j = z ? switchColors.disabledCheckedTrackColor : switchColors.disabledUncheckedTrackColor;
            } else if (z) {
                c = ' ';
                j = switchColors.checkedTrackColor;
            } else {
                c = ' ';
                j = switchColors.uncheckedTrackColor;
            }
            if (z2) {
                c2 = c;
                j2 = z ? switchColors.checkedThumbColor : switchColors.uncheckedThumbColor;
            } else {
                c2 = c;
                j2 = z ? switchColors.disabledCheckedThumbColor : switchColors.disabledUncheckedThumbColor;
            }
            float f = SwitchTokens.PressedHandleWidth;
            Shape value = ShapesKt.getValue(7, gapComposer);
            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = RippleKt.LocalRippleThemeConfiguration;
            char c3 = c2;
            boolean zAreEqual = Intrinsics.areEqual(gapComposer.consume(dynamicProvidableCompositionLocal), RippleDefaults.InsetFocusRingRippleThemeConfiguration);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierIndication = zAreEqual ? IndicationKt.indication(companion, mutableInteractionSourceImpl, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, value, true, 7)) : companion;
            float f2 = SwitchTokens.TrackOutlineWidth;
            if (z2) {
                j3 = z ? switchColors.checkedBorderColor : switchColors.uncheckedBorderColor;
            } else {
                j3 = z ? switchColors.disabledCheckedBorderColor : switchColors.disabledUncheckedBorderColor;
            }
            Modifier modifierThen = ImageKt.m47backgroundbw27NRU(ImageKt.m48borderxT4_qwU(f2, j3, modifier, value), j, value).then(modifierIndication);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j4 = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j4 ^ (j4 >>> c3));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierThen);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i3);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            shape2 = shape;
            Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(IndicationKt.indication(FlowRowOverflow.INSTANCE.align(companion, Alignment.Companion.CenterStart).then(new ThumbElement(mutableInteractionSourceImpl, z, ScrimKt.value(2, gapComposer))), mutableInteractionSourceImpl, RippleKt.m260rippleOu1YvPQ$default(SwitchTokens.StateLayerSize / 2, 0L, null, Intrinsics.areEqual(gapComposer.consume(dynamicProvidableCompositionLocal), RippleDefaults.OpacityFocusRippleThemeConfiguration), 220)), j2, shape2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j5 = gapComposer.compositeKeyHashCode;
            int i4 = (int) (j5 ^ (j5 >>> c3));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM47backgroundbw27NRU);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            gapComposer.startReplaceGroup(1236071411);
            gapComposer.end(false);
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            shape2 = shape;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Shape shape3 = shape2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.SwitchKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    SwitchKt.SwitchImpl(modifier, z, z2, switchColors, mutableInteractionSourceImpl, shape3, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
