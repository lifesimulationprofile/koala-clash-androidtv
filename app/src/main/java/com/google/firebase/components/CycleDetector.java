package com.google.firebase.components;

import com.google.android.gms.internal.mlkit_common.zzsr;
import com.google.android.gms.internal.mlkit_vision_common.zzma;
import com.google.android.gms.internal.mlkit_vision_common.zzmj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CycleDetector {
    public static zzsr zza;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ComponentNode {
        public final Component component;
        public final HashSet dependencies = new HashSet();
        public final HashSet dependents = new HashSet();

        public ComponentNode(Component component) {
            this.component = component;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Dep {
        public final Class anInterface;
        public final boolean set;

        public Dep(Class cls, boolean z) {
            this.anInterface = cls;
            this.set = z;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Dep) {
                Dep dep = (Dep) obj;
                if (dep.anInterface.equals(this.anInterface) && dep.set == this.set) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
        }
    }

    public static void detect(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            Component component = (Component) obj;
            ComponentNode componentNode = new ComponentNode(component);
            for (Class cls : component.providedInterfaces) {
                boolean z = component.type == 0;
                Dep dep = new Dep(cls, !z);
                if (!map.containsKey(dep)) {
                    map.put(dep, new HashSet());
                }
                Set set = (Set) map.get(dep);
                if (!set.isEmpty() && z) {
                    throw new IllegalArgumentException("Multiple components provide " + cls + ".");
                }
                set.add(componentNode);
            }
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            for (ComponentNode componentNode2 : (Set) it.next()) {
                for (Dependency dependency : componentNode2.component.dependencies) {
                    if (dependency.injection == 0) {
                        Set<ComponentNode> set2 = (Set) map.get(new Dep(dependency.anInterface, dependency.type == 2));
                        if (set2 != null) {
                            for (ComponentNode componentNode3 : set2) {
                                componentNode2.dependencies.add(componentNode3);
                                componentNode3.dependents.add(componentNode2);
                            }
                        }
                    }
                }
            }
        }
        HashSet<ComponentNode> hashSet = new HashSet();
        Iterator it2 = map.values().iterator();
        while (it2.hasNext()) {
            hashSet.addAll((Set) it2.next());
        }
        HashSet hashSet2 = new HashSet();
        for (ComponentNode componentNode4 : hashSet) {
            if (componentNode4.dependents.isEmpty()) {
                hashSet2.add(componentNode4);
            }
        }
        while (!hashSet2.isEmpty()) {
            ComponentNode componentNode5 = (ComponentNode) hashSet2.iterator().next();
            hashSet2.remove(componentNode5);
            i++;
            for (ComponentNode componentNode6 : componentNode5.dependencies) {
                componentNode6.dependents.remove(componentNode5);
                if (componentNode6.dependents.isEmpty()) {
                    hashSet2.add(componentNode6);
                }
            }
        }
        if (i == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (ComponentNode componentNode7 : hashSet) {
            if (!componentNode7.dependents.isEmpty() && !componentNode7.dependencies.isEmpty()) {
                arrayList2.add(componentNode7.component);
            }
        }
        throw new DependencyCycleException("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
    }

    public static synchronized zzmj zza(zzma zzmaVar) {
        try {
            if (zza == null) {
                zza = new zzsr(2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzmj) zza.get(zzmaVar);
    }
}
