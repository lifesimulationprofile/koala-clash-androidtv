package androidx.compose.foundation.text;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Handle {
    public static final /* synthetic */ Handle[] $VALUES;
    public static final Handle Cursor;
    public static final Handle SelectionEnd;
    public static final Handle SelectionStart;

    static {
        Handle handle = new Handle("Cursor", 0);
        Cursor = handle;
        Handle handle2 = new Handle("SelectionStart", 1);
        SelectionStart = handle2;
        Handle handle3 = new Handle("SelectionEnd", 2);
        SelectionEnd = handle3;
        $VALUES = new Handle[]{handle, handle2, handle3};
    }

    public static Handle valueOf(String str) {
        return (Handle) Enum.valueOf(Handle.class, str);
    }

    public static Handle[] values() {
        return (Handle[]) $VALUES.clone();
    }
}
