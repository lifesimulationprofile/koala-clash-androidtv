package com.github.kr328.clash.compose;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.camera.core.impl.Quirks;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.material.icons.filled.MoreVertKt;
import androidx.compose.material.icons.filled.StopKt;
import androidx.compose.material.icons.filled.SwapVertKt;
import androidx.compose.material.icons.filled.TuneKt;
import androidx.compose.material.icons.filled.UploadKt;
import androidx.compose.material.icons.outlined.PublicOffKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
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
import androidx.compose.ui.unit.Density;
import androidx.core.view.MenuHostHelper;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.github.kr328.clash.compose.profiles.ComposableSingletons$ProfilesScreenKt;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt$$ExternalSyntheticLambda2;
import com.github.kr328.clash.compose.settings.SettingsEntry;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$3$1;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.core.model.ConnectionMetadata;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.design.compose.components.ComposableSingletons$PreferencesKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.design.compose.theme.TypographyKt;
import com.github.kr328.clash.design.model.AppInfoSort;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzjb;
import com.google.android.gms.internal.mlkit_vision_common.zzje;
import com.google.android.gms.internal.mlkit_vision_common.zzjl;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeSourceElement;
import dev.chrisbanes.haze.HazeState;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.Regex;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.json.JsonKt;
import okhttp3.CacheControl;
import okhttp3.CertificatePinner;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody$Companion$toRequestBody$2;
import okio.Okio;
import okio.Options$Companion;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LogsScreenKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.LogsScreenKt$LogcatRow$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Function2 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ Function0 $onClick;
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass2(AppColors appColors, Function0 function0, int i) {
            this.$r8$classId = i;
            this.$colors = appColors;
            this.$onClick = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            int i = this.$r8$classId;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            int i2 = 4;
            int i3 = 6;
            int i4 = 16;
            Function0 function0 = this.$onClick;
            int i5 = 1;
            AppColors appColors = this.$colors;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        Modifier modifierM51clickableoSLSa3U$default = ImageKt.m51clickableoSLSa3U$default(SizeKt.FillWholeMaxSize, false, null, function0, 15);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        MenuHostHelper menuHostHelper = gapComposer.applier;
                        long j = gapComposer.compositeKeyHashCode;
                        int i6 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM51clickableoSLSa3U$default);
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
                        float f = 16;
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), f, 14);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
                        long j2 = gapComposer.compositeKeyHashCode;
                        int i7 = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM129paddingVpY3zN4);
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m295setimpl(gapComposer, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i7, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        ImageVector imageVectorBuild = CacheControl.Companion._adb;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder = new ImageVector.Builder("Filled.Adb", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i8 = VectorKt.$r8$clinit;
                            SolidColor solidColor = new SolidColor(Color.Black);
                            Quirks quirks = new Quirks();
                            quirks.moveTo(5.0f, 16.0f);
                            quirks.curveToRelative(0.0f, 3.87f, 3.13f, 7.0f, 7.0f, 7.0f);
                            quirks.reflectiveCurveToRelative(7.0f, -3.13f, 7.0f, -7.0f);
                            quirks.verticalLineToRelative(-4.0f);
                            quirks.lineTo(5.0f, 12.0f);
                            quirks.verticalLineToRelative(4.0f);
                            quirks.close();
                            quirks.moveTo(16.12f, 4.37f);
                            quirks.lineToRelative(2.1f, -2.1f);
                            quirks.lineToRelative(-0.82f, -0.83f);
                            quirks.lineToRelative(-2.3f, 2.31f);
                            quirks.curveTo(14.16f, 3.28f, 13.12f, 3.0f, 12.0f, 3.0f);
                            quirks.reflectiveCurveToRelative(-2.16f, 0.28f, -3.09f, 0.75f);
                            quirks.lineTo(6.6f, 1.44f);
                            quirks.lineToRelative(-0.82f, 0.83f);
                            quirks.lineToRelative(2.1f, 2.1f);
                            quirks.curveTo(6.14f, 5.64f, 5.0f, 7.68f, 5.0f, 10.0f);
                            quirks.verticalLineToRelative(1.0f);
                            quirks.horizontalLineToRelative(14.0f);
                            quirks.verticalLineToRelative(-1.0f);
                            quirks.curveToRelative(0.0f, -2.32f, -1.14f, -4.36f, -2.88f, -5.63f);
                            quirks.close();
                            quirks.moveTo(9.0f, 9.0f);
                            quirks.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
                            quirks.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
                            quirks.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
                            quirks.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
                            quirks.close();
                            quirks.moveTo(15.0f, 9.0f);
                            quirks.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
                            quirks.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
                            quirks.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
                            quirks.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
                            quirks.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                            imageVectorBuild = builder.build();
                            CacheControl.Companion._adb = imageVectorBuild;
                        }
                        IconKt.m249Iconww6aTOc(imageVectorBuild, null, SizeKt.m140size3ABfNKs(companion, 28), appColors.textPrimary, gapComposer, 432, 0);
                        OffsetKt.Spacer(gapComposer, SizeKt.m144width3ABfNKs(companion, f));
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer, 0);
                        long j3 = gapComposer.compositeKeyHashCode;
                        int i9 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer, layoutWeightElement);
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m295setimpl(gapComposer, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i9, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.clash_logcat, gapComposer);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextKt.m275TextNvy7gAk(strStringResource, null, appColors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer, 0, 0, 131066);
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.tap_to_start, gapComposer), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 0, 0, 131066);
                        gapComposer.end(true);
                        gapComposer.end(true);
                        gapComposer.end(true);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int i10 = 2;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-482844851, new AnonymousClass6(appColors, i10), gapComposer2), gapComposer2, 1572864, 62);
                    }
                    break;
                case 2:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        int i11 = 1;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(2000960493, new AnonymousClass6(appColors, i11), gapComposer3);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(497862187, new AnonymousClass2(function0, appColors, i11), gapComposer3);
                        PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                        long j4 = Color.Transparent;
                        long j5 = appColors.textPrimary;
                        AppBarKt.m238TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda, null, composableLambdaImplRememberComposableLambda2, null, 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(j4, j4, j5, j5, 0L, gapComposer3, 48), null, gapComposer3, 390, 442);
                    }
                    break;
                case 3:
                    GapComposer gapComposer4 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        ScrimKt.TextButton(this.$onClick, null, false, null, null, null, Thread_jvmKt.rememberComposableLambda(-989496034, new AnonymousClass4.AnonymousClass2(appColors, 1), gapComposer4), gapComposer4, 805306368, 510);
                    }
                    break;
                case 4:
                    GapComposer gapComposer5 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer5.getSkipping()) {
                        gapComposer5.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-1269295859, new AnonymousClass6(appColors, i3), gapComposer5), gapComposer5, 1572864, 62);
                    }
                    break;
                case 5:
                    GapComposer gapComposer6 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer6.getSkipping()) {
                        gapComposer6.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(893794460, new AnonymousClass6(appColors, 8), gapComposer6), gapComposer6, 1572864, 62);
                    }
                    break;
                case 6:
                    GapComposer gapComposer7 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer7.getSkipping()) {
                        gapComposer7.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-1482801521, new AnonymousClass6(appColors, 13), gapComposer7), gapComposer7, 1572864, 62);
                    }
                    break;
                case 7:
                    GapComposer gapComposer8 = (GapComposer) obj;
                    int i12 = 3;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer8.getSkipping()) {
                        gapComposer8.skipToGroupEnd();
                    } else {
                        ScrimKt.TextButton(this.$onClick, null, false, null, null, null, Thread_jvmKt.rememberComposableLambda(130534694, new AnonymousClass4.AnonymousClass2(appColors, i12), gapComposer8), gapComposer8, 805306368, 510);
                    }
                    break;
                case 8:
                    GapComposer gapComposer9 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer9.getSkipping()) {
                        gapComposer9.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(64873936, new AnonymousClass6(appColors, 17), gapComposer9), gapComposer9, 1572864, 62);
                    }
                    break;
                case 9:
                    GapComposer gapComposer10 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer10.getSkipping()) {
                        gapComposer10.skipToGroupEnd();
                    } else {
                        ComposableLambdaImpl composableLambdaImpl = ComposableSingletons$PropertiesScreenKt.f19lambda1;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Thread_jvmKt.rememberComposableLambda(-1121902798, new AnonymousClass2(function0, appColors, 8), gapComposer10);
                        PaddingValuesImpl paddingValuesImpl2 = TopAppBarDefaults.ContentPadding;
                        long j6 = Color.Transparent;
                        long j7 = appColors.textPrimary;
                        AppBarKt.m238TopAppBargNPyAyM(composableLambdaImpl, null, composableLambdaImplRememberComposableLambda3, null, 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(j6, j6, j7, j7, j7, gapComposer10, 32), null, gapComposer10, 390, 442);
                    }
                    break;
                case 10:
                    GapComposer gapComposer11 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer11.getSkipping()) {
                        gapComposer11.skipToGroupEnd();
                    } else {
                        ScrimKt.TextButton(this.$onClick, null, false, null, null, null, Thread_jvmKt.rememberComposableLambda(52920361, new AnonymousClass4.AnonymousClass2(appColors, i2), gapComposer11), gapComposer11, 805306368, 510);
                    }
                    break;
                case 11:
                    GapComposer gapComposer12 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer12.getSkipping()) {
                        gapComposer12.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(1242247933, new AnonymousClass6(appColors, 20), gapComposer12), gapComposer12, 1572864, 62);
                    }
                    break;
                case 12:
                    GapComposer gapComposer13 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer13.getSkipping()) {
                        gapComposer13.skipToGroupEnd();
                    } else {
                        float f2 = 24;
                        Modifier modifierM129paddingVpY3zN5 = OffsetKt.m129paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), f2, 36);
                        ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Center, Alignment.Companion.CenterHorizontally, gapComposer13, 54);
                        long j8 = gapComposer13.compositeKeyHashCode;
                        int i13 = (int) (j8 ^ (j8 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer13.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer13, modifierM129paddingVpY3zN5);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                        gapComposer13.startReusableNode();
                        if (gapComposer13.inserting) {
                            gapComposer13.createNode(layoutNode$Companion$Constructor$2);
                        } else {
                            gapComposer13.useNode();
                        }
                        Stack.m295setimpl(gapComposer13, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer13, persistentCompositionLocalMapCurrentCompositionLocalScope4, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer13, Integer.valueOf(i13), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer13, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer13, modifierMaterializeModifier4, ComposeUiNode.Companion.SetModifier);
                        ImageVector imageVectorBuild2 = PublicOffKt._publicOff;
                        if (imageVectorBuild2 == null) {
                            ImageVector.Builder builder2 = new ImageVector.Builder("Outlined.PublicOff", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i14 = VectorKt.$r8$clinit;
                            SolidColor solidColor2 = new SolidColor(Color.Black);
                            Quirks quirks2 = new Quirks();
                            quirks2.moveTo(11.0f, 8.17f);
                            quirks2.lineTo(6.49f, 3.66f);
                            quirks2.curveTo(8.07f, 2.61f, 9.96f, 2.0f, 12.0f, 2.0f);
                            quirks2.curveToRelative(5.52f, 0.0f, 10.0f, 4.48f, 10.0f, 10.0f);
                            quirks2.curveToRelative(0.0f, 2.04f, -0.61f, 3.93f, -1.66f, 5.51f);
                            quirks2.lineToRelative(-1.46f, -1.46f);
                            quirks2.curveTo(19.59f, 14.87f, 20.0f, 13.48f, 20.0f, 12.0f);
                            quirks2.curveToRelative(0.0f, -3.35f, -2.07f, -6.22f, -5.0f, -7.41f);
                            quirks2.verticalLineTo(5.0f);
                            quirks2.curveToRelative(0.0f, 1.1f, -0.9f, 2.0f, -2.0f, 2.0f);
                            quirks2.horizontalLineToRelative(-2.0f);
                            quirks2.verticalLineTo(8.17f);
                            quirks2.close();
                            quirks2.moveTo(21.19f, 21.19f);
                            quirks2.lineToRelative(-1.41f, 1.41f);
                            quirks2.lineToRelative(-2.27f, -2.27f);
                            quirks2.curveTo(15.93f, 21.39f, 14.04f, 22.0f, 12.0f, 22.0f);
                            quirks2.curveTo(6.48f, 22.0f, 2.0f, 17.52f, 2.0f, 12.0f);
                            quirks2.curveToRelative(0.0f, -2.04f, 0.61f, -3.93f, 1.66f, -5.51f);
                            quirks2.lineTo(1.39f, 4.22f);
                            quirks2.lineToRelative(1.41f, -1.41f);
                            quirks2.lineTo(21.19f, 21.19f);
                            quirks2.close();
                            quirks2.moveTo(11.0f, 18.0f);
                            quirks2.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                            quirks2.verticalLineToRelative(-1.0f);
                            quirks2.lineToRelative(-4.79f, -4.79f);
                            quirks2.curveTo(4.08f, 10.79f, 4.0f, 11.38f, 4.0f, 12.0f);
                            quirks2.curveToRelative(0.0f, 4.08f, 3.05f, 7.44f, 7.0f, 7.93f);
                            quirks2.verticalLineTo(18.0f);
                            quirks2.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder2, quirks2.mQuirks, solidColor2);
                            imageVectorBuild2 = builder2.build();
                            PublicOffKt._publicOff = imageVectorBuild2;
                        }
                        IconKt.m249Iconww6aTOc(imageVectorBuild2, null, SizeKt.m140size3ABfNKs(companion, 72), appColors.textPrimary, gapComposer13, 432, 0);
                        OffsetKt.Spacer(gapComposer13, SizeKt.m135height3ABfNKs(companion, f2));
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.profile_no_profiles, gapComposer13);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                        TextKt.m275TextNvy7gAk(strStringResource2, null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer13.consume(staticProvidableCompositionLocal2)).typography.titleLarge, gapComposer13, 1572864, 0, 131002);
                        OffsetKt.Spacer(gapComposer13, SizeKt.m135height3ABfNKs(companion, 12));
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_add_description, gapComposer13), OffsetKt.m130paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 16, 0.0f, 2), appColors.textSecondary, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer13.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer13, 48, 0, 130040);
                        OffsetKt.Spacer(gapComposer13, SizeKt.m135height3ABfNKs(companion, f2));
                        HomeScreenKt.AddProfilePillButton(function0, gapComposer13, 0);
                        gapComposer13.end(true);
                    }
                    break;
                case 13:
                    GapComposer gapComposer14 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer14.getSkipping()) {
                        gapComposer14.skipToGroupEnd();
                    } else {
                        RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
                        PaddingValuesImpl paddingValuesImpl3 = ButtonDefaults.ContentPadding;
                        ScrimKt.Button(this.$onClick, null, false, roundedCornerShapeM158RoundedCornerShape0680j_4, ButtonDefaults.m243buttonColorsro_MJ88(appColors.cardBorder, appColors.textPrimary, gapComposer14), null, null, ComposableSingletons$ProfilesScreenKt.f26lambda2, gapComposer14, 805306368, 486);
                    }
                    break;
                case 14:
                    GapComposer gapComposer15 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer15.getSkipping()) {
                        gapComposer15.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-2031684442, new SettingsScreenKt$SettingsScreen$3$1(appColors, i5), gapComposer15), gapComposer15, 1572864, 62);
                    }
                    break;
                case 15:
                    GapComposer gapComposer16 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer16.getSkipping()) {
                        gapComposer16.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(336555688, new SettingsScreenKt$SettingsScreen$3$1(appColors, i2), gapComposer16), gapComposer16, 1572864, 62);
                    }
                    break;
                case 16:
                    GapComposer gapComposer17 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer17.getSkipping()) {
                        gapComposer17.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(1352434422, new SettingsScreenKt$SettingsScreen$3$1(appColors, i3), gapComposer17), gapComposer17, 1572864, 62);
                    }
                    break;
                case 17:
                    GapComposer gapComposer18 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer18.getSkipping()) {
                        gapComposer18.skipToGroupEnd();
                    } else {
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Thread_jvmKt.rememberComposableLambda(2031822742, new SettingsScreenKt$SettingsScreen$3$1(appColors, 5), gapComposer18);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda5 = Thread_jvmKt.rememberComposableLambda(-1776070828, new AnonymousClass2(function0, appColors, i4), gapComposer18);
                        PaddingValuesImpl paddingValuesImpl4 = TopAppBarDefaults.ContentPadding;
                        AppBarKt.m238TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda4, null, composableLambdaImplRememberComposableLambda5, null, 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(appColors.appBackground, 0L, 0L, 0L, 0L, gapComposer18, 62), null, gapComposer18, 390, 442);
                    }
                    break;
                case 18:
                    GapComposer gapComposer19 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer19.getSkipping()) {
                        gapComposer19.skipToGroupEnd();
                    } else {
                        ScrimKt.IconButton(this.$onClick, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-1263231355, new SettingsScreenKt$SettingsScreen$3$1(appColors, 7), gapComposer19), gapComposer19, 1572864, 62);
                    }
                    break;
                default:
                    GapComposer gapComposer20 = (GapComposer) obj;
                    if ((3 & ((Number) obj2).intValue()) == 2 && gapComposer20.getSkipping()) {
                        gapComposer20.skipToGroupEnd();
                    } else {
                        ScrimKt.TextButton(this.$onClick, null, false, null, null, null, Thread_jvmKt.rememberComposableLambda(-360916281, new AnonymousClass4.AnonymousClass2(appColors, 9), gapComposer20), gapComposer20, 805306368, 510);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public /* synthetic */ AnonymousClass2(Function0 function0, AppColors appColors, int i) {
            this.$r8$classId = i;
            this.$onClick = function0;
            this.$colors = appColors;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.LogsScreenKt$LogsScreen$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00212 implements Function3 {
        public final /* synthetic */ Object $colors;
        public final /* synthetic */ Object $hazeState;
        public final /* synthetic */ boolean $isTv;
        public final /* synthetic */ Object $logs;
        public final /* synthetic */ Function1 $onOpenLog;
        public final /* synthetic */ Object $onStartLogcat;
        public final /* synthetic */ int $r8$classId = 2;

        public C00212(AppColors appColors, boolean z, HazeState hazeState, List list, Set set, Function1 function1) {
            this.$colors = appColors;
            this.$isTv = z;
            this.$hazeState = hazeState;
            this.$logs = list;
            this.$onStartLogcat = set;
            this.$onOpenLog = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Modifier modifier;
            Modifier modifierM129paddingVpY3zN4;
            GapComposer gapComposer;
            PaddingValuesImpl paddingValuesImpl;
            int i = this.$r8$classId;
            Function1 function1 = this.$onOpenLog;
            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = BrushKt.RectangleShape;
            Object obj4 = this.$onStartLogcat;
            Object obj5 = this.$logs;
            Object obj6 = this.$hazeState;
            Object obj7 = this.$colors;
            int i2 = 2;
            boolean z = this.$isTv;
            switch (i) {
                case 0:
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    AppColors appColors = (AppColors) obj7;
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, rectangleShapeKt$RectangleShape$1);
                        Modifier modifierM132paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                        Modifier modifierThen = modifierM47backgroundbw27NRU.then(!z ? modifierM132paddingqDBjuR0$default.then(new HazeSourceElement((HazeState) obj6)) : modifierM132paddingqDBjuR0$default);
                        if (z) {
                            modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(modifierM132paddingqDBjuR0$default, 0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues.mo117calculateBottomPaddingD9Ej5fM(), 5);
                            modifier = modifierM132paddingqDBjuR0$default;
                        } else {
                            modifier = modifierM132paddingqDBjuR0$default;
                        }
                        Modifier modifierVerticalScroll$default = ImageKt.verticalScroll$default(modifierThen.then(modifierM132paddingqDBjuR0$default), ImageKt.rememberScrollState(gapComposer2));
                        if (z) {
                            modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(modifier, 16, 8);
                        } else {
                            float f = 8;
                            float fMo120calculateTopPaddingD9Ej5fM = paddingValues.mo120calculateTopPaddingD9Ej5fM() + f;
                            float fMo117calculateBottomPaddingD9Ej5fM = paddingValues.mo117calculateBottomPaddingD9Ej5fM() + f;
                            float f2 = 16;
                            modifierM129paddingVpY3zN4 = OffsetKt.m131paddingqDBjuR0(modifier, f2, fMo120calculateTopPaddingD9Ej5fM, f2, fMo117calculateBottomPaddingD9Ej5fM);
                        }
                        Modifier modifierThen2 = modifierVerticalScroll$default.then(modifierM129paddingVpY3zN4);
                        float f3 = 8;
                        Function0 function0 = (Function0) obj4;
                        List<LogFile> list = (List) obj5;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(f3), Alignment.Companion.Start, gapComposer2, 6);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i3 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierThen2);
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
                        LogsScreenKt.LogcatRow(function0, gapComposer2, 0);
                        gapComposer2.startReplaceGroup(215090628);
                        if (list.isEmpty()) {
                            gapComposer = gapComposer2;
                        } else {
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.history, gapComposer2), OffsetKt.m132paddingqDBjuR0$default(modifier, f3, 16, 0.0f, 4, 4), appColors.textSecondary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge, gapComposer2, 1572912, 0, 131000);
                            gapComposer = gapComposer2;
                            for (LogFile logFile : list) {
                                gapComposer.startReplaceGroup(518818242);
                                boolean zChanged = gapComposer.changed(function1) | gapComposer.changedInstance(logFile);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                                    objRememberedValue = new Recomposer$$ExternalSyntheticLambda6(24, function1, logFile);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                gapComposer.end(false);
                                Regex regex = LogFile.REGEX_FILE;
                                LogsScreenKt.LogFileRow(logFile, (Function0) objRememberedValue, gapComposer, 8);
                            }
                        }
                        gapComposer.end(false);
                        gapComposer.end(true);
                    }
                    break;
                case 1:
                    GapComposer gapComposer3 = (GapComposer) obj2;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        Modifier modifierM129paddingVpY3zN5 = OffsetKt.m129paddingVpY3zN4(SizeKt.m144width3ABfNKs(Modifier.Companion.$$INSTANCE, 300), 16, 14);
                        TunnelState.Mode mode = (TunnelState.Mode) obj7;
                        TunnelState.Mode mode2 = (TunnelState.Mode) obj6;
                        ProxySort proxySort = (ProxySort) obj4;
                        Function1 function2 = (Function1) obj5;
                        ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(18), Alignment.Companion.Start, gapComposer3, 6);
                        long j2 = gapComposer3.compositeKeyHashCode;
                        int i4 = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM129paddingVpY3zN5);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$2);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer3, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                        gapComposer3.startReplaceGroup(1910885625);
                        if (z) {
                            ProxyScreenKt.SettingsSection(StringResources_androidKt.stringResource(R.string.mode, gapComposer3), Thread_jvmKt.rememberComposableLambda(1575669499, new MainAppKt$MainApp$2$3$1$1$1$2.AnonymousClass1(mode, mode2, function1, i2), gapComposer3), gapComposer3, 48);
                        }
                        gapComposer3.end(false);
                        ProxyScreenKt.SettingsSection(StringResources_androidKt.stringResource(R.string.sort, gapComposer3), Thread_jvmKt.rememberComposableLambda(-246313034, new AnonymousClass1.AnonymousClass3.AnonymousClass2(5, proxySort, function2), gapComposer3), gapComposer3, 48);
                        gapComposer3.end(true);
                    }
                    break;
                default:
                    PaddingValues paddingValues2 = (PaddingValues) obj;
                    GapComposer gapComposer4 = (GapComposer) obj2;
                    int iIntValue2 = ((Number) obj3).intValue();
                    if ((iIntValue2 & 6) == 0) {
                        iIntValue2 |= gapComposer4.changed(paddingValues2) ? 4 : 2;
                    }
                    if ((iIntValue2 & 19) == 18 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        Modifier modifierM47backgroundbw27NRU2 = ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, ((AppColors) obj7).appBackground, rectangleShapeKt$RectangleShape$1);
                        Modifier modifierM132paddingqDBjuR0$default2 = Modifier.Companion.$$INSTANCE;
                        Modifier modifierThen3 = modifierM47backgroundbw27NRU2.then(!z ? modifierM132paddingqDBjuR0$default2.then(new HazeSourceElement((HazeState) obj6)) : modifierM132paddingqDBjuR0$default2);
                        if (z) {
                            modifierM132paddingqDBjuR0$default2 = OffsetKt.m132paddingqDBjuR0$default(modifierM132paddingqDBjuR0$default2, 0.0f, paddingValues2.mo120calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues2.mo117calculateBottomPaddingD9Ej5fM(), 5);
                        }
                        Modifier modifierThen4 = modifierThen3.then(modifierM132paddingqDBjuR0$default2);
                        if (z) {
                            float f4 = 16;
                            float f5 = 8;
                            paddingValuesImpl = new PaddingValuesImpl(f4, f5, f4, f5);
                        } else {
                            float f6 = 16;
                            paddingValuesImpl = new PaddingValuesImpl(f6, paddingValues2.mo120calculateTopPaddingD9Ej5fM() + 8, f6, paddingValues2.mo117calculateBottomPaddingD9Ej5fM() + f6);
                        }
                        zzjb.AppList((List) obj5, (Set) obj4, this.$onOpenLog, paddingValuesImpl, modifierThen4, this.$isTv, gapComposer4, 0, 0);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public C00212(AppColors appColors, boolean z, HazeState hazeState, Function0 function0, List list, Function1 function1) {
            this.$colors = appColors;
            this.$isTv = z;
            this.$hazeState = hazeState;
            this.$onStartLogcat = function0;
            this.$logs = list;
            this.$onOpenLog = function1;
        }

        public C00212(boolean z, TunnelState.Mode mode, TunnelState.Mode mode2, Function1 function1, ProxySort proxySort, Function1 function2) {
            this.$isTv = z;
            this.$colors = mode;
            this.$hazeState = mode2;
            this.$onOpenLog = function1;
            this.$onStartLogcat = proxySort;
            this.$logs = function2;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.LogsScreenKt$LogsScreen$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass4 implements Function2 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ MutableState $deleteDialogOpen$delegate;
        public final /* synthetic */ Function0 $onDeleteAll;
        public final /* synthetic */ int $r8$classId;

        /* JADX INFO: renamed from: com.github.kr328.clash.compose.LogsScreenKt$LogsScreen$4$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class AnonymousClass2 implements Function3 {
            public final /* synthetic */ AppColors $colors;
            public final /* synthetic */ int $r8$classId;

            public /* synthetic */ AnonymousClass2(AppColors appColors, int i) {
                this.$r8$classId = i;
                this.$colors = appColors;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                switch (this.$r8$classId) {
                    case 0:
                        GapComposer gapComposer = (GapComposer) obj2;
                        if ((((Number) obj3).intValue() & 17) == 16 && gapComposer.getSkipping()) {
                            gapComposer.skipToGroupEnd();
                        } else {
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.ok, gapComposer), null, this.$colors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262138);
                        }
                        break;
                    case 1:
                        GapComposer gapComposer2 = (GapComposer) obj2;
                        if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                            gapComposer2.skipToGroupEnd();
                        } else {
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.cancel, gapComposer2), null, this.$colors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262138);
                        }
                        break;
                    case 2:
                        GapComposer gapComposer3 = (GapComposer) obj2;
                        if ((((Number) obj3).intValue() & 17) == 16 && gapComposer3.getSkipping()) {
                            gapComposer3.skipToGroupEnd();
                        } else {
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.cancel, gapComposer3), null, this.$colors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262138);
                        }
                        break;
                    case 3:
                        GapComposer gapComposer4 = (GapComposer) obj2;
                        if ((((Number) obj3).intValue() & 17) == 16 && gapComposer4.getSkipping()) {
                            gapComposer4.skipToGroupEnd();
                        } else {
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.cancel, gapComposer4), null, this.$colors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262138);
                        }
                        break;
                    case 4:
                        GapComposer gapComposer5 = (GapComposer) obj2;
                        if ((((Number) obj3).intValue() & 17) == 16 && gapComposer5.getSkipping()) {
                            gapComposer5.skipToGroupEnd();
                        } else {
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.cancel, gapComposer5), null, this.$colors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262138);
                        }
                        break;
                    case 5:
                        ((Number) obj3).intValue();
                        float f = 4;
                        Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), f, 16, f, 0.0f, 8);
                        AppColors appColors = this.$colors;
                        ProgressIndicatorKt.m257LinearProgressIndicatorrIrjwxo(modifierM132paddingqDBjuR0$default, appColors.textPrimary, appColors.cardBorder, 0, 0.0f, (GapComposer) obj2, 0);
                        break;
                    case 6:
                        GapComposer gapComposer6 = (GapComposer) obj2;
                        ((Number) obj3).intValue();
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierM132paddingqDBjuR0$default2 = OffsetKt.m132paddingqDBjuR0$default(companion, 0.0f, 10, 0.0f, 0.0f, 13);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer6, 0);
                        long j = gapComposer6.compositeKeyHashCode;
                        int i = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer6.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer6, modifierM132paddingqDBjuR0$default2);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer6.startReusableNode();
                        if (gapComposer6.inserting) {
                            gapComposer6.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer6.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer6, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer6, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer6, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer6, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer6, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer6, 48);
                        long j2 = gapComposer6.compositeKeyHashCode;
                        int i2 = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer6.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer6, companion);
                        gapComposer6.startReusableNode();
                        if (gapComposer6.inserting) {
                            gapComposer6.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer6.useNode();
                        }
                        Stack.m295setimpl(gapComposer6, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer6, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i2, gapComposer6, composeUiNode$Companion$SetModifier$3, gapComposer6, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer6, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.profile_updating, gapComposer6);
                        TextStyle textStyle = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).typography.bodySmall;
                        AppColors appColors2 = this.$colors;
                        TextKt.m275TextNvy7gAk(strStringResource, null, appColors2.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer6, 0, 0, 131066);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        OffsetKt.Spacer(gapComposer6, new LayoutWeightElement(1.0f, true));
                        gapComposer6.end(true);
                        OffsetKt.Spacer(gapComposer6, SizeKt.m135height3ABfNKs(companion, 4));
                        ProgressIndicatorKt.m257LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth(companion, 1.0f), appColors2.textPrimary, appColors2.cardBorder, 0, 0.0f, gapComposer6, 6);
                        gapComposer6.end(true);
                        break;
                    case 7:
                        GapComposer gapComposer7 = (GapComposer) obj2;
                        ((Number) obj3).intValue();
                        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                        Modifier modifierM132paddingqDBjuR0$default3 = OffsetKt.m132paddingqDBjuR0$default(companion2, 0.0f, 10, 0.0f, 0.0f, 13);
                        ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer7, 0);
                        long j3 = gapComposer7.compositeKeyHashCode;
                        int i3 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer7.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer7, modifierM132paddingqDBjuR0$default3);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                        gapComposer7.startReusableNode();
                        if (gapComposer7.inserting) {
                            gapComposer7.createNode(layoutNode$Companion$Constructor$2);
                        } else {
                            gapComposer7.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$5 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer7, columnMeasurePolicy2, composeUiNode$Companion$SetModifier$5);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$6 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer7, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$6);
                        Integer numValueOf2 = Integer.valueOf(i3);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$7 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer7, numValueOf2, composeUiNode$Companion$SetModifier$7);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$2 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer7, ownerSnapshotObserver$onCommitAffectingLayout$2);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$8 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer7, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$8);
                        RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer7, 48);
                        long j4 = gapComposer7.compositeKeyHashCode;
                        int i4 = (int) (j4 ^ (j4 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer7.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer7, companion2);
                        gapComposer7.startReusableNode();
                        if (gapComposer7.inserting) {
                            gapComposer7.createNode(layoutNode$Companion$Constructor$2);
                        } else {
                            gapComposer7.useNode();
                        }
                        Stack.m295setimpl(gapComposer7, rowMeasurePolicy2, composeUiNode$Companion$SetModifier$5);
                        Stack.m295setimpl(gapComposer7, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$6);
                        Modifier.CC.m(i4, gapComposer7, composeUiNode$Companion$SetModifier$7, gapComposer7, ownerSnapshotObserver$onCommitAffectingLayout$2);
                        Stack.m295setimpl(gapComposer7, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$8);
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.profile_updating, gapComposer7);
                        TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer7.consume(MaterialThemeKt._localMaterialTheme)).typography.bodySmall;
                        AppColors appColors3 = this.$colors;
                        TextKt.m275TextNvy7gAk(strStringResource2, null, appColors3.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer7, 0, 0, 131066);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        OffsetKt.Spacer(gapComposer7, new LayoutWeightElement(1.0f, true));
                        gapComposer7.end(true);
                        OffsetKt.Spacer(gapComposer7, SizeKt.m135height3ABfNKs(companion2, 4));
                        ProgressIndicatorKt.m257LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth(companion2, 1.0f), appColors3.textPrimary, appColors3.cardBorder, 0, 0.0f, gapComposer7, 6);
                        gapComposer7.end(true);
                        break;
                    case 8:
                        GapComposer gapComposer8 = (GapComposer) obj2;
                        if ((((Number) obj3).intValue() & 17) == 16 && gapComposer8.getSkipping()) {
                            gapComposer8.skipToGroupEnd();
                        } else {
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.share_to_tv_hint, gapComposer8), OffsetKt.m129paddingVpY3zN4(Modifier.Companion.$$INSTANCE, 4, 8), this.$colors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer8, 48, 0, 131064);
                        }
                        break;
                    default:
                        GapComposer gapComposer9 = (GapComposer) obj2;
                        if ((((Number) obj3).intValue() & 17) == 16 && gapComposer9.getSkipping()) {
                            gapComposer9.skipToGroupEnd();
                        } else {
                            TextKt.m275TextNvy7gAk("OK", null, this.$colors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 6, 0, 262138);
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        }

        public /* synthetic */ AnonymousClass4(Function0 function0, MutableState mutableState, AppColors appColors, int i) {
            this.$r8$classId = i;
            this.$onDeleteAll = function0;
            this.$deleteDialogOpen$delegate = mutableState;
            this.$colors = appColors;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        gapComposer.startReplaceGroup(-2095020557);
                        Function0 function0 = this.$onDeleteAll;
                        boolean zChanged = gapComposer.changed(function0);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                            objRememberedValue = new TvQrCodeSheetKt$$ExternalSyntheticLambda2(function0, this.$deleteDialogOpen$delegate, 1);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer.end(false);
                        ScrimKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, Thread_jvmKt.rememberComposableLambda(-732706715, new AnonymousClass2(this.$colors, 0), gapComposer), gapComposer, 805306368, 510);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(1485486208);
                        Function0 function1 = this.$onDeleteAll;
                        boolean zChanged2 = gapComposer2.changed(function1);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == Composer$Companion.Empty) {
                            objRememberedValue2 = new TvQrCodeSheetKt$$ExternalSyntheticLambda2(function1, this.$deleteDialogOpen$delegate, 2);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        ScrimKt.IconButton((Function0) objRememberedValue2, null, false, null, null, Thread_jvmKt.rememberComposableLambda(1045679029, new AnonymousClass6(this.$colors, 21), gapComposer2), gapComposer2, 1572864, 62);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.LogsScreenKt$LogsScreen$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass5 implements Function2 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ MutableState $deleteDialogOpen$delegate;
        public final /* synthetic */ int $r8$classId;

        public AnonymousClass5(MutableState mutableState, AppColors appColors) {
            this.$r8$classId = 0;
            this.$deleteDialogOpen$delegate = mutableState;
            this.$colors = appColors;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            String strStringResource;
            int i = this.$r8$classId;
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            MutableState mutableState = this.$deleteDialogOpen$delegate;
            AppColors appColors = this.$colors;
            int i2 = 2;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        gapComposer.startReplaceGroup(-2095009043);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 12);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer.end(false);
                        ScrimKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, Thread_jvmKt.rememberComposableLambda(1837652259, new AnonymousClass4.AnonymousClass2(appColors, i2), gapComposer), gapComposer, 805306374, 510);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        JsonImpl jsonImpl = ConnectionsScreenKt.connectionJson;
                        if (((String) mutableState.getValue()) != null) {
                            gapComposer2.startReplaceGroup(-1195102401);
                            strStringResource = (String) mutableState.getValue();
                            if (strStringResource.length() == 0) {
                                strStringResource = StringResources_androidKt.stringResource(R.string.process_unknown, gapComposer2);
                            }
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(1485472467);
                            strStringResource = StringResources_androidKt.stringResource(R.string.connections, gapComposer2);
                            gapComposer2.end(false);
                        }
                        TextKt.m275TextNvy7gAk(strStringResource, null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer2, 1572864, 24960, 110522);
                    }
                    break;
                default:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        String str = (String) mutableState.getValue();
                        TextStyle textStyle = new TextStyle(appColors.textPrimary, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium.spanStyle.fontSize, null, 0L, 0, 0L, 16777212);
                        SolidColor solidColor = new SolidColor(appColors.textPrimary);
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                        gapComposer3.startReplaceGroup(-1672830721);
                        Object objRememberedValue2 = gapComposer3.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 26);
                            gapComposer3.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer3.end(false);
                        BasicTextFieldKt.BasicTextField(str, (Function1) objRememberedValue2, modifierFillMaxWidth, false, textStyle, null, null, true, 0, 0, null, null, null, solidColor, Thread_jvmKt.rememberComposableLambda(-831044565, new ApkBrokenScreenKt.AnonymousClass1(1, appColors, mutableState), gapComposer3), gapComposer3, 100663728, 16088);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public /* synthetic */ AnonymousClass5(AppColors appColors, MutableState mutableState, int i) {
            this.$r8$classId = i;
            this.$colors = appColors;
            this.$deleteDialogOpen$delegate = mutableState;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.LogsScreenKt$LogsScreen$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass6 implements Function2 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass6(AppColors appColors, int i) {
            this.$r8$classId = i;
            this.$colors = appColors;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            int i = this.$r8$classId;
            AppColors appColors = this.$colors;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.delete_all_logs, gapComposer), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 1572864, 0, 262074);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.application_crashed, gapComposer2), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer2, 1572864, 0, 131002);
                    }
                    break;
                case 2:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer3), null, appColors.textPrimary, gapComposer3, 0, 4);
                    }
                    break;
                case 3:
                    GapComposer gapComposer4 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.file_name, gapComposer4), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 1572864, 0, 262074);
                    }
                    break;
                case 4:
                    GapComposer gapComposer5 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer5.getSkipping()) {
                        gapComposer5.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(MoreVertKt.getMoreVert(), StringResources_androidKt.stringResource(R.string.more, gapComposer5), null, appColors.textSecondary, gapComposer5, 0, 4);
                    }
                    break;
                case 5:
                    GapComposer gapComposer6 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer6.getSkipping()) {
                        gapComposer6.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.files, gapComposer6), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer6, 1572864, 0, 131002);
                    }
                    break;
                case 6:
                    GapComposer gapComposer7 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer7.getSkipping()) {
                        gapComposer7.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer7), null, appColors.textPrimary, gapComposer7, 0, 4);
                    }
                    break;
                case 7:
                    GapComposer gapComposer8 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer8.getSkipping()) {
                        gapComposer8.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(CertificatePinner.Companion.getAdd(), StringResources_androidKt.stringResource(R.string._new, gapComposer8), null, appColors.textPrimary, gapComposer8, 0, 4);
                    }
                    break;
                case 8:
                    GapComposer gapComposer9 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer9.getSkipping()) {
                        gapComposer9.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer9), null, appColors.textPrimary, gapComposer9, 0, 4);
                    }
                    break;
                case 9:
                    GapComposer gapComposer10 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer10.getSkipping()) {
                        gapComposer10.skipToGroupEnd();
                    } else {
                        ImageVector imageVectorBuild = StopKt._stop;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder = new ImageVector.Builder("Filled.Stop", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i2 = VectorKt.$r8$clinit;
                            SolidColor solidColor = new SolidColor(Color.Black);
                            ArrayList arrayList = new ArrayList(32);
                            arrayList.add(new PathNode.MoveTo(6.0f, 6.0f));
                            arrayList.add(new PathNode.RelativeHorizontalTo(12.0f));
                            arrayList.add(new PathNode.RelativeVerticalTo(12.0f));
                            arrayList.add(new PathNode.HorizontalTo(6.0f));
                            arrayList.add(PathNode.Close.INSTANCE);
                            ImageVector.Builder.m502addPathoIyEayM$default(builder, arrayList, solidColor);
                            imageVectorBuild = builder.build();
                            StopKt._stop = imageVectorBuild;
                        }
                        IconKt.m249Iconww6aTOc(imageVectorBuild, StringResources_androidKt.stringResource(R.string.close, gapComposer10), null, appColors.textPrimary, gapComposer10, 0, 4);
                    }
                    break;
                case 10:
                    GapComposer gapComposer11 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer11.getSkipping()) {
                        gapComposer11.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(RequestBody$Companion$toRequestBody$2.getDelete(), StringResources_androidKt.stringResource(R.string.delete, gapComposer11), null, appColors.textPrimary, gapComposer11, 0, 4);
                    }
                    break;
                case 11:
                    GapComposer gapComposer12 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer12.getSkipping()) {
                        gapComposer12.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(UploadKt.getUpload(), StringResources_androidKt.stringResource(R.string.export, gapComposer12), null, appColors.textPrimary, gapComposer12, 0, 4);
                    }
                    break;
                case 12:
                    GapComposer gapComposer13 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer13.getSkipping()) {
                        gapComposer13.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.logs, gapComposer13), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer13.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer13, 1572864, 0, 131002);
                    }
                    break;
                case 13:
                    GapComposer gapComposer14 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer14.getSkipping()) {
                        gapComposer14.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer14), null, appColors.textPrimary, gapComposer14, 0, 4);
                    }
                    break;
                case 14:
                    GapComposer gapComposer15 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer15.getSkipping()) {
                        gapComposer15.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.delete_all_logs_warn, gapComposer15), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262138);
                    }
                    break;
                case 15:
                    GapComposer gapComposer16 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer16.getSkipping()) {
                        gapComposer16.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.exit_without_save, gapComposer16), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 1572864, 0, 262074);
                    }
                    break;
                case 16:
                    GapComposer gapComposer17 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer17.getSkipping()) {
                        gapComposer17.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.exit_without_save_warning, gapComposer17), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer17, 0, 0, 262138);
                    }
                    break;
                case 17:
                    GapComposer gapComposer18 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer18.getSkipping()) {
                        gapComposer18.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer18), null, appColors.textPrimary, gapComposer18, 0, 4);
                    }
                    break;
                case 18:
                    GapComposer gapComposer19 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer19.getSkipping()) {
                        gapComposer19.skipToGroupEnd();
                    } else {
                        ImageVector imageVectorBuild2 = SwapVertKt._swapVert;
                        if (imageVectorBuild2 == null) {
                            ImageVector.Builder builder2 = new ImageVector.Builder("Filled.SwapVert", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i3 = VectorKt.$r8$clinit;
                            SolidColor solidColor2 = new SolidColor(Color.Black);
                            Quirks quirks = new Quirks();
                            quirks.moveTo(16.0f, 17.01f);
                            quirks.verticalLineTo(10.0f);
                            quirks.horizontalLineToRelative(-2.0f);
                            quirks.verticalLineToRelative(7.01f);
                            quirks.horizontalLineToRelative(-3.0f);
                            quirks.lineTo(15.0f, 21.0f);
                            quirks.lineToRelative(4.0f, -3.99f);
                            quirks.horizontalLineToRelative(-3.0f);
                            quirks.close();
                            quirks.moveTo(9.0f, 3.0f);
                            quirks.lineTo(5.0f, 6.99f);
                            quirks.horizontalLineToRelative(3.0f);
                            quirks.verticalLineTo(14.0f);
                            quirks.horizontalLineToRelative(2.0f);
                            quirks.verticalLineTo(6.99f);
                            quirks.horizontalLineToRelative(3.0f);
                            quirks.lineTo(9.0f, 3.0f);
                            quirks.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder2, quirks.mQuirks, solidColor2);
                            imageVectorBuild2 = builder2.build();
                            SwapVertKt._swapVert = imageVectorBuild2;
                        }
                        IconKt.m249Iconww6aTOc(imageVectorBuild2, StringResources_androidKt.stringResource(R.string.update_all, gapComposer19), null, appColors.textPrimary, gapComposer19, 0, 4);
                    }
                    break;
                case 19:
                    GapComposer gapComposer20 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer20.getSkipping()) {
                        gapComposer20.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.providers, gapComposer20), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer20.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer20, 1572864, 0, 131002);
                    }
                    break;
                case 20:
                    GapComposer gapComposer21 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer21.getSkipping()) {
                        gapComposer21.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer21), null, appColors.textPrimary, gapComposer21, 0, 4);
                    }
                    break;
                case 21:
                    GapComposer gapComposer22 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer22.getSkipping()) {
                        gapComposer22.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer22), null, appColors.textPrimary, gapComposer22, 0, 4);
                    }
                    break;
                case 22:
                    GapComposer gapComposer23 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer23.getSkipping()) {
                        gapComposer23.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(Okio.getLinkOff(), StringResources_androidKt.stringResource(R.string.connections_close_all, gapComposer23), null, appColors.textPrimary, gapComposer23, 0, 4);
                    }
                    break;
                case 23:
                    GapComposer gapComposer24 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer24.getSkipping()) {
                        gapComposer24.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(Okio.getLinkOff(), StringResources_androidKt.stringResource(R.string.connections_close_all, gapComposer24), null, appColors.textPrimary, gapComposer24, 0, 4);
                    }
                    break;
                case 24:
                    GapComposer gapComposer25 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer25.getSkipping()) {
                        gapComposer25.skipToGroupEnd();
                    } else {
                        ImageVector imageVectorBuild3 = Options$Companion._moreHoriz;
                        if (imageVectorBuild3 == null) {
                            ImageVector.Builder builder3 = new ImageVector.Builder("Filled.MoreHoriz", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i4 = VectorKt.$r8$clinit;
                            SolidColor solidColor3 = new SolidColor(Color.Black);
                            Quirks quirks2 = new Quirks();
                            quirks2.moveTo(6.0f, 10.0f);
                            quirks2.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
                            quirks2.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
                            quirks2.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
                            quirks2.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
                            quirks2.close();
                            quirks2.moveTo(18.0f, 10.0f);
                            quirks2.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
                            quirks2.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
                            quirks2.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
                            quirks2.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
                            quirks2.close();
                            quirks2.moveTo(12.0f, 10.0f);
                            quirks2.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
                            quirks2.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
                            quirks2.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
                            quirks2.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
                            quirks2.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder3, quirks2.mQuirks, solidColor3);
                            imageVectorBuild3 = builder3.build();
                            Options$Companion._moreHoriz = imageVectorBuild3;
                        }
                        IconKt.m249Iconww6aTOc(imageVectorBuild3, null, null, appColors.textPrimary, gapComposer25, 48, 4);
                    }
                    break;
                case 25:
                    GapComposer gapComposer26 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer26.getSkipping()) {
                        gapComposer26.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profiles, gapComposer26), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer26.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer26, 1572864, 0, 131002);
                    }
                    break;
                case 26:
                    GapComposer gapComposer27 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer27.getSkipping()) {
                        gapComposer27.skipToGroupEnd();
                    } else {
                        IconKt.m249Iconww6aTOc(MediaType.Companion.getClose(), StringResources_androidKt.stringResource(R.string.close, gapComposer27), null, appColors.textPrimary, gapComposer27, 0, 4);
                    }
                    break;
                case 27:
                    GapComposer gapComposer28 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer28.getSkipping()) {
                        gapComposer28.skipToGroupEnd();
                    } else {
                        ImageVector imageVectorBuild4 = TuneKt._tune;
                        if (imageVectorBuild4 == null) {
                            ImageVector.Builder builder4 = new ImageVector.Builder("Filled.Tune", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i5 = VectorKt.$r8$clinit;
                            SolidColor solidColor4 = new SolidColor(Color.Black);
                            Quirks quirks3 = new Quirks();
                            quirks3.moveTo(3.0f, 17.0f);
                            quirks3.verticalLineToRelative(2.0f);
                            quirks3.horizontalLineToRelative(6.0f);
                            quirks3.verticalLineToRelative(-2.0f);
                            quirks3.lineTo(3.0f, 17.0f);
                            quirks3.close();
                            quirks3.moveTo(3.0f, 5.0f);
                            quirks3.verticalLineToRelative(2.0f);
                            quirks3.horizontalLineToRelative(10.0f);
                            quirks3.lineTo(13.0f, 5.0f);
                            quirks3.lineTo(3.0f, 5.0f);
                            quirks3.close();
                            quirks3.moveTo(13.0f, 21.0f);
                            quirks3.verticalLineToRelative(-2.0f);
                            quirks3.horizontalLineToRelative(8.0f);
                            quirks3.verticalLineToRelative(-2.0f);
                            quirks3.horizontalLineToRelative(-8.0f);
                            quirks3.verticalLineToRelative(-2.0f);
                            quirks3.horizontalLineToRelative(-2.0f);
                            quirks3.verticalLineToRelative(6.0f);
                            quirks3.horizontalLineToRelative(2.0f);
                            quirks3.close();
                            quirks3.moveTo(7.0f, 9.0f);
                            quirks3.verticalLineToRelative(2.0f);
                            quirks3.lineTo(3.0f, 11.0f);
                            quirks3.verticalLineToRelative(2.0f);
                            quirks3.horizontalLineToRelative(4.0f);
                            quirks3.verticalLineToRelative(2.0f);
                            quirks3.horizontalLineToRelative(2.0f);
                            quirks3.lineTo(9.0f, 9.0f);
                            quirks3.lineTo(7.0f, 9.0f);
                            quirks3.close();
                            quirks3.moveTo(21.0f, 13.0f);
                            quirks3.verticalLineToRelative(-2.0f);
                            quirks3.lineTo(11.0f, 11.0f);
                            quirks3.verticalLineToRelative(2.0f);
                            quirks3.horizontalLineToRelative(10.0f);
                            quirks3.close();
                            quirks3.moveTo(15.0f, 9.0f);
                            quirks3.horizontalLineToRelative(2.0f);
                            quirks3.lineTo(17.0f, 7.0f);
                            quirks3.horizontalLineToRelative(4.0f);
                            quirks3.lineTo(21.0f, 5.0f);
                            quirks3.horizontalLineToRelative(-4.0f);
                            quirks3.lineTo(17.0f, 3.0f);
                            quirks3.horizontalLineToRelative(-2.0f);
                            quirks3.verticalLineToRelative(6.0f);
                            quirks3.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder4, quirks3.mQuirks, solidColor4);
                            imageVectorBuild4 = builder4.build();
                            TuneKt._tune = imageVectorBuild4;
                        }
                        IconKt.m249Iconww6aTOc(imageVectorBuild4, StringResources_androidKt.stringResource(R.string.settings, gapComposer28), null, appColors.textPrimary, gapComposer28, 0, 4);
                    }
                    break;
                case 28:
                    GapComposer gapComposer29 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer29.getSkipping()) {
                        gapComposer29.skipToGroupEnd();
                    } else {
                        ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(null, appColors.textPrimary, 0.0f, 0L, 0, 0.0f, gapComposer29, 0, 61);
                    }
                    break;
                default:
                    GapComposer gapComposer30 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer30.getSkipping()) {
                        gapComposer30.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.access_control_packages, gapComposer30), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer30.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer30, 1572864, 0, 131002);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public static final void LogFileRow(LogFile logFile, Function0 function0, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-1349723436);
        if ((((gapComposer.changedInstance(logFile) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16)) & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(527865858);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = DateFormat.getDateTimeInstance(2, 2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            DateFormat dateFormat = (DateFormat) objRememberedValue;
            Object objM = Density.CC.m(527869107, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM);
            }
            MutableState mutableState = (MutableState) objM;
            gapComposer.end(false);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
            gapComposer.startReplaceGroup(527873485);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 13);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifierFillMaxWidth, (Function1) objRememberedValue2);
            float f = 12;
            zzjl.m819GlassSurfaceYxtnGt4(ImageKt.m48borderxT4_qwU(((Boolean) mutableState.getValue()).booleanValue() ? 2 : 0, ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : Color.Transparent, modifierOnFocusChanged, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f)), f, null, Thread_jvmKt.rememberComposableLambda(673280055, new MainAppKt.AnonymousClass2.AnonymousClass1(function0, dateFormat, logFile, appColors, 1), gapComposer), gapComposer, 196656, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 22, logFile, function0);
        }
    }

    public static final void LogcatRow(Function0 function0, GapComposer gapComposer, int i) {
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(-1610069194);
        if ((((gapComposer.changedInstance(function0) ? 4 : 2) | i) & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(-1356775693);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
            gapComposer.startReplaceGroup(-1356771315);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 14);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            float f = 12;
            gapComposer2 = gapComposer;
            zzjl.m819GlassSurfaceYxtnGt4(ImageKt.m48borderxT4_qwU(((Boolean) mutableState.getValue()).booleanValue() ? 2 : 0, ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : Color.Transparent, FocusTraversalKt.onFocusChanged(modifierFillMaxWidth, (Function1) objRememberedValue2), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f)), f, null, Thread_jvmKt.rememberComposableLambda(-1844802957, new AnonymousClass2(function0, appColors, 0), gapComposer), gapComposer2, 196656, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogsScreenKt$$ExternalSyntheticLambda5(function0, i, 0);
        }
    }

    public static final void LogsScreen(final List list, final Function0 function0, final Function1 function1, final Function0 function2, final Function0 function3, Modifier modifier, final boolean z, GapComposer gapComposer, final int i) {
        final Modifier modifier2;
        gapComposer.startRestartGroup(1429870767);
        if (((i | (gapComposer.changedInstance(list) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changedInstance(function1) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024) | (gapComposer.changedInstance(function3) ? 16384 : 8192) | 196608 | (gapComposer.changed(z) ? 1048576 : 524288)) & 599187) == 599186 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            final HazeState hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer);
            gapComposer.startReplaceGroup(2101267188);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-660944269, new Function2() { // from class: com.github.kr328.clash.compose.LogsScreenKt.LogsScreen.1

                /* JADX INFO: renamed from: com.github.kr328.clash.compose.LogsScreenKt$LogsScreen$1$3, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                public final class AnonymousClass3 implements Function3 {
                    public final /* synthetic */ Object $colors;
                    public final /* synthetic */ Object $deleteDialogOpen$delegate;
                    public final /* synthetic */ Object $logs;
                    public final /* synthetic */ int $r8$classId;

                    /* JADX INFO: renamed from: com.github.kr328.clash.compose.LogsScreenKt$LogsScreen$1$3$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                    public final class AnonymousClass2 implements Function2 {
                        public final /* synthetic */ Object $colors;
                        public final /* synthetic */ Object $logs;
                        public final /* synthetic */ int $r8$classId;

                        public /* synthetic */ AnonymousClass2(int i, Object obj, Object obj2) {
                            this.$r8$classId = i;
                            this.$logs = obj;
                            this.$colors = obj2;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r7v20 */
                        /* JADX WARN: Type inference failed for: r7v21, types: [boolean, int] */
                        /* JADX WARN: Type inference failed for: r7v22 */
                        /* JADX WARN: Type inference failed for: r7v23, types: [boolean, int] */
                        /* JADX WARN: Type inference failed for: r7v25 */
                        /* JADX WARN: Type inference failed for: r7v26 */
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ?? r7;
                            ?? r8;
                            int i = this.$r8$classId;
                            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                            Object obj3 = this.$colors;
                            Object obj4 = this.$logs;
                            int i2 = 2;
                            int i3 = 3;
                            switch (i) {
                                case 0:
                                    GapComposer gapComposer = (GapComposer) obj;
                                    AppColors appColors = (AppColors) obj3;
                                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                                        gapComposer.skipToGroupEnd();
                                    } else {
                                        ImageVector imageVectorBuild = Headers.Companion._clearAll;
                                        if (imageVectorBuild == null) {
                                            ImageVector.Builder builder = new ImageVector.Builder("Filled.ClearAll", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                            int i4 = VectorKt.$r8$clinit;
                                            SolidColor solidColor = new SolidColor(Color.Black);
                                            Quirks quirks = new Quirks();
                                            quirks.moveTo(5.0f, 13.0f);
                                            quirks.horizontalLineToRelative(14.0f);
                                            quirks.verticalLineToRelative(-2.0f);
                                            quirks.lineTo(5.0f, 11.0f);
                                            quirks.verticalLineToRelative(2.0f);
                                            quirks.close();
                                            quirks.moveTo(3.0f, 17.0f);
                                            quirks.horizontalLineToRelative(14.0f);
                                            quirks.verticalLineToRelative(-2.0f);
                                            quirks.lineTo(3.0f, 15.0f);
                                            quirks.verticalLineToRelative(2.0f);
                                            quirks.close();
                                            quirks.moveTo(7.0f, 7.0f);
                                            quirks.verticalLineToRelative(2.0f);
                                            quirks.horizontalLineToRelative(14.0f);
                                            quirks.lineTo(21.0f, 7.0f);
                                            quirks.lineTo(7.0f, 7.0f);
                                            quirks.close();
                                            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                                            imageVectorBuild = builder.build();
                                            Headers.Companion._clearAll = imageVectorBuild;
                                        }
                                        IconKt.m249Iconww6aTOc(imageVectorBuild, StringResources_androidKt.stringResource(R.string.delete_all_logs, gapComposer), null, !((List) obj4).isEmpty() ? appColors.textPrimary : appColors.textSecondary, gapComposer, 0, 4);
                                    }
                                    break;
                                case 1:
                                    GapComposer gapComposer2 = (GapComposer) obj;
                                    Context context = (Context) obj4;
                                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        gapComposer2.startReplaceGroup(-1845026750);
                                        boolean zChangedInstance = gapComposer2.changedInstance(context);
                                        Object objRememberedValue = gapComposer2.rememberedValue();
                                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                                            objRememberedValue = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context, i2);
                                            gapComposer2.updateRememberedValue(objRememberedValue);
                                        }
                                        Function0 function0 = (Function0) objRememberedValue;
                                        gapComposer2.end(false);
                                        gapComposer2.startReplaceGroup(-1845021306);
                                        boolean zChangedInstance2 = gapComposer2.changedInstance(context);
                                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                                        if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                                            objRememberedValue2 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context, i3);
                                            gapComposer2.updateRememberedValue(objRememberedValue2);
                                        }
                                        Function0 function1 = (Function0) objRememberedValue2;
                                        gapComposer2.end(false);
                                        gapComposer2.startReplaceGroup(-1845015870);
                                        boolean zChangedInstance3 = gapComposer2.changedInstance(context);
                                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                                        if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                                            objRememberedValue3 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context, 4);
                                            gapComposer2.updateRememberedValue(objRememberedValue3);
                                        }
                                        Function0 function2 = (Function0) objRememberedValue3;
                                        gapComposer2.end(false);
                                        gapComposer2.startReplaceGroup(-1845010561);
                                        boolean zChangedInstance4 = gapComposer2.changedInstance(context);
                                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                                        if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                                            objRememberedValue4 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context, 5);
                                            gapComposer2.updateRememberedValue(objRememberedValue4);
                                        }
                                        Function0 function3 = (Function0) objRememberedValue4;
                                        gapComposer2.end(false);
                                        gapComposer2.startReplaceGroup(-1844998464);
                                        boolean zChangedInstance5 = gapComposer2.changedInstance(context);
                                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                                        if (zChangedInstance5 || objRememberedValue5 == neverEqualPolicy) {
                                            objRememberedValue5 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context, 6);
                                            gapComposer2.updateRememberedValue(objRememberedValue5);
                                        }
                                        gapComposer2.end(false);
                                        zzje.SettingsScreen(function0, function1, function2, function3, (Function0) objRememberedValue5, null, OffsetKt.m124PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, ((PaddingValues) obj3).mo117calculateBottomPaddingD9Ej5fM(), 7), false, gapComposer2, 0, 416);
                                    }
                                    break;
                                case 2:
                                    GapComposer gapComposer3 = (GapComposer) obj;
                                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                                        gapComposer3.skipToGroupEnd();
                                    } else {
                                        ImageVector imageVectorBuild2 = JsonKt._label;
                                        if (imageVectorBuild2 == null) {
                                            ImageVector.Builder builder2 = new ImageVector.Builder("AutoMirrored.Outlined.Label", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
                                            int i5 = VectorKt.$r8$clinit;
                                            SolidColor solidColor2 = new SolidColor(Color.Black);
                                            Quirks quirks2 = new Quirks();
                                            quirks2.moveTo(17.63f, 5.84f);
                                            quirks2.curveTo(17.27f, 5.33f, 16.67f, 5.0f, 16.0f, 5.0f);
                                            quirks2.lineTo(5.0f, 5.01f);
                                            quirks2.curveTo(3.9f, 5.01f, 3.0f, 5.9f, 3.0f, 7.0f);
                                            quirks2.verticalLineToRelative(10.0f);
                                            quirks2.curveToRelative(0.0f, 1.1f, 0.9f, 1.99f, 2.0f, 1.99f);
                                            quirks2.lineTo(16.0f, 19.0f);
                                            quirks2.curveToRelative(0.67f, 0.0f, 1.27f, -0.33f, 1.63f, -0.84f);
                                            quirks2.lineTo(22.0f, 12.0f);
                                            quirks2.lineToRelative(-4.37f, -6.16f);
                                            quirks2.close();
                                            quirks2.moveTo(16.0f, 17.0f);
                                            quirks2.horizontalLineTo(5.0f);
                                            quirks2.verticalLineTo(7.0f);
                                            quirks2.horizontalLineToRelative(11.0f);
                                            quirks2.lineToRelative(3.55f, 5.0f);
                                            quirks2.lineTo(16.0f, 17.0f);
                                            quirks2.close();
                                            ImageVector.Builder.m502addPathoIyEayM$default(builder2, quirks2.mQuirks, solidColor2);
                                            imageVectorBuild2 = builder2.build();
                                            JsonKt._label = imageVectorBuild2;
                                        }
                                        ImageVector imageVector = imageVectorBuild2;
                                        String strStringResource = StringResources_androidKt.stringResource(R.string.name, gapComposer3);
                                        String str = ((Profile) obj4).name;
                                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.profile_name, gapComposer3);
                                        gapComposer3.startReplaceGroup(1926025292);
                                        MutableState mutableState = (MutableState) obj3;
                                        Object objRememberedValue6 = gapComposer3.rememberedValue();
                                        if (objRememberedValue6 == neverEqualPolicy) {
                                            objRememberedValue6 = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 21);
                                            gapComposer3.updateRememberedValue(objRememberedValue6);
                                        }
                                        gapComposer3.end(false);
                                        PropertiesScreenKt.FieldRow(imageVector, strStringResource, str, strStringResource2, true, (Function0) objRememberedValue6, gapComposer3, 221184);
                                    }
                                    break;
                                case 3:
                                    GapComposer gapComposer4 = (GapComposer) obj;
                                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                                        gapComposer4.skipToGroupEnd();
                                    } else {
                                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                                        ConnectionInfo connectionInfo = (ConnectionInfo) obj4;
                                        AppColors appColors2 = (AppColors) obj3;
                                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer4, 48);
                                        long j = gapComposer4.compositeKeyHashCode;
                                        int i6 = (int) (j ^ (j >>> 32));
                                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer4, modifierFillMaxWidth);
                                        ComposeUiNode.Companion.getClass();
                                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                                        gapComposer4.startReusableNode();
                                        if (gapComposer4.inserting) {
                                            gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                                        } else {
                                            gapComposer4.useNode();
                                        }
                                        Stack.m295setimpl(gapComposer4, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                        Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                        Stack.m295setimpl(gapComposer4, Integer.valueOf(i6), ComposeUiNode.Companion.SetCompositeKeyHash);
                                        Stack.m294reconcileimpl(gapComposer4, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                                        Stack.m295setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                        String strStringResource3 = StringResources_androidKt.stringResource(R.string.connection_upload, gapComposer4);
                                        String strAccess$formatBytes = ConnectionsScreenKt.access$formatBytes(connectionInfo.upload);
                                        if (1.0f <= 0.0d) {
                                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                        }
                                        ConnectionsScreenKt.m806StatCellSj8uqqQ(strStringResource3, strAccess$formatBytes, new LayoutWeightElement(1.0f, true), null, "↑", gapComposer4, 24576, 8);
                                        BoxKt.Box(ImageKt.m47backgroundbw27NRU(SizeKt.m135height3ABfNKs(SizeKt.m144width3ABfNKs(companion, 1), 32), appColors2.cardBorder, BrushKt.RectangleShape), gapComposer4, 0);
                                        String strStringResource4 = StringResources_androidKt.stringResource(R.string.connection_download, gapComposer4);
                                        String strAccess$formatBytes2 = ConnectionsScreenKt.access$formatBytes(connectionInfo.download);
                                        if (1.0f <= 0.0d) {
                                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                        }
                                        ConnectionsScreenKt.m806StatCellSj8uqqQ(strStringResource4, strAccess$formatBytes2, new LayoutWeightElement(1.0f, true), null, "↓", gapComposer4, 24576, 8);
                                        gapComposer4.end(true);
                                    }
                                    break;
                                case 4:
                                    GapComposer gapComposer5 = (GapComposer) obj;
                                    int iIntValue = ((Number) obj2).intValue();
                                    ConnectionMetadata connectionMetadata = (ConnectionMetadata) obj3;
                                    ConnectionInfo connectionInfo2 = (ConnectionInfo) obj4;
                                    String str2 = connectionInfo2.rule;
                                    if ((iIntValue & 3) == 2 && gapComposer5.getSkipping()) {
                                        gapComposer5.skipToGroupEnd();
                                    } else {
                                        gapComposer5.startReplaceGroup(1427315483);
                                        String str3 = connectionInfo2.rulePayload;
                                        if (str2.length() > 0) {
                                            r7 = 0;
                                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_rule, gapComposer5), str2, gapComposer5, 0);
                                        } else {
                                            r7 = 0;
                                        }
                                        gapComposer5.end(r7);
                                        gapComposer5.startReplaceGroup(1427320209);
                                        if (str3.length() > 0) {
                                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_rule_payload, gapComposer5), str3, gapComposer5, r7);
                                        }
                                        gapComposer5.end(r7);
                                        gapComposer5.startReplaceGroup(1427325709);
                                        if (connectionInfo2.chains.isEmpty()) {
                                            r8 = 0;
                                        } else {
                                            r8 = 0;
                                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_proxy_chain, gapComposer5), CollectionsKt.joinToString$default(connectionInfo2.chains, " → ", null, null, null, 62), gapComposer5, 0);
                                        }
                                        gapComposer5.end(r8);
                                        if (connectionMetadata.inboundName.length() > 0) {
                                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_inbound, gapComposer5), connectionMetadata.inboundName, gapComposer5, r8);
                                        }
                                    }
                                    break;
                                case 5:
                                    GapComposer gapComposer6 = (GapComposer) obj;
                                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer6.getSkipping()) {
                                        gapComposer6.skipToGroupEnd();
                                    } else {
                                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                                        ProxySort proxySort = (ProxySort) obj4;
                                        Function1 function4 = (Function1) obj3;
                                        RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.m111spacedBy0680j_4(8), Alignment.Companion.Top, gapComposer6, 6);
                                        long j2 = gapComposer6.compositeKeyHashCode;
                                        int i7 = (int) (j2 ^ (j2 >>> 32));
                                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer6.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer6, modifierFillMaxWidth2);
                                        ComposeUiNode.Companion.getClass();
                                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                                        gapComposer6.startReusableNode();
                                        if (gapComposer6.inserting) {
                                            gapComposer6.createNode(layoutNode$Companion$Constructor$2);
                                        } else {
                                            gapComposer6.useNode();
                                        }
                                        Stack.m295setimpl(gapComposer6, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                                        Stack.m295setimpl(gapComposer6, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                        Stack.m295setimpl(gapComposer6, Integer.valueOf(i7), ComposeUiNode.Companion.SetCompositeKeyHash);
                                        Stack.m294reconcileimpl(gapComposer6, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                                        Stack.m295setimpl(gapComposer6, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                                        String strStringResource5 = StringResources_androidKt.stringResource(R.string.default_, gapComposer6);
                                        boolean z = proxySort == ProxySort.Default;
                                        gapComposer6.startReplaceGroup(1968824280);
                                        boolean zChanged = gapComposer6.changed(function4);
                                        Object objRememberedValue7 = gapComposer6.rememberedValue();
                                        if (zChanged || objRememberedValue7 == neverEqualPolicy) {
                                            objRememberedValue7 = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function4, 3);
                                            gapComposer6.updateRememberedValue(objRememberedValue7);
                                        }
                                        Function0 function5 = (Function0) objRememberedValue7;
                                        gapComposer6.end(false);
                                        if (1.0f <= 0.0d) {
                                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                        }
                                        ProxyScreenKt.SegmentedPill(strStringResource5, z, function5, new LayoutWeightElement(1.0f, true), false, gapComposer6, 6, 16);
                                        String strStringResource6 = StringResources_androidKt.stringResource(R.string.name, gapComposer6);
                                        boolean z2 = proxySort == ProxySort.Title;
                                        gapComposer6.startReplaceGroup(1968834102);
                                        boolean zChanged2 = gapComposer6.changed(function4);
                                        Object objRememberedValue8 = gapComposer6.rememberedValue();
                                        if (zChanged2 || objRememberedValue8 == neverEqualPolicy) {
                                            objRememberedValue8 = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function4, 4);
                                            gapComposer6.updateRememberedValue(objRememberedValue8);
                                        }
                                        Function0 function6 = (Function0) objRememberedValue8;
                                        gapComposer6.end(false);
                                        if (1.0f <= 0.0d) {
                                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                        }
                                        ProxyScreenKt.SegmentedPill(strStringResource6, z2, function6, new LayoutWeightElement(1.0f, true), false, gapComposer6, 6, 16);
                                        String strStringResource7 = StringResources_androidKt.stringResource(R.string.delay, gapComposer6);
                                        boolean z3 = proxySort == ProxySort.Delay;
                                        gapComposer6.startReplaceGroup(1968843894);
                                        boolean zChanged3 = gapComposer6.changed(function4);
                                        Object objRememberedValue9 = gapComposer6.rememberedValue();
                                        if (zChanged3 || objRememberedValue9 == neverEqualPolicy) {
                                            objRememberedValue9 = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function4, 5);
                                            gapComposer6.updateRememberedValue(objRememberedValue9);
                                        }
                                        Function0 function7 = (Function0) objRememberedValue9;
                                        gapComposer6.end(false);
                                        if (1.0f <= 0.0d) {
                                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                        }
                                        ProxyScreenKt.SegmentedPill(strStringResource7, z3, function7, new LayoutWeightElement(1.0f, true), false, gapComposer6, 6, 16);
                                        gapComposer6.end(true);
                                    }
                                    break;
                                case 6:
                                    GapComposer gapComposer7 = (GapComposer) obj;
                                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer7.getSkipping()) {
                                        gapComposer7.skipToGroupEnd();
                                    } else {
                                        float f = 8;
                                        AppInfoSort appInfoSort = (AppInfoSort) obj4;
                                        Function1 function8 = (Function1) obj3;
                                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(f), Alignment.Companion.Start, gapComposer7, 6);
                                        MenuHostHelper menuHostHelper = gapComposer7.applier;
                                        long j3 = gapComposer7.compositeKeyHashCode;
                                        int i8 = (int) (j3 ^ (j3 >>> 32));
                                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer7.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer7, companion);
                                        ComposeUiNode.Companion.getClass();
                                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$3 = ComposeUiNode.Companion.Constructor;
                                        gapComposer7.startReusableNode();
                                        if (gapComposer7.inserting) {
                                            gapComposer7.createNode(layoutNode$Companion$Constructor$3);
                                        } else {
                                            gapComposer7.useNode();
                                        }
                                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                                        Stack.m295setimpl(gapComposer7, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                                        Stack.m295setimpl(gapComposer7, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                                        Integer numValueOf = Integer.valueOf(i8);
                                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                        Stack.m295setimpl(gapComposer7, numValueOf, composeUiNode$Companion$SetModifier$3);
                                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                                        Stack.m294reconcileimpl(gapComposer7, ownerSnapshotObserver$onCommitAffectingLayout$1);
                                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                                        Stack.m295setimpl(gapComposer7, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                                        Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(f);
                                        BiasAlignment.Vertical vertical = Alignment.Companion.Top;
                                        RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(spacedAlignedM111spacedBy0680j_4, vertical, gapComposer7, 6);
                                        long j4 = gapComposer7.compositeKeyHashCode;
                                        int i9 = (int) (j4 ^ (j4 >>> 32));
                                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer7.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer7, modifierFillMaxWidth3);
                                        gapComposer7.startReusableNode();
                                        if (gapComposer7.inserting) {
                                            gapComposer7.createNode(layoutNode$Companion$Constructor$3);
                                        } else {
                                            gapComposer7.useNode();
                                        }
                                        Stack.m295setimpl(gapComposer7, rowMeasurePolicy3, composeUiNode$Companion$SetModifier$1);
                                        Stack.m295setimpl(gapComposer7, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$2);
                                        Modifier.CC.m(i9, gapComposer7, composeUiNode$Companion$SetModifier$3, gapComposer7, ownerSnapshotObserver$onCommitAffectingLayout$1);
                                        Stack.m295setimpl(gapComposer7, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$4);
                                        String strStringResource8 = StringResources_androidKt.stringResource(R.string.name, gapComposer7);
                                        boolean z4 = appInfoSort == AppInfoSort.Label;
                                        gapComposer7.startReplaceGroup(-875197086);
                                        boolean zChanged4 = gapComposer7.changed(function8);
                                        Object objRememberedValue10 = gapComposer7.rememberedValue();
                                        if (zChanged4 || objRememberedValue10 == neverEqualPolicy) {
                                            objRememberedValue10 = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function8, 6);
                                            gapComposer7.updateRememberedValue(objRememberedValue10);
                                        }
                                        gapComposer7.end(false);
                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                        zzjb.SegmentedPill(strStringResource8, z4, (Function0) objRememberedValue10, rowScopeInstance.weight(), gapComposer7, 0);
                                        String strStringResource9 = StringResources_androidKt.stringResource(R.string.package_name, gapComposer7);
                                        boolean z5 = appInfoSort == AppInfoSort.PackageName;
                                        gapComposer7.startReplaceGroup(-875185976);
                                        boolean zChanged5 = gapComposer7.changed(function8);
                                        Object objRememberedValue11 = gapComposer7.rememberedValue();
                                        if (zChanged5 || objRememberedValue11 == neverEqualPolicy) {
                                            objRememberedValue11 = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function8, 7);
                                            gapComposer7.updateRememberedValue(objRememberedValue11);
                                        }
                                        gapComposer7.end(false);
                                        zzjb.SegmentedPill(strStringResource9, z5, (Function0) objRememberedValue11, rowScopeInstance.weight(), gapComposer7, 0);
                                        gapComposer7.end(true);
                                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                                        RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.m111spacedBy0680j_4(f), vertical, gapComposer7, 6);
                                        long j5 = gapComposer7.compositeKeyHashCode;
                                        int i10 = (int) (j5 ^ (j5 >>> 32));
                                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope5 = gapComposer7.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier5 = AbsoluteAlignment.materializeModifier(gapComposer7, modifierFillMaxWidth4);
                                        gapComposer7.startReusableNode();
                                        if (gapComposer7.inserting) {
                                            gapComposer7.createNode(layoutNode$Companion$Constructor$3);
                                        } else {
                                            gapComposer7.useNode();
                                        }
                                        Stack.m295setimpl(gapComposer7, rowMeasurePolicy4, composeUiNode$Companion$SetModifier$1);
                                        Stack.m295setimpl(gapComposer7, persistentCompositionLocalMapCurrentCompositionLocalScope5, composeUiNode$Companion$SetModifier$2);
                                        Modifier.CC.m(i10, gapComposer7, composeUiNode$Companion$SetModifier$3, gapComposer7, ownerSnapshotObserver$onCommitAffectingLayout$1);
                                        Stack.m295setimpl(gapComposer7, modifierMaterializeModifier5, composeUiNode$Companion$SetModifier$4);
                                        String strStringResource10 = StringResources_androidKt.stringResource(R.string.install_time, gapComposer7);
                                        boolean z6 = appInfoSort == AppInfoSort.InstallTime;
                                        gapComposer7.startReplaceGroup(-875168056);
                                        boolean zChanged6 = gapComposer7.changed(function8);
                                        Object objRememberedValue12 = gapComposer7.rememberedValue();
                                        if (zChanged6 || objRememberedValue12 == neverEqualPolicy) {
                                            objRememberedValue12 = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function8, 8);
                                            gapComposer7.updateRememberedValue(objRememberedValue12);
                                        }
                                        gapComposer7.end(false);
                                        zzjb.SegmentedPill(strStringResource10, z6, (Function0) objRememberedValue12, rowScopeInstance.weight(), gapComposer7, 0);
                                        String strStringResource11 = StringResources_androidKt.stringResource(R.string.update_time, gapComposer7);
                                        boolean z7 = appInfoSort == AppInfoSort.UpdateTime;
                                        gapComposer7.startReplaceGroup(-875156825);
                                        boolean zChanged7 = gapComposer7.changed(function8);
                                        Object objRememberedValue13 = gapComposer7.rememberedValue();
                                        if (zChanged7 || objRememberedValue13 == neverEqualPolicy) {
                                            objRememberedValue13 = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function8, 9);
                                            gapComposer7.updateRememberedValue(objRememberedValue13);
                                        }
                                        gapComposer7.end(false);
                                        zzjb.SegmentedPill(strStringResource11, z7, (Function0) objRememberedValue13, rowScopeInstance.weight(), gapComposer7, 0);
                                        gapComposer7.end(true);
                                        gapComposer7.end(true);
                                    }
                                    break;
                                case 7:
                                    GapComposer gapComposer8 = (GapComposer) obj;
                                    SettingsEntry settingsEntry = (SettingsEntry) obj4;
                                    if ((3 & ((Number) obj2).intValue()) == 2 && gapComposer8.getSkipping()) {
                                        gapComposer8.skipToGroupEnd();
                                    } else {
                                        float f2 = 16;
                                        Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(ImageKt.m51clickableoSLSa3U$default(SizeKt.FillWholeMaxSize, false, null, settingsEntry.onClick, 15), f2, 0.0f, 2);
                                        AppColors appColors3 = (AppColors) obj3;
                                        RowMeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer8, 48);
                                        long j6 = gapComposer8.compositeKeyHashCode;
                                        int i11 = (int) (j6 ^ (j6 >>> 32));
                                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope6 = gapComposer8.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier6 = AbsoluteAlignment.materializeModifier(gapComposer8, modifierM130paddingVpY3zN4$default);
                                        ComposeUiNode.Companion.getClass();
                                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$4 = ComposeUiNode.Companion.Constructor;
                                        gapComposer8.startReusableNode();
                                        if (gapComposer8.inserting) {
                                            gapComposer8.createNode(layoutNode$Companion$Constructor$4);
                                        } else {
                                            gapComposer8.useNode();
                                        }
                                        Stack.m295setimpl(gapComposer8, rowMeasurePolicy5, ComposeUiNode.Companion.SetMeasurePolicy);
                                        Stack.m295setimpl(gapComposer8, persistentCompositionLocalMapCurrentCompositionLocalScope6, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                        Stack.m295setimpl(gapComposer8, Integer.valueOf(i11), ComposeUiNode.Companion.SetCompositeKeyHash);
                                        Stack.m294reconcileimpl(gapComposer8, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                                        Stack.m295setimpl(gapComposer8, modifierMaterializeModifier6, ComposeUiNode.Companion.SetModifier);
                                        IconKt.m249Iconww6aTOc(settingsEntry.icon, null, SizeKt.m140size3ABfNKs(companion, 24), appColors3.textPrimary, gapComposer8, 432, 0);
                                        OffsetKt.Spacer(gapComposer8, SizeKt.m144width3ABfNKs(companion, f2));
                                        String strStringResource12 = StringResources_androidKt.stringResource(settingsEntry.labelRes, gapComposer8);
                                        TextStyle textStyle = ((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium;
                                        long j7 = appColors3.textPrimary;
                                        if (1.0f <= 0.0d) {
                                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                        }
                                        TextKt.m275TextNvy7gAk(strStringResource12, new LayoutWeightElement(1.0f, true), j7, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer8, 0, 0, 131064);
                                        IconKt.m249Iconww6aTOc(Encoder.DefaultImpls.getKeyboardArrowRight(), null, null, appColors3.textSecondary, gapComposer8, 48, 4);
                                        gapComposer8.end(true);
                                    }
                                    break;
                                default:
                                    GapComposer gapComposer9 = (GapComposer) obj;
                                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer9.getSkipping()) {
                                        gapComposer9.skipToGroupEnd();
                                    } else {
                                        MaterialThemeKt.MaterialExpressiveTheme((ColorScheme) obj4, TypographyKt.AppTypography, (ComposableLambdaImpl) obj3, gapComposer9, 3072);
                                    }
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public AnonymousClass3(ImageVector imageVector, String str, String str2) {
                        this.$r8$classId = 2;
                        ComposableLambdaImpl composableLambdaImpl = ComposableSingletons$PreferencesKt.f31lambda1;
                        this.$logs = imageVector;
                        this.$deleteDialogOpen$delegate = str;
                        this.$colors = str2;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        switch (this.$r8$classId) {
                            case 0:
                                GapComposer gapComposer = (GapComposer) obj2;
                                int iIntValue = ((Number) obj3).intValue();
                                List list = (List) this.$logs;
                                if ((iIntValue & 17) == 16 && gapComposer.getSkipping()) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    gapComposer.startReplaceGroup(215025483);
                                    MutableState mutableState = (MutableState) this.$deleteDialogOpen$delegate;
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    if (objRememberedValue == Composer$Companion.Empty) {
                                        objRememberedValue = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 11);
                                        gapComposer.updateRememberedValue(objRememberedValue);
                                    }
                                    gapComposer.end(false);
                                    ScrimKt.IconButton((Function0) objRememberedValue, null, !list.isEmpty(), null, null, Thread_jvmKt.rememberComposableLambda(-1153921022, new AnonymousClass2(0, list, (AppColors) this.$colors), gapComposer), gapComposer, 1572870, 58);
                                }
                                break;
                            case 1:
                                GapComposer gapComposer2 = (GapComposer) obj2;
                                if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    List list2 = (List) this.$logs;
                                    boolean z = false;
                                    if (list2 == null || !list2.isEmpty()) {
                                        Iterator it = list2.iterator();
                                        while (it.hasNext()) {
                                            if (((ProviderItemState) it.next()).provider.vehicleType != Provider.VehicleType.Inline) {
                                                z = true;
                                            }
                                        }
                                    }
                                    boolean z2 = z;
                                    ScrimKt.IconButton((Function0) this.$deleteDialogOpen$delegate, null, z2, null, null, Thread_jvmKt.rememberComposableLambda(1352378224, new ProvidersScreenKt$ProvidersScreen$2$3$1(z2, (AppColors) this.$colors, 0), gapComposer2), gapComposer2, 1572864, 58);
                                }
                                break;
                            default:
                                RowScope rowScope = (RowScope) obj;
                                GapComposer gapComposer3 = (GapComposer) obj2;
                                int iIntValue2 = ((Number) obj3).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    iIntValue2 |= gapComposer3.changed(rowScope) ? 4 : 2;
                                }
                                if ((iIntValue2 & 19) == 18 && gapComposer3.getSkipping()) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    zzjo.PreferenceLeadingIcon((ImageVector) this.$logs, gapComposer3, 0);
                                    zzjo.PreferenceTexts((String) this.$deleteDialogOpen$delegate, (String) this.$colors, rowScope.weight(), gapComposer3, 0);
                                    ComposableSingletons$PreferencesKt.f31lambda1.invoke((Object) gapComposer3, (Object) 0);
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }

                    public /* synthetic */ AnonymousClass3(List list, Object obj, AppColors appColors, int i) {
                        this.$r8$classId = i;
                        this.$logs = list;
                        this.$deleteDialogOpen$delegate = obj;
                        this.$colors = appColors;
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int iIntValue = ((Number) obj2).intValue();
                    AppColors appColors2 = appColors;
                    long j = appColors2.appBackground;
                    if ((iIntValue & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-2095152211);
                        Modifier modifierThen = Modifier.Companion.$$INSTANCE;
                        boolean z2 = z;
                        if (!z2) {
                            modifierThen = modifierThen.then(new HazeEffectNodeElement(hazeStateRememberHazeState, BackHandlerKt.m6thinIv8Zu3U(gapComposer2)));
                        }
                        Modifier modifier3 = modifierThen;
                        int i2 = 0;
                        gapComposer2.end(false);
                        PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                        long j2 = z2 ? j : Color.Transparent;
                        if (!z2) {
                            j = Color.Transparent;
                        }
                        long j3 = j;
                        long j4 = j2;
                        long j5 = appColors2.textPrimary;
                        AppBarKt.m238TopAppBargNPyAyM(Thread_jvmKt.rememberComposableLambda(-1425654993, new AnonymousClass6(appColors2, 12), gapComposer2), modifier3, Thread_jvmKt.rememberComposableLambda(-1499239571, new AnonymousClass2(function3, appColors2, 6), gapComposer2), Thread_jvmKt.rememberComposableLambda(1224015076, new AnonymousClass3(list, mutableState, appColors2, i2), gapComposer2), 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(j4, j3, j5, j5, j5, gapComposer2, 32), null, gapComposer2, 3462, 432);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(1738024190, new C00212(appColors, z, hazeStateRememberHazeState, function0, list, function1), gapComposer), gapComposer, 805306416, 444);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                long jM414compositeOverOWjLjI = BrushKt.m414compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground);
                RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(20);
                gapComposer.startReplaceGroup(2101390094);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 10);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                gapComposer.end(false);
                ScrimKt.m263AlertDialogOix01E0((Function0) objRememberedValue2, Thread_jvmKt.rememberComposableLambda(1763173634, new AnonymousClass4(function2, mutableState, appColors, 0), gapComposer), null, Thread_jvmKt.rememberComposableLambda(38565312, new AnonymousClass5(mutableState, appColors), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-1686043010, new AnonymousClass6(appColors, 0), gapComposer), Thread_jvmKt.rememberComposableLambda(1746620125, new AnonymousClass6(appColors, 14), gapComposer), roundedCornerShapeM158RoundedCornerShape0680j_4, jM414compositeOverOWjLjI, 0L, 0L, 0L, 0.0f, null, gapComposer, 1772598, 15892);
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(list, function0, function1, function2, function3, modifier2, z, i) { // from class: com.github.kr328.clash.compose.LogsScreenKt$$ExternalSyntheticLambda1
                public final /* synthetic */ List f$0;
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ Function1 f$2;
                public final /* synthetic */ Function0 f$3;
                public final /* synthetic */ Function0 f$4;
                public final /* synthetic */ Modifier f$5;
                public final /* synthetic */ boolean f$6;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    LogsScreenKt.LogsScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
