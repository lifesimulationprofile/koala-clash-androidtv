package com.github.kr328.clash.service.data;

import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImportedDao_Impl$1 extends SharedSQLiteStatement {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImportedDao_Impl$1(Object obj, Database_Impl database_Impl, int i) {
        super(database_Impl);
        this.$r8$classId = i;
    }

    public void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, Object obj) {
        Imported imported = (Imported) obj;
        frameworkSQLiteStatement.bindString(imported.uuid.toString(), 1);
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
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.$r8$classId) {
            case 0:
                return "INSERT OR ABORT INTO `imported` (`uuid`,`name`,`type`,`source`,`interval`,`upload`,`download`,`total`,`expire`,`createdAt`,`updatedAt`,`announce`,`supportURL`,`profileImage`,`modeSwitchAllowed`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR REPLACE INTO `selections` (`uuid`,`proxy`,`selected`) VALUES (?,?,?)";
        }
    }
}
