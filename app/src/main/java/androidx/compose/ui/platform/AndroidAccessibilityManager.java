package androidx.compose.ui.platform;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAccessibilityManager implements AccessibilityManager {
    public final android.view.accessibility.AccessibilityManager accessibilityManager;

    public AndroidAccessibilityManager(Context context) {
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) context.getSystemService("accessibility");
    }
}
