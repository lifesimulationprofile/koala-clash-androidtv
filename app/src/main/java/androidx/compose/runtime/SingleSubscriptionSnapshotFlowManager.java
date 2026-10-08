package androidx.compose.runtime;

import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.lifecycle.Lifecycle;
import java.util.Collection;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SingleSubscriptionSnapshotFlowManager extends Lifecycle {
    public final Recomposer$$ExternalSyntheticLambda0 readObserverCache;
    public Object soleWatchedObject;
    public SendChannel subscribedChannel;
    public final OnBackPressedDispatcher$$ExternalSyntheticLambda0 unregisterApplyObserver;
    public MutableScatterSet watchSet;
    public Object workingSoleWatchedObject;
    public MutableScatterSet workingWatchSet;

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.Collection] */
    public SingleSubscriptionSnapshotFlowManager() {
        super(3);
        this.readObserverCache = new Recomposer$$ExternalSyntheticLambda0(29, this);
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = new Updater$$ExternalSyntheticLambda0(24, this);
        SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers = CollectionsKt.plus((Collection) SnapshotKt.applyObservers, updater$$ExternalSyntheticLambda0);
            Unit unit = Unit.INSTANCE;
        }
        this.unregisterApplyObserver = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(13, updater$$ExternalSyntheticLambda0);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void clearWatchSet$runtime(SendChannel sendChannel) {
        this.workingSoleWatchedObject = null;
        this.workingWatchSet = null;
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void commitSubscriptionChanges$runtime() {
        synchronized (this.internalScopeRef) {
            try {
                this.soleWatchedObject = this.workingSoleWatchedObject;
                if (this.workingWatchSet == null) {
                    this.watchSet = null;
                } else {
                    if (this.watchSet == null) {
                        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
                        this.watchSet = new MutableScatterSet();
                    }
                    MutableScatterSet mutableScatterSet2 = this.watchSet;
                    this.watchSet = this.workingWatchSet;
                    this.workingWatchSet = mutableScatterSet2;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        this.workingSoleWatchedObject = null;
        this.workingWatchSet = null;
        synchronized (this.internalScopeRef) {
            this.subscribedChannel = null;
            this.soleWatchedObject = null;
            this.watchSet = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Function1 readObserverFor$runtime(SendChannel sendChannel) {
        SendChannel sendChannel2 = this.subscribedChannel;
        if (sendChannel2 != null && !sendChannel2.equals(sendChannel)) {
            PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
        }
        this.subscribedChannel = sendChannel;
        return this.readObserverCache;
    }
}
