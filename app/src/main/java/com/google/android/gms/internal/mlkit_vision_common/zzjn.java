package com.google.android.gms.internal.mlkit_vision_common;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import coil.compose.AsyncImageKt$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.ApkBrokenScreenKt;
import com.github.kr328.clash.compose.MainAppKt;
import com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$2;
import com.github.kr328.clash.design.compose.components.ComposableSingletons$PreferenceScaffoldKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjn {
    /* JADX WARN: Code duplicated, block: B:37:0x0064  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x006d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0097  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:57:0x0103  */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    public static final void PreferenceScaffold(String str, Function0 function0, Modifier modifier, SnackbarHostState snackbarHostState, Function3 function3, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i, int i2) {
        int i3;
        SnackbarHostState snackbarHostState2;
        int i4;
        SnackbarHostState snackbarHostState3;
        Function3 function4;
        Object objRememberedValue;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i5;
        gapComposer.startRestartGroup(-1753507675);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                snackbarHostState2 = snackbarHostState;
                i3 |= gapComposer.changed(snackbarHostState2) ? 2048 : 1024;
            }
            i4 = i3 | 24576;
            if ((196608 & i) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i4 |= i5;
            }
            if ((i4 & 74899) == 74898 || !gapComposer.getSkipping()) {
                if (i6 != 0) {
                    gapComposer.startReplaceGroup(241379128);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new SnackbarHostState();
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    snackbarHostState3 = (SnackbarHostState) objRememberedValue;
                    gapComposer.end(false);
                } else {
                    snackbarHostState3 = snackbarHostState2;
                }
                ComposableLambdaImpl composableLambdaImpl2 = ComposableSingletons$PreferenceScaffoldKt.f30lambda1;
                AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(modifier.then(SizeKt.FillWholeMaxSize), appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1704186263, new MainAppKt$MainApp$2$3$1$1$1$2.AnonymousClass1(appColors, str, function0), gapComposer), null, Thread_jvmKt.rememberComposableLambda(1869861611, new MainAppKt.AnonymousClass2.C00052(snackbarHostState3, 1), gapComposer), null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(-2131465228, new ApkBrokenScreenKt.AnonymousClass1(2, appColors, composableLambdaImpl), gapComposer), gapComposer, 805309488, 436);
                snackbarHostState2 = snackbarHostState3;
                function4 = composableLambdaImpl2;
            } else {
                gapComposer.skipToGroupEnd();
                function4 = function3;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda0(str, function0, modifier, snackbarHostState2, function4, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 3072;
        snackbarHostState2 = snackbarHostState;
        i4 = i3 | 24576;
        if ((196608 & i) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i5 = 131072;
            } else {
                i5 = 65536;
            }
            i4 |= i5;
        }
        if ((i4 & 74899) == 74898) {
            if (i6 != 0) {
                gapComposer.startReplaceGroup(241379128);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new SnackbarHostState();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                snackbarHostState3 = (SnackbarHostState) objRememberedValue;
                gapComposer.end(false);
            } else {
                snackbarHostState3 = snackbarHostState2;
            }
            ComposableLambdaImpl composableLambdaImpl3 = ComposableSingletons$PreferenceScaffoldKt.f30lambda1;
            AppColors appColors2 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(modifier.then(SizeKt.FillWholeMaxSize), appColors2.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1704186263, new MainAppKt$MainApp$2$3$1$1$1$2.AnonymousClass1(appColors2, str, function0), gapComposer), null, Thread_jvmKt.rememberComposableLambda(1869861611, new MainAppKt.AnonymousClass2.C00052(snackbarHostState3, 1), gapComposer), null, 0, appColors2.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(-2131465228, new ApkBrokenScreenKt.AnonymousClass1(2, appColors2, composableLambdaImpl), gapComposer), gapComposer, 805309488, 436);
            snackbarHostState2 = snackbarHostState3;
            function4 = composableLambdaImpl3;
        } else {
            if (i6 != 0) {
                gapComposer.startReplaceGroup(241379128);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new SnackbarHostState();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                snackbarHostState3 = (SnackbarHostState) objRememberedValue;
                gapComposer.end(false);
            } else {
                snackbarHostState3 = snackbarHostState2;
            }
            ComposableLambdaImpl composableLambdaImpl4 = ComposableSingletons$PreferenceScaffoldKt.f30lambda1;
            AppColors appColors3 = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(modifier.then(SizeKt.FillWholeMaxSize), appColors3.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-1704186263, new MainAppKt$MainApp$2$3$1$1$1$2.AnonymousClass1(appColors3, str, function0), gapComposer), null, Thread_jvmKt.rememberComposableLambda(1869861611, new MainAppKt.AnonymousClass2.C00052(snackbarHostState3, 1), gapComposer), null, 0, appColors3.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(-2131465228, new ApkBrokenScreenKt.AnonymousClass1(2, appColors3, composableLambdaImpl), gapComposer), gapComposer, 805309488, 436);
            snackbarHostState2 = snackbarHostState3;
            function4 = composableLambdaImpl4;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda0(str, function0, modifier, snackbarHostState2, function4, composableLambdaImpl, i, i2);
        }
    }
}
