package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.util.ArrayMap;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.MutableTagBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.UseCaseConfig;
import coil.intercept.RealInterceptorChain;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class Camera2CaptureOptionUnpacker {
    public static final Camera2CaptureOptionUnpacker INSTANCE = new Camera2CaptureOptionUnpacker();

    public void unpack(UseCaseConfig useCaseConfig, RealInterceptorChain realInterceptorChain) {
        CaptureConfig defaultCaptureConfig = useCaseConfig.getDefaultCaptureConfig();
        OptionsBundle optionsBundle = OptionsBundle.EMPTY_BUNDLE;
        AutoValue_Config_Option autoValue_Config_Option = CaptureConfig.OPTION_ROTATION;
        HashSet hashSet = new HashSet();
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        ArrayList arrayList = new ArrayList();
        MutableTagBundle mutableTagBundleCreate = MutableTagBundle.create();
        ArrayList arrayList2 = new ArrayList(hashSet);
        OptionsBundle optionsBundleFrom = OptionsBundle.from(mutableOptionsBundleCreate);
        ArrayList arrayList3 = new ArrayList(arrayList);
        TagBundle tagBundle = TagBundle.EMPTY_TAGBUNDLE;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = mutableTagBundleCreate.mTagMap;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        int i = -1;
        new CaptureConfig(arrayList2, optionsBundleFrom, -1, arrayList3, false, new TagBundle(arrayMap), null);
        if (defaultCaptureConfig != null) {
            i = defaultCaptureConfig.mTemplateType;
            realInterceptorChain.addAllCameraCaptureCallbacks(defaultCaptureConfig.mCameraCaptureCallbacks);
            optionsBundle = defaultCaptureConfig.mImplementationOptions;
        }
        realInterceptorChain.request = MutableOptionsBundle.from((Config) optionsBundle);
        realInterceptorChain.index = ((Integer) useCaseConfig.retrieveOption(Camera2ImplConfig.TEMPLATE_TYPE_OPTION, Integer.valueOf(i))).intValue();
        realInterceptorChain.addCameraCaptureCallback(new CaptureCallbackContainer((CameraCaptureSession.CaptureCallback) useCaseConfig.retrieveOption(Camera2ImplConfig.SESSION_CAPTURE_CALLBACK_OPTION, new Camera2CaptureCallbacks$NoOpSessionCaptureCallback())));
        realInterceptorChain.addImplementationOptions(Preview.Builder.from(useCaseConfig).build());
    }
}
