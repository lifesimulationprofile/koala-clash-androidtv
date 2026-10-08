package androidx.compose.foundation.text.selection;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Selection {
    public final AnchorInfo end;
    public final boolean handlesCrossed;
    public final AnchorInfo start;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnchorInfo {
        public final int direction;
        public final int offset;
        public final long selectableId;

        public AnchorInfo(int i, int i2, long j) {
            this.direction = i;
            this.offset = i2;
            this.selectableId = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnchorInfo)) {
                return false;
            }
            AnchorInfo anchorInfo = (AnchorInfo) obj;
            return this.direction == anchorInfo.direction && this.offset == anchorInfo.offset && this.selectableId == anchorInfo.selectableId;
        }

        public final int hashCode() {
            int iOrdinal = ((CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.direction) * 31) + this.offset) * 31;
            long j = this.selectableId;
            return iOrdinal + ((int) (j ^ (j >>> 32)));
        }

        public final String toString() {
            return "AnchorInfo(direction=" + Density.CC.stringValueOf(this.direction) + ", offset=" + this.offset + ", selectableId=" + this.selectableId + ')';
        }
    }

    public Selection(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z) {
        this.start = anchorInfo;
        this.end = anchorInfo2;
        this.handlesCrossed = z;
    }

    public static Selection copy$default(Selection selection, AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z, int i) {
        if ((i & 1) != 0) {
            anchorInfo = selection.start;
        }
        if ((i & 2) != 0) {
            anchorInfo2 = selection.end;
        }
        if ((i & 4) != 0) {
            z = selection.handlesCrossed;
        }
        selection.getClass();
        return new Selection(anchorInfo, anchorInfo2, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Selection)) {
            return false;
        }
        Selection selection = (Selection) obj;
        return Intrinsics.areEqual(this.start, selection.start) && Intrinsics.areEqual(this.end, selection.end) && this.handlesCrossed == selection.handlesCrossed;
    }

    public final int hashCode() {
        return ((this.end.hashCode() + (this.start.hashCode() * 31)) * 31) + (this.handlesCrossed ? 1231 : 1237);
    }

    public final String toString() {
        return "Selection(start=" + this.start + ", end=" + this.end + ", handlesCrossed=" + this.handlesCrossed + ')';
    }
}
