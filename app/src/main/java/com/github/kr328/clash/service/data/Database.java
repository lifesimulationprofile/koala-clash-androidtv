package com.github.kr328.clash.service.data;

import androidx.core.view.MenuHostHelper;
import androidx.room.RoomDatabase;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.remote.Remote$launch$2;
import java.lang.ref.SoftReference;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Database extends RoomDatabase {
    public static final Path.Companion Companion = new Path.Companion();
    public static SoftReference softDatabase = new SoftReference(null);

    static {
        Global global = Global.INSTANCE;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        JobKt.launch$default(global, DefaultIoScheduler.INSTANCE, new Remote$launch$2(2, null, 1), 2);
    }

    public abstract Dispatcher openImportedDao();

    public abstract MenuHostHelper openSelectionProxyDao();
}
