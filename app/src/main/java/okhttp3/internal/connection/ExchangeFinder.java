package okhttp3.internal.connection;

import androidx.compose.ui.node.RulerTrackingMap;
import coil.memory.RealWeakMemoryCache;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ExchangeFinder {
    public final Address address;
    public final RealCall call;
    public final RealConnectionPool connectionPool;
    public int connectionShutdownCount;
    public Route nextRouteToTry;
    public int otherFailureCount;
    public int refusedStreamCount;
    public RealWeakMemoryCache routeSelection;
    public RulerTrackingMap routeSelector;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address, RealCall realCall) {
        this.connectionPool = realConnectionPool;
        this.address = address;
        this.call = realCall;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:40:0x007e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:64:0x011a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0126  */
    /* JADX WARN: Code duplicated, block: B:67:0x012c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0132  */
    /* JADX WARN: Code duplicated, block: B:74:0x016e  */
    /* JADX WARN: Code duplicated, block: B:75:0x017c  */
    public final RealConnection findHealthyConnection(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        Route route;
        RealWeakMemoryCache realWeakMemoryCache;
        RulerTrackingMap rulerTrackingMap;
        RealWeakMemoryCache next;
        ArrayList arrayList;
        Address address;
        URI uri;
        List<Proxy> listSelect;
        List listImmutableListOf;
        RealConnection realConnection;
        Socket socketReleaseConnectionNoEvents$okhttp;
        while (!this.call.canceled) {
            RealConnection realConnection2 = this.call.connection;
            if (realConnection2 != null) {
                synchronized (realConnection2) {
                    try {
                        if (!realConnection2.noNewExchanges) {
                            HttpUrl httpUrl = realConnection2.route.address.url;
                            HttpUrl httpUrl2 = this.address.url;
                            socketReleaseConnectionNoEvents$okhttp = !(httpUrl.port == httpUrl2.port && Intrinsics.areEqual(httpUrl.host, httpUrl2.host)) ? this.call.releaseConnectionNoEvents$okhttp() : null;
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (this.call.connection == null) {
                    if (socketReleaseConnectionNoEvents$okhttp != null) {
                        Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                    }
                    this.refusedStreamCount = 0;
                    this.connectionShutdownCount = 0;
                    this.otherFailureCount = 0;
                    if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
                        realConnection2 = this.call.connection;
                    } else {
                        route = this.nextRouteToTry;
                        try {
                            if (route != null) {
                                this.nextRouteToTry = null;
                            } else {
                                realWeakMemoryCache = this.routeSelection;
                                if (realWeakMemoryCache == null && realWeakMemoryCache.hasNext()) {
                                    RealWeakMemoryCache realWeakMemoryCache2 = this.routeSelection;
                                    if (!realWeakMemoryCache2.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    ArrayList arrayList2 = (ArrayList) realWeakMemoryCache2.cache;
                                    int i4 = realWeakMemoryCache2.operationsSinceCleanUp;
                                    realWeakMemoryCache2.operationsSinceCleanUp = i4 + 1;
                                    route = (Route) arrayList2.get(i4);
                                } else {
                                    rulerTrackingMap = this.routeSelector;
                                    if (rulerTrackingMap == null) {
                                        address = this.address;
                                        Headers.Builder builder = this.call.client.routeDatabase;
                                        rulerTrackingMap = new RulerTrackingMap();
                                        rulerTrackingMap.rulers = address;
                                        rulerTrackingMap.values = builder;
                                        EmptyList emptyList = EmptyList.INSTANCE;
                                        rulerTrackingMap.accessFlags = emptyList;
                                        rulerTrackingMap.layoutNodes = emptyList;
                                        rulerTrackingMap.newRulers = new ArrayList();
                                        uri = address.url.uri();
                                        if (uri.getHost() == null) {
                                            listImmutableListOf = Util.immutableListOf(Proxy.NO_PROXY);
                                        } else {
                                            listSelect = address.proxySelector.select(uri);
                                            if (listSelect != null || listSelect.isEmpty()) {
                                                listImmutableListOf = Util.immutableListOf(Proxy.NO_PROXY);
                                            } else {
                                                listImmutableListOf = Collections.unmodifiableList(new ArrayList(listSelect));
                                            }
                                        }
                                        rulerTrackingMap.accessFlags = listImmutableListOf;
                                        rulerTrackingMap.size = 0;
                                        this.routeSelector = rulerTrackingMap;
                                    }
                                    next = rulerTrackingMap.next();
                                    this.routeSelection = next;
                                    arrayList = (ArrayList) next.cache;
                                    if (!this.call.canceled) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, false)) {
                                        realConnection2 = this.call.connection;
                                    } else {
                                        if (next.hasNext()) {
                                            throw new NoSuchElementException();
                                        }
                                        ArrayList arrayList3 = (ArrayList) next.cache;
                                        int i5 = next.operationsSinceCleanUp;
                                        next.operationsSinceCleanUp = i5 + 1;
                                        route = (Route) arrayList3.get(i5);
                                        realConnection = new RealConnection(route);
                                        this.call.connectionToCancel = realConnection;
                                        realConnection.connect(i, i2, i3, z, this.call);
                                        this.call.connectionToCancel = null;
                                        this.call.client.routeDatabase.connected(route);
                                        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, true)) {
                                            RealConnection realConnection3 = this.call.connection;
                                            this.nextRouteToTry = route;
                                            Util.closeQuietly(realConnection.socket);
                                            realConnection2 = realConnection3;
                                        } else {
                                            synchronized (realConnection) {
                                                RealConnectionPool realConnectionPool = this.connectionPool;
                                                realConnectionPool.getClass();
                                                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                                                realConnectionPool.connections.add(realConnection);
                                                realConnectionPool.cleanupQueue.schedule(realConnectionPool.cleanupTask, 0L);
                                                this.call.acquireConnectionNoEvents(realConnection);
                                                Unit unit2 = Unit.INSTANCE;
                                            }
                                            realConnection2 = realConnection;
                                        }
                                    }
                                }
                            }
                            realConnection.connect(i, i2, i3, z, this.call);
                            this.call.connectionToCancel = null;
                            this.call.client.routeDatabase.connected(route);
                            if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, true)) {
                                RealConnection realConnection4 = this.call.connection;
                                this.nextRouteToTry = route;
                                Util.closeQuietly(realConnection.socket);
                                realConnection2 = realConnection4;
                            } else {
                                synchronized (realConnection) {
                                    RealConnectionPool realConnectionPool2 = this.connectionPool;
                                    realConnectionPool2.getClass();
                                    byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                                    realConnectionPool2.connections.add(realConnection);
                                    realConnectionPool2.cleanupQueue.schedule(realConnectionPool2.cleanupTask, 0L);
                                    this.call.acquireConnectionNoEvents(realConnection);
                                    Unit unit3 = Unit.INSTANCE;
                                    realConnection2 = realConnection;
                                }
                            }
                        } catch (Throwable th2) {
                            this.call.connectionToCancel = null;
                            throw th2;
                        }
                        arrayList = null;
                        realConnection = new RealConnection(route);
                        this.call.connectionToCancel = realConnection;
                    }
                } else if (socketReleaseConnectionNoEvents$okhttp != null) {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                this.refusedStreamCount = 0;
                this.connectionShutdownCount = 0;
                this.otherFailureCount = 0;
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
                    realConnection2 = this.call.connection;
                } else {
                    route = this.nextRouteToTry;
                    if (route != null) {
                        this.nextRouteToTry = null;
                    } else {
                        realWeakMemoryCache = this.routeSelection;
                        if (realWeakMemoryCache == null) {
                        }
                        rulerTrackingMap = this.routeSelector;
                        if (rulerTrackingMap == null) {
                            address = this.address;
                            Headers.Builder builder2 = this.call.client.routeDatabase;
                            rulerTrackingMap = new RulerTrackingMap();
                            rulerTrackingMap.rulers = address;
                            rulerTrackingMap.values = builder2;
                            EmptyList emptyList2 = EmptyList.INSTANCE;
                            rulerTrackingMap.accessFlags = emptyList2;
                            rulerTrackingMap.layoutNodes = emptyList2;
                            rulerTrackingMap.newRulers = new ArrayList();
                            uri = address.url.uri();
                            if (uri.getHost() == null) {
                                listImmutableListOf = Util.immutableListOf(Proxy.NO_PROXY);
                            } else {
                                listSelect = address.proxySelector.select(uri);
                                if (listSelect != null) {
                                    listImmutableListOf = Util.immutableListOf(Proxy.NO_PROXY);
                                } else {
                                    listImmutableListOf = Util.immutableListOf(Proxy.NO_PROXY);
                                }
                            }
                            rulerTrackingMap.accessFlags = listImmutableListOf;
                            rulerTrackingMap.size = 0;
                            this.routeSelector = rulerTrackingMap;
                        }
                        next = rulerTrackingMap.next();
                        this.routeSelection = next;
                        arrayList = (ArrayList) next.cache;
                        if (!this.call.canceled) {
                            throw new IOException("Canceled");
                        }
                        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, false)) {
                            realConnection2 = this.call.connection;
                        } else {
                            if (next.hasNext()) {
                                throw new NoSuchElementException();
                            }
                            ArrayList arrayList4 = (ArrayList) next.cache;
                            int i6 = next.operationsSinceCleanUp;
                            next.operationsSinceCleanUp = i6 + 1;
                            route = (Route) arrayList4.get(i6);
                            realConnection = new RealConnection(route);
                            this.call.connectionToCancel = realConnection;
                            realConnection.connect(i, i2, i3, z, this.call);
                            this.call.connectionToCancel = null;
                            this.call.client.routeDatabase.connected(route);
                            if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, true)) {
                                RealConnection realConnection5 = this.call.connection;
                                this.nextRouteToTry = route;
                                Util.closeQuietly(realConnection.socket);
                                realConnection2 = realConnection5;
                            } else {
                                synchronized (realConnection) {
                                    RealConnectionPool realConnectionPool3 = this.connectionPool;
                                    realConnectionPool3.getClass();
                                    byte[] bArr3 = Util.EMPTY_BYTE_ARRAY;
                                    realConnectionPool3.connections.add(realConnection);
                                    realConnectionPool3.cleanupQueue.schedule(realConnectionPool3.cleanupTask, 0L);
                                    this.call.acquireConnectionNoEvents(realConnection);
                                    Unit unit4 = Unit.INSTANCE;
                                    realConnection2 = realConnection;
                                }
                            }
                        }
                    }
                    arrayList = null;
                    realConnection = new RealConnection(route);
                    this.call.connectionToCancel = realConnection;
                    realConnection.connect(i, i2, i3, z, this.call);
                    this.call.connectionToCancel = null;
                    this.call.client.routeDatabase.connected(route);
                    if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, arrayList, true)) {
                        RealConnection realConnection6 = this.call.connection;
                        this.nextRouteToTry = route;
                        Util.closeQuietly(realConnection.socket);
                        realConnection2 = realConnection6;
                    } else {
                        synchronized (realConnection) {
                            RealConnectionPool realConnectionPool4 = this.connectionPool;
                            realConnectionPool4.getClass();
                            byte[] bArr4 = Util.EMPTY_BYTE_ARRAY;
                            realConnectionPool4.connections.add(realConnection);
                            realConnectionPool4.cleanupQueue.schedule(realConnectionPool4.cleanupTask, 0L);
                            this.call.acquireConnectionNoEvents(realConnection);
                            Unit unit5 = Unit.INSTANCE;
                            realConnection2 = realConnection;
                        }
                    }
                }
            }
            if (realConnection2.isHealthy(z2)) {
                return realConnection2;
            }
            realConnection2.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RealWeakMemoryCache realWeakMemoryCache3 = this.routeSelection;
                if (realWeakMemoryCache3 != null ? realWeakMemoryCache3.hasNext() : true) {
                    continue;
                } else {
                    RulerTrackingMap rulerTrackingMap2 = this.routeSelector;
                    if (!(rulerTrackingMap2 != null ? rulerTrackingMap2.hasNext() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final void trackFailure(IOException iOException) {
        this.nextRouteToTry = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == 8) {
            this.refusedStreamCount++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
