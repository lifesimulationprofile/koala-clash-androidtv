package com.github.kr328.clash.util;

import com.github.kr328.clash.service.remote.IRemoteService;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RemoteKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.util.RemoteKt$withClash$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public CoroutineContext L$0;
        public Function2 L$1;
        public IRemoteService L$2;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteKt.withClash(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.util.RemoteKt$withProfile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00441 extends ContinuationImpl {
        public CoroutineContext L$0;
        public Function2 L$1;
        public IRemoteService L$2;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteKt.withProfile(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:29:0x007a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static final java.lang.Object withClash(kotlin.coroutines.CoroutineContext r9, kotlin.jvm.functions.Function2 r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof com.github.kr328.clash.util.RemoteKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.github.kr328.clash.util.RemoteKt$withClash$1 r0 = (com.github.kr328.clash.util.RemoteKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.github.kr328.clash.util.RemoteKt$withClash$1 r0 = new com.github.kr328.clash.util.RemoteKt$withClash$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L44
            if (r2 == r3) goto L3c
            if (r2 != r4) goto L34
            com.github.kr328.clash.service.remote.IRemoteService r9 = r0.L$2
            kotlin.jvm.functions.Function2 r10 = r0.L$1
            kotlin.coroutines.CoroutineContext r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: android.os.DeadObjectException -> L31
            return r11
        L31:
            r11 = r10
            r10 = r2
            goto L7d
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            kotlin.jvm.functions.Function2 r9 = r0.L$1
            kotlin.coroutines.CoroutineContext r10 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5d
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
        L47:
            com.github.kr328.clash.remote.Service r11 = com.github.kr328.clash.remote.Remote.service
            okhttp3.internal.cache.CacheStrategy r11 = r11.remote
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r11 = r11.get(r0)
            if (r11 != r1) goto L5a
            goto L78
        L5a:
            r8 = r10
            r10 = r9
            r9 = r8
        L5d:
            com.github.kr328.clash.service.remote.IRemoteService r11 = (com.github.kr328.clash.service.remote.IRemoteService) r11
            com.github.kr328.clash.service.remote.IClashManager r2 = r11.clash()
            com.github.kr328.clash.FilesActivity$showError$1 r6 = new com.github.kr328.clash.FilesActivity$showError$1     // Catch: android.os.DeadObjectException -> L7a
            r7 = 17
            r6.<init>(r9, r2, r5, r7)     // Catch: android.os.DeadObjectException -> L7a
            r0.L$0 = r10     // Catch: android.os.DeadObjectException -> L7a
            r0.L$1 = r9     // Catch: android.os.DeadObjectException -> L7a
            r0.L$2 = r11     // Catch: android.os.DeadObjectException -> L7a
            r0.label = r4     // Catch: android.os.DeadObjectException -> L7a
            java.lang.Object r9 = kotlinx.coroutines.JobKt.withContext(r10, r6, r0)     // Catch: android.os.DeadObjectException -> L7a
            if (r9 != r1) goto L79
        L78:
            return r1
        L79:
            return r9
        L7a:
            r8 = r11
            r11 = r9
            r9 = r8
        L7d:
            java.lang.String r2 = "Remote services panic"
            com.github.kr328.clash.common.log.Log.w$default(r2)
            com.github.kr328.clash.remote.Service r2 = com.github.kr328.clash.remote.Remote.service
            okhttp3.internal.cache.CacheStrategy r2 = r2.remote
            monitor-enter(r2)
            java.lang.Object r6 = r2.cacheResponse     // Catch: java.lang.Throwable -> L8e
            if (r6 != r9) goto L90
            r2.cacheResponse = r5     // Catch: java.lang.Throwable -> L8e
            goto L90
        L8e:
            r9 = move-exception
            goto L94
        L90:
            monitor-exit(r2)
            r9 = r10
            r10 = r11
            goto L47
        L94:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L8e
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.util.RemoteKt.withClash(kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static Object withClash$default(Function2 function2, Continuation continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return withClash(DefaultIoScheduler.INSTANCE, function2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:29:0x007a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static final java.lang.Object withProfile(kotlin.coroutines.CoroutineContext r9, kotlin.jvm.functions.Function2 r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            boolean r0 = r11 instanceof com.github.kr328.clash.util.RemoteKt.C00441
            if (r0 == 0) goto L13
            r0 = r11
            com.github.kr328.clash.util.RemoteKt$withProfile$1 r0 = (com.github.kr328.clash.util.RemoteKt.C00441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.github.kr328.clash.util.RemoteKt$withProfile$1 r0 = new com.github.kr328.clash.util.RemoteKt$withProfile$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L44
            if (r2 == r3) goto L3c
            if (r2 != r4) goto L34
            com.github.kr328.clash.service.remote.IRemoteService r9 = r0.L$2
            kotlin.jvm.functions.Function2 r10 = r0.L$1
            kotlin.coroutines.CoroutineContext r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: android.os.DeadObjectException -> L31
            return r11
        L31:
            r11 = r10
            r10 = r2
            goto L7d
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            kotlin.jvm.functions.Function2 r9 = r0.L$1
            kotlin.coroutines.CoroutineContext r10 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5d
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
        L47:
            com.github.kr328.clash.remote.Service r11 = com.github.kr328.clash.remote.Remote.service
            okhttp3.internal.cache.CacheStrategy r11 = r11.remote
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r11 = r11.get(r0)
            if (r11 != r1) goto L5a
            goto L78
        L5a:
            r8 = r10
            r10 = r9
            r9 = r8
        L5d:
            com.github.kr328.clash.service.remote.IRemoteService r11 = (com.github.kr328.clash.service.remote.IRemoteService) r11
            com.github.kr328.clash.service.remote.IProfileManager r2 = r11.profile()
            com.github.kr328.clash.FilesActivity$showError$1 r6 = new com.github.kr328.clash.FilesActivity$showError$1     // Catch: android.os.DeadObjectException -> L7a
            r7 = 18
            r6.<init>(r9, r2, r5, r7)     // Catch: android.os.DeadObjectException -> L7a
            r0.L$0 = r10     // Catch: android.os.DeadObjectException -> L7a
            r0.L$1 = r9     // Catch: android.os.DeadObjectException -> L7a
            r0.L$2 = r11     // Catch: android.os.DeadObjectException -> L7a
            r0.label = r4     // Catch: android.os.DeadObjectException -> L7a
            java.lang.Object r9 = kotlinx.coroutines.JobKt.withContext(r10, r6, r0)     // Catch: android.os.DeadObjectException -> L7a
            if (r9 != r1) goto L79
        L78:
            return r1
        L79:
            return r9
        L7a:
            r8 = r11
            r11 = r9
            r9 = r8
        L7d:
            java.lang.String r2 = "Remote services panic"
            com.github.kr328.clash.common.log.Log.w$default(r2)
            com.github.kr328.clash.remote.Service r2 = com.github.kr328.clash.remote.Remote.service
            okhttp3.internal.cache.CacheStrategy r2 = r2.remote
            monitor-enter(r2)
            java.lang.Object r6 = r2.cacheResponse     // Catch: java.lang.Throwable -> L8e
            if (r6 != r9) goto L90
            r2.cacheResponse = r5     // Catch: java.lang.Throwable -> L8e
            goto L90
        L8e:
            r9 = move-exception
            goto L94
        L90:
            monitor-exit(r2)
            r9 = r10
            r10 = r11
            goto L47
        L94:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L8e
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.util.RemoteKt.withProfile(kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static Object withProfile$default(Function2 function2, ContinuationImpl continuationImpl) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return withProfile(DefaultIoScheduler.INSTANCE, function2, continuationImpl);
    }
}
