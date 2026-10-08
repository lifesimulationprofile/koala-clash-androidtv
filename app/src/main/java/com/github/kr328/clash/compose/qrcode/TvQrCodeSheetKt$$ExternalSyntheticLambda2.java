package com.github.kr328.clash.compose.qrcode;

import androidx.compose.runtime.MutableState;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.qrserver.QrProfileServer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.json.JsonImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvQrCodeSheetKt$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ TvQrCodeSheetKt$$ExternalSyntheticLambda2(Function0 function0, MutableState mutableState, int i) {
        this.$r8$classId = i;
        this.f$0 = function0;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        MutableState mutableState = this.f$1;
        Function0 function0 = this.f$0;
        switch (i) {
            case 0:
                QrProfileServer qrProfileServer = (QrProfileServer) mutableState.getValue();
                if (qrProfileServer != null) {
                    qrProfileServer.stop();
                }
                function0.invoke();
                break;
            case 1:
                mutableState.setValue(Boolean.FALSE);
                function0.invoke();
                break;
            default:
                JsonImpl jsonImpl = ConnectionsScreenKt.connectionJson;
                if (((String) mutableState.getValue()) != null) {
                    mutableState.setValue(null);
                } else {
                    function0.invoke();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
