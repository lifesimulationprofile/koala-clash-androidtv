package com.github.kr328.clash.compose.proxy;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.Quirks;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.BackgroundElement;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9;
import androidx.compose.material.icons.filled.LanKt;
import androidx.compose.material.icons.filled.SpeedKt;
import androidx.compose.material.icons.outlined.InboxKt;
import androidx.compose.material.icons.outlined.WarningAmberKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnitKt;
import coil.compose.AsyncImageKt;
import coil.compose.AsyncImageKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda10;
import com.github.kr328.clash.compose.FilesScreenKt$$ExternalSyntheticLambda4;
import com.github.kr328.clash.compose.HwidLimitDialogKt$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.core.model.Proxy;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProxyScreenKt {
    public static final void CenterMessage(ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-2137870880);
        if ((i & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer.compositeKeyHashCode;
            int i2 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, fillElement);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke((Object) gapComposer, (Object) 6);
            gapComposer.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FlowLayoutKt$$ExternalSyntheticLambda0(composableLambdaImpl, i, 4);
        }
    }

    public static final void EmptyMessage(ImageVector imageVector, String str, GapComposer gapComposer, int i) {
        String str2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-2024548072);
        int i2 = i | (gapComposer2.changed(imageVector) ? 4 : 2) | (gapComposer2.changed(str) ? 32 : 16);
        if ((i2 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            str2 = str;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(12);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM128padding3ABfNKs = OffsetKt.m128padding3ABfNKs(companion, 32);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spacedAlignedM111spacedBy0680j_4, horizontal, gapComposer2, 54);
            long j = gapComposer2.compositeKeyHashCode;
            int i3 = (int) ((j >>> 32) ^ j);
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM128padding3ABfNKs);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(companion, 48), appColors.textSecondary, gapComposer2, (i2 & 14) | 432, 0);
            str2 = str;
            TextKt.m275TextNvy7gAk(str2, null, appColors.textSecondary, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer, (i2 >> 3) & 14, 0, 130042);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 26, imageVector, str2);
        }
    }

    public static final void ErrorContent(String str, Function0 function0, GapComposer gapComposer, int i) {
        int i2;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        int i3;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(734267679);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer2.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2;
        if ((i4 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            i3 = 1;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer2.compositeKeyHashCode;
            int i5 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, fillElement);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$2);
            } else {
                gapComposer2.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i5);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(16);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM128padding3ABfNKs = OffsetKt.m128padding3ABfNKs(companion, 32);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spacedAlignedM111spacedBy0680j_4, horizontal, gapComposer2, 54);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i6 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM128padding3ABfNKs);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$2;
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$2;
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            ImageVector imageVectorBuild = WarningAmberKt._warningAmber;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder = new ImageVector.Builder("Outlined.WarningAmber", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i7 = VectorKt.$r8$clinit;
                SolidColor solidColor = new SolidColor(Color.Black);
                Quirks quirks = new Quirks();
                quirks.moveTo(12.0f, 5.99f);
                quirks.lineTo(19.53f, 19.0f);
                quirks.lineTo(4.47f, 19.0f);
                quirks.lineTo(12.0f, 5.99f);
                quirks.moveTo(12.0f, 2.0f);
                quirks.lineTo(1.0f, 21.0f);
                quirks.horizontalLineToRelative(22.0f);
                quirks.lineTo(12.0f, 2.0f);
                quirks.close();
                quirks.moveTo(13.0f, 16.0f);
                quirks.horizontalLineToRelative(-2.0f);
                quirks.verticalLineToRelative(2.0f);
                quirks.horizontalLineToRelative(2.0f);
                quirks.verticalLineToRelative(-2.0f);
                quirks.close();
                quirks.moveTo(13.0f, 10.0f);
                quirks.horizontalLineToRelative(-2.0f);
                quirks.verticalLineToRelative(4.0f);
                quirks.horizontalLineToRelative(2.0f);
                quirks.verticalLineToRelative(-4.0f);
                quirks.close();
                ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                imageVectorBuild = builder.build();
                WarningAmberKt._warningAmber = imageVectorBuild;
            }
            IconKt.m249Iconww6aTOc(imageVectorBuild, null, SizeKt.m140size3ABfNKs(companion, 48), appColors.textSecondary, gapComposer2, 432, 0);
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$3 = layoutNode$Companion$Constructor$1;
            TextKt.m275TextNvy7gAk(str, null, appColors.textPrimary, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer, i4 & 14, 0, 130042);
            float f = 12;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, appColors.accentBorder, ImageKt.m47backgroundbw27NRU(ClipKt.clip(companion, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f)), appColors.accentFill, BrushKt.RectangleShape), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f)), false, null, function0, 15), 24, f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j3 = gapComposer.compositeKeyHashCode;
            int i8 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM129paddingVpY3zN4);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$3);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i8, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.proxy_retry, gapComposer), null, appColors.textPrimary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 1572864, 0, 262074);
            gapComposer2 = gapComposer;
            i3 = 1;
            gapComposer2.end(true);
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HwidLimitDialogKt$$ExternalSyntheticLambda0(str, function0, i, i3);
        }
    }

    public static final void PingBadge(final int i, final boolean z, final boolean z2, final Function0 function0, GapComposer gapComposer, final int i2) {
        int i3;
        long jColor;
        FontWeight fontWeight;
        gapComposer.startRestartGroup(-1852164377);
        if ((i2 & 6) == 0) {
            i3 = (gapComposer.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            boolean z3 = 1 <= i && i < 30000;
            String strValueOf = "—";
            if (!z) {
                jColor = appColors.textSecondary;
                fontWeight = FontWeight.SemiBold;
            } else if (z3) {
                strValueOf = String.valueOf(i);
                jColor = appColors.textPrimary;
                fontWeight = FontWeight.Bold;
            } else {
                jColor = BrushKt.Color(4293212469L);
                fontWeight = FontWeight.SemiBold;
            }
            long j = jColor;
            FontWeight fontWeight2 = fontWeight;
            long j2 = z2 ? appColors.accentBorder : appColors.cardBorder;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
            TextKt.m275TextNvy7gAk(strValueOf, OffsetKt.m129paddingVpY3zN4(ImageKt.m48borderxT4_qwU(1, j2, ImageKt.m51clickableoSLSa3U$default(ClipKt.clip(Modifier.Companion.$$INSTANCE, roundedCornerShapeM158RoundedCornerShape0680j_4), false, null, function0, 15), roundedCornerShapeM158RoundedCornerShape0680j_4), 8, 2), j, 0L, null, fontWeight2, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 0, 0, 131000);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    ProxyScreenKt.PingBadge(i, z, z2, function0, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxyGroupCard(String str, String str2, boolean z, Function0 function0, GapComposer gapComposer, int i) {
        long jColor;
        AppColors appColors;
        boolean z2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(2031906996);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changed(str2) ? 32 : 16) | (gapComposer2.changed(z) ? 256 : 128) | (gapComposer2.changedInstance(function0) ? 2048 : 1024);
        if ((i2 & 1171) == 1170 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors2 = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(11);
            if (z) {
                jColor = appColors2.accentFill;
            } else {
                long j = appColors2.cardBackground;
                jColor = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.5f, Color.m438getColorSpaceimpl(j));
            }
            long j2 = z ? appColors2.accentBorder : appColors2.cardBorder;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            float f = 8;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, j2, ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.m135height3ABfNKs(SizeKt.m144width3ABfNKs(companion, 109), 76), roundedCornerShapeM158RoundedCornerShape0680j_4), jColor, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4), false, null, function0, 15), f, f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(6), Alignment.Companion.CenterHorizontally, gapComposer2, 54);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j3 ^ (j3 >>> 32));
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
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            if (str2 == null || StringsKt.isBlank(str2)) {
                gapComposer2.startReplaceGroup(1896515241);
                ImageVector imageVectorBuild = LanKt._lan;
                if (imageVectorBuild == null) {
                    ImageVector.Builder builder = new ImageVector.Builder("Filled.Lan", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i4 = VectorKt.$r8$clinit;
                    SolidColor solidColor = new SolidColor(Color.Black);
                    Quirks quirks = new Quirks();
                    quirks.moveTo(13.0f, 22.0f);
                    quirks.lineToRelative(8.0f, 0.0f);
                    quirks.lineToRelative(0.0f, -7.0f);
                    quirks.lineToRelative(-3.0f, 0.0f);
                    quirks.lineToRelative(0.0f, -4.0f);
                    quirks.lineToRelative(-5.0f, 0.0f);
                    quirks.lineToRelative(0.0f, -2.0f);
                    quirks.lineToRelative(3.0f, 0.0f);
                    quirks.lineToRelative(0.0f, -7.0f);
                    quirks.lineToRelative(-8.0f, 0.0f);
                    quirks.lineToRelative(0.0f, 7.0f);
                    quirks.lineToRelative(3.0f, 0.0f);
                    quirks.lineToRelative(0.0f, 2.0f);
                    quirks.lineToRelative(-5.0f, 0.0f);
                    quirks.lineToRelative(0.0f, 4.0f);
                    quirks.lineToRelative(-3.0f, 0.0f);
                    quirks.lineToRelative(0.0f, 7.0f);
                    quirks.lineToRelative(8.0f, 0.0f);
                    quirks.lineToRelative(0.0f, -7.0f);
                    quirks.lineToRelative(-3.0f, 0.0f);
                    quirks.lineToRelative(0.0f, -2.0f);
                    quirks.lineToRelative(8.0f, 0.0f);
                    quirks.lineToRelative(0.0f, 2.0f);
                    quirks.lineToRelative(-3.0f, 0.0f);
                    quirks.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                    imageVectorBuild = builder.build();
                    LanKt._lan = imageVectorBuild;
                }
                appColors = appColors2;
                ImageVector imageVector = imageVectorBuild;
                z2 = true;
                IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(companion, 24), appColors2.textPrimary, gapComposer2, 432, 0);
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(1896335069);
                AsyncImageKt.m778AsyncImagegl8XCv8(str2, SizeKt.m140size3ABfNKs(companion, 24), null, null, gapComposer2, ((i2 >> 3) & 14) | 432, 4088);
                gapComposer2.end(false);
                appColors = appColors2;
                z2 = true;
            }
            TextKt.m275TextNvy7gAk(str, SizeKt.fillMaxWidth(companion, 1.0f), appColors.textPrimary, 0L, null, FontWeight.Medium, 0L, new TextAlign(3), 0L, 2, false, 2, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, (i2 & 14) | 1572912, 24960, 109496);
            gapComposer2 = gapComposer;
            gapComposer2.end(z2);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProxyScreenKt$$ExternalSyntheticLambda2(str, str2, z, function0, i);
        }
    }

    public static final void ProxyGroupsScroll(List list, Map map, String str, Function1 function1, GapComposer gapComposer, int i) {
        int i2;
        PaddingValuesImpl paddingValuesImpl;
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        gapComposer.startRestartGroup(2000134382);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(map) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(str) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            float f = 15;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierClip = ClipKt.clip(OffsetKt.m128padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 16), roundedCornerShapeM158RoundedCornerShape0680j_4);
            long j = appColors.cardBackground;
            long j2 = appColors.cardBackground;
            Modifier modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(1, appColors.cardBorder, ImageKt.m47backgroundbw27NRU(modifierClip, j, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j3 = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM48borderxT4_qwU);
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
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            float f2 = 8;
            float f3 = 5;
            PaddingValuesImpl paddingValuesImpl2 = new PaddingValuesImpl(f2, f3, f2, f3);
            Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(12);
            gapComposer.startReplaceGroup(-1097488980);
            boolean zChangedInstance = ((i2 & 7168) == 2048) | ((i2 & 896) == 256) | gapComposer.changedInstance(list) | gapComposer.changedInstance(map);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                paddingValuesImpl = paddingValuesImpl2;
                FilesActivity$$ExternalSyntheticLambda10 filesActivity$$ExternalSyntheticLambda10 = new FilesActivity$$ExternalSyntheticLambda10(list, map, str, function1, 7);
                gapComposer.updateRememberedValue(filesActivity$$ExternalSyntheticLambda10);
                objRememberedValue = filesActivity$$ExternalSyntheticLambda10;
            } else {
                paddingValuesImpl = paddingValuesImpl2;
            }
            gapComposer.end(false);
            LazyDslKt.LazyRow(modifierFillMaxWidth, null, paddingValuesImpl, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, gapComposer, 24966);
            Modifier modifierM135height3ABfNKs = SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 76);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, gapComposer, 0);
            long j4 = gapComposer.compositeKeyHashCode;
            int i4 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM135height3ABfNKs);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            OffsetKt.Spacer(gapComposer, SizeKt.m144width3ABfNKs(companion, f).then(new BackgroundElement(0L, AsyncTimeout.Companion.m855horizontalGradient8A3gB4$default(new Pair[]{new Pair(fValueOf2, new Color(j)), new Pair(Float.valueOf(0.3f), new Color(j)), new Pair(fValueOf, new Color(BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.0f, Color.m438getColorSpaceimpl(j2))))}), BrushKt.RectangleShape, 1)));
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            OffsetKt.Spacer(gapComposer, new LayoutWeightElement(1.0f, true));
            OffsetKt.Spacer(gapComposer, SizeKt.m144width3ABfNKs(companion, f).then(new BackgroundElement(0L, AsyncTimeout.Companion.m855horizontalGradient8A3gB4$default(new Pair[]{new Pair(fValueOf2, new Color(BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.0f, Color.m438getColorSpaceimpl(j2)))), new Pair(Float.valueOf(0.7f), new Color(j)), new Pair(fValueOf, new Color(j))}), BrushKt.RectangleShape, 1)));
            gapComposer.end(true);
            gapComposer.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda1(list, map, str, function1, i, 7);
        }
    }

    public static final void ProxyHeader(boolean z, boolean z2, final boolean z3, final ProxySort proxySort, final TunnelState.Mode mode, final TunnelState.Mode mode2, final boolean z4, final Function0 function0, final Function0 function1, final Function1 function2, final Function1 function3, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        Function0 function4;
        char c;
        int i4;
        MutableState mutableState;
        final boolean z5;
        final boolean z6;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1167311444);
        if ((i & 6) == 0) {
            i3 = (gapComposer2.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer2.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer2.changed(z3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer2.changed(proxySort) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer2.changed(mode) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= gapComposer2.changed(mode2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer2.changed(z4) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            function4 = function0;
            i3 |= gapComposer2.changedInstance(function4) ? 8388608 : 4194304;
        } else {
            function4 = function0;
        }
        if ((100663296 & i) == 0) {
            i3 |= gapComposer2.changedInstance(function1) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= gapComposer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            c = ' ';
            i4 = i2 | (gapComposer2.changedInstance(function3) ? 4 : 2);
        } else {
            c = ' ';
            i4 = i2;
        }
        if ((306783379 & i3) == 306783378 && (i4 & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            z6 = z2;
            z5 = z;
        } else {
            final AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            gapComposer2.startReplaceGroup(153689382);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            gapComposer2.end(false);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            int i5 = i3;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 8, 6);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j = gapComposer2.compositeKeyHashCode;
            int i6 = (int) (j ^ (j >>> c));
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
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i6);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            ScrimKt.IconButton(function4, null, false, null, null, Thread_jvmKt.rememberComposableLambda(154815662, new LogsScreenKt.AnonymousClass6(appColors, 26), gapComposer2), gapComposer2, ((i5 >> 21) & 14) | 1572864, 62);
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            OffsetKt.Spacer(gapComposer2, new LayoutWeightElement(1.0f, true));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i7 = (int) (j2 ^ (j2 >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, companion);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i7, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            gapComposer2.startReplaceGroup(1508340917);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                mutableState = mutableState2;
                objRememberedValue2 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState, 0);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                mutableState = mutableState2;
            }
            gapComposer2.end(false);
            ScrimKt.IconButton((Function0) objRememberedValue2, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-1880958028, new LogsScreenKt.AnonymousClass6(appColors, 27), gapComposer2), gapComposer2, 1572870, 62);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            gapComposer2.startReplaceGroup(1508352086);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState, 4);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            gapComposer2.end(false);
            int i8 = i5 >> 3;
            ProxySettingsMenu(zBooleanValue, (Function0) objRememberedValue3, proxySort, mode, mode2, z4, function2, function3, gapComposer2, (i8 & 458752) | (i8 & 896) | 48 | (i8 & 7168) | (57344 & i8) | ((i5 >> 9) & 3670016) | (29360128 & (i4 << 21)));
            gapComposer2.end(true);
            z5 = z;
            z6 = z2;
            ScrimKt.IconButton(function1, null, z3, null, null, Thread_jvmKt.rememberComposableLambda(426339365, new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyHeader$1$3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        boolean z7 = z6;
                        AppColors appColors2 = appColors;
                        if (z7) {
                            gapComposer3.startReplaceGroup(-485328633);
                            ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(SizeKt.m140size3ABfNKs(Modifier.Companion.$$INSTANCE, 20), appColors2.textPrimary, 2, 0L, 0, 0.0f, gapComposer3, 390, 56);
                            gapComposer3.end(false);
                        } else {
                            gapComposer3.startReplaceGroup(-485105247);
                            ImageVector imageVectorBuild = SpeedKt._speed;
                            if (imageVectorBuild == null) {
                                ImageVector.Builder builder = new ImageVector.Builder("Filled.Speed", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                int i9 = VectorKt.$r8$clinit;
                                SolidColor solidColor = new SolidColor(Color.Black);
                                Quirks quirks = new Quirks();
                                quirks.moveTo(20.38f, 8.57f);
                                quirks.lineToRelative(-1.23f, 1.85f);
                                quirks.arcToRelative(8.0f, 8.0f, -0.22f, 7.58f, true);
                                quirks.lineTo(5.07f, 18.0f);
                                PathNode.ArcTo arcTo = new PathNode.ArcTo(8.0f, 8.0f, 0.0f, false, true, 15.58f, 6.85f);
                                ArrayList arrayList = quirks.mQuirks;
                                arrayList.add(arcTo);
                                quirks.lineToRelative(1.85f, -1.23f);
                                arrayList.add(new PathNode.ArcTo(10.0f, 10.0f, 0.0f, false, false, 3.35f, 19.0f));
                                quirks.arcToRelative(2.0f, 2.0f, 1.72f, 1.0f, false);
                                quirks.horizontalLineToRelative(13.85f);
                                quirks.arcToRelative(2.0f, 2.0f, 1.74f, -1.0f, false);
                                quirks.arcToRelative(10.0f, 10.0f, -0.27f, -10.44f, false);
                                quirks.close();
                                quirks.moveTo(10.59f, 15.41f);
                                quirks.arcToRelative(2.0f, 2.0f, 2.83f, 0.0f, false);
                                quirks.lineToRelative(5.66f, -8.49f);
                                quirks.lineToRelative(-8.49f, 5.66f);
                                quirks.arcToRelative(2.0f, 2.0f, 0.0f, 2.83f, false);
                                quirks.close();
                                ImageVector.Builder.m502addPathoIyEayM$default(builder, arrayList, solidColor);
                                imageVectorBuild = builder.build();
                                SpeedKt._speed = imageVectorBuild;
                            }
                            IconKt.m249Iconww6aTOc(imageVectorBuild, StringResources_androidKt.stringResource(R.string.delay_test, gapComposer3), null, (!z3 || z5) ? appColors2.textSecondary : appColors2.textPrimary, gapComposer3, 0, 4);
                            gapComposer3.end(false);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer2), gapComposer2, ((i5 >> 24) & 14) | 1572864 | (i5 & 896), 58);
            gapComposer2 = gapComposer2;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z7 = z5;
            final boolean z8 = z6;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    ProxyScreenKt.ProxyHeader(z7, z8, z3, proxySort, mode, mode2, z4, function0, function1, function2, function3, (GapComposer) obj, Stack.updateChangedFlags(i | 1), Stack.updateChangedFlags(i2));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxyScreen(final ProxyScreenState proxyScreenState, final Function0 function0, final Function1 function1, final Function1 function2, final Function0 function3, final Function1 function4, final Function1 function5, final Function1 function6, final Function0 function7, final Modifier modifier, GapComposer gapComposer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        GapComposer gapComposer2 = gapComposer;
        String str = proxyScreenState.error;
        List list = proxyScreenState.groupNames;
        String str2 = proxyScreenState.selectedGroupName;
        gapComposer2.startRestartGroup(-913949340);
        int i3 = i | (gapComposer2.changed(proxyScreenState) ? 4 : 2) | (gapComposer2.changedInstance(function0) ? 32 : 16) | (gapComposer2.changedInstance(function1) ? 256 : 128) | (gapComposer2.changedInstance(function2) ? 2048 : 1024) | (gapComposer2.changedInstance(function3) ? 16384 : 8192) | (gapComposer2.changedInstance(function4) ? 131072 : 65536) | (gapComposer2.changedInstance(function5) ? 1048576 : 524288) | (gapComposer2.changedInstance(function6) ? 8388608 : 4194304) | (gapComposer2.changedInstance(function7) ? 67108864 : 33554432);
        if ((306783379 & i3) == 306783378 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(SizeKt.fillMaxWidth(modifier, 1.0f), appColors.appBackground, BrushKt.RectangleShape);
            FlowRowOverflow flowRowOverflow = Arrangement.Top;
            BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(flowRowOverflow, horizontal, gapComposer2, 0);
            long j = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM47backgroundbw27NRU);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i4);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            boolean z4 = proxyScreenState.isLoading;
            boolean z5 = proxyScreenState.isTesting;
            int i5 = i3 >> 21;
            ProxyHeader(z4, z5, (z4 || z5 || str2 == null) ? false : true, proxyScreenState.sort, proxyScreenState.currentMode, proxyScreenState.configMode, proxyScreenState.modeSwitchAllowed, function0, function3, function5, function6, gapComposer2, ((i3 << 18) & 29360128) | ((i3 << 12) & 234881024) | ((i3 << 9) & 1879048192), i5 & 14);
            GapComposer gapComposer3 = gapComposer2;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierWeight$default = Modifier.CC.weight$default(SizeKt.fillMaxWidth(companion, 1.0f));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j2 = gapComposer3.compositeKeyHashCode;
            int i6 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierWeight$default);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer3.useNode();
            }
            Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            if (proxyScreenState.isLoading && list.isEmpty()) {
                gapComposer3.startReplaceGroup(1504316652);
                CenterMessage(Thread_jvmKt.rememberComposableLambda(684351583, new LogsScreenKt.AnonymousClass6(appColors, 28), gapComposer3), gapComposer3, 6);
                gapComposer3.end(false);
            } else if (str != null) {
                gapComposer3.startReplaceGroup(1504321362);
                ErrorContent(str, function7, gapComposer3, i5 & 112);
                gapComposer3.end(false);
            } else {
                if (list.isEmpty()) {
                    gapComposer3.startReplaceGroup(1504326585);
                    CenterMessage(ComposableSingletons$ProxyScreenKt.f28lambda1, gapComposer3, 6);
                    gapComposer3.end(false);
                } else {
                    gapComposer3.startReplaceGroup(-610230144);
                    ProxyGroup proxyGroup = str2 != null ? (ProxyGroup) proxyScreenState.groups.get(str2) : null;
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(flowRowOverflow, horizontal, gapComposer3, 0);
                    long j3 = gapComposer3.compositeKeyHashCode;
                    int i7 = (int) (j3 ^ (j3 >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer3, fillElement);
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m295setimpl(gapComposer3, columnMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                    Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                    ImageAnalysis$$ExternalSyntheticLambda1.m(i7, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                    Stack.m295setimpl(gapComposer3, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                    if (proxyGroup == null || proxyGroup.proxies.isEmpty()) {
                        i2 = i3;
                        z = false;
                        gapComposer3.startReplaceGroup(-782107506);
                        Modifier modifierWeight$default2 = Modifier.CC.weight$default(SizeKt.fillMaxWidth(companion, 1.0f));
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                        long j4 = gapComposer3.compositeKeyHashCode;
                        int i8 = (int) (j4 ^ (j4 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierWeight$default2);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$2);
                        ImageAnalysis$$ExternalSyntheticLambda1.m(i8, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$4);
                        EmptyMessage(InboxKt.getInbox(), StringResources_androidKt.stringResource(R.string.empty, gapComposer3), gapComposer3, 0);
                        gapComposer3.end(true);
                        gapComposer3.end(false);
                        z2 = true;
                    } else {
                        gapComposer3.startReplaceGroup(-782680634);
                        i2 = i3;
                        ProxyGroup proxyGroup2 = proxyGroup;
                        z = false;
                        ProxyServersList(proxyGroup2, proxyScreenState.testingProxies, proxyScreenState.testedProxies, function2, function4, Modifier.CC.weight$default(SizeKt.fillMaxWidth(companion, 1.0f)), gapComposer3, (i2 & 7168) | ((i2 >> 3) & 57344));
                        gapComposer3 = gapComposer3;
                        gapComposer3.end(false);
                        z2 = true;
                    }
                    int i9 = (i2 << 3) & 7168;
                    gapComposer2 = gapComposer3;
                    z3 = z2;
                    ProxyGroupsScroll(proxyScreenState.groupNames, proxyScreenState.groups, proxyScreenState.selectedGroupName, function1, gapComposer2, i9);
                    gapComposer2.end(z3);
                    gapComposer2.end(z);
                }
                gapComposer2.end(z3);
                gapComposer2.end(z3);
            }
            gapComposer2 = gapComposer3;
            z3 = true;
            gapComposer2.end(z3);
            gapComposer2.end(z3);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(function0, function1, function2, function3, function4, function5, function6, function7, modifier, i) { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda6
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ Function1 f$2;
                public final /* synthetic */ Function1 f$3;
                public final /* synthetic */ Function0 f$4;
                public final /* synthetic */ Function1 f$5;
                public final /* synthetic */ Function1 f$6;
                public final /* synthetic */ Function1 f$7;
                public final /* synthetic */ Function0 f$8;
                public final /* synthetic */ Modifier f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(805306369);
                    ProxyScreenKt.ProxyScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxyServerRow(final Proxy proxy, final boolean z, final boolean z2, final boolean z3, final Function0 function0, final Function0 function1, GapComposer gapComposer, final int i) {
        long jColor;
        long j;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1749507682);
        int i2 = i | (gapComposer2.changedInstance(proxy) ? 4 : 2) | (gapComposer2.changed(z) ? 32 : 16) | (gapComposer2.changed(z2) ? 256 : 128) | (gapComposer2.changed(z3) ? 2048 : 1024) | (gapComposer2.changedInstance(function0) ? 16384 : 8192) | (gapComposer2.changedInstance(function1) ? 131072 : 65536);
        if ((74899 & i2) == 74898 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
            gapComposer2.startReplaceGroup(176957826);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer2.end(false);
            if (z) {
                jColor = appColors.accentFill;
            } else {
                long j2 = appColors.cardBackground;
                jColor = BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.5f, Color.m438getColorSpaceimpl(j2));
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                j = Color.White;
            } else {
                j = z ? appColors.accentBorder : appColors.cardBorder;
            }
            float f = ((Boolean) mutableState.getValue()).booleanValue() ? 2 : 1;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            gapComposer2.startReplaceGroup(176971292);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 23);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            gapComposer2.end(false);
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(f, j, ImageKt.m47backgroundbw27NRU(ClipKt.clip(FocusTraversalKt.onFocusChanged(modifierFillMaxWidth, (Function1) objRememberedValue2), roundedCornerShapeM158RoundedCornerShape0680j_4), jColor, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4), false, null, function0, 15), 20, 16);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j3 ^ (j3 >>> 32));
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
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i3);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            String str = proxy.name;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge;
            long j4 = appColors.textPrimary;
            FontWeight fontWeight = FontWeight.Medium;
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            TextKt.m275TextNvy7gAk(str, new LayoutWeightElement(1.0f, true), j4, 0L, null, fontWeight, 0L, null, 0L, 2, false, 1, 0, textStyle, gapComposer, 1572864, 24960, 110520);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.CenterEnd, false);
            long j5 = gapComposer.compositeKeyHashCode;
            int i4 = (int) (j5 ^ (j5 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, companion);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            if (z2) {
                gapComposer.startReplaceGroup(1912571371);
                ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(SizeKt.m140size3ABfNKs(companion, 14), appColors.textPrimary, 2, 0L, 0, 0.0f, gapComposer, 390, 56);
                gapComposer2 = gapComposer;
                gapComposer2.end(false);
            } else {
                gapComposer2 = gapComposer;
                gapComposer2.startReplaceGroup(477344580);
                int i5 = i2 >> 6;
                PingBadge(proxy.delay, z3, z, function1, gapComposer2, (i5 & 112) | ((i2 << 3) & 896) | (i5 & 7168));
                gapComposer2.end(false);
            }
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(z, z2, z3, function0, function1, i) { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda1
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ Function0 f$4;
                public final /* synthetic */ Function0 f$5;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    ProxyScreenKt.ProxyServerRow(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProxyServersList(ProxyGroup proxyGroup, Set set, Set set2, Function1 function1, Function1 function2, Modifier modifier, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(297167563);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(proxyGroup) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(set) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(set2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(modifier) ? 131072 : 65536;
        }
        int i3 = i2;
        if ((74899 & i3) == 74898 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            Proxy.Type type = proxyGroup.type;
            boolean z = type == Proxy.Type.Selector || type == Proxy.Type.Fallback || type == Proxy.Type.URLTest;
            float f = 16;
            float f2 = 12;
            PaddingValuesImpl paddingValuesImpl = new PaddingValuesImpl(f, f2, f, f2);
            Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(8);
            gapComposer.startReplaceGroup(267323453);
            boolean zChangedInstance = gapComposer.changedInstance(proxyGroup) | gapComposer.changedInstance(set) | gapComposer.changedInstance(set2) | gapComposer.changed(z) | ((i3 & 7168) == 2048) | ((57344 & i3) == 16384);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                CoreTextFieldKt$$ExternalSyntheticLambda9 coreTextFieldKt$$ExternalSyntheticLambda9 = new CoreTextFieldKt$$ExternalSyntheticLambda9(proxyGroup, set, set2, z, function1, function2, 2);
                gapComposer.updateRememberedValue(coreTextFieldKt$$ExternalSyntheticLambda9);
                objRememberedValue = coreTextFieldKt$$ExternalSyntheticLambda9;
            }
            gapComposer.end(false);
            LazyDslKt.LazyColumn(modifier, null, paddingValuesImpl, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, gapComposer, ((i3 >> 15) & 14) | 24960, 490);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ScaffoldKt$$ExternalSyntheticLambda1(proxyGroup, set, set2, function1, function2, modifier, i);
        }
    }

    public static final void ProxySettingsMenu(final boolean z, final Function0 function0, final ProxySort proxySort, final TunnelState.Mode mode, final TunnelState.Mode mode2, final boolean z2, final Function1 function1, final Function1 function2, GapComposer gapComposer, final int i) {
        boolean z3;
        int i2;
        gapComposer.startRestartGroup(1789650877);
        if ((i & 6) == 0) {
            z3 = z;
            i2 = (gapComposer.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(proxySort) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(mode) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(mode2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(z2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) == 4793490 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            AndroidMenu_androidKt.m236DropdownMenuIlH_yew(z3, function0, null, 0L, null, null, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(20), BrushKt.m414compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground), 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(140775138, new LogsScreenKt.C00212(z2, mode, mode2, function2, proxySort, function1), gapComposer), gapComposer, i2 & 126);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    ProxyScreenKt.ProxySettingsMenu(z, function0, proxySort, mode, mode2, z2, function1, function2, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void SegmentedPill(String str, boolean z, Function0 function0, Modifier modifier, boolean z2, GapComposer gapComposer, int i, int i2) {
        boolean z3;
        int i3;
        long jColor;
        boolean z4;
        boolean z5;
        boolean z6;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1458177244);
        int i4 = i | (gapComposer2.changed(str) ? 32 : 16) | (gapComposer2.changed(z) ? 256 : 128) | (gapComposer2.changedInstance(function0) ? 2048 : 1024) | (gapComposer2.changed(modifier) ? 16384 : 8192);
        int i5 = i2 & 16;
        if (i5 != 0) {
            i3 = i4 | 196608;
            z3 = z2;
        } else {
            z3 = z2;
            i3 = i4 | (gapComposer2.changed(z3) ? 131072 : 65536);
        }
        if ((74897 & i3) == 74896 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            z6 = z3;
        } else {
            boolean z7 = i5 != 0 ? false : z3;
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(11);
            if (z) {
                jColor = appColors.accentFill;
            } else {
                long j = appColors.cardBackground;
                jColor = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.5f, Color.m438getColorSpaceimpl(j));
            }
            long j2 = z ? appColors.accentBorder : appColors.cardBorder;
            State stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(jColor, null, "pillBg", gapComposer2, 384, 10);
            State stateM26animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j2, null, "pillBorder", gapComposer, 384, 10);
            Modifier modifierClip = ClipKt.clip(SizeKt.m135height3ABfNKs(modifier, 38), roundedCornerShapeM158RoundedCornerShape0680j_4);
            long j3 = ((Color) stateM26animateColorAsStateeuL9pac.getValue()).value;
            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = BrushKt.RectangleShape;
            Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, ((Color) stateM26animateColorAsStateeuL9pac2.getValue()).value, ImageKt.m47backgroundbw27NRU(modifierClip, j3, rectangleShapeKt$RectangleShape$1), roundedCornerShapeM158RoundedCornerShape0680j_4), false, null, function0, 15), 8, 0.0f, 2);
            BiasAlignment biasAlignment = Alignment.Companion.Center;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
            long j4 = gapComposer.compositeKeyHashCode;
            int i6 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM130paddingVpY3zN4$default);
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
            Integer numValueOf = Integer.valueOf(i6);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
            TextKt.m275TextNvy7gAk(str, null, appColors.textPrimary, TextUnitKt.getSp(13), null, z ? FontWeight.Bold : FontWeight.Medium, 0L, new TextAlign(3), 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelMedium, gapComposer, ((i3 >> 3) & 14) | 24576, 24960, 109482);
            gapComposer2 = gapComposer;
            gapComposer2.startReplaceGroup(137274872);
            if (z7) {
                BiasAlignment biasAlignment2 = Alignment.Companion.TopEnd;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                float f = 5;
                Modifier modifierM140size3ABfNKs = SizeKt.m140size3ABfNKs(OffsetKt.m132paddingqDBjuR0$default(flowRowOverflow.align(companion, biasAlignment2), 0.0f, f, f, 0.0f, 9), 10);
                RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
                Modifier modifierClip2 = ClipKt.clip(modifierM140size3ABfNKs, roundedCornerShape);
                long j5 = appColors.appBackground;
                Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(modifierClip2, BrushKt.Color(Color.m440getRedimpl(j5), Color.m439getGreenimpl(j5), Color.m437getBlueimpl(j5), 0.6f, Color.m438getColorSpaceimpl(j5)), rectangleShapeKt$RectangleShape$1);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                long j6 = gapComposer2.compositeKeyHashCode;
                int i7 = (int) (j6 ^ (j6 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM47backgroundbw27NRU);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i7, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                Modifier modifierClip3 = ClipKt.clip(SizeKt.m140size3ABfNKs(companion, 7), roundedCornerShape);
                long j7 = appColors.textPrimary;
                z5 = false;
                BoxKt.Box(ImageKt.m47backgroundbw27NRU(modifierClip3, BrushKt.Color(Color.m440getRedimpl(j7), Color.m439getGreenimpl(j7), Color.m437getBlueimpl(j7), 0.78f, Color.m438getColorSpaceimpl(j7)), rectangleShapeKt$RectangleShape$1), gapComposer2, 0);
                z4 = true;
                gapComposer2.end(true);
            } else {
                z4 = true;
                z5 = false;
            }
            gapComposer2.end(z5);
            gapComposer2.end(z4);
            z6 = z7;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesScreenKt$$ExternalSyntheticLambda4(str, z, function0, modifier, z6, i, i2);
        }
    }

    public static final void SettingsSection(String str, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1252361885);
        if (((i | (gapComposer2.changed(str) ? 4 : 2)) & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(10), Alignment.Companion.Start, gapComposer2, 6);
            long j = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, companion);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextKt.m275TextNvy7gAk(str.toUpperCase(Locale.ROOT), OffsetKt.m132paddingqDBjuR0$default(companion, 4, 0.0f, 0.0f, 0.0f, 14), appColors.textSecondary, TextUnitKt.getSp(11), null, FontWeight.SemiBold, TextUnitKt.getSp(0.6d), null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 102260784, 0, 130728);
            gapComposer2 = gapComposer;
            composableLambdaImpl.invoke((Object) gapComposer2, (Object) 6);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BasicTooltipKt$$ExternalSyntheticLambda7(str, composableLambdaImpl, i, 3);
        }
    }
}
