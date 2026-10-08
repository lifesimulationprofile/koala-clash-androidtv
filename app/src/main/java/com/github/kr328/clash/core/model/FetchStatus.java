package com.github.kr328.clash.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FetchStatus implements Parcelable {
    public final Action action;
    public final List args;
    public final int max;
    public final int progress;
    public static final CREATOR CREATOR = new CREATOR();
    public static final KSerializer[] $childSerializers = {new EnumSerializer("com.github.kr328.clash.core.model.FetchStatus.Action", Action.values()), new ArrayListSerializer(StringSerializer.INSTANCE), null, null};

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Action {
        public static final /* synthetic */ Action[] $VALUES;
        public static final Action FetchConfiguration;

        static {
            Action action = new Action("FetchConfiguration", 0);
            FetchConfiguration = action;
            $VALUES = new Action[]{action, new Action("FetchProviders", 1), new Action("Verifying", 2)};
        }

        public static Action valueOf(String str) {
            return (Action) Enum.valueOf(Action.class, str);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CREATOR implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return (FetchStatus) serializer().deserialize(new Parcelizer$ParcelDecoder(parcel, 0));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new FetchStatus[i];
        }

        public final KSerializer serializer() {
            return FetchStatus$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ FetchStatus(int i, Action action, List list, int i2, int i3) {
        if (15 != (i & 15)) {
            Platform_commonKt.throwMissingFieldException(i, 15, FetchStatus$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.action = action;
        this.args = list;
        this.progress = i2;
        this.max = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchStatus)) {
            return false;
        }
        FetchStatus fetchStatus = (FetchStatus) obj;
        return this.action == fetchStatus.action && Intrinsics.areEqual(this.args, fetchStatus.args) && this.progress == fetchStatus.progress && this.max == fetchStatus.max;
    }

    public final int hashCode() {
        return ((((this.args.hashCode() + (this.action.hashCode() * 31)) * 31) + this.progress) * 31) + this.max;
    }

    public final String toString() {
        return "FetchStatus(action=" + this.action + ", args=" + this.args + ", progress=" + this.progress + ", max=" + this.max + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        CREATOR.serializer().serialize(new Parcelizer$ParcelDecoder(parcel, 1), this);
    }

    public FetchStatus(List list) {
        this.action = Action.FetchConfiguration;
        this.args = list;
        this.progress = -1;
        this.max = -1;
    }
}
