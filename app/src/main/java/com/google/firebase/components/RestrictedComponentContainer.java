package com.google.firebase.components;

import coil.network.HttpException;
import com.google.android.gms.internal.mlkit_vision_common.zzlu;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RestrictedComponentContainer extends zzlu {
    public final Set allowedDirectInterfaces;
    public final Set allowedProviderInterfaces;
    public final Set allowedSetDirectInterfaces;
    public final Set allowedSetProviderInterfaces;
    public final zzlu delegateContainer;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RestrictedPublisher implements Publisher {
    }

    public RestrictedComponentContainer(Component component, zzlu zzluVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        Set<Dependency> set = component.dependencies;
        Set set2 = component.publishedEvents;
        for (Dependency dependency : set) {
            int i = dependency.injection;
            int i2 = dependency.type;
            boolean z = i == 0;
            Class cls = dependency.anInterface;
            if (z) {
                if (i2 == 2) {
                    hashSet4.add(cls);
                } else {
                    hashSet.add(cls);
                }
            } else if (i == 2) {
                hashSet3.add(cls);
            } else if (i2 == 2) {
                hashSet5.add(cls);
            } else {
                hashSet2.add(cls);
            }
        }
        if (!set2.isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.allowedDirectInterfaces = Collections.unmodifiableSet(hashSet);
        this.allowedProviderInterfaces = Collections.unmodifiableSet(hashSet2);
        Collections.unmodifiableSet(hashSet3);
        this.allowedSetDirectInterfaces = Collections.unmodifiableSet(hashSet4);
        this.allowedSetProviderInterfaces = Collections.unmodifiableSet(hashSet5);
        this.delegateContainer = zzluVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzlu
    public final Object get(Class cls) {
        if (!this.allowedDirectInterfaces.contains(cls)) {
            throw new HttpException("Attempting to request an undeclared dependency " + cls + ".");
        }
        Object obj = this.delegateContainer.get(cls);
        if (!cls.equals(Publisher.class)) {
            return obj;
        }
        return new RestrictedPublisher();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzlu
    public final Provider getProvider(Class cls) {
        if (this.allowedProviderInterfaces.contains(cls)) {
            return this.delegateContainer.getProvider(cls);
        }
        throw new HttpException("Attempting to request an undeclared dependency Provider<" + cls + ">.");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzlu
    public final Set setOf(Class cls) {
        if (this.allowedSetDirectInterfaces.contains(cls)) {
            return this.delegateContainer.setOf(cls);
        }
        throw new HttpException("Attempting to request an undeclared dependency Set<" + cls + ">.");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzlu
    public final Provider setOfProvider(Class cls) {
        if (this.allowedSetProviderInterfaces.contains(cls)) {
            return this.delegateContainer.setOfProvider(cls);
        }
        throw new HttpException("Attempting to request an undeclared dependency Provider<Set<" + cls + ">>.");
    }
}
