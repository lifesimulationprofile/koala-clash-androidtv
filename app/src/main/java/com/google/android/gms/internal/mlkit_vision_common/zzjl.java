package com.google.android.gms.internal.mlkit_vision_common;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjl;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeState;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjl {
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:57:0x0104  */
    /* JADX WARN: Code duplicated, block: B:58:0x0108  */
    /* JADX WARN: Code duplicated, block: B:62:0x013d  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: GlassSurface-YxtnGt4, reason: not valid java name */
    public static final void m819GlassSurfaceYxtnGt4(Modifier modifier, float f, HazeState hazeState, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        final HazeState hazeState2;
        final Modifier modifier3;
        HazeState hazeState3;
        AppColors appColors;
        long j;
        RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4;
        char c;
        Modifier modifierM48borderxT4_qwU;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i4;
        gapComposer.startRestartGroup(1686515092);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (gapComposer.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            f2 = f;
            i3 |= gapComposer.changed(f2) ? 32 : 16;
        } else {
            f2 = f;
        }
        int i6 = i3 | 3456;
        int i7 = i2 & 16;
        if (i7 == 0) {
            if ((i & 24576) == 0) {
                hazeState2 = hazeState;
                i6 |= gapComposer.changed(hazeState2) ? 16384 : 8192;
            }
            if ((196608 & i) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i6 |= i4;
            }
            if ((74899 & i6) == 74898 || !gapComposer.getSkipping()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i7 != 0) {
                    hazeState3 = null;
                } else {
                    hazeState3 = hazeState2;
                }
                appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                j = appColors.cardBorder;
                roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2);
                gapComposer.startReplaceGroup(1886128232);
                if (hazeState3 != null) {
                    c = ' ';
                    modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(1, j, ClipKt.clip(modifier3, roundedCornerShapeM158RoundedCornerShape0680j_4).then(new HazeEffectNodeElement(hazeState3, BackHandlerKt.m5hazeMaterialek8zF_U(0.35f, 0.55f, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface))), roundedCornerShapeM158RoundedCornerShape0680j_4);
                } else {
                    c = ' ';
                    modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(1, j, ImageKt.m47backgroundbw27NRU(ClipKt.clip(modifier3, roundedCornerShapeM158RoundedCornerShape0680j_4), appColors.cardBackground, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4);
                }
                gapComposer.end(false);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                long j2 = gapComposer.compositeKeyHashCode;
                int i8 = (int) (j2 ^ (j2 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM48borderxT4_qwU);
                ComposeUiNode.Companion.getClass();
                layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer.useNode();
                }
                Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m295setimpl(gapComposer, Integer.valueOf(i8), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                composableLambdaImpl.invoke(gapComposer, Integer.valueOf((i6 >> 15) & 14));
                gapComposer.end(true);
                hazeState2 = hazeState3;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final float f3 = f2;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.design.compose.components.GlassSurfaceKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        zzjl.m819GlassSurfaceYxtnGt4(modifier3, f3, hazeState2, composableLambdaImpl, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i6 = i3 | 28032;
        hazeState2 = hazeState;
        if ((196608 & i) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i6 |= i4;
        }
        if ((74899 & i6) == 74898) {
            if (i5 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i7 != 0) {
                hazeState3 = null;
            } else {
                hazeState3 = hazeState2;
            }
            appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            j = appColors.cardBorder;
            roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2);
            gapComposer.startReplaceGroup(1886128232);
            if (hazeState3 != null) {
                c = ' ';
                modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(1, j, ClipKt.clip(modifier3, roundedCornerShapeM158RoundedCornerShape0680j_4).then(new HazeEffectNodeElement(hazeState3, BackHandlerKt.m5hazeMaterialek8zF_U(0.35f, 0.55f, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface))), roundedCornerShapeM158RoundedCornerShape0680j_4);
            } else {
                c = ' ';
                modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(1, j, ImageKt.m47backgroundbw27NRU(ClipKt.clip(modifier3, roundedCornerShapeM158RoundedCornerShape0680j_4), appColors.cardBackground, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4);
            }
            gapComposer.end(false);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j3 = gapComposer.compositeKeyHashCode;
            int i9 = (int) (j3 ^ (j3 >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM48borderxT4_qwU);
            ComposeUiNode.Companion.getClass();
            layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i9), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke(gapComposer, Integer.valueOf((i6 >> 15) & 14));
            gapComposer.end(true);
            hazeState2 = hazeState3;
        } else {
            if (i5 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i7 != 0) {
                hazeState3 = null;
            } else {
                hazeState3 = hazeState2;
            }
            appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            j = appColors.cardBorder;
            roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2);
            gapComposer.startReplaceGroup(1886128232);
            if (hazeState3 != null) {
                c = ' ';
                modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(1, j, ClipKt.clip(modifier3, roundedCornerShapeM158RoundedCornerShape0680j_4).then(new HazeEffectNodeElement(hazeState3, BackHandlerKt.m5hazeMaterialek8zF_U(0.35f, 0.55f, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface))), roundedCornerShapeM158RoundedCornerShape0680j_4);
            } else {
                c = ' ';
                modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(1, j, ImageKt.m47backgroundbw27NRU(ClipKt.clip(modifier3, roundedCornerShapeM158RoundedCornerShape0680j_4), appColors.cardBackground, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4);
            }
            gapComposer.end(false);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j4 = gapComposer.compositeKeyHashCode;
            int i10 = (int) (j4 ^ (j4 >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM48borderxT4_qwU);
            ComposeUiNode.Companion.getClass();
            layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i10), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke(gapComposer, Integer.valueOf((i6 >> 15) & 14));
            gapComposer.end(true);
            hazeState2 = hazeState3;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final float f4 = f2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.design.compose.components.GlassSurfaceKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    zzjl.m819GlassSurfaceYxtnGt4(modifier3, f4, hazeState2, composableLambdaImpl, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
