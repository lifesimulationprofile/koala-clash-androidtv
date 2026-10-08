package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import coil.request.Parameters;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {
    public final Parameters.Builder mCompat;

    public AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(Parameters.Builder builder) {
        this.mCompat = builder;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateAccessibilityNodeInfo = this.mCompat.createAccessibilityNodeInfo(i);
        if (accessibilityNodeInfoCompatCreateAccessibilityNodeInfo == null) {
            return null;
        }
        return accessibilityNodeInfoCompatCreateAccessibilityNodeInfo.mInfo;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i) {
        this.mCompat.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatFindFocus = this.mCompat.findFocus(i);
        if (accessibilityNodeInfoCompatFindFocus == null) {
            return null;
        }
        return accessibilityNodeInfoCompatFindFocus.mInfo;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.mCompat.performAction(i, i2, bundle);
    }
}
