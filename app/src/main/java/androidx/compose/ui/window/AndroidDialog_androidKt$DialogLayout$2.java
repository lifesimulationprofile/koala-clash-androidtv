package androidx.compose.ui.window;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.navigation.compose.NavBackStackEntryProviderKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidDialog_androidKt$DialogLayout$2 extends Lambda implements Function2 {
    public final /* synthetic */ int $$changed;
    public final /* synthetic */ Function2 $content;
    public final /* synthetic */ Object $modifier;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidDialog_androidKt$DialogLayout$2(int i, int i2, Object obj, Function2 function2) {
        super(2);
        this.$r8$classId = i2;
        this.$modifier = obj;
        this.$content = function2;
        this.$$changed = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        GapComposer gapComposer = (GapComposer) obj;
        ((Number) obj2).intValue();
        switch (i) {
            case 0:
                AndroidDialog_androidKt.access$DialogLayout((Modifier) this.$modifier, this.$content, gapComposer, Stack.updateChangedFlags(this.$$changed | 1));
                break;
            default:
                NavBackStackEntryProviderKt.access$SaveableStateProvider((SaveableStateHolder) this.$modifier, (ComposableLambdaImpl) this.$content, gapComposer, Stack.updateChangedFlags(this.$$changed | 1));
                break;
        }
        return Unit.INSTANCE;
    }
}
