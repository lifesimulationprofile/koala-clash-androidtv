package androidx.camera.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenFlashView extends View {
    public AnonymousClass1 mScreenFlash;
    public Window mScreenFlashWindow;

    private float getBrightness() {
        Window window = this.mScreenFlashWindow;
        if (window != null) {
            return window.getAttributes().screenBrightness;
        }
        Logger.e("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
        return Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrightness(float f) {
        if (this.mScreenFlashWindow == null) {
            Logger.e("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
            return;
        }
        if (Float.isNaN(f)) {
            Logger.e("ScreenFlashView", "setBrightness: value is NaN!");
            return;
        }
        WindowManager.LayoutParams attributes = this.mScreenFlashWindow.getAttributes();
        attributes.screenBrightness = f;
        this.mScreenFlashWindow.setAttributes(attributes);
        Logger.d("ScreenFlashView", "Brightness set to " + attributes.screenBrightness);
    }

    private void setScreenFlashUiInfo(ImageCapture.ScreenFlash screenFlash) {
        Logger.d("ScreenFlashView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }

    public long getVisibilityRampUpAnimationDurationMillis() {
        return 1000L;
    }

    public void setController(CameraController cameraController) {
        CharsKt.checkMainThread();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setScreenFlashWindow(Window window) {
        CharsKt.checkMainThread();
        if (this.mScreenFlashWindow != window) {
            this.mScreenFlash = window == null ? 0 : new ImageCapture.ScreenFlash() { // from class: androidx.camera.view.ScreenFlashView.1
                public ValueAnimator mAnimator;

                @Override // androidx.camera.core.ImageCapture.ScreenFlash
                public final void clear() {
                    Logger.d("ScreenFlashView", "ScreenFlash#clearScreenFlashUi");
                    ValueAnimator valueAnimator = this.mAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                        this.mAnimator = null;
                    }
                    ScreenFlashView screenFlashView = ScreenFlashView.this;
                    screenFlashView.setAlpha(0.0f);
                    screenFlashView.setBrightness(0.0f);
                }
            };
        }
        this.mScreenFlashWindow = window;
        setScreenFlashUiInfo(getScreenFlash());
    }
}
