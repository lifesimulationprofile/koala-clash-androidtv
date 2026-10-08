package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzlu {
    public Object get(Class cls) {
        Provider provider = getProvider(cls);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    public abstract Provider getProvider(Class cls);

    public Set setOf(Class cls) {
        return (Set) setOfProvider(cls).get();
    }

    public abstract Provider setOfProvider(Class cls);
}
