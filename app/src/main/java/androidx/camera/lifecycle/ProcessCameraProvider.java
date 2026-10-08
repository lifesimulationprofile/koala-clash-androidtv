package androidx.camera.lifecycle;

import android.content.Context;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.AutoValue_Identifier;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.internal.AutoValue_CameraUseCaseAdapter_CameraId;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.room.DatabaseConfiguration;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessCameraProvider {
    public static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();
    public CameraX mCameraX;
    public CallbackToFutureAdapter.SafeFuture mCameraXInitializeFuture;
    public Context mContext;
    public final Object mLock = new Object();
    public final Request mLifecycleCameraRepository = new Request(4);
    public final HashMap mCameraInfoMap = new HashMap();

    public static final Toolbar.AnonymousClass1 access$getCameraConfig(ProcessCameraProvider processCameraProvider, CameraSelector cameraSelector) {
        for (CameraFilter cameraFilter : cameraSelector.mCameraFilterSet) {
            AutoValue_Identifier autoValue_Identifier = CameraFilter.DEFAULT_ID;
            if (!Intrinsics.areEqual(autoValue_Identifier, autoValue_Identifier)) {
                synchronized (ExtendedCameraConfigProviderStore.LOCK) {
                }
            }
        }
        return CameraConfigs.DEFAULT_CAMERA_CONFIG;
    }

    public static final void access$setCameraOperatingMode(ProcessCameraProvider processCameraProvider, int i) {
        CameraX cameraX = processCameraProvider.mCameraX;
        if (cameraX == null) {
            return;
        }
        Camera2CameraFactory camera2CameraFactory = cameraX.mCameraFactory;
        if (camera2CameraFactory == null) {
            throw new IllegalStateException("CameraX not initialized yet.");
        }
        DatabaseConfiguration databaseConfiguration = camera2CameraFactory.mCameraCoordinator;
        if (i != databaseConfiguration.journalMode) {
            ArrayList arrayList = (ArrayList) databaseConfiguration.context;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                CameraStateRegistry cameraStateRegistry = (CameraStateRegistry) obj;
                int i3 = databaseConfiguration.journalMode;
                synchronized (cameraStateRegistry.mLock) {
                    boolean z = true;
                    cameraStateRegistry.mMaxAllowedOpenedCameras = i == 2 ? 2 : 1;
                    boolean z2 = i3 != 2 && i == 2;
                    if (i3 != 2 || i == 2) {
                        z = false;
                    }
                    if (z2 || z) {
                        cameraStateRegistry.recalculateAvailableCameras();
                    }
                }
            }
        }
        if (databaseConfiguration.journalMode == 2 && i != 2) {
            ((ArrayList) databaseConfiguration.typeConverters).clear();
        }
        databaseConfiguration.journalMode = i;
    }

    public final LifecycleCamera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCaseArr) {
        int i;
        Trace.beginSection("CX:bindToLifecycle");
        try {
            CameraX cameraX = this.mCameraX;
            if (cameraX == null) {
                i = 0;
            } else {
                Camera2CameraFactory camera2CameraFactory = cameraX.mCameraFactory;
                if (camera2CameraFactory == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                i = camera2CameraFactory.mCameraCoordinator.journalMode;
            }
            if (i == 2) {
                throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
            }
            access$setCameraOperatingMode(this, 1);
            LifecycleCamera lifecycleCameraBindToLifecycle$camera_lifecycle_release = bindToLifecycle$camera_lifecycle_release(lifecycleOwner, cameraSelector, (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length));
            android.os.Trace.endSection();
            return lifecycleCameraBindToLifecycle$camera_lifecycle_release;
        } catch (Throwable th) {
            android.os.Trace.endSection();
            throw th;
        }
    }

    public final LifecycleCamera bindToLifecycle$camera_lifecycle_release(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCaseArr) {
        LifecycleCamera lifecycleCameraCreateLifecycleCamera;
        Trace.beginSection("CX:bindToLifecycle-internal");
        try {
            CharsKt.checkMainThread();
            CameraInternal cameraInternalSelect = cameraSelector.select(this.mCameraX.mCameraRepository.getCameras());
            cameraInternalSelect.setPrimary(true);
            RestrictedCameraInfo cameraInfo = getCameraInfo(cameraSelector);
            Request request = this.mLifecycleCameraRepository;
            AutoValue_CameraUseCaseAdapter_CameraId autoValue_CameraUseCaseAdapter_CameraIdGenerateCameraId = CameraUseCaseAdapter.generateCameraId(cameraInfo, null);
            synchronized (request.url) {
                lifecycleCameraCreateLifecycleCamera = (LifecycleCamera) ((HashMap) request.method).get(new AutoValue_LifecycleCameraRepository_Key(lifecycleOwner, autoValue_CameraUseCaseAdapter_CameraIdGenerateCameraId));
            }
            Collection<LifecycleCamera> lifecycleCameras = this.mLifecycleCameraRepository.getLifecycleCameras();
            ArrayList arrayListFilterNotNull = ArraysKt.filterNotNull(useCaseArr);
            int size = arrayListFilterNotNull.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListFilterNotNull.get(i);
                i++;
                UseCase useCase = (UseCase) obj;
                for (LifecycleCamera lifecycleCamera : lifecycleCameras) {
                    if (lifecycleCamera.isBound(useCase) && !lifecycleCamera.equals(lifecycleCameraCreateLifecycleCamera)) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{useCase}, 1)));
                    }
                }
            }
            if (lifecycleCameraCreateLifecycleCamera == null) {
                Request request2 = this.mLifecycleCameraRepository;
                CameraX cameraX = this.mCameraX;
                Camera2CameraFactory camera2CameraFactory = cameraX.mCameraFactory;
                if (camera2CameraFactory == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                DatabaseConfiguration databaseConfiguration = camera2CameraFactory.mCameraCoordinator;
                SurfaceRequest.AnonymousClass1 anonymousClass1 = cameraX.mSurfaceManager;
                if (anonymousClass1 == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                Camera2UseCaseConfigFactory camera2UseCaseConfigFactory = cameraX.mDefaultConfigFactory;
                if (camera2UseCaseConfigFactory == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                lifecycleCameraCreateLifecycleCamera = request2.createLifecycleCamera(lifecycleOwner, new CameraUseCaseAdapter(cameraInternalSelect, null, cameraInfo, null, databaseConfiguration, anonymousClass1, camera2UseCaseConfigFactory));
            }
            if (useCaseArr.length != 0) {
                Request request3 = this.mLifecycleCameraRepository;
                List listListOf = AppCompatHintHelper.listOf(Arrays.copyOf(useCaseArr, useCaseArr.length));
                Camera2CameraFactory camera2CameraFactory2 = this.mCameraX.mCameraFactory;
                if (camera2CameraFactory2 == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                request3.bindToLifecycleCamera(lifecycleCameraCreateLifecycleCamera, listListOf, camera2CameraFactory2.mCameraCoordinator);
            }
            android.os.Trace.endSection();
            return lifecycleCameraCreateLifecycleCamera;
        } catch (Throwable th) {
            android.os.Trace.endSection();
            throw th;
        }
    }

    public final RestrictedCameraInfo getCameraInfo(CameraSelector cameraSelector) {
        Object restrictedCameraInfo;
        Trace.beginSection("CX:getCameraInfo");
        try {
            CameraInfoInternal cameraInfoInternal = cameraSelector.select(this.mCameraX.mCameraRepository.getCameras()).getCameraInfoInternal();
            Toolbar.AnonymousClass1 anonymousClass1Access$getCameraConfig = access$getCameraConfig(this, cameraSelector);
            AutoValue_CameraUseCaseAdapter_CameraId autoValue_CameraUseCaseAdapter_CameraId = new AutoValue_CameraUseCaseAdapter_CameraId(cameraInfoInternal.getCameraId(), (AutoValue_Identifier) anonymousClass1Access$getCameraConfig.this$0);
            synchronized (this.mLock) {
                try {
                    restrictedCameraInfo = this.mCameraInfoMap.get(autoValue_CameraUseCaseAdapter_CameraId);
                    if (restrictedCameraInfo == null) {
                        restrictedCameraInfo = new RestrictedCameraInfo(cameraInfoInternal, anonymousClass1Access$getCameraConfig);
                        this.mCameraInfoMap.put(autoValue_CameraUseCaseAdapter_CameraId, restrictedCameraInfo);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            RestrictedCameraInfo restrictedCameraInfo2 = (RestrictedCameraInfo) restrictedCameraInfo;
            android.os.Trace.endSection();
            return restrictedCameraInfo2;
        } catch (Throwable th2) {
            android.os.Trace.endSection();
            throw th2;
        }
    }
}
