package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import androidx.tracing.TraceApi29Impl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewGroupUtils {
    public static boolean sTryHiddenSuppressLayout = true;

    public static void suppressLayout(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.suppressLayout(viewGroup, z);
        } else if (sTryHiddenSuppressLayout) {
            try {
                TraceApi29Impl.suppressLayout(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }
}
