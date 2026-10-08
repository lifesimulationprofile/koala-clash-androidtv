package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.SurfaceRequest;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2Config$$ExternalSyntheticLambda1 {
    public static SurfaceRequest.AnonymousClass1 newInstance(Context context, Object obj, LinkedHashSet linkedHashSet) throws InitializationException {
        try {
            return new SurfaceRequest.AnonymousClass1(context, obj, linkedHashSet);
        } catch (CameraUnavailableException e) {
            throw new InitializationException(e);
        }
    }
}
