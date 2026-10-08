package androidx.compose.material.icons.filled;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class UploadKt {
    public static ImageVector _upload;

    public static final ImageVector getUpload() {
        ImageVector imageVector = _upload;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Upload", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(5.0f, 20.0f);
        quirks.horizontalLineToRelative(14.0f);
        quirks.verticalLineToRelative(-2.0f);
        quirks.horizontalLineTo(5.0f);
        quirks.verticalLineTo(20.0f);
        quirks.close();
        quirks.moveTo(5.0f, 10.0f);
        quirks.horizontalLineToRelative(4.0f);
        quirks.verticalLineToRelative(6.0f);
        quirks.horizontalLineToRelative(6.0f);
        quirks.verticalLineToRelative(-6.0f);
        quirks.horizontalLineToRelative(4.0f);
        quirks.lineToRelative(-7.0f, -7.0f);
        quirks.lineTo(5.0f, 10.0f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _upload = imageVectorBuild;
        return imageVectorBuild;
    }
}
