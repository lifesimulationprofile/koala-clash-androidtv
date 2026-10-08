package com.github.kr328.clash.service.data.migrations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.github.g00fy2.quickie.ScanQRCode;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyMigrationKt$migrationFromLegacy$1 extends ContinuationImpl {
    public Context L$0;
    public SQLiteDatabase L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ScanQRCode.migrationFromLegacy(null, this);
    }
}
