package com.github.kr328.clash.compose.newprofile;

import android.app.Application;
import android.net.Uri;
import androidx.lifecycle.AndroidViewModel;
import com.github.kr328.clash.LogcatActivity$writeLogTo$2$1;
import com.github.kr328.clash.compose.proxy.ProxyViewModel$testProxy$1;
import com.github.kr328.clash.service.HwidLimitMarker;
import com.github.kr328.clash.service.ProfileProcessorKt;
import com.github.kr328.clash.util.RemoteKt;
import com.koala.clash.R;
import java.util.Locale;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NewProfileViewModel extends AndroidViewModel {
    public final StateFlowImpl _completed;
    public final StateFlowImpl _error;
    public final StateFlowImpl _hwidLimit;
    public final StateFlowImpl _isLoading;
    public final StateFlowImpl _link;
    public final Application app;
    public final ReadonlyStateFlow completed;
    public final ReadonlyStateFlow error;
    public final ReadonlyStateFlow hwidLimit;
    public final ReadonlyStateFlow isLoading;
    public final ReadonlyStateFlow link;

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.newprofile.NewProfileViewModel$createAndActivateAwait$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public NewProfileViewModel L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NewProfileViewModel.this.createAndActivateAwait(this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.newprofile.NewProfileViewModel$importFromContentAwait$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00241 extends ContinuationImpl {
        public NewProfileViewModel L$0;
        public byte[] L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00241(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NewProfileViewModel.this.importFromContentAwait(null, this);
        }
    }

    public NewProfileViewModel(Application application) {
        super(application);
        this.app = application;
        StateFlowImpl stateFlowImplMutableStateFlow = FlowKt.MutableStateFlow("");
        this._link = stateFlowImplMutableStateFlow;
        this.link = FlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        Boolean bool = Boolean.FALSE;
        StateFlowImpl stateFlowImplMutableStateFlow2 = FlowKt.MutableStateFlow(bool);
        this._isLoading = stateFlowImplMutableStateFlow2;
        this.isLoading = FlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = FlowKt.MutableStateFlow(null);
        this._error = stateFlowImplMutableStateFlow3;
        this.error = FlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        StateFlowImpl stateFlowImplMutableStateFlow4 = FlowKt.MutableStateFlow(bool);
        this._completed = stateFlowImplMutableStateFlow4;
        this.completed = FlowKt.asStateFlow(stateFlowImplMutableStateFlow4);
        StateFlowImpl stateFlowImplMutableStateFlow5 = FlowKt.MutableStateFlow(null);
        this._hwidLimit = stateFlowImplMutableStateFlow5;
        this.hwidLimit = FlowKt.asStateFlow(stateFlowImplMutableStateFlow5);
    }

    public static String extractDeepLink(String str) {
        Object failure;
        String queryParameter;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (StringsKt__StringsJVMKt.startsWith(lowerCase, "koala-clash://", false) || StringsKt__StringsJVMKt.startsWith(lowerCase, "clash://", false)) {
            try {
                failure = Uri.parse(str);
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            if (failure instanceof Result.Failure) {
                failure = null;
            }
            Uri uri = (Uri) failure;
            if (uri == null || !Intrinsics.areEqual(uri.getHost(), "install-config") || (queryParameter = uri.getQueryParameter("url")) == null || StringsKt.isBlank(queryParameter)) {
                return null;
            }
            return queryParameter;
        }
        return null;
    }

    public static boolean isValidUrl(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return StringsKt__StringsJVMKt.startsWith(lowerCase, "http://", false) || StringsKt__StringsJVMKt.startsWith(lowerCase, "https://", false);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c2 A[Catch: all -> 0x0028, TryCatch #2 {all -> 0x0028, blocks: (B:12:0x0024, B:34:0x009c, B:41:0x00b8, B:43:0x00c2, B:44:0x00d0, B:46:0x00d6, B:47:0x00de), top: B:52:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00d0 A[Catch: all -> 0x0028, TryCatch #2 {all -> 0x0028, blocks: (B:12:0x0024, B:34:0x009c, B:41:0x00b8, B:43:0x00c2, B:44:0x00d0, B:46:0x00d6, B:47:0x00de), top: B:52:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00d6 A[Catch: all -> 0x0028, TryCatch #2 {all -> 0x0028, blocks: (B:12:0x0024, B:34:0x009c, B:41:0x00b8, B:43:0x00c2, B:44:0x00d0, B:46:0x00d6, B:47:0x00de), top: B:52:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object createAndActivateAwait(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        NewProfileViewModel newProfileViewModel;
        HwidLimitMarker hwidLimitMarker;
        String message;
        Object error;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Continuation continuation = null;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            newProfileViewModel = anonymousClass1.L$0;
            try {
                try {
                    ResultKt.throwOnFailure(obj);
                    StateFlowImpl stateFlowImpl = newProfileViewModel._completed;
                    Boolean bool = Boolean.TRUE;
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, bool);
                    ProfileAddResult.Success success = ProfileAddResult.Success.INSTANCE;
                    StateFlowImpl stateFlowImpl2 = newProfileViewModel._isLoading;
                    Boolean bool2 = Boolean.FALSE;
                    stateFlowImpl2.getClass();
                    stateFlowImpl2.updateState(null, bool2);
                    return success;
                } catch (Exception e) {
                    e = e;
                    hwidLimitMarker = ProfileProcessorKt.parseHwidLimitMarker(e.getMessage());
                    if (hwidLimitMarker != null) {
                        StateFlowImpl stateFlowImpl3 = newProfileViewModel._hwidLimit;
                        stateFlowImpl3.getClass();
                        stateFlowImpl3.updateState(null, hwidLimitMarker);
                        error = new ProfileAddResult.HwidLimitHit(hwidLimitMarker);
                    } else {
                        message = e.getMessage();
                        if (message == null) {
                            message = e.getClass().getSimpleName();
                        }
                        StateFlowImpl stateFlowImpl4 = newProfileViewModel._error;
                        stateFlowImpl4.getClass();
                        stateFlowImpl4.updateState(null, message);
                        error = new ProfileAddResult.Error(message);
                    }
                    StateFlowImpl stateFlowImpl5 = newProfileViewModel._isLoading;
                    Boolean bool3 = Boolean.FALSE;
                    stateFlowImpl5.getClass();
                    stateFlowImpl5.updateState(null, bool3);
                    return error;
                }
            } catch (Throwable th) {
                th = th;
                StateFlowImpl stateFlowImpl6 = newProfileViewModel._isLoading;
                Boolean bool4 = Boolean.FALSE;
                stateFlowImpl6.getClass();
                stateFlowImpl6.updateState(null, bool4);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        String string = StringsKt.trim((String) this._link.getValue()).toString();
        if (string.length() == 0) {
            return new ProfileAddResult.Error("Empty URL");
        }
        boolean zIsValidUrl = isValidUrl(string);
        StateFlowImpl stateFlowImpl7 = this._error;
        Application application = this.app;
        if (!zIsValidUrl) {
            String string2 = application.getString(R.string.invalid_url);
            stateFlowImpl7.getClass();
            stateFlowImpl7.updateState(null, string2);
            return new ProfileAddResult.Error(string2);
        }
        Boolean bool5 = Boolean.TRUE;
        StateFlowImpl stateFlowImpl8 = this._isLoading;
        stateFlowImpl8.getClass();
        stateFlowImpl8.updateState(null, bool5);
        stateFlowImpl7.setValue(null);
        try {
            ProxyViewModel$testProxy$1.AnonymousClass2 anonymousClass2 = new ProxyViewModel$testProxy$1.AnonymousClass2(application.getString(R.string.new_profile), string, continuation, 1);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            Object objWithProfile$default = RemoteKt.withProfile$default(anonymousClass2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithProfile$default == coroutineSingletons) {
                return coroutineSingletons;
            }
            newProfileViewModel = this;
            StateFlowImpl stateFlowImpl9 = newProfileViewModel._completed;
            Boolean bool6 = Boolean.TRUE;
            stateFlowImpl9.getClass();
            stateFlowImpl9.updateState(null, bool6);
            ProfileAddResult.Success success2 = ProfileAddResult.Success.INSTANCE;
            StateFlowImpl stateFlowImpl10 = newProfileViewModel._isLoading;
            Boolean bool7 = Boolean.FALSE;
            stateFlowImpl10.getClass();
            stateFlowImpl10.updateState(null, bool7);
            return success2;
        } catch (Exception e2) {
            e = e2;
            newProfileViewModel = this;
            hwidLimitMarker = ProfileProcessorKt.parseHwidLimitMarker(e.getMessage());
            if (hwidLimitMarker != null) {
                StateFlowImpl stateFlowImpl11 = newProfileViewModel._hwidLimit;
                stateFlowImpl11.getClass();
                stateFlowImpl11.updateState(null, hwidLimitMarker);
                error = new ProfileAddResult.HwidLimitHit(hwidLimitMarker);
            } else {
                message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                StateFlowImpl stateFlowImpl12 = newProfileViewModel._error;
                stateFlowImpl12.getClass();
                stateFlowImpl12.updateState(null, message);
                error = new ProfileAddResult.Error(message);
            }
            StateFlowImpl stateFlowImpl13 = newProfileViewModel._isLoading;
            Boolean bool8 = Boolean.FALSE;
            stateFlowImpl13.getClass();
            stateFlowImpl13.updateState(null, bool8);
            return error;
        } catch (Throwable th2) {
            th = th2;
            newProfileViewModel = this;
            StateFlowImpl stateFlowImpl14 = newProfileViewModel._isLoading;
            Boolean bool9 = Boolean.FALSE;
            stateFlowImpl14.getClass();
            stateFlowImpl14.updateState(null, bool9);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d0 A[Catch: all -> 0x002e, TryCatch #9 {all -> 0x002e, blocks: (B:13:0x0029, B:40:0x009c, B:57:0x00ca, B:59:0x00d0, B:60:0x00d8), top: B:64:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object importFromContentAwait(byte[] bArr, ContinuationImpl continuationImpl) {
        C00241 c00241;
        Throwable th;
        NewProfileViewModel newProfileViewModel;
        Exception exc;
        NewProfileViewModel newProfileViewModel2;
        DefaultIoScheduler defaultIoScheduler;
        LogcatActivity$writeLogTo$2$1 logcatActivity$writeLogTo$2$1;
        String message;
        Object error;
        if (continuationImpl instanceof C00241) {
            c00241 = (C00241) continuationImpl;
            int i = c00241.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00241.label = i - Integer.MIN_VALUE;
            } else {
                c00241 = new C00241(continuationImpl);
            }
        } else {
            c00241 = new C00241(continuationImpl);
        }
        Object objWithProfile$default = c00241.result;
        int i2 = c00241.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithProfile$default);
            Boolean bool = Boolean.TRUE;
            StateFlowImpl stateFlowImpl = this._isLoading;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool);
            this._error.setValue(null);
            try {
                NewProfileViewModel$importFromFile$1$uuid$1 newProfileViewModel$importFromFile$1$uuid$1 = new NewProfileViewModel$importFromFile$1$uuid$1(this.app.getString(R.string.new_profile), null, 1);
                c00241.L$0 = this;
                c00241.L$1 = bArr;
                c00241.label = 1;
                objWithProfile$default = RemoteKt.withProfile$default(newProfileViewModel$importFromFile$1$uuid$1, c00241);
                if (objWithProfile$default != coroutineSingletons) {
                    newProfileViewModel2 = this;
                    byte[] bArr2 = bArr;
                    UUID uuid = (UUID) objWithProfile$default;
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    logcatActivity$writeLogTo$2$1 = new LogcatActivity$writeLogTo$2$1(newProfileViewModel2, uuid, bArr2, continuation, 5);
                    c00241.L$0 = newProfileViewModel2;
                    c00241.L$1 = null;
                    c00241.label = 2;
                    if (JobKt.withContext(defaultIoScheduler, logcatActivity$writeLogTo$2$1, c00241) != coroutineSingletons) {
                        newProfileViewModel = newProfileViewModel2;
                        StateFlowImpl stateFlowImpl2 = newProfileViewModel._completed;
                        Boolean bool2 = Boolean.TRUE;
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, bool2);
                        error = ProfileAddResult.Success.INSTANCE;
                    }
                }
                return coroutineSingletons;
            } catch (Exception e) {
                exc = e;
                newProfileViewModel = this;
                message = exc.getMessage();
                if (message == null) {
                    message = exc.getClass().getSimpleName();
                }
                StateFlowImpl stateFlowImpl3 = newProfileViewModel._error;
                stateFlowImpl3.getClass();
                stateFlowImpl3.updateState(null, message);
                error = new ProfileAddResult.Error(message);
                StateFlowImpl stateFlowImpl4 = newProfileViewModel._isLoading;
                Boolean bool3 = Boolean.FALSE;
                stateFlowImpl4.getClass();
                stateFlowImpl4.updateState(null, bool3);
                return error;
            } catch (Throwable th2) {
                th = th2;
                newProfileViewModel = this;
                StateFlowImpl stateFlowImpl5 = newProfileViewModel._isLoading;
                Boolean bool4 = Boolean.FALSE;
                stateFlowImpl5.getClass();
                stateFlowImpl5.updateState(null, bool4);
                throw th;
            }
        }
        if (i2 == 1) {
            bArr = c00241.L$1;
            NewProfileViewModel newProfileViewModel3 = c00241.L$0;
            try {
                ResultKt.throwOnFailure(objWithProfile$default);
                newProfileViewModel2 = newProfileViewModel3;
                byte[] bArr3 = bArr;
                try {
                    UUID uuid2 = (UUID) objWithProfile$default;
                    try {
                        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                        defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                        logcatActivity$writeLogTo$2$1 = new LogcatActivity$writeLogTo$2$1(newProfileViewModel2, uuid2, bArr3, continuation, 5);
                        c00241.L$0 = newProfileViewModel2;
                        c00241.L$1 = null;
                        c00241.label = 2;
                        if (JobKt.withContext(defaultIoScheduler, logcatActivity$writeLogTo$2$1, c00241) != coroutineSingletons) {
                            newProfileViewModel = newProfileViewModel2;
                            StateFlowImpl stateFlowImpl6 = newProfileViewModel._completed;
                            Boolean bool5 = Boolean.TRUE;
                            stateFlowImpl6.getClass();
                            stateFlowImpl6.updateState(null, bool5);
                            error = ProfileAddResult.Success.INSTANCE;
                        }
                        return coroutineSingletons;
                    } catch (Exception e2) {
                        exc = e2;
                        newProfileViewModel = newProfileViewModel2;
                        message = exc.getMessage();
                        if (message == null) {
                            message = exc.getClass().getSimpleName();
                        }
                        StateFlowImpl stateFlowImpl7 = newProfileViewModel._error;
                        stateFlowImpl7.getClass();
                        stateFlowImpl7.updateState(null, message);
                        error = new ProfileAddResult.Error(message);
                    } catch (Throwable th3) {
                        th = th3;
                        newProfileViewModel = newProfileViewModel2;
                        StateFlowImpl stateFlowImpl8 = newProfileViewModel._isLoading;
                        Boolean bool6 = Boolean.FALSE;
                        stateFlowImpl8.getClass();
                        stateFlowImpl8.updateState(null, bool6);
                        throw th;
                    }
                } catch (Exception e3) {
                    exc = e3;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e4) {
                exc = e4;
                newProfileViewModel = newProfileViewModel3;
                message = exc.getMessage();
                if (message == null) {
                    message = exc.getClass().getSimpleName();
                }
                StateFlowImpl stateFlowImpl9 = newProfileViewModel._error;
                stateFlowImpl9.getClass();
                stateFlowImpl9.updateState(null, message);
                error = new ProfileAddResult.Error(message);
                StateFlowImpl stateFlowImpl10 = newProfileViewModel._isLoading;
                Boolean bool7 = Boolean.FALSE;
                stateFlowImpl10.getClass();
                stateFlowImpl10.updateState(null, bool7);
                return error;
            } catch (Throwable th5) {
                th = th5;
                newProfileViewModel = newProfileViewModel3;
                StateFlowImpl stateFlowImpl11 = newProfileViewModel._isLoading;
                Boolean bool8 = Boolean.FALSE;
                stateFlowImpl11.getClass();
                stateFlowImpl11.updateState(null, bool8);
                throw th;
            }
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            newProfileViewModel = c00241.L$0;
            try {
                try {
                    ResultKt.throwOnFailure(objWithProfile$default);
                    StateFlowImpl stateFlowImpl12 = newProfileViewModel._completed;
                    Boolean bool9 = Boolean.TRUE;
                    stateFlowImpl12.getClass();
                    stateFlowImpl12.updateState(null, bool9);
                    error = ProfileAddResult.Success.INSTANCE;
                } catch (Exception e5) {
                    exc = e5;
                    message = exc.getMessage();
                    if (message == null) {
                        message = exc.getClass().getSimpleName();
                    }
                    StateFlowImpl stateFlowImpl13 = newProfileViewModel._error;
                    stateFlowImpl13.getClass();
                    stateFlowImpl13.updateState(null, message);
                    error = new ProfileAddResult.Error(message);
                }
            } catch (Throwable th6) {
                th = th6;
                StateFlowImpl stateFlowImpl14 = newProfileViewModel._isLoading;
                Boolean bool10 = Boolean.FALSE;
                stateFlowImpl14.getClass();
                stateFlowImpl14.updateState(null, bool10);
                throw th;
            }
        }
        StateFlowImpl stateFlowImpl15 = newProfileViewModel._isLoading;
        Boolean bool11 = Boolean.FALSE;
        stateFlowImpl15.getClass();
        stateFlowImpl15.updateState(null, bool11);
        return error;
    }

    public final void reset() {
        StateFlowImpl stateFlowImpl = this._link;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, "");
        Boolean bool = Boolean.FALSE;
        StateFlowImpl stateFlowImpl2 = this._isLoading;
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, bool);
        this._error.setValue(null);
        StateFlowImpl stateFlowImpl3 = this._completed;
        stateFlowImpl3.getClass();
        stateFlowImpl3.updateState(null, bool);
    }

    public final void setLink(String str) {
        StateFlowImpl stateFlowImpl = this._link;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, str);
        StateFlowImpl stateFlowImpl2 = this._error;
        if (stateFlowImpl2.getValue() != null) {
            stateFlowImpl2.setValue(null);
        }
    }
}
