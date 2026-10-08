package androidx.compose.material.icons.outlined;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class FolderKt {
    public static ImageVector _folder;

    public static final ImageVector getFolder() {
        ImageVector imageVector = _folder;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Folder", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(9.17f, 6.0f);
        quirks.lineToRelative(2.0f, 2.0f);
        quirks.horizontalLineTo(20.0f);
        quirks.verticalLineToRelative(10.0f);
        quirks.horizontalLineTo(4.0f);
        quirks.verticalLineTo(6.0f);
        quirks.horizontalLineToRelative(5.17f);
        quirks.moveTo(10.0f, 4.0f);
        quirks.horizontalLineTo(4.0f);
        quirks.curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
        quirks.lineTo(2.0f, 18.0f);
        quirks.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        quirks.horizontalLineToRelative(16.0f);
        quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        quirks.verticalLineTo(8.0f);
        quirks.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        quirks.horizontalLineToRelative(-8.0f);
        quirks.lineToRelative(-2.0f, -2.0f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _folder = imageVectorBuild;
        return imageVectorBuild;
    }
}
