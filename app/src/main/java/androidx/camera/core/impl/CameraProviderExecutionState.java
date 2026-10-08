package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import java.io.Serializable;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraProviderExecutionState {
    public final Serializable mCause;
    public final int mStatus;
    public final long mTaskExecutedTimeInMillis;

    public CameraProviderExecutionState(long j, Exception exc) {
        this.mTaskExecutedTimeInMillis = SystemClock.elapsedRealtime() - j;
        if (exc instanceof CameraValidator.CameraIdListIncorrectException) {
            this.mStatus = 2;
            this.mCause = exc;
            return;
        }
        if (!(exc instanceof InitializationException)) {
            this.mStatus = 0;
            this.mCause = exc;
            return;
        }
        Throwable cause = exc.getCause();
        exc = cause != null ? cause : exc;
        this.mCause = exc;
        if (exc instanceof CameraUnavailableException) {
            this.mStatus = 2;
        } else if (exc instanceof IllegalArgumentException) {
            this.mStatus = 1;
        } else {
            this.mStatus = 0;
        }
    }

    public CameraProviderExecutionState(int i, URL url, long j) {
        this.mStatus = i;
        this.mCause = url;
        this.mTaskExecutedTimeInMillis = j;
    }
}
