package com.github.kr328.clash.service.document;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Flag {
    public static final /* synthetic */ Flag[] $VALUES;
    public static final Flag Deletable;
    public static final Flag Virtual;
    public static final Flag Writable;

    static {
        Flag flag = new Flag("Writable", 0);
        Writable = flag;
        Flag flag2 = new Flag("Deletable", 1);
        Deletable = flag2;
        Flag flag3 = new Flag("Virtual", 2);
        Virtual = flag3;
        $VALUES = new Flag[]{flag, flag2, flag3};
    }

    public static Flag valueOf(String str) {
        return (Flag) Enum.valueOf(Flag.class, str);
    }

    public static Flag[] values() {
        return (Flag[]) $VALUES.clone();
    }
}
