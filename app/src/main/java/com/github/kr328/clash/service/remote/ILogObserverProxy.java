package com.github.kr328.clash.service.remote;

import android.os.IBinder;
import android.os.Parcel;
import com.github.kr328.clash.core.model.LogMessage;
import kotlin.Unit;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ILogObserverProxy implements ILogObserver {
    public final /* synthetic */ int $r8$classId;
    public final Object remote;

    public /* synthetic */ ILogObserverProxy(int i, Object obj) {
        this.$r8$classId = i;
        this.remote = obj;
    }

    @Override // com.github.kr328.clash.service.remote.ILogObserver
    public final void newItem(LogMessage logMessage) {
        int i = this.$r8$classId;
        Object obj = this.remote;
        switch (i) {
            case 0:
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    int i2 = ILogObserverDelegate.$r8$clinit;
                    parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.ILogObserver");
                    logMessage.writeToParcel(parcelObtain, 0);
                    ((IBinder) obj).transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    Unit unit = Unit.INSTANCE;
                    return;
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            default:
                ((BufferedChannel) obj).mo842trySendJP2dKIU(logMessage);
                return;
        }
    }
}
