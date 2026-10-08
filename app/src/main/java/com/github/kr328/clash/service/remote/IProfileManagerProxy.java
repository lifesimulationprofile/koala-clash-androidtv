package com.github.kr328.clash.service.remote;

import android.os.IBinder;
import android.os.Parcel;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.kaidl.SuspendTransactionKt;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IProfileManagerProxy implements IProfileManager {
    public final IBinder remote;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerProxy$clone$1, reason: invalid class name */
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
            return IProfileManagerProxy.this.clone(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerProxy$delete$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00361 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00361(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IProfileManagerProxy.this.delete(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerProxy$import$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00371 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00371(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IProfileManagerProxy.this.mo811import(null, null, null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerProxy$patch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00381 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00381(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IProfileManagerProxy.this.patch(null, null, null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerProxy$queryActive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00391 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00391(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IProfileManagerProxy.this.queryActive(this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerProxy$queryAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00401 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00401(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IProfileManagerProxy.this.queryAll(this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerProxy$queryByUUID$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00411 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00411(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IProfileManagerProxy.this.queryByUUID(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerProxy$setActive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00421 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00421(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IProfileManagerProxy.this.setActive(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.remote.IProfileManagerProxy$update$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00431 extends ContinuationImpl {
        public Parcel L$0;
        public Parcel L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00431(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IProfileManagerProxy.this.update(null, this);
        }
    }

    public IProfileManagerProxy(IBinder iBinder) {
        this.remote = iBinder;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object clone(UUID uuid, Continuation continuation) throws Throwable {
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
                int i3 = IProfileManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IProfileManager");
                parcelObtain.writeSerializable(uuid);
                IBinder iBinder = this.remote;
                anonymousClass1.L$0 = parcelObtain;
                anonymousClass1.L$1 = parcelObtain2;
                anonymousClass1.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 4, parcelObtain, parcelObtain2, anonymousClass1);
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
        UUID uuid2 = (UUID) parcel2.readSerializable();
        parcel.recycle();
        parcel2.recycle();
        return uuid2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object delete(UUID uuid, Continuation continuation) throws Throwable {
        C00361 c00361;
        Parcel parcel;
        Throwable th;
        Parcel parcel2;
        if (continuation instanceof C00361) {
            c00361 = (C00361) continuation;
            int i = c00361.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00361.label = i - Integer.MIN_VALUE;
            } else {
                c00361 = new C00361((ContinuationImpl) continuation);
            }
        } else {
            c00361 = new C00361((ContinuationImpl) continuation);
        }
        Object obj = c00361.result;
        int i2 = c00361.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i3 = IProfileManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IProfileManager");
                parcelObtain.writeSerializable(uuid);
                IBinder iBinder = this.remote;
                c00361.L$0 = parcelObtain;
                c00361.L$1 = parcelObtain2;
                c00361.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 5, parcelObtain, parcelObtain2, c00361);
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
            parcel2 = c00361.L$1;
            parcel = c00361.L$0;
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
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    /* JADX INFO: renamed from: import */
    public final Object mo811import(Profile.Type type, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation) throws Throwable {
        C00371 c00371;
        Parcel parcel;
        Parcel parcel2;
        if (continuation instanceof C00371) {
            c00371 = (C00371) continuation;
            int i = c00371.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00371.label = i - Integer.MIN_VALUE;
            } else {
                c00371 = new C00371((ContinuationImpl) continuation);
            }
        } else {
            c00371 = new C00371((ContinuationImpl) continuation);
        }
        Object obj = c00371.result;
        int i2 = c00371.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i3 = IProfileManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IProfileManager");
                parcelObtain.writeInt(type.ordinal());
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeLong(j);
                if (iFetchObserver != null) {
                    parcelObtain.writeInt(1);
                    try {
                        parcelObtain.writeStrongBinder(iFetchObserver instanceof IBinder ? (IBinder) iFetchObserver : new IFetchObserverDelegate(iFetchObserver));
                    } catch (Throwable th) {
                        th = th;
                        parcel = parcelObtain;
                        parcel2 = parcelObtain2;
                        parcel.recycle();
                        parcel2.recycle();
                        throw th;
                    }
                } else {
                    parcelObtain.writeInt(0);
                }
                IBinder iBinder = this.remote;
                c00371.L$0 = parcelObtain;
                c00371.L$1 = parcelObtain2;
                c00371.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 1, parcelObtain, parcelObtain2, c00371);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSuspendTransact == coroutineSingletons) {
                    return coroutineSingletons;
                }
                parcel = parcelObtain;
                parcel2 = parcelObtain2;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            parcel2 = c00371.L$1;
            parcel = c00371.L$0;
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
        UUID uuid = (UUID) parcel2.readSerializable();
        parcel.recycle();
        parcel2.recycle();
        return uuid;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object patch(UUID uuid, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation) throws Throwable {
        C00381 c00381;
        Parcel parcel;
        Parcel parcel2;
        if (continuation instanceof C00381) {
            c00381 = (C00381) continuation;
            int i = c00381.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00381.label = i - Integer.MIN_VALUE;
            } else {
                c00381 = new C00381((ContinuationImpl) continuation);
            }
        } else {
            c00381 = new C00381((ContinuationImpl) continuation);
        }
        Object obj = c00381.result;
        int i2 = c00381.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i3 = IProfileManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IProfileManager");
                parcelObtain.writeSerializable(uuid);
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeLong(j);
                if (iFetchObserver != null) {
                    parcelObtain.writeInt(1);
                    try {
                        parcelObtain.writeStrongBinder(iFetchObserver instanceof IBinder ? (IBinder) iFetchObserver : new IFetchObserverDelegate(iFetchObserver));
                    } catch (Throwable th) {
                        th = th;
                        parcel = parcelObtain;
                        parcel2 = parcelObtain2;
                        parcel.recycle();
                        parcel2.recycle();
                        throw th;
                    }
                } else {
                    parcelObtain.writeInt(0);
                }
                IBinder iBinder = this.remote;
                c00381.L$0 = parcelObtain;
                c00381.L$1 = parcelObtain2;
                c00381.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 2, parcelObtain, parcelObtain2, c00381);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSuspendTransact == coroutineSingletons) {
                    return coroutineSingletons;
                }
                parcel = parcelObtain;
                parcel2 = parcelObtain2;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            parcel2 = c00381.L$1;
            parcel = c00381.L$0;
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
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryActive(Continuation continuation) throws Throwable {
        C00391 c00391;
        Parcel parcelObtain;
        Parcel parcel;
        Throwable th;
        if (continuation instanceof C00391) {
            c00391 = (C00391) continuation;
            int i = c00391.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00391.label = i - Integer.MIN_VALUE;
            } else {
                c00391 = new C00391((ContinuationImpl) continuation);
            }
        } else {
            c00391 = new C00391((ContinuationImpl) continuation);
        }
        Object obj = c00391.result;
        int i2 = c00391.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain2 = Parcel.obtain();
            parcelObtain = Parcel.obtain();
            try {
                int i3 = IProfileManagerDelegate.$r8$clinit;
                parcelObtain2.writeInterfaceToken("com.github.kr328.clash.service.remote.IProfileManager");
                IBinder iBinder = this.remote;
                c00391.L$0 = parcelObtain2;
                c00391.L$1 = parcelObtain;
                c00391.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 8, parcelObtain2, parcelObtain, c00391);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSuspendTransact == coroutineSingletons) {
                    return coroutineSingletons;
                }
                parcel = parcelObtain2;
            } catch (Throwable th2) {
                parcel = parcelObtain2;
                th = th2;
                parcel.recycle();
                parcelObtain.recycle();
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            parcelObtain = c00391.L$1;
            parcel = c00391.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                parcel.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        parcelObtain.readException();
        Profile profileCreateFromParcel = parcelObtain.readInt() != 0 ? Profile.CREATOR.createFromParcel(parcelObtain) : null;
        parcel.recycle();
        parcelObtain.recycle();
        return profileCreateFromParcel;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryAll(Continuation continuation) throws Throwable {
        C00401 c00401;
        Parcel parcelObtain;
        Parcel parcel;
        Throwable th;
        if (continuation instanceof C00401) {
            c00401 = (C00401) continuation;
            int i = c00401.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00401.label = i - Integer.MIN_VALUE;
            } else {
                c00401 = new C00401((ContinuationImpl) continuation);
            }
        } else {
            c00401 = new C00401((ContinuationImpl) continuation);
        }
        Object obj = c00401.result;
        int i2 = c00401.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain2 = Parcel.obtain();
            parcelObtain = Parcel.obtain();
            try {
                int i3 = IProfileManagerDelegate.$r8$clinit;
                parcelObtain2.writeInterfaceToken("com.github.kr328.clash.service.remote.IProfileManager");
                IBinder iBinder = this.remote;
                c00401.L$0 = parcelObtain2;
                c00401.L$1 = parcelObtain;
                c00401.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 7, parcelObtain2, parcelObtain, c00401);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSuspendTransact == coroutineSingletons) {
                    return coroutineSingletons;
                }
                parcel = parcelObtain2;
            } catch (Throwable th2) {
                parcel = parcelObtain2;
                th = th2;
                parcel.recycle();
                parcelObtain.recycle();
                throw th;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            parcelObtain = c00401.L$1;
            parcel = c00401.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                parcel.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        parcelObtain.readException();
        int i4 = parcelObtain.readInt();
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList.add(Profile.CREATOR.createFromParcel(parcelObtain));
        }
        parcel.recycle();
        parcelObtain.recycle();
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryByUUID(UUID uuid, Continuation continuation) throws Throwable {
        C00411 c00411;
        Parcel parcel;
        Throwable th;
        Parcel parcel2;
        if (continuation instanceof C00411) {
            c00411 = (C00411) continuation;
            int i = c00411.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00411.label = i - Integer.MIN_VALUE;
            } else {
                c00411 = new C00411((ContinuationImpl) continuation);
            }
        } else {
            c00411 = new C00411((ContinuationImpl) continuation);
        }
        Object obj = c00411.result;
        int i2 = c00411.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i3 = IProfileManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IProfileManager");
                parcelObtain.writeSerializable(uuid);
                IBinder iBinder = this.remote;
                c00411.L$0 = parcelObtain;
                c00411.L$1 = parcelObtain2;
                c00411.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 6, parcelObtain, parcelObtain2, c00411);
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
            parcel2 = c00411.L$1;
            parcel = c00411.L$0;
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
        Profile profileCreateFromParcel = parcel2.readInt() != 0 ? Profile.CREATOR.createFromParcel(parcel2) : null;
        parcel.recycle();
        parcel2.recycle();
        return profileCreateFromParcel;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object setActive(Profile profile, Continuation continuation) throws Throwable {
        C00421 c00421;
        Parcel parcel;
        Throwable th;
        Parcel parcel2;
        if (continuation instanceof C00421) {
            c00421 = (C00421) continuation;
            int i = c00421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00421.label = i - Integer.MIN_VALUE;
            } else {
                c00421 = new C00421((ContinuationImpl) continuation);
            }
        } else {
            c00421 = new C00421((ContinuationImpl) continuation);
        }
        Object obj = c00421.result;
        int i2 = c00421.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i3 = IProfileManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IProfileManager");
                profile.writeToParcel(parcelObtain, 0);
                IBinder iBinder = this.remote;
                c00421.L$0 = parcelObtain;
                c00421.L$1 = parcelObtain2;
                c00421.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 9, parcelObtain, parcelObtain2, c00421);
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
            parcel2 = c00421.L$1;
            parcel = c00421.L$0;
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
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object update(UUID uuid, Continuation continuation) throws Throwable {
        C00431 c00431;
        Parcel parcel;
        Throwable th;
        Parcel parcel2;
        if (continuation instanceof C00431) {
            c00431 = (C00431) continuation;
            int i = c00431.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00431.label = i - Integer.MIN_VALUE;
            } else {
                c00431 = new C00431((ContinuationImpl) continuation);
            }
        } else {
            c00431 = new C00431((ContinuationImpl) continuation);
        }
        Object obj = c00431.result;
        int i2 = c00431.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                int i3 = IProfileManagerDelegate.$r8$clinit;
                parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IProfileManager");
                parcelObtain.writeSerializable(uuid);
                IBinder iBinder = this.remote;
                c00431.L$0 = parcelObtain;
                c00431.L$1 = parcelObtain2;
                c00431.label = 1;
                Object objSuspendTransact = SuspendTransactionKt.suspendTransact(iBinder, 3, parcelObtain, parcelObtain2, c00431);
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
            parcel2 = c00431.L$1;
            parcel = c00431.L$0;
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
