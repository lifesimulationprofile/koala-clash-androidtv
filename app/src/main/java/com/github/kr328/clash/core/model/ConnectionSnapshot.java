package com.github.kr328.clash.core.model;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionSnapshot {
    public final List connections;
    public final long downloadTotal;
    public final long memory;
    public final long uploadTotal;
    public static final Companion Companion = new Companion();
    public static final KSerializer[] $childSerializers = {null, null, new ArrayListSerializer(ConnectionInfo$$serializer.INSTANCE), null};

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public final KSerializer serializer() {
            return ConnectionSnapshot$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ConnectionSnapshot(int i, long j, long j2, List list, long j3) {
        if ((i & 1) == 0) {
            this.downloadTotal = 0L;
        } else {
            this.downloadTotal = j;
        }
        if ((i & 2) == 0) {
            this.uploadTotal = 0L;
        } else {
            this.uploadTotal = j2;
        }
        if ((i & 4) == 0) {
            this.connections = EmptyList.INSTANCE;
        } else {
            this.connections = list;
        }
        if ((i & 8) == 0) {
            this.memory = 0L;
        } else {
            this.memory = j3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionSnapshot)) {
            return false;
        }
        ConnectionSnapshot connectionSnapshot = (ConnectionSnapshot) obj;
        return this.downloadTotal == connectionSnapshot.downloadTotal && this.uploadTotal == connectionSnapshot.uploadTotal && Intrinsics.areEqual(this.connections, connectionSnapshot.connections) && this.memory == connectionSnapshot.memory;
    }

    public final int hashCode() {
        long j = this.downloadTotal;
        long j2 = this.uploadTotal;
        int iHashCode = (this.connections.hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31;
        long j3 = this.memory;
        return iHashCode + ((int) (j3 ^ (j3 >>> 32)));
    }

    public final String toString() {
        return "ConnectionSnapshot(downloadTotal=" + this.downloadTotal + ", uploadTotal=" + this.uploadTotal + ", connections=" + this.connections + ", memory=" + this.memory + ")";
    }
}
