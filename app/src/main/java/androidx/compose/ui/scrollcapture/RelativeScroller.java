package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.text.android.StaticLayoutFactory;
import androidx.compose.ui.text.android.TextLayout;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RelativeScroller {
    public float scrollAmount;
    public final Object scrollBy;
    public int viewportSize;

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RelativeScroller.this.scrollBy(0.0f, this);
        }
    }

    public RelativeScroller(int i, ComposeScrollCaptureCallback$scrollTracker$1 composeScrollCaptureCallback$scrollTracker$1) {
        this.viewportSize = i;
        this.scrollBy = composeScrollCaptureCallback$scrollTracker$1;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    public float get(int i, boolean z, boolean z2, boolean z3) {
        boolean z4;
        TextLayout textLayout = (TextLayout) this.scrollBy;
        int i2 = 1;
        if (z) {
            int lineForOffset = StaticLayoutFactory.getLineForOffset(textLayout.layout, i, z);
            int lineStart = textLayout.layout.getLineStart(lineForOffset);
            int lineEnd = textLayout.getLineEnd(lineForOffset);
            if (i == lineStart || i == lineEnd) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        int i3 = i * 4;
        if (!z3) {
            i2 = z4 ? 2 : 3;
        } else if (z4) {
            i2 = 0;
        }
        int i4 = i3 + i2;
        if (this.viewportSize == i4) {
            return this.scrollAmount;
        }
        float primaryHorizontal = z3 ? textLayout.getPrimaryHorizontal(i, z) : textLayout.getSecondaryHorizontal(i, z);
        if (z2) {
            this.viewportSize = i4;
            this.scrollAmount = primaryHorizontal;
        }
        return primaryHorizontal;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object scrollBy(float f, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objInvoke = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            ComposeScrollCaptureCallback$scrollTracker$1 composeScrollCaptureCallback$scrollTracker$1 = (ComposeScrollCaptureCallback$scrollTracker$1) this.scrollBy;
            Float f2 = new Float(f);
            anonymousClass1.label = 1;
            objInvoke = composeScrollCaptureCallback$scrollTracker$1.invoke(f2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objInvoke);
        }
        this.scrollAmount += ((Number) objInvoke).floatValue();
        return Unit.INSTANCE;
    }

    public RelativeScroller(TextLayout textLayout) {
        this.scrollBy = textLayout;
        this.viewportSize = -1;
    }
}
