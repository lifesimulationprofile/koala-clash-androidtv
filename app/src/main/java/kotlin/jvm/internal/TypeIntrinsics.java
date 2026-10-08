package kotlin.jvm.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.internal.ComposableLambda;
import java.util.Map;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypeIntrinsics {
    public static Map asMutableMap(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableMap)) {
            throwCce(obj, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            Intrinsics.sanitizeStackTrace(e, TypeIntrinsics.class.getName());
            throw e;
        }
    }

    public static void beforeCheckcastToFunctionOfArity(int i, Object obj) {
        if (obj == null || isFunctionOfArity(i, obj)) {
            return;
        }
        throwCce(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static boolean isFunctionOfArity(int i, Object obj) {
        int arity;
        if (obj instanceof Function) {
            if (obj instanceof FunctionBase) {
                arity = ((FunctionBase) obj).getArity();
            } else if (obj instanceof Function0) {
                arity = 0;
            } else if (obj instanceof Function1) {
                arity = 1;
            } else if (obj instanceof Function2) {
                arity = 2;
            } else if (obj instanceof Function3) {
                arity = 3;
            } else if (obj instanceof Function4) {
                arity = 4;
            } else if (obj instanceof Function5) {
                arity = 5;
            } else if (obj instanceof Function6) {
                arity = 6;
            } else {
                boolean z = obj instanceof ComposableLambda;
                if (z) {
                    arity = 7;
                } else if (obj instanceof Function8) {
                    arity = 8;
                } else if (z) {
                    arity = 9;
                } else if (z) {
                    arity = 10;
                } else if (z) {
                    arity = 11;
                } else if (z) {
                    arity = 13;
                } else if (z) {
                    arity = 14;
                } else if (z) {
                    arity = 15;
                } else if (z) {
                    arity = 16;
                } else if (z) {
                    arity = 17;
                } else if (z) {
                    arity = 18;
                } else if (z) {
                    arity = 19;
                } else if (z) {
                    arity = 20;
                } else {
                    arity = z ? 21 : -1;
                }
            }
            if (arity == i) {
                return true;
            }
        }
        return false;
    }

    public static void throwCce(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(ImageAnalysis$$ExternalSyntheticLambda1.m(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        Intrinsics.sanitizeStackTrace(classCastException, TypeIntrinsics.class.getName());
        throw classCastException;
    }
}
