package com.github.kr328.clash.compose.util;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvGlassTabRowKt$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function3 f$0;

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda5(Function3 function3, int i) {
        this.$r8$classId = i;
        this.f$0 = function3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj;
        switch (this.$r8$classId) {
            case 0:
                LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                this.f$0.invoke(Float.valueOf(Float.intBitsToFloat((int) ((parentLayoutCoordinates != null ? parentLayoutCoordinates.mo523localPositionOfR5De75A(layoutCoordinates, 0L) : 0L) >> 32))), Float.valueOf((int) (layoutCoordinates.mo522getSizeYbymL2g() >> 32)), Float.valueOf((int) (layoutCoordinates.mo522getSizeYbymL2g() & 4294967295L)));
                break;
            default:
                LayoutCoordinates parentLayoutCoordinates2 = layoutCoordinates.getParentLayoutCoordinates();
                this.f$0.invoke(Float.valueOf(Float.intBitsToFloat((int) ((parentLayoutCoordinates2 != null ? parentLayoutCoordinates2.mo523localPositionOfR5De75A(layoutCoordinates, 0L) : 0L) >> 32))), Float.valueOf((int) (layoutCoordinates.mo522getSizeYbymL2g() >> 32)), Float.valueOf((int) (layoutCoordinates.mo522getSizeYbymL2g() & 4294967295L)));
                break;
        }
        return Unit.INSTANCE;
    }
}
