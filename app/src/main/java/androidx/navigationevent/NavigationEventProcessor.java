package androidx.navigationevent;

import androidx.appcompat.widget.AppCompatHintHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavigationEventProcessor {
    public final StateFlowImpl _history;
    public final StateFlowImpl _transitionState = FlowKt.MutableStateFlow(NavigationEventTransitionState.Idle.INSTANCE);
    public final ArrayDeque defaultHandlers;
    public final LinkedHashSet defaultInputs;
    public boolean hasEnabledAnyHandlers;
    public boolean hasEnabledDefaultHandlers;
    public boolean hasEnabledOverlayHandlers;
    public final ReadonlyStateFlow history;
    public int inProgressDirection;
    public NavigationEventHandler inProgressHandler;
    public NavigationEventInput inProgressInput;
    public final ArrayDeque overlayHandlers;
    public final LinkedHashSet overlayInputs;
    public final LinkedHashSet unspecifiedInputs;

    public NavigationEventProcessor() {
        StateFlowImpl stateFlowImplMutableStateFlow = FlowKt.MutableStateFlow(new NavigationEventHistory());
        this._history = stateFlowImplMutableStateFlow;
        this.history = FlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        this.overlayHandlers = new ArrayDeque();
        this.defaultHandlers = new ArrayDeque();
        this.unspecifiedInputs = new LinkedHashSet();
        this.defaultInputs = new LinkedHashSet();
        this.overlayInputs = new LinkedHashSet();
    }

    public final void addInput(Dispatcher dispatcher, NavigationEventInput navigationEventInput, int i) {
        LinkedHashSet linkedHashSet;
        boolean z;
        if (navigationEventInput.dispatcher != null) {
            throw new IllegalArgumentException(("Input '" + navigationEventInput + "' is already added to dispatcher " + navigationEventInput.dispatcher + '.').toString());
        }
        if (i != 0) {
            linkedHashSet = i != 1 ? this.unspecifiedInputs : this.defaultInputs;
        } else {
            linkedHashSet = this.overlayInputs;
        }
        linkedHashSet.add(navigationEventInput);
        navigationEventInput.dispatcher = dispatcher;
        if (i != 0) {
            z = i != 1 ? this.hasEnabledAnyHandlers : this.hasEnabledDefaultHandlers;
        } else {
            z = this.hasEnabledOverlayHandlers;
        }
        navigationEventInput.onHasEnabledHandlersChanged(z);
    }

    public final void refreshEnabledHandlers() {
        boolean z;
        boolean z2;
        NavigationEventHistory navigationEventHistory;
        ArrayDeque arrayDeque = this.overlayHandlers;
        if (arrayDeque != null && arrayDeque.isEmpty()) {
            z = false;
            break;
        }
        Iterator it = arrayDeque.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (((NavigationEventHandler) it.next()).isBackEnabled) {
                z = true;
                break;
            }
        }
        ArrayDeque arrayDeque2 = this.defaultHandlers;
        if (arrayDeque2 != null && arrayDeque2.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator it2 = arrayDeque2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z2 = false;
                break;
            } else if (((NavigationEventHandler) it2.next()).isBackEnabled) {
                z2 = true;
                break;
            }
        }
        boolean z3 = z || z2;
        boolean z4 = this.hasEnabledOverlayHandlers != z;
        boolean z5 = this.hasEnabledDefaultHandlers != z2;
        boolean z6 = this.hasEnabledAnyHandlers != z3;
        LinkedHashSet linkedHashSet = this.overlayInputs;
        if (z4) {
            Iterator it3 = linkedHashSet.iterator();
            while (it3.hasNext()) {
                ((NavigationEventInput) it3.next()).onHasEnabledHandlersChanged(z);
            }
        }
        LinkedHashSet linkedHashSet2 = this.defaultInputs;
        if (z5) {
            Iterator it4 = linkedHashSet2.iterator();
            while (it4.hasNext()) {
                ((NavigationEventInput) it4.next()).onHasEnabledHandlersChanged(z2);
            }
        }
        LinkedHashSet linkedHashSet3 = this.unspecifiedInputs;
        if (z6) {
            Iterator it5 = linkedHashSet3.iterator();
            while (it5.hasNext()) {
                ((NavigationEventInput) it5.next()).onHasEnabledHandlersChanged(z3);
            }
        }
        this.hasEnabledOverlayHandlers = z;
        this.hasEnabledDefaultHandlers = z2;
        this.hasEnabledAnyHandlers = z3;
        NavigationEventHandler navigationEventHandlerResolveEnabledHandler = this.inProgressHandler;
        if (navigationEventHandlerResolveEnabledHandler == null) {
            navigationEventHandlerResolveEnabledHandler = resolveEnabledHandler(0);
        }
        NavigationEventHandler navigationEventHandlerResolveEnabledHandler2 = this.inProgressHandler;
        if (navigationEventHandlerResolveEnabledHandler2 == null) {
            navigationEventHandlerResolveEnabledHandler2 = resolveEnabledHandler(0);
        }
        if (Intrinsics.areEqual(navigationEventHandlerResolveEnabledHandler2, navigationEventHandlerResolveEnabledHandler)) {
            if (navigationEventHandlerResolveEnabledHandler2 == null) {
                navigationEventHistory = new NavigationEventHistory();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<E> it6 = arrayDeque.iterator();
                while (it6.hasNext()) {
                    boolean z7 = ((NavigationEventHandler) it6.next()).isBackEnabled;
                }
                Iterator<E> it7 = arrayDeque2.iterator();
                while (it7.hasNext()) {
                    boolean z8 = ((NavigationEventHandler) it7.next()).isBackEnabled;
                }
                NavigationEventInfo navigationEventInfo = navigationEventHandlerResolveEnabledHandler2.currentInfo;
                ListBuilder listBuilderCreateListBuilder = AppCompatHintHelper.createListBuilder();
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, listBuilderCreateListBuilder);
                listBuilderCreateListBuilder.add(navigationEventInfo);
                CollectionsKt__MutableCollectionsKt.addAll(EmptyList.INSTANCE, listBuilderCreateListBuilder);
                navigationEventHistory = new NavigationEventHistory(arrayList.size(), AppCompatHintHelper.build(listBuilderCreateListBuilder));
            }
            StateFlowImpl stateFlowImpl = this._history;
            if (Intrinsics.areEqual((NavigationEventHistory) stateFlowImpl.getValue(), navigationEventHistory)) {
                return;
            }
            stateFlowImpl.updateState(null, navigationEventHistory);
            Iterator it8 = linkedHashSet.iterator();
            while (it8.hasNext()) {
                ((NavigationEventInput) it8.next()).getClass();
            }
            Iterator it9 = linkedHashSet2.iterator();
            while (it9.hasNext()) {
                ((NavigationEventInput) it9.next()).getClass();
            }
            Iterator it10 = linkedHashSet3.iterator();
            while (it10.hasNext()) {
                ((NavigationEventInput) it10.next()).getClass();
            }
        }
    }

    public final NavigationEventHandler resolveEnabledHandler(int i) {
        Object next;
        Object next2;
        ArrayDeque arrayDeque = this.defaultHandlers;
        ArrayDeque arrayDeque2 = this.overlayHandlers;
        Object obj = null;
        if (i == -1) {
            Iterator it = arrayDeque2.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!((NavigationEventHandler) next).isBackEnabled);
            NavigationEventHandler navigationEventHandler = (NavigationEventHandler) next;
            if (navigationEventHandler != null) {
                return navigationEventHandler;
            }
            for (Object obj2 : arrayDeque) {
                if (((NavigationEventHandler) obj2).isBackEnabled) {
                    obj = obj2;
                    break;
                }
            }
            return (NavigationEventHandler) obj;
        }
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException(("Unsupported direction: '" + i + "'.").toString());
            }
            Iterator it2 = arrayDeque2.iterator();
            while (it2.hasNext()) {
                ((NavigationEventHandler) it2.next()).getClass();
            }
            Iterator it3 = arrayDeque.iterator();
            while (it3.hasNext()) {
                ((NavigationEventHandler) it3.next()).getClass();
            }
            return null;
        }
        Iterator it4 = arrayDeque2.iterator();
        do {
            if (!it4.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it4.next();
        } while (!((NavigationEventHandler) next2).isBackEnabled);
        NavigationEventHandler navigationEventHandler2 = (NavigationEventHandler) next2;
        if (navigationEventHandler2 != null) {
            return navigationEventHandler2;
        }
        for (Object obj3 : arrayDeque) {
            if (((NavigationEventHandler) obj3).isBackEnabled) {
                obj = obj3;
                break;
            }
        }
        return (NavigationEventHandler) obj;
    }
}
