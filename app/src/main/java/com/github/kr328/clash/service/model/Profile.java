package com.github.kr328.clash.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import com.github.kr328.clash.service.util.UUIDSerializer;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.Platform_commonKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Profile implements Parcelable {
    public final boolean active;
    public final String announce;
    public final long download;
    public final long expire;
    public final long interval;
    public final boolean modeSwitchAllowed;
    public final String name;
    public final String profileImagePath;
    public final String source;
    public final String supportURL;
    public final long total;
    public final Type type;
    public final long updatedAt;
    public final long upload;
    public final UUID uuid;
    public static final CREATOR CREATOR = new CREATOR();
    public static final KSerializer[] $childSerializers = {new UUIDSerializer(), null, new EnumSerializer("com.github.kr328.clash.service.model.Profile.Type", Type.values()), null, null, null, null, null, null, null, null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CREATOR implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Profile[i];
        }

        public final KSerializer serializer() {
            return Profile$$serializer.INSTANCE;
        }

        @Override // android.os.Parcelable.Creator
        public final Profile createFromParcel(Parcel parcel) {
            return (Profile) serializer().deserialize(new Parcelizer$ParcelDecoder(parcel, 0));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static final Type External;
        public static final Type File;
        public static final Type Url;

        static {
            Type type = new Type("File", 0);
            File = type;
            Type type2 = new Type("Url", 1);
            Url = type2;
            Type type3 = new Type("External", 2);
            External = type3;
            $VALUES = new Type[]{type, type2, type3};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public /* synthetic */ Profile(int i, UUID uuid, String str, Type type, String str2, boolean z, long j, long j2, long j3, long j4, long j5, long j6, String str3, String str4, String str5, boolean z2) {
        if (2047 != (i & 2047)) {
            Platform_commonKt.throwMissingFieldException(i, 2047, Profile$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.uuid = uuid;
        this.name = str;
        this.type = type;
        this.source = str2;
        this.active = z;
        this.interval = j;
        this.upload = j2;
        this.download = j3;
        this.total = j4;
        this.expire = j5;
        this.updatedAt = j6;
        if ((i & 2048) == 0) {
            this.profileImagePath = null;
        } else {
            this.profileImagePath = str3;
        }
        if ((i & 4096) == 0) {
            this.announce = null;
        } else {
            this.announce = str4;
        }
        if ((i & 8192) == 0) {
            this.supportURL = null;
        } else {
            this.supportURL = str5;
        }
        this.modeSwitchAllowed = (i & 16384) == 0 ? true : z2;
    }

    public static Profile copy$default(Profile profile, String str, String str2, long j, int i) {
        return new Profile(profile.uuid, (i & 2) != 0 ? profile.name : str, profile.type, (i & 8) != 0 ? profile.source : str2, profile.active, (i & 32) != 0 ? profile.interval : j, profile.upload, profile.download, profile.total, profile.expire, profile.updatedAt, profile.profileImagePath, profile.announce, profile.supportURL, profile.modeSwitchAllowed);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        return Intrinsics.areEqual(this.uuid, profile.uuid) && Intrinsics.areEqual(this.name, profile.name) && this.type == profile.type && Intrinsics.areEqual(this.source, profile.source) && this.active == profile.active && this.interval == profile.interval && this.upload == profile.upload && this.download == profile.download && this.total == profile.total && this.expire == profile.expire && this.updatedAt == profile.updatedAt && Intrinsics.areEqual(this.profileImagePath, profile.profileImagePath) && Intrinsics.areEqual(this.announce, profile.announce) && Intrinsics.areEqual(this.supportURL, profile.supportURL) && this.modeSwitchAllowed == profile.modeSwitchAllowed;
    }

    public final int hashCode() {
        int iM = Modifier.CC.m((this.type.hashCode() + Modifier.CC.m(this.uuid.hashCode() * 31, 31, this.name)) * 31, 31, this.source);
        int i = this.active ? 1231 : 1237;
        long j = this.interval;
        int i2 = (((iM + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.upload;
        int i3 = (i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.download;
        int i4 = (i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.total;
        int i5 = (i4 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.expire;
        int i6 = (i5 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.updatedAt;
        int i7 = (i6 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        String str = this.profileImagePath;
        int iHashCode = (i7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.announce;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.supportURL;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.modeSwitchAllowed ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Profile(uuid=");
        sb.append(this.uuid);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", source=");
        sb.append(this.source);
        sb.append(", active=");
        sb.append(this.active);
        sb.append(", interval=");
        sb.append(this.interval);
        sb.append(", upload=");
        sb.append(this.upload);
        sb.append(", download=");
        sb.append(this.download);
        sb.append(", total=");
        sb.append(this.total);
        sb.append(", expire=");
        sb.append(this.expire);
        sb.append(", updatedAt=");
        sb.append(this.updatedAt);
        sb.append(", profileImagePath=");
        Density.CC.m(sb, this.profileImagePath, ", announce=", this.announce, ", supportURL=");
        sb.append(this.supportURL);
        sb.append(", modeSwitchAllowed=");
        sb.append(this.modeSwitchAllowed);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        CREATOR.serializer().serialize(new Parcelizer$ParcelDecoder(parcel, 1), this);
    }

    public Profile(UUID uuid, String str, Type type, String str2, boolean z, long j, long j2, long j3, long j4, long j5, long j6, String str3, String str4, String str5, boolean z2) {
        this.uuid = uuid;
        this.name = str;
        this.type = type;
        this.source = str2;
        this.active = z;
        this.interval = j;
        this.upload = j2;
        this.download = j3;
        this.total = j4;
        this.expire = j5;
        this.updatedAt = j6;
        this.profileImagePath = str3;
        this.announce = str4;
        this.supportURL = str5;
        this.modeSwitchAllowed = z2;
    }
}
