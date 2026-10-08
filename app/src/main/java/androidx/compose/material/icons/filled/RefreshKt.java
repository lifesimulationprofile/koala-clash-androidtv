package androidx.compose.material.icons.filled;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RefreshKt {
    public static ImageVector _refresh;

    public static final ImageVector getRefresh() {
        ImageVector imageVector = _refresh;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Refresh", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(17.65f, 6.35f);
        quirks.curveTo(16.2f, 4.9f, 14.21f, 4.0f, 12.0f, 4.0f);
        quirks.curveToRelative(-4.42f, 0.0f, -7.99f, 3.58f, -7.99f, 8.0f);
        quirks.reflectiveCurveToRelative(3.57f, 8.0f, 7.99f, 8.0f);
        quirks.curveToRelative(3.73f, 0.0f, 6.84f, -2.55f, 7.73f, -6.0f);
        quirks.horizontalLineToRelative(-2.08f);
        quirks.curveToRelative(-0.82f, 2.33f, -3.04f, 4.0f, -5.65f, 4.0f);
        quirks.curveToRelative(-3.31f, 0.0f, -6.0f, -2.69f, -6.0f, -6.0f);
        quirks.reflectiveCurveToRelative(2.69f, -6.0f, 6.0f, -6.0f);
        quirks.curveToRelative(1.66f, 0.0f, 3.14f, 0.69f, 4.22f, 1.78f);
        quirks.lineTo(13.0f, 11.0f);
        quirks.horizontalLineToRelative(7.0f);
        quirks.verticalLineTo(4.0f);
        quirks.lineToRelative(-2.35f, 2.35f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _refresh = imageVectorBuild;
        return imageVectorBuild;
    }
}
