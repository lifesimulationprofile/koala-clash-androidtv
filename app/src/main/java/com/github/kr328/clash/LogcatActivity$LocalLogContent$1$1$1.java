package com.github.kr328.clash;

import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.log.LogcatReader$$ExternalSyntheticLambda3;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatActivity$LocalLogContent$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ LogFile $file;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LogcatActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogcatActivity$LocalLogContent$1$1$1(LogcatActivity logcatActivity, LogFile logFile, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = logcatActivity;
        this.$file = logFile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new LogcatActivity$LocalLogContent$1$1$1(this.this$0, this.$file, continuation, 0);
            default:
                return new LogcatActivity$LocalLogContent$1$1$1(this.this$0, this.$file, continuation, 1);
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
        return ((LogcatActivity$LocalLogContent$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(FilesKt.resolve(FilesKt.resolve(this.this$0.getCacheDir(), "logs"), this.$file.fileName)));
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = new Date(0L);
                return SequencesKt.toList(new GeneratorSequence(new GeneratorSequence(SequencesKt.filter(new GeneratorSequence(new ConstrainedOnceSequence(new LinesSequence(0, bufferedReader)), new AsyncImagePainter$$ExternalSyntheticLambda0(29), 3), new Remote$$ExternalSyntheticLambda1(1)), new Remote$$ExternalSyntheticLambda1(2), 3), new LogcatReader$$ExternalSyntheticLambda3(ref$ObjectRef, 0), 3));
            default:
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(FilesKt.resolve(FilesKt.resolve(this.this$0.getCacheDir(), "logs"), this.$file.fileName).delete());
        }
    }
}
