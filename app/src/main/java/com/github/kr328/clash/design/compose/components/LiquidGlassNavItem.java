package com.github.kr328.clash.design.compose.components;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LiquidGlassNavItem {
    public final ImageVector icon;
    public final String key;
    public final String label;

    public LiquidGlassNavItem(ImageVector imageVector, String str, String str2) {
        this.key = str;
        this.icon = imageVector;
        this.label = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiquidGlassNavItem)) {
            return false;
        }
        LiquidGlassNavItem liquidGlassNavItem = (LiquidGlassNavItem) obj;
        return Intrinsics.areEqual(this.key, liquidGlassNavItem.key) && Intrinsics.areEqual(this.icon, liquidGlassNavItem.icon) && Intrinsics.areEqual(this.label, liquidGlassNavItem.label);
    }

    public final int hashCode() {
        return this.label.hashCode() + ((this.icon.hashCode() + (this.key.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LiquidGlassNavItem(key=");
        sb.append(this.key);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", label=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.label, ")");
    }
}
