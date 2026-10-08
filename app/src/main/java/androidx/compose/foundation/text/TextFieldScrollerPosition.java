package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.TextRange;
import coil.request.RequestService;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldScrollerPosition {
    public static final RequestService Saver;
    public final ParcelableSnapshotMutableFloatState offset$delegate;
    public final ParcelableSnapshotMutableState orientation$delegate;
    public final ParcelableSnapshotMutableFloatState maximum$delegate = new ParcelableSnapshotMutableFloatState(0.0f);
    public final ParcelableSnapshotMutableIntState viewportSize$delegate = new ParcelableSnapshotMutableIntState(0);
    public Rect previousCursorRect = Rect.Zero;
    public long previousSelection = TextRange.Zero;

    static {
        SaversKt$$ExternalSyntheticLambda0 saversKt$$ExternalSyntheticLambda0 = new SaversKt$$ExternalSyntheticLambda0(4);
        BasicTextKt$$ExternalSyntheticLambda3 basicTextKt$$ExternalSyntheticLambda3 = new BasicTextKt$$ExternalSyntheticLambda3(27);
        ScaffoldKt$$ExternalSyntheticLambda3 scaffoldKt$$ExternalSyntheticLambda3 = new ScaffoldKt$$ExternalSyntheticLambda3(6, saversKt$$ExternalSyntheticLambda0);
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, basicTextKt$$ExternalSyntheticLambda3);
        Saver = new RequestService(2, scaffoldKt$$ExternalSyntheticLambda3, basicTextKt$$ExternalSyntheticLambda3);
    }

    public TextFieldScrollerPosition(Orientation orientation, float f) {
        this.offset$delegate = new ParcelableSnapshotMutableFloatState(f);
        this.orientation$delegate = new ParcelableSnapshotMutableState(orientation, NeverEqualPolicy.INSTANCE$3);
    }

    public final void update(Orientation orientation, Rect rect, int i, int i2) {
        float f;
        float f2 = i2 - i;
        this.maximum$delegate.setFloatValue(f2);
        float f3 = rect.left;
        float f4 = rect.top;
        Rect rect2 = this.previousCursorRect;
        float f5 = rect2.left;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.offset$delegate;
        if (f3 != f5 || f4 != rect2.top) {
            boolean z = orientation == Orientation.Vertical;
            if (z) {
                f3 = f4;
            }
            float f6 = z ? rect.bottom : rect.right;
            float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
            float f7 = i;
            float f8 = floatValue + f7;
            if (f6 <= f8 && (f3 >= floatValue || f6 - f3 <= f7)) {
                f = (f3 >= floatValue || f6 - f3 > f7) ? 0.0f : f3 - floatValue;
            } else {
                f = f6 - f8;
            }
            parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState.getFloatValue() + f);
            this.previousCursorRect = rect;
        }
        parcelableSnapshotMutableFloatState.setFloatValue(RangesKt.coerceIn(parcelableSnapshotMutableFloatState.getFloatValue(), 0.0f, f2));
        this.viewportSize$delegate.setIntValue(i);
    }
}
