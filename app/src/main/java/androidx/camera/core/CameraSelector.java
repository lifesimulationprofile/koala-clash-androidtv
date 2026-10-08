package androidx.camera.core;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LensFacingCameraFilter;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CameraSelector {
    public static final CameraSelector DEFAULT_BACK_CAMERA;
    public static final CameraSelector DEFAULT_FRONT_CAMERA;
    public final LinkedHashSet mCameraFilterSet;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new LensFacingCameraFilter(0));
        DEFAULT_FRONT_CAMERA = new CameraSelector(linkedHashSet);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(new LensFacingCameraFilter(1));
        DEFAULT_BACK_CAMERA = new CameraSelector(linkedHashSet2);
    }

    public CameraSelector(LinkedHashSet linkedHashSet) {
        this.mCameraFilterSet = linkedHashSet;
    }

    public final ArrayList filter(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        for (CameraFilter cameraFilter : this.mCameraFilterSet) {
            List<CameraInfoInternal> listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            LensFacingCameraFilter lensFacingCameraFilter = (LensFacingCameraFilter) cameraFilter;
            lensFacingCameraFilter.getClass();
            ArrayList arrayList3 = new ArrayList();
            for (CameraInfoInternal cameraInfoInternal : listUnmodifiableList) {
                Preconditions.checkArgument("The camera info doesn't contain internal implementation.", cameraInfoInternal instanceof CameraInfoInternal);
                if (cameraInfoInternal.getLensFacing() == lensFacingCameraFilter.mLensFacing) {
                    arrayList3.add(cameraInfoInternal);
                }
            }
            arrayList2 = arrayList3;
        }
        arrayList2.retainAll(arrayList);
        return arrayList2;
    }

    public final Integer getLensFacing() {
        Integer num = null;
        for (CameraFilter cameraFilter : this.mCameraFilterSet) {
            if (cameraFilter instanceof LensFacingCameraFilter) {
                Integer numValueOf = Integer.valueOf(((LensFacingCameraFilter) cameraFilter).mLensFacing);
                if (num == null) {
                    num = numValueOf;
                } else if (!num.equals(numValueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    public final CameraInternal select(LinkedHashSet linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((CameraInternal) it.next()).getCameraInfo());
        }
        ArrayList arrayListFilter = filter(arrayList);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            CameraInternal cameraInternal = (CameraInternal) it2.next();
            if (arrayListFilter.contains(cameraInternal.getCameraInfo())) {
                linkedHashSet2.add(cameraInternal);
            }
        }
        Iterator it3 = linkedHashSet2.iterator();
        if (it3.hasNext()) {
            return (CameraInternal) it3.next();
        }
        throw new IllegalArgumentException("No available camera can be found");
    }
}
