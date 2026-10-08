package com.github.kr328.clash.compose.util;

import androidx.activity.compose.BackHandlerKt;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda8;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeState;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TvGlassTabRowKt {
    /* JADX WARN: Code duplicated, block: B:55:0x0122  */
    /* JADX WARN: Code duplicated, block: B:56:0x0124  */
    /* JADX WARN: Code duplicated, block: B:62:0x0131  */
    /* JADX WARN: Code duplicated, block: B:66:0x015f  */
    /* JADX WARN: Code duplicated, block: B:69:0x019c  */
    /* JADX WARN: Code duplicated, block: B:70:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:76:0x01e0  */
    public static final void TvGlassTab(String str, boolean z, Function0 function0, FocusRequester focusRequester, Function3 function3, Modifier modifier, GapComposer gapComposer, int i) {
        NeverEqualPolicy neverEqualPolicy;
        boolean z2;
        Object objRememberedValue;
        MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue2;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        FontWeight fontWeight;
        Modifier modifier2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1122249420);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changed(z) ? 32 : 16) | (gapComposer2.changedInstance(function0) ? 256 : 128) | (gapComposer2.changed(focusRequester) ? 2048 : 1024) | (gapComposer2.changedInstance(function3) ? 16384 : 8192) | 196608;
        if ((74899 & i2) == 74898 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            gapComposer2.startReplaceGroup(-1250241294);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
            if (objRememberedValue3 == neverEqualPolicy2) {
                objRememberedValue3 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            gapComposer2.end(false);
            State stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac((((Boolean) mutableState2.getValue()).booleanValue() || z) ? appColors.textPrimary : appColors.textSecondary, ArcSplineKt.spring$default(0.0f, 1500.0f, null, 5), "tab-text", gapComposer2, 432, 8);
            State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(((Boolean) mutableState2.getValue()).booleanValue() ? 1.05f : 1.0f, ArcSplineKt.spring$default(0.75f, 1500.0f, null, 4), "tab-scale", gapComposer2, 3120);
            gapComposer2.startReplaceGroup(-1250219681);
            boolean z3 = (57344 & i2) == 16384;
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (z3) {
                neverEqualPolicy = neverEqualPolicy2;
            } else {
                neverEqualPolicy = neverEqualPolicy2;
                if (objRememberedValue4 == neverEqualPolicy) {
                }
                gapComposer2.end(false);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(companion, (Function1) objRememberedValue4);
                gapComposer2.startReplaceGroup(-1250211229);
                if ((i2 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = gapComposer2.rememberedValue();
                if (!z2 || objRememberedValue == neverEqualPolicy) {
                    mutableState = mutableState2;
                    objRememberedValue = new TvGlassTabRowKt$$ExternalSyntheticLambda6(function0, mutableState);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                } else {
                    mutableState = mutableState2;
                }
                gapComposer2.end(false);
                Modifier modifierFocusable = ImageKt.focusable(FocusTraversalKt.focusRequester(FocusTraversalKt.onFocusChanged(modifierOnGloballyPositioned, (Function1) objRememberedValue), focusRequester), true, null);
                gapComposer2.startReplaceGroup(-1250204483);
                zChanged = gapComposer2.changed(stateAnimateFloatAsState);
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new TvGlassTabRowKt$$ExternalSyntheticLambda7(stateAnimateFloatAsState, 0);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                gapComposer2.end(false);
                Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(BrushKt.graphicsLayer(modifierFocusable, (Function1) objRememberedValue2), 18, 6);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                long j = gapComposer2.compositeKeyHashCode;
                int i3 = (int) (j ^ (j >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN4);
                ComposeUiNode.Companion.getClass();
                layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                long j2 = ((Color) stateM26animateColorAsStateeuL9pac.getValue()).value;
                long sp = TextUnitKt.getSp(14);
                if (!((Boolean) mutableState.getValue()).booleanValue() || z) {
                    fontWeight = FontWeight.SemiBold;
                } else {
                    fontWeight = FontWeight.Normal;
                }
                TextKt.m275TextNvy7gAk(str, null, j2, sp, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, (i2 & 14) | 24576, 0, 262058);
                gapComposer2 = gapComposer;
                gapComposer2.end(true);
                modifier2 = companion;
            }
            objRememberedValue4 = new TvGlassTabRowKt$$ExternalSyntheticLambda5(function3, 0);
            gapComposer2.updateRememberedValue(objRememberedValue4);
            gapComposer2.end(false);
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierOnGloballyPositioned2 = RulerKt.onGloballyPositioned(companion2, (Function1) objRememberedValue4);
            gapComposer2.startReplaceGroup(-1250211229);
            if ((i2 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = gapComposer2.rememberedValue();
            if (z2) {
                mutableState = mutableState2;
                objRememberedValue = new TvGlassTabRowKt$$ExternalSyntheticLambda6(function0, mutableState);
                gapComposer2.updateRememberedValue(objRememberedValue);
            } else {
                mutableState = mutableState2;
                objRememberedValue = new TvGlassTabRowKt$$ExternalSyntheticLambda6(function0, mutableState);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            gapComposer2.end(false);
            Modifier modifierFocusable2 = ImageKt.focusable(FocusTraversalKt.focusRequester(FocusTraversalKt.onFocusChanged(modifierOnGloballyPositioned2, (Function1) objRememberedValue), focusRequester), true, null);
            gapComposer2.startReplaceGroup(-1250204483);
            zChanged = gapComposer2.changed(stateAnimateFloatAsState);
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new TvGlassTabRowKt$$ExternalSyntheticLambda7(stateAnimateFloatAsState, 0);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new TvGlassTabRowKt$$ExternalSyntheticLambda7(stateAnimateFloatAsState, 0);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            gapComposer2.end(false);
            Modifier modifierM129paddingVpY3zN5 = OffsetKt.m129paddingVpY3zN4(BrushKt.graphicsLayer(modifierFocusable2, (Function1) objRememberedValue2), 18, 6);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN5);
            ComposeUiNode.Companion.getClass();
            layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            long j4 = ((Color) stateM26animateColorAsStateeuL9pac.getValue()).value;
            long sp2 = TextUnitKt.getSp(14);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                fontWeight = FontWeight.SemiBold;
            } else {
                fontWeight = FontWeight.SemiBold;
            }
            TextKt.m275TextNvy7gAk(str, null, j4, sp2, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, (i2 & 14) | 24576, 0, 262058);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            modifier2 = companion2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TvGlassTabRowKt$$ExternalSyntheticLambda8(str, z, function0, focusRequester, function3, modifier2, i);
        }
    }

    public static final void TvGlassTabRow(int i, List list, Function1 function1, Modifier modifier, HazeState hazeState, List list2, Function0 function0, Function0 function2, GapComposer gapComposer, int i2) {
        Object tvGlassTabRowKt$TvGlassTabRow$4$1;
        Animatable animatable;
        NeverEqualPolicy neverEqualPolicy;
        RoundedCornerShape roundedCornerShape;
        Animatable animatable2;
        MutableState mutableState;
        long jColor;
        GapComposer gapComposer2;
        Modifier modifierM48borderxT4_qwU;
        NeverEqualPolicy neverEqualPolicy2;
        boolean z;
        int i3;
        List list3;
        gapComposer.startRestartGroup(766950579);
        int i4 = i2 | (gapComposer.changed(i) ? 4 : 2) | (gapComposer.changedInstance(list) ? 32 : 16) | (gapComposer.changed(hazeState) ? 16384 : 8192) | (gapComposer.changedInstance(list2) ? 131072 : 65536) | (gapComposer.changedInstance(function0) ? 1048576 : 524288);
        if ((i4 & 4793491) == 4793490 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            i3 = i;
            list3 = list2;
            gapComposer2 = gapComposer;
        } else {
            gapComposer.startDefaults();
            if ((i2 & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(18);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(14);
            gapComposer.startReplaceGroup(1563015532);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy3 = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy3) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            Object objM = Density.CC.m(1563017366, gapComposer, false);
            if (objM == neverEqualPolicy3) {
                objM = new SnapshotStateMap();
                gapComposer.updateRememberedValue(objM);
            }
            SnapshotStateMap snapshotStateMap = (SnapshotStateMap) objM;
            Object objM2 = Density.CC.m(1563019446, gapComposer, false);
            if (objM2 == neverEqualPolicy3) {
                objM2 = new SnapshotStateMap();
                gapComposer.updateRememberedValue(objM2);
            }
            SnapshotStateMap snapshotStateMap2 = (SnapshotStateMap) objM2;
            Object objM3 = Density.CC.m(1563021550, gapComposer, false);
            if (objM3 == neverEqualPolicy3) {
                objM3 = new ParcelableSnapshotMutableFloatState(0.0f);
                gapComposer.updateRememberedValue(objM3);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) objM3;
            Object objM4 = Density.CC.m(1563023589, gapComposer, false);
            if (objM4 == neverEqualPolicy3) {
                objM4 = ArcSplineKt.Animatable$default(0.0f);
                gapComposer.updateRememberedValue(objM4);
            }
            Animatable animatable3 = (Animatable) objM4;
            Object objM5 = Density.CC.m(1563025285, gapComposer, false);
            if (objM5 == neverEqualPolicy3) {
                objM5 = ArcSplineKt.Animatable$default(0.0f);
                gapComposer.updateRememberedValue(objM5);
            }
            Animatable animatable4 = (Animatable) objM5;
            Object objM6 = Density.CC.m(1563026987, gapComposer, false);
            if (objM6 == neverEqualPolicy3) {
                objM6 = Stack.mutableStateOf$default(Boolean.TRUE);
                gapComposer.updateRememberedValue(objM6);
            }
            MutableState mutableState3 = (MutableState) objM6;
            gapComposer.end(false);
            SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(0.8f, 700.0f, null, 4);
            Integer numValueOf = Integer.valueOf(i);
            gapComposer.startReplaceGroup(1563033133);
            boolean zChangedInstance = ((i4 & 14) == 4) | gapComposer.changedInstance(animatable3) | gapComposer.changedInstance(animatable4);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy3) {
                animatable = animatable3;
                neverEqualPolicy = neverEqualPolicy3;
                roundedCornerShape = roundedCornerShapeM158RoundedCornerShape0680j_4;
                tvGlassTabRowKt$TvGlassTabRow$4$1 = new TvGlassTabRowKt$TvGlassTabRow$4$1(snapshotStateMap, i, snapshotStateMap2, animatable, animatable4, mutableState3, springSpecSpring$default, (Continuation) null);
                animatable2 = animatable4;
                mutableState = mutableState2;
                snapshotStateMap = snapshotStateMap;
                gapComposer.updateRememberedValue(tvGlassTabRowKt$TvGlassTabRow$4$1);
            } else {
                animatable2 = animatable4;
                roundedCornerShape = roundedCornerShapeM158RoundedCornerShape0680j_4;
                neverEqualPolicy = neverEqualPolicy3;
                animatable = animatable3;
                tvGlassTabRowKt$TvGlassTabRow$4$1 = objRememberedValue2;
                mutableState = mutableState2;
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, numValueOf, (Function2) tvGlassTabRowKt$TvGlassTabRow$4$1);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                long j = appColors.buttonActiveStart;
                jColor = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.25f, Color.m438getColorSpaceimpl(j));
            } else {
                long j2 = r25.buttonActiveStart;
                jColor = BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.12f, Color.m438getColorSpaceimpl(j2));
            }
            Animatable animatable5 = animatable;
            State stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(jColor, ArcSplineKt.spring$default(0.0f, 1500.0f, null, 5), "indicator-bg", gapComposer, 432, 8);
            gapComposer2 = gapComposer;
            State stateM26animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(((Boolean) mutableState.getValue()).booleanValue() ? r25.buttonActiveStart : r25.accentBorder, ArcSplineKt.spring$default(0.0f, 1500.0f, null, 5), "indicator-border", gapComposer2, 432, 8);
            State stateM27animateDpAsStateAjpBEmI = AnimateAsStateKt.m27animateDpAsStateAjpBEmI(((Boolean) mutableState.getValue()).booleanValue() ? 2 : 1, ArcSplineKt.spring$default(0.0f, 1500.0f, null, 5), gapComposer2, 432, 8);
            gapComposer2.startReplaceGroup(1563078436);
            boolean z2 = (i4 & 3670016) == 1048576;
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy4 = neverEqualPolicy;
            if (z2 || objRememberedValue3 == neverEqualPolicy4) {
                objRememberedValue3 = new LifecycleEffectKt$$ExternalSyntheticLambda1(function0, function2, mutableState, 22);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            gapComposer2.end(false);
            Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifier, (Function1) objRememberedValue3);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i5 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierOnFocusChanged);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf2 = Integer.valueOf(i5);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf2, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            gapComposer2.startReplaceGroup(429771980);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (hazeState != null) {
                RoundedCornerShape roundedCornerShape2 = roundedCornerShape;
                modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(1, r25.cardBorder, ClipKt.clip(companion, roundedCornerShape2).then(new HazeEffectNodeElement(hazeState, BackHandlerKt.m5hazeMaterialek8zF_U(0.35f, 0.55f, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface))), roundedCornerShape2);
            } else {
                RoundedCornerShape roundedCornerShape3 = roundedCornerShape;
                modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(1, r25.cardBorder, ClipKt.clip(companion, roundedCornerShape3), roundedCornerShape3);
            }
            gapComposer2.end(false);
            Modifier modifierM128padding3ABfNKs = OffsetKt.m128padding3ABfNKs(modifierM48borderxT4_qwU, 4);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j4 = gapComposer2.compositeKeyHashCode;
            int i6 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM128padding3ABfNKs);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            gapComposer2.startReplaceGroup(733574145);
            if (((Number) animatable2.getValue()).floatValue() > 0.0f) {
                gapComposer2.startReplaceGroup(733577712);
                boolean zChangedInstance2 = gapComposer2.changedInstance(animatable5);
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy2) {
                    neverEqualPolicy2 = neverEqualPolicy4;
                    objRememberedValue4 = new TvGlassTabRowKt$$ExternalSyntheticLambda1(animatable5, 0);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                gapComposer2.end(false);
                Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(ClipKt.clip(BrushKt.graphicsLayer(companion, (Function1) objRememberedValue4).then(SizeKt.m141sizeVpY3zN4(companion, density.mo88toDpu2uoSUM(((Number) animatable2.getValue()).floatValue()), density.mo88toDpu2uoSUM(parcelableSnapshotMutableFloatState.getFloatValue()))), roundedCornerShapeM158RoundedCornerShape0680j_5), ((Color) stateM26animateColorAsStateeuL9pac.getValue()).value, BrushKt.RectangleShape);
                z = false;
                BoxKt.Box(ImageKt.m48borderxT4_qwU(((Dp) stateM27animateDpAsStateAjpBEmI.getValue()).value, ((Color) stateM26animateColorAsStateeuL9pac2.getValue()).value, modifierM47backgroundbw27NRU, roundedCornerShapeM158RoundedCornerShape0680j_5), gapComposer2, 0);
            } else {
                neverEqualPolicy2 = neverEqualPolicy4;
                z = false;
            }
            gapComposer2.end(z);
            Modifier modifierFocusGroup = ImageKt.focusGroup(companion);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Center, Alignment.Companion.CenterVertically, gapComposer2, 54);
            long j5 = gapComposer2.compositeKeyHashCode;
            int i7 = (int) (j5 ^ (j5 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierFocusGroup);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i7, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            gapComposer2.startReplaceGroup(-2028760577);
            int i8 = 0;
            for (Object obj : list) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    AppCompatHintHelper.throwIndexOverflow();
                    throw null;
                }
                String str = (String) obj;
                boolean z3 = i8 == i;
                gapComposer2.startReplaceGroup(-1398716354);
                boolean zChanged = gapComposer2.changed(i8);
                Object objRememberedValue5 = gapComposer2.rememberedValue();
                if (zChanged || objRememberedValue5 == neverEqualPolicy2) {
                    objRememberedValue5 = new TvGlassTabRowKt$$ExternalSyntheticLambda2(i8, 0, function1);
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                Function0 function3 = (Function0) objRememberedValue5;
                gapComposer2.end(false);
                FocusRequester focusRequester = (FocusRequester) list2.get(i8);
                gapComposer2.startReplaceGroup(-1398711958);
                boolean zChanged2 = gapComposer2.changed(i8);
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue6 == neverEqualPolicy2) {
                    objRememberedValue6 = new TvGlassTabRowKt$$ExternalSyntheticLambda3(snapshotStateMap, i8, snapshotStateMap2, parcelableSnapshotMutableFloatState, 0);
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                gapComposer2.end(false);
                TvGlassTab(str, z3, function3, focusRequester, (Function3) objRememberedValue6, null, gapComposer, 0);
                gapComposer2 = gapComposer;
                i8 = i9;
            }
            i3 = i;
            list3 = list2;
            gapComposer2.end(false);
            gapComposer2.end(true);
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ScaffoldKt$$ExternalSyntheticLambda8(i3, list, function1, modifier, hazeState, list3, function0, function2, i2);
        }
    }
}
