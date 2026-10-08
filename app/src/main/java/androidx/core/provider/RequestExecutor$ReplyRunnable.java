package androidx.core.provider;

import android.content.res.Resources;
import android.os.Handler;
import androidx.camera.core.processing.Edge;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import coil.ImageLoader$Builder;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_common.zze;
import com.google.android.gms.internal.mlkit_vision_common.zziv;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import com.google.android.gms.internal.mlkit_vision_common.zzla;
import com.google.android.gms.internal.mlkit_vision_common.zzmj;
import com.google.android.gms.internal.mlkit_vision_common.zzn;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import com.google.android.gms.internal.mlkit_vision_common.zzu;
import com.google.android.gms.tasks.zzi;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Logger;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RequestExecutor$ReplyRunnable implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public Object mCallable;
    public Object mConsumer;
    public Object mHandler;

    public /* synthetic */ RequestExecutor$ReplyRunnable() {
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        String str;
        zzu zzuVar;
        switch (this.$r8$classId) {
            case 0:
                try {
                    objCall = ((FontRequestWorker.AnonymousClass1) this.mCallable).call();
                    break;
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.mHandler).post(new zzi(7, (Edge) this.mConsumer, objCall));
                return;
            case 1:
                DefaultScheduler defaultScheduler = (DefaultScheduler) this.mCallable;
                AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.mConsumer;
                String str2 = autoValue_TransportContext.backendName;
                AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.mHandler;
                Logger logger = DefaultScheduler.LOGGER;
                try {
                    TransportBackend transportBackend = defaultScheduler.backendRegistry.get(str2);
                    if (transportBackend == null) {
                        String str3 = "Transport backend '" + str2 + "' is not registered";
                        logger.warning(str3);
                        new IllegalArgumentException(str3);
                    } else {
                        ((SQLiteEventStore) defaultScheduler.guard).runCriticalSection(new ImageLoader$Builder(defaultScheduler, autoValue_TransportContext, ((CctTransportBackend) transportBackend).decorate(autoValue_EventInternal), 12));
                    }
                    return;
                } catch (Exception e) {
                    logger.warning("Error scheduling event " + e.getMessage());
                    return;
                }
            default:
                zzmj zzmjVar = (zzmj) this.mCallable;
                CacheStrategy cacheStrategy = (CacheStrategy) this.mConsumer;
                zziv zzivVar = zziv.zzbA;
                String str4 = (String) this.mHandler;
                ImageLoader$Builder imageLoader$Builder = (ImageLoader$Builder) cacheStrategy.networkRequest;
                imageLoader$Builder.defaults = zzivVar;
                zzla zzlaVar = (zzla) imageLoader$Builder.applicationContext;
                if (zzlaVar != null) {
                    str = zzlaVar.zzd;
                    int i = zze.$r8$clinit;
                    if (str == null || str.isEmpty()) {
                        str = "NA";
                    }
                } else {
                    str = "NA";
                }
                zzky zzkyVar = new zzky();
                zzkyVar.zza = zzmjVar.zzc;
                zzkyVar.zzb = zzmjVar.zzd;
                synchronized (zzmj.class) {
                    zzuVar = zzmj.zza;
                    if (zzuVar == null) {
                        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                        Object[] objArrCopyOf = new Object[4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < locales.mImpl.size()) {
                            Locale locale = locales.mImpl.get(i2);
                            GmsLogger gmsLogger = CommonUtils.zza;
                            String languageTag = locale.toLanguageTag();
                            languageTag.getClass();
                            int i4 = i3 + 1;
                            int length = objArrCopyOf.length;
                            if (length < i4) {
                                int i5 = length + (length >> 1) + 1;
                                if (i5 < i4) {
                                    int iHighestOneBit = Integer.highestOneBit(i3);
                                    i5 = iHighestOneBit + iHighestOneBit;
                                }
                                if (i5 < 0) {
                                    i5 = Integer.MAX_VALUE;
                                }
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i5);
                            }
                            objArrCopyOf[i3] = languageTag;
                            i2++;
                            i3 = i4;
                        }
                        zzn zznVar = zzp.zza;
                        zzuVar = i3 == 0 ? zzu.zza : new zzu(i3, objArrCopyOf);
                        zzmj.zza = zzuVar;
                    }
                }
                zzkyVar.zze = zzuVar;
                zzkyVar.zzh = Boolean.TRUE;
                zzkyVar.zzd = str;
                zzkyVar.zzc = str4;
                zzkyVar.zzf = zzmjVar.zzh.isSuccessful() ? (String) zzmjVar.zzh.getResult() : zzmjVar.zzf.getMlSdkInstanceId();
                zzkyVar.zzj = 10;
                zzkyVar.zzk = Integer.valueOf(zzmjVar.zzj);
                cacheStrategy.cacheResponse = zzkyVar;
                zzmjVar.zze.zza(cacheStrategy);
                return;
        }
    }

    public RequestExecutor$ReplyRunnable(DefaultScheduler defaultScheduler, AutoValue_TransportContext autoValue_TransportContext, AutoValue_EventInternal autoValue_EventInternal) {
        this.mCallable = defaultScheduler;
        this.mConsumer = autoValue_TransportContext;
        this.mHandler = autoValue_EventInternal;
    }

    public /* synthetic */ RequestExecutor$ReplyRunnable(zzmj zzmjVar, CacheStrategy cacheStrategy, String str) {
        this.mCallable = zzmjVar;
        this.mConsumer = cacheStrategy;
        this.mHandler = str;
    }
}
