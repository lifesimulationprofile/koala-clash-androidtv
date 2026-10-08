package okhttp3.internal.http;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HttpMethod {
    public static ImageVector _edit;

    public static final ImageVector getEdit() {
        ImageVector imageVector = _edit;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Edit", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(3.0f, 17.25f);
        quirks.verticalLineTo(21.0f);
        quirks.horizontalLineToRelative(3.75f);
        quirks.lineTo(17.81f, 9.94f);
        quirks.lineToRelative(-3.75f, -3.75f);
        quirks.lineTo(3.0f, 17.25f);
        quirks.close();
        quirks.moveTo(20.71f, 7.04f);
        quirks.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        quirks.lineToRelative(-2.34f, -2.34f);
        quirks.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
        quirks.lineToRelative(-1.83f, 1.83f);
        quirks.lineToRelative(3.75f, 3.75f);
        quirks.lineToRelative(1.83f, -1.83f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _edit = imageVectorBuild;
        return imageVectorBuild;
    }

    public static final boolean permitsRequestBody(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }
}
