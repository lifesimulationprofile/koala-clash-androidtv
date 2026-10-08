package androidx.navigation;

import android.os.Bundle;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.network.EmptyNetworkObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("navigation")
public class NavGraphNavigator extends Navigator {
    public final NavigatorProvider navigatorProvider;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        this.navigatorProvider = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List list, NavOptions navOptions) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
            NavGraph navGraph = (NavGraph) navBackStackEntry.destination;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = navBackStackEntry.getArguments();
            int i = navGraph.startDestId;
            String str = navGraph.startDestinationRoute;
            if (i == 0 && str == null) {
                StringBuilder sb = new StringBuilder("no start destination defined via app:startDestination for ");
                int i2 = navGraph.id;
                sb.append(i2 != 0 ? String.valueOf(i2) : "the root navigation");
                throw new IllegalStateException(sb.toString().toString());
            }
            NavDestination navDestinationFindNode = str != null ? navGraph.findNode(str, false) : (NavDestination) navGraph.nodes.get(i);
            if (navDestinationFindNode == null) {
                if (navGraph.startDestIdName == null) {
                    String strValueOf = navGraph.startDestinationRoute;
                    if (strValueOf == null) {
                        strValueOf = String.valueOf(navGraph.startDestId);
                    }
                    navGraph.startDestIdName = strValueOf;
                }
                throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("navigation destination ", navGraph.startDestIdName, " is not a direct child of this NavGraph"));
            }
            LinkedHashMap linkedHashMap = navDestinationFindNode._arguments;
            if (str != null) {
                if (!str.equals(navDestinationFindNode.route)) {
                    NavDestination.DeepLinkMatch deepLinkMatchMatchRoute = navDestinationFindNode.matchRoute(str);
                    Bundle bundle = deepLinkMatchMatchRoute != null ? deepLinkMatchMatchRoute.matchingArgs : null;
                    if (bundle != null && !bundle.isEmpty()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putAll(bundle);
                        Bundle bundle3 = (Bundle) ref$ObjectRef.element;
                        if (bundle3 != null) {
                            bundle2.putAll(bundle3);
                        }
                        ref$ObjectRef.element = bundle2;
                    }
                }
                if (MapsKt__MapsKt.toMap(linkedHashMap).isEmpty()) {
                    continue;
                } else {
                    ArrayList arrayListMissingRequiredArguments = NavArgumentKt.missingRequiredArguments(MapsKt__MapsKt.toMap(linkedHashMap), new NavGraphNavigator$navigate$missingRequiredArgs$1(ref$ObjectRef, 0));
                    if (!arrayListMissingRequiredArguments.isEmpty()) {
                        throw new IllegalArgumentException(("Cannot navigate to startDestination " + navDestinationFindNode + ". Missing required arguments [" + arrayListMissingRequiredArguments + ']').toString());
                    }
                }
            }
            Navigator navigator = this.navigatorProvider.getNavigator(navDestinationFindNode.navigatorName);
            NavController$NavControllerNavigatorState state = getState();
            Bundle bundleAddInDefaultArgs = navDestinationFindNode.addInDefaultArgs((Bundle) ref$ObjectRef.element);
            NavHostController navHostController = state.this$0;
            navigator.navigate(Collections.singletonList(EmptyNetworkObserver.create$default(navHostController.context, navDestinationFindNode, bundleAddInDefaultArgs, navHostController.getHostLifecycleState$navigation_runtime_release(), navHostController.viewModel)), navOptions);
        }
    }

    @Override // androidx.navigation.Navigator
    public NavGraph createDestination() {
        return new NavGraph(this);
    }
}
