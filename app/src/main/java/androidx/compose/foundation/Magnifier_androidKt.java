package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Magnifier_androidKt {
    public static final SemanticsPropertyKey MagnifierPositionInRoot = new SemanticsPropertyKey("MagnifierPositionInRoot");

    public static boolean isPlatformMagnifierSupported$default() {
        return Build.VERSION.SDK_INT >= 28;
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q$default, reason: not valid java name */
    public static Modifier m56magnifierjPUL71Q$default(Function1 function1, Function1 function2, PlatformMagnifierFactory platformMagnifierFactory) {
        return isPlatformMagnifierSupported$default() ? new MagnifierElement(function1, function2, platformMagnifierFactory) : Modifier.Companion.$$INSTANCE;
    }
}
