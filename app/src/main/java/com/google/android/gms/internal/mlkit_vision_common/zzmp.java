package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import coil.ImageLoader$Builder;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportImpl;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzmp implements zzmc {
    public final Lazy zzb;
    public final zzma zzc;

    public zzmp(Context context, zzma zzmaVar) {
        this.zzc = zzmaVar;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        ImageLoader$Builder imageLoader$BuilderNewFactory = TransportRuntime.getInstance().newFactory(cCTDestination);
        if (CCTDestination.SUPPORTED_ENCODINGS.contains(new Encoding("json"))) {
            new Lazy(new zzmm(0, imageLoader$BuilderNewFactory));
        }
        this.zzb = new Lazy(new zzmm(3, imageLoader$BuilderNewFactory));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmc
    public final void zza(CacheStrategy cacheStrategy) {
        TransportImpl transportImpl = (TransportImpl) this.zzb.get();
        zzmw zzmwVar = zzmw.zza$1;
        ImageLoader$Builder imageLoader$Builder = (ImageLoader$Builder) cacheStrategy.networkRequest;
        ((zzky) cacheStrategy.cacheResponse).zzi = false;
        zzky zzkyVar = (zzky) cacheStrategy.cacheResponse;
        zzkyVar.zzg = Boolean.FALSE;
        imageLoader$Builder.applicationContext = new zzla(zzkyVar);
        try {
            zzmw.zza();
            zziy zziyVar = new zziy(imageLoader$Builder);
            ImageLoader$Builder imageLoader$Builder2 = new ImageLoader$Builder();
            zzmwVar.configure(imageLoader$Builder2);
            HashMap map = new HashMap((HashMap) imageLoader$Builder2.applicationContext);
            HashMap map2 = new HashMap((HashMap) imageLoader$Builder2.defaults);
            zzaj zzajVar = (zzaj) imageLoader$Builder2.options;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                zzak zzakVar = new zzak(byteArrayOutputStream, map, map2, zzajVar);
                ObjectEncoder objectEncoder = (ObjectEncoder) map.get(zziy.class);
                if (objectEncoder == null) {
                    throw new EncodingException("No encoder for ".concat(String.valueOf(zziy.class)));
                }
                objectEncoder.encode(zziyVar, zzakVar);
                transportImpl.send(new AutoValue_Event(byteArrayOutputStream.toByteArray(), Priority.VERY_LOW));
            } catch (IOException unused) {
            }
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
