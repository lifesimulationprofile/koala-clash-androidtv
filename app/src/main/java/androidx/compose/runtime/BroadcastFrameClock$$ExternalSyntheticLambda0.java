package androidx.compose.runtime;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.material3.ThumbNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BroadcastFrameClock$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long f$0;

    public /* synthetic */ BroadcastFrameClock$$ExternalSyntheticLambda0(int i, long j) {
        this.$r8$classId = i;
        this.f$0 = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CancellableContinuationImpl cancellableContinuationImpl;
        Object failure;
        switch (this.$r8$classId) {
            case 0:
                long j = this.f$0;
                BroadcastFrameClock.FrameAwaiter frameAwaiter = (BroadcastFrameClock.FrameAwaiter) obj;
                Function1 function1 = frameAwaiter.onFrame;
                if (function1 != null && (cancellableContinuationImpl = frameAwaiter.continuation) != null) {
                    try {
                        failure = function1.invoke(Long.valueOf(j));
                    } catch (Throwable th) {
                        failure = new Result.Failure(th);
                    }
                    cancellableContinuationImpl.resumeWith(failure);
                    break;
                }
                return Unit.INSTANCE;
            case 1:
                CacheDrawScope cacheDrawScope = (CacheDrawScope) obj;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo337getSizeNHjbRc() >> 32)) / 2.0f;
                return cacheDrawScope.onDrawWithContent(new ThumbNode$$ExternalSyntheticLambda0(fIntBitsToFloat, SimpleLayoutKt.createHandleImage(cacheDrawScope, fIntBitsToFloat), new BlendModeColorFilter(5, this.f$0)));
            default:
                ((SemanticsPropertyReceiver) obj).set(SelectionHandlesKt.SelectionHandleInfoKey, new SelectionHandleInfo(Handle.Cursor, this.f$0, 2, true));
                return Unit.INSTANCE;
        }
    }
}
