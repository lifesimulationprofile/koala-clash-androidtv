package com.google.android.gms.signin;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.moduleinstall.internal.zaz;
import com.google.android.gms.signin.internal.SignInClientImpl;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zaa {
    public final /* synthetic */ int $r8$classId;

    public Api$Client buildClient(Context context, Looper looper, Http2Connection.Builder builder, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        switch (this.$r8$classId) {
            case 0:
                builder.getClass();
                Integer num = (Integer) builder.listener;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new SignInClientImpl(context, looper, builder, bundle, connectionCallbacks, onConnectionFailedListener);
            case 3:
                throw ImageAnalysis$$ExternalSyntheticLambda1.m(obj);
            default:
                zabq zabqVar = (zabq) connectionCallbacks;
                zabq zabqVar2 = (zabq) onConnectionFailedListener;
                switch (this.$r8$classId) {
                    case 1:
                        return new zap(context, looper, builder, (TelemetryLoggingOptions) obj, zabqVar, zabqVar2);
                    case 2:
                        return new zaz(context, looper, 308, builder, zabqVar, zabqVar2);
                    default:
                        throw new UnsupportedOperationException("buildClient must be implemented");
                }
        }
    }
}
