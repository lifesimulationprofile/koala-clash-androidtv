package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.TagBundle;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_ImmutableImageInfo implements ImageInfo {
    public final int rotationDegrees;
    public final Matrix sensorToBufferTransformMatrix;
    public final TagBundle tagBundle;
    public final long timestamp;

    public AutoValue_ImmutableImageInfo(TagBundle tagBundle, long j, int i, Matrix matrix) {
        if (tagBundle == null) {
            throw new NullPointerException("Null tagBundle");
        }
        this.tagBundle = tagBundle;
        this.timestamp = j;
        this.rotationDegrees = i;
        this.sensorToBufferTransformMatrix = matrix;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_ImmutableImageInfo) {
            AutoValue_ImmutableImageInfo autoValue_ImmutableImageInfo = (AutoValue_ImmutableImageInfo) obj;
            if (this.tagBundle.equals(autoValue_ImmutableImageInfo.tagBundle) && this.timestamp == autoValue_ImmutableImageInfo.timestamp && this.rotationDegrees == autoValue_ImmutableImageInfo.rotationDegrees && this.sensorToBufferTransformMatrix.equals(autoValue_ImmutableImageInfo.sensorToBufferTransformMatrix)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.ImageInfo
    public final int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.ImageInfo
    public final TagBundle getTagBundle() {
        return this.tagBundle;
    }

    @Override // androidx.camera.core.ImageInfo
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int hashCode() {
        int iHashCode = (this.tagBundle.hashCode() ^ 1000003) * 1000003;
        long j = this.timestamp;
        return ((((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.sensorToBufferTransformMatrix.hashCode();
    }

    public final String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.tagBundle + ", timestamp=" + this.timestamp + ", rotationDegrees=" + this.rotationDegrees + ", sensorToBufferTransformMatrix=" + this.sensorToBufferTransformMatrix + "}";
    }
}
