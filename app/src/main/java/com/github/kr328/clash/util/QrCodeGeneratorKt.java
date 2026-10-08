package com.github.kr328.clash.util;

import android.graphics.Bitmap;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.navigation.NavOptions;
import coil.ImageLoader$Builder;
import coil.memory.RealWeakMemoryCache;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.ECIEncoderSet;
import com.google.zxing.common.StringUtils;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.GenericGFPoly;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.encoder.BlockPair;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.MaskUtil;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import com.google.zxing.qrcode.encoder.MinimalEncoder$ResultList$ResultNode;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import okhttp3.internal.http2.Huffman;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class QrCodeGeneratorKt {
    /* JADX WARN: Code duplicated, block: B:24:0x0078  */
    /* JADX WARN: Code duplicated, block: B:340:0x0773  */
    /* JADX WARN: Code duplicated, block: B:412:0x0843  */
    /* JADX WARN: Code duplicated, block: B:453:0x08ba  */
    /* JADX WARN: Code duplicated, block: B:616:0x08bc A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v46, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v47 */
    /* JADX WARN: Type inference failed for: r10v49, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v22, types: [com.google.zxing.common.BitArray] */
    /* JADX WARN: Type inference failed for: r1v27, types: [com.google.zxing.common.BitArray] */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.google.zxing.common.BitArray] */
    /* JADX WARN: Type inference failed for: r26v2 */
    public static final Bitmap generateQrBitmap(String str) {
        int i;
        Charset charsetForName;
        int i2;
        int i3;
        Mode mode;
        int i4;
        Version versionForNumber;
        Version version;
        ?? r1;
        CharacterSetECI characterSetECI;
        ?? r2;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        char c;
        GenericGFPoly genericGFPoly;
        GenericGFPoly genericGFPoly2;
        int i9;
        char c2;
        GenericGFPoly genericGFPoly3;
        int i10 = 1;
        EncodeHintType encodeHintType = EncodeHintType.MARGIN;
        Pair pair = new Pair(encodeHintType, 1);
        EncodeHintType encodeHintType2 = EncodeHintType.CHARACTER_SET;
        int i11 = 0;
        Map mapMapOf = MapsKt__MapsKt.mapOf(pair, new Pair(encodeHintType2, "UTF-8"));
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        EncodeHintType encodeHintType3 = EncodeHintType.ERROR_CORRECTION;
        int i12 = 4;
        if (mapMapOf.containsKey(encodeHintType3)) {
            String string = mapMapOf.get(encodeHintType3).toString();
            if (string == null) {
                throw new NullPointerException("Name is null");
            }
            if (string.equals("L")) {
                i = 1;
            } else if (string.equals("M")) {
                i = 2;
            } else if (string.equals("Q")) {
                i = 3;
            } else {
                if (!string.equals("H")) {
                    throw new IllegalArgumentException("No enum constant com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.".concat(string));
                }
                i = 4;
            }
        } else {
            i = 1;
        }
        int i13 = mapMapOf.containsKey(encodeHintType) ? Integer.parseInt(mapMapOf.get(encodeHintType).toString()) : 4;
        Charset charset = Encoder.DEFAULT_BYTE_MODE_ENCODING;
        EncodeHintType encodeHintType4 = EncodeHintType.GS1_FORMAT;
        boolean z5 = mapMapOf.containsKey(encodeHintType4) && Boolean.parseBoolean(mapMapOf.get(encodeHintType4).toString());
        EncodeHintType encodeHintType5 = EncodeHintType.QR_COMPACT;
        boolean z6 = mapMapOf.containsKey(encodeHintType5) && Boolean.parseBoolean(mapMapOf.get(encodeHintType5).toString());
        boolean zContainsKey = mapMapOf.containsKey(encodeHintType2);
        if (zContainsKey) {
            try {
                charsetForName = Charset.forName(mapMapOf.get(encodeHintType2).toString());
            } catch (UnsupportedCharsetException unused) {
                charsetForName = charset;
            }
        } else {
            charsetForName = charset;
        }
        int i14 = 8;
        int i15 = 2;
        if (z6) {
            if (charsetForName.equals(charset)) {
                charsetForName = null;
            }
            MinimalEncoder minimalEncoder = new MinimalEncoder();
            minimalEncoder.stringToEncode = str;
            minimalEncoder.isGS1 = z5;
            minimalEncoder.encoders = new ECIEncoderSet(str, charsetForName);
            minimalEncoder.ecLevel = i;
            int i16 = minimalEncoder.ecLevel;
            Version[] versionArr = {MinimalEncoder.getVersion(1), MinimalEncoder.getVersion(2), MinimalEncoder.getVersion(3)};
            ImageLoader$Builder[] imageLoader$BuilderArr = {minimalEncoder.encodeSpecificVersion(versionArr[0]), minimalEncoder.encodeSpecificVersion(versionArr[1]), minimalEncoder.encodeSpecificVersion(versionArr[2])};
            int i17 = 0;
            int i18 = Integer.MAX_VALUE;
            int i19 = -1;
            for (int i20 = 3; i17 < i20; i20 = 3) {
                ImageLoader$Builder imageLoader$Builder = imageLoader$BuilderArr[i17];
                int i21 = i10;
                int size = imageLoader$Builder.getSize((Version) imageLoader$Builder.defaults);
                if (Encoder.willFit(size, versionArr[i17], i16) && size < i18) {
                    i18 = size;
                    i19 = i17;
                }
                i17++;
                i10 = i21;
            }
            i2 = i10;
            if (i19 < 0) {
                throw new WriterException("Data too big for any version");
            }
            ImageLoader$Builder imageLoader$Builder2 = imageLoader$BuilderArr[i19];
            BitArray bitArray = new BitArray();
            ArrayList arrayList = (ArrayList) imageLoader$Builder2.applicationContext;
            int size2 = arrayList.size();
            int i22 = 0;
            while (i22 < size2) {
                Object obj = arrayList.get(i22);
                i22++;
                MinimalEncoder$ResultList$ResultNode minimalEncoder$ResultList$ResultNode = (MinimalEncoder$ResultList$ResultNode) obj;
                int i23 = minimalEncoder$ResultList$ResultNode.charsetEncoderIndex;
                ImageLoader$Builder imageLoader$Builder3 = minimalEncoder$ResultList$ResultNode.this$1;
                int i24 = i11;
                MinimalEncoder minimalEncoder2 = (MinimalEncoder) imageLoader$Builder3.options;
                Mode mode2 = minimalEncoder$ResultList$ResultNode.mode;
                bitArray.appendBits(mode2.bits, i12);
                int i25 = minimalEncoder$ResultList$ResultNode.characterLength;
                if (i25 > 0) {
                    bitArray.appendBits(minimalEncoder$ResultList$ResultNode.getCharacterCountIndicator(), mode2.getCharacterCountBits((Version) imageLoader$Builder3.defaults));
                }
                if (mode2 == Mode.ECI) {
                    bitArray.appendBits(((CharacterSetECI) CharacterSetECI.NAME_TO_ECI.get(((ECIEncoderSet) minimalEncoder2.encoders).encoders[i23].charset().name())).values[i24], 8);
                } else if (i25 > 0) {
                    String str2 = (String) minimalEncoder2.stringToEncode;
                    int i26 = minimalEncoder$ResultList$ResultNode.fromPosition;
                    Encoder.appendBytes(str2.substring(i26, i25 + i26), mode2, bitArray, ((ECIEncoderSet) minimalEncoder2.encoders).encoders[i23].charset());
                }
                i11 = i24;
                i12 = 4;
            }
            i3 = i11;
            version = (Version) imageLoader$Builder2.defaults;
            r1 = bitArray;
        } else {
            i2 = 1;
            i3 = 0;
            Charset charset2 = StringUtils.SHIFT_JIS_CHARSET;
            Mode mode3 = Mode.BYTE;
            if (charset2 == null || !charset2.equals(charsetForName) || !Encoder.isOnlyDoubleByteKanji(str)) {
                int i27 = 0;
                boolean z7 = false;
                boolean z8 = false;
                while (true) {
                    if (i27 < str.length()) {
                        char cCharAt = str.charAt(i27);
                        if (cCharAt >= '0' && cCharAt <= '9') {
                            z8 = true;
                        } else if ((cCharAt < '`' ? Encoder.ALPHANUMERIC_TABLE[cCharAt] : -1) != -1) {
                            z7 = true;
                        }
                        i27++;
                    } else {
                        if (z7) {
                            mode = Mode.ALPHANUMERIC;
                            break;
                        }
                        if (z8) {
                            mode = Mode.NUMERIC;
                            break;
                        }
                    }
                    mode = mode3;
                    break;
                }
            }
            mode = Mode.KANJI;
            BitArray bitArray2 = new BitArray();
            if (mode == mode3 && zContainsKey && (characterSetECI = (CharacterSetECI) CharacterSetECI.NAME_TO_ECI.get(charsetForName.name())) != null) {
                i4 = 4;
                bitArray2.appendBits(7, 4);
                bitArray2.appendBits(characterSetECI.values[0], 8);
            } else {
                i4 = 4;
            }
            if (z5) {
                bitArray2.appendBits(5, i4);
            }
            bitArray2.appendBits(mode.bits, i4);
            BitArray bitArray3 = new BitArray();
            Encoder.appendBytes(str, mode, bitArray3, charsetForName);
            EncodeHintType encodeHintType6 = EncodeHintType.QR_VERSION;
            if (mapMapOf.containsKey(encodeHintType6)) {
                versionForNumber = Version.getVersionForNumber(Integer.parseInt(mapMapOf.get(encodeHintType6).toString()));
                if (!Encoder.willFit(mode.getCharacterCountBits(versionForNumber) + bitArray2.size + bitArray3.size, versionForNumber, i)) {
                    throw new WriterException("Data too big for requested version");
                }
            } else {
                int characterCountBits = mode.getCharacterCountBits(Version.getVersionForNumber(1)) + bitArray2.size + bitArray3.size;
                int i28 = 1;
                while (true) {
                    if (i28 > 40) {
                        throw new WriterException("Data too big");
                    }
                    Version versionForNumber2 = Version.getVersionForNumber(i28);
                    if (Encoder.willFit(characterCountBits, versionForNumber2, i)) {
                        int characterCountBits2 = mode.getCharacterCountBits(versionForNumber2) + bitArray2.size + bitArray3.size;
                        int i29 = 1;
                        while (true) {
                            if (i29 > 40) {
                                throw new WriterException("Data too big");
                            }
                            Version versionForNumber3 = Version.getVersionForNumber(i29);
                            if (Encoder.willFit(characterCountBits2, versionForNumber3, i)) {
                                versionForNumber = versionForNumber3;
                                break;
                            }
                            i29++;
                            i = i;
                            i14 = 8;
                        }
                    } else {
                        i28++;
                        i = i;
                        i14 = 8;
                    }
                }
            }
            BitArray bitArray4 = new BitArray();
            int i30 = bitArray2.size;
            bitArray4.ensureCapacity(i30);
            for (int i31 = 0; i31 < i30; i31++) {
                bitArray4.appendBit(bitArray2.get(i31));
            }
            int sizeInBytes = mode == mode3 ? bitArray3.getSizeInBytes() : str.length();
            int characterCountBits3 = mode.getCharacterCountBits(versionForNumber);
            int i32 = 1 << characterCountBits3;
            if (sizeInBytes >= i32) {
                StringBuilder sb = new StringBuilder();
                sb.append(sizeInBytes);
                sb.append(" is bigger than ");
                sb.append(i32 - 1);
                throw new WriterException(sb.toString());
            }
            bitArray4.appendBits(sizeInBytes, characterCountBits3);
            int i33 = bitArray3.size;
            bitArray4.ensureCapacity(bitArray4.size + i33);
            for (int i34 = 0; i34 < i33; i34++) {
                bitArray4.appendBit(bitArray3.get(i34));
            }
            version = versionForNumber;
            r1 = bitArray4;
        }
        RealWeakMemoryCache realWeakMemoryCache = version.ecBlocks[CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)];
        int i35 = version.totalCodewords;
        int i36 = realWeakMemoryCache.operationsSinceCleanUp;
        NavOptions.Builder[] builderArr = (NavOptions.Builder[]) realWeakMemoryCache.cache;
        int length = builderArr.length;
        int i37 = i3;
        int i38 = i37;
        while (i37 < length) {
            i38 += builderArr[i37].enterAnim;
            i37++;
        }
        int i39 = i35 - (i38 * i36);
        int i40 = i39 * 8;
        if (r1.size > i40) {
            throw new WriterException("data bits cannot fit in the QR Code" + r1.size + " > " + i40);
        }
        for (int i41 = i3; i41 < 4 && r1.size < i40; i41++) {
            r1.appendBit(i3);
        }
        ?? r10 = i3;
        int i42 = r1.size & 7;
        if (i42 > 0) {
            while (i42 < i14) {
                r1.appendBit(r10);
                i42++;
                r10 = 0;
            }
        }
        int sizeInBytes2 = i39 - r1.getSizeInBytes();
        for (int i43 = 0; i43 < sizeInBytes2; i43++) {
            r1.appendBits((i43 & 1) == 0 ? 236 : 17, i14);
        }
        if (r1.size != i40) {
            throw new WriterException("Bits size does not equal capacity");
        }
        int i44 = 0;
        for (NavOptions.Builder builder : builderArr) {
            i44 += builder.enterAnim;
        }
        if (r1.getSizeInBytes() != i39) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList2 = new ArrayList(i44);
        int i45 = 0;
        int i46 = 0;
        int iMax = 0;
        int iMax2 = 0;
        while (i45 < i44) {
            int i47 = i2;
            int[] iArr = new int[i47];
            int[] iArr2 = new int[i47];
            if (i45 >= i44) {
                r2 = r1;
                throw new WriterException("Block ID too large");
            }
            int i48 = i35 % i44;
            int i49 = i13;
            int i50 = i44 - i48;
            int i51 = i35 / i44;
            int i52 = i39 / i44;
            int i53 = i52 + 1;
            int i54 = i51 - i52;
            int i55 = (i51 + 1) - i53;
            if (i54 != i55) {
                r2 = r1;
                throw new WriterException("EC bytes mismatch");
            }
            if (i44 != i50 + i48) {
                r2 = r1;
                throw new WriterException("RS blocks mismatch");
            }
            if (i35 != ((i53 + i55) * i48) + ((i52 + i54) * i50)) {
                r2 = r1;
                throw new WriterException("Total bytes mismatch");
            }
            if (i45 < i50) {
                c = 0;
                iArr[0] = i52;
                iArr2[0] = i54;
            } else {
                c = 0;
                iArr[0] = i53;
                iArr2[0] = i55;
            }
            int i56 = iArr[c];
            byte[] bArr = new byte[i56];
            int i57 = i46 * 8;
            int i58 = 0;
            while (i58 < i56) {
                int i59 = i45;
                int i60 = i44;
                int i61 = i58;
                int i62 = 0;
                for (int i63 = 0; i63 < 8; i63++) {
                    if (r2.get(i57)) {
                        i62 |= 1 << (7 - i63);
                    }
                    i57++;
                }
                bArr[i61] = (byte) i62;
                i58 = i61 + 1;
                i45 = i59;
                i44 = i60;
            }
            int i64 = i45;
            int i65 = i44;
            int i66 = iArr2[0];
            int i67 = i56 + i66;
            int[] iArr3 = new int[i67];
            int i68 = 0;
            while (i68 < i56) {
                iArr3[i68] = bArr[i68] & 255;
                i68++;
                i67 = i67;
            }
            int i69 = i67;
            GenericGF genericGF = GenericGF.QR_CODE_FIELD_256;
            ArrayList arrayList3 = new ArrayList();
            ?? r26 = r2;
            int i70 = i;
            arrayList3.add(new GenericGFPoly(genericGF, new int[]{1}));
            if (i66 == 0) {
                throw new IllegalArgumentException("No error correction bytes");
            }
            int i71 = i69 - i66;
            if (i71 <= 0) {
                throw new IllegalArgumentException("No data bytes provided");
            }
            Map map = mapMapOf;
            if (i66 >= arrayList3.size()) {
                GenericGFPoly genericGFPoly4 = (GenericGFPoly) arrayList3.get(arrayList3.size() - 1);
                int size3 = arrayList3.size();
                while (size3 <= i66) {
                    int i72 = size3;
                    int i73 = i35;
                    int[] iArr4 = {1, genericGF.expTable[(size3 - 1) + genericGF.generatorBase]};
                    if (iArr4[0] == 0) {
                        i9 = i39;
                        int i74 = i15;
                        int i75 = 1;
                        while (i75 < i74 && iArr4[i75] == 0) {
                            i75++;
                        }
                        if (i75 == i74) {
                            c2 = 0;
                            iArr4 = new int[]{0};
                        } else {
                            c2 = 0;
                            int i76 = 2 - i75;
                            int[] iArr5 = new int[i76];
                            System.arraycopy(iArr4, i75, iArr5, 0, i76);
                            iArr4 = iArr5;
                        }
                    } else {
                        i9 = i39;
                        c2 = 0;
                    }
                    GenericGF genericGF2 = genericGFPoly4.field;
                    if (!genericGF2.equals(genericGF)) {
                        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                    }
                    if (genericGFPoly4.isZero() || iArr4[c2] == 0) {
                        genericGFPoly3 = genericGF2.zero;
                    } else {
                        int[] iArr6 = genericGFPoly4.coefficients;
                        int length2 = iArr6.length;
                        int length3 = iArr4.length;
                        int[] iArr7 = new int[(length2 + length3) - 1];
                        int[] iArr8 = iArr4;
                        int i77 = 0;
                        while (i77 < length2) {
                            int i78 = i77;
                            int i79 = iArr6[i78];
                            int[] iArr9 = iArr6;
                            int i80 = 0;
                            while (i80 < length3) {
                                int i81 = i78 + i80;
                                int i82 = i80;
                                iArr7[i81] = iArr7[i81] ^ genericGF2.multiply(i79, iArr8[i82]);
                                i80 = i82 + 1;
                            }
                            i77 = i78 + 1;
                            iArr6 = iArr9;
                        }
                        genericGFPoly3 = new GenericGFPoly(genericGF2, iArr7);
                    }
                    genericGFPoly4 = genericGFPoly3;
                    arrayList3.add(genericGFPoly4);
                    size3 = i72 + 1;
                    i46 = i46;
                    i35 = i73;
                    i39 = i9;
                    iMax2 = iMax2;
                    i15 = 2;
                }
            }
            int i83 = i35;
            int i84 = i39;
            int i85 = i46;
            int i86 = iMax2;
            GenericGFPoly genericGFPoly5 = (GenericGFPoly) arrayList3.get(i66);
            int[] iArr10 = new int[i71];
            System.arraycopy(iArr3, 0, iArr10, 0, i71);
            if (i71 == 0) {
                throw new IllegalArgumentException();
            }
            if (i71 > 1 && iArr10[0] == 0) {
                int i87 = 1;
                while (i87 < i71 && iArr10[i87] == 0) {
                    i87++;
                }
                if (i87 == i71) {
                    iArr10 = new int[]{0};
                } else {
                    int i88 = i71 - i87;
                    int[] iArr11 = new int[i88];
                    System.arraycopy(iArr10, i87, iArr11, 0, i88);
                    iArr10 = iArr11;
                }
            }
            if (i66 < 0) {
                throw new IllegalArgumentException();
            }
            int length4 = iArr10.length;
            int[] iArr12 = new int[length4 + i66];
            for (int i89 = 0; i89 < length4; i89++) {
                iArr12[i89] = genericGF.multiply(iArr10[i89], 1);
            }
            GenericGFPoly genericGFPoly6 = new GenericGFPoly(genericGF, iArr12);
            GenericGF genericGF3 = genericGFPoly5.field;
            int[] iArr13 = genericGFPoly5.coefficients;
            boolean zEquals = genericGF.equals(genericGF3);
            GenericGFPoly genericGFPoly7 = genericGF.zero;
            if (!zEquals) {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            }
            if (genericGFPoly5.isZero()) {
                throw new IllegalArgumentException("Divide by 0");
            }
            int i90 = iArr13[(iArr13.length - 1) - genericGFPoly5.getDegree()];
            if (i90 == 0) {
                throw new ArithmeticException();
            }
            int i91 = genericGF.expTable[(genericGF.size - genericGF.logTable[i90]) - 1];
            GenericGFPoly genericGFPolyAddOrSubtract = genericGFPoly7;
            while (genericGFPoly6.getDegree() >= genericGFPoly5.getDegree() && !genericGFPoly6.isZero()) {
                int degree = genericGFPoly6.getDegree() - genericGFPoly5.getDegree();
                int degree2 = genericGFPoly6.getDegree();
                int i92 = i71;
                int[] iArr14 = genericGFPoly6.coefficients;
                GenericGFPoly genericGFPoly8 = genericGFPoly7;
                int iMultiply = genericGF.multiply(iArr14[(iArr14.length - 1) - degree2], i91);
                GenericGF genericGF4 = genericGFPoly5.field;
                if (degree < 0) {
                    throw new IllegalArgumentException();
                }
                if (iMultiply == 0) {
                    genericGFPoly = genericGF4.zero;
                } else {
                    int length5 = iArr13.length;
                    int[] iArr15 = new int[length5 + degree];
                    int i93 = 0;
                    while (i93 < length5) {
                        int i94 = i93;
                        iArr15[i94] = genericGF4.multiply(iArr13[i94], iMultiply);
                        i93 = i94 + 1;
                    }
                    genericGFPoly = new GenericGFPoly(genericGF4, iArr15);
                }
                if (degree < 0) {
                    throw new IllegalArgumentException();
                }
                if (iMultiply == 0) {
                    genericGFPoly2 = genericGFPoly8;
                } else {
                    int[] iArr16 = new int[degree + 1];
                    iArr16[0] = iMultiply;
                    genericGFPoly2 = new GenericGFPoly(genericGF, iArr16);
                }
                genericGFPolyAddOrSubtract = genericGFPolyAddOrSubtract.addOrSubtract(genericGFPoly2);
                genericGFPoly6 = genericGFPoly6.addOrSubtract(genericGFPoly);
                i71 = i92;
                genericGFPoly7 = genericGFPoly8;
                genericGFPoly5 = genericGFPoly5;
                i91 = i91;
            }
            int i95 = i71;
            int[] iArr17 = new GenericGFPoly[]{genericGFPolyAddOrSubtract, genericGFPoly6}[1].coefficients;
            int length6 = i66 - iArr17.length;
            for (int i96 = 0; i96 < length6; i96++) {
                iArr3[i95 + i96] = 0;
            }
            System.arraycopy(iArr17, 0, iArr3, i95 + length6, iArr17.length);
            byte[] bArr2 = new byte[i66];
            for (int i97 = 0; i97 < i66; i97++) {
                bArr2[i97] = (byte) iArr3[i56 + i97];
            }
            arrayList2.add(new BlockPair(bArr, bArr2));
            iMax = Math.max(iMax, i56);
            iMax2 = Math.max(i86, i66);
            i46 = i85 + iArr[0];
            i45 = i64 + 1;
            i13 = i49;
            i44 = i65;
            r2 = r26;
            i = i70;
            mapMapOf = map;
            version = version;
            i35 = i83;
            i39 = i84;
            i15 = 2;
            i2 = 1;
        }
        r2 = r1;
        Version version2 = version;
        Map map2 = mapMapOf;
        int i98 = i;
        int i99 = i13;
        int i100 = i35;
        int i101 = iMax2;
        if (i39 != i46) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray5 = new BitArray();
        for (int i102 = 0; i102 < iMax; i102++) {
            int size4 = arrayList2.size();
            int i103 = 0;
            while (i103 < size4) {
                Object obj2 = arrayList2.get(i103);
                i103++;
                byte[] bArr3 = ((BlockPair) obj2).dataBytes;
                if (i102 < bArr3.length) {
                    bitArray5.appendBits(bArr3[i102], 8);
                }
            }
        }
        for (int i104 = 0; i104 < i101; i104++) {
            int size5 = arrayList2.size();
            int i105 = 0;
            while (i105 < size5) {
                Object obj3 = arrayList2.get(i105);
                i105++;
                byte[] bArr4 = ((BlockPair) obj3).errorCorrectionBytes;
                if (i104 < bArr4.length) {
                    bitArray5.appendBits(bArr4[i104], 8);
                }
            }
        }
        if (i100 != bitArray5.getSizeInBytes()) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i100, "Interleaving error: ", " and ");
            sbM.append(bitArray5.getSizeInBytes());
            sbM.append(" differ.");
            throw new WriterException(sbM.toString());
        }
        int i106 = (version2.versionNumber * 4) + 17;
        Huffman.Node node = new Huffman.Node(i106, i106, 4);
        int i107 = node.terminalBitCount;
        EncodeHintType encodeHintType7 = EncodeHintType.QR_MASK_PATTERN;
        if (map2.containsKey(encodeHintType7)) {
            i5 = Integer.parseInt(map2.get(encodeHintType7).toString());
            if (!(i5 >= 0 && i5 < 8)) {
                i5 = -1;
            }
        } else {
            i5 = -1;
        }
        int i108 = node.symbol;
        if (i5 == -1) {
            i5 = -1;
            int i109 = Integer.MAX_VALUE;
            int i110 = 0;
            while (i110 < 8) {
                int i111 = i98;
                MaskUtil.buildMatrix(bitArray5, i111, version2, i110, node);
                int iApplyMaskPenaltyRule1Internal = MaskUtil.applyMaskPenaltyRule1Internal(node, false) + MaskUtil.applyMaskPenaltyRule1Internal(node, true);
                byte[][] bArr5 = (byte[][]) node.children;
                int i112 = 0;
                int i113 = 0;
                while (i112 < i107 - 1) {
                    byte[] bArr6 = bArr5[i112];
                    int i114 = i113;
                    int i115 = 0;
                    while (i115 < i108 - 1) {
                        byte b = bArr6[i115];
                        int i116 = i115 + 1;
                        if (b == bArr6[i116]) {
                            byte[] bArr7 = bArr5[i112 + 1];
                            if (b == bArr7[i115] && b == bArr7[i116]) {
                                i114++;
                            }
                        }
                        i115 = i116;
                    }
                    i112++;
                    i113 = i114;
                }
                int i117 = (i113 * 3) + iApplyMaskPenaltyRule1Internal;
                int i118 = 0;
                int i119 = 0;
                while (i118 < i107) {
                    int i120 = 0;
                    while (i120 < i108) {
                        byte[] bArr8 = bArr5[i118];
                        int i121 = i120 + 6;
                        int i122 = i119;
                        if (i121 < i108) {
                            i6 = i5;
                            byte b2 = 1;
                            if (bArr8[i120] == 1 && bArr8[i120 + 1] == 0 && bArr8[i120 + 2] == 1 && bArr8[i120 + 3] == 1 && bArr8[i120 + 4] == 1 && bArr8[i120 + 5] == 0 && bArr8[i121] == 1) {
                                int i123 = i120 - 4;
                                if (i123 < 0 || bArr8.length < i120) {
                                    z3 = false;
                                    break;
                                }
                                while (true) {
                                    if (i123 >= i120) {
                                        z3 = true;
                                        break;
                                    }
                                    if (bArr8[i123] == b2) {
                                        z3 = false;
                                        break;
                                    }
                                    i123++;
                                    b2 = 1;
                                }
                                if (!z3) {
                                    int i124 = i120 + 7;
                                    int i125 = i120 + 11;
                                    if (i124 < 0 || bArr8.length < i125) {
                                        z4 = false;
                                        break;
                                    }
                                    while (true) {
                                        if (i124 >= i125) {
                                            z4 = true;
                                            break;
                                        }
                                        int i126 = i124;
                                        if (bArr8[i124] == 1) {
                                            z4 = false;
                                            break;
                                        }
                                        i124 = i126 + 1;
                                    }
                                    if (z4) {
                                    }
                                }
                                i119 = i122 + 1;
                            }
                            i7 = i118 + 6;
                            if (i7 < i107) {
                                byte b3 = 1;
                                if (bArr5[i118][i120] != 1 && bArr5[i118 + 1][i120] == 0 && bArr5[i118 + 2][i120] == 1 && bArr5[i118 + 3][i120] == 1 && bArr5[i118 + 4][i120] == 1 && bArr5[i118 + 5][i120] == 0 && bArr5[i7][i120] == 1) {
                                    int i127 = i118 - 4;
                                    if (i127 < 0 || bArr5.length < i118) {
                                        z = false;
                                        break;
                                    }
                                    while (true) {
                                        if (i127 >= i118) {
                                            z = true;
                                            break;
                                        }
                                        if (bArr5[i127][i120] == b3) {
                                            z = false;
                                            break;
                                        }
                                        i127++;
                                        b3 = 1;
                                    }
                                    if (z) {
                                        i8 = i118;
                                    } else {
                                        int i128 = i118 + 7;
                                        int i129 = i118 + 11;
                                        if (i128 < 0 || bArr5.length < i129) {
                                            i8 = i118;
                                        } else {
                                            while (true) {
                                                if (i128 >= i129) {
                                                    i8 = i118;
                                                    z2 = true;
                                                    break;
                                                }
                                                i8 = i118;
                                                if (bArr5[i128][i120] != 1) {
                                                    i128++;
                                                    i118 = i8;
                                                }
                                            }
                                            if (z2) {
                                            }
                                        }
                                        z2 = false;
                                        if (z2) {
                                        }
                                    }
                                    i119++;
                                } else {
                                    i8 = i118;
                                }
                            } else {
                                i8 = i118;
                            }
                            i120++;
                            i5 = i6;
                            i118 = i8;
                        } else {
                            i6 = i5;
                        }
                        i119 = i122;
                        i7 = i118 + 6;
                        if (i7 < i107) {
                            byte b4 = 1;
                            if (bArr5[i118][i120] != 1) {
                                i8 = i118;
                            } else {
                                i8 = i118;
                            }
                        } else {
                            i8 = i118;
                        }
                        i120++;
                        i5 = i6;
                        i118 = i8;
                    }
                    i118++;
                }
                int i130 = i5;
                int i131 = (i119 * 40) + i117;
                int i132 = 0;
                for (int i133 = 0; i133 < i107; i133++) {
                    byte[] bArr9 = bArr5[i133];
                    for (int i134 = 0; i134 < i108; i134++) {
                        if (bArr9[i134] == 1) {
                            i132++;
                        }
                    }
                }
                int i135 = i107 * i108;
                int iAbs = (((Math.abs((i132 * 2) - i135) * 10) / i135) * 10) + i131;
                if (iAbs < i109) {
                    i109 = iAbs;
                    i5 = i110;
                } else {
                    i5 = i130;
                }
                i110++;
                i98 = i111;
            }
        }
        MaskUtil.buildMatrix(bitArray5, i98, version2, i5, node);
        int i136 = i99 * 2;
        int i137 = i108 + i136;
        int i138 = i136 + i107;
        int iMax3 = Math.max(512, i137);
        int iMax4 = Math.max(512, i138);
        int iMin = Math.min(iMax3 / i137, iMax4 / i138);
        int i139 = (iMax3 - (i108 * iMin)) / 2;
        int i140 = (iMax4 - (i107 * iMin)) / 2;
        if (iMax3 < 1 || iMax4 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        int i141 = (iMax3 + 31) / 32;
        int[] iArr18 = new int[i141 * iMax4];
        int i142 = 0;
        while (i142 < i107) {
            int i143 = i139;
            int i144 = 0;
            while (i144 < i108) {
                if (node.get(i144, i142) == 1) {
                    if (i140 < 0 || i143 < 0) {
                        throw new IllegalArgumentException("Left and top must be nonnegative");
                    }
                    if (iMin < 1 || iMin < 1) {
                        throw new IllegalArgumentException("Height and width must be at least 1");
                    }
                    int i145 = i143 + iMin;
                    int i146 = i140 + iMin;
                    if (i146 > iMax4 || i145 > iMax3) {
                        throw new IllegalArgumentException("The region must fit inside the matrix");
                    }
                    int i147 = i140;
                    while (i147 < i146) {
                        int i148 = i147 * i141;
                        int i149 = iMin;
                        for (int i150 = i143; i150 < i145; i150++) {
                            int i151 = (i150 / 32) + i148;
                            iArr18[i151] = iArr18[i151] | (1 << (i150 & 31));
                        }
                        i147++;
                        iMin = i149;
                    }
                }
                int i152 = iMin;
                i144++;
                i143 += i152;
                iMin = i152;
            }
            i142++;
            i140 += iMin;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        for (int i153 = 0; i153 < 512; i153++) {
            for (int i154 = 0; i154 < 512; i154++) {
                bitmapCreateBitmap.setPixel(i153, i154, ((iArr18[(i153 / 32) + (i154 * i141)] >>> (i153 & 31)) & 1) != 0 ? -16777216 : -1);
            }
        }
        return bitmapCreateBitmap;
    }
}
