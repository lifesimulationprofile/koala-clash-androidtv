package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import coil.memory.MemoryCacheService;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        File codeCacheDir;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            Encoding.writeProfile(context, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new MemoryCacheService(16, this), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                        setResultCode(11);
                        return;
                    }
                    return;
                }
                MemoryCacheService memoryCacheService = new MemoryCacheService(16, this);
                try {
                    Encoding.noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    memoryCacheService.onResultReceived(10, null);
                    return;
                } catch (PackageManager.NameNotFoundException e) {
                    memoryCacheService.onResultReceived(7, e);
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            MemoryCacheService memoryCacheService2 = new MemoryCacheService(16, this);
            int iMyPid = Process.myPid();
            if (Build.VERSION.SDK_INT < 24) {
                memoryCacheService2.onResultReceived(13, null);
                return;
            } else {
                Process.sendSignal(iMyPid, 10);
                memoryCacheService2.onResultReceived(12, null);
                return;
            }
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        MemoryCacheService memoryCacheService3 = new MemoryCacheService(16, this);
        if (!"DROP_SHADER_CACHE".equals(string2)) {
            if (!"SAVE_PROFILE".equals(string2)) {
                memoryCacheService3.onResultReceived(16, null);
                return;
            }
            int i = extras.getInt("EXTRA_PID", Process.myPid());
            if (Build.VERSION.SDK_INT < 24) {
                memoryCacheService3.onResultReceived(13, null);
                return;
            } else {
                Process.sendSignal(i, 10);
                memoryCacheService3.onResultReceived(12, null);
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            codeCacheDir = context.createDeviceProtectedStorageContext().getCacheDir();
        } else if (i2 >= 24) {
            codeCacheDir = context.createDeviceProtectedStorageContext().getCodeCacheDir();
        } else {
            codeCacheDir = i2 == 23 ? context.getCodeCacheDir() : context.getCacheDir();
        }
        if (Encoding.deleteFilesRecursively(codeCacheDir)) {
            memoryCacheService3.onResultReceived(14, null);
        } else {
            memoryCacheService3.onResultReceived(15, null);
        }
    }
}
