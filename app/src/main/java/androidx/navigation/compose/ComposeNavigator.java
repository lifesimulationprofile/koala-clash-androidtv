package androidx.navigation.compose;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController$NavControllerNavigatorState;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("composable")
public final class ComposeNavigator extends Navigator {
    public final ParcelableSnapshotMutableState isPop = Stack.mutableStateOf$default(Boolean.FALSE);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Destination extends NavDestination {
        public final Function4 content;

        public Destination(ComposeNavigator composeNavigator, ComposableLambdaImpl composableLambdaImpl) {
            super(composeNavigator);
            this.content = composableLambdaImpl;
        }
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination createDestination() {
        return new Destination(this, ComposableSingletons$ComposeNavigatorKt.f11lambda1);
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List list, NavOptions navOptions) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
            NavController$NavControllerNavigatorState state = getState();
            ReadonlyStateFlow readonlyStateFlow = state.backStack;
            StateFlowImpl stateFlowImpl = state._transitionsInProgress;
            Iterable iterable = (Iterable) stateFlowImpl.getValue();
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it2 = iterable.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((NavBackStackEntry) it2.next()) == navBackStackEntry) {
                            Iterable iterable2 = (Iterable) readonlyStateFlow.$$delegate_0.getValue();
                            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                                Iterator it3 = iterable2.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        if (((NavBackStackEntry) it3.next()) == navBackStackEntry) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.lastOrNull((List) readonlyStateFlow.$$delegate_0.getValue());
            if (navBackStackEntry2 != null) {
                stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry2));
            }
            stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry));
            state.push(navBackStackEntry);
        }
        this.isPop.setValue(Boolean.FALSE);
    }

    @Override // androidx.navigation.Navigator
    public final void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        getState().popWithTransition(navBackStackEntry, z);
        this.isPop.setValue(Boolean.TRUE);
    }

    public final void prepareForTransition(NavBackStackEntry navBackStackEntry) {
        NavController$NavControllerNavigatorState state = getState();
        StateFlowImpl stateFlowImpl = state._transitionsInProgress;
        stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry));
        if (!state.this$0.backQueue.contains(navBackStackEntry)) {
            throw new IllegalStateException("Cannot transition entry that is not in the back stack");
        }
        navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
    }
}
