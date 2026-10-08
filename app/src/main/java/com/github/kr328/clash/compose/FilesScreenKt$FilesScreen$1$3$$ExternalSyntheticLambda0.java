package com.github.kr328.clash.compose;

import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.design.model.AppInfoSort;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(Function1 function1, int i) {
        this.$r8$classId = i;
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.invoke(new FileAction.Import(null));
                break;
            case 1:
                this.f$0.invoke(TunnelState.Mode.Rule);
                break;
            case 2:
                this.f$0.invoke(TunnelState.Mode.Global);
                break;
            case 3:
                this.f$0.invoke(ProxySort.Default);
                break;
            case 4:
                this.f$0.invoke(ProxySort.Title);
                break;
            case 5:
                this.f$0.invoke(ProxySort.Delay);
                break;
            case 6:
                this.f$0.invoke(AppInfoSort.Label);
                break;
            case 7:
                this.f$0.invoke(AppInfoSort.PackageName);
                break;
            case 8:
                this.f$0.invoke(AppInfoSort.InstallTime);
                break;
            default:
                this.f$0.invoke(AppInfoSort.UpdateTime);
                break;
        }
        return Unit.INSTANCE;
    }
}
