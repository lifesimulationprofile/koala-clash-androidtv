package androidx.camera.core.impl;

import android.util.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CaptureConfig {
    public final List mCameraCaptureCallbacks;
    public final CameraCaptureResult mCameraCaptureResult;
    public final OptionsBundle mImplementationOptions;
    public final ArrayList mSurfaces;
    public final TagBundle mTagBundle;
    public final int mTemplateType;
    public final boolean mUseRepeatingSurface;
    public static final AutoValue_Config_Option OPTION_ROTATION = new AutoValue_Config_Option("camerax.core.captureConfig.rotation", Integer.TYPE, null);
    public static final AutoValue_Config_Option OPTION_JPEG_QUALITY = new AutoValue_Config_Option("camerax.core.captureConfig.jpegQuality", Integer.class, null);
    public static final AutoValue_Config_Option OPTION_RESOLVED_FRAME_RATE = new AutoValue_Config_Option("camerax.core.captureConfig.resolvedFrameRate", Range.class, null);

    public CaptureConfig(ArrayList arrayList, OptionsBundle optionsBundle, int i, ArrayList arrayList2, boolean z, TagBundle tagBundle, CameraCaptureResult cameraCaptureResult) {
        this.mSurfaces = arrayList;
        this.mImplementationOptions = optionsBundle;
        this.mTemplateType = i;
        this.mCameraCaptureCallbacks = Collections.unmodifiableList(arrayList2);
        this.mUseRepeatingSurface = z;
        this.mTagBundle = tagBundle;
        this.mCameraCaptureResult = cameraCaptureResult;
    }

    public final int getPreviewStabilizationMode() {
        Object objRetrieveOption = 0;
        try {
            objRetrieveOption = this.mImplementationOptions.retrieveOption(UseCaseConfig.OPTION_PREVIEW_STABILIZATION_MODE);
        } catch (IllegalArgumentException unused) {
        }
        Integer num = (Integer) objRetrieveOption;
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public final int getVideoStabilizationMode() {
        Object objRetrieveOption = 0;
        try {
            objRetrieveOption = this.mImplementationOptions.retrieveOption(UseCaseConfig.OPTION_VIDEO_STABILIZATION_MODE);
        } catch (IllegalArgumentException unused) {
        }
        Integer num = (Integer) objRetrieveOption;
        Objects.requireNonNull(num);
        return num.intValue();
    }
}
