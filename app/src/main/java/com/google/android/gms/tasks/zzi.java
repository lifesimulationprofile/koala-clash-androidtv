package com.google.android.gms.tasks;

import android.app.Application;
import android.app.job.JobParameters;
import android.graphics.Typeface;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.compose.ui.unit.Density;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.app.ActivityRecreator;
import androidx.core.content.res.CamUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.room.RoomOpenHelper;
import androidx.room.TransactionExecutor;
import coil.disk.DiskLruCache;
import coil.request.Parameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.AccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.mlkit_common.zzrq;
import com.google.android.gms.internal.mlkit_common.zzsu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzft;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.signin.internal.zak;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.textfield.ClearTextEndIconDelegate;
import com.google.android.material.textfield.DropdownMenuEndIconDelegate;
import com.google.android.material.textfield.PasswordToggleEndIconDelegate;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.components.ComponentRuntime$$Lambda$5;
import com.google.firebase.components.LazySet;
import com.google.firebase.components.OptionalProvider;
import com.google.firebase.components.OptionalProvider$$Lambda$4;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.zzd;
import com.google.mlkit.vision.barcode.internal.zzb;
import com.google.mlkit.vision.barcode.internal.zzl;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LimitedDispatcher;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzi implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public Object zza;
    public final Object zzb;

    public /* synthetic */ zzi(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
    }

    private final void run$com$google$android$gms$tasks$zzk() {
        synchronized (((zzh) this.zzb).zzb) {
            OnFailureListener onFailureListener = (OnFailureListener) ((zzh) this.zzb).zzc;
            Exception exception = ((zzw) this.zza).getException();
            zzah.checkNotNull(exception);
            onFailureListener.onFailure(exception);
        }
    }

    private final void run$com$google$android$gms$tasks$zzm() {
        synchronized (((zzh) this.zzb).zzb) {
            ((OnSuccessListener) ((zzh) this.zzb).zzc).onSuccess(((zzw) this.zza).getResult());
        }
    }

    private final void run$com$google$firebase$components$ComponentRuntime$$Lambda$3() {
        OptionalProvider$$Lambda$4 optionalProvider$$Lambda$4;
        OptionalProvider optionalProvider = (OptionalProvider) this.zza;
        Provider provider = (Provider) this.zzb;
        if (optionalProvider.delegate != ComponentRuntime$$Lambda$5.instance$1) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (optionalProvider) {
            optionalProvider$$Lambda$4 = optionalProvider.handler;
            optionalProvider.handler = null;
            optionalProvider.delegate = provider;
        }
        optionalProvider$$Lambda$4.getClass();
    }

    private final void run$com$google$firebase$components$ComponentRuntime$$Lambda$4() {
        LazySet lazySet = (LazySet) this.zza;
        Provider provider = (Provider) this.zzb;
        synchronized (lazySet) {
            try {
                if (lazySet.actualSet == null) {
                    lazySet.providers.add(provider);
                } else {
                    lazySet.actualSet.add(provider.get());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void run$com$google$mlkit$common$sdkinternal$zzl() {
        zzl zzlVar = (zzl) this.zza;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzb;
        int iDecrementAndGet = zzlVar.zza$1.decrementAndGet();
        if (iDecrementAndGet < 0) {
            throw new IllegalStateException();
        }
        if (iDecrementAndGet == 0) {
            synchronized (zzlVar) {
                try {
                    zzlVar.zzd.zzb();
                    zzl.zza = true;
                    Http2Connection.Builder builder = new Http2Connection.Builder();
                    zzra zzraVar = zzlVar.zzh ? zzra.zzc : zzra.zzb;
                    zzwp zzwpVar = zzlVar.zze;
                    builder.connectionName = zzraVar;
                    Request request = new Request(15, false);
                    request.method = zzb.zzc(zzlVar.zzc);
                    builder.source = new zzrr(request);
                    com.google.mlkit.common.sdkinternal.zzh.zza.execute(new CascadingMenuPopup$3$1(zzwpVar, new RoomOpenHelper(builder, 0), zzrc.zzl, zzwpVar.zzj(), 2));
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzlVar.zzb.set(false);
        }
        zzrq.zza.clear();
        zzsu.zza.clear();
        taskCompletionSource.zza.zzb(null);
    }

    @Override // java.lang.Runnable
    public final void run() throws DispatchException {
        IAccountAccessor iAccountAccessor;
        IAccountAccessor zzwVar;
        int i = 3;
        zzbq zzbqVar = null;
        try {
            switch (this.$r8$classId) {
                case 0:
                    synchronized (((zzh) this.zzb).zzb) {
                        ((OnCompleteListener) ((zzh) this.zzb).zzc).onComplete((zzw) this.zza);
                        break;
                    }
                    return;
                case 1:
                    FutureCallback futureCallback = (FutureCallback) this.zzb;
                    try {
                        futureCallback.onSuccess(Futures.getDone((Future) this.zza));
                        return;
                    } catch (Error e) {
                        e = e;
                        futureCallback.onFailure(e);
                        return;
                    } catch (RuntimeException e2) {
                        e = e2;
                        futureCallback.onFailure(e);
                        return;
                    } catch (ExecutionException e3) {
                        Throwable cause = e3.getCause();
                        if (cause == null) {
                            futureCallback.onFailure(e3);
                            return;
                        } else {
                            futureCallback.onFailure(cause);
                            return;
                        }
                    }
                case 2:
                    try {
                        ChainingListenableFuture chainingListenableFuture = (ChainingListenableFuture) this.zzb;
                        Object uninterruptibly = Futures.getUninterruptibly((ListenableFuture) this.zza);
                        CallbackToFutureAdapter.Completer completer = chainingListenableFuture.mCompleter;
                        if (completer != null) {
                            completer.set(uninterruptibly);
                        }
                        break;
                    } catch (CancellationException unused) {
                        ((ChainingListenableFuture) this.zzb).cancel(false);
                    } catch (ExecutionException e4) {
                        ChainingListenableFuture chainingListenableFuture2 = (ChainingListenableFuture) this.zzb;
                        Throwable cause2 = e4.getCause();
                        CallbackToFutureAdapter.Completer completer2 = chainingListenableFuture2.mCompleter;
                        if (completer2 != null) {
                            completer2.setException(cause2);
                        }
                    }
                    return;
                case 3:
                    ((ActivityRecreator.LifecycleCheckCallbacks) this.zza).currentlyRecreatingToken = this.zzb;
                    return;
                case 4:
                    ((Application) this.zza).unregisterActivityLifecycleCallbacks((ActivityRecreator.LifecycleCheckCallbacks) this.zzb);
                    return;
                case 5:
                    Object obj = this.zzb;
                    Object obj2 = this.zza;
                    try {
                        Method method = ActivityRecreator.performStopActivity3ParamsMethod;
                        if (method != null) {
                            method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                        } else {
                            ActivityRecreator.performStopActivity2ParamsMethod.invoke(obj2, obj, Boolean.FALSE);
                        }
                        return;
                    } catch (RuntimeException e5) {
                        if (e5.getClass() == RuntimeException.class && e5.getMessage() != null && e5.getMessage().startsWith("Unable to stop")) {
                            throw e5;
                        }
                        return;
                    } catch (Throwable th) {
                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                        return;
                    }
                case 6:
                    Parameters.Builder builder = (Parameters.Builder) this.zza;
                    Typeface typeface = (Typeface) this.zzb;
                    CamUtils camUtils = (CamUtils) builder.entries;
                    if (camUtils != null) {
                        camUtils.onFontRetrieved(typeface);
                        return;
                    }
                    return;
                case 7:
                    ((Edge) this.zza).accept(this.zzb);
                    return;
                case 8:
                    ArrayList arrayList = (ArrayList) this.zza;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.zzb;
                    if (arrayList.contains(specialEffectsController$FragmentStateManagerOperation)) {
                        arrayList.remove(specialEffectsController$FragmentStateManagerOperation);
                        Density.CC._applyState(specialEffectsController$FragmentStateManagerOperation.mFragment.mView, specialEffectsController$FragmentStateManagerOperation.mFinalState);
                        return;
                    }
                    return;
                case 9:
                    TransactionExecutor transactionExecutor = (TransactionExecutor) this.zzb;
                    try {
                        ((Runnable) this.zza).run();
                        return;
                    } finally {
                        transactionExecutor.scheduleNext();
                    }
                case 10:
                    JobInfoSchedulerService jobInfoSchedulerService = (JobInfoSchedulerService) this.zza;
                    JobParameters jobParameters = (JobParameters) this.zzb;
                    int i2 = JobInfoSchedulerService.$r8$clinit;
                    jobInfoSchedulerService.jobFinished(jobParameters, false);
                    return;
                case 11:
                    ConnectionResult connectionResult = (ConnectionResult) this.zza;
                    ZoomControl zoomControl = (ZoomControl) this.zzb;
                    Api$Client api$Client = (Api$Client) zoomControl.mCamera2CameraControlImpl;
                    zabq zabqVar = (zabq) ((GoogleApiManager) zoomControl.mCaptureResultListener).zan.get((ApiKey) zoomControl.mCurrentZoomState);
                    if (zabqVar == null) {
                        return;
                    }
                    if (connectionResult.zzb != 0) {
                        zabqVar.zar(connectionResult, null);
                        return;
                    }
                    zoomControl.mIsActive = true;
                    if (api$Client.requiresSignIn()) {
                        if (!zoomControl.mIsActive || (iAccountAccessor = (IAccountAccessor) zoomControl.mZoomStateLiveData) == null) {
                            return;
                        }
                        api$Client.getRemoteService(iAccountAccessor, (Set) zoomControl.mZoomImpl);
                        return;
                    }
                    try {
                        api$Client.getRemoteService(null, api$Client.getScopesForConnectionlessNonSignIn());
                        return;
                    } catch (SecurityException e6) {
                        Log.e("GoogleApiManager", "Failed to get service from broker. ", e6);
                        api$Client.disconnect("Failed to get service from broker.");
                        zabqVar.zar(new ConnectionResult(10), null);
                        return;
                    }
                case 12:
                    zact zactVar = (zact) this.zzb;
                    zak zakVar = (zak) this.zza;
                    ConnectionResult connectionResult2 = zakVar.zab;
                    if (connectionResult2.zzb == 0) {
                        zav zavVar = zakVar.zac;
                        zzah.checkNotNull(zavVar);
                        ConnectionResult connectionResult3 = zavVar.zac;
                        if (connectionResult3.zzb != 0) {
                            Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(connectionResult3)), new Exception());
                            zactVar.zah.zae(connectionResult3);
                            zactVar.zag.disconnect();
                            return;
                        }
                        ZoomControl zoomControl2 = zactVar.zah;
                        IBinder iBinder = zavVar.zab;
                        if (iBinder == null) {
                            zzwVar = null;
                        } else {
                            int i3 = AccountAccessor.$r8$clinit;
                            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                            zzwVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new com.google.android.gms.common.internal.zzw(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                        }
                        Set set = zactVar.zae;
                        zoomControl2.getClass();
                        if (zzwVar == null || set == null) {
                            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                            zoomControl2.zae(new ConnectionResult(4));
                        } else {
                            zoomControl2.mZoomStateLiveData = zzwVar;
                            zoomControl2.mZoomImpl = set;
                            if (zoomControl2.mIsActive) {
                                ((Api$Client) zoomControl2.mCamera2CameraControlImpl).getRemoteService(zzwVar, set);
                            }
                        }
                    } else {
                        zactVar.zah.zae(connectionResult2);
                    }
                    zactVar.zag.disconnect();
                    return;
                case 13:
                    zzwp zzwpVar = (zzwp) this.zza;
                    zzrc zzrcVar = zzrc.zzbe;
                    ConnectionPool connectionPool = (ConnectionPool) this.zzb;
                    HashMap map = zzwpVar.zzl;
                    zzbw zzbwVar = (zzbw) map.get(zzrcVar);
                    if (zzbwVar != null) {
                        for (Object obj3 : (zzbg) zzbwVar.zzw()) {
                            Object arrayList2 = (Collection) zzbwVar.zza.get(obj3);
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList(i);
                            }
                            List list = (List) arrayList2;
                            ArrayList arrayList3 = new ArrayList(list instanceof RandomAccess ? new zzbm(zzbwVar, obj3, list, zzbqVar) : new zzbq(zzbwVar, obj3, list, zzbqVar));
                            Collections.sort(arrayList3);
                            Http2Connection.Builder builder2 = new Http2Connection.Builder();
                            int size = arrayList3.size();
                            long jLongValue = 0;
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj4 = arrayList3.get(i4);
                                i4++;
                                jLongValue = ((Long) obj4).longValue() + jLongValue;
                            }
                            builder2.connectionName = Long.valueOf((jLongValue / ((long) arrayList3.size())) & Long.MAX_VALUE);
                            builder2.taskRunner = Long.valueOf(zzwp.zza(arrayList3, 100.0d) & Long.MAX_VALUE);
                            builder2.listener = Long.valueOf(zzwp.zza(arrayList3, 75.0d) & Long.MAX_VALUE);
                            builder2.sink = Long.valueOf(zzwp.zza(arrayList3, 50.0d) & Long.MAX_VALUE);
                            builder2.source = Long.valueOf(zzwp.zza(arrayList3, 25.0d) & Long.MAX_VALUE);
                            builder2.socket = Long.valueOf(Long.MAX_VALUE & zzwp.zza(arrayList3, 0.0d));
                            zzqd zzqdVar = new zzqd(builder2);
                            int size2 = arrayList3.size();
                            zzl zzlVar = (zzl) connectionPool.delegate;
                            zzft zzftVar = (zzft) obj3;
                            Http2Connection.Builder builder3 = new Http2Connection.Builder();
                            builder3.connectionName = zzlVar.zzh ? zzra.zzc : zzra.zzb;
                            zzfi zzfiVar = new zzfi();
                            zzfiVar.zzd = Integer.valueOf(size2 & Integer.MAX_VALUE);
                            zzfiVar.zzc = zzftVar;
                            zzfiVar.zze = zzqdVar;
                            builder3.listener = new zzfv(zzfiVar);
                            com.google.mlkit.common.sdkinternal.zzh.zza.execute(new CascadingMenuPopup$3$1(zzwpVar, new RoomOpenHelper(builder3, 0), zzrcVar, zzwpVar.zzj(), 2));
                            i = 3;
                            zzbqVar = null;
                        }
                        map.remove(zzrcVar);
                        return;
                    }
                    return;
                case 14:
                    run$com$google$android$gms$tasks$zzk();
                    return;
                case 15:
                    run$com$google$android$gms$tasks$zzm();
                    return;
                case 16:
                    zzp zzpVar = (zzp) this.zzb;
                    try {
                        List list2 = (List) ((zzw) this.zza).getResult();
                        zzw zzwVar2 = new zzw();
                        zzwVar2.zzb(list2);
                        zzt zztVar = TaskExecutors.zza;
                        zzwVar2.addOnSuccessListener(zztVar, zzpVar);
                        zzwVar2.addOnFailureListener(zztVar, zzpVar);
                        zzwVar2.zzb.zza(new zzh((Executor) zztVar, (OnCanceledListener) zzpVar));
                        zzwVar2.zzi();
                        return;
                    } catch (RuntimeExecutionException e7) {
                        if (e7.getCause() instanceof Exception) {
                            zzpVar.onFailure((Exception) e7.getCause());
                            return;
                        } else {
                            zzpVar.onFailure(e7);
                            return;
                        }
                    } catch (CancellationException unused2) {
                        zzpVar.onCanceled();
                        return;
                    } catch (Exception e8) {
                        zzpVar.onFailure(e8);
                        return;
                    }
                case 17:
                    ViewDragHelper viewDragHelper = ((SwipeDismissBehavior) this.zzb).viewDragHelper;
                    if (viewDragHelper == null || !viewDragHelper.continueSettling()) {
                        return;
                    }
                    View view = (View) this.zza;
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    view.postOnAnimation(this);
                    return;
                case 18:
                    EditText editText = (EditText) this.zza;
                    ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) ((ClearTextEndIconDelegate.AnonymousClass4) this.zzb).this$0;
                    editText.removeTextChangedListener(clearTextEndIconDelegate.clearTextEndIconTextWatcher);
                    clearTextEndIconDelegate.animateIcon(true);
                    return;
                case 19:
                    boolean zIsPopupShowing = ((AutoCompleteTextView) this.zza).isPopupShowing();
                    DropdownMenuEndIconDelegate.AnonymousClass1 anonymousClass1 = (DropdownMenuEndIconDelegate.AnonymousClass1) this.zzb;
                    ((DropdownMenuEndIconDelegate) anonymousClass1.this$0).setEndIconChecked(zIsPopupShowing);
                    ((DropdownMenuEndIconDelegate) anonymousClass1.this$0).dropdownPopupDirty = zIsPopupShowing;
                    return;
                case 20:
                    ((AutoCompleteTextView) this.zza).removeTextChangedListener(((DropdownMenuEndIconDelegate) ((ClearTextEndIconDelegate.AnonymousClass4) this.zzb).this$0).exposedDropdownEndIconTextWatcher);
                    return;
                case 21:
                    ((EditText) this.zza).removeTextChangedListener(((PasswordToggleEndIconDelegate) ((ClearTextEndIconDelegate.AnonymousClass4) this.zzb).this$0).textWatcher);
                    return;
                case 22:
                    run$com$google$firebase$components$ComponentRuntime$$Lambda$3();
                    return;
                case 23:
                    run$com$google$firebase$components$ComponentRuntime$$Lambda$4();
                    return;
                case 24:
                    ReferenceQueue referenceQueue = (ReferenceQueue) this.zza;
                    while (!((Set) this.zzb).isEmpty()) {
                        try {
                            zzd zzdVar = (zzd) referenceQueue.remove();
                            if (zzdVar.zza.remove(zzdVar)) {
                                zzdVar.clear();
                                zzdVar.zzb.getClass();
                            }
                        } catch (InterruptedException unused3) {
                        }
                    }
                    return;
                case 25:
                    Callable callable = (Callable) this.zza;
                    zzw zzwVar3 = ((TaskCompletionSource) this.zzb).zza;
                    try {
                        zzwVar3.zzb(callable.call());
                        return;
                    } catch (MlKitException e9) {
                        zzwVar3.zza(e9);
                        return;
                    } catch (Exception e10) {
                        zzwVar3.zza(new MlKitException("Internal error has occurred when executing ML Kit tasks", e10));
                        return;
                    }
                case 26:
                    run$com$google$mlkit$common$sdkinternal$zzl();
                    return;
                case 27:
                    DiskLruCache.Editor editor = (DiskLruCache.Editor) this.zza;
                    AtomicReference atomicReference = (AtomicReference) editor.this$0;
                    if (((Thread) atomicReference.getAndSet(Thread.currentThread())) != null) {
                        throw new IllegalStateException();
                    }
                    try {
                        ((Runnable) this.zzb).run();
                        atomicReference.set(null);
                        editor.zzc();
                        return;
                    } catch (Throwable th2) {
                        try {
                            atomicReference.set(null);
                            editor.zzc();
                            throw th2;
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                            throw th2;
                        }
                    }
                case 28:
                    ((CancellableContinuationImpl) this.zzb).resumeUndispatched((ExecutorCoroutineDispatcherImpl) this.zza, Unit.INSTANCE);
                    return;
                default:
                    LimitedDispatcher limitedDispatcher = (LimitedDispatcher) this.zzb;
                    int i5 = 0;
                    while (true) {
                        try {
                            ((Runnable) this.zza).run();
                        } catch (Throwable th4) {
                            JobKt.handleCoroutineException(th4, EmptyCoroutineContext.INSTANCE);
                        }
                        Runnable runnableObtainTaskOrDeallocateWorker = limitedDispatcher.obtainTaskOrDeallocateWorker();
                        if (runnableObtainTaskOrDeallocateWorker == null) {
                            return;
                        }
                        this.zza = runnableObtainTaskOrDeallocateWorker;
                        i5++;
                        if (i5 >= 16 && InlineList.safeIsDispatchNeeded(limitedDispatcher.dispatcher, limitedDispatcher)) {
                            InlineList.safeDispatch(limitedDispatcher.dispatcher, limitedDispatcher, this);
                            return;
                        }
                        break;
                    }
                    break;
            }
        } finally {
            ((ChainingListenableFuture) this.zzb).mOutputFuture = null;
        }
        ((ChainingListenableFuture) this.zzb).mOutputFuture = null;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 1:
                return zzi.class.getSimpleName() + "," + ((FutureCallback) this.zzb);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ zzi(int i, Object obj, Object obj2, boolean z) {
        this.$r8$classId = i;
        this.zzb = obj;
        this.zza = obj2;
    }

    public /* synthetic */ zzi(zzwp zzwpVar, ConnectionPool connectionPool) {
        this.$r8$classId = 13;
        zzrc zzrcVar = zzrc.zza;
        this.zza = zzwpVar;
        this.zzb = connectionPool;
    }

    public zzi(DefaultSpecialEffectsController defaultSpecialEffectsController, ArrayList arrayList, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation) {
        this.$r8$classId = 8;
        this.zza = arrayList;
        this.zzb = specialEffectsController$FragmentStateManagerOperation;
    }

    public zzi(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.$r8$classId = 17;
        this.zzb = swipeDismissBehavior;
        this.zza = view;
    }
}
