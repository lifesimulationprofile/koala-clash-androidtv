package androidx.compose.runtime;

import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.lifecycle.Lifecycle;
import coil.network.HttpException;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MultiSubscriptionSnapshotFlowManager extends Lifecycle {
    public final ArrayList pendingChanges;
    public final MutableScatterMap readObserverCache;
    public final MutableScatterMap subscriptions;
    public final MutableScatterSet toNotify;
    public final OnBackPressedDispatcher$$ExternalSyntheticLambda0 unregisterApplyObserver;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Add implements SubscriptionChange {
        public final SendChannel channel;
        public final Object obj;

        public Add(Object obj, SendChannel sendChannel) {
            this.obj = obj;
            this.channel = sendChannel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RemoveScope implements SubscriptionChange {
        public final SendChannel channel;

        public RemoveScope(SendChannel sendChannel) {
            this.channel = sendChannel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface SubscriptionChange {
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.Collection] */
    public MultiSubscriptionSnapshotFlowManager() {
        super(3);
        this.subscriptions = ScopeMap.m298constructorimpl$default();
        this.pendingChanges = new ArrayList();
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.toNotify = new MutableScatterSet();
        this.readObserverCache = new MutableScatterMap();
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = new Updater$$ExternalSyntheticLambda0(22, this);
        SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers = CollectionsKt.plus((Collection) SnapshotKt.applyObservers, updater$$ExternalSyntheticLambda0);
            Unit unit = Unit.INSTANCE;
        }
        this.unregisterApplyObserver = new OnBackPressedDispatcher$$ExternalSyntheticLambda0(13, updater$$ExternalSyntheticLambda0);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void clearWatchSet$runtime(SendChannel sendChannel) {
        this.pendingChanges.add(new RemoveScope(sendChannel));
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void commitSubscriptionChanges$runtime() {
        synchronized (this.internalScopeRef) {
            try {
                ArrayList arrayList = this.pendingChanges;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    SubscriptionChange subscriptionChange = (SubscriptionChange) arrayList.get(i);
                    if (subscriptionChange instanceof Add) {
                        ScopeMap.m297addimpl(this.subscriptions, ((Add) subscriptionChange).obj, ((Add) subscriptionChange).channel);
                    } else {
                        if (!(subscriptionChange instanceof RemoveScope)) {
                            throw new HttpException();
                        }
                        ScopeMap.m300removeScopeimpl(this.subscriptions, ((RemoveScope) subscriptionChange).channel);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.pendingChanges.clear();
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        this.pendingChanges.clear();
        this.readObserverCache.clear();
        synchronized (this.internalScopeRef) {
            this.subscriptions.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Function1 readObserverFor$runtime(SendChannel sendChannel) {
        MutableScatterMap mutableScatterMap = this.readObserverCache;
        Function1 blurEffectKt$$ExternalSyntheticLambda1 = (Function1) mutableScatterMap.get(sendChannel);
        if (blurEffectKt$$ExternalSyntheticLambda1 == null) {
            blurEffectKt$$ExternalSyntheticLambda1 = new BlurEffectKt$$ExternalSyntheticLambda1(6, this, sendChannel);
            int iFindInsertIndex = mutableScatterMap.findInsertIndex(sendChannel);
            if (iFindInsertIndex < 0) {
                iFindInsertIndex = ~iFindInsertIndex;
            }
            Object[] objArr = mutableScatterMap.values;
            Object obj = objArr[iFindInsertIndex];
            mutableScatterMap.keys[iFindInsertIndex] = sendChannel;
            objArr[iFindInsertIndex] = blurEffectKt$$ExternalSyntheticLambda1;
        }
        return blurEffectKt$$ExternalSyntheticLambda1;
    }
}
