package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.network.EmptyNetworkObserver;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.internal.zay;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.zzc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzym;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyo;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import kotlin.math.MathKt;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzo implements zzm {
    public static final zzdk zza;
    public boolean zzb;
    public boolean zzc;
    public boolean zzd;
    public final Context zze;
    public final BarcodeScannerOptions zzf;
    public final zzwp zzg;
    public zzyl zzh;

    static {
        zzcq zzcqVar = zzcs.zza;
        Object[] objArr = {"com.google.android.gms.vision.barcode", "com.google.android.gms.tflite_dynamite"};
        for (int i = 0; i < 2; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(ImageAnalysis$$ExternalSyntheticLambda1.m("at index ", i));
            }
        }
        zza = new zzdk(2, objArr);
    }

    public zzo(Context context, BarcodeScannerOptions barcodeScannerOptions, zzwp zzwpVar) {
        this.zze = context;
        this.zzf = barcodeScannerOptions;
        this.zzg = zzwpVar;
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzm
    public final ArrayList zza(InputImage inputImage) throws Throwable {
        ObjectWrapper objectWrapper;
        if (this.zzh == null) {
            zzc();
        }
        zzyl zzylVar = this.zzh;
        zzah.checkNotNull(zzylVar);
        if (!this.zzb) {
            try {
                zzylVar.zzc(zzylVar.zza(), 1);
                this.zzb = true;
            } catch (RemoteException e) {
                throw new MlKitException("Failed to init barcode scanner.", e);
            }
        }
        int rowStride = inputImage.zzd;
        int i = 0;
        if (inputImage.zzg == 35) {
            Image.Plane[] planes = inputImage.getPlanes();
            zzah.checkNotNull(planes);
            rowStride = planes[0].getRowStride();
        }
        int i2 = inputImage.zzg;
        int i3 = inputImage.zze;
        int iConvertToMVRotation = MathKt.convertToMVRotation(inputImage.zzf);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i4 = inputImage.zzg;
        if (i4 != -1) {
            if (i4 != 17) {
                if (i4 == 35) {
                    objectWrapper = new ObjectWrapper(inputImage.zzc != null ? (Image) inputImage.zzc.namesAndValues : null);
                } else if (i4 != 842094169) {
                    throw new MlKitException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unsupported image format: ", inputImage.zzg), 3);
                }
            }
            zzah.checkNotNull(null);
            throw null;
        }
        Bitmap bitmap = inputImage.zza;
        zzah.checkNotNull(bitmap);
        objectWrapper = new ObjectWrapper(bitmap);
        try {
            Parcel parcelZza = zzylVar.zza();
            int i5 = zzc.$r8$clinit;
            parcelZza.writeStrongBinder(objectWrapper);
            parcelZza.writeInt(1);
            int iZza = zzkp.zza(parcelZza, 20293);
            zzkp.zzc(parcelZza, 1, 4);
            parcelZza.writeInt(i2);
            zzkp.zzc(parcelZza, 2, 4);
            parcelZza.writeInt(rowStride);
            zzkp.zzc(parcelZza, 3, 4);
            parcelZza.writeInt(i3);
            zzkp.zzc(parcelZza, 4, 4);
            parcelZza.writeInt(iConvertToMVRotation);
            zzkp.zzc(parcelZza, 5, 8);
            parcelZza.writeLong(jElapsedRealtime);
            zzkp.zzb(parcelZza, iZza);
            Parcel parcelZzb = zzylVar.zzb(parcelZza, 3);
            ArrayList arrayListCreateTypedArrayList = parcelZzb.createTypedArrayList(zzyb.CREATOR);
            parcelZzb.recycle();
            ArrayList arrayList = new ArrayList();
            int size = arrayListCreateTypedArrayList.size();
            while (i < size) {
                Object obj = arrayListCreateTypedArrayList.get(i);
                i++;
                arrayList.add(new Barcode(new Headers.Builder(14, (zzyb) obj)));
            }
            return arrayList;
        } catch (RemoteException e2) {
            throw new MlKitException("Failed to run barcode scanner.", e2);
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzm
    public final void zzb() {
        zzyl zzylVar = this.zzh;
        if (zzylVar != null) {
            try {
                zzylVar.zzc(zzylVar.zza(), 2);
            } catch (RemoteException e) {
                Log.e("DecoupledBarcodeScanner", "Failed to release barcode scanner.", e);
            }
            this.zzh = null;
            this.zzb = false;
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzm
    public final boolean zzc() throws Throwable {
        boolean z;
        if (this.zzh != null) {
            return this.zzc;
        }
        Context context = this.zze;
        int localVersion = DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
        zzwp zzwpVar = this.zzg;
        if (localVersion > 0) {
            this.zzc = true;
            try {
                this.zzh = zze(DynamiteModule.PREFER_LOCAL, ModuleDescriptor.MODULE_ID, "com.google.mlkit.vision.barcode.bundled.internal.ThickBarcodeScannerCreator");
            } catch (RemoteException e) {
                throw new MlKitException("Failed to create thick barcode scanner.", e);
            } catch (DynamiteModule.LoadingException e2) {
                throw new MlKitException("Failed to load the bundled barcode module.", e2);
            }
        } else {
            this.zzc = false;
            Feature[] featureArr = OptionalModuleUtils.EMPTY_FEATURES;
            GoogleApiAvailabilityLight.zza.getClass();
            int apkVersion = GoogleApiAvailabilityLight.getApkVersion(context);
            zzdk zzdkVar = zza;
            if (apkVersion >= 221500000) {
                try {
                    zzw zzwVarAreModulesAvailable = new zay(context, zay.zae, Api$ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS).areModulesAvailable(new com.google.mlkit.common.sdkinternal.zzo(OptionalModuleUtils.zza(OptionalModuleUtils.zzb, zzdkVar), 1));
                    EmptyNetworkObserver emptyNetworkObserver = new EmptyNetworkObserver();
                    zzwVarAreModulesAvailable.getClass();
                    zzwVarAreModulesAvailable.addOnFailureListener(TaskExecutors.MAIN_THREAD, emptyNetworkObserver);
                    z = ((ModuleAvailabilityResponse) Tasks.await(zzwVarAreModulesAvailable)).zaa;
                } catch (InterruptedException | ExecutionException e3) {
                    Log.e("OptionalModuleUtils", "Failed to complete the task of features availability check", e3);
                    z = false;
                }
            } else {
                try {
                    zzcq zzcqVarListIterator = zzdkVar.listIterator(0);
                    while (zzcqVarListIterator.hasNext()) {
                        DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, (String) zzcqVarListIterator.next());
                    }
                    z = true;
                } catch (DynamiteModule.LoadingException unused) {
                    z = false;
                }
            }
            if (!z) {
                if (!this.zzd) {
                    Object[] objArr = {"barcode", "tflite_dynamite"};
                    for (int i = 0; i < 2; i++) {
                        if (objArr[i] == null) {
                            throw new NullPointerException(ImageAnalysis$$ExternalSyntheticLambda1.m("at index ", i));
                        }
                    }
                    OptionalModuleUtils.requestDownload(context, new zzdk(2, objArr));
                    this.zzd = true;
                }
                zzb.zze(zzwpVar, zzrb.zzB);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            try {
                this.zzh = zze(DynamiteModule.PREFER_REMOTE, "com.google.android.gms.vision.barcode", "com.google.android.gms.vision.barcode.mlkit.BarcodeScannerCreator");
            } catch (RemoteException | DynamiteModule.LoadingException e4) {
                zzb.zze(zzwpVar, zzrb.zzC);
                throw new MlKitException("Failed to create thin barcode scanner.", e4);
            }
        }
        zzb.zze(zzwpVar, zzrb.zza);
        return this.zzc;
    }

    public final zzyl zze(DynamiteModule.VersionPolicy versionPolicy, String str, String str2) {
        IInterface zzymVar;
        Context context = this.zze;
        IBinder iBinderInstantiate = DynamiteModule.load(context, versionPolicy, str).instantiate(str2);
        int i = zzyn.$r8$clinit;
        zzyl zzylVar = null;
        if (iBinderInstantiate == null) {
            zzymVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
            zzymVar = iInterfaceQueryLocalInterface instanceof zzyo ? (zzyo) iInterfaceQueryLocalInterface : new zzym(iBinderInstantiate, "com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator", 2);
        }
        ObjectWrapper objectWrapper = new ObjectWrapper(context);
        int i2 = this.zzf.zza;
        zzym zzymVar2 = (zzym) zzymVar;
        Parcel parcelZza = zzymVar2.zza();
        int i3 = zzc.$r8$clinit;
        parcelZza.writeStrongBinder(objectWrapper);
        parcelZza.writeInt(1);
        int iZza = zzkp.zza(parcelZza, 20293);
        zzkp.zzc(parcelZza, 1, 4);
        parcelZza.writeInt(i2);
        zzkp.zzc(parcelZza, 2, 4);
        parcelZza.writeInt(0);
        zzkp.zzb(parcelZza, iZza);
        Parcel parcelZzb = zzymVar2.zzb(parcelZza, 1);
        IBinder strongBinder = parcelZzb.readStrongBinder();
        if (strongBinder != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
            zzylVar = iInterfaceQueryLocalInterface2 instanceof zzyl ? (zzyl) iInterfaceQueryLocalInterface2 : new zzyl(strongBinder, "com.google.mlkit.vision.barcode.aidls.IBarcodeScanner", 2);
        }
        parcelZzb.recycle();
        return zzylVar;
    }
}
