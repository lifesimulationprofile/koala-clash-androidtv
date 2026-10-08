package androidx.camera.core.streamsharing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceEdge$$ExternalSyntheticLambda1;
import androidx.camera.core.processing.util.AutoValue_OutConfig;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VirtualCameraAdapter implements UseCase.StateChangeCallback {
    public final HashSet mChildren;
    public final HashSet mChildrenConfigs;
    public final HashMap mChildrenConfigsMap;
    public final CameraInternal mParentCamera;
    public final ResolutionsMerger mResolutionsMerger;
    public final CameraInternal mSecondaryParentCamera;
    public final ResolutionsMerger mSecondaryResolutionsMerger;
    public final UseCaseConfigFactory mUseCaseConfigFactory;
    public final HashMap mChildrenEdges = new HashMap();
    public final HashMap mChildrenVirtualCameras = new HashMap();
    public final HashMap mChildrenActiveState = new HashMap();
    public final MetadataImageReader.AnonymousClass1 mParentMetadataCallback = new MetadataImageReader.AnonymousClass1(2, this);

    public VirtualCameraAdapter(CameraInternal cameraInternal, CameraInternal cameraInternal2, HashSet hashSet, UseCaseConfigFactory useCaseConfigFactory, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0) {
        this.mParentCamera = cameraInternal;
        this.mSecondaryParentCamera = cameraInternal2;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        this.mChildren = hashSet;
        HashMap map = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            map.put(useCase, useCase.mergeConfigs(cameraInternal.getCameraInfoInternal(), null, useCase.getDefaultConfig(true, useCaseConfigFactory)));
        }
        this.mChildrenConfigsMap = map;
        HashSet hashSet2 = new HashSet(map.values());
        this.mChildrenConfigs = hashSet2;
        this.mResolutionsMerger = new ResolutionsMerger(cameraInternal, hashSet2);
        if (this.mSecondaryParentCamera != null) {
            this.mSecondaryResolutionsMerger = new ResolutionsMerger(this.mSecondaryParentCamera, hashSet2);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            UseCase useCase2 = (UseCase) it2.next();
            this.mChildrenActiveState.put(useCase2, Boolean.FALSE);
            this.mChildrenVirtualCameras.put(useCase2, new VirtualCamera(cameraInternal, this, zslControlImpl$$ExternalSyntheticLambda0));
        }
    }

    public static void forceSetProvider(SurfaceEdge surfaceEdge, DeferrableSurface deferrableSurface, SessionConfig sessionConfig) {
        surfaceEdge.invalidate();
        try {
            CharsKt.checkMainThread();
            surfaceEdge.checkNotClosed();
            SurfaceEdge.SettableSurface settableSurface = surfaceEdge.mSettableSurface;
            Objects.requireNonNull(settableSurface);
            settableSurface.setProvider(deferrableSurface, new SurfaceEdge$$ExternalSyntheticLambda1(settableSurface, 0));
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            SessionConfig.ErrorListener errorListener = sessionConfig.mErrorListener;
            if (errorListener != null) {
                errorListener.onError(sessionConfig);
            }
        }
    }

    public static DeferrableSurface getChildSurface(UseCase useCase) {
        List surfaces = useCase instanceof ImageCapture ? useCase.mAttachedSessionConfig.getSurfaces() : Collections.unmodifiableList(useCase.mAttachedSessionConfig.mRepeatingCaptureConfig.mSurfaces);
        Preconditions.checkState(null, surfaces.size() <= 1);
        if (surfaces.size() == 1) {
            return (DeferrableSurface) surfaces.get(0);
        }
        return null;
    }

    public final AutoValue_OutConfig calculateOutConfig(UseCase useCase, ResolutionsMerger resolutionsMerger, CameraInternal cameraInternal, SurfaceEdge surfaceEdge, int i, boolean z) {
        Size sizeRectToSize;
        int i2;
        int sensorRotationDegrees = cameraInternal.getCameraInfo().getSensorRotationDegrees(i);
        Matrix matrix = surfaceEdge.mSensorToBufferTransform;
        RectF rectF = TransformUtils.NORMALIZED_RECT;
        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = (f2 * f4) + (f * f3);
        float f6 = (f * f4) - (f2 * f3);
        float f7 = (f4 * f4) + (f3 * f3);
        boolean z2 = false;
        double dSqrt = Math.sqrt((f2 * f2) + (f * f)) * Math.sqrt(f7);
        boolean z3 = ((float) Math.toDegrees(Math.atan2(((double) f6) / dSqrt, ((double) f5) / dSqrt))) > 0.0f;
        UseCaseConfig useCaseConfig = (UseCaseConfig) this.mChildrenConfigsMap.get(useCase);
        Objects.requireNonNull(useCaseConfig);
        Rect cropRectOfReferenceAspectRatio = surfaceEdge.mCropRect;
        float[] fArr2 = new float[9];
        surfaceEdge.mSensorToBufferTransform.getValues(fArr2);
        int iWithin360 = TransformUtils.within360((int) Math.round(Math.atan2(fArr2[3], fArr2[0]) * 57.29577951308232d));
        resolutionsMerger.getClass();
        if (TransformUtils.is90or270(iWithin360)) {
            cropRectOfReferenceAspectRatio = new Rect(cropRectOfReferenceAspectRatio.top, cropRectOfReferenceAspectRatio.left, cropRectOfReferenceAspectRatio.bottom, cropRectOfReferenceAspectRatio.right);
            z2 = true;
        }
        if (z) {
            sizeRectToSize = TransformUtils.rectToSize(cropRectOfReferenceAspectRatio);
            Iterator it = resolutionsMerger.getSortedChildSizes(useCaseConfig).iterator();
            while (it.hasNext()) {
                Size sizeRectToSize2 = TransformUtils.rectToSize(ResolutionsMerger.getCropRectOfReferenceAspectRatio((Size) it.next(), sizeRectToSize));
                if (!ResolutionsMerger.hasUpscaling(sizeRectToSize2, sizeRectToSize)) {
                    sizeRectToSize = sizeRectToSize2;
                    break;
                }
            }
        } else {
            Size sizeRectToSize3 = TransformUtils.rectToSize(cropRectOfReferenceAspectRatio);
            List sortedChildSizes = resolutionsMerger.getSortedChildSizes(useCaseConfig);
            Iterator it2 = sortedChildSizes.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    Iterator it3 = sortedChildSizes.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            sizeRectToSize = sizeRectToSize3;
                            break;
                        }
                        Size size = (Size) it3.next();
                        if (!ResolutionsMerger.hasUpscaling(size, sizeRectToSize3)) {
                            sizeRectToSize = size;
                            break;
                        }
                    }
                } else {
                    Size size2 = (Size) it2.next();
                    Rational rational = AspectRatioUtil.ASPECT_RATIO_4_3;
                    if (!AspectRatioUtil.hasMatchingAspectRatio(rational, sizeRectToSize3)) {
                        rational = AspectRatioUtil.ASPECT_RATIO_16_9;
                        if (!AspectRatioUtil.hasMatchingAspectRatio(rational, sizeRectToSize3)) {
                            rational = ResolutionsMerger.toRational(sizeRectToSize3);
                        }
                    }
                    if (!resolutionsMerger.isDoubleCropping(rational, size2) && !ResolutionsMerger.hasUpscaling(size2, sizeRectToSize3)) {
                        sizeRectToSize = size2;
                        break;
                    }
                }
            }
            cropRectOfReferenceAspectRatio = ResolutionsMerger.getCropRectOfReferenceAspectRatio(sizeRectToSize3, sizeRectToSize);
        }
        Pair pair = new Pair(cropRectOfReferenceAspectRatio, sizeRectToSize);
        Rect rect = (Rect) pair.first;
        Size size3 = (Size) pair.second;
        if (z2) {
            Size size4 = new Size(size3.getHeight(), size3.getWidth());
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
            size3 = size4;
        }
        Pair pair2 = new Pair(rect, size3);
        Rect rect2 = (Rect) pair2.first;
        Size size5 = (Size) pair2.second;
        int sensorRotationDegrees2 = this.mParentCamera.getCameraInfo().getSensorRotationDegrees(((ImageOutputConfig) useCase.mCurrentConfig).getTargetRotation());
        VirtualCamera virtualCamera = (VirtualCamera) this.mChildrenVirtualCameras.get(useCase);
        Objects.requireNonNull(virtualCamera);
        virtualCamera.mVirtualCameraInfo.mVirtualCameraRotationDegrees = sensorRotationDegrees2;
        int iWithin361 = TransformUtils.within360((surfaceEdge.mRotationDegrees + sensorRotationDegrees2) - sensorRotationDegrees);
        if (useCase instanceof Preview) {
            i2 = 1;
        } else {
            i2 = useCase instanceof ImageCapture ? 4 : 2;
        }
        return new AutoValue_OutConfig(UUID.randomUUID(), i2, useCase instanceof ImageCapture ? 256 : 34, rect2, TransformUtils.rotateSize(size5, iWithin361), iWithin361, useCase.isMirroringRequired(cameraInternal) ^ z3);
    }

    public final SurfaceEdge getUseCaseEdge(UseCase useCase) {
        SurfaceEdge surfaceEdge = (SurfaceEdge) this.mChildrenEdges.get(useCase);
        Objects.requireNonNull(surfaceEdge);
        return surfaceEdge;
    }

    public final boolean isUseCaseActive(UseCase useCase) {
        Boolean bool = (Boolean) this.mChildrenActiveState.get(useCase);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseActive(UseCase useCase) {
        CharsKt.checkMainThread();
        if (isUseCaseActive(useCase)) {
            return;
        }
        this.mChildrenActiveState.put(useCase, Boolean.TRUE);
        DeferrableSurface childSurface = getChildSurface(useCase);
        if (childSurface != null) {
            forceSetProvider(getUseCaseEdge(useCase), childSurface, useCase.mAttachedSessionConfig);
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseInactive(UseCase useCase) {
        CharsKt.checkMainThread();
        if (isUseCaseActive(useCase)) {
            this.mChildrenActiveState.put(useCase, Boolean.FALSE);
            SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
            CharsKt.checkMainThread();
            useCaseEdge.checkNotClosed();
            useCaseEdge.mSettableSurface.close();
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseReset(UseCase useCase) {
        DeferrableSurface childSurface;
        CharsKt.checkMainThread();
        SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
        if (isUseCaseActive(useCase) && (childSurface = getChildSurface(useCase)) != null) {
            forceSetProvider(useCaseEdge, childSurface, useCase.mAttachedSessionConfig);
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseUpdated(UseCase useCase) {
        CharsKt.checkMainThread();
        if (isUseCaseActive(useCase)) {
            SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
            DeferrableSurface childSurface = getChildSurface(useCase);
            if (childSurface != null) {
                forceSetProvider(useCaseEdge, childSurface, useCase.mAttachedSessionConfig);
                return;
            }
            CharsKt.checkMainThread();
            useCaseEdge.checkNotClosed();
            useCaseEdge.mSettableSurface.close();
        }
    }

    public final void setChildrenEdges(HashMap map) {
        HashMap map2 = this.mChildrenEdges;
        map2.clear();
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            UseCase useCase = (UseCase) entry.getKey();
            SurfaceEdge surfaceEdge = (SurfaceEdge) entry.getValue();
            useCase.setViewPortCropRect(surfaceEdge.mCropRect);
            useCase.setSensorToBufferTransformMatrix(surfaceEdge.mSensorToBufferTransform);
            useCase.mAttachedStreamSpec = useCase.onSuggestedStreamSpecUpdated(surfaceEdge.mStreamSpec, null);
            useCase.notifyState();
        }
    }
}
