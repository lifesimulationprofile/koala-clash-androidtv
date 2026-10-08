package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazySet implements Provider {
    public volatile Set actualSet;
    public volatile Set providers;

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        if (this.actualSet == null) {
            synchronized (this) {
                try {
                    if (this.actualSet == null) {
                        this.actualSet = Collections.newSetFromMap(new ConcurrentHashMap());
                        updateSet();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Collections.unmodifiableSet(this.actualSet);
    }

    public final synchronized void updateSet() {
        try {
            Iterator it = this.providers.iterator();
            while (it.hasNext()) {
                this.actualSet.add(((Provider) it.next()).get());
            }
            this.providers = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
