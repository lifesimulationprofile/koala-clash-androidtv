package com.github.kr328.clash.service.remote;

import android.os.Binder;
import android.os.Parcel;
import com.github.kr328.clash.core.model.FetchStatus;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IFetchObserverDelegate extends Binder implements IFetchObserver {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final /* synthetic */ IFetchObserver $$delegate_0;

    public IFetchObserverDelegate(IFetchObserver iFetchObserver) {
        this.$$delegate_0 = iFetchObserver;
    }

    @Override // android.os.Binder, android.os.IBinder
    public final String getInterfaceDescriptor() {
        return "com.github.kr328.clash.service.remote.IFetchObserver";
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        parcel.enforceInterface("com.github.kr328.clash.service.remote.IFetchObserver");
        updateStatus((FetchStatus) FetchStatus.CREATOR.serializer().deserialize(new Parcelizer$ParcelDecoder(parcel, 0)));
        Unit unit = Unit.INSTANCE;
        parcel2.writeNoException();
        return true;
    }

    @Override // com.github.kr328.clash.service.remote.IFetchObserver
    public final void updateStatus(FetchStatus fetchStatus) {
        this.$$delegate_0.updateStatus(fetchStatus);
    }
}
