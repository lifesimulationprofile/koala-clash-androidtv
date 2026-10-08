package com.github.kr328.clash.service.clash.module;

import android.app.Service;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.network.RealNetworkObserver$networkCallback$1;
import com.github.kr328.clash.core.bridge.Bridge;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkObserveModule extends Module {
    public final RealNetworkObserver$networkCallback$1 callback;
    public final ConnectivityManager connectivity;
    public volatile Object curDnsList;
    public final ConcurrentHashMap networkInfos;
    public final BufferedChannel networks;
    public final NetworkRequest request;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class NetworkInfo {
        public volatile List dnsList;
        public volatile long losingMs;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NetworkInfo)) {
                return false;
            }
            NetworkInfo networkInfo = (NetworkInfo) obj;
            return this.losingMs == networkInfo.losingMs && Intrinsics.areEqual(this.dnsList, networkInfo.dnsList);
        }

        public final int hashCode() {
            long j = this.losingMs;
            return this.dnsList.hashCode() + (((int) (j ^ (j >>> 32))) * 31);
        }

        public final String toString() {
            return "NetworkInfo(losingMs=" + this.losingMs + ", dnsList=" + this.dnsList + ")";
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.clash.module.NetworkObserveModule$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkObserveModule.this.run(this);
        }
    }

    public NetworkObserveModule(Service service) {
        super(service);
        this.connectivity = (ConnectivityManager) service.getSystemService(ConnectivityManager.class);
        this.networks = ChannelKt.Channel$default(Integer.MAX_VALUE, 0, 6);
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(15);
        builder.addCapability(12);
        if (Build.VERSION.SDK_INT >= 28) {
            builder.addCapability(19);
        }
        builder.addCapability(13);
        this.request = builder.build();
        this.networkInfos = new ConcurrentHashMap();
        this.curDnsList = EmptyList.INSTANCE;
        this.callback = new RealNetworkObserver$networkCallback$1(1, this);
    }

    public static final void access$notifyDnsChange(NetworkObserveModule networkObserveModule) {
        Object obj;
        Iterable<InetAddress> iterable;
        String strM;
        NetworkInfo networkInfo;
        Iterator it = networkObserveModule.networkInfos.entrySet().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int iNetworkToInt = networkObserveModule.networkToInt((Map.Entry) next);
                do {
                    Object next2 = it.next();
                    int iNetworkToInt2 = networkObserveModule.networkToInt((Map.Entry) next2);
                    if (iNetworkToInt > iNetworkToInt2) {
                        next = next2;
                        iNetworkToInt = iNetworkToInt2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null || (networkInfo = (NetworkInfo) entry.getValue()) == null || (iterable = networkInfo.dnsList) == null) {
            iterable = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (InetAddress inetAddress : iterable) {
            if (inetAddress instanceof Inet6Address) {
                Inet6Address inet6Address = (Inet6Address) inetAddress;
                byte[] address = inet6Address.getAddress();
                StringBuilder sb = new StringBuilder(39);
                for (int i = 0; i < 8; i++) {
                    int i2 = i << 1;
                    sb.append(Integer.toHexString(((address[i2] << 8) & 65280) | (address[i2 + 1] & 255)));
                    if (i < 7) {
                        sb.append(":");
                    }
                }
                if (inet6Address.getScopeId() > 0) {
                    sb.append("%");
                    sb.append(inet6Address.getScopeId());
                }
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m$1("[", sb.toString(), "]:53");
            } else {
                if (!(inetAddress instanceof Inet4Address)) {
                    throw new IllegalArgumentException("Unsupported Inet type " + inetAddress.getClass());
                }
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m(((Inet4Address) inetAddress).getHostAddress(), ":53");
            }
            arrayList.add(strM);
        }
        Object obj2 = networkObserveModule.curDnsList;
        if (arrayList.isEmpty() || Intrinsics.areEqual(obj2, arrayList)) {
            return;
        }
        Log.i("KoalaClash", "notifyDnsChange " + obj2 + " -> " + arrayList, null);
        networkObserveModule.curDnsList = arrayList;
        Bridge.INSTANCE.nativeNotifyDnsChanged(CollectionsKt.joinToString$default(CollectionsKt.toSet(arrayList), ",", null, null, null, 62));
    }

    public final int networkToInt(Map.Entry entry) {
        int i;
        NetworkCapabilities networkCapabilities = this.connectivity.getNetworkCapabilities((Network) entry.getKey());
        if (networkCapabilities == null) {
            i = 100;
        } else if (networkCapabilities.hasTransport(4)) {
            i = 90;
        } else if (networkCapabilities.hasTransport(1)) {
            i = 0;
        } else if (networkCapabilities.hasTransport(3)) {
            i = 1;
        } else {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 31 && networkCapabilities.hasTransport(8)) {
                i = 2;
            } else if (networkCapabilities.hasTransport(2)) {
                i = 3;
            } else if (networkCapabilities.hasTransport(0)) {
                i = 4;
            } else {
                i = (i2 < 35 || !networkCapabilities.hasTransport(10)) ? 20 : 5;
            }
        }
        return i + (((NetworkInfo) entry.getValue()).losingMs < System.currentTimeMillis() ? 0 : 10);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006d A[Catch: all -> 0x004d, PHI: r1
      0x006d: PHI (r1v5 com.github.kr328.clash.service.clash.module.NetworkObserveModule) = 
      (r1v2 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
      (r1v6 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
     binds: [B:28:0x006c, B:33:0x0095] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {all -> 0x004d, blocks: (B:19:0x0049, B:32:0x008f, B:29:0x006d, B:34:0x0097), top: B:45:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x008e  */
    /* JADX WARN: Code duplicated, block: B:32:0x008f A[Catch: all -> 0x004d, PHI: r1 r12
      0x008f: PHI (r1v6 com.github.kr328.clash.service.clash.module.NetworkObserveModule) = 
      (r1v5 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
      (r1v8 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
     binds: [B:30:0x008c, B:19:0x0049] A[DONT_GENERATE, DONT_INLINE]
      0x008f: PHI (r12v11 java.lang.Object) = (r12v10 java.lang.Object), (r12v2 java.lang.Object) binds: [B:30:0x008c, B:19:0x0049] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x004d, blocks: (B:19:0x0049, B:32:0x008f, B:29:0x006d, B:34:0x0097), top: B:45:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0097 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #1 {all -> 0x004d, blocks: (B:19:0x0049, B:32:0x008f, B:29:0x006d, B:34:0x0097), top: B:45:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008c -> B:32:0x008f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.github.kr328.clash.service.clash.module.Module
    public final java.lang.Object run(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.github.kr328.clash.service.clash.module.NetworkObserveModule.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            com.github.kr328.clash.service.clash.module.NetworkObserveModule$run$1 r0 = (com.github.kr328.clash.service.clash.module.NetworkObserveModule.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L1a
        L13:
            com.github.kr328.clash.service.clash.module.NetworkObserveModule$run$1 r0 = new com.github.kr328.clash.service.clash.module.NetworkObserveModule$run$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r12 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r12
            r0.<init>(r12)
        L1a:
            java.lang.Object r12 = r0.result
            int r1 = r0.label
            r2 = 3
            r3 = 1
            r4 = 2
            r5 = 0
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L52
            if (r1 == r3) goto L45
            if (r1 == r4) goto L3d
            if (r1 == r2) goto L34
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L34:
            java.lang.Object r0 = r0.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lc2
        L3d:
            java.lang.Object r0 = r0.L$0
            kotlin.Unit r0 = (kotlin.Unit) r0
            kotlin.ResultKt.throwOnFailure(r12)
            return r0
        L45:
            java.lang.Object r1 = r0.L$0
            com.github.kr328.clash.service.clash.module.NetworkObserveModule r1 = (com.github.kr328.clash.service.clash.module.NetworkObserveModule) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L4d
            goto L8f
        L4d:
            r12 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto Lae
        L52:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = "NetworkObserve start register"
            com.github.kr328.clash.common.log.Log.i$default(r12)
            android.net.ConnectivityManager r12 = r11.connectivity     // Catch: java.lang.Exception -> L64
            android.net.NetworkRequest r1 = r11.request     // Catch: java.lang.Exception -> L64
            coil.network.RealNetworkObserver$networkCallback$1 r7 = r11.callback     // Catch: java.lang.Exception -> L64
            r12.registerNetworkCallback(r1, r7)     // Catch: java.lang.Exception -> L64
            goto L6c
        L64:
            r12 = move-exception
            java.lang.String r1 = "NetworkObserve register failed"
            java.lang.String r7 = "KoalaClash"
            android.util.Log.w(r7, r1, r12)
        L6c:
            r1 = r11
        L6d:
            kotlinx.coroutines.selects.SelectImplementation r12 = new kotlinx.coroutines.selects.SelectImplementation     // Catch: java.lang.Throwable -> L4d
            kotlin.coroutines.CoroutineContext r7 = r0._context     // Catch: java.lang.Throwable -> L4d
            r12.<init>(r7)     // Catch: java.lang.Throwable -> L4d
            kotlinx.coroutines.channels.BufferedChannel r7 = r1.networks     // Catch: java.lang.Throwable -> L4d
            kotlinx.coroutines.selects.SelectClause1 r7 = r7.getOnReceive()     // Catch: java.lang.Throwable -> L4d
            com.github.kr328.clash.FilesActivity$showError$1 r8 = new com.github.kr328.clash.FilesActivity$showError$1     // Catch: java.lang.Throwable -> L4d
            r9 = 16
            r8.<init>(r1, r5, r9)     // Catch: java.lang.Throwable -> L4d
            r12.invoke(r7, r8)     // Catch: java.lang.Throwable -> L4d
            r0.L$0 = r1     // Catch: java.lang.Throwable -> L4d
            r0.label = r3     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r12 = r12.doSelect(r0)     // Catch: java.lang.Throwable -> L4d
            if (r12 != r6) goto L8f
            goto Lc1
        L8f:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L4d
            boolean r12 = r12.booleanValue()     // Catch: java.lang.Throwable -> L4d
            if (r12 == 0) goto L6d
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L4d
            kotlinx.coroutines.NonCancellable r2 = kotlinx.coroutines.NonCancellable.INSTANCE
            coil.disk.DiskLruCache$launchCleanup$1 r3 = new coil.disk.DiskLruCache$launchCleanup$1
            r7 = 9
            r3.<init>(r1, r5, r7)
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r0 = kotlinx.coroutines.JobKt.withContext(r2, r3, r0)
            if (r0 != r6) goto Lad
            goto Lc1
        Lad:
            return r12
        Lae:
            kotlinx.coroutines.NonCancellable r3 = kotlinx.coroutines.NonCancellable.INSTANCE
            coil.disk.DiskLruCache$launchCleanup$1 r4 = new coil.disk.DiskLruCache$launchCleanup$1
            r7 = 9
            r4.<init>(r1, r5, r7)
            r12.L$0 = r0
            r12.label = r2
            java.lang.Object r12 = kotlinx.coroutines.JobKt.withContext(r3, r4, r12)
            if (r12 != r6) goto Lc2
        Lc1:
            return r6
        Lc2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.clash.module.NetworkObserveModule.run(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
