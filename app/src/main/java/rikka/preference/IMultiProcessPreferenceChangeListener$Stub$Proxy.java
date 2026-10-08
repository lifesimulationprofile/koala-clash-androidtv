package rikka.preference;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IMultiProcessPreferenceChangeListener$Stub$Proxy implements IMultiProcessPreferenceChangeListener {
    public IBinder mRemote;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    @Override // rikka.preference.IMultiProcessPreferenceChangeListener
    public final void onPreferenceChanged(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("rikka.preference.IMultiProcessPreferenceChangeListener");
            parcelObtain.writeString(str);
            if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = MultiProcessPreference.AnonymousClass1.$r8$clinit;
            }
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
