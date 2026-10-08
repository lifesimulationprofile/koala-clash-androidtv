package androidx.compose.material.icons.filled;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SettingsKt {
    public static ImageVector _settings;

    public static final ImageVector getSettings() {
        ImageVector imageVector = _settings;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Settings", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(19.14f, 12.94f);
        quirks.curveToRelative(0.04f, -0.3f, 0.06f, -0.61f, 0.06f, -0.94f);
        quirks.curveToRelative(0.0f, -0.32f, -0.02f, -0.64f, -0.07f, -0.94f);
        quirks.lineToRelative(2.03f, -1.58f);
        quirks.curveToRelative(0.18f, -0.14f, 0.23f, -0.41f, 0.12f, -0.61f);
        quirks.lineToRelative(-1.92f, -3.32f);
        quirks.curveToRelative(-0.12f, -0.22f, -0.37f, -0.29f, -0.59f, -0.22f);
        quirks.lineToRelative(-2.39f, 0.96f);
        quirks.curveToRelative(-0.5f, -0.38f, -1.03f, -0.7f, -1.62f, -0.94f);
        quirks.lineTo(14.4f, 2.81f);
        quirks.curveToRelative(-0.04f, -0.24f, -0.24f, -0.41f, -0.48f, -0.41f);
        quirks.horizontalLineToRelative(-3.84f);
        quirks.curveToRelative(-0.24f, 0.0f, -0.43f, 0.17f, -0.47f, 0.41f);
        quirks.lineTo(9.25f, 5.35f);
        quirks.curveTo(8.66f, 5.59f, 8.12f, 5.92f, 7.63f, 6.29f);
        quirks.lineTo(5.24f, 5.33f);
        quirks.curveToRelative(-0.22f, -0.08f, -0.47f, 0.0f, -0.59f, 0.22f);
        quirks.lineTo(2.74f, 8.87f);
        quirks.curveTo(2.62f, 9.08f, 2.66f, 9.34f, 2.86f, 9.48f);
        quirks.lineToRelative(2.03f, 1.58f);
        quirks.curveTo(4.84f, 11.36f, 4.8f, 11.69f, 4.8f, 12.0f);
        quirks.reflectiveCurveToRelative(0.02f, 0.64f, 0.07f, 0.94f);
        quirks.lineToRelative(-2.03f, 1.58f);
        quirks.curveToRelative(-0.18f, 0.14f, -0.23f, 0.41f, -0.12f, 0.61f);
        quirks.lineToRelative(1.92f, 3.32f);
        quirks.curveToRelative(0.12f, 0.22f, 0.37f, 0.29f, 0.59f, 0.22f);
        quirks.lineToRelative(2.39f, -0.96f);
        quirks.curveToRelative(0.5f, 0.38f, 1.03f, 0.7f, 1.62f, 0.94f);
        quirks.lineToRelative(0.36f, 2.54f);
        quirks.curveToRelative(0.05f, 0.24f, 0.24f, 0.41f, 0.48f, 0.41f);
        quirks.horizontalLineToRelative(3.84f);
        quirks.curveToRelative(0.24f, 0.0f, 0.44f, -0.17f, 0.47f, -0.41f);
        quirks.lineToRelative(0.36f, -2.54f);
        quirks.curveToRelative(0.59f, -0.24f, 1.13f, -0.56f, 1.62f, -0.94f);
        quirks.lineToRelative(2.39f, 0.96f);
        quirks.curveToRelative(0.22f, 0.08f, 0.47f, 0.0f, 0.59f, -0.22f);
        quirks.lineToRelative(1.92f, -3.32f);
        quirks.curveToRelative(0.12f, -0.22f, 0.07f, -0.47f, -0.12f, -0.61f);
        quirks.lineTo(19.14f, 12.94f);
        quirks.close();
        quirks.moveTo(12.0f, 15.6f);
        quirks.curveToRelative(-1.98f, 0.0f, -3.6f, -1.62f, -3.6f, -3.6f);
        quirks.reflectiveCurveToRelative(1.62f, -3.6f, 3.6f, -3.6f);
        quirks.reflectiveCurveToRelative(3.6f, 1.62f, 3.6f, 3.6f);
        quirks.reflectiveCurveTo(13.98f, 15.6f, 12.0f, 15.6f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _settings = imageVectorBuild;
        return imageVectorBuild;
    }
}
