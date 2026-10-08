package androidx.compose.foundation.style;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$2;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableStyleState$processInteractions$2$emit$1 extends ContinuationImpl {
    public Interaction L$0;
    public MutableStyleState L$1;
    public Iterator L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CoreTextFieldKt$CoreTextField$5$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableStyleState$processInteractions$2$emit$1(CoreTextFieldKt$CoreTextField$5$1$2 coreTextFieldKt$CoreTextField$5$1$2, Continuation continuation) {
        super(continuation);
        this.this$0 = coreTextFieldKt$CoreTextField$5$1$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Interaction) null, (Continuation) this);
    }
}
