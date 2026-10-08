package com.google.android.datatransport;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Priority {
    public static final /* synthetic */ Priority[] $VALUES;
    public static final Priority DEFAULT;
    public static final Priority HIGHEST;
    public static final Priority VERY_LOW;

    static {
        Priority priority = new Priority("DEFAULT", 0);
        DEFAULT = priority;
        Priority priority2 = new Priority("VERY_LOW", 1);
        VERY_LOW = priority2;
        Priority priority3 = new Priority("HIGHEST", 2);
        HIGHEST = priority3;
        $VALUES = new Priority[]{priority, priority2, priority3};
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) $VALUES.clone();
    }
}
