package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.impl.Quirks;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material.icons.filled.SwapHorizKt;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.PropertiesActivity$$ExternalSyntheticLambda4;
import com.github.kr328.clash.UpdateInfo;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.ProvidersScreenKt$ProvidersScreen$2$3$1;
import com.github.kr328.clash.compose.UpdateDialogKt;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda8;
import com.github.kr328.clash.compose.settings.SettingsEntry;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$$ExternalSyntheticLambda6;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.remote.Remote;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpx;
import com.google.android.gms.internal.mlkit_vision_common.zzje;
import com.koala.clash.R;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.serialization.json.JsonElementSerializersKt;
import okhttp3.TlsVersion;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzje {
    public static final void BuildInfoFooter(int i, GapComposer gapComposer, Modifier modifier, Function0 function0, boolean z) {
        GapComposer gapComposer2;
        Modifier modifier2;
        gapComposer.startRestartGroup(-381278243);
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changed(modifier) ? 256 : 128);
        if ((i2 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
            modifier2 = modifier;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(1843976365);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            Unit unit = Unit.INSTANCE;
            gapComposer.startReplaceGroup(1843978656);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new FilesActivity$showError$1(mutableState, null, 10);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, unit, (Function2) objRememberedValue2);
            gapComposer2 = gapComposer;
            modifier2 = modifier;
            zzjl.m819GlassSurfaceYxtnGt4(modifier2, 12, null, Thread_jvmKt.rememberComposableLambda(2119322778, new HomeScreenKt.AnonymousClass2(z, appColors, function0, mutableState), gapComposer), gapComposer2, ((i2 >> 6) & 14) | 196656, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SettingsScreenKt$$ExternalSyntheticLambda6(z, function0, modifier2, i);
        }
    }

    public static final void SettingsRow(SettingsEntry settingsEntry, GapComposer gapComposer, int i) {
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(415203615);
        if ((((gapComposer.changed(settingsEntry) ? 4 : 2) | i) & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(-723558107);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            Modifier modifierM135height3ABfNKs = SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 64);
            gapComposer.startReplaceGroup(-723552865);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 27);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            float f = 12;
            gapComposer2 = gapComposer;
            zzjl.m819GlassSurfaceYxtnGt4(ImageKt.m48borderxT4_qwU(((Boolean) mutableState.getValue()).booleanValue() ? 2 : 0, ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : Color.Transparent, FocusTraversalKt.onFocusChanged(modifierM135height3ABfNKs, (Function1) objRememberedValue2), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f)), f, null, Thread_jvmKt.rememberComposableLambda(-1731266878, new LogsScreenKt.AnonymousClass1.AnonymousClass3.AnonymousClass2(7, settingsEntry, appColors), gapComposer), gapComposer2, 196656, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Updater$$ExternalSyntheticLambda0(i, 29, settingsEntry);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x061f  */
    /* JADX WARN: Code duplicated, block: B:102:0x063f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x0645  */
    /* JADX WARN: Code duplicated, block: B:108:0x0661  */
    /* JADX WARN: Code duplicated, block: B:113:0x067f  */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:60:0x0120  */
    /* JADX WARN: Code duplicated, block: B:61:0x012c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0145  */
    /* JADX WARN: Code duplicated, block: B:67:0x0167  */
    /* JADX WARN: Code duplicated, block: B:70:0x017c  */
    /* JADX WARN: Code duplicated, block: B:73:0x0190  */
    /* JADX WARN: Code duplicated, block: B:76:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:80:0x032c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0334  */
    /* JADX WARN: Code duplicated, block: B:88:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:91:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:96:0x04f7  */
    public static final void SettingsScreen(Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, Modifier modifier, final PaddingValuesImpl paddingValuesImpl, boolean z, GapComposer gapComposer, int i, int i2) {
        boolean z2;
        final SnackbarHostState snackbarHostState;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        MutableState mutableState;
        Object objM;
        MutableState mutableState2;
        Object objM2;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final Context context;
        Object objRememberedValue4;
        final CoroutineScope coroutineScope;
        Object objRememberedValue5;
        final MutableState mutableState3;
        Object objM3;
        ListBuilder listBuilderCreateListBuilder;
        ImageVector imageVectorBuild;
        ImageVector imageVectorBuild2;
        GapComposer gapComposer2;
        Modifier modifier2;
        boolean z3;
        boolean zChangedInstance;
        Object objRememberedValue6;
        MutableState mutableState4;
        Object objM4;
        ImageVector imageVectorBuild3;
        ImageVector imageVectorBuild4;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(-1578400540);
        int i3 = i | (gapComposer.changedInstance(function0) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128) | (gapComposer.changedInstance(function3) ? 2048 : 1024) | (gapComposer.changedInstance(function4) ? 16384 : 8192) | 196608;
        if ((i & 1572864) == 0) {
            i3 |= gapComposer.changed(paddingValuesImpl) ? 1048576 : 524288;
        }
        int i4 = 12582912 | i3;
        int i5 = i2 & 256;
        if (i5 == 0) {
            if ((i & 100663296) == 0) {
                z2 = z;
                i4 |= gapComposer.changed(z2) ? 67108864 : 33554432;
            }
            if ((i4 & 38347923) == 38347922 || !gapComposer.getSkipping()) {
                if (i5 != 0) {
                    z2 = false;
                }
                final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                snackbarHostState = (SnackbarHostState) gapComposer.consume(GlassSnackbarKt.LocalGlassSnackbarHost);
                gapComposer.startReplaceGroup(-995676386);
                objRememberedValue = gapComposer.rememberedValue();
                neverEqualPolicy = Composer$Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(Boolean.valueOf(Remote.broadcasts.closed));
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                objM = Density.CC.m(-995673723, gapComposer, false);
                if (objM == neverEqualPolicy) {
                    objM = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(objM);
                }
                mutableState2 = (MutableState) objM;
                objM2 = Density.CC.m(-995671868, gapComposer, false);
                if (objM2 == neverEqualPolicy) {
                    objM2 = new ParcelableSnapshotMutableIntState(0);
                    gapComposer.updateRememberedValue(objM2);
                }
                parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objM2;
                gapComposer.end(false);
                Boolean bool = (Boolean) mutableState.getValue();
                bool.getClass();
                Integer numValueOf = Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue());
                gapComposer.startReplaceGroup(-995669122);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new ChannelFlow.AnonymousClass2(mutableState, mutableState2, null, 3);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                gapComposer.end(false);
                Stack.LaunchedEffect(bool, numValueOf, (Function2) objRememberedValue2, gapComposer);
                Unit unit = Unit.INSTANCE;
                gapComposer.startReplaceGroup(-995661558);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new BlurEffectKt$$ExternalSyntheticLambda1(12, mutableState, parcelableSnapshotMutableIntState);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                gapComposer.end(false);
                Stack.DisposableEffect(unit, (Function1) objRememberedValue3, gapComposer);
                context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                gapComposer.startReplaceGroup(-995632175);
                objRememberedValue5 = gapComposer.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = Stack.mutableStateOf$default(null);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                mutableState3 = (MutableState) objRememberedValue5;
                objM3 = Density.CC.m(-995629851, gapComposer, false);
                if (objM3 == neverEqualPolicy) {
                    objM3 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(objM3);
                }
                final MutableState mutableState5 = (MutableState) objM3;
                gapComposer.end(false);
                listBuilderCreateListBuilder = AppCompatHintHelper.createListBuilder();
                listBuilderCreateListBuilder.add(new SettingsEntry(SettingsKt.getSettings(), R.string.app, function0));
                imageVectorBuild = TlsVersion.Companion._dns;
                if (imageVectorBuild == null) {
                    ImageVector.Builder builder = new ImageVector.Builder("Filled.Dns", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i6 = VectorKt.$r8$clinit;
                    SolidColor solidColor = new SolidColor(Color.Black);
                    Quirks quirks = new Quirks();
                    quirks.moveTo(20.0f, 13.0f);
                    quirks.horizontalLineTo(4.0f);
                    quirks.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                    quirks.verticalLineToRelative(6.0f);
                    quirks.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                    quirks.horizontalLineToRelative(16.0f);
                    quirks.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                    quirks.verticalLineToRelative(-6.0f);
                    quirks.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                    quirks.close();
                    quirks.moveTo(7.0f, 19.0f);
                    quirks.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                    quirks.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                    quirks.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                    quirks.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                    quirks.close();
                    quirks.moveTo(20.0f, 3.0f);
                    quirks.horizontalLineTo(4.0f);
                    quirks.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                    quirks.verticalLineToRelative(6.0f);
                    quirks.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                    quirks.horizontalLineToRelative(16.0f);
                    quirks.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                    quirks.verticalLineTo(4.0f);
                    quirks.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                    quirks.close();
                    quirks.moveTo(7.0f, 9.0f);
                    quirks.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                    quirks.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                    quirks.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                    quirks.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                    quirks.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                    imageVectorBuild = builder.build();
                    TlsVersion.Companion._dns = imageVectorBuild;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild, R.string.network, function1));
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    imageVectorBuild4 = SwapHorizKt._swapHoriz;
                    if (imageVectorBuild4 == null) {
                        ImageVector.Builder builder2 = new ImageVector.Builder("Filled.SwapHoriz", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i7 = VectorKt.$r8$clinit;
                        SolidColor solidColor2 = new SolidColor(Color.Black);
                        Quirks quirks2 = new Quirks();
                        quirks2.moveTo(6.99f, 11.0f);
                        quirks2.lineTo(3.0f, 15.0f);
                        quirks2.lineToRelative(3.99f, 4.0f);
                        quirks2.verticalLineToRelative(-3.0f);
                        quirks2.horizontalLineTo(14.0f);
                        quirks2.verticalLineToRelative(-2.0f);
                        quirks2.horizontalLineTo(6.99f);
                        quirks2.verticalLineToRelative(-3.0f);
                        quirks2.close();
                        quirks2.moveTo(21.0f, 9.0f);
                        quirks2.lineToRelative(-3.99f, -4.0f);
                        quirks2.verticalLineToRelative(3.0f);
                        quirks2.horizontalLineTo(10.0f);
                        quirks2.verticalLineToRelative(2.0f);
                        quirks2.horizontalLineToRelative(7.01f);
                        quirks2.verticalLineToRelative(3.0f);
                        quirks2.lineTo(21.0f, 9.0f);
                        quirks2.close();
                        ImageVector.Builder.m502addPathoIyEayM$default(builder2, quirks2.mQuirks, solidColor2);
                        imageVectorBuild4 = builder2.build();
                        SwapHorizKt._swapHoriz = imageVectorBuild4;
                    }
                    listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild4, R.string.connections, function2));
                }
                imageVectorBuild2 = JsonElementSerializersKt._article;
                if (imageVectorBuild2 == null) {
                    ImageVector.Builder builder3 = new ImageVector.Builder("AutoMirrored.Outlined.Article", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
                    int i8 = VectorKt.$r8$clinit;
                    long j = Color.Black;
                    SolidColor solidColor3 = new SolidColor(j);
                    Quirks quirks3 = new Quirks();
                    quirks3.moveTo(19.0f, 5.0f);
                    quirks3.verticalLineToRelative(14.0f);
                    quirks3.horizontalLineTo(5.0f);
                    quirks3.verticalLineTo(5.0f);
                    quirks3.horizontalLineTo(19.0f);
                    quirks3.moveTo(19.0f, 3.0f);
                    quirks3.horizontalLineTo(5.0f);
                    quirks3.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
                    quirks3.verticalLineToRelative(14.0f);
                    quirks3.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                    quirks3.horizontalLineToRelative(14.0f);
                    quirks3.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                    quirks3.verticalLineTo(5.0f);
                    quirks3.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
                    quirks3.lineTo(19.0f, 3.0f);
                    quirks3.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder3, quirks3.mQuirks, solidColor3);
                    SolidColor solidColor4 = new SolidColor(j);
                    Quirks quirks4 = new Quirks();
                    quirks4.moveTo(14.0f, 17.0f);
                    quirks4.horizontalLineTo(7.0f);
                    quirks4.verticalLineToRelative(-2.0f);
                    quirks4.horizontalLineToRelative(7.0f);
                    quirks4.verticalLineTo(17.0f);
                    quirks4.close();
                    quirks4.moveTo(17.0f, 13.0f);
                    quirks4.horizontalLineTo(7.0f);
                    quirks4.verticalLineToRelative(-2.0f);
                    quirks4.horizontalLineToRelative(10.0f);
                    quirks4.verticalLineTo(13.0f);
                    quirks4.close();
                    quirks4.moveTo(17.0f, 9.0f);
                    quirks4.horizontalLineTo(7.0f);
                    quirks4.verticalLineTo(7.0f);
                    quirks4.horizontalLineToRelative(10.0f);
                    quirks4.verticalLineTo(9.0f);
                    quirks4.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder3, quirks4.mQuirks, solidColor4);
                    imageVectorBuild2 = builder3.build();
                    JsonElementSerializersKt._article = imageVectorBuild2;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild2, R.string.logs, function3));
                if (((Boolean) mutableState.getValue()).booleanValue() && ((Boolean) mutableState2.getValue()).booleanValue()) {
                    imageVectorBuild3 = zzpx._swapVerticalCircle;
                    if (imageVectorBuild3 == null) {
                        ImageVector.Builder builder4 = new ImageVector.Builder("Filled.SwapVerticalCircle", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i9 = VectorKt.$r8$clinit;
                        SolidColor solidColor5 = new SolidColor(Color.Black);
                        Quirks quirks5 = new Quirks();
                        quirks5.moveTo(12.0f, 2.0f);
                        quirks5.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                        quirks5.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                        quirks5.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                        quirks5.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                        quirks5.close();
                        quirks5.moveTo(6.5f, 9.0f);
                        quirks5.lineTo(10.0f, 5.5f);
                        quirks5.lineTo(13.5f, 9.0f);
                        quirks5.lineTo(11.0f, 9.0f);
                        quirks5.verticalLineToRelative(4.0f);
                        quirks5.lineTo(9.0f, 13.0f);
                        quirks5.lineTo(9.0f, 9.0f);
                        quirks5.lineTo(6.5f, 9.0f);
                        quirks5.close();
                        quirks5.moveTo(17.5f, 15.0f);
                        quirks5.lineTo(14.0f, 18.5f);
                        quirks5.lineTo(10.5f, 15.0f);
                        quirks5.lineTo(13.0f, 15.0f);
                        quirks5.verticalLineToRelative(-4.0f);
                        quirks5.horizontalLineToRelative(2.0f);
                        quirks5.verticalLineToRelative(4.0f);
                        quirks5.horizontalLineToRelative(2.5f);
                        quirks5.close();
                        ImageVector.Builder.m502addPathoIyEayM$default(builder4, quirks5.mQuirks, solidColor5);
                        imageVectorBuild3 = builder4.build();
                        zzpx._swapVerticalCircle = imageVectorBuild3;
                    }
                    listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild3, R.string.providers, function4));
                }
                final ListBuilder listBuilderBuild = AppCompatHintHelper.build(listBuilderCreateListBuilder);
                boolean z4 = z2;
                ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1555841112, new ProvidersScreenKt$ProvidersScreen$2$3$1(z2, appColors, 2), gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(977690355, new Function3() { // from class: com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        PaddingValues paddingValues = (PaddingValues) obj;
                        GapComposer gapComposer3 = (GapComposer) obj2;
                        int iIntValue = ((Number) obj3).intValue();
                        if ((iIntValue & 6) == 0) {
                            iIntValue |= gapComposer3.changed(paddingValues) ? 4 : 2;
                        }
                        if ((iIntValue & 19) == 18 && gapComposer3.getSkipping()) {
                            gapComposer3.skipToGroupEnd();
                        } else {
                            Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape);
                            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer3, 0);
                            long j2 = gapComposer3.compositeKeyHashCode;
                            int i10 = (int) (j2 ^ (j2 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM47backgroundbw27NRU);
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m295setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m295setimpl(gapComposer3, Integer.valueOf(i10), ComposeUiNode.Companion.SetCompositeKeyHash);
                            Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                            if (1.0f <= 0.0d) {
                                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                            }
                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(new LayoutWeightElement(1.0f, true), 1.0f);
                            float f = 8;
                            float f2 = 16;
                            PaddingValuesImpl paddingValuesImpl2 = new PaddingValuesImpl(f2, paddingValues.mo120calculateTopPaddingD9Ej5fM() + f, f2, f);
                            Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(12);
                            gapComposer3.startReplaceGroup(-71810661);
                            List list = listBuilderBuild;
                            boolean zChangedInstance2 = gapComposer3.changedInstance(list);
                            Object objRememberedValue7 = gapComposer3.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                            if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy2) {
                                objRememberedValue7 = new DiskLruCache$$ExternalSyntheticLambda0(12, list);
                                gapComposer3.updateRememberedValue(objRememberedValue7);
                            }
                            gapComposer3.end(false);
                            LazyDslKt.LazyColumn(modifierFillMaxWidth, null, paddingValuesImpl2, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue7, gapComposer3, 24576, 490);
                            MutableState mutableState6 = mutableState5;
                            boolean zBooleanValue = ((Boolean) mutableState6.getValue()).booleanValue();
                            gapComposer3.startReplaceGroup(-71802873);
                            CoroutineScope coroutineScope2 = coroutineScope;
                            boolean zChangedInstance3 = gapComposer3.changedInstance(coroutineScope2);
                            SnackbarHostState snackbarHostState2 = snackbarHostState;
                            boolean zChanged = zChangedInstance3 | gapComposer3.changed(snackbarHostState2);
                            Context context2 = context;
                            boolean zChangedInstance4 = zChanged | gapComposer3.changedInstance(context2);
                            Object objRememberedValue8 = gapComposer3.rememberedValue();
                            if (zChangedInstance4 || objRememberedValue8 == neverEqualPolicy2) {
                                PropertiesActivity$$ExternalSyntheticLambda4 propertiesActivity$$ExternalSyntheticLambda4 = new PropertiesActivity$$ExternalSyntheticLambda4(coroutineScope2, mutableState6, snackbarHostState2, context2, mutableState3, 1);
                                gapComposer3.updateRememberedValue(propertiesActivity$$ExternalSyntheticLambda4);
                                objRememberedValue8 = propertiesActivity$$ExternalSyntheticLambda4;
                            }
                            gapComposer3.end(false);
                            zzje.BuildInfoFooter(0, gapComposer3, OffsetKt.m132paddingqDBjuR0$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), f2, 0.0f, f2, paddingValuesImpl.bottom + f2, 2), (Function0) objRememberedValue8, zBooleanValue);
                            gapComposer3.end(true);
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 805306416, 444);
                gapComposer2 = gapComposer;
                if (((UpdateInfo) mutableState3.getValue()) != null) {
                    UpdateInfo updateInfo = (UpdateInfo) mutableState3.getValue();
                    gapComposer2.startReplaceGroup(-995499547);
                    zChangedInstance = gapComposer2.changedInstance(context) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changed(snackbarHostState);
                    objRememberedValue6 = gapComposer2.rememberedValue();
                    if (!zChangedInstance || objRememberedValue6 == neverEqualPolicy) {
                        mutableState4 = mutableState3;
                        BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda1 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                        gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda1);
                        objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda1;
                    } else {
                        mutableState4 = mutableState3;
                    }
                    Function0 function5 = (Function0) objRememberedValue6;
                    objM4 = Density.CC.m(-995475816, gapComposer2, false);
                    if (objM4 == neverEqualPolicy) {
                        objM4 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState4, 9);
                        gapComposer2.updateRememberedValue(objM4);
                    }
                    gapComposer2.end(false);
                    UpdateDialogKt.UpdateDialog(updateInfo, function5, (Function0) objM4, gapComposer2, 384);
                }
                modifier2 = Modifier.Companion.$$INSTANCE;
                z3 = z4;
            } else {
                gapComposer.skipToGroupEnd();
                z3 = z2;
                gapComposer2 = gapComposer;
                modifier2 = modifier;
            }
            recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, function1, function2, function3, function4, modifier2, paddingValuesImpl, z3, i, i2, 2);
            }
        }
        i4 = 113246208 | i3;
        z2 = z;
        if ((i4 & 38347923) == 38347922) {
            if (i5 != 0) {
                z2 = false;
            }
            final AppColors appColors2 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            snackbarHostState = (SnackbarHostState) gapComposer.consume(GlassSnackbarKt.LocalGlassSnackbarHost);
            gapComposer.startReplaceGroup(-995676386);
            objRememberedValue = gapComposer.rememberedValue();
            neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.valueOf(Remote.broadcasts.closed));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objM = Density.CC.m(-995673723, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM);
            }
            mutableState2 = (MutableState) objM;
            objM2 = Density.CC.m(-995671868, gapComposer, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = new ParcelableSnapshotMutableIntState(0);
                gapComposer.updateRememberedValue(objM2);
            }
            parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objM2;
            gapComposer.end(false);
            Boolean bool2 = (Boolean) mutableState.getValue();
            bool2.getClass();
            Integer numValueOf2 = Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue());
            gapComposer.startReplaceGroup(-995669122);
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ChannelFlow.AnonymousClass2(mutableState, mutableState2, null, 3);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(bool2, numValueOf2, (Function2) objRememberedValue2, gapComposer);
            Unit unit2 = Unit.INSTANCE;
            gapComposer.startReplaceGroup(-995661558);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new BlurEffectKt$$ExternalSyntheticLambda1(12, mutableState, parcelableSnapshotMutableIntState);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            gapComposer.end(false);
            Stack.DisposableEffect(unit2, (Function1) objRememberedValue3, gapComposer);
            context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            coroutineScope = (CoroutineScope) objRememberedValue4;
            gapComposer.startReplaceGroup(-995632175);
            objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            mutableState3 = (MutableState) objRememberedValue5;
            objM3 = Density.CC.m(-995629851, gapComposer, false);
            if (objM3 == neverEqualPolicy) {
                objM3 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM3);
            }
            final MutableState mutableState6 = (MutableState) objM3;
            gapComposer.end(false);
            listBuilderCreateListBuilder = AppCompatHintHelper.createListBuilder();
            listBuilderCreateListBuilder.add(new SettingsEntry(SettingsKt.getSettings(), R.string.app, function0));
            imageVectorBuild = TlsVersion.Companion._dns;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder5 = new ImageVector.Builder("Filled.Dns", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i10 = VectorKt.$r8$clinit;
                SolidColor solidColor6 = new SolidColor(Color.Black);
                Quirks quirks6 = new Quirks();
                quirks6.moveTo(20.0f, 13.0f);
                quirks6.horizontalLineTo(4.0f);
                quirks6.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                quirks6.verticalLineToRelative(6.0f);
                quirks6.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                quirks6.horizontalLineToRelative(16.0f);
                quirks6.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                quirks6.verticalLineToRelative(-6.0f);
                quirks6.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                quirks6.close();
                quirks6.moveTo(7.0f, 19.0f);
                quirks6.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                quirks6.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                quirks6.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                quirks6.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                quirks6.close();
                quirks6.moveTo(20.0f, 3.0f);
                quirks6.horizontalLineTo(4.0f);
                quirks6.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                quirks6.verticalLineToRelative(6.0f);
                quirks6.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                quirks6.horizontalLineToRelative(16.0f);
                quirks6.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                quirks6.verticalLineTo(4.0f);
                quirks6.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                quirks6.close();
                quirks6.moveTo(7.0f, 9.0f);
                quirks6.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                quirks6.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                quirks6.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                quirks6.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                quirks6.close();
                ImageVector.Builder.m502addPathoIyEayM$default(builder5, quirks6.mQuirks, solidColor6);
                imageVectorBuild = builder5.build();
                TlsVersion.Companion._dns = imageVectorBuild;
            }
            listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild, R.string.network, function1));
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                imageVectorBuild4 = SwapHorizKt._swapHoriz;
                if (imageVectorBuild4 == null) {
                    ImageVector.Builder builder6 = new ImageVector.Builder("Filled.SwapHoriz", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i11 = VectorKt.$r8$clinit;
                    SolidColor solidColor7 = new SolidColor(Color.Black);
                    Quirks quirks7 = new Quirks();
                    quirks7.moveTo(6.99f, 11.0f);
                    quirks7.lineTo(3.0f, 15.0f);
                    quirks7.lineToRelative(3.99f, 4.0f);
                    quirks7.verticalLineToRelative(-3.0f);
                    quirks7.horizontalLineTo(14.0f);
                    quirks7.verticalLineToRelative(-2.0f);
                    quirks7.horizontalLineTo(6.99f);
                    quirks7.verticalLineToRelative(-3.0f);
                    quirks7.close();
                    quirks7.moveTo(21.0f, 9.0f);
                    quirks7.lineToRelative(-3.99f, -4.0f);
                    quirks7.verticalLineToRelative(3.0f);
                    quirks7.horizontalLineTo(10.0f);
                    quirks7.verticalLineToRelative(2.0f);
                    quirks7.horizontalLineToRelative(7.01f);
                    quirks7.verticalLineToRelative(3.0f);
                    quirks7.lineTo(21.0f, 9.0f);
                    quirks7.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder6, quirks7.mQuirks, solidColor7);
                    imageVectorBuild4 = builder6.build();
                    SwapHorizKt._swapHoriz = imageVectorBuild4;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild4, R.string.connections, function2));
            }
            imageVectorBuild2 = JsonElementSerializersKt._article;
            if (imageVectorBuild2 == null) {
                ImageVector.Builder builder7 = new ImageVector.Builder("AutoMirrored.Outlined.Article", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
                int i12 = VectorKt.$r8$clinit;
                long j2 = Color.Black;
                SolidColor solidColor8 = new SolidColor(j2);
                Quirks quirks8 = new Quirks();
                quirks8.moveTo(19.0f, 5.0f);
                quirks8.verticalLineToRelative(14.0f);
                quirks8.horizontalLineTo(5.0f);
                quirks8.verticalLineTo(5.0f);
                quirks8.horizontalLineTo(19.0f);
                quirks8.moveTo(19.0f, 3.0f);
                quirks8.horizontalLineTo(5.0f);
                quirks8.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
                quirks8.verticalLineToRelative(14.0f);
                quirks8.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                quirks8.horizontalLineToRelative(14.0f);
                quirks8.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                quirks8.verticalLineTo(5.0f);
                quirks8.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
                quirks8.lineTo(19.0f, 3.0f);
                quirks8.close();
                ImageVector.Builder.m502addPathoIyEayM$default(builder7, quirks8.mQuirks, solidColor8);
                SolidColor solidColor9 = new SolidColor(j2);
                Quirks quirks9 = new Quirks();
                quirks9.moveTo(14.0f, 17.0f);
                quirks9.horizontalLineTo(7.0f);
                quirks9.verticalLineToRelative(-2.0f);
                quirks9.horizontalLineToRelative(7.0f);
                quirks9.verticalLineTo(17.0f);
                quirks9.close();
                quirks9.moveTo(17.0f, 13.0f);
                quirks9.horizontalLineTo(7.0f);
                quirks9.verticalLineToRelative(-2.0f);
                quirks9.horizontalLineToRelative(10.0f);
                quirks9.verticalLineTo(13.0f);
                quirks9.close();
                quirks9.moveTo(17.0f, 9.0f);
                quirks9.horizontalLineTo(7.0f);
                quirks9.verticalLineTo(7.0f);
                quirks9.horizontalLineToRelative(10.0f);
                quirks9.verticalLineTo(9.0f);
                quirks9.close();
                ImageVector.Builder.m502addPathoIyEayM$default(builder7, quirks9.mQuirks, solidColor9);
                imageVectorBuild2 = builder7.build();
                JsonElementSerializersKt._article = imageVectorBuild2;
            }
            listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild2, R.string.logs, function3));
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                imageVectorBuild3 = zzpx._swapVerticalCircle;
                if (imageVectorBuild3 == null) {
                    ImageVector.Builder builder8 = new ImageVector.Builder("Filled.SwapVerticalCircle", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i13 = VectorKt.$r8$clinit;
                    SolidColor solidColor10 = new SolidColor(Color.Black);
                    Quirks quirks10 = new Quirks();
                    quirks10.moveTo(12.0f, 2.0f);
                    quirks10.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                    quirks10.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                    quirks10.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                    quirks10.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                    quirks10.close();
                    quirks10.moveTo(6.5f, 9.0f);
                    quirks10.lineTo(10.0f, 5.5f);
                    quirks10.lineTo(13.5f, 9.0f);
                    quirks10.lineTo(11.0f, 9.0f);
                    quirks10.verticalLineToRelative(4.0f);
                    quirks10.lineTo(9.0f, 13.0f);
                    quirks10.lineTo(9.0f, 9.0f);
                    quirks10.lineTo(6.5f, 9.0f);
                    quirks10.close();
                    quirks10.moveTo(17.5f, 15.0f);
                    quirks10.lineTo(14.0f, 18.5f);
                    quirks10.lineTo(10.5f, 15.0f);
                    quirks10.lineTo(13.0f, 15.0f);
                    quirks10.verticalLineToRelative(-4.0f);
                    quirks10.horizontalLineToRelative(2.0f);
                    quirks10.verticalLineToRelative(4.0f);
                    quirks10.horizontalLineToRelative(2.5f);
                    quirks10.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder8, quirks10.mQuirks, solidColor10);
                    imageVectorBuild3 = builder8.build();
                    zzpx._swapVerticalCircle = imageVectorBuild3;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild3, R.string.providers, function4));
            }
            final ListBuilder listBuilderBuild2 = AppCompatHintHelper.build(listBuilderCreateListBuilder);
            boolean z5 = z2;
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors2.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1555841112, new ProvidersScreenKt$ProvidersScreen$2$3$1(z2, appColors2, 2), gapComposer), null, null, null, 0, appColors2.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(977690355, new Function3() { // from class: com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer3 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer3.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors2.appBackground, BrushKt.RectangleShape);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer3, 0);
                        long j3 = gapComposer3.compositeKeyHashCode;
                        int i14 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM47backgroundbw27NRU);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer3, Integer.valueOf(i14), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(new LayoutWeightElement(1.0f, true), 1.0f);
                        float f = 8;
                        float f2 = 16;
                        PaddingValuesImpl paddingValuesImpl2 = new PaddingValuesImpl(f2, paddingValues.mo120calculateTopPaddingD9Ej5fM() + f, f2, f);
                        Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(12);
                        gapComposer3.startReplaceGroup(-71810661);
                        List list = listBuilderBuild2;
                        boolean zChangedInstance2 = gapComposer3.changedInstance(list);
                        Object objRememberedValue7 = gapComposer3.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy2) {
                            objRememberedValue7 = new DiskLruCache$$ExternalSyntheticLambda0(12, list);
                            gapComposer3.updateRememberedValue(objRememberedValue7);
                        }
                        gapComposer3.end(false);
                        LazyDslKt.LazyColumn(modifierFillMaxWidth, null, paddingValuesImpl2, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue7, gapComposer3, 24576, 490);
                        MutableState mutableState7 = mutableState6;
                        boolean zBooleanValue = ((Boolean) mutableState7.getValue()).booleanValue();
                        gapComposer3.startReplaceGroup(-71802873);
                        CoroutineScope coroutineScope2 = coroutineScope;
                        boolean zChangedInstance3 = gapComposer3.changedInstance(coroutineScope2);
                        SnackbarHostState snackbarHostState2 = snackbarHostState;
                        boolean zChanged = zChangedInstance3 | gapComposer3.changed(snackbarHostState2);
                        Context context2 = context;
                        boolean zChangedInstance4 = zChanged | gapComposer3.changedInstance(context2);
                        Object objRememberedValue8 = gapComposer3.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue8 == neverEqualPolicy2) {
                            PropertiesActivity$$ExternalSyntheticLambda4 propertiesActivity$$ExternalSyntheticLambda4 = new PropertiesActivity$$ExternalSyntheticLambda4(coroutineScope2, mutableState7, snackbarHostState2, context2, mutableState3, 1);
                            gapComposer3.updateRememberedValue(propertiesActivity$$ExternalSyntheticLambda4);
                            objRememberedValue8 = propertiesActivity$$ExternalSyntheticLambda4;
                        }
                        gapComposer3.end(false);
                        zzje.BuildInfoFooter(0, gapComposer3, OffsetKt.m132paddingqDBjuR0$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), f2, 0.0f, f2, paddingValuesImpl.bottom + f2, 2), (Function0) objRememberedValue8, zBooleanValue);
                        gapComposer3.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306416, 444);
            gapComposer2 = gapComposer;
            if (((UpdateInfo) mutableState3.getValue()) != null) {
                UpdateInfo updateInfo2 = (UpdateInfo) mutableState3.getValue();
                gapComposer2.startReplaceGroup(-995499547);
                zChangedInstance = gapComposer2.changedInstance(context) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changed(snackbarHostState);
                objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChangedInstance) {
                    mutableState4 = mutableState3;
                    BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda2 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                    gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda2);
                    objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda2;
                } else {
                    mutableState4 = mutableState3;
                    BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda3 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                    gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda3);
                    objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda3;
                }
                Function0 function6 = (Function0) objRememberedValue6;
                objM4 = Density.CC.m(-995475816, gapComposer2, false);
                if (objM4 == neverEqualPolicy) {
                    objM4 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState4, 9);
                    gapComposer2.updateRememberedValue(objM4);
                }
                gapComposer2.end(false);
                UpdateDialogKt.UpdateDialog(updateInfo2, function6, (Function0) objM4, gapComposer2, 384);
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
            z3 = z5;
        } else {
            if (i5 != 0) {
                z2 = false;
            }
            final AppColors appColors3 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            snackbarHostState = (SnackbarHostState) gapComposer.consume(GlassSnackbarKt.LocalGlassSnackbarHost);
            gapComposer.startReplaceGroup(-995676386);
            objRememberedValue = gapComposer.rememberedValue();
            neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.valueOf(Remote.broadcasts.closed));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            objM = Density.CC.m(-995673723, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM);
            }
            mutableState2 = (MutableState) objM;
            objM2 = Density.CC.m(-995671868, gapComposer, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = new ParcelableSnapshotMutableIntState(0);
                gapComposer.updateRememberedValue(objM2);
            }
            parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objM2;
            gapComposer.end(false);
            Boolean bool3 = (Boolean) mutableState.getValue();
            bool3.getClass();
            Integer numValueOf3 = Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue());
            gapComposer.startReplaceGroup(-995669122);
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ChannelFlow.AnonymousClass2(mutableState, mutableState2, null, 3);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(bool3, numValueOf3, (Function2) objRememberedValue2, gapComposer);
            Unit unit3 = Unit.INSTANCE;
            gapComposer.startReplaceGroup(-995661558);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new BlurEffectKt$$ExternalSyntheticLambda1(12, mutableState, parcelableSnapshotMutableIntState);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            gapComposer.end(false);
            Stack.DisposableEffect(unit3, (Function1) objRememberedValue3, gapComposer);
            context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            coroutineScope = (CoroutineScope) objRememberedValue4;
            gapComposer.startReplaceGroup(-995632175);
            objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            mutableState3 = (MutableState) objRememberedValue5;
            objM3 = Density.CC.m(-995629851, gapComposer, false);
            if (objM3 == neverEqualPolicy) {
                objM3 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM3);
            }
            final MutableState mutableState7 = (MutableState) objM3;
            gapComposer.end(false);
            listBuilderCreateListBuilder = AppCompatHintHelper.createListBuilder();
            listBuilderCreateListBuilder.add(new SettingsEntry(SettingsKt.getSettings(), R.string.app, function0));
            imageVectorBuild = TlsVersion.Companion._dns;
            if (imageVectorBuild == null) {
                ImageVector.Builder builder9 = new ImageVector.Builder("Filled.Dns", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i14 = VectorKt.$r8$clinit;
                SolidColor solidColor11 = new SolidColor(Color.Black);
                Quirks quirks11 = new Quirks();
                quirks11.moveTo(20.0f, 13.0f);
                quirks11.horizontalLineTo(4.0f);
                quirks11.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                quirks11.verticalLineToRelative(6.0f);
                quirks11.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                quirks11.horizontalLineToRelative(16.0f);
                quirks11.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                quirks11.verticalLineToRelative(-6.0f);
                quirks11.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                quirks11.close();
                quirks11.moveTo(7.0f, 19.0f);
                quirks11.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                quirks11.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                quirks11.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                quirks11.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                quirks11.close();
                quirks11.moveTo(20.0f, 3.0f);
                quirks11.horizontalLineTo(4.0f);
                quirks11.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                quirks11.verticalLineToRelative(6.0f);
                quirks11.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                quirks11.horizontalLineToRelative(16.0f);
                quirks11.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                quirks11.verticalLineTo(4.0f);
                quirks11.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                quirks11.close();
                quirks11.moveTo(7.0f, 9.0f);
                quirks11.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
                quirks11.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
                quirks11.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
                quirks11.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
                quirks11.close();
                ImageVector.Builder.m502addPathoIyEayM$default(builder9, quirks11.mQuirks, solidColor11);
                imageVectorBuild = builder9.build();
                TlsVersion.Companion._dns = imageVectorBuild;
            }
            listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild, R.string.network, function1));
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                imageVectorBuild4 = SwapHorizKt._swapHoriz;
                if (imageVectorBuild4 == null) {
                    ImageVector.Builder builder10 = new ImageVector.Builder("Filled.SwapHoriz", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i15 = VectorKt.$r8$clinit;
                    SolidColor solidColor12 = new SolidColor(Color.Black);
                    Quirks quirks12 = new Quirks();
                    quirks12.moveTo(6.99f, 11.0f);
                    quirks12.lineTo(3.0f, 15.0f);
                    quirks12.lineToRelative(3.99f, 4.0f);
                    quirks12.verticalLineToRelative(-3.0f);
                    quirks12.horizontalLineTo(14.0f);
                    quirks12.verticalLineToRelative(-2.0f);
                    quirks12.horizontalLineTo(6.99f);
                    quirks12.verticalLineToRelative(-3.0f);
                    quirks12.close();
                    quirks12.moveTo(21.0f, 9.0f);
                    quirks12.lineToRelative(-3.99f, -4.0f);
                    quirks12.verticalLineToRelative(3.0f);
                    quirks12.horizontalLineTo(10.0f);
                    quirks12.verticalLineToRelative(2.0f);
                    quirks12.horizontalLineToRelative(7.01f);
                    quirks12.verticalLineToRelative(3.0f);
                    quirks12.lineTo(21.0f, 9.0f);
                    quirks12.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder10, quirks12.mQuirks, solidColor12);
                    imageVectorBuild4 = builder10.build();
                    SwapHorizKt._swapHoriz = imageVectorBuild4;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild4, R.string.connections, function2));
            }
            imageVectorBuild2 = JsonElementSerializersKt._article;
            if (imageVectorBuild2 == null) {
                ImageVector.Builder builder11 = new ImageVector.Builder("AutoMirrored.Outlined.Article", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
                int i16 = VectorKt.$r8$clinit;
                long j3 = Color.Black;
                SolidColor solidColor13 = new SolidColor(j3);
                Quirks quirks13 = new Quirks();
                quirks13.moveTo(19.0f, 5.0f);
                quirks13.verticalLineToRelative(14.0f);
                quirks13.horizontalLineTo(5.0f);
                quirks13.verticalLineTo(5.0f);
                quirks13.horizontalLineTo(19.0f);
                quirks13.moveTo(19.0f, 3.0f);
                quirks13.horizontalLineTo(5.0f);
                quirks13.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
                quirks13.verticalLineToRelative(14.0f);
                quirks13.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                quirks13.horizontalLineToRelative(14.0f);
                quirks13.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                quirks13.verticalLineTo(5.0f);
                quirks13.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
                quirks13.lineTo(19.0f, 3.0f);
                quirks13.close();
                ImageVector.Builder.m502addPathoIyEayM$default(builder11, quirks13.mQuirks, solidColor13);
                SolidColor solidColor14 = new SolidColor(j3);
                Quirks quirks14 = new Quirks();
                quirks14.moveTo(14.0f, 17.0f);
                quirks14.horizontalLineTo(7.0f);
                quirks14.verticalLineToRelative(-2.0f);
                quirks14.horizontalLineToRelative(7.0f);
                quirks14.verticalLineTo(17.0f);
                quirks14.close();
                quirks14.moveTo(17.0f, 13.0f);
                quirks14.horizontalLineTo(7.0f);
                quirks14.verticalLineToRelative(-2.0f);
                quirks14.horizontalLineToRelative(10.0f);
                quirks14.verticalLineTo(13.0f);
                quirks14.close();
                quirks14.moveTo(17.0f, 9.0f);
                quirks14.horizontalLineTo(7.0f);
                quirks14.verticalLineTo(7.0f);
                quirks14.horizontalLineToRelative(10.0f);
                quirks14.verticalLineTo(9.0f);
                quirks14.close();
                ImageVector.Builder.m502addPathoIyEayM$default(builder11, quirks14.mQuirks, solidColor14);
                imageVectorBuild2 = builder11.build();
                JsonElementSerializersKt._article = imageVectorBuild2;
            }
            listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild2, R.string.logs, function3));
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                imageVectorBuild3 = zzpx._swapVerticalCircle;
                if (imageVectorBuild3 == null) {
                    ImageVector.Builder builder12 = new ImageVector.Builder("Filled.SwapVerticalCircle", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i17 = VectorKt.$r8$clinit;
                    SolidColor solidColor15 = new SolidColor(Color.Black);
                    Quirks quirks15 = new Quirks();
                    quirks15.moveTo(12.0f, 2.0f);
                    quirks15.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                    quirks15.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                    quirks15.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                    quirks15.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                    quirks15.close();
                    quirks15.moveTo(6.5f, 9.0f);
                    quirks15.lineTo(10.0f, 5.5f);
                    quirks15.lineTo(13.5f, 9.0f);
                    quirks15.lineTo(11.0f, 9.0f);
                    quirks15.verticalLineToRelative(4.0f);
                    quirks15.lineTo(9.0f, 13.0f);
                    quirks15.lineTo(9.0f, 9.0f);
                    quirks15.lineTo(6.5f, 9.0f);
                    quirks15.close();
                    quirks15.moveTo(17.5f, 15.0f);
                    quirks15.lineTo(14.0f, 18.5f);
                    quirks15.lineTo(10.5f, 15.0f);
                    quirks15.lineTo(13.0f, 15.0f);
                    quirks15.verticalLineToRelative(-4.0f);
                    quirks15.horizontalLineToRelative(2.0f);
                    quirks15.verticalLineToRelative(4.0f);
                    quirks15.horizontalLineToRelative(2.5f);
                    quirks15.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder12, quirks15.mQuirks, solidColor15);
                    imageVectorBuild3 = builder12.build();
                    zzpx._swapVerticalCircle = imageVectorBuild3;
                }
                listBuilderCreateListBuilder.add(new SettingsEntry(imageVectorBuild3, R.string.providers, function4));
            }
            final ListBuilder listBuilderBuild3 = AppCompatHintHelper.build(listBuilderCreateListBuilder);
            boolean z6 = z2;
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors3.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1555841112, new ProvidersScreenKt$ProvidersScreen$2$3$1(z2, appColors3, 2), gapComposer), null, null, null, 0, appColors3.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(977690355, new Function3() { // from class: com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer3 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer3.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors3.appBackground, BrushKt.RectangleShape);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer3, 0);
                        long j4 = gapComposer3.compositeKeyHashCode;
                        int i18 = (int) (j4 ^ (j4 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM47backgroundbw27NRU);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer3, Integer.valueOf(i18), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(new LayoutWeightElement(1.0f, true), 1.0f);
                        float f = 8;
                        float f2 = 16;
                        PaddingValuesImpl paddingValuesImpl2 = new PaddingValuesImpl(f2, paddingValues.mo120calculateTopPaddingD9Ej5fM() + f, f2, f);
                        Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(12);
                        gapComposer3.startReplaceGroup(-71810661);
                        List list = listBuilderBuild3;
                        boolean zChangedInstance2 = gapComposer3.changedInstance(list);
                        Object objRememberedValue7 = gapComposer3.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zChangedInstance2 || objRememberedValue7 == neverEqualPolicy2) {
                            objRememberedValue7 = new DiskLruCache$$ExternalSyntheticLambda0(12, list);
                            gapComposer3.updateRememberedValue(objRememberedValue7);
                        }
                        gapComposer3.end(false);
                        LazyDslKt.LazyColumn(modifierFillMaxWidth, null, paddingValuesImpl2, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue7, gapComposer3, 24576, 490);
                        MutableState mutableState8 = mutableState7;
                        boolean zBooleanValue = ((Boolean) mutableState8.getValue()).booleanValue();
                        gapComposer3.startReplaceGroup(-71802873);
                        CoroutineScope coroutineScope2 = coroutineScope;
                        boolean zChangedInstance3 = gapComposer3.changedInstance(coroutineScope2);
                        SnackbarHostState snackbarHostState2 = snackbarHostState;
                        boolean zChanged = zChangedInstance3 | gapComposer3.changed(snackbarHostState2);
                        Context context2 = context;
                        boolean zChangedInstance4 = zChanged | gapComposer3.changedInstance(context2);
                        Object objRememberedValue8 = gapComposer3.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue8 == neverEqualPolicy2) {
                            PropertiesActivity$$ExternalSyntheticLambda4 propertiesActivity$$ExternalSyntheticLambda4 = new PropertiesActivity$$ExternalSyntheticLambda4(coroutineScope2, mutableState8, snackbarHostState2, context2, mutableState3, 1);
                            gapComposer3.updateRememberedValue(propertiesActivity$$ExternalSyntheticLambda4);
                            objRememberedValue8 = propertiesActivity$$ExternalSyntheticLambda4;
                        }
                        gapComposer3.end(false);
                        zzje.BuildInfoFooter(0, gapComposer3, OffsetKt.m132paddingqDBjuR0$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), f2, 0.0f, f2, paddingValuesImpl.bottom + f2, 2), (Function0) objRememberedValue8, zBooleanValue);
                        gapComposer3.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306416, 444);
            gapComposer2 = gapComposer;
            if (((UpdateInfo) mutableState3.getValue()) != null) {
                UpdateInfo updateInfo3 = (UpdateInfo) mutableState3.getValue();
                gapComposer2.startReplaceGroup(-995499547);
                zChangedInstance = gapComposer2.changedInstance(context) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changed(snackbarHostState);
                objRememberedValue6 = gapComposer2.rememberedValue();
                if (zChangedInstance) {
                    mutableState4 = mutableState3;
                    BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda4 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                    gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda4);
                    objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda4;
                } else {
                    mutableState4 = mutableState3;
                    BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda5 = new BottomSheetKt$$ExternalSyntheticLambda1(context, coroutineScope, mutableState4, snackbarHostState, 3);
                    gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda5);
                    objRememberedValue6 = bottomSheetKt$$ExternalSyntheticLambda5;
                }
                Function0 function7 = (Function0) objRememberedValue6;
                objM4 = Density.CC.m(-995475816, gapComposer2, false);
                if (objM4 == neverEqualPolicy) {
                    objM4 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState4, 9);
                    gapComposer2.updateRememberedValue(objM4);
                }
                gapComposer2.end(false);
                UpdateDialogKt.UpdateDialog(updateInfo3, function7, (Function0) objM4, gapComposer2, 384);
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
            z3 = z6;
        }
        recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, function1, function2, function3, function4, modifier2, paddingValuesImpl, z3, i, i2, 2);
        }
    }
}
