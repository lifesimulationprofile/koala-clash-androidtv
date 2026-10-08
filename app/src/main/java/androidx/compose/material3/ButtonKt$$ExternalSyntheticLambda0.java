package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ButtonKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId = 2;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ int f$10;
    public final /* synthetic */ int f$11;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda0(String str, List list, List list2, int i, Function1 function1, Modifier modifier, ImageVector imageVector, boolean z, int i2, int i3) {
        this.f$0 = str;
        this.f$3 = list;
        this.f$4 = list2;
        this.f$10 = i;
        this.f$7 = function1;
        this.f$1 = modifier;
        this.f$9 = imageVector;
        this.f$2 = z;
        this.f$11 = i3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                ScrimKt.TextButton((Function0) this.f$0, this.f$1, this.f$2, (Shape) this.f$3, (ButtonColors) this.f$4, (PaddingValues) this.f$7, (ComposableLambdaImpl) this.f$9, (GapComposer) obj, Stack.updateChangedFlags(this.f$10 | 1), this.f$11);
                break;
            case 1:
                ((Integer) obj2).getClass();
                zzjo.PreferenceClickable((String) this.f$3, (Function0) this.f$0, this.f$1, (String) this.f$4, (ImageVector) this.f$7, this.f$2, (Function2) this.f$9, (GapComposer) obj, Stack.updateChangedFlags(this.f$10 | 1), this.f$11);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(49);
                zzjo.PreferenceSelectable((String) this.f$0, (List) this.f$3, (List) this.f$4, this.f$10, (Function1) this.f$7, this.f$1, (ImageVector) this.f$9, this.f$2, (GapComposer) obj, iUpdateChangedFlags, this.f$11);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda0(String str, Function0 function0, Modifier modifier, String str2, ImageVector imageVector, boolean z, Function2 function2, int i, int i2) {
        this.f$3 = str;
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$4 = str2;
        this.f$7 = imageVector;
        this.f$2 = z;
        this.f$9 = function2;
        this.f$10 = i;
        this.f$11 = i2;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda0(Function0 function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, PaddingValues paddingValues, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$3 = shape;
        this.f$4 = buttonColors;
        this.f$7 = paddingValues;
        this.f$9 = composableLambdaImpl;
        this.f$10 = i;
        this.f$11 = i2;
    }
}
