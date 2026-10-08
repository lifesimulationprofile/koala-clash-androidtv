package androidx.compose.foundation.gestures;

import androidx.camera.core.impl.utils.MatrixExt;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.sequences.SequenceBuilderIterator;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TrackpadScrollingLogic extends NonTouchScrollingLogic {
    public final BufferedChannel channel;
    public StandaloneCoroutine receivingPanEventsJob;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TrackpadScrollDelta {
        public final boolean isEnd;
        public final long timeMillis;
        public final long value;

        public TrackpadScrollDelta(long j, long j2, boolean z) {
            this.value = j;
            this.timeMillis = j2;
            this.isEnd = z;
        }

        public final TrackpadScrollDelta plus(TrackpadScrollDelta trackpadScrollDelta) {
            return new TrackpadScrollDelta(Offset.m373plusMKHz9U(this.value, trackpadScrollDelta.value), Math.max(this.timeMillis, trackpadScrollDelta.timeMillis), this.isEnd || trackpadScrollDelta.isEnd);
        }
    }

    public TrackpadScrollingLogic(ScrollingLogic scrollingLogic, ComposableLambdaImpl.AnonymousClass1 anonymousClass1, Density density) {
        super(scrollingLogic, anonymousClass1, density);
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, 0, 6);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00de, code lost:
    
        if (r0.invoke(r3, r7) == r10) goto L25;
     */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.AdaptedFunctionReference] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object access$dispatchTrackpadScroll(androidx.compose.foundation.gestures.TrackpadScrollingLogic r16, androidx.compose.foundation.gestures.ScrollingLogic r17, androidx.compose.foundation.gestures.TrackpadScrollingLogic.TrackpadScrollDelta r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TrackpadScrollingLogic.access$dispatchTrackpadScroll(androidx.compose.foundation.gestures.TrackpadScrollingLogic, androidx.compose.foundation.gestures.ScrollingLogic, androidx.compose.foundation.gestures.TrackpadScrollingLogic$TrackpadScrollDelta, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static TrackpadScrollDelta sumOrNull(BufferedChannel bufferedChannel) {
        TrackpadScrollDelta trackpadScrollDelta = null;
        SequenceBuilderIterator it = MatrixExt.iterator(new ForEachGestureKt$awaitEachGesture$2((Object) new TrackpadScrollingLogic$$ExternalSyntheticLambda0(bufferedChannel, 0), (Continuation) (0 == true ? 1 : 0), 1));
        while (it.hasNext()) {
            TrackpadScrollDelta trackpadScrollDeltaPlus = (TrackpadScrollDelta) it.next();
            if (trackpadScrollDelta != null) {
                trackpadScrollDeltaPlus = trackpadScrollDelta.plus(trackpadScrollDeltaPlus);
            }
            trackpadScrollDelta = trackpadScrollDeltaPlus;
        }
        return trackpadScrollDelta;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List] */
    public final boolean onPan(PointerEvent pointerEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        BufferedChannel bufferedChannel;
        ScrollingLogic scrollingLogic;
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull(pointerEvent.changes);
        if (pointerInputChange != null) {
            List list = pointerInputChange._historical;
            if (list == null) {
                list = EmptyList.INSTANCE;
            }
            int size = list.size();
            int i = 0;
            z3 = false;
            while (true) {
                bufferedChannel = this.channel;
                scrollingLogic = this.scrollingLogic;
                if (i >= size) {
                    break;
                }
                HistoricalChange historicalChange = (HistoricalChange) list.get(i);
                long j = historicalChange.panOffset ^ (-9223372034707292160L);
                if (!(scrollingLogic.m109toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m106reverseIfNeededMKHz9U(j)) == 0.0f)) {
                    z3 = !(bufferedChannel.mo842trySendJP2dKIU(new TrackpadScrollDelta(j, historicalChange.uptimeMillis, false)) instanceof ChannelResult.Failed) || z3;
                }
                i++;
            }
            z = true;
            z2 = false;
            long j2 = pointerInputChange.panOffset ^ (-9223372034707292160L);
            boolean z4 = pointerEvent.type == 12;
            if (!(scrollingLogic.m109toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m106reverseIfNeededMKHz9U(j2)) == 0.0f) || z4) {
                if (!(bufferedChannel.mo842trySendJP2dKIU(new TrackpadScrollDelta(j2, pointerInputChange.uptimeMillis, z4)) instanceof ChannelResult.Failed) || z3) {
                    z3 = true;
                }
            }
            return (!z3 || this.isScrolling) ? z : z2;
        }
        z = true;
        z2 = false;
        z3 = z2;
        if (z3) {
        }
    }
}
