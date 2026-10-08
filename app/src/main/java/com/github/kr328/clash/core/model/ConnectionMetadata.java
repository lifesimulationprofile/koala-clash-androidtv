package com.github.kr328.clash.core.model;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionMetadata {
    public static final Companion Companion = new Companion();
    public final String destinationIP;
    public final String destinationPort;
    public final String host;
    public final String inboundName;
    public final String network;
    public final String process;
    public final String processPath;
    public final String remoteDestination;
    public final String sniffHost;
    public final String sourceIP;
    public final String sourcePort;
    public final String type;
    public final int uid;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public final KSerializer serializer() {
            return ConnectionMetadata$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ConnectionMetadata(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10, String str11, String str12) {
        if ((i & 1) == 0) {
            this.network = "";
        } else {
            this.network = str;
        }
        if ((i & 2) == 0) {
            this.type = "";
        } else {
            this.type = str2;
        }
        if ((i & 4) == 0) {
            this.sourceIP = "";
        } else {
            this.sourceIP = str3;
        }
        if ((i & 8) == 0) {
            this.destinationIP = "";
        } else {
            this.destinationIP = str4;
        }
        if ((i & 16) == 0) {
            this.sourcePort = "";
        } else {
            this.sourcePort = str5;
        }
        if ((i & 32) == 0) {
            this.destinationPort = "";
        } else {
            this.destinationPort = str6;
        }
        if ((i & 64) == 0) {
            this.host = "";
        } else {
            this.host = str7;
        }
        if ((i & 128) == 0) {
            this.process = "";
        } else {
            this.process = str8;
        }
        if ((i & 256) == 0) {
            this.processPath = "";
        } else {
            this.processPath = str9;
        }
        if ((i & 512) == 0) {
            this.uid = 0;
        } else {
            this.uid = i2;
        }
        if ((i & 1024) == 0) {
            this.remoteDestination = "";
        } else {
            this.remoteDestination = str10;
        }
        if ((i & 2048) == 0) {
            this.sniffHost = "";
        } else {
            this.sniffHost = str11;
        }
        if ((i & 4096) == 0) {
            this.inboundName = "";
        } else {
            this.inboundName = str12;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionMetadata)) {
            return false;
        }
        ConnectionMetadata connectionMetadata = (ConnectionMetadata) obj;
        return Intrinsics.areEqual(this.network, connectionMetadata.network) && Intrinsics.areEqual(this.type, connectionMetadata.type) && Intrinsics.areEqual(this.sourceIP, connectionMetadata.sourceIP) && Intrinsics.areEqual(this.destinationIP, connectionMetadata.destinationIP) && Intrinsics.areEqual(this.sourcePort, connectionMetadata.sourcePort) && Intrinsics.areEqual(this.destinationPort, connectionMetadata.destinationPort) && Intrinsics.areEqual(this.host, connectionMetadata.host) && Intrinsics.areEqual(this.process, connectionMetadata.process) && Intrinsics.areEqual(this.processPath, connectionMetadata.processPath) && this.uid == connectionMetadata.uid && Intrinsics.areEqual(this.remoteDestination, connectionMetadata.remoteDestination) && Intrinsics.areEqual(this.sniffHost, connectionMetadata.sniffHost) && Intrinsics.areEqual(this.inboundName, connectionMetadata.inboundName);
    }

    public final int hashCode() {
        return this.inboundName.hashCode() + Modifier.CC.m(Modifier.CC.m((Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(this.network.hashCode() * 31, 31, this.type), 31, this.sourceIP), 31, this.destinationIP), 31, this.sourcePort), 31, this.destinationPort), 31, this.host), 31, this.process), 31, this.processPath) + this.uid) * 31, 31, this.remoteDestination), 31, this.sniffHost);
    }

    public final String toString() {
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("ConnectionMetadata(network=", this.network, ", type=", this.type, ", sourceIP=");
        Density.CC.m(sbM, this.sourceIP, ", destinationIP=", this.destinationIP, ", sourcePort=");
        Density.CC.m(sbM, this.sourcePort, ", destinationPort=", this.destinationPort, ", host=");
        Density.CC.m(sbM, this.host, ", process=", this.process, ", processPath=");
        sbM.append(this.processPath);
        sbM.append(", uid=");
        sbM.append(this.uid);
        sbM.append(", remoteDestination=");
        Density.CC.m(sbM, this.remoteDestination, ", sniffHost=", this.sniffHost, ", inboundName=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sbM, this.inboundName, ")");
    }
}
