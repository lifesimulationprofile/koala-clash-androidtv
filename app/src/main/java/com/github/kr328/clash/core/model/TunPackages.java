package com.github.kr328.clash.core.model;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TunPackages {
    public static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion();
    public final List excludePackage;
    public final List includePackage;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public final KSerializer serializer() {
            return TunPackages$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer)};
    }

    public /* synthetic */ TunPackages(int i, List list, List list2) {
        int i2 = i & 1;
        EmptyList emptyList = EmptyList.INSTANCE;
        if (i2 == 0) {
            this.includePackage = emptyList;
        } else {
            this.includePackage = list;
        }
        if ((i & 2) == 0) {
            this.excludePackage = emptyList;
        } else {
            this.excludePackage = list2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TunPackages)) {
            return false;
        }
        TunPackages tunPackages = (TunPackages) obj;
        return Intrinsics.areEqual(this.includePackage, tunPackages.includePackage) && Intrinsics.areEqual(this.excludePackage, tunPackages.excludePackage);
    }

    public final int hashCode() {
        return this.excludePackage.hashCode() + (this.includePackage.hashCode() * 31);
    }

    public final String toString() {
        return "TunPackages(includePackage=" + this.includePackage + ", excludePackage=" + this.excludePackage + ")";
    }
}
