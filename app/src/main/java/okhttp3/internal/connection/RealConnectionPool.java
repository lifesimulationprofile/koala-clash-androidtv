package okhttp3.internal.connection;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import okhttp3.Address;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealConnectionPool {
    public final TaskQueue cleanupQueue;
    public final long keepAliveDurationNs = TimeUnit.MINUTES.toNanos(5);
    public final TaskQueue$execute$1 cleanupTask = new TaskQueue$execute$1(this, ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), Util.okHttpName, " ConnectionPool"));
    public final ConcurrentLinkedQueue connections = new ConcurrentLinkedQueue();

    public RealConnectionPool(TaskRunner taskRunner) {
        this.cleanupQueue = taskRunner.newQueue();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0027 A[SYNTHETIC] */
    public final boolean callAcquirePooledConnection(Address address, RealCall realCall, List list, boolean z) {
        Iterator it = this.connections.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            RealConnection realConnection = (RealConnection) it.next();
            synchronized (realConnection) {
                if (z) {
                    try {
                        if (realConnection.http2Connection != null) {
                            if (realConnection.isEligible$okhttp(address, list)) {
                                realCall.acquireConnectionNoEvents(realConnection);
                                return true;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (realConnection.isEligible$okhttp(address, list)) {
                    realCall.acquireConnectionNoEvents(realConnection);
                    return true;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = realConnection.calls;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = "A connection to " + realConnection.route.address.url + " was leaked. Did you forget to close a response body?";
                Platform platform = Platform.platform;
                Platform.platform.logCloseableLeak(((RealCall.CallReference) reference).callStackTrace, str);
                arrayList.remove(i);
                realConnection.noNewExchanges = true;
                if (arrayList.isEmpty()) {
                    realConnection.idleAtNs = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
