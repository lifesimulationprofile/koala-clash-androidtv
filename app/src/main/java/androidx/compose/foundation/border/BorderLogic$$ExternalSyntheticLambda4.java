package androidx.compose.foundation.border;

import androidx.compose.animation.core.Animation;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.core.view.MenuHostHelper;
import coil.request.Parameters;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BorderLogic$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ float f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ BorderLogic$$ExternalSyntheticLambda4(Rect rect, Outline$Generic outline$Generic, Brush brush, float f, AndroidPath androidPath) {
        this.f$0 = rect;
        this.f$1 = outline$Generic;
        this.f$2 = brush;
        this.f$3 = f;
        this.f$4 = androidPath;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        long j;
        switch (this.$r8$classId) {
            case 0:
                Rect rect = (Rect) this.f$0;
                Outline$Generic outline$Generic = (Outline$Generic) this.f$1;
                Brush brush = (Brush) this.f$2;
                float f = this.f$3;
                AndroidPath androidPath = (AndroidPath) this.f$4;
                DrawScope drawScope = (DrawScope) obj;
                float f2 = -rect.left;
                float f3 = -rect.top;
                ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(f2, f3);
                try {
                    Modifier.CC.m312drawPathGBMwjPU$default(drawScope, outline$Generic.path, brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, 30), null, 0, 52);
                    float f4 = 1;
                    float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32)) + f4) / Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32));
                    float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L)) + f4) / Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L));
                    long jMo473getCenterF1C5BW0 = drawScope.mo473getCenterF1C5BW0();
                    MenuHostHelper drawContext = drawScope.getDrawContext();
                    long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    try {
                        ((Parameters.Builder) drawContext.mOnInvalidateMenuCallback).m792scale0AR0LA0(fIntBitsToFloat, fIntBitsToFloat2, jMo473getCenterF1C5BW0);
                        j = jM756getSizeNHjbRc;
                        try {
                            Modifier.CC.m312drawPathGBMwjPU$default(drawScope, androidPath, brush, 0.0f, null, null, 0, 28);
                            drawContext.getCanvas().restore();
                            drawContext.m758setSizeuvyYCjk(j);
                            ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-f2, -f3);
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            drawContext.getCanvas().restore();
                            drawContext.m758setSizeuvyYCjk(j);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        j = jM756getSizeNHjbRc;
                    }
                } catch (Throwable th3) {
                    ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-f2, -f3);
                    throw th3;
                }
                break;
            default:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.f$0;
                ArcSplineKt.doAnimationFrameWithScale((AnimationScope) ref$ObjectRef.element, ((Long) obj).longValue(), this.f$3, (Animation) this.f$1, (AnimationState) this.f$2, (Function1) this.f$4);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ BorderLogic$$ExternalSyntheticLambda4(Ref$ObjectRef ref$ObjectRef, float f, Animation animation, AnimationState animationState, Function1 function1) {
        this.f$0 = ref$ObjectRef;
        this.f$3 = f;
        this.f$1 = animation;
        this.f$2 = animationState;
        this.f$4 = function1;
    }
}
