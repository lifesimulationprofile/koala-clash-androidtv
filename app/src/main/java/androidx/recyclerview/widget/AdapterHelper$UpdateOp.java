package androidx.recyclerview.widget;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AdapterHelper$UpdateOp {
    public int cmd;
    public int itemCount;
    public int positionStart;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof AdapterHelper$UpdateOp)) {
                return false;
            }
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp) obj;
            int i = this.cmd;
            if (i != adapterHelper$UpdateOp.cmd) {
                return false;
            }
            if (i != 8 || Math.abs(this.itemCount - this.positionStart) != 1 || this.itemCount != adapterHelper$UpdateOp.positionStart || this.positionStart != adapterHelper$UpdateOp.itemCount) {
                return this.itemCount == adapterHelper$UpdateOp.itemCount && this.positionStart == adapterHelper$UpdateOp.positionStart;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i = this.cmd;
        if (i == 1) {
            str = "add";
        } else if (i == 2) {
            str = "rm";
        } else if (i != 4) {
            str = i != 8 ? "??" : "mv";
        } else {
            str = "up";
        }
        sb.append(str);
        sb.append(",s:");
        sb.append(this.positionStart);
        sb.append("c:");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.itemCount, ",p:null]");
    }
}
