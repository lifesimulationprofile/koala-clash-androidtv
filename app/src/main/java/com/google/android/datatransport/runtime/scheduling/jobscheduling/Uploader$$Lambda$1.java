package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.appcompat.widget.TooltipPopup;
import androidx.room.RoomOpenHelper;
import coil.ImageLoader$Builder;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Uploader$$Lambda$1 implements Runnable {
    public final TooltipPopup arg$1;
    public final AutoValue_TransportContext arg$2;
    public final int arg$3;
    public final Runnable arg$4;

    public Uploader$$Lambda$1(TooltipPopup tooltipPopup, AutoValue_TransportContext autoValue_TransportContext, int i, Runnable runnable) {
        this.arg$1 = tooltipPopup;
        this.arg$2 = autoValue_TransportContext;
        this.arg$3 = i;
        this.arg$4 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TooltipPopup tooltipPopup = this.arg$1;
        SynchronizationGuard synchronizationGuard = (SynchronizationGuard) tooltipPopup.mTmpAnchorPos;
        AutoValue_TransportContext autoValue_TransportContext = this.arg$2;
        int i = this.arg$3;
        Runnable runnable = this.arg$4;
        try {
            EventStore eventStore = (EventStore) tooltipPopup.mMessageView;
            eventStore.getClass();
            ((SQLiteEventStore) synchronizationGuard).runCriticalSection(new Headers.Builder(2, eventStore));
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ((Context) tooltipPopup.mContext).getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                ((SQLiteEventStore) synchronizationGuard).runCriticalSection(new RoomOpenHelper(i, 9, tooltipPopup, autoValue_TransportContext));
            } else {
                tooltipPopup.logAndUpdateState(autoValue_TransportContext, i);
            }
        } catch (SynchronizationException unused) {
            ((ImageLoader$Builder) tooltipPopup.mLayoutParams).schedule(autoValue_TransportContext, i + 1, false);
        } finally {
            runnable.run();
        }
    }
}
