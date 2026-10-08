package dev.chrisbanes.haze;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HazeTraversableNodeKeys {
    public static final /* synthetic */ HazeTraversableNodeKeys[] $VALUES;
    public static final HazeTraversableNodeKeys Effect;
    public static final HazeTraversableNodeKeys Source;

    static {
        HazeTraversableNodeKeys hazeTraversableNodeKeys = new HazeTraversableNodeKeys("Effect", 0);
        Effect = hazeTraversableNodeKeys;
        HazeTraversableNodeKeys hazeTraversableNodeKeys2 = new HazeTraversableNodeKeys("Source", 1);
        Source = hazeTraversableNodeKeys2;
        $VALUES = new HazeTraversableNodeKeys[]{hazeTraversableNodeKeys, hazeTraversableNodeKeys2};
    }

    public static HazeTraversableNodeKeys valueOf(String str) {
        return (HazeTraversableNodeKeys) Enum.valueOf(HazeTraversableNodeKeys.class, str);
    }

    public static HazeTraversableNodeKeys[] values() {
        return (HazeTraversableNodeKeys[]) $VALUES.clone();
    }
}
