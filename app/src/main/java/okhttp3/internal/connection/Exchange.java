package okhttp3.internal.connection;

import android.content.Context;
import android.media.Image;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.LongSparseArray;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HitPathTracker;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import coil.memory.MemoryCacheService;
import coil.request.RequestService;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzad;
import com.google.android.gms.internal.mlkit_common.zzaf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzak;
import com.google.android.gms.internal.mlkit_vision_barcode.zzal;
import com.google.android.gms.internal.mlkit_vision_barcode.zzam;
import com.google.android.gms.internal.mlkit_vision_barcode.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode.zzc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.internal.zzb;
import com.google.mlkit.vision.barcode.internal.zzm;
import com.google.mlkit.vision.common.InputImage;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import okhttp3.ConnectionPool;
import okhttp3.Response;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Exchange implements zzm {
    public Object call;
    public Object codec;
    public Object connection;
    public Object finder;
    public boolean hasFailure;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ResponseBodySource extends ForwardingSource {
        public long bytesReceived;
        public boolean closed;
        public boolean completed;
        public final long contentLength;
        public boolean invokeStartEvent;

        public ResponseBodySource(Source source, long j) {
            super(source);
            this.contentLength = j;
            this.invokeStartEvent = true;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // okio.ForwardingSource, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            if (iOException == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
            }
            Exchange exchange = Exchange.this;
            if (iOException != null) {
                exchange.trackFailure(iOException);
            }
            return ((RealCall) exchange.call).messageDone$okhttp(exchange, false, true, iOException);
        }

        @Override // okio.Source
        public final long read(long j, Buffer buffer) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            try {
                long j2 = this.delegate.read(j, buffer);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                }
                if (j2 == -1) {
                    complete(null);
                    return -1L;
                }
                long j3 = this.bytesReceived + j2;
                long j4 = this.contentLength;
                if (j4 == -1 || j3 <= j4) {
                    this.bytesReceived = j3;
                    if (j3 == j4) {
                        complete(null);
                    }
                    return j2;
                }
                throw new ProtocolException("expected " + j4 + " bytes but received " + j3);
            } catch (IOException e) {
                throw complete(e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: process-BIzXfog, reason: not valid java name */
    public int m851processBIzXfog(RequestService requestService, AndroidComposeView androidComposeView, boolean z) {
        int i;
        Object[] objArr;
        int i2;
        int i3;
        HitPathTracker hitPathTracker = (HitPathTracker) this.finder;
        HitTestResult hitTestResult = (HitTestResult) this.connection;
        if (this.hasFailure) {
            return 0;
        }
        try {
            this.hasFailure = true;
            RequestService requestServiceProduce = ((MemoryCacheService) this.codec).produce(requestService, androidComposeView);
            LongSparseArray longSparseArray = (LongSparseArray) requestServiceProduce.systemCallbacks;
            int size = longSparseArray.size();
            while (true) {
                if (i >= size) {
                    objArr = true;
                    break;
                }
                PointerInputChange pointerInputChange = (PointerInputChange) longSparseArray.valueAt(i);
                i = (pointerInputChange.pressed || pointerInputChange.previousPressed) ? 0 : i + 1;
                objArr = false;
                break;
            }
            int size2 = longSparseArray.size();
            for (int i4 = 0; i4 < size2; i4++) {
                PointerInputChange pointerInputChange2 = (PointerInputChange) longSparseArray.valueAt(i4);
                if (objArr != false || PointerId.changedToDownIgnoreConsumed(pointerInputChange2)) {
                    ((LayoutNode) this.call).m549hitTest6fMxITs$ui(pointerInputChange2.position, (HitTestResult) this.connection, pointerInputChange2.type, true);
                    if (!hitTestResult.values.isEmpty()) {
                        hitPathTracker.m507addHitPathQJqDSyo(pointerInputChange2.id, hitTestResult, PointerId.changedToDownIgnoreConsumed(pointerInputChange2));
                        hitTestResult.clear();
                    }
                }
            }
            boolean zDispatchChanges = hitPathTracker.dispatchChanges(requestServiceProduce, z);
            int size3 = longSparseArray.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size3) {
                    i2 = 0;
                    break;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) longSparseArray.valueAt(i5);
                if (!Offset.m369equalsimpl0(PointerId.positionChangeInternal(pointerInputChange3, true), 0L) && pointerInputChange3.isConsumed()) {
                    i2 = 1;
                    break;
                }
                i5++;
            }
            int size4 = longSparseArray.size();
            for (int i6 = 0; i6 < size4; i6++) {
                if (((PointerInputChange) longSparseArray.valueAt(i6)).isConsumed()) {
                    i3 = 1;
                    return (zDispatchChanges ? 1 : 0) | (i2 << 1) | (i3 << 2);
                }
            }
            i3 = 0;
            return (zDispatchChanges ? 1 : 0) | (i2 << 1) | (i3 << 2);
        } finally {
            this.hasFailure = false;
        }
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        try {
            Response.Builder responseHeaders = ((ExchangeCodec) this.codec).readResponseHeaders(z);
            if (responseHeaders == null) {
                return responseHeaders;
            }
            responseHeaders.exchange = this;
            return responseHeaders;
        } catch (IOException e) {
            trackFailure(e);
            throw e;
        }
    }

    public void trackFailure(IOException iOException) {
        this.hasFailure = true;
        ((ExchangeFinder) this.finder).trackFailure(iOException);
        RealConnection connection = ((ExchangeCodec) this.codec).getConnection();
        RealCall realCall = (RealCall) this.call;
        synchronized (connection) {
            try {
                if (!(iOException instanceof StreamResetException)) {
                    if (!(connection.http2Connection != null) || (iOException instanceof ConnectionShutdownException)) {
                        connection.noNewExchanges = true;
                        if (connection.successCount == 0) {
                            RealConnection.connectFailed$okhttp(realCall.client, connection.route, iOException);
                            connection.routeFailureCount++;
                        }
                    }
                } else if (((StreamResetException) iOException).errorCode == 8) {
                    int i = connection.refusedStreamCount + 1;
                    connection.refusedStreamCount = i;
                    if (i > 1) {
                        connection.noNewExchanges = true;
                        connection.routeFailureCount++;
                    }
                } else if (((StreamResetException) iOException).errorCode != 9 || !realCall.canceled) {
                    connection.noNewExchanges = true;
                    connection.routeFailureCount++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void update(int i, int i2) {
        if (i < 0.0f) {
            InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative (" + i + ')');
        }
        ((ParcelableSnapshotMutableIntState) this.call).setIntValue(i);
        LazyLayoutNearestRangeState lazyLayoutNearestRangeState = (LazyLayoutNearestRangeState) this.connection;
        if (i != lazyLayoutNearestRangeState.lastFirstVisibleItem) {
            lazyLayoutNearestRangeState.lastFirstVisibleItem = i;
            int i3 = (i / 30) * 30;
            lazyLayoutNearestRangeState.value$delegate.setValue(RangesKt.until(Math.max(i3 - 100, 0), i3 + 130));
        }
        ((ParcelableSnapshotMutableIntState) this.finder).setIntValue(i2);
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzm
    public ArrayList zza(InputImage inputImage) throws MlKitException {
        zzu[] zzuVarArrZze;
        if (((zzaj) this.connection) == null) {
            zzc();
        }
        zzaj zzajVar = (zzaj) this.connection;
        if (zzajVar == null) {
            throw new MlKitException("Error initializing the legacy barcode scanner.", 14);
        }
        zzan zzanVar = new zzan(inputImage.zzd, inputImage.zze, 0, MathKt.convertToMVRotation(inputImage.zzf), 0L);
        try {
            int i = inputImage.zzg;
            if (i == -1) {
                ObjectWrapper objectWrapper = new ObjectWrapper(inputImage.zza);
                Parcel parcelZza = zzajVar.zza();
                int i2 = zzc.$r8$clinit;
                parcelZza.writeStrongBinder(objectWrapper);
                parcelZza.writeInt(1);
                zzanVar.writeToParcel(parcelZza, 0);
                Parcel parcelZzb = zzajVar.zzb(parcelZza, 2);
                zzu[] zzuVarArr = (zzu[]) parcelZzb.createTypedArray(zzu.CREATOR);
                parcelZzb.recycle();
                zzuVarArrZze = zzuVarArr;
            } else if (i == 17) {
                zzuVarArrZze = zzajVar.zze(new ObjectWrapper(null), zzanVar);
            } else if (i == 35) {
                Image.Plane[] planes = inputImage.getPlanes();
                zzah.checkNotNull(planes);
                zzanVar.zza = planes[0].getRowStride();
                zzuVarArrZze = zzajVar.zze(new ObjectWrapper(planes[0].getBuffer()), zzanVar);
            } else {
                if (i != 842094169) {
                    throw new MlKitException("Unsupported image format: " + inputImage.zzg, 3);
                }
                zzuVarArrZze = zzajVar.zze(new ObjectWrapper(BouncyCastlePlatform.Companion.convertToNv21Buffer(inputImage)), zzanVar);
            }
            ArrayList arrayList = new ArrayList();
            for (zzu zzuVar : zzuVarArrZze) {
                arrayList.add(new Barcode(new ConnectionPool(zzuVar)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to detect with legacy barcode detector", e);
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzm
    public void zzb() {
        zzaj zzajVar = (zzaj) this.connection;
        if (zzajVar != null) {
            try {
                zzajVar.zzc(zzajVar.zza(), 3);
            } catch (RemoteException e) {
                Log.e("LegacyBarcodeScanner", "Failed to release legacy barcode detector.", e);
            }
            this.connection = null;
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzm
    public boolean zzc() throws MlKitException {
        zzam zzakVar;
        zzwp zzwpVar = (zzwp) this.codec;
        Context context = (Context) this.call;
        if (((zzaj) this.connection) == null) {
            try {
                IBinder iBinderInstantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.vision.dynamite").instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
                int i = zzal.$r8$clinit;
                if (iBinderInstantiate == null) {
                    zzakVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    zzakVar = iInterfaceQueryLocalInterface instanceof zzam ? (zzam) iInterfaceQueryLocalInterface : new zzak(iBinderInstantiate, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator", 2);
                }
                zzaj zzajVarZzd = ((zzak) zzakVar).zzd(new ObjectWrapper(context), (com.google.android.gms.internal.mlkit_vision_barcode.zzah) this.finder);
                this.connection = zzajVarZzd;
                if (zzajVarZzd == null && !this.hasFailure) {
                    Log.d("LegacyBarcodeScanner", "Request optional module download.");
                    Feature[] featureArr = OptionalModuleUtils.EMPTY_FEATURES;
                    zzad zzadVar = zzaf.zza;
                    Object[] objArr = {"barcode"};
                    com.google.android.gms.internal.mlkit_common.zzak.zza(1, objArr);
                    OptionalModuleUtils.requestDownload(context, new com.google.android.gms.internal.mlkit_common.zzal(1, objArr));
                    this.hasFailure = true;
                    zzb.zze(zzwpVar, zzrb.zzB);
                    throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
                }
                zzb.zze(zzwpVar, zzrb.zza);
            } catch (RemoteException e) {
                throw new MlKitException("Failed to create legacy barcode detector.", e);
            } catch (DynamiteModule.LoadingException e2) {
                throw new MlKitException("Failed to load deprecated vision dynamite module.", e2);
            }
        }
        return false;
    }
}
