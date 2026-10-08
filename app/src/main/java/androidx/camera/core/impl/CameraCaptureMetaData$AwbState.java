package androidx.camera.core.impl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraCaptureMetaData$AwbState {
    public static final /* synthetic */ CameraCaptureMetaData$AwbState[] $VALUES;
    public static final CameraCaptureMetaData$AwbState CONVERGED;
    public static final CameraCaptureMetaData$AwbState INACTIVE;
    public static final CameraCaptureMetaData$AwbState LOCKED;
    public static final CameraCaptureMetaData$AwbState METERING;
    public static final CameraCaptureMetaData$AwbState UNKNOWN;

    static {
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState = new CameraCaptureMetaData$AwbState("UNKNOWN", 0);
        UNKNOWN = cameraCaptureMetaData$AwbState;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState2 = new CameraCaptureMetaData$AwbState("INACTIVE", 1);
        INACTIVE = cameraCaptureMetaData$AwbState2;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState3 = new CameraCaptureMetaData$AwbState("METERING", 2);
        METERING = cameraCaptureMetaData$AwbState3;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState4 = new CameraCaptureMetaData$AwbState("CONVERGED", 3);
        CONVERGED = cameraCaptureMetaData$AwbState4;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState5 = new CameraCaptureMetaData$AwbState("LOCKED", 4);
        LOCKED = cameraCaptureMetaData$AwbState5;
        $VALUES = new CameraCaptureMetaData$AwbState[]{cameraCaptureMetaData$AwbState, cameraCaptureMetaData$AwbState2, cameraCaptureMetaData$AwbState3, cameraCaptureMetaData$AwbState4, cameraCaptureMetaData$AwbState5};
    }

    public static CameraCaptureMetaData$AwbState valueOf(String str) {
        return (CameraCaptureMetaData$AwbState) Enum.valueOf(CameraCaptureMetaData$AwbState.class, str);
    }

    public static CameraCaptureMetaData$AwbState[] values() {
        return (CameraCaptureMetaData$AwbState[]) $VALUES.clone();
    }
}
