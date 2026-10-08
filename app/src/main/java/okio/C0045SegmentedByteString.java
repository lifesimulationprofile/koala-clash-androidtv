package okio;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import java.util.Arrays;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import okio.internal.ZipFilesKt;

/* JADX INFO: renamed from: okio.SegmentedByteString, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class C0045SegmentedByteString extends ByteString {
    public final transient int[] directory;
    public final transient byte[][] segments;

    public C0045SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.data);
        this.segments = bArr;
        this.directory = iArr;
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.getSize$okio() == getSize$okio() && rangeEquals(0, byteString, getSize$okio())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public final int getSize$okio() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.segments;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr2 = bArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    public final String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public final int indexOf(int i, byte[] bArr) {
        return toByteString().indexOf(i, bArr);
    }

    @Override // okio.ByteString
    public final byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public final byte internalGet$okio(int i) {
        byte[][] bArr = this.segments;
        int length = bArr.length - 1;
        int[] iArr = this.directory;
        SegmentedByteString.checkOffsetAndCount(iArr[length], i, 1L);
        int iSegment = ZipFilesKt.segment(this, i);
        return bArr[iSegment][(i - (iSegment == 0 ? 0 : iArr[iSegment - 1])) + iArr[bArr.length + iSegment]];
    }

    @Override // okio.ByteString
    public final int lastIndexOf(byte[] bArr) {
        return toByteString().lastIndexOf(bArr);
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int i, int i2, int i3, byte[] bArr) {
        if (i < 0 || i > getSize$okio() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = ZipFilesKt.segment(this, i);
        while (i < i4) {
            int[] iArr = this.directory;
            int i5 = iSegment == 0 ? 0 : iArr[iSegment - 1];
            int i6 = iArr[iSegment] - i5;
            byte[][] bArr2 = this.segments;
            int i7 = iArr[bArr2.length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!SegmentedByteString.arrayRangeEquals(bArr2[iSegment], (i - i5) + i7, bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final ByteString substring(int i, int i2) {
        if (i2 == -1234567890) {
            i2 = getSize$okio();
        }
        if (i < 0) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "beginIndex=", " < 0").toString());
        }
        if (i2 > getSize$okio()) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i2, "endIndex=", " > length(");
            sbM.append(getSize$okio());
            sbM.append(')');
            throw new IllegalArgumentException(sbM.toString().toString());
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(Modifier.CC.m(i2, i, "endIndex=", " < beginIndex=").toString());
        }
        if (i == 0 && i2 == getSize$okio()) {
            return this;
        }
        if (i == i2) {
            return ByteString.EMPTY;
        }
        int iSegment = ZipFilesKt.segment(this, i);
        int iSegment2 = ZipFilesKt.segment(this, i2 - 1);
        int i4 = iSegment2 + 1;
        byte[][] bArr = this.segments;
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i4, bArr.length);
        byte[][] bArr2 = (byte[][]) Arrays.copyOfRange(bArr, iSegment, i4);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.directory;
        if (iSegment <= iSegment2) {
            int i5 = iSegment;
            int i6 = 0;
            while (true) {
                iArr[i6] = Math.min(iArr2[i5] - i, i3);
                int i7 = i6 + 1;
                iArr[i6 + bArr2.length] = iArr2[bArr.length + i5];
                if (i5 == iSegment2) {
                    break;
                }
                i5++;
                i6 = i7;
            }
        }
        int i8 = iSegment != 0 ? iArr2[iSegment - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i - i8) + iArr[length];
        return new C0045SegmentedByteString(bArr2, iArr);
    }

    @Override // okio.ByteString
    public final ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[getSize$okio()];
        byte[][] bArr2 = this.segments;
        int length = bArr2.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            System.arraycopy(bArr2[i], i4, bArr, i3, (i4 + i6) - i4);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public final String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public final void write$okio(Buffer buffer, int i) {
        int iSegment = ZipFilesKt.segment(this, 0);
        int i2 = 0;
        while (i2 < i) {
            int[] iArr = this.directory;
            int i3 = iSegment == 0 ? 0 : iArr[iSegment - 1];
            int i4 = iArr[iSegment] - i3;
            byte[][] bArr = this.segments;
            int i5 = iArr[bArr.length + iSegment];
            int iMin = Math.min(i, i4 + i3) - i2;
            int i6 = (i2 - i3) + i5;
            Segment segment = new Segment(bArr[iSegment], i6, i6 + iMin, true);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                segment2.prev.push(segment);
            }
            i2 += iMin;
            iSegment++;
        }
        buffer.size += (long) i;
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int i, ByteString byteString, int i2) {
        if (i >= 0 && i <= getSize$okio() - i2) {
            int i3 = i2 + i;
            int iSegment = ZipFilesKt.segment(this, i);
            int i4 = 0;
            while (i < i3) {
                int[] iArr = this.directory;
                int i5 = iSegment == 0 ? 0 : iArr[iSegment - 1];
                int i6 = iArr[iSegment] - i5;
                byte[][] bArr = this.segments;
                int i7 = iArr[bArr.length + iSegment];
                int iMin = Math.min(i3, i6 + i5) - i;
                if (byteString.rangeEquals(i4, (i - i5) + i7, iMin, bArr[iSegment])) {
                    i4 += iMin;
                    i += iMin;
                    iSegment++;
                }
            }
            return true;
        }
        return false;
    }
}
