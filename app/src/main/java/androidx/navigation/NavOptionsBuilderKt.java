package androidx.navigation;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavOptionsBuilderKt {
    public static final NavOptions navOptions(Function1 function1) {
        NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
        function1.invoke(navOptionsBuilder);
        boolean z = navOptionsBuilder.launchSingleTop;
        boolean z2 = navOptionsBuilder.restoreState;
        int i = navOptionsBuilder.popUpToId;
        boolean z3 = navOptionsBuilder.saveState;
        NavOptions.Builder builder = navOptionsBuilder.builder;
        return new NavOptions(z, z2, i, false, z3, builder.enterAnim, builder.exitAnim);
    }
}
