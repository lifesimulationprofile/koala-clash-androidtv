package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateMap implements StateObject, Map, KMutableMap {
    public final SnapshotMapKeySet entries;
    public StateMapStateRecord firstStateRecord;
    public final SnapshotMapKeySet keys;
    public final SnapshotMapKeySet values;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class StateMapStateRecord extends StateRecord {
        public PersistentMap map;
        public int modification;

        public StateMapStateRecord(long j, PersistentMap persistentMap) {
            super(j);
            this.map = persistentMap;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final void assign(StateRecord stateRecord) {
            StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) stateRecord;
            synchronized (SnapshotId_jvmKt.sync$1) {
                this.map = stateMapStateRecord.map;
                this.modification = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public final StateRecord create(long j) {
            return new StateMapStateRecord(j, this.map);
        }
    }

    public SnapshotStateMap() {
        PersistentHashMap persistentHashMap = PersistentHashMap.EMPTY;
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        StateMapStateRecord stateMapStateRecord = new StateMapStateRecord(snapshotCurrentSnapshot.getSnapshotId(), persistentHashMap);
        if (!(snapshotCurrentSnapshot instanceof GlobalSnapshot)) {
            stateMapStateRecord.next = new StateMapStateRecord(1, persistentHashMap);
        }
        this.firstStateRecord = stateMapStateRecord;
        this.entries = new SnapshotMapKeySet(this, 1);
        this.keys = new SnapshotMapKeySet(this, 0);
        this.values = new SnapshotMapKeySet(this, 2);
    }

    public static final boolean access$attemptUpdate(SnapshotStateMap snapshotStateMap, StateMapStateRecord stateMapStateRecord, int i, PersistentMap persistentMap) {
        boolean z;
        synchronized (SnapshotId_jvmKt.sync$1) {
            int i2 = stateMapStateRecord.modification;
            if (i2 == i) {
                stateMapStateRecord.map = persistentMap;
                z = true;
                stateMapStateRecord.modification = i2 + 1;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static void commitUpdate(StateMapStateRecord stateMapStateRecord) {
        PersistentHashMap persistentHashMap = PersistentHashMap.EMPTY;
        synchronized (SnapshotId_jvmKt.sync$1) {
            stateMapStateRecord.map = persistentHashMap;
            stateMapStateRecord.modification++;
        }
    }

    @Override // java.util.Map
    public final void clear() {
        Snapshot snapshotCurrentSnapshot;
        if (PersistentHashMap.EMPTY != ((StateMapStateRecord) SnapshotKt.current(this.firstStateRecord)).map) {
            StateMapStateRecord stateMapStateRecord = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                commitUpdate((StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord, this, snapshotCurrentSnapshot));
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        }
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return getReadable$runtime().map.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return getReadable$runtime().map.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return this.entries;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return getReadable$runtime().map.get(obj);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final StateMapStateRecord getReadable$runtime() {
        return (StateMapStateRecord) SnapshotKt.readable(this.firstStateRecord, this);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return ((AbstractMap) getReadable$runtime().map).isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return this.keys;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void prependStateRecord(StateRecord stateRecord) {
        this.firstStateRecord = (StateMapStateRecord) stateRecord;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        PersistentMap persistentMap;
        int i;
        Object objPut;
        Snapshot snapshotCurrentSnapshot;
        boolean zAccess$attemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$1) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current(this.firstStateRecord);
                persistentMap = stateMapStateRecord.map;
                i = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
            PersistentHashMapBuilder persistentHashMapBuilder = (PersistentHashMapBuilder) persistentMap.builder();
            objPut = persistentHashMapBuilder.put(obj, obj2);
            PersistentMap persistentMapBuild = persistentHashMapBuilder.build();
            if (Intrinsics.areEqual(persistentMapBuild, persistentMap)) {
                break;
            }
            StateMapStateRecord stateMapStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAccess$attemptUpdate = access$attemptUpdate(this, (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, snapshotCurrentSnapshot), i, persistentMapBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAccess$attemptUpdate);
        return objPut;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        PersistentMap persistentMap;
        int i;
        Snapshot snapshotCurrentSnapshot;
        boolean zAccess$attemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$1) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current(this.firstStateRecord);
                persistentMap = stateMapStateRecord.map;
                i = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
            PersistentHashMapBuilder persistentHashMapBuilder = (PersistentHashMapBuilder) persistentMap.builder();
            persistentHashMapBuilder.putAll(map);
            PersistentMap persistentMapBuild = persistentHashMapBuilder.build();
            if (Intrinsics.areEqual(persistentMapBuild, persistentMap)) {
                return;
            }
            StateMapStateRecord stateMapStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAccess$attemptUpdate = access$attemptUpdate(this, (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, snapshotCurrentSnapshot), i, persistentMapBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAccess$attemptUpdate);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        PersistentMap persistentMap;
        int i;
        Object objRemove;
        Snapshot snapshotCurrentSnapshot;
        boolean zAccess$attemptUpdate;
        do {
            synchronized (SnapshotId_jvmKt.sync$1) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current(this.firstStateRecord);
                persistentMap = stateMapStateRecord.map;
                i = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
            PersistentMap.Builder builder = persistentMap.builder();
            objRemove = builder.remove(obj);
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, persistentMap)) {
                break;
            }
            StateMapStateRecord stateMapStateRecord2 = this.firstStateRecord;
            synchronized (SnapshotKt.lock) {
                snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                zAccess$attemptUpdate = access$attemptUpdate(this, (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, snapshotCurrentSnapshot), i, persistentMapBuild);
            }
            SnapshotKt.notifyWrite(snapshotCurrentSnapshot, this);
        } while (!zAccess$attemptUpdate);
        return objRemove;
    }

    @Override // java.util.Map
    public final int size() {
        AbstractMap abstractMap = (AbstractMap) getReadable$runtime().map;
        abstractMap.getClass();
        return ((PersistentHashMap) abstractMap).size;
    }

    public final String toString() {
        return "SnapshotStateMap(value=" + ((StateMapStateRecord) SnapshotKt.current(this.firstStateRecord)).map + ")@" + hashCode();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.values;
    }
}
