package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LinearGradient extends ShaderBrush implements Interpolatable {
    public final List colors;
    public final long end;
    public final long start;
    public final List stops;
    public final int tileMode;

    public LinearGradient(List list, List list2, long j, long j2, int i) {
        this.colors = list;
        this.stops = list2;
        this.start = j;
        this.end = j2;
        this.tileMode = i;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public final Shader mo431createShaderuvyYCjk(long j) {
        long j2 = this.start;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (j2 >> 32)) == Float.POSITIVE_INFINITY ? j >> 32 : j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (j2 & 4294967295L)) == Float.POSITIVE_INFINITY ? j & 4294967295L : j2 & 4294967295L));
        long j3 = this.end;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (j3 >> 32)) == Float.POSITIVE_INFINITY ? j >> 32 : j3 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (Float.intBitsToFloat((int) (j3 & 4294967295L)) == Float.POSITIVE_INFINITY ? j & 4294967295L : j3 & 4294967295L));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat4)) & 4294967295L);
        List list = this.colors;
        List list2 = this.stops;
        BrushKt.validateColorStops(list, list2);
        int iCountTransparentColors = BrushKt.countTransparentColors(list);
        return new android.graphics.LinearGradient(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)), Float.intBitsToFloat((int) (jFloatToRawIntBits2 >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits2 & 4294967295L)), BrushKt.makeTransparentColors(iCountTransparentColors, list), BrushKt.makeTransparentStops(iCountTransparentColors, list2, list), BrushKt.m425toAndroidTileMode0vamqd0(this.tileMode));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return this.colors.equals(linearGradient.colors) && Intrinsics.areEqual(this.stops, linearGradient.stops) && Offset.m369equalsimpl0(this.start, linearGradient.start) && Offset.m369equalsimpl0(this.end, linearGradient.end) && this.tileMode == linearGradient.tileMode;
    }

    public final int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List list = this.stops;
        return ((Offset.m371hashCodeimpl(this.end) + ((Offset.m371hashCodeimpl(this.start) + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31)) * 31)) * 31) + this.tileMode;
    }

    @Override // androidx.compose.ui.graphics.Interpolatable
    public final Object lerp(Object obj, float f) {
        if (obj == null) {
            obj = new SolidColor(Color.Transparent);
        }
        boolean z = obj instanceof SolidColor;
        List list = this.colors;
        if (z) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((Color) list.get(i)).getClass();
                arrayList.add(new Color(((SolidColor) obj).value));
            }
            obj = new LinearGradient(arrayList, this.stops, this.start, this.end, this.tileMode);
        }
        if (!(obj instanceof LinearGradient)) {
            return null;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return new LinearGradient(BrushKt.lerpColorList(list, linearGradient.colors, f), BrushKt.lerpNullableFloatList(this.stops, linearGradient.stops, f), BrushKt.m420lerpSafeWko1d7g(this.start, linearGradient.start, f), BrushKt.m420lerpSafeWko1d7g(this.end, linearGradient.end, f), f < 0.5f ? this.tileMode : linearGradient.tileMode);
    }

    public final String toString() {
        String str;
        long j = this.start;
        String str2 = "";
        if (((((j & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0) {
            str = "start=" + ((Object) Offset.m375toStringimpl(j)) + ", ";
        } else {
            str = "";
        }
        long j2 = this.end;
        if (((((j2 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0) {
            str2 = "end=" + ((Object) Offset.m375toStringimpl(j2)) + ", ";
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) BrushKt.m430toStringimpl$1(this.tileMode)) + ')';
    }
}
