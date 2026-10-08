package androidx.compose.material3;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.foundation.shape.DpCornerSize;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Shape;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShapesKt {
    static {
        Stack.staticCompositionLocalOf(new ImageLoader$Builder$$ExternalSyntheticLambda2(2));
    }

    public static final Shape getValue(int i, GapComposer gapComposer) {
        Shapes shapes = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).shapes;
        switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)) {
            case 0:
                return shapes.extraExtraLarge;
            case 1:
                return shapes.extraLarge;
            case 2:
                return shapes.extraLargeIncreased;
            case 3:
                return top$default(shapes.extraLarge);
            case 4:
                return shapes.extraSmall;
            case 5:
                return top$default(shapes.extraSmall);
            case 6:
                return RoundedCornerShapeKt.CircleShape;
            case 7:
                return shapes.large;
            case 8:
                RoundedCornerShape roundedCornerShape = shapes.large;
                DpCornerSize dpCornerSize = ShapeDefaults.CornerNone;
                return RoundedCornerShape.copy$default(roundedCornerShape, dpCornerSize, null, null, dpCornerSize, 6);
            case 9:
                return shapes.largeIncreased;
            case 10:
                RoundedCornerShape roundedCornerShape2 = shapes.large;
                DpCornerSize dpCornerSize2 = ShapeDefaults.CornerNone;
                return RoundedCornerShape.copy$default(roundedCornerShape2, null, dpCornerSize2, dpCornerSize2, null, 9);
            case 11:
                return top$default(shapes.large);
            case 12:
                return shapes.medium;
            case 13:
                return BrushKt.RectangleShape;
            case 14:
                return shapes.small;
            default:
                throw new HttpException();
        }
    }

    public static RoundedCornerShape top$default(RoundedCornerShape roundedCornerShape) {
        DpCornerSize dpCornerSize = ShapeDefaults.CornerNone;
        return RoundedCornerShape.copy$default(roundedCornerShape, null, null, dpCornerSize, dpCornerSize, 3);
    }
}
