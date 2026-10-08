package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import coil.ImageLoader$Builder;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.HashMap;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MetadataBackendRegistry {
    public final CacheStrategy backendFactoryProvider;
    public final HashMap backends;
    public final ImageLoader$Builder creationContextFactory;

    public MetadataBackendRegistry(Context context, ImageLoader$Builder imageLoader$Builder) {
        CacheStrategy cacheStrategy = new CacheStrategy(3, context);
        this.backends = new HashMap();
        this.backendFactoryProvider = cacheStrategy;
        this.creationContextFactory = imageLoader$Builder;
    }

    public final synchronized TransportBackend get(String str) {
        if (this.backends.containsKey(str)) {
            return (TransportBackend) this.backends.get(str);
        }
        CctBackendFactory cctBackendFactory = this.backendFactoryProvider.get(str);
        if (cctBackendFactory == null) {
            return null;
        }
        ImageLoader$Builder imageLoader$Builder = this.creationContextFactory;
        TransportBackend transportBackendCreate = cctBackendFactory.create(new AutoValue_CreationContext((Context) imageLoader$Builder.applicationContext, (Clock) imageLoader$Builder.defaults, (Clock) imageLoader$Builder.options, str));
        this.backends.put(str, transportBackendCreate);
        return transportBackendCreate;
    }
}
