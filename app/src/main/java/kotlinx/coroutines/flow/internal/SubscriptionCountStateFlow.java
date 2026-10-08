package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SubscriptionCountStateFlow extends SharedFlowImpl implements StateFlow {
    @Override // kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        Integer numValueOf;
        synchronized (this) {
            Object[] objArr = this.buffer;
            numValueOf = Integer.valueOf(((Number) objArr[((int) ((this.replayIndex + ((long) ((int) ((getHead() + ((long) this.bufferSize)) - this.replayIndex)))) - 1)) & (objArr.length - 1)]).intValue());
        }
        return numValueOf;
    }

    public final void increment(int i) {
        synchronized (this) {
            Object[] objArr = this.buffer;
            tryEmit(Integer.valueOf(((Number) objArr[((int) ((this.replayIndex + ((long) ((int) ((getHead() + ((long) this.bufferSize)) - this.replayIndex)))) - 1)) & (objArr.length - 1)]).intValue() + i));
        }
    }
}
