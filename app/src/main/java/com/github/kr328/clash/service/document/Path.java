package com.github.kr328.clash.service.document;

import coil.network.HttpException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Path {
    public final List relative;
    public final Scope scope;
    public final UUID uuid;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Scope {
        public static final /* synthetic */ Scope[] $VALUES;
        public static final Scope Configuration;
        public static final Scope Providers;

        static {
            Scope scope = new Scope("Configuration", 0);
            Configuration = scope;
            Scope scope2 = new Scope("Providers", 1);
            Providers = scope2;
            $VALUES = new Scope[]{scope, scope2};
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scope.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Path(UUID uuid, Scope scope, List list) {
        this.uuid = uuid;
        this.scope = scope;
        this.relative = list;
    }

    public static Path copy$default(Path path, UUID uuid, Scope scope, ArrayList arrayList, int i) {
        if ((i & 1) != 0) {
            uuid = path.uuid;
        }
        if ((i & 2) != 0) {
            scope = path.scope;
        }
        List list = arrayList;
        if ((i & 4) != 0) {
            list = path.relative;
        }
        path.getClass();
        return new Path(uuid, scope, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Path)) {
            return false;
        }
        Path path = (Path) obj;
        return Intrinsics.areEqual(this.uuid, path.uuid) && this.scope == path.scope && Intrinsics.areEqual(this.relative, path.relative);
    }

    public final int hashCode() {
        UUID uuid = this.uuid;
        int iHashCode = (uuid == null ? 0 : uuid.hashCode()) * 31;
        Scope scope = this.scope;
        int iHashCode2 = (iHashCode + (scope == null ? 0 : scope.hashCode())) * 31;
        List list = this.relative;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        String str;
        UUID uuid = this.uuid;
        if (uuid == null) {
            return "/";
        }
        Scope scope = this.scope;
        if (scope == null) {
            return "/" + uuid;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[scope.ordinal()];
        if (i == 1) {
            str = "config.yaml";
        } else {
            if (i != 2) {
                throw new HttpException();
            }
            str = "providers";
        }
        List list = this.relative;
        if (list == null) {
            return "/" + uuid + "/" + str;
        }
        return "/" + uuid + "/" + str + "/" + CollectionsKt.joinToString$default(list, "/", null, null, null, 62);
    }
}
