package com.github.kr328.clash.service.remote;

import android.os.Binder;
import android.os.Parcel;
import com.github.kr328.clash.core.model.LogMessage;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ILogObserverDelegate extends Binder implements ILogObserver {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final /* synthetic */ ILogObserver $$delegate_0;

    public ILogObserverDelegate(ILogObserver iLogObserver) {
        this.$$delegate_0 = iLogObserver;
    }

    @Override // android.os.Binder, android.os.IBinder
    public final String getInterfaceDescriptor() {
        return "com.github.kr328.clash.service.remote.ILogObserver";
    }

    @Override // com.github.kr328.clash.service.remote.ILogObserver
    public final void newItem(LogMessage logMessage) {
        this.$$delegate_0.newItem(logMessage);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        parcel.enforceInterface("com.github.kr328.clash.service.remote.ILogObserver");
        newItem(LogMessage.CREATOR.createFromParcel(parcel));
        Unit unit = Unit.INSTANCE;
        parcel2.writeNoException();
        return true;
    }
}
