package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ MutableTransitionState f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ ScrollState f$3;
    public final /* synthetic */ Shape f$4;
    public final /* synthetic */ long f$5;
    public final /* synthetic */ float f$6;
    public final /* synthetic */ float f$7;
    public final /* synthetic */ ComposableLambdaImpl f$9;

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda2(Modifier modifier, MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, Shape shape, long j, float f, float f2, ComposableLambdaImpl composableLambdaImpl) {
        this.f$0 = modifier;
        this.f$1 = mutableTransitionState;
        this.f$2 = mutableState;
        this.f$3 = scrollState;
        this.f$4 = shape;
        this.f$5 = j;
        this.f$6 = f;
        this.f$7 = f2;
        this.f$9 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                MenuKt.m250DropdownMenuContentQj0Zi0g(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$9, (GapComposer) obj, Stack.updateChangedFlags(385));
                break;
            default:
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    MenuKt.m250DropdownMenuContentQj0Zi0g(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$9, gapComposer, 384);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda2(Modifier modifier, MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, Shape shape, long j, float f, float f2, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$0 = modifier;
        this.f$1 = mutableTransitionState;
        this.f$2 = mutableState;
        this.f$3 = scrollState;
        this.f$4 = shape;
        this.f$5 = j;
        this.f$6 = f;
        this.f$7 = f2;
        this.f$9 = composableLambdaImpl;
    }
}
