package com.github.kr328.clash.remote;

import android.content.Context;
import com.github.kr328.clash.FilesActivity;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FilesClient {
    public static final String[] FilesProjection = {"document_id", "_display_name", "_size", "last_modified", "mime_type"};
    public final Context context;

    public FilesClient(FilesActivity filesActivity) {
        this.context = filesActivity;
    }
}
