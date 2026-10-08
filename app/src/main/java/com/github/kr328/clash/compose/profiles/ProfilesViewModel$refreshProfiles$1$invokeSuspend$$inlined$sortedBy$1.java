package com.github.kr328.clash.compose.profiles;

import com.github.kr328.clash.service.model.Profile;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfilesViewModel$refreshProfiles$1$invokeSuspend$$inlined$sortedBy$1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((Profile) obj).updatedAt), Long.valueOf(((Profile) obj2).updatedAt));
    }
}
