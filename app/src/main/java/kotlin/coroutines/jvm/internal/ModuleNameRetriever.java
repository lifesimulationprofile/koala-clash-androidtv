package kotlin.coroutines.jvm.internal;

import okhttp3.internal.platform.android.CloseGuard;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ModuleNameRetriever {
    public static CloseGuard cache;
    public static final CloseGuard notOnJava9 = new CloseGuard(null, null, null);
}
