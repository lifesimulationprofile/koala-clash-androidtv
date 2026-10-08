package androidx.compose.ui.contentcapture;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.request.Parameters;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContentCaptureEvent {
    public final int id;
    public final Parameters.Builder structureCompat;
    public final long timestamp;
    public final int type;

    public ContentCaptureEvent(int i, long j, int i2, Parameters.Builder builder) {
        this.id = i;
        this.timestamp = j;
        this.type = i2;
        this.structureCompat = builder;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentCaptureEvent)) {
            return false;
        }
        ContentCaptureEvent contentCaptureEvent = (ContentCaptureEvent) obj;
        return this.id == contentCaptureEvent.id && this.timestamp == contentCaptureEvent.timestamp && this.type == contentCaptureEvent.type && Intrinsics.areEqual(this.structureCompat, contentCaptureEvent.structureCompat);
    }

    public final int hashCode() {
        int i = this.id * 31;
        long j = this.timestamp;
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.type, (i + ((int) (j ^ (j >>> 32)))) * 31, 31);
        Parameters.Builder builder = this.structureCompat;
        return iM + (builder == null ? 0 : builder.hashCode());
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ContentCaptureEvent(id=");
        sb.append(this.id);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", type=");
        int i = this.type;
        if (i != 1) {
            str = i != 2 ? "null" : "VIEW_DISAPPEAR";
        } else {
            str = "VIEW_APPEAR";
        }
        sb.append(str);
        sb.append(", structureCompat=");
        sb.append(this.structureCompat);
        sb.append(')');
        return sb.toString();
    }
}
