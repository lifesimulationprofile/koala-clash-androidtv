package com.github.kr328.clash;

import android.net.Uri;
import android.os.IBinder;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.remote.FilesClient;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FilesActivity$Content$5$1$1$1 extends SuspendLambda implements Function2 {
    public Object $client;
    public final /* synthetic */ Object $files$delegate;
    public Object $newName;
    public final /* synthetic */ int $r8$classId = 3;
    public final /* synthetic */ Object $stack;
    public Object $target;
    public Object $uuidStr;
    public /* synthetic */ Object L$0;
    public int label;
    public Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$5$1$1$1(IBinder iBinder, LogcatService logcatService, Continuation continuation) {
        super(2, continuation);
        this.$stack = iBinder;
        this.$files$delegate = logcatService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                FilesActivity$Content$5$1$1$1 filesActivity$Content$5$1$1$1 = new FilesActivity$Content$5$1$1$1((FilesActivity) this.this$0, (FilesClient) this.$client, (File) this.$target, (String) this.$newName, (SnapshotStateList) this.$stack, (String) this.$uuidStr, (MutableState) this.$files$delegate, continuation);
                filesActivity$Content$5$1$1$1.L$0 = obj;
                return filesActivity$Content$5$1$1$1;
            case 1:
                FilesActivity$Content$5$1$1$1 filesActivity$Content$5$1$1$2 = new FilesActivity$Content$5$1$1$1((FilesActivity) this.this$0, (FilesClient) this.$client, (SnapshotStateList) this.$stack, (Uri) this.$target, (String) this.$newName, (String) this.$uuidStr, (MutableState) this.$files$delegate, continuation);
                filesActivity$Content$5$1$1$2.L$0 = obj;
                return filesActivity$Content$5$1$1$2;
            case 2:
                FilesActivity$Content$5$1$1$1 filesActivity$Content$5$1$1$3 = new FilesActivity$Content$5$1$1$1((FilesActivity) this.this$0, (FilesClient) this.$client, (File) this.$target, (Uri) this.$uuidStr, (SnapshotStateList) this.$stack, (String) this.$newName, (MutableState) this.$files$delegate, continuation);
                filesActivity$Content$5$1$1$3.L$0 = obj;
                return filesActivity$Content$5$1$1$3;
            default:
                FilesActivity$Content$5$1$1$1 filesActivity$Content$5$1$1$4 = new FilesActivity$Content$5$1$1$1((IBinder) this.$stack, (LogcatService) this.$files$delegate, continuation);
                filesActivity$Content$5$1$1$4.L$0 = obj;
                return filesActivity$Content$5$1$1$4;
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
        }
        return ((FilesActivity$Content$5$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00d0 A[Catch: all -> 0x0065, TRY_ENTER, TryCatch #5 {all -> 0x0065, blocks: (B:16:0x0055, B:33:0x00d0, B:37:0x00ef, B:21:0x0082), top: B:173:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:40:0x0142  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v79, types: [com.github.kr328.clash.log.LogcatWriter, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r0v96 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0142 -> B:41:0x0149). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 868
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.FilesActivity$Content$5$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$5$1$1$1(FilesActivity filesActivity, FilesClient filesClient, SnapshotStateList snapshotStateList, Uri uri, String str, String str2, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filesActivity;
        this.$client = filesClient;
        this.$stack = snapshotStateList;
        this.$target = uri;
        this.$newName = str;
        this.$uuidStr = str2;
        this.$files$delegate = mutableState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$5$1$1$1(FilesActivity filesActivity, FilesClient filesClient, File file, Uri uri, SnapshotStateList snapshotStateList, String str, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filesActivity;
        this.$client = filesClient;
        this.$target = file;
        this.$uuidStr = uri;
        this.$stack = snapshotStateList;
        this.$newName = str;
        this.$files$delegate = mutableState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$5$1$1$1(FilesActivity filesActivity, FilesClient filesClient, File file, String str, SnapshotStateList snapshotStateList, String str2, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filesActivity;
        this.$client = filesClient;
        this.$target = file;
        this.$newName = str;
        this.$stack = snapshotStateList;
        this.$uuidStr = str2;
        this.$files$delegate = mutableState;
    }
}
