package androidx.compose.ui.layout;

import androidx.compose.runtime.GapComposer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$SubcomposeLayoutKt$lambda$641200809$1 extends Lambda implements Function2 {
    public static final ComposableSingletons$SubcomposeLayoutKt$lambda$641200809$1 INSTANCE = new ComposableSingletons$SubcomposeLayoutKt$lambda$641200809$1(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
