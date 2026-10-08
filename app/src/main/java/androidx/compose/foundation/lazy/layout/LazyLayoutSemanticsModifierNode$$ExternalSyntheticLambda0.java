package androidx.compose.foundation.lazy.layout;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LazyLayoutSemanticsModifierNode f$0;

    public /* synthetic */ LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda0(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, int i) {
        this.$r8$classId = i;
        this.f$0 = lazyLayoutSemanticsModifierNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) this.f$0.itemProviderLambda.invoke();
                int itemCount = lazyListItemProviderImpl.getItemCount();
                int i = 0;
                while (i < itemCount) {
                    if (lazyListItemProviderImpl.getKey(i).equals(obj)) {
                        return Integer.valueOf(i);
                    }
                    i++;
                }
                i = -1;
                return Integer.valueOf(i);
            default:
                int iIntValue = ((Integer) obj).intValue();
                LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode = this.f$0;
                LazyListItemProviderImpl lazyListItemProviderImpl2 = (LazyListItemProviderImpl) lazyLayoutSemanticsModifierNode.itemProviderLambda.invoke();
                if (iIntValue < 0 || iIntValue >= lazyListItemProviderImpl2.getItemCount()) {
                    StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(iIntValue, "Can't scroll to index ", ", it is out of bounds [0, ");
                    sbM.append(lazyListItemProviderImpl2.getItemCount());
                    sbM.append(')');
                    InlineClassHelperKt.throwIllegalArgumentException(sbM.toString());
                }
                JobKt.launch$default(lazyLayoutSemanticsModifierNode.getCoroutineScope(), null, new LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2(lazyLayoutSemanticsModifierNode, iIntValue, null), 3);
                return Boolean.TRUE;
        }
    }
}
