package com.github.kr328.clash.compose.util;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.google.android.gms.internal.mlkit_vision_common.zzir;
import dev.chrisbanes.haze.HazeState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvGlassTabRowKt$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ int $r8$classId = 2;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda8(String str, Function1 function1, boolean z, Function0 function0, Function0 function2, Function0 function3, int i) {
        this.f$0 = str;
        this.f$3 = function1;
        this.f$1 = z;
        this.f$2 = function0;
        this.f$4 = function2;
        this.f$5 = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                TvGlassTabRowKt.TvGlassTab((String) this.f$0, this.f$1, (Function0) this.f$2, (FocusRequester) this.f$3, (Function3) this.f$4, (Modifier) this.f$5, (GapComposer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(385);
                ConnectionsScreenKt.ConnectionListContent((List) this.f$0, (List) this.f$2, (Function2) this.f$3, (PaddingValues) this.f$4, this.f$1, (HazeState) this.f$5, (GapComposer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(1);
                zzir.LinkInputRow((String) this.f$0, (Function1) this.f$3, this.f$1, (Function0) this.f$2, (Function0) this.f$4, (Function0) this.f$5, (GapComposer) obj, iUpdateChangedFlags3);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda8(String str, boolean z, Function0 function0, FocusRequester focusRequester, Function3 function3, Modifier modifier, int i) {
        this.f$0 = str;
        this.f$1 = z;
        this.f$2 = function0;
        this.f$3 = focusRequester;
        this.f$4 = function3;
        this.f$5 = modifier;
    }

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda8(List list, List list2, Function2 function2, PaddingValues paddingValues, boolean z, HazeState hazeState, int i) {
        this.f$0 = list;
        this.f$2 = list2;
        this.f$3 = function2;
        this.f$4 = paddingValues;
        this.f$1 = z;
        this.f$5 = hazeState;
    }
}
