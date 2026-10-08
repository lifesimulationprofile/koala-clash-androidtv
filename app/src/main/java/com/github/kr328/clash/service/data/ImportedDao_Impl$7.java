package com.github.kr328.clash.service.data;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import com.github.kr328.clash.service.model.Profile;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Callable;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImportedDao_Impl$7 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Dispatcher this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public /* synthetic */ ImportedDao_Impl$7(Dispatcher dispatcher, RoomSQLiteQuery roomSQLiteQuery, int i) {
        this.$r8$classId = i;
        this.this$0 = dispatcher;
        this.val$_statement = roomSQLiteQuery;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public final Object call() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        Boolean boolValueOf;
        switch (this.$r8$classId) {
            case 0:
                Database_Impl database_Impl = (Database_Impl) this.this$0.executorServiceOrNull;
                RoomSQLiteQuery roomSQLiteQuery2 = this.val$_statement;
                Cursor cursorQuery = database_Impl.query(roomSQLiteQuery2);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "uuid");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "upload");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "download");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "total");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expire");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updatedAt");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "announce");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "supportURL");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "profileImage");
                    roomSQLiteQuery = roomSQLiteQuery2;
                    try {
                        int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modeSwitchAllowed");
                        Object imported = null;
                        if (cursorQuery.moveToFirst()) {
                            imported = new Imported(UUID.fromString(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow)), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), Profile.Type.valueOf(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3)), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getLong(columnIndexOrThrow7), cursorQuery.getLong(columnIndexOrThrow8), cursorQuery.getLong(columnIndexOrThrow9), cursorQuery.getLong(columnIndexOrThrow10), cursorQuery.getLong(columnIndexOrThrow11), cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12), cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13), cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getBlob(columnIndexOrThrow14), cursorQuery.getInt(columnIndexOrThrow15) != 0);
                        }
                        cursorQuery.close();
                        roomSQLiteQuery.release();
                        return imported;
                    } catch (Throwable th) {
                        th = th;
                        cursorQuery.close();
                        roomSQLiteQuery.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    roomSQLiteQuery = roomSQLiteQuery2;
                }
                break;
            case 1:
                Database_Impl database_Impl2 = (Database_Impl) this.this$0.executorServiceOrNull;
                RoomSQLiteQuery roomSQLiteQuery3 = this.val$_statement;
                Cursor cursorQuery2 = database_Impl2.query(roomSQLiteQuery3);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery2.getCount());
                    while (cursorQuery2.moveToNext()) {
                        arrayList.add(UUID.fromString(cursorQuery2.isNull(0) ? null : cursorQuery2.getString(0)));
                        break;
                    }
                    return arrayList;
                } finally {
                    cursorQuery2.close();
                    roomSQLiteQuery3.release();
                }
            default:
                Database_Impl database_Impl3 = (Database_Impl) this.this$0.executorServiceOrNull;
                RoomSQLiteQuery roomSQLiteQuery4 = this.val$_statement;
                Cursor cursorQuery3 = database_Impl3.query(roomSQLiteQuery4);
                try {
                    if (cursorQuery3.moveToFirst()) {
                        boolValueOf = Boolean.valueOf(cursorQuery3.getInt(0) != 0);
                    } else {
                        boolValueOf = Boolean.FALSE;
                    }
                    return boolValueOf;
                } finally {
                    cursorQuery3.close();
                    roomSQLiteQuery4.release();
                }
        }
    }
}
