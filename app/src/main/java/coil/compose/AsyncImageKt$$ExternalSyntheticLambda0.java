package coil.compose;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import com.google.android.gms.internal.mlkit_vision_common.zzjn;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AsyncImageKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$11;
    public final /* synthetic */ int f$12;
    public final /* synthetic */ Modifier f$2;
    public final /* synthetic */ Function f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;

    public /* synthetic */ AsyncImageKt$$ExternalSyntheticLambda0(AsyncImageState asyncImageState, Modifier modifier, Function1 function1, Function1 function2, Alignment alignment, ContentScale contentScale, int i, int i2) {
        this.f$0 = asyncImageState;
        this.f$2 = modifier;
        this.f$3 = function1;
        this.f$4 = function2;
        this.f$5 = alignment;
        this.f$6 = contentScale;
        this.f$11 = i;
        this.f$12 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                AsyncImageKt.m777AsyncImage76YX9Dk((AsyncImageState) this.f$0, this.f$2, (Function1) this.f$3, (Function1) this.f$4, (Alignment) this.f$5, (ContentScale) this.f$6, (GapComposer) obj, Stack.updateChangedFlags(this.f$11 | 1), Stack.updateChangedFlags(this.f$12));
                break;
            default:
                ((Integer) obj2).getClass();
                zzjn.PreferenceScaffold((String) this.f$0, (Function0) this.f$3, this.f$2, (SnackbarHostState) this.f$4, (Function3) this.f$5, (ComposableLambdaImpl) this.f$6, (GapComposer) obj, Stack.updateChangedFlags(this.f$11 | 1), this.f$12);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ AsyncImageKt$$ExternalSyntheticLambda0(String str, Function0 function0, Modifier modifier, SnackbarHostState snackbarHostState, Function3 function3, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$0 = str;
        this.f$3 = function0;
        this.f$2 = modifier;
        this.f$4 = snackbarHostState;
        this.f$5 = function3;
        this.f$6 = composableLambdaImpl;
        this.f$11 = i;
        this.f$12 = i2;
    }
}
