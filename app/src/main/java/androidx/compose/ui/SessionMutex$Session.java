package androidx.compose.ui;

import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SessionMutex$Session {
    public final Job job;
    public final Object value;

    public SessionMutex$Session(Job job, Object obj) {
        this.job = job;
        this.value = obj;
    }
}
