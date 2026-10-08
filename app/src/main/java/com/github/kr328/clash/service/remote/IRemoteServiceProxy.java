package com.github.kr328.clash.service.remote;

import android.os.IBinder;
import android.os.Parcel;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IRemoteServiceProxy implements IRemoteService {
    public final IBinder remote;

    public IRemoteServiceProxy(IBinder iBinder) {
        this.remote = iBinder;
    }

    @Override // com.github.kr328.clash.service.remote.IRemoteService
    public final IClashManager clash() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IRemoteServiceDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IRemoteService");
            this.remote.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            IBinder strongBinder = parcelObtain2.readStrongBinder();
            Reflection.getOrCreateKotlinClass(IClashManager.class);
            return strongBinder instanceof IClashManager ? (IClashManager) strongBinder : new IClashManagerProxy(strongBinder);
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IRemoteService
    public final IProfileManager profile() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IRemoteServiceDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IRemoteService");
            this.remote.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            IBinder strongBinder = parcelObtain2.readStrongBinder();
            Reflection.getOrCreateKotlinClass(IProfileManager.class);
            return strongBinder instanceof IProfileManager ? (IProfileManager) strongBinder : new IProfileManagerProxy(strongBinder);
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
