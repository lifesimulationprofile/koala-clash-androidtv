package com.google.android.gms.common;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentActivity$HostCallbacks;
import androidx.fragment.app.FragmentManagerImpl;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0;
import coil.request.RequestService;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.DeviceProperties;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final Object zaa = new Object();
    public static final GoogleApiAvailability zab = new GoogleApiAvailability();

    public static AlertDialog zaa(Activity activity, int i, com.google.android.gms.common.internal.zad zadVar, DialogInterface.OnCancelListener onCancelListener) {
        String string;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(zac.zac(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i == 1) {
            string = resources.getString(com.koala.clash.R.string.common_google_play_services_install_button);
        } else if (i != 2) {
            string = i != 3 ? resources.getString(R.string.ok) : resources.getString(com.koala.clash.R.string.common_google_play_services_enable_button);
        } else {
            string = resources.getString(com.koala.clash.R.string.common_google_play_services_update_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, zadVar);
        }
        String strZaf = zac.zaf(activity, i);
        if (strZaf != null) {
            builder.setTitle(strZaf);
        }
        Log.w("GoogleApiAvailability", ImageAnalysis$$ExternalSyntheticLambda1.m("Creating dialog for Google Play services availability issue. ConnectionResult=", i), new IllegalArgumentException());
        return builder.create();
    }

    public static void zad(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof AppCompatActivity) {
                FragmentManagerImpl fragmentManagerImpl = ((FragmentActivity$HostCallbacks) ((AppCompatActivity) activity).mFragments.entries).mFragmentManager;
                SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
                zzah.checkNotNull(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                supportErrorDialogFragment.zaa = alertDialog;
                if (onCancelListener != null) {
                    supportErrorDialogFragment.zab = onCancelListener;
                }
                supportErrorDialogFragment.mDismissed = false;
                supportErrorDialogFragment.mShownByMe = true;
                fragmentManagerImpl.getClass();
                BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
                backStackRecord.mReorderingAllowed = true;
                backStackRecord.doAddOp(0, supportErrorDialogFragment, str, 1);
                backStackRecord.commitInternal(false);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        zzah.checkNotNull(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        errorDialogFragment.zaa = alertDialog;
        if (onCancelListener != null) {
            errorDialogFragment.zab = onCancelListener;
        }
        errorDialogFragment.show(fragmentManager, str);
    }

    public final void showErrorDialogFragment(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogZaa = zaa(googleApiActivity, i, new com.google.android.gms.common.internal.zad(super.getErrorResolutionIntent(i, googleApiActivity, "d"), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogZaa == null) {
            return;
        }
        zad(googleApiActivity, alertDialogZaa, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void zae(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        Log.w("GoogleApiAvailability", CaptureSession$State$EnumUnboxingLocalUtility.m(i, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i == 18) {
            new zad(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strZah = i == 6 ? zac.zah(context, "common_google_play_services_resolution_required_title") : zac.zaf(context, i);
        if (strZah == null) {
            strZah = context.getResources().getString(com.koala.clash.R.string.common_google_play_services_notification_ticker);
        }
        String strZag = (i == 6 || i == 19) ? zac.zag(context, "common_google_play_services_resolution_required_text", zac.zaa(context)) : zac.zac(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        zzah.checkNotNull(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, null);
        notificationCompat$Builder.mLocalOnly = true;
        notificationCompat$Builder.setFlag(16);
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(strZah);
        RequestService requestService = new RequestService(13, false);
        requestService.hardwareBitmapService = NotificationCompat$Builder.limitCharSequenceLength(strZag);
        notificationCompat$Builder.setStyle(requestService);
        PackageManager packageManager = context.getPackageManager();
        if (DeviceProperties.zze == null) {
            DeviceProperties.zze = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (DeviceProperties.zze.booleanValue()) {
            notificationCompat$Builder.mNotification.icon = context.getApplicationInfo().icon;
            notificationCompat$Builder.mPriority = 2;
            if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                notificationCompat$Builder.mActions.add(new NotificationCompat$Action(resources.getString(com.koala.clash.R.string.common_open_on_phone), pendingIntent));
            } else {
                notificationCompat$Builder.mContentIntent = pendingIntent;
            }
        } else {
            notificationCompat$Builder.mNotification.icon = R.drawable.stat_sys_warning;
            notificationCompat$Builder.mNotification.tickerText = NotificationCompat$Builder.limitCharSequenceLength(resources.getString(com.koala.clash.R.string.common_google_play_services_notification_ticker));
            notificationCompat$Builder.mNotification.when = System.currentTimeMillis();
            notificationCompat$Builder.mContentIntent = pendingIntent;
            notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(strZag);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            if (i3 < 26) {
                throw new IllegalStateException();
            }
            synchronized (zaa) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(com.koala.clash.R.string.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0.m(string));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationCompat$Builder.mChannelId = "com.google.android.gms.availability";
        }
        Notification notificationBuild = notificationCompat$Builder.build();
        if (i == 1 || i == 2 || i == 3) {
            GooglePlayServicesUtil.sCanceledAvailabilityNotification.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationBuild);
    }

    public final void zag(Activity activity, LifecycleFragment lifecycleFragment, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogZaa = zaa(activity, i, new com.google.android.gms.common.internal.zad(super.getErrorResolutionIntent(i, activity, "d"), lifecycleFragment, 1), onCancelListener);
        if (alertDialogZaa == null) {
            return;
        }
        zad(activity, alertDialogZaa, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
