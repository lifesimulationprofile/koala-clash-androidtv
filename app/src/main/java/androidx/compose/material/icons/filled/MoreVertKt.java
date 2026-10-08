package androidx.compose.material.icons.filled;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class MoreVertKt {
    public static ImageVector _moreVert;

    public static final ImageVector getMoreVert() {
        ImageVector imageVector = _moreVert;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.MoreVert", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(12.0f, 8.0f);
        quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        quirks.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        quirks.reflectiveCurveToRelative(-2.0f, 0.9f, -2.0f, 2.0f);
        quirks.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
        quirks.close();
        quirks.moveTo(12.0f, 10.0f);
        quirks.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        quirks.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
        quirks.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        quirks.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        quirks.close();
        quirks.moveTo(12.0f, 16.0f);
        quirks.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        quirks.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
        quirks.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        quirks.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _moreVert = imageVectorBuild;
        return imageVectorBuild;
    }
}
