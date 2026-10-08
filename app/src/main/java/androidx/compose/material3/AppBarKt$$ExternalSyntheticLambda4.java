package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppBarKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ AppBarKt$$ExternalSyntheticLambda4(int i, Function0 function0) {
        this.$r8$classId = i;
        this.f$0 = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((ReusableGraphicsLayerScope) obj).setAlpha(((Number) this.f$0.invoke()).floatValue());
                return Unit.INSTANCE;
            case 1:
                return (Offset) this.f$0.invoke();
            case 2:
                return (Offset) this.f$0.invoke();
            case 3:
                this.f$0.invoke();
                return Unit.INSTANCE;
            case 4:
                this.f$0.invoke();
                return Unit.INSTANCE;
            default:
                ((Boolean) obj).booleanValue();
                this.f$0.invoke();
                return Unit.INSTANCE;
        }
    }
}
