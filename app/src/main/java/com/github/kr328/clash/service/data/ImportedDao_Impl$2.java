package com.github.kr328.clash.service.data;

import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.util.UUID;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImportedDao_Impl$2 extends SharedSQLiteStatement {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImportedDao_Impl$2(Database_Impl database_Impl, int i) {
        super(database_Impl);
        this.$r8$classId = i;
    }

    public void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, Object obj) {
        Imported imported = (Imported) obj;
        UUID uuid = imported.uuid;
        frameworkSQLiteStatement.bindString(uuid.toString(), 1);
        String str = imported.name;
        if (str == null) {
            frameworkSQLiteStatement.bindNull(2);
        } else {
            frameworkSQLiteStatement.bindString(str, 2);
        }
        String strName = imported.type.name();
        if (strName == null) {
            frameworkSQLiteStatement.bindNull(3);
        } else {
            frameworkSQLiteStatement.bindString(strName, 3);
        }
        String str2 = imported.source;
        if (str2 == null) {
            frameworkSQLiteStatement.bindNull(4);
        } else {
            frameworkSQLiteStatement.bindString(str2, 4);
        }
        frameworkSQLiteStatement.bindLong(5, imported.interval);
        frameworkSQLiteStatement.bindLong(6, imported.upload);
        frameworkSQLiteStatement.bindLong(7, imported.download);
        frameworkSQLiteStatement.bindLong(8, imported.total);
        frameworkSQLiteStatement.bindLong(9, imported.expire);
        frameworkSQLiteStatement.bindLong(10, imported.createdAt);
        frameworkSQLiteStatement.bindLong(11, imported.updatedAt);
        String str3 = imported.announce;
        if (str3 == null) {
            frameworkSQLiteStatement.bindNull(12);
        } else {
            frameworkSQLiteStatement.bindString(str3, 12);
        }
        String str4 = imported.supportURL;
        if (str4 == null) {
            frameworkSQLiteStatement.bindNull(13);
        } else {
            frameworkSQLiteStatement.bindString(str4, 13);
        }
        byte[] bArr = imported.profileImage;
        if (bArr == null) {
            frameworkSQLiteStatement.bindNull(14);
        } else {
            frameworkSQLiteStatement.bindBlob(14, bArr);
        }
        frameworkSQLiteStatement.bindLong(15, imported.modeSwitchAllowed ? 1L : 0L);
        frameworkSQLiteStatement.bindString(uuid.toString(), 16);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.$r8$classId) {
            case 0:
                return "UPDATE OR ABORT `imported` SET `uuid` = ?,`name` = ?,`type` = ?,`source` = ?,`interval` = ?,`upload` = ?,`download` = ?,`total` = ?,`expire` = ?,`createdAt` = ?,`updatedAt` = ?,`announce` = ?,`supportURL` = ?,`profileImage` = ?,`modeSwitchAllowed` = ? WHERE `uuid` = ?";
            case 1:
                return "DELETE FROM imported WHERE uuid = ?";
            default:
                return "DELETE FROM selections WHERE uuid = ? AND proxy = ?";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportedDao_Impl$2(Dispatcher dispatcher, Database_Impl database_Impl) {
        super(database_Impl);
        this.$r8$classId = 0;
    }
}
