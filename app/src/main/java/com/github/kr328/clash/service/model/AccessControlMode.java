package com.github.kr328.clash.service.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AccessControlMode {
    public static final /* synthetic */ AccessControlMode[] $VALUES;
    public static final AccessControlMode AcceptAll;
    public static final AccessControlMode AcceptSelected;
    public static final AccessControlMode DenySelected;

    static {
        AccessControlMode accessControlMode = new AccessControlMode("AcceptAll", 0);
        AcceptAll = accessControlMode;
        AccessControlMode accessControlMode2 = new AccessControlMode("AcceptSelected", 1);
        AcceptSelected = accessControlMode2;
        AccessControlMode accessControlMode3 = new AccessControlMode("DenySelected", 2);
        DenySelected = accessControlMode3;
        $VALUES = new AccessControlMode[]{accessControlMode, accessControlMode2, accessControlMode3};
    }

    public static AccessControlMode valueOf(String str) {
        return (AccessControlMode) Enum.valueOf(AccessControlMode.class, str);
    }

    public static AccessControlMode[] values() {
        return (AccessControlMode[]) $VALUES.clone();
    }
}
