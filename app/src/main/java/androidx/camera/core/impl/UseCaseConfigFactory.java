package androidx.camera.core.impl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface UseCaseConfigFactory {
    public static final AnonymousClass1 EMPTY_INSTANCE = new AnonymousClass1();

    /* JADX INFO: renamed from: androidx.camera.core.impl.UseCaseConfigFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements UseCaseConfigFactory {
        @Override // androidx.camera.core.impl.UseCaseConfigFactory
        public final Config getConfig(CaptureType captureType, int i) {
            return null;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CaptureType {
        public static final /* synthetic */ CaptureType[] $VALUES;
        public static final CaptureType IMAGE_ANALYSIS;
        public static final CaptureType IMAGE_CAPTURE;
        public static final CaptureType METERING_REPEATING;
        public static final CaptureType PREVIEW;
        public static final CaptureType STREAM_SHARING;
        public static final CaptureType VIDEO_CAPTURE;

        static {
            CaptureType captureType = new CaptureType("IMAGE_CAPTURE", 0);
            IMAGE_CAPTURE = captureType;
            CaptureType captureType2 = new CaptureType("PREVIEW", 1);
            PREVIEW = captureType2;
            CaptureType captureType3 = new CaptureType("IMAGE_ANALYSIS", 2);
            IMAGE_ANALYSIS = captureType3;
            CaptureType captureType4 = new CaptureType("VIDEO_CAPTURE", 3);
            VIDEO_CAPTURE = captureType4;
            CaptureType captureType5 = new CaptureType("STREAM_SHARING", 4);
            STREAM_SHARING = captureType5;
            CaptureType captureType6 = new CaptureType("METERING_REPEATING", 5);
            METERING_REPEATING = captureType6;
            $VALUES = new CaptureType[]{captureType, captureType2, captureType3, captureType4, captureType5, captureType6};
        }

        public static CaptureType valueOf(String str) {
            return (CaptureType) Enum.valueOf(CaptureType.class, str);
        }

        public static CaptureType[] values() {
            return (CaptureType[]) $VALUES.clone();
        }
    }

    Config getConfig(CaptureType captureType, int i);
}
