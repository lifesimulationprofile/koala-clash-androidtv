package androidx.camera.camera2.internal.compat.params;

import android.os.Build;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OutputConfigurationCompat {
    public final OutputConfigurationCompatBaseImpl mImpl;

    public OutputConfigurationCompat(int i, Surface surface) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.mImpl = new OutputConfigurationCompatApi33Impl(i, surface);
            return;
        }
        if (i2 >= 28) {
            this.mImpl = new OutputConfigurationCompatApi28Impl(i, surface);
            return;
        }
        if (i2 >= 26) {
            this.mImpl = new OutputConfigurationCompatApi26Impl(i, surface);
        } else if (i2 >= 24) {
            this.mImpl = new OutputConfigurationCompatApi24Impl(i, surface);
        } else {
            this.mImpl = new OutputConfigurationCompatBaseImpl(surface);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof OutputConfigurationCompat)) {
            return false;
        }
        return this.mImpl.equals(((OutputConfigurationCompat) obj).mImpl);
    }

    public final int hashCode() {
        return this.mImpl.hashCode();
    }

    public OutputConfigurationCompat(OutputConfigurationCompatApi24Impl outputConfigurationCompatApi24Impl) {
        this.mImpl = outputConfigurationCompatApi24Impl;
    }
}
