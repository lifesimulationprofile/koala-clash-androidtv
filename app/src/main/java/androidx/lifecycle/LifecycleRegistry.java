package androidx.lifecycle;

import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleRegistry extends Lifecycle {
    public final StateFlowImpl _currentStateFlow;
    public int addingObserverCounter;
    public final boolean enforceMainThread;
    public boolean handlingEvent;
    public final WeakReference lifecycleOwner;
    public boolean newEventOccurred;
    public FastSafeIterableMap observerMap;
    public final ArrayList parentStates;
    public Lifecycle.State state;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ObserverWithState {
        public LifecycleEventObserver lifecycleObserver;
        public Lifecycle.State state;

        public final void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            Lifecycle.State state = this.state;
            if (targetState.compareTo(state) < 0) {
                state = targetState;
            }
            this.state = state;
            this.lifecycleObserver.onStateChanged(lifecycleOwner, event);
            this.state = targetState;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z) {
        super(0);
        this.enforceMainThread = z;
        this.observerMap = new FastSafeIterableMap();
        Lifecycle.State state = Lifecycle.State.INITIALIZED;
        this.state = state;
        this.parentStates = new ArrayList();
        this.lifecycleOwner = new WeakReference(lifecycleOwner);
        this._currentStateFlow = FlowKt.MutableStateFlow(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void addObserver(LifecycleObserver lifecycleObserver) {
        LifecycleEventObserver defaultLifecycleObserverAdapter;
        Object obj;
        LifecycleOwner lifecycleOwner;
        Lifecycle.Event event;
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.state;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState();
        HashMap map = Lifecycling.callbackCache;
        boolean z = lifecycleObserver instanceof LifecycleEventObserver;
        boolean z2 = lifecycleObserver instanceof DefaultLifecycleObserver;
        Object obj2 = null;
        int i = 0;
        int i2 = 1;
        if (z && z2) {
            defaultLifecycleObserverAdapter = new DefaultLifecycleObserverAdapter(i, (DefaultLifecycleObserver) lifecycleObserver, (LifecycleEventObserver) lifecycleObserver);
        } else if (z2) {
            defaultLifecycleObserverAdapter = new DefaultLifecycleObserverAdapter(i, (DefaultLifecycleObserver) lifecycleObserver, obj2);
        } else if (z) {
            defaultLifecycleObserverAdapter = (LifecycleEventObserver) lifecycleObserver;
        } else {
            Class<?> cls = lifecycleObserver.getClass();
            if (Lifecycling.getObserverConstructorType(cls) == 2) {
                List list = (List) Lifecycling.classToAdapters.get(cls);
                if (list.size() == 1) {
                    Lifecycling.createGeneratedAdapter((Constructor) list.get(0), lifecycleObserver);
                    throw null;
                }
                int size = list.size();
                GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
                if (size > 0) {
                    Lifecycling.createGeneratedAdapter((Constructor) list.get(0), lifecycleObserver);
                    throw null;
                }
                defaultLifecycleObserverAdapter = new SavedStateHandleAttacher(i2, generatedAdapterArr);
            } else {
                defaultLifecycleObserverAdapter = new DefaultLifecycleObserverAdapter(lifecycleObserver);
            }
        }
        observerWithState.lifecycleObserver = defaultLifecycleObserverAdapter;
        observerWithState.state = state2;
        FastSafeIterableMap fastSafeIterableMap = this.observerMap;
        SafeIterableMap.Entry entry = fastSafeIterableMap.get(lifecycleObserver);
        if (entry != null) {
            obj = entry.mValue;
        } else {
            HashMap map2 = fastSafeIterableMap.mHashMap;
            SafeIterableMap.Entry entry2 = new SafeIterableMap.Entry(lifecycleObserver, observerWithState);
            fastSafeIterableMap.mSize++;
            SafeIterableMap.Entry entry3 = fastSafeIterableMap.mEnd;
            if (entry3 == null) {
                fastSafeIterableMap.mStart = entry2;
                fastSafeIterableMap.mEnd = entry2;
            } else {
                entry3.mNext = entry2;
                entry2.mPrevious = entry3;
                fastSafeIterableMap.mEnd = entry2;
            }
            map2.put(lifecycleObserver, entry2);
            obj = null;
        }
        if (((ObserverWithState) obj) == null && (lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.get()) != null) {
            i = (this.addingObserverCounter != 0 || this.handlingEvent) ? 1 : 0;
            Lifecycle.State stateCalculateTargetState = calculateTargetState(lifecycleObserver);
            this.addingObserverCounter++;
            while (observerWithState.state.compareTo(stateCalculateTargetState) < 0 && this.observerMap.mHashMap.containsKey(lifecycleObserver)) {
                Lifecycle.State state3 = observerWithState.state;
                ArrayList arrayList = this.parentStates;
                arrayList.add(state3);
                Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                Lifecycle.State state4 = observerWithState.state;
                companion.getClass();
                int iOrdinal = state4.ordinal();
                if (iOrdinal == 1) {
                    event = Lifecycle.Event.ON_CREATE;
                } else if (iOrdinal != 2) {
                    event = iOrdinal != 3 ? null : Lifecycle.Event.ON_RESUME;
                } else {
                    event = Lifecycle.Event.ON_START;
                }
                if (event == null) {
                    throw new IllegalStateException("no event up from " + observerWithState.state);
                }
                observerWithState.dispatchEvent(lifecycleOwner, event);
                arrayList.remove(arrayList.size() - 1);
                stateCalculateTargetState = calculateTargetState(lifecycleObserver);
            }
            if (i == 0) {
                sync();
            }
            this.addingObserverCounter--;
        }
    }

    public final Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        HashMap map = this.observerMap.mHashMap;
        SafeIterableMap.Entry entry = map.containsKey(lifecycleObserver) ? ((SafeIterableMap.Entry) map.get(lifecycleObserver)).mPrevious : null;
        Lifecycle.State state = entry != null ? ((ObserverWithState) entry.mValue).state : null;
        ArrayList arrayList = this.parentStates;
        Lifecycle.State state2 = arrayList.isEmpty() ? null : (Lifecycle.State) arrayList.get(arrayList.size() - 1);
        Lifecycle.State state3 = this.state;
        if (state == null || state.compareTo(state3) >= 0) {
            state = state3;
        }
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    public final void enforceMainThreadIfNeeded(String str) {
        if (this.enforceMainThread) {
            ArchTaskExecutor.getInstance().mDelegate.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Lifecycle.State getCurrentState() {
        return this.state;
    }

    public final void handleLifecycleEvent(Lifecycle.Event event) {
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    public final void moveToState(Lifecycle.State state) {
        if (this.state == state) {
            return;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.get();
        Lifecycle.State state2 = this.state;
        Lifecycle.State state3 = Lifecycle.State.INITIALIZED;
        Lifecycle.State state4 = Lifecycle.State.DESTROYED;
        if (state2 == state3 && state == state4) {
            throw new IllegalStateException(("State must be at least '" + Lifecycle.State.CREATED + "' to be moved to '" + state + "' in component " + lifecycleOwner).toString());
        }
        if (state2 == state4 && state2 != state) {
            throw new IllegalStateException(("State is '" + state4 + "' and cannot be moved to `" + state + "` in component " + lifecycleOwner).toString());
        }
        this.state = state;
        if (this.handlingEvent || this.addingObserverCounter != 0) {
            this.newEventOccurred = true;
            return;
        }
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state == state4) {
            this.observerMap = new FastSafeIterableMap();
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void removeObserver(LifecycleObserver lifecycleObserver) {
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(lifecycleObserver);
    }

    public final void setCurrentState(Lifecycle.State state) {
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    public final void sync() {
        Lifecycle.State state;
        Lifecycle.State state2;
        Lifecycle.Event event;
        Lifecycle.Event event2;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            FastSafeIterableMap fastSafeIterableMap = this.observerMap;
            if (fastSafeIterableMap.mSize == 0 || ((state = ((ObserverWithState) fastSafeIterableMap.mStart.mValue).state) == (state2 = ((ObserverWithState) fastSafeIterableMap.mEnd.mValue).state) && this.state == state2)) {
                break;
            }
            this.newEventOccurred = false;
            int iCompareTo = this.state.compareTo(state);
            ArrayList arrayList = this.parentStates;
            if (iCompareTo < 0) {
                FastSafeIterableMap fastSafeIterableMap2 = this.observerMap;
                SafeIterableMap.AscendingIterator ascendingIterator = new SafeIterableMap.AscendingIterator(fastSafeIterableMap2.mEnd, fastSafeIterableMap2.mStart, 1);
                fastSafeIterableMap2.mIterators.put(ascendingIterator, Boolean.FALSE);
                while (ascendingIterator.hasNext() && !this.newEventOccurred) {
                    Map.Entry entry = (Map.Entry) ascendingIterator.next();
                    LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
                    ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
                    while (observerWithState.state.compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.mHashMap.containsKey(lifecycleObserver)) {
                        Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                        Lifecycle.State state3 = observerWithState.state;
                        companion.getClass();
                        int iOrdinal = state3.ordinal();
                        if (iOrdinal == 2) {
                            event2 = Lifecycle.Event.ON_DESTROY;
                        } else if (iOrdinal != 3) {
                            event2 = iOrdinal != 4 ? null : Lifecycle.Event.ON_PAUSE;
                        } else {
                            event2 = Lifecycle.Event.ON_STOP;
                        }
                        if (event2 == null) {
                            throw new IllegalStateException("no event down from " + observerWithState.state);
                        }
                        arrayList.add(event2.getTargetState());
                        observerWithState.dispatchEvent(lifecycleOwner, event2);
                        arrayList.remove(arrayList.size() - 1);
                    }
                }
            }
            SafeIterableMap.Entry entry2 = this.observerMap.mEnd;
            if (!this.newEventOccurred && entry2 != null && this.state.compareTo(((ObserverWithState) entry2.mValue).state) > 0) {
                FastSafeIterableMap fastSafeIterableMap3 = this.observerMap;
                fastSafeIterableMap3.getClass();
                SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
                fastSafeIterableMap3.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
                while (iteratorWithAdditions.hasNext() && !this.newEventOccurred) {
                    Map.Entry entry3 = (Map.Entry) iteratorWithAdditions.next();
                    LifecycleObserver lifecycleObserver2 = (LifecycleObserver) entry3.getKey();
                    ObserverWithState observerWithState2 = (ObserverWithState) entry3.getValue();
                    while (observerWithState2.state.compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.mHashMap.containsKey(lifecycleObserver2)) {
                        arrayList.add(observerWithState2.state);
                        Lifecycle.Event.Companion companion2 = Lifecycle.Event.Companion;
                        Lifecycle.State state4 = observerWithState2.state;
                        companion2.getClass();
                        int iOrdinal2 = state4.ordinal();
                        if (iOrdinal2 == 1) {
                            event = Lifecycle.Event.ON_CREATE;
                        } else if (iOrdinal2 != 2) {
                            event = iOrdinal2 != 3 ? null : Lifecycle.Event.ON_RESUME;
                        } else {
                            event = Lifecycle.Event.ON_START;
                        }
                        if (event == null) {
                            throw new IllegalStateException("no event up from " + observerWithState2.state);
                        }
                        observerWithState2.dispatchEvent(lifecycleOwner, event);
                        arrayList.remove(arrayList.size() - 1);
                    }
                }
            }
        }
        this.newEventOccurred = false;
        this._currentStateFlow.setValue(this.state);
    }
}
