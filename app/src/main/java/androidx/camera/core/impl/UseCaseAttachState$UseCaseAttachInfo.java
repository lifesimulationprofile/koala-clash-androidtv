package androidx.camera.core.impl;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UseCaseAttachState$UseCaseAttachInfo {
    public final List mCaptureTypes;
    public final SessionConfig mSessionConfig;
    public final AutoValue_StreamSpec mStreamSpec;
    public final UseCaseConfig mUseCaseConfig;
    public boolean mAttached = false;
    public boolean mActive = false;

    public UseCaseAttachState$UseCaseAttachInfo(SessionConfig sessionConfig, UseCaseConfig useCaseConfig, AutoValue_StreamSpec autoValue_StreamSpec, List list) {
        this.mSessionConfig = sessionConfig;
        this.mUseCaseConfig = useCaseConfig;
        this.mStreamSpec = autoValue_StreamSpec;
        this.mCaptureTypes = list;
    }

    public final String toString() {
        return "UseCaseAttachInfo{mSessionConfig=" + this.mSessionConfig + ", mUseCaseConfig=" + this.mUseCaseConfig + ", mStreamSpec=" + this.mStreamSpec + ", mCaptureTypes=" + this.mCaptureTypes + ", mAttached=" + this.mAttached + ", mActive=" + this.mActive + '}';
    }
}
