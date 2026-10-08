package com.github.kr328.clash;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.core.Transition;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import com.github.kr328.clash.compose.MainAppKt;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesActivity$$ExternalSyntheticLambda16 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda16(int i, int i2, Object obj, Object obj2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$2 = obj2;
        this.f$3 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        int i2 = this.f$3;
        Object obj3 = this.f$2;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                int i3 = FilesActivity.$r8$clinit;
                ((FilesActivity) obj4).DisposableBackPressed((Function0) obj3, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                break;
            case 1:
                ((Integer) obj2).intValue();
                ((Transition) obj4).animateTo$animation_core(obj3, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                break;
            case 2:
                ((Integer) obj2).intValue();
                Stack.CompositionLocalProvider((ProvidedValue) obj4, (Function2) obj3, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                break;
            case 3:
                ((Integer) obj2).intValue();
                Stack.CompositionLocalProvider((ProvidedValue[]) obj4, (Function2) obj3, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                break;
            case 4:
                ((Integer) obj2).intValue();
                ((ComposableLambdaImpl) obj4).invoke(obj3, (GapComposer) obj, Stack.updateChangedFlags(i2) | 1);
                break;
            case 5:
                ((Integer) obj2).getClass();
                MainAppKt.ScreenWrapper((AnimatedVisibilityScope) obj4, (ComposableLambdaImpl) obj3, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                break;
            case 6:
                ((Integer) obj2).getClass();
                ConnectionsScreenKt.DetailRow((String) obj4, (String) obj3, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                GlassSnackbarKt.GlassSnackbar((SnackbarHostState.SnackbarDataImpl) obj4, (Modifier) obj3, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                break;
        }
        return Unit.INSTANCE;
    }
}
