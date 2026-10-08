package com.github.kr328.clash.compose.home;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import dev.chrisbanes.haze.HazeState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Modifier f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda3(Modifier modifier, boolean z, Function0 function0, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$3 = modifier;
        this.f$2 = z;
        this.f$0 = function0;
        this.f$1 = composableLambdaImpl;
        this.f$4 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                HomeScreenKt.EmptyHomeContent(this.f$0, (HazeState) this.f$1, this.f$2, this.f$3, (GapComposer) obj, Stack.updateChangedFlags(this.f$4 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                zzjo.PreferenceContainer(this.f$3, this.f$2, this.f$0, (ComposableLambdaImpl) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(this.f$4 | 1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda3(Function0 function0, HazeState hazeState, boolean z, Modifier modifier, int i) {
        this.f$0 = function0;
        this.f$1 = hazeState;
        this.f$2 = z;
        this.f$3 = modifier;
        this.f$4 = i;
    }
}
