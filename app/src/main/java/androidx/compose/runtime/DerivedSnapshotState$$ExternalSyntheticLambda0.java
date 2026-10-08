package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.CrossAxisAlignment$HorizontalCrossAxisAlignment;
import androidx.compose.foundation.layout.RowColumnParentData;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DerivedSnapshotState$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ DerivedSnapshotState$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                DerivedSnapshotState derivedSnapshotState = (DerivedSnapshotState) this.f$0;
                IntRef intRef = (IntRef) this.f$1;
                MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) this.f$2;
                if (obj == derivedSnapshotState) {
                    throw new IllegalStateException("A derived state calculation cannot read itself");
                }
                if (obj instanceof StateObject) {
                    int i = intRef.element - this.f$3;
                    int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(obj);
                    mutableObjectIntMap.set(Math.min(i, iFindKeyIndex >= 0 ? mutableObjectIntMap.values[iFindKeyIndex] : Integer.MAX_VALUE), obj);
                }
                return Unit.INSTANCE;
            case 1:
                Placeable[] placeableArr = (Placeable[]) this.f$0;
                RowMeasurePolicy rowMeasurePolicy = (RowMeasurePolicy) this.f$1;
                int[] iArr = (int[]) this.f$2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int length = placeableArr.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    Placeable placeable = placeableArr[i2];
                    int i4 = i3 + 1;
                    Object parentData = placeable.getParentData();
                    RowColumnParentData rowColumnParentData = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
                    CrossAxisAlignment$HorizontalCrossAxisAlignment crossAxisAlignment$HorizontalCrossAxisAlignment = rowColumnParentData != null ? rowColumnParentData.crossAxisAlignment : null;
                    int i5 = this.f$3;
                    Placeable.PlacementScope.place$default(placementScope, placeable, iArr[i3], crossAxisAlignment$HorizontalCrossAxisAlignment != null ? crossAxisAlignment$HorizontalCrossAxisAlignment.horizontal.align(placeable.height, i5, LayoutDirection.Ltr) : rowMeasurePolicy.verticalAlignment.align(placeable.height, i5));
                    i2++;
                    i3 = i4;
                }
                return Unit.INSTANCE;
            default:
                HorizontalScrollLayoutModifier horizontalScrollLayoutModifier = (HorizontalScrollLayoutModifier) this.f$0;
                MeasureScope measureScope = (MeasureScope) this.f$1;
                Placeable placeable2 = (Placeable) this.f$2;
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                int i6 = horizontalScrollLayoutModifier.cursorOffset;
                TextFieldScrollerPosition textFieldScrollerPosition = horizontalScrollLayoutModifier.scrollerPosition;
                TransformedText transformedText = horizontalScrollLayoutModifier.transformedText;
                TextLayoutResultProxy textLayoutResultProxy = (TextLayoutResultProxy) horizontalScrollLayoutModifier.textLayoutResultProvider.invoke();
                textFieldScrollerPosition.update(Orientation.Horizontal, BasicTextKt.access$getCursorRectInScroller(placementScope2, i6, transformedText, textLayoutResultProxy != null ? textLayoutResultProxy.value : null, measureScope.getLayoutDirection() == LayoutDirection.Rtl, placeable2.width), this.f$3, placeable2.width);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, Math.round(-textFieldScrollerPosition.offset$delegate.getFloatValue()), 0);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ DerivedSnapshotState$$ExternalSyntheticLambda0(Placeable[] placeableArr, RowMeasurePolicy rowMeasurePolicy, int i, int[] iArr) {
        this.$r8$classId = 1;
        this.f$0 = placeableArr;
        this.f$1 = rowMeasurePolicy;
        this.f$3 = i;
        this.f$2 = iArr;
    }
}
