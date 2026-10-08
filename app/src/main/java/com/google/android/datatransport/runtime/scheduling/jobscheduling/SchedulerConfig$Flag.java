package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SchedulerConfig$Flag {
    public static final /* synthetic */ SchedulerConfig$Flag[] $VALUES;
    public static final SchedulerConfig$Flag DEVICE_CHARGING;
    public static final SchedulerConfig$Flag DEVICE_IDLE;
    public static final SchedulerConfig$Flag NETWORK_UNMETERED;

    static {
        SchedulerConfig$Flag schedulerConfig$Flag = new SchedulerConfig$Flag("NETWORK_UNMETERED", 0);
        NETWORK_UNMETERED = schedulerConfig$Flag;
        SchedulerConfig$Flag schedulerConfig$Flag2 = new SchedulerConfig$Flag("DEVICE_IDLE", 1);
        DEVICE_IDLE = schedulerConfig$Flag2;
        SchedulerConfig$Flag schedulerConfig$Flag3 = new SchedulerConfig$Flag("DEVICE_CHARGING", 2);
        DEVICE_CHARGING = schedulerConfig$Flag3;
        $VALUES = new SchedulerConfig$Flag[]{schedulerConfig$Flag, schedulerConfig$Flag2, schedulerConfig$Flag3};
    }

    public static SchedulerConfig$Flag valueOf(String str) {
        return (SchedulerConfig$Flag) Enum.valueOf(SchedulerConfig$Flag.class, str);
    }

    public static SchedulerConfig$Flag[] values() {
        return (SchedulerConfig$Flag[]) $VALUES.clone();
    }
}
