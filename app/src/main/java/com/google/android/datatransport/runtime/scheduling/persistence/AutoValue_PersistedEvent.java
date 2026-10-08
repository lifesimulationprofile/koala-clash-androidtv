package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_PersistedEvent {
    public final AutoValue_EventInternal event;
    public final long id;
    public final AutoValue_TransportContext transportContext;

    public AutoValue_PersistedEvent(long j, AutoValue_TransportContext autoValue_TransportContext, AutoValue_EventInternal autoValue_EventInternal) {
        this.id = j;
        this.transportContext = autoValue_TransportContext;
        this.event = autoValue_EventInternal;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_PersistedEvent) {
            AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) obj;
            if (this.id == autoValue_PersistedEvent.id && this.transportContext.equals(autoValue_PersistedEvent.transportContext) && this.event.equals(autoValue_PersistedEvent.event)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.id;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.transportContext.hashCode()) * 1000003) ^ this.event.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.id + ", transportContext=" + this.transportContext + ", event=" + this.event + "}";
    }
}
