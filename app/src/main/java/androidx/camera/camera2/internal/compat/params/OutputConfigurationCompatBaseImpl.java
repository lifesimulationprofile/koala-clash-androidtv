package androidx.camera.camera2.internal.compat.params;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class OutputConfigurationCompatBaseImpl {
    public final Object mObject;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class OutputConfigurationParamsApi21 {
        public final int mConfiguredFormat;
        public final int mConfiguredGenerationId;
        public final Size mConfiguredSize;
        public String mPhysicalCameraId;
        public final List mSurfaces;
        public boolean mIsShared = false;
        public long mDynamicRangeProfile = 1;

        public OutputConfigurationParamsApi21(Surface surface) {
            Size size;
            int iIntValue;
            int iIntValue2 = 0;
            this.mSurfaces = Collections.singletonList(surface);
            try {
                Method declaredMethod = Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("getSurfaceSize", Surface.class);
                declaredMethod.setAccessible(true);
                size = (Size) declaredMethod.invoke(null, surface);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                Logger.e("OutputConfigCompat", "Unable to retrieve surface size.", e);
                size = null;
            }
            this.mConfiguredSize = size;
            try {
                iIntValue2 = ((Integer) Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("detectSurfaceType", Surface.class).invoke(null, surface)).intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Logger.e("OutputConfigCompat", "Unable to retrieve surface format.", e2);
            }
            this.mConfiguredFormat = iIntValue2;
            try {
                iIntValue = ((Integer) Surface.class.getDeclaredMethod("getGenerationId", null).invoke(surface, null)).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
                Logger.e("OutputConfigCompat", "Unable to retrieve surface generation id.", e3);
                iIntValue = -1;
            }
            this.mConfiguredGenerationId = iIntValue;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof OutputConfigurationParamsApi21) {
                OutputConfigurationParamsApi21 outputConfigurationParamsApi21 = (OutputConfigurationParamsApi21) obj;
                List list = outputConfigurationParamsApi21.mSurfaces;
                if (this.mConfiguredSize.equals(outputConfigurationParamsApi21.mConfiguredSize) && this.mConfiguredFormat == outputConfigurationParamsApi21.mConfiguredFormat && this.mConfiguredGenerationId == outputConfigurationParamsApi21.mConfiguredGenerationId && this.mIsShared == outputConfigurationParamsApi21.mIsShared && this.mDynamicRangeProfile == outputConfigurationParamsApi21.mDynamicRangeProfile && Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi21.mPhysicalCameraId)) {
                    List list2 = this.mSurfaces;
                    int iMin = Math.min(list2.size(), list.size());
                    for (int i = 0; i < iMin; i++) {
                        if (list2.get(i) == list.get(i)) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int iHashCode = this.mSurfaces.hashCode() ^ 31;
            int i = this.mConfiguredGenerationId ^ ((iHashCode << 5) - iHashCode);
            int iHashCode2 = this.mConfiguredSize.hashCode() ^ ((i << 5) - i);
            int i2 = this.mConfiguredFormat ^ ((iHashCode2 << 5) - iHashCode2);
            int i3 = (this.mIsShared ? 1 : 0) ^ ((i2 << 5) - i2);
            int i4 = (i3 << 5) - i3;
            String str = this.mPhysicalCameraId;
            int iHashCode3 = (str == null ? 0 : str.hashCode()) ^ i4;
            int i5 = (iHashCode3 << 5) - iHashCode3;
            long j = this.mDynamicRangeProfile;
            return ((int) (j ^ (j >>> 32))) ^ i5;
        }
    }

    public OutputConfigurationCompatBaseImpl(Surface surface) {
        this.mObject = new OutputConfigurationParamsApi21(surface);
    }

    public void addSurface(Surface surface) {
        if (getSurface() == surface) {
            throw new IllegalStateException("Surface is already added!");
        }
        if (!isSurfaceSharingEnabled()) {
            throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
        }
        throw new IllegalArgumentException("Exceeds maximum number of surfaces");
    }

    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi21) this.mObject).mIsShared = true;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof OutputConfigurationCompatBaseImpl)) {
            return false;
        }
        return Objects.equals(this.mObject, ((OutputConfigurationCompatBaseImpl) obj).mObject);
    }

    public Object getOutputConfiguration() {
        return null;
    }

    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId;
    }

    public Surface getSurface() {
        List list = ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
        if (list.size() == 0) {
            return null;
        }
        return (Surface) list.get(0);
    }

    public final int hashCode() {
        return this.mObject.hashCode();
    }

    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi21) this.mObject).mIsShared;
    }

    public void setDynamicRangeProfile(long j) {
        ((OutputConfigurationParamsApi21) this.mObject).mDynamicRangeProfile = j;
    }

    public void setPhysicalCameraId(String str) {
        ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId = str;
    }

    public OutputConfigurationCompatBaseImpl(Object obj) {
        this.mObject = obj;
    }

    public void setMirrorMode(int i) {
    }

    public void setStreamUseCase(long j) {
    }
}
