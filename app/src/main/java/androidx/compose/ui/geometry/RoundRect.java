package androidx.compose.ui.geometry;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RoundRect {
    public final float bottom;
    public final long bottomLeftCornerRadius;
    public final long bottomRightCornerRadius;
    public final float left;
    public final float right;
    public final float top;
    public final long topLeftCornerRadius;
    public final long topRightCornerRadius;

    static {
        RoundRectKt.m383RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    public RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m365equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m365equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m365equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m365equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public final int hashCode() {
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.bottom, ImageAnalysis$$ExternalSyntheticLambda1.m(this.right, ImageAnalysis$$ExternalSyntheticLambda1.m(this.top, Float.floatToIntBits(this.left) * 31, 31), 31), 31);
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        int i = (((int) (j2 ^ (j2 >>> 32))) + ((((int) (j ^ (j >>> 32))) + iM) * 31)) * 31;
        long j3 = this.bottomRightCornerRadius;
        int i2 = (((int) (j3 ^ (j3 >>> 32))) + i) * 31;
        long j4 = this.bottomLeftCornerRadius;
        return ((int) (j4 ^ (j4 >>> 32))) + i2;
    }

    public final String toString() {
        String str = GeometryUtilsKt.toStringAsFixed(this.left) + ", " + GeometryUtilsKt.toStringAsFixed(this.top) + ", " + GeometryUtilsKt.toStringAsFixed(this.right) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom);
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        boolean zM365equalsimpl0 = CornerRadius.m365equalsimpl0(j, j2);
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        if (!zM365equalsimpl0 || !CornerRadius.m365equalsimpl0(j2, j3) || !CornerRadius.m365equalsimpl0(j3, j4)) {
            StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("RoundRect(rect=", str, ", topLeft=");
            sbM16m.append((Object) CornerRadius.m366toStringimpl(j));
            sbM16m.append(", topRight=");
            sbM16m.append((Object) CornerRadius.m366toStringimpl(j2));
            sbM16m.append(", bottomRight=");
            sbM16m.append((Object) CornerRadius.m366toStringimpl(j3));
            sbM16m.append(", bottomLeft=");
            sbM16m.append((Object) CornerRadius.m366toStringimpl(j4));
            sbM16m.append(')');
            return sbM16m.toString();
        }
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i2)) {
            StringBuilder sbM16m2 = ImageAnalysis$$ExternalSyntheticLambda1.m16m("RoundRect(rect=", str, ", radius=");
            sbM16m2.append(GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i)));
            sbM16m2.append(')');
            return sbM16m2.toString();
        }
        StringBuilder sbM16m3 = ImageAnalysis$$ExternalSyntheticLambda1.m16m("RoundRect(rect=", str, ", x=");
        sbM16m3.append(GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i)));
        sbM16m3.append(", y=");
        sbM16m3.append(GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i2)));
        sbM16m3.append(')');
        return sbM16m3.toString();
    }
}
