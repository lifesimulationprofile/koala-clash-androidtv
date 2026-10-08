package com.github.kr328.clash.compose.settings;

import androidx.camera.core.impl.Quirks;
import androidx.compose.material.icons.filled.MoreVertKt;
import androidx.compose.material.icons.filled.SearchKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.encoding.AbstractDecoder;
import okhttp3.MediaType;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsScreenKt$SettingsScreen$3$1 implements Function2 {
    public final /* synthetic */ AppColors $colors;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SettingsScreenKt$SettingsScreen$3$1(AppColors appColors, int i) {
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
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.settings, gapComposer), null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer, 1572864, 0, 131002);
                }
                break;
            case 1:
                GapComposer gapComposer2 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer2), null, appColors.textPrimary, gapComposer2, 0, 4);
                }
                break;
            case 2:
                GapComposer gapComposer3 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    ImageVector imageVectorBuild = SearchKt._search;
                    if (imageVectorBuild == null) {
                        ImageVector.Builder builder = new ImageVector.Builder("Filled.Search", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i2 = VectorKt.$r8$clinit;
                        SolidColor solidColor = new SolidColor(Color.Black);
                        Quirks quirks = new Quirks();
                        quirks.moveTo(15.5f, 14.0f);
                        quirks.horizontalLineToRelative(-0.79f);
                        quirks.lineToRelative(-0.28f, -0.27f);
                        quirks.curveTo(15.41f, 12.59f, 16.0f, 11.11f, 16.0f, 9.5f);
                        quirks.curveTo(16.0f, 5.91f, 13.09f, 3.0f, 9.5f, 3.0f);
                        quirks.reflectiveCurveTo(3.0f, 5.91f, 3.0f, 9.5f);
                        quirks.reflectiveCurveTo(5.91f, 16.0f, 9.5f, 16.0f);
                        quirks.curveToRelative(1.61f, 0.0f, 3.09f, -0.59f, 4.23f, -1.57f);
                        quirks.lineToRelative(0.27f, 0.28f);
                        quirks.verticalLineToRelative(0.79f);
                        quirks.lineToRelative(5.0f, 4.99f);
                        quirks.lineTo(20.49f, 19.0f);
                        quirks.lineToRelative(-4.99f, -5.0f);
                        quirks.close();
                        quirks.moveTo(9.5f, 14.0f);
                        quirks.curveTo(7.01f, 14.0f, 5.0f, 11.99f, 5.0f, 9.5f);
                        quirks.reflectiveCurveTo(7.01f, 5.0f, 9.5f, 5.0f);
                        quirks.reflectiveCurveTo(14.0f, 7.01f, 14.0f, 9.5f);
                        quirks.reflectiveCurveTo(11.99f, 14.0f, 9.5f, 14.0f);
                        quirks.close();
                        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                        imageVectorBuild = builder.build();
                        SearchKt._search = imageVectorBuild;
                    }
                    IconKt.m249Iconww6aTOc(imageVectorBuild, null, null, appColors.textPrimary, gapComposer3, 48, 4);
                }
                break;
            case 3:
                GapComposer gapComposer4 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    IconKt.m249Iconww6aTOc(MoreVertKt.getMoreVert(), null, null, appColors.textPrimary, gapComposer4, 48, 4);
                }
                break;
            case 4:
                GapComposer gapComposer5 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer5.getSkipping()) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    IconKt.m249Iconww6aTOc(MediaType.Companion.getClose(), StringResources_androidKt.stringResource(R.string.close, gapComposer5), null, appColors.textPrimary, gapComposer5, 0, 4);
                }
                break;
            case 5:
                GapComposer gapComposer6 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer6.getSkipping()) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.share_to_tv_title, gapComposer6), null, appColors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262138);
                }
                break;
            case 6:
                GapComposer gapComposer7 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer7.getSkipping()) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), null, null, appColors.textPrimary, gapComposer7, 48, 4);
                }
                break;
            default:
                GapComposer gapComposer8 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer8.getSkipping()) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    IconKt.m249Iconww6aTOc(AbstractDecoder.getArrowBack(), StringResources_androidKt.stringResource(R.string.back, gapComposer8), null, appColors.textPrimary, gapComposer8, 0, 4);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
