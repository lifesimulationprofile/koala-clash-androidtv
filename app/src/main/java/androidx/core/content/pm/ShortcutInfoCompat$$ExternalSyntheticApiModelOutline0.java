package androidx.core.content.pm;

import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import com.github.kr328.clash.MainApplication;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ShortcutInfoCompat$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ ShortcutInfo.Builder m(MainApplication mainApplication, String str) {
        return new ShortcutInfo.Builder(mainApplication, str);
    }

    public static /* bridge */ /* synthetic */ ShortcutManager m(Object obj) {
        return (ShortcutManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class m() {
        return ShortcutManager.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m742m() {
    }
}
