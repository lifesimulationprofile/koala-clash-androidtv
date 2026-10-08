package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(context);
        if (queryParameter == null) {
            throw new NullPointerException("Null backendName");
        }
        Priority priorityValueOf = PriorityMapping.valueOf(iIntValue);
        byte[] bArrDecode = queryParameter2 != null ? Base64.decode(queryParameter2, 0) : null;
        TooltipPopup tooltipPopup = TransportRuntime.getInstance().uploader;
        ((Executor) tooltipPopup.mTmpDisplayFrame).execute(new Uploader$$Lambda$1(tooltipPopup, new AutoValue_TransportContext(queryParameter, bArrDecode, priorityValueOf), i, AlarmManagerSchedulerBroadcastReceiver$$Lambda$1.instance));
    }
}
