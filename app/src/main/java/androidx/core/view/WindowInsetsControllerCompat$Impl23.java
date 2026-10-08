package androidx.core.view;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl23 extends WindowInsetsControllerCompat$Impl {
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl23(Window window) {
        this.mWindow = window;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setAppearanceLightStatusBars(boolean z) {
        Window window = this.mWindow;
        if (!z) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }
}
