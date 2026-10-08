package okhttp3;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RequestBody$Companion$toRequestBody$2 {
    public static ImageVector _delete;

    public static final ImageVector getDelete() {
        ImageVector imageVector = _delete;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Delete", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(6.0f, 19.0f);
        quirks.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        quirks.horizontalLineToRelative(8.0f);
        quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        quirks.verticalLineTo(7.0f);
        quirks.horizontalLineTo(6.0f);
        quirks.verticalLineToRelative(12.0f);
        quirks.close();
        quirks.moveTo(19.0f, 4.0f);
        quirks.horizontalLineToRelative(-3.5f);
        quirks.lineToRelative(-1.0f, -1.0f);
        quirks.horizontalLineToRelative(-5.0f);
        quirks.lineToRelative(-1.0f, 1.0f);
        quirks.horizontalLineTo(5.0f);
        quirks.verticalLineToRelative(2.0f);
        quirks.horizontalLineToRelative(14.0f);
        quirks.verticalLineTo(4.0f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _delete = imageVectorBuild;
        return imageVectorBuild;
    }
}
