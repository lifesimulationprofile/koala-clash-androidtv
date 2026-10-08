package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.AutoValue_CameraState;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.Quirks;
import androidx.camera.view.PreviewStreamStateObserver$2;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData$Source;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.internal.ProgressionUtilKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmClassMappingKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraInfoImpl implements CameraInfoInternal {
    public Camera2CameraControlImpl mCamera2CameraControlImpl;
    public final Toolbar.AnonymousClass1 mCamera2CameraInfo;
    public final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    public final String mCameraId;
    public final Quirks mCameraQuirks;
    public final RedirectableLiveData mCameraStateLiveData;
    public final Object mLock = new Object();
    public RedirectableLiveData mRedirectTorchStateLiveData = null;
    public ArrayList mCameraCaptureCallbacks = null;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RedirectableLiveData extends MutableLiveData {
        public final Object mInitialValue;
        public LiveData mLiveDataSource;
        public SafeIterableMap mSources = new SafeIterableMap();

        public RedirectableLiveData(Object obj) {
            this.mInitialValue = obj;
        }

        @Override // androidx.lifecycle.LiveData
        public final Object getValue() {
            LiveData liveData = this.mLiveDataSource;
            return liveData == null ? this.mInitialValue : liveData.getValue();
        }

        @Override // androidx.lifecycle.LiveData
        public final void onActive() {
            Iterator it = this.mSources.iterator();
            while (true) {
                SafeIterableMap.AscendingIterator ascendingIterator = (SafeIterableMap.AscendingIterator) it;
                if (!ascendingIterator.hasNext()) {
                    return;
                }
                MediatorLiveData$Source mediatorLiveData$Source = (MediatorLiveData$Source) ((Map.Entry) ascendingIterator.next()).getValue();
                mediatorLiveData$Source.mLiveData.observeForever(mediatorLiveData$Source);
            }
        }

        @Override // androidx.lifecycle.LiveData
        public final void onInactive() {
            Iterator it = this.mSources.iterator();
            while (true) {
                SafeIterableMap.AscendingIterator ascendingIterator = (SafeIterableMap.AscendingIterator) it;
                if (!ascendingIterator.hasNext()) {
                    return;
                }
                MediatorLiveData$Source mediatorLiveData$Source = (MediatorLiveData$Source) ((Map.Entry) ascendingIterator.next()).getValue();
                mediatorLiveData$Source.mLiveData.removeObserver(mediatorLiveData$Source);
            }
        }

        public final void redirectTo(MutableLiveData mutableLiveData) {
            Object obj;
            MediatorLiveData$Source mediatorLiveData$Source;
            SafeIterableMap safeIterableMap = this.mSources;
            LiveData liveData = this.mLiveDataSource;
            if (liveData != null && (mediatorLiveData$Source = (MediatorLiveData$Source) safeIterableMap.remove(liveData)) != null) {
                mediatorLiveData$Source.mLiveData.removeObserver(mediatorLiveData$Source);
            }
            this.mLiveDataSource = mutableLiveData;
            Camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0 camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0 = new Camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0(this);
            if (mutableLiveData == null) {
                throw new NullPointerException("source cannot be null");
            }
            MediatorLiveData$Source mediatorLiveData$Source2 = new MediatorLiveData$Source(mutableLiveData, camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0);
            SafeIterableMap.Entry entry = safeIterableMap.get(mutableLiveData);
            if (entry != null) {
                obj = entry.mValue;
            } else {
                SafeIterableMap.Entry entry2 = new SafeIterableMap.Entry(mutableLiveData, mediatorLiveData$Source2);
                safeIterableMap.mSize++;
                SafeIterableMap.Entry entry3 = safeIterableMap.mEnd;
                if (entry3 == null) {
                    safeIterableMap.mStart = entry2;
                    safeIterableMap.mEnd = entry2;
                } else {
                    entry3.mNext = entry2;
                    entry2.mPrevious = entry3;
                    safeIterableMap.mEnd = entry2;
                }
                obj = null;
            }
            MediatorLiveData$Source mediatorLiveData$Source3 = (MediatorLiveData$Source) obj;
            if (mediatorLiveData$Source3 != null && mediatorLiveData$Source3.mObserver != camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            }
            if (mediatorLiveData$Source3 == null && this.mActiveCount > 0) {
                mutableLiveData.observeForever(mediatorLiveData$Source2);
            }
        }
    }

    public Camera2CameraInfoImpl(CameraManagerCompat cameraManagerCompat, String str) {
        str.getClass();
        this.mCameraId = str;
        CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str);
        this.mCameraCharacteristicsCompat = cameraCharacteristicsCompat;
        Toolbar.AnonymousClass1 anonymousClass1 = new Toolbar.AnonymousClass1(13);
        anonymousClass1.this$0 = this;
        this.mCamera2CameraInfo = anonymousClass1;
        this.mCameraQuirks = ProgressionUtilKt.get(cameraCharacteristicsCompat);
        new HashMap();
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Logger.w("Camera2EncoderProfilesProvider", "Camera id is not an integer: " + str + ", unable to create Camera2EncoderProfilesProvider");
        }
        this.mCameraStateLiveData = new RedirectableLiveData(new AutoValue_CameraState(5, null));
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final void addSessionCaptureCallback(Executor executor, PreviewStreamStateObserver$2 previewStreamStateObserver$2) {
        synchronized (this.mLock) {
            try {
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                if (camera2CameraControlImpl != null) {
                    camera2CameraControlImpl.mExecutor.execute(new LiveDataObservable$$ExternalSyntheticLambda1(camera2CameraControlImpl, executor, previewStreamStateObserver$2, 1));
                    return;
                }
                if (this.mCameraCaptureCallbacks == null) {
                    this.mCameraCaptureCallbacks = new ArrayList();
                }
                this.mCameraCaptureCallbacks.add(new Pair(previewStreamStateObserver$2, executor));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final String getCameraId() {
        return this.mCameraId;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final Quirks getCameraQuirks() {
        return this.mCameraQuirks;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final String getImplementationType() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        num.getClass();
        return num.intValue() == 2 ? "androidx.camera.camera2.legacy" : "androidx.camera.camera2";
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final int getLensFacing() {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING);
        Preconditions.checkArgument("Unable to get the lens facing of the camera.", num != null);
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return 0;
        }
        if (iIntValue == 1) {
            return 1;
        }
        if (iIntValue == 2) {
            return 2;
        }
        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(iIntValue, "The given lens facing integer: ", " can not be recognized."));
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final int getSensorRotationDegrees(int i) {
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_ORIENTATION);
        num.getClass();
        return JvmClassMappingKt.getRelativeImageRotation(JvmClassMappingKt.surfaceRotationToDegrees(i), num.intValue(), 1 == getLensFacing());
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final List getSupportedResolutions(int i) {
        Size[] outputSizes = this.mCameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputSizes(i);
        return outputSizes != null ? Arrays.asList(outputSizes) : Collections.EMPTY_LIST;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final LiveData getTorchState() {
        synchronized (this.mLock) {
            try {
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                if (camera2CameraControlImpl == null) {
                    if (this.mRedirectTorchStateLiveData == null) {
                        this.mRedirectTorchStateLiveData = new RedirectableLiveData(0);
                    }
                    return this.mRedirectTorchStateLiveData;
                }
                RedirectableLiveData redirectableLiveData = this.mRedirectTorchStateLiveData;
                if (redirectableLiveData != null) {
                    return redirectableLiveData;
                }
                return camera2CameraControlImpl.mTorchControl.mTorchState;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final boolean hasFlashUnit() {
        CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCameraCharacteristicsCompat;
        Objects.requireNonNull(cameraCharacteristicsCompat);
        return ByteStreamsKt.isFlashAvailable(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(3, cameraCharacteristicsCompat));
    }

    public final void linkWithCameraControl(Camera2CameraControlImpl camera2CameraControlImpl) {
        String strM;
        synchronized (this.mLock) {
            try {
                this.mCamera2CameraControlImpl = camera2CameraControlImpl;
                RedirectableLiveData redirectableLiveData = this.mRedirectTorchStateLiveData;
                if (redirectableLiveData != null) {
                    redirectableLiveData.redirectTo(camera2CameraControlImpl.mTorchControl.mTorchState);
                }
                ArrayList arrayList = this.mCameraCaptureCallbacks;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        Pair pair = (Pair) obj;
                        Camera2CameraControlImpl camera2CameraControlImpl2 = this.mCamera2CameraControlImpl;
                        camera2CameraControlImpl2.mExecutor.execute(new LiveDataObservable$$ExternalSyntheticLambda1(camera2CameraControlImpl2, (Executor) pair.second, (CameraCaptureCallback) pair.first, 1));
                    }
                    this.mCameraCaptureCallbacks = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Integer num = (Integer) this.mCameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        num.getClass();
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            strM = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (iIntValue == 1) {
            strM = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (iIntValue == 2) {
            strM = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (iIntValue != 3) {
            strM = iIntValue != 4 ? ImageAnalysis$$ExternalSyntheticLambda1.m("Unknown value: ", iIntValue) : "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        } else {
            strM = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        }
        String strM2 = CaptureSession$State$EnumUnboxingLocalUtility.m("Device Level: ", strM);
        String strTruncateTag = Logger.truncateTag("Camera2CameraInfo");
        if (Logger.isLogLevelEnabled(strTruncateTag, 4)) {
            Log.i(strTruncateTag, strM2);
        }
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        synchronized (this.mLock) {
            try {
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCamera2CameraControlImpl;
                if (camera2CameraControlImpl != null) {
                    camera2CameraControlImpl.mExecutor.execute(new Preview$$ExternalSyntheticLambda1(3, camera2CameraControlImpl, cameraCaptureCallback));
                    return;
                }
                ArrayList arrayList = this.mCameraCaptureCallbacks;
                if (arrayList == null) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((Pair) it.next()).first == cameraCaptureCallback) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final CameraInfoInternal getImplementation() {
        return this;
    }
}
