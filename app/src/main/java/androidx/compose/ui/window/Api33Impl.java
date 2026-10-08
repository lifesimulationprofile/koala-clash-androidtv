package androidx.compose.ui.window;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Api33Impl {
    public static Object getParcelable(String str, Bundle bundle) {
        return bundle.getParcelable(str, ActivityResult.class);
    }

    public static Object getParcelableExtra(Intent intent, String str, Class cls) {
        return intent.getParcelableExtra(str, cls);
    }

    public static DynamicRange getRecommended10BitDynamicRange(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Long l = (Long) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
        if (l != null) {
            return (DynamicRange) DynamicRangeConversions.PROFILE_TO_DR_MAP.get(l);
        }
        return null;
    }

    public static String getUniqueId(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getUniqueId();
    }

    public static boolean isTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextSelectable();
    }

    public static final void maybeRegisterBackCallback(PopupLayout popupLayout, Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0) {
        OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
        if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) api33Impl$$ExternalSyntheticLambda0) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = popupLayout.findOnBackInvokedDispatcher()) == null) {
            return;
        }
        onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(1000000, api33Impl$$ExternalSyntheticLambda0);
    }

    public static final void maybeUnregisterBackCallback(PopupLayout popupLayout, Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0) {
        OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
        if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) api33Impl$$ExternalSyntheticLambda0) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = popupLayout.findOnBackInvokedDispatcher()) == null) {
            return;
        }
        onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(api33Impl$$ExternalSyntheticLambda0);
    }

    public static void setExcludedFromSurfaces(ShortcutInfo.Builder builder) {
        builder.setExcludedFromSurfaces(0);
    }
}
