package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceCombination {
    public final ArrayList mSurfaceConfigList = new ArrayList();

    public static void generateArrangements(ArrayList arrayList, int i, int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            arrayList.add((int[]) iArr.clone());
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    iArr[i2] = i3;
                    generateArrangements(arrayList, i, iArr, i2 + 1);
                    break;
                } else if (i3 == iArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    public final void addSurfaceConfig(AutoValue_SurfaceConfig autoValue_SurfaceConfig) {
        this.mSurfaceConfigList.add(autoValue_SurfaceConfig);
    }

    public final List getOrderedSupportedSurfaceConfigList(List list) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        int size = list.size();
        ArrayList arrayList = this.mSurfaceConfigList;
        if (size != arrayList.size()) {
            return null;
        }
        int size2 = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        generateArrangements(arrayList2, size2, new int[size2], 0);
        AutoValue_SurfaceConfig[] autoValue_SurfaceConfigArr = new AutoValue_SurfaceConfig[list.size()];
        int size3 = arrayList2.size();
        int i = 0;
        while (i < size3) {
            Object obj = arrayList2.get(i);
            i++;
            int[] iArr = (int[]) obj;
            boolean z2 = true;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (iArr[i2] < list.size()) {
                    AutoValue_SurfaceConfig autoValue_SurfaceConfig = (AutoValue_SurfaceConfig) arrayList.get(i2);
                    AutoValue_SurfaceConfig autoValue_SurfaceConfig2 = (AutoValue_SurfaceConfig) list.get(iArr[i2]);
                    autoValue_SurfaceConfig.getClass();
                    z2 &= autoValue_SurfaceConfig2.configSize.mId <= autoValue_SurfaceConfig.configSize.mId && autoValue_SurfaceConfig2.configType == autoValue_SurfaceConfig.configType;
                    if (!z2) {
                        break;
                    }
                    autoValue_SurfaceConfigArr[iArr[i2]] = (AutoValue_SurfaceConfig) arrayList.get(i2);
                }
            }
            if (z2) {
                z = true;
                break;
            }
        }
        if (z) {
            return Arrays.asList(autoValue_SurfaceConfigArr);
        }
        return null;
    }
}
