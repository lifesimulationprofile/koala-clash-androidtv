package androidx.camera.camera2.internal;

import android.os.Build;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda0;
import androidx.compose.ui.platform.InvertMatrixKt;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraControlImpl$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Camera2CameraControlImpl$$ExternalSyntheticLambda4(int i) {
        this.$r8$classId = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                return;
            default:
                MutableObjectList mutableObjectList = AndroidComposeView.composeViews;
                synchronized (mutableObjectList) {
                    try {
                        int i = 0;
                        if (Build.VERSION.SDK_INT < 30) {
                            Object[] objArr = mutableObjectList.content;
                            int i2 = mutableObjectList._size;
                            while (i < i2) {
                                AndroidComposeView androidComposeView = (AndroidComposeView) objArr[i];
                                boolean showLayoutBounds = androidComposeView.getShowLayoutBounds();
                                Class cls = AndroidComposeView.systemPropertiesClass;
                                androidComposeView.setShowLayoutBounds(InvertMatrixKt.getIsShowingLayoutBounds());
                                if (showLayoutBounds != androidComposeView.getShowLayoutBounds()) {
                                    androidComposeView.post(new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView, 2));
                                }
                                i++;
                            }
                        } else {
                            Object[] objArr2 = mutableObjectList.content;
                            int i3 = mutableObjectList._size;
                            while (i < i3) {
                                AndroidComposeView androidComposeView2 = (AndroidComposeView) objArr2[i];
                                androidComposeView2.post(new AndroidComposeView$$ExternalSyntheticLambda0(androidComposeView2, 3));
                                i++;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    private final void run$androidx$camera$camera2$internal$Camera2CameraControlImpl$$ExternalSyntheticLambda4() {
    }
}
