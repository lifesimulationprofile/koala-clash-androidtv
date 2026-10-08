package com.github.kr328.clash;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.view.MenuItemCompat$Api26Impl;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ApkDownloader {
    public static void downloadAndInstall(Context context, String str, String str2) {
        String strM$1 = ImageAnalysis$$ExternalSyntheticLambda1.m$1("koalaclash-", str2, ".apk");
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), strM$1);
        if (file.exists()) {
            file.delete();
        }
        final DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        final long jEnqueue = downloadManager.enqueue(new DownloadManager.Request(Uri.parse(str)).setTitle("KoalaClash v".concat(str2)).setNotificationVisibility(1).setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, strM$1).setMimeType("application/vnd.android.package-archive"));
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.github.kr328.clash.ApkDownloader$downloadAndInstall$receiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                long j = jEnqueue;
                if (longExtra != j) {
                    return;
                }
                try {
                    context2.unregisterReceiver(this);
                } catch (Exception unused) {
                }
                Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(j);
                if (uriForDownloadedFile == null) {
                    return;
                }
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(uriForDownloadedFile, "application/vnd.android.package-archive");
                intent2.addFlags(268435457);
                try {
                    context2.startActivity(intent2);
                } catch (Exception unused2) {
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            context.registerReceiver(broadcastReceiver, intentFilter, null, null, 2);
        } else if (i >= 26) {
            MenuItemCompat$Api26Impl.registerReceiver(context, broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, null, null);
        }
    }
}
