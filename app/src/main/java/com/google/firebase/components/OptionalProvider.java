package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OptionalProvider implements Provider {
    public volatile Provider delegate;
    public OptionalProvider$$Lambda$4 handler;

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return this.delegate.get();
    }
}
