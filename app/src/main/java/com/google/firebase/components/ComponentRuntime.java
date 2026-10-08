package com.google.firebase.components;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_common.zzlu;
import com.google.android.gms.tasks.zzi;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentRuntime extends zzlu {
    public final EventBus eventBus;
    public final HashMap components = new HashMap();
    public final HashMap lazyInstanceMap = new HashMap();
    public final HashMap lazySetMap = new HashMap();
    public final AtomicReference eagerComponentsInitializedWith = new AtomicReference();

    public ComponentRuntime(ArrayList arrayList, ArrayList arrayList2) {
        EventBus eventBus = new EventBus();
        new HashMap();
        eventBus.pendingEvents = new ArrayDeque();
        this.eventBus = eventBus;
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        arrayList3.add(Component.of(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        arrayList3.add(Component.of(this, ComponentRuntime.class, new Class[0]));
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            Component component = (Component) obj;
            if (component != null) {
                arrayList3.add(component);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList4.add(obj2);
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((Provider) it.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(componentRegistrar.getComponents());
                        it.remove();
                    }
                } catch (InvalidRegistrarException e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.components.isEmpty()) {
                CycleDetector.detect(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.components.keySet());
                arrayList6.addAll(arrayList3);
                CycleDetector.detect(arrayList6);
            }
            int size3 = arrayList3.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj3 = arrayList3.get(i4);
                i4++;
                final Component component2 = (Component) obj3;
                this.components.put(component2, new Lazy(new Provider(this, component2) { // from class: com.google.firebase.components.ComponentRuntime$$Lambda$1
                    public final ComponentRuntime arg$1;
                    public final Component arg$2;

                    {
                        this.arg$1 = this;
                        this.arg$2 = component2;
                    }

                    @Override // com.google.firebase.inject.Provider
                    public final Object get() {
                        Component component3 = this.arg$2;
                        return component3.factory.create(new RestrictedComponentContainer(component3, this.arg$1));
                    }
                }));
            }
            arrayList5.addAll(processInstanceComponents(arrayList3));
            arrayList5.addAll(processSetComponents());
            processDependencies();
        }
        int size4 = arrayList5.size();
        while (i < size4) {
            Object obj4 = arrayList5.get(i);
            i++;
            ((Runnable) obj4).run();
        }
        Boolean bool = (Boolean) this.eagerComponentsInitializedWith.get();
        if (bool != null) {
            doInitializeEagerComponents(this.components, bool.booleanValue());
        }
    }

    public final void doInitializeEagerComponents(HashMap map, boolean z) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            Component component = (Component) entry.getKey();
            component.getClass();
        }
        EventBus eventBus = this.eventBus;
        synchronized (eventBus) {
            try {
                arrayDeque = eventBus.pendingEvents;
                if (arrayDeque != null) {
                    eventBus.pendingEvents = null;
                } else {
                    arrayDeque = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzlu
    public final synchronized Provider getProvider(Class cls) {
        return (Provider) this.lazyInstanceMap.get(cls);
    }

    public final void initializeEagerComponents() {
        HashMap map;
        AtomicReference atomicReference = this.eagerComponentsInitializedWith;
        Boolean bool = Boolean.TRUE;
        while (!atomicReference.compareAndSet(null, bool)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        synchronized (this) {
            map = new HashMap(this.components);
        }
        doInitializeEagerComponents(map, true);
    }

    public final void processDependencies() {
        for (Component component : this.components.keySet()) {
            for (Dependency dependency : component.dependencies) {
                if (dependency.type == 2 && !this.lazySetMap.containsKey(dependency.anInterface)) {
                    HashMap map = this.lazySetMap;
                    Class cls = dependency.anInterface;
                    Set set = Collections.EMPTY_SET;
                    LazySet lazySet = new LazySet();
                    lazySet.actualSet = null;
                    lazySet.providers = Collections.newSetFromMap(new ConcurrentHashMap());
                    lazySet.providers.addAll(set);
                    map.put(cls, lazySet);
                } else if (this.lazyInstanceMap.containsKey(dependency.anInterface)) {
                    continue;
                } else {
                    int i = dependency.type;
                    if (i == 1) {
                        throw new DependencyCycleException("Unsatisfied dependency for component " + component + ": " + dependency.anInterface);
                    }
                    if (i != 2) {
                        HashMap map2 = this.lazyInstanceMap;
                        Class cls2 = dependency.anInterface;
                        OptionalProvider$$Lambda$4 optionalProvider$$Lambda$4 = OptionalProvider$$Lambda$4.instance;
                        ComponentRuntime$$Lambda$5 componentRuntime$$Lambda$5 = ComponentRuntime$$Lambda$5.instance$1;
                        OptionalProvider optionalProvider = new OptionalProvider();
                        optionalProvider.handler = optionalProvider$$Lambda$4;
                        optionalProvider.delegate = componentRuntime$$Lambda$5;
                        map2.put(cls2, optionalProvider);
                    }
                }
            }
        }
    }

    public final ArrayList processInstanceComponents(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Component component = (Component) obj;
            if (component.type == 0) {
                Provider provider = (Provider) this.components.get(component);
                for (Class cls : component.providedInterfaces) {
                    HashMap map = this.lazyInstanceMap;
                    if (map.containsKey(cls)) {
                        arrayList2.add(new zzi(22, (OptionalProvider) ((Provider) map.get(cls)), provider));
                    } else {
                        map.put(cls, provider);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList processSetComponents() {
        HashMap map = this.lazySetMap;
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : this.components.entrySet()) {
            Component component = (Component) entry.getKey();
            if (component.type != 0) {
                Provider provider = (Provider) entry.getValue();
                for (Class cls : component.providedInterfaces) {
                    if (!map2.containsKey(cls)) {
                        map2.put(cls, new HashSet());
                    }
                    ((Set) map2.get(cls)).add(provider);
                }
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (map.containsKey(entry2.getKey())) {
                LazySet lazySet = (LazySet) map.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzi(23, lazySet, (Provider) it.next()));
                }
            } else {
                Class cls2 = (Class) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                LazySet lazySet2 = new LazySet();
                lazySet2.actualSet = null;
                lazySet2.providers = Collections.newSetFromMap(new ConcurrentHashMap());
                lazySet2.providers.addAll(set);
                map.put(cls2, lazySet2);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzlu
    public final synchronized Provider setOfProvider(Class cls) {
        LazySet lazySet = (LazySet) this.lazySetMap.get(cls);
        if (lazySet != null) {
            return lazySet;
        }
        return ComponentRuntime$$Lambda$5.instance;
    }
}
