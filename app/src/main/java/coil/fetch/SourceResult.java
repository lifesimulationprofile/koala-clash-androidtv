package coil.fetch;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SourceResult extends FetchResult {
    public final int dataSource;
    public final String mimeType;
    public final ResponseBody source;

    public SourceResult(ResponseBody responseBody, String str, int i) {
        this.source = responseBody;
        this.mimeType = str;
        this.dataSource = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceResult)) {
            return false;
        }
        SourceResult sourceResult = (SourceResult) obj;
        return this.source.equals(sourceResult.source) && Intrinsics.areEqual(this.mimeType, sourceResult.mimeType) && this.dataSource == sourceResult.dataSource;
    }

    public final int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        String str = this.mimeType;
        return CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.dataSource) + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31);
    }
}
