package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.AutoValue_CameraThreadConfig;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.room.DatabaseConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2CameraFactory {
    public final ArrayList mAvailableCameraIds;
    public final DatabaseConfiguration mCameraCoordinator;
    public final HashMap mCameraInfos = new HashMap();
    public final CameraManagerCompat mCameraManager;
    public final long mCameraOpenRetryMaxTimeoutInMs;
    public final CameraStateRegistry mCameraStateRegistry;
    public final Context mContext;
    public final DisplayInfoManager mDisplayInfoManager;
    public final AutoValue_CameraThreadConfig mThreadConfig;

    public Camera2CameraFactory(Context context, AutoValue_CameraThreadConfig autoValue_CameraThreadConfig, CameraSelector cameraSelector, long j) throws InitializationException {
        String strDecideSkippedCameraIdByHeuristic;
        this.mContext = context;
        this.mThreadConfig = autoValue_CameraThreadConfig;
        CameraManagerCompat cameraManagerCompatFrom = CameraManagerCompat.from(context, autoValue_CameraThreadConfig.schedulerHandler);
        this.mCameraManager = cameraManagerCompatFrom;
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(context);
        try {
            ArrayList arrayList = new ArrayList();
            SurfaceRequest.AnonymousClass1 anonymousClass1 = cameraManagerCompatFrom.mImpl;
            anonymousClass1.getClass();
            try {
                List<String> listAsList = Arrays.asList(((CameraManager) anonymousClass1.val$requestCancellationCompleter).getCameraIdList());
                int i = 0;
                if (cameraSelector == null) {
                    Iterator it = listAsList.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) it.next());
                    }
                } else {
                    try {
                        strDecideSkippedCameraIdByHeuristic = CoroutineContext.Element.DefaultImpls.decideSkippedCameraIdByHeuristic(cameraManagerCompatFrom, cameraSelector.getLensFacing(), listAsList);
                    } catch (IllegalStateException unused) {
                        strDecideSkippedCameraIdByHeuristic = null;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (String str : listAsList) {
                        if (!str.equals(strDecideSkippedCameraIdByHeuristic)) {
                            arrayList2.add(getCameraInfo(str));
                        }
                    }
                    ArrayList arrayListFilter = cameraSelector.filter(arrayList2);
                    int size = arrayListFilter.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayListFilter.get(i2);
                        i2++;
                        arrayList.add(((CameraInfoInternal) obj).getCameraId());
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList.size();
                while (i < size2) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    String str2 = (String) obj2;
                    if (str2.equals("0") || str2.equals("1")) {
                        arrayList3.add(str2);
                    } else if (CameraIdUtil.isBackwardCompatible(this.mCameraManager, str2)) {
                        arrayList3.add(str2);
                    } else {
                        Logger.d("Camera2CameraFactory", "Camera " + str2 + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
                    }
                }
                this.mAvailableCameraIds = arrayList3;
                DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(this.mCameraManager);
                this.mCameraCoordinator = databaseConfiguration;
                CameraStateRegistry cameraStateRegistry = new CameraStateRegistry(databaseConfiguration);
                this.mCameraStateRegistry = cameraStateRegistry;
                ((ArrayList) databaseConfiguration.context).add(cameraStateRegistry);
                this.mCameraOpenRetryMaxTimeoutInMs = j;
            } catch (CameraAccessException e) {
                throw new CameraAccessExceptionCompat(e);
            }
        } catch (CameraAccessExceptionCompat e2) {
            throw new InitializationException(new CameraUnavailableException(e2));
        } catch (CameraUnavailableException e3) {
            throw new InitializationException(e3);
        }
    }

    public final Camera2CameraImpl getCamera(String str) throws CameraUnavailableException {
        if (!this.mAvailableCameraIds.contains(str)) {
            throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
        }
        Camera2CameraInfoImpl cameraInfo = getCameraInfo(str);
        AutoValue_CameraThreadConfig autoValue_CameraThreadConfig = this.mThreadConfig;
        return new Camera2CameraImpl(this.mContext, this.mCameraManager, str, cameraInfo, this.mCameraCoordinator, this.mCameraStateRegistry, autoValue_CameraThreadConfig.cameraExecutor, autoValue_CameraThreadConfig.schedulerHandler, this.mDisplayInfoManager, this.mCameraOpenRetryMaxTimeoutInMs);
    }

    public final Camera2CameraInfoImpl getCameraInfo(String str) throws CameraUnavailableException {
        HashMap map = this.mCameraInfos;
        try {
            Camera2CameraInfoImpl camera2CameraInfoImpl = (Camera2CameraInfoImpl) map.get(str);
            if (camera2CameraInfoImpl != null) {
                return camera2CameraInfoImpl;
            }
            Camera2CameraInfoImpl camera2CameraInfoImpl2 = new Camera2CameraInfoImpl(this.mCameraManager, str);
            map.put(str, camera2CameraInfoImpl2);
            return camera2CameraInfoImpl2;
        } catch (CameraAccessExceptionCompat e) {
            throw new CameraUnavailableException(e);
        }
    }
}
