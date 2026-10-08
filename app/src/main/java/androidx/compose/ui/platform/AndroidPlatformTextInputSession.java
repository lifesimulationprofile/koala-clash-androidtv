package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.ui.text.input.TextInputService;
import androidx.navigation.NavController$handleDeepLink$2;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.RealImageLoader$execute$3;
import coil.network.HttpException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPlatformTextInputSession implements CoroutineScope {
    public final CoroutineScope coroutineScope;
    public final AtomicReference methodSessionMutex = new AtomicReference(null);
    public final TextInputService textInputService;
    public final View view;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidPlatformTextInputSession$startInputMethod$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            AndroidPlatformTextInputSession.this.startInputMethod(null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    public AndroidPlatformTextInputSession(View view, TextInputService textInputService, CoroutineScope coroutineScope) {
        this.view = view;
        this.textInputService = textInputService;
        this.coroutineScope = coroutineScope;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineScope.getCoroutineContext();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final void startInputMethod(LegacyTextInputMethodRequest legacyTextInputMethodRequest, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
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
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            NavController$handleDeepLink$2 navController$handleDeepLink$2 = new NavController$handleDeepLink$2(5, legacyTextInputMethodRequest, this);
            RealImageLoader$execute$3 realImageLoader$execute$3 = new RealImageLoader$execute$3(this, (Continuation) null, 22);
            anonymousClass1.label = 1;
            if (JobKt.coroutineScope(new NavHostKt$NavHost$29$1(navController$handleDeepLink$2, this.methodSessionMutex, realImageLoader$execute$3, (Continuation) null), anonymousClass1) == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new HttpException();
    }
}
