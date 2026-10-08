package coil.memory;

import android.R;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.collection.MutableLongList;
import androidx.collection.MutableScatterSet;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputChangeEventProducer$PointerInputData;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SortedSet;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.android.CanvasCompatS$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.unit.Density;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.provider.FontProvider;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatApi25Impl;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.Lifecycle;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewBoundsCheck$Callback;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import coil.EventListener$Companion$NONE$1;
import coil.ImageLoader$Builder;
import coil.RealImageLoader;
import coil.compose.AsyncImagePainter;
import coil.decode.DecodeUtils;
import coil.disk.DiskLruCache;
import coil.disk.RealDiskCache;
import coil.intercept.RealInterceptorChain;
import coil.key.UriKeyer;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.Parameters;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Dimension;
import coil.size.Size;
import coil.target.Target;
import coil.util.Bitmaps;
import coil.util.Requests;
import coil.util.Utils;
import com.github.kr328.clash.core.bridge.LogcatInterface;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.service.data.migrations.MigrationsKt$MIGRATION_1_2$1;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$20;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.moduleinstall.internal.zaf;
import com.google.android.gms.common.moduleinstall.internal.zar;
import com.google.android.gms.common.moduleinstall.internal.zay;
import com.google.android.gms.common.moduleinstall.internal.zaz;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.internal.mlkit_vision_common.zzas;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.serialization.json.Json;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okio.AsyncTimeout;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class MemoryCacheService implements OnApplyWindowInsetsListener, FontProvider.ContentQueryWrapper, ContentInfoCompat.BuilderCompat, ProfileInstaller$DiagnosticsCallback, ViewBoundsCheck$Callback, Target, LogcatInterface, SynchronizationGuard.CriticalSection, Factory, RemoteCall {
    public final /* synthetic */ int $r8$classId;
    public Object imageLoader;

    public /* synthetic */ MemoryCacheService(int i, Object obj) {
        this.$r8$classId = i;
        this.imageLoader = obj;
    }

    public static SuccessResult newResult(RealInterceptorChain realInterceptorChain, ImageRequest imageRequest, MemoryCache$Key memoryCache$Key, MemoryCache$Value memoryCache$Value) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(imageRequest.context.getResources(), memoryCache$Value.bitmap);
        Map map = memoryCache$Value.extras;
        Object obj = map.get("coil#disk_cache_key");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("coil#is_sampled");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean z = false;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
        if (realInterceptorChain != null && realInterceptorChain.isPlaceholderCached) {
            z = true;
        }
        return new SuccessResult(bitmapDrawable, imageRequest, 1, memoryCache$Key, str, zBooleanValue, z);
    }

    public static zzv onValidateSchema(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        HashMap map = new HashMap(15);
        map.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, 1));
        map.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
        map.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
        map.put("source", new TableInfo.Column("source", "TEXT", true, 0, null, 1));
        map.put("interval", new TableInfo.Column("interval", "INTEGER", true, 0, null, 1));
        map.put("upload", new TableInfo.Column("upload", "INTEGER", true, 0, null, 1));
        map.put("download", new TableInfo.Column("download", "INTEGER", true, 0, null, 1));
        map.put("total", new TableInfo.Column("total", "INTEGER", true, 0, null, 1));
        map.put("expire", new TableInfo.Column("expire", "INTEGER", true, 0, null, 1));
        map.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
        map.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, "0", 1));
        map.put("announce", new TableInfo.Column("announce", "TEXT", false, 0, null, 1));
        map.put("supportURL", new TableInfo.Column("supportURL", "TEXT", false, 0, null, 1));
        map.put("profileImage", new TableInfo.Column("profileImage", "BLOB", false, 0, null, 1));
        map.put("modeSwitchAllowed", new TableInfo.Column("modeSwitchAllowed", "INTEGER", true, 0, "1", 1));
        TableInfo tableInfo = new TableInfo("imported", map, new HashSet(0), new HashSet(0));
        TableInfo tableInfo2 = TableInfo.read(frameworkSQLiteDatabase, "imported");
        if (!tableInfo.equals(tableInfo2)) {
            return new zzv(false, "imported(com.github.kr328.clash.service.data.Imported).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
        }
        HashMap map2 = new HashMap(3);
        map2.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, 1));
        map2.put("proxy", new TableInfo.Column("proxy", "TEXT", true, 2, null, 1));
        map2.put("selected", new TableInfo.Column("selected", "TEXT", true, 0, null, 1));
        HashSet hashSet = new HashSet(1);
        hashSet.add(new TableInfo.ForeignKey("imported", "CASCADE", "CASCADE", Arrays.asList("uuid"), Arrays.asList("uuid")));
        TableInfo tableInfo3 = new TableInfo("selections", map2, hashSet, new HashSet(0));
        TableInfo tableInfo4 = TableInfo.read(frameworkSQLiteDatabase, "selections");
        if (tableInfo3.equals(tableInfo4)) {
            return new zzv(true, (String) null);
        }
        return new zzv(false, "selections(com.github.kr328.clash.service.data.Selection).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public void accept(Object obj, Object obj2) {
        zar zarVar = new zar((TaskCompletionSource) obj2, 0);
        zaf zafVar = (zaf) ((zaz) obj).getService();
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) this.imageLoader;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(zafVar.zab);
        int i = zac.$r8$clinit;
        parcelObtain.writeStrongBinder(zarVar);
        zac.zac(parcelObtain, apiFeatureRequest);
        zafVar.zac(parcelObtain, 1);
    }

    public void add(LayoutNode layoutNode) {
        if (!layoutNode.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.add called on an unattached node");
        }
        ((SortedSet) this.imageLoader).add(layoutNode);
    }

    public void addMigrations(MigrationsKt$MIGRATION_1_2$1... migrationsKt$MIGRATION_1_2$1Arr) {
        for (MigrationsKt$MIGRATION_1_2$1 migrationsKt$MIGRATION_1_2$1 : migrationsKt$MIGRATION_1_2$1Arr) {
            int i = migrationsKt$MIGRATION_1_2$1.startVersion;
            int i2 = migrationsKt$MIGRATION_1_2$1.endVersion;
            HashMap map = (HashMap) this.imageLoader;
            TreeMap treeMap = (TreeMap) map.get(Integer.valueOf(i));
            if (treeMap == null) {
                treeMap = new TreeMap();
                map.put(Integer.valueOf(i), treeMap);
            }
            MigrationsKt$MIGRATION_1_2$1 migrationsKt$MIGRATION_1_2$2 = (MigrationsKt$MIGRATION_1_2$1) treeMap.get(Integer.valueOf(i2));
            if (migrationsKt$MIGRATION_1_2$2 != null) {
                Log.w("ROOM", "Overriding migration " + migrationsKt$MIGRATION_1_2$2 + " with " + migrationsKt$MIGRATION_1_2$1);
            }
            treeMap.put(Integer.valueOf(i2), migrationsKt$MIGRATION_1_2$1);
        }
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public ContentInfoCompat build() {
        return new ContentInfoCompat(new Parameters.Builder(((ContentInfo.Builder) this.imageLoader).build()));
    }

    @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
    public void close() {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.imageLoader;
        if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }

    public RealDiskCache.RealSnapshot commitAndOpenSnapshot$1() {
        DiskLruCache.Snapshot snapshot;
        DiskLruCache.Editor editor = (DiskLruCache.Editor) this.imageLoader;
        DiskLruCache diskLruCache = (DiskLruCache) editor.this$0;
        synchronized (diskLruCache) {
            editor.complete(true);
            snapshot = diskLruCache.get(((DiskLruCache.Entry) editor.entry).key);
        }
        if (snapshot != null) {
            return new RealDiskCache.RealSnapshot(snapshot);
        }
        return null;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        Dispatcher dispatcher = (Dispatcher) this.imageLoader;
        SQLiteDatabase db = ((SQLiteEventStore) ((EventStore) dispatcher.readyAsyncCalls)).getDb();
        db.beginTransaction();
        try {
            List list = (List) SQLiteEventStore.tryWithCursor(db.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), SQLiteEventStore$$Lambda$20.instance);
            db.setTransactionSuccessful();
            db.endTransaction();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ImageLoader$Builder) dispatcher.runningAsyncCalls).schedule((AutoValue_TransportContext) it.next(), 1, false);
            }
            return null;
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new SQLiteEventStore(new ByteString.Companion(15), new AsyncTimeout.Companion(15), AutoValue_EventStoreConfig.DEFAULT, (SchemaManager) ((Headers.Builder) this.imageLoader).get());
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    public MemoryCache$Value getCacheValue(ImageRequest imageRequest, MemoryCache$Key memoryCache$Key, Size size, int i) {
        MemoryCache$Value memoryCache$Value;
        int i2;
        boolean zEquals;
        ?? r8;
        MemoryCache$Value memoryCache$Value2;
        if (Density.CC.getReadEnabled(imageRequest.memoryCachePolicy)) {
            RealMemoryCache realMemoryCache = (RealMemoryCache) ((RealImageLoader) this.imageLoader).memoryCacheLazy.getValue();
            if (realMemoryCache != null) {
                memoryCache$Value = realMemoryCache.strongMemoryCache.get(memoryCache$Key);
                if (memoryCache$Value == null) {
                    RealWeakMemoryCache realWeakMemoryCache = realMemoryCache.weakMemoryCache;
                    synchronized (realWeakMemoryCache) {
                        try {
                            ArrayList arrayList = (ArrayList) ((LinkedHashMap) realWeakMemoryCache.cache).get(memoryCache$Key);
                            memoryCache$Value2 = null;
                            if (arrayList != null) {
                                int size2 = arrayList.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    RealWeakMemoryCache.InternalValue internalValue = (RealWeakMemoryCache.InternalValue) arrayList.get(i3);
                                    Bitmap bitmap = (Bitmap) internalValue.bitmap.get();
                                    MemoryCache$Value memoryCache$Value3 = bitmap != null ? new MemoryCache$Value(bitmap, internalValue.extras) : null;
                                    if (memoryCache$Value3 != null) {
                                        memoryCache$Value2 = memoryCache$Value3;
                                        break;
                                    }
                                }
                                int i4 = realWeakMemoryCache.operationsSinceCleanUp;
                                realWeakMemoryCache.operationsSinceCleanUp = i4 + 1;
                                if (i4 >= 10) {
                                    realWeakMemoryCache.cleanUp$coil_base_release();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    memoryCache$Value = memoryCache$Value2;
                }
            } else {
                memoryCache$Value = null;
            }
            if (memoryCache$Value != null) {
                Bitmap bitmap2 = memoryCache$Value.bitmap;
                Bitmap.Config config = bitmap2.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                if (Bitmaps.isHardware(config) && !imageRequest.allowHardware) {
                    r8 = 0;
                } else {
                    Object obj = memoryCache$Value.extras.get("coil#is_sampled");
                    Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                    boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                    if (!Intrinsics.areEqual(size, Size.ORIGINAL)) {
                        String str = (String) memoryCache$Key.extras.get("coil#transformation_size");
                        if (str != null) {
                            zEquals = str.equals(size.toString());
                        } else {
                            int width = bitmap2.getWidth();
                            int height = bitmap2.getHeight();
                            Dimension dimension = size.width;
                            int i5 = dimension instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension).px : Integer.MAX_VALUE;
                            Dimension dimension2 = size.height;
                            int i6 = dimension2 instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension2).px : Integer.MAX_VALUE;
                            double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, i5, i6, i);
                            boolean allowInexactSize = Requests.getAllowInexactSize(imageRequest);
                            if (allowInexactSize) {
                                double d = dComputeSizeMultiplier > 1.0d ? 1.0d : dComputeSizeMultiplier;
                                if (Math.abs(((double) i5) - (d * ((double) width))) <= 1.0d || Math.abs(((double) i6) - (d * ((double) height))) <= 1.0d) {
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                                r8 = i2;
                            } else {
                                if (i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE) {
                                    i2 = 1;
                                } else {
                                    int iAbs = Math.abs(i5 - width);
                                    i2 = 1;
                                    if (iAbs <= 1) {
                                    }
                                }
                                if (i6 != Integer.MIN_VALUE && i6 != Integer.MAX_VALUE && Math.abs(i6 - height) > i2) {
                                }
                                r8 = i2;
                            }
                            if (!(dComputeSizeMultiplier == 1.0d || allowInexactSize) || (dComputeSizeMultiplier > 1.0d && zBooleanValue)) {
                                r8 = 0;
                            } else {
                                r8 = i2;
                            }
                        }
                    } else if (zBooleanValue) {
                        r8 = 0;
                    } else {
                        i2 = 1;
                        r8 = i2;
                    }
                }
                if (r8 != 0) {
                    r8 = zEquals;
                    return memoryCache$Value;
                }
            }
        }
        r8 = zEquals;
        return null;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public View getChildAt(int i) {
        return ((RecyclerView.LayoutManager) this.imageLoader).getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getChildEnd(View view) {
        return view.getRight() + ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.right + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getChildStart(View view) {
        return (view.getLeft() - ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.left) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getParentEnd() {
        RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.imageLoader;
        return layoutManager.mWidth - layoutManager.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getParentStart() {
        return ((RecyclerView.LayoutManager) this.imageLoader).getPaddingLeft();
    }

    public void hide() {
        View view = (View) this.imageLoader;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public MemoryCache$Key newCacheKey(ImageRequest imageRequest, Object obj, Options options, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1) {
        String string;
        Map linkedHashMap;
        imageRequest.getClass();
        List list = imageRequest.transformations;
        List list2 = ((RealImageLoader) this.imageLoader).components.keyers;
        int size = list2.size();
        int i = 0;
        while (true) {
            if (i < size) {
                Pair pair = (Pair) list2.get(i);
                UriKeyer uriKeyer = (UriKeyer) pair.first;
                if (((Class) pair.second).isAssignableFrom(obj.getClass())) {
                    switch (uriKeyer.$r8$classId) {
                        case 0:
                            Uri uri = (Uri) obj;
                            if (!Intrinsics.areEqual(uri.getScheme(), "android.resource")) {
                                string = uri.toString();
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(uri);
                                sb.append('-');
                                Configuration configuration = options.context.getResources().getConfiguration();
                                Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
                                sb.append(configuration.uiMode & 48);
                                string = sb.toString();
                            }
                            break;
                        default:
                            File file = (File) obj;
                            string = file.getPath() + ':' + file.lastModified();
                            break;
                    }
                    if (string != null) {
                    }
                }
                i++;
            } else {
                string = null;
            }
        }
        if (string == null) {
            return null;
        }
        Map map = imageRequest.parameters.entries;
        boolean zIsEmpty = map.isEmpty();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (zIsEmpty) {
            linkedHashMap = emptyMap;
        } else {
            linkedHashMap = new LinkedHashMap();
            Iterator it = map.entrySet().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getValue().getClass();
                throw new ClassCastException();
            }
        }
        if (list.isEmpty() && linkedHashMap.isEmpty()) {
            return new MemoryCache$Key(string, emptyMap);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        if (!list.isEmpty()) {
            if (list.size() > 0) {
                list.get(0).getClass();
                throw new ClassCastException();
            }
            linkedHashMap2.put("coil#transformation_size", options.size.toString());
        }
        return new MemoryCache$Key(string, linkedHashMap2);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.imageLoader;
        if (!Objects.equals(coordinatorLayout.mLastInsets, windowInsetsCompat)) {
            coordinatorLayout.mLastInsets = windowInsetsCompat;
            boolean z = windowInsetsCompat.getSystemWindowInsetTop() > 0;
            coordinatorLayout.mDrawStatusBarBackground = z;
            coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
            if (!impl.isConsumed()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    if (childAt.getFitsSystemWindows() && ((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).mBehavior != null && impl.isConsumed()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return windowInsetsCompat;
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onDiagnosticReceived() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.imageLoader).setResultCode(i);
    }

    @Override // coil.target.Target
    public void onStart(Drawable drawable) {
        AsyncImagePainter asyncImagePainter = (AsyncImagePainter) this.imageLoader;
        asyncImagePainter.updateState(new AsyncImagePainter.State.Loading(drawable != null ? asyncImagePainter.toPainter(drawable) : null));
    }

    public RequestService produce(RequestService requestService, AndroidComposeView androidComposeView) {
        long jM593screenToLocalMKHz9U;
        long j;
        boolean z;
        LongSparseArray longSparseArray = (LongSparseArray) this.imageLoader;
        List list = (List) requestService.systemCallbacks;
        LongSparseArray longSparseArray2 = new LongSparseArray(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            PointerInputEventData pointerInputEventData = (PointerInputEventData) list.get(i);
            long j2 = pointerInputEventData.id;
            PointerInputChangeEventProducer$PointerInputData pointerInputChangeEventProducer$PointerInputData = (PointerInputChangeEventProducer$PointerInputData) longSparseArray.get(j2);
            if (pointerInputChangeEventProducer$PointerInputData == null) {
                j = pointerInputEventData.uptime;
                jM593screenToLocalMKHz9U = pointerInputEventData.position;
                z = false;
            } else {
                long j3 = pointerInputChangeEventProducer$PointerInputData.uptime;
                boolean z2 = pointerInputChangeEventProducer$PointerInputData.down;
                jM593screenToLocalMKHz9U = androidComposeView.m593screenToLocalMKHz9U(pointerInputChangeEventProducer$PointerInputData.positionOnScreen);
                j = j3;
                z = z2;
            }
            long j4 = pointerInputEventData.id;
            List list2 = list;
            int i2 = size;
            longSparseArray2.put(j4, new PointerInputChange(j4, pointerInputEventData.uptime, pointerInputEventData.position, pointerInputEventData.down, pointerInputEventData.pressure, j, jM593screenToLocalMKHz9U, z, pointerInputEventData.type, pointerInputEventData.historical, pointerInputEventData.scrollDelta, pointerInputEventData.scaleGestureFactor, pointerInputEventData.panGestureOffset, pointerInputEventData.originalEventPosition));
            boolean z3 = pointerInputEventData.down;
            if (z3) {
                longSparseArray.put(j2, new PointerInputChangeEventProducer$PointerInputData(pointerInputEventData.uptime, pointerInputEventData.positionOnScreen, z3));
            } else {
                longSparseArray.remove(j2);
            }
            i++;
            list = list2;
            size = i2;
        }
        return new RequestService(3, longSparseArray2, requestService);
    }

    @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
    public Cursor query(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.imageLoader;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException e) {
            Log.w("FontsProvider", "Unable to query the content provider", e);
            return null;
        }
    }

    @Override // com.github.kr328.clash.core.bridge.LogcatInterface
    public void received(String str) {
        ((BufferedChannel) this.imageLoader).mo842trySendJP2dKIU(Json.Default.decodeFromString(str, LogMessage.Companion.serializer()));
    }

    public boolean remove(LayoutNode layoutNode) {
        if (!layoutNode.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.remove called on an unattached node");
        }
        return ((SortedSet) this.imageLoader).remove(layoutNode);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0093 A[LOOP:0: B:22:0x004e->B:34:0x0093, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x0096 A[EDGE_INSN: B:53:0x0096->B:35:0x0096 BREAK  A[LOOP:0: B:22:0x004e->B:34:0x0093], SYNTHETIC] */
    public Object runAndWatch$runtime(Channel channel, Function0 function0) {
        SingleSubscriptionSnapshotFlowManager singleSubscriptionSnapshotFlowManager;
        SendChannel sendChannel;
        if (((Lifecycle) this.imageLoader) == null) {
            PreconditionsKt.throwIllegalStateException("Called runAndWatch on a manager that has been disposed of");
        }
        Lifecycle lifecycle = (Lifecycle) this.imageLoader;
        if ((lifecycle instanceof SingleSubscriptionSnapshotFlowManager) && (sendChannel = (singleSubscriptionSnapshotFlowManager = (SingleSubscriptionSnapshotFlowManager) lifecycle).subscribedChannel) != null && !sendChannel.equals(channel)) {
            MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager = new MultiSubscriptionSnapshotFlowManager();
            SendChannel sendChannel2 = singleSubscriptionSnapshotFlowManager.subscribedChannel;
            if (sendChannel2 == null) {
                PreconditionsKt.throwIllegalStateException("promote must only be called when a manager is managing subscriptions for one channel and needs to start managing them for a second");
            }
            MutableScatterSet mutableScatterSet = singleSubscriptionSnapshotFlowManager.watchSet;
            ArrayList arrayList = multiSubscriptionSnapshotFlowManager.pendingChanges;
            if (mutableScatterSet != null) {
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i != length) {
                                break;
                                break;
                            }
                            i++;
                        } else {
                            int i2 = 8;
                            int i3 = 8 - ((~(i - length)) >>> 31);
                            int i4 = 0;
                            while (i4 < i3) {
                                if ((j & 255) < 128) {
                                    arrayList.add(new MultiSubscriptionSnapshotFlowManager.Add(objArr[(i << 3) + i4], sendChannel2));
                                }
                                j >>= i2;
                                i4++;
                                i2 = i2;
                            }
                            if (i3 != i2) {
                                break;
                            }
                            if (i != length) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            } else {
                arrayList.add(new MultiSubscriptionSnapshotFlowManager.Add(singleSubscriptionSnapshotFlowManager.soleWatchedObject, sendChannel2));
            }
            multiSubscriptionSnapshotFlowManager.commitSubscriptionChanges$runtime();
            singleSubscriptionSnapshotFlowManager.dispose$runtime();
            this.imageLoader = multiSubscriptionSnapshotFlowManager;
        }
        Lifecycle lifecycle2 = (Lifecycle) this.imageLoader;
        Snapshot snapshotTakeNestedSnapshot = SnapshotKt.currentSnapshot().takeNestedSnapshot(lifecycle2.readObserverFor$runtime(channel));
        lifecycle2.clearWatchSet$runtime(channel);
        try {
            Snapshot snapshotMakeCurrent = snapshotTakeNestedSnapshot.makeCurrent();
            try {
                Object objInvoke = function0.invoke();
                Snapshot.restoreCurrent(snapshotMakeCurrent);
                snapshotTakeNestedSnapshot.dispose();
                lifecycle2.commitSubscriptionChanges$runtime();
                return objInvoke;
            } catch (Throwable th) {
                Snapshot.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            snapshotTakeNestedSnapshot.dispose();
            throw th2;
        }
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.imageLoader).setExtras(bundle);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setFlags(int i) {
        ((ContentInfo.Builder) this.imageLoader).setFlags(i);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setLinkUri(Uri uri) {
        ((ContentInfo.Builder) this.imageLoader).setLinkUri(uri);
    }

    public void show() {
        View viewFindViewById;
        View view = (View) this.imageLoader;
        if (view == null) {
            return;
        }
        if (view.isInEditMode() || view.onCheckIsTextEditor()) {
            view.requestFocus();
            viewFindViewById = view;
        } else {
            viewFindViewById = view.getRootView().findFocus();
        }
        if (viewFindViewById == null) {
            viewFindViewById = view.getRootView().findViewById(R.id.content);
        }
        if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
            return;
        }
        viewFindViewById.post(new ActivityCompat$$ExternalSyntheticLambda0(1, viewFindViewById));
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 6:
                return ((SortedSet) this.imageLoader).toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ MemoryCacheService(int i, boolean z) {
        this.$r8$classId = i;
    }

    public /* synthetic */ MemoryCacheService(zay zayVar, ApiFeatureRequest apiFeatureRequest) {
        this.$r8$classId = 28;
        this.imageLoader = apiFeatureRequest;
    }

    public MemoryCacheService(RealImageLoader realImageLoader, RequestService requestService) {
        this.$r8$classId = 0;
        this.imageLoader = realImageLoader;
    }

    public MemoryCacheService(final TextView textView) {
        this.$r8$classId = 15;
        this.imageLoader = new zzas(textView) { // from class: androidx.emoji2.viewsintegration.EmojiTextViewHelper$SkippingHelper19
            public final EmojiTextViewHelper$HelperInternal19 mHelperDelegate;

            {
                this.mHelperDelegate = new EmojiTextViewHelper$HelperInternal19(textView);
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzas
            public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
                return !EmojiCompat.isConfigured() ? inputFilterArr : this.mHelperDelegate.getFilters(inputFilterArr);
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzas
            public final boolean isEnabled() {
                return this.mHelperDelegate.mEnabled;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzas
            public final void setAllCaps(boolean z) {
                if (EmojiCompat.isConfigured()) {
                    this.mHelperDelegate.setAllCaps(z);
                }
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzas
            public final void setEnabled(boolean z) {
                boolean zIsConfigured = EmojiCompat.isConfigured();
                EmojiTextViewHelper$HelperInternal19 emojiTextViewHelper$HelperInternal19 = this.mHelperDelegate;
                if (zIsConfigured) {
                    emojiTextViewHelper$HelperInternal19.setEnabled(z);
                } else {
                    emojiTextViewHelper$HelperInternal19.mEnabled = z;
                }
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzas
            public final TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
                return !EmojiCompat.isConfigured() ? transformationMethod : this.mHelperDelegate.wrapTransformationMethod(transformationMethod);
            }
        };
    }

    public MemoryCacheService(long[] jArr) {
        MutableLongList mutableLongList;
        this.$r8$classId = 2;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            mutableLongList = new MutableLongList(jArrCopyOf.length);
            int i = mutableLongList._size;
            if (i >= 0) {
                if (jArrCopyOf.length != 0) {
                    int length = jArrCopyOf.length + i;
                    long[] jArr2 = mutableLongList.content;
                    if (jArr2.length < length) {
                        mutableLongList.content = Arrays.copyOf(jArr2, Math.max(length, (jArr2.length * 3) / 2));
                    }
                    long[] jArr3 = mutableLongList.content;
                    int i2 = mutableLongList._size;
                    if (i != i2) {
                        ArraysKt.copyInto(jArr3, jArr3, jArrCopyOf.length + i, i, i2);
                    }
                    System.arraycopy(jArrCopyOf, 0, jArr3, i, jArrCopyOf.length);
                    mutableLongList._size += jArrCopyOf.length;
                }
            } else {
                RuntimeHelpersKt.throwIndexOutOfBoundsException("");
                throw null;
            }
        } else {
            mutableLongList = new MutableLongList();
        }
        this.imageLoader = mutableLongList;
    }

    public MemoryCacheService(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.$r8$classId = 13;
        if (Build.VERSION.SDK_INT >= 25) {
            this.imageLoader = new InputContentInfoCompat$InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.imageLoader = new MenuHostHelper(uri, clipDescription, uri2, 29);
        }
    }

    public MemoryCacheService(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 6:
                this.imageLoader = new SortedSet(HitTestResultKt.DepthComparator);
                break;
            case 7:
                this.imageLoader = Stack.mutableStateOf$default(Boolean.FALSE);
                break;
            default:
                this.imageLoader = new LongSparseArray((Object) null);
                break;
        }
    }

    public MemoryCacheService(Context context, Uri uri) {
        this.$r8$classId = 10;
        this.imageLoader = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }

    public MemoryCacheService(ClipData clipData, int i) {
        this.$r8$classId = 11;
        this.imageLoader = CanvasCompatS$$ExternalSyntheticApiModelOutline0.m(clipData, i);
    }
}
