package androidx.databinding;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class MergedDataBinderMapper extends DataBinderMapper {
    public final HashSet mExistingMappers = new HashSet();
    public final CopyOnWriteArrayList mMappers = new CopyOnWriteArrayList();

    public MergedDataBinderMapper() {
        new CopyOnWriteArrayList();
    }

    public final void addMapper(DataBinderMapper dataBinderMapper) {
        if (this.mExistingMappers.add(dataBinderMapper.getClass())) {
            this.mMappers.add(dataBinderMapper);
            Iterator it = dataBinderMapper.collectDependencies().iterator();
            while (it.hasNext()) {
                addMapper((DataBinderMapper) it.next());
            }
        }
    }
}
