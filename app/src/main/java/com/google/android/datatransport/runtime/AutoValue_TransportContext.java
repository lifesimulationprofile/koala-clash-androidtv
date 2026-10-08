package com.google.android.datatransport.runtime;

import android.util.Base64;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.android.datatransport.Priority;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_TransportContext {
    public final String backendName;
    public final byte[] extras;
    public final Priority priority;

    public AutoValue_TransportContext(String str, byte[] bArr, Priority priority) {
        this.backendName = str;
        this.extras = bArr;
        this.priority = priority;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_TransportContext) {
            AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) obj;
            if (this.backendName.equals(autoValue_TransportContext.backendName) && Arrays.equals(this.extras, autoValue_TransportContext.extras) && this.priority.equals(autoValue_TransportContext.priority)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.backendName.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.extras)) * 1000003) ^ this.priority.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.extras;
        String strEncodeToString = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(this.backendName);
        sb.append(", ");
        sb.append(this.priority);
        sb.append(", ");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, strEncodeToString, ")");
    }
}
