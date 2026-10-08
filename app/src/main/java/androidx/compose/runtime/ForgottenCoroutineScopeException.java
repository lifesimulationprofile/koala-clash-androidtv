package androidx.compose.runtime;

import androidx.compose.ui.internal.PlatformOptimizedCancellationException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ForgottenCoroutineScopeException extends PlatformOptimizedCancellationException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForgottenCoroutineScopeException(int i) {
        super("rememberCoroutineScope left the composition", 2);
        switch (i) {
            case 1:
                super("The coroutine scope left the composition", 2);
                break;
            default:
                break;
        }
    }
}
