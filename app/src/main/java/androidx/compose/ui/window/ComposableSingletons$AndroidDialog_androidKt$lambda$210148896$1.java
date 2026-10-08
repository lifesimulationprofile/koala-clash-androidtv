package androidx.compose.ui.window;

import androidx.compose.runtime.GapComposer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$AndroidDialog_androidKt$lambda$210148896$1 extends Lambda implements Function2 {
    public static final ComposableSingletons$AndroidDialog_androidKt$lambda$210148896$1 INSTANCE;
    public static final ComposableSingletons$AndroidDialog_androidKt$lambda$210148896$1 INSTANCE$1;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 2;
        INSTANCE = new ComposableSingletons$AndroidDialog_androidKt$lambda$210148896$1(i, 0);
        INSTANCE$1 = new ComposableSingletons$AndroidDialog_androidKt$lambda$210148896$1(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComposableSingletons$AndroidDialog_androidKt$lambda$210148896$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                GapComposer gapComposer2 = (GapComposer) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
