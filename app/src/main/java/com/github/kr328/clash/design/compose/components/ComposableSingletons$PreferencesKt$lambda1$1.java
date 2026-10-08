package com.github.kr328.clash.design.compose.components;

import androidx.camera.core.impl.Quirks;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.rounded.CloseKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: renamed from: com.github.kr328.clash.design.compose.components.ComposableSingletons$PreferencesKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$PreferencesKt$lambda1$1 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public static final ComposableSingletons$PreferencesKt$lambda1$1 INSTANCE$1 = new ComposableSingletons$PreferencesKt$lambda1$1(1);
    public static final ComposableSingletons$PreferencesKt$lambda1$1 INSTANCE = new ComposableSingletons$PreferencesKt$lambda1$1(0);

    public /* synthetic */ ComposableSingletons$PreferencesKt$lambda1$1(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                    gapComposer.skipToGroupEnd();
                } else {
                    IconKt.m249Iconww6aTOc(Encoder.DefaultImpls.getKeyboardArrowRight(), null, null, ((AppColors) gapComposer.consume(AppColorsKt.LocalAppColors)).textSecondary, gapComposer, 48, 4);
                }
                break;
            default:
                GapComposer gapComposer2 = (GapComposer) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ImageVector imageVectorBuild = CloseKt._close;
                    if (imageVectorBuild == null) {
                        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Close", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i = VectorKt.$r8$clinit;
                        SolidColor solidColor = new SolidColor(Color.Black);
                        Quirks quirks = new Quirks();
                        quirks.moveTo(18.3f, 5.71f);
                        quirks.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
                        quirks.lineTo(12.0f, 10.59f);
                        quirks.lineTo(7.11f, 5.7f);
                        quirks.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
                        quirks.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0.0f, 1.41f);
                        quirks.lineTo(10.59f, 12.0f);
                        quirks.lineTo(5.7f, 16.89f);
                        quirks.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0.0f, 1.41f);
                        quirks.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
                        quirks.lineTo(12.0f, 13.41f);
                        quirks.lineToRelative(4.89f, 4.89f);
                        quirks.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
                        quirks.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
                        quirks.lineTo(13.41f, 12.0f);
                        quirks.lineToRelative(4.89f, -4.89f);
                        quirks.curveToRelative(0.38f, -0.38f, 0.38f, -1.02f, 0.0f, -1.4f);
                        quirks.close();
                        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                        imageVectorBuild = builder.build();
                        CloseKt._close = imageVectorBuild;
                    }
                    IconKt.m249Iconww6aTOc(imageVectorBuild, null, SizeKt.m140size3ABfNKs(Modifier.Companion.$$INSTANCE, 18), 0L, gapComposer2, 432, 8);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
