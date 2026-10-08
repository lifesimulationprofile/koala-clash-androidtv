package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShadowKt {
    /* JADX WARN: Code duplicated, block: B:19:0x0081  */
    public static final Shadow lerpNonNull(Shadow shadow, Shadow shadow2, float f) {
        float fLerp = MathHelpersKt.lerp(shadow.radius, shadow2.radius, f);
        float fLerp2 = MathHelpersKt.lerp(shadow.spread, shadow2.spread, f);
        long j = shadow.offset;
        long j2 = shadow2.offset;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(MathHelpersKt.lerp(DpOffset.m707getXD9Ej5fM(j), DpOffset.m707getXD9Ej5fM(j2), f))) << 32) | (((long) Float.floatToRawIntBits(MathHelpersKt.lerp(DpOffset.m708getYD9Ej5fM(j), DpOffset.m708getYD9Ej5fM(j2), f))) & 4294967295L);
        long jM419lerpjxsXWHM = BrushKt.m419lerpjxsXWHM(shadow.color, shadow2.color, f);
        Object obj = shadow.brush;
        Object obj2 = shadow2.brush;
        if (!Intrinsics.areEqual(obj, obj2)) {
            Object objLerp = obj instanceof Interpolatable ? ((Interpolatable) obj).lerp(obj2, f) : null;
            if (objLerp == null && (obj2 instanceof Interpolatable)) {
                objLerp = ((Interpolatable) obj2).lerp(obj, 1 - f);
            }
            if (objLerp != null) {
                obj = objLerp;
            } else if (f >= 0.5f) {
                obj = obj2;
            }
        } else if (f >= 0.5f) {
            obj = obj2;
        }
        return new Shadow(fLerp, fLerp2, jFloatToRawIntBits, jM419lerpjxsXWHM, obj instanceof Brush ? (Brush) obj : null, MathHelpersKt.lerp(shadow.alpha, shadow2.alpha, f), f < 0.5f ? shadow.blendMode : shadow2.blendMode);
    }
}
