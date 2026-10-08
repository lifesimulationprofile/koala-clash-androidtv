package androidx.lifecycle.compose;

import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.lifecycle.LifecycleOwner;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Result;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalLifecycleOwnerKt {
    public static final ProvidableCompositionLocal LocalLifecycleOwner;

    static {
        Object failure;
        try {
            Method method = LifecycleOwner.class.getClassLoader().loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalLifecycleOwner", null);
            Annotation[] annotations = method.getAnnotations();
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    Object objInvoke = method.invoke(null, null);
                    if (objInvoke instanceof ProvidableCompositionLocal) {
                        failure = (ProvidableCompositionLocal) objInvoke;
                        break;
                    }
                } else if (!(annotations[i] instanceof Deprecated)) {
                    i++;
                }
                failure = null;
                break;
            }
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        ProvidableCompositionLocal staticProvidableCompositionLocal = (ProvidableCompositionLocal) (failure instanceof Result.Failure ? null : failure);
        if (staticProvidableCompositionLocal == null) {
            staticProvidableCompositionLocal = new StaticProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(14));
        }
        LocalLifecycleOwner = staticProvidableCompositionLocal;
    }
}
