package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutatorMutex$mutateWith$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $block;
    public final /* synthetic */ Object $priority;
    public final /* synthetic */ int $r8$classId = 2;
    public Object $receiver;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutatorMutex$mutateWith$2(Context context, UUID uuid, Continuation continuation) {
        super(2, continuation);
        this.$priority = uuid;
        this.$block = context;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$2 = new MutatorMutex$mutateWith$2((MutatePriority) this.$priority, (MutatorMutex) this.this$0, (SuspendLambda) this.$block, (DefaultScrollableState$scrollScope$1) this.$receiver, continuation);
                mutatorMutex$mutateWith$2.L$0 = obj;
                return mutatorMutex$mutateWith$2;
            case 1:
                MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$3 = new MutatorMutex$mutateWith$2((Map) this.L$0, (MutableState) this.L$3, (MutableState) this.$receiver, (MutableState) this.L$4, (MutableState) this.this$0, (ParcelableSnapshotMutableLongState) this.$priority, (ParcelableSnapshotMutableLongState) this.$block, continuation);
                mutatorMutex$mutateWith$3.L$2 = obj;
                return mutatorMutex$mutateWith$3;
            default:
                return new MutatorMutex$mutateWith$2((Context) this.$block, (UUID) this.$priority, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((MutatorMutex$mutateWith$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:138:0x034b A[Catch: Exception -> 0x0468, TRY_ENTER, TryCatch #12 {Exception -> 0x0468, blocks: (B:138:0x034b, B:141:0x035d, B:142:0x0381, B:144:0x0387, B:145:0x0393, B:146:0x03a6, B:148:0x03ac, B:171:0x0430, B:172:0x0450, B:174:0x0456, B:175:0x0462, B:120:0x02ca), top: B:251:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:140:0x035b  */
    /* JADX WARN: Code duplicated, block: B:144:0x0387 A[Catch: Exception -> 0x0468, LOOP:0: B:142:0x0381->B:144:0x0387, LOOP_END, TryCatch #12 {Exception -> 0x0468, blocks: (B:138:0x034b, B:141:0x035d, B:142:0x0381, B:144:0x0387, B:145:0x0393, B:146:0x03a6, B:148:0x03ac, B:171:0x0430, B:172:0x0450, B:174:0x0456, B:175:0x0462, B:120:0x02ca), top: B:251:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:148:0x03ac A[Catch: Exception -> 0x0468, TRY_LEAVE, TryCatch #12 {Exception -> 0x0468, blocks: (B:138:0x034b, B:141:0x035d, B:142:0x0381, B:144:0x0387, B:145:0x0393, B:146:0x03a6, B:148:0x03ac, B:171:0x0430, B:172:0x0450, B:174:0x0456, B:175:0x0462, B:120:0x02ca), top: B:251:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:151:0x03b9 A[Catch: Exception -> 0x03bf, TryCatch #7 {Exception -> 0x03bf, blocks: (B:149:0x03b0, B:151:0x03b9, B:154:0x03c2, B:156:0x03c8, B:158:0x03d4, B:160:0x03e4, B:161:0x03e8), top: B:244:0x03b0 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x03c8 A[Catch: Exception -> 0x03bf, TryCatch #7 {Exception -> 0x03bf, blocks: (B:149:0x03b0, B:151:0x03b9, B:154:0x03c2, B:156:0x03c8, B:158:0x03d4, B:160:0x03e4, B:161:0x03e8), top: B:244:0x03b0 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x03d4 A[Catch: Exception -> 0x03bf, TryCatch #7 {Exception -> 0x03bf, blocks: (B:149:0x03b0, B:151:0x03b9, B:154:0x03c2, B:156:0x03c8, B:158:0x03d4, B:160:0x03e4, B:161:0x03e8), top: B:244:0x03b0 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x042f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0456 A[Catch: Exception -> 0x0468, LOOP:3: B:172:0x0450->B:174:0x0456, LOOP_END, TryCatch #12 {Exception -> 0x0468, blocks: (B:138:0x034b, B:141:0x035d, B:142:0x0381, B:144:0x0387, B:145:0x0393, B:146:0x03a6, B:148:0x03ac, B:171:0x0430, B:172:0x0450, B:174:0x0456, B:175:0x0462, B:120:0x02ca), top: B:251:0x02ca }] */
    /* JADX WARN: Code duplicated, block: B:266:0x03bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:268:0x03e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:270:0x03d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v30, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r37v0 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v49, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r3v67 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v69 */
    /* JADX WARN: Type inference failed for: r3v70 */
    /* JADX WARN: Type inference failed for: r3v71 */
    /* JADX WARN: Type inference failed for: r3v72 */
    /* JADX WARN: Type inference failed for: r3v73 */
    /* JADX WARN: Type inference failed for: r3v74 */
    /* JADX WARN: Type inference failed for: r3v75 */
    /* JADX WARN: Type inference failed for: r3v76 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x047c -> B:181:0x047f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r39) {
        /*
            Method dump skipped, instruction units count: 1374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MutatorMutex$mutateWith$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutatorMutex$mutateWith$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function2 function2, DefaultScrollableState$scrollScope$1 defaultScrollableState$scrollScope$1, Continuation continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = mutatorMutex;
        this.$block = (SuspendLambda) function2;
        this.$receiver = defaultScrollableState$scrollScope$1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutatorMutex$mutateWith$2(Map map, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2, Continuation continuation) {
        super(2, continuation);
        this.L$0 = map;
        this.L$3 = mutableState;
        this.$receiver = mutableState2;
        this.L$4 = mutableState3;
        this.this$0 = mutableState4;
        this.$priority = parcelableSnapshotMutableLongState;
        this.$block = parcelableSnapshotMutableLongState2;
    }
}
