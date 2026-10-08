package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DynamicRangeConversions {
    public static final HashMap DR_TO_PROFILE_MAP;
    public static final HashMap PROFILE_TO_DR_MAP;

    static {
        DynamicRange dynamicRange;
        HashMap map = new HashMap();
        PROFILE_TO_DR_MAP = map;
        HashMap map2 = new HashMap();
        DR_TO_PROFILE_MAP = map2;
        DynamicRange dynamicRange2 = DynamicRange.SDR;
        map.put(1L, dynamicRange2);
        map2.put(dynamicRange2, Collections.singletonList(1L));
        map.put(2L, DynamicRange.HLG_10_BIT);
        map2.put((DynamicRange) map.get(2L), Collections.singletonList(2L));
        DynamicRange dynamicRange3 = DynamicRange.HDR10_10_BIT;
        map.put(4L, dynamicRange3);
        map2.put(dynamicRange3, Collections.singletonList(4L));
        DynamicRange dynamicRange4 = DynamicRange.HDR10_PLUS_10_BIT;
        map.put(8L, dynamicRange4);
        map2.put(dynamicRange4, Collections.singletonList(8L));
        List listAsList = Arrays.asList(64L, 128L, 16L, 32L);
        Iterator it = listAsList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            dynamicRange = DynamicRange.DOLBY_VISION_10_BIT;
            if (!zHasNext) {
                break;
            } else {
                PROFILE_TO_DR_MAP.put((Long) it.next(), dynamicRange);
            }
        }
        DR_TO_PROFILE_MAP.put(dynamicRange, listAsList);
        List listAsList2 = Arrays.asList(1024L, 2048L, 256L, 512L);
        Iterator it2 = listAsList2.iterator();
        while (true) {
            boolean zHasNext2 = it2.hasNext();
            DynamicRange dynamicRange5 = DynamicRange.DOLBY_VISION_8_BIT;
            if (!zHasNext2) {
                DR_TO_PROFILE_MAP.put(dynamicRange5, listAsList2);
                return;
            }
            PROFILE_TO_DR_MAP.put((Long) it2.next(), dynamicRange5);
        }
    }

    public static Long dynamicRangeToFirstSupportedProfile(DynamicRange dynamicRange, DynamicRangeProfiles dynamicRangeProfiles) {
        List<Long> list = (List) DR_TO_PROFILE_MAP.get(dynamicRange);
        if (list == null) {
            return null;
        }
        Set supportedProfiles = dynamicRangeProfiles.getSupportedProfiles();
        for (Long l : list) {
            if (supportedProfiles.contains(l)) {
                return l;
            }
        }
        return null;
    }
}
