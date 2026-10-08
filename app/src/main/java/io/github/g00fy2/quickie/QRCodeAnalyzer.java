package io.github.g00fy2.quickie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image;
import android.os.SystemClock;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda0;
import androidx.camera.core.SettableImageProxy;
import androidx.core.provider.RequestExecutor$ReplyRunnable;
import coil.ImageLoader$Builder;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.mlkit_vision_common.zzii;
import com.google.android.gms.internal.mlkit_vision_common.zzio;
import com.google.android.gms.internal.mlkit_vision_common.zziq;
import com.google.android.gms.internal.mlkit_vision_common.zziv;
import com.google.android.gms.internal.mlkit_vision_common.zzma;
import com.google.android.gms.internal.mlkit_vision_common.zzmj;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzu;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.components.CycleDetector;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.internal.zzh;
import com.google.mlkit.vision.common.InputImage;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.SynchronizedLazyImpl;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class QRCodeAnalyzer implements ImageAnalysis.Analyzer {
    public final int[] barcodeFormats;
    public final SynchronizedLazyImpl barcodeScanner$delegate = new SynchronizedLazyImpl(new BitmapFactoryDecoder$$ExternalSyntheticLambda2(16, this));
    public boolean failureOccurred;
    public long failureTimestamp;
    public final QRScannerActivity$$ExternalSyntheticLambda0 onFailure;
    public final QRScannerActivity$$ExternalSyntheticLambda0 onPassCompleted;
    public final BlurEffectKt$$ExternalSyntheticLambda1 onSuccess;

    public QRCodeAnalyzer(int[] iArr, BlurEffectKt$$ExternalSyntheticLambda1 blurEffectKt$$ExternalSyntheticLambda1, QRScannerActivity$$ExternalSyntheticLambda0 qRScannerActivity$$ExternalSyntheticLambda0, QRScannerActivity$$ExternalSyntheticLambda0 qRScannerActivity$$ExternalSyntheticLambda1) {
        this.barcodeFormats = iArr;
        this.onSuccess = blurEffectKt$$ExternalSyntheticLambda1;
        this.onFailure = qRScannerActivity$$ExternalSyntheticLambda0;
        this.onPassCompleted = qRScannerActivity$$ExternalSyntheticLambda1;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public final void analyze(SettableImageProxy settableImageProxy) {
        InputImage inputImage;
        int iLimit;
        zzmj zzmjVarZza;
        BarcodeScanner barcodeScanner;
        zzii zziiVar;
        Bitmap bitmapCreateBitmap;
        Image image = settableImageProxy.mImage.getImage();
        if (image == null || (this.failureOccurred && System.currentTimeMillis() - this.failureTimestamp < 1000)) {
            settableImageProxy.close();
            return;
        }
        this.failureOccurred = false;
        BarcodeScanner barcodeScanner2 = (BarcodeScanner) this.barcodeScanner$delegate.getValue();
        if (barcodeScanner2 != null) {
            int rotationDegrees = settableImageProxy.mImageInfo.getRotationDegrees();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            InputImage.zza(rotationDegrees);
            zzah.checkArgument("Only JPEG and YUV_420_888 are supported now", image.getFormat() == 256 || image.getFormat() == 35);
            Image.Plane[] planes = image.getPlanes();
            if (image.getFormat() == 256) {
                iLimit = image.getPlanes()[0].getBuffer().limit();
                zzah.checkArgument("Only JPEG is supported now", image.getFormat() == 256);
                Image.Plane[] planes2 = image.getPlanes();
                if (planes2 == null || planes2.length != 1) {
                    throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
                }
                ByteBuffer buffer = planes2[0].getBuffer();
                buffer.rewind();
                int iRemaining = buffer.remaining();
                byte[] bArr = new byte[iRemaining];
                buffer.get(bArr);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, iRemaining);
                int width = bitmapDecodeByteArray.getWidth();
                int height = bitmapDecodeByteArray.getHeight();
                if (rotationDegrees == 0) {
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, width, height);
                } else {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(rotationDegrees);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, width, height, matrix, true);
                }
                inputImage = new InputImage(bitmapCreateBitmap);
            } else {
                for (Image.Plane plane : planes) {
                    if (plane.getBuffer() != null) {
                        plane.getBuffer().rewind();
                    }
                }
                inputImage = new InputImage(image, image.getWidth(), image.getHeight(), rotationDegrees);
                iLimit = (image.getPlanes()[0].getBuffer().limit() * 3) / 2;
            }
            int format = image.getFormat();
            int height2 = image.getHeight();
            int width2 = image.getWidth();
            synchronized (CycleDetector.class) {
                byte b = (byte) (((byte) 1) | 2);
                try {
                    if (b != 3) {
                        StringBuilder sb = new StringBuilder();
                        if ((b & 1) == 0) {
                            sb.append(" enableFirelog");
                        }
                        if ((b & 2) == 0) {
                            sb.append(" firelogEventType");
                        }
                        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
                    }
                    zzmjVarZza = CycleDetector.zza(new zzma());
                } catch (Throwable th) {
                    throw th;
                }
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            zziv zzivVar = zziv.zzbA;
            zzw zzwVar = zzmjVarZza.zzg;
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            HashMap map = zzmjVarZza.zzk;
            if (map.get(zzivVar) != null) {
                barcodeScanner = barcodeScanner2;
                if (jElapsedRealtime3 - ((Long) map.get(zzivVar)).longValue() > TimeUnit.SECONDS.toMillis(30L)) {
                }
                zzw zzwVarProcess = ((zzh) barcodeScanner).process(inputImage);
                OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0 = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(15, new DiskLruCache$$ExternalSyntheticLambda0(15, this));
                zzu zzuVar = TaskExecutors.MAIN_THREAD;
                zzwVarProcess.addOnSuccessListener(zzuVar, onBackPressedDispatcher$$ExternalSyntheticLambda0);
                zzwVarProcess.addOnFailureListener(zzuVar, new ImageAnalysis$$ExternalSyntheticLambda0(this));
                zzwVarProcess.zzb.zza(new com.google.android.gms.tasks.zzh(zzuVar, new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(14, this, settableImageProxy)));
                zzwVarProcess.zzi();
            }
            barcodeScanner = barcodeScanner2;
            map.put(zzivVar, Long.valueOf(jElapsedRealtime3));
            TooltipPopup tooltipPopup = new TooltipPopup();
            if (format == -1) {
                zziiVar = zzii.zzg;
            } else if (format == 35) {
                zziiVar = zzii.zze;
            } else if (format == 842094169) {
                zziiVar = zzii.zzd;
            } else if (format != 16) {
                zziiVar = format != 17 ? zzii.zza : zzii.zzc;
            } else {
                zziiVar = zzii.zzb;
            }
            tooltipPopup.mMessageView = zziiVar;
            tooltipPopup.mContentView = zzio.zzf;
            tooltipPopup.mLayoutParams = Integer.valueOf(iLimit & Integer.MAX_VALUE);
            tooltipPopup.mTmpAnchorPos = Integer.valueOf(height2 & Integer.MAX_VALUE);
            tooltipPopup.mTmpDisplayFrame = Integer.valueOf(width2 & Integer.MAX_VALUE);
            tooltipPopup.mContext = Long.valueOf(Long.MAX_VALUE & jElapsedRealtime2);
            tooltipPopup.mTmpAppPos = Integer.valueOf(rotationDegrees & Integer.MAX_VALUE);
            zziq zziqVar = new zziq(tooltipPopup);
            ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(19);
            imageLoader$Builder.options = zziqVar;
            com.google.mlkit.common.sdkinternal.zzh.zza.execute(new RequestExecutor$ReplyRunnable(zzmjVarZza, new CacheStrategy(imageLoader$Builder), zzwVar.isSuccessful() ? (String) zzwVar.getResult() : LibraryVersion.zzb.getVersion(zzmjVarZza.zzi)));
            zzw zzwVarProcess2 = ((zzh) barcodeScanner).process(inputImage);
            OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda1 = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(15, new DiskLruCache$$ExternalSyntheticLambda0(15, this));
            zzu zzuVar2 = TaskExecutors.MAIN_THREAD;
            zzwVarProcess2.addOnSuccessListener(zzuVar2, onBackPressedDispatcher$$ExternalSyntheticLambda1);
            zzwVarProcess2.addOnFailureListener(zzuVar2, new ImageAnalysis$$ExternalSyntheticLambda0(this));
            zzwVarProcess2.zzb.zza(new com.google.android.gms.tasks.zzh(zzuVar2, new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(14, this, settableImageProxy)));
            zzwVarProcess2.zzi();
        }
    }
}
