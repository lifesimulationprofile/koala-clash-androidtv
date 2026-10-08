package com.github.kr328.clash.compose.qrcode;

import android.graphics.Bitmap;
import androidx.compose.runtime.MutableState;
import com.github.kr328.clash.qrserver.QrProfileServer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TvQrCodeSheetKt$TvQrCodeSheet$3$1$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Bitmap $bitmap;
    public final /* synthetic */ QrProfileServer $profileServer;
    public final /* synthetic */ MutableState $qrBitmap$delegate;
    public final /* synthetic */ MutableState $serverRef$delegate;
    public final /* synthetic */ MutableState $serverState$delegate;
    public final /* synthetic */ MutableState $serverUrl$delegate;
    public final /* synthetic */ String $url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TvQrCodeSheetKt$TvQrCodeSheet$3$1$1$2(QrProfileServer qrProfileServer, String str, Bitmap bitmap, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Continuation continuation) {
        super(2, continuation);
        this.$profileServer = qrProfileServer;
        this.$url = str;
        this.$bitmap = bitmap;
        this.$serverRef$delegate = mutableState;
        this.$serverUrl$delegate = mutableState2;
        this.$qrBitmap$delegate = mutableState3;
        this.$serverState$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TvQrCodeSheetKt$TvQrCodeSheet$3$1$1$2(this.$profileServer, this.$url, this.$bitmap, this.$serverRef$delegate, this.$serverUrl$delegate, this.$qrBitmap$delegate, this.$serverState$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TvQrCodeSheetKt$TvQrCodeSheet$3$1$1$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        this.$serverRef$delegate.setValue(this.$profileServer);
        this.$serverUrl$delegate.setValue(this.$url);
        this.$qrBitmap$delegate.setValue(this.$bitmap);
        this.$serverState$delegate.setValue(QrServerState.Ready);
        return Unit.INSTANCE;
    }
}
