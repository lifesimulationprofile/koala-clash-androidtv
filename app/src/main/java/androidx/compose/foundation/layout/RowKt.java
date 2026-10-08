package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RowKt {
    public static final RowMeasurePolicy DefaultRowMeasurePolicy = new RowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top);

    public static final RowMeasurePolicy rowMeasurePolicy(Arrangement.Horizontal horizontal, BiasAlignment.Vertical vertical, GapComposer gapComposer, int i) {
        if (Intrinsics.areEqual(horizontal, Arrangement.Start) && Intrinsics.areEqual(vertical, Alignment.Companion.Top)) {
            gapComposer.startReplaceGroup(-1073830487);
            gapComposer.end(false);
            return DefaultRowMeasurePolicy;
        }
        gapComposer.startReplaceGroup(-1073779616);
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && gapComposer.changed(horizontal)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !gapComposer.changed(vertical)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (z3 || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new RowMeasurePolicy(horizontal, vertical);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        RowMeasurePolicy rowMeasurePolicy = (RowMeasurePolicy) objRememberedValue;
        gapComposer.end(false);
        return rowMeasurePolicy;
    }
}
