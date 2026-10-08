package kotlin.jvm.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    public final boolean syntheticJavaProperty;

    public PropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.syntheticJavaProperty = false;
    }

    public final KCallable compute() {
        if (this.syntheticJavaProperty) {
            return this;
        }
        KCallable kCallable = this.reflected;
        if (kCallable != null) {
            return kCallable;
        }
        KCallable kCallableComputeReflected = computeReflected();
        this.reflected = kCallableComputeReflected;
        return kCallableComputeReflected;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && this.name.equals(propertyReference.name) && this.signature.equals(propertyReference.signature) && Intrinsics.areEqual(this.receiver, propertyReference.receiver);
        }
        if (obj instanceof KProperty) {
            return obj.equals(compute());
        }
        return false;
    }

    public final int hashCode() {
        return this.signature.hashCode() + Modifier.CC.m(getOwner().hashCode() * 31, 31, this.name);
    }

    public final String toString() {
        KCallable kCallableCompute = compute();
        return kCallableCompute != this ? kCallableCompute.toString() : ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("property "), this.name, " (Kotlin reflection is not available)");
    }
}
