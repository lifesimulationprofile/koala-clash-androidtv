package kotlinx.coroutines.flow.internal;

import androidx.compose.animation.core.internal.PlatformOptimizedCancellationException_jvmAndAndroidKt;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ChildCancelledException extends CancellationException {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChildCancelledException(String str, int i) {
        super(str);
        this.$r8$classId = i;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        switch (this.$r8$classId) {
            case 0:
                setStackTrace(new StackTraceElement[0]);
                break;
            default:
                setStackTrace(PlatformOptimizedCancellationException_jvmAndAndroidKt.EmptyStackTraceElements);
                break;
        }
        return this;
    }
}
