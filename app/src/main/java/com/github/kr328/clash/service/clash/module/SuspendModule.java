package com.github.kr328.clash.service.clash.module;

import android.app.Service;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SuspendModule extends Module {
    public final /* synthetic */ int $r8$classId;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.clash.module.SuspendModule$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            SuspendModule.this.run(this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuspendModule(Service service, int i) {
        super(service);
        this.$r8$classId = i;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x027b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0284 A[Catch: all -> 0x0232, TryCatch #0 {all -> 0x0232, blocks: (B:89:0x022e, B:101:0x027c, B:103:0x0284, B:108:0x0293, B:110:0x0299, B:98:0x0271, B:111:0x02aa, B:114:0x02b1, B:115:0x02c2), top: B:121:0x022e }] */
    /* JADX WARN: Code duplicated, block: B:105:0x028d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0292 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:108:0x0293 A[Catch: all -> 0x0232, TryCatch #0 {all -> 0x0232, blocks: (B:89:0x022e, B:101:0x027c, B:103:0x0284, B:108:0x0293, B:110:0x0299, B:98:0x0271, B:111:0x02aa, B:114:0x02b1, B:115:0x02c2), top: B:121:0x022e }] */
    /* JADX WARN: Code duplicated, block: B:111:0x02aa A[Catch: all -> 0x0232, TryCatch #0 {all -> 0x0232, blocks: (B:89:0x022e, B:101:0x027c, B:103:0x0284, B:108:0x0293, B:110:0x0299, B:98:0x0271, B:111:0x02aa, B:114:0x02b1, B:115:0x02c2), top: B:121:0x022e }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:114:0x02b1 A[Catch: all -> 0x0232, TryCatch #0 {all -> 0x0232, blocks: (B:89:0x022e, B:101:0x027c, B:103:0x0284, B:108:0x0293, B:110:0x0299, B:98:0x0271, B:111:0x02aa, B:114:0x02b1, B:115:0x02c2), top: B:121:0x022e }] */
    /* JADX WARN: Code duplicated, block: B:115:0x02c2 A[Catch: all -> 0x0232, TRY_LEAVE, TryCatch #0 {all -> 0x0232, blocks: (B:89:0x022e, B:101:0x027c, B:103:0x0284, B:108:0x0293, B:110:0x0299, B:98:0x0271, B:111:0x02aa, B:114:0x02b1, B:115:0x02c2), top: B:121:0x022e }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0206  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01ef -> B:31:0x009c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0279 -> B:101:0x027c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:103:0x0284
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.github.kr328.clash.service.clash.module.Module
    public final java.lang.Object run(kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.clash.module.SuspendModule.run(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
