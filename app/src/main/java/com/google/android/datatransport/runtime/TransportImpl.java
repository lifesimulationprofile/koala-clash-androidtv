package com.google.android.datatransport.runtime;

import androidx.core.provider.RequestExecutor$ReplyRunnable;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import java.util.HashMap;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TransportImpl {
    public final Encoding payloadEncoding;
    public final Transformer transformer;
    public final AutoValue_TransportContext transportContext;
    public final TransportRuntime transportInternal;

    public TransportImpl(AutoValue_TransportContext autoValue_TransportContext, Encoding encoding, Transformer transformer, TransportRuntime transportRuntime) {
        this.transportContext = autoValue_TransportContext;
        this.payloadEncoding = encoding;
        this.transformer = transformer;
        this.transportInternal = transportRuntime;
    }

    public final void send(AutoValue_Event autoValue_Event) {
        TransportRuntime transportRuntime = this.transportInternal;
        Scheduler scheduler = transportRuntime.scheduler;
        Priority priority = autoValue_Event.priority;
        AutoValue_TransportContext autoValue_TransportContext = this.transportContext;
        String str = autoValue_TransportContext.backendName;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        AutoValue_TransportContext autoValue_TransportContext2 = new AutoValue_TransportContext(str, autoValue_TransportContext.extras, priority);
        Http2Connection.Builder builder = new Http2Connection.Builder();
        builder.listener = new HashMap();
        builder.source = Long.valueOf(transportRuntime.eventClock.getTime());
        builder.sink = Long.valueOf(transportRuntime.uptimeClock.getTime());
        builder.connectionName = "FIREBASE_ML_SDK";
        builder.socket = new EncodedPayload(this.payloadEncoding, (byte[]) this.transformer.apply(autoValue_Event.payload));
        builder.taskRunner = null;
        DefaultScheduler defaultScheduler = (DefaultScheduler) scheduler;
        defaultScheduler.executor.execute(new RequestExecutor$ReplyRunnable(defaultScheduler, autoValue_TransportContext2, builder.build()));
    }
}
