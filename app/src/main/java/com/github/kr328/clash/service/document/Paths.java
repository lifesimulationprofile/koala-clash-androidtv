package com.github.kr328.clash.service.document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Paths {
    public static Path resolve(String str) {
        List listSplit$default = StringsKt.split$default(str, new String[]{"/"}, 0, 6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            String str2 = (String) obj;
            if (!StringsKt.isBlank(str2) && !str2.equals(".") && !str2.equals("..")) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return new Path(null, null, null);
        }
        if (size == 1) {
            return new Path(UUID.fromString((String) arrayList.get(0)), null, null);
        }
        Path.Scope scope = Path.Scope.Providers;
        Path.Scope scope2 = Path.Scope.Configuration;
        if (size != 2) {
            UUID uuidFromString = UUID.fromString((String) arrayList.get(0));
            String str3 = (String) arrayList.get(1);
            if (Intrinsics.areEqual(str3, "config.yaml")) {
                scope = scope2;
            } else if (!Intrinsics.areEqual(str3, "providers")) {
                throw new IllegalArgumentException("unknown scope " + arrayList.get(1));
            }
            return new Path(uuidFromString, scope, CollectionsKt.drop(2, arrayList));
        }
        UUID uuidFromString2 = UUID.fromString((String) arrayList.get(0));
        String str4 = (String) arrayList.get(1);
        if (Intrinsics.areEqual(str4, "config.yaml")) {
            scope = scope2;
        } else if (!Intrinsics.areEqual(str4, "providers")) {
            throw new IllegalArgumentException("unknown scope " + arrayList.get(1));
        }
        return new Path(uuidFromString2, scope, null);
    }
}
