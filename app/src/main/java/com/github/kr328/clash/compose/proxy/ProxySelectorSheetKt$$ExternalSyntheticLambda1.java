package com.github.kr328.clash.compose.proxy;

import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.BottomSheetKt$BottomSheetImpl$6$1$1$1$1;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.MutableState;
import com.github.kr328.clash.qrserver.QrProfileServer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProxySelectorSheetKt$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ SheetState f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ ProxySelectorSheetKt$$ExternalSyntheticLambda1(CoroutineScope coroutineScope, MutableState mutableState, SheetState sheetState, Function0 function0, int i) {
        this.$r8$classId = i;
        this.f$0 = coroutineScope;
        this.f$1 = mutableState;
        this.f$2 = sheetState;
        this.f$3 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                this.f$1.setValue(Boolean.TRUE);
                SheetState sheetState = this.f$2;
                JobKt.launch$default(this.f$0, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 12), 3).invokeOnCompletion(new BottomSheetKt$$ExternalSyntheticLambda3(sheetState, this.f$3, 3));
                break;
            default:
                QrProfileServer qrProfileServer = (QrProfileServer) this.f$1.getValue();
                if (qrProfileServer != null) {
                    qrProfileServer.stop();
                }
                SheetState sheetState2 = this.f$2;
                JobKt.launch$default(this.f$0, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState2, null, 13), 3).invokeOnCompletion(new BottomSheetKt$$ExternalSyntheticLambda3(sheetState2, this.f$3, 4));
                break;
        }
        return Unit.INSTANCE;
    }
}
