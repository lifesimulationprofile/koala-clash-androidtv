package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import com.github.kr328.clash.core.model.ProxyGroup;
import java.util.Set;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScaffoldKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Function f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;

    public /* synthetic */ ScaffoldKt$$ExternalSyntheticLambda1(int i, Function2 function2, ComposableLambdaImpl composableLambdaImpl, Function2 function3, Function2 function4, WindowInsets windowInsets, Function2 function5, int i2) {
        this.f$0 = i;
        this.f$1 = function2;
        this.f$2 = composableLambdaImpl;
        this.f$3 = function3;
        this.f$4 = function4;
        this.f$5 = windowInsets;
        this.f$6 = function5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Function2 function2 = (Function2) this.f$1;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$2;
                Function2 function3 = (Function2) this.f$3;
                Function2 function4 = (Function2) this.f$4;
                MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) this.f$5;
                Function2 function5 = (Function2) this.f$6;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    ScaffoldKt.m262ScaffoldLayoutFMILGgc(this.f$0, function2, composableLambdaImpl, function3, function4, mutableWindowInsets, function5, gapComposer, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                ScaffoldKt.m262ScaffoldLayoutFMILGgc(this.f$0, (Function2) this.f$1, (ComposableLambdaImpl) this.f$2, (Function2) this.f$3, (Function2) this.f$4, (WindowInsets) this.f$5, (Function2) this.f$6, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                ((ComposableLambdaImpl) this.f$2).invoke(this.f$1, (Boolean) this.f$3, this.f$4, this.f$6, this.f$5, (GapComposer) obj, Stack.updateChangedFlags(this.f$0) | 1);
                break;
            default:
                ((Integer) obj2).getClass();
                ProxyScreenKt.ProxyServersList((ProxyGroup) this.f$1, (Set) this.f$3, (Set) this.f$4, (Function1) this.f$6, (Function1) this.f$2, (Modifier) this.f$5, (GapComposer) obj, Stack.updateChangedFlags(this.f$0 | 1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ScaffoldKt$$ExternalSyntheticLambda1(int i, Function2 function2, ComposableLambdaImpl composableLambdaImpl, Function2 function3, Function2 function4, MutableWindowInsets mutableWindowInsets, Function2 function5) {
        this.f$0 = i;
        this.f$1 = function2;
        this.f$2 = composableLambdaImpl;
        this.f$3 = function3;
        this.f$4 = function4;
        this.f$5 = mutableWindowInsets;
        this.f$6 = function5;
    }

    public /* synthetic */ ScaffoldKt$$ExternalSyntheticLambda1(ComposableLambdaImpl composableLambdaImpl, Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, int i) {
        this.f$2 = composableLambdaImpl;
        this.f$1 = obj;
        this.f$3 = bool;
        this.f$4 = obj2;
        this.f$6 = obj3;
        this.f$5 = obj4;
        this.f$0 = i;
    }

    public /* synthetic */ ScaffoldKt$$ExternalSyntheticLambda1(ProxyGroup proxyGroup, Set set, Set set2, Function1 function1, Function1 function2, Modifier modifier, int i) {
        this.f$1 = proxyGroup;
        this.f$3 = set;
        this.f$4 = set2;
        this.f$6 = function1;
        this.f$2 = function2;
        this.f$5 = modifier;
        this.f$0 = i;
    }
}
