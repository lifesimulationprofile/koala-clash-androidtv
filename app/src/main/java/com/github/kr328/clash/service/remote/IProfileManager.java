package com.github.kr328.clash.service.remote;

import com.github.kr328.clash.service.model.Profile;
import java.util.UUID;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface IProfileManager {
    Object clone(UUID uuid, Continuation continuation);

    Object delete(UUID uuid, Continuation continuation);

    /* JADX INFO: renamed from: import */
    Object mo811import(Profile.Type type, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation);

    Object patch(UUID uuid, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation);

    Object queryActive(Continuation continuation);

    Object queryAll(Continuation continuation);

    Object queryByUUID(UUID uuid, Continuation continuation);

    Object setActive(Profile profile, Continuation continuation);

    Object update(UUID uuid, Continuation continuation);
}
