package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.BiasAlignment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ChangeSize {
    public final BiasAlignment alignment;
    public final FiniteAnimationSpec animationSpec;
    public final Lambda size;

    /* JADX WARN: Multi-variable type inference failed */
    public ChangeSize(BiasAlignment biasAlignment, Function1 function1, FiniteAnimationSpec finiteAnimationSpec) {
        this.alignment = biasAlignment;
        this.size = (Lambda) function1;
        this.animationSpec = finiteAnimationSpec;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeSize)) {
            return false;
        }
        ChangeSize changeSize = (ChangeSize) obj;
        return this.alignment.equals(changeSize.alignment) && this.size.equals(changeSize.size) && Intrinsics.areEqual(this.animationSpec, changeSize.animationSpec);
    }

    public final int hashCode() {
        return ((this.animationSpec.hashCode() + ((this.size.hashCode() + (this.alignment.hashCode() * 31)) * 31)) * 31) + 1231;
    }

    public final String toString() {
        return "ChangeSize(alignment=" + this.alignment + ", size=" + this.size + ", animationSpec=" + this.animationSpec + ", clip=true)";
    }
}
