package com.github.kr328.clash.design.compose.components;

import androidx.compose.runtime.GapComposer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.github.kr328.clash.design.compose.components.ComposableSingletons$PreferenceScaffoldKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$PreferenceScaffoldKt$lambda1$1 implements Function3 {
    public static final ComposableSingletons$PreferenceScaffoldKt$lambda1$1 INSTANCE = new ComposableSingletons$PreferenceScaffoldKt$lambda1$1();

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        GapComposer gapComposer = (GapComposer) obj2;
        if ((((Number) obj3).intValue() & 17) == 16 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
