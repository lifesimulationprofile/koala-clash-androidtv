package androidx.compose.ui.text.platform;

import androidx.emoji2.text.EmojiCompat;
import coil.request.Parameters;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiCompatStatus {
    public static final Parameters.Builder delegate;

    static {
        Parameters.Builder builder = new Parameters.Builder(12, false);
        builder.entries = EmojiCompat.isConfigured() ? builder.getFontLoadState() : null;
        delegate = builder;
    }
}
