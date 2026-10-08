package io.github.g00fy2.quickie;

import android.view.View;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import kotlin.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QROverlayView$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function f$0;

    public /* synthetic */ QROverlayView$$ExternalSyntheticLambda0(Function function, int i) {
        this.$r8$classId = i;
        this.f$0 = function;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Exception {
        int i = this.$r8$classId;
        Function function = this.f$0;
        switch (i) {
            case 0:
                int i2 = QROverlayView.$r8$clinit;
                ((Function1) function).invoke(Boolean.valueOf(!view.isSelected()));
                break;
            default:
                int i3 = QROverlayView.$r8$clinit;
                ((BitmapFactoryDecoder$$ExternalSyntheticLambda2) function).invoke();
                break;
        }
    }
}
