package com.google.mlkit.common.model;

import android.database.Cursor;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.firebase.components.Preconditions;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RemoteModelManager implements SQLiteEventStore.Function {
    public final HashMap zza;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RemoteModelManagerRegistration {
        public final Provider zzb;

        public RemoteModelManagerRegistration(Provider provider) {
            this.zzb = provider;
        }
    }

    public RemoteModelManager(HashMap map) {
        this.zza = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Long lValueOf = Long.valueOf(j);
            HashMap map = this.zza;
            Set hashSet = (Set) map.get(lValueOf);
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j), hashSet);
            }
            hashSet.add(new SQLiteEventStore.Metadata(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    public RemoteModelManager(Set set) {
        this.zza = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            RemoteModelManagerRegistration remoteModelManagerRegistration = (RemoteModelManagerRegistration) it.next();
            HashMap map = this.zza;
            remoteModelManagerRegistration.getClass();
            map.put(Preconditions.class, remoteModelManagerRegistration.zzb);
        }
    }
}
