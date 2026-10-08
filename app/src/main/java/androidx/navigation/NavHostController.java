package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.fragment.app.FragmentManager$1;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import coil.network.EmptyNetworkObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostController {
    public final StateFlowImpl _currentBackStack;
    public final SharedFlowImpl _currentBackStackEntryFlow;
    public NavGraph _graph;
    public final NavigatorProvider _navigatorProvider;
    public final StateFlowImpl _visibleEntries;
    public final Activity activity;
    public Lambda addToBackStackHandler;
    public final ArrayDeque backQueue;
    public final ArrayList backStackEntriesToDispatch;
    public final LinkedHashMap backStackMap;
    public final LinkedHashMap backStackStates;
    public Parcelable[] backStackToRestore;
    public final LinkedHashMap childToParentEntries;
    public final Context context;
    public final ReadonlySharedFlow currentBackStackEntryFlow;
    public boolean deepLinkHandled;
    public int dispatchReentrantCount;
    public final boolean enableOnBackPressedCallback;
    public final LinkedHashMap entrySavedState;
    public Lifecycle.State hostLifecycleState;
    public final NavController$$ExternalSyntheticLambda0 lifecycleObserver;
    public LifecycleOwner lifecycleOwner;
    public final LinkedHashMap navigatorState;
    public Bundle navigatorStateToRestore;
    public final FragmentManager$1 onBackPressedCallback;
    public final CopyOnWriteArrayList onDestinationChangedListeners;
    public final LinkedHashMap parentToChildCount;
    public NavController$executePopOperations$1 popFromBackStackHandler;
    public NavControllerViewModel viewModel;
    public final ReadonlyStateFlow visibleEntries;

    public NavHostController(Context context) {
        this.context = context;
        for (Object obj : SequencesKt.generateSequence(context, NavController$activity$1.INSTANCE)) {
            if (((Context) obj) instanceof Activity) {
                this.activity = (Activity) obj;
                this.backQueue = new ArrayDeque();
                EmptyList emptyList = EmptyList.INSTANCE;
                this._currentBackStack = FlowKt.MutableStateFlow(emptyList);
                StateFlowImpl stateFlowImplMutableStateFlow = FlowKt.MutableStateFlow(emptyList);
                this._visibleEntries = stateFlowImplMutableStateFlow;
                this.visibleEntries = FlowKt.asStateFlow(stateFlowImplMutableStateFlow);
                this.childToParentEntries = new LinkedHashMap();
                this.parentToChildCount = new LinkedHashMap();
                this.backStackMap = new LinkedHashMap();
                this.backStackStates = new LinkedHashMap();
                this.onDestinationChangedListeners = new CopyOnWriteArrayList();
                this.hostLifecycleState = Lifecycle.State.INITIALIZED;
                this.lifecycleObserver = new NavController$$ExternalSyntheticLambda0(0, this);
                this.onBackPressedCallback = new FragmentManager$1(3, this, false);
                this.enableOnBackPressedCallback = true;
                NavigatorProvider navigatorProvider = new NavigatorProvider();
                this._navigatorProvider = navigatorProvider;
                this.navigatorState = new LinkedHashMap();
                this.entrySavedState = new LinkedHashMap();
                navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
                navigatorProvider.addNavigator(new ActivityNavigator(this.context));
                this.backStackEntriesToDispatch = new ArrayList();
                SharedFlowImpl sharedFlowImplMutableSharedFlow$default = FlowKt.MutableSharedFlow$default(2, 2);
                this._currentBackStackEntryFlow = sharedFlowImplMutableSharedFlow$default;
                this.currentBackStackEntryFlow = new ReadonlySharedFlow(sharedFlowImplMutableSharedFlow$default);
            }
        }
        obj = null;
        this.activity = (Activity) obj;
        this.backQueue = new ArrayDeque();
        EmptyList emptyList2 = EmptyList.INSTANCE;
        this._currentBackStack = FlowKt.MutableStateFlow(emptyList2);
        StateFlowImpl stateFlowImplMutableStateFlow2 = FlowKt.MutableStateFlow(emptyList2);
        this._visibleEntries = stateFlowImplMutableStateFlow2;
        this.visibleEntries = FlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new NavController$$ExternalSyntheticLambda0(0, this);
        this.onBackPressedCallback = new FragmentManager$1(3, this, false);
        this.enableOnBackPressedCallback = true;
        NavigatorProvider navigatorProvider2 = new NavigatorProvider();
        this._navigatorProvider = navigatorProvider2;
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        navigatorProvider2.addNavigator(new NavGraphNavigator(navigatorProvider2));
        navigatorProvider2.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        SharedFlowImpl sharedFlowImplMutableSharedFlow$default2 = FlowKt.MutableSharedFlow$default(2, 2);
        this._currentBackStackEntryFlow = sharedFlowImplMutableSharedFlow$default2;
        this.currentBackStackEntryFlow = new ReadonlySharedFlow(sharedFlowImplMutableSharedFlow$default2);
    }

    public static NavDestination findDestinationComprehensive(NavDestination navDestination, int i, boolean z, NavDestination navDestination2) {
        if (navDestination.id == i && (navDestination2 == null || (navDestination.equals(navDestination2) && Intrinsics.areEqual(navDestination.parent, navDestination2.parent)))) {
            return navDestination;
        }
        NavGraph navGraph = navDestination instanceof NavGraph ? (NavGraph) navDestination : navDestination.parent;
        return navGraph.findNodeComprehensive(i, navGraph, z, navDestination2);
    }

    public static /* synthetic */ void popEntryFromBackStack$default(NavHostController navHostController, NavBackStackEntry navBackStackEntry) {
        navHostController.popEntryFromBackStack(navBackStackEntry, false, new ArrayDeque());
    }

    public final void addEntryToBackStack(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list) {
        Object objPrevious;
        Object objPrevious2;
        NavDestination navDestination2 = navBackStackEntry.destination;
        boolean z = navDestination2 instanceof FloatingWindow;
        ArrayDeque arrayDeque = this.backQueue;
        if (!z) {
            while (!arrayDeque.isEmpty() && (((NavBackStackEntry) arrayDeque.last()).destination instanceof FloatingWindow) && popBackStackInternal(((NavBackStackEntry) arrayDeque.last()).destination.id, true, false)) {
            }
        }
        ArrayDeque<NavBackStackEntry> arrayDeque2 = new ArrayDeque();
        boolean z2 = navDestination instanceof NavGraph;
        Context context = this.context;
        Object obj = null;
        if (z2) {
            NavDestination navDestination3 = navDestination2;
            do {
                navDestination3 = navDestination3.parent;
                if (navDestination3 != null) {
                    ListIterator listIterator = list.listIterator(list.size());
                    do {
                        if (!listIterator.hasPrevious()) {
                            objPrevious2 = null;
                            break;
                        }
                        objPrevious2 = listIterator.previous();
                    } while (!Intrinsics.areEqual(((NavBackStackEntry) objPrevious2).destination, navDestination3));
                    NavBackStackEntry navBackStackEntryCreate$default = (NavBackStackEntry) objPrevious2;
                    if (navBackStackEntryCreate$default == null) {
                        navBackStackEntryCreate$default = EmptyNetworkObserver.create$default(context, navDestination3, bundle, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                    }
                    arrayDeque2.addFirst(navBackStackEntryCreate$default);
                    if (!arrayDeque.isEmpty() && ((NavBackStackEntry) arrayDeque.last()).destination == navDestination3) {
                        popEntryFromBackStack$default(this, (NavBackStackEntry) arrayDeque.last());
                    }
                }
                if (navDestination3 == null) {
                    break;
                }
            } while (navDestination3 != navDestination);
        }
        NavDestination navDestination4 = arrayDeque2.isEmpty() ? navDestination2 : ((NavBackStackEntry) arrayDeque2.first()).destination;
        while (navDestination4 != null && findDestination(navDestination4.id, navDestination4) != navDestination4) {
            navDestination4 = navDestination4.parent;
            if (navDestination4 != null) {
                Bundle bundle2 = (bundle == null || !bundle.isEmpty()) ? bundle : null;
                ListIterator listIterator2 = list.listIterator(list.size());
                do {
                    if (!listIterator2.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator2.previous();
                } while (!Intrinsics.areEqual(((NavBackStackEntry) objPrevious).destination, navDestination4));
                NavBackStackEntry navBackStackEntryCreate$default2 = (NavBackStackEntry) objPrevious;
                if (navBackStackEntryCreate$default2 == null) {
                    navBackStackEntryCreate$default2 = EmptyNetworkObserver.create$default(context, navDestination4, navDestination4.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                }
                arrayDeque2.addFirst(navBackStackEntryCreate$default2);
            }
        }
        if (!arrayDeque2.isEmpty()) {
            navDestination2 = ((NavBackStackEntry) arrayDeque2.first()).destination;
        }
        while (!arrayDeque.isEmpty() && (((NavBackStackEntry) arrayDeque.last()).destination instanceof NavGraph) && ((NavGraph) ((NavBackStackEntry) arrayDeque.last()).destination).nodes.get(navDestination2.id) == null) {
            popEntryFromBackStack$default(this, (NavBackStackEntry) arrayDeque.last());
        }
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) arrayDeque.firstOrNull();
        if (navBackStackEntry2 == null) {
            navBackStackEntry2 = (NavBackStackEntry) arrayDeque2.firstOrNull();
        }
        if (!Intrinsics.areEqual(navBackStackEntry2 != null ? navBackStackEntry2.destination : null, this._graph)) {
            ListIterator listIterator3 = list.listIterator(list.size());
            while (listIterator3.hasPrevious()) {
                Object objPrevious3 = listIterator3.previous();
                if (Intrinsics.areEqual(((NavBackStackEntry) objPrevious3).destination, this._graph)) {
                    obj = objPrevious3;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntryCreate$default3 = (NavBackStackEntry) obj;
            if (navBackStackEntryCreate$default3 == null) {
                NavGraph navGraph = this._graph;
                navBackStackEntryCreate$default3 = EmptyNetworkObserver.create$default(context, navGraph, navGraph.addInDefaultArgs(bundle), getHostLifecycleState$navigation_runtime_release(), this.viewModel);
            }
            arrayDeque2.addFirst(navBackStackEntryCreate$default3);
        }
        for (NavBackStackEntry navBackStackEntry3 : arrayDeque2) {
            Object obj2 = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry3.destination.navigatorName));
            if (obj2 == null) {
                throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("NavigatorBackStack for "), navDestination.navigatorName, " should already be created").toString());
            }
            ((NavController$NavControllerNavigatorState) obj2).addInternal(navBackStackEntry3);
        }
        arrayDeque.addAll(arrayDeque2);
        arrayDeque.addLast(navBackStackEntry);
        ArrayList arrayListPlus = CollectionsKt.plus(arrayDeque2, navBackStackEntry);
        int size = arrayListPlus.size();
        int i = 0;
        while (i < size) {
            Object obj3 = arrayListPlus.get(i);
            i++;
            NavBackStackEntry navBackStackEntry4 = (NavBackStackEntry) obj3;
            NavGraph navGraph2 = navBackStackEntry4.destination.parent;
            if (navGraph2 != null) {
                linkChildToParent(navBackStackEntry4, getBackStackEntry(navGraph2.id));
            }
        }
    }

    public final boolean dispatchOnDestinationChanged() {
        ArrayDeque arrayDeque;
        while (true) {
            arrayDeque = this.backQueue;
            if (arrayDeque.isEmpty() || !(((NavBackStackEntry) arrayDeque.last()).destination instanceof NavGraph)) {
                break;
            }
            popEntryFromBackStack$default(this, (NavBackStackEntry) arrayDeque.last());
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) arrayDeque.lastOrNull();
        ArrayList arrayList = this.backStackEntriesToDispatch;
        if (navBackStackEntry != null) {
            arrayList.add(navBackStackEntry);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        if (i == 0) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            arrayList.clear();
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
                Iterator it = this.onDestinationChangedListeners.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    NavDestination navDestination = navBackStackEntry2.destination;
                    navBackStackEntry2.getArguments();
                    throw null;
                }
                this._currentBackStackEntryFlow.tryEmit(navBackStackEntry2);
            }
            ArrayList arrayList3 = new ArrayList(arrayDeque);
            StateFlowImpl stateFlowImpl = this._currentBackStack;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, arrayList3);
            ArrayList arrayListPopulateVisibleEntries$navigation_runtime_release = populateVisibleEntries$navigation_runtime_release();
            StateFlowImpl stateFlowImpl2 = this._visibleEntries;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, arrayListPopulateVisibleEntries$navigation_runtime_release);
        }
        return navBackStackEntry != null;
    }

    public final NavDestination findDestination(int i, NavDestination navDestination) {
        NavDestination navDestination2;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        if (navGraph.id == i) {
            if (navDestination == null) {
                return navGraph;
            }
            if (navGraph.equals(navDestination) && navDestination.parent == null) {
                return this._graph;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.lastOrNull();
        if (navBackStackEntry == null || (navDestination2 = navBackStackEntry.destination) == null) {
            navDestination2 = this._graph;
        }
        return findDestinationComprehensive(navDestination2, i, false, navDestination);
    }

    public final NavBackStackEntry getBackStackEntry(int i) {
        Object objPrevious;
        ArrayDeque arrayDeque = this.backQueue;
        ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (((NavBackStackEntry) objPrevious).destination.id != i);
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) objPrevious;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "No destination with ID ", " is on the NavController's back stack. The current destination is ");
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) arrayDeque.lastOrNull();
        sbM.append(navBackStackEntry2 != null ? navBackStackEntry2.destination : null);
        throw new IllegalArgumentException(sbM.toString().toString());
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        return this.lifecycleOwner == null ? Lifecycle.State.CREATED : this.hostLifecycleState;
    }

    public final void linkChildToParent(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.childToParentEntries.put(navBackStackEntry, navBackStackEntry2);
        LinkedHashMap linkedHashMap = this.parentToChildCount;
        if (linkedHashMap.get(navBackStackEntry2) == null) {
            linkedHashMap.put(navBackStackEntry2, new AtomicInteger(0));
        }
        ((AtomicInteger) linkedHashMap.get(navBackStackEntry2)).incrementAndGet();
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0163 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0188 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x016b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x01ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:11:0x0038  */
    /* JADX WARN: Code duplicated, block: B:120:? A[LOOP:7: B:71:0x01ad->B:120:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:52:0x0101 A[LOOP:4: B:50:0x00fb->B:52:0x0101, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x014e  */
    /* JADX WARN: Code duplicated, block: B:58:0x015a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0171  */
    /* JADX WARN: Code duplicated, block: B:66:0x0184  */
    /* JADX WARN: Code duplicated, block: B:73:0x01b3 A[Catch: all -> 0x01c8, TryCatch #0 {all -> 0x01c8, blocks: (B:70:0x0196, B:71:0x01ad, B:73:0x01b3, B:75:0x01c3, B:79:0x01cb), top: B:101:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:86:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:87:0x0212  */
    public final void navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions) {
        boolean zPopBackStackInternal;
        NavigatorProvider navigatorProvider;
        Ref$BooleanRef ref$BooleanRef;
        boolean z;
        int iNextIndex;
        NavDestination navDestination2;
        ArrayDeque<NavBackStackEntry> arrayDeque;
        Navigator navigator;
        NavDestination navDestination3;
        ReentrantLock reentrantLock;
        ListIterator listIterator;
        int iNextIndex2;
        NavGraph navGraph;
        LinkedHashMap linkedHashMap = this.navigatorState;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((NavController$NavControllerNavigatorState) it.next()).isNavigating = true;
        }
        Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        if (navOptions != null) {
            boolean z2 = navOptions.popUpToSaveState;
            boolean z3 = navOptions.popUpToInclusive;
            int i = navOptions.popUpToId;
            if (i != -1) {
                zPopBackStackInternal = popBackStackInternal(i, z3, z2);
            } else {
                zPopBackStackInternal = false;
            }
        } else {
            zPopBackStackInternal = false;
        }
        Bundle bundleAddInDefaultArgs = navDestination.addInDefaultArgs(bundle);
        if (navOptions == null || !navOptions.restoreState) {
            navigatorProvider = this._navigatorProvider;
            if (navOptions == null && navOptions.singleTop) {
                ArrayDeque arrayDeque2 = this.backQueue;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) arrayDeque2.lastOrNull();
                ListIterator listIterator2 = arrayDeque2.listIterator(arrayDeque2.getSize());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        if (((NavBackStackEntry) listIterator2.previous()).destination == navDestination) {
                            iNextIndex = listIterator2.nextIndex();
                            break;
                        }
                    } else {
                        iNextIndex = -1;
                        break;
                    }
                }
                if (iNextIndex == -1) {
                    ref$BooleanRef = ref$BooleanRef2;
                    z = false;
                } else if (navDestination instanceof NavGraph) {
                    int i2 = NavGraph.$r8$clinit;
                    List list = SequencesKt.toList(new GeneratorSequence(SequencesKt.generateSequence((NavGraph) navDestination, NavController$activity$1.INSTANCE$6), NavController$activity$1.INSTANCE$4, 3));
                    if (arrayDeque2.size - iNextIndex == list.size()) {
                        List listSubList = arrayDeque2.subList(iNextIndex, arrayDeque2.size);
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSubList, 10));
                        Iterator it2 = listSubList.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(Integer.valueOf(((NavBackStackEntry) it2.next()).destination.id));
                        }
                        if (arrayList.equals(list)) {
                            arrayDeque = new ArrayDeque();
                            while (AppCompatHintHelper.getLastIndex(arrayDeque2) >= iNextIndex) {
                                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt__MutableCollectionsKt.removeLast(arrayDeque2);
                                unlinkChildFromParent$navigation_runtime_release(navBackStackEntry2);
                                NavBackStackEntry navBackStackEntry3 = new NavBackStackEntry(navBackStackEntry2.context, navBackStackEntry2.destination, navBackStackEntry2.destination.addInDefaultArgs(bundle), navBackStackEntry2.hostLifecycleState, navBackStackEntry2.viewModelStoreProvider, navBackStackEntry2.id, navBackStackEntry2.savedState);
                                navBackStackEntry3.hostLifecycleState = navBackStackEntry2.hostLifecycleState;
                                navBackStackEntry3.setMaxLifecycle(navBackStackEntry2.maxLifecycle);
                                arrayDeque.addFirst(navBackStackEntry3);
                                ref$BooleanRef2 = ref$BooleanRef2;
                            }
                            ref$BooleanRef = ref$BooleanRef2;
                            for (NavBackStackEntry navBackStackEntry4 : arrayDeque) {
                                navGraph = navBackStackEntry4.destination.parent;
                                if (navGraph != null) {
                                    linkChildToParent(navBackStackEntry4, getBackStackEntry(navGraph.id));
                                }
                                arrayDeque2.addLast(navBackStackEntry4);
                            }
                            for (NavBackStackEntry navBackStackEntry5 : arrayDeque) {
                                navigator = navigatorProvider.getNavigator(navBackStackEntry5.destination.navigatorName);
                                navDestination3 = navBackStackEntry5.destination;
                                if (navDestination3 == null) {
                                    navDestination3 = null;
                                }
                                if (navDestination3 == null) {
                                    Unit unit = Unit.INSTANCE;
                                    navigator.navigate(navDestination3);
                                    NavController$NavControllerNavigatorState state = navigator.getState();
                                    reentrantLock = state.backStackLock;
                                    reentrantLock.lock();
                                    try {
                                        ArrayList arrayList2 = new ArrayList((Collection) state.backStack.$$delegate_0.getValue());
                                        listIterator = arrayList2.listIterator(arrayList2.size());
                                        while (true) {
                                            if (listIterator.hasPrevious()) {
                                                if (Intrinsics.areEqual(((NavBackStackEntry) listIterator.previous()).id, navBackStackEntry5.id)) {
                                                    iNextIndex2 = listIterator.nextIndex();
                                                    break;
                                                }
                                            } else {
                                                iNextIndex2 = -1;
                                                break;
                                            }
                                        }
                                        arrayList2.set(iNextIndex2, navBackStackEntry5);
                                        StateFlowImpl stateFlowImpl = state._backStack;
                                        stateFlowImpl.getClass();
                                        stateFlowImpl.updateState(null, arrayList2);
                                        Unit unit2 = Unit.INSTANCE;
                                        reentrantLock.unlock();
                                    } catch (Throwable th) {
                                        reentrantLock.unlock();
                                        throw th;
                                    }
                                }
                            }
                            z = true;
                        }
                    }
                    ref$BooleanRef = ref$BooleanRef2;
                    z = false;
                } else if (navBackStackEntry == null || (navDestination2 = navBackStackEntry.destination) == null || navDestination.id != navDestination2.id) {
                    ref$BooleanRef = ref$BooleanRef2;
                    z = false;
                } else {
                    arrayDeque = new ArrayDeque();
                    while (AppCompatHintHelper.getLastIndex(arrayDeque2) >= iNextIndex) {
                        NavBackStackEntry navBackStackEntry6 = (NavBackStackEntry) CollectionsKt__MutableCollectionsKt.removeLast(arrayDeque2);
                        unlinkChildFromParent$navigation_runtime_release(navBackStackEntry6);
                        NavBackStackEntry navBackStackEntry7 = new NavBackStackEntry(navBackStackEntry6.context, navBackStackEntry6.destination, navBackStackEntry6.destination.addInDefaultArgs(bundle), navBackStackEntry6.hostLifecycleState, navBackStackEntry6.viewModelStoreProvider, navBackStackEntry6.id, navBackStackEntry6.savedState);
                        navBackStackEntry7.hostLifecycleState = navBackStackEntry6.hostLifecycleState;
                        navBackStackEntry7.setMaxLifecycle(navBackStackEntry6.maxLifecycle);
                        arrayDeque.addFirst(navBackStackEntry7);
                        ref$BooleanRef2 = ref$BooleanRef2;
                    }
                    ref$BooleanRef = ref$BooleanRef2;
                    while (r1.hasNext()) {
                        navGraph = navBackStackEntry4.destination.parent;
                        if (navGraph != null) {
                            linkChildToParent(navBackStackEntry4, getBackStackEntry(navGraph.id));
                        }
                        arrayDeque2.addLast(navBackStackEntry4);
                    }
                    while (r0.hasNext()) {
                        navigator = navigatorProvider.getNavigator(navBackStackEntry5.destination.navigatorName);
                        navDestination3 = navBackStackEntry5.destination;
                        if (navDestination3 == null) {
                            navDestination3 = null;
                        }
                        if (navDestination3 == null) {
                            Unit unit3 = Unit.INSTANCE;
                            navigator.navigate(navDestination3);
                            NavController$NavControllerNavigatorState state2 = navigator.getState();
                            reentrantLock = state2.backStackLock;
                            reentrantLock.lock();
                            ArrayList arrayList3 = new ArrayList((Collection) state2.backStack.$$delegate_0.getValue());
                            listIterator = arrayList3.listIterator(arrayList3.size());
                            while (true) {
                                if (listIterator.hasPrevious()) {
                                    if (Intrinsics.areEqual(((NavBackStackEntry) listIterator.previous()).id, navBackStackEntry5.id)) {
                                        iNextIndex2 = listIterator.nextIndex();
                                        break;
                                    }
                                } else {
                                    iNextIndex2 = -1;
                                    break;
                                }
                            }
                            arrayList3.set(iNextIndex2, navBackStackEntry5);
                            StateFlowImpl stateFlowImpl2 = state2._backStack;
                            stateFlowImpl2.getClass();
                            stateFlowImpl2.updateState(null, arrayList3);
                            Unit unit4 = Unit.INSTANCE;
                            reentrantLock.unlock();
                        }
                    }
                    z = true;
                }
            } else {
                ref$BooleanRef = ref$BooleanRef2;
                z = false;
            }
            if (z) {
                ref$BooleanRef2 = ref$BooleanRef;
            } else {
                NavBackStackEntry navBackStackEntryCreate$default = EmptyNetworkObserver.create$default(this.context, navDestination, bundleAddInDefaultArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                Navigator navigator2 = navigatorProvider.getNavigator(navDestination.navigatorName);
                List listSingletonList = Collections.singletonList(navBackStackEntryCreate$default);
                ref$BooleanRef2 = ref$BooleanRef;
                this.addToBackStackHandler = new NavController$navigate$5(ref$BooleanRef2, this, navDestination, bundleAddInDefaultArgs, 0);
                navigator2.navigate(listSingletonList, navOptions);
                this.addToBackStackHandler = null;
            }
        } else if (this.backStackMap.containsKey(Integer.valueOf(navDestination.id))) {
            ref$BooleanRef2.element = restoreStateInternal(navDestination.id, bundleAddInDefaultArgs, navOptions);
            z = false;
        } else {
            navigatorProvider = this._navigatorProvider;
            if (navOptions == null) {
                ref$BooleanRef = ref$BooleanRef2;
                z = false;
            } else {
                ref$BooleanRef = ref$BooleanRef2;
                z = false;
            }
            if (z) {
                NavBackStackEntry navBackStackEntryCreate$default2 = EmptyNetworkObserver.create$default(this.context, navDestination, bundleAddInDefaultArgs, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                Navigator navigator3 = navigatorProvider.getNavigator(navDestination.navigatorName);
                List listSingletonList2 = Collections.singletonList(navBackStackEntryCreate$default2);
                ref$BooleanRef2 = ref$BooleanRef;
                this.addToBackStackHandler = new NavController$navigate$5(ref$BooleanRef2, this, navDestination, bundleAddInDefaultArgs, 0);
                navigator3.navigate(listSingletonList2, navOptions);
                this.addToBackStackHandler = null;
            } else {
                ref$BooleanRef2 = ref$BooleanRef;
            }
        }
        updateOnBackPressedCallbackEnabled();
        Iterator it3 = linkedHashMap.values().iterator();
        while (it3.hasNext()) {
            ((NavController$NavControllerNavigatorState) it3.next()).isNavigating = false;
        }
        if (zPopBackStackInternal || ref$BooleanRef2.element || z) {
            dispatchOnDestinationChanged();
        } else {
            updateBackStackLifecycle$navigation_runtime_release();
        }
    }

    public final boolean popBackStackInternal(int i, boolean z, boolean z2) {
        NavDestination navDestination;
        boolean z3;
        ArrayDeque arrayDeque = this.backQueue;
        final int i2 = 0;
        if (arrayDeque.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(arrayDeque).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            NavDestination navDestination2 = ((NavBackStackEntry) it.next()).destination;
            Navigator navigator = this._navigatorProvider.getNavigator(navDestination2.navigatorName);
            if (z || navDestination2.id != i) {
                arrayList.add(navigator);
            }
            if (navDestination2.id == i) {
                navDestination = navDestination2;
                break;
            }
        }
        if (navDestination == null) {
            int i3 = NavDestination.$r8$clinit;
            Log.i("NavController", "Ignoring popBackStack to destination " + NavDestination.Companion.getDisplayName(this.context, i) + " as it was not found on the current back stack");
            return false;
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                z3 = z2;
                break;
            }
            int i5 = i4 + 1;
            Navigator navigator2 = (Navigator) arrayList.get(i4);
            Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) arrayDeque.last();
            z3 = z2;
            this.popFromBackStackHandler = new NavController$executePopOperations$1(ref$BooleanRef2, ref$BooleanRef, this, z3, arrayDeque2);
            navigator2.popBackStack(navBackStackEntry, z3);
            this.popFromBackStackHandler = null;
            if (!ref$BooleanRef2.element) {
                break;
            }
            i4 = i5;
        }
        if (z3) {
            LinkedHashMap linkedHashMap = this.backStackMap;
            if (!z) {
                FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk.FileTreeWalkIterator(new GeneratorSequence(SequencesKt.generateSequence(navDestination, NavController$activity$1.INSTANCE$2), new Function1(this) { // from class: androidx.navigation.NavController$executePopOperations$3
                    public final /* synthetic */ NavHostController this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        switch (i2) {
                            case 0:
                                break;
                        }
                        return Boolean.valueOf(!this.this$0.backStackMap.containsKey(Integer.valueOf(((NavDestination) obj).id)));
                    }
                }), (byte) 0);
                while (fileTreeWalkIterator.hasNext()) {
                    Integer numValueOf = Integer.valueOf(((NavDestination) fileTreeWalkIterator.next()).id);
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque2.firstOrNull();
                    linkedHashMap.put(numValueOf, navBackStackEntryState != null ? navBackStackEntryState.id : null);
                }
            }
            if (!arrayDeque2.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) arrayDeque2.first();
                int i6 = navBackStackEntryState2.destinationId;
                String str = navBackStackEntryState2.id;
                final int i7 = 1;
                FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator2 = new FileTreeWalk.FileTreeWalkIterator(new GeneratorSequence(SequencesKt.generateSequence(findDestination(i6, null), NavController$activity$1.INSTANCE$3), new Function1(this) { // from class: androidx.navigation.NavController$executePopOperations$3
                    public final /* synthetic */ NavHostController this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        switch (i7) {
                            case 0:
                                break;
                        }
                        return Boolean.valueOf(!this.this$0.backStackMap.containsKey(Integer.valueOf(((NavDestination) obj).id)));
                    }
                }), (byte) 0);
                while (fileTreeWalkIterator2.hasNext()) {
                    linkedHashMap.put(Integer.valueOf(((NavDestination) fileTreeWalkIterator2.next()).id), str);
                }
                if (linkedHashMap.values().contains(str)) {
                    this.backStackStates.put(str, arrayDeque2);
                }
            }
        }
        updateOnBackPressedCallbackEnabled();
        return ref$BooleanRef.element;
    }

    public final void popEntryFromBackStack(NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque arrayDeque) {
        NavControllerViewModel navControllerViewModel;
        ReadonlyStateFlow readonlyStateFlow;
        Set set;
        ArrayDeque arrayDeque2 = this.backQueue;
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) arrayDeque2.last();
        if (!Intrinsics.areEqual(navBackStackEntry2, navBackStackEntry)) {
            throw new IllegalStateException(("Attempted to pop " + navBackStackEntry.destination + ", which is not the top of the back stack (" + navBackStackEntry2.destination + ')').toString());
        }
        CollectionsKt__MutableCollectionsKt.removeLast(arrayDeque2);
        NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = (NavController$NavControllerNavigatorState) this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry2.destination.navigatorName));
        boolean z2 = true;
        if ((navController$NavControllerNavigatorState == null || (readonlyStateFlow = navController$NavControllerNavigatorState.transitionsInProgress) == null || (set = (Set) readonlyStateFlow.$$delegate_0.getValue()) == null || !set.contains(navBackStackEntry2)) && !this.parentToChildCount.containsKey(navBackStackEntry2)) {
            z2 = false;
        }
        Lifecycle.State state = navBackStackEntry2._lifecycle.state;
        Lifecycle.State state2 = Lifecycle.State.CREATED;
        if (state.isAtLeast(state2)) {
            if (z) {
                navBackStackEntry2.setMaxLifecycle(state2);
                arrayDeque.addFirst(new NavBackStackEntryState(navBackStackEntry2));
            }
            if (z2) {
                navBackStackEntry2.setMaxLifecycle(state2);
            } else {
                navBackStackEntry2.setMaxLifecycle(Lifecycle.State.DESTROYED);
                unlinkChildFromParent$navigation_runtime_release(navBackStackEntry2);
            }
        }
        if (z || z2 || (navControllerViewModel = this.viewModel) == null) {
            return;
        }
        ViewModelStore viewModelStore = (ViewModelStore) navControllerViewModel.viewModelStores.remove(navBackStackEntry2.id);
        if (viewModelStore != null) {
            viewModelStore.clear();
        }
    }

    public final ArrayList populateVisibleEntries$navigation_runtime_release() {
        Lifecycle.State state;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.navigatorState.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            state = Lifecycle.State.STARTED;
            if (!zHasNext) {
                break;
            }
            Iterable iterable = (Iterable) ((NavController$NavControllerNavigatorState) it.next()).transitionsInProgress.$$delegate_0.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : iterable) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.maxLifecycle.isAtLeast(state)) {
                    arrayList2.add(obj);
                }
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : this.backQueue) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.maxLifecycle.isAtLeast(state)) {
                arrayList3.add(obj2);
            }
        }
        CollectionsKt__MutableCollectionsKt.addAll(arrayList3, arrayList);
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj3 = arrayList.get(i);
            i++;
            if (!(((NavBackStackEntry) obj3).destination instanceof NavGraph)) {
                arrayList4.add(obj3);
            }
        }
        return arrayList4;
    }

    public final boolean restoreStateInternal(int i, Bundle bundle, NavOptions navOptions) {
        NavDestination navDestination;
        NavBackStackEntry navBackStackEntry;
        NavDestination navDestination2;
        Bundle bundle2;
        Integer numValueOf = Integer.valueOf(i);
        LinkedHashMap linkedHashMap = this.backStackMap;
        if (!linkedHashMap.containsKey(numValueOf)) {
            return false;
        }
        String str = (String) linkedHashMap.get(Integer.valueOf(i));
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), str)) {
                it.remove();
            }
        }
        ArrayDeque<NavBackStackEntryState> arrayDeque = (ArrayDeque) TypeIntrinsics.asMutableMap(this.backStackStates).remove(str);
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) this.backQueue.lastOrNull();
        if ((navBackStackEntry2 == null || (navDestination = navBackStackEntry2.destination) == null) && (navDestination = this._graph) == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        if (arrayDeque != null) {
            for (NavBackStackEntryState navBackStackEntryState : arrayDeque) {
                NavDestination navDestinationFindDestinationComprehensive = findDestinationComprehensive(navDestination, navBackStackEntryState.destinationId, true, null);
                Context context = this.context;
                if (navDestinationFindDestinationComprehensive == null) {
                    int i3 = NavDestination.$r8$clinit;
                    throw new IllegalStateException(("Restore State failed: destination " + NavDestination.Companion.getDisplayName(context, navBackStackEntryState.destinationId) + " cannot be found from the current destination " + navDestination).toString());
                }
                Lifecycle.State hostLifecycleState$navigation_runtime_release = getHostLifecycleState$navigation_runtime_release();
                NavControllerViewModel navControllerViewModel = this.viewModel;
                Bundle bundle3 = navBackStackEntryState.args;
                if (bundle3 != null) {
                    bundle3.setClassLoader(context.getClassLoader());
                    bundle2 = bundle3;
                } else {
                    bundle2 = null;
                }
                arrayList.add(new NavBackStackEntry(context, navDestinationFindDestinationComprehensive, bundle2, hostLifecycleState$navigation_runtime_release, navControllerViewModel, navBackStackEntryState.id, navBackStackEntryState.savedState));
                navDestination = navDestinationFindDestinationComprehensive;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            if (!(((NavBackStackEntry) obj).destination instanceof NavGraph)) {
                arrayList3.add(obj);
            }
        }
        int size2 = arrayList3.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList3.get(i5);
            i5++;
            NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj2;
            List list = (List) CollectionsKt.lastOrNull(arrayList2);
            if (Intrinsics.areEqual((list == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last(list)) == null || (navDestination2 = navBackStackEntry.destination) == null) ? null : navDestination2.navigatorName, navBackStackEntry3.destination.navigatorName)) {
                list.add(navBackStackEntry3);
            } else {
                arrayList2.add(AppCompatHintHelper.mutableListOf(navBackStackEntry3));
            }
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        int size3 = arrayList2.size();
        while (i2 < size3) {
            int i6 = i2 + 1;
            List list2 = (List) arrayList2.get(i2);
            Navigator navigator = this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt.first(list2)).destination.navigatorName);
            Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
            this.addToBackStackHandler = new NavController$executeRestoreState$3(ref$BooleanRef2, arrayList, new Ref$IntRef(), this, bundle, 0);
            navigator.navigate(list2, navOptions);
            this.addToBackStackHandler = null;
            ref$BooleanRef = ref$BooleanRef2;
            i2 = i6;
        }
        return ref$BooleanRef.element;
    }

    public final void unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry navBackStackEntry) {
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) this.childToParentEntries.remove(navBackStackEntry);
        if (navBackStackEntry2 == null) {
            return;
        }
        LinkedHashMap linkedHashMap = this.parentToChildCount;
        AtomicInteger atomicInteger = (AtomicInteger) linkedHashMap.get(navBackStackEntry2);
        Integer numValueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = (NavController$NavControllerNavigatorState) this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry2.destination.navigatorName));
            if (navController$NavControllerNavigatorState != null) {
                navController$NavControllerNavigatorState.markTransitionComplete(navBackStackEntry2);
            }
            linkedHashMap.remove(navBackStackEntry2);
        }
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        AtomicInteger atomicInteger;
        ReadonlyStateFlow readonlyStateFlow;
        Set set;
        ArrayList arrayList = new ArrayList(this.backQueue);
        if (arrayList.isEmpty()) {
            return;
        }
        NavDestination navDestination = ((NavBackStackEntry) CollectionsKt.last(arrayList)).destination;
        ArrayList arrayList2 = new ArrayList();
        if (navDestination instanceof FloatingWindow) {
            Iterator it = CollectionsKt.reversed(arrayList).iterator();
            while (it.hasNext()) {
                NavDestination navDestination2 = ((NavBackStackEntry) it.next()).destination;
                arrayList2.add(navDestination2);
                if (!(navDestination2 instanceof FloatingWindow) && !(navDestination2 instanceof NavGraph)) {
                    break;
                }
            }
        }
        HashMap map = new HashMap();
        Iterator it2 = CollectionsKt.reversed(arrayList).iterator();
        while (true) {
            int i = 0;
            if (!it2.hasNext()) {
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                    Lifecycle.State state = (Lifecycle.State) map.get(navBackStackEntry);
                    if (state != null) {
                        navBackStackEntry.setMaxLifecycle(state);
                    } else {
                        navBackStackEntry.updateState();
                    }
                }
                return;
            }
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) it2.next();
            Lifecycle.State state2 = navBackStackEntry2.maxLifecycle;
            NavDestination navDestination3 = navBackStackEntry2.destination;
            Lifecycle.State state3 = Lifecycle.State.RESUMED;
            Lifecycle.State state4 = Lifecycle.State.STARTED;
            if (navDestination != null && navDestination3.id == navDestination.id) {
                if (state2 != state3) {
                    NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = (NavController$NavControllerNavigatorState) this.navigatorState.get(this._navigatorProvider.getNavigator(navDestination3.navigatorName));
                    if (Intrinsics.areEqual((navController$NavControllerNavigatorState == null || (readonlyStateFlow = navController$NavControllerNavigatorState.transitionsInProgress) == null || (set = (Set) readonlyStateFlow.$$delegate_0.getValue()) == null) ? null : Boolean.valueOf(set.contains(navBackStackEntry2)), Boolean.TRUE) || ((atomicInteger = (AtomicInteger) this.parentToChildCount.get(navBackStackEntry2)) != null && atomicInteger.get() == 0)) {
                        map.put(navBackStackEntry2, state4);
                    } else {
                        map.put(navBackStackEntry2, state3);
                    }
                }
                NavDestination navDestination4 = (NavDestination) CollectionsKt.firstOrNull(arrayList2);
                if (navDestination4 != null && navDestination4.id == navDestination3.id) {
                    if (arrayList2.isEmpty()) {
                        throw new NoSuchElementException("List is empty.");
                    }
                    arrayList2.remove(0);
                }
                navDestination = navDestination.parent;
            } else if (arrayList2.isEmpty() || navDestination3.id != ((NavDestination) CollectionsKt.first((List) arrayList2)).id) {
                navBackStackEntry2.setMaxLifecycle(Lifecycle.State.CREATED);
            } else {
                if (arrayList2.isEmpty()) {
                    throw new NoSuchElementException("List is empty.");
                }
                NavDestination navDestination5 = (NavDestination) arrayList2.remove(0);
                if (state2 == state3) {
                    navBackStackEntry2.setMaxLifecycle(state4);
                } else if (state2 != state4) {
                    map.put(navBackStackEntry2, state4);
                }
                NavGraph navGraph = navDestination5.parent;
                if (navGraph != null && !arrayList2.contains(navGraph)) {
                    arrayList2.add(navGraph);
                }
            }
        }
    }

    public final void updateOnBackPressedCallbackEnabled() {
        int i;
        boolean z = false;
        if (this.enableOnBackPressedCallback) {
            ArrayDeque arrayDeque = this.backQueue;
            if (arrayDeque == null || !arrayDeque.isEmpty()) {
                Iterator it = arrayDeque.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (!(((NavBackStackEntry) it.next()).destination instanceof NavGraph) && (i = i + 1) < 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
            } else {
                i = 0;
            }
            if (i > 1) {
                z = true;
            }
        }
        this.onBackPressedCallback.setEnabled(z);
    }
}
