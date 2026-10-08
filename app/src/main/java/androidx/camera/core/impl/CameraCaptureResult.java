package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface CameraCaptureResult {
    CameraCaptureMetaData$AeState getAeState();

    CameraCaptureMetaData$AfState getAfState();

    CameraCaptureMetaData$AwbState getAwbState();

    CaptureResult getCaptureResult();

    TagBundle getTagBundle();

    long getTimestamp();
}
