package androidx.compose.ui.platform;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.camera.camera2.internal.ExposureStateImpl;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent;
import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory$InstanceHolder;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.zzj;
import com.google.android.gms.common.zzk;
import com.google.android.gms.common.zzm;
import com.google.android.gms.common.zzn;
import com.google.android.gms.dynamite.zze;
import javax.inject.Provider;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidUriHandler {
    public static AndroidUriHandler zza;
    public Context context;

    public /* synthetic */ AndroidUriHandler(Context context, byte b) {
        this.context = context;
    }

    public static void getInstance(Context context) {
        zzah.checkNotNull(context);
        synchronized (AndroidUriHandler.class) {
            try {
                if (zza == null) {
                    zzn.zze(context);
                    zza = new AndroidUriHandler(context, 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final zzj zza(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzjVarArr.length; i++) {
                if (zzjVarArr[i].equals(zzkVar)) {
                    return zzjVarArr[i];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0036  */
    /* JADX WARN: Code duplicated, block: B:24:0x003d  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b A[RETURN] */
    public static final boolean zzb(PackageInfo packageInfo) {
        PackageInfo packageInfo2;
        boolean z;
        zzj zzjVarZza;
        if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
                packageInfo2 = packageInfo;
            } else {
                packageInfo2 = packageInfo;
            }
            if (packageInfo != null && packageInfo2.signatures != null) {
                if (z) {
                    zzjVarZza = zza(packageInfo2, zzm.zza);
                } else {
                    zzjVarZza = zza(packageInfo2, zzm.zza[0]);
                }
                if (zzjVarZza != null) {
                    return true;
                }
            }
            return false;
        }
        packageInfo2 = null;
        z = true;
        if (packageInfo != null) {
            if (z) {
                zzjVarZza = zza(packageInfo2, zzm.zza);
            } else {
                zzjVarZza = zza(packageInfo2, zzm.zza[0]);
            }
            if (zzjVarZza != null) {
                return true;
            }
        }
        return false;
    }

    public DaggerTransportRuntimeComponent build() {
        Context context = this.context;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = new DaggerTransportRuntimeComponent();
        daggerTransportRuntimeComponent.executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory$InstanceHolder.INSTANCE);
        ExposureStateImpl exposureStateImpl = new ExposureStateImpl(context);
        daggerTransportRuntimeComponent.setApplicationContextProvider = exposureStateImpl;
        daggerTransportRuntimeComponent.metadataBackendRegistryProvider = DoubleCheck.provider(new CacheStrategy(4, exposureStateImpl, new Headers.Builder(1, exposureStateImpl)));
        Provider provider = DoubleCheck.provider(new MemoryCacheService(26, new Headers.Builder(3, daggerTransportRuntimeComponent.setApplicationContextProvider)));
        daggerTransportRuntimeComponent.sQLiteEventStoreProvider = provider;
        zze zzeVar = new zze(15);
        ExposureStateImpl exposureStateImpl2 = daggerTransportRuntimeComponent.setApplicationContextProvider;
        ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(exposureStateImpl2, provider, zzeVar, 13);
        Provider provider2 = daggerTransportRuntimeComponent.executorProvider;
        Provider provider3 = daggerTransportRuntimeComponent.metadataBackendRegistryProvider;
        daggerTransportRuntimeComponent.transportRuntimeProvider = DoubleCheck.provider(new ImageLoader$Builder(new Request(provider2, provider3, imageLoader$Builder, provider, provider, 12), new Http2Connection.Builder(exposureStateImpl2, provider3, provider, imageLoader$Builder, provider2, provider), new Dispatcher(provider2, provider, imageLoader$Builder, provider), 10));
        return daggerTransportRuntimeComponent;
    }

    public AndroidUriHandler(Context context, int i) {
        switch (i) {
            case 2:
                this.context = context.getApplicationContext();
                break;
            default:
                this.context = context.getApplicationContext();
                break;
        }
    }
}
