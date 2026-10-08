package androidx.compose.foundation;

import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import coil.request.RequestService;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollState implements ScrollableState {
    public static final RequestService Saver = new RequestService(2, new SaversKt$$ExternalSyntheticLambda0(1), new BorderKt$$ExternalSyntheticLambda1(25));
    public float accumulator;
    public final DerivedSnapshotState canScrollBackward$delegate;
    public final DerivedSnapshotState canScrollForward$delegate;
    public final ParcelableSnapshotMutableIntState value$delegate;
    public final ParcelableSnapshotMutableIntState viewportSize$delegate = new ParcelableSnapshotMutableIntState(0);
    public final ParcelableSnapshotMutableIntState contentSize$delegate = new ParcelableSnapshotMutableIntState(0);
    public final MutableInteractionSourceImpl internalInteractionSource = new MutableInteractionSourceImpl();
    public final ParcelableSnapshotMutableIntState _maxValueState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);
    public final DefaultScrollableState scrollableState = new DefaultScrollableState(new Recomposer$$ExternalSyntheticLambda0(3, this));

    public ScrollState(int i) {
        this.value$delegate = new ParcelableSnapshotMutableIntState(i);
        final int i2 = 0;
        this.canScrollForward$delegate = Stack.derivedStateOf(new Function0(this) { // from class: androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda1
            public final /* synthetic */ ScrollState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        ScrollState scrollState = this.f$0;
                        return Boolean.valueOf(scrollState.value$delegate.getIntValue() < scrollState._maxValueState.getIntValue());
                    default:
                        return Boolean.valueOf(this.f$0.value$delegate.getIntValue() > 0);
                }
            }
        });
        final int i3 = 1;
        this.canScrollBackward$delegate = Stack.derivedStateOf(new Function0(this) { // from class: androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda1
            public final /* synthetic */ ScrollState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i3) {
                    case 0:
                        ScrollState scrollState = this.f$0;
                        return Boolean.valueOf(scrollState.value$delegate.getIntValue() < scrollState._maxValueState.getIntValue());
                    default:
                        return Boolean.valueOf(this.f$0.value$delegate.getIntValue() > 0);
                }
            }
        });
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, function2, continuationImpl);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }
}
