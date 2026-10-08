package androidx.compose.ui.window;

import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPopup_androidKt$Popup$7$1 extends Lambda implements Function1 {
    public final /* synthetic */ PopupLayout $popupLayout;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidPopup_androidKt$Popup$7$1(PopupLayout popupLayout, int i) {
        super(1);
        this.$r8$classId = i;
        this.$popupLayout = popupLayout;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                this.$popupLayout.updateParentLayoutCoordinates(((LayoutCoordinates) obj).getParentLayoutCoordinates());
                break;
            case 1:
                IntSize intSize = new IntSize(((IntSize) obj).packedValue);
                PopupLayout popupLayout = this.$popupLayout;
                popupLayout.m741setPopupContentSizefhxjrPA(intSize);
                popupLayout.updatePosition();
                break;
            default:
                Function0 function0 = (Function0) obj;
                PopupLayout popupLayout2 = this.$popupLayout;
                Handler handler = popupLayout2.getHandler();
                if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                    function0.invoke();
                } else {
                    Handler handler2 = popupLayout2.getHandler();
                    if (handler2 != null) {
                        handler2.post(new AndroidComposeView$$ExternalSyntheticLambda2(3, function0));
                    }
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
