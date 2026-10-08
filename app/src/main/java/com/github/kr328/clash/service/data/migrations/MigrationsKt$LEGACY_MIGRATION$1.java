package com.github.kr328.clash.service.data.migrations;

import android.content.Context;
import io.github.g00fy2.quickie.ScanQRCode;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MigrationsKt$LEGACY_MIGRATION$1 extends FunctionReferenceImpl implements Function2 {
    public static final MigrationsKt$LEGACY_MIGRATION$1 INSTANCE = new MigrationsKt$LEGACY_MIGRATION$1(2, ScanQRCode.class, "migrationFromLegacy", "migrationFromLegacy(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ScanQRCode.migrationFromLegacy((Context) obj, (Continuation) obj2);
    }
}
