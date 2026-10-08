package coil.request;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.size.SizeResolver;
import coil.transition.Transition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefinedRequestOptions {
    public final int precision;
    public final int scale;
    public final SizeResolver sizeResolver;
    public final Transition.Factory transitionFactory;

    public DefinedRequestOptions(SizeResolver sizeResolver, int i, Transition.Factory factory, int i2) {
        this.sizeResolver = sizeResolver;
        this.scale = i;
        this.transitionFactory = factory;
        this.precision = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefinedRequestOptions)) {
            return false;
        }
        DefinedRequestOptions definedRequestOptions = (DefinedRequestOptions) obj;
        return Intrinsics.areEqual(this.sizeResolver, definedRequestOptions.sizeResolver) && this.scale == definedRequestOptions.scale && Intrinsics.areEqual(this.transitionFactory, definedRequestOptions.transitionFactory) && this.precision == definedRequestOptions.precision;
    }

    public final int hashCode() {
        SizeResolver sizeResolver = this.sizeResolver;
        int iHashCode = (sizeResolver != null ? sizeResolver.hashCode() : 0) * 31;
        int i = this.scale;
        int iOrdinal = (iHashCode + (i != 0 ? CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i) : 0)) * 28629151;
        Transition.Factory factory = this.transitionFactory;
        int iHashCode2 = (iOrdinal + (factory != null ? factory.hashCode() : 0)) * 31;
        int i2 = this.precision;
        return (iHashCode2 + (i2 != 0 ? CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i2) : 0)) * 887503681;
    }
}
