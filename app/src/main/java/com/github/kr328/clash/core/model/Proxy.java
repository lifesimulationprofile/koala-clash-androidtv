package com.github.kr328.clash.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.Platform_commonKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Proxy implements Parcelable {
    public final int delay;
    public final String name;
    public final String subtitle;
    public final String title;
    public final Type type;
    public static final CREATOR CREATOR = new CREATOR();
    public static final KSerializer[] $childSerializers = {null, null, null, new EnumSerializer("com.github.kr328.clash.core.model.Proxy.Type", Type.values()), null};

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CREATOR implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return (Proxy) serializer().deserialize(new Parcelizer$ParcelDecoder(parcel, 0));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Proxy[i];
        }

        public final KSerializer serializer() {
            return Proxy$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static final Type Fallback;
        public static final Type Selector;
        public static final Type URLTest;
        public static final Type Unknown;

        /* JADX INFO: Fake field, exist only in values array */
        Type EF0;

        static {
            Type type = new Type("Direct", 0);
            Type type2 = new Type("Reject", 1);
            Type type3 = new Type("RejectDrop", 2);
            Type type4 = new Type("Compatible", 3);
            Type type5 = new Type("Pass", 4);
            Type type6 = new Type("Shadowsocks", 5);
            Type type7 = new Type("ShadowsocksR", 6);
            Type type8 = new Type("Snell", 7);
            Type type9 = new Type("Socks5", 8);
            Type type10 = new Type("Http", 9);
            Type type11 = new Type("Vmess", 10);
            Type type12 = new Type("Vless", 11);
            Type type13 = new Type("Trojan", 12);
            Type type14 = new Type("Hysteria", 13);
            Type type15 = new Type("Hysteria2", 14);
            Type type16 = new Type("Tuic", 15);
            Type type17 = new Type("WireGuard", 16);
            Type type18 = new Type("Dns", 17);
            Type type19 = new Type("Ssh", 18);
            Type type20 = new Type("Mieru", 19);
            Type type21 = new Type("AnyTLS", 20);
            Type type22 = new Type("Sudoku", 21);
            Type type23 = new Type("Masque", 22);
            Type type24 = new Type("TrustTunnel", 23);
            Type type25 = new Type("Relay", 24);
            Type type26 = new Type("Selector", 25);
            Selector = type26;
            Type type27 = new Type("Fallback", 26);
            Fallback = type27;
            Type type28 = new Type("URLTest", 27);
            URLTest = type28;
            Type type29 = new Type("LoadBalance", 28);
            Type type30 = new Type("Unknown", 29);
            Unknown = type30;
            $VALUES = new Type[]{type, type2, type3, type4, type5, type6, type7, type8, type9, type10, type11, type12, type13, type14, type15, type16, type17, type18, type19, type20, type21, type22, type23, type24, type25, type26, type27, type28, type29, type30};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public /* synthetic */ Proxy(int i, String str, String str2, String str3, Type type, int i2) {
        if (31 != (i & 31)) {
            Platform_commonKt.throwMissingFieldException(i, 31, Proxy$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.name = str;
        this.title = str2;
        this.subtitle = str3;
        this.type = type;
        this.delay = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Proxy)) {
            return false;
        }
        Proxy proxy = (Proxy) obj;
        return Intrinsics.areEqual(this.name, proxy.name) && Intrinsics.areEqual(this.title, proxy.title) && Intrinsics.areEqual(this.subtitle, proxy.subtitle) && this.type == proxy.type && this.delay == proxy.delay;
    }

    public final int hashCode() {
        return ((this.type.hashCode() + Modifier.CC.m(Modifier.CC.m(this.name.hashCode() * 31, 31, this.title), 31, this.subtitle)) * 31) + this.delay;
    }

    public final String toString() {
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Proxy(name=", this.name, ", title=", this.title, ", subtitle=");
        sbM.append(this.subtitle);
        sbM.append(", type=");
        sbM.append(this.type);
        sbM.append(", delay=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sbM, this.delay, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        CREATOR.serializer().serialize(new Parcelizer$ParcelDecoder(parcel, 1), this);
    }
}
