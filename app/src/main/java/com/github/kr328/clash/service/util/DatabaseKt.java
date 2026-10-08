package com.github.kr328.clash.service.util;

import java.util.UUID;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DatabaseKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.service.util.DatabaseKt$generateProfileUUID$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public UUID L$0;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatabaseKt.generateProfileUUID(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0050  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0045 -> B:18:0x0048). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object generateProfileUUID(kotlin.coroutines.jvm.internal.ContinuationImpl r4) {
        /*
            boolean r0 = r4 instanceof com.github.kr328.clash.service.util.DatabaseKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r4
            com.github.kr328.clash.service.util.DatabaseKt$generateProfileUUID$1 r0 = (com.github.kr328.clash.service.util.DatabaseKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.github.kr328.clash.service.util.DatabaseKt$generateProfileUUID$1 r0 = new com.github.kr328.clash.service.util.DatabaseKt$generateProfileUUID$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            java.util.UUID r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r4)
            goto L48
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2f:
            kotlin.ResultKt.throwOnFailure(r4)
            java.util.UUID r4 = java.util.UUID.randomUUID()
            r1 = r4
        L37:
            okhttp3.Dispatcher r4 = com.github.kr328.clash.service.data.DaosKt.ImportedDao()
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.exists(r1, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r4 != r3) goto L48
            return r3
        L48:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L55
            java.util.UUID r1 = java.util.UUID.randomUUID()
            goto L37
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.util.DatabaseKt.generateProfileUUID(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
