package okio;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import java.io.InputStream;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class Okio {
    public static ImageVector _linkOff;

    public static final ImageVector getLinkOff() {
        ImageVector imageVector = _linkOff;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.LinkOff", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(17.0f, 7.0f);
        quirks.horizontalLineToRelative(-4.0f);
        quirks.verticalLineToRelative(1.9f);
        quirks.horizontalLineToRelative(4.0f);
        quirks.curveToRelative(1.71f, 0.0f, 3.1f, 1.39f, 3.1f, 3.1f);
        quirks.curveToRelative(0.0f, 1.43f, -0.98f, 2.63f, -2.31f, 2.98f);
        quirks.lineToRelative(1.46f, 1.46f);
        quirks.curveTo(20.88f, 15.61f, 22.0f, 13.95f, 22.0f, 12.0f);
        quirks.curveToRelative(0.0f, -2.76f, -2.24f, -5.0f, -5.0f, -5.0f);
        quirks.close();
        quirks.moveTo(16.0f, 11.0f);
        quirks.horizontalLineToRelative(-2.19f);
        quirks.lineToRelative(2.0f, 2.0f);
        quirks.lineTo(16.0f, 13.0f);
        quirks.close();
        quirks.moveTo(2.0f, 4.27f);
        quirks.lineToRelative(3.11f, 3.11f);
        quirks.curveTo(3.29f, 8.12f, 2.0f, 9.91f, 2.0f, 12.0f);
        quirks.curveToRelative(0.0f, 2.76f, 2.24f, 5.0f, 5.0f, 5.0f);
        quirks.horizontalLineToRelative(4.0f);
        quirks.verticalLineToRelative(-1.9f);
        quirks.lineTo(7.0f, 15.1f);
        quirks.curveToRelative(-1.71f, 0.0f, -3.1f, -1.39f, -3.1f, -3.1f);
        quirks.curveToRelative(0.0f, -1.59f, 1.21f, -2.9f, 2.76f, -3.07f);
        quirks.lineTo(8.73f, 11.0f);
        quirks.lineTo(8.0f, 11.0f);
        quirks.verticalLineToRelative(2.0f);
        quirks.horizontalLineToRelative(2.73f);
        quirks.lineTo(13.0f, 15.27f);
        quirks.lineTo(13.0f, 17.0f);
        quirks.horizontalLineToRelative(1.73f);
        quirks.lineToRelative(4.01f, 4.0f);
        quirks.lineTo(20.0f, 19.74f);
        quirks.lineTo(3.27f, 3.0f);
        quirks.lineTo(2.0f, 4.27f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _linkOff = imageVectorBuild;
        return imageVectorBuild;
    }

    public static final InputStreamSource source(InputStream inputStream) {
        Logger logger = Okio__JvmOkioKt.logger;
        return new InputStreamSource(0, inputStream, new Timeout());
    }
}
