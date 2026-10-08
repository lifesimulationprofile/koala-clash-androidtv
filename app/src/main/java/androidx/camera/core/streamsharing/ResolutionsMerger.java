package androidx.camera.core.streamsharing;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.SupportedOutputSizesSorter;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ResolutionsMerger {
    public static final double SAME_AREA_WIDTH_HEIGHT_RATIO = Math.sqrt(2.3703703703703702d);
    public final CameraInfoInternal mCameraInfo;
    public final HashMap mChildSizesCache;
    public final HashSet mChildrenConfigs;
    public final Rational mFallbackAspectRatio;
    public final Rational mSensorAspectRatio;
    public final Size mSensorSize;
    public final SupportedOutputSizesSorter mSizeSorter;

    public ResolutionsMerger(CameraInternal cameraInternal, HashSet hashSet) {
        Size sizeRectToSize = TransformUtils.rectToSize(cameraInternal.getCameraControlInternal().getSensorRect());
        CameraInfoInternal cameraInfoInternal = cameraInternal.getCameraInfoInternal();
        SupportedOutputSizesSorter supportedOutputSizesSorter = new SupportedOutputSizesSorter(cameraInfoInternal, sizeRectToSize);
        this.mChildSizesCache = new HashMap();
        this.mSensorSize = sizeRectToSize;
        Rational rational = ((double) sizeRectToSize.getWidth()) / ((double) sizeRectToSize.getHeight()) > SAME_AREA_WIDTH_HEIGHT_RATIO ? AspectRatioUtil.ASPECT_RATIO_16_9 : AspectRatioUtil.ASPECT_RATIO_4_3;
        Logger.d("ResolutionsMerger", "The closer aspect ratio to the sensor size (" + sizeRectToSize + ") is " + rational + ".");
        this.mSensorAspectRatio = rational;
        Rational rational2 = AspectRatioUtil.ASPECT_RATIO_4_3;
        if (rational.equals(rational2)) {
            rational2 = AspectRatioUtil.ASPECT_RATIO_16_9;
        } else if (!rational.equals(AspectRatioUtil.ASPECT_RATIO_16_9)) {
            throw new IllegalArgumentException("Invalid sensor aspect-ratio: " + rational);
        }
        this.mFallbackAspectRatio = rational2;
        this.mCameraInfo = cameraInfoInternal;
        this.mChildrenConfigs = hashSet;
        this.mSizeSorter = supportedOutputSizesSorter;
    }

    public static Rect getCropRectOfReferenceAspectRatio(Size size, Size size2) {
        RectF rectF;
        RectF rectF2;
        Rational rational = toRational(size2);
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = toRational(size);
        if (rational.floatValue() == rational2.floatValue()) {
            rectF2 = new RectF(0.0f, 0.0f, width, height);
        } else {
            if (rational.floatValue() > rational2.floatValue()) {
                float f = width;
                float fFloatValue = f / rational.floatValue();
                float f2 = (height - fFloatValue) / 2.0f;
                rectF = new RectF(0.0f, f2, f, fFloatValue + f2);
            } else {
                float f3 = height;
                float fFloatValue2 = rational.floatValue() * f3;
                float f4 = (width - fFloatValue2) / 2.0f;
                rectF = new RectF(f4, 0.0f, fFloatValue2 + f4, f3);
            }
            rectF2 = rectF;
        }
        Rect rect = new Rect();
        rectF2.round(rect);
        return rect;
    }

    public static boolean hasUpscaling(Size size, Size size2) {
        return size.getHeight() > size2.getHeight() || size.getWidth() > size2.getWidth();
    }

    public static Rational toRational(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    public final List getSortedChildSizes(UseCaseConfig useCaseConfig) {
        Rational rational;
        if (!this.mChildrenConfigs.contains(useCaseConfig)) {
            throw new IllegalArgumentException("Invalid child config: " + useCaseConfig);
        }
        HashMap map = this.mChildSizesCache;
        if (map.containsKey(useCaseConfig)) {
            List list = (List) map.get(useCaseConfig);
            Objects.requireNonNull(list);
            return list;
        }
        List sortedSupportedOutputSizes = this.mSizeSorter.getSortedSupportedOutputSizes(useCaseConfig);
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) sortedSupportedOutputSizes;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            Size size2 = (Size) obj;
            Iterator it = map2.keySet().iterator();
            do {
                if (!it.hasNext()) {
                    rational = null;
                    break;
                }
                rational = (Rational) it.next();
            } while (!AspectRatioUtil.hasMatchingAspectRatio(rational, size2));
            if (rational != null) {
                Size size3 = (Size) map2.get(rational);
                Objects.requireNonNull(size3);
                if (size2.getHeight() > size3.getHeight() || size2.getWidth() > size3.getWidth() || (size2.getWidth() == size3.getWidth() && size2.getHeight() == size3.getHeight())) {
                }
            } else {
                rational = toRational(size2);
            }
            arrayList.add(size2);
            map2.put(rational, size2);
        }
        map.put(useCaseConfig, arrayList);
        return arrayList;
    }

    public final boolean isDoubleCropping(Rational rational, Size size) {
        Rational rational2 = this.mSensorAspectRatio;
        if (rational2.equals(rational) || AspectRatioUtil.hasMatchingAspectRatio(rational, size)) {
            return false;
        }
        float fFloatValue = rational2.floatValue();
        float fFloatValue2 = rational.floatValue();
        Rational rational3 = AspectRatioUtil.ASPECT_RATIO_4_3;
        if (!AspectRatioUtil.hasMatchingAspectRatio(rational3, size)) {
            rational3 = AspectRatioUtil.ASPECT_RATIO_16_9;
            if (!AspectRatioUtil.hasMatchingAspectRatio(rational3, size)) {
                rational3 = toRational(size);
            }
        }
        float fFloatValue3 = rational3.floatValue();
        if (fFloatValue == fFloatValue2 || fFloatValue2 == fFloatValue3) {
            return false;
        }
        if (fFloatValue > fFloatValue2) {
            return fFloatValue2 < fFloatValue3;
        }
        return fFloatValue2 > fFloatValue3;
    }

    public final ArrayList selectOtherAspectRatioParentResolutionsWithFovPriority(List list, boolean z) {
        int i;
        List arrayList;
        HashMap map = new HashMap();
        Rational rational = AspectRatioUtil.ASPECT_RATIO_4_3;
        map.put(rational, new ArrayList());
        Rational rational2 = AspectRatioUtil.ASPECT_RATIO_16_9;
        map.put(rational2, new ArrayList());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(rational);
        arrayList2.add(rational2);
        Iterator it = list.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Size size = (Size) it.next();
            if (size.getHeight() > 0) {
                int size2 = arrayList2.size();
                while (true) {
                    if (i >= size2) {
                        arrayList = null;
                        break;
                    }
                    Object obj = arrayList2.get(i);
                    i++;
                    Rational rational3 = (Rational) obj;
                    if (AspectRatioUtil.hasMatchingAspectRatio(rational3, size)) {
                        arrayList = (List) map.get(rational3);
                        break;
                    }
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    Rational rational4 = toRational(size);
                    arrayList2.add(rational4);
                    map.put(rational4, arrayList);
                }
                arrayList.add(size);
            }
        }
        ArrayList arrayList3 = new ArrayList(map.keySet());
        Collections.sort(arrayList3, new MaterialButtonToggleGroup.AnonymousClass1(1, toRational(this.mSensorSize)));
        ArrayList arrayList4 = new ArrayList();
        int size3 = arrayList3.size();
        while (i < size3) {
            Object obj2 = arrayList3.get(i);
            i++;
            Rational rational5 = (Rational) obj2;
            if (!rational5.equals(AspectRatioUtil.ASPECT_RATIO_16_9) && !rational5.equals(AspectRatioUtil.ASPECT_RATIO_4_3)) {
                List list2 = (List) map.get(rational5);
                Objects.requireNonNull(list2);
                arrayList4.addAll(selectParentResolutionsByAspectRatio(rational5, list2, z));
            }
        }
        return arrayList4;
    }

    public final ArrayList selectParentResolutionsByAspectRatio(Rational rational, List list, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (AspectRatioUtil.hasMatchingAspectRatio(rational, size)) {
                arrayList2.add(size);
            }
        }
        Collections.sort(arrayList2, new CompareSizesByArea(true));
        HashSet hashSet = new HashSet(arrayList2);
        Iterator it2 = this.mChildrenConfigs.iterator();
        while (true) {
            int i = 0;
            if (!it2.hasNext()) {
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList2.size();
                while (i < size2) {
                    Object obj = arrayList2.get(i);
                    i++;
                    Size size3 = (Size) obj;
                    if (!hashSet.contains(size3)) {
                        arrayList3.add(size3);
                    }
                }
                return arrayList3;
            }
            List<Size> sortedChildSizes = getSortedChildSizes((UseCaseConfig) it2.next());
            if (!z) {
                ArrayList arrayList4 = new ArrayList();
                for (Size size4 : sortedChildSizes) {
                    if (!isDoubleCropping(rational, size4)) {
                        arrayList4.add(size4);
                    }
                }
                sortedChildSizes = arrayList4;
            }
            if (sortedChildSizes.isEmpty()) {
                return new ArrayList();
            }
            if (sortedChildSizes.isEmpty() || arrayList2.isEmpty()) {
                arrayList2 = new ArrayList();
            } else {
                ArrayList arrayList5 = new ArrayList();
                int size5 = arrayList2.size();
                int i2 = 0;
                while (i2 < size5) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    Size size6 = (Size) obj2;
                    Iterator it3 = sortedChildSizes.iterator();
                    while (it3.hasNext()) {
                        if (!hasUpscaling((Size) it3.next(), size6)) {
                            arrayList5.add(size6);
                            break;
                        }
                    }
                }
                arrayList2 = arrayList5;
            }
            if (sortedChildSizes.isEmpty() || arrayList2.isEmpty()) {
                arrayList = new ArrayList();
            } else {
                ArrayList arrayList6 = arrayList2.isEmpty() ? arrayList2 : new ArrayList(new LinkedHashSet(arrayList2));
                arrayList = new ArrayList();
                int size7 = arrayList6.size();
                while (i < size7) {
                    Object obj3 = arrayList6.get(i);
                    i++;
                    Size size8 = (Size) obj3;
                    Iterator it4 = sortedChildSizes.iterator();
                    do {
                        if (!it4.hasNext()) {
                            arrayList.add(size8);
                            break;
                        }
                    } while (!hasUpscaling((Size) it4.next(), size8));
                }
                if (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
            hashSet.retainAll(arrayList);
        }
    }
}
