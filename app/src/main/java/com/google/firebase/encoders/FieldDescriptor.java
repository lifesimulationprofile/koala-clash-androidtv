package com.google.firebase.encoders;

import java.util.Collections;
import java.util.Map;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FieldDescriptor {
    public final String name;
    public final Map properties;

    public FieldDescriptor(String str, Map map) {
        this.name = str;
        this.properties = map;
    }

    public static CacheStrategy builder(String str) {
        return new CacheStrategy(17, str);
    }

    public static FieldDescriptor of(String str) {
        return new FieldDescriptor(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        return this.name.equals(fieldDescriptor.name) && this.properties.equals(fieldDescriptor.properties);
    }

    public final int hashCode() {
        return this.properties.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.name + ", properties=" + this.properties.values() + "}";
    }
}
