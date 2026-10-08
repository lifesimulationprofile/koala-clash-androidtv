package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColumnKt {
    public static final ColumnMeasurePolicy DefaultColumnMeasurePolicy = new ColumnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start);

    public static final ColumnMeasurePolicy columnMeasurePolicy(Arrangement.Vertical vertical, BiasAlignment.Horizontal horizontal, GapComposer gapComposer, int i) {
        if (Intrinsics.areEqual(vertical, Arrangement.Top) && horizontal.equals(Alignment.Companion.Start)) {
            gapComposer.startReplaceGroup(-1446604504);
            gapComposer.end(false);
            return DefaultColumnMeasurePolicy;
        }
        gapComposer.startReplaceGroup(-1446550657);
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && gapComposer.changed(vertical)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !gapComposer.changed(horizontal)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (z3 || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new ColumnMeasurePolicy(vertical, horizontal);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        ColumnMeasurePolicy columnMeasurePolicy = (ColumnMeasurePolicy) objRememberedValue;
        gapComposer.end(false);
        return columnMeasurePolicy;
    }
}
