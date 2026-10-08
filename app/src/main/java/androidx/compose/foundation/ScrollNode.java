package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollNode extends Modifier.Node implements LayoutModifierNode, SemanticsModifierNode {
    public boolean isVertical;
    public ScrollState state;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver);
        final int i = 0;
        final int i2 = 1;
        ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new Function0(this) { // from class: androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda1
            public final /* synthetic */ ScrollNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int intValue;
                switch (i) {
                    case 0:
                        intValue = this.f$0.state.value$delegate.getIntValue();
                        break;
                    default:
                        intValue = this.f$0.state._maxValueState.getIntValue();
                        break;
                }
                return Float.valueOf(intValue);
            }
        }, new Function0(this) { // from class: androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda1
            public final /* synthetic */ ScrollNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int intValue;
                switch (i2) {
                    case 0:
                        intValue = this.f$0.state.value$delegate.getIntValue();
                        break;
                    default:
                        intValue = this.f$0.state._maxValueState.getIntValue();
                        break;
                }
                return Float.valueOf(intValue);
            }
        }, false);
        if (this.isVertical) {
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.VerticalScrollAxisRange;
            KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[13];
            semanticsPropertyReceiver.set(semanticsPropertyKey, scrollAxisRange);
        } else {
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.HorizontalScrollAxisRange;
            KProperty kProperty2 = SemanticsPropertiesKt.$$delegatedProperties[12];
            semanticsPropertyReceiver.set(semanticsPropertyKey2, scrollAxisRange);
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return true;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!this.isVertical) {
            i = Integer.MAX_VALUE;
        }
        return measurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.isVertical) {
            i = Integer.MAX_VALUE;
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ImageKt.m49checkScrollableContainerConstraintsK40F9xA(j, this.isVertical ? Orientation.Vertical : Orientation.Horizontal);
        Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(Constraints.m676copyZbe2FdA$default(j, 0, this.isVertical ? Constraints.m683getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, this.isVertical ? Integer.MAX_VALUE : Constraints.m682getMaxHeightimpl(j), 5));
        int i = placeableMo517measureBRTryo0.width;
        int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
        if (i > iM683getMaxWidthimpl) {
            i = iM683getMaxWidthimpl;
        }
        int i2 = placeableMo517measureBRTryo0.height;
        int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
        if (i2 > iM682getMaxHeightimpl) {
            i2 = iM682getMaxHeightimpl;
        }
        int i3 = placeableMo517measureBRTryo0.height - i2;
        int i4 = placeableMo517measureBRTryo0.width - i;
        if (!this.isVertical) {
            i3 = i4;
        }
        ScrollState scrollState = this.state;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = scrollState._maxValueState;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = scrollState.value$delegate;
        parcelableSnapshotMutableIntState.setIntValue(i3);
        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (parcelableSnapshotMutableIntState2.getIntValue() > i3) {
                parcelableSnapshotMutableIntState2.setIntValue(i3);
            }
            Unit unit = Unit.INSTANCE;
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            this.state.viewportSize$delegate.setIntValue(this.isVertical ? i2 : i);
            this.state.contentSize$delegate.setIntValue(this.isVertical ? placeableMo517measureBRTryo0.height : placeableMo517measureBRTryo0.width);
            return measureScope.layout(i, i2, EmptyMap.INSTANCE, new ScrollNode$$ExternalSyntheticLambda0(i3, 0, this, placeableMo517measureBRTryo0));
        } catch (Throwable th) {
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!this.isVertical) {
            i = Integer.MAX_VALUE;
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.isVertical) {
            i = Integer.MAX_VALUE;
        }
        return measurable.minIntrinsicWidth(i);
    }
}
