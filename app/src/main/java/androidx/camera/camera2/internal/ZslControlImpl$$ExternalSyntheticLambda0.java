package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.activity.result.ActivityResultCallback;
import androidx.arch.core.util.Function;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.internal.CameraUseCaseAdapter$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.Easing;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.transition.Transition;
import com.github.kr328.clash.MainActivity;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ZslControlImpl$$ExternalSyntheticLambda0 implements Function, Preview.SurfaceProvider, Easing, CancellationHandle, DoubleFunction, ShouldPauseCallback, Transition.TransitionNotification, ActivityResultCallback {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ZslControlImpl$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        return null;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public double invoke(double d) {
        switch (this.$r8$classId) {
            case 9:
                double d2 = d < 0.0d ? -d : d;
                return Math.copySign(d2 >= 0.0031308049535603718d ? (Math.pow(d2, 0.4166666666666667d) - 0.05213270142180095d) / 0.9478672985781991d : d2 / 0.07739938080495357d, d);
            case 10:
                double d3 = d < 0.0d ? -d : d;
                return Math.copySign(d3 >= 0.04045d ? Math.pow((0.9478672985781991d * d3) + 0.05213270142180095d, 2.4d) : d3 * 0.07739938080495357d, d);
            case 11:
                float[] fArr = ColorSpaces.SrgbPrimaries;
                return ColorSpaces.transferHlgOetf$ui_graphics(ColorSpaces.Bt2020HlgTransferParameters, d);
            case 12:
                float[] fArr2 = ColorSpaces.SrgbPrimaries;
                return ColorSpaces.transferHlgEotf$ui_graphics(ColorSpaces.Bt2020HlgTransferParameters, d);
            case 13:
                float[] fArr3 = ColorSpaces.SrgbPrimaries;
                return ColorSpaces.transferSt2048Oetf$ui_graphics(ColorSpaces.Bt2020PqTransferParameters, d);
            case 14:
                float[] fArr4 = ColorSpaces.SrgbPrimaries;
                return ColorSpaces.transferSt2048Eotf$ui_graphics(ColorSpaces.Bt2020PqTransferParameters, d);
            default:
                return d;
        }
    }

    @Override // androidx.transition.Transition.TransitionNotification
    public void notifyListener(Transition.TransitionListener transitionListener, Transition transition) {
        switch (this.$r8$classId) {
            case 23:
                transitionListener.onTransitionStart$1(transition);
                break;
            case 24:
                transitionListener.onTransitionEnd$1(transition);
                break;
            case 25:
                transitionListener.onTransitionCancel(transition);
                break;
            case 26:
                transitionListener.onTransitionPause();
                break;
            default:
                transitionListener.onTransitionResume();
                break;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ((Boolean) obj).booleanValue();
        int i = MainActivity.$r8$clinit;
    }

    @Override // androidx.camera.core.Preview.SurfaceProvider
    public void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.mResolution.getWidth(), surfaceRequest.mResolution.getHeight());
        surfaceTexture.detachFromGLContext();
        Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, HexFormatKt.directExecutor(), new CameraUseCaseAdapter$$ExternalSyntheticLambda1(0, surface, surfaceTexture));
    }

    @Override // androidx.compose.runtime.ShouldPauseCallback
    public boolean shouldPause() {
        return false;
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float f) {
        float f2;
        float f3;
        switch (this.$r8$classId) {
            case 5:
                if (f < 0.36363637f) {
                    return 7.5625f * f * f;
                }
                if (f < 0.72727275f) {
                    float f4 = f - 0.54545456f;
                    f2 = 7.5625f * f4 * f4;
                    f3 = 0.75f;
                } else if (f < 0.90909094f) {
                    float f5 = f - 0.8181818f;
                    f2 = 7.5625f * f5 * f5;
                    f3 = 0.9375f;
                } else {
                    float f6 = f - 0.95454544f;
                    f2 = 7.5625f * f6 * f6;
                    f3 = 0.984375f;
                }
                return f2 + f3;
            default:
                return f;
        }
    }

    @Override // androidx.compose.runtime.CancellationHandle
    public void cancel() {
    }
}
