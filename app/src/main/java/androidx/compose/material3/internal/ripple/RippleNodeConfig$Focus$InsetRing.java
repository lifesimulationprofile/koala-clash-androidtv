package androidx.compose.material3.internal.ripple;

import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RippleNodeConfig$Focus$InsetRing extends zzry {
    public final FiniteAnimationSpec focusingAnimationSpec;
    public final Toolbar.AnonymousClass1 innerStrokeColor;
    public final float innerStrokeInset;
    public final float innerStrokeWidth;
    public final DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1 outerStrokeColor;
    public final float outerStrokeInset;
    public final float outerStrokeWidth;
    public final Shape shape;
    public final FiniteAnimationSpec unfocusingAnimationSpec;

    public RippleNodeConfig$Focus$InsetRing(Shape shape, float f, float f2, DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1 delegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1, float f3, float f4, Toolbar.AnonymousClass1 anonymousClass1, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2) {
        this.shape = shape;
        this.outerStrokeInset = f;
        this.outerStrokeWidth = f2;
        this.outerStrokeColor = delegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1;
        this.innerStrokeInset = f3;
        this.innerStrokeWidth = f4;
        this.innerStrokeColor = anonymousClass1;
        this.focusingAnimationSpec = finiteAnimationSpec;
        this.unfocusingAnimationSpec = finiteAnimationSpec2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleNodeConfig$Focus$InsetRing)) {
            return false;
        }
        RippleNodeConfig$Focus$InsetRing rippleNodeConfig$Focus$InsetRing = (RippleNodeConfig$Focus$InsetRing) obj;
        return Intrinsics.areEqual(this.shape, rippleNodeConfig$Focus$InsetRing.shape) && Dp.m704equalsimpl0(this.outerStrokeInset, rippleNodeConfig$Focus$InsetRing.outerStrokeInset) && Dp.m704equalsimpl0(this.outerStrokeWidth, rippleNodeConfig$Focus$InsetRing.outerStrokeWidth) && this.outerStrokeColor.equals(rippleNodeConfig$Focus$InsetRing.outerStrokeColor) && Dp.m704equalsimpl0(this.innerStrokeInset, rippleNodeConfig$Focus$InsetRing.innerStrokeInset) && Dp.m704equalsimpl0(this.innerStrokeWidth, rippleNodeConfig$Focus$InsetRing.innerStrokeWidth) && this.innerStrokeColor.equals(rippleNodeConfig$Focus$InsetRing.innerStrokeColor) && Intrinsics.areEqual(this.focusingAnimationSpec, rippleNodeConfig$Focus$InsetRing.focusingAnimationSpec) && Intrinsics.areEqual(this.unfocusingAnimationSpec, rippleNodeConfig$Focus$InsetRing.unfocusingAnimationSpec);
    }

    public final int hashCode() {
        return this.unfocusingAnimationSpec.hashCode() + ((this.focusingAnimationSpec.hashCode() + ((this.innerStrokeColor.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.innerStrokeWidth, ImageAnalysis$$ExternalSyntheticLambda1.m(this.innerStrokeInset, (this.outerStrokeColor.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.outerStrokeWidth, ImageAnalysis$$ExternalSyntheticLambda1.m(this.outerStrokeInset, this.shape.hashCode() * 31, 31), 31)) * 31, 31), 31)) * 31)) * 31);
    }
}
