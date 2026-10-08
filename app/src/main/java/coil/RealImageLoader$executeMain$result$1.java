package coil;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.gestures.TrackpadScrollingLogic;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ProduceStateScopeImpl;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.compose.ComposeNavigator;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.Parameters;
import coil.size.Size;
import com.github.kr328.clash.FilesActivity;
import com.github.kr328.clash.FilesActivity$Content$3$1$1;
import com.github.kr328.clash.LogcatActivity;
import com.github.kr328.clash.compose.FileAction;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.qrserver.QrProfileServer;
import com.github.kr328.clash.remote.FilesClient;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import com.github.kr328.clash.service.ProfileProcessor;
import com.github.kr328.clash.service.TunService;
import com.github.kr328.clash.service.clash.ClashRuntimeKt$clashRuntime$1$launch$1$1$scope$1;
import com.github.kr328.clash.service.clash.module.ConfigurationModule;
import com.github.kr328.clash.service.data.DaosKt;
import com.github.kr328.clash.service.store.ServiceStore;
import com.github.kr328.clash.service.util.BroadcastKt;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealImageLoader$executeMain$result$1 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object $eventListener;
    public final /* synthetic */ Object $placeholderBitmap;
    public final /* synthetic */ int $r8$classId;
    public Object $request;
    public Object $size;
    public int label;
    public Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$executeMain$result$1(Context context, UUID uuid, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 15;
        this.$eventListener = uuid;
        this.$placeholderBitmap = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b8, code lost:
    
        if (kotlinx.coroutines.JobKt.withContext(r1, r11, r20) == r2) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ce, code lost:
    
        if (kotlinx.coroutines.JobKt.withContext(r1, r3, r20) == r2) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object invokeSuspend$com$github$kr328$clash$compose$qrcode$TvQrCodeSheetKt$TvQrCodeSheet$3$1$1(java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader$executeMain$result$1.invokeSuspend$com$github$kr328$clash$compose$qrcode$TvQrCodeSheetKt$TvQrCodeSheet$3$1$1(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0076 A[Catch: all -> 0x001d, TryCatch #1 {all -> 0x001d, blocks: (B:7:0x0019, B:22:0x006e, B:24:0x0076, B:25:0x00a7), top: B:34:0x0019 }] */
    private final Object invokeSuspend$com$github$kr328$clash$service$ProfileProcessor$active$2(Object obj) throws Throwable {
        UUID uuid;
        Context context;
        Mutex mutex;
        Mutex mutex2;
        Throwable th;
        UUID uuid2;
        int i = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutexImpl mutexImpl = ProfileProcessor.profileLock;
                UUID uuid3 = (UUID) this.$eventListener;
                Context context2 = (Context) this.$placeholderBitmap;
                this.$request = mutexImpl;
                this.this$0 = uuid3;
                this.$size = context2;
                this.label = 1;
                if (mutexImpl.lock(this) != coroutineSingletons) {
                    uuid = uuid3;
                    context = context2;
                    mutex = mutexImpl;
                }
                return coroutineSingletons;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                context = (Context) this.$size;
                uuid2 = (UUID) this.this$0;
                mutex2 = (Mutex) this.$request;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2 = mutex2;
                    if (((Boolean) obj).booleanValue()) {
                        ImageLoader$Builder imageLoader$Builder = new ServiceStore(context).activeProfile$delegate;
                        KProperty kProperty = ServiceStore.$$delegatedProperties[0];
                        MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                        String str = (String) ((Remote$$ExternalSyntheticLambda1) imageLoader$Builder.defaults).invoke(uuid2);
                        SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                        editorEdit.putString("active_profile", str);
                        editorEdit.apply();
                        BroadcastKt.sendProfileChanged(context, uuid2);
                    }
                    Unit unit = Unit.INSTANCE;
                    ((MutexImpl) mutex2).unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    ((MutexImpl) mutex2).unlock(null);
                    throw th;
                }
            }
            context = (Context) this.$size;
            uuid = (UUID) this.this$0;
            Mutex mutex3 = (Mutex) this.$request;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
            this.$request = mutex;
            this.this$0 = uuid;
            this.$size = context;
            this.label = 2;
            Object objExists = dispatcherImportedDao.exists(uuid, this);
            if (objExists != coroutineSingletons) {
                UUID uuid4 = uuid;
                mutex2 = mutex;
                obj = objExists;
                uuid2 = uuid4;
                if (((Boolean) obj).booleanValue()) {
                    ImageLoader$Builder imageLoader$Builder2 = new ServiceStore(context).activeProfile$delegate;
                    KProperty kProperty2 = ServiceStore.$$delegatedProperties[0];
                    MemoryCacheService memoryCacheService2 = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder2.applicationContext).entries;
                    String str2 = (String) ((Remote$$ExternalSyntheticLambda1) imageLoader$Builder2.defaults).invoke(uuid2);
                    SharedPreferences.Editor editorEdit2 = ((SharedPreferences) memoryCacheService2.imageLoader).edit();
                    editorEdit2.putString("active_profile", str2);
                    editorEdit2.apply();
                    BroadcastKt.sendProfileChanged(context, uuid2);
                }
                Unit unit2 = Unit.INSTANCE;
                ((MutexImpl) mutex2).unlock(null);
                return Unit.INSTANCE;
            }
            return coroutineSingletons;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            ((MutexImpl) mutex2).unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00bb A[Catch: all -> 0x004a, Exception -> 0x004d, TryCatch #1 {Exception -> 0x004d, blocks: (B:13:0x0043, B:31:0x00ff, B:26:0x00b5, B:28:0x00bb), top: B:52:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ff A[Catch: all -> 0x004a, Exception -> 0x004d, PHI: r0 r5 r11 r12 r13
      0x00ff: PHI (r0v18 com.github.kr328.clash.service.clash.module.NetworkObserveModule) = 
      (r0v17 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
      (r0v21 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
     binds: [B:29:0x00fb, B:14:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r5v10 java.lang.Object) = (r5v9 java.lang.Object), (r5v14 java.lang.Object) binds: [B:29:0x00fb, B:14:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r11v9 com.github.kr328.clash.service.clash.module.ConfigurationModule) = 
      (r11v8 com.github.kr328.clash.service.clash.module.ConfigurationModule)
      (r11v11 com.github.kr328.clash.service.clash.module.ConfigurationModule)
     binds: [B:29:0x00fb, B:14:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r12v11 com.github.kr328.clash.service.clash.module.TunModule) = 
      (r12v10 com.github.kr328.clash.service.clash.module.TunModule)
      (r12v13 com.github.kr328.clash.service.clash.module.TunModule)
     binds: [B:29:0x00fb, B:14:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r13v3 com.github.kr328.clash.service.clash.module.CloseModule) = 
      (r13v2 com.github.kr328.clash.service.clash.module.CloseModule)
      (r13v5 com.github.kr328.clash.service.clash.module.CloseModule)
     binds: [B:29:0x00fb, B:14:0x0046] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {Exception -> 0x004d, blocks: (B:13:0x0043, B:31:0x00ff, B:26:0x00b5, B:28:0x00bb), top: B:52:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0108  */
    /* JADX WARN: Code duplicated, block: B:35:0x010b A[PHI: r12
      0x010b: PHI (r12v9 com.github.kr328.clash.service.clash.module.TunModule) = 
      (r12v10 com.github.kr328.clash.service.clash.module.TunModule)
      (r12v11 com.github.kr328.clash.service.clash.module.TunModule)
     binds: [B:27:0x00b9, B:32:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00fb -> B:31:0x00ff). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private final java.lang.Object invokeSuspend$com$github$kr328$clash$service$TunService$runtime$1(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader$executeMain$result$1.invokeSuspend$com$github$kr328$clash$service$TunService$runtime$1(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new RealImageLoader$executeMain$result$1((ImageRequest) this.$request, (RealImageLoader) this.this$0, (Size) this.$size, (EventListener$Companion$NONE$1) this.$eventListener, (Bitmap) this.$placeholderBitmap, continuation, 0);
            case 1:
                return new RealImageLoader$executeMain$result$1((SeekableTransitionState) this.$size, this.$eventListener, (Transition) this.$placeholderBitmap, continuation, 1);
            case 2:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1((PointerInputScope) this.this$0, (TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1) this.$size, (TooltipKt$$ExternalSyntheticLambda7) this.$eventListener, (PressGestureScopeImpl) this.$placeholderBitmap, continuation, 2);
                realImageLoader$executeMain$result$1.$request = obj;
                return realImageLoader$executeMain$result$1;
            case 3:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$2 = new RealImageLoader$executeMain$result$1((TrackpadScrollingLogic) this.$size, (ScrollingLogic) this.$eventListener, (Ref$ObjectRef) this.$placeholderBitmap, continuation, 3);
                realImageLoader$executeMain$result$2.this$0 = obj;
                return realImageLoader$executeMain$result$2;
            case 4:
                return new RealImageLoader$executeMain$result$1((LegacyTextFieldState) this.$request, (MutableState) this.this$0, (TextInputService) this.$size, (TextFieldSelectionManager) this.$eventListener, (ImeOptions) this.$placeholderBitmap, continuation, 4);
            case 5:
                return new RealImageLoader$executeMain$result$1((BringIntoViewRequesterImpl) this.$request, (TextFieldValue) this.this$0, (LegacyTextFieldState) this.$size, (TextLayoutResultProxy) this.$eventListener, (OffsetMapping) this.$placeholderBitmap, continuation, 5);
            case 6:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$3 = new RealImageLoader$executeMain$result$1((AndroidPlatformTextInputSession) this.this$0, (Function1) this.$size, (AndroidLegacyPlatformTextInputServiceAdapter) this.$eventListener, (LegacyAdaptingPlatformTextInputModifierNode) this.$placeholderBitmap, continuation, 6);
                realImageLoader$executeMain$result$3.$request = obj;
                return realImageLoader$executeMain$result$3;
            case 7:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$4 = new RealImageLoader$executeMain$result$1((Recomposer) this.$size, (Recomposer$runRecomposeAndApplyChanges$2) this.$eventListener, (BroadcastFrameClock) this.$placeholderBitmap, continuation, 7);
                realImageLoader$executeMain$result$4.this$0 = obj;
                return realImageLoader$executeMain$result$4;
            case 8:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$5 = new RealImageLoader$executeMain$result$1((Function0) this.$placeholderBitmap, continuation, 8);
                realImageLoader$executeMain$result$5.$eventListener = obj;
                return realImageLoader$executeMain$result$5;
            case 9:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$6 = new RealImageLoader$executeMain$result$1((Lifecycle) this.this$0, (Lifecycle.State) this.$size, (CoroutineContext) this.$eventListener, (Flow) this.$placeholderBitmap, continuation, 9);
                realImageLoader$executeMain$result$6.$request = obj;
                return realImageLoader$executeMain$result$6;
            case 10:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$7 = new RealImageLoader$executeMain$result$1((ComposeNavigator) this.this$0, (MutableState) this.$size, (ParcelableSnapshotMutableFloatState) this.$eventListener, (MutableState) this.$placeholderBitmap, continuation, 10);
                realImageLoader$executeMain$result$7.$request = obj;
                return realImageLoader$executeMain$result$7;
            case 11:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$8 = new RealImageLoader$executeMain$result$1((FilesActivity) this.this$0, (FilesClient) this.$size, (Uri) this.$eventListener, (File) this.$placeholderBitmap, continuation, 11);
                realImageLoader$executeMain$result$8.$request = obj;
                return realImageLoader$executeMain$result$8;
            case 12:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$9 = new RealImageLoader$executeMain$result$1((FilesActivity) this.this$0, (FilesActivity$Content$3$1$1) this.$size, (FilesClient) this.$eventListener, (FileAction) this.$placeholderBitmap, continuation, 12);
                realImageLoader$executeMain$result$9.$request = obj;
                return realImageLoader$executeMain$result$9;
            case 13:
                return new RealImageLoader$executeMain$result$1((LogFile) this.$size, (LogcatActivity) this.$eventListener, (MutableState) this.$placeholderBitmap, continuation, 13);
            case 14:
                return new RealImageLoader$executeMain$result$1((QrProfileServer) this.$request, (MutableState) this.this$0, (MutableState) this.$size, (MutableState) this.$eventListener, (MutableState) this.$placeholderBitmap, continuation, 14);
            case 15:
                return new RealImageLoader$executeMain$result$1((Context) this.$placeholderBitmap, (UUID) this.$eventListener, continuation);
            case 16:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$10 = new RealImageLoader$executeMain$result$1((TunService) this.$placeholderBitmap, continuation, 16);
                realImageLoader$executeMain$result$10.$eventListener = obj;
                return realImageLoader$executeMain$result$10;
            default:
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$11 = new RealImageLoader$executeMain$result$1((ConfigurationModule) this.$placeholderBitmap, continuation, 17);
                realImageLoader$executeMain$result$11.$eventListener = obj;
                return realImageLoader$executeMain$result$11;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                return ((RealImageLoader$executeMain$result$1) create((ScrollingLogic$nestedScrollScope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 4:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 5:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 6:
                ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 7:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 8:
                ((RealImageLoader$executeMain$result$1) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 9:
                return ((RealImageLoader$executeMain$result$1) create((ProduceStateScopeImpl) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 10:
                return ((RealImageLoader$executeMain$result$1) create((Flow) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 11:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 12:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 13:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 14:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 15:
                return ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 16:
                return ((RealImageLoader$executeMain$result$1) create((ClashRuntimeKt$clashRuntime$1$launch$1$1$scope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                ((RealImageLoader$executeMain$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    /* JADX WARN: Code duplicated, block: B:316:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:319:0x06e0  */
    /* JADX WARN: Code duplicated, block: B:322:0x0716  */
    /* JADX WARN: Code duplicated, block: B:323:0x0745  */
    /* JADX WARN: Code duplicated, block: B:380:0x0889  */
    /* JADX WARN: Code duplicated, block: B:382:0x0891  */
    /* JADX WARN: Code duplicated, block: B:389:0x08a4  */
    /* JADX WARN: Code duplicated, block: B:390:0x08ad  */
    /* JADX WARN: Code duplicated, block: B:392:0x08b3  */
    /* JADX WARN: Code duplicated, block: B:394:0x08bb  */
    /* JADX WARN: Code duplicated, block: B:396:0x08c2  */
    /* JADX WARN: Code duplicated, block: B:398:0x08cc  */
    /* JADX WARN: Code duplicated, block: B:399:0x08ce  */
    /* JADX WARN: Code duplicated, block: B:404:0x08db  */
    /* JADX WARN: Code duplicated, block: B:408:0x08e7  */
    /* JADX WARN: Code duplicated, block: B:410:0x08ef  */
    /* JADX WARN: Code duplicated, block: B:488:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:492:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:493:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:494:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0505: IF  (r5v15 ?? I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) != (r3 I:??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:236:0x050c (LINE:1286), block:B:232:0x0505 */
    /* JADX WARN: Type inference failed for: r2v63, types: [androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0, int] */
    /* JADX WARN: Type inference failed for: r2v90, types: [androidx.lifecycle.Lifecycle] */
    /* JADX WARN: Type inference failed for: r3v27, types: [coil.memory.MemoryCacheService, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r4v36, types: [java.lang.Object, kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.Channel] */
    /* JADX WARN: Type inference failed for: r4v37, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r4v38, types: [java.lang.Object, kotlinx.coroutines.channels.Channel] */
    /* JADX WARN: Type inference failed for: r4v63 */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r4v65 */
    /* JADX WARN: Type inference failed for: r4v66 */
    /* JADX WARN: Type inference failed for: r4v67 */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24, types: [coil.memory.MemoryCacheService] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v29, types: [coil.memory.MemoryCacheService, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v49, types: [androidx.compose.runtime.MutableState] */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v61 */
    /* JADX WARN: Type inference failed for: r5v62 */
    /* JADX WARN: Type inference failed for: r5v63 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x03cf -> B:158:0x03b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:166:0x03e2 -> B:158:0x03b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:319:0x06e0 -> B:320:0x06e2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader$executeMain$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealImageLoader$executeMain$result$1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$request = obj;
        this.this$0 = obj2;
        this.$size = obj3;
        this.$eventListener = obj4;
        this.$placeholderBitmap = obj5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealImageLoader$executeMain$result$1(Object obj, Object obj2, Object obj3, Object obj4, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = obj;
        this.$size = obj2;
        this.$eventListener = obj3;
        this.$placeholderBitmap = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealImageLoader$executeMain$result$1(Object obj, Object obj2, Object obj3, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$size = obj;
        this.$eventListener = obj2;
        this.$placeholderBitmap = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealImageLoader$executeMain$result$1(Object obj, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$placeholderBitmap = obj;
    }
}
