package kotlinx.serialization.internal;

import androidx.compose.foundation.FocusableNode$focusTargetNode$1;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ElementMarker {
    public static final long[] EMPTY_HIGH_MARKS = new long[0];
    public final SerialDescriptor descriptor;
    public final long[] highMarksArray;
    public long lowerMarks;
    public final FocusableNode$focusTargetNode$1 readIfAbsent;

    public ElementMarker(SerialDescriptor serialDescriptor, FocusableNode$focusTargetNode$1 focusableNode$focusTargetNode$1) {
        this.descriptor = serialDescriptor;
        this.readIfAbsent = focusableNode$focusTargetNode$1;
        int elementsCount = serialDescriptor.getElementsCount();
        if (elementsCount <= 64) {
            this.lowerMarks = elementsCount != 64 ? (-1) << elementsCount : 0L;
            this.highMarksArray = EMPTY_HIGH_MARKS;
            return;
        }
        this.lowerMarks = 0L;
        int i = (elementsCount - 1) >>> 6;
        long[] jArr = new long[i];
        if ((elementsCount & 63) != 0) {
            jArr[i - 1] = (-1) << elementsCount;
        }
        this.highMarksArray = jArr;
    }
}
