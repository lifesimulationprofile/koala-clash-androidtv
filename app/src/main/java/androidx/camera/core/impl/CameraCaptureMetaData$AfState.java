package androidx.camera.core.impl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraCaptureMetaData$AfState {
    public static final /* synthetic */ CameraCaptureMetaData$AfState[] $VALUES;
    public static final CameraCaptureMetaData$AfState INACTIVE;
    public static final CameraCaptureMetaData$AfState LOCKED_FOCUSED;
    public static final CameraCaptureMetaData$AfState LOCKED_NOT_FOCUSED;
    public static final CameraCaptureMetaData$AfState PASSIVE_FOCUSED;
    public static final CameraCaptureMetaData$AfState PASSIVE_NOT_FOCUSED;
    public static final CameraCaptureMetaData$AfState SCANNING;
    public static final CameraCaptureMetaData$AfState UNKNOWN;

    static {
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState = new CameraCaptureMetaData$AfState("UNKNOWN", 0);
        UNKNOWN = cameraCaptureMetaData$AfState;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState2 = new CameraCaptureMetaData$AfState("INACTIVE", 1);
        INACTIVE = cameraCaptureMetaData$AfState2;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState3 = new CameraCaptureMetaData$AfState("SCANNING", 2);
        SCANNING = cameraCaptureMetaData$AfState3;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState4 = new CameraCaptureMetaData$AfState("PASSIVE_FOCUSED", 3);
        PASSIVE_FOCUSED = cameraCaptureMetaData$AfState4;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState5 = new CameraCaptureMetaData$AfState("PASSIVE_NOT_FOCUSED", 4);
        PASSIVE_NOT_FOCUSED = cameraCaptureMetaData$AfState5;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState6 = new CameraCaptureMetaData$AfState("LOCKED_FOCUSED", 5);
        LOCKED_FOCUSED = cameraCaptureMetaData$AfState6;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState7 = new CameraCaptureMetaData$AfState("LOCKED_NOT_FOCUSED", 6);
        LOCKED_NOT_FOCUSED = cameraCaptureMetaData$AfState7;
        $VALUES = new CameraCaptureMetaData$AfState[]{cameraCaptureMetaData$AfState, cameraCaptureMetaData$AfState2, cameraCaptureMetaData$AfState3, cameraCaptureMetaData$AfState4, cameraCaptureMetaData$AfState5, cameraCaptureMetaData$AfState6, cameraCaptureMetaData$AfState7};
    }

    public static CameraCaptureMetaData$AfState valueOf(String str) {
        return (CameraCaptureMetaData$AfState) Enum.valueOf(CameraCaptureMetaData$AfState.class, str);
    }

    public static CameraCaptureMetaData$AfState[] values() {
        return (CameraCaptureMetaData$AfState[]) $VALUES.clone();
    }
}
