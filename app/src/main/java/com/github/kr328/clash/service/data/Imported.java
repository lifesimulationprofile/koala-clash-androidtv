package com.github.kr328.clash.service.data;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import com.github.kr328.clash.service.model.Profile;
import java.util.Arrays;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Imported {
    public final String announce;
    public final long createdAt;
    public final long download;
    public final long expire;
    public final long interval;
    public final boolean modeSwitchAllowed;
    public final String name;
    public final byte[] profileImage;
    public final String source;
    public final String supportURL;
    public final long total;
    public final Profile.Type type;
    public final long updatedAt;
    public final long upload;
    public final UUID uuid;

    public /* synthetic */ Imported(UUID uuid, String str, Profile.Type type, String str2, long j, long j2, long j3) {
        this(uuid, str, type, str2, j, 0L, 0L, 0L, 0L, j2, j3, null, null, null, true);
    }

    public static Imported copy$default(Imported imported, String str, String str2, long j, long j2, long j3, long j4, long j5, long j6, String str3, String str4, byte[] bArr, boolean z, int i) {
        return new Imported(imported.uuid, str, imported.type, (i & 8) != 0 ? imported.source : str2, (i & 16) != 0 ? imported.interval : j, j2, j3, j4, j5, imported.createdAt, j6, str3, str4, bArr, z);
    }

    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Imported)) {
            return false;
        }
        Imported imported = (Imported) obj;
        if (Intrinsics.areEqual(this.uuid, imported.uuid) && Intrinsics.areEqual(this.name, imported.name) && this.type == imported.type && Intrinsics.areEqual(this.source, imported.source) && this.interval == imported.interval && this.upload == imported.upload && this.download == imported.download && this.total == imported.total && this.expire == imported.expire && this.createdAt == imported.createdAt && this.updatedAt == imported.updatedAt && Intrinsics.areEqual(this.announce, imported.announce) && Intrinsics.areEqual(this.supportURL, imported.supportURL)) {
            byte[] bArr = imported.profileImage;
            byte[] bArr2 = this.profileImage;
            if (bArr2 == null && bArr == null) {
                zEquals = true;
            } else {
                zEquals = (bArr2 == null || bArr == null) ? false : Arrays.equals(bArr2, bArr);
            }
            if (zEquals && this.modeSwitchAllowed == imported.modeSwitchAllowed) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iM = Modifier.CC.m((this.type.hashCode() + Modifier.CC.m(this.uuid.hashCode() * 31, 31, this.name)) * 31, 31, this.source);
        long j = this.interval;
        int i = (iM + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.upload;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.download;
        int i3 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.total;
        int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.expire;
        int i5 = (i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.createdAt;
        int i6 = (i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.updatedAt;
        int i7 = (i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        String str = this.announce;
        int iHashCode = (i7 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.supportURL;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        byte[] bArr = this.profileImage;
        return ((iHashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + (this.modeSwitchAllowed ? 1231 : 1237);
    }

    public final String toString() {
        String string = Arrays.toString(this.profileImage);
        StringBuilder sb = new StringBuilder("Imported(uuid=");
        sb.append(this.uuid);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", source=");
        sb.append(this.source);
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
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", updatedAt=");
        sb.append(this.updatedAt);
        sb.append(", announce=");
        sb.append(this.announce);
        Density.CC.m(sb, ", supportURL=", this.supportURL, ", profileImage=", string);
        sb.append(", modeSwitchAllowed=");
        sb.append(this.modeSwitchAllowed);
        sb.append(")");
        return sb.toString();
    }

    public Imported(UUID uuid, String str, Profile.Type type, String str2, long j, long j2, long j3, long j4, long j5, long j6, long j7, String str3, String str4, byte[] bArr, boolean z) {
        this.uuid = uuid;
        this.name = str;
        this.type = type;
        this.source = str2;
        this.interval = j;
        this.upload = j2;
        this.download = j3;
        this.total = j4;
        this.expire = j5;
        this.createdAt = j6;
        this.updatedAt = j7;
        this.announce = str3;
        this.supportURL = str4;
        this.profileImage = bArr;
        this.modeSwitchAllowed = z;
    }
}
