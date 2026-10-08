package androidx.compose.ui.graphics.layer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayer$drawBlock$1 extends Lambda implements Function1 {
    public static final GraphicsLayer$drawBlock$1 INSTANCE;
    public static final GraphicsLayer$drawBlock$1 INSTANCE$1;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 1;
        INSTANCE = new GraphicsLayer$drawBlock$1(i, 0);
        INSTANCE$1 = new GraphicsLayer$drawBlock$1(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GraphicsLayer$drawBlock$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                break;
            default:
                Modifier.CC.m315drawRectnJ9OG0$default((DrawScope) obj, Color.Transparent, 0L, 0.0f, 0, 126);
                break;
        }
        return Unit.INSTANCE;
    }
}
