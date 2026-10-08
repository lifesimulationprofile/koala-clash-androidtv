package androidx.compose.foundation.lazy;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyListItemProviderImpl$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ LazyListItemProviderImpl f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ LazyListItemProviderImpl$$ExternalSyntheticLambda1(int i, LazyListItemProviderImpl lazyListItemProviderImpl, Object obj) {
        this.f$0 = lazyListItemProviderImpl;
        this.f$1 = i;
        this.f$2 = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        GapComposer gapComposer = (GapComposer) obj;
        Integer num = (Integer) obj2;
        switch (this.$r8$classId) {
            case 0:
                num.getClass();
                this.f$0.Item(this.f$1, this.f$2, gapComposer, Stack.updateChangedFlags(1));
                break;
            default:
                int iIntValue = num.intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    this.f$0.Item(this.f$1, this.f$2, gapComposer, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ LazyListItemProviderImpl$$ExternalSyntheticLambda1(LazyListItemProviderImpl lazyListItemProviderImpl, int i, Object obj, int i2) {
        this.f$0 = lazyListItemProviderImpl;
        this.f$1 = i;
        this.f$2 = obj;
    }
}
