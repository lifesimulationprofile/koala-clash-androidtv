package com.github.kr328.clash.compose.util;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvGlassTabRowKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Animatable f$0;

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda1(Animatable animatable, int i) {
        this.$r8$classId = i;
        this.f$0 = animatable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((ReusableGraphicsLayerScope) obj).setTranslationX(((Number) this.f$0.getValue()).floatValue());
                return Unit.INSTANCE;
            case 1:
                return new IntOffset((((long) MathKt.roundToInt(((Number) this.f$0.getValue()).floatValue())) << 32) | (((long) 0) & 4294967295L));
            default:
                ((ReusableGraphicsLayerScope) obj).setTranslationX(((Number) this.f$0.getValue()).floatValue());
                return Unit.INSTANCE;
        }
    }
}
