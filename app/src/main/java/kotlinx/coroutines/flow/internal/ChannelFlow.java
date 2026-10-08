package kotlinx.coroutines.flow.internal;

import android.os.Parcel;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.compose.qrcode.QrServerState;
import com.github.kr328.clash.service.FilesProvider;
import com.github.kr328.clash.service.document.Document;
import com.github.kr328.clash.service.document.FileDocument;
import com.github.kr328.clash.service.document.Path;
import com.github.kr328.clash.service.document.Paths;
import com.github.kr328.clash.service.document.Picker;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IClashManagerDelegate;
import com.github.kr328.clash.service.remote.IProfileManagerDelegate;
import com.github.kr328.clash.util.RemoteKt;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChannelFlow implements FusibleFlow {
    public final int capacity;
    public final CoroutineContext context;
    public final int onBufferOverflow;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlow$collect$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $collector;
        public final /* synthetic */ int $r8$classId;
        public /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Object obj3, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.L$0 = obj;
            this.$collector = obj2;
            this.this$0 = obj3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((FlowCollector) this.$collector, (ChannelFlow) this.this$0, continuation, 0);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                case 1:
                    return new AnonymousClass2((ProxyViewModel) this.L$0, (String) this.$collector, (ArrayList) this.this$0, continuation, 1);
                case 2:
                    return new AnonymousClass2((Function0) this.L$0, (MutableState) this.$collector, (MutableState) this.this$0, continuation, 2);
                case 3:
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2((MutableState) this.$collector, (MutableState) this.this$0, continuation, 3);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                case 4:
                    return new AnonymousClass2((String) this.L$0, (String) this.$collector, (FilesProvider) this.this$0, continuation, 4);
                case 5:
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2((IClashManagerDelegate) this.$collector, (String) this.this$0, continuation, 5);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
                case 6:
                    AnonymousClass2 anonymousClass5 = new AnonymousClass2((IProfileManagerDelegate) this.$collector, (Profile) this.this$0, continuation, 6);
                    anonymousClass5.L$0 = obj;
                    return anonymousClass5;
                default:
                    AnonymousClass2 anonymousClass6 = new AnonymousClass2((SendChannel) this.$collector, this.this$0, continuation, 7);
                    anonymousClass6.L$0 = obj;
                    return anonymousClass6;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 1:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 2:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 3:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 4:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 5:
                    return ((AnonymousClass2) create((Parcel) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 6:
                    return ((AnonymousClass2) create((Parcel) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                default:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object value;
            MutableState mutableState;
            MutableState mutableState2;
            boolean zBooleanValue;
            Object failure;
            Parcel parcel;
            Parcel parcel2;
            Object failure2;
            switch (this.$r8$classId) {
                case 0:
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        FlowCollector flowCollector = (FlowCollector) this.$collector;
                        ReceiveChannel receiveChannelProduceImpl = ((ChannelFlow) this.this$0).produceImpl(coroutineScope);
                        this.label = 1;
                        Object objEmitAllImpl$FlowKt__ChannelsKt = FlowKt.emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannelProduceImpl, true, this);
                        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objEmitAllImpl$FlowKt__ChannelsKt != obj2) {
                            objEmitAllImpl$FlowKt__ChannelsKt = Unit.INSTANCE;
                        }
                        if (objEmitAllImpl$FlowKt__ChannelsKt == obj2) {
                            return obj2;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                case 1:
                    String str = (String) this.$collector;
                    ArrayList arrayList = (ArrayList) this.this$0;
                    ProxyViewModel proxyViewModel = (ProxyViewModel) this.L$0;
                    int i2 = this.label;
                    Continuation continuation = null;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    try {
                        if (i2 != 0) {
                            if (i2 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                if (i2 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            StateFlowImpl stateFlowImpl = proxyViewModel._isTesting;
                            Boolean bool = Boolean.FALSE;
                            stateFlowImpl.getClass();
                            stateFlowImpl.updateState(null, bool);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        StateFlowImpl stateFlowImpl2 = proxyViewModel._isTesting;
                        Boolean bool2 = Boolean.TRUE;
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, bool2);
                        StateFlowImpl stateFlowImpl3 = proxyViewModel._testingProxies;
                        do {
                            value = stateFlowImpl3.getValue();
                        } while (!stateFlowImpl3.compareAndSet(value, SetsKt.plus((Set) value, (Iterable) arrayList)));
                        NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(arrayList, proxyViewModel, str, continuation, 17);
                        this.label = 1;
                        if (JobKt.coroutineScope(navHostKt$NavHost$29$1, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        this.label = 2;
                        if (ProxyViewModel.access$reloadGroup(proxyViewModel, str, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        StateFlowImpl stateFlowImpl4 = proxyViewModel._isTesting;
                        Boolean bool3 = Boolean.FALSE;
                        stateFlowImpl4.getClass();
                        stateFlowImpl4.updateState(null, bool3);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        StateFlowImpl stateFlowImpl5 = proxyViewModel._isTesting;
                        Boolean bool4 = Boolean.FALSE;
                        stateFlowImpl5.getClass();
                        stateFlowImpl5.updateState(null, bool4);
                        throw th;
                    }
                case 2:
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) ((MutableState) this.$collector).getValue()).booleanValue()) {
                            ((MutableState) this.this$0).setValue(QrServerState.Received);
                            this.label = 1;
                            Object objDelay = JobKt.delay(1500L, this);
                            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (objDelay == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Function0) this.L$0).invoke();
                    return Unit.INSTANCE;
                case 3:
                    int i4 = this.label;
                    if (i4 == 0) {
                        ResultKt.throwOnFailure(obj);
                        mutableState = (MutableState) this.this$0;
                        if (((Boolean) ((MutableState) this.$collector).getValue()).booleanValue()) {
                            try {
                                Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(2, null, 11);
                                this.L$0 = mutableState;
                                this.label = 1;
                                Object objWithClash$default = RemoteKt.withClash$default(recomposer$join$2, this);
                                CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                                if (objWithClash$default == coroutineSingletons3) {
                                    return coroutineSingletons3;
                                }
                                mutableState2 = mutableState;
                                obj = objWithClash$default;
                            } catch (Throwable th2) {
                                th = th2;
                                mutableState2 = mutableState;
                                failure = new Result.Failure(th);
                            }
                        } else {
                            zBooleanValue = false;
                        }
                        mutableState.setValue(Boolean.valueOf(zBooleanValue));
                        return Unit.INSTANCE;
                    }
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutableState2 = (MutableState) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        failure = new Result.Failure(th);
                    }
                    failure = (Boolean) obj;
                    failure.getClass();
                    Object obj3 = Boolean.FALSE;
                    if (failure instanceof Result.Failure) {
                        failure = obj3;
                    }
                    zBooleanValue = ((Boolean) failure).booleanValue();
                    mutableState = mutableState2;
                    mutableState.setValue(Boolean.valueOf(zBooleanValue));
                    return Unit.INSTANCE;
                case 4:
                    String str2 = (String) this.$collector;
                    int i5 = this.label;
                    if (i5 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Path pathResolve = Paths.resolve((String) this.L$0);
                        if (pathResolve.relative == null) {
                            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m("invalid path ", str2));
                        }
                        Picker picker = (Picker) ((FilesProvider) this.this$0).picker$delegate.getValue();
                        this.label = 1;
                        obj = picker.pick(pathResolve, true, this);
                        CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (obj == coroutineSingletons4) {
                            return coroutineSingletons4;
                        }
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Document document = (Document) obj;
                    if (document instanceof FileDocument) {
                        return Boolean.valueOf(FilesKt.deleteRecursively(((FileDocument) document).file));
                    }
                    throw new FileNotFoundException(CaptureSession$State$EnumUnboxingLocalUtility.m("invalid path ", str2));
                case 5:
                    int i6 = this.label;
                    if (i6 == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel = (Parcel) this.L$0;
                        IClashManagerDelegate iClashManagerDelegate = (IClashManagerDelegate) this.$collector;
                        String str3 = (String) this.this$0;
                        this.L$0 = parcel;
                        this.label = 1;
                        Object objHealthCheck = iClashManagerDelegate.$$delegate_0.healthCheck(str3, this);
                        CoroutineSingletons coroutineSingletons5 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objHealthCheck == coroutineSingletons5) {
                            return coroutineSingletons5;
                        }
                    } else {
                        if (i6 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    parcel.writeNoException();
                    return Unit.INSTANCE;
                case 6:
                    int i7 = this.label;
                    if (i7 == 0) {
                        ResultKt.throwOnFailure(obj);
                        parcel2 = (Parcel) this.L$0;
                        IProfileManagerDelegate iProfileManagerDelegate = (IProfileManagerDelegate) this.$collector;
                        Profile profile = (Profile) this.this$0;
                        this.L$0 = parcel2;
                        this.label = 1;
                        Object active = iProfileManagerDelegate.$$delegate_0.setActive(profile, this);
                        CoroutineSingletons coroutineSingletons6 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (active == coroutineSingletons6) {
                            return coroutineSingletons6;
                        }
                    } else {
                        if (i7 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        parcel2 = (Parcel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    parcel2.writeNoException();
                    return Unit.INSTANCE;
                default:
                    int i8 = this.label;
                    try {
                        if (i8 == 0) {
                            ResultKt.throwOnFailure(obj);
                            SendChannel sendChannel = (SendChannel) this.$collector;
                            Object obj4 = this.this$0;
                            this.label = 1;
                            Object objSend = sendChannel.send(obj4, this);
                            CoroutineSingletons coroutineSingletons7 = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (objSend == coroutineSingletons7) {
                                return coroutineSingletons7;
                            }
                        } else {
                            if (i8 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        failure2 = Unit.INSTANCE;
                        break;
                    } catch (Throwable th4) {
                        failure2 = new Result.Failure(th4);
                    }
                    return new ChannelResult(!(failure2 instanceof Result.Failure) ? Unit.INSTANCE : new ChannelResult.Closed(Result.m830exceptionOrNullimpl(failure2)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Object obj2, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.$collector = obj;
            this.this$0 = obj2;
        }
    }

    public ChannelFlow(CoroutineContext coroutineContext, int i, int i2) {
        this.context = coroutineContext;
        this.capacity = i;
        this.onBufferOverflow = i2;
    }

    public String additionalToStringProps() {
        return null;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object objCoroutineScope = JobKt.coroutineScope(new AnonymousClass2(flowCollector, this, null, 0), continuation);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    public abstract Object collectTo(ProducerScope producerScope, Continuation continuation);

    public abstract ChannelFlow create(CoroutineContext coroutineContext, int i, int i2);

    public Flow dropChannelOperators() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0014  */
    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, int i2) {
        CoroutineContext coroutineContext2 = this.context;
        CoroutineContext coroutineContextPlus = coroutineContext.plus(coroutineContext2);
        int i3 = this.onBufferOverflow;
        int i4 = this.capacity;
        if (i2 == 1) {
            if (i4 != -3) {
                if (i == -3) {
                    i = i4;
                } else if (i4 != -2) {
                    if (i == -2) {
                        i = i4;
                    } else {
                        i += i4;
                        if (i < 0) {
                            i = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            i2 = i3;
        }
        return (Intrinsics.areEqual(coroutineContextPlus, coroutineContext2) && i == i4 && i2 == i3) ? this : create(coroutineContextPlus, i, i2);
    }

    public ReceiveChannel produceImpl(CoroutineScope coroutineScope) {
        int i = this.capacity;
        if (i == -3) {
            i = -2;
        }
        Function2 filesActivity$showError$1 = new FilesActivity$showError$1(this, null, 20);
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(JobKt.newCoroutineContext(coroutineScope, this.context), ChannelKt.Channel$default(i, this.onBufferOverflow, 4));
        producerCoroutine.start(3, producerCoroutine, filesActivity$showError$1);
        return producerCoroutine;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strAdditionalToStringProps = additionalToStringProps();
        if (strAdditionalToStringProps != null) {
            arrayList.add(strAdditionalToStringProps);
        }
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext = this.context;
        if (coroutineContext != emptyCoroutineContext) {
            arrayList.add("context=" + coroutineContext);
        }
        int i = this.capacity;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        int i2 = this.onBufferOverflow;
        if (i2 != 1) {
            arrayList.add("onBufferOverflow=".concat(Density.CC.stringValueOf$6(i2)));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return Modifier.CC.m(sb, CollectionsKt.joinToString$default(arrayList, ", ", null, null, null, 62), ']');
    }
}
