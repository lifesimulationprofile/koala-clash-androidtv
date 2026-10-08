package androidx.compose.foundation.layout;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import coil.network.HttpException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLayoutBuildingBlocks {
    public final long constraints;
    public final int crossAxisSpacing;
    public final int mainAxisSpacing;
    public final FlowLayoutOverflowState overflow;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class WrapEllipsisInfo {
        public final Measurable ellipsis;
        public final long ellipsisSize;
        public boolean placeEllipsisOnLastContentLine = true;
        public final Placeable placeable;

        public WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j) {
            this.ellipsis = measurable;
            this.placeable = placeable;
            this.ellipsisSize = j;
        }
    }

    public FlowLayoutBuildingBlocks(FlowLayoutOverflowState flowLayoutOverflowState, long j, int i, int i2) {
        this.overflow = flowLayoutOverflowState;
        this.constraints = j;
        this.mainAxisSpacing = i;
        this.crossAxisSpacing = i2;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0039  */
    public final WrapEllipsisInfo getWrapEllipsisInfo(WrapInfo wrapInfo, boolean z, int i, int i2, int i3, int i4) {
        WrapEllipsisInfo wrapEllipsisInfo;
        Measurable measurable;
        IntIntPair intIntPair;
        Placeable placeable;
        if (wrapInfo.isLastItemInContainer) {
            FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
            flowLayoutOverflowState.getClass();
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(2);
            boolean z2 = true;
            if (iOrdinal == 0 || iOrdinal == 1) {
                wrapEllipsisInfo = null;
            } else {
                if (iOrdinal != 2 && iOrdinal != 3) {
                    throw new HttpException();
                }
                if (z) {
                    measurable = flowLayoutOverflowState.seeMoreMeasurable;
                    intIntPair = flowLayoutOverflowState.seeMoreSize;
                    placeable = flowLayoutOverflowState.seeMorePlaceable;
                } else {
                    measurable = (i < -1 || i2 < 0) ? null : flowLayoutOverflowState.collapseMeasurable;
                    intIntPair = flowLayoutOverflowState.collapseSize;
                    placeable = flowLayoutOverflowState.collapsePlaceable;
                }
                if (measurable == null) {
                    wrapEllipsisInfo = null;
                } else {
                    wrapEllipsisInfo = new WrapEllipsisInfo(measurable, placeable, intIntPair.packedValue);
                }
            }
            if (wrapEllipsisInfo != null) {
                if (i < 0 || (i4 != 0 && (i3 - ((int) (wrapEllipsisInfo.ellipsisSize >> 32)) < 0 || i4 >= Integer.MAX_VALUE))) {
                    z2 = false;
                }
                wrapEllipsisInfo.placeEllipsisOnLastContentLine = z2;
                return wrapEllipsisInfo;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
    
        if ((((int) (r22 >> 32)) - ((int) (r5 >> 32))) < 0) goto L20;
     */
    /* JADX INFO: renamed from: getWrapInfo-OpUlnko, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo m114getWrapInfoOpUlnko(boolean r20, int r21, long r22, androidx.collection.IntIntPair r24, int r25, int r26, int r27, boolean r28, boolean r29) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.m114getWrapInfoOpUlnko(boolean, int, long, androidx.collection.IntIntPair, int, int, int, boolean, boolean):androidx.compose.foundation.layout.FlowLayoutBuildingBlocks$WrapInfo");
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class WrapInfo {
        public final boolean isLastItemInContainer;
        public final boolean isLastItemInLine;

        public WrapInfo(boolean z, boolean z2) {
            this.isLastItemInLine = z;
            this.isLastItemInContainer = z2;
        }

        public WrapInfo(Quirks quirks, int i) {
            switch (i) {
                case 2:
                    quirks.getClass();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = quirks.mQuirks;
                    int size = arrayList2.size();
                    boolean z = false;
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList2.get(i2);
                        i2++;
                        Quirk quirk = (Quirk) obj;
                        if (CaptureIntentPreviewQuirk.class.isAssignableFrom(quirk.getClass())) {
                            arrayList.add(quirk);
                        }
                    }
                    int size2 = arrayList.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        Object obj2 = arrayList.get(i3);
                        i3++;
                        if (((CaptureIntentPreviewQuirk) obj2).workaroundByCaptureIntentPreview()) {
                            z = true;
                            this.isLastItemInLine = z;
                            this.isLastItemInContainer = quirks.contains(ImageCaptureFailedForVideoSnapshotQuirk.class);
                            break;
                        }
                    }
                    this.isLastItemInLine = z;
                    this.isLastItemInContainer = quirks.contains(ImageCaptureFailedForVideoSnapshotQuirk.class);
                    break;
                default:
                    this.isLastItemInLine = quirks.contains(ImageCaptureFailWithAutoFlashQuirk.class);
                    this.isLastItemInContainer = DeviceQuirks.sQuirks.get(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) != null;
                    break;
            }
        }
    }
}
