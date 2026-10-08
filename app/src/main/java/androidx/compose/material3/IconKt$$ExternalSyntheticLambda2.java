package androidx.compose.material3;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.github.kr328.clash.compose.FilesScreenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IconKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ long f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ IconKt$$ExternalSyntheticLambda2(Painter painter, String str, Modifier modifier, long j, int i) {
        this.f$0 = painter;
        this.f$1 = str;
        this.f$2 = modifier;
        this.f$3 = j;
        this.f$4 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                IconKt.m248Iconww6aTOc((Painter) this.f$0, (String) this.f$1, (Modifier) this.f$2, this.f$3, (GapComposer) obj, Stack.updateChangedFlags(this.f$4 | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                ScrimKt.m266ModalBottomSheetDialogsW7UJKQ((Function0) this.f$0, this.f$3, (ModalBottomSheetProperties) this.f$1, (ComposableLambdaImpl) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$4 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                FilesScreenKt.m802MenuRowcf5BqRc((ImageVector) this.f$0, (String) this.f$1, this.f$3, (Function0) this.f$2, (GapComposer) obj, iUpdateChangedFlags, this.f$4);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ IconKt$$ExternalSyntheticLambda2(ImageVector imageVector, String str, long j, Function0 function0, int i, int i2) {
        this.f$0 = imageVector;
        this.f$1 = str;
        this.f$3 = j;
        this.f$2 = function0;
        this.f$4 = i2;
    }

    public /* synthetic */ IconKt$$ExternalSyntheticLambda2(Function0 function0, long j, ModalBottomSheetProperties modalBottomSheetProperties, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = function0;
        this.f$3 = j;
        this.f$1 = modalBottomSheetProperties;
        this.f$2 = composableLambdaImpl;
        this.f$4 = i;
    }
}
