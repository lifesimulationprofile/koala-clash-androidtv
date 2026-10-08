package kotlinx.serialization.json.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.Log;
import android.util.Range;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.view.PreviewView;
import androidx.core.text.TextDirectionHeuristicsCompat;
import coil.memory.RealWeakMemoryCache;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class Composer implements ZoomControl.ZoomImpl {
    public final Object writer;
    public boolean writingFirst;

    public Composer(RealWeakMemoryCache realWeakMemoryCache) {
        this.writer = realWeakMemoryCache;
        this.writingFirst = true;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void addRequestOption(ImageCapture.Builder builder) {
        builder.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(1.0f));
        if (!this.writingFirst || Build.VERSION.SDK_INT < 34) {
            return;
        }
        builder.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_SETTINGS_OVERRIDE, 1);
    }

    public CameraCaptureSession.CaptureCallback createMonitorListener(CameraCaptureSession.CaptureCallback captureCallback) {
        if (!this.writingFirst) {
            return captureCallback;
        }
        CameraBurstCaptureCallback cameraBurstCaptureCallback = new CameraBurstCaptureCallback(3);
        ListenableFuture listenableFuture = (ListenableFuture) cameraBurstCaptureCallback.mCallbackMap;
        ((List) this.writer).add(listenableFuture);
        Log.d("RequestMonitor", "RequestListener " + cameraBurstCaptureCallback + " monitoring " + this);
        listenableFuture.addListener(new LiveDataObservable$$ExternalSyntheticLambda1(this, cameraBurstCaptureCallback, listenableFuture, 3), HexFormatKt.directExecutor());
        return new CaptureSession.AnonymousClass2(Arrays.asList(cameraBurstCaptureCallback, captureCallback));
    }

    public boolean defaultIsRtl() {
        return this.writingFirst;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMaxZoom() {
        return ((Float) ((Range) this.writer).getUpper()).floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMinZoom() {
        return ((Float) ((Range) this.writer).getLower()).floatValue();
    }

    public ListenableFuture getRequestsProcessedFuture() {
        List list = (List) this.writer;
        if (list.isEmpty()) {
            return ImmediateFuture$ImmediateFailedFuture.NULL_FUTURE;
        }
        ListFuture listFuture = new ListFuture(new ArrayList(new ArrayList(list)), false, HexFormatKt.directExecutor());
        ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0 = new ZslControlImpl$$ExternalSyntheticLambda0(1);
        return Futures.nonCancellationPropagating(Futures.transformAsync(listFuture, new PreviewView.AnonymousClass1(18, zslControlImpl$$ExternalSyntheticLambda0), HexFormatKt.directExecutor()));
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0039  */
    public boolean isRtl(CharSequence charSequence, int i) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        }
        TextDirectionHeuristicsCompat.FirstStrong firstStrong = (TextDirectionHeuristicsCompat.FirstStrong) this.writer;
        if (firstStrong == null) {
            return defaultIsRtl();
        }
        firstStrong.getClass();
        char c = 0;
        c = 2;
        for (int i2 = 0; i2 < i && c == 2; i2++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i2));
            Composer composer = TextDirectionHeuristicsCompat.LTR;
            if (directionality == 0) {
                c = 1;
                continue;
            } else if (directionality != 1 && directionality != 2) {
                switch (directionality) {
                    case 14:
                    case 15:
                        c = 1;
                        continue;
                    case 16:
                    case 17:
                        break;
                    default:
                        c = 2;
                        continue;
                }
            }
        }
        if (c == 0) {
            return true;
        }
        if (c != 1) {
            return defaultIsRtl();
        }
        return false;
    }

    public void nextItem() {
        this.writingFirst = false;
    }

    public void print(char c) {
        RealWeakMemoryCache realWeakMemoryCache = (RealWeakMemoryCache) this.writer;
        realWeakMemoryCache.ensureTotalCapacity(realWeakMemoryCache.operationsSinceCleanUp, 1);
        char[] cArr = (char[]) realWeakMemoryCache.cache;
        int i = realWeakMemoryCache.operationsSinceCleanUp;
        realWeakMemoryCache.operationsSinceCleanUp = i + 1;
        cArr[i] = c;
    }

    public void printQuoted(String str) {
        byte b;
        RealWeakMemoryCache realWeakMemoryCache = (RealWeakMemoryCache) this.writer;
        realWeakMemoryCache.ensureTotalCapacity(realWeakMemoryCache.operationsSinceCleanUp, str.length() + 2);
        char[] cArr = (char[]) realWeakMemoryCache.cache;
        int i = realWeakMemoryCache.operationsSinceCleanUp;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        int i4 = i2;
        while (i4 < i3) {
            char c = cArr[i4];
            byte[] bArr = StringOpsKt.ESCAPE_MARKERS;
            if (c < bArr.length && bArr[c] != 0) {
                int length2 = str.length();
                for (int i5 = i4 - i2; i5 < length2; i5++) {
                    realWeakMemoryCache.ensureTotalCapacity(i4, 2);
                    char cCharAt = str.charAt(i5);
                    byte[] bArr2 = StringOpsKt.ESCAPE_MARKERS;
                    if (cCharAt >= bArr2.length || (b = bArr2[cCharAt]) == 0) {
                        int i6 = i4 + 1;
                        ((char[]) realWeakMemoryCache.cache)[i4] = cCharAt;
                        i4 = i6;
                    } else if (b == 1) {
                        String str2 = StringOpsKt.ESCAPE_STRINGS[cCharAt];
                        realWeakMemoryCache.ensureTotalCapacity(i4, str2.length());
                        str2.getChars(0, str2.length(), (char[]) realWeakMemoryCache.cache, i4);
                        int length3 = str2.length() + i4;
                        realWeakMemoryCache.operationsSinceCleanUp = length3;
                        i4 = length3;
                    } else {
                        char[] cArr2 = (char[]) realWeakMemoryCache.cache;
                        cArr2[i4] = '\\';
                        cArr2[i4 + 1] = (char) b;
                        i4 += 2;
                        realWeakMemoryCache.operationsSinceCleanUp = i4;
                    }
                }
                realWeakMemoryCache.ensureTotalCapacity(i4, 1);
                ((char[]) realWeakMemoryCache.cache)[i4] = '\"';
                realWeakMemoryCache.operationsSinceCleanUp = i4 + 1;
                return;
            }
            i4++;
        }
        cArr[i3] = '\"';
        realWeakMemoryCache.operationsSinceCleanUp = i3 + 1;
    }

    public void setActive(boolean z) {
        if (z == this.writingFirst) {
            return;
        }
        this.writingFirst = z;
        if (z) {
            return;
        }
        synchronized (((ExposureStateImpl) this.writer).mLock) {
        }
    }

    public void stop() {
        LinkedList linkedList = new LinkedList((List) this.writer);
        while (!linkedList.isEmpty()) {
            ListenableFuture listenableFuture = (ListenableFuture) linkedList.poll();
            Objects.requireNonNull(listenableFuture);
            listenableFuture.cancel(true);
        }
    }

    public Composer(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean z = false;
        this.writingFirst = false;
        this.writer = (Range) cameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        if (Build.VERSION.SDK_INT >= 34) {
            int[] iArr = (int[]) ((CameraCharacteristics) cameraCharacteristicsCompat.mCameraCharacteristicsImpl.this$0).get(CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES);
            if (iArr != null) {
                for (int i : iArr) {
                    if (i == 1) {
                        z = true;
                        break;
                    }
                }
            }
        }
        this.writingFirst = z;
    }

    public void print(String str) {
        ((RealWeakMemoryCache) this.writer).write(str);
    }

    public void print(byte b) {
        ((RealWeakMemoryCache) this.writer).write(String.valueOf(b));
    }

    public void print(short s) {
        ((RealWeakMemoryCache) this.writer).write(String.valueOf(s));
    }

    public void print(int i) {
        ((RealWeakMemoryCache) this.writer).write(String.valueOf(i));
    }

    public void print(long j) {
        ((RealWeakMemoryCache) this.writer).write(String.valueOf(j));
    }

    public Composer(Executor executor) {
        Quirks quirks = DeviceQuirks.sQuirks;
        if (DeviceQuirks.sQuirks.get(LowMemoryQuirk.class) != null) {
            new SequentialExecutor(executor);
        }
        this.writer = quirks;
        this.writingFirst = quirks.contains(IncorrectJpegMetadataQuirk.class);
    }

    public Composer(boolean z) {
        this.writer = Collections.synchronizedList(new ArrayList());
        this.writingFirst = z;
    }

    public Composer(Camera2CameraControlImpl camera2CameraControlImpl) {
        this.writingFirst = false;
        this.writer = new ExposureStateImpl(0);
    }

    public Composer(TextDirectionHeuristicsCompat.FirstStrong firstStrong, boolean z) {
        this.writer = firstStrong;
        this.writingFirst = z;
    }

    public Composer(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        this.writer = bottomSheetBehavior;
        this.writingFirst = z;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void resetZoom() {
    }

    public void space() {
    }

    public void unIndent() {
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void onCaptureResult(TotalCaptureResult totalCaptureResult) {
    }
}
