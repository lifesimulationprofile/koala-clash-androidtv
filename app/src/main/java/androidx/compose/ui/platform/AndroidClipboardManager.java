package androidx.compose.ui.platform;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidClipboardManager implements ClipboardManager {
    public android.content.ClipboardManager _clipboardManager;
    public final Context context;

    public AndroidClipboardManager(Context context) {
        this.context = context;
    }

    public final android.content.ClipboardManager getClipboardManager() {
        android.content.ClipboardManager clipboardManager = this._clipboardManager;
        if (clipboardManager != null) {
            return clipboardManager;
        }
        android.content.ClipboardManager clipboardManager2 = (android.content.ClipboardManager) this.context.getSystemService("clipboard");
        this._clipboardManager = clipboardManager2;
        return clipboardManager2;
    }
}
