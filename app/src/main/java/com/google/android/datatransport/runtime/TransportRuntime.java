package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.appcompat.widget.TooltipPopup;
import androidx.compose.ui.platform.AndroidUriHandler;
import coil.ImageLoader$Builder;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.gms.tasks.zzg;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TransportRuntime {
    public static volatile DaggerTransportRuntimeComponent instance;
    public final Clock eventClock;
    public final Scheduler scheduler;
    public final TooltipPopup uploader;
    public final Clock uptimeClock;

    public TransportRuntime(Clock clock, Clock clock2, Scheduler scheduler, TooltipPopup tooltipPopup, Dispatcher dispatcher) {
        this.eventClock = clock;
        this.uptimeClock = clock2;
        this.scheduler = scheduler;
        this.uploader = tooltipPopup;
        ((Executor) dispatcher.executorServiceOrNull).execute(new zzg(19, dispatcher));
    }

    public static TransportRuntime getInstance() {
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = instance;
        if (daggerTransportRuntimeComponent != null) {
            return (TransportRuntime) daggerTransportRuntimeComponent.transportRuntimeProvider.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void initialize(Context context) {
        if (instance == null) {
            synchronized (TransportRuntime.class) {
                try {
                    if (instance == null) {
                        AndroidUriHandler androidUriHandler = new AndroidUriHandler();
                        context.getClass();
                        androidUriHandler.context = context;
                        instance = androidUriHandler.build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final ImageLoader$Builder newFactory(EncodedDestination encodedDestination) {
        byte[] bytes;
        Set setUnmodifiableSet = encodedDestination != null ? Collections.unmodifiableSet(CCTDestination.SUPPORTED_ENCODINGS) : Collections.singleton(new Encoding("proto"));
        encodedDestination.getClass();
        CCTDestination cCTDestination = (CCTDestination) encodedDestination;
        String str = cCTDestination.endPoint;
        String str2 = cCTDestination.apiKey;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        }
        return new ImageLoader$Builder(setUnmodifiableSet, new AutoValue_TransportContext("cct", bytes, Priority.DEFAULT), this, 9);
    }
}
