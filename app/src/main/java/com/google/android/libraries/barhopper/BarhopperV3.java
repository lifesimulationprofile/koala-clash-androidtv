package com.google.android.libraries.barhopper;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdk;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfu;
import com.google.barhopper.deeplearning.BarhopperV3Options;
import com.google.photos.vision.barhopper.BarhopperProto$BarhopperResponse;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class BarhopperV3 implements Closeable {
    public long nativePointer;

    private native void closeNative(long j);

    private native long createNativeWithClientOptions(byte[] bArr);

    private native byte[] recognizeBitmapNative(long j, Bitmap bitmap, RecognitionOptions recognitionOptions);

    private native byte[] recognizeBufferNative(long j, int i, int i2, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native byte[] recognizeNative(long j, int i, int i2, byte[] bArr, RecognitionOptions recognitionOptions);

    public static BarhopperProto$BarhopperResponse toProto(byte[] bArr) {
        bArr.getClass();
        try {
            zzds zzdsVar = zzds.zza;
            zzfu zzfuVar = zzfu.zzb;
            return BarhopperProto$BarhopperResponse.zzb(bArr, zzds.zza);
        } catch (zzer e) {
            throw new IllegalStateException("Received unexpected BarhopperResponse buffer: {0}", e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j = this.nativePointer;
        if (j != 0) {
            closeNative(j);
            this.nativePointer = 0L;
        }
    }

    public final void create(BarhopperV3Options barhopperV3Options) {
        if (this.nativePointer != 0) {
            Log.w("BarhopperV3", "Native pointer already exists.");
            return;
        }
        try {
            int iZzF = barhopperV3Options.zzF();
            byte[] bArr = new byte[iZzF];
            zzdk zzdkVar = new zzdk(iZzF, bArr);
            barhopperV3Options.zzab(zzdkVar);
            if (iZzF - zzdkVar.zzd != 0) {
                throw new IllegalStateException("Did not write as much data as expected.");
            }
            long jCreateNativeWithClientOptions = createNativeWithClientOptions(bArr);
            this.nativePointer = jCreateNativeWithClientOptions;
            if (jCreateNativeWithClientOptions == 0) {
                throw new IllegalArgumentException("Failed to create native pointer with client options.");
            }
        } catch (IOException e) {
            throw new RuntimeException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Serializing ", BarhopperV3Options.class.getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    public final BarhopperProto$BarhopperResponse recognize(int i, int i2, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions) {
        long j = this.nativePointer;
        if (j != 0) {
            return toProto(recognizeBufferNative(j, i, i2, byteBuffer, recognitionOptions));
        }
        throw new IllegalStateException("Native pointer does not exist.");
    }

    public final BarhopperProto$BarhopperResponse recognize(int i, int i2, byte[] bArr, RecognitionOptions recognitionOptions) {
        long j = this.nativePointer;
        if (j != 0) {
            return toProto(recognizeNative(j, i, i2, bArr, recognitionOptions));
        }
        throw new IllegalStateException("Native pointer does not exist.");
    }

    public final BarhopperProto$BarhopperResponse recognize(Bitmap bitmap, RecognitionOptions recognitionOptions) {
        if (this.nativePointer != 0) {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2) {
                Log.d("BarhopperV3", "Input bitmap config is not ARGB_8888. Converting it to ARGB_8888 from ".concat(String.valueOf(bitmap.getConfig())));
                bitmap = bitmap.copy(config2, bitmap.isMutable());
            }
            return toProto(recognizeBitmapNative(this.nativePointer, bitmap, recognitionOptions));
        }
        throw new IllegalStateException("Native pointer does not exist.");
    }
}
