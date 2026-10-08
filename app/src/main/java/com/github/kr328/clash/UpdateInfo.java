package com.github.kr328.clash;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UpdateInfo {
    public final String apkDownloadUrl;
    public final String body;
    public final String htmlUrl;
    public final String tagName;
    public final String versionName;

    public UpdateInfo(String str, String str2, String str3, String str4, String str5) {
        this.tagName = str;
        this.versionName = str2;
        this.body = str3;
        this.htmlUrl = str4;
        this.apkDownloadUrl = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateInfo)) {
            return false;
        }
        UpdateInfo updateInfo = (UpdateInfo) obj;
        return Intrinsics.areEqual(this.tagName, updateInfo.tagName) && Intrinsics.areEqual(this.versionName, updateInfo.versionName) && Intrinsics.areEqual(this.body, updateInfo.body) && Intrinsics.areEqual(this.htmlUrl, updateInfo.htmlUrl) && Intrinsics.areEqual(this.apkDownloadUrl, updateInfo.apkDownloadUrl);
    }

    public final int hashCode() {
        int iM = Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(this.tagName.hashCode() * 31, 31, this.versionName), 31, this.body), 31, this.htmlUrl);
        String str = this.apkDownloadUrl;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("UpdateInfo(tagName=", this.tagName, ", versionName=", this.versionName, ", body=");
        Density.CC.m(sbM, this.body, ", htmlUrl=", this.htmlUrl, ", apkDownloadUrl=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sbM, this.apkDownloadUrl, ")");
    }
}
