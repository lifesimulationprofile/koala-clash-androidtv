package androidx.compose.material.icons.outlined;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DescriptionKt {
    public static ImageVector _description;

    public static final ImageVector getDescription() {
        ImageVector imageVector = _description;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Description", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(8.0f, 16.0f);
        quirks.horizontalLineToRelative(8.0f);
        quirks.verticalLineToRelative(2.0f);
        quirks.lineTo(8.0f, 18.0f);
        quirks.close();
        quirks.moveTo(8.0f, 12.0f);
        quirks.horizontalLineToRelative(8.0f);
        quirks.verticalLineToRelative(2.0f);
        quirks.lineTo(8.0f, 14.0f);
        quirks.close();
        quirks.moveTo(14.0f, 2.0f);
        quirks.lineTo(6.0f, 2.0f);
        quirks.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        quirks.verticalLineToRelative(16.0f);
        quirks.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 1.99f, 2.0f);
        quirks.lineTo(18.0f, 22.0f);
        quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        quirks.lineTo(20.0f, 8.0f);
        quirks.lineToRelative(-6.0f, -6.0f);
        quirks.close();
        quirks.moveTo(18.0f, 20.0f);
        quirks.lineTo(6.0f, 20.0f);
        quirks.lineTo(6.0f, 4.0f);
        quirks.horizontalLineToRelative(7.0f);
        quirks.verticalLineToRelative(5.0f);
        quirks.horizontalLineToRelative(5.0f);
        quirks.verticalLineToRelative(11.0f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _description = imageVectorBuild;
        return imageVectorBuild;
    }
}
