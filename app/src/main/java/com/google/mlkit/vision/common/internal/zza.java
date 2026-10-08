package com.google.mlkit.vision.common.internal;

import android.database.Cursor;
import androidx.core.view.MenuHostHelper;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.ImportedDao_Impl$2;
import com.github.kr328.clash.service.data.Selection;
import com.google.android.gms.internal.mlkit_vision_common.zzlv;
import com.google.android.gms.internal.mlkit_vision_common.zzlx;
import com.google.android.gms.internal.mlkit_vision_common.zzmv;
import com.google.android.gms.internal.mlkit_vision_common.zzmw;
import com.google.mlkit.vision.barcode.internal.zzh;
import com.google.mlkit.vision.common.InputImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Unit;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zza implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zza(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.zzb = obj;
        this.zza = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzlx zzlxVar;
        int i = this.$r8$classId;
        Object obj = this.zza;
        Object obj2 = this.zzb;
        switch (i) {
            case 0:
                zzh zzhVar = (zzh) obj;
                InputImage inputImage = (InputImage) obj2;
                HashMap map = zzlx.zza;
                zzmw.zza();
                int i2 = zzmv.$r8$clinit;
                zzmw.zza();
                if (Boolean.parseBoolean("")) {
                    HashMap map2 = zzlx.zza;
                    if (map2.get("detectorTaskWithResource#run") == null) {
                        map2.put("detectorTaskWithResource#run", new zzlx("detectorTaskWithResource#run"));
                    }
                    zzlxVar = (zzlx) map2.get("detectorTaskWithResource#run");
                } else {
                    zzlxVar = zzlv.zza;
                }
                zzlxVar.zzb();
                try {
                    List listRun = zzhVar.zzd.run(inputImage);
                    zzlxVar.close();
                    return listRun;
                } catch (Throwable th) {
                    try {
                        zzlxVar.close();
                        break;
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            break;
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            case 1:
                Dispatcher dispatcher = (Dispatcher) obj2;
                ImportedDao_Impl$2 importedDao_Impl$2 = (ImportedDao_Impl$2) dispatcher.runningSyncCalls;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = importedDao_Impl$2.acquire();
                frameworkSQLiteStatementAcquire.bindString(((UUID) obj).toString(), 1);
                Database_Impl database_Impl = (Database_Impl) dispatcher.executorServiceOrNull;
                database_Impl.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire.executeUpdateDelete();
                    database_Impl.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    database_Impl.internalEndTransaction();
                    importedDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                }
            default:
                RoomSQLiteQuery roomSQLiteQuery = (RoomSQLiteQuery) obj;
                Cursor cursorQuery = ((Database_Impl) ((MenuHostHelper) obj2).mOnInvalidateMenuCallback).query(roomSQLiteQuery);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "uuid");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "proxy");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "selected");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string = null;
                        UUID uuidFromString = UUID.fromString(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                        String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        if (!cursorQuery.isNull(columnIndexOrThrow3)) {
                            string = cursorQuery.getString(columnIndexOrThrow3);
                        }
                        arrayList.add(new Selection(uuidFromString, string2, string));
                        break;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                }
        }
    }

    public /* synthetic */ zza(zzh zzhVar, InputImage inputImage) {
        this.$r8$classId = 0;
        this.zza = zzhVar;
        this.zzb = inputImage;
    }
}
