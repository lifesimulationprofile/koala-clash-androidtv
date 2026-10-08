package com.github.kr328.clash.compose.qrcode;

import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ NewProfileViewModel $profileViewModel;
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1(NewProfileViewModel newProfileViewModel, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$profileViewModel = newProfileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 = new TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1(this.$profileViewModel, continuation, 0);
                tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1.L$0 = obj;
                return tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1;
            default:
                TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1 tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$2 = new TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1(this.$profileViewModel, continuation, 1);
                tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$2.L$0 = obj;
                return tvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1) create((String) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1) create((byte[]) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                String str = (String) this.L$0;
                NewProfileViewModel newProfileViewModel = this.$profileViewModel;
                newProfileViewModel.setLink(str);
                this.label = 1;
                Object objCreateAndActivateAwait = newProfileViewModel.createAndActivateAwait(this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objCreateAndActivateAwait == coroutineSingletons ? coroutineSingletons : objCreateAndActivateAwait;
            default:
                int i2 = this.label;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                byte[] bArr = (byte[]) this.L$0;
                this.label = 1;
                Object objImportFromContentAwait = this.$profileViewModel.importFromContentAwait(bArr, this);
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objImportFromContentAwait == coroutineSingletons2 ? coroutineSingletons2 : objImportFromContentAwait;
        }
    }
}
