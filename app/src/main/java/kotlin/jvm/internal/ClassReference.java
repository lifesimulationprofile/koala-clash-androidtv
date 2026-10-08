package kotlin.jvm.internal;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.compose.runtime.internal.ComposableLambda;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function8;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ClassReference implements KClass, ClassBasedDeclarationContainer {
    public static final Map FUNCTION_CLASSES;
    public final Class jClass;

    static {
        int i = 0;
        List listListOf = AppCompatHintHelper.listOf(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, ComposableLambda.class, Function8.class, ComposableLambda.class, ComposableLambda.class, ComposableLambda.class, Function12.class, ComposableLambda.class, ComposableLambda.class, ComposableLambda.class, ComposableLambda.class, ComposableLambda.class, ComposableLambda.class, ComposableLambda.class, ComposableLambda.class, ComposableLambda.class, Function22.class);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listListOf, 10));
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                AppCompatHintHelper.throwIndexOverflow();
                throw null;
            }
            arrayList.add(new Pair((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        FUNCTION_CLASSES = MapsKt__MapsKt.toMap(arrayList);
    }

    public ClassReference(Class cls) {
        this.jClass = cls;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ClassReference) && JvmClassMappingKt.getJavaObjectType(this).equals(JvmClassMappingKt.getJavaObjectType((KClass) obj));
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.jClass;
    }

    public final String getQualifiedName() {
        String strClassFqNameOf;
        Class cls = this.jClass;
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (!cls.isArray()) {
            String strClassFqNameOf2 = Intrinsics.classFqNameOf(cls.getName());
            return strClassFqNameOf2 == null ? cls.getCanonicalName() : strClassFqNameOf2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (strClassFqNameOf = Intrinsics.classFqNameOf(componentType.getName())) != null) {
            strConcat = strClassFqNameOf.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final String getSimpleName() {
        String strSimpleNameOf;
        Class cls = this.jClass;
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strSimpleNameOf2 = Intrinsics.simpleNameOf(cls.getName());
                return strSimpleNameOf2 == null ? cls.getSimpleName() : strSimpleNameOf2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strSimpleNameOf = Intrinsics.simpleNameOf(componentType.getName())) != null) {
                strConcat = strSimpleNameOf.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            int iIndexOf$default = StringsKt.indexOf$default(simpleName, '$', 0, 6);
            return iIndexOf$default == -1 ? simpleName : simpleName.substring(iIndexOf$default + 1, simpleName.length());
        }
        return StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + '$');
    }

    public final int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public final String toString() {
        return this.jClass.toString() + " (Kotlin reflection is not available)";
    }
}
