package com.github.kr328.clash.compose.qrcode;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class QrServerState {
    public static final /* synthetic */ QrServerState[] $VALUES;
    public static final QrServerState ProfileError;
    public static final QrServerState Ready;
    public static final QrServerState Received;
    public static final QrServerState ServerError;
    public static final QrServerState Starting;

    static {
        QrServerState qrServerState = new QrServerState("Starting", 0);
        Starting = qrServerState;
        QrServerState qrServerState2 = new QrServerState("Ready", 1);
        Ready = qrServerState2;
        QrServerState qrServerState3 = new QrServerState("Received", 2);
        Received = qrServerState3;
        QrServerState qrServerState4 = new QrServerState("ServerError", 3);
        ServerError = qrServerState4;
        QrServerState qrServerState5 = new QrServerState("ProfileError", 4);
        ProfileError = qrServerState5;
        $VALUES = new QrServerState[]{qrServerState, qrServerState2, qrServerState3, qrServerState4, qrServerState5};
    }

    public static QrServerState valueOf(String str) {
        return (QrServerState) Enum.valueOf(QrServerState.class, str);
    }

    public static QrServerState[] values() {
        return (QrServerState[]) $VALUES.clone();
    }
}
