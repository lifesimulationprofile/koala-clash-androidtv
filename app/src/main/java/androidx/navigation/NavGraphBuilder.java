package androidx.navigation;

import androidx.collection.SparseArrayCompat;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavGraphBuilder extends NavDestinationBuilder {
    public final ArrayList destinations;
    public final NavigatorProvider provider;
    public final String startDestinationRoute;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphBuilder(NavigatorProvider navigatorProvider) {
        super(navigatorProvider.getNavigator(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(NavGraphNavigator.class)), null);
        navigatorProvider.getClass();
        this.destinations = new ArrayList();
        this.provider = navigatorProvider;
        this.startDestinationRoute = "home";
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final NavGraph build() {
        int iHashCode;
        NavGraph navGraph = (NavGraph) super.build();
        ArrayList arrayList = this.destinations;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            NavDestination navDestination = (NavDestination) obj;
            if (navDestination != null) {
                SparseArrayCompat sparseArrayCompat = navGraph.nodes;
                int i2 = navDestination.id;
                String str = navDestination.route;
                if (i2 == 0 && str == null) {
                    throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
                }
                String str2 = navGraph.route;
                if (str2 != null && Intrinsics.areEqual(str, str2)) {
                    throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same route as graph " + navGraph).toString());
                }
                if (i2 == navGraph.id) {
                    throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same id as graph " + navGraph).toString());
                }
                NavDestination navDestination2 = (NavDestination) sparseArrayCompat.get(i2);
                if (navDestination2 == navDestination) {
                    continue;
                } else {
                    if (navDestination.parent != null) {
                        throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
                    }
                    if (navDestination2 != null) {
                        navDestination2.parent = null;
                    }
                    navDestination.parent = navGraph;
                    sparseArrayCompat.put(navDestination.id, navDestination);
                }
            }
        }
        String str3 = this.startDestinationRoute;
        if (str3 == null) {
            if (this.route != null) {
                throw new IllegalStateException("You must set a start destination route");
            }
            throw new IllegalStateException("You must set a start destination id");
        }
        if (str3 == null) {
            iHashCode = 0;
        } else {
            if (str3.equals(navGraph.route)) {
                throw new IllegalArgumentException(("Start destination " + str3 + " cannot use the same route as the graph " + navGraph).toString());
            }
            if (StringsKt.isBlank(str3)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route");
            }
            iHashCode = "android-app://androidx.navigation/".concat(str3).hashCode();
        }
        navGraph.startDestId = iHashCode;
        navGraph.startDestinationRoute = str3;
        return navGraph;
    }
}
