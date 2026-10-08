package com.google.zxing.qrcode.encoder;

import android.view.View;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.view.ViewCompat;
import coil.ImageLoader$Builder;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.zzg;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.zxing.WriterException;
import com.google.zxing.common.ECIEncoderSet;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.nio.charset.CharsetEncoder;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MinimalEncoder {
    public int ecLevel;
    public Object encoders;
    public boolean isGS1;
    public Object stringToEncode = new zzg(24, this);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Edge {
        public final int cachedTotalSize;
        public final int characterLength;
        public final int charsetEncoderIndex;
        public final int fromPosition;
        public final Mode mode;
        public final Edge previous;

        public Edge(MinimalEncoder minimalEncoder, Mode mode, int i, int i2, int i3, Edge edge, Version version) {
            this.mode = mode;
            this.fromPosition = i;
            Mode mode2 = Mode.BYTE;
            int i4 = (mode == mode2 || edge == null) ? i2 : edge.charsetEncoderIndex;
            this.charsetEncoderIndex = i4;
            this.characterLength = i3;
            this.previous = edge;
            boolean z = false;
            int characterCountBits = edge != null ? edge.cachedTotalSize : 0;
            if ((mode == mode2 && edge == null && i4 != 0) || (edge != null && i4 != edge.charsetEncoderIndex)) {
                z = true;
            }
            characterCountBits = (edge == null || mode != edge.mode || z) ? characterCountBits + mode.getCharacterCountBits(version) + 4 : characterCountBits;
            int iOrdinal = mode.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    characterCountBits += i3 != 1 ? 11 : 6;
                } else if (iOrdinal == 4) {
                    characterCountBits += ((String) minimalEncoder.stringToEncode).substring(i, i3 + i).getBytes(((ECIEncoderSet) minimalEncoder.encoders).encoders[i2].charset()).length * 8;
                    if (z) {
                        characterCountBits += 12;
                    }
                } else if (iOrdinal == 6) {
                    characterCountBits += 13;
                }
            } else {
                characterCountBits += i3 != 1 ? i3 == 2 ? 7 : 10 : 4;
            }
            this.cachedTotalSize = characterCountBits;
        }
    }

    public MinimalEncoder(BottomSheetBehavior bottomSheetBehavior) {
        this.encoders = bottomSheetBehavior;
    }

    public static void addEdge(Edge[][][] edgeArr, int i, Edge edge) {
        Edge[] edgeArr2 = edgeArr[i + edge.characterLength][edge.charsetEncoderIndex];
        Mode mode = edge.mode;
        int iOrdinal = mode.ordinal();
        char c = 2;
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                c = 1;
            } else if (iOrdinal == 4) {
                c = 3;
            } else {
                if (iOrdinal != 6) {
                    throw new IllegalStateException("Illegal mode " + mode);
                }
                c = 0;
            }
        }
        Edge edge2 = edgeArr2[c];
        if (edge2 == null || edge2.cachedTotalSize > edge.cachedTotalSize) {
            edgeArr2[c] = edge;
        }
    }

    public static boolean canEncode(Mode mode, char c) {
        int iOrdinal = mode.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                if ((c < '`' ? Encoder.ALPHANUMERIC_TABLE[c] : -1) == -1) {
                    return false;
                }
            } else if (iOrdinal != 4) {
                if (iOrdinal != 6) {
                    return false;
                }
                return Encoder.isOnlyDoubleByteKanji(String.valueOf(c));
            }
        } else if (c < '0' || c > '9') {
            return false;
        }
        return true;
    }

    public static Version getVersion(int i) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal != 0) {
            return iOrdinal != 1 ? Version.getVersionForNumber(40) : Version.getVersionForNumber(26);
        }
        return Version.getVersionForNumber(9);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0031  */
    public void addEdges(Version version, Edge[][][] edgeArr, int i, Edge edge) {
        int i2;
        String str = (String) this.stringToEncode;
        ECIEncoderSet eCIEncoderSet = (ECIEncoderSet) this.encoders;
        CharsetEncoder[] charsetEncoderArr = eCIEncoderSet.encoders;
        CharsetEncoder[] charsetEncoderArr2 = eCIEncoderSet.encoders;
        int length = charsetEncoderArr.length;
        int i3 = eCIEncoderSet.priorityEncoderIndex;
        if (i3 >= 0) {
            char cCharAt = str.charAt(i);
            if (charsetEncoderArr2[i3].canEncode("" + cCharAt)) {
                length = i3 + 1;
            } else {
                i3 = 0;
            }
        } else {
            i3 = 0;
        }
        int i4 = length;
        for (int i5 = i3; i5 < i4; i5++) {
            char cCharAt2 = str.charAt(i);
            if (charsetEncoderArr2[i5].canEncode("" + cCharAt2)) {
                addEdge(edgeArr, i, new Edge(this, Mode.BYTE, i, i5, 1, edge, version));
            }
        }
        char cCharAt3 = str.charAt(i);
        Mode mode = Mode.KANJI;
        if (canEncode(mode, cCharAt3)) {
            addEdge(edgeArr, i, new Edge(this, mode, i, 0, 1, edge, version));
        }
        int length2 = str.length();
        char cCharAt4 = str.charAt(i);
        Mode mode2 = Mode.ALPHANUMERIC;
        int i6 = 2;
        if (canEncode(mode2, cCharAt4)) {
            int i7 = i + 1;
            addEdge(edgeArr, i, new Edge(this, mode2, i, 0, (i7 >= length2 || !canEncode(mode2, str.charAt(i7))) ? 1 : 2, edge, version));
        }
        char cCharAt5 = str.charAt(i);
        Mode mode3 = Mode.NUMERIC;
        if (canEncode(mode3, cCharAt5)) {
            int i8 = i + 1;
            if (i8 >= length2 || !canEncode(mode3, str.charAt(i8))) {
                i2 = 1;
            } else {
                int i9 = i + 2;
                if (i9 < length2 && canEncode(mode3, str.charAt(i9))) {
                    i6 = 3;
                }
                i2 = i6;
            }
            addEdge(edgeArr, i, new Edge(this, mode3, i, 0, i2, edge, version));
        }
    }

    public MinimalEncoder build() {
        zzah.checkArgument("execute parameter required", ((RemoteCall) this.stringToEncode) != null);
        Feature[] featureArr = (Feature[]) this.encoders;
        boolean z = this.isGS1;
        int i = this.ecLevel;
        MinimalEncoder minimalEncoder = new MinimalEncoder();
        minimalEncoder.encoders = this;
        minimalEncoder.stringToEncode = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        minimalEncoder.isGS1 = z2;
        minimalEncoder.ecLevel = i;
        return minimalEncoder;
    }

    public void continueSettlingToState(int i) {
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.encoders;
        WeakReference weakReference = bottomSheetBehavior.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ecLevel = i;
        if (this.isGS1) {
            return;
        }
        View view = (View) bottomSheetBehavior.viewRef.get();
        zzg zzgVar = (zzg) this.stringToEncode;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        view.postOnAnimation(zzgVar);
        this.isGS1 = true;
    }

    public ImageLoader$Builder encodeSpecificVersion(Version version) throws WriterException {
        int i;
        String str = (String) this.stringToEncode;
        int length = str.length();
        ECIEncoderSet eCIEncoderSet = (ECIEncoderSet) this.encoders;
        CharsetEncoder[] charsetEncoderArr = eCIEncoderSet.encoders;
        CharsetEncoder[] charsetEncoderArr2 = eCIEncoderSet.encoders;
        Edge[][][] edgeArr = (Edge[][][]) Array.newInstance((Class<?>) Edge.class, length + 1, charsetEncoderArr.length, 4);
        addEdges(version, edgeArr, 0, null);
        for (int i2 = 1; i2 <= length; i2++) {
            for (int i3 = 0; i3 < charsetEncoderArr2.length; i3++) {
                for (int i4 = 0; i4 < 4; i4++) {
                    Edge edge = edgeArr[i2][i3][i4];
                    if (edge != null && i2 < length) {
                        addEdges(version, edgeArr, i2, edge);
                    }
                }
            }
        }
        int i5 = -1;
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        for (int i8 = 0; i8 < charsetEncoderArr2.length; i8++) {
            for (int i9 = 0; i9 < 4; i9++) {
                Edge edge2 = edgeArr[length][i8][i9];
                if (edge2 != null && (i = edge2.cachedTotalSize) < i6) {
                    i5 = i8;
                    i7 = i9;
                    i6 = i;
                }
            }
        }
        if (i5 >= 0) {
            return new ImageLoader$Builder(this, version, edgeArr[length][i5][i7]);
        }
        throw new WriterException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Internal error: failed to encode \"", str, "\""));
    }
}
