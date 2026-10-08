package kotlin.text;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.collections.AbstractList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HexExtensionsKt {
    public static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;
    public static final long[] HEX_DIGITS_TO_LONG_DECIMAL;

    static {
        int[] iArr = new int[256];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = "0123456789abcdef".charAt(i2 & 15) | ("0123456789abcdef".charAt(i2 >> 4) << '\b');
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            iArr2[i3] = "0123456789ABCDEF".charAt(i3 & 15) | ("0123456789ABCDEF".charAt(i3 >> 4) << '\b');
        }
        int[] iArr3 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr3[i4] = -1;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i5)] = i6;
            i5++;
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i7)] = i8;
            i7++;
            i8++;
        }
        long[] jArr = new long[256];
        for (int i9 = 0; i9 < 256; i9++) {
            jArr[i9] = -1;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i10)] = i11;
            i10++;
            i11++;
        }
        int i12 = 0;
        while (i < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i)] = i12;
            i++;
            i12++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    public static final void checkNumberOfDigits(int i, int i2, String str) {
        int i3 = i2 - i;
        if (i3 < 1) {
            throw new NumberFormatException("Expected at least 1 hexadecimal digits at index " + i + ", but was \"" + str.substring(i, i2) + "\" of length " + i3);
        }
        if (i3 > 16) {
            int i4 = (i3 + i) - 16;
            while (i < i4) {
                if (str.charAt(i) != '0') {
                    StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Expected the hexadecimal digit '0' at index ", ", but was '");
                    sbM.append(str.charAt(i));
                    sbM.append("'.\nThe result won't fit the type being parsed.");
                    throw new NumberFormatException(sbM.toString());
                }
                i++;
            }
        }
    }

    public static long hexToLong$default(int i, int i2, String str) {
        HexFormat hexFormat = HexFormat.Default;
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (hexFormat.number.isDigitsOnly) {
            checkNumberOfDigits(i, i2, str);
            return parseLong(i, i2, str);
        }
        if (i2 - i <= 0) {
            throw new NumberFormatException(CaptureSession$State$EnumUnboxingLocalUtility.m("Expected a hexadecimal number with prefix \"\" and suffix \"\", but was ", str.substring(i, i2)));
        }
        checkNumberOfDigits(i, i2, str);
        return parseLong(i, i2, str);
    }

    public static final long parseLong(int i, int i2, String str) {
        long j = 0;
        while (i < i2) {
            long j2 = j << 4;
            char cCharAt = str.charAt(i);
            if ((cCharAt >>> '\b') == 0) {
                long j3 = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
                if (j3 >= 0) {
                    j = j2 | j3;
                    i++;
                }
            }
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Expected a hexadecimal digit at index ", ", but was ");
            sbM.append(str.charAt(i));
            throw new NumberFormatException(sbM.toString());
        }
        return j;
    }
}
