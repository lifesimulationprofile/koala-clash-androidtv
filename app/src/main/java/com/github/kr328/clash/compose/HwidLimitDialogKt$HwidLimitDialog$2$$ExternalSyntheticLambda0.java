package com.github.kr328.clash.compose;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.material3.SnackbarHostState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ CoroutineScope f$2;
    public final /* synthetic */ Function0 f$3;
    public final /* synthetic */ SnackbarHostState f$4;

    public /* synthetic */ HwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0(String str, Context context, CoroutineScope coroutineScope, Function0 function0, SnackbarHostState snackbarHostState) {
        this.f$0 = str;
        this.f$1 = context;
        this.f$2 = coroutineScope;
        this.f$3 = function0;
        this.f$4 = snackbarHostState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                Context context = this.f$1;
                String str = this.f$0;
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
                } catch (ActivityNotFoundException unused) {
                    JobKt.launch$default(this.f$2, null, new HwidLimitDialogKt$HwidLimitDialog$2$1$1$2(this.f$4, str, null, 0), 3);
                }
                this.f$3.invoke();
                break;
            default:
                Context context2 = this.f$1;
                this.f$3.invoke();
                String str2 = this.f$0;
                try {
                    context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)).addFlags(268435456));
                } catch (ActivityNotFoundException unused2) {
                    JobKt.launch$default(this.f$2, null, new HwidLimitDialogKt$HwidLimitDialog$2$1$1$2(this.f$4, str2, null, 1), 3);
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ HwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0(Function0 function0, String str, Context context, CoroutineScope coroutineScope, SnackbarHostState snackbarHostState) {
        this.f$3 = function0;
        this.f$0 = str;
        this.f$1 = context;
        this.f$2 = coroutineScope;
        this.f$4 = snackbarHostState;
    }
}
