package kotlinx.coroutines.channels;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.sqlite.db.SupportSQLiteQuery;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Waiter;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConflatedBufferedChannel extends BufferedChannel {
    public final int onBufferOverflow;

    public ConflatedBufferedChannel(int i, int i2) {
        super(i);
        this.onBufferOverflow = i2;
        if (i2 != 1) {
            if (i < 1) {
                throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean isConflatedDropOldest() {
        return this.onBufferOverflow == 2;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final Object send(Object obj, Continuation continuation) throws Throwable {
        if (m843trySendImplMj0NB7M(obj, true) instanceof ChannelResult.Closed) {
            throw getSendException();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo842trySendJP2dKIU(Object obj) {
        return m843trySendImplMj0NB7M(obj, false);
    }

    /* JADX INFO: renamed from: trySendImpl-Mj0NB7M, reason: not valid java name */
    public final Object m843trySendImplMj0NB7M(Object obj, boolean z) {
        if (this.onBufferOverflow == 3) {
            Object objMo842trySendJP2dKIU = super.mo842trySendJP2dKIU(obj);
            return (!(objMo842trySendJP2dKIU instanceof ChannelResult.Failed) || (objMo842trySendJP2dKIU instanceof ChannelResult.Closed)) ? objMo842trySendJP2dKIU : Unit.INSTANCE;
        }
        SupportSQLiteQuery supportSQLiteQuery = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment = (ChannelSegment) BufferedChannel.sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = BufferedChannel.sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosed = isClosed(andIncrement, false);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = i;
            long j3 = j / j2;
            int i2 = (int) (j % j2);
            if (channelSegment.id != j3) {
                ChannelSegment channelSegmentAccess$findSegmentSend = BufferedChannel.access$findSegmentSend(this, j3, channelSegment);
                if (channelSegmentAccess$findSegmentSend != null) {
                    channelSegment = channelSegmentAccess$findSegmentSend;
                } else if (zIsClosed) {
                    return new ChannelResult.Closed(getSendException());
                }
            }
            int iAccess$updateCellSend = BufferedChannel.access$updateCellSend(this, channelSegment, i2, obj, j, supportSQLiteQuery, zIsClosed);
            if (iAccess$updateCellSend == 0) {
                channelSegment.cleanPrev();
                return Unit.INSTANCE;
            }
            if (iAccess$updateCellSend == 1) {
                return Unit.INSTANCE;
            }
            if (iAccess$updateCellSend == 2) {
                if (zIsClosed) {
                    channelSegment.onSlotCleaned();
                    return new ChannelResult.Closed(getSendException());
                }
                Waiter waiter = supportSQLiteQuery instanceof Waiter ? (Waiter) supportSQLiteQuery : null;
                if (waiter != null) {
                    waiter.invokeOnCancellation(channelSegment, i2 + i);
                }
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * j2) + ((long) i2));
                return Unit.INSTANCE;
            }
            if (iAccess$updateCellSend == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iAccess$updateCellSend == 4) {
                if (j < BufferedChannel.receivers$volatile$FU.get(this)) {
                    channelSegment.cleanPrev();
                }
                return new ChannelResult.Closed(getSendException());
            }
            if (iAccess$updateCellSend == 5) {
                channelSegment.cleanPrev();
            }
        }
    }
}
