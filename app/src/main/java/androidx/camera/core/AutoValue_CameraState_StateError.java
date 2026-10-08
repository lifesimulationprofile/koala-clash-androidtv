package androidx.camera.core;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_CameraState_StateError {
    public final Throwable cause;
    public final int code;

    public AutoValue_CameraState_StateError(int i, Throwable th) {
        this.code = i;
        this.cause = th;
    }

    public final boolean equals(Object obj) {
        Throwable th;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_CameraState_StateError) {
            AutoValue_CameraState_StateError autoValue_CameraState_StateError = (AutoValue_CameraState_StateError) obj;
            Throwable th2 = autoValue_CameraState_StateError.cause;
            if (this.code == autoValue_CameraState_StateError.code && ((th = this.cause) != null ? th.equals(th2) : th2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.code ^ 1000003) * 1000003;
        Throwable th = this.cause;
        return i ^ (th == null ? 0 : th.hashCode());
    }

    public final String toString() {
        return "StateError{code=" + this.code + ", cause=" + this.cause + "}";
    }
}
