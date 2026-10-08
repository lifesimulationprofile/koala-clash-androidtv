package androidx.navigation;

import android.util.Log;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavController$NavControllerNavigatorState {
    public final StateFlowImpl _backStack;
    public final StateFlowImpl _transitionsInProgress;
    public final ReadonlyStateFlow backStack;
    public final ReentrantLock backStackLock = new ReentrantLock(true);
    public boolean isNavigating;
    public final Navigator navigator;
    public final /* synthetic */ NavHostController this$0;
    public final ReadonlyStateFlow transitionsInProgress;

    public NavController$NavControllerNavigatorState(NavHostController navHostController, Navigator navigator) {
        this.this$0 = navHostController;
        StateFlowImpl stateFlowImplMutableStateFlow = FlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this._backStack = stateFlowImplMutableStateFlow;
        StateFlowImpl stateFlowImplMutableStateFlow2 = FlowKt.MutableStateFlow(EmptySet.INSTANCE);
        this._transitionsInProgress = stateFlowImplMutableStateFlow2;
        this.backStack = FlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        this.transitionsInProgress = FlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        this.navigator = navigator;
    }

    public final void addInternal(NavBackStackEntry navBackStackEntry) {
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            StateFlowImpl stateFlowImpl = this._backStack;
            ArrayList arrayListPlus = CollectionsKt.plus((Collection) stateFlowImpl.getValue(), navBackStackEntry);
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, arrayListPlus);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void markTransitionComplete(NavBackStackEntry navBackStackEntry) {
        NavControllerViewModel navControllerViewModel;
        ViewModelStore viewModelStore;
        String str = navBackStackEntry.id;
        NavHostController navHostController = this.this$0;
        LinkedHashMap linkedHashMap = navHostController.entrySavedState;
        StateFlowImpl stateFlowImpl = navHostController._visibleEntries;
        boolean zAreEqual = Intrinsics.areEqual(linkedHashMap.get(navBackStackEntry), Boolean.TRUE);
        StateFlowImpl stateFlowImpl2 = this._transitionsInProgress;
        stateFlowImpl2.updateState(null, SetsKt.minus((Set) stateFlowImpl2.getValue(), navBackStackEntry));
        navHostController.entrySavedState.remove(navBackStackEntry);
        ArrayDeque arrayDeque = navHostController.backQueue;
        if (arrayDeque.contains(navBackStackEntry)) {
            if (this.isNavigating) {
                return;
            }
            navHostController.updateBackStackLifecycle$navigation_runtime_release();
            StateFlowImpl stateFlowImpl3 = navHostController._currentBackStack;
            ArrayList arrayList = new ArrayList(arrayDeque);
            stateFlowImpl3.getClass();
            stateFlowImpl3.updateState(null, arrayList);
            ArrayList arrayListPopulateVisibleEntries$navigation_runtime_release = navHostController.populateVisibleEntries$navigation_runtime_release();
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, arrayListPopulateVisibleEntries$navigation_runtime_release);
            return;
        }
        navHostController.unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
        if (navBackStackEntry._lifecycle.state.isAtLeast(Lifecycle.State.CREATED)) {
            navBackStackEntry.setMaxLifecycle(Lifecycle.State.DESTROYED);
        }
        if (arrayDeque == null || !arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((NavBackStackEntry) it.next()).id, str)) {
                }
            }
            if (!zAreEqual && (navControllerViewModel = navHostController.viewModel) != null && (viewModelStore = (ViewModelStore) navControllerViewModel.viewModelStores.remove(str)) != null) {
                viewModelStore.clear();
            }
        } else if (!zAreEqual) {
            viewModelStore.clear();
        }
        navHostController.updateBackStackLifecycle$navigation_runtime_release();
        ArrayList arrayListPopulateVisibleEntries$navigation_runtime_release2 = navHostController.populateVisibleEntries$navigation_runtime_release();
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, arrayListPopulateVisibleEntries$navigation_runtime_release2);
    }

    public final void pop(NavBackStackEntry navBackStackEntry, boolean z) {
        NavHostController navHostController = this.this$0;
        Navigator navigator = navHostController._navigatorProvider.getNavigator(navBackStackEntry.destination.navigatorName);
        navHostController.entrySavedState.put(navBackStackEntry, Boolean.valueOf(z));
        if (!navigator.equals(this.navigator)) {
            ((NavController$NavControllerNavigatorState) navHostController.navigatorState.get(navigator)).pop(navBackStackEntry, z);
            return;
        }
        NavController$executePopOperations$1 navController$executePopOperations$1 = navHostController.popFromBackStackHandler;
        if (navController$executePopOperations$1 != null) {
            navController$executePopOperations$1.invoke(navBackStackEntry);
            pop$androidx$navigation$NavigatorState(navBackStackEntry);
            return;
        }
        ArrayDeque arrayDeque = navHostController.backQueue;
        int iIndexOf = arrayDeque.indexOf(navBackStackEntry);
        if (iIndexOf < 0) {
            Log.i("NavController", "Ignoring pop of " + navBackStackEntry + " as it was not found on the current back stack");
            return;
        }
        int i = iIndexOf + 1;
        if (i != arrayDeque.size) {
            navHostController.popBackStackInternal(((NavBackStackEntry) arrayDeque.get(i)).destination.id, true, false);
        }
        NavHostController.popEntryFromBackStack$default(navHostController, navBackStackEntry);
        pop$androidx$navigation$NavigatorState(navBackStackEntry);
        Unit unit = Unit.INSTANCE;
        navHostController.updateOnBackPressedCallbackEnabled();
        navHostController.dispatchOnDestinationChanged();
    }

    public final void pop$androidx$navigation$NavigatorState(NavBackStackEntry navBackStackEntry) {
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            StateFlowImpl stateFlowImpl = this._backStack;
            Iterable iterable = (Iterable) stateFlowImpl.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : iterable) {
                if (Intrinsics.areEqual((NavBackStackEntry) obj, navBackStackEntry)) {
                    break;
                } else {
                    arrayList.add(obj);
                }
            }
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, arrayList);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void popWithTransition(NavBackStackEntry navBackStackEntry, boolean z) {
        Object objPrevious;
        StateFlowImpl stateFlowImpl = this._transitionsInProgress;
        Iterable iterable = (Iterable) stateFlowImpl.getValue();
        boolean z2 = iterable instanceof Collection;
        ReadonlyStateFlow readonlyStateFlow = this.backStack;
        if (!z2 || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (((NavBackStackEntry) it.next()) == navBackStackEntry) {
                    Iterable iterable2 = (Iterable) readonlyStateFlow.$$delegate_0.getValue();
                    if ((iterable2 instanceof Collection) && ((Collection) iterable2).isEmpty()) {
                        return;
                    }
                    Iterator it2 = iterable2.iterator();
                    while (it2.hasNext()) {
                        if (((NavBackStackEntry) it2.next()) == navBackStackEntry) {
                            break;
                        }
                    }
                    return;
                }
            }
        }
        stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry));
        StateFlow stateFlow = readonlyStateFlow.$$delegate_0;
        StateFlow stateFlow2 = readonlyStateFlow.$$delegate_0;
        List list = (List) stateFlow.getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) objPrevious;
            if (!Intrinsics.areEqual(navBackStackEntry2, navBackStackEntry) && ((List) stateFlow2.getValue()).lastIndexOf(navBackStackEntry2) < ((List) stateFlow2.getValue()).lastIndexOf(navBackStackEntry)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry3 != null) {
            stateFlowImpl.updateState(null, SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry3));
        }
        pop(navBackStackEntry, z);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    public final void push(NavBackStackEntry navBackStackEntry) {
        NavHostController navHostController = this.this$0;
        Navigator navigator = navHostController._navigatorProvider.getNavigator(navBackStackEntry.destination.navigatorName);
        if (!navigator.equals(this.navigator)) {
            Object obj = navHostController.navigatorState.get(navigator);
            if (obj == null) {
                throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("NavigatorBackStack for "), navBackStackEntry.destination.navigatorName, " should already be created").toString());
            }
            ((NavController$NavControllerNavigatorState) obj).push(navBackStackEntry);
            return;
        }
        ?? r0 = navHostController.addToBackStackHandler;
        if (r0 != 0) {
            r0.invoke(navBackStackEntry);
            addInternal(navBackStackEntry);
        } else {
            Log.i("NavController", "Ignoring add of destination " + navBackStackEntry.destination + " outside of the call to navigate(). ");
        }
    }
}
