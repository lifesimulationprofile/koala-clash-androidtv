package com.github.kr328.clash.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.Modifier;
import com.github.kr328.clash.common.util.ParcelableKt;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.Platform_commonKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyGroup implements Parcelable {
    public final String icon;
    public final String now;
    public final List proxies;
    public final Proxy.Type type;
    public static final CREATOR CREATOR = new CREATOR();
    public static final KSerializer[] $childSerializers = {new EnumSerializer("com.github.kr328.clash.core.model.Proxy.Type", Proxy.Type.values()), new ArrayListSerializer(Proxy$$serializer.INSTANCE), null, null};

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CREATOR implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new ProxyGroup[i];
        }

        public final KSerializer serializer() {
            return ProxyGroup$$serializer.INSTANCE;
        }

        public static ProxyGroup createFromParcel(Parcel parcel) {
            Proxy.Type type = Proxy.Type.values()[parcel.readInt()];
            SliceProxyList sliceProxyList = new SliceProxyList(parcel);
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (string2 == null) {
                string2 = "";
            }
            return new ProxyGroup(type, sliceProxyList, string, string2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SliceProxyList implements List, Parcelable, KMappedMarker {
        public static final CREATOR CREATOR = new CREATOR();
        public final /* synthetic */ List $$delegate_0;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class CREATOR implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SliceProxyList(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new SliceProxyList[i];
            }
        }

        public SliceProxyList(List list) {
            this.$$delegate_0 = list;
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final boolean addAll(int i, Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ /* synthetic */ void addFirst(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ /* synthetic */ void addLast(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            if (!(obj instanceof Proxy)) {
                return false;
            }
            return this.$$delegate_0.contains((Proxy) obj);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection collection) {
            return this.$$delegate_0.containsAll(collection);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // java.util.List
        public final Object get(int i) {
            return (Proxy) this.$$delegate_0.get(i);
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Proxy)) {
                return -1;
            }
            return this.$$delegate_0.indexOf((Proxy) obj);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.$$delegate_0.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return this.$$delegate_0.iterator();
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Proxy)) {
                return -1;
            }
            return this.$$delegate_0.lastIndexOf((Proxy) obj);
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            return this.$$delegate_0.listIterator();
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ Object remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ /* synthetic */ Object removeFirst() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final /* bridge */ /* synthetic */ Object removeLast() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final void replaceAll(UnaryOperator unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.$$delegate_0.size();
        }

        @Override // java.util.List
        public final void sort(Comparator comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final List subList(int i, int i2) {
            return this.$$delegate_0.subList(i, i2);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return Intrinsics.Kotlin.toArray(this);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            ParcelableKt.writeToParcelSlice(i, parcel, this);
        }

        public SliceProxyList(Parcel parcel) {
            this(ParcelableKt.createListFromParcelSlice(50, parcel, Proxy.CREATOR));
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i) {
            return this.$$delegate_0.listIterator(i);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            return Intrinsics.Kotlin.toArray(this, objArr);
        }
    }

    public /* synthetic */ ProxyGroup(int i, Proxy.Type type, List list, String str, String str2) {
        if (7 != (i & 7)) {
            Platform_commonKt.throwMissingFieldException(i, 7, ProxyGroup$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.type = type;
        this.proxies = list;
        this.now = str;
        if ((i & 8) == 0) {
            this.icon = "";
        } else {
            this.icon = str2;
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
        if (!(obj instanceof ProxyGroup)) {
            return false;
        }
        ProxyGroup proxyGroup = (ProxyGroup) obj;
        return this.type == proxyGroup.type && Intrinsics.areEqual(this.proxies, proxyGroup.proxies) && Intrinsics.areEqual(this.now, proxyGroup.now) && Intrinsics.areEqual(this.icon, proxyGroup.icon);
    }

    public final int hashCode() {
        return this.icon.hashCode() + Modifier.CC.m((this.proxies.hashCode() + (this.type.hashCode() * 31)) * 31, 31, this.now);
    }

    public final String toString() {
        return "ProxyGroup(type=" + this.type + ", proxies=" + this.proxies + ", now=" + this.now + ", icon=" + this.icon + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type.ordinal());
        ParcelableKt.writeToParcelSlice(0, parcel, new SliceProxyList(this.proxies));
        parcel.writeString(this.now);
        parcel.writeString(this.icon);
    }

    public /* synthetic */ ProxyGroup() {
        this(Proxy.Type.Unknown, EmptyList.INSTANCE, "", "");
    }

    public ProxyGroup(Proxy.Type type, List list, String str, String str2) {
        this.type = type;
        this.proxies = list;
        this.now = str;
        this.icon = str2;
    }
}
