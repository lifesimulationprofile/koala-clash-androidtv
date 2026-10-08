package com.google.android.gms.internal.mlkit_vision_common;

import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda1;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.FocusInteractionKt$collectIsFocusedAsState$1$1;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import com.github.kr328.clash.compose.PropertiesScreenKt$$ExternalSyntheticLambda17;
import com.github.kr328.clash.compose.ProvidersScreenKt$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda3;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda5;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda7;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$TvGlassTabRow$4$1;
import com.github.kr328.clash.design.compose.components.LiquidGlassNavItem;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeState;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjm {
    public static final void LiquidGlassNavBar(List list, String str, Function1 function1, Modifier modifier, HazeState hazeState, GapComposer gapComposer, int i) {
        char c;
        Animatable animatable;
        Density density;
        Modifier modifierM47backgroundbw27NRU;
        Modifier modifier2;
        boolean z;
        String str2;
        Function1 function2;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-624775087);
        char c2 = ' ';
        int i2 = i | (gapComposer2.changedInstance(list) ? 4 : 2) | (gapComposer2.changed(str) ? 32 : 16) | (gapComposer2.changedInstance(function1) ? 256 : 128) | 3072 | (gapComposer2.changed(hazeState) ? 16384 : 8192);
        if ((i2 & 9363) == 9362 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            modifier2 = modifier;
            function2 = function1;
            str2 = str;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            Density density2 = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(32);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(26);
            Iterator it = list.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    c = c2;
                    i3 = -1;
                    break;
                } else {
                    c = c2;
                    if (((LiquidGlassNavItem) it.next()).key.equals(str)) {
                        break;
                    }
                    i3++;
                    c2 = c;
                }
            }
            gapComposer2.startReplaceGroup(1654993397);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new SnapshotStateMap();
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            SnapshotStateMap snapshotStateMap = (SnapshotStateMap) objRememberedValue;
            Object objM = Density.CC.m(1654995509, gapComposer2, false);
            if (objM == neverEqualPolicy) {
                objM = new SnapshotStateMap();
                gapComposer2.updateRememberedValue(objM);
            }
            SnapshotStateMap snapshotStateMap2 = (SnapshotStateMap) objM;
            Object objM2 = Density.CC.m(1654997645, gapComposer2, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = new ParcelableSnapshotMutableFloatState(0.0f);
                gapComposer2.updateRememberedValue(objM2);
            }
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = (ParcelableSnapshotMutableFloatState) objM2;
            Object objM3 = Density.CC.m(1654999684, gapComposer2, false);
            if (objM3 == neverEqualPolicy) {
                objM3 = ArcSplineKt.Animatable$default(0.0f);
                gapComposer2.updateRememberedValue(objM3);
            }
            Animatable animatable2 = (Animatable) objM3;
            Object objM4 = Density.CC.m(1655001380, gapComposer2, false);
            if (objM4 == neverEqualPolicy) {
                objM4 = ArcSplineKt.Animatable$default(0.0f);
                gapComposer2.updateRememberedValue(objM4);
            }
            Animatable animatable3 = (Animatable) objM4;
            Object objM5 = Density.CC.m(1655003082, gapComposer2, false);
            if (objM5 == neverEqualPolicy) {
                objM5 = Stack.mutableStateOf$default(Boolean.TRUE);
                gapComposer2.updateRememberedValue(objM5);
            }
            MutableState mutableState = (MutableState) objM5;
            gapComposer2.end(false);
            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState3 = parcelableSnapshotMutableFloatState2;
            SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(0.8f, 700.0f, null, 4);
            Integer numValueOf = Integer.valueOf(i3);
            gapComposer2.startReplaceGroup(1655009178);
            boolean zChanged = gapComposer2.changed(i3) | gapComposer2.changedInstance(animatable2) | gapComposer2.changedInstance(animatable3);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                animatable = animatable3;
                objRememberedValue2 = new TvGlassTabRowKt$TvGlassTabRow$4$1(i3, snapshotStateMap, snapshotStateMap2, animatable2, animatable, mutableState, springSpecSpring$default, (Continuation) null);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                animatable = animatable3;
            }
            gapComposer2.end(false);
            Stack.LaunchedEffect(gapComposer2, numValueOf, (Function2) objRememberedValue2);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(OffsetKt.windowInsetsPadding(modifierFillMaxWidth, FlowRowOverflow.current(gapComposer2).navigationBars), 75, 10);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j ^ (j >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN4);
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
            Integer numValueOf2 = Integer.valueOf(i4);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf2, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            long j2 = Color.Black;
            Modifier modifierClip = ClipKt.clip(ClipKt.m338shadows4CzXII$default(SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 64), 18, roundedCornerShapeM158RoundedCornerShape0680j_4, BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.18f, Color.m438getColorSpaceimpl(j2)), BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.24f, Color.m438getColorSpaceimpl(j2)), 4), roundedCornerShapeM158RoundedCornerShape0680j_4);
            gapComposer2.startReplaceGroup(-1669249493);
            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = BrushKt.RectangleShape;
            if (hazeState != null) {
                modifierM47backgroundbw27NRU = modifierClip.then(new HazeEffectNodeElement(hazeState, BackHandlerKt.m6thinIv8Zu3U(gapComposer2)));
                density = density2;
            } else {
                density = density2;
                modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(modifierClip, appColors.cardBackground, rectangleShapeKt$RectangleShape$1);
            }
            gapComposer2.end(false);
            float f = 1;
            float f2 = 6;
            Modifier modifierM129paddingVpY3zN5 = OffsetKt.m129paddingVpY3zN4(ImageKt.m48borderxT4_qwU(f, appColors.cardBorder, modifierM47backgroundbw27NRU, roundedCornerShapeM158RoundedCornerShape0680j_4), f2, f2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i5 = (int) (j3 ^ (j3 >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN5);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i5, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            gapComposer2.startReplaceGroup(-295506672);
            if (((Number) animatable.getValue()).floatValue() > 0.0f) {
                gapComposer2.startReplaceGroup(-295503121);
                boolean zChangedInstance = gapComposer2.changedInstance(animatable2);
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new TvGlassTabRowKt$$ExternalSyntheticLambda1(animatable2, 2);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                gapComposer2.end(false);
                modifier2 = companion;
                Modifier modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(f, appColors.accentBorder, ImageKt.m47backgroundbw27NRU(ClipKt.clip(BrushKt.graphicsLayer(modifier2, (Function1) objRememberedValue3).then(SizeKt.m141sizeVpY3zN4(modifier2, density.mo88toDpu2uoSUM(((Number) animatable.getValue()).floatValue()), density.mo88toDpu2uoSUM(parcelableSnapshotMutableFloatState3.getFloatValue()))), roundedCornerShapeM158RoundedCornerShape0680j_5), appColors.accentFill, rectangleShapeKt$RectangleShape$1), roundedCornerShapeM158RoundedCornerShape0680j_5);
                z = false;
                BoxKt.Box(modifierM48borderxT4_qwU, gapComposer2, 0);
            } else {
                modifier2 = companion;
                z = false;
            }
            gapComposer2.end(z);
            Modifier modifierThen = SizeKt.fillMaxWidth(modifier2, 1.0f).then(SizeKt.FillWholeMaxHeight);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j4 = gapComposer2.compositeKeyHashCode;
            int i6 = (int) (j4 ^ (j4 >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierThen);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            gapComposer2.startReplaceGroup(-314519251);
            int i7 = 0;
            for (Object obj : list) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    AppCompatHintHelper.throwIndexOverflow();
                    throw null;
                }
                LiquidGlassNavItem liquidGlassNavItem = (LiquidGlassNavItem) obj;
                boolean zEquals = liquidGlassNavItem.key.equals(str);
                gapComposer2.startReplaceGroup(-1418717605);
                int i9 = i2;
                boolean zChanged2 = ((i9 & 896) == 256) | gapComposer2.changed(liquidGlassNavItem);
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new Recomposer$$ExternalSyntheticLambda6(27, function1, liquidGlassNavItem);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                Function0 function0 = (Function0) objRememberedValue4;
                gapComposer2.end(false);
                gapComposer2.startReplaceGroup(-1418715443);
                boolean zChanged3 = gapComposer2.changed(i7);
                Object objRememberedValue5 = gapComposer2.rememberedValue();
                if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                    SnapshotStateMap snapshotStateMap3 = snapshotStateMap;
                    parcelableSnapshotMutableFloatState = parcelableSnapshotMutableFloatState3;
                    objRememberedValue5 = new TvGlassTabRowKt$$ExternalSyntheticLambda3(snapshotStateMap3, i7, snapshotStateMap2, parcelableSnapshotMutableFloatState, 1);
                    snapshotStateMap = snapshotStateMap3;
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                } else {
                    parcelableSnapshotMutableFloatState = parcelableSnapshotMutableFloatState3;
                }
                Function3 function3 = (Function3) objRememberedValue5;
                gapComposer2.end(false);
                if (1.0f <= 0.0d) {
                    InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                }
                gapComposer2 = gapComposer;
                LiquidGlassNavCell(liquidGlassNavItem, zEquals, function0, function3, new LayoutWeightElement(1.0f, true).then(SizeKt.FillWholeMaxHeight), gapComposer2, 0);
                i2 = i9;
                i7 = i8;
                neverEqualPolicy = neverEqualPolicy;
                parcelableSnapshotMutableFloatState3 = parcelableSnapshotMutableFloatState;
            }
            str2 = str;
            function2 = function1;
            gapComposer2.end(false);
            gapComposer2.end(true);
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProvidersScreenKt$$ExternalSyntheticLambda0(list, str2, function2, modifier2, hazeState, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0147  */
    /* JADX WARN: Code duplicated, block: B:59:0x0149  */
    /* JADX WARN: Code duplicated, block: B:63:0x0153  */
    /* JADX WARN: Code duplicated, block: B:66:0x017d  */
    /* JADX WARN: Code duplicated, block: B:67:0x017f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0185  */
    /* JADX WARN: Code duplicated, block: B:71:0x0187  */
    /* JADX WARN: Code duplicated, block: B:75:0x0191  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:83:0x0209  */
    public static final void LiquidGlassNavCell(LiquidGlassNavItem liquidGlassNavItem, boolean z, Function0 function0, Function3 function3, Modifier modifier, GapComposer gapComposer, int i) {
        NeverEqualPolicy neverEqualPolicy;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        boolean z4;
        boolean z5;
        boolean z6;
        Object objRememberedValue2;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        boolean zChanged;
        Object objRememberedValue3;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1362029876);
        int i2 = i | (gapComposer2.changed(liquidGlassNavItem) ? 4 : 2) | (gapComposer2.changed(z) ? 32 : 16) | (gapComposer2.changedInstance(function0) ? 256 : 128) | (gapComposer2.changedInstance(function3) ? 2048 : 1024) | (gapComposer2.changed(modifier) ? 16384 : 8192);
        if ((i2 & 9363) == 9362 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            HapticFeedback hapticFeedback = (HapticFeedback) gapComposer2.consume(CompositionLocalsKt.LocalHapticFeedback);
            gapComposer2.startReplaceGroup(-205738029);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
            if (objRememberedValue4 == neverEqualPolicy2) {
                objRememberedValue4 = new MutableInteractionSourceImpl();
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue4;
            gapComposer2.end(false);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy2) {
                objRememberedValue5 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            MutableState mutableState = (MutableState) objRememberedValue5;
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy2) {
                objRememberedValue6 = new FocusInteractionKt$collectIsFocusedAsState$1$1(mutableInteractionSourceImpl, mutableState, null, 1);
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            Stack.LaunchedEffect(gapComposer2, mutableInteractionSourceImpl, (Function2) objRememberedValue6);
            State stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(z ? appColors.textPrimary : appColors.textSecondary, ArcSplineKt.tween$default(250, 6, null), "nav-icon-color", gapComposer2, 432, 8);
            State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(((Boolean) mutableState.getValue()).booleanValue() ? 0.94f : 1.0f, ArcSplineKt.spring$default(1.0f, 1500.0f, null, 4), "nav-icon-press-scale", gapComposer2, 3120);
            float f = 26;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f);
            gapComposer2.startReplaceGroup(-205714789);
            boolean z7 = (i2 & 7168) == 2048;
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (z7) {
                neverEqualPolicy = neverEqualPolicy2;
            } else {
                if (objRememberedValue7 == neverEqualPolicy) {
                }
                neverEqualPolicy = neverEqualPolicy2;
                gapComposer2.end(false);
                Modifier modifierClip = ClipKt.clip(RulerKt.onGloballyPositioned(modifier, (Function1) objRememberedValue7), roundedCornerShapeM158RoundedCornerShape0680j_4);
                gapComposer2.startReplaceGroup(-205702400);
                boolean zChangedInstance = gapComposer2.changedInstance(hapticFeedback);
                if ((i2 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = zChangedInstance | z2;
                objRememberedValue = gapComposer2.rememberedValue();
                if (z3 || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new Recomposer$$ExternalSyntheticLambda6(28, hapticFeedback, function0);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                gapComposer2.end(false);
                Modifier modifierM50clickableO2vRcR0$default = ImageKt.m50clickableO2vRcR0$default(modifierClip, mutableInteractionSourceImpl, null, false, null, (Function0) objRememberedValue, 28);
                gapComposer2.startReplaceGroup(-205697890);
                if ((i2 & 112) == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if ((i2 & 14) == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z5 | z4;
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (z6 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new BackHandlerKt$$ExternalSyntheticLambda1(4, liquidGlassNavItem, z);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                gapComposer2.end(false);
                Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM50clickableO2vRcR0$default, false, (Function1) objRememberedValue2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                long j = gapComposer2.compositeKeyHashCode;
                int i3 = (int) (j ^ (j >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierSemantics);
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
                ImageVector imageVector = liquidGlassNavItem.icon;
                long j2 = ((Color) stateM26animateColorAsStateeuL9pac.getValue()).value;
                gapComposer2.startReplaceGroup(-1469645714);
                zChanged = gapComposer2.changed(stateAnimateFloatAsState);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new TvGlassTabRowKt$$ExternalSyntheticLambda7(stateAnimateFloatAsState, 2);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                gapComposer2.end(false);
                IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(BrushKt.graphicsLayer(Modifier.Companion.$$INSTANCE, (Function1) objRememberedValue3), f), j2, gapComposer, 48, 0);
                gapComposer2 = gapComposer;
                gapComposer2.end(true);
            }
            neverEqualPolicy = neverEqualPolicy2;
            objRememberedValue7 = new TvGlassTabRowKt$$ExternalSyntheticLambda5(function3, 1);
            gapComposer2.updateRememberedValue(objRememberedValue7);
            neverEqualPolicy = neverEqualPolicy2;
            gapComposer2.end(false);
            Modifier modifierClip2 = ClipKt.clip(RulerKt.onGloballyPositioned(modifier, (Function1) objRememberedValue7), roundedCornerShapeM158RoundedCornerShape0680j_4);
            gapComposer2.startReplaceGroup(-205702400);
            boolean zChangedInstance2 = gapComposer2.changedInstance(hapticFeedback);
            if ((i2 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = zChangedInstance2 | z2;
            objRememberedValue = gapComposer2.rememberedValue();
            if (z3) {
                objRememberedValue = new Recomposer$$ExternalSyntheticLambda6(28, hapticFeedback, function0);
                gapComposer2.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Recomposer$$ExternalSyntheticLambda6(28, hapticFeedback, function0);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            gapComposer2.end(false);
            Modifier modifierM50clickableO2vRcR0$default2 = ImageKt.m50clickableO2vRcR0$default(modifierClip2, mutableInteractionSourceImpl, null, false, null, (Function0) objRememberedValue, 28);
            gapComposer2.startReplaceGroup(-205697890);
            if ((i2 & 112) == 32) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((i2 & 14) == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = z5 | z4;
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (z6) {
                objRememberedValue2 = new BackHandlerKt$$ExternalSyntheticLambda1(4, liquidGlassNavItem, z);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new BackHandlerKt$$ExternalSyntheticLambda1(4, liquidGlassNavItem, z);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            gapComposer2.end(false);
            Modifier modifierSemantics2 = SemanticsModifierKt.semantics(modifierM50clickableO2vRcR0$default2, false, (Function1) objRememberedValue2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierSemantics2);
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
            ImageVector imageVector2 = liquidGlassNavItem.icon;
            long j4 = ((Color) stateM26animateColorAsStateeuL9pac.getValue()).value;
            gapComposer2.startReplaceGroup(-1469645714);
            zChanged = gapComposer2.changed(stateAnimateFloatAsState);
            objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new TvGlassTabRowKt$$ExternalSyntheticLambda7(stateAnimateFloatAsState, 2);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new TvGlassTabRowKt$$ExternalSyntheticLambda7(stateAnimateFloatAsState, 2);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            gapComposer2.end(false);
            IconKt.m249Iconww6aTOc(imageVector2, null, SizeKt.m140size3ABfNKs(BrushKt.graphicsLayer(Modifier.Companion.$$INSTANCE, (Function1) objRememberedValue3), f), j4, gapComposer, 48, 0);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PropertiesScreenKt$$ExternalSyntheticLambda17(liquidGlassNavItem, z, function0, function3, modifier, i);
        }
    }
}
