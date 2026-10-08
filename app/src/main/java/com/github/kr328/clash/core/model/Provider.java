package com.github.kr328.clash.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.Platform_commonKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Provider implements Parcelable, Comparable<Provider> {
    public final String name;
    public final Type type;
    public final long updatedAt;
    public final VehicleType vehicleType;
    public static final CREATOR CREATOR = new CREATOR();
    public static final KSerializer[] $childSerializers = {null, new EnumSerializer("com.github.kr328.clash.core.model.Provider.Type", Type.values()), new EnumSerializer("com.github.kr328.clash.core.model.Provider.VehicleType", VehicleType.values()), null};

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CREATOR implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return (Provider) serializer().deserialize(new Parcelizer$ParcelDecoder(parcel, 0));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Provider[i];
        }

        public final KSerializer serializer() {
            return Provider$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Type {
        public static final /* synthetic */ Type[] $VALUES = {new Type("Proxy", 0), new Type("Rule", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        Type EF5;

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class VehicleType {
        public static final /* synthetic */ VehicleType[] $VALUES;
        public static final VehicleType Inline;

        /* JADX INFO: Fake field, exist only in values array */
        VehicleType EF0;

        static {
            VehicleType vehicleType = new VehicleType("HTTP", 0);
            VehicleType vehicleType2 = new VehicleType("File", 1);
            VehicleType vehicleType3 = new VehicleType("Inline", 2);
            Inline = vehicleType3;
            $VALUES = new VehicleType[]{vehicleType, vehicleType2, vehicleType3, new VehicleType("Compatible", 3)};
        }

        public static VehicleType valueOf(String str) {
            return (VehicleType) Enum.valueOf(VehicleType.class, str);
        }

        public static VehicleType[] values() {
            return (VehicleType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.core.model.Provider$compareTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final /* synthetic */ class AnonymousClass1 extends PropertyReference1Impl {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1("type", "getType()Lcom/github/kr328/clash/core/model/Provider$Type;");

        @Override // kotlin.reflect.KProperty1
        public final Object get(Object obj) {
            return ((Provider) obj).type;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.core.model.Provider$compareTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final /* synthetic */ class AnonymousClass2 extends PropertyReference1Impl {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2("name", "getName()Ljava/lang/String;");

        @Override // kotlin.reflect.KProperty1
        public final Object get(Object obj) {
            return ((Provider) obj).name;
        }
    }

    public /* synthetic */ Provider(int i, String str, Type type, VehicleType vehicleType, long j) {
        if (15 != (i & 15)) {
            Platform_commonKt.throwMissingFieldException(i, 15, Provider$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.name = str;
        this.type = type;
        this.vehicleType = vehicleType;
        this.updatedAt = j;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Provider provider) {
        Provider provider2 = provider;
        Function1[] function1Arr = {AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE};
        for (int i = 0; i < 2; i++) {
            Function1 function1 = function1Arr[i];
            int iCompareValues = ComparisonsKt__ComparisonsKt.compareValues((Comparable) function1.invoke(this), (Comparable) function1.invoke(provider2));
            if (iCompareValues != 0) {
                return iCompareValues;
            }
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Provider)) {
            return false;
        }
        Provider provider = (Provider) obj;
        return Intrinsics.areEqual(this.name, provider.name) && this.type == provider.type && this.vehicleType == provider.vehicleType && this.updatedAt == provider.updatedAt;
    }

    public final int hashCode() {
        int iHashCode = (this.vehicleType.hashCode() + ((this.type.hashCode() + (this.name.hashCode() * 31)) * 31)) * 31;
        long j = this.updatedAt;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "Provider(name=" + this.name + ", type=" + this.type + ", vehicleType=" + this.vehicleType + ", updatedAt=" + this.updatedAt + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        CREATOR.serializer().serialize(new Parcelizer$ParcelDecoder(parcel, 1), this);
    }
}
