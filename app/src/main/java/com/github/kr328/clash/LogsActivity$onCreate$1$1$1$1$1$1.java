package com.github.kr328.clash;

import com.github.kr328.clash.design.model.LogFile;
import java.io.File;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogsActivity$onCreate$1$1$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LogsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogsActivity$onCreate$1$1$1$1$1$1(LogsActivity logsActivity, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = logsActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new LogsActivity$onCreate$1$1$1$1$1$1(this.this$0, continuation, 0);
            default:
                return new LogsActivity$onCreate$1$1$1$1$1$1(this.this$0, continuation, 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((LogsActivity$onCreate$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.$r8$classId;
        LogsActivity logsActivity = this.this$0;
        switch (i) {
            case 0:
                ResultKt.throwOnFailure(obj);
                int i2 = LogsActivity.$r8$clinit;
                File[] fileArrListFiles = FilesKt.resolve(logsActivity.getCacheDir(), "logs").listFiles();
                Iterable<File> list = fileArrListFiles != null ? ArraysKt.toList(fileArrListFiles) : EmptyList.INSTANCE;
                ArrayList arrayList = new ArrayList();
                for (File file : list) {
                    Regex regex = LogFile.REGEX_FILE;
                    LogFile fromFileName = LogFile.Companion.parseFromFileName(file.getName());
                    if (fromFileName != null) {
                        arrayList.add(fromFileName);
                    }
                }
                return CollectionsKt.sortedWith(arrayList, new LogsActivity$loadFiles$$inlined$sortedByDescending$1());
            default:
                ResultKt.throwOnFailure(obj);
                int i3 = LogsActivity.$r8$clinit;
                FilesKt.deleteRecursively(FilesKt.resolve(logsActivity.getCacheDir(), "logs"));
                return Unit.INSTANCE;
        }
    }
}
