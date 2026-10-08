package androidx.lifecycle;

import android.app.Application;
import androidx.appcompat.widget.AppCompatHintHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SavedStateViewModelFactory_androidKt {
    public static final List ANDROID_VIEWMODEL_SIGNATURE = AppCompatHintHelper.listOf(Application.class, SavedStateHandle.class);
    public static final List VIEWMODEL_SIGNATURE = Collections.singletonList(SavedStateHandle.class);

    public static final Constructor findMatchingConstructor(Class cls, List list) {
        Constructor<?>[] constructors = cls.getConstructors();
        int i = 0;
        while (true) {
            if (!(i < constructors.length)) {
                return null;
            }
            int i2 = i + 1;
            try {
                Constructor<?> constructor = constructors[i];
                List list2 = ArraysKt.toList(constructor.getParameterTypes());
                if (list.equals(list2)) {
                    return constructor;
                }
                if (list.size() == list2.size() && list2.containsAll(list)) {
                    throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
                }
                i = i2;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }
    }

    public static final ViewModel newInstance(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
