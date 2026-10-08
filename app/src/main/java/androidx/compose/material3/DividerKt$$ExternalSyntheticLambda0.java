package androidx.compose.material3;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DividerKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ float f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ DividerKt$$ExternalSyntheticLambda0(float f, int i, long j) {
        this.$r8$classId = i;
        this.f$0 = f;
        this.f$1 = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                DrawScope drawScope = (DrawScope) obj;
                float f = this.f$0;
                float fMo92toPx0680j_4 = drawScope.mo92toPx0680j_4(f);
                float f2 = 2;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(drawScope.mo92toPx0680j_4(f) / f2)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L);
                float fMo92toPx0680j_5 = drawScope.mo92toPx0680j_4(f) / f2;
                drawScope.mo466drawLineNGM6Ib0(this.f$1, jFloatToRawIntBits, (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(fMo92toPx0680j_5)) << 32), fMo92toPx0680j_4, (496 & 16) != 0 ? 0 : 0);
                break;
            default:
                DrawScope drawScope2 = (DrawScope) obj;
                float f3 = this.f$0;
                float fMo92toPx0680j_6 = drawScope2.mo92toPx0680j_4(f3);
                float f4 = 2;
                drawScope2.mo466drawLineNGM6Ib0(this.f$1, (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(drawScope2.mo92toPx0680j_4(f3) / f4)) & 4294967295L), (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo474getSizeNHjbRc() >> 32)))) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(drawScope2.mo92toPx0680j_4(f3) / f4))), fMo92toPx0680j_6, (496 & 16) != 0 ? 0 : 0);
                break;
        }
        return Unit.INSTANCE;
    }
}
