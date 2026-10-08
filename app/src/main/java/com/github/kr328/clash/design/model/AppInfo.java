package com.github.kr328.clash.design.model;

import android.graphics.drawable.Drawable;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppInfo {
    public final Drawable icon;
    public final long installTime;
    public final String label;
    public final String packageName;
    public final long updateDate;

    public AppInfo(String str, String str2, Drawable drawable, long j, long j2) {
        this.packageName = str;
        this.label = str2;
        this.icon = drawable;
        this.installTime = j;
        this.updateDate = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) obj;
        return Intrinsics.areEqual(this.packageName, appInfo.packageName) && Intrinsics.areEqual(this.label, appInfo.label) && Intrinsics.areEqual(this.icon, appInfo.icon) && this.installTime == appInfo.installTime && this.updateDate == appInfo.updateDate;
    }

    public final int hashCode() {
        int iHashCode = (this.icon.hashCode() + Modifier.CC.m(this.packageName.hashCode() * 31, 31, this.label)) * 31;
        long j = this.installTime;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.updateDate;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("AppInfo(packageName=", this.packageName, ", label=", this.label, ", icon=");
        sbM.append(this.icon);
        sbM.append(", installTime=");
        sbM.append(this.installTime);
        sbM.append(", updateDate=");
        sbM.append(this.updateDate);
        sbM.append(")");
        return sbM.toString();
    }
}
