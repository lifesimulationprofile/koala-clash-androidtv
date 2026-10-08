package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Build;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.impl.Quirks;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$copy$1;
import androidx.compose.material.icons.filled.VpnLockKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Density;
import com.github.kr328.clash.compose.FilesScreenKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.settings.NetworkSettingsState;
import com.github.kr328.clash.service.model.AccessControlMode;
import com.google.android.gms.internal.mlkit_vision_common.zzjd;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import com.koala.clash.R;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjd {
    public static final void NetworkSettingsScreen(final NetworkSettingsState networkSettingsState, final Function1 function1, final Function1 function2, final Function1 function3, final Function1 function4, final Function1 function5, final Function1 function6, final Function1 function7, final Function1 function8, final Function0 function0, final Function0 function9, final Function1 function10, final SnackbarHostState snackbarHostState, Modifier modifier, GapComposer gapComposer, final int i) {
        final Modifier modifier2;
        gapComposer.startRestartGroup(-1796961417);
        int i2 = i | (gapComposer.changed(networkSettingsState) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128) | (gapComposer.changedInstance(function3) ? 2048 : 1024) | (gapComposer.changedInstance(function4) ? 16384 : 8192) | (gapComposer.changedInstance(function5) ? 131072 : 65536) | (gapComposer.changedInstance(function6) ? 1048576 : 524288) | (gapComposer.changedInstance(function7) ? 8388608 : 4194304) | (gapComposer.changedInstance(function8) ? 67108864 : 33554432) | (gapComposer.changedInstance(function0) ? 536870912 : 268435456);
        int i3 = 384 | (gapComposer.changedInstance(function9) ? 4 : 2) | (gapComposer.changedInstance(function10) ? 32 : 16) | 3072;
        if ((i2 & 306783379) == 306783378 && (i3 & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            gapComposer.startReplaceGroup(1177397660);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.valueOf(networkSettingsState.enableVpn));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objM = Density.CC.m(1177400359, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.valueOf(networkSettingsState.bypassPrivateNetwork));
                gapComposer.updateRememberedValue(objM);
            }
            final MutableState mutableState2 = (MutableState) objM;
            Object objM2 = Density.CC.m(1177403135, gapComposer, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = Stack.mutableStateOf$default(Boolean.valueOf(networkSettingsState.dnsHijacking));
                gapComposer.updateRememberedValue(objM2);
            }
            final MutableState mutableState3 = (MutableState) objM2;
            Object objM3 = Density.CC.m(1177405630, gapComposer, false);
            if (objM3 == neverEqualPolicy) {
                objM3 = Stack.mutableStateOf$default(Boolean.valueOf(networkSettingsState.allowBypass));
                gapComposer.updateRememberedValue(objM3);
            }
            final MutableState mutableState4 = (MutableState) objM3;
            Object objM4 = Density.CC.m(1177408028, gapComposer, false);
            if (objM4 == neverEqualPolicy) {
                objM4 = Stack.mutableStateOf$default(Boolean.valueOf(networkSettingsState.allowIpv6));
                gapComposer.updateRememberedValue(objM4);
            }
            final MutableState mutableState5 = (MutableState) objM4;
            Object objM5 = Density.CC.m(1177410430, gapComposer, false);
            if (objM5 == neverEqualPolicy) {
                objM5 = Stack.mutableStateOf$default(Boolean.valueOf(networkSettingsState.systemProxy));
                gapComposer.updateRememberedValue(objM5);
            }
            final MutableState mutableState6 = (MutableState) objM5;
            Object objM6 = Density.CC.m(1177412927, gapComposer, false);
            if (objM6 == neverEqualPolicy) {
                objM6 = Stack.mutableStateOf$default(networkSettingsState.tunStackMode);
                gapComposer.updateRememberedValue(objM6);
            }
            final MutableState mutableState7 = (MutableState) objM6;
            Object objM7 = Density.CC.m(1177415620, gapComposer, false);
            if (objM7 == neverEqualPolicy) {
                objM7 = Stack.mutableStateOf$default(networkSettingsState.accessControlMode);
                gapComposer.updateRememberedValue(objM7);
            }
            final MutableState mutableState8 = (MutableState) objM7;
            gapComposer.end(false);
            boolean z = networkSettingsState.clashRunning;
            final boolean z2 = !z;
            final boolean z3 = true;
            if (z || !((Boolean) mutableState.getValue()).booleanValue()) {
                z3 = false;
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            gapComposer.startReplaceGroup(1177422552);
            boolean zChanged = gapComposer.changed(z) | gapComposer.changedInstance(function10);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TextFieldSelectionManager$copy$1(z, function10, null, 2);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, boolValueOf, (Function2) objRememberedValue2);
            final List listListOf = AppCompatHintHelper.listOf("system", "gvisor", "mixed");
            final List listListOf2 = AppCompatHintHelper.listOf(StringResources_androidKt.stringResource(R.string.tun_stack_system, gapComposer), StringResources_androidKt.stringResource(R.string.tun_stack_gvisor, gapComposer), StringResources_androidKt.stringResource(R.string.tun_stack_mixed, gapComposer));
            final List listListOf3 = AppCompatHintHelper.listOf(AccessControlMode.AcceptAll, AccessControlMode.AcceptSelected, AccessControlMode.DenySelected);
            final List listListOf4 = AppCompatHintHelper.listOf(StringResources_androidKt.stringResource(R.string.allow_all_apps, gapComposer), StringResources_androidKt.stringResource(R.string.allow_selected_apps, gapComposer), StringResources_androidKt.stringResource(R.string.deny_selected_apps, gapComposer));
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            zzjn.PreferenceScaffold(StringResources_androidKt.stringResource(R.string.network, gapComposer), function9, companion, snackbarHostState, null, Thread_jvmKt.rememberComposableLambda(1261915466, new Function3() { // from class: com.github.kr328.clash.compose.settings.NetworkSettingsScreenKt$NetworkSettingsScreen$3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        String strStringResource = StringResources_androidKt.stringResource(R.string.route_system_traffic, gapComposer2);
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.routing_via_vpn_service, gapComposer2);
                        ImageVector imageVectorBuild = VpnLockKt._vpnLock;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder = new ImageVector.Builder("Filled.VpnLock", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i4 = VectorKt.$r8$clinit;
                            SolidColor solidColor = new SolidColor(Color.Black);
                            Quirks quirks = new Quirks();
                            quirks.moveTo(22.0f, 4.0f);
                            quirks.verticalLineToRelative(-0.5f);
                            quirks.curveTo(22.0f, 2.12f, 20.88f, 1.0f, 19.5f, 1.0f);
                            quirks.reflectiveCurveTo(17.0f, 2.12f, 17.0f, 3.5f);
                            quirks.lineTo(17.0f, 4.0f);
                            quirks.curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f);
                            quirks.verticalLineToRelative(4.0f);
                            quirks.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                            quirks.horizontalLineToRelative(5.0f);
                            quirks.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                            quirks.lineTo(23.0f, 5.0f);
                            quirks.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                            quirks.close();
                            quirks.moveTo(21.2f, 4.0f);
                            quirks.horizontalLineToRelative(-3.4f);
                            quirks.verticalLineToRelative(-0.5f);
                            quirks.curveToRelative(0.0f, -0.94f, 0.76f, -1.7f, 1.7f, -1.7f);
                            quirks.reflectiveCurveToRelative(1.7f, 0.76f, 1.7f, 1.7f);
                            quirks.lineTo(21.2f, 4.0f);
                            quirks.close();
                            quirks.moveTo(18.92f, 12.0f);
                            quirks.curveToRelative(0.04f, 0.33f, 0.08f, 0.66f, 0.08f, 1.0f);
                            quirks.curveToRelative(0.0f, 2.08f, -0.8f, 3.97f, -2.1f, 5.39f);
                            quirks.curveToRelative(-0.26f, -0.81f, -1.0f, -1.39f, -1.9f, -1.39f);
                            quirks.horizontalLineToRelative(-1.0f);
                            quirks.verticalLineToRelative(-3.0f);
                            quirks.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                            quirks.lineTo(7.0f, 13.0f);
                            quirks.verticalLineToRelative(-2.0f);
                            quirks.horizontalLineToRelative(2.0f);
                            quirks.curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f);
                            quirks.lineTo(10.0f, 8.0f);
                            quirks.horizontalLineToRelative(2.0f);
                            quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                            quirks.lineTo(14.0f, 3.46f);
                            quirks.curveToRelative(-0.95f, -0.3f, -1.95f, -0.46f, -3.0f, -0.46f);
                            quirks.curveTo(5.48f, 3.0f, 1.0f, 7.48f, 1.0f, 13.0f);
                            quirks.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                            quirks.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                            quirks.curveToRelative(0.0f, -0.34f, -0.02f, -0.67f, -0.05f, -1.0f);
                            quirks.horizontalLineToRelative(-2.03f);
                            quirks.close();
                            quirks.moveTo(10.0f, 20.93f);
                            quirks.curveToRelative(-3.95f, -0.49f, -7.0f, -3.85f, -7.0f, -7.93f);
                            quirks.curveToRelative(0.0f, -0.62f, 0.08f, -1.21f, 0.21f, -1.79f);
                            quirks.lineTo(8.0f, 16.0f);
                            quirks.verticalLineToRelative(1.0f);
                            quirks.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                            quirks.verticalLineToRelative(1.93f);
                            quirks.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                            imageVectorBuild = builder.build();
                            VpnLockKt._vpnLock = imageVectorBuild;
                        }
                        ImageVector imageVector = imageVectorBuild;
                        MutableState mutableState9 = mutableState;
                        boolean zBooleanValue = ((Boolean) mutableState9.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(-1612473892);
                        Function1 function11 = function1;
                        boolean zChanged2 = gapComposer2.changed(function11);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zChanged2 || objRememberedValue3 == neverEqualPolicy2) {
                            objRememberedValue3 = new FilesScreenKt$$ExternalSyntheticLambda1(function11, mutableState9, 6);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource, zBooleanValue, (Function1) objRememberedValue3, null, strStringResource2, imageVector, z2, gapComposer2, 0, 8);
                        zzjo.PreferenceCategory(StringResources_androidKt.stringResource(R.string.vpn_service_options, gapComposer2), null, gapComposer2, 0);
                        String strStringResource3 = StringResources_androidKt.stringResource(R.string.bypass_private_network, gapComposer2);
                        String strStringResource4 = StringResources_androidKt.stringResource(R.string.bypass_private_network_summary, gapComposer2);
                        MutableState mutableState10 = mutableState2;
                        boolean zBooleanValue2 = ((Boolean) mutableState10.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(-1612458894);
                        Function1 function12 = function2;
                        boolean zChanged3 = gapComposer2.changed(function12);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChanged3 || objRememberedValue4 == neverEqualPolicy2) {
                            objRememberedValue4 = new FilesScreenKt$$ExternalSyntheticLambda1(function12, mutableState10, 7);
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource3, zBooleanValue2, (Function1) objRememberedValue4, null, strStringResource4, null, z3, gapComposer2, 0, 40);
                        String strStringResource5 = StringResources_androidKt.stringResource(R.string.dns_hijacking, gapComposer2);
                        String strStringResource6 = StringResources_androidKt.stringResource(R.string.dns_hijacking_summary, gapComposer2);
                        MutableState mutableState11 = mutableState3;
                        boolean zBooleanValue3 = ((Boolean) mutableState11.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(-1612446686);
                        Function1 function13 = function3;
                        boolean zChanged4 = gapComposer2.changed(function13);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChanged4 || objRememberedValue5 == neverEqualPolicy2) {
                            objRememberedValue5 = new FilesScreenKt$$ExternalSyntheticLambda1(function13, mutableState11, 8);
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource5, zBooleanValue3, (Function1) objRememberedValue5, null, strStringResource6, null, z3, gapComposer2, 0, 40);
                        String strStringResource7 = StringResources_androidKt.stringResource(R.string.allow_bypass, gapComposer2);
                        String strStringResource8 = StringResources_androidKt.stringResource(R.string.allow_bypass_summary, gapComposer2);
                        MutableState mutableState12 = mutableState4;
                        boolean zBooleanValue4 = ((Boolean) mutableState12.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(-1612435072);
                        Function1 function14 = function4;
                        boolean zChanged5 = gapComposer2.changed(function14);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChanged5 || objRememberedValue6 == neverEqualPolicy2) {
                            objRememberedValue6 = new FilesScreenKt$$ExternalSyntheticLambda1(function14, mutableState12, 9);
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource7, zBooleanValue4, (Function1) objRememberedValue6, null, strStringResource8, null, z3, gapComposer2, 0, 40);
                        String strStringResource9 = StringResources_androidKt.stringResource(R.string.allow_ipv6, gapComposer2);
                        String strStringResource10 = StringResources_androidKt.stringResource(R.string.allow_ipv6_summary, gapComposer2);
                        MutableState mutableState13 = mutableState5;
                        boolean zBooleanValue5 = ((Boolean) mutableState13.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(-1612423716);
                        Function1 function15 = function5;
                        boolean zChanged6 = gapComposer2.changed(function15);
                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                        if (zChanged6 || objRememberedValue7 == neverEqualPolicy2) {
                            objRememberedValue7 = new FilesScreenKt$$ExternalSyntheticLambda1(function15, mutableState13, 10);
                            gapComposer2.updateRememberedValue(objRememberedValue7);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource9, zBooleanValue5, (Function1) objRememberedValue7, null, strStringResource10, null, z3, gapComposer2, 0, 40);
                        gapComposer2.startReplaceGroup(-1612419996);
                        if (Build.VERSION.SDK_INT >= 29) {
                            String strStringResource11 = StringResources_androidKt.stringResource(R.string.system_proxy, gapComposer2);
                            String strStringResource12 = StringResources_androidKt.stringResource(R.string.system_proxy_summary, gapComposer2);
                            MutableState mutableState14 = mutableState6;
                            boolean zBooleanValue6 = ((Boolean) mutableState14.getValue()).booleanValue();
                            gapComposer2.startReplaceGroup(-1612410132);
                            Function1 function16 = function6;
                            boolean zChanged7 = gapComposer2.changed(function16);
                            Object objRememberedValue8 = gapComposer2.rememberedValue();
                            if (zChanged7 || objRememberedValue8 == neverEqualPolicy2) {
                                objRememberedValue8 = new FilesScreenKt$$ExternalSyntheticLambda1(function16, mutableState14, 11);
                                gapComposer2.updateRememberedValue(objRememberedValue8);
                            }
                            gapComposer2.end(false);
                            zzjo.PreferenceSwitch(strStringResource11, zBooleanValue6, (Function1) objRememberedValue8, null, strStringResource12, null, z3, gapComposer2, 0, 40);
                        }
                        gapComposer2.end(false);
                        String strStringResource13 = StringResources_androidKt.stringResource(R.string.tun_stack_mode, gapComposer2);
                        MutableState mutableState15 = mutableState7;
                        String str = (String) mutableState15.getValue();
                        List list = listListOf;
                        int iIndexOf = list.indexOf(str);
                        if (iIndexOf < 0) {
                            iIndexOf = 0;
                        }
                        gapComposer2.startReplaceGroup(-1612395740);
                        Function1 function17 = function7;
                        boolean zChanged8 = gapComposer2.changed(function17);
                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                        if (zChanged8 || objRememberedValue9 == neverEqualPolicy2) {
                            objRememberedValue9 = new FilesScreenKt$FilesScreen$2$$ExternalSyntheticLambda0(list, function17, mutableState15, 2);
                            gapComposer2.updateRememberedValue(objRememberedValue9);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSelectable(strStringResource13, list, listListOf2, iIndexOf, (Function1) objRememberedValue9, null, null, z3, gapComposer2, 48, 96);
                        String strStringResource14 = StringResources_androidKt.stringResource(R.string.access_control_mode, gapComposer2);
                        MutableState mutableState16 = mutableState8;
                        AccessControlMode accessControlMode = (AccessControlMode) mutableState16.getValue();
                        List list2 = listListOf3;
                        int iIndexOf2 = list2.indexOf(accessControlMode);
                        if (iIndexOf2 < 0) {
                            iIndexOf2 = 0;
                        }
                        gapComposer2.startReplaceGroup(-1612379378);
                        Function1 function18 = function8;
                        boolean zChanged9 = gapComposer2.changed(function18);
                        Object objRememberedValue10 = gapComposer2.rememberedValue();
                        if (zChanged9 || objRememberedValue10 == neverEqualPolicy2) {
                            objRememberedValue10 = new FilesScreenKt$FilesScreen$2$$ExternalSyntheticLambda0(list2, function18, mutableState16, 3);
                            gapComposer2.updateRememberedValue(objRememberedValue10);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSelectable(strStringResource14, list2, listListOf4, iIndexOf2, (Function1) objRememberedValue10, null, null, z3, gapComposer2, 48, 96);
                        zzjo.PreferenceClickable(StringResources_androidKt.stringResource(R.string.access_control_packages, gapComposer2), function0, null, StringResources_androidKt.stringResource(R.string.access_control_packages_summary, gapComposer2), null, false, null, gapComposer2, 0, 116);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, ((i3 << 3) & 112) | 200064, 16);
            modifier2 = companion;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(function1, function2, function3, function4, function5, function6, function7, function8, function0, function9, function10, snackbarHostState, modifier2, i) { // from class: com.github.kr328.clash.compose.settings.NetworkSettingsScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ Function1 f$1;
                public final /* synthetic */ Function0 f$10;
                public final /* synthetic */ Function1 f$11;
                public final /* synthetic */ SnackbarHostState f$12;
                public final /* synthetic */ Modifier f$13;
                public final /* synthetic */ Function1 f$2;
                public final /* synthetic */ Function1 f$3;
                public final /* synthetic */ Function1 f$4;
                public final /* synthetic */ Function1 f$5;
                public final /* synthetic */ Function1 f$6;
                public final /* synthetic */ Function1 f$7;
                public final /* synthetic */ Function1 f$8;
                public final /* synthetic */ Function0 f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    zzjd.NetworkSettingsScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
