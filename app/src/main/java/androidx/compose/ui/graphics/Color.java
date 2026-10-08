package androidx.compose.ui.graphics;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Connector;
import androidx.compose.ui.graphics.colorspace.ConnectorKt;
import androidx.compose.ui.graphics.colorspace.Illuminant;
import kotlin.ULong;
import kotlin.UnsignedKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Color {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Black = BrushKt.Color(4278190080L);
    public static final long Blue;
    public static final long Red;
    public static final long Transparent;
    public static final long Unspecified;
    public static final long White;
    public final long value;

    static {
        BrushKt.Color(4282664004L);
        BrushKt.Color(4287137928L);
        BrushKt.Color(4291611852L);
        White = BrushKt.Color(4294967295L);
        Red = BrushKt.Color(4294901760L);
        BrushKt.Color(4278255360L);
        Blue = BrushKt.Color(4278190335L);
        BrushKt.Color(4294967040L);
        BrushKt.Color(4278255615L);
        BrushKt.Color(4294902015L);
        Transparent = BrushKt.Color(0);
        Unspecified = BrushKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.Unspecified);
    }

    public /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: convert-vNxB06k, reason: not valid java name */
    public static final long m433convertvNxB06k(long j, ColorSpace colorSpace) {
        Connector connectorM459createConnectorYBCOT_4;
        ColorSpace colorSpaceM438getColorSpaceimpl = m438getColorSpaceimpl(j);
        int i = colorSpaceM438getColorSpaceimpl.id;
        int i2 = colorSpace.id;
        if ((i | i2) < 0) {
            connectorM459createConnectorYBCOT_4 = Illuminant.m459createConnectorYBCOT_4(colorSpaceM438getColorSpaceimpl, colorSpace);
        } else {
            MutableIntObjectMap mutableIntObjectMap = ConnectorKt.Connectors;
            int i3 = i | (i2 << 6);
            Object objM459createConnectorYBCOT_4 = mutableIntObjectMap.get(i3);
            if (objM459createConnectorYBCOT_4 == null) {
                objM459createConnectorYBCOT_4 = Illuminant.m459createConnectorYBCOT_4(colorSpaceM438getColorSpaceimpl, colorSpace);
                mutableIntObjectMap.set(i3, objM459createConnectorYBCOT_4);
            }
            connectorM459createConnectorYBCOT_4 = (Connector) objM459createConnectorYBCOT_4;
        }
        return connectorM459createConnectorYBCOT_4.mo458transformToColorl2rxGTc$ui_graphics(j);
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m435equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getAlpha-impl, reason: not valid java name */
    public static final float m436getAlphaimpl(long j) {
        float fUlongToDouble;
        float f;
        if ((63 & j) == 0) {
            fUlongToDouble = (float) UnsignedKt.ulongToDouble((j >>> 56) & 255);
            f = 255.0f;
        } else {
            fUlongToDouble = (float) UnsignedKt.ulongToDouble((j >>> 6) & 1023);
            f = 1023.0f;
        }
        return fUlongToDouble / f;
    }

    /* JADX INFO: renamed from: getBlue-impl, reason: not valid java name */
    public static final float m437getBlueimpl(long j) {
        int i;
        int i2;
        int i3;
        if ((63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble((j >>> 32) & 255)) / 255.0f;
        }
        short s = (short) ((j >>> 16) & 65535);
        int i4 = Short.MIN_VALUE & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* JADX INFO: renamed from: getColorSpace-impl, reason: not valid java name */
    public static final ColorSpace m438getColorSpaceimpl(long j) {
        float[] fArr = ColorSpaces.SrgbPrimaries;
        return ColorSpaces.ColorSpacesArray[(int) (j & 63)];
    }

    /* JADX INFO: renamed from: getGreen-impl, reason: not valid java name */
    public static final float m439getGreenimpl(long j) {
        int i;
        int i2;
        int i3;
        if ((63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble((j >>> 40) & 255)) / 255.0f;
        }
        short s = (short) ((j >>> 32) & 65535);
        int i4 = Short.MIN_VALUE & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* JADX INFO: renamed from: getRed-impl, reason: not valid java name */
    public static final float m440getRedimpl(long j) {
        int i;
        int i2;
        int i3;
        if ((63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble((j >>> 48) & 255)) / 255.0f;
        }
        short s = (short) ((j >>> 48) & 65535);
        int i4 = Short.MIN_VALUE & s;
        int i5 = ((65535 & s) >>> 10) & 31;
        int i6 = s & 1023;
        if (i5 != 0) {
            int i7 = i6 << 13;
            if (i5 == 31) {
                i = 255;
                if (i7 != 0) {
                    i7 |= 4194304;
                }
            } else {
                i = i5 + 112;
            }
            int i8 = i;
            i2 = i7;
            i3 = i8;
        } else {
            if (i6 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i6 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i4 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i3 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i3 << 23) | (i4 << 16) | i2);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m441toStringimpl(long j) {
        StringBuilder sb = new StringBuilder("Color(");
        sb.append(m440getRedimpl(j));
        sb.append(", ");
        sb.append(m439getGreenimpl(j));
        sb.append(", ");
        sb.append(m437getBlueimpl(j));
        sb.append(", ");
        sb.append(m436getAlphaimpl(j));
        sb.append(", ");
        return Modifier.CC.m(sb, m438getColorSpaceimpl(j).name, ')');
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Color) {
            return this.value == ((Color) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return ULong.m831hashCodeimpl(this.value);
    }

    public final String toString() {
        return m441toStringimpl(this.value);
    }
}
