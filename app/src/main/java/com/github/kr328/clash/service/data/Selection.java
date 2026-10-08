package com.github.kr328.clash.service.data;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Selection {
    public final String proxy;
    public final String selected;
    public final UUID uuid;

    public Selection(UUID uuid, String str, String str2) {
        this.uuid = uuid;
        this.proxy = str;
        this.selected = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Selection)) {
            return false;
        }
        Selection selection = (Selection) obj;
        return Intrinsics.areEqual(this.uuid, selection.uuid) && Intrinsics.areEqual(this.proxy, selection.proxy) && Intrinsics.areEqual(this.selected, selection.selected);
    }

    public final int hashCode() {
        return this.selected.hashCode() + Modifier.CC.m(this.uuid.hashCode() * 31, 31, this.proxy);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Selection(uuid=");
        sb.append(this.uuid);
        sb.append(", proxy=");
        sb.append(this.proxy);
        sb.append(", selected=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.selected, ")");
    }
}
