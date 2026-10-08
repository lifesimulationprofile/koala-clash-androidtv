package androidx.compose.foundation.text.selection;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.collection.LongIntMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.compose.ui.layout.LayoutCoordinates;
import coil.network.HttpException;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionLayoutBuilder {
    public final LayoutCoordinates containerCoordinates;
    public final long currentPosition;
    public int currentSlot;
    public int endSlot;
    public final ArrayList infoList;
    public final boolean isStartHandle;
    public final long previousHandlePosition;
    public final Selection previousSelection;
    public final MaterialButtonToggleGroup.AnonymousClass1 selectableIdOrderingComparator;
    public final MutableLongIntMap selectableIdToInfoListIndex;
    public int startSlot;

    public SelectionLayoutBuilder(long j, long j2, LayoutCoordinates layoutCoordinates, boolean z, Selection selection, MaterialButtonToggleGroup.AnonymousClass1 anonymousClass1) {
        this.currentPosition = j;
        this.previousHandlePosition = j2;
        this.containerCoordinates = layoutCoordinates;
        this.isStartHandle = z;
        this.previousSelection = selection;
        this.selectableIdOrderingComparator = anonymousClass1;
        int i = LongIntMapKt.$r8$clinit;
        this.selectableIdToInfoListIndex = new MutableLongIntMap(6);
        this.infoList = new ArrayList();
        this.startSlot = -1;
        this.endSlot = -1;
        this.currentSlot = -1;
    }

    public final int updateSlot(int i, int i2, int i3) {
        if (i == -1) {
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(SimpleLayoutKt.resolve2dDirection(i2, i3));
            if (iOrdinal == 0) {
                return this.currentSlot - 1;
            }
            if (iOrdinal == 1) {
                return this.currentSlot;
            }
            if (iOrdinal != 2) {
                throw new HttpException();
            }
        }
        return i;
    }
}
