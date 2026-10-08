package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.core.view.MenuItemCompat$Api26Impl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewCompatShims {
    public static ExposureStateImpl getAutofillId(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new ExposureStateImpl(MenuItemCompat$Api26Impl.getAutofillId(view));
        }
        return null;
    }
}
