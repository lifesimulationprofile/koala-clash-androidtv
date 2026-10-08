package com.github.kr328.clash.core.model;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionInfo {
    public static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion();
    public final List chains;
    public final long download;
    public final String id;
    public final ConnectionMetadata metadata;
    public final List providerChains;
    public final String rule;
    public final String rulePayload;
    public final String start;
    public final long upload;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public final KSerializer serializer() {
            return ConnectionInfo$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, null, null, new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer), null, null};
    }

    public /* synthetic */ ConnectionInfo(int i, String str, ConnectionMetadata connectionMetadata, long j, long j2, String str2, List list, List list2, String str3, String str4) {
        if (3 != (i & 3)) {
            Platform_commonKt.throwMissingFieldException(i, 3, ConnectionInfo$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.id = str;
        this.metadata = connectionMetadata;
        if ((i & 4) == 0) {
            this.upload = 0L;
        } else {
            this.upload = j;
        }
        if ((i & 8) == 0) {
            this.download = 0L;
        } else {
            this.download = j2;
        }
        if ((i & 16) == 0) {
            this.start = "";
        } else {
            this.start = str2;
        }
        int i2 = i & 32;
        EmptyList emptyList = EmptyList.INSTANCE;
        if (i2 == 0) {
            this.chains = emptyList;
        } else {
            this.chains = list;
        }
        if ((i & 64) == 0) {
            this.providerChains = emptyList;
        } else {
            this.providerChains = list2;
        }
        if ((i & 128) == 0) {
            this.rule = "";
        } else {
            this.rule = str3;
        }
        if ((i & 256) == 0) {
            this.rulePayload = "";
        } else {
            this.rulePayload = str4;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionInfo)) {
            return false;
        }
        ConnectionInfo connectionInfo = (ConnectionInfo) obj;
        return Intrinsics.areEqual(this.id, connectionInfo.id) && Intrinsics.areEqual(this.metadata, connectionInfo.metadata) && this.upload == connectionInfo.upload && this.download == connectionInfo.download && Intrinsics.areEqual(this.start, connectionInfo.start) && Intrinsics.areEqual(this.chains, connectionInfo.chains) && Intrinsics.areEqual(this.providerChains, connectionInfo.providerChains) && Intrinsics.areEqual(this.rule, connectionInfo.rule) && Intrinsics.areEqual(this.rulePayload, connectionInfo.rulePayload);
    }

    public final int hashCode() {
        int iHashCode = (this.metadata.hashCode() + (this.id.hashCode() * 31)) * 31;
        long j = this.upload;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.download;
        return this.rulePayload.hashCode() + Modifier.CC.m((this.providerChains.hashCode() + ((this.chains.hashCode() + Modifier.CC.m((i + ((int) (j2 ^ (j2 >>> 32)))) * 31, 31, this.start)) * 31)) * 31, 31, this.rule);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConnectionInfo(id=");
        sb.append(this.id);
        sb.append(", metadata=");
        sb.append(this.metadata);
        sb.append(", upload=");
        sb.append(this.upload);
        sb.append(", download=");
        sb.append(this.download);
        sb.append(", start=");
        sb.append(this.start);
        sb.append(", chains=");
        sb.append(this.chains);
        sb.append(", providerChains=");
        sb.append(this.providerChains);
        sb.append(", rule=");
        sb.append(this.rule);
        sb.append(", rulePayload=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.rulePayload, ")");
    }
}
