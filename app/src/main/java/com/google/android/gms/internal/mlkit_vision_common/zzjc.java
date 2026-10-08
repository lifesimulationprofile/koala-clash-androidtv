package com.google.android.gms.internal.mlkit_vision_common;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.impl.Quirks;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$copy$1;
import androidx.compose.material.icons.filled.RestoreKt;
import androidx.compose.material.icons.filled.UpdateKt;
import androidx.compose.material.icons.filled.VisibilityOffKt;
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
import com.github.kr328.clash.compose.settings.AppSettingsState;
import com.github.kr328.clash.design.model.DarkMode;
import com.google.android.gms.internal.mlkit_vision_common.zzjc;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import com.koala.clash.R;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import okhttp3.Handshake;
import okhttp3.internal.HostnamesKt;
import okio.SegmentedByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjc {
    public static final void AppSettingsScreen(final AppSettingsState appSettingsState, final Function1 function1, final Function1 function2, final Function1 function3, final Function1 function4, final Function1 function5, final Function1 function6, final Function0 function0, final Function1 function7, final SnackbarHostState snackbarHostState, Modifier modifier, GapComposer gapComposer, final int i) {
        Modifier modifier2;
        char c;
        final Modifier modifier3;
        gapComposer.startRestartGroup(653420144);
        int i2 = i | (gapComposer.changed(appSettingsState) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128) | (gapComposer.changedInstance(function3) ? 2048 : 1024) | (gapComposer.changedInstance(function4) ? 16384 : 8192) | (gapComposer.changedInstance(function5) ? 131072 : 65536) | (gapComposer.changedInstance(function6) ? 1048576 : 524288) | (gapComposer.changedInstance(function0) ? 8388608 : 4194304) | (gapComposer.changedInstance(function7) ? 67108864 : 33554432);
        if ((i2 & 306783379) == 306783378 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier3 = modifier;
        } else {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                modifier2 = Modifier.Companion.$$INSTANCE;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(1927767377);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.valueOf(appSettingsState.autoRestart));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objM = Density.CC.m(1927769742, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(appSettingsState.darkMode);
                gapComposer.updateRememberedValue(objM);
            }
            final MutableState mutableState2 = (MutableState) objM;
            Object objM2 = Density.CC.m(1927772113, gapComposer, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = Stack.mutableStateOf$default(Boolean.valueOf(appSettingsState.hideAppIcon));
                gapComposer.updateRememberedValue(objM2);
            }
            final MutableState mutableState3 = (MutableState) objM2;
            Object objM3 = Density.CC.m(1927774709, gapComposer, false);
            if (objM3 == neverEqualPolicy) {
                objM3 = Stack.mutableStateOf$default(Boolean.valueOf(appSettingsState.hideFromRecents));
                gapComposer.updateRememberedValue(objM3);
            }
            final MutableState mutableState4 = (MutableState) objM3;
            Object objM4 = Density.CC.m(1927777561, gapComposer, false);
            if (objM4 == neverEqualPolicy) {
                objM4 = Stack.mutableStateOf$default(Boolean.valueOf(appSettingsState.dynamicNotification));
                gapComposer.updateRememberedValue(objM4);
            }
            final MutableState mutableState5 = (MutableState) objM4;
            Object objM5 = Density.CC.m(1927780405, gapComposer, false);
            if (objM5 == neverEqualPolicy) {
                objM5 = Stack.mutableStateOf$default(Boolean.valueOf(appSettingsState.autoCheckUpdate));
                gapComposer.updateRememberedValue(objM5);
            }
            final MutableState mutableState6 = (MutableState) objM5;
            gapComposer.end(false);
            boolean z = !appSettingsState.dynamicNotificationEnabled;
            Boolean boolValueOf = Boolean.valueOf(z);
            gapComposer.startReplaceGroup(1927785164);
            boolean zChanged = gapComposer.changed(z) | gapComposer.changedInstance(function7);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                c = 1;
                objRememberedValue2 = new TextFieldSelectionManager$copy$1(z, function7, null, 1);
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                c = 1;
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, boolValueOf, (Function2) objRememberedValue2);
            DarkMode[] darkModeArr = new DarkMode[3];
            darkModeArr[0] = DarkMode.Auto;
            darkModeArr[c] = DarkMode.ForceLight;
            darkModeArr[2] = DarkMode.ForceDark;
            final List listListOf = AppCompatHintHelper.listOf(darkModeArr);
            final List listListOf2 = AppCompatHintHelper.listOf(StringResources_androidKt.stringResource(R.string.follow_system_android_10, gapComposer), StringResources_androidKt.stringResource(R.string.always_light, gapComposer), StringResources_androidKt.stringResource(R.string.always_dark, gapComposer));
            Modifier modifier4 = modifier2;
            zzjn.PreferenceScaffold(StringResources_androidKt.stringResource(R.string.app, gapComposer), function0, modifier4, snackbarHostState, null, Thread_jvmKt.rememberComposableLambda(-368717821, new Function3() { // from class: com.github.kr328.clash.compose.settings.AppSettingsScreenKt$AppSettingsScreen$4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    char c2;
                    float f;
                    char c3;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        zzjo.PreferenceCategory(StringResources_androidKt.stringResource(R.string.behavior, gapComposer2), null, gapComposer2, 0);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.auto_restart, gapComposer2);
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.allow_clash_auto_restart, gapComposer2);
                        ImageVector imageVectorBuild = RestoreKt._restore;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder = new ImageVector.Builder("Filled.Restore", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i3 = VectorKt.$r8$clinit;
                            SolidColor solidColor = new SolidColor(Color.Black);
                            Quirks quirks = new Quirks();
                            quirks.moveTo(13.0f, 3.0f);
                            quirks.curveToRelative(-4.97f, 0.0f, -9.0f, 4.03f, -9.0f, 9.0f);
                            quirks.lineTo(1.0f, 12.0f);
                            quirks.lineToRelative(3.89f, 3.89f);
                            quirks.lineToRelative(0.07f, 0.14f);
                            quirks.lineTo(9.0f, 12.0f);
                            quirks.lineTo(6.0f, 12.0f);
                            quirks.curveToRelative(0.0f, -3.87f, 3.13f, -7.0f, 7.0f, -7.0f);
                            quirks.reflectiveCurveToRelative(7.0f, 3.13f, 7.0f, 7.0f);
                            quirks.reflectiveCurveToRelative(-3.13f, 7.0f, -7.0f, 7.0f);
                            quirks.curveToRelative(-1.93f, 0.0f, -3.68f, -0.79f, -4.94f, -2.06f);
                            quirks.lineToRelative(-1.42f, 1.42f);
                            quirks.curveTo(8.27f, 19.99f, 10.51f, 21.0f, 13.0f, 21.0f);
                            quirks.curveToRelative(4.97f, 0.0f, 9.0f, -4.03f, 9.0f, -9.0f);
                            quirks.reflectiveCurveToRelative(-4.03f, -9.0f, -9.0f, -9.0f);
                            quirks.close();
                            quirks.moveTo(12.0f, 8.0f);
                            quirks.verticalLineToRelative(5.0f);
                            quirks.lineToRelative(4.28f, 2.54f);
                            quirks.lineToRelative(0.72f, -1.21f);
                            quirks.lineToRelative(-3.5f, -2.08f);
                            quirks.lineTo(13.5f, 8.0f);
                            quirks.lineTo(12.0f, 8.0f);
                            quirks.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                            imageVectorBuild = builder.build();
                            RestoreKt._restore = imageVectorBuild;
                        }
                        MutableState mutableState7 = mutableState;
                        boolean zBooleanValue = ((Boolean) mutableState7.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(-1487553069);
                        Function1 function8 = function1;
                        boolean zChanged2 = gapComposer2.changed(function8);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zChanged2 || objRememberedValue3 == neverEqualPolicy2) {
                            objRememberedValue3 = new FilesScreenKt$$ExternalSyntheticLambda1(function8, mutableState7, 1);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource, zBooleanValue, (Function1) objRememberedValue3, null, strStringResource2, imageVectorBuild, false, gapComposer2, 0, 72);
                        String strStringResource3 = StringResources_androidKt.stringResource(R.string.update_auto_check, gapComposer2);
                        String strStringResource4 = StringResources_androidKt.stringResource(R.string.update_auto_check_desc, gapComposer2);
                        ImageVector imageVectorBuild2 = UpdateKt._update;
                        if (imageVectorBuild2 != null) {
                            c2 = 0;
                        } else {
                            ImageVector.Builder builder2 = new ImageVector.Builder("Filled.Update", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i4 = VectorKt.$r8$clinit;
                            SolidColor solidColor2 = new SolidColor(Color.Black);
                            Quirks quirks2 = new Quirks();
                            quirks2.moveTo(21.0f, 10.12f);
                            quirks2.horizontalLineToRelative(-6.78f);
                            quirks2.lineToRelative(2.74f, -2.82f);
                            quirks2.curveToRelative(-2.73f, -2.7f, -7.15f, -2.8f, -9.88f, -0.1f);
                            quirks2.curveToRelative(-2.73f, 2.71f, -2.73f, 7.08f, 0.0f, 9.79f);
                            quirks2.reflectiveCurveToRelative(7.15f, 2.71f, 9.88f, 0.0f);
                            quirks2.curveTo(18.32f, 15.65f, 19.0f, 14.08f, 19.0f, 12.1f);
                            quirks2.horizontalLineToRelative(2.0f);
                            quirks2.curveToRelative(0.0f, 1.98f, -0.88f, 4.55f, -2.64f, 6.29f);
                            quirks2.curveToRelative(-3.51f, 3.48f, -9.21f, 3.48f, -12.72f, 0.0f);
                            quirks2.curveToRelative(-3.5f, -3.47f, -3.53f, -9.11f, -0.02f, -12.58f);
                            quirks2.reflectiveCurveToRelative(9.14f, -3.47f, 12.65f, 0.0f);
                            quirks2.lineTo(21.0f, 3.0f);
                            quirks2.verticalLineTo(10.12f);
                            quirks2.close();
                            quirks2.moveTo(12.5f, 8.0f);
                            quirks2.verticalLineToRelative(4.25f);
                            quirks2.lineToRelative(3.5f, 2.08f);
                            quirks2.lineToRelative(-0.72f, 1.21f);
                            c2 = 0;
                            quirks2.lineTo(11.0f, 13.0f);
                            quirks2.verticalLineTo(8.0f);
                            quirks2.horizontalLineTo(12.5f);
                            quirks2.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder2, quirks2.mQuirks, solidColor2);
                            imageVectorBuild2 = builder2.build();
                            UpdateKt._update = imageVectorBuild2;
                        }
                        MutableState mutableState8 = mutableState6;
                        boolean zBooleanValue2 = ((Boolean) mutableState8.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(-1487541189);
                        Function1 function9 = function6;
                        boolean zChanged3 = gapComposer2.changed(function9);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChanged3 || objRememberedValue4 == neverEqualPolicy2) {
                            objRememberedValue4 = new FilesScreenKt$$ExternalSyntheticLambda1(function9, mutableState8, 2);
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource3, zBooleanValue2, (Function1) objRememberedValue4, null, strStringResource4, imageVectorBuild2, false, gapComposer2, 0, 72);
                        zzjo.PreferenceCategory(StringResources_androidKt.stringResource(R.string.interface_, gapComposer2), null, gapComposer2, 0);
                        String strStringResource5 = StringResources_androidKt.stringResource(R.string.dark_mode, gapComposer2);
                        ImageVector imageVectorBuild3 = Handshake.Companion._brightness4;
                        if (imageVectorBuild3 == null) {
                            ImageVector.Builder builder3 = new ImageVector.Builder("Filled.Brightness4", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i5 = VectorKt.$r8$clinit;
                            SolidColor solidColor3 = new SolidColor(Color.Black);
                            Quirks quirks3 = new Quirks();
                            quirks3.moveTo(20.0f, 8.69f);
                            quirks3.verticalLineTo(4.0f);
                            quirks3.horizontalLineToRelative(-4.69f);
                            quirks3.lineTo(12.0f, 0.69f);
                            quirks3.lineTo(8.69f, 4.0f);
                            quirks3.horizontalLineTo(4.0f);
                            quirks3.verticalLineToRelative(4.69f);
                            quirks3.lineTo(0.69f, 12.0f);
                            quirks3.lineTo(4.0f, 15.31f);
                            quirks3.verticalLineTo(20.0f);
                            quirks3.horizontalLineToRelative(4.69f);
                            quirks3.lineTo(12.0f, 23.31f);
                            quirks3.lineTo(15.31f, 20.0f);
                            quirks3.horizontalLineTo(20.0f);
                            quirks3.verticalLineToRelative(-4.69f);
                            quirks3.lineTo(23.31f, 12.0f);
                            quirks3.lineTo(20.0f, 8.69f);
                            quirks3.close();
                            quirks3.moveTo(12.0f, 18.0f);
                            quirks3.curveToRelative(-0.89f, 0.0f, -1.74f, -0.2f, -2.5f, -0.55f);
                            quirks3.curveTo(11.56f, 16.5f, 13.0f, 14.42f, 13.0f, 12.0f);
                            quirks3.reflectiveCurveToRelative(-1.44f, -4.5f, -3.5f, -5.45f);
                            quirks3.curveTo(10.26f, 6.2f, 11.11f, 6.0f, 12.0f, 6.0f);
                            quirks3.curveToRelative(3.31f, 0.0f, 6.0f, 2.69f, 6.0f, 6.0f);
                            quirks3.reflectiveCurveToRelative(-2.69f, 6.0f, -6.0f, 6.0f);
                            quirks3.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder3, quirks3.mQuirks, solidColor3);
                            imageVectorBuild3 = builder3.build();
                            Handshake.Companion._brightness4 = imageVectorBuild3;
                        }
                        ImageVector imageVector = imageVectorBuild3;
                        MutableState mutableState9 = mutableState2;
                        DarkMode darkMode = (DarkMode) mutableState9.getValue();
                        List list = listListOf;
                        int iIndexOf = list.indexOf(darkMode);
                        if (iIndexOf < 0) {
                            iIndexOf = 0;
                        }
                        gapComposer2.startReplaceGroup(-1487525585);
                        Function1 function10 = function2;
                        boolean zChanged4 = gapComposer2.changed(function10);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChanged4 || objRememberedValue5 == neverEqualPolicy2) {
                            objRememberedValue5 = new FilesScreenKt$FilesScreen$2$$ExternalSyntheticLambda0(list, function10, mutableState9, 1);
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSelectable(strStringResource5, list, listListOf2, iIndexOf, (Function1) objRememberedValue5, null, imageVector, false, gapComposer2, 48, 160);
                        String strStringResource6 = StringResources_androidKt.stringResource(R.string.hide_app_icon_title, gapComposer2);
                        String strStringResource7 = StringResources_androidKt.stringResource(R.string.hide_app_icon_desc, gapComposer2);
                        ImageVector imageVectorBuild4 = VisibilityOffKt._visibilityOff;
                        if (imageVectorBuild4 != null) {
                            f = 7.0f;
                        } else {
                            ImageVector.Builder builder4 = new ImageVector.Builder("Filled.VisibilityOff", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i6 = VectorKt.$r8$clinit;
                            SolidColor solidColor4 = new SolidColor(Color.Black);
                            Quirks quirks4 = new Quirks();
                            f = 7.0f;
                            quirks4.moveTo(12.0f, 7.0f);
                            quirks4.curveToRelative(2.76f, 0.0f, 5.0f, 2.24f, 5.0f, 5.0f);
                            quirks4.curveToRelative(0.0f, 0.65f, -0.13f, 1.26f, -0.36f, 1.83f);
                            quirks4.lineToRelative(2.92f, 2.92f);
                            quirks4.curveToRelative(1.51f, -1.26f, 2.7f, -2.89f, 3.43f, -4.75f);
                            quirks4.curveToRelative(-1.73f, -4.39f, -6.0f, -7.5f, -11.0f, -7.5f);
                            quirks4.curveToRelative(-1.4f, 0.0f, -2.74f, 0.25f, -3.98f, 0.7f);
                            quirks4.lineToRelative(2.16f, 2.16f);
                            quirks4.curveTo(10.74f, 7.13f, 11.35f, 7.0f, 12.0f, 7.0f);
                            quirks4.close();
                            quirks4.moveTo(2.0f, 4.27f);
                            quirks4.lineToRelative(2.28f, 2.28f);
                            quirks4.lineToRelative(0.46f, 0.46f);
                            quirks4.curveTo(3.08f, 8.3f, 1.78f, 10.02f, 1.0f, 12.0f);
                            quirks4.curveToRelative(1.73f, 4.39f, 6.0f, 7.5f, 11.0f, 7.5f);
                            quirks4.curveToRelative(1.55f, 0.0f, 3.03f, -0.3f, 4.38f, -0.84f);
                            quirks4.lineToRelative(0.42f, 0.42f);
                            quirks4.lineTo(19.73f, 22.0f);
                            quirks4.lineTo(21.0f, 20.73f);
                            quirks4.lineTo(3.27f, 3.0f);
                            quirks4.lineTo(2.0f, 4.27f);
                            quirks4.close();
                            quirks4.moveTo(7.53f, 9.8f);
                            quirks4.lineToRelative(1.55f, 1.55f);
                            quirks4.curveToRelative(-0.05f, 0.21f, -0.08f, 0.43f, -0.08f, 0.65f);
                            quirks4.curveToRelative(0.0f, 1.66f, 1.34f, 3.0f, 3.0f, 3.0f);
                            quirks4.curveToRelative(0.22f, 0.0f, 0.44f, -0.03f, 0.65f, -0.08f);
                            quirks4.lineToRelative(1.55f, 1.55f);
                            quirks4.curveToRelative(-0.67f, 0.33f, -1.41f, 0.53f, -2.2f, 0.53f);
                            quirks4.curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f);
                            quirks4.curveToRelative(0.0f, -0.79f, 0.2f, -1.53f, 0.53f, -2.2f);
                            quirks4.close();
                            quirks4.moveTo(11.84f, 9.02f);
                            quirks4.lineToRelative(3.15f, 3.15f);
                            quirks4.lineToRelative(0.02f, -0.16f);
                            quirks4.curveToRelative(0.0f, -1.66f, -1.34f, -3.0f, -3.0f, -3.0f);
                            quirks4.lineToRelative(-0.17f, 0.01f);
                            quirks4.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder4, quirks4.mQuirks, solidColor4);
                            imageVectorBuild4 = builder4.build();
                            VisibilityOffKt._visibilityOff = imageVectorBuild4;
                        }
                        ImageVector imageVector2 = imageVectorBuild4;
                        MutableState mutableState10 = mutableState3;
                        boolean zBooleanValue3 = ((Boolean) mutableState10.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(-1487511821);
                        Function1 function11 = function3;
                        boolean zChanged5 = gapComposer2.changed(function11);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChanged5 || objRememberedValue6 == neverEqualPolicy2) {
                            objRememberedValue6 = new FilesScreenKt$$ExternalSyntheticLambda1(function11, mutableState10, 3);
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource6, zBooleanValue3, (Function1) objRememberedValue6, null, strStringResource7, imageVector2, false, gapComposer2, 0, 72);
                        String strStringResource8 = StringResources_androidKt.stringResource(R.string.hide_from_recents_title, gapComposer2);
                        String strStringResource9 = StringResources_androidKt.stringResource(R.string.hide_from_recents_desc, gapComposer2);
                        ImageVector imageVectorBuild5 = SegmentedByteString._layers;
                        if (imageVectorBuild5 != null) {
                            c3 = 0;
                        } else {
                            ImageVector.Builder builder5 = new ImageVector.Builder("Filled.Layers", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i7 = VectorKt.$r8$clinit;
                            SolidColor solidColor5 = new SolidColor(Color.Black);
                            Quirks quirks5 = new Quirks();
                            quirks5.moveTo(11.99f, 18.54f);
                            quirks5.lineToRelative(-7.37f, -5.73f);
                            quirks5.lineTo(3.0f, 14.07f);
                            c3 = 0;
                            quirks5.lineToRelative(9.0f, f);
                            quirks5.lineToRelative(9.0f, -7.0f);
                            quirks5.lineToRelative(-1.63f, -1.27f);
                            quirks5.lineToRelative(-7.38f, 5.74f);
                            quirks5.close();
                            quirks5.moveTo(12.0f, 16.0f);
                            quirks5.lineToRelative(7.36f, -5.73f);
                            quirks5.lineTo(21.0f, 9.0f);
                            quirks5.lineToRelative(-9.0f, -7.0f);
                            quirks5.lineToRelative(-9.0f, f);
                            quirks5.lineToRelative(1.63f, 1.27f);
                            quirks5.lineTo(12.0f, 16.0f);
                            quirks5.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder5, quirks5.mQuirks, solidColor5);
                            imageVectorBuild5 = builder5.build();
                            SegmentedByteString._layers = imageVectorBuild5;
                        }
                        MutableState mutableState11 = mutableState4;
                        boolean zBooleanValue4 = ((Boolean) mutableState11.getValue()).booleanValue();
                        gapComposer2.startReplaceGroup(-1487499749);
                        Function1 function12 = function4;
                        boolean zChanged6 = gapComposer2.changed(function12);
                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                        if (zChanged6 || objRememberedValue7 == neverEqualPolicy2) {
                            objRememberedValue7 = new FilesScreenKt$$ExternalSyntheticLambda1(function12, mutableState11, 4);
                            gapComposer2.updateRememberedValue(objRememberedValue7);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource8, zBooleanValue4, (Function1) objRememberedValue7, null, strStringResource9, imageVectorBuild5, false, gapComposer2, 0, 72);
                        zzjo.PreferenceCategory(StringResources_androidKt.stringResource(R.string.service, gapComposer2), null, gapComposer2, 0);
                        String strStringResource10 = StringResources_androidKt.stringResource(R.string.show_traffic, gapComposer2);
                        String strStringResource11 = StringResources_androidKt.stringResource(R.string.show_traffic_summary, gapComposer2);
                        ImageVector imageVectorBuild6 = HostnamesKt._domain;
                        if (imageVectorBuild6 == null) {
                            ImageVector.Builder builder6 = new ImageVector.Builder("Filled.Domain", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i8 = VectorKt.$r8$clinit;
                            SolidColor solidColor6 = new SolidColor(Color.Black);
                            Quirks quirks6 = new Quirks();
                            quirks6.moveTo(12.0f, f);
                            quirks6.verticalLineTo(3.0f);
                            quirks6.horizontalLineTo(2.0f);
                            quirks6.verticalLineToRelative(18.0f);
                            quirks6.horizontalLineToRelative(20.0f);
                            quirks6.verticalLineTo(f);
                            quirks6.horizontalLineTo(12.0f);
                            quirks6.close();
                            quirks6.moveTo(6.0f, 19.0f);
                            quirks6.horizontalLineTo(4.0f);
                            quirks6.verticalLineToRelative(-2.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(19.0f);
                            quirks6.close();
                            quirks6.moveTo(6.0f, 15.0f);
                            quirks6.horizontalLineTo(4.0f);
                            quirks6.verticalLineToRelative(-2.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(15.0f);
                            quirks6.close();
                            quirks6.moveTo(6.0f, 11.0f);
                            quirks6.horizontalLineTo(4.0f);
                            quirks6.verticalLineTo(9.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(11.0f);
                            quirks6.close();
                            quirks6.moveTo(6.0f, f);
                            quirks6.horizontalLineTo(4.0f);
                            quirks6.verticalLineTo(5.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(f);
                            quirks6.close();
                            quirks6.moveTo(10.0f, 19.0f);
                            quirks6.horizontalLineTo(8.0f);
                            quirks6.verticalLineToRelative(-2.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(19.0f);
                            quirks6.close();
                            quirks6.moveTo(10.0f, 15.0f);
                            quirks6.horizontalLineTo(8.0f);
                            quirks6.verticalLineToRelative(-2.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(15.0f);
                            quirks6.close();
                            quirks6.moveTo(10.0f, 11.0f);
                            quirks6.horizontalLineTo(8.0f);
                            quirks6.verticalLineTo(9.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(11.0f);
                            quirks6.close();
                            quirks6.moveTo(10.0f, f);
                            quirks6.horizontalLineTo(8.0f);
                            quirks6.verticalLineTo(5.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(f);
                            quirks6.close();
                            quirks6.moveTo(20.0f, 19.0f);
                            quirks6.horizontalLineToRelative(-8.0f);
                            quirks6.verticalLineToRelative(-2.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineToRelative(-2.0f);
                            quirks6.horizontalLineToRelative(-2.0f);
                            quirks6.verticalLineToRelative(-2.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineToRelative(-2.0f);
                            quirks6.horizontalLineToRelative(-2.0f);
                            quirks6.verticalLineTo(9.0f);
                            quirks6.horizontalLineToRelative(8.0f);
                            quirks6.verticalLineTo(19.0f);
                            quirks6.close();
                            quirks6.moveTo(18.0f, 11.0f);
                            quirks6.horizontalLineToRelative(-2.0f);
                            quirks6.verticalLineToRelative(2.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(11.0f);
                            quirks6.close();
                            quirks6.moveTo(18.0f, 15.0f);
                            quirks6.horizontalLineToRelative(-2.0f);
                            quirks6.verticalLineToRelative(2.0f);
                            quirks6.horizontalLineToRelative(2.0f);
                            quirks6.verticalLineTo(15.0f);
                            quirks6.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder6, quirks6.mQuirks, solidColor6);
                            imageVectorBuild6 = builder6.build();
                            HostnamesKt._domain = imageVectorBuild6;
                        }
                        ImageVector imageVector3 = imageVectorBuild6;
                        MutableState mutableState12 = mutableState5;
                        boolean zBooleanValue5 = ((Boolean) mutableState12.getValue()).booleanValue();
                        boolean z2 = appSettingsState.dynamicNotificationEnabled;
                        gapComposer2.startReplaceGroup(-1487483453);
                        Function1 function13 = function5;
                        boolean zChanged7 = gapComposer2.changed(function13);
                        Object objRememberedValue8 = gapComposer2.rememberedValue();
                        if (zChanged7 || objRememberedValue8 == neverEqualPolicy2) {
                            objRememberedValue8 = new FilesScreenKt$$ExternalSyntheticLambda1(function13, mutableState12, 5);
                            gapComposer2.updateRememberedValue(objRememberedValue8);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceSwitch(strStringResource10, zBooleanValue5, (Function1) objRememberedValue8, null, strStringResource11, imageVector3, z2, gapComposer2, 0, 8);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, ((i2 >> 18) & 112) | 200064, 16);
            modifier3 = modifier4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(function1, function2, function3, function4, function5, function6, function0, function7, snackbarHostState, modifier3, i) { // from class: com.github.kr328.clash.compose.settings.AppSettingsScreenKt$$ExternalSyntheticLambda0
                public final /* synthetic */ Function1 f$1;
                public final /* synthetic */ Modifier f$10;
                public final /* synthetic */ Function1 f$2;
                public final /* synthetic */ Function1 f$3;
                public final /* synthetic */ Function1 f$4;
                public final /* synthetic */ Function1 f$5;
                public final /* synthetic */ Function1 f$6;
                public final /* synthetic */ Function0 f$7;
                public final /* synthetic */ Function1 f$8;
                public final /* synthetic */ SnackbarHostState f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(805306369);
                    zzjc.AppSettingsScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
