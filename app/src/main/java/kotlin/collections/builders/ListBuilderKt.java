package kotlin.collections.builders;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import android.view.Surface;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.OptionsBundle;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import kotlin.collections.AbstractMutableList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListBuilderKt {
    public static final String access$subarrayContentToString(Object[] objArr, int i, int i2, AbstractMutableList abstractMutableList) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i3];
            if (obj == abstractMutableList) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void applyImplementationOptionToCaptureBuilder(CaptureRequest.Builder builder, OptionsBundle optionsBundle) {
        Toolbar.AnonymousClass1 anonymousClass1Build = Preview.Builder.from(optionsBundle).build();
        for (AutoValue_Config_Option autoValue_Config_Option : anonymousClass1Build.getConfig().listOptions()) {
            CaptureRequest.Key key = (CaptureRequest.Key) autoValue_Config_Option.token;
            try {
                builder.set(key, anonymousClass1Build.getConfig().retrieveOption(autoValue_Config_Option));
            } catch (IllegalArgumentException unused) {
                Logger.e("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    public static void applyTemplateParamsOverrideWorkaround(CaptureRequest.Builder builder, int i, FlowLayoutBuildingBlocks.WrapInfo wrapInfo) {
        Map mapUnmodifiableMap;
        if (i == 3 && wrapInfo.isLastItemInLine) {
            HashMap map = new HashMap();
            map.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
            mapUnmodifiableMap = Collections.unmodifiableMap(map);
        } else {
            if (i != 4) {
                wrapInfo.getClass();
            } else if (wrapInfo.isLastItemInContainer) {
                HashMap map2 = new HashMap();
                map2.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 2);
                mapUnmodifiableMap = Collections.unmodifiableMap(map2);
            }
            mapUnmodifiableMap = Collections.EMPTY_MAP;
        }
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            builder.set((CaptureRequest.Key) entry.getKey(), entry.getValue());
        }
    }

    public static CaptureRequest build(CaptureConfig captureConfig, CameraDevice cameraDevice, HashMap map, boolean z, FlowLayoutBuildingBlocks.WrapInfo wrapInfo) throws CameraAccessException {
        CaptureRequest.Builder builderCreateCaptureRequest;
        if (cameraDevice == null) {
            return null;
        }
        ArrayList arrayList = captureConfig.mSurfaces;
        OptionsBundle optionsBundle = captureConfig.mImplementationOptions;
        int i = captureConfig.mTemplateType;
        TreeMap treeMap = optionsBundle.mOptions;
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = listUnmodifiableList.iterator();
        while (it.hasNext()) {
            Surface surface = (Surface) map.get((DeferrableSurface) it.next());
            if (surface == null) {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
            arrayList2.add(surface);
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        CameraCaptureResult cameraCaptureResult = captureConfig.mCameraCaptureResult;
        if (i == 5 && cameraCaptureResult != null && (cameraCaptureResult.getCaptureResult() instanceof TotalCaptureResult)) {
            Logger.d("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
            builderCreateCaptureRequest = cameraDevice.createReprocessCaptureRequest((TotalCaptureResult) cameraCaptureResult.getCaptureResult());
        } else {
            Logger.d("Camera2CaptureRequestBuilder", "createCaptureRequest");
            if (i == 5) {
                builderCreateCaptureRequest = cameraDevice.createCaptureRequest(z ? 1 : 2);
            } else {
                builderCreateCaptureRequest = cameraDevice.createCaptureRequest(i);
            }
        }
        applyTemplateParamsOverrideWorkaround(builderCreateCaptureRequest, i, wrapInfo);
        AutoValue_Config_Option autoValue_Config_Option = CaptureConfig.OPTION_RESOLVED_FRAME_RATE;
        Object objRetrieveOption = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        try {
            objRetrieveOption = optionsBundle.retrieveOption(autoValue_Config_Option);
        } catch (IllegalArgumentException unused) {
        }
        Range range = (Range) objRetrieveOption;
        Objects.requireNonNull(range);
        Object objRetrieveOption2 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        if (!range.equals(objRetrieveOption2)) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
            try {
                objRetrieveOption2 = optionsBundle.retrieveOption(CaptureConfig.OPTION_RESOLVED_FRAME_RATE);
            } catch (IllegalArgumentException unused2) {
            }
            Range range2 = (Range) objRetrieveOption2;
            Objects.requireNonNull(range2);
            builderCreateCaptureRequest.set(key, range2);
        }
        int i2 = 0;
        if (captureConfig.getPreviewStabilizationMode() == 1 || captureConfig.getVideoStabilizationMode() == 1) {
            builderCreateCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        } else if (captureConfig.getPreviewStabilizationMode() == 2) {
            builderCreateCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
        } else if (captureConfig.getVideoStabilizationMode() == 2) {
            builderCreateCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
        }
        AutoValue_Config_Option autoValue_Config_Option2 = CaptureConfig.OPTION_ROTATION;
        if (treeMap.containsKey(autoValue_Config_Option2)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) optionsBundle.retrieveOption(autoValue_Config_Option2));
        }
        AutoValue_Config_Option autoValue_Config_Option3 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (treeMap.containsKey(autoValue_Config_Option3)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) optionsBundle.retrieveOption(autoValue_Config_Option3)).byteValue()));
        }
        applyImplementationOptionToCaptureBuilder(builderCreateCaptureRequest, optionsBundle);
        int size = arrayList2.size();
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            builderCreateCaptureRequest.addTarget((Surface) obj);
        }
        builderCreateCaptureRequest.setTag(captureConfig.mTagBundle);
        return builderCreateCaptureRequest.build();
    }

    public static CaptureRequest buildWithoutTarget(CaptureConfig captureConfig, CameraDevice cameraDevice, FlowLayoutBuildingBlocks.WrapInfo wrapInfo) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("template type = ");
        int i = captureConfig.mTemplateType;
        sb.append(i);
        Logger.d("Camera2CaptureRequestBuilder", sb.toString());
        CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(i);
        applyTemplateParamsOverrideWorkaround(builderCreateCaptureRequest, i, wrapInfo);
        applyImplementationOptionToCaptureBuilder(builderCreateCaptureRequest, captureConfig.mImplementationOptions);
        return builderCreateCaptureRequest.build();
    }

    public static final void resetRange(Object[] objArr, int i, int i2) {
        while (i < i2) {
            objArr[i] = null;
            i++;
        }
    }
}
