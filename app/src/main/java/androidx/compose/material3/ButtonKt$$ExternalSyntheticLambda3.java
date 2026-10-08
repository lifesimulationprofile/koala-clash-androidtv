package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.google.android.gms.internal.mlkit_vision_common.zzje;
import dev.chrisbanes.haze.HazeState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ButtonKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ int f$10;
    public final /* synthetic */ int f$11;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda3(Function0 function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, PaddingValues paddingValues, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.$r8$classId = 0;
        this.f$0 = function0;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$3 = shape;
        this.f$4 = buttonColors;
        this.f$5 = buttonElevation;
        this.f$7 = paddingValues;
        this.f$9 = composableLambdaImpl;
        this.f$10 = i;
        this.f$11 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                ScrimKt.Button(this.f$0, this.f$1, this.f$2, (Shape) this.f$3, (ButtonColors) this.f$4, (ButtonElevation) this.f$5, (PaddingValues) this.f$7, (ComposableLambdaImpl) this.f$9, (GapComposer) obj, Stack.updateChangedFlags(this.f$10 | 1), this.f$11);
                break;
            case 1:
                ((Integer) obj2).getClass();
                HomeScreenKt.HomeScreen(this.f$0, (Function0) this.f$3, (Function0) this.f$4, (Function0) this.f$5, (PaddingValuesImpl) this.f$7, this.f$1, (HazeState) this.f$9, this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$10 | 1), this.f$11);
                break;
            default:
                ((Integer) obj2).getClass();
                zzje.SettingsScreen(this.f$0, (Function0) this.f$3, (Function0) this.f$4, (Function0) this.f$5, (Function0) this.f$7, this.f$1, (PaddingValuesImpl) this.f$9, this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$10 | 1), this.f$11);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda3(Function0 function0, Function0 function1, Function0 function2, Function0 function3, Object obj, Modifier modifier, Object obj2, boolean z, int i, int i2, int i3) {
        this.$r8$classId = i3;
        this.f$0 = function0;
        this.f$3 = function1;
        this.f$4 = function2;
        this.f$5 = function3;
        this.f$7 = obj;
        this.f$1 = modifier;
        this.f$9 = obj2;
        this.f$2 = z;
        this.f$10 = i;
        this.f$11 = i2;
    }
}
