package androidx.compose.ui.text;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MultiParagraph$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda1(int i, int i2, Placeable placeable) {
        this.$r8$classId = 3;
        this.f$1 = i;
        this.f$0 = placeable;
        this.f$2 = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                AndroidPath androidPath = (AndroidPath) this.f$0;
                ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
                AndroidParagraph androidParagraph = paragraphInfo.paragraph;
                int localIndex = paragraphInfo.toLocalIndex(this.f$1);
                int localIndex2 = paragraphInfo.toLocalIndex(this.f$2);
                CharSequence charSequence = androidParagraph.charSequence;
                if (localIndex < 0 || localIndex > localIndex2 || localIndex2 > charSequence.length()) {
                    InlineClassHelperKt.throwIllegalArgumentException("start(" + localIndex + ") or end(" + localIndex2 + ") is out of range [0.." + charSequence.length() + "], or start > end!");
                }
                Path path = new Path();
                TextLayout textLayout = androidParagraph.layout;
                textLayout.layout.getSelectionPath(localIndex, localIndex2, path);
                int i = textLayout.topPadding;
                if (i != 0 && !path.isEmpty()) {
                    path.offset(0.0f, i);
                }
                AndroidPath androidPath2 = new AndroidPath(path);
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(paragraphInfo.top)) & 4294967295L);
                Matrix matrix = androidPath2.mMatrix;
                if (matrix == null) {
                    androidPath2.mMatrix = new Matrix();
                } else {
                    matrix.reset();
                }
                androidPath2.mMatrix.setTranslate(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)));
                path.transform(androidPath2.mMatrix);
                Modifier.CC.m307addPathUv8p0NA$default(androidPath, androidPath2);
                break;
            case 1:
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, (Placeable) this.f$0, this.f$1, this.f$2);
                break;
            case 2:
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, (Placeable) this.f$0, this.f$1, this.f$2);
                break;
            default:
                Placeable placeable = (Placeable) this.f$0;
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, placeable, MathKt.roundToInt((this.f$1 - placeable.width) / 2.0f), MathKt.roundToInt((this.f$2 - placeable.height) / 2.0f));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda1(Object obj, int i, int i2, int i3) {
        this.$r8$classId = i3;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = i2;
    }
}
