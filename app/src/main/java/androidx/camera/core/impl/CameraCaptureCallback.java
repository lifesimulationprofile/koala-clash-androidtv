package androidx.camera.core.impl;

import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CameraCaptureCallback {
    public void onCaptureCancelled(int i) {
    }

    public void onCaptureStarted(int i) {
    }

    public void onCaptureCompleted(int i, CameraCaptureResult cameraCaptureResult) {
    }

    public void onCaptureFailed(int i, Path.Companion companion) {
    }
}
