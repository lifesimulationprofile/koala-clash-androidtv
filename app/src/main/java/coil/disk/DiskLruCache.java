package coil.disk;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.ui.autofill.AndroidAutofill$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.core.text.PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.network.HttpException;
import coil.util.FileSystems;
import coil.util.Utils;
import com.github.kr328.clash.AppCrashedActivity;
import com.github.kr328.clash.TileService$receiver$1;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.remote.Broadcasts$Observer;
import com.github.kr328.clash.service.ClashService;
import com.github.kr328.clash.service.clash.module.NetworkObserveModule;
import com.google.android.gms.tasks.zzi;
import com.google.mlkit.common.sdkinternal.zzv;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import okio.BlackholeSink;
import okio.FileSystem;
import okio.Path;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache implements Closeable, Flushable {
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public final ContextScope cleanupScope;
    public boolean closed;
    public final Path directory;
    public final DiskLruCache$fileSystem$1 fileSystem;
    public boolean hasJournalErrors;
    public boolean initialized;
    public final Path journalFile;
    public final Path journalFileBackup;
    public final Path journalFileTmp;
    public RealBufferedSink journalWriter;
    public final LinkedHashMap lruEntries;
    public final long maxSize;
    public boolean mostRecentRebuildFailed;
    public boolean mostRecentTrimFailed;
    public int operationsSinceRewrite;
    public long size;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Entry {
        public Editor currentEditor;
        public final String key;
        public int lockingSnapshotCount;
        public boolean readable;
        public boolean zombie;
        public final long[] lengths = new long[2];
        public final ArrayList cleanFiles = new ArrayList(2);
        public final ArrayList dirtyFiles = new ArrayList(2);

        public Entry(String str) {
            this.key = str;
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < 2; i++) {
                sb.append(i);
                this.cleanFiles.add(DiskLruCache.this.directory.resolve(sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(DiskLruCache.this.directory.resolve(sb.toString()));
                sb.setLength(length);
            }
        }

        public final Snapshot snapshot() {
            if (!this.readable || this.currentEditor != null || this.zombie) {
                return null;
            }
            ArrayList arrayList = this.cleanFiles;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (i >= size) {
                    this.lockingSnapshotCount++;
                    return diskLruCache.new Snapshot(this);
                }
                if (!diskLruCache.fileSystem.exists((Path) arrayList.get(i))) {
                    try {
                        diskLruCache.removeEntry(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Snapshot implements Closeable {
        public boolean closed;
        public final Entry entry;

        public Snapshot(Entry entry) {
            this.entry = entry;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                try {
                    Entry entry = this.entry;
                    int i = entry.lockingSnapshotCount - 1;
                    entry.lockingSnapshotCount = i;
                    if (i == 0 && entry.zombie) {
                        Regex regex = DiskLruCache.LEGAL_KEY_PATTERN;
                        diskLruCache.removeEntry(entry);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: coil.disk.DiskLruCache$launchCleanup$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass1((DiskLruCache) this.this$0, continuation, 0);
                case 1:
                    return new AnonymousClass1((Function0) this.this$0, continuation, 1);
                case 2:
                    return new AnonymousClass1((PlatformSelectionBehaviorsImpl) this.this$0, continuation, 2);
                case 3:
                    return new AnonymousClass1((TooltipStateImpl) this.this$0, continuation, 3);
                case 4:
                    return new AnonymousClass1((Callable) this.this$0, continuation, 4);
                case 5:
                    return new AnonymousClass1((AppCrashedActivity) this.this$0, continuation, 5);
                case 6:
                    return new AnonymousClass1((ProxyViewModel) this.this$0, continuation, 6);
                case 7:
                    return new AnonymousClass1((BufferedChannel) this.this$0, continuation, 7);
                case 8:
                    return new AnonymousClass1((ClashService) this.this$0, continuation, 8);
                case 9:
                    return new AnonymousClass1((NetworkObserveModule) this.this$0, continuation, 9);
                default:
                    return new AnonymousClass1((Ref$ObjectRef) this.this$0, continuation, 10);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (this.$r8$classId) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            switch (this.$r8$classId) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    DiskLruCache diskLruCache = (DiskLruCache) this.this$0;
                    synchronized (diskLruCache) {
                        if (!diskLruCache.initialized || diskLruCache.closed) {
                            return Unit.INSTANCE;
                        }
                        try {
                            diskLruCache.trimToSize();
                            break;
                        } catch (IOException unused) {
                            diskLruCache.mostRecentTrimFailed = true;
                        }
                        try {
                            if (diskLruCache.operationsSinceRewrite >= 2000) {
                                diskLruCache.writeJournal();
                            }
                            break;
                        } catch (IOException unused2) {
                            diskLruCache.mostRecentRebuildFailed = true;
                            diskLruCache.journalWriter = new RealBufferedSink(new BlackholeSink());
                        }
                        return Unit.INSTANCE;
                    }
                case 1:
                    ResultKt.throwOnFailure(obj);
                    ((Function0) this.this$0).invoke();
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) this.this$0;
                    Context context = platformSelectionBehaviorsImpl.context;
                    SelectedTextType selectedTextType = platformSelectionBehaviorsImpl.selectedTextType;
                    TextClassificationManager textClassificationManagerM327m = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m327m(context.getSystemService(AndroidAutofill$$ExternalSyntheticApiModelOutline0.m332m()));
                    int iOrdinal = selectedTextType.ordinal();
                    if (iOrdinal == 0) {
                        str = "edittext";
                    } else {
                        if (iOrdinal != 1) {
                            throw new HttpException();
                        }
                        str = "textview";
                    }
                    PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2.m$2();
                    TextClassifier textClassifierCreateTextClassificationSession = textClassificationManagerM327m.createTextClassificationSession(PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2.m(context.getPackageName(), str).build());
                    platformSelectionBehaviorsImpl.textClassificationSession = textClassifierCreateTextClassificationSession;
                    return textClassifierCreateTextClassificationSession;
                case 3:
                    ResultKt.throwOnFailure(obj);
                    ((TooltipStateImpl) this.this$0).dismiss();
                    return Unit.INSTANCE;
                case 4:
                    ResultKt.throwOnFailure(obj);
                    return ((Callable) this.this$0).call();
                case 5:
                    ResultKt.throwOnFailure(obj);
                    AppCrashedActivity appCrashedActivity = (AppCrashedActivity) this.this$0;
                    return appCrashedActivity.getPackageManager().getPackageInfo(appCrashedActivity.getPackageName(), 0);
                case 6:
                    ResultKt.throwOnFailure(obj);
                    ProxyViewModel proxyViewModel = (ProxyViewModel) this.this$0;
                    JobKt.launch$default(ViewModelKt.getViewModelScope(proxyViewModel), null, new NavHostKt$NavHost$28$1(proxyViewModel, (Continuation) null, 28), 3);
                    return Unit.INSTANCE;
                case 7:
                    ResultKt.throwOnFailure(obj);
                    ((BufferedChannel) this.this$0).cancel(null);
                    Bridge.INSTANCE.nativeForceGc();
                    return Unit.INSTANCE;
                case 8:
                    ResultKt.throwOnFailure(obj);
                    ((ClashService) this.this$0).stopSelf();
                    return Unit.INSTANCE;
                case 9:
                    ResultKt.throwOnFailure(obj);
                    NetworkObserveModule networkObserveModule = (NetworkObserveModule) this.this$0;
                    networkObserveModule.getClass();
                    Log.i("KoalaClash", "NetworkObserve start unregister", null);
                    try {
                        networkObserveModule.connectivity.unregisterNetworkCallback(networkObserveModule.callback);
                        break;
                    } catch (Exception e) {
                        Log.w("KoalaClash", "NetworkObserve unregister failed", e);
                    }
                    Log.i("KoalaClash", "NetworkObserve dns = []", null);
                    Bridge.INSTANCE.nativeNotifyDnsChanged(CollectionsKt.joinToString$default(CollectionsKt.toSet(EmptyList.INSTANCE), ",", null, null, null, 62));
                    return Unit.INSTANCE;
                default:
                    ResultKt.throwOnFailure(obj);
                    ((Function0) ((Ref$ObjectRef) this.this$0).element).invoke();
                    return Unit.INSTANCE;
            }
        }
    }

    public DiskLruCache(long j, FileSystem fileSystem, Path path) {
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        this.directory = path;
        this.maxSize = j;
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.journalFile = path.resolve("journal");
        this.journalFileTmp = path.resolve("journal.tmp");
        this.journalFileBackup = path.resolve("journal.bkp");
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupScope = JobKt.CoroutineScope(CameraIdUtil.plus(JobKt.SupervisorJob$default(), defaultIoScheduler.limitedParallelism(1)));
        this.fileSystem = new DiskLruCache$fileSystem$1(fileSystem);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0118 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0011, B:11:0x0018, B:13:0x0020, B:15:0x0030, B:23:0x003e, B:25:0x0056, B:29:0x0073, B:31:0x0083, B:33:0x008a, B:26:0x005c, B:28:0x006c, B:37:0x00aa, B:39:0x00b1, B:42:0x00b6, B:44:0x00c4, B:47:0x00c9, B:52:0x0104, B:54:0x010f, B:58:0x0118, B:48:0x00e1, B:50:0x00f6, B:51:0x0101, B:36:0x009a, B:61:0x011d, B:62:0x0124), top: B:65:0x0001 }] */
    public static final void access$completeEdit(DiskLruCache diskLruCache, Editor editor, boolean z) {
        synchronized (diskLruCache) {
            Entry entry = (Entry) editor.entry;
            if (!Intrinsics.areEqual(entry.currentEditor, editor)) {
                throw new IllegalStateException("Check failed.");
            }
            if (!z || entry.zombie) {
                for (int i = 0; i < 2; i++) {
                    diskLruCache.fileSystem.delete((Path) entry.dirtyFiles.get(i));
                }
            } else {
                for (int i2 = 0; i2 < 2; i2++) {
                    if (((boolean[]) editor.written)[i2] && !diskLruCache.fileSystem.exists((Path) entry.dirtyFiles.get(i2))) {
                        editor.complete(false);
                        return;
                    }
                }
                for (int i3 = 0; i3 < 2; i3++) {
                    Path path = (Path) entry.dirtyFiles.get(i3);
                    Path path2 = (Path) entry.cleanFiles.get(i3);
                    if (diskLruCache.fileSystem.exists(path)) {
                        diskLruCache.fileSystem.atomicMove(path, path2);
                    } else {
                        DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = diskLruCache.fileSystem;
                        Path path3 = (Path) entry.cleanFiles.get(i3);
                        if (!diskLruCache$fileSystem$1.exists(path3)) {
                            Utils.closeQuietly(diskLruCache$fileSystem$1.sink(path3));
                        }
                    }
                    long j = entry.lengths[i3];
                    Long l = (Long) diskLruCache.fileSystem.metadata(path2).size;
                    long jLongValue = l != null ? l.longValue() : 0L;
                    entry.lengths[i3] = jLongValue;
                    diskLruCache.size = (diskLruCache.size - j) + jLongValue;
                }
            }
            entry.currentEditor = null;
            if (entry.zombie) {
                diskLruCache.removeEntry(entry);
                return;
            }
            diskLruCache.operationsSinceRewrite++;
            RealBufferedSink realBufferedSink = diskLruCache.journalWriter;
            if (z || entry.readable) {
                entry.readable = true;
                realBufferedSink.writeUtf8("CLEAN");
                realBufferedSink.writeByte(32);
                realBufferedSink.writeUtf8(entry.key);
                for (long j2 : entry.lengths) {
                    realBufferedSink.writeByte(32);
                    realBufferedSink.writeDecimalLong(j2);
                }
                realBufferedSink.writeByte(10);
            } else {
                diskLruCache.lruEntries.remove(entry.key);
                realBufferedSink.writeUtf8("REMOVE");
                realBufferedSink.writeByte(32);
                realBufferedSink.writeUtf8(entry.key);
                realBufferedSink.writeByte(10);
            }
            realBufferedSink.flush();
            if (diskLruCache.size > diskLruCache.maxSize) {
                diskLruCache.launchCleanup();
            } else if (diskLruCache.operationsSinceRewrite >= 2000) {
                diskLruCache.launchCleanup();
            }
        }
    }

    public static void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.initialized && !this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
                    Editor editor = entry.currentEditor;
                    if (editor != null) {
                        Entry entry2 = (Entry) editor.entry;
                        if (Intrinsics.areEqual(entry2.currentEditor, editor)) {
                            entry2.zombie = true;
                        }
                    }
                }
                trimToSize();
                JobKt.cancel(this.cleanupScope, (CancellationException) null);
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Editor edit(String str) {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
        validateKey(str);
        initialize();
        Entry entry = (Entry) this.lruEntries.get(str);
        if ((entry != null ? entry.currentEditor : null) != null) {
            return null;
        }
        if (entry != null && entry.lockingSnapshotCount != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            RealBufferedSink realBufferedSink = this.journalWriter;
            realBufferedSink.writeUtf8("DIRTY");
            realBufferedSink.writeByte(32);
            realBufferedSink.writeUtf8(str);
            realBufferedSink.writeByte(10);
            realBufferedSink.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(str);
                this.lruEntries.put(str, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.currentEditor = editor;
            return editor;
        }
        launchCleanup();
        return null;
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.initialized) {
            if (this.closed) {
                throw new IllegalStateException("cache is closed");
            }
            trimToSize();
            this.journalWriter.flush();
        }
    }

    public final synchronized Snapshot get(String str) {
        Snapshot snapshot;
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
        validateKey(str);
        initialize();
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry != null && (snapshot = entry.snapshot()) != null) {
            boolean z = true;
            this.operationsSinceRewrite++;
            RealBufferedSink realBufferedSink = this.journalWriter;
            realBufferedSink.writeUtf8("READ");
            realBufferedSink.writeByte(32);
            realBufferedSink.writeUtf8(str);
            realBufferedSink.writeByte(10);
            if (this.operationsSinceRewrite < 2000) {
                z = false;
            }
            if (z) {
                launchCleanup();
            }
            return snapshot;
        }
        return null;
    }

    public final synchronized void initialize() {
        try {
            if (this.initialized) {
                return;
            }
            this.fileSystem.delete(this.journalFileTmp);
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException unused) {
                    try {
                        close();
                        FileSystems.deleteContents(this.fileSystem, this.directory);
                        this.closed = false;
                        writeJournal();
                        this.initialized = true;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            writeJournal();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void launchCleanup() {
        JobKt.launch$default(this.cleanupScope, null, new AnonymousClass1(this, null, 0), 3);
    }

    public final void processJournal() {
        Iterator it = this.lruEntries.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (entry.currentEditor == null) {
                while (i < 2) {
                    j += entry.lengths[i];
                    i++;
                }
            } else {
                entry.currentEditor = null;
                while (i < 2) {
                    Path path = (Path) entry.cleanFiles.get(i);
                    DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
                    diskLruCache$fileSystem$1.delete(path);
                    diskLruCache$fileSystem$1.delete((Path) entry.dirtyFiles.get(i));
                    i++;
                }
                it.remove();
            }
        }
        this.size = j;
    }

    public final void readJournal() throws Throwable {
        DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
        FileSystem fileSystem = diskLruCache$fileSystem$1.delegate;
        Path path = this.journalFile;
        RealBufferedSource realBufferedSource = new RealBufferedSource(fileSystem.source(path));
        try {
            String utf8LineStrict = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict2 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict3 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict4 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict5 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            if (!"libcore.io.DiskLruCache".equals(utf8LineStrict) || !"1".equals(utf8LineStrict2) || !Intrinsics.areEqual(String.valueOf(1), utf8LineStrict3) || !Intrinsics.areEqual(String.valueOf(2), utf8LineStrict4) || utf8LineStrict5.length() > 0) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict3 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + ']');
            }
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    readJournalLine(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
                    i2++;
                } catch (EOFException unused) {
                    this.operationsSinceRewrite = i2 - this.lruEntries.size();
                    if (realBufferedSource.exhausted()) {
                        this.journalWriter = new RealBufferedSink(new FaultHidingSink(diskLruCache$fileSystem$1.delegate.appendingSink(path), new DiskLruCache$$ExternalSyntheticLambda0(i, this)));
                    } else {
                        writeJournal();
                    }
                    Unit unit = Unit.INSTANCE;
                    try {
                        realBufferedSource.close();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                realBufferedSource.close();
            } catch (Throwable th3) {
                ScanQRCode.addSuppressed(th, th3);
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public final void readJournalLine(String str) throws IOException {
        String strSubstring;
        int iIndexOf$default = StringsKt.indexOf$default(str, ' ', 0, 6);
        if (iIndexOf$default == -1) {
            throw new IOException(CaptureSession$State$EnumUnboxingLocalUtility.m("unexpected journal line: ", str));
        }
        int i = iIndexOf$default + 1;
        int iIndexOf$default2 = StringsKt.indexOf$default(str, ' ', i, 4);
        LinkedHashMap linkedHashMap = this.lruEntries;
        if (iIndexOf$default2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf$default == 6 && StringsKt__StringsJVMKt.startsWith(str, "REMOVE", false)) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf$default2);
        }
        Object entry = linkedHashMap.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            linkedHashMap.put(strSubstring, entry);
        }
        Entry entry2 = (Entry) entry;
        if (iIndexOf$default2 == -1 || iIndexOf$default != 5 || !StringsKt__StringsJVMKt.startsWith(str, "CLEAN", false)) {
            if (iIndexOf$default2 == -1 && iIndexOf$default == 5 && StringsKt__StringsJVMKt.startsWith(str, "DIRTY", false)) {
                entry2.currentEditor = new Editor(this, entry2);
                return;
            } else {
                if (iIndexOf$default2 != -1 || iIndexOf$default != 4 || !StringsKt__StringsJVMKt.startsWith(str, "READ", false)) {
                    throw new IOException(CaptureSession$State$EnumUnboxingLocalUtility.m("unexpected journal line: ", str));
                }
                return;
            }
        }
        List listSplit$default = StringsKt.split$default(str.substring(iIndexOf$default2 + 1), new char[]{' '});
        entry2.readable = true;
        entry2.currentEditor = null;
        if (listSplit$default.size() != 2) {
            throw new IOException("unexpected journal line: " + listSplit$default);
        }
        try {
            int size = listSplit$default.size();
            for (int i2 = 0; i2 < size; i2++) {
                entry2.lengths[i2] = Long.parseLong((String) listSplit$default.get(i2));
            }
        } catch (NumberFormatException unused) {
            throw new IOException("unexpected journal line: " + listSplit$default);
        }
    }

    public final void removeEntry(Entry entry) {
        RealBufferedSink realBufferedSink;
        int i = entry.lockingSnapshotCount;
        String str = entry.key;
        if (i > 0 && (realBufferedSink = this.journalWriter) != null) {
            realBufferedSink.writeUtf8("DIRTY");
            realBufferedSink.writeByte(32);
            realBufferedSink.writeUtf8(str);
            realBufferedSink.writeByte(10);
            realBufferedSink.flush();
        }
        if (entry.lockingSnapshotCount > 0 || entry.currentEditor != null) {
            entry.zombie = true;
            return;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            this.fileSystem.delete((Path) entry.cleanFiles.get(i2));
            long j = this.size;
            long[] jArr = entry.lengths;
            this.size = j - jArr[i2];
            jArr[i2] = 0;
        }
        this.operationsSinceRewrite++;
        RealBufferedSink realBufferedSink2 = this.journalWriter;
        if (realBufferedSink2 != null) {
            realBufferedSink2.writeUtf8("REMOVE");
            realBufferedSink2.writeByte(32);
            realBufferedSink2.writeUtf8(str);
            realBufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(str);
        if (this.operationsSinceRewrite >= 2000) {
            launchCleanup();
        }
    }

    public final void trimToSize() {
        while (this.size > this.maxSize) {
            for (Entry entry : this.lruEntries.values()) {
                if (!entry.zombie) {
                    removeEntry(entry);
                }
            }
            return;
        }
        this.mostRecentTrimFailed = false;
    }

    public final synchronized void writeJournal() {
        Throwable th;
        try {
            RealBufferedSink realBufferedSink = this.journalWriter;
            if (realBufferedSink != null) {
                realBufferedSink.close();
            }
            RealBufferedSink realBufferedSink2 = new RealBufferedSink(this.fileSystem.sink(this.journalFileTmp));
            int i = 0;
            try {
                realBufferedSink2.writeUtf8("libcore.io.DiskLruCache");
                realBufferedSink2.writeByte(10);
                realBufferedSink2.writeUtf8("1");
                realBufferedSink2.writeByte(10);
                realBufferedSink2.writeDecimalLong(1);
                realBufferedSink2.writeByte(10);
                realBufferedSink2.writeDecimalLong(2);
                realBufferedSink2.writeByte(10);
                realBufferedSink2.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.currentEditor != null) {
                        realBufferedSink2.writeUtf8("DIRTY");
                        realBufferedSink2.writeByte(32);
                        realBufferedSink2.writeUtf8(entry.key);
                        realBufferedSink2.writeByte(10);
                    } else {
                        realBufferedSink2.writeUtf8("CLEAN");
                        realBufferedSink2.writeByte(32);
                        realBufferedSink2.writeUtf8(entry.key);
                        for (long j : entry.lengths) {
                            realBufferedSink2.writeByte(32);
                            realBufferedSink2.writeDecimalLong(j);
                        }
                        realBufferedSink2.writeByte(10);
                    }
                }
                Unit unit = Unit.INSTANCE;
                try {
                    realBufferedSink2.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    realBufferedSink2.close();
                } catch (Throwable th4) {
                    ScanQRCode.addSuppressed(th3, th4);
                }
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
            }
            this.journalWriter = new RealBufferedSink(new FaultHidingSink(this.fileSystem.delegate.appendingSink(this.journalFile), new DiskLruCache$$ExternalSyntheticLambda0(i, this)));
            this.operationsSinceRewrite = 0;
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Editor {
        public boolean closed;
        public final Object entry;
        public Object this$0;
        public Object written;

        public Editor(Application application) {
            this.entry = application;
            this.written = new ArrayList();
            this.this$0 = new TileService$receiver$1(2, this);
        }

        public void addObserver(Broadcasts$Observer broadcasts$Observer) {
            ((ArrayList) this.written).add(broadcasts$Observer);
        }

        public void complete(boolean z) {
            DiskLruCache diskLruCache = (DiskLruCache) this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (this.closed) {
                        throw new IllegalStateException("editor is closed");
                    }
                    if (Intrinsics.areEqual(((Entry) this.entry).currentEditor, this)) {
                        DiskLruCache.access$completeEdit(diskLruCache, this, z);
                    }
                    this.closed = true;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Path file(int i) {
            Path path;
            DiskLruCache diskLruCache = (DiskLruCache) this.this$0;
            synchronized (diskLruCache) {
                if (this.closed) {
                    throw new IllegalStateException("editor is closed");
                }
                ((boolean[]) this.written)[i] = true;
                Object obj = ((Entry) this.entry).dirtyFiles.get(i);
                DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = diskLruCache.fileSystem;
                Path path2 = (Path) obj;
                if (!diskLruCache$fileSystem$1.exists(path2)) {
                    Utils.closeQuietly(diskLruCache$fileSystem$1.sink(path2));
                }
                path = (Path) obj;
            }
            return path;
        }

        public int[] getTablesToSync() {
            synchronized (this) {
                try {
                    if (!this.closed) {
                        return null;
                    }
                    int length = ((long[]) this.entry).length;
                    for (int i = 0; i < length; i++) {
                        int i2 = 1;
                        boolean z = ((long[]) this.entry)[i] > 0;
                        boolean[] zArr = (boolean[]) this.written;
                        if (z != zArr[i]) {
                            int[] iArr = (int[]) this.this$0;
                            if (!z) {
                                i2 = 2;
                            }
                            iArr[i] = i2;
                        } else {
                            ((int[]) this.this$0)[i] = 0;
                        }
                        zArr[i] = z;
                    }
                    this.closed = false;
                    return (int[]) ((int[]) this.this$0).clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean isOpen() {
            boolean z;
            synchronized (this.entry) {
                z = this.closed;
            }
            return z;
        }

        public void removeObserver(Broadcasts$Observer broadcasts$Observer) {
            ((ArrayList) this.written).remove(broadcasts$Observer);
        }

        public void submit(Runnable runnable, Executor executor) {
            synchronized (this.entry) {
                try {
                    if (this.closed) {
                        ((ArrayDeque) this.written).add(new zzv(runnable, executor));
                    } else {
                        this.closed = true;
                        zzd(runnable, executor);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void zzc() {
            synchronized (this.entry) {
                try {
                    if (((ArrayDeque) this.written).isEmpty()) {
                        this.closed = false;
                        return;
                    }
                    zzv zzvVar = (zzv) ((ArrayDeque) this.written).remove();
                    zzd(zzvVar.zzb, zzvVar.zza);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void zzd(Runnable runnable, Executor executor) {
            try {
                executor.execute(new zzi(27, this, runnable));
            } catch (RejectedExecutionException unused) {
                zzc();
            }
        }

        public Editor(int i, boolean z) {
            switch (i) {
                case 5:
                    this.entry = new Object();
                    this.written = new ArrayDeque();
                    this.this$0 = new AtomicReference();
                    break;
                default:
                    this.entry = new Object();
                    this.written = new ArrayList();
                    this.this$0 = new ArrayList();
                    this.closed = true;
                    break;
            }
        }

        public Editor(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, PrefetchScheduler prefetchScheduler) {
            this.entry = lazyLayoutItemContentFactory;
            this.written = subcomposeLayoutState;
            this.this$0 = prefetchScheduler;
            this.closed = true;
        }

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = new boolean[2];
        }

        public Editor(int i) {
            long[] jArr = new long[i];
            this.entry = jArr;
            boolean[] zArr = new boolean[i];
            this.written = zArr;
            this.this$0 = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }
    }
}
