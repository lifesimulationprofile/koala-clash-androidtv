package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SchedulerConfig {
    public final Clock clock;
    public final HashMap values;

    public AutoValue_SchedulerConfig(Clock clock, HashMap map) {
        this.clock = clock;
        this.values = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_SchedulerConfig)) {
            return false;
        }
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) obj;
        return this.clock.equals(autoValue_SchedulerConfig.clock) && this.values.equals(autoValue_SchedulerConfig.values);
    }

    public final long getScheduleDelay(Priority priority, long j, int i) {
        long time = j - this.clock.getTime();
        AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = (AutoValue_SchedulerConfig_ConfigValue) this.values.get(priority);
        long j2 = autoValue_SchedulerConfig_ConfigValue.delta;
        int i2 = i - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, i2) * j2 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j2 > 1 ? j2 : 2L) * ((long) i2)))), time), autoValue_SchedulerConfig_ConfigValue.maxAllowedDelay);
    }

    public final int hashCode() {
        return ((this.clock.hashCode() ^ 1000003) * 1000003) ^ this.values.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.clock + ", values=" + this.values + "}";
    }
}
