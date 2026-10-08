package androidx.compose.material.icons.outlined;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class InboxKt {
    public static ImageVector _inbox;

    public static final ImageVector getInbox() {
        ImageVector imageVector = _inbox;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Inbox", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Quirks quirks = new Quirks();
        quirks.moveTo(19.0f, 3.0f);
        quirks.lineTo(5.0f, 3.0f);
        quirks.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        quirks.verticalLineToRelative(14.0f);
        quirks.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
        quirks.horizontalLineToRelative(14.0f);
        quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        quirks.lineTo(21.0f, 5.0f);
        quirks.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        quirks.close();
        quirks.moveTo(19.0f, 19.0f);
        quirks.lineTo(5.0f, 19.0f);
        quirks.verticalLineToRelative(-3.0f);
        quirks.horizontalLineToRelative(3.56f);
        quirks.curveToRelative(0.69f, 1.19f, 1.97f, 2.0f, 3.45f, 2.0f);
        quirks.reflectiveCurveToRelative(2.75f, -0.81f, 3.45f, -2.0f);
        quirks.lineTo(19.0f, 16.0f);
        quirks.verticalLineToRelative(3.0f);
        quirks.close();
        quirks.moveTo(19.0f, 14.0f);
        quirks.horizontalLineToRelative(-4.99f);
        quirks.curveToRelative(0.0f, 1.1f, -0.9f, 2.0f, -2.0f, 2.0f);
        quirks.reflectiveCurveToRelative(-2.0f, -0.9f, -2.0f, -2.0f);
        quirks.lineTo(5.0f, 14.0f);
        quirks.lineTo(5.0f, 5.0f);
        quirks.horizontalLineToRelative(14.0f);
        quirks.verticalLineToRelative(9.0f);
        quirks.close();
        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _inbox = imageVectorBuild;
        return imageVectorBuild;
    }
}
