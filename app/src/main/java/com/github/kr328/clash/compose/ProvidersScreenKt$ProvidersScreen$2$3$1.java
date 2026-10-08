package com.github.kr328.clash.compose;

import androidx.camera.core.impl.Quirks;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material.icons.filled.SyncKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$3$1;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$3$2;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProvidersScreenKt$ProvidersScreen$2$3$1 implements Function2 {
    public final /* synthetic */ AppColors $colors;
    public final /* synthetic */ boolean $hasRefreshable;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ProvidersScreenKt$ProvidersScreen$2$3$1(boolean z, AppColors appColors, int i) {
        this.$r8$classId = i;
        this.$hasRefreshable = z;
        this.$colors = appColors;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        boolean z = this.$hasRefreshable;
        AppColors appColors = this.$colors;
        switch (i) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                    gapComposer.skipToGroupEnd();
                } else {
                    ImageVector imageVectorBuild = SyncKt._sync;
                    if (imageVectorBuild == null) {
                        ImageVector.Builder builder = new ImageVector.Builder("Filled.Sync", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i2 = VectorKt.$r8$clinit;
                        SolidColor solidColor = new SolidColor(Color.Black);
                        Quirks quirks = new Quirks();
                        quirks.moveTo(12.0f, 4.0f);
                        quirks.lineTo(12.0f, 1.0f);
                        quirks.lineTo(8.0f, 5.0f);
                        quirks.lineToRelative(4.0f, 4.0f);
                        quirks.lineTo(12.0f, 6.0f);
                        quirks.curveToRelative(3.31f, 0.0f, 6.0f, 2.69f, 6.0f, 6.0f);
                        quirks.curveToRelative(0.0f, 1.01f, -0.25f, 1.97f, -0.7f, 2.8f);
                        quirks.lineToRelative(1.46f, 1.46f);
                        quirks.curveTo(19.54f, 15.03f, 20.0f, 13.57f, 20.0f, 12.0f);
                        quirks.curveToRelative(0.0f, -4.42f, -3.58f, -8.0f, -8.0f, -8.0f);
                        quirks.close();
                        quirks.moveTo(12.0f, 18.0f);
                        quirks.curveToRelative(-3.31f, 0.0f, -6.0f, -2.69f, -6.0f, -6.0f);
                        quirks.curveToRelative(0.0f, -1.01f, 0.25f, -1.97f, 0.7f, -2.8f);
                        quirks.lineTo(5.24f, 7.74f);
                        quirks.curveTo(4.46f, 8.97f, 4.0f, 10.43f, 4.0f, 12.0f);
                        quirks.curveToRelative(0.0f, 4.42f, 3.58f, 8.0f, 8.0f, 8.0f);
                        quirks.verticalLineToRelative(3.0f);
                        quirks.lineToRelative(4.0f, -4.0f);
                        quirks.lineToRelative(-4.0f, -4.0f);
                        quirks.verticalLineToRelative(3.0f);
                        quirks.close();
                        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                        imageVectorBuild = builder.build();
                        SyncKt._sync = imageVectorBuild;
                    }
                    IconKt.m249Iconww6aTOc(imageVectorBuild, StringResources_androidKt.stringResource(R.string.update_all, gapComposer), null, z ? appColors.textPrimary : appColors.textSecondary, gapComposer, 0, 4);
                }
                break;
            case 1:
                GapComposer gapComposer2 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                    gapComposer2.skipToGroupEnd();
                } else if (!z) {
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-1702094573, new LogsScreenKt.AnonymousClass6(appColors, 25), gapComposer2);
                    PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                    long j = Color.Transparent;
                    AppBarKt.m238TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda, null, null, null, 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(j, j, 0L, appColors.textPrimary, 0L, gapComposer2, 52), null, gapComposer2, 6, 446);
                }
                break;
            default:
                GapComposer gapComposer3 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                    gapComposer3.skipToGroupEnd();
                } else if (!z) {
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(1959424767, new SettingsScreenKt$SettingsScreen$3$1(appColors, 0), gapComposer3);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Thread_jvmKt.rememberComposableLambda(-789458627, new SettingsScreenKt$SettingsScreen$3$2(), gapComposer3);
                    PaddingValuesImpl paddingValuesImpl2 = TopAppBarDefaults.ContentPadding;
                    long j2 = Color.Transparent;
                    long j3 = appColors.textPrimary;
                    AppBarKt.m238TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda2, null, composableLambdaImplRememberComposableLambda3, null, 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(j2, j2, j3, j3, 0L, gapComposer3, 48), null, gapComposer3, 390, 442);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
