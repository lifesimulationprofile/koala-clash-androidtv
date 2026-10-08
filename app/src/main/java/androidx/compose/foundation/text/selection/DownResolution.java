package androidx.compose.foundation.text.selection;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DownResolution {
    public static final /* synthetic */ DownResolution[] $VALUES;
    public static final DownResolution Cancel;
    public static final DownResolution Drag;
    public static final DownResolution Timeout;
    public static final DownResolution Up;

    static {
        DownResolution downResolution = new DownResolution("Up", 0);
        Up = downResolution;
        DownResolution downResolution2 = new DownResolution("Drag", 1);
        Drag = downResolution2;
        DownResolution downResolution3 = new DownResolution("Timeout", 2);
        Timeout = downResolution3;
        DownResolution downResolution4 = new DownResolution("Cancel", 3);
        Cancel = downResolution4;
        $VALUES = new DownResolution[]{downResolution, downResolution2, downResolution3, downResolution4};
    }

    public static DownResolution valueOf(String str) {
        return (DownResolution) Enum.valueOf(DownResolution.class, str);
    }

    public static DownResolution[] values() {
        return (DownResolution[]) $VALUES.clone();
    }
}
