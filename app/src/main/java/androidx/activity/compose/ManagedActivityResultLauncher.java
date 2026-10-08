package androidx.activity.compose;

import androidx.activity.result.ActivityResultRegistry$register$2;
import androidx.core.content.pm.ShortcutManagerCompat;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ManagedActivityResultLauncher extends ShortcutManagerCompat {
    public final ActivityResultLauncherHolder launcher;

    public ManagedActivityResultLauncher(ActivityResultLauncherHolder activityResultLauncherHolder) {
        this.launcher = activityResultLauncherHolder;
    }

    public final void launch(Object obj) throws Exception {
        ActivityResultRegistry$register$2 activityResultRegistry$register$2 = this.launcher.launcher;
        if (activityResultRegistry$register$2 == null) {
            throw new IllegalStateException("Launcher has not been initialized");
        }
        activityResultRegistry$register$2.launch(obj);
    }
}
