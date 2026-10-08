package com.github.kr328.clash.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiCompat;
import com.github.kr328.clash.common.constants.Authorities;
import com.google.android.gms.internal.mlkit_vision_common.zzap;
import com.google.android.gms.internal.mlkit_vision_common.zzmm;
import com.google.firebase.components.OptionalProvider$$Lambda$4;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StatusClient implements Font$ResourceLoader, EmojiCompat.MetadataRepoLoader {
    public final Context context;

    public /* synthetic */ StatusClient(Context context, boolean z) {
        this.context = context;
    }

    public String currentProfile() {
        try {
            Bundle bundleCall = this.context.getContentResolver().call(new Uri.Builder().scheme("content").authority(Authorities.STATUS_PROVIDER).build(), "currentProfile", (String) null, (Bundle) null);
            if (bundleCall != null) {
                return bundleCall.getString("name");
            }
            return null;
        } catch (Exception e) {
            Log.w("KoalaClash", "Query current profile: " + e, e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List] */
    public ArrayList discoverLazy() {
        ?? arrayList;
        ArrayList arrayList2 = new ArrayList();
        Context context = this.context;
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) MlKitComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", MlKitComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new zzmm(4, (String) it.next()));
        }
        return arrayList2;
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
    public void load(zzap zzapVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ConcurrencyHelpers$$ExternalSyntheticLambda0("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new LiveDataObservable$$ExternalSyntheticLambda1(this, zzapVar, threadPoolExecutor, 11));
    }

    public StatusClient(Context context, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0) {
        ViewConfiguration.get(context).getScaledTouchSlop();
        this.context = context;
        new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: androidx.camera.view.impl.ZoomGestureDetector$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                motionEvent.getX();
                motionEvent.getY();
                return true;
            }
        });
    }

    public StatusClient(Context context, OptionalProvider$$Lambda$4 optionalProvider$$Lambda$4) {
        this.context = context;
    }

    public StatusClient(Context context) {
        this.context = context.getApplicationContext();
    }
}
