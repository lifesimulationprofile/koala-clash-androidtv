package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zad extends zau {
    public final /* synthetic */ GoogleApiAvailability zaa;
    public final Context zab;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zad(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.zaa = googleApiAvailability;
        this.zab = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
            return;
        }
        int i2 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        GoogleApiAvailability googleApiAvailability = this.zaa;
        Context context = this.zab;
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context, i2);
        int i3 = GooglePlayServicesUtil.$r8$clinit;
        if (iIsGooglePlayServicesAvailable == 1 || iIsGooglePlayServicesAvailable == 2 || iIsGooglePlayServicesAvailable == 3 || iIsGooglePlayServicesAvailable == 9) {
            Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(iIsGooglePlayServicesAvailable, context, "n");
            googleApiAvailability.zae(context, iIsGooglePlayServicesAvailable, errorResolutionIntent == null ? null : PendingIntent.getActivity(context, 0, errorResolutionIntent, 201326592));
        }
    }
}
