package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface InputContentInfoCompat$InputContentInfoCompatImpl {
    Uri getContentUri();

    ClipDescription getDescription();

    Object getInputContentInfo();

    Uri getLinkUri();

    void requestPermission();
}
