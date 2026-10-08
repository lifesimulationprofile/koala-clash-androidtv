package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycling {
    public static final HashMap callbackCache = new HashMap();
    public static final HashMap classToAdapters = new HashMap();

    public static void createGeneratedAdapter(Constructor constructor, LifecycleObserver lifecycleObserver) {
        try {
            constructor.newInstance(lifecycleObserver);
            throw new ClassCastException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:70:0x0108  */
    /* JADX WARN: Code duplicated, block: B:73:0x010d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0114 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0116  */
    /* JADX WARN: Code duplicated, block: B:83:0x0132  */
    /* JADX WARN: Code duplicated, block: B:95:0x0137 A[EDGE_INSN: B:95:0x0137->B:84:0x0137 BREAK  A[LOOP:0: B:59:0x00f2->B:72:0x010b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x010b A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static int getObserverConstructorType(Class cls) {
        Constructor declaredConstructor;
        boolean zBooleanValue;
        Class<?>[] interfaces;
        int i;
        boolean z;
        Class<?> cls2;
        boolean z2;
        HashMap map = callbackCache;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i2 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r4 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r4 != null ? r4.getName() : "";
                if (name.length() != 0) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String strConcat = StringsKt__StringsJVMKt.replace$default(canonicalName, ".", "_").concat("_LifecycleAdapter");
                if (name.length() != 0) {
                    strConcat = name + '.' + strConcat;
                }
                declaredConstructor = Class.forName(strConcat).getDeclaredConstructor(cls);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                declaredConstructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap map2 = classToAdapters;
            if (declaredConstructor == null) {
                ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
                HashMap map3 = classesInfoCache.mHasLifecycleMethods;
                Boolean bool = (Boolean) map3.get(cls);
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                map3.put(cls, Boolean.FALSE);
                                zBooleanValue = false;
                                break;
                            }
                            if (((OnLifecycleEvent) declaredMethods[i3].getAnnotation(OnLifecycleEvent.class)) != null) {
                                classesInfoCache.createInfo(cls, declaredMethods);
                                zBooleanValue = true;
                                break;
                            }
                            i3++;
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
                    }
                }
                if (!zBooleanValue) {
                    Class superclass = cls.getSuperclass();
                    if (!(superclass != null && LifecycleObserver.class.isAssignableFrom(superclass))) {
                        interfaces = cls.getInterfaces();
                        i = 0;
                        while (true) {
                            if (i < interfaces.length) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                if (arrayList != null) {
                                    break;
                                }
                                map2.put(cls, arrayList);
                            } else {
                                int i4 = i + 1;
                                try {
                                    cls2 = interfaces[i];
                                    if (cls2 == null && LifecycleObserver.class.isAssignableFrom(cls2)) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        if (getObserverConstructorType(cls2) == 1) {
                                            break;
                                        }
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.addAll((Collection) map2.get(cls2));
                                    }
                                    i = i4;
                                } catch (ArrayIndexOutOfBoundsException e3) {
                                    throw new NoSuchElementException(e3.getMessage());
                                }
                            }
                        }
                    } else if (getObserverConstructorType(superclass) != 1) {
                        arrayList = new ArrayList((Collection) map2.get(superclass));
                        interfaces = cls.getInterfaces();
                        i = 0;
                        while (true) {
                            if (i < interfaces.length) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                if (arrayList != null) {
                                    break;
                                }
                                map2.put(cls, arrayList);
                            } else {
                                int i5 = i + 1;
                                cls2 = interfaces[i];
                                if (cls2 == null) {
                                    z2 = false;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    if (getObserverConstructorType(cls2) == 1) {
                                        break;
                                        break;
                                    }
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.addAll((Collection) map2.get(cls2));
                                }
                                i = i5;
                            }
                        }
                    }
                }
            } else {
                map2.put(cls, Collections.singletonList(declaredConstructor));
            }
            i2 = 2;
            break;
        }
        map.put(cls, Integer.valueOf(i2));
        return i2;
    }
}
