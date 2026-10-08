package com.github.kr328.clash.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import kotlin.LazyKt__LazyJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.Platform_commonKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TunnelState implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();
    public final Mode mode;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CREATOR implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return (TunnelState) serializer().deserialize(new Parcelizer$ParcelDecoder(parcel, 0));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new TunnelState[i];
        }

        public final KSerializer serializer() {
            return TunnelState$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Mode {
        public static final /* synthetic */ Mode[] $VALUES;
        public static final Object $cachedSerializer$delegate;
        public static final Companion Companion;
        public static final Mode Direct;
        public static final Mode Global;
        public static final Mode Rule;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class Companion {
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
            public final KSerializer serializer() {
                return (KSerializer) Mode.$cachedSerializer$delegate.getValue();
            }
        }

        static {
            Mode mode = new Mode("Direct", 0);
            Direct = mode;
            Mode mode2 = new Mode("Global", 1);
            Global = mode2;
            Mode mode3 = new Mode("Rule", 2);
            Rule = mode3;
            $VALUES = new Mode[]{mode, mode2, mode3, new Mode("Script", 3)};
            Companion = new Companion();
            $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(2, new ImageLoader$Builder$$ExternalSyntheticLambda2(26));
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    public /* synthetic */ TunnelState(int i, Mode mode) {
        if (1 == (i & 1)) {
            this.mode = mode;
        } else {
            Platform_commonKt.throwMissingFieldException(i, 1, TunnelState$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TunnelState) && this.mode == ((TunnelState) obj).mode;
    }

    public final int hashCode() {
        return this.mode.hashCode();
    }

    public final String toString() {
        return "TunnelState(mode=" + this.mode + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        CREATOR.serializer().serialize(new Parcelizer$ParcelDecoder(parcel, 1), this);
    }
}
