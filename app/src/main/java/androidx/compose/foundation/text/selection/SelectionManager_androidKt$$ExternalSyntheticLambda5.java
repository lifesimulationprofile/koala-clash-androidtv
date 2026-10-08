package androidx.compose.foundation.text.selection;

import android.os.Build;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda4;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionManager_androidKt$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Density f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ SelectionManager_androidKt$$ExternalSyntheticLambda5(Density density, MutableState mutableState, int i) {
        this.$r8$classId = i;
        this.f$0 = density;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                AppBarKt$$ExternalSyntheticLambda4 appBarKt$$ExternalSyntheticLambda4 = new AppBarKt$$ExternalSyntheticLambda4(1, (Function0) obj);
                SelectionManager_androidKt$$ExternalSyntheticLambda5 selectionManager_androidKt$$ExternalSyntheticLambda5 = new SelectionManager_androidKt$$ExternalSyntheticLambda5(this.f$0, this.f$1, 1);
                if (Magnifier_androidKt.isPlatformMagnifierSupported$default()) {
                    return Magnifier_androidKt.m56magnifierjPUL71Q$default(appBarKt$$ExternalSyntheticLambda4, selectionManager_androidKt$$ExternalSyntheticLambda5, Build.VERSION.SDK_INT == 28 ? PlatformMagnifierFactoryApi28Impl.INSTANCE : PlatformMagnifierFactoryApi28Impl.INSTANCE$1);
                }
                throw new UnsupportedOperationException("Magnifier is only supported on API level 28 and higher.");
            case 1:
                DpSize dpSize = (DpSize) obj;
                float fM711getWidthD9Ej5fM = DpSize.m711getWidthD9Ej5fM(dpSize.packedValue);
                Density density = this.f$0;
                this.f$1.setValue(new IntSize((((long) density.mo86roundToPx0680j_4(fM711getWidthD9Ej5fM)) << 32) | (((long) density.mo86roundToPx0680j_4(DpSize.m710getHeightD9Ej5fM(dpSize.packedValue))) & 4294967295L)));
                return Unit.INSTANCE;
            case 2:
                DpSize dpSize2 = (DpSize) obj;
                float fM711getWidthD9Ej5fM2 = DpSize.m711getWidthD9Ej5fM(dpSize2.packedValue);
                Density density2 = this.f$0;
                this.f$1.setValue(new IntSize((((long) density2.mo86roundToPx0680j_4(fM711getWidthD9Ej5fM2)) << 32) | (((long) density2.mo86roundToPx0680j_4(DpSize.m710getHeightD9Ej5fM(dpSize2.packedValue))) & 4294967295L)));
                return Unit.INSTANCE;
            default:
                AppBarKt$$ExternalSyntheticLambda4 appBarKt$$ExternalSyntheticLambda5 = new AppBarKt$$ExternalSyntheticLambda4(2, (Function0) obj);
                SelectionManager_androidKt$$ExternalSyntheticLambda5 selectionManager_androidKt$$ExternalSyntheticLambda6 = new SelectionManager_androidKt$$ExternalSyntheticLambda5(this.f$0, this.f$1, 2);
                if (Magnifier_androidKt.isPlatformMagnifierSupported$default()) {
                    return Magnifier_androidKt.m56magnifierjPUL71Q$default(appBarKt$$ExternalSyntheticLambda5, selectionManager_androidKt$$ExternalSyntheticLambda6, Build.VERSION.SDK_INT == 28 ? PlatformMagnifierFactoryApi28Impl.INSTANCE : PlatformMagnifierFactoryApi28Impl.INSTANCE$1);
                }
                throw new UnsupportedOperationException("Magnifier is only supported on API level 28 and higher.");
        }
    }
}
