package androidx.navigation;

import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavController$executePopOperations$1 extends Lambda implements Function1 {
    public final /* synthetic */ Ref$BooleanRef $popped;
    public final /* synthetic */ Ref$BooleanRef $receivedPop;
    public final /* synthetic */ boolean $saveState;
    public final /* synthetic */ ArrayDeque $savedState;
    public final /* synthetic */ NavHostController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavController$executePopOperations$1(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, NavHostController navHostController, boolean z, ArrayDeque arrayDeque) {
        super(1);
        this.$receivedPop = ref$BooleanRef;
        this.$popped = ref$BooleanRef2;
        this.this$0 = navHostController;
        this.$saveState = z;
        this.$savedState = arrayDeque;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.$receivedPop.element = true;
        this.$popped.element = true;
        boolean z = this.$saveState;
        ArrayDeque arrayDeque = this.$savedState;
        this.this$0.popEntryFromBackStack((NavBackStackEntry) obj, z, arrayDeque);
        return Unit.INSTANCE;
    }
}
