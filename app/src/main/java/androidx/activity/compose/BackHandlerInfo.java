package androidx.activity.compose;

import androidx.navigationevent.NavigationEventInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BackHandlerInfo extends NavigationEventInfo {
    public final long compositeKey;
    public final Object owner;

    public BackHandlerInfo(long j, Object obj) {
        this.owner = obj;
        this.compositeKey = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackHandlerInfo)) {
            return false;
        }
        BackHandlerInfo backHandlerInfo = (BackHandlerInfo) obj;
        return Intrinsics.areEqual(this.owner, backHandlerInfo.owner) && this.compositeKey == backHandlerInfo.compositeKey;
    }

    public final int hashCode() {
        int iHashCode = this.owner.hashCode() * 31;
        long j = this.compositeKey;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "BackHandlerInfo(owner=" + this.owner + ", compositeKey=" + this.compositeKey + ')';
    }
}
