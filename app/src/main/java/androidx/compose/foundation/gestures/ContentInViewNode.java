package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringIntoView$2$1$1;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.MeasuredSizeAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import coil.network.HttpException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContentInViewNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, MeasuredSizeAwareModifierNode {
    public final ScrollableNode$$ExternalSyntheticLambda0 getFocusedRect;
    public boolean isAnimationRunning;
    public Orientation orientation;
    public boolean reverseDirection;
    public final ScrollingLogic scrollingLogic;
    public boolean trackingFocusedChild;
    public final Toolbar.AnonymousClass1 bringIntoViewRequests = new Toolbar.AnonymousClass1(25);
    public long viewportSize = ContentInViewNodeKt.UnspecifiedIntSize;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Request {
        public final CancellableContinuationImpl continuation;
        public final BringIntoViewResponderNode$bringIntoView$2$1$1 currentBounds;

        public Request(BringIntoViewResponderNode$bringIntoView$2$1$1 bringIntoViewResponderNode$bringIntoView$2$1$1, CancellableContinuationImpl cancellableContinuationImpl) {
            this.currentBounds = bringIntoViewResponderNode$bringIntoView$2$1$1;
            this.continuation = cancellableContinuationImpl;
        }

        public final String toString() {
            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl.context.get(CoroutineName.Key) != null) {
                throw new ClassCastException();
            }
            StringBuilder sb = new StringBuilder("Request@");
            int iHashCode = hashCode();
            CharsKt.checkRadix(16);
            sb.append(Integer.toString(iHashCode, 16));
            sb.append("(currentBounds()=");
            sb.append(this.currentBounds.invoke());
            sb.append(", continuation=");
            sb.append(cancellableContinuationImpl);
            sb.append(')');
            return sb.toString();
        }
    }

    public ContentInViewNode(Orientation orientation, ScrollingLogic scrollingLogic, boolean z, ScrollableNode$$ExternalSyntheticLambda0 scrollableNode$$ExternalSyntheticLambda0) {
        this.orientation = orientation;
        this.scrollingLogic = scrollingLogic;
        this.reverseDirection = z;
        this.getFocusedRect = scrollableNode$$ExternalSyntheticLambda0;
    }

    /* JADX INFO: renamed from: access$calculateScrollDelta-I_oMVgE, reason: not valid java name */
    public static final float m62access$calculateScrollDeltaI_oMVgE(ContentInViewNode contentInViewNode, BringIntoViewSpec bringIntoViewSpec, long j) {
        char c;
        Rect rect;
        int iCompare;
        long j2 = contentInViewNode.viewportSize;
        MutableVector mutableVector = (MutableVector) contentInViewNode.bringIntoViewRequests.this$0;
        int i = mutableVector.size - 1;
        Object[] objArr = mutableVector.content;
        if (i < objArr.length) {
            rect = null;
            while (true) {
                if (i < 0) {
                    c = ' ';
                    break;
                }
                Rect rect2 = (Rect) ((Request) objArr[i]).currentBounds.invoke();
                if (rect2 != null) {
                    long jM379getSizeNHjbRc = rect2.m379getSizeNHjbRc();
                    long jM724toSizeozmzZPI = IntSizeKt.m724toSizeozmzZPI(contentInViewNode.m64getViewportSizeOrZeroYbymL2g$foundation());
                    c = ' ';
                    int iOrdinal = contentInViewNode.orientation.ordinal();
                    if (iOrdinal == 0) {
                        iCompare = Float.compare(Float.intBitsToFloat((int) (jM379getSizeNHjbRc & 4294967295L)), Float.intBitsToFloat((int) (jM724toSizeozmzZPI & 4294967295L)));
                    } else {
                        if (iOrdinal != 1) {
                            throw new HttpException();
                        }
                        iCompare = Float.compare(Float.intBitsToFloat((int) (jM379getSizeNHjbRc >> 32)), Float.intBitsToFloat((int) (jM724toSizeozmzZPI >> 32)));
                    }
                    if (iCompare > 0) {
                        if (rect != null) {
                            break;
                        }
                        rect = rect2;
                        break;
                    }
                    rect = rect2;
                }
                i--;
            }
        } else {
            c = ' ';
            rect = null;
        }
        if (rect == null) {
            Rect rect3 = contentInViewNode.trackingFocusedChild ? (Rect) contentInViewNode.getFocusedRect.invoke() : null;
            if (rect3 == null) {
                return 0.0f;
            }
            rect = rect3;
        }
        long jM724toSizeozmzZPI2 = IntSizeKt.m724toSizeozmzZPI(j2);
        int iOrdinal2 = contentInViewNode.orientation.ordinal();
        if (iOrdinal2 == 0) {
            float f = rect.top;
            return bringIntoViewSpec.calculateScrollDistance(f - ((int) (j & 4294967295L)), rect.bottom - f, Float.intBitsToFloat((int) (jM724toSizeozmzZPI2 & 4294967295L)));
        }
        if (iOrdinal2 != 1) {
            throw new HttpException();
        }
        float f2 = rect.left;
        return bringIntoViewSpec.calculateScrollDistance(f2 - ((int) (j >> c)), rect.right - f2, Float.intBitsToFloat((int) (jM724toSizeozmzZPI2 >> c)));
    }

    /* JADX INFO: renamed from: isMaxVisible--EQwtKw$default, reason: not valid java name */
    public static boolean m63isMaxVisibleEQwtKw$default(ContentInViewNode contentInViewNode, Rect rect, long j, long j2, int i) {
        if ((i & 1) != 0) {
            j = contentInViewNode.m64getViewportSizeOrZeroYbymL2g$foundation();
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = 0;
        }
        long jM67relocationOffsetfbGrOKE = contentInViewNode.m67relocationOffsetfbGrOKE(rect, j3, j2);
        return Math.abs(Float.intBitsToFloat((int) (jM67relocationOffsetfbGrOKE >> 32))) <= 0.5f && Math.abs(Float.intBitsToFloat((int) (jM67relocationOffsetfbGrOKE & 4294967295L))) <= 0.5f;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    /* JADX INFO: renamed from: getViewportSizeOrZero-YbymL2g$foundation, reason: not valid java name */
    public final long m64getViewportSizeOrZeroYbymL2g$foundation() {
        long j = this.viewportSize;
        if (IntSize.m720equalsimpl0(j, ContentInViewNodeKt.UnspecifiedIntSize)) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: renamed from: launchAnimation--gyyYBs, reason: not valid java name */
    public final void m65launchAnimationgyyYBs(long j) {
        DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = BringIntoViewSpec_androidKt.LocalBringIntoViewSpec;
        BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) HitTestResultKt.currentValueOf(this, dynamicProvidableCompositionLocal);
        if (this.isAnimationRunning) {
            InlineClassHelperKt.throwIllegalStateException("launchAnimation called when previous animation was running");
        }
        JobKt.launch$default(getCoroutineScope(), null, new ContentInViewNode$launchAnimation$2(this, new UpdatableAnimationState(((BringIntoViewSpec) HitTestResultKt.currentValueOf(this, dynamicProvidableCompositionLocal)).getScrollAnimationSpec()), bringIntoViewSpec, j, null), 1);
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public final void mo66onRemeasuredozmzZPI(long j) {
        int iCompare;
        long j2;
        long j3;
        long j4;
        long jM64getViewportSizeOrZeroYbymL2g$foundation = m64getViewportSizeOrZeroYbymL2g$foundation();
        this.viewportSize = j;
        int iOrdinal = this.orientation.ordinal();
        if (iOrdinal == 0) {
            iCompare = Intrinsics.compare((int) (j & 4294967295L), (int) (jM64getViewportSizeOrZeroYbymL2g$foundation & 4294967295L));
        } else {
            if (iOrdinal != 1) {
                throw new HttpException();
            }
            iCompare = Intrinsics.compare((int) (j >> 32), (int) (jM64getViewportSizeOrZeroYbymL2g$foundation >> 32));
        }
        if (iCompare >= 0) {
            return;
        }
        if (this.reverseDirection) {
            j2 = 0;
        } else {
            if (this.orientation == Orientation.Vertical) {
                j3 = ((long) 0) << 32;
                j4 = ((int) (jM64getViewportSizeOrZeroYbymL2g$foundation & 4294967295L)) - ((int) (j & 4294967295L));
            } else {
                j3 = ((long) (((int) (jM64getViewportSizeOrZeroYbymL2g$foundation >> 32)) - ((int) (j >> 32)))) << 32;
                j4 = 0;
            }
            j2 = j3 | (j4 & 4294967295L);
        }
        long j5 = j2;
        Rect rect = (Rect) this.getFocusedRect.invoke();
        if (rect == null || this.isAnimationRunning || this.trackingFocusedChild || !m63isMaxVisibleEQwtKw$default(this, rect, jM64getViewportSizeOrZeroYbymL2g$foundation, 0L, 2) || m63isMaxVisibleEQwtKw$default(this, rect, 0L, j5, 1)) {
            return;
        }
        this.trackingFocusedChild = true;
        m65launchAnimationgyyYBs(j5);
    }

    /* JADX INFO: renamed from: relocationOffset-fbGrOKE, reason: not valid java name */
    public final long m67relocationOffsetfbGrOKE(Rect rect, long j, long j2) {
        long jM724toSizeozmzZPI = IntSizeKt.m724toSizeozmzZPI(j);
        int iOrdinal = this.orientation.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new HttpException();
            }
            BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) HitTestResultKt.currentValueOf(this, BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
            float f = rect.left;
            return (((long) Float.floatToRawIntBits(bringIntoViewSpec.calculateScrollDistance(f - ((int) (j2 >> 32)), rect.right - f, Float.intBitsToFloat((int) (jM724toSizeozmzZPI >> 32))))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L);
        }
        BringIntoViewSpec bringIntoViewSpec2 = (BringIntoViewSpec) HitTestResultKt.currentValueOf(this, BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
        float f2 = rect.top;
        return (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(bringIntoViewSpec2.calculateScrollDistance(f2 - ((int) (j2 & 4294967295L)), rect.bottom - f2, Float.intBitsToFloat((int) (jM724toSizeozmzZPI & 4294967295L))))) & 4294967295L);
    }
}
