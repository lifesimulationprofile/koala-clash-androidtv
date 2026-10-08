package com.github.kr328.clash.service.remote;

import android.os.IBinder;
import android.os.Parcel;
import com.github.kr328.clash.common.util.ParcelableKt;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.core.model.ProviderList;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.core.model.UiConfiguration;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import com.github.kr328.kaidl.SuspendTransactionKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IClashManagerProxy implements IClashManager {
    public final IBinder remote;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IClashManagerProxy$healthCheck$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IClashManagerProxy.this.healthCheck(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IClashManagerProxy$healthCheckProxy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00341 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00341(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IClashManagerProxy.this.healthCheckProxy(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IClashManagerProxy$updateProvider$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00351 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00351(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IClashManagerProxy.this.updateProvider(null, null, this);
        }
    }

    public IClashManagerProxy(IBinder iBinder) {
        this.remote = iBinder;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void addClosedConnections(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            parcelObtain.writeString(str);
            this.remote.transact(18, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Unit unit = Unit.INSTANCE;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void clearClosedConnections() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(19, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Unit unit = Unit.INSTANCE;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void closeAllConnections() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(16, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Unit unit = Unit.INSTANCE;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void closeConnection(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            parcelObtain.writeString(str);
            this.remote.transact(15, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Unit unit = Unit.INSTANCE;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final Object healthCheck(String str, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Parcel parcel;
        Throwable th;
        Parcel parcel2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i3 = IClashManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
                parcelObtain.writeString(str);
                IBinder iBinder = this.remote;
                anonymousClass1.L$0 = parcelObtain;
                anonymousClass1.L$1 = parcelObtain2;
                anonymousClass1.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 8, parcelObtain, parcelObtain2, anonymousClass1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSuspendTransact == coroutineSingletons) {
                    return coroutineSingletons;
                }
                parcel = parcelObtain;
                parcel2 = parcelObtain2;
            } catch (Throwable th2) {
                parcel = parcelObtain;
                th = th2;
                parcel2 = parcelObtain2;
                parcel.recycle();
                parcel2.recycle();
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            parcel2 = anonymousClass1.L$1;
            parcel = anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                parcel.recycle();
                parcel2.recycle();
                throw th;
            }
        }
        parcel2.readException();
        Unit unit = Unit.INSTANCE;
        parcel.recycle();
        parcel2.recycle();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final Object healthCheckProxy(String str, String str2, Continuation continuation) throws Throwable {
        C00341 c00341;
        Parcel parcel;
        Throwable th;
        Parcel parcel2;
        if (continuation instanceof C00341) {
            c00341 = (C00341) continuation;
            int i = c00341.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00341.label = i - Integer.MIN_VALUE;
            } else {
                c00341 = new C00341((ContinuationImpl) continuation);
            }
        } else {
            c00341 = new C00341((ContinuationImpl) continuation);
        }
        Object obj = c00341.result;
        int i2 = c00341.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i3 = IClashManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                IBinder iBinder = this.remote;
                c00341.L$0 = parcelObtain;
                c00341.L$1 = parcelObtain2;
                c00341.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 9, parcelObtain, parcelObtain2, c00341);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSuspendTransact == coroutineSingletons) {
                    return coroutineSingletons;
                }
                parcel = parcelObtain;
                parcel2 = parcelObtain2;
            } catch (Throwable th2) {
                parcel = parcelObtain;
                th = th2;
                parcel2 = parcelObtain2;
                parcel.recycle();
                parcel2.recycle();
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            parcel2 = c00341.L$1;
            parcel = c00341.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                parcel.recycle();
                parcel2.recycle();
                throw th;
            }
        }
        parcel2.readException();
        Unit unit = Unit.INSTANCE;
        parcel.recycle();
        parcel2.recycle();
        return Unit.INSTANCE;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void patchOverrideMode(TunnelState.Mode mode) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            if (mode != null) {
                parcelObtain.writeInt(1);
                parcelObtain.writeInt(mode.ordinal());
            } else {
                parcelObtain.writeInt(0);
            }
            this.remote.transact(12, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Unit unit = Unit.INSTANCE;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final boolean patchSelector(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            this.remote.transact(7, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final String queryClosedConnections() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(17, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final TunnelState.Mode queryConfigMode() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(13, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? TunnelState.Mode.values()[parcelObtain2.readInt()] : null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final UiConfiguration queryConfiguration() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(5, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return (UiConfiguration) UiConfiguration.CREATOR.serializer().deserialize(new Parcelizer$ParcelDecoder(parcelObtain2, 0));
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final String queryConnections() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(14, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final TunnelState.Mode queryOverrideMode() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(11, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0 ? TunnelState.Mode.values()[parcelObtain2.readInt()] : null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final ProviderList queryProviders() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(6, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            ProviderList.CREATOR.getClass();
            return new ProviderList(ParcelableKt.createListFromParcelSlice(20, parcelObtain2, Provider.CREATOR));
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final ProxyGroup queryProxyGroup(String str, ProxySort proxySort) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(proxySort.ordinal());
            this.remote.transact(4, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            ProxyGroup.CREATOR.getClass();
            return ProxyGroup.CREATOR.createFromParcel(parcelObtain2);
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final List queryProxyGroupNames(boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            parcelObtain.writeInt(z ? 1 : 0);
            this.remote.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            int i2 = parcelObtain2.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(parcelObtain2.readString());
            }
            parcelObtain.recycle();
            parcelObtain2.recycle();
            return arrayList;
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th;
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final long queryTrafficTotal() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readLong();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final TunnelState queryTunnelState() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            this.remote.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return (TunnelState) TunnelState.CREATOR.serializer().deserialize(new Parcelizer$ParcelDecoder(parcelObtain2, 0));
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void setLogObserver(ILogObserver iLogObserver) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IClashManagerDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
            if (iLogObserver != null) {
                parcelObtain.writeInt(1);
                parcelObtain.writeStrongBinder(iLogObserver instanceof IBinder ? (IBinder) iLogObserver : new ILogObserverDelegate(iLogObserver));
            } else {
                parcelObtain.writeInt(0);
            }
            this.remote.transact(20, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Unit unit = Unit.INSTANCE;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final Object updateProvider(Provider.Type type, String str, Continuation continuation) throws Throwable {
        C00351 c00351;
        Parcel parcel;
        Throwable th;
        Parcel parcel2;
        if (continuation instanceof C00351) {
            c00351 = (C00351) continuation;
            int i = c00351.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00351.label = i - Integer.MIN_VALUE;
            } else {
                c00351 = new C00351((ContinuationImpl) continuation);
            }
        } else {
            c00351 = new C00351((ContinuationImpl) continuation);
        }
        Object obj = c00351.result;
        int i2 = c00351.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i3 = IClashManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IClashManager");
                parcelObtain.writeInt(type.ordinal());
                parcelObtain.writeString(str);
                IBinder iBinder = this.remote;
                c00351.L$0 = parcelObtain;
                c00351.L$1 = parcelObtain2;
                c00351.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 10, parcelObtain, parcelObtain2, c00351);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSuspendTransact == coroutineSingletons) {
                    return coroutineSingletons;
                }
                parcel = parcelObtain;
                parcel2 = parcelObtain2;
            } catch (Throwable th2) {
                parcel = parcelObtain;
                th = th2;
                parcel2 = parcelObtain2;
                parcel.recycle();
                parcel2.recycle();
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            parcel2 = c00351.L$1;
            parcel = c00351.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                parcel.recycle();
                parcel2.recycle();
                throw th;
            }
        }
        parcel2.readException();
        Unit unit = Unit.INSTANCE;
        parcel.recycle();
        parcel2.recycle();
        return Unit.INSTANCE;
    }
}
