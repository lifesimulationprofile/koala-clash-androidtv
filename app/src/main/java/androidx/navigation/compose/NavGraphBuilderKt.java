package androidx.navigation.compose;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavigatorProvider;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavGraphBuilderKt {
    public static void composable$default(NavGraphBuilder navGraphBuilder, String str, ComposableLambdaImpl composableLambdaImpl) {
        NavigatorProvider navigatorProvider = navGraphBuilder.provider;
        navigatorProvider.getClass();
        navGraphBuilder.destinations.add(new ComposeNavigatorDestinationBuilder((ComposeNavigator) navigatorProvider.getNavigator(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(ComposeNavigator.class)), str, composableLambdaImpl).build());
    }
}
