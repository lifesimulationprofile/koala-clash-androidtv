package androidx.compose.ui.platform;

import android.content.ClipData;
import android.os.Build;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidClipboard implements Clipboard {
    public final AndroidClipboardManager androidClipboardManager;

    public AndroidClipboard(AndroidClipboardManager androidClipboardManager) {
        this.androidClipboardManager = androidClipboardManager;
    }

    public final Unit setClipEntry(ClipEntry clipEntry) {
        AndroidClipboardManager androidClipboardManager = this.androidClipboardManager;
        if (clipEntry != null) {
            androidClipboardManager.getClipboardManager().setPrimaryClip(clipEntry.clipData);
        } else if (Build.VERSION.SDK_INT >= 28) {
            androidClipboardManager.getClipboardManager().clearPrimaryClip();
        } else {
            androidClipboardManager.getClipboardManager().setPrimaryClip(ClipData.newPlainText("", ""));
        }
        return Unit.INSTANCE;
    }
}
