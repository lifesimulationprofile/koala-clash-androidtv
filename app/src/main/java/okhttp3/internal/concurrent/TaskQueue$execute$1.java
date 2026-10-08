package okhttp3.internal.concurrent;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TaskQueue$execute$1 extends Task {
    public final /* synthetic */ Object $block;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TaskQueue$execute$1(String str, Object obj, int i) {
        super(str, true);
        this.$r8$classId = i;
        this.$block = obj;
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                ((Function0) this.$block).invoke();
                return -1L;
            case 1:
                RealConnectionPool realConnectionPool = (RealConnectionPool) this.$block;
                long jNanoTime = System.nanoTime();
                long j = Long.MIN_VALUE;
                RealConnection realConnection = null;
                int i2 = 0;
                for (RealConnection realConnection2 : realConnectionPool.connections) {
                    synchronized (realConnection2) {
                        if (realConnectionPool.pruneAndGetAllocationCount(realConnection2, jNanoTime) > 0) {
                            i2++;
                        } else {
                            i++;
                            long j2 = jNanoTime - realConnection2.idleAtNs;
                            if (j2 > j) {
                                realConnection = realConnection2;
                                j = j2;
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
                long j3 = realConnectionPool.keepAliveDurationNs;
                if (j < j3 && i <= 5) {
                    if (i > 0) {
                        return j3 - j;
                    }
                    if (i2 > 0) {
                        return j3;
                    }
                    return -1L;
                }
                synchronized (realConnection) {
                    if (!realConnection.calls.isEmpty()) {
                        return 0L;
                    }
                    if (realConnection.idleAtNs + j != jNanoTime) {
                        return 0L;
                    }
                    realConnection.noNewExchanges = true;
                    realConnectionPool.connections.remove(realConnection);
                    Util.closeQuietly(realConnection.socket);
                    if (!realConnectionPool.connections.isEmpty()) {
                        return 0L;
                    }
                    realConnectionPool.cleanupQueue.cancelAll();
                    return 0L;
                }
            default:
                Http2Connection http2Connection = (Http2Connection) this.$block;
                http2Connection.getClass();
                try {
                    http2Connection.writer.ping(2, 0, false);
                    break;
                } catch (IOException e) {
                    http2Connection.close$okhttp(2, 2, e);
                }
                return -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(RealConnectionPool realConnectionPool, String str) {
        super(str, true);
        this.$r8$classId = 1;
        this.$block = realConnectionPool;
    }
}
