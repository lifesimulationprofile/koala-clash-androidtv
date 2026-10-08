package androidx.compose.foundation.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.graphics.shadow.ShadowKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Unit;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResolvedStyleKt {
    public static final ResolvedStyle EmptyResolvedStyle = new ResolvedStyle();

    static {
        int i = Color.$r8$clinit;
        int i2 = Color.$r8$clinit;
        int i3 = Color.$r8$clinit;
        int i4 = TransformOrigin.$r8$clinit;
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        TextUnitKt.getSp(14);
        TextUnitKt.getSp(0);
        int i5 = Color.$r8$clinit;
        int i6 = FontWeight.Normal.weight;
        Unit unit = Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0046  */
    /* JADX INFO: renamed from: lerp-wffgcV4, reason: not valid java name */
    public static final Brush m164lerpwffgcV4(Brush brush, long j, Brush brush2, long j2, float f) {
        Object obj;
        if (brush != null || brush2 != null) {
            if (brush == null) {
                brush = new SolidColor(j);
            } else if (brush2 == null) {
                brush2 = new SolidColor(j2);
            }
            if (!brush.equals(brush2)) {
                Object objLerp = brush instanceof Interpolatable ? ((Interpolatable) brush).lerp(brush2, f) : null;
                if (objLerp == null && (brush2 instanceof Interpolatable)) {
                    objLerp = ((Interpolatable) brush2).lerp(brush, 1 - f);
                }
                if (objLerp != null) {
                    obj = objLerp;
                } else if (f >= 0.5f) {
                    obj = brush;
                    obj = brush;
                    obj = brush2;
                }
            } else if (f >= 0.5f) {
                obj = brush;
                obj = brush;
                obj = brush2;
            }
            obj = brush;
            obj = brush;
            if (obj instanceof Brush) {
                return (Brush) obj;
            }
        }
        return null;
    }

    public static final Object lerpShadows(float f, Object obj, Object obj2) {
        Shadow shadowLerpNonNull;
        if (obj == null && obj2 == null) {
            return null;
        }
        boolean z = obj instanceof Object[];
        boolean z2 = obj2 instanceof Object[];
        if (!z && !z2) {
            Shadow shadow = obj instanceof Shadow ? (Shadow) obj : null;
            Shadow shadow2 = obj2 instanceof Shadow ? (Shadow) obj2 : null;
            if (shadow == null && shadow2 == null) {
                return null;
            }
            if (shadow == null) {
                return ShadowKt.lerpNonNull(shadow2.transparentCopy$ui_graphics(), shadow2, f);
            }
            return shadow2 == null ? ShadowKt.lerpNonNull(shadow, shadow.transparentCopy$ui_graphics(), f) : ShadowKt.lerpNonNull(shadow, shadow2, f);
        }
        Object[] objArr = z ? (Shadow[]) obj : new Shadow[]{obj};
        Object[] objArr2 = z2 ? (Shadow[]) obj2 : new Shadow[]{obj2};
        int iMax = Math.max(objArr.length, objArr2.length);
        Shadow[] shadowArr = new Shadow[iMax];
        for (int i = 0; i < iMax; i++) {
            shadowArr[i] = null;
        }
        for (int i2 = 0; i2 < iMax; i2++) {
            Shadow shadow3 = (Shadow) ArraysKt.getOrNull(i2, objArr);
            Shadow shadowTransparentCopy$ui_graphics = (Shadow) ArraysKt.getOrNull(i2, objArr2);
            if (shadow3 == null && shadowTransparentCopy$ui_graphics == null) {
                shadowLerpNonNull = null;
            } else if (shadow3 == null) {
                shadowLerpNonNull = ShadowKt.lerpNonNull(shadowTransparentCopy$ui_graphics.transparentCopy$ui_graphics(), shadowTransparentCopy$ui_graphics, f);
            } else {
                if (shadowTransparentCopy$ui_graphics == null) {
                    shadowTransparentCopy$ui_graphics = shadow3.transparentCopy$ui_graphics();
                }
                shadowLerpNonNull = ShadowKt.lerpNonNull(shadow3, shadowTransparentCopy$ui_graphics, f);
            }
            shadowArr[i2] = shadowLerpNonNull;
        }
        return shadowArr;
    }
}
