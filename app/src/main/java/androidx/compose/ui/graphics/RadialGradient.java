package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RadialGradient extends ShaderBrush implements Interpolatable {
    public final long center;
    public final ArrayList colors;
    public final float radius;
    public final List stops;
    public final int tileMode;

    public RadialGradient(ArrayList arrayList, List list, long j, float f, int i) {
        this.colors = arrayList;
        this.stops = list;
        this.center = j;
        this.radius = f;
        this.tileMode = i;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public final Shader mo431createShaderuvyYCjk(long j) {
        float fIntBitsToFloat;
        float fIntBitsToFloat2;
        long j2 = this.center;
        if ((9223372034707292159L & j2) == 9205357640488583168L) {
            long jM391getCenteruvyYCjk = SizeKt.m391getCenteruvyYCjk(j);
            fIntBitsToFloat = Float.intBitsToFloat((int) (jM391getCenteruvyYCjk >> 32));
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM391getCenteruvyYCjk & 4294967295L));
        } else {
            int i = (int) (j2 >> 32);
            if (Float.intBitsToFloat(i) == Float.POSITIVE_INFINITY) {
                i = (int) (j >> 32);
            }
            fIntBitsToFloat = Float.intBitsToFloat(i);
            int i2 = (int) (j2 & 4294967295L);
            if (Float.intBitsToFloat(i2) == Float.POSITIVE_INFINITY) {
                i2 = (int) (j & 4294967295L);
            }
            fIntBitsToFloat2 = Float.intBitsToFloat(i2);
        }
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
        float fM386getMinDimensionimpl = this.radius;
        if (fM386getMinDimensionimpl == Float.POSITIVE_INFINITY) {
            fM386getMinDimensionimpl = Size.m386getMinDimensionimpl(j) / 2;
        }
        float f = fM386getMinDimensionimpl;
        ArrayList arrayList = this.colors;
        List list = this.stops;
        BrushKt.validateColorStops(arrayList, list);
        int iCountTransparentColors = BrushKt.countTransparentColors(arrayList);
        return new android.graphics.RadialGradient(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)), f, BrushKt.makeTransparentColors(iCountTransparentColors, arrayList), BrushKt.makeTransparentStops(iCountTransparentColors, list, arrayList), BrushKt.m425toAndroidTileMode0vamqd0(this.tileMode));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        return this.colors.equals(radialGradient.colors) && Intrinsics.areEqual(this.stops, radialGradient.stops) && Offset.m369equalsimpl0(this.center, radialGradient.center) && this.radius == radialGradient.radius && this.tileMode == radialGradient.tileMode;
    }

    public final int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List list = this.stops;
        return ImageAnalysis$$ExternalSyntheticLambda1.m(this.radius, (Offset.m371hashCodeimpl(this.center) + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31)) * 31, 31) + this.tileMode;
    }

    @Override // androidx.compose.ui.graphics.Interpolatable
    public final Object lerp(Object obj, float f) {
        if (obj == null) {
            obj = new SolidColor(Color.Transparent);
        }
        boolean z = obj instanceof SolidColor;
        ArrayList arrayList = this.colors;
        if (z) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Color) arrayList.get(i)).getClass();
                arrayList2.add(new Color(((SolidColor) obj).value));
            }
            obj = new RadialGradient(arrayList2, this.stops, this.center, this.radius, this.tileMode);
        }
        if (!(obj instanceof RadialGradient)) {
            return null;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        return new RadialGradient(BrushKt.lerpColorList(arrayList, radialGradient.colors, f), BrushKt.lerpNullableFloatList(this.stops, radialGradient.stops, f), OffsetKt.m376lerpWko1d7g(this.center, radialGradient.center, f), MathHelpersKt.lerp(this.radius, radialGradient.radius, f), f < 0.5f ? this.tileMode : radialGradient.tileMode);
    }

    public final String toString() {
        String str;
        long j = this.center;
        String str2 = "";
        if ((9223372034707292159L & j) != 9205357640488583168L) {
            str = "center=" + ((Object) Offset.m375toStringimpl(j)) + ", ";
        } else {
            str = "";
        }
        float f = this.radius;
        if ((Float.floatToRawIntBits(f) & Integer.MAX_VALUE) < 2139095040) {
            str2 = "radius=" + f + ", ";
        }
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) BrushKt.m430toStringimpl$1(this.tileMode)) + ')';
    }
}
