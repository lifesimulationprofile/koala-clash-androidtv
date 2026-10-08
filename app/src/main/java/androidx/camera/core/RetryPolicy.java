package androidx.camera.core;

import androidx.camera.core.impl.CameraProviderExecutionState;
import androidx.camera.core.impl.CameraProviderInitRetryPolicy;
import androidx.camera.core.impl.TimeoutRetryPolicy;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface RetryPolicy {
    public static final CameraProviderInitRetryPolicy DEFAULT;

    /* JADX INFO: renamed from: androidx.camera.core.RetryPolicy$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class CC {
        public static final /* synthetic */ int $r8$clinit = 0;

        static {
            CameraProviderInitRetryPolicy cameraProviderInitRetryPolicy = RetryPolicy.DEFAULT;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RetryConfig {
        public static final RetryConfig COMPLETE_WITHOUT_FAILURE;
        public final boolean mCompleteWithoutFailure;
        public final long mDelayInMillis;
        public final boolean mShouldRetry;
        public static final RetryConfig NOT_RETRY = new RetryConfig(false, 0, false);
        public static final RetryConfig DEFAULT_DELAY_RETRY = new RetryConfig(true, 500, false);

        static {
            new RetryConfig(true, 100L, false);
            COMPLETE_WITHOUT_FAILURE = new RetryConfig(false, 0L, true);
        }

        public RetryConfig(boolean z, long j, boolean z2) {
            this.mShouldRetry = z;
            this.mDelayInMillis = j;
            if (z2) {
                Preconditions.checkArgument("shouldRetry must be false when completeWithoutFailure is set to true", !z);
            }
            this.mCompleteWithoutFailure = z2;
        }
    }

    static {
        int i = CC.$r8$clinit;
        DEFAULT = new CameraProviderInitRetryPolicy(1, 6000L);
        new TimeoutRetryPolicy(6000L, new CameraProviderInitRetryPolicy.AnonymousClass1(6000L));
    }

    long getTimeoutInMillis();

    RetryConfig onRetryDecisionRequested(CameraProviderExecutionState cameraProviderExecutionState);
}
