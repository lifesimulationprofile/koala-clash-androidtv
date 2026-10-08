package androidx.camera.core.internal;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SupportedOutputSizesSorter {
    public Object mCameraInfoInternal;
    public Serializable mFullFovRatio;
    public int mLensFacing;
    public int mSensorOrientation;
    public Object mSupportedOutputSizesSorterLegacy;

    public SupportedOutputSizesSorter(CameraInfoInternal cameraInfoInternal, Size size) {
        Rational rational;
        this.mCameraInfoInternal = cameraInfoInternal;
        this.mSensorOrientation = cameraInfoInternal.getSensorRotationDegrees();
        this.mLensFacing = cameraInfoInternal.getLensFacing();
        if (size != null) {
            rational = new Rational(size.getWidth(), size.getHeight());
        } else {
            List supportedResolutions = cameraInfoInternal.getSupportedResolutions(256);
            if (supportedResolutions.isEmpty()) {
                rational = null;
            } else {
                Size size2 = (Size) Collections.max(supportedResolutions, new CompareSizesByArea(false));
                rational = new Rational(size2.getWidth(), size2.getHeight());
            }
        }
        this.mFullFovRatio = rational;
        this.mSupportedOutputSizesSorterLegacy = new SupportedOutputSizesSorterLegacy(cameraInfoInternal, rational);
    }

    public static ArrayList getResolutionListGroupingAspectRatioKeys(ArrayList arrayList) {
        Object obj;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(AspectRatioUtil.ASPECT_RATIO_4_3);
        arrayList2.add(AspectRatioUtil.ASPECT_RATIO_16_9);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            Size size2 = (Size) obj2;
            Rational rational = new Rational(size2.getWidth(), size2.getHeight());
            if (!arrayList2.contains(rational)) {
                int size3 = arrayList2.size();
                int i2 = 0;
                do {
                    if (i2 >= size3) {
                        arrayList2.add(rational);
                        break;
                    }
                    obj = arrayList2.get(i2);
                    i2++;
                } while (!AspectRatioUtil.hasMatchingAspectRatio((Rational) obj, size2));
            }
        }
        return arrayList2;
    }

    public static Rational getTargetAspectRatioRationalValue(int i, boolean z) {
        if (i == -1) {
            return null;
        }
        if (i == 0) {
            return z ? AspectRatioUtil.ASPECT_RATIO_4_3 : AspectRatioUtil.ASPECT_RATIO_3_4;
        }
        if (i == 1) {
            return z ? AspectRatioUtil.ASPECT_RATIO_16_9 : AspectRatioUtil.ASPECT_RATIO_9_16;
        }
        Logger.e("SupportedOutputSizesCollector", "Undefined target aspect ratio: " + i);
        return null;
    }

    public static HashMap groupSizesByAspectRatio(ArrayList arrayList) {
        HashMap map = new HashMap();
        ArrayList resolutionListGroupingAspectRatioKeys = getResolutionListGroupingAspectRatioKeys(arrayList);
        int size = resolutionListGroupingAspectRatioKeys.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = resolutionListGroupingAspectRatioKeys.get(i2);
            i2++;
            map.put((Rational) obj, new ArrayList());
        }
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            Size size3 = (Size) obj2;
            for (Rational rational : map.keySet()) {
                if (AspectRatioUtil.hasMatchingAspectRatio(rational, size3)) {
                    ((List) map.get(rational)).add(size3);
                }
            }
        }
        return map;
    }

    public static void sortSupportedSizesByFallbackRuleClosestHigherThenLower(List list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = (Size) list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z) {
            list.addAll(arrayList);
        }
    }

    public static void sortSupportedSizesByFallbackRuleClosestLowerThenHigher(List list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Size size2 = (Size) list.get(i);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z) {
            list.addAll(arrayList);
        }
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [int[], java.io.Serializable] */
    public int add(long j) {
        int i = this.mSensorOrientation + 1;
        long[] jArr = (long[]) this.mCameraInfoInternal;
        int length = jArr.length;
        if (i > length) {
            int i2 = length * 2;
            long[] jArr2 = new long[i2];
            ?? r2 = new int[i2];
            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
            ArraysKt.copyInto$default(0, 0, 14, (int[]) this.mFullFovRatio, (int[]) r2);
            this.mCameraInfoInternal = jArr2;
            this.mFullFovRatio = r2;
        }
        int i3 = this.mSensorOrientation;
        this.mSensorOrientation = i3 + 1;
        int length2 = ((int[]) this.mSupportedOutputSizesSorterLegacy).length;
        if (this.mLensFacing >= length2) {
            int i4 = length2 * 2;
            int[] iArr = new int[i4];
            int i5 = 0;
            while (i5 < i4) {
                int i6 = i5 + 1;
                iArr[i5] = i6;
                i5 = i6;
            }
            ArraysKt.copyInto$default(0, 0, 14, (int[]) this.mSupportedOutputSizesSorterLegacy, iArr);
            this.mSupportedOutputSizesSorterLegacy = iArr;
        }
        int i7 = this.mLensFacing;
        int[] iArr2 = (int[]) this.mSupportedOutputSizesSorterLegacy;
        this.mLensFacing = iArr2[i7];
        long[] jArr3 = (long[]) this.mCameraInfoInternal;
        jArr3[i3] = j;
        ((int[]) this.mFullFovRatio)[i3] = i7;
        iArr2[i7] = i3;
        while (i3 > 0) {
            int i8 = ((i3 + 1) >> 1) - 1;
            if (Intrinsics.compare(jArr3[i8], j) <= 0) {
                break;
            }
            swap(i8, i3);
            i3 = i8;
        }
        return i7;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00bc  */
    public List getSortedSupportedOutputSizes(UseCaseConfig useCaseConfig) {
        Size[] sizeArr;
        CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) this.mCameraInfoInternal;
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCaseConfig;
        ArrayList customOrderedResolutions = imageOutputConfig.getCustomOrderedResolutions();
        if (customOrderedResolutions != null) {
            return customOrderedResolutions;
        }
        ResolutionSelector resolutionSelector$1 = imageOutputConfig.getResolutionSelector$1();
        List supportedResolutions = imageOutputConfig.getSupportedResolutions();
        int inputFormat = useCaseConfig.getInputFormat();
        Rational rational = null;
        if (supportedResolutions == null) {
            sizeArr = null;
            break;
        }
        Iterator it = supportedResolutions.iterator();
        while (true) {
            if (!it.hasNext()) {
                sizeArr = null;
                break;
            }
            Pair pair = (Pair) it.next();
            if (((Integer) pair.first).intValue() == inputFormat) {
                sizeArr = (Size[]) pair.second;
                break;
            }
        }
        List listAsList = sizeArr == null ? null : Arrays.asList(sizeArr);
        if (listAsList == null) {
            listAsList = cameraInfoInternal.getSupportedResolutions(inputFormat);
        }
        ArrayList arrayList = new ArrayList(listAsList);
        Collections.sort(arrayList, new CompareSizesByArea(true));
        if (arrayList.isEmpty()) {
            Logger.w("SupportedOutputSizesCollector", "The retrieved supported resolutions from camera info internal is empty. Format is " + inputFormat + ".");
        }
        int i = 0;
        if (resolutionSelector$1 != null) {
            Size maxResolution = ((ImageOutputConfig) useCaseConfig).getMaxResolution();
            imageOutputConfig.getTargetRotation();
            if (!useCaseConfig.isHighResolutionDisabled()) {
                useCaseConfig.getInputFormat();
            }
            ResolutionSelector resolutionSelector = imageOutputConfig.getResolutionSelector();
            Rational rational2 = (Rational) this.mFullFovRatio;
            AspectRatioStrategy aspectRatioStrategy = resolutionSelector.mAspectRatioStrategy;
            HashMap mapGroupSizesByAspectRatio = groupSizesByAspectRatio(arrayList);
            boolean z = rational2 == null || rational2.getNumerator() >= rational2.getDenominator();
            aspectRatioStrategy.getClass();
            Rational targetAspectRatioRationalValue = getTargetAspectRatioRationalValue(0, z);
            ArrayList arrayList2 = new ArrayList(mapGroupSizesByAspectRatio.keySet());
            Collections.sort(arrayList2, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(targetAspectRatioRationalValue, rational2));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                Rational rational3 = (Rational) obj;
                linkedHashMap.put(rational3, (List) mapGroupSizesByAspectRatio.get(rational3));
            }
            if (maxResolution != null) {
                Size size2 = SizeUtil.RESOLUTION_ZERO;
                int height = maxResolution.getHeight() * maxResolution.getWidth();
                Iterator it2 = linkedHashMap.keySet().iterator();
                while (it2.hasNext()) {
                    List<Size> list = (List) linkedHashMap.get((Rational) it2.next());
                    ArrayList arrayList3 = new ArrayList();
                    for (Size size3 : list) {
                        if (SizeUtil.getArea(size3) <= height) {
                            arrayList3.add(size3);
                        }
                    }
                    list.clear();
                    list.addAll(arrayList3);
                }
            }
            ResolutionStrategy resolutionStrategy = resolutionSelector.mResolutionStrategy;
            if (resolutionStrategy != null) {
                Iterator it3 = linkedHashMap.keySet().iterator();
                while (it3.hasNext()) {
                    List list2 = (List) linkedHashMap.get((Rational) it3.next());
                    if (!list2.isEmpty()) {
                        int i3 = resolutionStrategy.mFallbackRule;
                        if (!resolutionStrategy.equals(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY)) {
                            Size size4 = resolutionStrategy.mBoundSize;
                            if (i3 == 0) {
                                boolean zContains = list2.contains(size4);
                                list2.clear();
                                if (zContains) {
                                    list2.add(size4);
                                }
                            } else if (i3 == 1) {
                                sortSupportedSizesByFallbackRuleClosestHigherThenLower(list2, size4, true);
                            } else if (i3 == 2) {
                                sortSupportedSizesByFallbackRuleClosestHigherThenLower(list2, size4, false);
                            } else if (i3 == 3) {
                                sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list2, size4, true);
                            } else if (i3 == 4) {
                                sortSupportedSizesByFallbackRuleClosestLowerThenHigher(list2, size4, false);
                            }
                        }
                    }
                }
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it4 = linkedHashMap.values().iterator();
            while (it4.hasNext()) {
                for (Size size5 : (List) it4.next()) {
                    if (!arrayList4.contains(size5)) {
                        arrayList4.add(size5);
                    }
                }
            }
            return arrayList4;
        }
        SupportedOutputSizesSorterLegacy supportedOutputSizesSorterLegacy = (SupportedOutputSizesSorterLegacy) this.mSupportedOutputSizesSorterLegacy;
        supportedOutputSizesSorterLegacy.getClass();
        if (arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList5 = new ArrayList(arrayList);
        Collections.sort(arrayList5, new CompareSizesByArea(true));
        ArrayList arrayList6 = new ArrayList();
        ImageOutputConfig imageOutputConfig2 = (ImageOutputConfig) useCaseConfig;
        Size maxResolution2 = imageOutputConfig2.getMaxResolution();
        Size size6 = (Size) arrayList5.get(0);
        if (maxResolution2 == null) {
            maxResolution2 = size6;
        } else if (SizeUtil.getArea(size6) < maxResolution2.getHeight() * maxResolution2.getWidth()) {
            maxResolution2 = size6;
        }
        Size targetSize = supportedOutputSizesSorterLegacy.getTargetSize(imageOutputConfig2);
        Size size7 = SizeUtil.RESOLUTION_VGA;
        int area = SizeUtil.getArea(size7);
        if (SizeUtil.getArea(maxResolution2) < area) {
            size7 = SizeUtil.RESOLUTION_ZERO;
        } else if (targetSize != null) {
            if (targetSize.getHeight() * targetSize.getWidth() < area) {
                size7 = targetSize;
            }
        }
        int size8 = arrayList5.size();
        int i4 = 0;
        while (i4 < size8) {
            Object obj2 = arrayList5.get(i4);
            i4++;
            Size size9 = (Size) obj2;
            if (SizeUtil.getArea(size9) <= maxResolution2.getWidth() * maxResolution2.getHeight()) {
                if (size9.getHeight() * size9.getWidth() >= SizeUtil.getArea(size7) && !arrayList6.contains(size9)) {
                    arrayList6.add(size9);
                }
            }
        }
        if (arrayList6.isEmpty()) {
            throw new IllegalArgumentException("All supported output sizes are filtered out according to current resolution selection settings. \nminSize = " + size7 + "\nmaxSize = " + maxResolution2 + "\ninitial size list: " + arrayList5);
        }
        if (!imageOutputConfig2.hasTargetAspectRatio()) {
            Size targetSize2 = supportedOutputSizesSorterLegacy.getTargetSize(imageOutputConfig2);
            if (targetSize2 != null) {
                ArrayList resolutionListGroupingAspectRatioKeys = getResolutionListGroupingAspectRatioKeys(arrayList6);
                int size10 = resolutionListGroupingAspectRatioKeys.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size10) {
                        rational = new Rational(targetSize2.getWidth(), targetSize2.getHeight());
                        break;
                    }
                    Object obj3 = resolutionListGroupingAspectRatioKeys.get(i5);
                    i5++;
                    Rational rational4 = (Rational) obj3;
                    if (AspectRatioUtil.hasMatchingAspectRatio(rational4, targetSize2)) {
                        rational = rational4;
                        break;
                    }
                }
            }
        } else {
            rational = getTargetAspectRatioRationalValue(imageOutputConfig2.getTargetAspectRatio(), supportedOutputSizesSorterLegacy.mIsSensorLandscapeResolution);
        }
        if (targetSize == null) {
            targetSize = imageOutputConfig2.getDefaultResolution();
        }
        ArrayList arrayList7 = new ArrayList();
        new HashMap();
        if (rational == null) {
            arrayList7.addAll(arrayList6);
            if (targetSize != null) {
                sortSupportedSizesByFallbackRuleClosestHigherThenLower(arrayList7, targetSize, true);
                return arrayList7;
            }
        } else {
            HashMap mapGroupSizesByAspectRatio2 = groupSizesByAspectRatio(arrayList6);
            if (targetSize != null) {
                Iterator it5 = mapGroupSizesByAspectRatio2.keySet().iterator();
                while (it5.hasNext()) {
                    sortSupportedSizesByFallbackRuleClosestHigherThenLower((List) mapGroupSizesByAspectRatio2.get((Rational) it5.next()), targetSize, true);
                }
            }
            ArrayList arrayList8 = new ArrayList(mapGroupSizesByAspectRatio2.keySet());
            Collections.sort(arrayList8, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(rational, supportedOutputSizesSorterLegacy.mFullFovRatio));
            int size11 = arrayList8.size();
            while (i < size11) {
                Object obj4 = arrayList8.get(i);
                i++;
                for (Size size12 : (List) mapGroupSizesByAspectRatio2.get((Rational) obj4)) {
                    if (!arrayList7.contains(size12)) {
                        arrayList7.add(size12);
                    }
                }
            }
        }
        return arrayList7;
    }

    public void swap(int i, int i2) {
        long[] jArr = (long[]) this.mCameraInfoInternal;
        int[] iArr = (int[]) this.mFullFovRatio;
        int[] iArr2 = (int[]) this.mSupportedOutputSizesSorterLegacy;
        long j = jArr[i];
        jArr[i] = jArr[i2];
        jArr[i2] = j;
        int i3 = iArr[i];
        int i4 = iArr[i2];
        iArr[i] = i4;
        iArr[i2] = i3;
        iArr2[i4] = i;
        iArr2[i3] = i2;
    }
}
