package com.github.kr328.clash.compose.util;

import androidx.compose.foundation.text.selection.SelectableInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvGlassTabRowKt$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda2(int i, int i2, Object obj) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                ((Function1) this.f$0).invoke(Integer.valueOf(this.f$1));
                return Unit.INSTANCE;
            case 1:
                ((Function1) this.f$0).invoke(Integer.valueOf(this.f$1));
                return Unit.INSTANCE;
            case 2:
                ((Function1) this.f$0).invoke(Integer.valueOf(this.f$1));
                return Unit.INSTANCE;
            default:
                return Integer.valueOf(((SelectableInfo) this.f$0).textLayoutResult.multiParagraph.getLineForOffset(this.f$1));
        }
    }
}
