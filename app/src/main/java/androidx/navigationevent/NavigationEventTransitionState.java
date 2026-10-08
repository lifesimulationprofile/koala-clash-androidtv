package androidx.navigationevent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationEventTransitionState {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Idle extends NavigationEventTransitionState {
        public static final Idle INSTANCE = new Idle();

        public final String toString() {
            return "Idle()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class InProgress extends NavigationEventTransitionState {
        public final NavigationEvent latestEvent;

        public InProgress(NavigationEvent navigationEvent) {
            this.latestEvent = navigationEvent;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && InProgress.class == obj.getClass() && Intrinsics.areEqual(this.latestEvent, ((InProgress) obj).latestEvent);
        }

        public final int hashCode() {
            return this.latestEvent.hashCode() - 31;
        }

        public final String toString() {
            return "InProgress(latestEvent=" + this.latestEvent + ", direction=-1)";
        }
    }
}
