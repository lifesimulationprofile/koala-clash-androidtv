package com.github.kr328.clash.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.Modifier;
import androidx.fragment.app.FragmentState;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import java.util.Date;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.Platform_commonKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogMessage implements Parcelable {
    public final Level level;
    public final String message;
    public final Date time;
    public static final Companion Companion = new Companion();
    public static final Parcelable.Creator<LogMessage> CREATOR = new FragmentState.AnonymousClass1(15);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public final KSerializer serializer() {
            return LogMessage$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Level {
        public static final /* synthetic */ Level[] $VALUES;
        public static final Object $cachedSerializer$delegate;
        public static final Companion Companion;
        public static final Level Warning;

        /* JADX INFO: Fake field, exist only in values array */
        Level EF0;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class Companion {
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
            public final KSerializer serializer() {
                return (KSerializer) Level.$cachedSerializer$delegate.getValue();
            }
        }

        static {
            Level level = new Level("Debug", 0);
            Level level2 = new Level("Info", 1);
            Level level3 = new Level("Warning", 2);
            Warning = level3;
            $VALUES = new Level[]{level, level2, level3, new Level("Error", 3), new Level("Silent", 4), new Level("Unknown", 5)};
            Companion = new Companion();
            $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(2, new ImageLoader$Builder$$ExternalSyntheticLambda2(25));
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    public /* synthetic */ LogMessage(int i, Level level, String str, Date date) {
        if (7 != (i & 7)) {
            Platform_commonKt.throwMissingFieldException(i, 7, LogMessage$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.level = level;
        this.message = str;
        this.time = date;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogMessage)) {
            return false;
        }
        LogMessage logMessage = (LogMessage) obj;
        return this.level == logMessage.level && Intrinsics.areEqual(this.message, logMessage.message) && Intrinsics.areEqual(this.time, logMessage.time);
    }

    public final int hashCode() {
        return this.time.hashCode() + Modifier.CC.m(this.level.hashCode() * 31, 31, this.message);
    }

    public final String toString() {
        return "LogMessage(level=" + this.level + ", message=" + this.message + ", time=" + this.time + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Companion.serializer().serialize(new Parcelizer$ParcelDecoder(parcel, 1), this);
    }

    public LogMessage(Level level, String str, Date date) {
        this.level = level;
        this.message = str;
        this.time = date;
    }
}
