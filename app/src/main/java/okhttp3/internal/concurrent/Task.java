package okhttp3.internal.concurrent;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Task {
    public final boolean cancelable;
    public final String name;
    public long nextExecuteNanoTime = -1;
    public TaskQueue queue;

    public Task(String str, boolean z) {
        this.name = str;
        this.cancelable = z;
    }

    public abstract long runOnce();

    public final String toString() {
        return this.name;
    }
}
