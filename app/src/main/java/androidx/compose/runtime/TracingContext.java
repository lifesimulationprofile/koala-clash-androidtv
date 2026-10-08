package androidx.compose.runtime;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TracingContext implements CoroutineContext.Element {
    public abstract void restoreThreadContext(Object obj);

    public abstract Object updateThreadContext(CoroutineContext coroutineContext);
}
