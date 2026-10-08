package com.google.android.datatransport;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_Event {
    public final Object payload;
    public final Priority priority;

    public AutoValue_Event(Object obj, Priority priority) {
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.payload = obj;
        this.priority = priority;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_Event) {
            AutoValue_Event autoValue_Event = (AutoValue_Event) obj;
            if (this.payload.equals(autoValue_Event.payload) && this.priority.equals(autoValue_Event.priority)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.priority.hashCode() ^ (((1000003 * 1000003) ^ this.payload.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.payload + ", priority=" + this.priority + "}";
    }
}
