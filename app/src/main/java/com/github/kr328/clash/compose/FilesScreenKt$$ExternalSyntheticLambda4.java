package com.github.kr328.clash.compose;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import com.github.kr328.clash.design.model.File;
import dev.chrisbanes.haze.HazeState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesScreenKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Function0 f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ int f$5;

    public /* synthetic */ FilesScreenKt$$ExternalSyntheticLambda4(File file, boolean z, boolean z2, Function0 function0, Function1 function1, int i) {
        this.f$0 = file;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = function0;
        this.f$4 = function1;
        this.f$5 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).intValue();
                FilesScreenKt.FileMenuSheet((File) this.f$0, this.f$1, this.f$2, this.f$3, (Function1) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$5 | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                HomeScreenKt.ProxyBar(this.f$1, (String) this.f$0, this.f$3, (HazeState) this.f$4, this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$5 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(7);
                ProxyScreenKt.SegmentedPill((String) this.f$0, this.f$1, this.f$3, (Modifier) this.f$4, this.f$2, (GapComposer) obj, iUpdateChangedFlags, this.f$5);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ FilesScreenKt$$ExternalSyntheticLambda4(String str, boolean z, Function0 function0, Modifier modifier, boolean z2, int i, int i2) {
        this.f$0 = str;
        this.f$1 = z;
        this.f$3 = function0;
        this.f$4 = modifier;
        this.f$2 = z2;
        this.f$5 = i2;
    }

    public /* synthetic */ FilesScreenKt$$ExternalSyntheticLambda4(boolean z, String str, Function0 function0, HazeState hazeState, boolean z2, int i) {
        this.f$1 = z;
        this.f$0 = str;
        this.f$3 = function0;
        this.f$4 = hazeState;
        this.f$2 = z2;
        this.f$5 = i;
    }
}
