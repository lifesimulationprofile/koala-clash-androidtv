package okio;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleDelegate;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.TransactionExecutor;
import coil.memory.MemoryCacheService;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.service.data.Database;
import com.github.kr328.clash.service.data.migrations.MigrationsKt;
import com.github.kr328.clash.service.data.migrations.MigrationsKt$MIGRATION_1_2$1;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Path implements Comparable {
    public static final String DIRECTORY_SEPARATOR = File.separator;
    public final ByteString bytes;

    public Path(ByteString byteString) {
        this.bytes = byteString;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.bytes.compareTo(((Path) obj).bytes);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Path) && Intrinsics.areEqual(((Path) obj).bytes, this.bytes);
    }

    public final ArrayList getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int iAccess$rootLength = okio.internal.Path.access$rootLength(this);
        ByteString byteString = this.bytes;
        if (iAccess$rootLength == -1) {
            iAccess$rootLength = 0;
        } else if (iAccess$rootLength < byteString.getSize$okio() && byteString.internalGet$okio(iAccess$rootLength) == 92) {
            iAccess$rootLength++;
        }
        int size$okio = byteString.getSize$okio();
        int i = iAccess$rootLength;
        while (iAccess$rootLength < size$okio) {
            if (byteString.internalGet$okio(iAccess$rootLength) == 47 || byteString.internalGet$okio(iAccess$rootLength) == 92) {
                arrayList.add(byteString.substring(i, iAccess$rootLength));
                i = iAccess$rootLength + 1;
            }
            iAccess$rootLength++;
        }
        if (i < byteString.getSize$okio()) {
            arrayList.add(byteString.substring(i, byteString.getSize$okio()));
        }
        return arrayList;
    }

    public final int hashCode() {
        return this.bytes.hashCode();
    }

    public final Path parent() {
        ByteString byteString = okio.internal.Path.DOT;
        ByteString byteString2 = this.bytes;
        if (Intrinsics.areEqual(byteString2, byteString)) {
            return null;
        }
        ByteString byteString3 = okio.internal.Path.SLASH;
        if (Intrinsics.areEqual(byteString2, byteString3)) {
            return null;
        }
        ByteString byteString4 = okio.internal.Path.BACKSLASH;
        if (Intrinsics.areEqual(byteString2, byteString4)) {
            return null;
        }
        ByteString byteString5 = okio.internal.Path.DOT_DOT;
        int size$okio = byteString2.getSize$okio();
        byte[] bArr = byteString5.data;
        if (byteString2.rangeEquals(size$okio - bArr.length, byteString5, bArr.length) && (byteString2.getSize$okio() == 2 || byteString2.rangeEquals(byteString2.getSize$okio() - 3, byteString3, 1) || byteString2.rangeEquals(byteString2.getSize$okio() - 3, byteString4, 1))) {
            return null;
        }
        byteString2.getClass();
        int iLastIndexOf = byteString2.lastIndexOf(byteString3.internalArray$okio());
        if (iLastIndexOf == -1) {
            byteString2.getClass();
            iLastIndexOf = byteString2.lastIndexOf(byteString4.internalArray$okio());
        }
        if (iLastIndexOf == 2 && volumeLetter() != null) {
            if (byteString2.getSize$okio() == 3) {
                return null;
            }
            return new Path(ByteString.substring$default(byteString2, 0, 3, 1));
        }
        if (iLastIndexOf == 1 && byteString2.rangeEquals(0, byteString4, byteString4.getSize$okio())) {
            return null;
        }
        if (iLastIndexOf != -1 || volumeLetter() == null) {
            if (iLastIndexOf == -1) {
                return new Path(byteString);
            }
            return iLastIndexOf == 0 ? new Path(ByteString.substring$default(byteString2, 0, 1, 1)) : new Path(ByteString.substring$default(byteString2, 0, iLastIndexOf, 1));
        }
        if (byteString2.getSize$okio() == 2) {
            return null;
        }
        return new Path(ByteString.substring$default(byteString2, 0, 2, 1));
    }

    public final Path relativeTo(Path path) {
        int iAccess$rootLength = okio.internal.Path.access$rootLength(this);
        ByteString byteString = this.bytes;
        Path path2 = iAccess$rootLength == -1 ? null : new Path(byteString.substring(0, iAccess$rootLength));
        path.getClass();
        ByteString byteString2 = path.bytes;
        int iAccess$rootLength2 = okio.internal.Path.access$rootLength(path);
        if (!Intrinsics.areEqual(path2, iAccess$rootLength2 != -1 ? new Path(byteString2.substring(0, iAccess$rootLength2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + path).toString());
        }
        ArrayList segmentsBytes = getSegmentsBytes();
        ArrayList segmentsBytes2 = path.getSegmentsBytes();
        int iMin = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i = 0;
        while (i < iMin && Intrinsics.areEqual(segmentsBytes.get(i), segmentsBytes2.get(i))) {
            i++;
        }
        if (i == iMin && byteString.getSize$okio() == byteString2.getSize$okio()) {
            return Companion.get$default(".");
        }
        if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(okio.internal.Path.DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + path).toString());
        }
        Buffer buffer = new Buffer();
        ByteString slash = okio.internal.Path.getSlash(path);
        if (slash == null && (slash = okio.internal.Path.getSlash(this)) == null) {
            slash = okio.internal.Path.toSlash(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i2 = i; i2 < size; i2++) {
            buffer.m856write(okio.internal.Path.DOT_DOT);
            buffer.m856write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i < size2) {
            buffer.m856write((ByteString) segmentsBytes.get(i));
            buffer.m856write(slash);
            i++;
        }
        return okio.internal.Path.toPath(buffer, false);
    }

    public final Path resolve(String str) {
        Buffer buffer = new Buffer();
        buffer.m860writeUtf8(str);
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(buffer, false), false);
    }

    public final File toFile() {
        return new File(this.bytes.utf8());
    }

    public final String toString() {
        return this.bytes.utf8();
    }

    public final Character volumeLetter() {
        ByteString byteString = okio.internal.Path.SLASH;
        ByteString byteString2 = this.bytes;
        if (ByteString.indexOf$default(byteString2, byteString) != -1 || byteString2.getSize$okio() < 2 || byteString2.internalGet$okio(1) != 58) {
            return null;
        }
        char cInternalGet$okio = (char) byteString2.internalGet$okio(0);
        if (('a' > cInternalGet$okio || cInternalGet$okio >= '{') && ('A' > cInternalGet$okio || cInternalGet$okio >= '[')) {
            return null;
        }
        return Character.valueOf(cInternalGet$okio);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class Companion implements MenuPresenter.Callback, FloatDecayAnimationSpec, PlatformLocaleDelegate, CreationExtras.Key, ComponentFactory, OnFailureListener {
        public static Companion zza;

        public static Path get$default(String str) {
            ByteString byteString = okio.internal.Path.SLASH;
            Buffer buffer = new Buffer();
            buffer.m860writeUtf8(str);
            return okio.internal.Path.toPath(buffer, false);
        }

        public static android.graphics.Path getPath(float f, float f2, float f3, float f4) {
            android.graphics.Path path = new android.graphics.Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }

        public static Database open(Application application) {
            Context applicationContext = application.getApplicationContext();
            MemoryCacheService memoryCacheService = new MemoryCacheService(18, false);
            memoryCacheService.imageLoader = new HashMap();
            MigrationsKt$MIGRATION_1_2$1[] migrationsKt$MIGRATION_1_2$1Arr = (MigrationsKt$MIGRATION_1_2$1[]) Arrays.copyOf(MigrationsKt.MIGRATIONS, 3);
            HashSet hashSet = new HashSet();
            for (MigrationsKt$MIGRATION_1_2$1 migrationsKt$MIGRATION_1_2$1 : migrationsKt$MIGRATION_1_2$1Arr) {
                hashSet.add(Integer.valueOf(migrationsKt$MIGRATION_1_2$1.startVersion));
                hashSet.add(Integer.valueOf(migrationsKt$MIGRATION_1_2$1.endVersion));
            }
            memoryCacheService.addMigrations(migrationsKt$MIGRATION_1_2$1Arr);
            if (applicationContext == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            ByteString.Companion companion = new ByteString.Companion(13);
            ActivityManager activityManager = (ActivityManager) applicationContext.getSystemService("activity");
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(applicationContext, companion, memoryCacheService, (activityManager == null || activityManager.isLowRamDevice()) ? 2 : 3);
            List list = (List) databaseConfiguration.autoMigrationSpecs;
            String name = Database.class.getPackage().getName();
            String canonicalName = Database.class.getCanonicalName();
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String str = canonicalName.replace('.', '_') + "_Impl";
            try {
                RoomDatabase roomDatabase = (RoomDatabase) Class.forName(name.isEmpty() ? str : name + "." + str, true, Database.class.getClassLoader()).newInstance();
                InvalidationTracker invalidationTracker = roomDatabase.mInvalidationTracker;
                HashMap map = roomDatabase.mAutoMigrationSpecs;
                roomDatabase.mOpenHelper = roomDatabase.createOpenHelper(databaseConfiguration);
                Set requiredAutoMigrationSpecs = roomDatabase.getRequiredAutoMigrationSpecs();
                BitSet bitSet = new BitSet();
                Iterator it = requiredAutoMigrationSpecs.iterator();
                while (true) {
                    int i = -1;
                    if (!it.hasNext()) {
                        MemoryCacheService memoryCacheService2 = (MemoryCacheService) databaseConfiguration.migrationContainer;
                        List list2 = (List) databaseConfiguration.typeConverters;
                        for (int size = list.size() - 1; size >= 0; size--) {
                            if (!bitSet.get(size)) {
                                throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                            }
                        }
                        for (MigrationsKt$MIGRATION_1_2$1 migrationsKt$MIGRATION_1_2$2 : roomDatabase.getAutoMigrations()) {
                            if (!Collections.unmodifiableMap((HashMap) memoryCacheService2.imageLoader).containsKey(Integer.valueOf(migrationsKt$MIGRATION_1_2$2.startVersion))) {
                                memoryCacheService2.addMigrations(migrationsKt$MIGRATION_1_2$2);
                            }
                        }
                        roomDatabase.mOpenHelper.setWriteAheadLoggingEnabled(databaseConfiguration.journalMode == 3);
                        roomDatabase.mQueryExecutor = ArchTaskExecutor.sIOThreadExecutor;
                        roomDatabase.mTransactionExecutor = new TransactionExecutor();
                        Map requiredTypeConverters = roomDatabase.getRequiredTypeConverters();
                        BitSet bitSet2 = new BitSet();
                        for (Map.Entry entry : requiredTypeConverters.entrySet()) {
                            Class cls = (Class) entry.getKey();
                            for (Class cls2 : (List) entry.getValue()) {
                                int size2 = list2.size() - 1;
                                while (true) {
                                    if (size2 < 0) {
                                        size2 = -1;
                                        break;
                                    }
                                    if (cls2.isAssignableFrom(list2.get(size2).getClass())) {
                                        bitSet2.set(size2);
                                        break;
                                    }
                                    size2--;
                                }
                                if (size2 < 0) {
                                    throw new IllegalArgumentException("A required type converter (" + cls2 + ") for " + cls.getCanonicalName() + " is missing in the database configuration.");
                                }
                                roomDatabase.mTypeConverters.put(cls2, list2.get(size2));
                            }
                        }
                        for (int size3 = list2.size() - 1; size3 >= 0; size3--) {
                            if (!bitSet2.get(size3)) {
                                throw new IllegalArgumentException("Unexpected type converter " + list2.get(size3) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                            }
                        }
                        return (Database) roomDatabase;
                    }
                    Class cls3 = (Class) it.next();
                    for (int size4 = list.size() - 1; size4 >= 0; size4--) {
                        if (cls3.isAssignableFrom(list.get(size4).getClass())) {
                            bitSet.set(size4);
                            i = size4;
                            break;
                        }
                    }
                    if (i < 0) {
                        throw new IllegalArgumentException("A required auto migration spec (" + cls3.getCanonicalName() + ") is missing in the database configuration.");
                    }
                    if (list.get(i) != null) {
                        throw new ClassCastException();
                    }
                    map.put(cls3, null);
                }
            } catch (ClassNotFoundException unused) {
                throw new RuntimeException("cannot find implementation for " + Database.class.getCanonicalName() + ". " + str + " does not exist");
            } catch (IllegalAccessException unused2) {
                throw new RuntimeException("Cannot access the constructor" + Database.class.getCanonicalName());
            } catch (InstantiationException unused3) {
                throw new RuntimeException("Failed to create an instance of " + Database.class.getCanonicalName());
            }
        }

        @Override // com.google.firebase.components.ComponentFactory
        public Object create(RestrictedComponentContainer restrictedComponentContainer) {
            return new ExecutorSelector(restrictedComponentContainer.getProvider(MlKitThreadPool.class));
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getAbsVelocityThreshold() {
            return 0.0f;
        }

        @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
        public LocaleList getCurrent() {
            return new LocaleList(Collections.singletonList(new Locale(java.util.Locale.getDefault())));
        }

        public synchronized Database getDatabase() {
            Database databaseOpen;
            databaseOpen = (Database) Database.softDatabase.get();
            if (databaseOpen == null) {
                Global.INSTANCE.getClass();
                databaseOpen = open(Global.getApplication$1());
                Database.softDatabase = new SoftReference(databaseOpen);
            }
            return databaseOpen;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public long getDurationNanos(float f) {
            return 0L;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getTargetValue(float f, float f2) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getValueFromNanos(float f, float f2, long j) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getVelocityFromNanos(float f, long j) {
            return 0.0f;
        }

        public boolean isPrecomputedText(CharSequence charSequence) {
            return false;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            Log.e("OptionalModuleUtils", "Failed to request modules install request", exc);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }

        public static Path get$default(File file) {
            String str = Path.DIRECTORY_SEPARATOR;
            String string = file.toString();
            ByteString byteString = okio.internal.Path.SLASH;
            Buffer buffer = new Buffer();
            buffer.m860writeUtf8(string);
            return okio.internal.Path.toPath(buffer, false);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }
    }
}
