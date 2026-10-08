package com.github.kr328.clash.service;

import android.content.Intent;
import android.os.IBinder;
import com.github.kr328.clash.service.remote.IClashManager;
import com.github.kr328.clash.service.remote.IClashManagerDelegate;
import com.github.kr328.clash.service.remote.IProfileManager;
import com.github.kr328.clash.service.remote.IProfileManagerDelegate;
import com.github.kr328.clash.service.remote.IRemoteService;
import com.github.kr328.clash.service.remote.IRemoteServiceDelegate;
import com.github.kr328.clash.service.util.CoroutineKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RemoteService extends BaseService implements IRemoteService {
    public final IBinder binder;
    public ClashManager clash;
    public IClashManager clashBinder;
    public ProfileManager profile;
    public IProfileManager profileBinder;

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteService() {
        this.binder = this instanceof IBinder ? (IBinder) this : new IRemoteServiceDelegate(this);
    }

    @Override // com.github.kr328.clash.service.remote.IRemoteService
    public final IClashManager clash() {
        return this.clashBinder;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // android.app.Service
    public final void onCreate() {
        IBinder iClashManagerDelegate;
        super.onCreate();
        this.clash = new ClashManager(this);
        this.profile = new ProfileManager(this);
        IClashManager iClashManager = this.clash;
        IBinder iProfileManagerDelegate = null;
        if (iClashManager != null) {
            iClashManagerDelegate = iClashManager instanceof IBinder ? (IBinder) iClashManager : new IClashManagerDelegate(iClashManager);
        } else {
            iClashManagerDelegate = null;
        }
        this.clashBinder = (IClashManager) iClashManagerDelegate;
        IProfileManager iProfileManager = this.profile;
        if (iProfileManager != null) {
            iProfileManagerDelegate = iProfileManager instanceof IBinder ? (IBinder) iProfileManager : new IProfileManagerDelegate(iProfileManager);
        }
        this.profileBinder = (IProfileManager) iProfileManagerDelegate;
    }

    @Override // com.github.kr328.clash.service.BaseService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        ClashManager clashManager = this.clash;
        if (clashManager != null) {
            CoroutineKt.cancelAndJoinBlocking(clashManager);
        }
        ProfileManager profileManager = this.profile;
        if (profileManager != null) {
            CoroutineKt.cancelAndJoinBlocking(profileManager);
        }
    }

    @Override // com.github.kr328.clash.service.remote.IRemoteService
    public final IProfileManager profile() {
        return this.profileBinder;
    }
}
