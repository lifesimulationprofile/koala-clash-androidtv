package com.github.kr328.clash.service.document;

import java.io.File;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FileDocument implements Document {
    public final File file;
    public final Set flags;
    public final String idOverride;
    public final String nameOverride;

    public FileDocument(File file, Set set, String str, String str2) {
        this.file = file;
        this.flags = set;
        this.idOverride = str;
        this.nameOverride = str2;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final Set getFlags() {
        return this.flags;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final String getId() {
        String str = this.idOverride;
        return str == null ? this.file.getName() : str;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final String getMimeType() {
        return this.file.isDirectory() ? "vnd.android.document/directory" : "text/plain";
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final String getName() {
        String str = this.nameOverride;
        return str == null ? this.file.getName() : str;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final long getSize() {
        return this.file.length();
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final long getUpdatedAt() {
        return this.file.lastModified();
    }
}
