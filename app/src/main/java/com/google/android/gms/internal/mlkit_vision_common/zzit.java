package com.google.android.gms.internal.mlkit_vision_common;

import androidx.activity.compose.BackHandlerKt;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.Quirks;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9;
import androidx.compose.material.icons.outlined.AddCircleKt;
import androidx.compose.material.icons.outlined.DeleteForeverKt;
import androidx.compose.material.icons.outlined.InboxKt;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import com.github.kr328.clash.compose.HwidLimitDialogKt;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.PropertiesScreenKt$TextInputDialog$4;
import com.github.kr328.clash.compose.ProvidersScreenKt$ProvidersScreen$2$3$1;
import com.github.kr328.clash.compose.profiles.ComposableSingletons$ProfilesScreenKt;
import com.github.kr328.clash.compose.profiles.ProfilesScreenKt$$ExternalSyntheticLambda7;
import com.github.kr328.clash.compose.profiles.ProfilesViewModel;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda8;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.service.HwidLimitMarker;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzit;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeSourceElement;
import dev.chrisbanes.haze.HazeState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import okhttp3.CertificatePinner;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzit {
    public static final void AddProfileFab(Function0 function0, HazeState hazeState, Modifier modifier, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(210395042);
        if (((i | (gapComposer.changedInstance(function0) ? 4 : 2) | (gapComposer.changed(hazeState) ? 32 : 16) | (gapComposer.changed(modifier) ? 256 : 128)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
            Modifier modifierM128padding3ABfNKs = OffsetKt.m128padding3ABfNKs(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, appColors.cardBorder, ClipKt.clip(modifier, roundedCornerShapeM158RoundedCornerShape0680j_4).then(new HazeEffectNodeElement(hazeState, BackHandlerKt.m6thinIv8Zu3U(gapComposer))), roundedCornerShapeM158RoundedCornerShape0680j_4), false, null, function0, 15), 16);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer.compositeKeyHashCode;
            int i2 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM128padding3ABfNKs);
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
            ImageVector imageVectorBuild = AddCircleKt._addCircle;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder = new ImageVector.Builder("Outlined.AddCircle", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i3 = VectorKt.$r8$clinit;
                SolidColor solidColor = new SolidColor(Color.Black);
                Quirks quirks = new Quirks();
                quirks.moveTo(12.0f, 2.0f);
                quirks.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                quirks.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                quirks.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                quirks.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                quirks.close();
                quirks.moveTo(17.0f, 13.0f);
                quirks.horizontalLineToRelative(-4.0f);
                quirks.verticalLineToRelative(4.0f);
                quirks.horizontalLineToRelative(-2.0f);
                quirks.verticalLineToRelative(-4.0f);
                quirks.lineTo(7.0f, 13.0f);
                quirks.verticalLineToRelative(-2.0f);
                quirks.horizontalLineToRelative(4.0f);
                quirks.lineTo(11.0f, 7.0f);
                quirks.horizontalLineToRelative(2.0f);
                quirks.verticalLineToRelative(4.0f);
                quirks.horizontalLineToRelative(4.0f);
                quirks.verticalLineToRelative(2.0f);
                quirks.close();
                ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                imageVectorBuild = builder.build();
                AddCircleKt._addCircle = imageVectorBuild;
            }
            IconKt.m249Iconww6aTOc(imageVectorBuild, StringResources_androidKt.stringResource(R.string.profile_add, gapComposer), SizeKt.m140size3ABfNKs(Modifier.Companion.$$INSTANCE, 28), appColors.textPrimary, gapComposer, 384, 0);
            gapComposer.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(function0, hazeState, modifier, i, 11);
        }
    }

    public static final void AddProfilePillButton(Function0 function0, GapComposer gapComposer, int i) {
        int i2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-381321614);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer2.changedInstance(function0) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            float f = 18;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierClip = ClipKt.clip(companion, roundedCornerShapeM158RoundedCornerShape0680j_4);
            long j = appColors.buttonColor;
            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = BrushKt.RectangleShape;
            Modifier modifierM51clickableoSLSa3U$default = ImageKt.m51clickableoSLSa3U$default(ImageKt.m47backgroundbw27NRU(modifierClip, j, rectangleShapeKt$RectangleShape$1), false, null, function0, 15);
            float f2 = 24;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(modifierM51clickableoSLSa3U$default, f2, 14);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.m111spacedBy0680j_4(10), Alignment.Companion.CenterVertically, gapComposer2, 54);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j2 ^ (j2 >>> 32));
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
            Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.m140size3ABfNKs(companion, f2), RoundedCornerShapeKt.CircleShape), Color.White, rectangleShapeKt$RectangleShape$1);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM47backgroundbw27NRU);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            IconKt.m249Iconww6aTOc(CertificatePinner.Companion.getAdd(), null, SizeKt.m140size3ABfNKs(companion, f), appColors.buttonActiveEnd, gapComposer2, 432, 0);
            gapComposer2.end(true);
            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_add, gapComposer2), null, appColors.textPrimary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer, 1572864, 0, 131002);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProfilesScreenKt$$ExternalSyntheticLambda7(i, 0, function0);
        }
    }

    public static final void DeleteProfileDialog(String str, final Function0 function0, Function0 function1, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(1508811322);
        if (((i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            final long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
            float f = AlertDialogDefaults.TonalElevation;
            int i2 = DialogTokens.ContainerShape;
            long value = ColorSchemeKt.getValue(38, gapComposer);
            long j2 = appColors.textPrimary;
            ScrimKt.m263AlertDialogOix01E0(function1, Thread_jvmKt.rememberComposableLambda(1142170754, new Function2() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$DeleteProfileDialog$1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
                        PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                        ScrimKt.Button(function0, null, false, roundedCornerShapeM158RoundedCornerShape0680j_4, ButtonDefaults.m243buttonColorsro_MJ88(j, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onError, gapComposer2), null, null, ComposableSingletons$ProfilesScreenKt.f25lambda1, gapComposer2, 805306368, 486);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), null, Thread_jvmKt.rememberComposableLambda(986190212, new LogsScreenKt.AnonymousClass2(function1, appColors, 13), gapComposer), Thread_jvmKt.rememberComposableLambda(908199941, new Function2() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$DeleteProfileDialog$3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        ImageVector imageVectorBuild = DeleteForeverKt._deleteForever;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder = new ImageVector.Builder("Outlined.DeleteForever", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i3 = VectorKt.$r8$clinit;
                            SolidColor solidColor = new SolidColor(Color.Black);
                            Quirks quirks = new Quirks();
                            quirks.moveTo(14.12f, 10.47f);
                            quirks.lineTo(12.0f, 12.59f);
                            quirks.lineToRelative(-2.13f, -2.12f);
                            quirks.lineToRelative(-1.41f, 1.41f);
                            quirks.lineTo(10.59f, 14.0f);
                            quirks.lineToRelative(-2.12f, 2.12f);
                            quirks.lineToRelative(1.41f, 1.41f);
                            quirks.lineTo(12.0f, 15.41f);
                            quirks.lineToRelative(2.12f, 2.12f);
                            quirks.lineToRelative(1.41f, -1.41f);
                            quirks.lineTo(13.41f, 14.0f);
                            quirks.lineToRelative(2.12f, -2.12f);
                            quirks.close();
                            quirks.moveTo(15.5f, 4.0f);
                            quirks.lineToRelative(-1.0f, -1.0f);
                            quirks.horizontalLineToRelative(-5.0f);
                            quirks.lineToRelative(-1.0f, 1.0f);
                            quirks.horizontalLineTo(5.0f);
                            quirks.verticalLineToRelative(2.0f);
                            quirks.horizontalLineToRelative(14.0f);
                            quirks.verticalLineTo(4.0f);
                            quirks.close();
                            quirks.moveTo(6.0f, 19.0f);
                            quirks.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                            quirks.horizontalLineToRelative(8.0f);
                            quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                            quirks.verticalLineTo(7.0f);
                            quirks.horizontalLineTo(6.0f);
                            quirks.verticalLineToRelative(12.0f);
                            quirks.close();
                            quirks.moveTo(8.0f, 9.0f);
                            quirks.horizontalLineToRelative(8.0f);
                            quirks.verticalLineToRelative(10.0f);
                            quirks.horizontalLineTo(8.0f);
                            quirks.verticalLineTo(9.0f);
                            quirks.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                            imageVectorBuild = builder.build();
                            DeleteForeverKt._deleteForever = imageVectorBuild;
                        }
                        IconKt.m249Iconww6aTOc(imageVectorBuild, null, null, j, gapComposer2, 48, 4);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), ComposableSingletons$ProfilesScreenKt.f27lambda3, Thread_jvmKt.rememberComposableLambda(752219399, new PropertiesScreenKt$TextInputDialog$4.AnonymousClass1(str, 1), gapComposer), null, value, 0L, j2, j2, 0.0f, null, gapComposer, 1797174, 12932);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(str, function0, function1, i, 10);
        }
    }

    public static final void EmptyProfilesContent(Function0 function0, Modifier modifier, GapComposer gapComposer, int i) {
        Function0 function1;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-10670204);
        int i2 = i | (gapComposer2.changedInstance(function0) ? 4 : 2) | (gapComposer2.changed(modifier) ? 32 : 16);
        if ((i2 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            function1 = function0;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(modifier, 1.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Center, Alignment.Companion.CenterHorizontally, gapComposer2, 54);
            long j = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierFillMaxWidth);
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
            ImageVector inbox = InboxKt.getInbox();
            long j2 = appColors.textPrimary;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            IconKt.m249Iconww6aTOc(inbox, null, SizeKt.m140size3ABfNKs(companion, 48), j2, gapComposer2, 432, 0);
            OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, 16));
            String strStringResource = StringResources_androidKt.stringResource(R.string.profile_no_profiles, gapComposer2);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt.m275TextNvy7gAk(strStringResource, null, appColors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer, 0, 0, 131066);
            OffsetKt.Spacer(gapComposer, SizeKt.m135height3ABfNKs(companion, 8));
            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_add_description, gapComposer), OffsetKt.m130paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 32, 0.0f, 2), appColors.textSecondary, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 48, 0, 130040);
            gapComposer2 = gapComposer;
            OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, 24));
            function1 = function0;
            AddProfilePillButton(function1, gapComposer2, i2 & 14);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 25, function1, modifier);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:44:0x011e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0122  */
    /* JADX WARN: Code duplicated, block: B:47:0x0139  */
    /* JADX WARN: Code duplicated, block: B:50:0x013e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0141  */
    /* JADX WARN: Code duplicated, block: B:55:0x0159  */
    /* JADX WARN: Code duplicated, block: B:60:0x017a  */
    /* JADX WARN: Code duplicated, block: B:62:0x018c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:63:0x018e  */
    /* JADX WARN: Code duplicated, block: B:68:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:70:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    public static final void ProfilesScreen(final Function0 function0, final Function1 function1, final PaddingValuesImpl paddingValuesImpl, Modifier modifier, boolean z, GapComposer gapComposer, final int i, final int i2) {
        boolean z2;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        final ProfilesViewModel profilesViewModel;
        Object objRememberedValue;
        Object obj;
        final MutableState mutableState;
        Profile profile;
        int i3;
        boolean zChangedInstance;
        Object objRememberedValue2;
        Object obj2;
        MutableState mutableState2;
        ?? r5;
        Object objM;
        HwidLimitMarker hwidLimitMarker;
        final Modifier modifier2;
        final boolean z3;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(1317581816);
        int i4 = (gapComposer.changedInstance(function1) ? 32 : 16) | i;
        if ((i & 384) == 0) {
            i4 |= gapComposer.changed(paddingValuesImpl) ? 256 : 128;
        }
        int i5 = i4 | 3072;
        int i6 = i2 & 16;
        if (i6 == 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                i5 |= gapComposer.changed(z2) ? 16384 : 8192;
            }
            if ((i5 & 9363) == 9362 || !gapComposer.getSkipping()) {
                if (i6 != 0) {
                    z2 = false;
                }
                current = LocalViewModelStoreOwner.getCurrent(gapComposer);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                if (current instanceof HasDefaultViewModelProviderFactory) {
                    defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                } else {
                    defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                }
                profilesViewModel = (ProfilesViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(ProfilesViewModel.class), current, null, defaultViewModelCreationExtras, gapComposer);
                final MutableState mutableStateCollectAsState = Stack.collectAsState(profilesViewModel.profiles, gapComposer, 0);
                final MutableState mutableStateCollectAsState2 = Stack.collectAsState(profilesViewModel.loaded, gapComposer, 0);
                final MutableState mutableStateCollectAsState3 = Stack.collectAsState(profilesViewModel.updatingProfiles, gapComposer, 0);
                MutableState mutableStateCollectAsState4 = Stack.collectAsState(profilesViewModel.hwidLimit, gapComposer, 0);
                final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                final HazeState hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer);
                gapComposer.startReplaceGroup(802983438);
                objRememberedValue = gapComposer.rememberedValue();
                obj = Composer$Companion.Empty;
                if (objRememberedValue == obj) {
                    objRememberedValue = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                gapComposer.end(false);
                final boolean z4 = z2;
                ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(2032534204, new ProvidersScreenKt$ProvidersScreen$2$3$1(z2, appColors, 1), gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(-1069938425, new Function3() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$ProfilesScreen$2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        boolean z5;
                        GapComposer gapComposer2;
                        boolean z6;
                        PaddingValues paddingValues = (PaddingValues) obj3;
                        GapComposer gapComposer3 = (GapComposer) obj4;
                        int iIntValue = ((Number) obj5).intValue();
                        if ((iIntValue & 6) == 0) {
                            iIntValue |= gapComposer3.changed(paddingValues) ? 4 : 2;
                        }
                        if ((iIntValue & 19) == 18 && gapComposer3.getSkipping()) {
                            gapComposer3.skipToGroupEnd();
                        } else {
                            FillElement fillElement = SizeKt.FillWholeMaxSize;
                            Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(fillElement, 0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, 0.0f, 13);
                            PaddingValuesImpl paddingValuesImpl2 = paddingValuesImpl;
                            float f = paddingValuesImpl2.bottom;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                            MenuHostHelper menuHostHelper = gapComposer3.applier;
                            long j = gapComposer3.compositeKeyHashCode;
                            int i7 = (int) (j ^ (j >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default);
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer3.useNode();
                            }
                            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                            Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                            Integer numValueOf = Integer.valueOf(i7);
                            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                            Stack.m295setimpl(gapComposer3, numValueOf, composeUiNode$Companion$SetModifier$3);
                            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                            Stack.m294reconcileimpl(gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                            FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
                            if (((Boolean) mutableStateCollectAsState2.getValue()).booleanValue()) {
                                z5 = true;
                                gapComposer2 = gapComposer3;
                                State state = mutableStateCollectAsState;
                                boolean zIsEmpty = ((List) state.getValue()).isEmpty();
                                Function0 function2 = function0;
                                if (zIsEmpty) {
                                    gapComposer2.startReplaceGroup(675561414);
                                    zzit.EmptyProfilesContent(function2, OffsetKt.m132paddingqDBjuR0$default(fillElement, 0.0f, 0.0f, 0.0f, paddingValuesImpl2.bottom, 7), gapComposer2, 0);
                                    gapComposer2.end(false);
                                } else {
                                    gapComposer2.startReplaceGroup(675888650);
                                    HazeState hazeState = hazeStateRememberHazeState;
                                    Modifier modifierThen = fillElement.then(new HazeSourceElement(hazeState));
                                    float f2 = 16;
                                    PaddingValuesImpl paddingValuesImpl3 = new PaddingValuesImpl(f2, 8, f2, 96 + f);
                                    Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(f2);
                                    gapComposer2.startReplaceGroup(437460638);
                                    boolean zChanged = gapComposer2.changed(state);
                                    State state2 = mutableStateCollectAsState3;
                                    boolean zChanged2 = zChanged | gapComposer2.changed(state2);
                                    ProfilesViewModel profilesViewModel2 = profilesViewModel;
                                    boolean zChangedInstance3 = zChanged2 | gapComposer2.changedInstance(profilesViewModel2);
                                    Function1 function3 = function1;
                                    boolean zChanged3 = zChangedInstance3 | gapComposer2.changed(function3);
                                    boolean z7 = z4;
                                    boolean zChanged4 = zChanged3 | gapComposer2.changed(z7);
                                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                                    if (zChanged4 || objRememberedValue4 == Composer$Companion.Empty) {
                                        objRememberedValue4 = new CoreTextFieldKt$$ExternalSyntheticLambda9(state, profilesViewModel2, function3, z7, state2, mutableState, 1);
                                        gapComposer2.updateRememberedValue(objRememberedValue4);
                                    }
                                    gapComposer2.end(false);
                                    LazyDslKt.LazyColumn(modifierThen, null, paddingValuesImpl3, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue4, gapComposer2, 24576, 490);
                                    gapComposer2 = gapComposer2;
                                    zzit.AddProfileFab(function2, hazeState, OffsetKt.m132paddingqDBjuR0$default(flowRowOverflow.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.BottomEnd), 0.0f, 0.0f, f2, f + f2, 3), gapComposer2, 0);
                                    gapComposer2.end(false);
                                    z6 = true;
                                }
                                gapComposer2.end(z6);
                            } else {
                                gapComposer3.startReplaceGroup(675169233);
                                Modifier modifierM132paddingqDBjuR0$default2 = OffsetKt.m132paddingqDBjuR0$default(fillElement, 0.0f, 0.0f, 0.0f, paddingValuesImpl2.bottom, 7);
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                                long j2 = gapComposer3.compositeKeyHashCode;
                                int i8 = (int) (j2 ^ (j2 >>> 32));
                                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default2);
                                gapComposer3.startReusableNode();
                                if (gapComposer3.inserting) {
                                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                                } else {
                                    gapComposer3.useNode();
                                }
                                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                                Modifier.CC.m(i8, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                                gapComposer2 = gapComposer3;
                                ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(null, appColors.textPrimary, 0.0f, 0L, 0, 0.0f, gapComposer2, 0, 61);
                                z5 = true;
                                gapComposer2.end(true);
                                gapComposer2.end(false);
                            }
                            z6 = z5;
                            gapComposer2.end(z6);
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 805306416, 444);
                profile = (Profile) mutableState.getValue();
                gapComposer.startReplaceGroup(803095250);
                i3 = 12;
                if (profile == null) {
                    obj2 = obj;
                    r5 = 0;
                } else {
                    String str = profile.name;
                    gapComposer.startReplaceGroup(-949705376);
                    zChangedInstance = gapComposer.changedInstance(profilesViewModel) | gapComposer.changedInstance(profile);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance) {
                        obj2 = obj;
                    } else {
                        obj2 = obj;
                        if (objRememberedValue2 != obj2) {
                            mutableState2 = mutableState;
                        }
                        Function0 function2 = (Function0) objRememberedValue2;
                        r5 = 0;
                        objM = Density.CC.m(-949701606, gapComposer, false);
                        if (objM == obj2) {
                            objM = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState2, 3);
                            gapComposer.updateRememberedValue(objM);
                        }
                        gapComposer.end(false);
                        DeleteProfileDialog(str, function2, (Function0) objM, gapComposer, 384);
                        Unit unit = Unit.INSTANCE;
                    }
                    mutableState2 = mutableState;
                    objRememberedValue2 = new GapComposer$$ExternalSyntheticLambda0(profilesViewModel, profile, mutableState2, i3);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                    Function0 function3 = (Function0) objRememberedValue2;
                    r5 = 0;
                    objM = Density.CC.m(-949701606, gapComposer, false);
                    if (objM == obj2) {
                        objM = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState2, 3);
                        gapComposer.updateRememberedValue(objM);
                    }
                    gapComposer.end(false);
                    DeleteProfileDialog(str, function3, (Function0) objM, gapComposer, 384);
                    Unit unit2 = Unit.INSTANCE;
                }
                gapComposer.end(r5);
                hwidLimitMarker = (HwidLimitMarker) mutableStateCollectAsState4.getValue();
                if (hwidLimitMarker != null) {
                    String str2 = hwidLimitMarker.supportURL;
                    gapComposer.startReplaceGroup(-949696250);
                    zChangedInstance2 = gapComposer.changedInstance(profilesViewModel);
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == obj2) {
                        objRememberedValue3 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(12, profilesViewModel);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    gapComposer.end(r5);
                    HwidLimitDialogKt.HwidLimitDialog(str2, (Function0) objRememberedValue3, gapComposer, r5);
                }
                modifier2 = Modifier.Companion.$$INSTANCE;
                z3 = z4;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                z3 = z2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        ((Integer) obj4).getClass();
                        zzit.ProfilesScreen(function0, function1, paddingValuesImpl, modifier2, z3, (GapComposer) obj3, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i5 = i4 | 27648;
        z2 = z;
        if ((i5 & 9363) == 9362) {
            if (i6 != 0) {
                z2 = false;
            }
            current = LocalViewModelStoreOwner.getCurrent(gapComposer);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            if (current instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
            }
            profilesViewModel = (ProfilesViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(ProfilesViewModel.class), current, null, defaultViewModelCreationExtras, gapComposer);
            final MutableState mutableStateCollectAsState5 = Stack.collectAsState(profilesViewModel.profiles, gapComposer, 0);
            final MutableState mutableStateCollectAsState6 = Stack.collectAsState(profilesViewModel.loaded, gapComposer, 0);
            final MutableState mutableStateCollectAsState7 = Stack.collectAsState(profilesViewModel.updatingProfiles, gapComposer, 0);
            MutableState mutableStateCollectAsState8 = Stack.collectAsState(profilesViewModel.hwidLimit, gapComposer, 0);
            final AppColors appColors2 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            final HazeState hazeStateRememberHazeState2 = HazeKt.rememberHazeState(gapComposer);
            gapComposer.startReplaceGroup(802983438);
            objRememberedValue = gapComposer.rememberedValue();
            obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            final boolean z5 = z2;
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors2.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(2032534204, new ProvidersScreenKt$ProvidersScreen$2$3$1(z2, appColors2, 1), gapComposer), null, null, null, 0, appColors2.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(-1069938425, new Function3() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$ProfilesScreen$2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    boolean z6;
                    GapComposer gapComposer2;
                    boolean z7;
                    PaddingValues paddingValues = (PaddingValues) obj3;
                    GapComposer gapComposer3 = (GapComposer) obj4;
                    int iIntValue = ((Number) obj5).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer3.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(fillElement, 0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, 0.0f, 13);
                        PaddingValuesImpl paddingValuesImpl2 = paddingValuesImpl;
                        float f = paddingValuesImpl2.bottom;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        MenuHostHelper menuHostHelper = gapComposer3.applier;
                        long j = gapComposer3.compositeKeyHashCode;
                        int i7 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i7);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer3, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
                        if (((Boolean) mutableStateCollectAsState6.getValue()).booleanValue()) {
                            z6 = true;
                            gapComposer2 = gapComposer3;
                            State state = mutableStateCollectAsState5;
                            boolean zIsEmpty = ((List) state.getValue()).isEmpty();
                            Function0 function4 = function0;
                            if (zIsEmpty) {
                                gapComposer2.startReplaceGroup(675561414);
                                zzit.EmptyProfilesContent(function4, OffsetKt.m132paddingqDBjuR0$default(fillElement, 0.0f, 0.0f, 0.0f, paddingValuesImpl2.bottom, 7), gapComposer2, 0);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(675888650);
                                HazeState hazeState = hazeStateRememberHazeState2;
                                Modifier modifierThen = fillElement.then(new HazeSourceElement(hazeState));
                                float f2 = 16;
                                PaddingValuesImpl paddingValuesImpl3 = new PaddingValuesImpl(f2, 8, f2, 96 + f);
                                Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(f2);
                                gapComposer2.startReplaceGroup(437460638);
                                boolean zChanged = gapComposer2.changed(state);
                                State state2 = mutableStateCollectAsState7;
                                boolean zChanged2 = zChanged | gapComposer2.changed(state2);
                                ProfilesViewModel profilesViewModel2 = profilesViewModel;
                                boolean zChangedInstance3 = zChanged2 | gapComposer2.changedInstance(profilesViewModel2);
                                Function1 function5 = function1;
                                boolean zChanged3 = zChangedInstance3 | gapComposer2.changed(function5);
                                boolean z8 = z5;
                                boolean zChanged4 = zChanged3 | gapComposer2.changed(z8);
                                Object objRememberedValue4 = gapComposer2.rememberedValue();
                                if (zChanged4 || objRememberedValue4 == Composer$Companion.Empty) {
                                    objRememberedValue4 = new CoreTextFieldKt$$ExternalSyntheticLambda9(state, profilesViewModel2, function5, z8, state2, mutableState, 1);
                                    gapComposer2.updateRememberedValue(objRememberedValue4);
                                }
                                gapComposer2.end(false);
                                LazyDslKt.LazyColumn(modifierThen, null, paddingValuesImpl3, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue4, gapComposer2, 24576, 490);
                                gapComposer2 = gapComposer2;
                                zzit.AddProfileFab(function4, hazeState, OffsetKt.m132paddingqDBjuR0$default(flowRowOverflow.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.BottomEnd), 0.0f, 0.0f, f2, f + f2, 3), gapComposer2, 0);
                                gapComposer2.end(false);
                                z7 = true;
                            }
                            gapComposer2.end(z7);
                        } else {
                            gapComposer3.startReplaceGroup(675169233);
                            Modifier modifierM132paddingqDBjuR0$default2 = OffsetKt.m132paddingqDBjuR0$default(fillElement, 0.0f, 0.0f, 0.0f, paddingValuesImpl2.bottom, 7);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                            long j2 = gapComposer3.compositeKeyHashCode;
                            int i8 = (int) (j2 ^ (j2 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default2);
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                            Modifier.CC.m(i8, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                            gapComposer2 = gapComposer3;
                            ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(null, appColors2.textPrimary, 0.0f, 0L, 0, 0.0f, gapComposer2, 0, 61);
                            z6 = true;
                            gapComposer2.end(true);
                            gapComposer2.end(false);
                        }
                        z7 = z6;
                        gapComposer2.end(z7);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306416, 444);
            profile = (Profile) mutableState.getValue();
            gapComposer.startReplaceGroup(803095250);
            i3 = 12;
            if (profile == null) {
                obj2 = obj;
                r5 = 0;
            } else {
                String str3 = profile.name;
                gapComposer.startReplaceGroup(-949705376);
                zChangedInstance = gapComposer.changedInstance(profilesViewModel) | gapComposer.changedInstance(profile);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChangedInstance) {
                    obj2 = obj;
                    if (objRememberedValue2 != obj2) {
                        mutableState2 = mutableState;
                    }
                    Function0 function4 = (Function0) objRememberedValue2;
                    r5 = 0;
                    objM = Density.CC.m(-949701606, gapComposer, false);
                    if (objM == obj2) {
                        objM = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState2, 3);
                        gapComposer.updateRememberedValue(objM);
                    }
                    gapComposer.end(false);
                    DeleteProfileDialog(str3, function4, (Function0) objM, gapComposer, 384);
                    Unit unit3 = Unit.INSTANCE;
                } else {
                    obj2 = obj;
                }
                mutableState2 = mutableState;
                objRememberedValue2 = new GapComposer$$ExternalSyntheticLambda0(profilesViewModel, profile, mutableState2, i3);
                gapComposer.updateRememberedValue(objRememberedValue2);
                Function0 function5 = (Function0) objRememberedValue2;
                r5 = 0;
                objM = Density.CC.m(-949701606, gapComposer, false);
                if (objM == obj2) {
                    objM = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState2, 3);
                    gapComposer.updateRememberedValue(objM);
                }
                gapComposer.end(false);
                DeleteProfileDialog(str3, function5, (Function0) objM, gapComposer, 384);
                Unit unit4 = Unit.INSTANCE;
            }
            gapComposer.end(r5);
            hwidLimitMarker = (HwidLimitMarker) mutableStateCollectAsState8.getValue();
            if (hwidLimitMarker != null) {
                String str4 = hwidLimitMarker.supportURL;
                gapComposer.startReplaceGroup(-949696250);
                zChangedInstance2 = gapComposer.changedInstance(profilesViewModel);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue3 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(12, profilesViewModel);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(12, profilesViewModel);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                gapComposer.end(r5);
                HwidLimitDialogKt.HwidLimitDialog(str4, (Function0) objRememberedValue3, gapComposer, r5);
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
            z3 = z5;
        } else {
            if (i6 != 0) {
                z2 = false;
            }
            current = LocalViewModelStoreOwner.getCurrent(gapComposer);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            if (current instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
            }
            profilesViewModel = (ProfilesViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(ProfilesViewModel.class), current, null, defaultViewModelCreationExtras, gapComposer);
            final MutableState mutableStateCollectAsState9 = Stack.collectAsState(profilesViewModel.profiles, gapComposer, 0);
            final MutableState mutableStateCollectAsState10 = Stack.collectAsState(profilesViewModel.loaded, gapComposer, 0);
            final MutableState mutableStateCollectAsState11 = Stack.collectAsState(profilesViewModel.updatingProfiles, gapComposer, 0);
            MutableState mutableStateCollectAsState12 = Stack.collectAsState(profilesViewModel.hwidLimit, gapComposer, 0);
            final AppColors appColors3 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            final HazeState hazeStateRememberHazeState3 = HazeKt.rememberHazeState(gapComposer);
            gapComposer.startReplaceGroup(802983438);
            objRememberedValue = gapComposer.rememberedValue();
            obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            final boolean z6 = z2;
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors3.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(2032534204, new ProvidersScreenKt$ProvidersScreen$2$3$1(z2, appColors3, 1), gapComposer), null, null, null, 0, appColors3.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(-1069938425, new Function3() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$ProfilesScreen$2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    boolean z7;
                    GapComposer gapComposer2;
                    boolean z8;
                    PaddingValues paddingValues = (PaddingValues) obj3;
                    GapComposer gapComposer3 = (GapComposer) obj4;
                    int iIntValue = ((Number) obj5).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer3.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(fillElement, 0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, 0.0f, 13);
                        PaddingValuesImpl paddingValuesImpl2 = paddingValuesImpl;
                        float f = paddingValuesImpl2.bottom;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        MenuHostHelper menuHostHelper = gapComposer3.applier;
                        long j = gapComposer3.compositeKeyHashCode;
                        int i7 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i7);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer3, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
                        if (((Boolean) mutableStateCollectAsState10.getValue()).booleanValue()) {
                            z7 = true;
                            gapComposer2 = gapComposer3;
                            State state = mutableStateCollectAsState9;
                            boolean zIsEmpty = ((List) state.getValue()).isEmpty();
                            Function0 function6 = function0;
                            if (zIsEmpty) {
                                gapComposer2.startReplaceGroup(675561414);
                                zzit.EmptyProfilesContent(function6, OffsetKt.m132paddingqDBjuR0$default(fillElement, 0.0f, 0.0f, 0.0f, paddingValuesImpl2.bottom, 7), gapComposer2, 0);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(675888650);
                                HazeState hazeState = hazeStateRememberHazeState3;
                                Modifier modifierThen = fillElement.then(new HazeSourceElement(hazeState));
                                float f2 = 16;
                                PaddingValuesImpl paddingValuesImpl3 = new PaddingValuesImpl(f2, 8, f2, 96 + f);
                                Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(f2);
                                gapComposer2.startReplaceGroup(437460638);
                                boolean zChanged = gapComposer2.changed(state);
                                State state2 = mutableStateCollectAsState11;
                                boolean zChanged2 = zChanged | gapComposer2.changed(state2);
                                ProfilesViewModel profilesViewModel2 = profilesViewModel;
                                boolean zChangedInstance3 = zChanged2 | gapComposer2.changedInstance(profilesViewModel2);
                                Function1 function7 = function1;
                                boolean zChanged3 = zChangedInstance3 | gapComposer2.changed(function7);
                                boolean z9 = z6;
                                boolean zChanged4 = zChanged3 | gapComposer2.changed(z9);
                                Object objRememberedValue4 = gapComposer2.rememberedValue();
                                if (zChanged4 || objRememberedValue4 == Composer$Companion.Empty) {
                                    objRememberedValue4 = new CoreTextFieldKt$$ExternalSyntheticLambda9(state, profilesViewModel2, function7, z9, state2, mutableState, 1);
                                    gapComposer2.updateRememberedValue(objRememberedValue4);
                                }
                                gapComposer2.end(false);
                                LazyDslKt.LazyColumn(modifierThen, null, paddingValuesImpl3, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue4, gapComposer2, 24576, 490);
                                gapComposer2 = gapComposer2;
                                zzit.AddProfileFab(function6, hazeState, OffsetKt.m132paddingqDBjuR0$default(flowRowOverflow.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.BottomEnd), 0.0f, 0.0f, f2, f + f2, 3), gapComposer2, 0);
                                gapComposer2.end(false);
                                z8 = true;
                            }
                            gapComposer2.end(z8);
                        } else {
                            gapComposer3.startReplaceGroup(675169233);
                            Modifier modifierM132paddingqDBjuR0$default2 = OffsetKt.m132paddingqDBjuR0$default(fillElement, 0.0f, 0.0f, 0.0f, paddingValuesImpl2.bottom, 7);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                            long j2 = gapComposer3.compositeKeyHashCode;
                            int i8 = (int) (j2 ^ (j2 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default2);
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                            Modifier.CC.m(i8, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                            gapComposer2 = gapComposer3;
                            ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(null, appColors3.textPrimary, 0.0f, 0L, 0, 0.0f, gapComposer2, 0, 61);
                            z7 = true;
                            gapComposer2.end(true);
                            gapComposer2.end(false);
                        }
                        z8 = z7;
                        gapComposer2.end(z8);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306416, 444);
            profile = (Profile) mutableState.getValue();
            gapComposer.startReplaceGroup(803095250);
            i3 = 12;
            if (profile == null) {
                obj2 = obj;
                r5 = 0;
            } else {
                String str5 = profile.name;
                gapComposer.startReplaceGroup(-949705376);
                zChangedInstance = gapComposer.changedInstance(profilesViewModel) | gapComposer.changedInstance(profile);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChangedInstance) {
                    obj2 = obj;
                    if (objRememberedValue2 != obj2) {
                        mutableState2 = mutableState;
                    }
                    Function0 function6 = (Function0) objRememberedValue2;
                    r5 = 0;
                    objM = Density.CC.m(-949701606, gapComposer, false);
                    if (objM == obj2) {
                        objM = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState2, 3);
                        gapComposer.updateRememberedValue(objM);
                    }
                    gapComposer.end(false);
                    DeleteProfileDialog(str5, function6, (Function0) objM, gapComposer, 384);
                    Unit unit5 = Unit.INSTANCE;
                } else {
                    obj2 = obj;
                }
                mutableState2 = mutableState;
                objRememberedValue2 = new GapComposer$$ExternalSyntheticLambda0(profilesViewModel, profile, mutableState2, i3);
                gapComposer.updateRememberedValue(objRememberedValue2);
                Function0 function7 = (Function0) objRememberedValue2;
                r5 = 0;
                objM = Density.CC.m(-949701606, gapComposer, false);
                if (objM == obj2) {
                    objM = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState2, 3);
                    gapComposer.updateRememberedValue(objM);
                }
                gapComposer.end(false);
                DeleteProfileDialog(str5, function7, (Function0) objM, gapComposer, 384);
                Unit unit6 = Unit.INSTANCE;
            }
            gapComposer.end(r5);
            hwidLimitMarker = (HwidLimitMarker) mutableStateCollectAsState12.getValue();
            if (hwidLimitMarker != null) {
                String str6 = hwidLimitMarker.supportURL;
                gapComposer.startReplaceGroup(-949696250);
                zChangedInstance2 = gapComposer.changedInstance(profilesViewModel);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue3 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(12, profilesViewModel);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(12, profilesViewModel);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                gapComposer.end(r5);
                HwidLimitDialogKt.HwidLimitDialog(str6, (Function0) objRememberedValue3, gapComposer, r5);
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
            z3 = z6;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    ((Integer) obj4).getClass();
                    zzit.ProfilesScreen(function0, function1, paddingValuesImpl, modifier2, z3, (GapComposer) obj3, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
