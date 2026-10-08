package com.github.kr328.clash.compose.home;

import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.github.kr328.clash.service.model.Profile;
import dev.chrisbanes.haze.HazeState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda5(Object obj, Object obj2, boolean z, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = z;
        this.f$3 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(this.f$3 | 1);
                HomeScreenKt.TrafficDaysCard((Profile) this.f$0, (HazeState) this.f$1, this.f$2, (GapComposer) obj, iUpdateChangedFlags);
                break;
            case 1:
                Modifier modifier = (Modifier) this.f$0;
                Function0 function0 = (Function0) this.f$1;
                ((Integer) obj2).getClass();
                SimpleLayoutKt.SelectionHandleIcon(Stack.updateChangedFlags(this.f$3 | 1), (GapComposer) obj, modifier, function0, this.f$2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(this.f$3 | 1);
                HomeScreenKt.AnnounceCard((String) this.f$0, (HazeState) this.f$1, this.f$2, (GapComposer) obj, iUpdateChangedFlags2);
                break;
        }
        return Unit.INSTANCE;
    }
}
