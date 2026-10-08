package kotlin.jvm.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import kotlin.Function;
import kotlin.reflect.KCallable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class FunctionReferenceImpl extends CallableReference implements FunctionBase, KCallable, Function {
    public final int arity;
    public final int flags;

    public FunctionReferenceImpl(int i, Class cls, String str, String str2, int i2) {
        this(i, CallableReference.NoReceiver.INSTANCE, cls, str, str2, i2, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable computeReflected() {
        Reflection.factory.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReferenceImpl) {
            FunctionReferenceImpl functionReferenceImpl = (FunctionReferenceImpl) obj;
            return this.name.equals(functionReferenceImpl.name) && this.signature.equals(functionReferenceImpl.signature) && this.flags == functionReferenceImpl.flags && this.arity == functionReferenceImpl.arity && Intrinsics.areEqual(this.receiver, functionReferenceImpl.receiver) && getOwner().equals(functionReferenceImpl.getOwner());
        }
        if (!(obj instanceof FunctionReferenceImpl)) {
            return false;
        }
        KCallable kCallable = this.reflected;
        if (kCallable == null) {
            computeReflected();
            this.reflected = this;
            kCallable = this;
        }
        return obj.equals(kCallable);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.arity;
    }

    public final int hashCode() {
        getOwner();
        return this.signature.hashCode() + Modifier.CC.m(getOwner().hashCode() * 31, 31, this.name);
    }

    public final String toString() {
        KCallable kCallable = this.reflected;
        if (kCallable == null) {
            computeReflected();
            this.reflected = this;
            kCallable = this;
        }
        if (kCallable != this) {
            return kCallable.toString();
        }
        String str = this.name;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : ImageAnalysis$$ExternalSyntheticLambda1.m$1("function ", str, " (Kotlin reflection is not available)");
    }

    public FunctionReferenceImpl(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = 0;
    }
}
