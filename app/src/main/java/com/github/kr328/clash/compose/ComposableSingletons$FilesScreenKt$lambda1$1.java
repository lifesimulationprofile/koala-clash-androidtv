package com.github.kr328.clash.compose;

import androidx.camera.core.impl.Quirks;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.outlined.PhonelinkLockKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.github.kr328.clash.compose.ComposableSingletons$FilesScreenKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$FilesScreenKt$lambda1$1 implements Function2 {
    public static final ComposableSingletons$FilesScreenKt$lambda1$1 INSTANCE = new ComposableSingletons$FilesScreenKt$lambda1$1(0);
    public static final ComposableSingletons$FilesScreenKt$lambda1$1 INSTANCE$1 = new ComposableSingletons$FilesScreenKt$lambda1$1(1);
    public static final ComposableSingletons$FilesScreenKt$lambda1$1 INSTANCE$2 = new ComposableSingletons$FilesScreenKt$lambda1$1(2);
    public static final ComposableSingletons$FilesScreenKt$lambda1$1 INSTANCE$3 = new ComposableSingletons$FilesScreenKt$lambda1$1(3);
    public static final ComposableSingletons$FilesScreenKt$lambda1$1 INSTANCE$4 = new ComposableSingletons$FilesScreenKt$lambda1$1(4);
    public static final ComposableSingletons$FilesScreenKt$lambda1$1 INSTANCE$5 = new ComposableSingletons$FilesScreenKt$lambda1$1(5);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ComposableSingletons$FilesScreenKt$lambda1$1(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        switch (i) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.invalid_file_name, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262138);
                }
                break;
            case 1:
                GapComposer gapComposer2 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ImageVector imageVectorBuild = PhonelinkLockKt._phonelinkLock;
                    if (imageVectorBuild == null) {
                        ImageVector.Builder builder = new ImageVector.Builder("Outlined.PhonelinkLock", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i2 = VectorKt.$r8$clinit;
                        SolidColor solidColor = new SolidColor(Color.Black);
                        Quirks quirks = new Quirks();
                        quirks.moveTo(19.0f, 1.0f);
                        quirks.lineTo(9.0f, 1.0f);
                        quirks.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
                        quirks.verticalLineToRelative(3.0f);
                        quirks.horizontalLineToRelative(2.0f);
                        quirks.lineTo(9.0f, 4.0f);
                        quirks.horizontalLineToRelative(10.0f);
                        quirks.verticalLineToRelative(16.0f);
                        quirks.lineTo(9.0f, 20.0f);
                        quirks.verticalLineToRelative(-2.0f);
                        quirks.lineTo(7.0f, 18.0f);
                        quirks.verticalLineToRelative(3.0f);
                        quirks.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                        quirks.horizontalLineToRelative(10.0f);
                        quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                        quirks.lineTo(21.0f, 3.0f);
                        quirks.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
                        quirks.close();
                        quirks.moveTo(10.8f, 11.0f);
                        quirks.lineTo(10.8f, 9.5f);
                        quirks.curveTo(10.8f, 8.1f, 9.4f, 7.0f, 8.0f, 7.0f);
                        quirks.reflectiveCurveTo(5.2f, 8.1f, 5.2f, 9.5f);
                        quirks.lineTo(5.2f, 11.0f);
                        quirks.curveToRelative(-0.6f, 0.0f, -1.2f, 0.6f, -1.2f, 1.2f);
                        quirks.verticalLineToRelative(3.5f);
                        quirks.curveToRelative(0.0f, 0.7f, 0.6f, 1.3f, 1.2f, 1.3f);
                        quirks.horizontalLineToRelative(5.5f);
                        quirks.curveToRelative(0.7f, 0.0f, 1.3f, -0.6f, 1.3f, -1.2f);
                        quirks.verticalLineToRelative(-3.5f);
                        quirks.curveToRelative(0.0f, -0.7f, -0.6f, -1.3f, -1.2f, -1.3f);
                        quirks.close();
                        quirks.moveTo(9.5f, 11.0f);
                        quirks.horizontalLineToRelative(-3.0f);
                        quirks.lineTo(6.5f, 9.5f);
                        quirks.curveToRelative(0.0f, -0.8f, 0.7f, -1.3f, 1.5f, -1.3f);
                        quirks.reflectiveCurveToRelative(1.5f, 0.5f, 1.5f, 1.3f);
                        quirks.lineTo(9.5f, 11.0f);
                        quirks.close();
                        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                        imageVectorBuild = builder.build();
                        PhonelinkLockKt._phonelinkLock = imageVectorBuild;
                    }
                    IconKt.m249Iconww6aTOc(imageVectorBuild, null, null, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, gapComposer2, 48, 4);
                }
                break;
            case 2:
                GapComposer gapComposer3 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    String strStringResource = StringResources_androidKt.stringResource(R.string.profile_device_limit_title, gapComposer3);
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge;
                    TextKt.m275TextNvy7gAk(strStringResource, SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, null, FontWeight.SemiBold, 0L, new TextAlign(3), 0L, 0, false, 0, 0, textStyle, gapComposer3, 1572912, 0, 129980);
                }
                break;
            case 3:
                GapComposer gapComposer4 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_device_limit_message, gapComposer4), SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer4, 48, 0, 130044);
                }
                break;
            case 4:
                GapComposer gapComposer5 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer5.getSkipping()) {
                    gapComposer5.skipToGroupEnd();
                }
                break;
            default:
                GapComposer gapComposer6 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer6.getSkipping()) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.update_new_version_available, gapComposer6), null, 0L, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 1572864, 0, 262078);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
