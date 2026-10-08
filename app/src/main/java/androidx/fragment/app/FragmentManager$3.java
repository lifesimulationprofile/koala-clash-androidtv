package androidx.fragment.app;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.SimpleArrayMap;
import coil.network.HttpException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentManager$3 {
    public static final SimpleArrayMap sClassCacheMap = new SimpleArrayMap(0);
    public final /* synthetic */ FragmentManagerImpl this$0;

    public FragmentManager$3(FragmentManagerImpl fragmentManagerImpl) {
        this.this$0 = fragmentManagerImpl;
    }

    public static Class loadClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        SimpleArrayMap simpleArrayMap = sClassCacheMap;
        SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(classLoader);
        if (simpleArrayMap2 == null) {
            simpleArrayMap2 = new SimpleArrayMap(0);
            simpleArrayMap.put(classLoader, simpleArrayMap2);
        }
        Class cls = (Class) simpleArrayMap2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        simpleArrayMap2.put(str, cls2);
        return cls2;
    }

    public static Class loadFragmentClass(ClassLoader classLoader, String str) {
        try {
            return loadClass(classLoader, str);
        } catch (ClassCastException e) {
            throw new HttpException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new HttpException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    public final Fragment instantiate(String str) {
        try {
            return (Fragment) loadFragmentClass(this.this$0.mHost.mContext.getClassLoader(), str).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e) {
            throw new HttpException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new HttpException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new HttpException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new HttpException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }
}
