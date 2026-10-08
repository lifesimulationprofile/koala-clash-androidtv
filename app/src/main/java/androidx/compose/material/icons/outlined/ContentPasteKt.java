package androidx.compose.material.icons.outlined;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContentPasteKt {
    public static ImageVector _contentPaste;

    public static final ImageVector getContentPaste() {
        ImageVector imageVector = _contentPaste;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.ContentPaste", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(19.0f, 2.0f);
        quirks.horizontalLineToRelative(-4.18f);
        quirks.curveTo(14.4f, 0.84f, 13.3f, 0.0f, 12.0f, 0.0f);
        quirks.reflectiveCurveTo(9.6f, 0.84f, 9.18f, 2.0f);
        quirks.lineTo(5.0f, 2.0f);
        quirks.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        quirks.verticalLineToRelative(16.0f);
        quirks.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        quirks.horizontalLineToRelative(14.0f);
        quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        quirks.lineTo(21.0f, 4.0f);
        quirks.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        quirks.close();
        quirks.moveTo(12.0f, 2.0f);
        quirks.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
        quirks.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        quirks.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
        quirks.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        quirks.close();
        quirks.moveTo(19.0f, 20.0f);
        quirks.lineTo(5.0f, 20.0f);
        quirks.lineTo(5.0f, 4.0f);
        quirks.horizontalLineToRelative(2.0f);
        quirks.verticalLineToRelative(3.0f);
        quirks.horizontalLineToRelative(10.0f);
        quirks.lineTo(17.0f, 4.0f);
        quirks.horizontalLineToRelative(2.0f);
        quirks.verticalLineToRelative(16.0f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _contentPaste = imageVectorBuild;
        return imageVectorBuild;
    }
}
