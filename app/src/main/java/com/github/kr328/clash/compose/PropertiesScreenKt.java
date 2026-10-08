package com.github.kr328.clash.compose;

import android.content.res.Resources;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.network.HttpException;
import com.github.kr328.clash.LogcatActivity$$ExternalSyntheticLambda4;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzjp;
import com.koala.clash.R;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PropertiesScreenKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.PropertiesScreenKt$PropertiesScreen$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Function2 {
        public final /* synthetic */ Function0 $onCommit;
        public final /* synthetic */ boolean $processing;
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass2(boolean z, Function0 function0, int i) {
            this.$r8$classId = i;
            this.$processing = z;
            this.$onCommit = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        PropertiesScreenKt.SaveBar(this.$processing, this.$onCommit, gapComposer, 0);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        ImageVector folder = FolderKt.getFolder();
                        String strStringResource = StringResources_androidKt.stringResource(R.string.browse_files, gapComposer2);
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.browse_configuration_providers, gapComposer2);
                        gapComposer2.startReplaceGroup(1926086458);
                        boolean z = this.$processing;
                        boolean zChanged = gapComposer2.changed(z);
                        Function0 function0 = this.$onCommit;
                        boolean zChanged2 = zChanged | gapComposer2.changed(function0);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue == Composer$Companion.Empty) {
                            objRememberedValue = new ContextMenuUiKt$$ExternalSyntheticLambda4(z, function0, 1);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer2.end(false);
                        PropertiesScreenKt.NavigationRow(folder, strStringResource, strStringResource2, this.$processing, (Function0) objRememberedValue, gapComposer2, 0);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public static final void ExitWithoutSaveDialog(Function0 function0, Function0 function1, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(2125822815);
        int i2 = i | (gapComposer.changedInstance(function0) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16);
        if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            ScrimKt.m263AlertDialogOix01E0(function1, Thread_jvmKt.rememberComposableLambda(-1785321049, new UpdateDialogKt.AnonymousClass1(2, function0), gapComposer), null, Thread_jvmKt.rememberComposableLambda(1561594281, new LogsScreenKt.AnonymousClass2(function1, appColors, 7), gapComposer), null, Thread_jvmKt.rememberComposableLambda(613542315, new LogsScreenKt.AnonymousClass6(appColors, 15), gapComposer), Thread_jvmKt.rememberComposableLambda(139516332, new LogsScreenKt.AnonymousClass6(appColors, 16), gapComposer), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(20), BrushKt.m414compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground), 0L, 0L, 0L, 0.0f, null, gapComposer, ((i2 >> 3) & 14) | 1772592, 15892);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PropertiesScreenKt$$ExternalSyntheticLambda10(function0, function1, i, 0);
        }
    }

    public static final void FieldRow(ImageVector imageVector, String str, String str2, String str3, boolean z, Function0 function0, GapComposer gapComposer, int i) {
        long jColor;
        long jColor2;
        long jColor3;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-933283365);
        int i2 = (gapComposer2.changed(imageVector) ? 4 : 2) | i | (gapComposer2.changed(str) ? 32 : 16) | (gapComposer2.changed(str2) ? 256 : 128) | (gapComposer2.changed(str3) ? 2048 : 1024);
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer2.changedInstance(function0) ? 131072 : 65536;
        }
        if ((74899 & i2) == 74898 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            float f = 14;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f);
            if (z) {
                jColor = appColors.textPrimary;
            } else {
                long j = appColors.textSecondary;
                jColor = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.6f, Color.m438getColorSpaceimpl(j));
            }
            if (z) {
                jColor2 = appColors.textSecondary;
            } else {
                long j2 = appColors.textSecondary;
                jColor2 = BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.6f, Color.m438getColorSpaceimpl(j2));
            }
            long j3 = jColor2;
            if (z) {
                jColor3 = str2.length() == 0 ? appColors.textSecondary : appColors.textPrimary;
            } else {
                long j4 = appColors.textSecondary;
                jColor3 = BrushKt.Color(Color.m440getRedimpl(j4), Color.m439getGreenimpl(j4), Color.m437getBlueimpl(j4), 0.7f, Color.m438getColorSpaceimpl(j4));
            }
            long j5 = jColor3;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, appColors.cardBorder, ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), roundedCornerShapeM158RoundedCornerShape0680j_4), appColors.cardBackground, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4), z, null, function0, 14), 16, 12);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
            long j6 = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j6 ^ (j6 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM129paddingVpY3zN4);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i3);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(companion, 22), jColor, gapComposer, (i2 & 14) | 432, 0);
            OffsetKt.Spacer(gapComposer, SizeKt.m144width3ABfNKs(companion, f));
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer, 0);
            long j7 = gapComposer.compositeKeyHashCode;
            int i4 = (int) (j7 ^ (j7 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, layoutWeightElement);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelMedium;
            FontWeight fontWeight = FontWeight.Medium;
            TextKt.m275TextNvy7gAk(str, null, j3, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, ((i2 >> 3) & 14) | 1572864, 0, 131002);
            OffsetKt.Spacer(gapComposer, SizeKt.m135height3ABfNKs(companion, 2));
            String str4 = str2.length() == 0 ? str3 : str2;
            TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleMedium;
            if (str2.length() == 0) {
                fontWeight = FontWeight.Normal;
            }
            TextKt.m275TextNvy7gAk(str4, null, j5, 0L, new FontStyle(str2.length() == 0 ? 1 : 0), fontWeight, 0L, null, 0L, 0, false, 1, 0, textStyle2, gapComposer, 0, 24576, 114586);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CheckboxKt$$ExternalSyntheticLambda4(imageVector, str, str2, str3, z, function0, i);
        }
    }

    public static final void FieldsSection(String str, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1439606178);
        if (((i | (gapComposer2.changed(str) ? 4 : 2)) & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(8), Alignment.Companion.Start, gapComposer2, 6);
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
            TextKt.m275TextNvy7gAk(str.toUpperCase(Locale.ROOT), OffsetKt.m132paddingqDBjuR0$default(companion, 6, 0.0f, 0.0f, 0.0f, 14), appColors.textSecondary, TextUnitKt.getSp(11), null, FontWeight.SemiBold, TextUnitKt.getSp(0.6d), null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 102260784, 0, 130728);
            gapComposer2 = gapComposer;
            composableLambdaImpl.invoke((Object) gapComposer2, (Object) 6);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BasicTooltipKt$$ExternalSyntheticLambda7(str, composableLambdaImpl, i, 1);
        }
    }

    public static final void HelperText(String str, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(1487444332);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2);
        if ((i2 & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            TextKt.m275TextNvy7gAk(str, OffsetKt.m132paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 22, 2, 4, 0.0f, 8), ((AppColors) gapComposer.consume(AppColorsKt.LocalAppColors)).textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodySmall, gapComposer, (i2 & 14) | 48, 0, 131064);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SheetDefaultsKt$$ExternalSyntheticLambda0(str, i);
        }
    }

    public static final void NavigationRow(ImageVector imageVector, String str, String str2, boolean z, Function0 function0, GapComposer gapComposer, int i) {
        long jColor;
        char c;
        long jColor2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1986626438);
        int i2 = i | (gapComposer2.changed(imageVector) ? 4 : 2) | (gapComposer2.changed(str) ? 32 : 16) | (gapComposer2.changed(str2) ? 256 : 128) | (gapComposer2.changed(z) ? 2048 : 1024) | (gapComposer2.changedInstance(function0) ? 16384 : 8192);
        if ((i2 & 9363) == 9362 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            float f = 14;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f);
            if (z) {
                jColor = appColors.textPrimary;
            } else {
                long j = appColors.textSecondary;
                jColor = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.6f, Color.m438getColorSpaceimpl(j));
            }
            if (z) {
                c = ' ';
                jColor2 = appColors.textSecondary;
            } else {
                c = ' ';
                long j2 = appColors.textSecondary;
                jColor2 = BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.6f, Color.m438getColorSpaceimpl(j2));
            }
            long j3 = jColor2;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, appColors.cardBorder, ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), roundedCornerShapeM158RoundedCornerShape0680j_4), appColors.cardBackground, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4), z, null, function0, 14), 16, f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j4 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j4 ^ (j4 >>> c));
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
            long j5 = jColor;
            IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(companion, 22), j5, gapComposer2, (i2 & 14) | 432, 0);
            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, f));
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
            long j6 = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j6 ^ (j6 >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, layoutWeightElement);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt.m275TextNvy7gAk(str, null, j5, 0L, null, FontWeight.Medium, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer, ((i2 >> 3) & 14) | 1572864, 0, 131002);
            TextKt.m275TextNvy7gAk(str2, null, j3, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, (i2 >> 6) & 14, 0, 131066);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            IconKt.m249Iconww6aTOc(Encoder.DefaultImpls.getKeyboardArrowRight(), null, SizeKt.m140size3ABfNKs(companion, 20), j5, gapComposer2, 432, 0);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PropertiesScreenKt$$ExternalSyntheticLambda17(imageVector, str, str2, z, function0, i);
        }
    }

    public static final void ProfileHero(Profile profile, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1016181766);
        if (((i | (gapComposer2.changedInstance(profile) ? 4 : 2)) & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            float f = 4;
            Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 0.0f, f, 0.0f, f, 5);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(12), Alignment.Companion.CenterHorizontally, gapComposer2, 54);
            long j = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM132paddingqDBjuR0$default);
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
            zzjp.m820ProfileAvataruFdPcIQ(null, 72, profile.profileImagePath, gapComposer2, 48);
            gapComposer2.startReplaceGroup(1892327484);
            String strStringResource = profile.name;
            if (strStringResource.length() == 0) {
                strStringResource = StringResources_androidKt.stringResource(R.string.profile_name, gapComposer2);
            }
            gapComposer2.end(false);
            TextKt.m275TextNvy7gAk(strStringResource, null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, new TextAlign(3), 0L, 0, false, 2, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall, gapComposer, 1572864, 24576, 113594);
            gapComposer2 = gapComposer;
            TypeChip(profile.type, gapComposer2, 0);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Updater$$ExternalSyntheticLambda0(i, 27, profile);
        }
    }

    public static final void PropertiesScreen(final Profile profile, boolean z, final boolean z2, final Function1 function1, Function0 function0, final Function0 function2, Function0 function3, Modifier modifier, GapComposer gapComposer, int i) {
        Modifier modifier2;
        final Profile profile2 = profile;
        gapComposer.startRestartGroup(197044144);
        if (((i | (gapComposer.changedInstance(profile2) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changed(z2) ? 256 : 128) | (gapComposer.changedInstance(function0) ? 16384 : 8192) | (gapComposer.changedInstance(function2) ? 131072 : 65536) | (gapComposer.changedInstance(function3) ? 1048576 : 524288) | 12582912) & 4793491) == 4793490 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(2022604472);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objM = Density.CC.m(2022606392, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM);
            }
            final MutableState mutableState2 = (MutableState) objM;
            Object objM2 = Density.CC.m(2022608472, gapComposer, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM2);
            }
            final MutableState mutableState3 = (MutableState) objM2;
            gapComposer.end(false);
            Profile.Type type = profile2.type;
            Profile.Type type2 = Profile.Type.File;
            boolean z3 = (type == type2 || type == Profile.Type.External) ? false : true;
            final boolean z4 = type != type2;
            final boolean z5 = z3;
            profile2 = profile;
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1051182740, new LogsScreenKt.AnonymousClass2(appColors, function3, 9), gapComposer), Thread_jvmKt.rememberComposableLambda(-1466509557, new AnonymousClass2(z, function0, 0), gapComposer), null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(114176641, new Function3() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt.PropertiesScreen.3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(ImageKt.verticalScroll$default(OffsetKt.m132paddingqDBjuR0$default(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), 0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues.mo117calculateBottomPaddingD9Ej5fM(), 5), ImageKt.rememberScrollState(gapComposer2)), 16, 0.0f, 2);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(20), Alignment.Companion.Start, gapComposer2, 6);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i2 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM130paddingVpY3zN4$default);
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
                        Profile profile3 = profile;
                        PropertiesScreenKt.ProfileHero(profile3, gapComposer2, 0);
                        PropertiesScreenKt.FieldsSection(StringResources_androidKt.stringResource(R.string.profile, gapComposer2), Thread_jvmKt.rememberComposableLambda(1714035991, new LogsScreenKt.AnonymousClass1.AnonymousClass3.AnonymousClass2(2, profile3, mutableState), gapComposer2), gapComposer2, 48);
                        gapComposer2.startReplaceGroup(729012965);
                        if (profile3.type != Profile.Type.File) {
                            PropertiesScreenKt.FieldsSection(StringResources_androidKt.stringResource(R.string.url, gapComposer2), Thread_jvmKt.rememberComposableLambda(1918904818, new FilesScreenKt.C00191(profile3, z5, z4, mutableState2, mutableState3), gapComposer2), gapComposer2, 48);
                        }
                        gapComposer2.end(false);
                        PropertiesScreenKt.FieldsSection(StringResources_androidKt.stringResource(R.string.files, gapComposer2), Thread_jvmKt.rememberComposableLambda(763120590, new AnonymousClass2(z2, function2, 1), gapComposer2), gapComposer2, 48);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(Modifier.Companion.$$INSTANCE, 8));
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306800, 440);
            GapComposer gapComposer2 = gapComposer;
            gapComposer2.startReplaceGroup(2022748860);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                String strStringResource = StringResources_androidKt.stringResource(R.string.name, gapComposer2);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.profile_name, gapComposer2);
                String str = profile2.name;
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.should_not_be_blank, gapComposer2);
                gapComposer2.startReplaceGroup(2022757737);
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new AsyncImagePainter$$ExternalSyntheticLambda0(8);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                Function1 function4 = (Function1) objRememberedValue2;
                gapComposer2.end(false);
                gapComposer2.startReplaceGroup(2022760933);
                boolean zChangedInstance = gapComposer2.changedInstance(profile2);
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                    final int i2 = 0;
                    objRememberedValue3 = new Function1() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            switch (i2) {
                                case 0:
                                    mutableState.setValue(Boolean.FALSE);
                                    function1.invoke(Profile.copy$default(profile2, (String) obj, null, 0L, 32765));
                                    break;
                                case 1:
                                    mutableState.setValue(Boolean.FALSE);
                                    function1.invoke(Profile.copy$default(profile2, null, (String) obj, 0L, 32759));
                                    break;
                                default:
                                    mutableState.setValue(Boolean.FALSE);
                                    Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull((String) obj);
                                    function1.invoke(Profile.copy$default(profile2, null, null, TimeUnit.MINUTES.toMillis(longOrNull != null ? longOrNull.longValue() : 0L), 32735));
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                Function1 function5 = (Function1) objRememberedValue3;
                Object objM3 = Density.CC.m(2022759184, gapComposer2, false);
                if (objM3 == neverEqualPolicy) {
                    objM3 = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 18);
                    gapComposer2.updateRememberedValue(objM3);
                }
                gapComposer2.end(false);
                m803TextInputDialogCBfj69M(strStringResource, strStringResource2, str, strStringResource3, function4, function5, (Function0) objM3, 0, gapComposer2, 1597440, 128);
                gapComposer2 = gapComposer2;
            }
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(2022765751);
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                String strStringResource4 = StringResources_androidKt.stringResource(R.string.url, gapComposer2);
                String strStringResource5 = StringResources_androidKt.stringResource(R.string.profile_url, gapComposer2);
                String str2 = profile2.source;
                String strStringResource6 = StringResources_androidKt.stringResource(R.string.accept_http_content, gapComposer2);
                gapComposer2.startReplaceGroup(2022774597);
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new AsyncImagePainter$$ExternalSyntheticLambda0(9);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                }
                Function1 function6 = (Function1) objRememberedValue4;
                gapComposer2.end(false);
                gapComposer2.startReplaceGroup(2022781606);
                boolean zChangedInstance2 = gapComposer2.changedInstance(profile2);
                Object objRememberedValue5 = gapComposer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                    final int i3 = 1;
                    objRememberedValue5 = new Function1() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            switch (i3) {
                                case 0:
                                    mutableState2.setValue(Boolean.FALSE);
                                    function1.invoke(Profile.copy$default(profile2, (String) obj, null, 0L, 32765));
                                    break;
                                case 1:
                                    mutableState2.setValue(Boolean.FALSE);
                                    function1.invoke(Profile.copy$default(profile2, null, (String) obj, 0L, 32759));
                                    break;
                                default:
                                    mutableState2.setValue(Boolean.FALSE);
                                    Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull((String) obj);
                                    function1.invoke(Profile.copy$default(profile2, null, null, TimeUnit.MINUTES.toMillis(longOrNull != null ? longOrNull.longValue() : 0L), 32735));
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue5);
                }
                Function1 function7 = (Function1) objRememberedValue5;
                Object objM4 = Density.CC.m(2022779887, gapComposer2, false);
                if (objM4 == neverEqualPolicy) {
                    objM4 = new TooltipKt$$ExternalSyntheticLambda0(mutableState2, 19);
                    gapComposer2.updateRememberedValue(objM4);
                }
                gapComposer2.end(false);
                GapComposer gapComposer3 = gapComposer2;
                m803TextInputDialogCBfj69M(strStringResource4, strStringResource5, str2, strStringResource6, function6, function7, (Function0) objM4, 0, gapComposer3, 1597440, 128);
                gapComposer2 = gapComposer3;
            }
            gapComposer2.end(false);
            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                long minutes = TimeUnit.MILLISECONDS.toMinutes(profile2.interval);
                String strStringResource7 = StringResources_androidKt.stringResource(R.string.auto_update, gapComposer2);
                String strStringResource8 = StringResources_androidKt.stringResource(R.string.auto_update_minutes, gapComposer2);
                String strValueOf = minutes == 0 ? "" : String.valueOf(minutes);
                String strStringResource9 = StringResources_androidKt.stringResource(R.string.at_least_15_minutes, gapComposer2);
                gapComposer2.startReplaceGroup(2022801384);
                Object objRememberedValue6 = gapComposer2.rememberedValue();
                if (objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new AsyncImagePainter$$ExternalSyntheticLambda0(10);
                    gapComposer2.updateRememberedValue(objRememberedValue6);
                }
                Function1 function8 = (Function1) objRememberedValue6;
                gapComposer2.end(false);
                gapComposer2.startReplaceGroup(2022805775);
                boolean zChangedInstance3 = gapComposer2.changedInstance(profile2);
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue7 == neverEqualPolicy) {
                    final int i4 = 2;
                    objRememberedValue7 = new Function1() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            switch (i4) {
                                case 0:
                                    mutableState3.setValue(Boolean.FALSE);
                                    function1.invoke(Profile.copy$default(profile2, (String) obj, null, 0L, 32765));
                                    break;
                                case 1:
                                    mutableState3.setValue(Boolean.FALSE);
                                    function1.invoke(Profile.copy$default(profile2, null, (String) obj, 0L, 32759));
                                    break;
                                default:
                                    mutableState3.setValue(Boolean.FALSE);
                                    Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull((String) obj);
                                    function1.invoke(Profile.copy$default(profile2, null, null, TimeUnit.MINUTES.toMillis(longOrNull != null ? longOrNull.longValue() : 0L), 32735));
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                }
                Function1 function9 = (Function1) objRememberedValue7;
                Object objM5 = Density.CC.m(2022803796, gapComposer2, false);
                if (objM5 == neverEqualPolicy) {
                    objM5 = new TooltipKt$$ExternalSyntheticLambda0(mutableState3, 20);
                    gapComposer2.updateRememberedValue(objM5);
                }
                gapComposer2.end(false);
                m803TextInputDialogCBfj69M(strStringResource7, strStringResource8, strValueOf, strStringResource9, function8, function9, (Function0) objM5, 3, gapComposer2, 14180352, 0);
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PropertiesScreenKt$$ExternalSyntheticLambda9(profile2, z, z2, function1, function0, function2, function3, modifier2, i);
        }
    }

    public static final void SaveBar(boolean z, Function0 function0, GapComposer gapComposer, int i) {
        long jColor;
        boolean z2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1079956312);
        if (((i | (gapComposer2.changed(z) ? 4 : 2) | (gapComposer2.changedInstance(function0) ? 32 : 16)) & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(14);
            if (z) {
                long j = appColors.accentFill;
                jColor = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.4f, Color.m438getColorSpaceimpl(j));
            } else {
                jColor = appColors.accentFill;
            }
            long j2 = !z ? appColors.accentBorder : appColors.cardBorder;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            long j3 = appColors.appBackground;
            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = BrushKt.RectangleShape;
            float f = 16;
            Modifier modifierM131paddingqDBjuR0 = OffsetKt.m131paddingqDBjuR0(OffsetKt.windowInsetsPadding(ImageKt.m47backgroundbw27NRU(modifierFillMaxWidth, j3, rectangleShapeKt$RectangleShape$1), OffsetKt.navigationBarsLambda), f, 12, f, 20);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j4 = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM131paddingqDBjuR0);
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
            Integer numValueOf = Integer.valueOf(i2);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            Modifier modifierM51clickableoSLSa3U$default = ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, j2, ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 52), roundedCornerShapeM158RoundedCornerShape0680j_4), jColor, rectangleShapeKt$RectangleShape$1), roundedCornerShapeM158RoundedCornerShape0680j_4), !z, null, function0, 14);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j5 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j5 ^ (j5 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM51clickableoSLSa3U$default);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i3, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            if (z) {
                gapComposer2.startReplaceGroup(966879754);
                z2 = true;
                ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(SizeKt.m140size3ABfNKs(companion, 22), appColors.textPrimary, (float) 2.5d, 0L, 0, 0.0f, gapComposer2, 390, 56);
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(967105992);
                TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.save, gapComposer2), null, appColors.textPrimary, TextUnitKt.getSp(16), null, FontWeight.Medium, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer, 1597440, 0, 130986);
                gapComposer2 = gapComposer;
                gapComposer2.end(false);
                z2 = true;
            }
            gapComposer2.end(z2);
            gapComposer2.end(z2);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogcatActivity$$ExternalSyntheticLambda4(z, function0, i, 3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0081 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0083  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:47:0x0131  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: TextInputDialog-CBfj69M, reason: not valid java name */
    public static final void m803TextInputDialogCBfj69M(final String str, final String str2, final String str3, final String str4, final Function1 function1, final Function1 function2, final Function0 function0, int i, GapComposer gapComposer, final int i2, final int i3) {
        final int i4;
        Object objRememberedValue;
        final int i5;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(-147121520);
        int i6 = i2 | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(str2) ? 32 : 16) | (gapComposer.changed(str3) ? 256 : 128) | (gapComposer.changed(str4) ? 2048 : 1024) | (gapComposer.changedInstance(function2) ? 131072 : 65536);
        int i7 = i3 & 128;
        if (i7 == 0) {
            if ((i2 & 12582912) == 0) {
                i4 = i;
                i6 |= gapComposer.changed(i4) ? 8388608 : 4194304;
            }
            if ((i6 & 4793491) == 4793490 || !gapComposer.getSkipping()) {
                if (i7 != 0) {
                    i4 = 1;
                }
                final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                long jM414compositeOverOWjLjI = BrushKt.m414compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground);
                gapComposer.startReplaceGroup(1909435314);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = Stack.mutableStateOf$default(str3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                gapComposer.end(false);
                final boolean zBooleanValue = ((Boolean) function1.invoke((String) mutableState.getValue())).booleanValue();
                ScrimKt.m263AlertDialogOix01E0(function0, Thread_jvmKt.rememberComposableLambda(-130219704, new FilesScreenKt.C00181(function2, zBooleanValue, mutableState, appColors, 1), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-960873338, new LogsScreenKt.AnonymousClass2(function0, appColors, 10), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-1791526972, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(str, appColors, 2), gapComposer), Thread_jvmKt.rememberComposableLambda(2088113507, new Function2() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$TextInputDialog$4

                    /* JADX INFO: renamed from: com.github.kr328.clash.compose.PropertiesScreenKt$TextInputDialog$4$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                    public final class AnonymousClass1 implements Function2 {
                        public final /* synthetic */ String $errorText;
                        public final /* synthetic */ int $r8$classId;

                        public /* synthetic */ AnonymousClass1(String str, int i) {
                            this.$r8$classId = i;
                            this.$errorText = str;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            switch (this.$r8$classId) {
                                case 0:
                                    GapComposer gapComposer = (GapComposer) obj;
                                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                                        gapComposer.skipToGroupEnd();
                                    } else {
                                        TextKt.m275TextNvy7gAk(this.$errorText, null, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262138);
                                    }
                                    break;
                                default:
                                    GapComposer gapComposer2 = (GapComposer) obj;
                                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        TextKt.m275TextNvy7gAk(((Resources) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(R.string.profile_delete_warn, Arrays.copyOf(new Object[]{this.$errorText}, 1)), null, 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer2, 0, 0, 131070);
                                    }
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        GapComposer gapComposer2 = (GapComposer) obj;
                        if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                            gapComposer2.skipToGroupEnd();
                        } else {
                            MutableState mutableState2 = mutableState;
                            String str5 = (String) mutableState2.getValue();
                            boolean z = zBooleanValue;
                            boolean z2 = !z;
                            gapComposer2.startReplaceGroup(-580881783);
                            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = !z ? Thread_jvmKt.rememberComposableLambda(1795532130, new AnonymousClass1(str4, 0), gapComposer2) : null;
                            gapComposer2.end(false);
                            KeyboardOptions keyboardOptions = new KeyboardOptions(i4, 123);
                            OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                            AppColors appColors2 = appColors;
                            long j = appColors2.buttonColor;
                            long j2 = appColors2.cardBorder;
                            long j3 = appColors2.textPrimary;
                            TextFieldColors textFieldColorsM252colors0hiis_0 = OutlinedTextFieldDefaults.m252colors0hiis_0(j3, j3, j3, j, j2, gapComposer2);
                            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                            gapComposer2.startReplaceGroup(-580887269);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (objRememberedValue2 == Composer$Companion.Empty) {
                                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState2, 15);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            gapComposer2.end(false);
                            OutlinedTextFieldKt.OutlinedTextField(str5, (Function1) objRememberedValue2, modifierFillMaxWidth, false, null, Thread_jvmKt.rememberComposableLambda(1951989770, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(str2, appColors2, 3), gapComposer2), composableLambdaImplRememberComposableLambda, z2, null, keyboardOptions, null, true, 0, 0, roundedCornerShapeM158RoundedCornerShape0680j_4, textFieldColorsM252colors0hiis_0, gapComposer2, 12583344, 1920888);
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(20), jM414compositeOverOWjLjI, 0L, 0L, 0L, 0.0f, null, gapComposer, 1772598, 15892);
                i5 = i4;
            } else {
                gapComposer.skipToGroupEnd();
                i5 = i4;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        PropertiesScreenKt.m803TextInputDialogCBfj69M(str, str2, str3, str4, function1, function2, function0, i5, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i6 |= 12582912;
        i4 = i;
        if ((i6 & 4793491) == 4793490) {
            if (i7 != 0) {
                i4 = 1;
            }
            final AppColors appColors2 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            long jM414compositeOverOWjLjI2 = BrushKt.m414compositeOverOWjLjI(appColors2.cardBackground, appColors2.appBackground);
            gapComposer.startReplaceGroup(1909435314);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = Stack.mutableStateOf$default(str3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            gapComposer.end(false);
            final boolean zBooleanValue2 = ((Boolean) function1.invoke((String) mutableState2.getValue())).booleanValue();
            ScrimKt.m263AlertDialogOix01E0(function0, Thread_jvmKt.rememberComposableLambda(-130219704, new FilesScreenKt.C00181(function2, zBooleanValue2, mutableState2, appColors2, 1), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-960873338, new LogsScreenKt.AnonymousClass2(function0, appColors2, 10), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-1791526972, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(str, appColors2, 2), gapComposer), Thread_jvmKt.rememberComposableLambda(2088113507, new Function2() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$TextInputDialog$4

                /* JADX INFO: renamed from: com.github.kr328.clash.compose.PropertiesScreenKt$TextInputDialog$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                public final class AnonymousClass1 implements Function2 {
                    public final /* synthetic */ String $errorText;
                    public final /* synthetic */ int $r8$classId;

                    public /* synthetic */ AnonymousClass1(String str, int i) {
                        this.$r8$classId = i;
                        this.$errorText = str;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        switch (this.$r8$classId) {
                            case 0:
                                GapComposer gapComposer = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    TextKt.m275TextNvy7gAk(this.$errorText, null, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262138);
                                }
                                break;
                            default:
                                GapComposer gapComposer2 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    TextKt.m275TextNvy7gAk(((Resources) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(R.string.profile_delete_warn, Arrays.copyOf(new Object[]{this.$errorText}, 1)), null, 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer2, 0, 0, 131070);
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        MutableState mutableState3 = mutableState2;
                        String str5 = (String) mutableState3.getValue();
                        boolean z = zBooleanValue2;
                        boolean z2 = !z;
                        gapComposer2.startReplaceGroup(-580881783);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = !z ? Thread_jvmKt.rememberComposableLambda(1795532130, new AnonymousClass1(str4, 0), gapComposer2) : null;
                        gapComposer2.end(false);
                        KeyboardOptions keyboardOptions = new KeyboardOptions(i4, 123);
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                        AppColors appColors3 = appColors2;
                        long j = appColors3.buttonColor;
                        long j2 = appColors3.cardBorder;
                        long j3 = appColors3.textPrimary;
                        TextFieldColors textFieldColorsM252colors0hiis_0 = OutlinedTextFieldDefaults.m252colors0hiis_0(j3, j3, j3, j, j2, gapComposer2);
                        RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                        gapComposer2.startReplaceGroup(-580887269);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (objRememberedValue2 == Composer$Companion.Empty) {
                            objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState3, 15);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        OutlinedTextFieldKt.OutlinedTextField(str5, (Function1) objRememberedValue2, modifierFillMaxWidth, false, null, Thread_jvmKt.rememberComposableLambda(1951989770, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(str2, appColors3, 3), gapComposer2), composableLambdaImplRememberComposableLambda, z2, null, keyboardOptions, null, true, 0, 0, roundedCornerShapeM158RoundedCornerShape0680j_4, textFieldColorsM252colors0hiis_0, gapComposer2, 12583344, 1920888);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(20), jM414compositeOverOWjLjI2, 0L, 0L, 0L, 0.0f, null, gapComposer, 1772598, 15892);
            i5 = i4;
        } else {
            if (i7 != 0) {
                i4 = 1;
            }
            final AppColors appColors3 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            long jM414compositeOverOWjLjI3 = BrushKt.m414compositeOverOWjLjI(appColors3.cardBackground, appColors3.appBackground);
            gapComposer.startReplaceGroup(1909435314);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = Stack.mutableStateOf$default(str3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue;
            gapComposer.end(false);
            final boolean zBooleanValue3 = ((Boolean) function1.invoke((String) mutableState3.getValue())).booleanValue();
            ScrimKt.m263AlertDialogOix01E0(function0, Thread_jvmKt.rememberComposableLambda(-130219704, new FilesScreenKt.C00181(function2, zBooleanValue3, mutableState3, appColors3, 1), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-960873338, new LogsScreenKt.AnonymousClass2(function0, appColors3, 10), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-1791526972, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(str, appColors3, 2), gapComposer), Thread_jvmKt.rememberComposableLambda(2088113507, new Function2() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$TextInputDialog$4

                /* JADX INFO: renamed from: com.github.kr328.clash.compose.PropertiesScreenKt$TextInputDialog$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                public final class AnonymousClass1 implements Function2 {
                    public final /* synthetic */ String $errorText;
                    public final /* synthetic */ int $r8$classId;

                    public /* synthetic */ AnonymousClass1(String str, int i) {
                        this.$r8$classId = i;
                        this.$errorText = str;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        switch (this.$r8$classId) {
                            case 0:
                                GapComposer gapComposer = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    TextKt.m275TextNvy7gAk(this.$errorText, null, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262138);
                                }
                                break;
                            default:
                                GapComposer gapComposer2 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    TextKt.m275TextNvy7gAk(((Resources) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(R.string.profile_delete_warn, Arrays.copyOf(new Object[]{this.$errorText}, 1)), null, 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer2, 0, 0, 131070);
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        MutableState mutableState4 = mutableState3;
                        String str5 = (String) mutableState4.getValue();
                        boolean z = zBooleanValue3;
                        boolean z2 = !z;
                        gapComposer2.startReplaceGroup(-580881783);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = !z ? Thread_jvmKt.rememberComposableLambda(1795532130, new AnonymousClass1(str4, 0), gapComposer2) : null;
                        gapComposer2.end(false);
                        KeyboardOptions keyboardOptions = new KeyboardOptions(i4, 123);
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                        AppColors appColors4 = appColors3;
                        long j = appColors4.buttonColor;
                        long j2 = appColors4.cardBorder;
                        long j3 = appColors4.textPrimary;
                        TextFieldColors textFieldColorsM252colors0hiis_0 = OutlinedTextFieldDefaults.m252colors0hiis_0(j3, j3, j3, j, j2, gapComposer2);
                        RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                        gapComposer2.startReplaceGroup(-580887269);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (objRememberedValue2 == Composer$Companion.Empty) {
                            objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState4, 15);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        OutlinedTextFieldKt.OutlinedTextField(str5, (Function1) objRememberedValue2, modifierFillMaxWidth, false, null, Thread_jvmKt.rememberComposableLambda(1951989770, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(str2, appColors4, 3), gapComposer2), composableLambdaImplRememberComposableLambda, z2, null, keyboardOptions, null, true, 0, 0, roundedCornerShapeM158RoundedCornerShape0680j_4, textFieldColorsM252colors0hiis_0, gapComposer2, 12583344, 1920888);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(20), jM414compositeOverOWjLjI3, 0L, 0L, 0L, 0.0f, null, gapComposer, 1772598, 15892);
            i5 = i4;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    PropertiesScreenKt.m803TextInputDialogCBfj69M(str, str2, str3, str4, function1, function2, function0, i5, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1), i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void TypeChip(Profile.Type type, GapComposer gapComposer, int i) {
        String strStringResource;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1588161650);
        if (((i | (gapComposer2.changed(type) ? 4 : 2)) & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            int iOrdinal = type.ordinal();
            if (iOrdinal == 0) {
                gapComposer2.startReplaceGroup(1473053242);
                strStringResource = StringResources_androidKt.stringResource(R.string.file, gapComposer2);
                gapComposer2.end(false);
            } else if (iOrdinal == 1) {
                gapComposer2.startReplaceGroup(1473051385);
                strStringResource = StringResources_androidKt.stringResource(R.string.url, gapComposer2);
                gapComposer2.end(false);
            } else {
                if (iOrdinal != 2) {
                    gapComposer2.startReplaceGroup(1473050215);
                    gapComposer2.end(false);
                    throw new HttpException();
                }
                gapComposer2.startReplaceGroup(1473055262);
                strStringResource = StringResources_androidKt.stringResource(R.string.external, gapComposer2);
                gapComposer2.end(false);
            }
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(999);
            Modifier modifierClip = ClipKt.clip(Modifier.Companion.$$INSTANCE, roundedCornerShapeM158RoundedCornerShape0680j_4);
            long j = appColors.accentFill;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m48borderxT4_qwU(1, appColors.accentBorder, ImageKt.m47backgroundbw27NRU(modifierClip, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.6f, Color.m438getColorSpaceimpl(j)), BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4), 14, 5);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j2 ^ (j2 >>> 32));
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
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextKt.m275TextNvy7gAk(strStringResource.toUpperCase(Locale.ROOT), null, appColors.textPrimary, 0L, null, FontWeight.SemiBold, TextUnitKt.getSp(0.6d), null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 102236160, 0, 130746);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Updater$$ExternalSyntheticLambda0(i, 28, type);
        }
    }
}
