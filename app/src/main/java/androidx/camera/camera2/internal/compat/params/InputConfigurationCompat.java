package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InputConfigurationCompat {
    public final InputConfigurationCompatApi23Impl mImpl;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class InputConfigurationCompatApi23Impl {
        public final InputConfiguration mObject;

        public InputConfigurationCompatApi23Impl(Object obj) {
            this.mObject = (InputConfiguration) obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof InputConfigurationCompatApi23Impl)) {
                return false;
            }
            return Objects.equals(this.mObject, ((InputConfigurationCompatApi23Impl) obj).mObject);
        }

        public final int hashCode() {
            return this.mObject.hashCode();
        }

        public final String toString() {
            return this.mObject.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class InputConfigurationCompatApi31Impl extends InputConfigurationCompatApi23Impl {
    }

    public InputConfigurationCompat(InputConfigurationCompatApi23Impl inputConfigurationCompatApi23Impl) {
        this.mImpl = inputConfigurationCompatApi23Impl;
    }

    public static InputConfigurationCompat wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 31 ? new InputConfigurationCompat(new InputConfigurationCompatApi31Impl(obj)) : new InputConfigurationCompat(new InputConfigurationCompatApi23Impl(obj));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof InputConfigurationCompat)) {
            return false;
        }
        return this.mImpl.equals(((InputConfigurationCompat) obj).mImpl);
    }

    public final int hashCode() {
        return this.mImpl.hashCode();
    }

    public final String toString() {
        return this.mImpl.toString();
    }
}
