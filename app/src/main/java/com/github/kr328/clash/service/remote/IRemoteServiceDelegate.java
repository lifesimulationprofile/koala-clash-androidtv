package com.github.kr328.clash.service.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.github.kr328.clash.service.RemoteService;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IRemoteServiceDelegate extends Binder implements IRemoteService {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final /* synthetic */ RemoteService $$delegate_0;

    public IRemoteServiceDelegate(RemoteService remoteService) {
        this.$$delegate_0 = remoteService;
    }

    @Override // com.github.kr328.clash.service.remote.IRemoteService
    public final IClashManager clash() {
        return this.$$delegate_0.clashBinder;
    }

    @Override // android.os.Binder, android.os.IBinder
    public final String getInterfaceDescriptor() {
        return "com.github.kr328.clash.service.remote.IRemoteService";
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        RemoteService remoteService = this.$$delegate_0;
        if (i == 1) {
            if (parcel2 == null) {
                return false;
            }
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IRemoteService");
            IClashManager iClashManager = remoteService.clashBinder;
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iClashManager instanceof IBinder ? (IBinder) iClashManager : new IClashManagerDelegate(iClashManager));
            return true;
        }
        if (i != 2) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        parcel.enforceInterface("com.github.kr328.clash.service.remote.IRemoteService");
        IProfileManager iProfileManager = remoteService.profileBinder;
        parcel2.writeNoException();
        parcel2.writeStrongBinder(iProfileManager instanceof IBinder ? (IBinder) iProfileManager : new IProfileManagerDelegate(iProfileManager));
        return true;
    }

    @Override // com.github.kr328.clash.service.remote.IRemoteService
    public final IProfileManager profile() {
        return this.$$delegate_0.profileBinder;
    }
}
