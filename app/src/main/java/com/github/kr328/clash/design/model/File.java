package com.github.kr328.clash.design.model;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class File {
    public final String id;
    public final boolean isDirectory;
    public final long lastModified;
    public final String name;
    public final long size;

    public File(String str, String str2, long j, long j2, boolean z) {
        this.id = str;
        this.name = str2;
        this.size = j;
        this.lastModified = j2;
        this.isDirectory = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof File)) {
            return false;
        }
        File file = (File) obj;
        return Intrinsics.areEqual(this.id, file.id) && Intrinsics.areEqual(this.name, file.name) && this.size == file.size && this.lastModified == file.lastModified && this.isDirectory == file.isDirectory;
    }

    public final int hashCode() {
        int iM = Modifier.CC.m(this.id.hashCode() * 31, 31, this.name);
        long j = this.size;
        int i = (iM + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.lastModified;
        return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.isDirectory ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("File(id=", this.id, ", name=", this.name, ", size=");
        sbM.append(this.size);
        sbM.append(", lastModified=");
        sbM.append(this.lastModified);
        sbM.append(", isDirectory=");
        sbM.append(this.isDirectory);
        sbM.append(")");
        return sbM.toString();
    }
}
