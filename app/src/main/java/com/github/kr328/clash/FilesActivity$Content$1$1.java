package com.github.kr328.clash;

import android.content.Context;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.lifecycle.Lifecycle;
import com.github.kr328.clash.remote.FilesClient;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FilesActivity$Content$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $client;
    public Object $configurationEditable$delegate;
    public Object $files$delegate;
    public final /* synthetic */ int $r8$classId = 5;
    public Object $stack;
    public final /* synthetic */ Object $uuidStr;
    public int label;
    public Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$1$1(Context context, UUID uuid, Continuation continuation) {
        super(2, continuation);
        this.$uuidStr = uuid;
        this.$client = context;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r6v7, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new FilesActivity$Content$1$1((FilesActivity) this.this$0, (MutableState) this.$configurationEditable$delegate, (SnapshotStateList) this.$stack, (String) this.$uuidStr, (FilesClient) this.$client, (MutableState) this.$files$delegate, continuation);
            case 1:
                FilesActivity$Content$1$1 filesActivity$Content$1$1 = new FilesActivity$Content$1$1((Channel) this.$uuidStr, (Animatable) this.$client, (MutableState) this.$configurationEditable$delegate, (MutableState) this.$files$delegate, continuation);
                filesActivity$Content$1$1.$stack = obj;
                return filesActivity$Content$1$1;
            case 2:
                FilesActivity$Content$1$1 filesActivity$Content$1$2 = new FilesActivity$Content$1$1((MutatorMutex) this.$uuidStr, (Function1) this.$client, continuation);
                filesActivity$Content$1$2.$stack = obj;
                return filesActivity$Content$1$2;
            case 3:
                FilesActivity$Content$1$1 filesActivity$Content$1$3 = new FilesActivity$Content$1$1((PointerInputScope) this.$configurationEditable$delegate, (Function1) this.$files$delegate, (Function1) this.$stack, (Function3) this.$uuidStr, (Function1) this.$client, continuation);
                filesActivity$Content$1$3.this$0 = obj;
                return filesActivity$Content$1$3;
            case 4:
                return new FilesActivity$Content$1$1((Lifecycle) this.$files$delegate, (Lifecycle.State) this.$stack, (CoroutineScope) this.$uuidStr, (Function2) this.$client, continuation);
            default:
                return new FilesActivity$Content$1$1((Context) this.$client, (UUID) this.$uuidStr, continuation);
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
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        return ((FilesActivity$Content$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:196:0x03de  */
    /* JADX WARN: Code duplicated, block: B:199:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:201:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:202:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:262:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v4, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r4v11, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:192:0x03d3 -> B:194:0x03d6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r36) {
        /*
            Method dump skipped, instruction units count: 1170
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.FilesActivity$Content$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FilesActivity$Content$1$1(MutatorMutex mutatorMutex, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.$uuidStr = mutatorMutex;
        this.$client = (SuspendLambda) function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$1$1(PointerInputScope pointerInputScope, Function1 function1, Function1 function2, Function3 function3, Function1 function4, Continuation continuation) {
        super(2, continuation);
        this.$configurationEditable$delegate = pointerInputScope;
        this.$files$delegate = function1;
        this.$stack = function2;
        this.$uuidStr = function3;
        this.$client = function4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FilesActivity$Content$1$1(Lifecycle lifecycle, Lifecycle.State state, CoroutineScope coroutineScope, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$files$delegate = lifecycle;
        this.$stack = state;
        this.$uuidStr = coroutineScope;
        this.$client = (SuspendLambda) function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$1$1(FilesActivity filesActivity, MutableState mutableState, SnapshotStateList snapshotStateList, String str, FilesClient filesClient, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filesActivity;
        this.$configurationEditable$delegate = mutableState;
        this.$stack = snapshotStateList;
        this.$uuidStr = str;
        this.$client = filesClient;
        this.$files$delegate = mutableState2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$1$1(Channel channel, Animatable animatable, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$uuidStr = channel;
        this.$client = animatable;
        this.$configurationEditable$delegate = mutableState;
        this.$files$delegate = mutableState2;
    }
}
