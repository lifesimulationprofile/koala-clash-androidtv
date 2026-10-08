package androidx.camera.camera2.internal;

import android.content.Context;
import android.util.ArrayMap;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.MutableTagBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2UseCaseConfigFactory implements UseCaseConfigFactory {
    public final DisplayInfoManager mDisplayInfoManager;

    public Camera2UseCaseConfigFactory(Context context) {
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(context);
    }

    /* JADX WARN: Code duplicated, block: B:5:0x003a  */
    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    public final Config getConfig(UseCaseConfigFactory.CaptureType captureType, int i) {
        int i2;
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashSet hashSet = new HashSet();
        MutableOptionsBundle mutableOptionsBundleCreate2 = MutableOptionsBundle.create();
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = MutableTagBundle.create().mTagMap;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int iOrdinal = captureType.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 3) {
                i2 = 1;
            } else {
                i2 = 3;
            }
        } else if (i == 2) {
            i2 = 5;
        } else {
            i2 = 1;
        }
        AutoValue_Config_Option autoValue_Config_Option = UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG;
        ArrayList arrayList5 = new ArrayList(linkedHashSet);
        ArrayList arrayList6 = new ArrayList(arrayList2);
        ArrayList arrayList7 = new ArrayList(arrayList3);
        ArrayList arrayList8 = new ArrayList(arrayList4);
        ArrayList arrayList9 = new ArrayList(hashSet);
        OptionsBundle optionsBundleFrom = OptionsBundle.from(mutableOptionsBundleCreate2);
        ArrayList arrayList10 = new ArrayList(arrayList);
        TagBundle tagBundle = TagBundle.EMPTY_TAGBUNDLE;
        ArrayMap arrayMap2 = new ArrayMap();
        for (String str : arrayMap.keySet()) {
            arrayMap2.put(str, arrayMap.get(str));
        }
        mutableOptionsBundleCreate.insertOption(autoValue_Config_Option, new SessionConfig(arrayList5, arrayList6, arrayList7, arrayList8, new CaptureConfig(arrayList9, optionsBundleFrom, i2, arrayList10, false, new TagBundle(arrayMap2), null), null, null, null));
        mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, Camera2SessionOptionUnpacker.INSTANCE);
        HashSet hashSet2 = new HashSet();
        MutableOptionsBundle mutableOptionsBundleCreate3 = MutableOptionsBundle.create();
        ArrayList arrayList11 = new ArrayList();
        ArrayMap arrayMap3 = MutableTagBundle.create().mTagMap;
        int iOrdinal2 = captureType.ordinal();
        int i3 = iOrdinal2 != 0 ? iOrdinal2 != 3 ? 1 : 3 : i == 2 ? 5 : 2;
        AutoValue_Config_Option autoValue_Config_Option2 = UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG;
        ArrayList arrayList12 = new ArrayList(hashSet2);
        OptionsBundle optionsBundleFrom2 = OptionsBundle.from(mutableOptionsBundleCreate3);
        ArrayList arrayList13 = new ArrayList(arrayList11);
        TagBundle tagBundle2 = TagBundle.EMPTY_TAGBUNDLE;
        ArrayMap arrayMap4 = new ArrayMap();
        for (String str2 : arrayMap3.keySet()) {
            arrayMap4.put(str2, arrayMap3.get(str2));
        }
        mutableOptionsBundleCreate.insertOption(autoValue_Config_Option2, new CaptureConfig(arrayList12, optionsBundleFrom2, i3, arrayList13, false, new TagBundle(arrayMap4), null));
        mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, captureType == UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE ? ImageCaptureOptionUnpacker.INSTANCE : Camera2CaptureOptionUnpacker.INSTANCE);
        UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.PREVIEW;
        DisplayInfoManager displayInfoManager = this.mDisplayInfoManager;
        if (captureType == captureType2) {
            mutableOptionsBundleCreate.insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, displayInfoManager.getPreviewSize());
        }
        mutableOptionsBundleCreate.insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(displayInfoManager.getMaxSizeDisplay(true).getRotation()));
        if (captureType == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE || captureType == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            mutableOptionsBundleCreate.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
        }
        return OptionsBundle.from(mutableOptionsBundleCreate);
    }
}
