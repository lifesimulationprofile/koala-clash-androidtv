package androidx.compose.foundation.border;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxMeasurePolicy;
import androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda1;
import androidx.compose.material3.internal.ripple.BorderKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Dp;
import java.io.Serializable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.DurationKt;
import okhttp3.Request;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BorderLogic$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Serializable f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ BorderLogic$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Serializable serializable, Object obj4, Object obj5, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = serializable;
        this.f$4 = obj4;
        this.f$5 = obj5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Request request = (Request) this.f$0;
                RoundRect roundRect = (RoundRect) this.f$1;
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) this.f$2;
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.f$3;
                AndroidPath androidPath = (AndroidPath) this.f$4;
                Brush brush = (Brush) this.f$5;
                DrawScope drawScope = (DrawScope) obj;
                float fFloatValue = Float.valueOf(((StyleOuterNode$$ExternalSyntheticLambda1) request.method).f$0).floatValue();
                if (fFloatValue < 0.0f) {
                    fFloatValue = 0.0f;
                }
                boolean z = ((float) 2) * fFloatValue > Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
                if (ref$FloatRef.element != fFloatValue) {
                    androidPath.reset();
                    Modifier.CC.addRoundRect$default(androidPath, roundRect);
                    if (!z) {
                        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
                        Modifier.CC.addRoundRect$default(androidPathPath, new RoundRect(roundRect.left + fFloatValue, roundRect.top + fFloatValue, roundRect.right - fFloatValue, roundRect.bottom - fFloatValue, DurationKt.m840shrinkKibmq7A(fFloatValue, roundRect.topLeftCornerRadius), DurationKt.m840shrinkKibmq7A(fFloatValue, roundRect.topRightCornerRadius), DurationKt.m840shrinkKibmq7A(fFloatValue, roundRect.bottomRightCornerRadius), DurationKt.m840shrinkKibmq7A(fFloatValue, roundRect.bottomLeftCornerRadius)));
                        androidPath.m409opN5in7k0(androidPath, androidPathPath, 0);
                    }
                    ref$ObjectRef.element = androidPath;
                    ref$FloatRef.element = fFloatValue;
                }
                Modifier.CC.m312drawPathGBMwjPU$default(drawScope, (AndroidPath) ref$ObjectRef.element, brush, 0.0f, null, null, 0, 60);
                break;
            case 1:
                Placeable[] placeableArr = (Placeable[]) this.f$0;
                List list = (List) this.f$1;
                MeasureScope measureScope = (MeasureScope) this.f$2;
                Ref$IntRef ref$IntRef = (Ref$IntRef) this.f$3;
                Ref$IntRef ref$IntRef2 = (Ref$IntRef) this.f$4;
                BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) this.f$5;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int length = placeableArr.length;
                int i = 0;
                int i2 = 0;
                while (i2 < length) {
                    BoxKt.access$placeInBox(placementScope, placeableArr[i2], (Measurable) list.get(i), measureScope.getLayoutDirection(), ref$IntRef.element, ref$IntRef2.element, boxMeasurePolicy.alignment);
                    i2++;
                    i++;
                }
                break;
            default:
                Http2Connection.Builder builder = (Http2Connection.Builder) this.f$0;
                Ref$FloatRef ref$FloatRef2 = (Ref$FloatRef) this.f$2;
                Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) this.f$3;
                AndroidPath androidPath2 = (AndroidPath) this.f$4;
                Outline$Rounded outline$Rounded = (Outline$Rounded) this.f$1;
                SolidColor solidColor = (SolidColor) this.f$5;
                DrawScope drawScope2 = (DrawScope) obj;
                float f = ((Dp) ((Function0) builder.socket).invoke()).value;
                float f2 = 2;
                float fMin = Math.min(Dp.m704equalsimpl0(f, 0.0f) ? 1.0f : (float) Math.ceil(drawScope2.mo92toPx0680j_4(f)), (float) Math.ceil((Size.m386getMinDimensionimpl(drawScope2.mo474getSizeNHjbRc()) - (((float) Math.ceil(drawScope2.mo92toPx0680j_4(((Dp) ((Function0) builder.connectionName).invoke()).value))) * f2)) / f2));
                if (fMin < 0.0f) {
                    fMin = 0.0f;
                }
                float fCeil = (float) Math.ceil(drawScope2.mo92toPx0680j_4(((Dp) ((Function0) builder.connectionName).invoke()).value));
                boolean z2 = fCeil == 0.0f && f2 * fMin > Size.m386getMinDimensionimpl(drawScope2.mo474getSizeNHjbRc());
                if (ref$FloatRef2.element != fMin) {
                    RoundRect roundRect2 = outline$Rounded.roundRect;
                    androidPath2.reset();
                    Modifier.CC.addRoundRect$default(androidPath2, BorderKt.createInsetRoundedRect(fCeil, roundRect2));
                    if (!z2) {
                        AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
                        Modifier.CC.addRoundRect$default(androidPathPath2, BorderKt.createInsetRoundedRect(fCeil + fMin, roundRect2));
                        androidPath2.m409opN5in7k0(androidPath2, androidPathPath2, 0);
                    }
                    ref$ObjectRef2.element = androidPath2;
                    ref$FloatRef2.element = fMin;
                }
                Modifier.CC.m312drawPathGBMwjPU$default(drawScope2, (AndroidPath) ref$ObjectRef2.element, solidColor, 0.0f, null, null, 0, 60);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ BorderLogic$$ExternalSyntheticLambda1(Http2Connection.Builder builder, Ref$FloatRef ref$FloatRef, Ref$ObjectRef ref$ObjectRef, AndroidPath androidPath, Outline$Rounded outline$Rounded, SolidColor solidColor) {
        this.$r8$classId = 2;
        this.f$0 = builder;
        this.f$2 = ref$FloatRef;
        this.f$3 = ref$ObjectRef;
        this.f$4 = androidPath;
        this.f$1 = outline$Rounded;
        this.f$5 = solidColor;
    }
}
