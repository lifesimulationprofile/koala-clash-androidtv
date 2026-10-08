package androidx.camera.core;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_CameraState {
    public final AutoValue_CameraState_StateError error;
    public final int type;

    public AutoValue_CameraState(int i, AutoValue_CameraState_StateError autoValue_CameraState_StateError) {
        if (i == 0) {
            throw new NullPointerException("Null type");
        }
        this.type = i;
        this.error = autoValue_CameraState_StateError;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_CameraState)) {
            return false;
        }
        AutoValue_CameraState autoValue_CameraState = (AutoValue_CameraState) obj;
        AutoValue_CameraState_StateError autoValue_CameraState_StateError = autoValue_CameraState.error;
        if (!CaptureSession$State$EnumUnboxingLocalUtility.equals(this.type, autoValue_CameraState.type)) {
            return false;
        }
        AutoValue_CameraState_StateError autoValue_CameraState_StateError2 = this.error;
        if (autoValue_CameraState_StateError2 == null) {
            return autoValue_CameraState_StateError == null;
        }
        return autoValue_CameraState_StateError2.equals(autoValue_CameraState_StateError);
    }

    public final int hashCode() {
        int iOrdinal = (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.type) ^ 1000003) * 1000003;
        AutoValue_CameraState_StateError autoValue_CameraState_StateError = this.error;
        return iOrdinal ^ (autoValue_CameraState_StateError == null ? 0 : autoValue_CameraState_StateError.hashCode());
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("CameraState{type=");
        int i = this.type;
        if (i == 1) {
            str = "PENDING_OPEN";
        } else if (i == 2) {
            str = "OPENING";
        } else if (i == 3) {
            str = "OPEN";
        } else if (i != 4) {
            str = i != 5 ? "null" : "CLOSED";
        } else {
            str = "CLOSING";
        }
        sb.append(str);
        sb.append(", error=");
        sb.append(this.error);
        sb.append("}");
        return sb.toString();
    }
}
