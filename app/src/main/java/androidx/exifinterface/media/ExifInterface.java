package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ExifInterface {
    public static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2;
    public static final int[] BITS_PER_SAMPLE_RGB;
    public static final boolean DEBUG = Log.isLoggable("ExifInterface", 3);
    public static final byte[] EXIF_ASCII_PREFIX;
    public static final ExifTag[] EXIF_POINTER_TAGS;
    public static final ExifTag[][] EXIF_TAGS;
    public static final byte[] HEIF_BRAND_HEIC;
    public static final byte[] HEIF_BRAND_MIF1;
    public static final byte[] HEIF_TYPE_FTYP;
    public static final byte[] IDENTIFIER_EXIF_APP1;
    public static final byte[] IDENTIFIER_XMP_APP1;
    public static final int[] IFD_FORMAT_BYTES_PER_FORMAT;
    public static final String[] IFD_FORMAT_NAMES;
    public static final byte[] JPEG_SIGNATURE;
    public static final byte[] ORF_MAKER_NOTE_HEADER_1;
    public static final byte[] ORF_MAKER_NOTE_HEADER_2;
    public static final byte[] PNG_CHUNK_TYPE_EXIF;
    public static final byte[] PNG_CHUNK_TYPE_IEND;
    public static final byte[] PNG_CHUNK_TYPE_IHDR;
    public static final byte[] PNG_SIGNATURE;
    public static final ExifTag TAG_RAF_IMAGE_SIZE;
    public static final byte[] WEBP_CHUNK_TYPE_EXIF;
    public static final byte[] WEBP_SIGNATURE_1;
    public static final byte[] WEBP_SIGNATURE_2;
    public static final HashMap sExifPointerTagMap;
    public static final HashMap[] sExifTagMapsForReading;
    public static final HashMap[] sExifTagMapsForWriting;
    public static final HashSet sTagSetForCompatibility;
    public boolean mAreThumbnailStripsConsecutive;
    public final AssetManager.AssetInputStream mAssetInputStream;
    public final HashMap[] mAttributes;
    public final HashSet mAttributesOffsets;
    public ByteOrder mExifByteOrder;
    public final String mFilename;
    public int mMimeType;
    public int mOffsetToExifData;
    public int mOrfMakerNoteOffset;
    public int mOrfThumbnailLength;
    public int mOrfThumbnailOffset;
    public final FileDescriptor mSeekableFileDescriptor;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ExifAttribute {
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        public ExifAttribute(byte[] bArr, int i, int i2) {
            this(-1L, bArr, i, i2);
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes = str.concat("\u0000").getBytes(ExifInterface.ASCII);
            return new ExifAttribute(bytes, 2, bytes.length);
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            long[] jArr = {j};
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j2 : jArr) {
                byteBufferWrap.putInt((int) j2);
            }
            return new ExifAttribute(byteBufferWrap.array(), 4, jArr.length);
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length]);
            byteBufferWrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                byteBufferWrap.putInt((int) rational.numerator);
                byteBufferWrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(byteBufferWrap.array(), 5, rationalArr.length);
        }

        public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
            int[] iArr = {i};
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i2 : iArr) {
                byteBufferWrap.putShort((short) i2);
            }
            return new ExifAttribute(byteBufferWrap.array(), 3, iArr.length);
        }

        public final double getDoubleValue(ByteOrder byteOrder) throws Throwable {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (value instanceof String) {
                return Double.parseDouble((String) value);
            }
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(value instanceof Rational[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            Rational[] rationalArr = (Rational[]) value;
            if (rationalArr.length != 1) {
                throw new NumberFormatException("There are more than one component");
            }
            Rational rational = rationalArr[0];
            return rational.numerator / rational.denominator;
        }

        public final int getIntValue(ByteOrder byteOrder) throws Throwable {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (value instanceof String) {
                return Integer.parseInt((String) value);
            }
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(value instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) value;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public final String getStringValue(ByteOrder byteOrder) throws Throwable {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(value instanceof Rational[])) {
                return null;
            }
            Rational[] rationalArr = (Rational[]) value;
            while (i < rationalArr.length) {
                sb.append(rationalArr[i].numerator);
                sb.append('/');
                sb.append(rationalArr[i].denominator);
                i++;
                if (i != rationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Code duplicated, block: B:103:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:17:0x0032 */
        /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r14v19, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r14v23, types: [int[]] */
        /* JADX WARN: Type inference failed for: r14v24, types: [long[]] */
        /* JADX WARN: Type inference failed for: r14v25, types: [androidx.exifinterface.media.ExifInterface$Rational[]] */
        /* JADX WARN: Type inference failed for: r14v26, types: [int[]] */
        /* JADX WARN: Type inference failed for: r14v27, types: [int[]] */
        /* JADX WARN: Type inference failed for: r14v28, types: [androidx.exifinterface.media.ExifInterface$Rational[]] */
        /* JADX WARN: Type inference failed for: r14v29, types: [double[]] */
        /* JADX WARN: Type inference failed for: r14v30, types: [java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r14v31, types: [double[]] */
        public final Serializable getValue(ByteOrder byteOrder) throws Throwable {
            ByteOrderedDataInputStream byteOrderedDataInputStream;
            InputStream inputStream;
            ?? str;
            byte b;
            byte[] bArr = this.bytes;
            InputStream inputStream2 = null;
            try {
                try {
                    byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                    try {
                        byteOrderedDataInputStream.mByteOrder = byteOrder;
                        int i = this.format;
                        int length = 0;
                        int i2 = this.numberOfComponents;
                        switch (i) {
                            case 1:
                            case 6:
                                if (bArr.length == 1 && (b = bArr[0]) >= 0 && b <= 1) {
                                    String str2 = new String(new char[]{(char) (b + 48)});
                                    try {
                                        byteOrderedDataInputStream.close();
                                        return str2;
                                    } catch (IOException e) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                        return str2;
                                    }
                                }
                                str = new String(bArr, ExifInterface.ASCII);
                                break;
                                break;
                            case 2:
                            case 7:
                                if (i2 >= ExifInterface.EXIF_ASCII_PREFIX.length) {
                                    int i3 = 0;
                                    while (true) {
                                        byte[] bArr2 = ExifInterface.EXIF_ASCII_PREFIX;
                                        if (i3 >= bArr2.length) {
                                            length = bArr2.length;
                                        } else if (bArr[i3] == bArr2[i3]) {
                                            i3++;
                                        }
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (length < i2) {
                                    byte b2 = bArr[length];
                                    if (b2 == 0) {
                                        str = sb.toString();
                                    } else {
                                        if (b2 >= 32) {
                                            sb.append((char) b2);
                                        } else {
                                            sb.append('?');
                                        }
                                        length++;
                                    }
                                    break;
                                }
                                str = sb.toString();
                                break;
                            case 3:
                                str = new int[i2];
                                while (length < i2) {
                                    str[length] = byteOrderedDataInputStream.readUnsignedShort();
                                    length++;
                                }
                                break;
                            case 4:
                                str = new long[i2];
                                while (length < i2) {
                                    str[length] = ((long) byteOrderedDataInputStream.readInt()) & 4294967295L;
                                    length++;
                                }
                                break;
                            case 5:
                                str = new Rational[i2];
                                while (length < i2) {
                                    str[length] = new Rational(((long) byteOrderedDataInputStream.readInt()) & 4294967295L, ((long) byteOrderedDataInputStream.readInt()) & 4294967295L);
                                    length++;
                                }
                                break;
                            case 8:
                                str = new int[i2];
                                while (length < i2) {
                                    str[length] = byteOrderedDataInputStream.readShort();
                                    length++;
                                }
                                break;
                            case 9:
                                str = new int[i2];
                                while (length < i2) {
                                    str[length] = byteOrderedDataInputStream.readInt();
                                    length++;
                                }
                                break;
                            case 10:
                                str = new Rational[i2];
                                while (length < i2) {
                                    str[length] = new Rational(byteOrderedDataInputStream.readInt(), byteOrderedDataInputStream.readInt());
                                    length++;
                                }
                                break;
                            case 11:
                                str = new double[i2];
                                while (length < i2) {
                                    str[length] = byteOrderedDataInputStream.readFloat();
                                    length++;
                                }
                                break;
                            case 12:
                                str = new double[i2];
                                while (length < i2) {
                                    str[length] = byteOrderedDataInputStream.readDouble();
                                    length++;
                                }
                                break;
                            default:
                                try {
                                    byteOrderedDataInputStream.close();
                                    return null;
                                } catch (IOException e2) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                    return null;
                                }
                        }
                        try {
                            byteOrderedDataInputStream.close();
                            return str;
                        } catch (IOException e3) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                            return str;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (byteOrderedDataInputStream != null) {
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e5) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e6) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                byteOrderedDataInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("(");
            sb.append(ExifInterface.IFD_FORMAT_NAMES[this.format]);
            sb.append(", data length:");
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.bytes.length, ")");
        }

        public ExifAttribute(long j, byte[] bArr, int i, int i2) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytesOffset = j;
            this.bytes = bArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Rational {
        public final long denominator;
        public final long numerator;

        public Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
            } else {
                this.numerator = j;
                this.denominator = j2;
            }
        }

        public final String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        BITS_PER_SAMPLE_RGB = new int[]{8, 8, 8};
        BITS_PER_SAMPLE_GREYSCALE_2 = new int[]{8};
        JPEG_SIGNATURE = new byte[]{-1, -40, -1};
        HEIF_TYPE_FTYP = new byte[]{102, 116, 121, 112};
        HEIF_BRAND_MIF1 = new byte[]{109, 105, 102, 49};
        HEIF_BRAND_HEIC = new byte[]{104, 101, 105, 99};
        ORF_MAKER_NOTE_HEADER_1 = new byte[]{79, 76, 89, 77, 80, 0};
        ORF_MAKER_NOTE_HEADER_2 = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        PNG_SIGNATURE = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        PNG_CHUNK_TYPE_EXIF = new byte[]{101, 88, 73, 102};
        PNG_CHUNK_TYPE_IHDR = new byte[]{73, 72, 68, 82};
        PNG_CHUNK_TYPE_IEND = new byte[]{73, 69, 78, 68};
        WEBP_SIGNATURE_1 = new byte[]{82, 73, 70, 70};
        WEBP_SIGNATURE_2 = new byte[]{87, 69, 66, 80};
        WEBP_CHUNK_TYPE_EXIF = new byte[]{69, 88, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        EXIF_ASCII_PREFIX = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        ExifTag[] exifTagArr = {new ExifTag(254, 4, "NewSubfileType"), new ExifTag(255, 4, "SubfileType"), new ExifTag(256, 3, 4, "ImageWidth"), new ExifTag(257, 3, 4, "ImageLength"), new ExifTag(258, 3, "BitsPerSample"), new ExifTag(259, 3, "Compression"), new ExifTag(262, 3, "PhotometricInterpretation"), new ExifTag(270, 2, "ImageDescription"), new ExifTag(271, 2, "Make"), new ExifTag(272, 2, "Model"), new ExifTag(273, 3, 4, "StripOffsets"), new ExifTag(274, 3, "Orientation"), new ExifTag(277, 3, "SamplesPerPixel"), new ExifTag(278, 3, 4, "RowsPerStrip"), new ExifTag(279, 3, 4, "StripByteCounts"), new ExifTag(282, 5, "XResolution"), new ExifTag(283, 5, "YResolution"), new ExifTag(284, 3, "PlanarConfiguration"), new ExifTag(296, 3, "ResolutionUnit"), new ExifTag(301, 3, "TransferFunction"), new ExifTag(305, 2, "Software"), new ExifTag(306, 2, "DateTime"), new ExifTag(315, 2, "Artist"), new ExifTag(318, 5, "WhitePoint"), new ExifTag(319, 5, "PrimaryChromaticities"), new ExifTag(330, 4, "SubIFDPointer"), new ExifTag(513, 4, "JPEGInterchangeFormat"), new ExifTag(514, 4, "JPEGInterchangeFormatLength"), new ExifTag(529, 5, "YCbCrCoefficients"), new ExifTag(530, 3, "YCbCrSubSampling"), new ExifTag(531, 3, "YCbCrPositioning"), new ExifTag(532, 5, "ReferenceBlackWhite"), new ExifTag(33432, 2, "Copyright"), new ExifTag(34665, 4, "ExifIFDPointer"), new ExifTag(34853, 4, "GPSInfoIFDPointer"), new ExifTag(4, 4, "SensorTopBorder"), new ExifTag(5, 4, "SensorLeftBorder"), new ExifTag(6, 4, "SensorBottomBorder"), new ExifTag(7, 4, "SensorRightBorder"), new ExifTag(23, 3, "ISO"), new ExifTag(46, 7, "JpgFromRaw"), new ExifTag(700, 1, "Xmp")};
        ExifTag[] exifTagArr2 = {new ExifTag(33434, 5, "ExposureTime"), new ExifTag(33437, 5, "FNumber"), new ExifTag(34850, 3, "ExposureProgram"), new ExifTag(34852, 2, "SpectralSensitivity"), new ExifTag(34855, 3, "PhotographicSensitivity"), new ExifTag(34856, 7, "OECF"), new ExifTag(34864, 3, "SensitivityType"), new ExifTag(34865, 4, "StandardOutputSensitivity"), new ExifTag(34866, 4, "RecommendedExposureIndex"), new ExifTag(34867, 4, "ISOSpeed"), new ExifTag(34868, 4, "ISOSpeedLatitudeyyy"), new ExifTag(34869, 4, "ISOSpeedLatitudezzz"), new ExifTag(36864, 2, "ExifVersion"), new ExifTag(36867, 2, "DateTimeOriginal"), new ExifTag(36868, 2, "DateTimeDigitized"), new ExifTag(36880, 2, "OffsetTime"), new ExifTag(36881, 2, "OffsetTimeOriginal"), new ExifTag(36882, 2, "OffsetTimeDigitized"), new ExifTag(37121, 7, "ComponentsConfiguration"), new ExifTag(37122, 5, "CompressedBitsPerPixel"), new ExifTag(37377, 10, "ShutterSpeedValue"), new ExifTag(37378, 5, "ApertureValue"), new ExifTag(37379, 10, "BrightnessValue"), new ExifTag(37380, 10, "ExposureBiasValue"), new ExifTag(37381, 5, "MaxApertureValue"), new ExifTag(37382, 5, "SubjectDistance"), new ExifTag(37383, 3, "MeteringMode"), new ExifTag(37384, 3, "LightSource"), new ExifTag(37385, 3, "Flash"), new ExifTag(37386, 5, "FocalLength"), new ExifTag(37396, 3, "SubjectArea"), new ExifTag(37500, 7, "MakerNote"), new ExifTag(37510, 7, "UserComment"), new ExifTag(37520, 2, "SubSecTime"), new ExifTag(37521, 2, "SubSecTimeOriginal"), new ExifTag(37522, 2, "SubSecTimeDigitized"), new ExifTag(40960, 7, "FlashpixVersion"), new ExifTag(40961, 3, "ColorSpace"), new ExifTag(40962, 3, 4, "PixelXDimension"), new ExifTag(40963, 3, 4, "PixelYDimension"), new ExifTag(40964, 2, "RelatedSoundFile"), new ExifTag(40965, 4, "InteroperabilityIFDPointer"), new ExifTag(41483, 5, "FlashEnergy"), new ExifTag(41484, 7, "SpatialFrequencyResponse"), new ExifTag(41486, 5, "FocalPlaneXResolution"), new ExifTag(41487, 5, "FocalPlaneYResolution"), new ExifTag(41488, 3, "FocalPlaneResolutionUnit"), new ExifTag(41492, 3, "SubjectLocation"), new ExifTag(41493, 5, "ExposureIndex"), new ExifTag(41495, 3, "SensingMethod"), new ExifTag(41728, 7, "FileSource"), new ExifTag(41729, 7, "SceneType"), new ExifTag(41730, 7, "CFAPattern"), new ExifTag(41985, 3, "CustomRendered"), new ExifTag(41986, 3, "ExposureMode"), new ExifTag(41987, 3, "WhiteBalance"), new ExifTag(41988, 5, "DigitalZoomRatio"), new ExifTag(41989, 3, "FocalLengthIn35mmFilm"), new ExifTag(41990, 3, "SceneCaptureType"), new ExifTag(41991, 3, "GainControl"), new ExifTag(41992, 3, "Contrast"), new ExifTag(41993, 3, "Saturation"), new ExifTag(41994, 3, "Sharpness"), new ExifTag(41995, 7, "DeviceSettingDescription"), new ExifTag(41996, 3, "SubjectDistanceRange"), new ExifTag(42016, 2, "ImageUniqueID"), new ExifTag(42032, 2, "CameraOwnerName"), new ExifTag(42033, 2, "BodySerialNumber"), new ExifTag(42034, 5, "LensSpecification"), new ExifTag(42035, 2, "LensMake"), new ExifTag(42036, 2, "LensModel"), new ExifTag(42240, 5, "Gamma"), new ExifTag(50706, 1, "DNGVersion"), new ExifTag(50720, 3, 4, "DefaultCropSize")};
        ExifTag[] exifTagArr3 = {new ExifTag(0, 1, "GPSVersionID"), new ExifTag(1, 2, "GPSLatitudeRef"), new ExifTag(2, 5, 10, "GPSLatitude"), new ExifTag(3, 2, "GPSLongitudeRef"), new ExifTag(4, 5, 10, "GPSLongitude"), new ExifTag(5, 1, "GPSAltitudeRef"), new ExifTag(6, 5, "GPSAltitude"), new ExifTag(7, 5, "GPSTimeStamp"), new ExifTag(8, 2, "GPSSatellites"), new ExifTag(9, 2, "GPSStatus"), new ExifTag(10, 2, "GPSMeasureMode"), new ExifTag(11, 5, "GPSDOP"), new ExifTag(12, 2, "GPSSpeedRef"), new ExifTag(13, 5, "GPSSpeed"), new ExifTag(14, 2, "GPSTrackRef"), new ExifTag(15, 5, "GPSTrack"), new ExifTag(16, 2, "GPSImgDirectionRef"), new ExifTag(17, 5, "GPSImgDirection"), new ExifTag(18, 2, "GPSMapDatum"), new ExifTag(19, 2, "GPSDestLatitudeRef"), new ExifTag(20, 5, "GPSDestLatitude"), new ExifTag(21, 2, "GPSDestLongitudeRef"), new ExifTag(22, 5, "GPSDestLongitude"), new ExifTag(23, 2, "GPSDestBearingRef"), new ExifTag(24, 5, "GPSDestBearing"), new ExifTag(25, 2, "GPSDestDistanceRef"), new ExifTag(26, 5, "GPSDestDistance"), new ExifTag(27, 7, "GPSProcessingMethod"), new ExifTag(28, 7, "GPSAreaInformation"), new ExifTag(29, 2, "GPSDateStamp"), new ExifTag(30, 3, "GPSDifferential"), new ExifTag(31, 5, "GPSHPositioningError")};
        ExifTag[] exifTagArr4 = {new ExifTag(1, 2, "InteroperabilityIndex")};
        ExifTag[] exifTagArr5 = {new ExifTag(254, 4, "NewSubfileType"), new ExifTag(255, 4, "SubfileType"), new ExifTag(256, 3, 4, "ThumbnailImageWidth"), new ExifTag(257, 3, 4, "ThumbnailImageLength"), new ExifTag(258, 3, "BitsPerSample"), new ExifTag(259, 3, "Compression"), new ExifTag(262, 3, "PhotometricInterpretation"), new ExifTag(270, 2, "ImageDescription"), new ExifTag(271, 2, "Make"), new ExifTag(272, 2, "Model"), new ExifTag(273, 3, 4, "StripOffsets"), new ExifTag(274, 3, "ThumbnailOrientation"), new ExifTag(277, 3, "SamplesPerPixel"), new ExifTag(278, 3, 4, "RowsPerStrip"), new ExifTag(279, 3, 4, "StripByteCounts"), new ExifTag(282, 5, "XResolution"), new ExifTag(283, 5, "YResolution"), new ExifTag(284, 3, "PlanarConfiguration"), new ExifTag(296, 3, "ResolutionUnit"), new ExifTag(301, 3, "TransferFunction"), new ExifTag(305, 2, "Software"), new ExifTag(306, 2, "DateTime"), new ExifTag(315, 2, "Artist"), new ExifTag(318, 5, "WhitePoint"), new ExifTag(319, 5, "PrimaryChromaticities"), new ExifTag(330, 4, "SubIFDPointer"), new ExifTag(513, 4, "JPEGInterchangeFormat"), new ExifTag(514, 4, "JPEGInterchangeFormatLength"), new ExifTag(529, 5, "YCbCrCoefficients"), new ExifTag(530, 3, "YCbCrSubSampling"), new ExifTag(531, 3, "YCbCrPositioning"), new ExifTag(532, 5, "ReferenceBlackWhite"), new ExifTag(33432, 2, "Copyright"), new ExifTag(34665, 4, "ExifIFDPointer"), new ExifTag(34853, 4, "GPSInfoIFDPointer"), new ExifTag(50706, 1, "DNGVersion"), new ExifTag(50720, 3, 4, "DefaultCropSize")};
        TAG_RAF_IMAGE_SIZE = new ExifTag(273, 3, "StripOffsets");
        EXIF_TAGS = new ExifTag[][]{exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, new ExifTag[]{new ExifTag(256, 7, "ThumbnailImage"), new ExifTag(8224, 4, "CameraSettingsIFDPointer"), new ExifTag(8256, 4, "ImageProcessingIFDPointer")}, new ExifTag[]{new ExifTag(257, 4, "PreviewImageStart"), new ExifTag(258, 4, "PreviewImageLength")}, new ExifTag[]{new ExifTag(4371, 3, "AspectFrame")}, new ExifTag[]{new ExifTag(55, 3, "ColorSpace")}};
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(330, 4, "SubIFDPointer"), new ExifTag(34665, 4, "ExifIFDPointer"), new ExifTag(34853, 4, "GPSInfoIFDPointer"), new ExifTag(40965, 4, "InteroperabilityIFDPointer"), new ExifTag(8224, 1, "CameraSettingsIFDPointer"), new ExifTag(8256, 1, "ImageProcessingIFDPointer")};
        sExifTagMapsForReading = new HashMap[10];
        sExifTagMapsForWriting = new HashMap[10];
        sTagSetForCompatibility = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        sExifPointerTagMap = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        ASCII = charsetForName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(charsetForName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            ExifTag[][] exifTagArr6 = EXIF_TAGS;
            if (i >= exifTagArr6.length) {
                HashMap map = sExifPointerTagMap;
                ExifTag[] exifTagArr7 = EXIF_POINTER_TAGS;
                map.put(Integer.valueOf(exifTagArr7[0].number), 5);
                map.put(Integer.valueOf(exifTagArr7[1].number), 1);
                map.put(Integer.valueOf(exifTagArr7[2].number), 2);
                map.put(Integer.valueOf(exifTagArr7[3].number), 3);
                map.put(Integer.valueOf(exifTagArr7[4].number), 7);
                map.put(Integer.valueOf(exifTagArr7[5].number), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            sExifTagMapsForReading[i] = new HashMap();
            sExifTagMapsForWriting[i] = new HashMap();
            for (ExifTag exifTag : exifTagArr6[i]) {
                sExifTagMapsForReading[i].put(Integer.valueOf(exifTag.number), exifTag);
                sExifTagMapsForWriting[i].put(exifTag.name, exifTag);
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00de A[Catch: all -> 0x0064, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0064, blocks: (B:15:0x0053, B:17:0x0058, B:24:0x006d, B:30:0x008a, B:32:0x0095, B:40:0x00ab, B:35:0x009c, B:38:0x00a4, B:39:0x00a8, B:41:0x00b5, B:43:0x00be, B:45:0x00c4, B:47:0x00ca, B:49:0x00d0, B:54:0x00de), top: B:66:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    public ExifInterface(InputStream inputStream) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        this.mFilename = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
            this.mSeekableFileDescriptor = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            try {
                ExifInterfaceUtils.Api21Impl.lseek(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = fileInputStream.getFD();
            } catch (Exception unused) {
                if (DEBUG) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
        } else {
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = null;
        }
        boolean z = DEBUG;
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            try {
                try {
                    this.mAttributes[i] = new HashMap();
                } catch (Throwable th) {
                    addDefaultValuesForCompatibility();
                    if (z) {
                        printAttributes();
                    }
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                if (z) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                addDefaultValuesForCompatibility();
                if (!z) {
                    return;
                }
            } catch (UnsupportedOperationException e2) {
                e = e2;
                if (z) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                addDefaultValuesForCompatibility();
                if (!z) {
                    return;
                }
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        int mimeType = getMimeType(bufferedInputStream);
        this.mMimeType = mimeType;
        if (mimeType == 4 || mimeType == 9 || mimeType == 13 || mimeType == 14) {
            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream);
            int i2 = this.mMimeType;
            if (i2 == 4) {
                getJpegAttributes(byteOrderedDataInputStream, 0, 0);
            } else if (i2 == 13) {
                getPngAttributes(byteOrderedDataInputStream);
            } else if (i2 == 9) {
                getRafAttributes(byteOrderedDataInputStream);
            } else if (i2 == 14) {
                getWebpAttributes(byteOrderedDataInputStream);
            }
        } else {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bufferedInputStream);
            int i3 = this.mMimeType;
            if (i3 == 12) {
                getHeifAttributes(seekableByteOrderedDataInputStream);
            } else if (i3 == 7) {
                getOrfAttributes(seekableByteOrderedDataInputStream);
            } else if (i3 == 10) {
                getRw2Attributes(seekableByteOrderedDataInputStream);
            } else {
                getRawAttributes(seekableByteOrderedDataInputStream);
            }
            seekableByteOrderedDataInputStream.seek(this.mOffsetToExifData);
            setThumbnailData(seekableByteOrderedDataInputStream);
        }
        addDefaultValuesForCompatibility();
        if (!z) {
            return;
        }
        printAttributes();
    }

    public static ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short s = byteOrderedDataInputStream.readShort();
        boolean z = DEBUG;
        if (s == 18761) {
            if (z) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s == 19789) {
            if (z) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s));
    }

    public final void addDefaultValuesForCompatibility() {
        String attribute = getAttribute("DateTimeOriginal");
        HashMap[] mapArr = this.mAttributes;
        if (attribute != null && getAttribute("DateTime") == null) {
            mapArr[0].put("DateTime", ExifAttribute.createString(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("ImageLength") == null) {
            mapArr[0].put("ImageLength", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("Orientation") == null) {
            mapArr[0].put("Orientation", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("LightSource") == null) {
            mapArr[1].put("LightSource", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
    }

    public final String getAttribute(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            int i = exifAttribute.format;
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (str.equals("GPSTimeStamp")) {
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i);
                    return null;
                }
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                    return null;
                }
                Rational rational = rationalArr[0];
                Integer numValueOf = Integer.valueOf((int) (rational.numerator / rational.denominator));
                Rational rational2 = rationalArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (rational2.numerator / rational2.denominator));
                Rational rational3 = rationalArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (rational3.numerator / rational3.denominator)));
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final int getAttributeInt(String str, int i) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            try {
                return exifAttribute.getIntValue(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public final ExifAttribute getExifAttribute(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (DEBUG) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes[i].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    public final void getHeifAttributes(final SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                ExifInterfaceUtils.Api23Impl.setDataSource(mediaMetadataRetriever, new MediaDataSource() { // from class: androidx.exifinterface.media.ExifInterface.1
                    public long mPosition;

                    @Override // android.media.MediaDataSource
                    public final long getSize() {
                        return -1L;
                    }

                    @Override // android.media.MediaDataSource
                    public final int readAt(long j, byte[] bArr, int i2, int i3) {
                        if (i3 == 0) {
                            return 0;
                        }
                        if (j < 0) {
                            return -1;
                        }
                        try {
                            long j2 = this.mPosition;
                            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = seekableByteOrderedDataInputStream;
                            if (j2 != j) {
                                if (j2 >= 0 && j >= j2 + ((long) seekableByteOrderedDataInputStream2.mDataInputStream.available())) {
                                    return -1;
                                }
                                seekableByteOrderedDataInputStream2.seek(j);
                                this.mPosition = j;
                            }
                            if (i3 > seekableByteOrderedDataInputStream2.mDataInputStream.available()) {
                                i3 = seekableByteOrderedDataInputStream2.mDataInputStream.available();
                            }
                            int i4 = seekableByteOrderedDataInputStream2.read(bArr, i2, i3);
                            if (i4 >= 0) {
                                this.mPosition += (long) i4;
                                return i4;
                            }
                        } catch (IOException unused) {
                        }
                        this.mPosition = -1L;
                        return -1;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                    }
                });
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.mAttributes;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", ExifAttribute.createUShort(Integer.parseInt(strExtractMetadata), this.mExifByteOrder));
                }
                if (strExtractMetadata2 != null) {
                    mapArr[0].put("ImageLength", ExifAttribute.createUShort(Integer.parseInt(strExtractMetadata2), this.mExifByteOrder));
                }
                if (strExtractMetadata3 != null) {
                    int i2 = Integer.parseInt(strExtractMetadata3);
                    if (i2 == 90) {
                        i = 6;
                    } else if (i2 != 180) {
                        i = i2 != 270 ? 1 : 8;
                    } else {
                        i = 3;
                    }
                    mapArr[0].put("Orientation", ExifAttribute.createUShort(i, this.mExifByteOrder));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i3 = Integer.parseInt(strExtractMetadata4);
                    int i4 = Integer.parseInt(strExtractMetadata5);
                    if (i4 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    seekableByteOrderedDataInputStream.seek(i3);
                    byte[] bArr = new byte[6];
                    seekableByteOrderedDataInputStream.readFully(bArr);
                    int i5 = i3 + 6;
                    int i6 = i4 - 6;
                    if (!Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i6];
                    seekableByteOrderedDataInputStream.readFully(bArr2);
                    this.mOffsetToExifData = i5;
                    readExifSegment(0, bArr2);
                }
                if (DEBUG) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ab A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:67:0x0127  */
    /* JADX WARN: Code duplicated, block: B:70:0x012e A[LOOP:2: B:65:0x0124->B:70:0x012e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x0140  */
    /* JADX WARN: Code duplicated, block: B:78:0x0175 A[LOOP:0: B:10:0x0033->B:78:0x0175, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:95:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0131 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0171 A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x009d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x00a0. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x00a3. Please report as an issue. */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1068)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void getJpegAttributes(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r23, int r24, int r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    /* JADX WARN: Code duplicated, block: B:109:0x013f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:111:0x0142  */
    /* JADX WARN: Code duplicated, block: B:114:0x0149  */
    /* JADX WARN: Code duplicated, block: B:117:0x0152 A[LOOP:2: B:112:0x0144->B:117:0x0152, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:120:0x0158 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:122:0x015b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0162  */
    /* JADX WARN: Code duplicated, block: B:128:0x016b A[LOOP:3: B:123:0x015d->B:128:0x016b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:132:0x0175  */
    /* JADX WARN: Code duplicated, block: B:135:0x017f A[LOOP:4: B:130:0x0170->B:135:0x017f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:137:0x0184 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:139:0x0187 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:156:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x014f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x016e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x0168 A[EDGE_INSN: B:173:0x0168->B:127:0x0168 BREAK  A[LOOP:3: B:123:0x015d->B:128:0x016b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x0182 A[EDGE_INSN: B:174:0x0182->B:136:0x0182 BREAK  A[LOOP:4: B:130:0x0170->B:135:0x017f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x0168 A[EDGE_INSN: B:175:0x0168->B:127:0x0168 BREAK  A[LOOP:3: B:123:0x015d->B:128:0x016b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:87:0x0107 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x011e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0120  */
    public final int getMimeType(BufferedInputStream bufferedInputStream) throws Throwable {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        int i;
        ByteOrderedDataInputStream byteOrderedDataInputStream2;
        ByteOrderedDataInputStream byteOrderedDataInputStream3;
        ByteOrderedDataInputStream byteOrderedDataInputStream4;
        int i2;
        ByteOrderedDataInputStream byteOrderedDataInputStream5;
        ByteOrderedDataInputStream byteOrderedDataInputStream6;
        int i3;
        int i4;
        byte[] bArr;
        int i5;
        int i6;
        byte[] bArr2;
        int i7;
        byte[] bArr3;
        ByteOrderedDataInputStream byteOrderedDataInputStream7;
        short s;
        long j;
        bufferedInputStream.mark(5000);
        byte[] bArr4 = new byte[5000];
        bufferedInputStream.read(bArr4);
        bufferedInputStream.reset();
        int i8 = 0;
        while (true) {
            byte[] bArr5 = JPEG_SIGNATURE;
            if (i8 >= bArr5.length) {
                return 4;
            }
            if (bArr4[i8] != bArr5[i8]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i9 = 0; i9 < bytes.length; i9++) {
                    if (bArr4[i9] != bytes[i9]) {
                        int i10 = 1;
                        try {
                            try {
                                try {
                                    byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(bArr4);
                                    try {
                                        try {
                                            long j2 = byteOrderedDataInputStream2.readInt();
                                            byte[] bArr6 = new byte[4];
                                            byteOrderedDataInputStream2.readFully(bArr6);
                                            if (Arrays.equals(bArr6, HEIF_TYPE_FTYP)) {
                                                if (j2 == 1) {
                                                    j2 = byteOrderedDataInputStream2.readLong();
                                                    j = 16;
                                                    if (j2 < 16) {
                                                    }
                                                    byteOrderedDataInputStream4 = new ByteOrderedDataInputStream(bArr4);
                                                    ByteOrder byteOrder = readByteOrder(byteOrderedDataInputStream4);
                                                    this.mExifByteOrder = byteOrder;
                                                    byteOrderedDataInputStream4.mByteOrder = byteOrder;
                                                    s = byteOrderedDataInputStream4.readShort();
                                                    if (s != 20306 || s == 21330) {
                                                        i2 = 1;
                                                    } else {
                                                        i2 = i;
                                                    }
                                                    byteOrderedDataInputStream4.close();
                                                    if (i2 != 0) {
                                                        return 7;
                                                    }
                                                    try {
                                                        byteOrderedDataInputStream7 = new ByteOrderedDataInputStream(bArr4);
                                                        try {
                                                            ByteOrder byteOrder2 = readByteOrder(byteOrderedDataInputStream7);
                                                            this.mExifByteOrder = byteOrder2;
                                                            byteOrderedDataInputStream7.mByteOrder = byteOrder2;
                                                            if (byteOrderedDataInputStream7.readShort() == 85) {
                                                                i3 = 1;
                                                            } else {
                                                                i3 = i;
                                                            }
                                                            byteOrderedDataInputStream7.close();
                                                        } catch (Exception unused) {
                                                            byteOrderedDataInputStream6 = byteOrderedDataInputStream7;
                                                            if (byteOrderedDataInputStream6 != null) {
                                                                byteOrderedDataInputStream6.close();
                                                            }
                                                            i3 = i;
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            byteOrderedDataInputStream5 = byteOrderedDataInputStream7;
                                                            if (byteOrderedDataInputStream5 != null) {
                                                                byteOrderedDataInputStream5.close();
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (Exception unused2) {
                                                        byteOrderedDataInputStream6 = null;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        byteOrderedDataInputStream5 = null;
                                                    }
                                                    if (i3 != 0) {
                                                        return 10;
                                                    }
                                                    i4 = i;
                                                    while (true) {
                                                        bArr = PNG_SIGNATURE;
                                                        if (i4 < bArr.length) {
                                                            i5 = 1;
                                                            break;
                                                        }
                                                        if (bArr4[i4] != bArr[i4]) {
                                                            i5 = i;
                                                            break;
                                                        }
                                                        i4++;
                                                    }
                                                    if (i5 != 0) {
                                                        return 13;
                                                    }
                                                    i6 = i;
                                                    while (true) {
                                                        bArr2 = WEBP_SIGNATURE_1;
                                                        if (i6 < bArr2.length) {
                                                            i7 = i;
                                                            while (true) {
                                                                bArr3 = WEBP_SIGNATURE_2;
                                                                if (i7 >= bArr3.length) {
                                                                    break;
                                                                }
                                                                if (bArr4[bArr2.length + i7 + 4] != bArr3[i7]) {
                                                                    break;
                                                                }
                                                                i7++;
                                                            }
                                                            if (i10 != 0) {
                                                                return 14;
                                                            }
                                                            return i;
                                                        }
                                                        if (bArr4[i6] != bArr2[i6]) {
                                                            break;
                                                        }
                                                        i6++;
                                                    }
                                                    i10 = i;
                                                    if (i10 != 0) {
                                                        return 14;
                                                    }
                                                    return i;
                                                }
                                                j = 8;
                                                i = 0;
                                                long j3 = 5000;
                                                if (j2 > j3) {
                                                    j2 = j3;
                                                }
                                                long j4 = j2 - j;
                                                if (j4 >= 8) {
                                                    try {
                                                        byte[] bArr7 = new byte[4];
                                                        boolean z = false;
                                                        boolean z2 = false;
                                                        for (long j5 = 0; j5 < j4 / 4; j5++) {
                                                            try {
                                                                byteOrderedDataInputStream2.readFully(bArr7);
                                                                if (j5 != 1) {
                                                                    if (Arrays.equals(bArr7, HEIF_BRAND_MIF1)) {
                                                                        z = true;
                                                                    } else if (Arrays.equals(bArr7, HEIF_BRAND_HEIC)) {
                                                                        z2 = true;
                                                                    }
                                                                    if (z && z2) {
                                                                        byteOrderedDataInputStream2.close();
                                                                        return 12;
                                                                    }
                                                                }
                                                            } catch (EOFException unused3) {
                                                            }
                                                        }
                                                    } catch (Exception e) {
                                                        e = e;
                                                        if (DEBUG) {
                                                            Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                                                        }
                                                        if (byteOrderedDataInputStream2 != null) {
                                                        }
                                                        byteOrderedDataInputStream4 = new ByteOrderedDataInputStream(bArr4);
                                                        ByteOrder byteOrder3 = readByteOrder(byteOrderedDataInputStream4);
                                                        this.mExifByteOrder = byteOrder3;
                                                        byteOrderedDataInputStream4.mByteOrder = byteOrder3;
                                                        s = byteOrderedDataInputStream4.readShort();
                                                        if (s != 20306) {
                                                            i2 = 1;
                                                        } else {
                                                            i2 = 1;
                                                        }
                                                        byteOrderedDataInputStream4.close();
                                                        if (i2 != 0) {
                                                            return 7;
                                                        }
                                                        byteOrderedDataInputStream7 = new ByteOrderedDataInputStream(bArr4);
                                                        ByteOrder byteOrder4 = readByteOrder(byteOrderedDataInputStream7);
                                                        this.mExifByteOrder = byteOrder4;
                                                        byteOrderedDataInputStream7.mByteOrder = byteOrder4;
                                                        if (byteOrderedDataInputStream7.readShort() == 85) {
                                                            i3 = 1;
                                                        } else {
                                                            i3 = i;
                                                        }
                                                        byteOrderedDataInputStream7.close();
                                                        if (i3 != 0) {
                                                            return 10;
                                                        }
                                                        i4 = i;
                                                        while (true) {
                                                            bArr = PNG_SIGNATURE;
                                                            if (i4 < bArr.length) {
                                                                i5 = 1;
                                                                break;
                                                            }
                                                            if (bArr4[i4] != bArr[i4]) {
                                                                i5 = i;
                                                                break;
                                                            }
                                                            i4++;
                                                        }
                                                        if (i5 != 0) {
                                                            return 13;
                                                        }
                                                        i6 = i;
                                                        while (true) {
                                                            bArr2 = WEBP_SIGNATURE_1;
                                                            if (i6 < bArr2.length) {
                                                                i7 = i;
                                                                while (true) {
                                                                    bArr3 = WEBP_SIGNATURE_2;
                                                                    if (i7 >= bArr3.length) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    if (bArr4[bArr2.length + i7 + 4] != bArr3[i7]) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    i7++;
                                                                }
                                                                if (i10 != 0) {
                                                                    return 14;
                                                                }
                                                                return i;
                                                            }
                                                            if (bArr4[i6] != bArr2[i6]) {
                                                                break;
                                                                break;
                                                            }
                                                            i6++;
                                                        }
                                                        i10 = i;
                                                        if (i10 != 0) {
                                                            return 14;
                                                        }
                                                        return i;
                                                    }
                                                }
                                                byteOrderedDataInputStream2.close();
                                                byteOrderedDataInputStream4 = new ByteOrderedDataInputStream(bArr4);
                                                ByteOrder byteOrder5 = readByteOrder(byteOrderedDataInputStream4);
                                                this.mExifByteOrder = byteOrder5;
                                                byteOrderedDataInputStream4.mByteOrder = byteOrder5;
                                                s = byteOrderedDataInputStream4.readShort();
                                                if (s != 20306) {
                                                    i2 = 1;
                                                } else {
                                                    i2 = 1;
                                                }
                                                byteOrderedDataInputStream4.close();
                                                if (i2 != 0) {
                                                    return 7;
                                                }
                                                byteOrderedDataInputStream7 = new ByteOrderedDataInputStream(bArr4);
                                                ByteOrder byteOrder6 = readByteOrder(byteOrderedDataInputStream7);
                                                this.mExifByteOrder = byteOrder6;
                                                byteOrderedDataInputStream7.mByteOrder = byteOrder6;
                                                if (byteOrderedDataInputStream7.readShort() == 85) {
                                                    i3 = 1;
                                                } else {
                                                    i3 = i;
                                                }
                                                byteOrderedDataInputStream7.close();
                                                if (i3 != 0) {
                                                    return 10;
                                                }
                                                i4 = i;
                                                while (true) {
                                                    bArr = PNG_SIGNATURE;
                                                    if (i4 < bArr.length) {
                                                        i5 = 1;
                                                        break;
                                                    }
                                                    if (bArr4[i4] != bArr[i4]) {
                                                        i5 = i;
                                                        break;
                                                    }
                                                    i4++;
                                                }
                                                if (i5 != 0) {
                                                    return 13;
                                                }
                                                i6 = i;
                                                while (true) {
                                                    bArr2 = WEBP_SIGNATURE_1;
                                                    if (i6 < bArr2.length) {
                                                        i7 = i;
                                                        while (true) {
                                                            bArr3 = WEBP_SIGNATURE_2;
                                                            if (i7 >= bArr3.length) {
                                                                break;
                                                                break;
                                                            }
                                                            if (bArr4[bArr2.length + i7 + 4] != bArr3[i7]) {
                                                                break;
                                                                break;
                                                            }
                                                            i7++;
                                                        }
                                                        if (i10 != 0) {
                                                            return 14;
                                                        }
                                                        return i;
                                                    }
                                                    if (bArr4[i6] != bArr2[i6]) {
                                                        break;
                                                        break;
                                                    }
                                                    i6++;
                                                }
                                                i10 = i;
                                                if (i10 != 0) {
                                                    return 14;
                                                }
                                                return i;
                                            }
                                            byteOrderedDataInputStream2.close();
                                            i = 0;
                                        } catch (Exception e2) {
                                            e = e2;
                                            i = 0;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        byteOrderedDataInputStream = byteOrderedDataInputStream2;
                                        if (byteOrderedDataInputStream != null) {
                                            byteOrderedDataInputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    i = 0;
                                    byteOrderedDataInputStream2 = null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    byteOrderedDataInputStream = null;
                                }
                                ByteOrder byteOrder7 = readByteOrder(byteOrderedDataInputStream4);
                                this.mExifByteOrder = byteOrder7;
                                byteOrderedDataInputStream4.mByteOrder = byteOrder7;
                                s = byteOrderedDataInputStream4.readShort();
                                if (s != 20306) {
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                                byteOrderedDataInputStream4.close();
                            } catch (Exception unused4) {
                                if (byteOrderedDataInputStream4 != null) {
                                    byteOrderedDataInputStream4.close();
                                }
                                i2 = i;
                            } catch (Throwable th5) {
                                th = th5;
                                byteOrderedDataInputStream3 = byteOrderedDataInputStream4;
                                if (byteOrderedDataInputStream3 != null) {
                                    byteOrderedDataInputStream3.close();
                                }
                                throw th;
                            }
                            byteOrderedDataInputStream4 = new ByteOrderedDataInputStream(bArr4);
                        } catch (Exception unused5) {
                            byteOrderedDataInputStream4 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            byteOrderedDataInputStream3 = null;
                        }
                        if (i2 != 0) {
                            return 7;
                        }
                        byteOrderedDataInputStream7 = new ByteOrderedDataInputStream(bArr4);
                        ByteOrder byteOrder8 = readByteOrder(byteOrderedDataInputStream7);
                        this.mExifByteOrder = byteOrder8;
                        byteOrderedDataInputStream7.mByteOrder = byteOrder8;
                        if (byteOrderedDataInputStream7.readShort() == 85) {
                            i3 = 1;
                        } else {
                            i3 = i;
                        }
                        byteOrderedDataInputStream7.close();
                        if (i3 != 0) {
                            return 10;
                        }
                        i4 = i;
                        while (true) {
                            bArr = PNG_SIGNATURE;
                            if (i4 < bArr.length) {
                                i5 = 1;
                                break;
                            }
                            if (bArr4[i4] != bArr[i4]) {
                                i5 = i;
                                break;
                            }
                            i4++;
                        }
                        if (i5 != 0) {
                            return 13;
                        }
                        i6 = i;
                        while (true) {
                            bArr2 = WEBP_SIGNATURE_1;
                            if (i6 < bArr2.length) {
                                i7 = i;
                                while (true) {
                                    bArr3 = WEBP_SIGNATURE_2;
                                    if (i7 >= bArr3.length) {
                                        break;
                                        break;
                                    }
                                    if (bArr4[bArr2.length + i7 + 4] != bArr3[i7]) {
                                        break;
                                        break;
                                    }
                                    i7++;
                                }
                                if (i10 != 0) {
                                    return 14;
                                }
                                return i;
                            }
                            if (bArr4[i6] != bArr2[i6]) {
                                break;
                                break;
                            }
                            i6++;
                        }
                        i10 = i;
                        if (i10 != 0) {
                            return 14;
                        }
                        return i;
                    }
                }
                return 9;
            }
            i8++;
        }
    }

    public final void getOrfAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws Throwable {
        int i;
        int i2;
        getRawAttributes(seekableByteOrderedDataInputStream);
        HashMap[] mapArr = this.mAttributes;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[1].get("MakerNote");
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
            seekableByteOrderedDataInputStream2.mByteOrder = this.mExifByteOrder;
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.seek(0L);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.seek(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.seek(12L);
            }
            readImageFileDirectory(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[7].get("PreviewImageStart");
            ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[7].get("PreviewImageLength");
            if (exifAttribute2 != null && exifAttribute3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", exifAttribute2);
                mapArr[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = (ExifAttribute) mapArr[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                ExifAttribute exifAttributeCreateUShort = ExifAttribute.createUShort(i5, this.mExifByteOrder);
                ExifAttribute exifAttributeCreateUShort2 = ExifAttribute.createUShort(i6, this.mExifByteOrder);
                mapArr[0].put("ImageWidth", exifAttributeCreateUShort);
                mapArr[0].put("ImageLength", exifAttributeCreateUShort2);
            }
        }
    }

    public final void getPngAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        if (DEBUG) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.mByteOrder = ByteOrder.BIG_ENDIAN;
        byte[] bArr = PNG_SIGNATURE;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = byteOrderedDataInputStream.readInt();
                byte[] bArr2 = new byte[4];
                byteOrderedDataInputStream.readFully(bArr2);
                int i2 = length + 8;
                if (i2 == 16 && !Arrays.equals(bArr2, PNG_CHUNK_TYPE_IHDR)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_IEND)) {
                    return;
                }
                if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_EXIF)) {
                    byte[] bArr3 = new byte[i];
                    byteOrderedDataInputStream.readFully(bArr3);
                    int i3 = byteOrderedDataInputStream.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i3) {
                        this.mOffsetToExifData = i2;
                        readExifSegment(0, bArr3);
                        validateImages();
                        setThumbnailData(new ByteOrderedDataInputStream(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i3 + ", calculated CRC value: " + crc32.getValue());
                }
                int i4 = i + 4;
                byteOrderedDataInputStream.skipFully(i4);
                length = i2 + i4;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        boolean z = DEBUG;
        if (z) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.skipFully(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.readFully(bArr);
        byteOrderedDataInputStream.readFully(bArr2);
        byteOrderedDataInputStream.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        byteOrderedDataInputStream.skipFully(i - byteOrderedDataInputStream.mPosition);
        byteOrderedDataInputStream.readFully(bArr4);
        getJpegAttributes(new ByteOrderedDataInputStream(bArr4), i, 5);
        byteOrderedDataInputStream.skipFully(i3 - byteOrderedDataInputStream.mPosition);
        byteOrderedDataInputStream.mByteOrder = ByteOrder.BIG_ENDIAN;
        int i4 = byteOrderedDataInputStream.readInt();
        if (z) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (unsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short s = byteOrderedDataInputStream.readShort();
                short s2 = byteOrderedDataInputStream.readShort();
                ExifAttribute exifAttributeCreateUShort = ExifAttribute.createUShort(s, this.mExifByteOrder);
                ExifAttribute exifAttributeCreateUShort2 = ExifAttribute.createUShort(s2, this.mExifByteOrder);
                HashMap[] mapArr = this.mAttributes;
                mapArr[0].put("ImageLength", exifAttributeCreateUShort);
                mapArr[0].put("ImageWidth", exifAttributeCreateUShort2);
                if (z) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s) + ", width: " + ((int) s2));
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.skipFully(unsignedShort2);
        }
    }

    public final void getRawAttributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws Throwable {
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 0);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 5);
        updateImageSizeValues(seekableByteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType == 8) {
            HashMap[] mapArr = this.mAttributes;
            ExifAttribute exifAttribute = (ExifAttribute) mapArr[1].get("MakerNote");
            if (exifAttribute != null) {
                SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.bytes);
                seekableByteOrderedDataInputStream2.mByteOrder = this.mExifByteOrder;
                seekableByteOrderedDataInputStream2.skipFully(6);
                readImageFileDirectory(seekableByteOrderedDataInputStream2, 9);
                ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[9].get("ColorSpace");
                if (exifAttribute2 != null) {
                    mapArr[1].put("ColorSpace", exifAttribute2);
                }
            }
        }
    }

    public final void getRw2Attributes(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws Throwable {
        if (DEBUG) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream);
        }
        getRawAttributes(seekableByteOrderedDataInputStream);
        HashMap[] mapArr = this.mAttributes;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[0].get("JpgFromRaw");
        if (exifAttribute != null) {
            getJpegAttributes(new ByteOrderedDataInputStream(exifAttribute.bytes), (int) exifAttribute.bytesOffset, 5);
        }
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[0].get("ISO");
        ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[1].get("PhotographicSensitivity");
        if (exifAttribute2 == null || exifAttribute3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", exifAttribute2);
    }

    public final void getWebpAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        if (DEBUG) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.mByteOrder = ByteOrder.LITTLE_ENDIAN;
        byteOrderedDataInputStream.skipFully(WEBP_SIGNATURE_1.length);
        int i = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipFully(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                byteOrderedDataInputStream.readFully(bArr2);
                int i2 = byteOrderedDataInputStream.readInt();
                int i3 = length + 8;
                if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr2)) {
                    byte[] bArr3 = new byte[i2];
                    byteOrderedDataInputStream.readFully(bArr3);
                    this.mOffsetToExifData = i3;
                    readExifSegment(0, bArr3);
                    setThumbnailData(new ByteOrderedDataInputStream(bArr3));
                    return;
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                byteOrderedDataInputStream.skipFully(i2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap map) throws Throwable {
        ExifAttribute exifAttribute = (ExifAttribute) map.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("JPEGInterchangeFormatLength");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        if (this.mMimeType == 7) {
            intValue += this.mOrfMakerNoteOffset;
        }
        if (intValue > 0 && intValue2 > 0 && this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
            byteOrderedDataInputStream.skipFully(intValue);
            byteOrderedDataInputStream.readFully(new byte[intValue2]);
        }
        if (DEBUG) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + intValue + ", length: " + intValue2);
        }
    }

    public final boolean isThumbnail(HashMap map) {
        ExifAttribute exifAttribute = (ExifAttribute) map.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    public final void parseTiffHeaders(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        ByteOrder byteOrder = readByteOrder(seekableByteOrderedDataInputStream);
        this.mExifByteOrder = byteOrder;
        seekableByteOrderedDataInputStream.mByteOrder = byteOrder;
        int unsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
        int i = this.mMimeType;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i2 = seekableByteOrderedDataInputStream.readInt();
        if (i2 < 8) {
            throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("Invalid first Ifd offset: ", i2));
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            seekableByteOrderedDataInputStream.skipFully(i3);
        }
    }

    public final void printAttributes() {
        int i = 0;
        while (true) {
            HashMap[] mapArr = this.mAttributes;
            if (i >= mapArr.length) {
                return;
            }
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "The size of tag group[", "]: ");
            sbM.append(mapArr[i].size());
            Log.d("ExifInterface", sbM.toString());
            for (Map.Entry entry : mapArr[i].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.getStringValue(this.mExifByteOrder) + "'");
            }
            i++;
        }
    }

    public final void readExifSegment(int i, byte[] bArr) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        parseTiffHeaders(seekableByteOrderedDataInputStream);
        readImageFileDirectory(seekableByteOrderedDataInputStream, i);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x022b  */
    /* JADX WARN: Code duplicated, block: B:107:0x023c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0241  */
    /* JADX WARN: Code duplicated, block: B:109:0x024d  */
    /* JADX WARN: Code duplicated, block: B:111:0x0254  */
    /* JADX WARN: Code duplicated, block: B:114:0x0272 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:123:0x02b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:126:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:129:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:131:0x0305  */
    /* JADX WARN: Code duplicated, block: B:145:0x0342  */
    /* JADX WARN: Code duplicated, block: B:172:0x0345 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x0153  */
    /* JADX WARN: Code duplicated, block: B:70:0x016a  */
    /* JADX WARN: Code duplicated, block: B:71:0x0171  */
    /* JADX WARN: Code duplicated, block: B:73:0x0179  */
    /* JADX WARN: Code duplicated, block: B:75:0x017f  */
    /* JADX WARN: Code duplicated, block: B:76:0x0195  */
    /* JADX WARN: Code duplicated, block: B:79:0x019e  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:82:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:89:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:92:0x0206  */
    /* JADX WARN: Code duplicated, block: B:94:0x0221  */
    /* JADX WARN: Code duplicated, block: B:96:0x0224  */
    /* JADX WARN: Code duplicated, block: B:98:0x0227  */
    /* JADX WARN: Instruction removed from duplicated block: B:126:0x02ba, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x0153, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:75:0x017f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:92:0x0206, please report this as an issue */
    public final void readImageFileDirectory(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws IOException {
        HashMap[] mapArr;
        int i2;
        int i3;
        long j;
        boolean z;
        int i4;
        short s;
        Integer num;
        long j2;
        String str;
        int unsignedShort;
        long j3;
        String strM;
        int i5;
        int i6 = seekableByteOrderedDataInputStream.mPosition;
        int i7 = seekableByteOrderedDataInputStream.mLength;
        Integer numValueOf = Integer.valueOf(i6);
        HashSet hashSet = this.mAttributesOffsets;
        hashSet.add(numValueOf);
        short s2 = seekableByteOrderedDataInputStream.readShort();
        boolean z2 = DEBUG;
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) s2));
        }
        if (s2 <= 0) {
            return;
        }
        short s3 = 0;
        while (true) {
            mapArr = this.mAttributes;
            if (s3 >= s2) {
                break;
            }
            int unsignedShort2 = seekableByteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort3 = seekableByteOrderedDataInputStream.readUnsignedShort();
            int i8 = seekableByteOrderedDataInputStream.readInt();
            long j4 = ((long) seekableByteOrderedDataInputStream.mPosition) + 4;
            short s4 = s2;
            ExifTag exifTag = (ExifTag) sExifTagMapsForReading[i].get(Integer.valueOf(unsignedShort2));
            if (z2) {
                i2 = 3;
                Log.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", Integer.valueOf(i), Integer.valueOf(unsignedShort2), exifTag != null ? exifTag.name : null, Integer.valueOf(unsignedShort3), Integer.valueOf(i8)));
            } else {
                i2 = 3;
            }
            if (exifTag == null) {
                if (z2) {
                    Log.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
                }
                i3 = unsignedShort2;
            } else {
                if (unsignedShort3 > 0) {
                    int[] iArr = IFD_FORMAT_BYTES_PER_FORMAT;
                    if (unsignedShort3 >= iArr.length) {
                        i3 = unsignedShort2;
                        if (z2 != 0) {
                            Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                        }
                    } else {
                        int i9 = exifTag.primaryFormat;
                        if (i9 == 7 || unsignedShort3 == 7 || i9 == unsignedShort3 || (i4 = exifTag.secondaryFormat) == unsignedShort3) {
                            i3 = unsignedShort2;
                        } else {
                            i3 = unsignedShort2;
                            if (((i9 != 4 && i4 != 4) || unsignedShort3 != i2) && (((i9 != 9 && i4 != 9) || unsignedShort3 != 8) && ((i9 != 12 && i4 != 12) || unsignedShort3 != 11))) {
                                if (z2 != 0) {
                                    Log.d("ExifInterface", "Skip the tag entry since data format (" + IFD_FORMAT_NAMES[unsignedShort3] + ") is unexpected for tag: " + exifTag.name);
                                }
                            }
                        }
                        if (unsignedShort3 == 7) {
                            unsignedShort3 = i9;
                        }
                        j = ((long) iArr[unsignedShort3]) * ((long) i8);
                        if (j < 0 || j > 2147483647L) {
                            if (z2 != 0) {
                                Log.d("ExifInterface", "Skip the tag entry since the number of components is invalid: " + i8);
                            }
                            z = false;
                            j = j;
                        } else {
                            z = true;
                        }
                    }
                } else {
                    i3 = unsignedShort2;
                    if (z2 != 0) {
                        Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                    }
                }
                if (z) {
                    s = s3;
                    if (j > 4) {
                        i5 = seekableByteOrderedDataInputStream.readInt();
                        if (z2 != 0) {
                            Log.d("ExifInterface", "seek to data offset: " + i5);
                        }
                        if (this.mMimeType != 7) {
                            if ("MakerNote".equals(exifTag.name)) {
                                this.mOrfMakerNoteOffset = i5;
                            } else if (i != 6 && "ThumbnailImage".equals(exifTag.name)) {
                                this.mOrfThumbnailOffset = i5;
                                this.mOrfThumbnailLength = i8;
                                ExifAttribute exifAttributeCreateUShort = ExifAttribute.createUShort(6, this.mExifByteOrder);
                                ExifAttribute exifAttributeCreateULong = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                                ExifAttribute exifAttributeCreateULong2 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                                mapArr[4].put("Compression", exifAttributeCreateUShort);
                                mapArr[4].put("JPEGInterchangeFormat", exifAttributeCreateULong);
                                mapArr[4].put("JPEGInterchangeFormatLength", exifAttributeCreateULong2);
                            }
                        }
                        seekableByteOrderedDataInputStream.seek(i5);
                    } else {
                        j4 = j4;
                        i8 = i8;
                        mapArr = mapArr;
                    }
                    num = (Integer) sExifPointerTagMap.get(Integer.valueOf(i3));
                    if (z2 != 0) {
                        Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j);
                    }
                    if (num != null) {
                        if (unsignedShort3 != 3) {
                            if (unsignedShort3 != 4) {
                                j3 = ((long) seekableByteOrderedDataInputStream.readInt()) & 4294967295L;
                            } else if (unsignedShort3 == 8) {
                                unsignedShort = seekableByteOrderedDataInputStream.readShort();
                            } else if (unsignedShort3 != 9 || unsignedShort3 == 13) {
                                unsignedShort = seekableByteOrderedDataInputStream.readInt();
                            } else {
                                j3 = -1;
                            }
                            if (z2 != 0) {
                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j3), exifTag.name));
                            }
                            if (j3 > 0 || (i7 != -1 && j3 >= i7)) {
                                if (z2 != 0) {
                                    strM = Modifier.CC.m("Skip jump into the IFD since its offset is invalid: ", j3);
                                    if (i7 != -1) {
                                        strM = strM + " (total length: " + i7 + ")";
                                    }
                                    Log.d("ExifInterface", strM);
                                }
                            } else if (!hashSet.contains(Integer.valueOf((int) j3))) {
                                seekableByteOrderedDataInputStream.seek(j3);
                                readImageFileDirectory(seekableByteOrderedDataInputStream, num.intValue());
                            } else if (z2 != 0) {
                                Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j3 + ")");
                            }
                            seekableByteOrderedDataInputStream.seek(j4);
                        } else {
                            unsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
                        }
                        j3 = unsignedShort;
                        if (z2 != 0) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j3), exifTag.name));
                        }
                        if (j3 > 0) {
                            if (z2 != 0) {
                                strM = Modifier.CC.m("Skip jump into the IFD since its offset is invalid: ", j3);
                                if (i7 != -1) {
                                    strM = strM + " (total length: " + i7 + ")";
                                }
                                Log.d("ExifInterface", strM);
                            }
                        } else if (z2 != 0) {
                            strM = Modifier.CC.m("Skip jump into the IFD since its offset is invalid: ", j3);
                            if (i7 != -1) {
                                strM = strM + " (total length: " + i7 + ")";
                            }
                            Log.d("ExifInterface", strM);
                        }
                        seekableByteOrderedDataInputStream.seek(j4);
                    } else {
                        j2 = j4;
                        int i10 = seekableByteOrderedDataInputStream.mPosition + this.mOffsetToExifData;
                        byte[] bArr = new byte[(int) j];
                        seekableByteOrderedDataInputStream.readFully(bArr);
                        ExifAttribute exifAttribute = new ExifAttribute(i10, bArr, unsignedShort3, i8);
                        HashMap map = mapArr[i];
                        str = exifTag.name;
                        map.put(str, exifAttribute);
                        if ("DNGVersion".equals(str)) {
                            this.mMimeType = 3;
                        }
                        if (((!"Make".equals(str) || "Model".equals(str)) && exifAttribute.getStringValue(this.mExifByteOrder).contains("PENTAX")) || ("Compression".equals(str) && exifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                            this.mMimeType = 8;
                        }
                        if (seekableByteOrderedDataInputStream.mPosition != j2) {
                            seekableByteOrderedDataInputStream.seek(j2);
                        }
                    }
                } else {
                    seekableByteOrderedDataInputStream.seek(j4);
                    s = s3;
                }
                s3 = (short) (s + 1);
                s2 = s4;
                z2 = z2;
            }
            z = false;
            j = 0;
            if (z) {
                seekableByteOrderedDataInputStream.seek(j4);
                s = s3;
            } else {
                s = s3;
                if (j > 4) {
                    i5 = seekableByteOrderedDataInputStream.readInt();
                    if (z2 != 0) {
                        Log.d("ExifInterface", "seek to data offset: " + i5);
                    }
                    if (this.mMimeType != 7) {
                        if ("MakerNote".equals(exifTag.name)) {
                            this.mOrfMakerNoteOffset = i5;
                        } else if (i != 6) {
                        }
                    }
                    seekableByteOrderedDataInputStream.seek(i5);
                } else {
                    j4 = j4;
                    i8 = i8;
                    mapArr = mapArr;
                }
                num = (Integer) sExifPointerTagMap.get(Integer.valueOf(i3));
                if (z2 != 0) {
                    Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j);
                }
                if (num != null) {
                    if (unsignedShort3 != 3) {
                        if (unsignedShort3 != 4) {
                            j3 = ((long) seekableByteOrderedDataInputStream.readInt()) & 4294967295L;
                        } else if (unsignedShort3 == 8) {
                            if (unsignedShort3 != 9) {
                            }
                            unsignedShort = seekableByteOrderedDataInputStream.readInt();
                        } else {
                            unsignedShort = seekableByteOrderedDataInputStream.readShort();
                        }
                        if (z2 != 0) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j3), exifTag.name));
                        }
                        if (j3 > 0) {
                            if (z2 != 0) {
                                strM = Modifier.CC.m("Skip jump into the IFD since its offset is invalid: ", j3);
                                if (i7 != -1) {
                                    strM = strM + " (total length: " + i7 + ")";
                                }
                                Log.d("ExifInterface", strM);
                            }
                        } else if (z2 != 0) {
                            strM = Modifier.CC.m("Skip jump into the IFD since its offset is invalid: ", j3);
                            if (i7 != -1) {
                                strM = strM + " (total length: " + i7 + ")";
                            }
                            Log.d("ExifInterface", strM);
                        }
                        seekableByteOrderedDataInputStream.seek(j4);
                    } else {
                        unsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
                    }
                    j3 = unsignedShort;
                    if (z2 != 0) {
                        Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j3), exifTag.name));
                    }
                    if (j3 > 0) {
                        if (z2 != 0) {
                            strM = Modifier.CC.m("Skip jump into the IFD since its offset is invalid: ", j3);
                            if (i7 != -1) {
                                strM = strM + " (total length: " + i7 + ")";
                            }
                            Log.d("ExifInterface", strM);
                        }
                    } else if (z2 != 0) {
                        strM = Modifier.CC.m("Skip jump into the IFD since its offset is invalid: ", j3);
                        if (i7 != -1) {
                            strM = strM + " (total length: " + i7 + ")";
                        }
                        Log.d("ExifInterface", strM);
                    }
                    seekableByteOrderedDataInputStream.seek(j4);
                } else {
                    j2 = j4;
                    int i11 = seekableByteOrderedDataInputStream.mPosition + this.mOffsetToExifData;
                    byte[] bArr2 = new byte[(int) j];
                    seekableByteOrderedDataInputStream.readFully(bArr2);
                    ExifAttribute exifAttribute2 = new ExifAttribute(i11, bArr2, unsignedShort3, i8);
                    HashMap map2 = mapArr[i];
                    str = exifTag.name;
                    map2.put(str, exifAttribute2);
                    if ("DNGVersion".equals(str)) {
                        this.mMimeType = 3;
                    }
                    if (!"Make".equals(str)) {
                    }
                    this.mMimeType = 8;
                    if (seekableByteOrderedDataInputStream.mPosition != j2) {
                        seekableByteOrderedDataInputStream.seek(j2);
                    }
                }
            }
            s3 = (short) (s + 1);
            s2 = s4;
            z2 = z2;
        }
        boolean z3 = z2;
        int i12 = seekableByteOrderedDataInputStream.readInt();
        if (z3) {
            Log.d("ExifInterface", String.format("nextIfdOffset: %d", Integer.valueOf(i12)));
        }
        long j5 = i12;
        if (j5 <= 0) {
            if (z3) {
                Log.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i12);
                return;
            }
            return;
        }
        if (hashSet.contains(Integer.valueOf(i12))) {
            if (z3) {
                Log.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i12);
                return;
            }
            return;
        }
        seekableByteOrderedDataInputStream.seek(j5);
        if (mapArr[4].isEmpty()) {
            readImageFileDirectory(seekableByteOrderedDataInputStream, 4);
        } else if (mapArr[5].isEmpty()) {
            readImageFileDirectory(seekableByteOrderedDataInputStream, 5);
        }
    }

    public final void replaceInvalidTags(int i, String str, String str2) {
        HashMap[] mapArr = this.mAttributes;
        if (mapArr[i].isEmpty() || mapArr[i].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i];
        map.put(str2, map.get(str));
        mapArr[i].remove(str);
    }

    public final void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        ExifAttribute exifAttribute;
        int intValue;
        HashMap map = this.mAttributes[4];
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("Compression");
        if (exifAttribute2 == null) {
            handleThumbnailFromJfif(byteOrderedDataInputStream, map);
            return;
        }
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        if (intValue2 != 1) {
            if (intValue2 == 6) {
                handleThumbnailFromJfif(byteOrderedDataInputStream, map);
                return;
            } else if (intValue2 != 7) {
                return;
            }
        }
        ExifAttribute exifAttribute3 = (ExifAttribute) map.get("BitsPerSample");
        if (exifAttribute3 != null) {
            int[] iArr = (int[]) exifAttribute3.getValue(this.mExifByteOrder);
            int[] iArr2 = BITS_PER_SAMPLE_RGB;
            if (Arrays.equals(iArr2, iArr) || (this.mMimeType == 3 && (exifAttribute = (ExifAttribute) map.get("PhotometricInterpretation")) != null && (((intValue = exifAttribute.getIntValue(this.mExifByteOrder)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, iArr2))))) {
                ExifAttribute exifAttribute4 = (ExifAttribute) map.get("StripOffsets");
                ExifAttribute exifAttribute5 = (ExifAttribute) map.get("StripByteCounts");
                if (exifAttribute4 == null || exifAttribute5 == null) {
                    return;
                }
                long[] jArrConvertToLongArray = ExifInterfaceUtils.convertToLongArray(exifAttribute4.getValue(this.mExifByteOrder));
                long[] jArrConvertToLongArray2 = ExifInterfaceUtils.convertToLongArray(exifAttribute5.getValue(this.mExifByteOrder));
                if (jArrConvertToLongArray == null || jArrConvertToLongArray.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrConvertToLongArray2 == null || jArrConvertToLongArray2.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrConvertToLongArray.length != jArrConvertToLongArray2.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j = 0;
                for (long j2 : jArrConvertToLongArray2) {
                    j += j2;
                }
                byte[] bArr = new byte[(int) j];
                this.mAreThumbnailStripsConsecutive = true;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < jArrConvertToLongArray.length; i3++) {
                    int i4 = (int) jArrConvertToLongArray[i3];
                    int i5 = (int) jArrConvertToLongArray2[i3];
                    if (i3 < jArrConvertToLongArray.length - 1 && i4 + i5 != jArrConvertToLongArray[i3 + 1]) {
                        this.mAreThumbnailStripsConsecutive = false;
                    }
                    int i6 = i4 - i;
                    if (i6 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    try {
                        byteOrderedDataInputStream.skipFully(i6);
                        int i7 = i + i6;
                        byte[] bArr2 = new byte[i5];
                        try {
                            byteOrderedDataInputStream.readFully(bArr2);
                            i = i7 + i5;
                            System.arraycopy(bArr2, 0, bArr, i2, i5);
                            i2 += i5;
                        } catch (EOFException unused) {
                            Log.d("ExifInterface", "Failed to read " + i5 + " bytes.");
                            return;
                        }
                    } catch (EOFException unused2) {
                        Log.d("ExifInterface", "Failed to skip " + i6 + " bytes.");
                        return;
                    }
                }
                if (this.mAreThumbnailStripsConsecutive) {
                    long j3 = jArrConvertToLongArray[0];
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void swapBasedOnImageSize(int i, int i2) throws Throwable {
        HashMap[] mapArr = this.mAttributes;
        boolean zIsEmpty = mapArr[i].isEmpty();
        boolean z = DEBUG;
        if (zIsEmpty || mapArr[i2].isEmpty()) {
            if (z) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[i].get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[i].get("ImageWidth");
        ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[i2].get("ImageLength");
        ExifAttribute exifAttribute4 = (ExifAttribute) mapArr[i2].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            if (z) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (exifAttribute3 == null || exifAttribute4 == null) {
            if (z) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
        int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
        int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    public final void updateImageSizeValues(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i) throws Throwable {
        ExifAttribute exifAttributeCreateUShort;
        ExifAttribute exifAttributeCreateUShort2;
        HashMap[] mapArr = this.mAttributes;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[i].get("DefaultCropSize");
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[i].get("SensorTopBorder");
        ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[i].get("SensorLeftBorder");
        ExifAttribute exifAttribute4 = (ExifAttribute) mapArr[i].get("SensorBottomBorder");
        ExifAttribute exifAttribute5 = (ExifAttribute) mapArr[i].get("SensorRightBorder");
        if (exifAttribute != null) {
            if (exifAttribute.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                } else {
                    exifAttributeCreateUShort = ExifAttribute.createURational(new Rational[]{rationalArr[0]}, this.mExifByteOrder);
                    exifAttributeCreateUShort2 = ExifAttribute.createURational(new Rational[]{rationalArr[1]}, this.mExifByteOrder);
                }
            } else {
                int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                exifAttributeCreateUShort = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                exifAttributeCreateUShort2 = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
            }
            mapArr[i].put("ImageWidth", exifAttributeCreateUShort);
            mapArr[i].put("ImageLength", exifAttributeCreateUShort2);
            return;
        }
        if (exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null && exifAttribute5 != null) {
            int intValue = exifAttribute2.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute5.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute3.getIntValue(this.mExifByteOrder);
            if (intValue2 <= intValue || intValue3 <= intValue4) {
                return;
            }
            ExifAttribute exifAttributeCreateUShort3 = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
            ExifAttribute exifAttributeCreateUShort4 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
            mapArr[i].put("ImageLength", exifAttributeCreateUShort3);
            mapArr[i].put("ImageWidth", exifAttributeCreateUShort4);
            return;
        }
        ExifAttribute exifAttribute6 = (ExifAttribute) mapArr[i].get("ImageLength");
        ExifAttribute exifAttribute7 = (ExifAttribute) mapArr[i].get("ImageWidth");
        if (exifAttribute6 == null || exifAttribute7 == null) {
            ExifAttribute exifAttribute8 = (ExifAttribute) mapArr[i].get("JPEGInterchangeFormat");
            ExifAttribute exifAttribute9 = (ExifAttribute) mapArr[i].get("JPEGInterchangeFormatLength");
            if (exifAttribute8 == null || exifAttribute9 == null) {
                return;
            }
            int intValue5 = exifAttribute8.getIntValue(this.mExifByteOrder);
            int intValue6 = exifAttribute8.getIntValue(this.mExifByteOrder);
            seekableByteOrderedDataInputStream.seek(intValue5);
            byte[] bArr = new byte[intValue6];
            seekableByteOrderedDataInputStream.readFully(bArr);
            getJpegAttributes(new ByteOrderedDataInputStream(bArr), intValue5, i);
        }
    }

    public final void validateImages() throws Throwable {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        HashMap[] mapArr = this.mAttributes;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[1].get("PixelYDimension");
        if (exifAttribute != null && exifAttribute2 != null) {
            mapArr[0].put("ImageWidth", exifAttribute);
            mapArr[0].put("ImageLength", exifAttribute2);
        }
        if (mapArr[4].isEmpty() && isThumbnail(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!isThumbnail(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        replaceInvalidTags(0, "ThumbnailOrientation", "Orientation");
        replaceInvalidTags(0, "ThumbnailImageLength", "ImageLength");
        replaceInvalidTags(0, "ThumbnailImageWidth", "ImageWidth");
        replaceInvalidTags(5, "ThumbnailOrientation", "Orientation");
        replaceInvalidTags(5, "ThumbnailImageLength", "ImageLength");
        replaceInvalidTags(5, "ThumbnailImageWidth", "ImageWidth");
        replaceInvalidTags(4, "Orientation", "ThumbnailOrientation");
        replaceInvalidTags(4, "ImageLength", "ThumbnailImageLength");
        replaceInvalidTags(4, "ImageWidth", "ThumbnailImageWidth");
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class ByteOrderedDataInputStream extends InputStream implements DataInput {
        public ByteOrder mByteOrder;
        public final DataInputStream mDataInputStream;
        public final int mLength;
        public int mPosition;
        public byte[] mSkipBuffer;

        public ByteOrderedDataInputStream(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
            this.mLength = bArr.length;
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.mDataInputStream.available();
        }

        @Override // java.io.InputStream
        public final void mark(int i) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public final int read() {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public final byte readByte() throws IOException {
            this.mPosition++;
            int i = this.mDataInputStream.read();
            if (i >= 0) {
                return (byte) i;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final char readChar() {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public final double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public final float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.mPosition += i2;
            this.mDataInputStream.readFully(bArr, i, i2);
        }

        @Override // java.io.DataInput
        public final int readInt() throws IOException {
            this.mPosition += 4;
            DataInputStream dataInputStream = this.mDataInputStream;
            int i = dataInputStream.read();
            int i2 = dataInputStream.read();
            int i3 = dataInputStream.read();
            int i4 = dataInputStream.read();
            if ((i | i2 | i3 | i4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
            }
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public final String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public final long readLong() throws IOException {
            long j;
            long j2;
            this.mPosition += 8;
            DataInputStream dataInputStream = this.mDataInputStream;
            int i = dataInputStream.read();
            int i2 = dataInputStream.read();
            int i3 = dataInputStream.read();
            int i4 = dataInputStream.read();
            int i5 = dataInputStream.read();
            int i6 = dataInputStream.read();
            int i7 = dataInputStream.read();
            int i8 = dataInputStream.read();
            if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                j = (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8);
                j2 = i;
            } else {
                if (byteOrder != ByteOrder.BIG_ENDIAN) {
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                j = (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8);
                j2 = i8;
            }
            return j + j2;
        }

        @Override // java.io.DataInput
        public final short readShort() throws IOException {
            this.mPosition += 2;
            DataInputStream dataInputStream = this.mDataInputStream;
            int i = dataInputStream.read();
            int i2 = dataInputStream.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (short) ((i2 << 8) + i);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (short) ((i << 8) + i2);
            }
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.DataInput
        public final String readUTF() {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() throws IOException {
            this.mPosition += 2;
            DataInputStream dataInputStream = this.mDataInputStream;
            int i = dataInputStream.read();
            int i2 = dataInputStream.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i2 << 8) + i;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i << 8) + i2;
            }
            throw new IOException("Invalid byte order: " + this.mByteOrder);
        }

        @Override // java.io.InputStream
        public final void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public final void skipFully(int i) throws IOException {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                DataInputStream dataInputStream = this.mDataInputStream;
                int iSkip = (int) dataInputStream.skip(i3);
                if (iSkip <= 0) {
                    if (this.mSkipBuffer == null) {
                        this.mSkipBuffer = new byte[8192];
                    }
                    iSkip = dataInputStream.read(this.mSkipBuffer, 0, Math.min(8192, i3));
                    if (iSkip == -1) {
                        throw new EOFException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Reached EOF while skipping ", " bytes."));
                    }
                }
                i2 += iSkip;
            }
            this.mPosition += i2;
        }

        public ByteOrderedDataInputStream(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += i3;
            return i3;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr) throws IOException {
            this.mPosition += bArr.length;
            this.mDataInputStream.readFully(bArr);
        }

        public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            dataInputStream.mark(0);
            this.mPosition = 0;
            this.mByteOrder = byteOrder;
            this.mLength = inputStream instanceof ByteOrderedDataInputStream ? ((ByteOrderedDataInputStream) inputStream).mLength : -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        public SeekableByteOrderedDataInputStream(byte[] bArr) {
            super(bArr);
            this.mDataInputStream.mark(Integer.MAX_VALUE);
        }

        public final void seek(long j) throws IOException {
            int i = this.mPosition;
            if (i > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
            } else {
                j -= (long) i;
            }
            skipFully((int) j);
        }

        public SeekableByteOrderedDataInputStream(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.mDataInputStream.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        public ExifTag(int i, int i2, String str) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        public ExifTag(int i, int i2, int i3, String str) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }
    }
}
