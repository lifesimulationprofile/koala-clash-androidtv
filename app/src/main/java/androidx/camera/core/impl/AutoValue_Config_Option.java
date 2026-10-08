package androidx.camera.core.impl;

import android.hardware.camera2.CaptureRequest;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_Config_Option {
    public final String id;
    public final Object token;
    public final Class valueClass;

    public AutoValue_Config_Option(String str, Class cls, CaptureRequest.Key key) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.id = str;
        if (cls == null) {
            throw new NullPointerException("Null valueClass");
        }
        this.valueClass = cls;
        this.token = key;
    }

    public final boolean equals(Object obj) {
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_Config_Option) {
            AutoValue_Config_Option autoValue_Config_Option = (AutoValue_Config_Option) obj;
            Object obj3 = autoValue_Config_Option.token;
            if (this.id.equals(autoValue_Config_Option.id) && this.valueClass.equals(autoValue_Config_Option.valueClass) && ((obj2 = this.token) != null ? obj2.equals(obj3) : obj3 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.id.hashCode() ^ 1000003) * 1000003) ^ this.valueClass.hashCode()) * 1000003;
        Object obj = this.token;
        return iHashCode ^ (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "Option{id=" + this.id + ", valueClass=" + this.valueClass + ", token=" + this.token + "}";
    }
}
