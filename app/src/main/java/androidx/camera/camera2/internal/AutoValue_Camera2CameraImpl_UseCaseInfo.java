package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_Camera2CameraImpl_UseCaseInfo {
    public final List captureTypes;
    public final SessionConfig sessionConfig;
    public final AutoValue_StreamSpec streamSpec;
    public final Size surfaceResolution;
    public final UseCaseConfig useCaseConfig;
    public final String useCaseId;
    public final Class useCaseType;

    public AutoValue_Camera2CameraImpl_UseCaseInfo(String str, Class cls, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, Size size, AutoValue_StreamSpec autoValue_StreamSpec, ArrayList arrayList) {
        if (str == null) {
            throw new NullPointerException("Null useCaseId");
        }
        this.useCaseId = str;
        this.useCaseType = cls;
        if (sessionConfig == null) {
            throw new NullPointerException("Null sessionConfig");
        }
        this.sessionConfig = sessionConfig;
        if (useCaseConfig == null) {
            throw new NullPointerException("Null useCaseConfig");
        }
        this.useCaseConfig = useCaseConfig;
        this.surfaceResolution = size;
        this.streamSpec = autoValue_StreamSpec;
        this.captureTypes = arrayList;
    }

    public final boolean equals(Object obj) {
        Size size;
        AutoValue_StreamSpec autoValue_StreamSpec;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_Camera2CameraImpl_UseCaseInfo) {
            AutoValue_Camera2CameraImpl_UseCaseInfo autoValue_Camera2CameraImpl_UseCaseInfo = (AutoValue_Camera2CameraImpl_UseCaseInfo) obj;
            List list2 = autoValue_Camera2CameraImpl_UseCaseInfo.captureTypes;
            AutoValue_StreamSpec autoValue_StreamSpec2 = autoValue_Camera2CameraImpl_UseCaseInfo.streamSpec;
            Size size2 = autoValue_Camera2CameraImpl_UseCaseInfo.surfaceResolution;
            if (this.useCaseId.equals(autoValue_Camera2CameraImpl_UseCaseInfo.useCaseId) && this.useCaseType.equals(autoValue_Camera2CameraImpl_UseCaseInfo.useCaseType) && this.sessionConfig.equals(autoValue_Camera2CameraImpl_UseCaseInfo.sessionConfig) && this.useCaseConfig.equals(autoValue_Camera2CameraImpl_UseCaseInfo.useCaseConfig) && ((size = this.surfaceResolution) != null ? size.equals(size2) : size2 == null) && ((autoValue_StreamSpec = this.streamSpec) != null ? autoValue_StreamSpec.equals(autoValue_StreamSpec2) : autoValue_StreamSpec2 == null) && ((list = this.captureTypes) != null ? list.equals(list2) : list2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.useCaseId.hashCode() ^ 1000003) * 1000003) ^ this.useCaseType.hashCode()) * 1000003) ^ this.sessionConfig.hashCode()) * 1000003) ^ this.useCaseConfig.hashCode()) * 1000003;
        Size size = this.surfaceResolution;
        int iHashCode2 = (iHashCode ^ (size == null ? 0 : size.hashCode())) * 1000003;
        AutoValue_StreamSpec autoValue_StreamSpec = this.streamSpec;
        int iHashCode3 = (iHashCode2 ^ (autoValue_StreamSpec == null ? 0 : autoValue_StreamSpec.hashCode())) * 1000003;
        List list = this.captureTypes;
        return iHashCode3 ^ (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "UseCaseInfo{useCaseId=" + this.useCaseId + ", useCaseType=" + this.useCaseType + ", sessionConfig=" + this.sessionConfig + ", useCaseConfig=" + this.useCaseConfig + ", surfaceResolution=" + this.surfaceResolution + ", streamSpec=" + this.streamSpec + ", captureTypes=" + this.captureTypes + "}";
    }
}
