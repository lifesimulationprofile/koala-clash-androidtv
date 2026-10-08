package com.google.android.datatransport.runtime.scheduling;

import coil.ImageLoader$Builder;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultScheduler implements Scheduler {
    public static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    public final MetadataBackendRegistry backendRegistry;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final ImageLoader$Builder workScheduler;

    public DefaultScheduler(Executor executor, MetadataBackendRegistry metadataBackendRegistry, ImageLoader$Builder imageLoader$Builder, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.backendRegistry = metadataBackendRegistry;
        this.workScheduler = imageLoader$Builder;
        this.eventStore = eventStore;
        this.guard = synchronizationGuard;
    }
}
