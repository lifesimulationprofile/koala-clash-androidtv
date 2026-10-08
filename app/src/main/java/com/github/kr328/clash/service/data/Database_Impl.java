package com.github.kr328.clash.service.data;

import android.content.Context;
import androidx.core.view.MenuHostHelper;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import coil.memory.MemoryCacheService;
import com.github.kr328.clash.service.data.migrations.MigrationsKt$MIGRATION_1_2$1;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Database_Impl extends Database {
    public static final /* synthetic */ int $r8$clinit = 0;
    public volatile Dispatcher _importedDao;
    public volatile MenuHostHelper _selectionDao;

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "imported", "selections");
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return new FrameworkSQLiteOpenHelper((Context) databaseConfiguration.context, "profiles", new RoomOpenHelper(databaseConfiguration, new MemoryCacheService(24, this)));
    }

    @Override // androidx.room.RoomDatabase
    public final List getAutoMigrations() {
        return Arrays.asList(new MigrationsKt$MIGRATION_1_2$1[0]);
    }

    @Override // androidx.room.RoomDatabase
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map getRequiredTypeConverters() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(Dispatcher.class, list);
        map.put(MenuHostHelper.class, list);
        return map;
    }

    @Override // com.github.kr328.clash.service.data.Database
    public final Dispatcher openImportedDao() {
        Dispatcher dispatcher;
        if (this._importedDao != null) {
            return this._importedDao;
        }
        synchronized (this) {
            try {
                if (this._importedDao == null) {
                    Dispatcher dispatcher2 = new Dispatcher();
                    dispatcher2.executorServiceOrNull = this;
                    dispatcher2.readyAsyncCalls = new ImportedDao_Impl$1(dispatcher2, this, 0);
                    dispatcher2.runningAsyncCalls = new ImportedDao_Impl$2(dispatcher2, this);
                    dispatcher2.runningSyncCalls = new ImportedDao_Impl$2(this, 1);
                    this._importedDao = dispatcher2;
                }
                dispatcher = this._importedDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dispatcher;
    }

    @Override // com.github.kr328.clash.service.data.Database
    public final MenuHostHelper openSelectionProxyDao() {
        MenuHostHelper menuHostHelper;
        if (this._selectionDao != null) {
            return this._selectionDao;
        }
        synchronized (this) {
            try {
                if (this._selectionDao == null) {
                    this._selectionDao = new MenuHostHelper(this);
                }
                menuHostHelper = this._selectionDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return menuHostHelper;
    }
}
