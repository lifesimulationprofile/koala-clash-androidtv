package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.AbstractMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMapKeySet implements Set, KMutableSet {
    public final /* synthetic */ int $r8$classId;
    public final SnapshotStateMap map;

    public SnapshotMapKeySet(SnapshotStateMap snapshotStateMap, int i) {
        this.$r8$classId = i;
        this.map = snapshotStateMap;
    }

    private final boolean retainAll$androidx$compose$runtime$snapshots$SnapshotMapEntrySet(Collection collection) {
        PersistentMap persistentMap;
        int i;
        Snapshot snapshotCurrentSnapshot;
        boolean zAccess$attemptUpdate;
        Collection<Map.Entry> collection2 = collection;
        int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(collection2, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (Map.Entry entry : collection2) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        SnapshotStateMap snapshotStateMap = this.map;
        boolean z = false;
        do {
            synchronized (SnapshotId_jvmKt.sync$1) {
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current(snapshotStateMap.firstStateRecord);
                persistentMap = stateMapStateRecord.map;
                i = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
            PersistentMap.Builder builder = persistentMap.builder();
            Iterator it = snapshotStateMap.entries.iterator();
            while (((StateMapMutableKeysIterator) it).hasNext()) {
                Map.Entry entry2 = (Map.Entry) ((StateMapMutableKeysIterator) it).next();
                if (!linkedHashMap.containsKey(entry2.getKey()) || !Intrinsics.areEqual(linkedHashMap.get(entry2.getKey()), entry2.getValue())) {
                    builder.remove(entry2.getKey());
                    z = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, persistentMap)) {
                break;
            }
            SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = snapshotStateMap.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAccess$attemptUpdate = SnapshotStateMap.access$attemptUpdate(snapshotStateMap, (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, snapshotStateMap, snapshotCurrentSnapshot), i, persistentMapBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateMap);
        } while (!zAccess$attemptUpdate);
        return z;
    }

    private final boolean retainAll$androidx$compose$runtime$snapshots$SnapshotMapKeySet(Collection collection) {
        PersistentMap persistentMap;
        int i;
        Snapshot snapshotCurrentSnapshot;
        boolean zAccess$attemptUpdate;
        Set set = CollectionsKt.toSet(collection);
        SnapshotStateMap snapshotStateMap = this.map;
        boolean z = false;
        do {
            synchronized (SnapshotId_jvmKt.sync$1) {
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current(snapshotStateMap.firstStateRecord);
                persistentMap = stateMapStateRecord.map;
                i = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
            PersistentMap.Builder builder = persistentMap.builder();
            Iterator it = snapshotStateMap.entries.iterator();
            while (((StateMapMutableKeysIterator) it).hasNext()) {
                Map.Entry entry = (Map.Entry) ((StateMapMutableKeysIterator) it).next();
                if (!set.contains(entry.getKey())) {
                    builder.remove(entry.getKey());
                    z = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, persistentMap)) {
                break;
            }
            SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = snapshotStateMap.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAccess$attemptUpdate = SnapshotStateMap.access$attemptUpdate(snapshotStateMap, (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, snapshotStateMap, snapshotCurrentSnapshot), i, persistentMapBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateMap);
        } while (!zAccess$attemptUpdate);
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                SnapshotId_jvmKt.unsupported();
                throw null;
            case 1:
                SnapshotId_jvmKt.unsupported();
                throw null;
            default:
                SnapshotId_jvmKt.unsupported();
                throw null;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                SnapshotId_jvmKt.unsupported();
                throw null;
            case 1:
                SnapshotId_jvmKt.unsupported();
                throw null;
            default:
                SnapshotId_jvmKt.unsupported();
                throw null;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.map.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return this.map.containsKey(obj);
            case 1:
                if (!(obj instanceof Map.Entry) || ((obj instanceof KMappedMarker) && !(obj instanceof KMutableMap.Entry))) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return Intrinsics.areEqual(this.map.get(entry.getKey()), entry.getValue());
            default:
                return this.map.containsValue(obj);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                Collection collection2 = collection;
                if ((collection2 instanceof Collection) && collection2.isEmpty()) {
                    return true;
                }
                Iterator it = collection2.iterator();
                while (it.hasNext()) {
                    if (!this.map.containsKey(it.next())) {
                        return false;
                    }
                }
                return true;
            case 1:
                Collection collection3 = collection;
                if ((collection3 instanceof Collection) && collection3.isEmpty()) {
                    return true;
                }
                Iterator it2 = collection3.iterator();
                while (it2.hasNext()) {
                    if (!contains((Map.Entry) it2.next())) {
                        return false;
                    }
                }
                return true;
            default:
                Collection collection4 = collection;
                if ((collection4 instanceof Collection) && collection4.isEmpty()) {
                    return true;
                }
                Iterator it3 = collection4.iterator();
                while (it3.hasNext()) {
                    if (!this.map.containsValue(it3.next())) {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                SnapshotStateMap snapshotStateMap = this.map;
                return new StateMapMutableKeysIterator(snapshotStateMap, ((ImmutableSet) ((AbstractMap) snapshotStateMap.getReadable$runtime().map).entrySet()).iterator(), 0);
            case 1:
                SnapshotStateMap snapshotStateMap2 = this.map;
                return new StateMapMutableKeysIterator(snapshotStateMap2, ((ImmutableSet) ((AbstractMap) snapshotStateMap2.getReadable$runtime().map).entrySet()).iterator(), 1);
            default:
                SnapshotStateMap snapshotStateMap3 = this.map;
                return new StateMapMutableKeysIterator(snapshotStateMap3, ((ImmutableSet) ((AbstractMap) snapshotStateMap3.getReadable$runtime().map).entrySet()).iterator(), 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0030  */
    /* JADX WARN: Code duplicated, block: B:14:0x0039 A[ORIG_RETURN, RETURN] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v8 java.lang.Object, still in use, count: 2, list:
          (r2v8 java.lang.Object) from 0x002c: PHI (r2 I:??) = (r2v3 java.lang.Object), (r2v8 java.lang.Object) binds: [B:10:0x002b, B:32:0x002c] A[DONT_GENERATE, DONT_INLINE]
          (r2v8 java.lang.Object) from 0x001e: CHECK_CAST (java.util.Map$Entry) (r2v8 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // java.util.Set, java.util.Collection
    public final boolean remove(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.$r8$classId
            switch(r0) {
                case 0: goto L58;
                case 1: goto L3b;
                default: goto L5;
            }
        L5:
            androidx.compose.runtime.snapshots.SnapshotStateMap r0 = r4.map
            androidx.compose.runtime.snapshots.SnapshotMapKeySet r1 = r0.entries
            java.util.Iterator r1 = r1.iterator()
        Ld:
            r2 = r1
            androidx.compose.runtime.snapshots.StateMapMutableKeysIterator r2 = (androidx.compose.runtime.snapshots.StateMapMutableKeysIterator) r2
            boolean r2 = r2.hasNext()
            if (r2 == 0) goto L2b
            r2 = r1
            androidx.compose.runtime.snapshots.StateMapMutableKeysIterator r2 = (androidx.compose.runtime.snapshots.StateMapMutableKeysIterator) r2
            java.lang.Object r2 = r2.next()
            r3 = r2
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
            if (r3 == 0) goto Ld
            goto L2c
        L2b:
            r2 = 0
        L2c:
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            if (r2 == 0) goto L39
            java.lang.Object r5 = r2.getKey()
            r0.remove(r5)
            r5 = 1
            goto L3a
        L39:
            r5 = 0
        L3a:
            return r5
        L3b:
            boolean r0 = r5 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 == 0) goto L57
            boolean r0 = r5 instanceof kotlin.jvm.internal.markers.KMappedMarker
            if (r0 == 0) goto L48
            boolean r0 = r5 instanceof kotlin.jvm.internal.markers.KMutableMap.Entry
            if (r0 == 0) goto L57
        L48:
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            androidx.compose.runtime.snapshots.SnapshotStateMap r0 = r4.map
            java.lang.Object r5 = r5.getKey()
            java.lang.Object r5 = r0.remove(r5)
            if (r5 == 0) goto L57
            r1 = 1
        L57:
            return r1
        L58:
            androidx.compose.runtime.snapshots.SnapshotStateMap r0 = r4.map
            java.lang.Object r5 = r0.remove(r5)
            if (r5 == 0) goto L62
            r5 = 1
            goto L63
        L62:
            r5 = 0
        L63:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotMapKeySet.remove(java.lang.Object):boolean");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        PersistentMap persistentMap;
        int i;
        Snapshot snapshotCurrentSnapshot;
        boolean zAccess$attemptUpdate;
        boolean z = false;
        switch (this.$r8$classId) {
            case 0:
                Iterator it = collection.iterator();
                while (true) {
                    boolean z2 = false;
                    while (it.hasNext()) {
                        if (this.map.remove(it.next()) != null || z2) {
                            z2 = true;
                        }
                    }
                    return z2;
                }
            case 1:
                Iterator it2 = collection.iterator();
                while (true) {
                    boolean z3 = false;
                    while (it2.hasNext()) {
                        if (this.map.remove(((Map.Entry) it2.next()).getKey()) != null || z3) {
                            z3 = true;
                        }
                    }
                    return z3;
                }
            default:
                Set set = CollectionsKt.toSet(collection);
                SnapshotStateMap snapshotStateMap = this.map;
                do {
                    synchronized (SnapshotId_jvmKt.sync$1) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current(snapshotStateMap.firstStateRecord);
                        persistentMap = stateMapStateRecord.map;
                        i = stateMapStateRecord.modification;
                        Unit unit = Unit.INSTANCE;
                    }
                    PersistentMap.Builder builder = persistentMap.builder();
                    Iterator it3 = snapshotStateMap.entries.iterator();
                    while (((StateMapMutableKeysIterator) it3).hasNext()) {
                        Map.Entry entry = (Map.Entry) ((StateMapMutableKeysIterator) it3).next();
                        if (set.contains(entry.getValue())) {
                            builder.remove(entry.getKey());
                            z = true;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    PersistentMap persistentMapBuild = builder.build();
                    if (!Intrinsics.areEqual(persistentMapBuild, persistentMap)) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = snapshotStateMap.firstStateRecord;
                        synchronized (SnapshotKt.lock) {
                            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                            zAccess$attemptUpdate = SnapshotStateMap.access$attemptUpdate(snapshotStateMap, (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, snapshotStateMap, snapshotCurrentSnapshot), i, persistentMapBuild);
                        }
                        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateMap);
                    }
                    return z;
                } while (!zAccess$attemptUpdate);
                return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        PersistentMap persistentMap;
        int i;
        Snapshot snapshotCurrentSnapshot;
        boolean zAccess$attemptUpdate;
        switch (this.$r8$classId) {
            case 0:
                return retainAll$androidx$compose$runtime$snapshots$SnapshotMapKeySet(collection);
            case 1:
                return retainAll$androidx$compose$runtime$snapshots$SnapshotMapEntrySet(collection);
            default:
                Set set = CollectionsKt.toSet(collection);
                SnapshotStateMap snapshotStateMap = this.map;
                boolean z = false;
                do {
                    synchronized (SnapshotId_jvmKt.sync$1) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current(snapshotStateMap.firstStateRecord);
                        persistentMap = stateMapStateRecord.map;
                        i = stateMapStateRecord.modification;
                        Unit unit = Unit.INSTANCE;
                    }
                    PersistentMap.Builder builder = persistentMap.builder();
                    Iterator it = snapshotStateMap.entries.iterator();
                    while (((StateMapMutableKeysIterator) it).hasNext()) {
                        Map.Entry entry = (Map.Entry) ((StateMapMutableKeysIterator) it).next();
                        if (!set.contains(entry.getValue())) {
                            builder.remove(entry.getKey());
                            z = true;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    PersistentMap persistentMapBuild = builder.build();
                    if (!Intrinsics.areEqual(persistentMapBuild, persistentMap)) {
                        SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = snapshotStateMap.firstStateRecord;
                        synchronized (SnapshotKt.lock) {
                            snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                            zAccess$attemptUpdate = SnapshotStateMap.access$attemptUpdate(snapshotStateMap, (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, snapshotStateMap, snapshotCurrentSnapshot), i, persistentMapBuild);
                        }
                        SnapshotKt.notifyWrite(snapshotCurrentSnapshot, snapshotStateMap);
                    }
                    return z;
                } while (!zAccess$attemptUpdate);
                return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.map.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return Intrinsics.Kotlin.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return Intrinsics.Kotlin.toArray(this, objArr);
    }
}
